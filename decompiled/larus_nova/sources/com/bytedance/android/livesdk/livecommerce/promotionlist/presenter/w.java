package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class w implements com.bytedance.android.livesdk.livecommerce.eventcenter.ability.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePromotionListListingPresenter f151056a;

    public w(LivePromotionListListingPresenter r100) {
        this.f151056a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.ability.b
    public final void a(sl.q r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        LivePromotionListListingPresenter r101 = this.f151056a;
        if (r101.f150968m == null) goto L32;
        PromotionLinearLayoutManager r102 = r101.f150967l;
        if (r102 == null) goto L35;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L9:
        int r103 = r102.findFirstVisibleItemPosition();
        int r104 = LivePromotionListListingPresenter.i0(this.f151056a).findLastVisibleItemPosition();
        List<ql.a> r105 = this.f151056a.d0().getTotalPromotions();
        Iterator<ql.a> r106 = r105.iterator();
        boolean r107 = false;
        int r108 = 0;
    L11:
        if (r106.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(r106.next().getPromotionId(), r100.c()) == true) goto L17;
        r108 = r108 + 1;
    L17:
        Integer r109 = Integer.valueOf(r108);
        if (r109.intValue() < 0) goto L20;
        r107 = true;
    L20:
        if (r107 == true) goto L23;
        r109 = null;
    L23:
        if (r109 == null) goto L33;
        int r110 = r109.intValue() + (LivePromotionListListingPresenter.h0(this.f151056a).f150888c ? 1 : 0);
        if (r103 > r110) goto L36;
        if (r104 <= r110) goto L34;
        ((ql.a) ListProtector.get(r105, r110)).getClientData().f533696e = r100;
        LivePromotionListListingPresenter.l0(this.f151056a, CollectionsKt.listOf(new cf.x(r110, UpdateLocalViewType.UPDATE_ALL)));
        return;
    L34:
        return;
    L36:
        return;
    L33:
        return;
    L16:
        r108 = -1;
        goto L17
    L35:
        return;
    }
}
