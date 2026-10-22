package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.LeaveResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LeaveChannelResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/g1;", "", "toString", "", "controlType", "I", "getControlType", "()I", "setControlType", "(I)V", "", "totalApplyNum", "J", "getTotalApplyNum", "()J", "setTotalApplyNum", "(J)V", "totalLinkedNum", "getTotalLinkedNum", "setTotalLinkedNum", "paid_count", "getPaid_count", "setPaid_count", "link_duration", "getLink_duration", "setLink_duration", "Lcom/bytedance/android/livesdk/chatroom/model/u1;", "userInfoDuringLinkmic", "Lcom/bytedance/android/livesdk/chatroom/model/u1;", "getUserInfoDuringLinkmic", "()Lcom/bytedance/android/livesdk/chatroom/model/u1;", "setUserInfoDuringLinkmic", "(Lcom/bytedance/android/livesdk/chatroom/model/u1;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LeaveChannelResponse extends FlexModelBase<g1> implements g1, vh7.h {

    @SerializedName("control_type")
    protected int controlType;

    @SerializedName("link_duration")
    protected long link_duration;

    @SerializedName("paid_count")
    protected long paid_count;

    @SerializedName("total_apply")
    protected long totalApplyNum;

    @SerializedName("total_linked")
    protected long totalLinkedNum;

    @SerializedName("userinfo_during_linkmic")
    protected u1 userInfoDuringLinkmic;

    public LeaveChannelResponse() {
        super(g1.class);
    }

    public String toString() {
        return "LeaveChannelResponse{controlType=" + getControlType() + ", totalApplyNum=" + getTotalApplyNum() + ", totalLinkedNum=" + getTotalLinkedNum() + ", paid_count=" + getPaid_count() + ", link_duration=" + getLink_duration() + ", userInfoDuringLinkmic=" + getUserInfoDuringLinkmic() + '}';
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public int getControlType() {
        return this.controlType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public long getLink_duration() {
        return this.link_duration;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public long getPaid_count() {
        return this.paid_count;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public long getTotalApplyNum() {
        return this.totalApplyNum;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public long getTotalLinkedNum() {
        return this.totalLinkedNum;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public u1 getUserInfoDuringLinkmic() {
        return this.userInfoDuringLinkmic;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdk.chatroom.model.u1, java.lang.Object] */
    public LeaveChannelResponse(am3.g r100) {
        super(g1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 10) goto L7;
        this.controlType = r100.i();
        goto L3
    L7:
        switch(r102) {
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            default: goto L8;
        };
    L9:
        this.userInfoDuringLinkmic = vh7.f.a(r100, u1.class);
        goto L3
    L10:
        this.link_duration = r100.j();
        goto L3
    L11:
        this.paid_count = r100.j();
        goto L3
    L12:
        this.totalLinkedNum = r100.j();
        goto L3
    L13:
        this.totalApplyNum = r100.j();
        goto L3
    L8:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public void setControlType(int r100) {
        this.controlType = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public void setLink_duration(long r100) {
        this.link_duration = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public void setPaid_count(long r100) {
        this.paid_count = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public void setTotalApplyNum(long r100) {
        this.totalApplyNum = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public void setTotalLinkedNum(long r100) {
        this.totalLinkedNum = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.g1
    public void setUserInfoDuringLinkmic(u1 r100) {
        this.userInfoDuringLinkmic = r100;
    }
}
