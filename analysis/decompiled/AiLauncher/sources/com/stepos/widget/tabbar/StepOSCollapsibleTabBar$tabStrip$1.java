package com.stepos.widget.tabbar;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class StepOSCollapsibleTabBar$tabStrip$1 extends FunctionReferenceImpl implements InterfaceC5074l<StepOSCollapsibleTab, t> {
    public StepOSCollapsibleTabBar$tabStrip$1(Object obj) {
        super(1, obj, StepOSCollapsibleTabBar.class, "onTabClicked", "onTabClicked(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ t invoke(StepOSCollapsibleTab stepOSCollapsibleTab) {
        invoke2(stepOSCollapsibleTab);
        return t.f7040a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StepOSCollapsibleTab p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((StepOSCollapsibleTabBar) this.receiver).onTabClicked(p02);
    }
}
