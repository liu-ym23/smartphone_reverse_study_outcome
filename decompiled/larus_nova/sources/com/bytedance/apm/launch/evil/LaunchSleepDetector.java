package com.bytedance.apm.launch.evil;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes14.dex */
public final class LaunchSleepDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f190615a = null;

    public static final enum State extends Enum<State> {
        public static final State DISK_SLEEP = null;
        public static final State NONE = null;
        public static final State NOT_SLEEP = null;
        public static final State SLEEP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f190616a = null;

        static {
            State r100 = new State(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            State r101 = new State("SLEEP", 1);
            SLEEP = r101;
            State r102 = new State("NOT_SLEEP", 2);
            NOT_SLEEP = r102;
            State r103 = new State("DISK_SLEEP", 3);
            DISK_SLEEP = r103;
            f190616a = new State[]{r100, r101, r102, r103};
        }

        public static State[] values() {
            return (State[]) f190616a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "LaunchSleepDetector$1");
            ThreadMethodProxy.setName(r101, "launch_sleep_detector");
            return r101;
        }
    }

    static {
        State r100 = State.NONE;
        f190615a = PThreadExecutorsUtils.newSingleThreadExecutor(new a());
    }
}
