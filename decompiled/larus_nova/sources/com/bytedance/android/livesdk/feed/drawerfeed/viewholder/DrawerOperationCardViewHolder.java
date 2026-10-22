package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.config.ap;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerOperationCardViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerLynxViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerOperationCardViewHolder extends DrawerLynxViewHolder {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final float T3() {
        return 0.7619048f;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String W3() {
        return "operation_card";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String a4() {
        return "DrawerOperationCardViewHolder";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final int U3() {
        return ((this.f123916g.getMeasuredWidth() - 3) / 2) - 5;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final Object V3() {
        FeedItem r100 = this.f123914e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.operationCard;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String X3() {
        String r100 = ap.f119809a.getValue().getFallBackUri();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final String b4() {
        String r100 = ap.f119809a.getValue().getUri();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLynxViewHolder
    public final ViewGroup Z3() {
        return this.f123912c;
    }

    public DrawerOperationCardViewHolder(ViewGroup r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r100, r101);
    }
}
