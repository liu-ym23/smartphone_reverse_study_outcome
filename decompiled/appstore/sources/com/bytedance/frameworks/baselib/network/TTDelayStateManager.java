package com.bytedance.frameworks.baselib.network;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTDelayStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7122a = "TTDelayStateManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AppStartState f7123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f7124c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f7125d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f7126e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f7127f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLong f7128g = null;

    public static final enum AppStartState extends Enum<AppStartState> {
        private static final /* synthetic */ AppStartState[] $VALUES = null;
        public static final AppStartState ColdStart = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;
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
            $VALUES = new AppStartState[]{r10, r11, r12, r13};
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

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7129a = null;

        static {
            int[] r10 = new int[AppStartState.values().length];
            f7129a = r10;
            r10[AppStartState.ColdStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f7129a[AppStartState.HotStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f7129a[AppStartState.WarmStart.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f7123b = AppStartState.NormalStart;
        f7124c = new AtomicBoolean(false);
        f7125d = new AtomicLong(0);
        f7126e = new AtomicLong(0);
        f7127f = new AtomicLong(0);
        f7128g = new AtomicLong(0);
    }

    public static AppStartState a() {
        return f7123b;
    }

    public static AppStartState b() {
        if (Logger.debug() == false) goto L5;
        Logger.d(f7122a, "get coldDuration hostDuration warmDuration " + f7126e.get() + f7127f.get() + f7128g.get());
    L5:
        int r10 = a.f7129a[f7123b.ordinal()];
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L14;
        return f7123b;
    L14:
        if (d(f7125d.get(), f7128g.get()) == false) goto L17;
        f7123b = AppStartState.NormalStart;
    L17:
        return f7123b;
    L19:
        if (d(f7125d.get(), f7127f.get()) == false) goto L22;
        f7123b = AppStartState.NormalStart;
    L22:
        return f7123b;
    L24:
        if (d(f7125d.get(), f7126e.get()) == false) goto L27;
        f7123b = AppStartState.NormalStart;
    L27:
        return f7123b;
    }

    public static boolean c() {
        return f7124c.get();
    }

    public static boolean d(long r10, long r11) {
        if (((System.currentTimeMillis() / 1000) - r10) <= r11) goto L5;
        return true;
    L5:
        return false;
    }

    public static void e(JSONObject r10) {
        AtomicBoolean r11 = f7124c;
        if (r10.optInt("request_tag_enabled") <= 0) goto L5;
        boolean r12 = true;
    L6:
        r11.set(r12);
        AtomicLong r13 = f7126e;
        r13.set(r10.optInt("cold_start_seconds"));
        AtomicLong r14 = f7127f;
        r14.set(r10.optInt("hot_start_seconds"));
        AtomicLong r15 = f7128g;
        r15.set(r10.optInt("warm_start_seconds"));
        if (Logger.debug() == false) goto L10;
        Logger.d(f7122a, "set coldDuration hostDuration warmDuration " + r13.get() + r14.get() + r15.get());
        return;
    L10:
        return;
    L5:
        r12 = false;
        goto L6
    }
}
