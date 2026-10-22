package com.bytedance.android.live.revenuelink.connect.params;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import d11.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerPermitParamsSerializableObjectImpl;", "Ld11/k;", "", RemoteMessageConst.Notification.CHANNEL_ID, "J", "getChannelId", "()J", "setChannelId", "(J)V", "permitStatus", "Z3", "l7", "roomId", "getRoomId", "setRoomId", "applyUserId", "getApplyUserId", "setApplyUserId", "", "secApplyUserId", "Ljava/lang/String;", "j7", "()Ljava/lang/String;", "D6", "(Ljava/lang/String;)V", "scene", "getScene", "setScene", "signExtra", "getSignExtra", "setSignExtra", "applyOpenId", "Z0", "k4", "<init>", "()V", "Adapter", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ServerPermitParamsSerializableObjectImpl implements k {

    @SerializedName("apply_open_id")
    private String applyOpenId;

    @SerializedName("apply_user_id")
    private long applyUserId;

    @SerializedName("channel_id")
    private long channelId;

    @SerializedName("permit_status")
    private long permitStatus;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("scene")
    private long scene;

    @SerializedName("sec_apply_user_id")
    private String secApplyUserId;

    @SerializedName("sign_extra")
    private String signExtra;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerPermitParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ServerPermitParamsSerializableObjectImpl.class);
        }
    }

    public ServerPermitParamsSerializableObjectImpl() {
        this.secApplyUserId = "";
        this.signExtra = "";
        this.applyOpenId = "";
    }

    @Override // d11.k
    public final String Z0() {
        return this.applyOpenId;
    }

    @Override // d11.k
    public final long Z3() {
        return this.permitStatus;
    }

    @Override // d11.k
    public final long getChannelId() {
        return this.channelId;
    }

    @Override // d11.k
    public final long getRoomId() {
        return this.roomId;
    }

    @Override // d11.k
    public final long getScene() {
        return this.scene;
    }

    @Override // d11.k
    public final String j7() {
        return this.secApplyUserId;
    }

    @Override // d11.k
    public final void D6(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secApplyUserId = r100;
    }

    @Override // d11.k
    public final void k4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.applyOpenId = r100;
    }

    @Override // d11.k
    public final void l7(long r100) {
        this.permitStatus = r100;
    }

    @Override // d11.k
    public final void setChannelId(long r100) {
        this.channelId = r100;
    }

    @Override // d11.k
    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    @Override // d11.k
    public final void setScene(long r100) {
        this.scene = r100;
    }
}
