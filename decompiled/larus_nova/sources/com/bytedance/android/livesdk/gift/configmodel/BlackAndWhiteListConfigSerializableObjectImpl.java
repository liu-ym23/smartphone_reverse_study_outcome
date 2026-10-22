package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/BlackAndWhiteListConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/k;", "", "enable", "Z", "getEnable", "()Z", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "J", "getExpireTime", "()J", "", "length", "I", "getLength", "()I", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BlackAndWhiteListConfigSerializableObjectImpl implements k {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("expire_time")
    private final long expireTime;

    @SerializedName("length")
    private final int length;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/BlackAndWhiteListConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(BlackAndWhiteListConfigSerializableObjectImpl.class);
        }
    }

    public BlackAndWhiteListConfigSerializableObjectImpl() {
        this.enable = true;
        this.expireTime = 10000;
        this.length = 10;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.k
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.k
    public final long getExpireTime() {
        return this.expireTime;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.k
    public final int getLength() {
        return this.length;
    }
}
