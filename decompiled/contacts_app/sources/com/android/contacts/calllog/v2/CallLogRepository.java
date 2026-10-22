package com.android.contacts.calllog.v2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.CallLog;
import android.provider.Settings;
import com.GlobalProxyLancet;
import com.android.contacts.DSUtils;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.numberassistant.NumberInfosManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CallLogRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0010\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00130\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u001e\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170!0 2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170!2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006*"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentResolver", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "grouper", "Lcom/android/contacts/calllog/v2/CallLogGrouper;", "suppressObserverForSelfWrite", "", "getSuppressObserverForSelfWrite", "()Z", "setSuppressObserverForSelfWrite", "(Z)V", "buildSelection", "Lkotlin/Pair;", "", "", "contactNumber", "showAll", "cursorToItem", "Lcom/android/contacts/calllog/v2/CallLogItem;", "cursor", "Landroid/database/Cursor;", "deleteCallLogs", "ids", "", "", "isShowAllCallLogsEnabled", "observeCallLogs", "Lkotlinx/coroutines/flow/Flow;", "", "parseCursor", "queryCallLogsOnce", "queryCallLogsOnce$app_QssiCnRelease", "resolveSimSlot", "", "withCallTypeLimitSelection", CallLogListAdapter.PAYLOAD_SELECTION, "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogRepository {
    private static final int CACHED_PHOTO_URI_INDEX = 23;
    public static final Companion Companion = null;
    private static final long FUTURE_SECTION_TIME_WINDOW = 0;
    private static final long NEW_SECTION_TIME_WINDOW = 0;
    private static final String SHOW_ALL_CALL_LOGS = "show_all_call_logs";
    private static final String TAG = "CallLogV2";
    private final ContentResolver contentResolver;
    private final Context context;
    private final CallLogGrouper grouper;
    private volatile boolean suppressObserverForSelfWrite;

    /* JADX INFO: compiled from: CallLogRepository.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogRepository$Companion;", "", "()V", "CACHED_PHOTO_URI_INDEX", "", "FUTURE_SECTION_TIME_WINDOW", "", "NEW_SECTION_TIME_WINDOW", "SHOW_ALL_CALL_LOGS", "", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogRepository$observeCallLogs$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogRepository$observeCallLogs$1", f = "CallLogRepository.kt", i = {0, 0, 0}, l = {82, 83}, m = "invokeSuspend", n = {"$this$callbackFlow", "callLogObserver", "showAllCallLogsObserver"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ CallLogRepository this$0;

        AnonymousClass1(CallLogRepository r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L18:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CallLogRepository$observeCallLogs$1$showAllCallLogsObserver$1 r2 = (CallLogRepository$observeCallLogs$1$showAllCallLogsObserver$1) this.L$2;
            CallLogRepository$observeCallLogs$1$callLogObserver$1 r3 = (CallLogRepository$observeCallLogs$1$callLogObserver$1) this.L$1;
            final ProducerScope r4 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            final CallLogRepository$observeCallLogs$1$showAllCallLogsObserver$1 r5 = r2;
            final CallLogRepository$observeCallLogs$1$callLogObserver$1 r6 = r3;
        L14:
            final CallLogRepository r7 = this.this$0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (ProduceKt.awaitClose(r4, new C00191(r7, r6, r5), this) != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r10);
            r4 = (ProducerScope) this.L$0;
            final Handler r11 = new Handler(Looper.getMainLooper());
            final CallLogRepository r8 = this.this$0;
            ContentObserver r9 = new CallLogRepository$observeCallLogs$1$callLogObserver$1(r8, r4, r11);
            final Handler r12 = new Handler(Looper.getMainLooper());
            ContentObserver r13 = new CallLogRepository$observeCallLogs$1$showAllCallLogsObserver$1(r4, r12);
            CallLogRepository.access$getContentResolver$p(this.this$0).registerContentObserver(CallLog.Calls.CONTENT_URI, true, r9);
            CallLogRepository.access$getContentResolver$p(this.this$0).registerContentObserver(Settings.Global.getUriFor("show_all_call_logs"), false, r13);
            this.L$0 = r4;
            this.L$1 = r9;
            this.L$2 = r13;
            this.label = 1;
            if (r4.send(Unit.INSTANCE, this) != r0) goto L13;
            return r0;
        L13:
            r6 = r9;
            r5 = r13;
            goto L14
        }
    }

    public CallLogRepository(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Context r3 = r2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");
        this.context = r3;
        this.contentResolver = r3.getContentResolver();
        this.grouper = new CallLogGrouper();
    }

    public static final /* synthetic */ ContentResolver access$getContentResolver$p(CallLogRepository r0) {
        return r0.contentResolver;
    }

    public final boolean getSuppressObserverForSelfWrite() {
        return this.suppressObserverForSelfWrite;
    }

    public final void setSuppressObserverForSelfWrite(boolean r1) {
        this.suppressObserverForSelfWrite = r1;
    }

    public static /* synthetic */ Flow observeCallLogs$default(CallLogRepository r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.observeCallLogs(r1);
    }

    public final Flow<List<CallLogItem>> observeCallLogs(final String r4) {
        final Flow r0 = FlowKt.debounce(FlowKt.callbackFlow(new AnonymousClass1(this, null)), 300);
        return FlowKt.flowOn(new CallLogRepository$observeCallLogs$$inlined$map$1(r0, this, r4), Dispatchers.getIO());
    }

    public final List<CallLogItem> queryCallLogsOnce$app_QssiCnRelease(String r13) {
        long r1 = SystemClock.elapsedRealtime();
        boolean r3 = isShowAllCallLogsEnabled();
        Pair<String, String[]> r4 = buildSelection(r13, r3);
        Cursor r5 = this.contentResolver.query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery.PROJECTION_N, r4.component1(), r4.component2(), "date DESC");     // Catch: SecurityException -> L18 IllegalArgumentException -> L20 SQLiteDatabaseCorruptException -> L22 SQLiteFullException -> L24 SQLiteDiskIOException -> L26
        if (r5 == null) goto L16;
        Cursor r6 = r5;     // Catch: SecurityException -> L18 IllegalArgumentException -> L20 SQLiteDatabaseCorruptException -> L22 SQLiteFullException -> L24 SQLiteDiskIOException -> L26
        List<CallLogItem> r7 = parseCursor(r6);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r6, null);     // Catch: SecurityException -> L18 IllegalArgumentException -> L20 SQLiteDatabaseCorruptException -> L22 SQLiteFullException -> L24 SQLiteDiskIOException -> L26
        if (r7 == null) goto L16;
    L28:
        List<CallLogItem> r12 = this.grouper.group(r7);
        long r8 = SystemClock.elapsedRealtime() - r1;
        StringBuilder r2 = new StringBuilder("queryCallLogs done, showAll=").append(r3).append(", singleContact=");
        String r14 = r13;
        if (r14 != null) goto L31;
    L34:
        boolean r15 = true;
    L35:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r2.append(!r15).append(", count=").append(r12.size()).append(", raw=").append(r7.size()).append(", cost=").append(r8).append("ms").toString());
        return r12;
    L31:
        if (r14.length() == 0) goto L34;
        r15 = false;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: SecurityException -> L18 IllegalArgumentException -> L20 SQLiteDatabaseCorruptException -> L22 SQLiteFullException -> L24 SQLiteDiskIOException -> L26
        throw th;     // Catch: SecurityException -> L18 IllegalArgumentException -> L20 SQLiteDatabaseCorruptException -> L22 SQLiteFullException -> L24 SQLiteDiskIOException -> L26
    L16:
        r7 = CollectionsKt.emptyList();     // Catch: SecurityException -> L18 IllegalArgumentException -> L20 SQLiteDatabaseCorruptException -> L22 SQLiteFullException -> L24 SQLiteDiskIOException -> L26
    L22:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "queryCallLogs: SQLite corrupt", e);
        r7 = CollectionsKt.emptyList();
    L26:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "queryCallLogs: SQLite disk IO error", e);
        r7 = CollectionsKt.emptyList();
    L24:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "queryCallLogs: SQLite full", e);
        r7 = CollectionsKt.emptyList();
    L20:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "queryCallLogs: illegal argument", e);
        r7 = CollectionsKt.emptyList();
    L18:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "queryCallLogs: security exception", e);
        r7 = CollectionsKt.emptyList();
        goto L28
    }

    public final boolean deleteCallLogs(Set<Long> r12) {
        Intrinsics.checkNotNullParameter(r12, "ids");
        if (r12.isEmpty() == false) goto L5;
        return true;
    L5:
        Set<Long> r0 = r12;
        String r2 = "_id IN (" + CollectionsKt.joinToString$default(r0, SimContactsConstants.EMAIL_SEP, null, null, 0, null, CallLogRepository$deleteCallLogs$placeholders$1.INSTANCE, 30, null) + ')';
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r3.add(String.valueOf(((Number) r1.next()).longValue()));
        goto L7
    L9:
        int r11 = this.contentResolver.delete(CallLog.Calls.CONTENT_URI, r2, (String[]) r3.toArray(new String[0]));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "deleteCallLogs: requested=" + r12.size() + ", deleted=" + r11);
        if (r11 != r12.size()) goto L13;
        return true;
    L13:
        return false;
    }

    private final boolean isShowAllCallLogsEnabled() {
        if (Settings.Global.getInt(this.contentResolver, "show_all_call_logs", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    private final Pair<String, String[]> buildSelection(String r7, boolean r8) {
        ArrayList r0 = new ArrayList();
        String[] r1 = null;
        if (r8 == true) goto L5;
        r0.add(String.valueOf(System.currentTimeMillis() - NEW_SECTION_TIME_WINDOW));
        r0.add(String.valueOf(System.currentTimeMillis() + FUTURE_SECTION_TIME_WINDOW));
        String r9 = "date > ? AND date < ?";
    L6:
        String r2 = r7;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L18;
        if (r9 != null) goto L16;
        r9 = "number = ?";
    L17:
        r0.add(r7);
        goto L18
    L16:
        r9 = "(" + r9 + ") AND (number = ?)";
    L18:
        String r6 = withCallTypeLimitSelection(r9);
        if (r0.isEmpty() == true) goto L23;
        r1 = (String[]) r0.toArray(new String[0]);
    L23:
        return new Pair(r6, r1);
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    private final String withCallTypeLimitSelection(String r1) {
        if (r1 != null) goto L5;
        return "type IN (1,7,2,3,5,4)";
    L5:
        return r1 + " AND type IN (1,7,2,3,5,4)";
    }

    private final List<CallLogItem> parseCursor(Cursor r3) {
        ArrayList r0 = new ArrayList();
    L4:
        if (r3.moveToNext() == false) goto L6;
        r0.add(cursorToItem(r3));
        goto L4
    L6:
        return r0;
    }

    private final CallLogItem cursorToItem(Cursor r35) {
        long r3 = r35.getLong(0);
        String r5 = r35.getString(1);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        long r10 = r35.getLong(2);
        long r12 = r35.getLong(3);
        int r9 = r35.getInt(4);
        String r23 = r35.getString(5);
        String r25 = r35.getString(7);
        String r7 = r35.getString(8);
        int r21 = r35.getInt(9);
        String r20 = r35.getString(10);
        String r6 = r35.getString(11);
        String r8 = r35.getString(15);
        int r22 = r35.getInt(17);
        String r14 = r35.getString(23);
        if (r35.getInt(29) != 1) goto L8;
        boolean r29 = true;
    L10:
        if (CallLogQuery.FEATURES == (-1)) goto L12;
        int r30 = r35.getInt(CallLogQuery.FEATURES);
    L13:
        String r26 = r35.getString(30);
        if (r35.getInt(27) != 1) goto L16;
        boolean r28 = true;
    L17:
        int r1 = resolveSimSlot(r35);
        int r15 = CallLogQuery.getSubscription(r35);
        String r19 = r35.getString(28);
        String r0 = r35.getString(6);
        String r2 = r14;
        if (r2 != null) goto L20;
    L23:
        boolean r4 = true;
    L25:
        if (r4 == false) goto L27;
        Uri r16 = null;
    L28:
        List r24 = CollectionsKt.listOf(Long.valueOf(r3));
        String r11 = r6;
        if (r11 != null) goto L31;
    L34:
        boolean r13 = true;
    L35:
        if (r13 == false) goto L37;
        Uri r31 = null;
    L38:
        String r17 = r26;
        if (r17 != null) goto L41;
    L44:
        boolean r18 = true;
    L45:
        boolean r27 = !r18;
        NumberInfosManager r32 = NumberInfosManager.getInstance();
        if (r32 == null) goto L50;
        NumberInfosManager.NumberInfos r33 = r32.getCachedBaseAndMarkInfos(r5);
        if (r33 == null) goto L50;
        boolean r34 = r33.isMarked();
    L52:
        return new CallLogItem(r3, r5, r8, r7, r16, r9, r10, r12, r1, r15, r19, r0, 1, r24, r20, r21, r22, r23, r27, r25, r26, r34, r28, r29, r30, r31);
    L50:
        r34 = false;
        goto L52
    L41:
        if (r17.length() == 0) goto L44;
        r18 = false;
        goto L45
    L37:
        r31 = Uri.parse(r6);
        goto L38
    L31:
        if (r11.length() == 0) goto L34;
        r13 = false;
        goto L35
    L27:
        r16 = Uri.parse(r14);
        goto L28
    L20:
        if (r2.length() == 0) goto L23;
        r4 = false;
        goto L25
    L16:
        r28 = false;
        goto L17
    L12:
        r30 = 0;
        goto L13
    L8:
        r29 = false;
        goto L10
    }

    private final int resolveSimSlot(Cursor r3) {
        int r0 = CallLogQuery.getSubscription(r3);
        if (r0 >= 0) goto L6;
        return -1;
    L6:
        String r4 = r3.getString(28);
        return DSUtils.getSimSlotId(this.context, r0, r4);
    }

    static {
        Companion = new Companion(null);
        NEW_SECTION_TIME_WINDOW = TimeUnit.DAYS.toMillis(30);
        FUTURE_SECTION_TIME_WINDOW = TimeUnit.DAYS.toMillis(1);
    }
}
