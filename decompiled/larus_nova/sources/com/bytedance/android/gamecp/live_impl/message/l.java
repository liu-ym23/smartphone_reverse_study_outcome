package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.PlayDebugEntranceGame")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/l;", "", "", "gameId", "Ljava/lang/String;", "gameName", "", "Lcom/bytedance/android/gamecp/live_impl/message/n;", "gameList", "Ljava/util/List;", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("play_panel_url_list")
    public List<n> gameList;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    public l() {
        this.gameId = "";
        this.gameName = "";
        this.gameList = new ArrayList();
    }

    public l(am3.g r100) {
        this.gameList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.gameId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.gameList.add(new n(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.gameId != null) goto L19;
        this.gameId = "";
    L19:
        if (this.gameName != null) goto L22;
        this.gameName = "";
    L22:
        if (this.gameList.isEmpty() == false) goto L37;
        this.gameList = new ArrayList();
        return;
    }
}
