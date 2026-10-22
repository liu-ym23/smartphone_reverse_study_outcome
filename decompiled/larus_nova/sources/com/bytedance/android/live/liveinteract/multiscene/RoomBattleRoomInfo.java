package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleRoomInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/d;", "", "toString", "", "joinStatus", "I", "getJoinStatus", "()I", "setJoinStatus", "(I)V", "", "startOperatorUserId", "Ljava/lang/Long;", "getStartOperatorUserId", "()Ljava/lang/Long;", "setStartOperatorUserId", "(Ljava/lang/Long;)V", "startOperatorOpenId", "Ljava/lang/String;", "getStartOperatorOpenId", "()Ljava/lang/String;", "setStartOperatorOpenId", "(Ljava/lang/String;)V", "getStartOperatorUserIdString", "startOperatorUserIdString", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomBattleRoomInfo extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("join_status")
    protected int joinStatus;

    @SerializedName("start_operator_open_id")
    protected String startOperatorOpenId;

    @IgnoreProtoFieldCheck
    @SerializedName("start_operator_user_id")
    protected Long startOperatorUserId;

    public RoomBattleRoomInfo() {
        super(d.class);
        this.joinStatus = RoomJoinStatus.UNKNOWN.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.d
    public String getStartOperatorUserIdString() {
        o0.a r100 = o0.f58946a;
        Long r101 = this.startOperatorUserId;
        String r102 = this.startOperatorOpenId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public String toString() {
        return "RoomBattleRoomInfo(joinStatus=" + getJoinStatus() + ", startOperatorUserId=" + getStartOperatorUserIdString() + ')';
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.d
    public int getJoinStatus() {
        return this.joinStatus;
    }

    public final String getStartOperatorOpenId() {
        return this.startOperatorOpenId;
    }

    public final Long getStartOperatorUserId() {
        return this.startOperatorUserId;
    }

    public RoomBattleRoomInfo(am3.g r100) {
        super(d.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 2) goto L8;
        this.joinStatus = r100.i();
        r101 = r101 | true;
        goto L3
    L8:
        if (r103 != 3) goto L10;
        this.startOperatorUserId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r103 != 5000) goto L11;
        this.startOperatorOpenId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        setThreadSafe(true);
        if ((true & r101) == true) goto L31;
        this.joinStatus = RoomJoinStatus.UNKNOWN.getValue();
        return;
    }

    public void setJoinStatus(int r100) {
        this.joinStatus = r100;
    }

    public final void setStartOperatorOpenId(String r100) {
        this.startOperatorOpenId = r100;
    }

    public final void setStartOperatorUserId(Long r100) {
        this.startOperatorUserId = r100;
    }
}
