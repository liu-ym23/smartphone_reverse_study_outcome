package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemNormalVH;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemBaseVH;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractPanelItemNormalVH extends LinkPKAudienceInteractPanelItemBaseVH {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f81976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f81977b;

    public LinkPKAudienceInteractPanelItemNormalVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f81976a = (HSImageView) this.itemView.findViewById(R.id.panel_action_btn);
        this.f81977b = (TextView) this.itemView.findViewById(R.id.panel_action_text);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemBaseVH
    public final void T3(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelItem");
        this.f81977b.setText(r100.d());
        if (r100.c() <= 0) goto L5;
        this.f81976a.setActualImageResource(r100.c());
    L6:
        this.f81976a.setOnClickListener(x0.a(new LinkPKAudienceInteractPanelItemNormalVH$bind$1(r100)));
        return;
    L5:
        Intrinsics.checkNotNullParameter(this.f81976a, "icon");
        goto L6
    }
}
