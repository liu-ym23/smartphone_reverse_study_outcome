package android.view;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class StepOSInsetsControllerExtImpl implements IStepOSInsetsControllerExt {
    private static final boolean DEBUG = true;
    private static final String TAG = "InsetsControllerExt";
    InsetsController mHost;

    public void onAttach(InsetsController host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public void onAnimationFinishOrCancelled(final int types, final boolean finish) {
        Handler h = this.mHost.getHost().getHandler();
        if (Looper.myLooper() != h.getLooper()) {
            h.post(new Runnable() { // from class: android.view.StepOSInsetsControllerExtImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationFinishOrCancelled$0(types, finish);
                }
            });
        } else {
            lambda$onAnimationFinishOrCancelled$0(types, finish);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dispatchAnimationFinishOrCancelledInner, reason: merged with bridge method [inline-methods] */
    public void lambda$onAnimationFinishOrCancelled$0(int types, boolean finish) {
        Log.d(TAG, "onAnimationFinishOrCancelled " + WindowInsets.Type.toString(types) + " finish " + finish);
        dispatchAnimationFinishOnSourceConsumers(this.mHost, types, finish);
    }

    private static void dispatchAnimationFinishOnSourceConsumers(InsetsController controller, int types, boolean finish) {
        SparseArray<InsetsSourceConsumer> sourceConsumers = controller.getSourceConsumers();
        for (int i = sourceConsumers.size() - 1; i >= 0; i--) {
            InsetsSourceConsumer consumer = sourceConsumers.valueAt(i);
            if ((consumer.getType() & types) != 0) {
                consumer.onAnimationFinishOrCancelled(finish);
            }
        }
    }

    public WindowInsetsAnimationControlListener createInnerAnimationControlListener(int types, WindowInsetsAnimationControlListener loggingListener, InsetsController controller) {
        return new InnerAnimationControlListener(types, loggingListener, controller);
    }

    private static final class InnerAnimationControlListener implements WindowInsetsAnimationControlListener {
        private final InsetsController mController;
        private final WindowInsetsAnimationControlListener mLoggingListener;
        private final int mRequestedTypes;

        public InnerAnimationControlListener(int requestedTypes, WindowInsetsAnimationControlListener loggingListener, InsetsController controller) {
            this.mRequestedTypes = requestedTypes;
            this.mLoggingListener = loggingListener;
            this.mController = controller;
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onReady(WindowInsetsAnimationController controller, int types) {
            if (this.mLoggingListener != null) {
                this.mLoggingListener.onReady(controller, types);
            }
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onFinished(WindowInsetsAnimationController controller) {
            if (this.mLoggingListener != null) {
                this.mLoggingListener.onFinished(controller);
            }
            this.mController.mStepOSInsetsControllerExt.onAnimationFinishOrCancelled(this.mRequestedTypes, true);
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onCancelled(WindowInsetsAnimationController controller) {
            if (this.mLoggingListener != null) {
                this.mLoggingListener.onCancelled(controller);
            }
            this.mController.mStepOSInsetsControllerExt.onAnimationFinishOrCancelled(this.mRequestedTypes, false);
        }
    }
}
