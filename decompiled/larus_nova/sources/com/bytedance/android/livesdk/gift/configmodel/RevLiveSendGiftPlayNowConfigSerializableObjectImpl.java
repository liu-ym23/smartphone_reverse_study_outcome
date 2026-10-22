package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveSendGiftPlayNowConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/g2;", "", "enable", "Z", "getEnable", "()Z", "sendLog", "J4", "sendTrace", "J3", "", "consumeDuration", "I", "S8", "()I", "failDuration", "s0", "", "", "supportGiftList", "Ljava/util/List;", "getSupportGiftList", "()Ljava/util/List;", "remoteSupportGiftList", "getRemoteSupportGiftList", "banGiftList", "getBanGiftList", "remoteEnable", "getRemoteEnable", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLiveSendGiftPlayNowConfigSerializableObjectImpl implements g2 {

    @SerializedName("ban_list")
    private final List<Long> banGiftList;

    @SerializedName("last_consume_duration")
    private final int consumeDuration;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("last_fail_duration")
    private final int failDuration;

    @SerializedName("remote_enable")
    private final boolean remoteEnable;

    @SerializedName("remote_list")
    private final List<Long> remoteSupportGiftList;

    @SerializedName("send_log")
    private final boolean sendLog;

    @SerializedName("send_trace")
    private final boolean sendTrace;

    @SerializedName("support_list")
    private final List<Long> supportGiftList;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveSendGiftPlayNowConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLiveSendGiftPlayNowConfigSerializableObjectImpl.class);
        }
    }

    public RevLiveSendGiftPlayNowConfigSerializableObjectImpl() {
        this.enable = false;
        this.sendLog = true;
        this.sendTrace = true;
        this.consumeDuration = 120;
        this.failDuration = 120;
        this.supportGiftList = com.bytedance.revenue.platform.api.core.c.a(new Long[]{3780L, 2114L, 3483L, 5633L, 3200L, 3729L, 4339L, 6951L, 3836L, 781L, 6763L, 6252L, 4480L, 6533L, 5524L, 5701L, 511L, 7080L, 5831L, 6024L, 5664L, 4723L, 6517L, 7081L, 789L, 6963L, 4639L, 3876L, 3878L, 3877L});
        this.remoteSupportGiftList = CollectionsKt.emptyList();
        this.banGiftList = CollectionsKt.emptyList();
        this.remoteEnable = true;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g2
    public final boolean J3() {
        return this.sendTrace;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g2
    public final boolean J4() {
        return this.sendLog;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g2
    public final int S8() {
        return this.consumeDuration;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g2
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g2
    public final int s0() {
        return this.failDuration;
    }
}
