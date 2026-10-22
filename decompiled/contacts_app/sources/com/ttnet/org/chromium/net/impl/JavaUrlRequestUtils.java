package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public final class JavaUrlRequestUtils {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface CheckedRunnable {
        void run() throws Exception;
    }

    public static final class DirectPreventingExecutor implements Executor {
        private final Executor mDelegate;

        private static final class InlineCheckingRunnable implements Runnable {
            private Thread mCallingThread;
            private final Runnable mCommand;
            private InlineExecutionProhibitedException mExecutedInline;

            /* synthetic */ InlineCheckingRunnable(Runnable r1, Thread r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            static /* synthetic */ InlineExecutionProhibitedException access$100(InlineCheckingRunnable r0) {
                return r0.mExecutedInline;
            }

            static /* synthetic */ Thread access$202(InlineCheckingRunnable r0, Thread r1) {
                r0.mCallingThread = r1;
                return r1;
            }

            private InlineCheckingRunnable(Runnable r1, Thread r2) {
                this.mCommand = r1;
                this.mCallingThread = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Thread.currentThread() != this.mCallingThread) goto L6;
                this.mExecutedInline = new InlineExecutionProhibitedException();
                return;
            L6:
                this.mCommand.run();
            }
        }

        public DirectPreventingExecutor(Executor r1) {
            this.mDelegate = r1;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            InlineCheckingRunnable r1 = new InlineCheckingRunnable(r4, Thread.currentThread(), null);
            this.mDelegate.execute(r1);
            if (InlineCheckingRunnable.access$100(r1) != null) goto L7;
            InlineCheckingRunnable.access$202(r1, null);
            return;
        L7:
            throw InlineCheckingRunnable.access$100(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int AWAITING_FOLLOW_REDIRECT = 3;
        public static final int AWAITING_READ = 4;
        public static final int CANCELLED = 8;
        public static final int COMPLETE = 7;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 5;
        public static final int REDIRECT_RECEIVED = 2;
        public static final int STARTED = 1;
    }

    public JavaUrlRequestUtils() {
    }
}
