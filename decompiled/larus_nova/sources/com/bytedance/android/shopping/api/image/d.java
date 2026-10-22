package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u000274R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R.\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR.\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\"\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b.\u0010,R\"\u0010/\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,R\"\u00101\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R\"\u00103\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b4\u0010,R\"\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b7\u0010,R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006R\u001c\u0010;\u001a\u0004\u0018\u00010:8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010@\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bD\u0010\u0004\u0012\u0004\bF\u0010G\u001a\u0004\bE\u0010\u0006¨\u0006H"}, d2 = {"Lcom/bytedance/android/shopping/api/image/d;", "", "", "bucketName", "Ljava/lang/String;", "getBucketName", "()Ljava/lang/String;", "serviceId", "getServiceId", "originTmplName", "getOriginTmplName", "tmplName", "getTmplName", "tmplType", "getTmplType", "imgEncode", "getImgEncode", "bizTag", "getBizTag", "bizTagStartsWith", "getBizTagStartsWith", "bizTagContains", "getBizTagContains", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "bizTags", "Ljava/util/HashSet;", "getBizTags", "()Ljava/util/HashSet;", "sceneTag", "getSceneTag", "sceneTagStartsWith", "getSceneTagStartsWith", "sceneTagContains", "getSceneTagContains", "sceneTags", "getSceneTags", "imgEncodes", "getImgEncodes", "", "Lcom/bytedance/android/shopping/api/image/e;", GearStrategyConsts.EV_QUALITY, "Ljava/util/List;", "getQuality", "()Ljava/util/List;", "resizeWidth", "getResizeWidth", "resizeHeight", "getResizeHeight", "pixelSize", "getPixelSize", "netLevel", "b", "Lcom/bytedance/android/shopping/api/image/c;", "deviceScore", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "viewType", "c", "Lcom/bytedance/android/shopping/api/image/f;", "hasQuery", "Lcom/bytedance/android/shopping/api/image/f;", "getHasQuery", "()Lcom/bytedance/android/shopping/api/image/f;", "", "isExclude", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "contains", "getContains", "getContains$annotations", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("biz_tag#contains")
    private final String bizTagContains;

    @SerializedName("biz_tag#starts_with")
    private final String bizTagStartsWith;

    @SerializedName("biz_tag#list")
    private final HashSet<String> bizTags;

    @SerializedName("bucket_name")
    private final String bucketName;

    @SerializedName("contains")
    private final String contains;

    @SerializedName("device_score")
    private final List<c> deviceScore;

    @SerializedName("has_query")
    private final f hasQuery;

    @SerializedName("img_encode")
    private final String imgEncode;

    @SerializedName("img_encode#list")
    private final HashSet<String> imgEncodes;

    @SerializedName("is_exclude")
    private final Boolean isExclude;

    @SerializedName("net_level")
    private final List<e> netLevel;

    @SerializedName("origin_tmpl_name")
    private final String originTmplName;

    @SerializedName("pixel_size")
    private final List<e> pixelSize;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    private final List<e> quality;

    @SerializedName("resize_height")
    private final List<e> resizeHeight;

    @SerializedName("resize_width")
    private final List<e> resizeWidth;

    @SerializedName(FrescoMonitorConst.SCENE_TAG)
    private final String sceneTag;

    @SerializedName("scene_tag#contains")
    private final String sceneTagContains;

    @SerializedName("scene_tag#starts_with")
    private final String sceneTagStartsWith;

    @SerializedName("scene_tag#list")
    private final HashSet<String> sceneTags;

    @SerializedName("service_id")
    private final String serviceId;

    @SerializedName("tmpl_name")
    private final String tmplName;

    @SerializedName("tmpl_type")
    private final String tmplType;

    @SerializedName(BytedCertConstant.IntentKey.VIEW_TYPE)
    private final String viewType;

    public static final class a {
    }

    public interface b {
        Boolean c();

        List<d> e();

        String g();
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L56;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.bucketName, r101.bucketName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.serviceId, r101.serviceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originTmplName, r101.originTmplName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tmplName, r101.tmplName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tmplType, r101.tmplType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.imgEncode, r101.imgEncode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bizTagStartsWith, r101.bizTagStartsWith) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bizTagContains, r101.bizTagContains) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bizTags, r101.bizTags) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.sceneTag, r101.sceneTag) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.sceneTagStartsWith, r101.sceneTagStartsWith) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sceneTagContains, r101.sceneTagContains) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.sceneTags, r101.sceneTags) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.imgEncodes, r101.imgEncodes) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.quality, r101.quality) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.resizeWidth, r101.resizeWidth) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.resizeHeight, r101.resizeHeight) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.pixelSize, r101.pixelSize) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.netLevel, r101.netLevel) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.deviceScore, r101.deviceScore) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.viewType, r101.viewType) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.hasQuery, r101.hasQuery) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.isExclude, r101.isExclude) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.contains, r101.contains) == true) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    public final int hashCode() {
        String r100 = this.bucketName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.serviceId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.originTmplName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.tmplName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.tmplType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.imgEncode;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.bizTag;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.bizTagStartsWith;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.bizTagContains;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        HashSet<String> r128 = this.bizTags;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.sceneTag;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.sceneTagStartsWith;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.sceneTagContains;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        HashSet<String> r140 = this.sceneTags;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        HashSet<String> r143 = this.imgEncodes;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        List<e> r146 = this.quality;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        List<e> r149 = this.resizeWidth;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        List<e> r152 = this.resizeHeight;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        List<e> r155 = this.pixelSize;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        List<e> r158 = this.netLevel;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        List<c> r161 = this.deviceScore;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.viewType;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        f r167 = this.hasQuery;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        Boolean r170 = this.isExclude;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        String r173 = this.contains;
        if (r173 == null) goto L102;
        r101 = r173.hashCode();
    L102:
        return r172 + r101;
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
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
        return "ECImageUrlMatcher(bucketName=" + this.bucketName + ", serviceId=" + this.serviceId + ", originTmplName=" + this.originTmplName + ", tmplName=" + this.tmplName + ", tmplType=" + this.tmplType + ", imgEncode=" + this.imgEncode + ", bizTag=" + this.bizTag + ", bizTagStartsWith=" + this.bizTagStartsWith + ", bizTagContains=" + this.bizTagContains + ", bizTags=" + this.bizTags + ", sceneTag=" + this.sceneTag + ", sceneTagStartsWith=" + this.sceneTagStartsWith + ", sceneTagContains=" + this.sceneTagContains + ", sceneTags=" + this.sceneTags + ", imgEncodes=" + this.imgEncodes + ", quality=" + this.quality + ", resizeWidth=" + this.resizeWidth + ", resizeHeight=" + this.resizeHeight + ", pixelSize=" + this.pixelSize + ", netLevel=" + this.netLevel + ", deviceScore=" + this.deviceScore + ", viewType=" + this.viewType + ", hasQuery=" + this.hasQuery + ", isExclude=" + this.isExclude + ", contains=" + this.contains + ")";
    }

    public d() {
        Boolean r100 = Boolean.FALSE;
        this.bucketName = null;
        this.serviceId = null;
        this.originTmplName = null;
        this.tmplName = null;
        this.tmplType = null;
        this.imgEncode = null;
        this.bizTag = null;
        this.bizTagStartsWith = null;
        this.bizTagContains = null;
        this.bizTags = null;
        this.sceneTag = null;
        this.sceneTagStartsWith = null;
        this.sceneTagContains = null;
        this.sceneTags = null;
        this.imgEncodes = null;
        this.quality = null;
        this.resizeWidth = null;
        this.resizeHeight = null;
        this.pixelSize = null;
        this.netLevel = null;
        this.deviceScore = null;
        this.viewType = null;
        this.hasQuery = null;
        this.isExclude = r100;
        this.contains = null;
    }

    public final List<c> a() {
        return this.deviceScore;
    }

    public final List<e> b() {
        return this.netLevel;
    }

    public final String c() {
        return this.viewType;
    }

    public final Boolean d() {
        return this.isExclude;
    }

    public final boolean e(l r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "callerContext");
        String r102 = this.bizTag;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
    L13:
        String r104 = this.bizTagStartsWith;
        if (r104 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        String r106 = null;
        if (r105 == false) goto L23;
    L25:
        String r107 = this.bizTagContains;
        if (r107 != null) goto L28;
    L31:
        boolean r108 = true;
    L32:
        if (r108 == false) goto L34;
    L36:
        HashSet<String> r109 = this.bizTags;
        if (r109 != null) goto L39;
    L42:
        boolean r110 = true;
    L43:
        if (r110 == false) goto L45;
    L52:
        String r111 = this.sceneTag;
        if (r111 != null) goto L55;
    L58:
        boolean r112 = true;
    L59:
        if (r112 == false) goto L61;
    L63:
        String r113 = this.sceneTagStartsWith;
        if (r113 != null) goto L66;
    L69:
        boolean r114 = true;
    L70:
        if (r114 == false) goto L72;
    L74:
        String r115 = this.sceneTagContains;
        if (r115 != null) goto L77;
    L80:
        boolean r116 = true;
    L81:
        if (r116 == false) goto L83;
    L85:
        HashSet<String> r117 = this.sceneTags;
        if (r117 != null) goto L88;
    L91:
        boolean r118 = true;
    L92:
        if (r118 == false) goto L94;
    L101:
        String r119 = this.contains;
        if (r119 == null) goto L104;
    L129:
        boolean r120 = true;
    L130:
        if (r120 == false) goto L245;
        if (r101 != null) goto L133;
    L244:
        return false;
    L133:
        if (r101.f(this.bucketName, r119) == true) goto L135;
        return false;
    L135:
        String r121 = this.serviceId;
        if (r121 != null) goto L138;
    L141:
        boolean r122 = true;
    L142:
        if (r122 == false) goto L144;
    L146:
        String r123 = this.tmplName;
        if (r123 != null) goto L149;
    L152:
        boolean r124 = true;
    L153:
        if (r124 == false) goto L155;
    L157:
        String r125 = this.tmplType;
        if (r125 != null) goto L160;
    L163:
        boolean r126 = true;
    L164:
        if (r126 == false) goto L166;
    L168:
        String r127 = this.originTmplName;
        if (r127 != null) goto L171;
    L174:
        boolean r128 = true;
    L175:
        if (r128 == true) goto L183;
        String r129 = this.originTmplName;
        t r130 = r101.n();
        if (r130 == null) goto L179;
        String r131 = r130.l();
    L181:
        if ((!Intrinsics.areEqual(r129, r131)) == false) goto L183;
        return false;
    L179:
        r131 = null;
    L183:
        String r132 = this.imgEncode;
        if (r132 != null) goto L186;
    L189:
        boolean r133 = true;
    L190:
        if (r133 == false) goto L192;
    L194:
        List<e> r134 = this.quality;
        if (r134 != null) goto L197;
    L199:
        List<e> r135 = this.resizeWidth;
        if (r135 != null) goto L202;
    L204:
        List<e> r136 = this.resizeHeight;
        if (r136 != null) goto L207;
    L209:
        List<e> r137 = this.pixelSize;
        if (r137 != null) goto L212;
    L214:
        HashSet<String> r138 = this.imgEncodes;
        if (r138 != null) goto L217;
    L220:
        boolean r139 = true;
    L221:
        if (r139 == true) goto L233;
        String r140 = r101.getFormat();
        if (r140 != null) goto L225;
    L228:
        boolean r141 = true;
    L229:
        if (r141 == true) goto L233;
        if (CollectionsKt.contains(this.imgEncodes, r101.getFormat()) == true) goto L233;
        return false;
    L225:
        if (r140.length() == 0) goto L228;
        r141 = false;
    L233:
        f r142 = this.hasQuery;
        if (r142 == null) goto L236;
        r106 = r142.a();
    L236:
        if (r106 == null) goto L245;
        if (this.hasQuery.b() == null) goto L243;
        if ((!Intrinsics.areEqual(this.hasQuery.b(), r101.getQuery().b(this.hasQuery.a()))) == false) goto L245;
        return false;
    L243:
        if (r101.getQuery().a(this.hasQuery.a()) == true) goto L245;
    L217:
        if (r138.isEmpty() == true) goto L220;
        r139 = false;
        goto L221
    L212:
        if (y.a(r137, r101.k()) == true) goto L214;
        return false;
    L207:
        if (y.a(r136, r101.b().getValue()) == true) goto L209;
        return false;
    L202:
        if (y.a(r135, r101.d().getValue()) == true) goto L204;
        return false;
    L197:
        if (y.a(r134, r101.getQuality().getValue()) == true) goto L199;
        return false;
    L192:
        if ((!Intrinsics.areEqual(this.imgEncode, r101.getFormat())) == false) goto L194;
        return false;
    L186:
        if (r132.length() == 0) goto L189;
        r133 = false;
        goto L190
    L171:
        if (r127.length() == 0) goto L174;
        r128 = false;
        goto L175
    L166:
        if ((!Intrinsics.areEqual(this.tmplType, r101.i())) == false) goto L168;
        return false;
    L160:
        if (r125.length() == 0) goto L163;
        r126 = false;
        goto L164
    L155:
        if ((!Intrinsics.areEqual(this.tmplName, r101.l())) == false) goto L157;
        return false;
    L149:
        if (r123.length() == 0) goto L152;
        r124 = false;
        goto L153
    L144:
        if ((!Intrinsics.areEqual(this.serviceId, r101.getServiceId())) == false) goto L146;
        return false;
    L138:
        if (r121.length() == 0) goto L141;
        r122 = false;
    L245:
        return true;
    L104:
        if (this.bucketName != null) goto L129;
        if (this.serviceId != null) goto L129;
        if (this.tmplName != null) goto L129;
        if (this.tmplType != null) goto L129;
        if (this.originTmplName != null) goto L129;
        if (this.imgEncode != null) goto L129;
        if (this.imgEncodes != null) goto L129;
        if (this.quality != null) goto L129;
        if (this.resizeWidth != null) goto L129;
        if (this.resizeHeight != null) goto L129;
        if (this.pixelSize != null) goto L129;
        if (this.hasQuery != null) goto L129;
        r120 = false;
        goto L130
    L94:
        if (r100.a().length() <= 0) goto L96;
        boolean r143 = true;
    L97:
        if (r143 == false) goto L101;
        if (this.sceneTags.contains(r100.a()) == true) goto L101;
        return false;
    L96:
        r143 = false;
        goto L97
    L88:
        if (r117.isEmpty() == true) goto L91;
        r118 = false;
        goto L92
    L83:
        if (StringsKt.contains$default(r100.a(), this.sceneTagContains, false, 2, null) == true) goto L85;
        return false;
    L77:
        if (r115.length() == 0) goto L80;
        r116 = false;
        goto L81
    L72:
        if (StringsKt.startsWith$default(r100.a(), this.sceneTagStartsWith, false, 2, null) == true) goto L74;
        return false;
    L66:
        if (r113.length() == 0) goto L69;
        r114 = false;
        goto L70
    L61:
        if ((!Intrinsics.areEqual(this.sceneTag, r100.a())) == false) goto L63;
        return false;
    L55:
        if (r111.length() == 0) goto L58;
        r112 = false;
        goto L59
    L45:
        if (r100.getBizTag().length() <= 0) goto L47;
        boolean r144 = true;
    L48:
        if (r144 == false) goto L52;
        if (this.bizTags.contains(r100.getBizTag()) == true) goto L52;
        return false;
    L47:
        r144 = false;
        goto L48
    L39:
        if (r109.isEmpty() == true) goto L42;
        r110 = false;
        goto L43
    L34:
        if (StringsKt.contains$default(r100.getBizTag(), this.bizTagContains, false, 2, null) == true) goto L36;
        return false;
    L28:
        if (r107.length() == 0) goto L31;
        r108 = false;
        goto L32
    L23:
        if (StringsKt.startsWith$default(r100.getBizTag(), this.bizTagStartsWith, false, 2, null) == true) goto L25;
        return false;
    L16:
        if (r104.length() == 0) goto L19;
        r105 = false;
        goto L20
    L11:
        if ((!Intrinsics.areEqual(this.bizTag, r100.getBizTag())) == false) goto L13;
        return false;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
