package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelJumpOptSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/s0;", "", "preloadOpt", "Z", "q4", "()Z", "replaceEnterRequest", Keys.API_PARAM_KEY_M0, "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelJumpOptSerializableObjectImpl implements s0 {

    @SerializedName("preload_opt")
    private final boolean preloadOpt;

    @SerializedName("replace_enter")
    private final boolean replaceEnterRequest;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelJumpOptSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftPanelJumpOptSerializableObjectImpl.class);
        }
    }

    public GiftPanelJumpOptSerializableObjectImpl() {
        this.preloadOpt = false;
        this.replaceEnterRequest = false;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.s0
    public final boolean m0() {
        return this.replaceEnterRequest;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.s0
    public final boolean q4() {
        return this.preloadOpt;
    }
}
