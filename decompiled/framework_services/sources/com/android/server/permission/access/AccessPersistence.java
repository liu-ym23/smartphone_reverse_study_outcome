package com.android.server.permission.access;

import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseLongArray;
import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.ISmtResourceControl;
import com.android.server.IoThread;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IntMapExtensionsKt;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntSet;
import com.android.server.permission.access.immutable.MutableIntMap;
import com.android.server.permission.access.util.PermissionApex;
import com.android.server.permission.jarjar.kotlin.Unit;
import com.android.server.permission.jarjar.kotlin.io.CloseableKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Ref$ObjectRef;
import com.android.server.permission.jarjar.kotlin.ranges.RangesKt;
import com.android.server.security.FileIntegrity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: AccessPersistence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessPersistence {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;
    private final SparseLongArray pendingMutationTimesMillis;
    private final MutableIntMap<AccessState> pendingStates;
    private final AccessPolicy policy;
    private final Object scheduleLock;
    private WriteHandler writeHandler;
    private final Object writeLock;

    /* JADX INFO: compiled from: AccessPersistence.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AccessPersistence.kt */
    private final class WriteHandler extends Handler {
        final /* synthetic */ AccessPersistence this$0;

        public WriteHandler(AccessPersistence this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int userId = message.what;
            AccessPersistence.access$writePendingState(this.this$0, userId);
        }
    }

    public AccessPersistence(AccessPolicy policy) {
        this.policy = policy;
        this.scheduleLock = new Object();
        this.pendingMutationTimesMillis = new SparseLongArray();
        this.pendingStates = new MutableIntMap(null, 1, null);
        this.writeLock = new Object();
    }

    public static final /* synthetic */ void access$writePendingState(AccessPersistence $this, int userId) {
        $this.writePendingState(userId);
    }

    public final void initialize() {
        this.writeHandler = new WriteHandler(this, IoThread.getHandler().getLooper());
    }

    public final void read(MutableAccessState state) {
        readSystemState(state);
        IntSet $this$forEachIndexed$iv = state.getExternalState().getUserIds();
        int index$iv = 0;
        int r3 = $this$forEachIndexed$iv.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        int userId = $this$forEachIndexed$iv.elementAt(index$iv);
        readUserState(state, userId);
        index$iv = index$iv + 1;
        goto L3
    }

    private final void readSystemState(MutableAccessState state) {
        File $this$parse$iv = getSystemFile();
        AtomicFile $this$readWithReserveCopy$iv$iv = new AtomicFile($this$parse$iv);     // Catch: Exception -> L51 FileNotFoundException -> L53
        FileInputStream it$iv = $this$readWithReserveCopy$iv$iv.openRead();     // Catch: Exception -> L11 FileNotFoundException -> L55
        BinaryXmlPullParser $this$parseBinaryXml_u24lambda_u240$iv$iv = new BinaryXmlPullParser();     // Catch: Throwable -> L15
        $this$parseBinaryXml_u24lambda_u240$iv$iv.setInput(it$iv, null);     // Catch: Throwable -> L15
        AccessPolicy $this$readSystemState_u24lambda_u242_u24lambda_u241 = this.policy;     // Catch: Throwable -> L15
        $this$readSystemState_u24lambda_u242_u24lambda_u241.parseSystemState($this$parseBinaryXml_u24lambda_u240$iv$iv, state);     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(it$iv, null);     // Catch: Exception -> L11 FileNotFoundException -> L13
    L31:
        boolean fileExists = true;
    L63:
        if (fileExists == true) goto L85;
        this.policy.migrateSystemState(state);
        write(state.getSystemState(), state, -1);
        return;
    L85:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(it$iv, th);     // Catch: Exception -> L11 FileNotFoundException -> L13
        throw th;     // Catch: Exception -> L11 FileNotFoundException -> L13
    L13:
        e$iv$iv = move-exception;
        throw e$iv$iv;     // Catch: Exception -> L47 FileNotFoundException -> L49
    L55:
        e$iv$iv = move-exception;
        throw e$iv$iv;     // Catch: Exception -> L47 FileNotFoundException -> L49
    L11:
        e$iv$iv = move-exception;
        Slog.wtf("AccessPersistence", "Failed to read " + $this$readWithReserveCopy$iv$iv, e$iv$iv);     // Catch: Exception -> L51 FileNotFoundException -> L53
        File reserveFile$iv$iv = new File($this$readWithReserveCopy$iv$iv.getBaseFile().getParentFile(), $this$readWithReserveCopy$iv$iv.getBaseFile().getName() + ".reservecopy");     // Catch: Exception -> L51 FileNotFoundException -> L53
        goto L61
    L79:
        FileInputStream it$iv2 = new AtomicFile(reserveFile$iv$iv).openRead();     // Catch: Exception -> L42
        BinaryXmlPullParser $this$parseBinaryXml_u24lambda_u240$iv$iv2 = new BinaryXmlPullParser();     // Catch: Throwable -> L36
        $this$parseBinaryXml_u24lambda_u240$iv$iv2.setInput(it$iv2, null);     // Catch: Throwable -> L34
        AccessPolicy $this$readSystemState_u24lambda_u242_u24lambda_u242 = this.policy;     // Catch: Throwable -> L34
        $this$readSystemState_u24lambda_u242_u24lambda_u242.parseSystemState($this$parseBinaryXml_u24lambda_u240$iv$iv2, state);     // Catch: Throwable -> L34
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L34
        CloseableKt.closeFinally(it$iv2, null);     // Catch: Exception -> L32
    L34:
        th = move-exception;
        Throwable r6 = th;
    L76:
        throw r6;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(it$iv2, r6);     // Catch: Exception -> L32
        throw th;     // Catch: Exception -> L32
    L32:
        e2$iv$iv = e;
    L45:
        Slog.e("AccessPersistence", "Failed to read " + reserveFile$iv$iv, e2$iv$iv);     // Catch: Exception -> L47 FileNotFoundException -> L49
        throw e$iv$iv;     // Catch: Exception -> L47 FileNotFoundException -> L49
    L36:
        th = move-exception;
        r6 = th;
    L42:
        e2$iv$iv = e;
    L47:
        e2$iv$iv = e;
    L60:
        throw new IllegalStateException("Failed to read " + $this$parse$iv, e2$iv$iv);
    L51:
        e2$iv$iv = e;
    L61:
        Slog.i(LOG_TAG, $this$parse$iv + " not found");
        fileExists = false;
        goto L63
    }

    private final void readUserState(MutableAccessState state, int userId) {
        File $this$parse$iv = getUserFile(userId);
        AtomicFile $this$readWithReserveCopy$iv$iv = new AtomicFile($this$parse$iv);     // Catch: Exception -> L51 FileNotFoundException -> L53
        FileInputStream it$iv = $this$readWithReserveCopy$iv$iv.openRead();     // Catch: Exception -> L11 FileNotFoundException -> L55
        BinaryXmlPullParser $this$parseBinaryXml_u24lambda_u240$iv$iv = new BinaryXmlPullParser();     // Catch: Throwable -> L15
        $this$parseBinaryXml_u24lambda_u240$iv$iv.setInput(it$iv, null);     // Catch: Throwable -> L15
        AccessPolicy $this$readUserState_u24lambda_u244_u24lambda_u243 = this.policy;     // Catch: Throwable -> L15
        $this$readUserState_u24lambda_u244_u24lambda_u243.parseUserState($this$parseBinaryXml_u24lambda_u240$iv$iv, state, userId);     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(it$iv, null);     // Catch: Exception -> L11 FileNotFoundException -> L13
    L31:
        boolean fileExists = true;
    L63:
        if (fileExists == true) goto L84;
        this.policy.migrateUserState(state, userId);
        Immutable r4 = state.getUserStates().get(userId);
        Intrinsics.checkNotNull(r4);
        write((WritableState) r4, state, userId);
        return;
    L84:
        return;
    L13:
        e$iv$iv = move-exception;
        throw e$iv$iv;     // Catch: Exception -> L47 FileNotFoundException -> L49
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(it$iv, th);     // Catch: Exception -> L11 FileNotFoundException -> L13
        throw th;     // Catch: Exception -> L11 FileNotFoundException -> L13
    L11:
        e$iv$iv = move-exception;
        Slog.wtf("AccessPersistence", "Failed to read " + $this$readWithReserveCopy$iv$iv, e$iv$iv);     // Catch: Exception -> L51 FileNotFoundException -> L53
        File reserveFile$iv$iv = new File($this$readWithReserveCopy$iv$iv.getBaseFile().getParentFile(), $this$readWithReserveCopy$iv$iv.getBaseFile().getName() + ".reservecopy");     // Catch: Exception -> L51 FileNotFoundException -> L53
        goto L61
    L68:
        FileInputStream it$iv2 = new AtomicFile(reserveFile$iv$iv).openRead();     // Catch: Exception -> L42
        BinaryXmlPullParser $this$parseBinaryXml_u24lambda_u240$iv$iv2 = new BinaryXmlPullParser();     // Catch: Throwable -> L36
        $this$parseBinaryXml_u24lambda_u240$iv$iv2.setInput(it$iv2, null);     // Catch: Throwable -> L34
        AccessPolicy $this$readUserState_u24lambda_u244_u24lambda_u244 = this.policy;     // Catch: Throwable -> L34
        $this$readUserState_u24lambda_u244_u24lambda_u244.parseUserState($this$parseBinaryXml_u24lambda_u240$iv$iv2, state, userId);     // Catch: Throwable -> L34
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L34
        CloseableKt.closeFinally(it$iv2, null);     // Catch: Exception -> L32
    L34:
        th = move-exception;
        Throwable r6 = th;
    L66:
        throw r6;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(it$iv2, r6);     // Catch: Exception -> L32
        throw th;     // Catch: Exception -> L32
    L32:
        e2$iv$iv = e;
    L45:
        Slog.e("AccessPersistence", "Failed to read " + reserveFile$iv$iv, e2$iv$iv);     // Catch: Exception -> L47 FileNotFoundException -> L49
        throw e$iv$iv;     // Catch: Exception -> L47 FileNotFoundException -> L49
    L36:
        th = move-exception;
        r6 = th;
    L42:
        e2$iv$iv = e;
    L55:
        e$iv$iv = move-exception;
        throw e$iv$iv;     // Catch: Exception -> L47 FileNotFoundException -> L49
    L47:
        e2$iv$iv = e;
    L60:
        throw new IllegalStateException("Failed to read " + $this$parse$iv, e2$iv$iv);
    L51:
        e2$iv$iv = e;
    L61:
        Slog.i(LOG_TAG, $this$parse$iv + " not found");
        fileExists = false;
        goto L63
    }

    public final void write(AccessState state) {
        write(state.getSystemState(), state, -1);
        IntReferenceMap<UserState, MutableUserState> r0 = state.getUserStates();
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        int userId = r0.keyAt(index$iv);
        UserState userState = (UserState) r0.valueAt(index$iv);
        write(userState, state, userId);
        index$iv = index$iv + 1;
        goto L3
    }

    private final void write(WritableState $this$write, AccessState state, int userId) {
        int writeMode = $this$write.getWriteMode();
        switch(writeMode) {
            case 0: goto L42;
            case 1: goto L15;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        Object r5 = this.scheduleLock;
        monitor-enter(r5);
        IntMapExtensionsKt.set(this.pendingStates, userId, state);     // Catch: Throwable -> L12
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r5);
        writePendingState(userId);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        Object r6 = this.scheduleLock;
        monitor-enter(r6);
        WriteHandler r7 = this.writeHandler;     // Catch: Throwable -> L21
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("writeHandler");     // Catch: Throwable -> L21
        r7 = null;
    L23:
        r7.removeMessages(userId);     // Catch: Throwable -> L21
        IntMapExtensionsKt.set(this.pendingStates, userId, state);     // Catch: Throwable -> L21
        long currentTimeMillis = SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        SparseLongArray $this$getOrPut$iv = this.pendingMutationTimesMillis;     // Catch: Throwable -> L21
        int index$iv = $this$getOrPut$iv.indexOfKey(userId);     // Catch: Throwable -> L21
        if (index$iv < 0) goto L26;
        long pendingMutationTimeMillis = $this$getOrPut$iv.valueAt(index$iv);     // Catch: Throwable -> L21
    L27:
        long currentDelayMillis = currentTimeMillis - pendingMutationTimeMillis;     // Catch: Throwable -> L21
        WriteHandler r8 = this.writeHandler;     // Catch: Throwable -> L21
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("writeHandler");     // Catch: Throwable -> L21
        r8 = null;
    L30:
        Message message = r8.obtainMessage(userId);     // Catch: Throwable -> L21
        if (currentDelayMillis <= ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME) goto L33;
        message.sendToTarget();     // Catch: Throwable -> L21
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L38:
        monitor-exit(r6);
        return;
    L33:
        long newDelayMillis = RangesKt.coerceAtMost(1000, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME - currentDelayMillis);     // Catch: Throwable -> L21
        WriteHandler r10 = this.writeHandler;     // Catch: Throwable -> L21
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("writeHandler");     // Catch: Throwable -> L21
        r10 = null;
    L36:
        Boolean.valueOf(r10.sendMessageDelayed(message, newDelayMillis));     // Catch: Throwable -> L21
        goto L38
    L26:
        $this$getOrPut$iv.put(userId, currentTimeMillis);     // Catch: Throwable -> L21
        pendingMutationTimeMillis = currentTimeMillis;
    L21:
        th = move-exception;
        throw th;
    L42:
        return;
    L5:
        throw new IllegalStateException(Integer.valueOf(writeMode).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Object] */
    private final void writePendingState(int userId) {
        Object r0 = this.writeLock;
        monitor-enter(r0);
        Ref$ObjectRef state = new Ref$ObjectRef();     // Catch: Throwable -> L22
        Object r3 = this.scheduleLock;     // Catch: Throwable -> L22
        monitor-enter(r3);     // Catch: Throwable -> L22
        SparseLongArray $this$minusAssign$iv = this.pendingMutationTimesMillis;     // Catch: Throwable -> L11
        $this$minusAssign$iv.delete(userId);     // Catch: Throwable -> L11
        state.element = this.pendingStates.remove(userId);     // Catch: Throwable -> L11
        WriteHandler r5 = this.writeHandler;     // Catch: Throwable -> L11
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("writeHandler");     // Catch: Throwable -> L11
        r5 = null;
    L13:
        r5.removeMessages(userId);     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L22
        if (state.element != 0) goto L20;
        monitor-exit(r0);
        return;
    L20:
        if (userId != (-1)) goto L24;
        writeSystemState((AccessState) state.element);     // Catch: Throwable -> L22
    L25:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return;
    L24:
        writeUserState((AccessState) state.element, userId);     // Catch: Throwable -> L22
        goto L25
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private final void writeSystemState(AccessState state) {
        File $this$serialize$iv = getSystemFile();
        AtomicFile $this$writeWithReserveCopy$iv$iv = new AtomicFile($this$serialize$iv);     // Catch: Exception -> L62
        FileOutputStream it$iv$iv$iv = $this$writeWithReserveCopy$iv$iv.startWrite();     // Catch: Exception -> L62
        BinaryXmlSerializer $this$serializeBinaryXml_u24lambda_u240$iv$iv = new BinaryXmlSerializer();     // Catch: Throwable -> L53
        $this$serializeBinaryXml_u24lambda_u240$iv$iv.setOutput(it$iv$iv$iv, null);     // Catch: Throwable -> L53
        $this$serializeBinaryXml_u24lambda_u240$iv$iv.startDocument(null, true);     // Catch: Throwable -> L51
        AccessPolicy $this$writeSystemState_u24lambda_u2413_u24lambda_u2412 = this.policy;     // Catch: Throwable -> L51
        $this$writeSystemState_u24lambda_u2413_u24lambda_u2412.serializeSystemState($this$serializeBinaryXml_u24lambda_u240$iv$iv, state);     // Catch: Throwable -> L49
        $this$serializeBinaryXml_u24lambda_u240$iv$iv.endDocument();     // Catch: Throwable -> L49
        $this$writeWithReserveCopy$iv$iv.finishWrite(it$iv$iv$iv);     // Catch: Throwable -> L49
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L47
        CloseableKt.closeFinally(it$iv$iv$iv, null);     // Catch: Exception -> L45
        File reserveFile$iv$iv = new File($this$writeWithReserveCopy$iv$iv.getBaseFile().getParentFile(), $this$writeWithReserveCopy$iv$iv.getBaseFile().getName() + ".reservecopy");     // Catch: Exception -> L45
        reserveFile$iv$iv.delete();     // Catch: Exception -> L45
        FileInputStream inputStream$iv$iv = new FileInputStream($this$writeWithReserveCopy$iv$iv.getBaseFile());     // Catch: Exception -> L22
        FileOutputStream outputStream$iv$iv = new FileOutputStream(reserveFile$iv$iv);     // Catch: Throwable -> L24
        FileUtils.copy(inputStream$iv$iv, outputStream$iv$iv);     // Catch: Throwable -> L26
        outputStream$iv$iv.getFD().sync();     // Catch: Throwable -> L26
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L19:
        CloseableKt.closeFinally(outputStream$iv$iv, null);     // Catch: Throwable -> L24
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L24
        CloseableKt.closeFinally(inputStream$iv$iv, null);     // Catch: Exception -> L22
    L79:
        FileIntegrity.setUpFsVerity($this$writeWithReserveCopy$iv$iv.getBaseFile());     // Catch: Exception -> L42
        FileIntegrity.setUpFsVerity(reserveFile$iv$iv);     // Catch: Exception -> L42
    L89:
        return;
    L42:
        e$iv$iv = move-exception;
        Slog.e("AccessPersistence", "Failed to verity-protect runtime-permissions", e$iv$iv);     // Catch: Exception -> L45
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(outputStream$iv$iv, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(inputStream$iv$iv, th);     // Catch: Exception -> L22
        throw th;     // Catch: Exception -> L22
    L22:
        e$iv$iv = move-exception;
        Slog.e("AccessPersistence", "Failed to write " + reserveFile$iv$iv, e$iv$iv);     // Catch: Exception -> L45
    L49:
        t$iv$iv$iv = th;
    L55:
        $this$writeWithReserveCopy$iv$iv.failWrite(it$iv$iv$iv);     // Catch: Throwable -> L47
        throw t$iv$iv$iv;     // Catch: Throwable -> L47
    L51:
        t$iv$iv$iv = th;
    L53:
        t$iv$iv$iv = th;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        CloseableKt.closeFinally(it$iv$iv$iv, th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        e$iv = e;
    L64:
        Slog.e(LOG_TAG, "Failed to serialize " + $this$serialize$iv, e$iv);
        return;
    L62:
        e$iv = e;
        goto L64
    }

    private final void writeUserState(AccessState state, int userId) {
        File $this$serialize$iv = getUserFile(userId);
        AtomicFile $this$writeWithReserveCopy$iv$iv = new AtomicFile($this$serialize$iv);     // Catch: Exception -> L66
        FileOutputStream it$iv$iv$iv = $this$writeWithReserveCopy$iv$iv.startWrite();     // Catch: Exception -> L66
        BinaryXmlSerializer $this$serializeBinaryXml_u24lambda_u240$iv$iv = new BinaryXmlSerializer();     // Catch: Throwable -> L57
        $this$serializeBinaryXml_u24lambda_u240$iv$iv.setOutput(it$iv$iv$iv, null);     // Catch: Throwable -> L55
        $this$serializeBinaryXml_u24lambda_u240$iv$iv.startDocument(null, true);     // Catch: Throwable -> L53
        AccessPolicy $this$writeUserState_u24lambda_u2415_u24lambda_u2414 = this.policy;     // Catch: Throwable -> L53
        $this$writeUserState_u24lambda_u2415_u24lambda_u2414.serializeUserState($this$serializeBinaryXml_u24lambda_u240$iv$iv, state, userId);     // Catch: Throwable -> L51
        $this$serializeBinaryXml_u24lambda_u240$iv$iv.endDocument();     // Catch: Throwable -> L51
        $this$writeWithReserveCopy$iv$iv.finishWrite(it$iv$iv$iv);     // Catch: Throwable -> L51
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L49
        CloseableKt.closeFinally(it$iv$iv$iv, null);     // Catch: Exception -> L47
        File reserveFile$iv$iv = new File($this$writeWithReserveCopy$iv$iv.getBaseFile().getParentFile(), $this$writeWithReserveCopy$iv$iv.getBaseFile().getName() + ".reservecopy");     // Catch: Exception -> L47
        reserveFile$iv$iv.delete();     // Catch: Exception -> L47
        FileInputStream inputStream$iv$iv = new FileInputStream($this$writeWithReserveCopy$iv$iv.getBaseFile());     // Catch: Exception -> L24
        FileOutputStream outputStream$iv$iv = new FileOutputStream(reserveFile$iv$iv);     // Catch: Throwable -> L26
        FileUtils.copy(inputStream$iv$iv, outputStream$iv$iv);     // Catch: Throwable -> L28
        outputStream$iv$iv.getFD().sync();     // Catch: Throwable -> L28
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L21:
        CloseableKt.closeFinally(outputStream$iv$iv, null);     // Catch: Throwable -> L26
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(inputStream$iv$iv, null);     // Catch: Exception -> L24
    L77:
        FileIntegrity.setUpFsVerity($this$writeWithReserveCopy$iv$iv.getBaseFile());     // Catch: Exception -> L44
        FileIntegrity.setUpFsVerity(reserveFile$iv$iv);     // Catch: Exception -> L44
    L95:
        return;
    L44:
        e$iv$iv = move-exception;
        Slog.e("AccessPersistence", "Failed to verity-protect runtime-permissions", e$iv$iv);     // Catch: Exception -> L47
        return;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(outputStream$iv$iv, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(inputStream$iv$iv, th);     // Catch: Exception -> L24
        throw th;     // Catch: Exception -> L24
    L24:
        e$iv$iv = move-exception;
        Slog.e("AccessPersistence", "Failed to write " + reserveFile$iv$iv, e$iv$iv);     // Catch: Exception -> L47
    L51:
        t$iv$iv$iv = th;
    L59:
        $this$writeWithReserveCopy$iv$iv.failWrite(it$iv$iv$iv);     // Catch: Throwable -> L49
        throw t$iv$iv$iv;     // Catch: Throwable -> L49
    L53:
        t$iv$iv$iv = th;
    L55:
        t$iv$iv$iv = th;
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        CloseableKt.closeFinally(it$iv$iv$iv, th);     // Catch: Exception -> L47
        throw th;     // Catch: Exception -> L47
    L57:
        t$iv$iv$iv = th;
    L47:
        e$iv = e;
    L68:
        Slog.e(LOG_TAG, "Failed to serialize " + $this$serialize$iv, e$iv);
        return;
    L66:
        e$iv = e;
        goto L68
    }

    private final File getSystemFile() {
        return new File(PermissionApex.INSTANCE.getSystemDataDirectory(), "access.abx");
    }

    private final File getUserFile(int userId) {
        return new File(PermissionApex.INSTANCE.getUserDataDirectory(userId), "access.abx");
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AccessPersistence.class.getSimpleName();
    }
}
