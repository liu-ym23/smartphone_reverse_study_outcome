package com.bytedance.android.window.shop.innerflow.holder.factory;

import android.app.Activity;
import com.bytedance.android.ec.window.base.utils.quick.d;
import com.bytedance.android.window.shop.innerflow.holder.ECWindowInnerFlowVideoPlayBackHolder;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vp.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/window/shop/innerflow/holder/ECWindowInnerFlowVideoPlayBackHolder;", "p1", "Landroid/app/Activity;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopInnerFlowHolderFactory$holderGenerators$3 extends FunctionReferenceImpl implements Function1<Activity, ECWindowInnerFlowVideoPlayBackHolder> {
    public ECShopInnerFlowHolderFactory$holderGenerators$3(a r100) {
        super(1, r100, a.class, "createInnerFlowVideoPlayBackHolder", "createInnerFlowVideoPlayBackHolder(Landroid/app/Activity;)Lcom/bytedance/android/window/shop/innerflow/holder/ECWindowInnerFlowVideoPlayBackHolder;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ECWindowInnerFlowVideoPlayBackHolder invoke2(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        QUIManager r101 = new QUIManager();
        c r102 = new c();
        d.a(r101, new bq3.d(a.a(r100, R.layout.ec_shop_layout_inner_flow_video_card), r102), r100, null);
        return new ECWindowInnerFlowVideoPlayBackHolder(r101, r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ECWindowInnerFlowVideoPlayBackHolder invoke(Activity r100) {
        return invoke2(r100);
    }
}
