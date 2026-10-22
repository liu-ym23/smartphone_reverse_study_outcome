package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public interface Service {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.Service$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    @Beta
    public static abstract class Listener {
        public Listener() {
        }

        public void failed(State r10, Throwable r11) {
        }

        public void running() {
        }

        public void starting() {
        }

        public void stopping(State r10) {
        }

        public void terminated(State r10) {
        }
    }

    @Beta
    public static abstract enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State FAILED = null;
        public static final State NEW = null;
        public static final State RUNNING = null;
        public static final State STARTING = null;
        public static final State STOPPING = null;
        public static final State TERMINATED = null;

        static {
            final String r10 = "NEW";
            final int r11 = 0;
            State r12 = new AnonymousClass1(r10, r11);
            NEW = r12;
            final String r13 = "STARTING";
            final int r14 = 1;
            State r15 = new AnonymousClass2(r13, r14);
            STARTING = r15;
            final String r16 = "RUNNING";
            final int r17 = 2;
            State r18 = new AnonymousClass3(r16, r17);
            RUNNING = r18;
            final String r19 = "STOPPING";
            final int r20 = 3;
            State r21 = new AnonymousClass4(r19, r20);
            STOPPING = r21;
            final String r22 = "TERMINATED";
            final int r110 = 4;
            State r23 = new AnonymousClass5(r22, r110);
            TERMINATED = r23;
            final String r111 = "FAILED";
            final int r112 = 5;
            State r24 = new AnonymousClass6(r111, r112);
            FAILED = r24;
            $VALUES = new State[]{r12, r15, r18, r21, r23, r24};
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

        public abstract boolean isTerminal();

        public /* synthetic */ State(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    void addListener(Listener r10, Executor r11);

    void awaitRunning();

    void awaitRunning(long r10, TimeUnit r11) throws TimeoutException;

    void awaitTerminated();

    void awaitTerminated(long r10, TimeUnit r11) throws TimeoutException;

    Throwable failureCause();

    boolean isRunning();

    @CanIgnoreReturnValue
    Service startAsync();

    State state();

    @CanIgnoreReturnValue
    Service stopAsync();
}
