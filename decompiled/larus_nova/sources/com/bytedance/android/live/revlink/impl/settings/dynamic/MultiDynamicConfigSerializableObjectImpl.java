package com.bytedance.android.live.revlink.impl.settings.dynamic;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/dynamic/MultiDynamicConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/revlink/impl/settings/dynamic/c;", "", "hubLoadEnable", "Z", "I6", "()Z", "debugMode", "getDebugMode", "liveNativeControl", "N1", "feedHubLoadEnable", "R8", "feedNativeControl", "h7", "dynamicOffset", "s6", "", "dynamicUrl", "Ljava/lang/String;", "m8", "()Ljava/lang/String;", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiDynamicConfigSerializableObjectImpl implements c {

    @SerializedName("live_multi_pk_lynx_control_debug_mode")
    private final boolean debugMode;

    @SerializedName("live_multi_pk_dynamic_offset")
    private final boolean dynamicOffset;

    @SerializedName("live_multi_dynamic_hub_lynx_params")
    private final String dynamicUrl;

    @SerializedName("live_multi_preview_stream_support_dynamic_enable")
    private final boolean feedHubLoadEnable;

    @SerializedName("live_multi_preview_lynx_control_native_view_enable")
    private final boolean feedNativeControl;

    @SerializedName("live_multi_dynamic_hub_load_enable")
    private final boolean hubLoadEnable;

    @SerializedName("live_multi_lynx_control_native_view_enable")
    private final boolean liveNativeControl;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/dynamic/MultiDynamicConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(MultiDynamicConfigSerializableObjectImpl.class);
        }
    }

    public MultiDynamicConfigSerializableObjectImpl() {
        this.hubLoadEnable = true;
        this.debugMode = false;
        this.liveNativeControl = true;
        this.feedHubLoadEnable = false;
        this.feedNativeControl = false;
        this.dynamicOffset = false;
        this.dynamicUrl = LinkMultiDynamicSettingsKt.f97528b;
    }

    @Override // com.bytedance.android.live.revlink.impl.settings.dynamic.c
    public final boolean I6() {
        return this.hubLoadEnable;
    }

    @Override // com.bytedance.android.live.revlink.impl.settings.dynamic.c
    public final boolean N1() {
        return this.liveNativeControl;
    }

    @Override // com.bytedance.android.live.revlink.impl.settings.dynamic.c
    public final boolean R8() {
        return this.feedHubLoadEnable;
    }

    @Override // com.bytedance.android.live.revlink.impl.settings.dynamic.c
    public final boolean getDebugMode() {
        return this.debugMode;
    }

    @Override // com.bytedance.android.live.revlink.impl.settings.dynamic.c
    public final boolean h7() {
        return this.feedNativeControl;
    }

    @Override // com.bytedance.android.live.revlink.impl.settings.dynamic.c
    public final String m8() {
        return this.dynamicUrl;
    }

    @Override // com.bytedance.android.live.revlink.impl.settings.dynamic.c
    public final boolean s6() {
        return this.dynamicOffset;
    }
}
