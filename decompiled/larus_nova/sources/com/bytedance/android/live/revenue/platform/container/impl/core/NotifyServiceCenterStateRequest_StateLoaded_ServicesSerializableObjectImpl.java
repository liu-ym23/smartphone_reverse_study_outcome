package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest_StateLoaded_ServicesSerializableObjectImpl;", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b$b;", "", "interfaceId", "Ljava/lang/String;", "T1", "()Ljava/lang/String;", "setInterfaceId", "(Ljava/lang/String;)V", "<init>", "()V", "Adapter", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NotifyServiceCenterStateRequest_StateLoaded_ServicesSerializableObjectImpl implements NotifyServiceCenterStateRequest.b.InterfaceC1404b {

    @SerializedName("interface_id")
    private String interfaceId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest_StateLoaded_ServicesSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(NotifyServiceCenterStateRequest_StateLoaded_ServicesSerializableObjectImpl.class);
        }
    }

    public NotifyServiceCenterStateRequest_StateLoaded_ServicesSerializableObjectImpl() {
        this.interfaceId = "";
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest.b.InterfaceC1404b
    public final String T1() {
        return this.interfaceId;
    }
}
