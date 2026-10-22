package com.stepos.motionkit;

import S7.a;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lcom/stepos/motionkit/MotionKit;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/motionkit/ErrorHandler;", "handler", "LC7/r;", "setErrorHandler", "(Lcom/stepos/motionkit/ErrorHandler;)V", "Lcom/stepos/motionkit/MotionKitError;", "error", "handleError", "(Lcom/stepos/motionkit/MotionKitError;)V", ExifInterface.GPS_DIRECTION_TRUE, "fallback", "Lkotlin/Function0;", "block", "safeFx", "(Ljava/lang/Object;LS7/a;)Ljava/lang/Object;", "errorHandler", "Lcom/stepos/motionkit/ErrorHandler;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MotionKit {
    public static final MotionKit INSTANCE = new MotionKit();
    private static ErrorHandler errorHandler = new DefaultErrorHandler();

    private MotionKit() {
    }

    public final void handleError(MotionKitError error) {
        k.f(error, "error");
        errorHandler.onError(error);
    }

    public final <T> T safeFx(T fallback, a block) {
        k.f(block, "block");
        try {
            return (T) block.invoke();
        } catch (Exception e) {
            this.handleError(new MotionKitError(ErrorLevel.DEGRADED, "FX operation failed", e));
            return fallback;
        }
    }

    public final void setErrorHandler(ErrorHandler handler) {
        k.f(handler, "handler");
        errorHandler = handler;
    }
}
