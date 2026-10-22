package com.android.ttcjpaysdk.base.settings.bean;

import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/KeepDialogStandard;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "scheme", "", "fallback_wait_time_millis", "(Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KeepDialogStandard implements CJPayObject, Serializable {
    public String fallback_wait_time_millis;
    public String scheme;

    /* JADX WARN: Multi-variable type inference failed */
    public KeepDialogStandard() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public KeepDialogStandard(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallback_wait_time_millis");
        this.scheme = r100;
        this.fallback_wait_time_millis = r101;
    }

    public /* synthetic */ KeepDialogStandard(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "sslocal://webcast_lynxview?type=popup&url=https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/fe_lynx_cashdesk_dynamic/retain-dialog-20240325.js&hide_nav_bar=1&trans_status_bar=1&height_percent=100&width_percent=100&open_animate=0&forbid_right_back=1&loader_name=forest";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = AMap3DTileBuildType.HOUSING;
    L8:
        this(r100, r101);
    }
}
