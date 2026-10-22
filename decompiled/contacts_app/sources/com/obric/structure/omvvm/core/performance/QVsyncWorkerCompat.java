package com.obric.structure.omvvm.core.performance;

import android.view.Choreographer;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QVsyncWorkerCompat.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/structure/omvvm/core/performance/QVsyncWorkerCompat;", "", "()V", "Companion", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QVsyncWorkerCompat {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: QVsyncWorkerCompat.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/structure/omvvm/core/performance/QVsyncWorkerCompat$Companion;", "", "()V", "postCommitCallback", "", "choreographer", "Landroid/view/Choreographer;", "callback", "Landroid/view/Choreographer$FrameCallback;", "postCommitCallbackDelay", "delayMillis", "", "postCommitRunnable", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Ljava/lang/Runnable;", "postCommitRunnableDelay", "postOnCommitOrAnimation", "postOnCommitOrAnimationDelayed", "removeCommitCallback", "removeCommitRunnable", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean postCommitRunnable(Choreographer r3, Runnable r4) {
            Intrinsics.checkNotNullParameter(r3, "choreographer");
            Intrinsics.checkNotNullParameter(r4, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
            return postCommitRunnableDelay(r3, r4, 0);
        }

        @JvmStatic
        public final boolean postCommitRunnableDelay(Choreographer r1, Runnable r2, long r3) {
            Intrinsics.checkNotNullParameter(r1, "choreographer");
            Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
            if (QVsyncWorker.INSTANCE.postCommitRunnable$omvvm_core_release(r1, r2, r3) == false) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public final boolean removeCommitRunnable(Choreographer r1, Runnable r2) {
            Intrinsics.checkNotNullParameter(r1, "choreographer");
            Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
            if (QVsyncWorker.INSTANCE.removeCommitRunnable$omvvm_core_release(r1, r2) == false) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public final boolean postCommitCallback(Choreographer r3, Choreographer.FrameCallback r4) {
            Intrinsics.checkNotNullParameter(r3, "choreographer");
            Intrinsics.checkNotNullParameter(r4, "callback");
            return postCommitCallbackDelay(r3, r4, 0);
        }

        @JvmStatic
        public final boolean postCommitCallbackDelay(Choreographer r1, Choreographer.FrameCallback r2, long r3) {
            Intrinsics.checkNotNullParameter(r1, "choreographer");
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (QVsyncWorker.INSTANCE.postCommitCallback$omvvm_core_release(r1, r2, r3) == false) goto L5;
            return true;
        L5:
            r1.postFrameCallbackDelayed(r2, r3);
            return false;
        }

        @JvmStatic
        public final boolean removeCommitCallback(Choreographer r1, Choreographer.FrameCallback r2) {
            Intrinsics.checkNotNullParameter(r1, "choreographer");
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (QVsyncWorker.INSTANCE.removeCommitCallback$omvvm_core_release(r1, r2) == false) goto L5;
            return true;
        L5:
            r1.removeFrameCallback(r2);
            return false;
        }

        @JvmStatic
        public final boolean postOnCommitOrAnimation(Runnable r3) {
            Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
            return postOnCommitOrAnimationDelayed(r3, 0);
        }

        @JvmStatic
        public final boolean postOnCommitOrAnimationDelayed(Runnable r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
            QVsyncWorker r2 = QVsyncWorker.INSTANCE;
            Choreographer r0 = Choreographer.getInstance();
            Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
            if (r2.postCommitRunnable$omvvm_core_release(r0, r3, r4) == false) goto L5;
            return true;
        L5:
            Choreographer.getInstance().postFrameCallbackDelayed(new RunnableCallback(r3), r4);
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final boolean postCommitCallback(Choreographer r1, Choreographer.FrameCallback r2) {
        return Companion.postCommitCallback(r1, r2);
    }

    @JvmStatic
    public static final boolean postCommitCallbackDelay(Choreographer r1, Choreographer.FrameCallback r2, long r3) {
        return Companion.postCommitCallbackDelay(r1, r2, r3);
    }

    @JvmStatic
    public static final boolean postCommitRunnable(Choreographer r1, Runnable r2) {
        return Companion.postCommitRunnable(r1, r2);
    }

    @JvmStatic
    public static final boolean postCommitRunnableDelay(Choreographer r1, Runnable r2, long r3) {
        return Companion.postCommitRunnableDelay(r1, r2, r3);
    }

    @JvmStatic
    public static final boolean postOnCommitOrAnimation(Runnable r1) {
        return Companion.postOnCommitOrAnimation(r1);
    }

    @JvmStatic
    public static final boolean postOnCommitOrAnimationDelayed(Runnable r1, long r2) {
        return Companion.postOnCommitOrAnimationDelayed(r1, r2);
    }

    @JvmStatic
    public static final boolean removeCommitCallback(Choreographer r1, Choreographer.FrameCallback r2) {
        return Companion.removeCommitCallback(r1, r2);
    }

    @JvmStatic
    public static final boolean removeCommitRunnable(Choreographer r1, Runnable r2) {
        return Companion.removeCommitRunnable(r1, r2);
    }

    public QVsyncWorkerCompat() {
    }
}
