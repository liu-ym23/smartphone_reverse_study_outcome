package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/appstore/network/entity/UpdateAppInfoResp;", "Lcom/obric/appstore/network/entity/AppInfoResp;", "appInfo", "Lcom/obric/appstore/network/entity/CommonAppEntity;", "autoUpdateInfo", "Lcom/obric/appstore/network/entity/AutoUpdateInfo;", "(Lcom/obric/appstore/network/entity/CommonAppEntity;Lcom/obric/appstore/network/entity/AutoUpdateInfo;)V", "getAutoUpdateInfo", "()Lcom/obric/appstore/network/entity/AutoUpdateInfo;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpdateAppInfoResp extends AppInfoResp {

    @SerializedName("auto_update_info")
    @Nullable
    private final AutoUpdateInfo autoUpdateInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateAppInfoResp() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final AutoUpdateInfo getAutoUpdateInfo() {
        return this.autoUpdateInfo;
    }

    public /* synthetic */ UpdateAppInfoResp(CommonAppEntity r10, AutoUpdateInfo r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }

    public UpdateAppInfoResp(@Nullable CommonAppEntity r10, @Nullable AutoUpdateInfo r11) {
        super(r10);
        this.autoUpdateInfo = r11;
    }
}
