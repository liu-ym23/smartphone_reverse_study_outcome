package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import kotlin.Metadata;
import r11.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkEnterRoomOptConfigSerializableObjectImpl;", "Lr11/a;", "", "syncLoadControlWidget", "Z", "Y5", "()Z", "preloadLinkmicList", "q5", "delayLoadLinkWidget", DevicePlans.DEVICE_PLAN_VIVO4, "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkEnterRoomOptConfigSerializableObjectImpl implements a {

    @SerializedName("delay_load_link_widget")
    private final boolean delayLoadLinkWidget;

    @SerializedName("preload_linkmic_list")
    private final boolean preloadLinkmicList;

    @SerializedName("sync_load_control_widget")
    private final boolean syncLoadControlWidget;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkEnterRoomOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AnchorLinkEnterRoomOptConfigSerializableObjectImpl.class);
        }
    }

    public AnchorLinkEnterRoomOptConfigSerializableObjectImpl() {
        this.syncLoadControlWidget = true;
        this.preloadLinkmicList = true;
        this.delayLoadLinkWidget = false;
    }

    @Override // r11.a
    public final boolean Y5() {
        return this.syncLoadControlWidget;
    }

    @Override // r11.a
    public final boolean q5() {
        return this.preloadLinkmicList;
    }

    @Override // r11.a
    public final boolean v4() {
        return this.delayLoadLinkWidget;
    }
}
