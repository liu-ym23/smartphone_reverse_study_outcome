package com.obric.appstore.network.entity;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/appstore/network/entity/AppInfoResp;", "", "appInfo", "Lcom/obric/appstore/network/entity/CommonAppEntity;", "(Lcom/obric/appstore/network/entity/CommonAppEntity;)V", "getAppInfo", "()Lcom/obric/appstore/network/entity/CommonAppEntity;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class AppInfoResp {

    @SerializedName(ServerElements.APP_INFO)
    @Nullable
    private final CommonAppEntity appInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInfoResp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final CommonAppEntity getAppInfo() {
        return this.appInfo;
    }

    public AppInfoResp(@Nullable CommonAppEntity r10) {
        this.appInfo = r10;
    }

    public /* synthetic */ AppInfoResp(CommonAppEntity r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
