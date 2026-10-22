package com.bytedance.apm.launch.evil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class LaunchSleepDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f6505a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static State f6506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f6507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f6508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f6509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f6510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f6511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ExecutorService f6512h;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DISK_SLEEP = null;
        public static final State NONE = null;
        public static final State NOT_SLEEP = null;
        public static final State SLEEP = null;

        static {
            State r10 = new State("NONE", 0);
            NONE = r10;
            State r11 = new State("SLEEP", 1);
            SLEEP = r11;
            State r12 = new State("NOT_SLEEP", 2);
            NOT_SLEEP = r12;
            State r13 = new State("DISK_SLEEP", 3);
            DISK_SLEEP = r13;
            $VALUES = new State[]{r10, r11, r12, r13};
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public static class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(r10);
            r11.setName("launch_sleep_detector");
            return r11;
        }
    }

    static {
        f6506b = State.NONE;
        f6507c = -1;
        f6508d = 0;
        f6509e = "";
        f6510f = 8000;
        f6511g = 0;
        f6512h = Executors.newSingleThreadExecutor(new a());
    }

    public static void a() {
        if (f6505a == true) goto L5;
        return;
    L5:
        f6505a = false;
        f6506b = State.NONE;
        f6507c = -1;
        f6508d = 0;
        f6509e = "";
    }
}
