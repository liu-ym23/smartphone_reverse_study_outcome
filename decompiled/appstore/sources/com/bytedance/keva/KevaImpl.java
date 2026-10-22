package com.bytedance.keva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
abstract class KevaImpl extends Keva {
    static final Executor sExecutor = null;
    static final KevaMonitor sMonitor = null;
    private static final String sPortedSpRepoName = null;
    private static final HashMap<String, Keva> sRepoMap = null;
    private static final File sSharedPrefsDir = null;
    private final List<Keva.OnChangeListener> mChangeListeners;
    private List<KevaValueWrapper> mDuplicatedOldWrappers;
    volatile long mHandle;
    private final boolean mIsMultiProcess;
    private final int mMode;
    private final String mName;
    final HashMap<String, KevaValueWrapper> mValueMap;

    public static class KevaValueWrapper {
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;

        public KevaValueWrapper() {
        }
    }

    public static class PortedSpRepoHolder {
        private static final KevaImpl sInstance = null;
        private static final Map<String, ?> sPortedSpMap = null;

        static {
            KevaMultiProcessImpl r10 = new KevaMultiProcessImpl(KevaImpl.access$000(), 1);
            sInstance = r10;
            r10.init(true);
            sPortedSpMap = r10.generateOutMap();
        }

        private PortedSpRepoHolder() {
        }

        public static /* synthetic */ KevaImpl access$100() {
            return sInstance;
        }

        public static /* synthetic */ Map access$300() {
            return sPortedSpMap;
        }
    }

    public interface PrivateConstants {
        public static final int BLOCK_TYPE_BYTES = 0;
        public static final int BLOCK_TYPE_OBJECT = 4;
        public static final int BLOCK_TYPE_STRING_ARRAY = 3;
        public static final int BLOCK_TYPE_STRING_UTF16 = 2;
        public static final int BLOCK_TYPE_STRING_UTF8 = 1;
        public static final String EMPTY_STRING = "";
        public static final int EXT_TYPE_BYTES = 7;
        public static final int EXT_TYPE_OBJECT = 71;
        public static final int EXT_TYPE_STRING_ARRAY = 55;
        public static final int EXT_TYPE_STRING_UTF16 = 39;
        public static final int EXT_TYPE_STRING_UTF8 = 23;
        public static final String FILES_DIR_NAME = "files";
        public static final String KEVA = "keva";
        public static final String LIB_NAME = "keva";
        public static final String PORTED_SP = "keva_porting_sp";
        public static final int REPORT_VALUE_SIZE_THRESHOLD = 10000;
        public static final String SP_DIR_NAME = "shared_prefs";
        public static final int TYPE_BOOL = 2;
        public static final int TYPE_BYTES = 7;
        public static final int TYPE_DOUBLE = 5;
        public static final int TYPE_FLOAT = 4;
        public static final int TYPE_INT = 1;
        public static final int TYPE_INVALID = 0;
        public static final int TYPE_LONG = 3;
        public static final int TYPE_STRING = 6;
    }

    static {
        Log.i(KevaConstants.TAG, "Keva version: 1.4.7");
        KevaBuilder r10 = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = new HashMap();
        Executor r11 = r10.mExecutor;
        if (r11 == null) goto L5;
        sExecutor = r11;
    L6:
        String r12 = r10.mPortedRepoName;
        if (r12 != null) goto L10;
        r12 = PrivateConstants.PORTED_SP;
    L10:
        sPortedSpRepoName = r12;
        Context r13 = r10.mContext;
        File r14 = r13.getFilesDir();
        if (r14 != null) goto L14;
        r14 = new File(r13.getApplicationInfo().dataDir, PrivateConstants.FILES_DIR_NAME);
    L14:
        if (r14.exists() == true) goto L16;
        r14.mkdirs();
    L16:
        File r15 = r10.mWorkDir;
        if (r15 != null) goto L19;
        r15 = new File(r14, "keva");
    L19:
        sSharedPrefsDir = new File(r14.getParent(), PrivateConstants.SP_DIR_NAME);
        KevaMonitor r16 = r10.mMonitor;
        if (r16 != null) goto L23;
        r16 = new KevaMonitor();
    L23:
        sMonitor = r16;
        if (r15.exists() == false) goto L26;
    L33:
        r16.loadLibrary("keva");     // Catch: Throwable -> L30
        initialize(r15.getAbsolutePath());     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        KevaMonitor r17 = sMonitor;
        r17.logDebug("fail to load so and init");
        r17.reportThrowable(1, null, null, null, th);
        return;
    L26:
        if (r15.mkdirs() == true) goto L33;
        r16.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + r15.getPath()));
        goto L33
    L5:
        int r18 = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
        ThreadPoolExecutor r19 = new ThreadPoolExecutor(r18, r18, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r19.allowCoreThreadTimeOut(true);
        sExecutor = r19;
        goto L6
    }

    public KevaImpl(String r10, int r11) {
        this.mValueMap = new HashMap();
        this.mChangeListeners = new ArrayList();
        this.mDuplicatedOldWrappers = new ArrayList();
        this.mName = r10;
        this.mMode = r11;
        boolean r12 = true;
        if ((r11 & 1) != 0) goto L6;
        r12 = false;
    L6:
        this.mIsMultiProcess = r12;
    }

    public static /* synthetic */ String access$000() {
        return sPortedSpRepoName;
    }

    public static /* synthetic */ void access$200(KevaImpl r10, Context r11) {
        r10.doPortingFromSp(r11);
    }

    public static /* synthetic */ String access$400(KevaImpl r10) {
        return r10.mName;
    }

    private void addMapObjectWhenLoading(String r10, Object r11, long r12, int r13) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        KevaValueWrapper r14 = new KevaValueWrapper();
        r14.value = r11;
        r14.offset = r12;
        r14.type = r13;
        if (this.mIsMultiProcess == true) goto L8;
        r14.loaded = true;
    L8:
        KevaValueWrapper r15 = this.mValueMap.put(r10, r14);
        if (r15 == null) goto L14;
        List<KevaValueWrapper> r16 = this.mDuplicatedOldWrappers;
        if (r16 == null) goto L15;
        r16.add(r15);
        return;
    L15:
        return;
    }

    public static native void checkReportException(long r10);

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle != 0) goto L15;
        sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
        return;
    L15:
        Iterator<KevaValueWrapper> r10 = this.mDuplicatedOldWrappers.iterator();     // Catch: Throwable -> L9
    L7:
        if (r10.hasNext() == false) goto L11;
        eraseUnusedChunk(this.mHandle, r10.next().offset);     // Catch: Throwable -> L9
        goto L7
    L11:
        this.mDuplicatedOldWrappers = null;     // Catch: Throwable -> L9
        checkReportException(this.mHandle);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private static native void clear(long r10);

    private static native boolean delete(String r10);

    private void doLoadRepo(boolean r10) {
        this.mHandle = loadRepo(this.mName, this.mMode, r10);     // Catch: Throwable -> L6
        cleanUpAfterLoadRepo();     // Catch: Throwable -> L6
        if (r10 == true) goto L11;
        sMonitor.onLoadRepo(this.mName, this.mMode);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private void doPortingFromSp(Context r20) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandle == 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        boolean r10 = this instanceof KevaMultiProcessImpl;     // Catch: Throwable -> L8
        int r11 = -1;
        if (r10 == false) goto L17;
        r11 = protectPortingInterProcess(this.mName, true, -1);     // Catch: Throwable -> L8
        if (isRepoPorted(this.mName) == false) goto L17;
        doLoadRepo(false);     // Catch: Throwable -> L8
        protectPortingInterProcess(this.mName, false, r11);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L17:
        int r13 = r11;
        if (r10 == false) goto L20;
    L22:
        boolean r12 = false;
    L23:
        KevaMonitor r14 = sMonitor;     // Catch: Throwable -> L8
        r14.logDebug("poring load empty repo >> " + this.mName);     // Catch: Throwable -> L8
        doLoadRepo(false);     // Catch: Throwable -> L8
        if (this.mHandle != 0) goto L27;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L27:
        if (r12 == true) goto L29;
        clear();     // Catch: Throwable -> L8
    L29:
        SharedPreferences r15 = r20.getSharedPreferences(this.mName, 0);     // Catch: Throwable -> L8
        r14.logDebug("poring get sp >> " + this.mName);     // Catch: Throwable -> L8
        Map<String, ?> r16 = r15.getAll();     // Catch: Throwable -> L8
        r14.logDebug("poring get all value >> " + this.mName);     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, ?>> r17 = r16.entrySet().iterator();     // Catch: Throwable -> L8
    L31:
        if (r17.hasNext() == false) goto L74;
        Map.Entry<String, ?> r18 = r17.next();     // Catch: Throwable -> L8
        String r19 = r18.getKey();     // Catch: Throwable -> L8
        Object r110 = r18.getValue();     // Catch: Throwable -> L8
        if (r110 == null) goto L31;
        if ("".equals(r19) == false) goto L38;
        r19 = null;
    L38:
        String r21 = r19;
        KevaMonitor r22 = sMonitor;     // Catch: Throwable -> L8
        r22.logDebug("poring process key: " + r21 + ", value: " + r110 + " >> " + this.mName);     // Catch: Throwable -> L8
        KevaValueWrapper r23 = new KevaValueWrapper();     // Catch: Throwable -> L8
        this.mValueMap.put(r21, r23);     // Catch: Throwable -> L8
    L56:
        th = th;
        String r111 = r21;
    L55:
        Throwable r24 = th;
    L72:
        sMonitor.reportThrowable(3, this.mName, r111, r110, r24);     // Catch: Throwable -> L8
        goto L31
    L40:
        if ((r110 instanceof Boolean) == false) goto L46;
        r23.offset = storeBoolean(this.mHandle, r21, r23.offset, ((Boolean) r110).booleanValue());     // Catch: Throwable -> L43
        r23.value = r110;     // Catch: Throwable -> L43
    L42:
        r111 = r21;
    L84:
        if (this.mIsMultiProcess == true) goto L31;
        r23.loaded = true;     // Catch: Throwable -> L54
    L54:
        th = th;
    L43:
        th = move-exception;
        r24 = th;
        r111 = r21;
        goto L72
    L46:
        if ((r110 instanceof Integer) == false) goto L50;
        r23.offset = storeInt(this.mHandle, r21, r23.offset, ((Integer) r110).intValue());     // Catch: Throwable -> L43
        r23.value = r110;     // Catch: Throwable -> L43
        goto L42
    L50:
        if ((r110 instanceof Long) == false) goto L58;
        r111 = r21;
        r23.offset = storeLong(this.mHandle, r21, r23.offset, ((Long) r110).longValue());     // Catch: Throwable -> L54
        r23.value = r110;     // Catch: Throwable -> L54
        goto L84
    L58:
        r111 = r21;
        if ((r110 instanceof Float) == false) goto L62;
        r23.offset = storeFloat(this.mHandle, r111, r23.offset, ((Float) r110).floatValue());     // Catch: Throwable -> L54
        r23.value = r110;     // Catch: Throwable -> L54
        goto L84
    L62:
        if ((r110 instanceof String) == false) goto L65;
        r23.offset = storeString(this.mHandle, r111, r23.offset, (String) r110);     // Catch: Throwable -> L54
        r23.value = r110;     // Catch: Throwable -> L54
        goto L84
    L65:
        if ((r110 instanceof Set) == false) goto L67;
        Set r25 = (Set) r110;     // Catch: Throwable -> L54
        String[] r26 = new String[r25.size()];     // Catch: Throwable -> L54
        r25.toArray(r26);     // Catch: Throwable -> L54
        r23.offset = storeStringArray(this.mHandle, r111, r23.offset, r26, 3);     // Catch: Throwable -> L54
        r23.value = r26;     // Catch: Throwable -> L54
        goto L84
    L67:
        r22.reportThrowable(1, this.mName, r111, r110, new IllegalStateException("do not support type: " + r110.getClass()));     // Catch: Throwable -> L54
        goto L84
    L74:
        getPortedSpRepo().storeBoolean(this.mName, true);     // Catch: Throwable -> L8
        if (r10 == false) goto L77;
        protectPortingInterProcess(this.mName, false, r13);     // Catch: Throwable -> L8
    L77:
        monitor-exit(this);     // Catch: Throwable -> L8
        sMonitor.logDebug("poring set ported repo >> " + this.mName);
        return;
    L20:
        if (delete(this.mName) == false) goto L22;
        r12 = true;
        goto L23
    }

    private native void dump(long r10);

    private native void erase(long r10, String r11, long r12);

    private native void eraseUnusedChunk(long r10, long r11);

    private static boolean existSharedPrefs(String r10) {
        return new File(sSharedPrefsDir, r10 + ".xml").exists();
    }

    private Set<String> fetchStringSet(String r10, Set<String> r11, boolean r12) {
        if (r11 == null) goto L5;
        String[] r13 = (String[]) r11.toArray(new String[0]);
    L6:
        String[] r14 = fetchStringArray(r10, r13, r12);
        if (r14 != null) goto L9;
        return null;
    L9:
        return new HashSet(Arrays.asList(r14));
    L5:
        r13 = null;
        goto L6
    }

    public static void forceInitImpl() {
        Log.println(4, KevaConstants.TAG, "force initializing Keva");
    }

    public static KevaImpl getEmptyRepoImpl(String r10, int r11) {
        if (r11 >= 0) goto L4;
    L5:
        sMonitor.reportThrowable(1, r10, null, null, new IllegalArgumentException("mode is not valid! " + r11));
    L7:
        if ((r11 & 1) != 0) goto L10;
        return new KevaPrivateImpl(r10, r11);
    L10:
        return new KevaMultiProcessImpl(r10, r11);
    L4:
        if (r11 < 2) goto L7;
        goto L5
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.access$100();
    }

    public static Keva getRepo(String r10, int r11) {
        return getRepoImpl(r10, r11, false);
    }

    public static Keva getRepoFromSp(Context r10, String r11, int r12) {
        return getRepoFromSpImpl(r10, r11, r12, false);
    }

    private static Keva getRepoFromSpImpl(final Context r10, final String r11, final int r12, boolean r13) {
        if (isRepoPorted(r11) == true) goto L5;
        boolean r14 = true;
        if (existSharedPrefs(r11) == true) goto L10;
        getPortedSpRepo().storeBoolean(r11, true);
        return getRepo(r11, r12);
    L10:
        sMonitor.logDebug("do poring from sp: " + r11);
        HashMap<String, Keva> r15 = sRepoMap;
        monitor-enter(r15);
        Keva r16 = r15.get(r11);     // Catch: Throwable -> L20
        if (r16 == null) goto L16;
        r14 = false;
    L16:
        if (r14 == false) goto L24;
        if (r13 == false) goto L22;
        Keva r17 = getEmptyRepoImpl(r11, r12);     // Catch: Throwable -> L20
    L19:
        r16 = r17;
        r15.put(r11, r16);     // Catch: Throwable -> L20
        goto L24
    L22:
        r17 = new KevaFuture(r11, r12, new AnonymousClass2(r11, r12, r10));     // Catch: Throwable -> L20
    L24:
        monitor-exit(r15);     // Catch: Throwable -> L20
        if (r14 == false) goto L33;
        if ((r16 instanceof KevaImpl) == true) goto L39;
    L36:
        return r16;
    L39:
        ((KevaImpl) r16).doPortingFromSp(r10);     // Catch: UnsatisfiedLinkError -> L30
    L30:
        e = move-exception;
        sMonitor.reportThrowable(1, r11, null, null, e);
        goto L36
    L33:
        if ((r16 instanceof KevaImpl) == false) goto L35;
        ((KevaImpl) r16).checkMode(r12);
        goto L36
    L35:
        ((KevaFuture) r16).checkMode(r12);
    L20:
        th = move-exception;
        throw th;
    L5:
        return getRepo(r11, r12);
    }

    public static Keva getRepoFromSpSync(Context r10, String r11, int r12) {
        return getRepoFromSpImpl(r10, r11, r12, true);
    }

    private static Keva getRepoImpl(final String r10, final int r11, boolean r12) {
        HashMap<String, Keva> r13 = sRepoMap;
        monitor-enter(r13);
        Keva r14 = r13.get(r10);     // Catch: Throwable -> L12
        if (r14 != null) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L16;
        if (r12 == false) goto L14;
        Keva r16 = getEmptyRepoImpl(r10, r11);     // Catch: Throwable -> L12
    L11:
        r14 = r16;
        r13.put(r10, r14);     // Catch: Throwable -> L12
        goto L16
    L14:
        r16 = new KevaFuture(r10, r11, new AnonymousClass1(r10, r11));     // Catch: Throwable -> L12
    L16:
        monitor-exit(r13);     // Catch: Throwable -> L12
        if (r15 == false) goto L22;
        if ((r14 instanceof KevaFuture) == true) goto L25;
        ((KevaImpl) r14).init(false);
    L25:
        return r14;
    L22:
        if ((r14 instanceof KevaFuture) == true) goto L24;
        ((KevaImpl) r14).checkMode(r11);
        goto L25
    L24:
        ((KevaFuture) r14).checkMode(r11);
        goto L25
    L7:
        r15 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public static Keva getRepoSync(String r10, int r11) {
        return getRepoImpl(r10, r11, true);
    }

    private static native void initialize(String r10);

    public static boolean isRepoPorted(String r10) {
        if (PortedSpRepoHolder.access$300().get(r10) == null) goto L7;
        return true;
    L7:
        return getPortedSpRepo().getBoolean(r10, false);
    }

    private native long loadRepo(String r10, int r11, boolean r12);

    private void notifyChangeListeners(Keva r10, String r11) {
        if (this.mChangeListeners.size() != 0) goto L5;
        return;
    L5:
        Iterator<Keva.OnChangeListener> r12 = this.mChangeListeners.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r12.next().onChanged(r10, r11);
        goto L7
    }

    private KevaValueWrapper obtainWrapperLocked(String r10) {
        KevaValueWrapper r11 = this.mValueMap.get(r10);
        if (r11 != null) goto L6;
        KevaValueWrapper r12 = new KevaValueWrapper();
        this.mValueMap.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    private native int protectPortingInterProcess(String r10, boolean r11, int r12);

    private void reportBigValue(final String r10, final Object r11, final int r12) {
        if (r12 <= 10000) goto L6;
        sExecutor.execute(new AnonymousClass3(this, r10, r11, r12));
        return;
    }

    private native long storeBoolean(long r10, String r11, long r12, boolean r13);

    private native long storeBytes(long r10, String r11, long r12, byte[] r13, int r14);

    private void storeBytes(final String r11, byte[] r12, int r13, boolean r14) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r10 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r10.offset = storeBytes(this.mHandle, r11, r10.offset, r12, r13);     // Catch: Throwable -> L12
        r10.type = (r13 << 4) | 7;     // Catch: Throwable -> L12
        if (r14 == true) goto L14;
        r10.value = r12;     // Catch: Throwable -> L12
        if (this.mIsMultiProcess == true) goto L15;
        r10.loaded = true;     // Catch: Throwable -> L12
    L15:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L12
    L18:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r12 == null) goto L31;
        final int r15 = r12.length;
        if (r15 <= 10000) goto L32;
        sExecutor.execute(new AnonymousClass5(this, r11, r15));
        return;
    L32:
        return;
    L31:
        return;
    L14:
        r10.value = null;     // Catch: Throwable -> L12
        r10.loaded = false;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, r12, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private native long storeDouble(long r10, String r11, long r12, double r13);

    private native long storeFloat(long r10, String r11, long r12, float r13);

    private native long storeInt(long r10, String r11, long r12, int r13);

    private native long storeLong(long r10, String r11, long r12, long r13);

    private native long storeString(long r10, String r11, long r12, String r13);

    private void storeString(final String r10, final String r11, boolean r12) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r13 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L37:
        r13.offset = storeString(this.mHandle, r10, r13.offset, r11);     // Catch: Throwable -> L23
        r13.type = 6;     // Catch: Throwable -> L23
        if (r12 == true) goto L25;
        r13.value = r11;     // Catch: Throwable -> L23
        if (this.mIsMultiProcess == true) goto L26;
        r13.loaded = true;     // Catch: Throwable -> L23
    L26:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L23
    L29:
        monitor-exit(this);     // Catch: Throwable -> L16
        if (r11 == null) goto L40;
        final int r14 = r11.length();
        if (r14 <= 10000) goto L41;
        sExecutor.execute(new AnonymousClass4(this, r10, r11, r14));
        return;
    L41:
        return;
    L40:
        return;
    L25:
        r13.value = null;     // Catch: Throwable -> L23
        r13.loaded = false;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, r11, th);     // Catch: Throwable -> L16
        goto L29
    L9:
        if (r13.loaded == false) goto L37;
        if (r13.value == null) goto L37;
        if (r13.value.equals(r11) == false) goto L37;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private native long storeStringArray(long r10, String r11, long r12, String[] r13, int r14);

    private void storeStringArray(final String r11, String[] r12, boolean r13) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r10 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r10.offset = storeStringArray(this.mHandle, r11, r10.offset, r12, 3);     // Catch: Throwable -> L12
        r10.type = 55;     // Catch: Throwable -> L12
        if (r13 == true) goto L14;
        r10.value = r12;     // Catch: Throwable -> L12
        if (this.mIsMultiProcess == true) goto L15;
        r10.loaded = true;     // Catch: Throwable -> L12
    L15:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L12
    L18:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r12 == null) goto L31;
        final String r14 = Arrays.toString(r12);
        final int r15 = r14.length();
        if (r15 <= 10000) goto L32;
        sExecutor.execute(new AnonymousClass6(this, r11, r14, r15));
        return;
    L32:
        return;
    L31:
        return;
    L14:
        r10.value = null;     // Catch: Throwable -> L12
        r10.loaded = false;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, null, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private void storeStringSet(String r10, Set<String> r11, boolean r12) {
        if (r11 == null) goto L4;
        String[] r13 = new String[r11.size()];
        r11.toArray(r13);
    L5:
        storeStringArray(r10, r13, r12);
        return;
    L4:
        r13 = null;
        goto L5
    }

    public void addMapBoolWhenLoading(String r10, boolean r11, long r12) {
        addMapObjectWhenLoading(r10, Boolean.valueOf(r11), r12, 2);
    }

    public void addMapDoubleWhenLoading(String r10, double r11, long r12) {
        addMapObjectWhenLoading(r10, Double.valueOf(r11), r12, 5);
    }

    public void addMapFloatWhenLoading(String r10, float r11, long r12) {
        addMapObjectWhenLoading(r10, Float.valueOf(r11), r12, 4);
    }

    public void addMapIntWhenLoading(String r10, int r11, long r12) {
        addMapObjectWhenLoading(r10, Integer.valueOf(r11), r12, 1);
    }

    public void addMapLongWhenLoading(String r10, long r11, long r12) {
        addMapObjectWhenLoading(r10, Long.valueOf(r11), r12, 3);
    }

    public void addMapOffsetWhenLoading(String r10, long r11, int r12) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        KevaValueWrapper r13 = new KevaValueWrapper();
        r13.offset = r11;
        r13.type = r12;
        KevaValueWrapper r14 = this.mValueMap.put(r10, r13);
        if (r14 == null) goto L11;
        List<KevaValueWrapper> r15 = this.mDuplicatedOldWrappers;
        if (r15 == null) goto L12;
        r15.add(r14);
        return;
    L12:
        return;
    }

    public void checkMode(int r10) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (this.mMode == r10) goto L9;
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + r10));
        return;
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L5
        clear(this.mHandle);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L5:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, null, null, th);     // Catch: Throwable -> L10
        goto L8
    }

    public native boolean contains(long r10, String r11, long r12);

    @Override // com.bytedance.keva.Keva
    public void dump() {
        monitor-enter(this);
        sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L7
        Iterator<Map.Entry<String, KevaValueWrapper>> r10 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L7
    L5:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<String, KevaValueWrapper> r11 = r10.next();     // Catch: Throwable -> L7
        KevaValueWrapper r12 = r11.getValue();     // Catch: Throwable -> L7
        String r13 = r11.getKey();     // Catch: Throwable -> L7
        sMonitor.logDebug("key: " + r13 + ", value: " + r12.value + ", offset: " + r12.offset + ", loaded: " + r12.loaded);     // Catch: Throwable -> L7
        goto L5
    L9:
        sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dumpNative() {
        monitor-enter(this);
        dump(this.mHandle);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r10) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r11 = obtainWrapperLocked(r10);     // Catch: Throwable -> L10
        erase(this.mHandle, r10, r11.offset);     // Catch: Throwable -> L10
        r11.value = null;     // Catch: Throwable -> L10
        r11.offset = 0;     // Catch: Throwable -> L10
        if (this.mIsMultiProcess == true) goto L13;
        r11.loaded = true;     // Catch: Throwable -> L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, r10, null, th);     // Catch: Throwable -> L15
        goto L13
    }

    public native boolean fetchBoolean(long r10, String r11, long r12, boolean r13);

    public abstract boolean fetchBoolean(String r10, boolean r11);

    public native byte[] fetchBytes(long r10, String r11, long r12, byte[] r13, int r14);

    public abstract byte[] fetchBytes(String r10, byte[] r11, int r12, boolean r13);

    public native double fetchDouble(long r10, String r11, long r12, double r13);

    public abstract double fetchDouble(String r10, double r11);

    public native float fetchFloat(long r10, String r11, long r12, float r13);

    public abstract float fetchFloat(String r10, float r11);

    public native int fetchInt(long r10, String r11, long r12, int r13);

    public abstract int fetchInt(String r10, int r11);

    public native long fetchLong(long r10, String r11, long r12, long r13);

    public abstract long fetchLong(String r10, long r11);

    public native String fetchString(long r10, String r11, long r12, String r13);

    public abstract String fetchString(String r10, String r11, boolean r12);

    public native String[] fetchStringArray(long r10, String r11, long r12, String[] r13, int r14);

    public abstract String[] fetchStringArray(String r10, String[] r11, boolean r12);

    public Map<String, ?> generateOutMap() {
        HashMap r10 = new HashMap();
        Iterator<Map.Entry<String, KevaValueWrapper>> r11 = this.mValueMap.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L43;
        Map.Entry<String, KevaValueWrapper> r12 = r11.next();
        KevaValueWrapper r13 = r12.getValue();
        if (r13.offset == 0) goto L4;
        String r14 = r12.getKey();
    L26:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r14, Long.valueOf(r13.offset), th);
        goto L4
    L10:
        if (r13.loaded == true) goto L40;
        int r15 = r13.type;     // Catch: Throwable -> L26
        if (r15 != 6) goto L14;
        r13.value = fetchString(this.mHandle, r14, r13.offset, null);     // Catch: Throwable -> L26
    L38:
        if (this.mIsMultiProcess == true) goto L40;
        r13.loaded = true;     // Catch: Throwable -> L26
        goto L40
    L14:
        if (r15 != 7) goto L16;
        r13.value = fetchBytes(this.mHandle, r14, r13.offset, null, 0);     // Catch: Throwable -> L26
        goto L38
    L16:
        if (r15 == 23) goto L34;
        if (r15 == 39) goto L32;
        if (r15 != 55) goto L22;
        r13.value = fetchStringArray(this.mHandle, r14, r13.offset, null, 3);     // Catch: Throwable -> L26
        goto L38
    L22:
        if (this.mIsMultiProcess == false) goto L29;
        if (r13.type <= 5) goto L38;
    L29:
        throw new UnsupportedOperationException("keva has not implemented type " + r13.type);     // Catch: Throwable -> L26
    L32:
        throw new UnsupportedOperationException("keva has not implemented utf16");     // Catch: Throwable -> L26
    L34:
        throw new UnsupportedOperationException("keva has not implemented utf8");     // Catch: Throwable -> L26
    L40:
        r10.put(r14, r13.value);     // Catch: Throwable -> L26
        goto L4
    L43:
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r10, boolean r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        boolean r13 = fetchBoolean(r12, r11);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, null, th);     // Catch: Throwable -> L10
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r10, byte[] r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        byte[] r13 = fetchBytes(r12, r11, 0, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r10, byte[] r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        byte[] r13 = fetchBytes(r12, r11, 0, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r10, double r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        double r13 = fetchDouble(r12, r11);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, Double.valueOf(r11), th);     // Catch: Throwable -> L10
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r10, float r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        float r13 = fetchFloat(r12, r11);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, Float.valueOf(r11), th);     // Catch: Throwable -> L10
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r10, int r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        int r13 = fetchInt(r12, r11);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, Integer.valueOf(r11), th);     // Catch: Throwable -> L10
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r10, long r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        long r13 = fetchLong(r12, r11);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, Long.valueOf(r11), th);     // Catch: Throwable -> L10
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r10, String r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        String r13 = fetchString(r12, r11, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r10, String[] r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        String[] r13 = fetchStringArray(r12, r11, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r10, String[] r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        String[] r13 = fetchStringArray(r12, r11, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r10, String r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        String r13 = fetchString(r12, r11, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r10, Set<String> r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        Set<String> r13 = fetchStringSet(r12, r11, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r10, Set<String> r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        String r12 = r10;
        monitor-enter(this);
        Set<String> r13 = fetchStringSet(r12, r11, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r12, r11, th);     // Catch: Throwable -> L11
        return r11;
    }

    public void init(boolean r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandle == 0) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        doLoadRepo(r10);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    public native void rebuildValueMap(long r10);

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mChangeListeners.contains(r10) == true) goto L8;
        this.mChangeListeners.add(r10);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r10, boolean r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r12 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r13 = r10;
        r12.offset = storeBoolean(this.mHandle, r13, r12.offset, r11);     // Catch: Throwable -> L21
        r12.value = Boolean.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r12.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r14 = r10;
        sMonitor.reportThrowable(3, this.mName, r14, Boolean.valueOf(r11), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r12.loaded == false) goto L30;
        if (r12.value == null) goto L30;
        if (r12.value.equals(Boolean.valueOf(r11)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r10, byte[] r11) {
        storeBytes(r10, r11, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r10, double r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r12 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r13 = r10;
        r12.offset = storeDouble(this.mHandle, r13, r12.offset, r11);     // Catch: Throwable -> L21
        r12.value = Double.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r12.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r14 = r10;
        sMonitor.reportThrowable(3, this.mName, r14, Double.valueOf(r11), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r12.loaded == false) goto L30;
        if (r12.value == null) goto L30;
        if (r12.value.equals(Double.valueOf(r11)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r10, float r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r12 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r13 = r10;
        r12.offset = storeFloat(this.mHandle, r13, r12.offset, r11);     // Catch: Throwable -> L21
        r12.value = Float.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r12.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r14 = r10;
        sMonitor.reportThrowable(3, this.mName, r14, Float.valueOf(r11), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r12.loaded == false) goto L30;
        if (r12.value == null) goto L30;
        if (r12.value.equals(Float.valueOf(r11)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r10, int r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r12 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r13 = r10;
        r12.offset = storeInt(this.mHandle, r13, r12.offset, r11);     // Catch: Throwable -> L21
        r12.value = Integer.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r12.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r14 = r10;
        sMonitor.reportThrowable(3, this.mName, r14, Integer.valueOf(r11), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r12.loaded == false) goto L30;
        if (r12.value == null) goto L30;
        if (r12.value.equals(Integer.valueOf(r11)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r10, long r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r12 = obtainWrapperLocked(r10);     // Catch: Throwable -> L16
        if (this.mIsMultiProcess == false) goto L9;
    L30:
        String r13 = r10;
        r12.offset = storeLong(this.mHandle, r13, r12.offset, r11);     // Catch: Throwable -> L21
        r12.value = Long.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L23;
        r12.loaded = true;     // Catch: Throwable -> L21
    L23:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L26:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        th = move-exception;
        String r14 = r10;
        sMonitor.reportThrowable(3, this.mName, r14, Long.valueOf(r11), th);     // Catch: Throwable -> L16
        goto L26
    L9:
        if (r12.loaded == false) goto L30;
        if (r12.value == null) goto L30;
        if (r12.value.equals(Long.valueOf(r11)) == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r10, String[] r11) {
        storeStringArray(r10, r11, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r10, String r11) {
        storeString(r10, r11, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r10, Set<String> r11) {
        storeStringSet(r10, r11, true);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r10) {
        monitor-enter(this);
        this.mChangeListeners.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r10, Set<String> r11) {
        storeStringSet(r10, r11, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r10, byte[] r11) {
        storeBytes(r10, r11, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r10, String[] r11) {
        storeStringArray(r10, r11, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r10, String r11) {
        storeString(r10, r11, false);
    }
}
