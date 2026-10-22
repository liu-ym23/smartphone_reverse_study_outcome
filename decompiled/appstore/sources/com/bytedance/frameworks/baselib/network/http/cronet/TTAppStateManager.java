package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTAppStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AppStartState f7207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AppStartState f7208b;

    public static final enum AppStartState extends Enum<AppStartState> {
        private static final /* synthetic */ AppStartState[] $VALUES = null;
        public static final AppStartState ColdStart = null;
        public static final AppStartState Default = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;
        public static final AppStartState WeakNet = null;
        final int state;

        static {
            AppStartState r10 = new AppStartState("NormalStart", 0, -1);
            NormalStart = r10;
            AppStartState r11 = new AppStartState("ColdStart", 1, 0);
            ColdStart = r11;
            AppStartState r12 = new AppStartState("HotStart", 2, 1);
            HotStart = r12;
            AppStartState r13 = new AppStartState("WarmStart", 3, 2);
            WarmStart = r13;
            AppStartState r14 = new AppStartState("WeakNet", 4, 3);
            WeakNet = r14;
            AppStartState r15 = new AppStartState("Default", 5, 4);
            Default = r15;
            $VALUES = new AppStartState[]{r10, r11, r12, r13, r14, r15};
        }

        private AppStartState(String r10, int r11, int r12) {
            super(r10, r11);
            this.state = r12;
        }

        public static AppStartState valueOf(String r10) {
            return (AppStartState) Enum.valueOf(AppStartState.class, r10);
        }

        public static AppStartState[] values() {
            return (AppStartState[]) $VALUES.clone();
        }

        public int getValue() {
            return this.state;
        }
    }

    static {
        f7207a = AppStartState.NormalStart;
        f7208b = AppStartState.Default;
    }

    public static AppStartState a() {
        return f7208b;
    }

    public static int b() {
        return f7207a.state;
    }

    public static void c(AppStartState r10) {
        f7208b = r10;
    }
}
