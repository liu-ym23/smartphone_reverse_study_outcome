package com.bytedance.android.live.revenue.common;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ce.f26396k, "", BaseSwitches.V, AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Ljava/lang/Object;)V"}, k = 3, mv = {1, 5, 1})
final class HybridPropertyUtilsKt$GENERIC_ADAPTER$2 extends Lambda implements Function2<String, Object, Unit> {
    public static final HybridPropertyUtilsKt$GENERIC_ADAPTER$2 INSTANCE = null;

    static {
        INSTANCE = new HybridPropertyUtilsKt$GENERIC_ADAPTER$2();
    }

    public HybridPropertyUtilsKt$GENERIC_ADAPTER$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, ce.f26396k);
        HybridPropertyUtilsKt.f90802a.edit().putString(r100, GsonProtectorUtils.toJson(GsonHelper.get(), r101)).apply();
    }
}
