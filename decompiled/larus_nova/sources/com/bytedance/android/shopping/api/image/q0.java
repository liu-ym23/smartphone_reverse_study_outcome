package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R>\u0010\n\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\t8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/image/q0;", "", "", "", "customParams", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "finalParams", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "", "isOriginImage", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "tmplType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class q0 implements x {

    @SerializedName("custom_params")
    private final List<String> customParams;

    @SerializedName("final_params")
    private final HashMap<String, Object> finalParams;

    @SerializedName("is_origin_image")
    private final Boolean isOriginImage;

    @SerializedName("tmpl_type")
    private final String tmplType;

    public q0() {
        this(null, null, null, null);
    }

    public final int hashCode() {
        List<String> r100 = this.customParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashMap<String, Object> r104 = this.finalParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isOriginImage;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.tmplType;
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
        return "TmplModel(customParams=" + this.customParams + ", finalParams=" + this.finalParams + ", isOriginImage=" + this.isOriginImage + ", tmplType=" + this.tmplType + ")";
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final List<String> a() {
        return this.customParams;
    }

    public final String c() {
        return this.tmplType;
    }

    public final Boolean d() {
        return this.isOriginImage;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final HashMap<String, Object> f() {
        return this.finalParams;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q0) == false) goto L14;
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.customParams, r101.customParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.finalParams, r101.finalParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isOriginImage, r101.isOriginImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tmplType, r101.tmplType) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public static q0 b(q0 r100, HashMap r101) {
        return new q0(r100.customParams, r101, r100.isOriginImage, r100.tmplType);
    }

    public q0(List<String> r100, HashMap<String, Object> r101, Boolean r102, String r103) {
        this.customParams = r100;
        this.finalParams = r101;
        this.isOriginImage = r102;
        this.tmplType = r103;
    }
}
