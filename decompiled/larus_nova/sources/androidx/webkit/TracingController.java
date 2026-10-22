package androidx.webkit;

import androidx.webkit.internal.TracingControllerImpl;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public abstract class TracingController {

    public static class LAZY_HOLDER {
        static final TracingController INSTANCE = null;

        private LAZY_HOLDER() {
        }

        static {
            INSTANCE = new TracingControllerImpl();
        }
    }

    public TracingController() {
    }

    public abstract boolean isTracing();

    public abstract void start(TracingConfig r100);

    public abstract boolean stop(OutputStream r100, Executor r101);

    public static TracingController getInstance() {
        return LAZY_HOLDER.INSTANCE;
    }
}
