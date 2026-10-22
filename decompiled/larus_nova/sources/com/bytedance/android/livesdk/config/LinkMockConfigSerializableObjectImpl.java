package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/LinkMockConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/t01;", "", "isEnableMockLiveClientInitFailed", "Z", "e4", "()Z", "isEnableMockRtcClientInitFailed", "U", "isEnableMockRtcStartFailed", "c4", "isEnableMockPermissionCheckFailed", "L5", "<init>", "()V", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMockConfigSerializableObjectImpl implements t01 {

    @SerializedName("enable_mock_live_client_init_failed")
    private final boolean isEnableMockLiveClientInitFailed;

    @SerializedName("enable_mock_permission_check_failed")
    private final boolean isEnableMockPermissionCheckFailed;

    @SerializedName("enable_mock_rtc_client_init_failed")
    private final boolean isEnableMockRtcClientInitFailed;

    @SerializedName("enable_mock_rtc_client_start_failed")
    private final boolean isEnableMockRtcStartFailed;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/LinkMockConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkMockConfigSerializableObjectImpl.class);
        }
    }

    public LinkMockConfigSerializableObjectImpl() {
        this.isEnableMockLiveClientInitFailed = false;
        this.isEnableMockRtcClientInitFailed = false;
        this.isEnableMockRtcStartFailed = false;
        this.isEnableMockPermissionCheckFailed = false;
    }

    @Override // com.bytedance.android.livesdk.config.t01
    public final boolean L5() {
        return this.isEnableMockPermissionCheckFailed;
    }

    @Override // com.bytedance.android.livesdk.config.t01
    public final boolean U() {
        return this.isEnableMockRtcClientInitFailed;
    }

    @Override // com.bytedance.android.livesdk.config.t01
    public final boolean c4() {
        return this.isEnableMockRtcStartFailed;
    }

    @Override // com.bytedance.android.livesdk.config.t01
    public final boolean e4() {
        return this.isEnableMockLiveClientInitFailed;
    }
}
