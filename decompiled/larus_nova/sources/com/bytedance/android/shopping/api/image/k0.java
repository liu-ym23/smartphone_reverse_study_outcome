package com.bytedance.android.shopping.api.image;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\tR>\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/image/k0;", "Lcom/bytedance/android/shopping/api/image/x;", "Lcom/bytedance/android/shopping/api/image/w;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "targetServiceId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "targetTemplateName", "d", "customParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "finalParams", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "matchersType", ce.f26391f, "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class k0 implements x, w, d.b {

    @SerializedName("custom_params")
    private final List<String> customParams;

    @SerializedName("final_params")
    private final HashMap<String, Object> finalParams;

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("contents")
    private final List<d> supportMather;

    @SerializedName("target_service_id")
    private final String targetServiceId;

    @SerializedName("target_template")
    private final String targetTemplateName;

    public k0() {
        this(null, null, null, null, null, null, null);
    }

    public final int hashCode() {
        List<d> r100 = this.supportMather;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.targetServiceId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.targetTemplateName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.customParams;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        HashMap<String, Object> r113 = this.finalParams;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.matchersType;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.ignoreMatch;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "ReplaceSpecialResizeTmplModel(supportMather=" + this.supportMather + ", targetServiceId=" + this.targetServiceId + ", targetTemplateName=" + this.targetTemplateName + ", customParams=" + this.customParams + ", finalParams=" + this.finalParams + ", matchersType=" + this.matchersType + ", ignoreMatch=" + this.ignoreMatch + ")";
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final List<String> a() {
        return this.customParams;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String b() {
        return this.targetServiceId;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final Boolean c() {
        return this.ignoreMatch;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String d() {
        return this.targetTemplateName;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final List<d> e() {
        return this.supportMather;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final HashMap<String, Object> f() {
        return this.finalParams;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final String g() {
        return this.matchersType;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k0) == false) goto L20;
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.supportMather, r101.supportMather) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetServiceId, r101.targetServiceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.targetTemplateName, r101.targetTemplateName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customParams, r101.customParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.finalParams, r101.finalParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.matchersType, r101.matchersType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ignoreMatch, r101.ignoreMatch) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public static k0 h(k0 r100, HashMap r101) {
        return new k0(r100.supportMather, r100.targetServiceId, r100.targetTemplateName, r100.customParams, r101, r100.matchersType, r100.ignoreMatch);
    }

    public k0(List<d> r100, String r101, String r102, List<String> r103, HashMap<String, Object> r104, String r105, Boolean r106) {
        this.supportMather = r100;
        this.targetServiceId = r101;
        this.targetTemplateName = r102;
        this.customParams = r103;
        this.finalParams = r104;
        this.matchersType = r105;
        this.ignoreMatch = r106;
    }
}
