package androidx.work;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes17.dex */
public interface Operation {
    public static final State.IN_PROGRESS IN_PROGRESS = null;
    public static final State.SUCCESS SUCCESS = null;

    /* JADX INFO: renamed from: androidx.work.Operation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class State {

        public static final class FAILURE extends State {
            private final Throwable mThrowable;

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.mThrowable.getMessage()});
            }

            public Throwable getThrowable() {
                return this.mThrowable;
            }

            public FAILURE(Throwable r100) {
                this.mThrowable = r100;
            }
        }

        public static final class IN_PROGRESS extends State {
            public String toString() {
                return "IN_PROGRESS";
            }

            private IN_PROGRESS() {
            }

            public /* synthetic */ IN_PROGRESS(AnonymousClass1 r100) {
                this();
            }
        }

        public static final class SUCCESS extends State {
            public String toString() {
                return "SUCCESS";
            }

            private SUCCESS() {
            }

            public /* synthetic */ SUCCESS(AnonymousClass1 r100) {
                this();
            }
        }

        public State() {
        }
    }

    ListenableFuture<State.SUCCESS> getResult();

    LiveData<State> getState();

    static {
        AnonymousClass1 r100 = null;
        SUCCESS = new State.SUCCESS(r100);
        IN_PROGRESS = new State.IN_PROGRESS(r100);
    }
}
