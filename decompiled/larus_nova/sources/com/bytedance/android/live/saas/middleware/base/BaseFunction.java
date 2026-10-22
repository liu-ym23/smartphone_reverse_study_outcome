package com.bytedance.android.live.saas.middleware.base;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000f\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000eH\u0016R\u001c\u0010\u0006\u001a\u00028\u0001X\u0086.¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", ExifInterface.GPS_DIRECTION_TRUE, "C", "", "Lcom/bytedance/android/live/saas/middleware/base/IFunction;", "()V", "mParams", "getMParams", "()Ljava/lang/Object;", "setMParams", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getImpl", "getTask", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseFunction<T, C> implements IFunction<T, C> {
    public C mParams;

    public BaseFunction() {
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IFunction
    public T getImpl() {
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IFunction
    public ISdkInitTask<C> getTask() {
        return null;
    }

    public final C getMParams() {
        C r100 = this.mParams;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mParams");
    L5:
        return r100;
    }

    public final void setMParams(C r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mParams = r100;
    }
}
