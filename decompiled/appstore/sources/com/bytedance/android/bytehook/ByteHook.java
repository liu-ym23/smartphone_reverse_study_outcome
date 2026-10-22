package com.bytedance.android.bytehook;

/* JADX INFO: loaded from: classes.dex */
public class ByteHook {
    private static final boolean defaultDebug = false;
    private static final ILibLoader defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode AUTOMATIC = null;
        public static final Mode MANUAL = null;
        private final int value;

        static {
            Mode r10 = new Mode("AUTOMATIC", 0, 0);
            AUTOMATIC = r10;
            Mode r11 = new Mode("MANUAL", 1, 1);
            MANUAL = r11;
            $VALUES = new Mode[]{r10, r11};
        }

        private Mode(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Mode valueOf(String r10) {
            return (Mode) Enum.valueOf(Mode.class, r10);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ILibLoader f6267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6269c;

        public a() {
        }

        public boolean a() {
            return this.f6269c;
        }

        public ILibLoader b() {
            return this.f6267a;
        }

        public int c() {
            return this.f6268b;
        }

        public void d(boolean r10) {
            this.f6269c = r10;
        }

        public void e(ILibLoader r10) {
            this.f6267a = r10;
        }

        public void f(int r10) {
            this.f6268b = r10;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ILibLoader f6270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6272c;

        public b() {
            this.f6270a = ByteHook.access$000();
            this.f6271b = ByteHook.access$100();
            this.f6272c = false;
        }

        public a a() {
            a r10 = new a();
            r10.e(this.f6270a);
            r10.f(this.f6271b);
            r10.d(this.f6272c);
            return r10;
        }
    }

    static {
        defaultMode = Mode.AUTOMATIC.getValue();
    }

    public ByteHook() {
    }

    public static /* synthetic */ ILibLoader access$000() {
        return defaultLibLoader;
    }

    public static /* synthetic */ int access$100() {
        return defaultMode;
    }

    public static String getRecords() {
        if (initStatus == 0) goto L5;
        return null;
    L5:
        return nativeGetRecords();
    }

    public static int init() {
        if (inited == false) goto L7;
        return initStatus;
    L7:
        return init(new b().a());
    }

    private static native String nativeGetRecords();

    private static native int nativeInit(int r10, boolean r11);

    private static native void nativeSetDebug(boolean r10);

    public static void setDebug(boolean r10) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r10);
        return;
    }

    public static synchronized int init(a r10) {
        monitor-enter(ByteHook.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L12;
        int r11 = initStatus;     // Catch: Throwable -> L9
        monitor-exit(ByteHook.class);
        return r11;
    L12:
        inited = true;     // Catch: Throwable -> L9
        if (r10.b() != null) goto L16;
        System.loadLibrary(libName);     // Catch: Throwable -> L24
    L30:
        initStatus = nativeInit(r10.c(), r10.a());     // Catch: Throwable -> L19
    L21:
        int r12 = initStatus;     // Catch: Throwable -> L9
        monitor-exit(ByteHook.class);
        return r12;
    L20:
        initStatus = 101;     // Catch: Throwable -> L9
        goto L21
    L16:
        r10.b().loadLibrary(libName);     // Catch: Throwable -> L24
        goto L30
    L25:
        initStatus = 100;     // Catch: Throwable -> L9
        return 100;
    }
}
