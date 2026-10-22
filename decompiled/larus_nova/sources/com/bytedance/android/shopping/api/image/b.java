package com.bytedance.android.shopping.api.image;

import com.amap.api.col.s.ce;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u00168\u0016X\u0097\u0004¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR.\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R.\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/image/b;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "cacheSize", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "reuseLevel", "f", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "", "Lcom/bytedance/android/shopping/api/image/o0;", "supportTemplates", "Ljava/util/Map;", ce.f26396k, "()Ljava/util/Map;", "", "supportReuseImageCache", "Ljava/lang/Boolean;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Boolean;", "supportReuseImageCacheForThumb", ce.f26395j, "supportReuseBitmap", "h", "matchersType", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "ignoreMatch", "c", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "ignoreReuseOptBizTag", "Ljava/util/HashSet;", "b", "()Ljava/util/HashSet;", "ignoreThumbOptBizTag", "d", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class b implements d.b {

    @SerializedName(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE)
    private final Integer cacheSize;

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("ignore_reuse_opt_biz_tags")
    private final HashSet<String> ignoreReuseOptBizTag;

    @SerializedName("ignore_thumb_opt_biz_tags")
    private final HashSet<String> ignoreThumbOptBizTag;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("reuse_level")
    private final Integer reuseLevel;

    @SerializedName("support_mather")
    private final List<d> supportMather;

    @SerializedName("support_reuse_bitmap")
    private final Boolean supportReuseBitmap;

    @SerializedName("support_reuse_image_cache")
    private final Boolean supportReuseImageCache;

    @SerializedName("support_reuse_image_cache_for_thumb")
    private final Boolean supportReuseImageCacheForThumb;

    @SerializedName("support_templates")
    private final Map<String, o0> supportTemplates;

    public b() {
        this(null);
    }

    public final int hashCode() {
        Integer r100 = this.cacheSize;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.reuseLevel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<d> r107 = this.supportMather;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, o0> r110 = this.supportTemplates;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.supportReuseImageCache;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.supportReuseImageCacheForThumb;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.supportReuseBitmap;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.matchersType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.ignoreMatch;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        HashSet<String> r128 = this.ignoreReuseOptBizTag;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        HashSet<String> r131 = this.ignoreThumbOptBizTag;
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
        return "ECImageMultiReuseModel(cacheSize=" + this.cacheSize + ", reuseLevel=" + this.reuseLevel + ", supportMather=" + this.supportMather + ", supportTemplates=" + this.supportTemplates + ", supportReuseImageCache=" + this.supportReuseImageCache + ", supportReuseImageCacheForThumb=" + this.supportReuseImageCacheForThumb + ", supportReuseBitmap=" + this.supportReuseBitmap + ", matchersType=" + this.matchersType + ", ignoreMatch=" + this.ignoreMatch + ", ignoreReuseOptBizTag=" + this.ignoreReuseOptBizTag + ", ignoreThumbOptBizTag=" + this.ignoreThumbOptBizTag + ")";
    }

    public final Integer a() {
        return this.cacheSize;
    }

    public final HashSet<String> b() {
        return this.ignoreReuseOptBizTag;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final Boolean c() {
        return this.ignoreMatch;
    }

    public final HashSet<String> d() {
        return this.ignoreThumbOptBizTag;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final List<d> e() {
        return this.supportMather;
    }

    public final Integer f() {
        return this.reuseLevel;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final String g() {
        return this.matchersType;
    }

    public final Boolean h() {
        return this.supportReuseBitmap;
    }

    public final Boolean i() {
        return this.supportReuseImageCache;
    }

    public final Boolean j() {
        return this.supportReuseImageCacheForThumb;
    }

    public final Map<String, o0> k() {
        return this.supportTemplates;
    }

    public b(Object r100) {
        this.cacheSize = null;
        this.reuseLevel = null;
        this.supportMather = null;
        this.supportTemplates = null;
        this.supportReuseImageCache = null;
        this.supportReuseImageCacheForThumb = null;
        this.supportReuseBitmap = null;
        this.matchersType = null;
        this.ignoreMatch = null;
        this.ignoreReuseOptBizTag = null;
        this.ignoreThumbOptBizTag = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L28;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.cacheSize, r101.cacheSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.reuseLevel, r101.reuseLevel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supportMather, r101.supportMather) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.supportTemplates, r101.supportTemplates) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.supportReuseImageCache, r101.supportReuseImageCache) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.supportReuseImageCacheForThumb, r101.supportReuseImageCacheForThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportReuseBitmap, r101.supportReuseBitmap) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.matchersType, r101.matchersType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.ignoreMatch, r101.ignoreMatch) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ignoreReuseOptBizTag, r101.ignoreReuseOptBizTag) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.ignoreThumbOptBizTag, r101.ignoreThumbOptBizTag) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }
}
