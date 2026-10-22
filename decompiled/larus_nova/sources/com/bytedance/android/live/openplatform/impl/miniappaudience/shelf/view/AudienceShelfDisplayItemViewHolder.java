package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.utils.b;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qq0.k;
import rq0.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/view/AudienceShelfDisplayItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayItemViewHolder;", "Lrq0/a;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceShelfDisplayItemViewHolder extends CommonShelfDisplayItemViewHolder<a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f84984k;

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean X3() {
        b r100 = b.f84002b;
        return b.f84002b.h();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Y3() {
        b r100 = b.f84002b;
        return b.f84002b.i();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Z3() {
        b r100 = b.f84002b;
        return b.f84002b.e();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean T3(com.bytedance.android.live.openplatform.api.model.shelf.a r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "cardInfo");
        return r101.f538918a.c(false);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String V3(com.bytedance.android.live.openplatform.api.model.shelf.a r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "cardInfo");
        return r101.c(null);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String W3(com.bytedance.android.live.openplatform.api.model.shelf.a r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "cardInfo");
        return r101.f538918a.j(true);
    }

    public AudienceShelfDisplayItemViewHolder(View r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f84984k = r101;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final void U3(CommonProductLabelLayout r100, com.bytedance.android.live.openplatform.api.model.shelf.a r101) {
        a r102 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "labelLayout");
        Intrinsics.checkNotNullParameter(r102, "cardInfo");
        Intrinsics.checkNotNullParameter(r102, "displayCardInfo");
        List<ProductLabelInfo> r103 = rq0.b.b(r102.f538918a, r102.f538919b);
        if ((!r103.isEmpty()) == false) goto L5;
        r100.r(r103);
        r100.setVisibility(0);
        return;
    L5:
        r100.setVisibility(8);
    }
}
