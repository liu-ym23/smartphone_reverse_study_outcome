package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3;

import a20.e;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.larus.nova.R;
import f10.f;
import g20.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/delegate/v3/OpenFeatureTabListItemDebugModeViewHolder;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/delegate/v3/OpenFeatureTabListItemViewHolderV3;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureTabListItemDebugModeViewHolder extends OpenFeatureTabListItemViewHolderV3 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f61669n;

    public OpenFeatureTabListItemDebugModeViewHolder(View r100, e r101, OpenFeatureIconCallbackFrom r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "callbackFrom");
        super(r100, r101, r102);
        this.f61669n = (TextView) r100.findViewById(R.id.feature_debug_btn);
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemViewHolderV3
    public final void U3(TextView r100, HSImageView r101, View r102, LinearLayout r103, View r104, e r105, f r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "nameView");
        Intrinsics.checkNotNullParameter(r101, "iconView");
        Intrinsics.checkNotNullParameter(r102, "actionView");
        Intrinsics.checkNotNullParameter(r103, "labelLayout");
        Intrinsics.checkNotNullParameter(r104, "itemView");
        Intrinsics.checkNotNullParameter(r106, MapController.ITEM_LAYER_TAG);
        super.U3(r100, r101, r102, r103, r104, r105, r106, r107);
        TextView r108 = this.f61669n;
        if (r108 == null) goto L5;
        r108.setTag("debug_button");
    L5:
        TextView r109 = this.f61669n;
        if (r109 == null) goto L8;
        r109.setOnClickListener(new d(this, r105, r106, r107));
    L8:
        String r110 = r106.D.extra;
        if (r110 != null) goto L49;
    L16:
        String r111 = "调试";
    L18:
        if (r111.length() <= 0) goto L20;
        boolean r112 = true;
    L21:
        if (r112 == false) goto L26;
        TextView r113 = this.f61669n;
        if (r113 == null) goto L26;
        r113.setText(r111);
    L26:
        if (r106.f475043u == false) goto L39;
        TextView r114 = this.f61669n;
        if (r114 == null) goto L30;
        r114.setVisibility(0);
    L30:
        TextView r115 = this.f61678h;
        if (r115 == null) goto L33;
        r115.setAlpha(1.0f);
    L33:
        TextView r116 = this.f61678h;
        if (r116 == null) goto L36;
        r116.setTextColor(s1.h(R.color.black));
    L36:
        TextView r117 = this.f61678h;
        if (r117 == null) goto L51;
        r117.setBackground(s1.m(R.drawable.ttlive_feature_btn_debug_bg));
        return;
    L51:
        return;
    L39:
        TextView r118 = this.f61669n;
        if (r118 == null) goto L42;
        r118.setVisibility(8);
    L42:
        TextView r119 = this.f61678h;
        if (r119 == null) goto L45;
        r119.setTextColor(s1.h(R.color.white));
    L45:
        TextView r120 = this.f61678h;
        if (r120 == null) goto L53;
        r120.setBackground(s1.m(R.drawable.ttlive_feature_start_btn_bg));
        return;
    L53:
        return;
    L20:
        r112 = false;
        goto L21
    L49:
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L12
        JSONObject r121 = LiveSeiUtil.c(r110).optJSONObject("debug_button");     // Catch: Exception -> L12
    L13:
        if (r121 == null) goto L16;
        r111 = r121.optString("text");
        if (r111 != null) goto L18;
    L12:
        r121 = null;
        goto L13
    }
}
