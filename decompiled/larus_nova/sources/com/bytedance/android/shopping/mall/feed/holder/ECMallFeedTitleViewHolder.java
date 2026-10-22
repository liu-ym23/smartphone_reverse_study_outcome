package com.bytedance.android.shopping.mall.feed.holder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallFeedTitleViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFeedTitleViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f177049o = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    public ECMallFeedTitleViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        super.b4(r100, r101, r102);
        View r103 = null;
        if ((r100 instanceof i93.a) == true) goto L5;
        r100 = null;
    L5:
        i93.a r104 = (i93.a) r100;
        if (r104 == null) goto L15;
        View r105 = this.itemView;
        if ((r105 instanceof TextView) == false) goto L11;
        r103 = r105;
    L11:
        TextView r106 = (TextView) r103;
        if (r106 == null) goto L16;
        r106.setText(r104.a());
        return;
    L16:
        return;
    }
}
