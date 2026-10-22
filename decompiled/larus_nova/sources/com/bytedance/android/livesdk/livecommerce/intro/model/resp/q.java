package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q;", "", "", "carouselTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroElasticMultiElementTitle;", "data", "Ljava/util/List;", "b", "()Ljava/util/List;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("carousel_time")
    private final long carouselTime;

    @SerializedName("data")
    private final List<IntroElasticMultiElementTitle> data;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (this.carouselTime == r101.carouselTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.carouselTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<IntroElasticMultiElementTitle> r102 = this.data;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "IntroElasticTitleContent(carouselTime=" + this.carouselTime + ", data=" + this.data + ")";
    }

    public q() {
        this.carouselTime = 0;
        this.data = null;
    }

    public final long a() {
        return this.carouselTime;
    }

    public final List<IntroElasticMultiElementTitle> b() {
        return this.data;
    }
}
