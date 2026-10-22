package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.share.QQShare;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GameTagInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGameTagInfo;", "()V", "gameTagId", "", "getGameTagId", "()J", "gameTagName", "", "getGameTagName", "()Ljava/lang/String;", "isGame", "", "()I", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameTagInfo extends FlexModelBase<IGameTagInfo> implements IGameTagInfo, h {

    @SerializedName("game_tag_id")
    protected long gameTagId;

    @SerializedName(QQShare.SHARE_TO_QQ_GAME_TAG_NAME)
    protected String gameTagName;

    @SerializedName("is_game")
    protected int isGame;

    public GameTagInfo() {
        super(IGameTagInfo.class);
        this.gameTagName = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGameTagInfo
    public long getGameTagId() {
        return this.gameTagId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGameTagInfo
    public String getGameTagName() {
        return this.gameTagName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGameTagInfo
    public int isGame() {
        return this.isGame;
    }

    public GameTagInfo(g r100) {
        super(IGameTagInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isGame = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameTagId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.gameTagName = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.gameTagName != null) goto L31;
        this.gameTagName = "";
        return;
    }
}
