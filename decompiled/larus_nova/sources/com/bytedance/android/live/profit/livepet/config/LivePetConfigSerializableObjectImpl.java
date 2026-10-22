package com.bytedance.android.live.profit.livepet.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import qu0.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/profit/livepet/config/LivePetConfigSerializableObjectImpl;", "Lqu0/a;", "", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "", "debugMode", "I", "getDebugMode", "()I", "setDebugMode", "(I)V", "", "", "Lcom/google/gson/JsonObject;", "petConfig", "Ljava/util/Map;", "D5", "()Ljava/util/Map;", "setPetConfig", "(Ljava/util/Map;)V", "giftConfig", "V", "setGiftConfig", "<init>", "()V", "Adapter", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePetConfigSerializableObjectImpl implements a {

    @SerializedName("debug_mode")
    private int debugMode;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("gift_config")
    private Map<String, JsonObject> giftConfig;

    @SerializedName("pet_config")
    private Map<String, JsonObject> petConfig;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/livepet/config/LivePetConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LivePetConfigSerializableObjectImpl.class);
        }
    }

    public LivePetConfigSerializableObjectImpl() {
        this.petConfig = d.b();
        this.giftConfig = d.b();
    }

    @Override // qu0.a
    public final Map<String, JsonObject> D5() {
        return this.petConfig;
    }

    @Override // qu0.a
    public final Map<String, JsonObject> V() {
        return this.giftConfig;
    }

    @Override // qu0.a
    public final int getDebugMode() {
        return this.debugMode;
    }

    @Override // qu0.a
    public final boolean getEnabled() {
        return this.enabled;
    }
}
