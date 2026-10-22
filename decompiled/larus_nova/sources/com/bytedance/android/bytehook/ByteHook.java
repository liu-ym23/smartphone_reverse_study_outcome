package com.bytedance.android.bytehook;

import com.bytedance.shadowhook.ShadowHook;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class ByteHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_UNINIT = 1;
    private static final boolean defaultDebug = false;
    private static final hd.a defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static final boolean defaultRecordable = false;
    private static final boolean defaultShadowhookDebug = false;
    private static final ShadowHook.c defaultShadowhookLibLoader = null;
    private static final ShadowHook.Mode defaultShadowhookMode = null;
    private static final boolean defaultShadowhookRecordable = false;
    private static long initCostMs = -1;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";
    private static final int recordItemAll = 255;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 64;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 32;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 128;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode AUTOMATIC = null;
        public static final Mode MANUAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f42506a = null;
        private final int value;

        static {
            Mode r100 = new Mode("AUTOMATIC", 0, 0);
            AUTOMATIC = r100;
            Mode r101 = new Mode("MANUAL", 1, 1);
            MANUAL = r101;
            f42506a = new Mode[]{r100, r101};
        }

        public static Mode[] values() {
            return (Mode[]) f42506a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX INFO: loaded from: classes43.dex */
    public static final enum RecordItem extends Enum<RecordItem> {
        public static final RecordItem CALLER_LIB_NAME = null;
        public static final RecordItem ERRNO = null;
        public static final RecordItem LIB_NAME = null;
        public static final RecordItem NEW_ADDR = null;
        public static final RecordItem OP = null;
        public static final RecordItem STUB = null;
        public static final RecordItem SYM_NAME = null;
        public static final RecordItem TIMESTAMP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecordItem[] f42507a = null;

        static {
            RecordItem r100 = new RecordItem("TIMESTAMP", 0);
            TIMESTAMP = r100;
            RecordItem r101 = new RecordItem("CALLER_LIB_NAME", 1);
            CALLER_LIB_NAME = r101;
            RecordItem r102 = new RecordItem("OP", 2);
            OP = r102;
            RecordItem r103 = new RecordItem("LIB_NAME", 3);
            LIB_NAME = r103;
            RecordItem r104 = new RecordItem("SYM_NAME", 4);
            SYM_NAME = r104;
            RecordItem r105 = new RecordItem("NEW_ADDR", 5);
            NEW_ADDR = r105;
            RecordItem r110 = new RecordItem("ERRNO", 6);
            ERRNO = r110;
            RecordItem r111 = new RecordItem("STUB", 7);
            STUB = r111;
            f42507a = new RecordItem[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static RecordItem[] values() {
            return (RecordItem[]) f42507a.clone();
        }

        public static RecordItem valueOf(String r100) {
            return (RecordItem) r27.a.a(RecordItem.class, r100);
        }

        public RecordItem(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes43.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42508a = null;

        static {
            int[] r100 = new int[RecordItem.values().length];
            f42508a = r100;
            r100[RecordItem.TIMESTAMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f42508a[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f42508a[RecordItem.OP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f42508a[RecordItem.LIB_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f42508a[RecordItem.SYM_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f42508a[RecordItem.NEW_ADDR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f42508a[RecordItem.ERRNO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f42508a[RecordItem.STUB.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f42509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f42510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f42511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ShadowHook.Mode f42512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f42513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f42514f;

        public b() {
        }
    }

    public ByteHook() {
    }

    public static /* synthetic */ hd.a access$000() {
        return null;
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ ShadowHook.c access$200() {
        return null;
    }

    public static int init() {
        return init(null);
    }

    private static native int nativeAddIgnore(String r100);

    private static native String nativeGetArch();

    private static native boolean nativeGetDebug();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int r100);

    private static native String nativeGetVersion();

    private static native int nativeInit(int r100, boolean r101);

    private static native void nativeSetDebug(boolean r100);

    private static native void nativeSetRecordable(boolean r100);

    static {
        defaultMode = Mode.AUTOMATIC.getValue();
        defaultShadowhookMode = ShadowHook.Mode.SHARED;
    }

    public static String getArch() {
        if (initStatus == 0) goto L5;
        return "unknown";
    L5:
        return nativeGetArch();
    }

    public static boolean getDebug() {
        if (initStatus == 0) goto L5;
        return false;
    L5:
        return nativeGetDebug();
    }

    public static Mode getMode() {
        if (initStatus != 0) goto L10;
        Mode r100 = Mode.AUTOMATIC;
        if (r100.getValue() != nativeGetMode()) goto L8;
        return r100;
    L8:
        return Mode.MANUAL;
    L10:
        return Mode.AUTOMATIC;
    }

    public static boolean getRecordable() {
        if (initStatus == 0) goto L5;
        return false;
    L5:
        return nativeGetRecordable();
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static /* synthetic */ int access$100() {
        return defaultMode;
    }

    public static /* synthetic */ ShadowHook.Mode access$300() {
        return defaultShadowhookMode;
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static int getInitErrno() {
        return initStatus;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_android_bytehook_ByteHook_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static int addIgnore(String r100) {
        int r101 = initStatus;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        return nativeAddIgnore(r100);
    }

    public static String getRecords(RecordItem... r100) {
        if (initStatus != 0) goto L22;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r102 >= r101) goto L18;
        RecordItem r104 = r100[r102];
        switch(a.f42508a[r104.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L17;
        };
    L9:
        r103 = r103 | 128;
        goto L17
    L10:
        r103 = r103 | 64;
        goto L17
    L11:
        r103 = r103 | 32;
        goto L17
    L12:
        r103 = r103 | 16;
        goto L17
    L13:
        r103 = r103 | 8;
        goto L17
    L14:
        r103 = r103 | 4;
        goto L17
    L15:
        r103 = r103 | 2;
        goto L17
    L16:
        r103 = r103 | 1;
    L17:
        r102 = r102 + 1;
        goto L5
    L18:
        if (r103 != 0) goto L21;
        r103 = 255;
    L21:
        return nativeGetRecords(r103);
    L22:
        return null;
    }

    public static synchronized int init(b r100) {
        monitor-enter(ByteHook.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r101 = initStatus;     // Catch: Throwable -> L31
        monitor-exit(ByteHook.class);
        return r101;
    L10:
        inited = true;     // Catch: Throwable -> L31
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if (r100 != null) goto L13;
        access$000();     // Catch: Throwable -> L31
        int r103 = access$100();     // Catch: Throwable -> L31
        access$200();     // Catch: Throwable -> L31
        ShadowHook.Mode r104 = access$300();     // Catch: Throwable -> L31
        b r105 = new b();     // Catch: Throwable -> L31
        r105.f42509a = r103;     // Catch: Throwable -> L31
        r105.f42510b = false;     // Catch: Throwable -> L31
        r105.f42511c = false;     // Catch: Throwable -> L31
        r105.f42512d = r104;     // Catch: Throwable -> L31
        r105.f42513e = false;     // Catch: Throwable -> L31
        r105.f42514f = false;     // Catch: Throwable -> L31
        r100 = r105;
    L13:
        ShadowHook.access$000();     // Catch: Throwable -> L31
        ShadowHook.access$100();     // Catch: Throwable -> L31
        int r106 = r100.f42512d.getValue();     // Catch: Throwable -> L31
        boolean r107 = r100.f42513e;     // Catch: Throwable -> L31
        boolean r108 = r100.f42514f;     // Catch: Throwable -> L31
        ShadowHook.b r109 = new ShadowHook.b();     // Catch: Throwable -> L31
        r109.f270294a = r106;     // Catch: Throwable -> L31
        r109.f270295b = r107;     // Catch: Throwable -> L31
        r109.f270296c = r108;     // Catch: Throwable -> L31
        r109.f270297d = false;     // Catch: Throwable -> L31
        ShadowHook.init(r109);     // Catch: Throwable -> L31
        INVOKESTATIC_com_bytedance_android_bytehook_ByteHook_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(libName);     // Catch: Throwable -> L27
        goto L28
    L36:
        initStatus = nativeInit(r100.f42509a, r100.f42510b);     // Catch: Throwable -> L18
    L19:
        boolean r110 = r100.f42511c;     // Catch: Throwable -> L31
        if (r110 == true) goto L34;
    L24:
        initCostMs = System.currentTimeMillis() - r102;     // Catch: Throwable -> L31
        int r111 = initStatus;     // Catch: Throwable -> L31
        monitor-exit(ByteHook.class);
        return r111;
    L34:
        nativeSetRecordable(r110);     // Catch: Throwable -> L23
    L23:
        initStatus = 101;     // Catch: Throwable -> L31
        goto L24
    L18:
        initStatus = 101;     // Catch: Throwable -> L31
    L28:
        initStatus = 100;     // Catch: Throwable -> L31
        initCostMs = System.currentTimeMillis() - r102;     // Catch: Throwable -> L31
        return initStatus;
    }

    public static void setDebug(boolean r100) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r100);
        return;
    }

    public static void setRecordable(boolean r100) {
        if (initStatus != 0) goto L6;
        nativeSetRecordable(r100);
        return;
    }
}
