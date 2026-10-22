package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/f;", "", "", "", "methods", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/h;", "checkPoints", "b", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/b;", "appendInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class f {

    @SerializedName(EventConstants.ExtraJson.APPEND_INFO)
    private final List<b> appendInfo;

    @SerializedName("check_points")
    private final List<h> checkPoints;

    @SerializedName("methods")
    private final List<String> methods;

    public f() {
        this.methods = CollectionsKt.emptyList();
        this.checkPoints = CollectionsKt.emptyList();
        this.appendInfo = CollectionsKt.emptyList();
    }

    public final List<b> a() {
        return this.appendInfo;
    }

    public final List<h> b() {
        return this.checkPoints;
    }

    public final List<String> c() {
        return this.methods;
    }
}
