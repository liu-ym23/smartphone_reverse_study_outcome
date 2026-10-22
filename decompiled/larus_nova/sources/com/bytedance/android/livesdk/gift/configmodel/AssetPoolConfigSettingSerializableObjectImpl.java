package com.bytedance.android.livesdk.gift.configmodel;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetPoolConfigSettingSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/g;", "", "redLinePoolSize", "I", "U7", "()I", "poolSize", "getPoolSize", "", "onceRemoveSize", "J", "i5", "()J", "poolExpireTime", "d5", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetPoolConfigSettingSerializableObjectImpl implements g {

    @SerializedName("pool_remove_once_size")
    private final long onceRemoveSize;

    @SerializedName("pool_expire_time")
    private final long poolExpireTime;

    @SerializedName("pool_size")
    private final int poolSize;

    @SerializedName("red_line_pool_size")
    private final int redLinePoolSize;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetPoolConfigSettingSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AssetPoolConfigSettingSerializableObjectImpl.class);
        }
    }

    public AssetPoolConfigSettingSerializableObjectImpl() {
        this.redLinePoolSize = BmLocated.ALIGN_RIGHT_BOTTOM;
        this.poolSize = 20480;
        this.onceRemoveSize = 20480;
        this.poolExpireTime = 60;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g
    public final int U7() {
        return this.redLinePoolSize;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g
    public final long d5() {
        return this.poolExpireTime;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g
    public final int getPoolSize() {
        return this.poolSize;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.g
    public final long i5() {
        return this.onceRemoveSize;
    }
}
