package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes2.dex */
public interface Service {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.Service$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class Listener {
        public void failed(State r1, Throwable r2) {
        }

        public void running() {
        }

        public void starting() {
        }

        public void stopping(State r1) {
        }

        public void terminated(State r1) {
        }

        public Listener() {
        }
    }

    public static abstract enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State FAILED = null;
        public static final State NEW = null;
        public static final State RUNNING = null;
        public static final State STARTING = null;
        public static final State STOPPING = null;
        public static final State TERMINATED = null;

        abstract boolean isTerminal();

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ State(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static {
            final String r1 = "NEW";
            final int r2 = 0;
            State r0 = new AnonymousClass1(r1, r2);
            NEW = r0;
            final String r3 = "STARTING";
            final int r4 = 1;
            State r5 = new AnonymousClass2(r3, r4);
            STARTING = r5;
            final String r6 = DebugCoroutineInfoImplKt.RUNNING;
            final int r7 = 2;
            State r8 = new AnonymousClass3(r6, r7);
            RUNNING = r8;
            final String r9 = "STOPPING";
            final int r10 = 3;
            State r11 = new AnonymousClass4(r9, r10);
            STOPPING = r11;
            final String r12 = "TERMINATED";
            final int r13 = 4;
            State r14 = new AnonymousClass5(r12, r13);
            TERMINATED = r14;
            final String r15 = "FAILED";
            final int r16 = 5;
            State r17 = new AnonymousClass6(r15, r16);
            FAILED = r17;
            $VALUES = new State[]{r0, r5, r8, r11, r14, r17};
        }
    }

    void addListener(Listener r1, Executor r2);

    void awaitRunning();

    void awaitRunning(long r1, TimeUnit r3) throws TimeoutException;

    void awaitTerminated();

    void awaitTerminated(long r1, TimeUnit r3) throws TimeoutException;

    Throwable failureCause();

    boolean isRunning();

    Service startAsync();

    State state();

    Service stopAsync();
}
