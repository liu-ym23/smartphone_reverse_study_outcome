package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: classes45.dex */
public class a extends b implements IAudienceGameDataService {
    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService
    public long getCurrentGameId() {
        AudienceGameContext r100 = (AudienceGameContext) com.bytedance.live.datacontext.d.e(InteractGameContext.CONTEXT_KEY, AudienceGameContext.class);
        if (r100 == null) goto L9;
        n<r> r101 = r100.getCurrentGame();
        if (r101 == null) goto L9;
        r r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.p();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService
    public String getCurrentGameName() {
        AudienceGameContext r100 = (AudienceGameContext) com.bytedance.live.datacontext.d.e(InteractGameContext.CONTEXT_KEY, AudienceGameContext.class);
        if (r100 == null) goto L10;
        n<r> r101 = r100.getCurrentGame();
        if (r101 == null) goto L10;
        r r102 = r101.getValue();
        if (r102 == null) goto L10;
        String r103 = r102.q();
        if (r103 == null) goto L10;
        return r103;
    L10:
        return "";
    }

    public a() {
    }
}
