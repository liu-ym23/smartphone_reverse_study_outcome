package com.bytedance.android.shopping.feed.view;

import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/widget/price/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/core/widget/price/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class InflowRedPacketView$bind$1 extends Lambda implements Function1<com.bytedance.android.ec.core.widget.price.a, Unit> {
    final /* synthetic */ String $availableAmount;

    public InflowRedPacketView$bind$1(String r100) {
        this.$availableAmount = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.ec.core.widget.price.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.f46127d = Long.valueOf((long) (CastFloatProtector.parseFloat(this.$availableAmount) * 100));
        r100.f46132i = true;
        r100.f46145v = "元";
        r100.f46130g = 1.0f;
        r100.f46131h = true;
        int r101 = this.$availableAmount.length();
        if (r101 != 1) goto L5;
        int r102 = UnitExtensionKt.dp2px(18);
    L15:
        float r103 = r102;
    L16:
        r100.f46126c = r103;
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = UnitExtensionKt.dp2px(16);
        goto L15
    L7:
        if (r101 != 3) goto L9;
        r102 = UnitExtensionKt.dp2px(14);
        goto L15
    L9:
        if (r101 == 4) goto L11;
        r103 = 12.0f;
        goto L16
    L11:
        r102 = UnitExtensionKt.dp2px(12);
        goto L15
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.ec.core.widget.price.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
