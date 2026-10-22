package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/GuestBattleConfigContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/interact/model/u;", "", "toString", "", "is_anchor_involved", "J", "()J", "set_anchor_involved", "(J)V", "last_battle_duration_by_anchor", "getLast_battle_duration_by_anchor", "setLast_battle_duration_by_anchor", "loserNum", "getLoserNum", "setLoserNum", "", "scoreType", "I", "getScoreType", "()I", "setScoreType", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuestBattleConfigContent extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("is_anchor_involved")
    protected long is_anchor_involved;

    @SerializedName("last_battle_duration_by_anchor")
    protected long last_battle_duration_by_anchor;

    @SerializedName("loser_num")
    protected long loserNum;

    @SerializedName("score_type")
    protected int scoreType;

    public GuestBattleConfigContent() {
        super(u.class);
    }

    public String toString() {
        return "GuestBattleUpdateSettingResponse{loserNum=" + getLoserNum() + ", is_anchor_involved=" + is_anchor_involved() + ", last_battle_duration_by_anchor=" + getLast_battle_duration_by_anchor() + ", score_type=" + getScoreType() + '}';
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public long getLast_battle_duration_by_anchor() {
        return this.last_battle_duration_by_anchor;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public long getLoserNum() {
        return this.loserNum;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public int getScoreType() {
        return this.scoreType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public long is_anchor_involved() {
        return this.is_anchor_involved;
    }

    public GuestBattleConfigContent(am3.g r100) {
        super(u.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.is_anchor_involved = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.last_battle_duration_by_anchor = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.loserNum = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.scoreType = (int) r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public void setLast_battle_duration_by_anchor(long r100) {
        this.last_battle_duration_by_anchor = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public void setLoserNum(long r100) {
        this.loserNum = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public void setScoreType(int r100) {
        this.scoreType = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.u
    public void set_anchor_involved(long r100) {
        this.is_anchor_involved = r100;
    }
}
