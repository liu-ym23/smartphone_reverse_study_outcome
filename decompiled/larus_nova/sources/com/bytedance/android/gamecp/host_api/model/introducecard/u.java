package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.RemindIntroduce")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/u;", "", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "gameIcon", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "", "gameId", "Ljava/lang/String;", "content", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u implements vh7.h {

    @SerializedName("content")
    public String content;

    @SerializedName("game_icon")
    public GameImageBundler gameIcon;

    @SerializedName("game_id")
    public String gameId;

    public u() {
    }

    public u(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.gameId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameIcon = new GameImageBundler(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.content = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
