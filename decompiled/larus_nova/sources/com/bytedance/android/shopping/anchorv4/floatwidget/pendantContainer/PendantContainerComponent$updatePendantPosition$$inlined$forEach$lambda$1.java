package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import android.view.View;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantContainerComponent$updatePendantPosition$1$1$2", "com/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantContainerComponent$$special$$inlined$lets$lambda$1"}, k = 3, mv = {1, 4, 3})
final class PendantContainerComponent$updatePendantPosition$$inlined$forEach$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Integer $bottomMargin$inlined;
    final /* synthetic */ Integer $leftMargin$inlined;
    final /* synthetic */ View $lynxView;
    final /* synthetic */ String $pendantId$inlined;
    final /* synthetic */ Integer $rightMargin$inlined;
    final /* synthetic */ Integer $topMargin$inlined;
    final /* synthetic */ e this$0;

    public PendantContainerComponent$updatePendantPosition$$inlined$forEach$lambda$1(View r100, e r101, String r102, Integer r103, Integer r104, Integer r105, Integer r106) {
        this.$lynxView = r100;
        this.this$0 = r101;
        this.$pendantId$inlined = r102;
        this.$bottomMargin$inlined = r103;
        this.$leftMargin$inlined = r104;
        this.$topMargin$inlined = r105;
        this.$rightMargin$inlined = r106;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d2.a(this.$lynxView, this.$bottomMargin$inlined.intValue());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
