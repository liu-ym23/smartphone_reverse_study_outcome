package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECRedPacketResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "expireDuration", "Ljava/lang/Long;", "getExpireDuration", "()Ljava/lang/Long;", "setExpireDuration", "(Ljava/lang/Long;)V", "", "redPacketOverlap", "I", "getRedPacketOverlap", "()I", "setRedPacketOverlap", "(I)V", "Lcom/bytedance/android/livesdk/livecommerce/network/response/RedPacket;", "redPacket", "Lcom/bytedance/android/livesdk/livecommerce/network/response/RedPacket;", "getRedPacket", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/RedPacket;", "setRedPacket", "(Lcom/bytedance/android/livesdk/livecommerce/network/response/RedPacket;)V", "serverTime", "getServerTime", "setServerTime", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECRedPacketResponse extends g implements Serializable {

    @SerializedName("expire_duration")
    private Long expireDuration;

    @SerializedName("redpack")
    private RedPacket redPacket;

    @SerializedName("redpack_overlap")
    private int redPacketOverlap;

    @SerializedName("server_time")
    private Long serverTime;

    public ECRedPacketResponse() {
    }

    public final Long getExpireDuration() {
        return this.expireDuration;
    }

    public final RedPacket getRedPacket() {
        return this.redPacket;
    }

    public final int getRedPacketOverlap() {
        return this.redPacketOverlap;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final void setExpireDuration(Long r100) {
        this.expireDuration = r100;
    }

    public final void setRedPacket(RedPacket r100) {
        this.redPacket = r100;
    }

    public final void setRedPacketOverlap(int r100) {
        this.redPacketOverlap = r100;
    }

    public final void setServerTime(Long r100) {
        this.serverTime = r100;
    }
}
