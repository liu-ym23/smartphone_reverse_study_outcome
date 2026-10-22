package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lvg3/z;", "", AbsMethodDelegate.TAG_INVOKE, "(Lvg3/z;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class TopRightControlsComponent$handlerReportWithMeta$1$1 extends Lambda implements Function1<vg3.z, Unit> {
    public static final TopRightControlsComponent$handlerReportWithMeta$1$1 INSTANCE = null;

    static {
        INSTANCE = new TopRightControlsComponent$handlerReportWithMeta$1$1();
    }

    public TopRightControlsComponent$handlerReportWithMeta$1$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(vg3.z r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r100, "product_detail_report_icon_click", true, null, null, 12);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(vg3.z r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
