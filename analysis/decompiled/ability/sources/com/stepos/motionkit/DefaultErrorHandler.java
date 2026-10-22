package com.stepos.motionkit;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/motionkit/DefaultErrorHandler;", "Lcom/stepos/motionkit/ErrorHandler;", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/motionkit/MotionKitError;", "error", "LC7/r;", "onError", "(Lcom/stepos/motionkit/MotionKitError;)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultErrorHandler implements ErrorHandler {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ErrorLevel.values().length];
            try {
                iArr[ErrorLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ErrorLevel.DEGRADED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ErrorLevel.FATAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.stepos.motionkit.ErrorHandler
    public void onError(MotionKitError error) {
        k.f(error, "error");
        int i = WhenMappings.$EnumSwitchMapping$0[error.getLevel().ordinal()];
        if (i == 1) {
            MKLog.INSTANCE.w("Core", error.getMessage(), error.getCause());
        } else if (i == 2) {
            MKLog.INSTANCE.e("Core", error.getMessage(), error.getCause());
        } else {
            if (i == 3) {
                throw new IllegalStateException(error.getMessage(), error.getCause());
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
