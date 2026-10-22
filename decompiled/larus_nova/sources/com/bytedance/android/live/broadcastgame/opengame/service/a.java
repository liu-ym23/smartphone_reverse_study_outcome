package com.bytedance.android.live.broadcastgame.opengame.service;

import android.view.View;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceMiniGameIntroCardService f60993a;

    public a(AudienceMiniGameIntroCardService r100) {
        this.f60993a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r101 = AudienceGameContext.a.a();
        if (r101 == null) goto L7;
        n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r102 = r101.getGameIntroCardInfo();
        if (r102 == null) goto L7;
        com.bytedance.android.live.broadcastgame.api.openplatform.a r103 = r102.getValue();
    L8:
        com.bytedance.android.live.broadcastgame.api.openplatform.a r104 = r103;
        if (r104 == null) goto L11;
        int r105 = r104.f59402k;
    L12:
        int r106 = r105 + 1;
        if (r104 == null) goto L19;
        AudienceGameContext r107 = AudienceGameContext.a.a();
        if (r107 == null) goto L19;
        n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r108 = r107.getGameIntroCardInfo();
        if (r108 == null) goto L19;
        r108.setValue(com.bytedance.android.live.broadcastgame.api.openplatform.a.a(r104, null, null, null, r106, NewToolbarButtonConstants.TOOLBAR_ANCHOR_MORE_ADD_PICTURE));
    L19:
        AudienceMiniGameIntroCardService.a(this.f60993a, true, false, 2);
        return;
    L11:
        r105 = 0;
    L7:
        r103 = null;
        goto L8
    }
}
