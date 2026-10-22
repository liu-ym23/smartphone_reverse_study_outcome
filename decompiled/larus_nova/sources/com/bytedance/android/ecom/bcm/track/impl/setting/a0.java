package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/a0;", "", "", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/c;", "deepLinkBcmKey", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/y;", "urlLocationPath", "b", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class a0 {

    @SerializedName("deeplink_bcm_key_and_location")
    private final List<c> deepLinkBcmKey;

    @SerializedName("webview_url_location_list")
    private final List<y> urlLocationPath;

    public a0() {
        this.deepLinkBcmKey = CollectionsKt.emptyList();
        this.urlLocationPath = CollectionsKt.emptyList();
    }

    public final List<c> a() {
        return this.deepLinkBcmKey;
    }

    public final List<y> b() {
        return this.urlLocationPath;
    }
}
