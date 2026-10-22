package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/model/response/p0;", "", "Lcom/bytedance/android/ec/model/response/PromotionBenefitType;", "benefitType", "Lcom/bytedance/android/ec/model/response/PromotionBenefitType;", "b", "()Lcom/bytedance/android/ec/model/response/PromotionBenefitType;", "setBenefitType", "(Lcom/bytedance/android/ec/model/response/PromotionBenefitType;)V", "Lcom/bytedance/android/ec/model/response/b0;", "elasticTitle", "Lcom/bytedance/android/ec/model/response/b0;", "d", "()Lcom/bytedance/android/ec/model/response/b0;", "setElasticTitle", "(Lcom/bytedance/android/ec/model/response/b0;)V", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tag", "Ljava/util/List;", "f", "()Ljava/util/List;", "setTag", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "benefitLabel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBenefitLabel", "Lcom/bytedance/android/ec/model/response/o0;", "progressBar", "Lcom/bytedance/android/ec/model/response/o0;", "e", "()Lcom/bytedance/android/ec/model/response/o0;", "setProgressBar", "(Lcom/bytedance/android/ec/model/response/o0;)V", "customTag", "c", "setCustomTag", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("benefit_label")
    private List<PromotionBenefitLabel> benefitLabel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE)
    private PromotionBenefitType benefitType;

    @SerializedName("custom_tag")
    private List<ECRitTag> customTag;

    @SerializedName("elastic_title")
    private b0 elasticTitle;

    @SerializedName("progress_bar")
    private o0 progressBar;

    @SerializedName("tag")
    private List<ECRitTag> tag;

    public p0() {
    }

    public final List<PromotionBenefitLabel> a() {
        return this.benefitLabel;
    }

    public final PromotionBenefitType b() {
        return this.benefitType;
    }

    public final List<ECRitTag> c() {
        return this.customTag;
    }

    public final b0 d() {
        return this.elasticTitle;
    }

    public final o0 e() {
        return this.progressBar;
    }

    public final List<ECRitTag> f() {
        return this.tag;
    }
}
