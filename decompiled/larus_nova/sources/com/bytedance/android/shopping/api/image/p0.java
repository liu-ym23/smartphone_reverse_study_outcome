package com.bytedance.android.shopping.api.image;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR:\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R:\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R:\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u0001`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/api/image/p0;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "imgFormats", "Ljava/util/HashSet;", "d", "()Ljava/util/HashSet;", "alphaFormats", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/HashMap;", "Lcom/bytedance/android/shopping/api/image/g0;", "Lkotlin/collections/HashMap;", "originTemplates", "Ljava/util/HashMap;", "e", "()Ljava/util/HashMap;", "", "Lcom/bytedance/android/shopping/api/image/i0;", "replaceObjTemplates", "Ljava/util/List;", "h", "()Ljava/util/List;", "replaceEmptyTemplates", "f", "Lcom/bytedance/android/shopping/api/image/j0;", "replaceOldTemplates", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/shopping/api/image/k0;", "replaceSpecialResizeTemplates", ce.f26395j, "Lcom/bytedance/android/shopping/api/image/q0;", "ecCommonTemplates", "b", "Lcom/bytedance/android/shopping/api/image/g;", "replaceFormats", ce.f26391f, "Lcom/bytedance/android/shopping/api/image/h0;", "replaceQuality", "getReplaceQuality", "", "enableUnifiedFlag", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("img_alpha_formats")
    private final HashSet<String> alphaFormats;

    @SerializedName("ec_common_templates")
    private final HashMap<String, q0> ecCommonTemplates;

    @SerializedName("enable_unified_flag")
    private final Boolean enableUnifiedFlag;

    @SerializedName("img_static_formats")
    private final HashSet<String> imgFormats;

    @SerializedName("origin_templates")
    private final HashMap<String, g0> originTemplates;

    @SerializedName("replace_empty_templates")
    private final List<i0> replaceEmptyTemplates;

    @SerializedName("replace_format")
    private final List<g> replaceFormats;

    @SerializedName("replace_obj_templates")
    private final List<i0> replaceObjTemplates;

    @SerializedName("replace_old_templates")
    private final HashMap<String, j0> replaceOldTemplates;

    @SerializedName("replace_quality")
    private final List<h0> replaceQuality;

    @SerializedName("replace_special_resize_templates")
    private final List<k0> replaceSpecialResizeTemplates;

    public p0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == false) goto L28;
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.imgFormats, r101.imgFormats) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.alphaFormats, r101.alphaFormats) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originTemplates, r101.originTemplates) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replaceObjTemplates, r101.replaceObjTemplates) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.replaceEmptyTemplates, r101.replaceEmptyTemplates) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.replaceOldTemplates, r101.replaceOldTemplates) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.replaceSpecialResizeTemplates, r101.replaceSpecialResizeTemplates) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ecCommonTemplates, r101.ecCommonTemplates) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.replaceFormats, r101.replaceFormats) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.replaceQuality, r101.replaceQuality) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.enableUnifiedFlag, r101.enableUnifiedFlag) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        HashSet<String> r100 = this.imgFormats;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashSet<String> r104 = this.alphaFormats;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, g0> r107 = this.originTemplates;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<i0> r110 = this.replaceObjTemplates;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<i0> r113 = this.replaceEmptyTemplates;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        HashMap<String, j0> r116 = this.replaceOldTemplates;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<k0> r119 = this.replaceSpecialResizeTemplates;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        HashMap<String, q0> r122 = this.ecCommonTemplates;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<g> r125 = this.replaceFormats;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<h0> r128 = this.replaceQuality;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.enableUnifiedFlag;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "TmplConvModel(imgFormats=" + this.imgFormats + ", alphaFormats=" + this.alphaFormats + ", originTemplates=" + this.originTemplates + ", replaceObjTemplates=" + this.replaceObjTemplates + ", replaceEmptyTemplates=" + this.replaceEmptyTemplates + ", replaceOldTemplates=" + this.replaceOldTemplates + ", replaceSpecialResizeTemplates=" + this.replaceSpecialResizeTemplates + ", ecCommonTemplates=" + this.ecCommonTemplates + ", replaceFormats=" + this.replaceFormats + ", replaceQuality=" + this.replaceQuality + ", enableUnifiedFlag=" + this.enableUnifiedFlag + ")";
    }

    public final HashSet<String> a() {
        return this.alphaFormats;
    }

    public final HashMap<String, q0> b() {
        return this.ecCommonTemplates;
    }

    public final Boolean c() {
        return this.enableUnifiedFlag;
    }

    public final HashSet<String> d() {
        return this.imgFormats;
    }

    public final HashMap<String, g0> e() {
        return this.originTemplates;
    }

    public final List<i0> f() {
        return this.replaceEmptyTemplates;
    }

    public final List<g> g() {
        return this.replaceFormats;
    }

    public final List<i0> h() {
        return this.replaceObjTemplates;
    }

    public final HashMap<String, j0> i() {
        return this.replaceOldTemplates;
    }

    public final List<k0> j() {
        return this.replaceSpecialResizeTemplates;
    }

    public p0(Object r100) {
        this.imgFormats = null;
        this.alphaFormats = null;
        this.originTemplates = null;
        this.replaceObjTemplates = null;
        this.replaceEmptyTemplates = null;
        this.replaceOldTemplates = null;
        this.replaceSpecialResizeTemplates = null;
        this.ecCommonTemplates = null;
        this.replaceFormats = null;
        this.replaceQuality = null;
        this.enableUnifiedFlag = null;
    }
}
