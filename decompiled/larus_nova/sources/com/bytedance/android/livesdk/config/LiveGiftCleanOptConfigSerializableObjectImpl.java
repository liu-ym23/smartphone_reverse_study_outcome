package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveGiftCleanOptConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/v31;", "", "enable", "Z", "getEnable", "()Z", "enableChangeUseTime", "q1", "<init>", "()V", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveGiftCleanOptConfigSerializableObjectImpl implements v31 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_change_use_time")
    private final boolean enableChangeUseTime;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveGiftCleanOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveGiftCleanOptConfigSerializableObjectImpl.class);
        }
    }

    public LiveGiftCleanOptConfigSerializableObjectImpl() {
        this.enable = false;
        this.enableChangeUseTime = false;
    }

    @Override // com.bytedance.android.livesdk.config.v31
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.config.v31
    public final boolean q1() {
        return this.enableChangeUseTime;
    }
}
