package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.LeaveResponse.UserInfoDuringLinkmic")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/UserInfoDuringLinkmic;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/u1;", "", "toString", "", "addFollowerCount", "J", "getAddFollowerCount", "()J", "setAddFollowerCount", "(J)V", "fanTicket", "Ljava/lang/String;", "getFanTicket", "()Ljava/lang/String;", "setFanTicket", "(Ljava/lang/String;)V", "scoreBeyond", "getScoreBeyond", "setScoreBeyond", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoDuringLinkmic extends FlexModelBase<u1> implements u1, vh7.h {

    @SerializedName("add_followers_count")
    protected long addFollowerCount;

    @SerializedName("add_fan_ticket_str")
    protected String fanTicket;

    @SerializedName("score_more_than")
    protected long scoreBeyond;

    public UserInfoDuringLinkmic() {
        super(u1.class);
    }

    public String toString() {
        return "UserInfoDuringLinkmic{addFollowerCount=" + getAddFollowerCount() + ", fanTicket='" + getFanTicket() + "', scoreBeyond=" + getScoreBeyond() + '}';
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.u1
    public long getAddFollowerCount() {
        return this.addFollowerCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.u1
    public String getFanTicket() {
        return this.fanTicket;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.u1
    public long getScoreBeyond() {
        return this.scoreBeyond;
    }

    public UserInfoDuringLinkmic(am3.g r100) {
        super(u1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.addFollowerCount = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.fanTicket = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.scoreBeyond = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.u1
    public void setAddFollowerCount(long r100) {
        this.addFollowerCount = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.u1
    public void setFanTicket(String r100) {
        this.fanTicket = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.u1
    public void setScoreBeyond(long r100) {
        this.scoreBeyond = r100;
    }
}
