package com.bytedance.android.live.revenue.common;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, ce.f26396k, "", "d", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
final class HybridPropertyUtilsKt$GENERIC_ADAPTER$1 extends Lambda implements Function2<String, Object, Object> {
    final /* synthetic */ Class $cls;

    public HybridPropertyUtilsKt$GENERIC_ADAPTER$1(Class r100) {
        this.$cls = r100;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Object r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, ce.f26396k);
        String r102 = HybridPropertyUtilsKt.f90802a.getString(r100, null);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return GsonProtectorUtils.fromJson(GsonHelper.get(), r102, this.$cls);
    }
}
