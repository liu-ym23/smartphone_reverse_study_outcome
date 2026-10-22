package com.bytedance.android.livesdkapi.model.gamecp;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.MiniPlayMeta")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/gamecp/MiniPlayMeta;", "", "()V", "appId", "", "developer", "extra", "gameId", "gameName", "gameType", "", "icon", "schema", "supportLiveScene", "", "", "version", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniPlayMeta implements h {

    @SerializedName("app_id")
    public String appId;

    @SerializedName("developer")
    public String developer;

    @SerializedName("extra")
    public String extra;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
    public int gameType;

    @SerializedName("icon")
    public String icon;

    @SerializedName("schema")
    public String schema;

    @SerializedName("support_live_scene")
    public List<Long> supportLiveScene;

    @SerializedName("version")
    public String version;

    public MiniPlayMeta() {
    }

    public MiniPlayMeta(g r100) {
        this.supportLiveScene = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.extra = am3.h.c(r100);
        goto L3
    L8:
        this.developer = am3.h.c(r100);
        goto L3
    L9:
        this.gameType = r100.i();
        goto L3
    L10:
        this.version = am3.h.c(r100);
        goto L3
    L11:
        this.supportLiveScene.add(Long.valueOf(r100.j()));
        goto L3
    L12:
        this.appId = am3.h.c(r100);
        goto L3
    L13:
        this.gameId = am3.h.c(r100);
        goto L3
    L14:
        this.icon = am3.h.c(r100);
        goto L3
    L15:
        this.gameName = am3.h.c(r100);
        goto L3
    L16:
        this.schema = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
    }
}
