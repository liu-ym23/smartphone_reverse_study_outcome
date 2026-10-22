package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f62426a;

    public h(g r100) {
        this.f62426a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        IInteractGameService r102 = (IInteractGameService) k.n(IInteractGameService.class);
        JSONObject r103 = new JSONObject();
        r103.put("app_data", this.f62426a.f62418d);
        Unit r104 = Unit.INSTANCE;
        r102.sendGameSeiData(GameSeiConstants.KEY_GAME_POD_MERGE_STREAM_SEI, r103.toString());
    }
}
