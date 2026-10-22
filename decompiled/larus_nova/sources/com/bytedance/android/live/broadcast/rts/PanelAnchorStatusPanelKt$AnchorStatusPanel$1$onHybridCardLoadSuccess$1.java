package com.bytedance.android.live.broadcast.rts;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.rts.foundation.u;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0 $actvieTabIndex;
    final /* synthetic */ Ref.BooleanRef $didHybridCardLoadSuccess;
    final /* synthetic */ Function3 $onTabSelected;
    final /* synthetic */ Ref.BooleanRef $panelDataLoaded;
    final /* synthetic */ d $props;
    final /* synthetic */ Function1 $setActiveTabIndex;
    final /* synthetic */ Ref.ObjectRef $switchTabTimer;
    final /* synthetic */ Function0 $tabs;

    public PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1(Ref.BooleanRef r100, Ref.BooleanRef r101, d r102, Function0 r103, Ref.ObjectRef r104, Function0 r105, Function1 r106, Function3 r107) {
        this.$didHybridCardLoadSuccess = r100;
        this.$panelDataLoaded = r101;
        this.$props = r102;
        this.$tabs = r103;
        this.$switchTabTimer = r104;
        this.$actvieTabIndex = r105;
        this.$setActiveTabIndex = r106;
        this.$onTabSelected = r107;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Ref.BooleanRef r100 = this.$didHybridCardLoadSuccess;
        if (r100.element == false) goto L6;
        int r101 = k.f59219a;
        k.a.a("Failed to process onHybridCardLoadSuccess: already succeeded before.");
        return;
    L6:
        r100.element = true;
        int r102 = k.f59219a;
        k.a.b("AnchorStatusHybridCard loaded successfully.");
        this.$panelDataLoaded.element = true;
        String r103 = this.$props.f59193c;
        if (r103 == null) goto L18;
        int r104 = f.f59206a;
        Intrinsics.checkNotNull(r103);
        if (f.a.a(r103) == true) goto L19;
        final Ref.IntRef r105 = new Ref.IntRef();
        r105.element = com.bytedance.rts.foundation.j.c((ArrayList) this.$tabs.invoke(), new PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1$index$1(this));
        final String r106 = this.$props.f59193c;
        Intrinsics.checkNotNull(r106);
        if (r105.element >= 0) goto L13;
        k.a.a("Can't find tab for key: " + r106 + ", use index 0");
        r105.element = 0;
    L13:
        k.a.b("Set active tab index: for key: " + r106 + ", index: " + r105.element);
        T r107 = this.$switchTabTimer.element;
        if (r107 == 0) goto L16;
        Intrinsics.checkNotNull(r107);
        u.b(r107);
        this.$switchTabTimer.element = null;
    L16:
        new PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1$doSwitchTab$1(this, r105, r106).invoke();
        return;
    L19:
        return;
    }
}
