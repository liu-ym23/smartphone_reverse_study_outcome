package com.bytedance.android.live.saas.middleware.base;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0003J!\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", ExifInterface.GPS_DIRECTION_TRUE, "C", "", "create", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "conf", "(Ljava/lang/Object;)Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface IConfiguration<T, C> {
    BaseFunction<T, C> create(C r100);
}
