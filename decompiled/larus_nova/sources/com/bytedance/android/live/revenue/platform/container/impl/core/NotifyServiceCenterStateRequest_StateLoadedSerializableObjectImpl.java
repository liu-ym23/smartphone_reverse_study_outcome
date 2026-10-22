package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest_StateLoadedSerializableObjectImpl;", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b;", "", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b$b;", PromotionProductPrivilegesStruct.SERVICES, "Ljava/util/List;", "getServices", "()Ljava/util/List;", "setServices", "(Ljava/util/List;)V", "<init>", "()V", "Adapter", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NotifyServiceCenterStateRequest_StateLoadedSerializableObjectImpl implements NotifyServiceCenterStateRequest.b {

    @SerializedName(PromotionProductPrivilegesStruct.SERVICES)
    private List<? extends NotifyServiceCenterStateRequest.b.InterfaceC1404b> services;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest_StateLoadedSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(NotifyServiceCenterStateRequest_StateLoadedSerializableObjectImpl.class);
        }
    }

    public NotifyServiceCenterStateRequest_StateLoadedSerializableObjectImpl() {
        this.services = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest.b
    public final List<NotifyServiceCenterStateRequest.b.InterfaceC1404b> getServices() {
        return this.services;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest.b
    public final void setServices(List<? extends NotifyServiceCenterStateRequest.b.InterfaceC1404b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.services = r100;
    }
}
