package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECShopTopMarqueeUDSlidePresenter this$0;

    public ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1(ECShopTopMarqueeUDSlidePresenter r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ECShopTopMarqueeUDSlidePresenter r100 = this.this$0;
        int r101 = ECShopTopMarqueeUDSlidePresenter.I;
        r100.getClass();
        ECShopTopMarqueeUDSlidePresenter r102 = this.this$0;
        r102.E++;
        View r103 = r102.f184064u;
        if (r103 == null) goto L6;
        ECShopTopMarqueeUDSlidePresenter.q0(r102, 0, -r103.getHeight(), this.this$0.H);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
