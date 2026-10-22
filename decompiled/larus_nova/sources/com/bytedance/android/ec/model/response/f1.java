package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/response/f1;", "", "", "surveyId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "surveyTitle", "getSurveyTitle", "surveyUrl", "b", "", "Lcom/bytedance/android/ec/model/response/r1;", "surveyOptions", "Ljava/util/List;", "getSurveyOptions", "()Ljava/util/List;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class f1 {

    @SerializedName("survey_id")
    private final String surveyId;

    @SerializedName("survey_options")
    private final List<r1> surveyOptions;

    @SerializedName("survey_title")
    private final String surveyTitle;

    @SerializedName("survey_url")
    private final String surveyUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f1) == false) goto L14;
        f1 r101 = (f1) r100;
        if (Intrinsics.areEqual(this.surveyId, r101.surveyId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.surveyTitle, r101.surveyTitle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.surveyUrl, r101.surveyUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.surveyOptions, r101.surveyOptions) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.surveyId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.surveyTitle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.surveyUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<r1> r110 = this.surveyOptions;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "PromotionProductCommentSurveyDTO(surveyId=" + this.surveyId + ", surveyTitle=" + this.surveyTitle + ", surveyUrl=" + this.surveyUrl + ", surveyOptions=" + this.surveyOptions + ")";
    }

    public f1() {
        this.surveyId = null;
        this.surveyTitle = null;
        this.surveyUrl = null;
        this.surveyOptions = null;
    }

    public final String a() {
        return this.surveyId;
    }

    public final String b() {
        return this.surveyUrl;
    }
}
