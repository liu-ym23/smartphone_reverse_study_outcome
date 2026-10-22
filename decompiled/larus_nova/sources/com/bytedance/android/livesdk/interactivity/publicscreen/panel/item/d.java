package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends b {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        return R.layout.ttlive_audience_panel_more;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        return true;
    }

    public d() {
        super(AudiencePanelItemSymbol.MORE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r100) {
        super.onClick(r100);
        v r101 = this.f138972d;
        if (r101 == null) goto L5;
        r101.l20(true);
    L5:
        com.bytedance.android.livesdk.interactivity.api.h r102 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r102 == null) goto L13;
        j<l> r103 = r102.getAudienceOperateManager();
        if (r103 == null) goto L14;
        l r104 = r103.getValue();
        if (r104 == null) goto L15;
        r104.c();
        return;
    L15:
        return;
    L14:
        return;
    }
}
