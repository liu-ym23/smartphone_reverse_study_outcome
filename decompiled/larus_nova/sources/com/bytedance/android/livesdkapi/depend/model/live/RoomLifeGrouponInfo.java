package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.LifeGrouponInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomLifeGrouponInfo;", "", "()V", "aggCardId", "", "getAggCardId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dynamicUrl", "", "getDynamicUrl", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "lifeLivePackComponentConfig", "getLifeLivePackComponentConfig", "permissionStatus", "getPermissionStatus", "setPermissionStatus", "(Ljava/lang/Long;)V", "PermissionStatus", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomLifeGrouponInfo implements h {

    @SerializedName("agg_card_id")
    protected Long aggCardId;

    @SerializedName("dynamic_url")
    protected String dynamicUrl;

    @SerializedName("icon_url")
    protected String iconUrl;

    @IgnoreProtoFieldCheck
    @SerializedName("life_live_pack_component_config")
    protected String lifeLivePackComponentConfig;

    @SerializedName(LocationMonitorConst.PERMISSION_STATUS)
    protected Long permissionStatus;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomLifeGrouponInfo$PermissionStatus;", "", "()V", "HAS_PERMISSION", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PermissionStatus {
        public static final long HAS_PERMISSION = 1;
        public static final PermissionStatus INSTANCE = null;

        private PermissionStatus() {
        }

        static {
            INSTANCE = new PermissionStatus();
        }
    }

    public RoomLifeGrouponInfo() {
    }

    public final Long getAggCardId() {
        return this.aggCardId;
    }

    public final String getDynamicUrl() {
        return this.dynamicUrl;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getLifeLivePackComponentConfig() {
        return this.lifeLivePackComponentConfig;
    }

    public final Long getPermissionStatus() {
        return this.permissionStatus;
    }

    public RoomLifeGrouponInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.permissionStatus = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.aggCardId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.iconUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.dynamicUrl = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.lifeLivePackComponentConfig = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setPermissionStatus(Long r100) {
        this.permissionStatus = r100;
    }
}
