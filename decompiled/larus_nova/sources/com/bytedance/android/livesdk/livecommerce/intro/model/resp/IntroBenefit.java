package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroBenefit;", "", "", "benefitType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s;", "elasticTitle", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s;", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tag", "Ljava/util/List;", "f", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "benefitLabel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i0;", "progressBar", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i0;", "e", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i0;", "customTag", "c", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroBenefit {

    @SerializedName("benefit_label")
    private final List<PromotionBenefitLabel> benefitLabel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE)
    private final Integer benefitType;

    @SerializedName("custom_tag")
    private final List<ECRitTag> customTag;

    @SerializedName("elastic_title")
    private final s elasticTitle;

    @SerializedName("progress_bar")
    private final i0 progressBar;

    @SerializedName("tag")
    private final List<ECRitTag> tag;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroBenefit$Companion$IntroBenefitType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroBenefitType {
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IntroBenefit) == false) goto L18;
        IntroBenefit r101 = (IntroBenefit) r100;
        if (Intrinsics.areEqual(this.benefitType, r101.benefitType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.elasticTitle, r101.elasticTitle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.benefitLabel, r101.benefitLabel) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.progressBar, r101.progressBar) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.customTag, r101.customTag) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.benefitType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        s r104 = this.elasticTitle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<ECRitTag> r107 = this.tag;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<PromotionBenefitLabel> r110 = this.benefitLabel;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        i0 r113 = this.progressBar;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<ECRitTag> r116 = this.customTag;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroBenefit(benefitType=" + this.benefitType + ", elasticTitle=" + this.elasticTitle + ", tag=" + this.tag + ", benefitLabel=" + this.benefitLabel + ", progressBar=" + this.progressBar + ", customTag=" + this.customTag + ")";
    }

    public IntroBenefit() {
        this.benefitType = null;
        this.elasticTitle = null;
        this.tag = null;
        this.benefitLabel = null;
        this.progressBar = null;
        this.customTag = null;
    }

    public final List<PromotionBenefitLabel> a() {
        return this.benefitLabel;
    }

    public final Integer b() {
        return this.benefitType;
    }

    public final List<ECRitTag> c() {
        return this.customTag;
    }

    public final s d() {
        return this.elasticTitle;
    }

    public final i0 e() {
        return this.progressBar;
    }

    public final List<ECRitTag> f() {
        return this.tag;
    }
}
