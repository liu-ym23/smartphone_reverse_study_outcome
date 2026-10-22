package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.LinkmicProfitRoomEggInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicProfitRoomEggInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/z9;", "", Keys.API_EVENT_KEY_PLAY_MODE, "I", "getPlayMode", "()I", "setPlayMode", "(I)V", "Lcom/bytedance/android/livesdk/message/model/TeamfightEggInfo;", "teamfightEggInfo", "Lcom/bytedance/android/livesdk/message/model/TeamfightEggInfo;", "getTeamfightEggInfo", "()Lcom/bytedance/android/livesdk/message/model/TeamfightEggInfo;", "setTeamfightEggInfo", "(Lcom/bytedance/android/livesdk/message/model/TeamfightEggInfo;)V", "", "version", "J", "getVersion", "()J", "setVersion", "(J)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicProfitRoomEggInfo extends FlexModelBase<z9> implements z9, vh7.h {

    @SerializedName(FastStartLiveConfig.PLAY_MODE)
    protected int playMode;

    @SerializedName("teamfight_egg_info")
    protected TeamfightEggInfo teamfightEggInfo;

    @SerializedName("version")
    protected long version;

    public LinkmicProfitRoomEggInfo() {
        super(z9.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.z9
    public /* bridge */ /* synthetic */ yb getTeamfightEggInfo() {
        return getTeamfightEggInfo();
    }

    @Override // com.bytedance.android.livesdk.message.model.z9
    public int getPlayMode() {
        return this.playMode;
    }

    @Override // com.bytedance.android.livesdk.message.model.z9
    public long getVersion() {
        return this.version;
    }

    @Override // com.bytedance.android.livesdk.message.model.z9
    public TeamfightEggInfo getTeamfightEggInfo() {
        return this.teamfightEggInfo;
    }

    public LinkmicProfitRoomEggInfo(am3.g r100) {
        super(z9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.playMode = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.teamfightEggInfo = new TeamfightEggInfo(r100);
        goto L3
    L10:
        if (r102 != 255) goto L11;
        this.version = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setPlayMode(int r100) {
        this.playMode = r100;
    }

    public void setTeamfightEggInfo(TeamfightEggInfo r100) {
        this.teamfightEggInfo = r100;
    }

    public void setVersion(long r100) {
        this.version = r100;
    }
}
