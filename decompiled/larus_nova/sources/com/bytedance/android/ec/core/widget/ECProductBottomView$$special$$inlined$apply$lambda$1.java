package com.bytedance.android.ec.core.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/widget/price/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/core/widget/price/a;)V", "com/bytedance/android/ec/core/widget/ECProductBottomView$bindData$5$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECProductBottomView$$special$$inlined$apply$lambda$1 extends Lambda implements Function1<com.bytedance.android.ec.core.widget.price.a, Unit> {
    final /* synthetic */ com.bytedance.android.ec.model.response.t $item$inlined;

    public ECProductBottomView$$special$$inlined$apply$lambda$1(com.bytedance.android.ec.model.response.t r100) {
        this.$item$inlined = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.ec.core.widget.price.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.f46127d = Long.valueOf(this.$item$inlined.b());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.ec.core.widget.price.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
