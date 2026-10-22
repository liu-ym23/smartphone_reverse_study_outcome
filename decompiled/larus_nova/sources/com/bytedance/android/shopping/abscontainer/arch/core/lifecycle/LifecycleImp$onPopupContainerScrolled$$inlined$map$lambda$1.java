package com.bytedance.android.shopping.abscontainer.arch.core.lifecycle;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/abscontainer/arch/core/lifecycle/LifecycleImp$onPopupContainerScrolled$executeList$1$1"}, k = 3, mv = {1, 4, 3})
final class LifecycleImp$onPopupContainerScrolled$$inlined$map$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RecyclerView $body$inlined;
    final /* synthetic */ int $dx$inlined;
    final /* synthetic */ int $dy$inlined;
    final /* synthetic */ s33.b $module;
    final /* synthetic */ String $popupCode$inlined;

    public LifecycleImp$onPopupContainerScrolled$$inlined$map$lambda$1(s33.b r100, String r101, RecyclerView r102, int r103, int r104) {
        this.$module = r100;
        this.$popupCode$inlined = r101;
        this.$body$inlined = r102;
        this.$dx$inlined = r103;
        this.$dy$inlined = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$module.s(this.$popupCode$inlined, this.$body$inlined, this.$dy$inlined);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
