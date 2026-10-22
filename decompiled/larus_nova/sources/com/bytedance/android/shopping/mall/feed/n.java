package com.bytedance.android.shopping.mall.feed;

import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.mall.homepage.card.loadview.LoadingViewCardVH;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n extends com.bytedance.android.ec.hybrid.list.ability.p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECMallFeed.n f177151b;

    public static final class a implements LoadingViewCardVH.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f177152a;

        @Override // com.bytedance.android.shopping.mall.homepage.card.loadview.LoadingViewCardVH.b
        public final void a() {
            Integer r100 = this.f177152a.f177151b.f176704a.R;
            if (r100 == null) goto L6;
            int r101 = r100.intValue();
            ECMallFeed.t0(this.f177152a.f177151b.f176704a, r101, null, null, false, null, null, null, 254);
            return;
        }

        public a(n r100) {
            this.f177152a = r100;
        }
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.r0
    public final BaseViewHolder n(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        boolean r101 = LoadingViewCardVH.f178007q;
        ECHybridListContainer r102 = this.f177151b.f176704a.f176596z1;
        a r103 = new a(this);
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        o93.a r104 = new o93.a(r100, new com.bytedance.android.shopping.mall.homepage.card.loadview.a(r103));
        LoadingViewCardVH r105 = new LoadingViewCardVH(r104.f522469d, r102, r104);
        this.f177151b.f176704a.getClass();
        return r105;
    }

    public n(ECMallFeed.n r100, Class r101) {
        this.f177151b = r100;
        super(r101);
    }
}
