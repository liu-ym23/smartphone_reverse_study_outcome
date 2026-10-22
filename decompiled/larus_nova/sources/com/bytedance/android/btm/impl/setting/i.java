package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/i;", "", "", "isSdkError", "I", "d", "()I", "", "Lcom/bytedance/android/btm/impl/setting/k;", "rating", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "reportToQualityPlatform", "b", "uploadAlog", "c", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class i {

    @SerializedName("sdk_error")
    private final int isSdkError;

    @SerializedName("rating")
    private final List<k> rating;

    @SerializedName("report_to_quality_platform")
    private final int reportToQualityPlatform;

    @SerializedName("upload_alog")
    private final int uploadAlog;

    public i() {
        this.rating = CollectionsKt.emptyList();
    }

    public final List<k> a() {
        return this.rating;
    }

    public final int b() {
        return this.reportToQualityPlatform;
    }

    public final int c() {
        return this.uploadAlog;
    }

    public final int d() {
        return this.isSdkError;
    }
}
