package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/View;", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListRootPresenter$initLinkMicStyle$2 extends FunctionReferenceImpl implements Function1<Integer, View> {
    public LivePromotionListRootPresenter$initLinkMicStyle$2(LivePromotionListRootPresenter r100) {
        super(1, r100, LivePromotionListRootPresenter.class, "getPageView", "getPageView(I)Landroid/view/View;", 0);
    }

    public final View invoke(int r100) {
        LivePromotionListRootPresenter r101 = (LivePromotionListRootPresenter) this.receiver;
        if (r100 != 0) goto L9;
        View r102 = r101.f150988l;
        if (r102 == null) goto L8;
        return r102;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L9:
        int r103 = LivePromotionListRootPresenter.f150985t;
        return r101.j0();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ View invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
