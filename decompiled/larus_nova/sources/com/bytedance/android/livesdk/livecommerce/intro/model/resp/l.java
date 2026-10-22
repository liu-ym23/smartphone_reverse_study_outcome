package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/p0;", "lineBenefits", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "carouselInterval", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("carousel_interval")
    private final long carouselInterval;

    @SerializedName("line_benefits")
    private final List<p0> lineBenefits;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.lineBenefits, r101.lineBenefits) == true) goto L8;
        return false;
    L8:
        if (this.carouselInterval == r101.carouselInterval) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<p0> r100 = this.lineBenefits;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.carouselInterval;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroCarouselBenefits(lineBenefits=" + this.lineBenefits + ", carouselInterval=" + this.carouselInterval + ")";
    }

    public l() {
        this.lineBenefits = null;
        this.carouselInterval = 0;
    }

    public final long a() {
        return this.carouselInterval;
    }

    public final List<p0> b() {
        return this.lineBenefits;
    }
}
