package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/DeviceStorageSettingSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/q;", "", "enable", "Z", "getEnable", "()Z", "", "", "rankArray", "Ljava/util/List;", "v0", "()Ljava/util/List;", "refreshInterval", "J", "L4", "()J", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DeviceStorageSettingSerializableObjectImpl implements q {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("rank_array")
    private final List<Long> rankArray;

    @SerializedName("refresh_interval")
    private final long refreshInterval;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/DeviceStorageSettingSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(DeviceStorageSettingSerializableObjectImpl.class);
        }
    }

    public DeviceStorageSettingSerializableObjectImpl() {
        this.enable = true;
        this.rankArray = com.bytedance.revenue.platform.api.core.c.a(new Long[]{100L, 500L, 50000L});
        this.refreshInterval = 0;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.q
    public final long L4() {
        return this.refreshInterval;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.q
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.q
    public final List<Long> v0() {
        return this.rankArray;
    }
}
