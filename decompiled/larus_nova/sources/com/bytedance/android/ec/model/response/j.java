package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/response/j;", "", "", "Lcom/bytedance/android/ec/model/response/i;", "subOptions", "Ljava/util/List;", "getSubOptions", "()Ljava/util/List;", "", "showInput", "Ljava/lang/Boolean;", "getShowInput", "()Ljava/lang/Boolean;", "", "inputBackgroundContent", "Ljava/lang/String;", "getInputBackgroundContent", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("input_background_content")
    private final String inputBackgroundContent;

    @SerializedName("show_input")
    private final Boolean showInput;

    @SerializedName("sub_options")
    private final List<i> subOptions;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.subOptions, r101.subOptions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showInput, r101.showInput) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.inputBackgroundContent, r101.inputBackgroundContent) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<i> r100 = this.subOptions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showInput;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.inputBackgroundContent;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentSurveySubOptionConfig(subOptions=" + this.subOptions + ", showInput=" + this.showInput + ", inputBackgroundContent=" + this.inputBackgroundContent + ")";
    }

    public j() {
        this.subOptions = null;
        this.showInput = null;
        this.inputBackgroundContent = null;
    }
}
