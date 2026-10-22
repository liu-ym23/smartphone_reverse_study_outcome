package com.bytedance.android.live.saas.middleware.base;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u0002H\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/base/FunctionFactory;", "", "()V", "provide", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", ExifInterface.GPS_DIRECTION_TRUE, "C", "configParams", "configuration", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "(Ljava/lang/Object;Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;)Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class FunctionFactory {
    public static final FunctionFactory INSTANCE = null;

    private FunctionFactory() {
    }

    static {
        INSTANCE = new FunctionFactory();
    }

    public final <T, C> BaseFunction<T, C> provide(C r100, IConfiguration<T, C> r101) {
        Intrinsics.checkNotNullParameter(r100, "configParams");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        BaseFunction<T, C> r102 = r101.create(r100);
        r102.setMParams(r100);
        return r102;
    }
}
