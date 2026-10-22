package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 3})
final class KIntroCardPresenter$bind$2 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ j this$0;

    public KIntroCardPresenter$bind$2(j r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = nh2.a.f519160a;
        Intrinsics.checkNotNullParameter(this.this$0.w().f(), "view");
        View r102 = this.this$0.w().f();
        r102.setFocusable(true);
        r102.sendAccessibilityEvent(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
