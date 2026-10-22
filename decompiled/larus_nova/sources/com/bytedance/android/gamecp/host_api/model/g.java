package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.MiniPlayMeta")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/g;", "", "", "schema", "Ljava/lang/String;", "gameName", "icon", "gameId", "appId", "", "", "_supportLiveScene", "Ljava/util/List;", "version", "", "gameType", "I", "developer", "extra", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class g implements vh7.h {

    @SerializedName("support_live_scene")
    protected List<Long> _supportLiveScene;

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

    @SerializedName("version")
    public String version;

    public g() {
    }

    public final List<Integer> a() {
        List<Long> r100 = this._supportLiveScene;
        if (r100 == null) goto L8;
        List<Long> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        r102.add(Integer.valueOf((int) ((Number) r103.next()).longValue()));
        goto L6
    L11:
        return r102;
    L8:
        return null;
    }

    public g(am3.g r100) {
        this._supportLiveScene = new ArrayList();
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
        this._supportLiveScene.add(Long.valueOf(r100.j()));
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
