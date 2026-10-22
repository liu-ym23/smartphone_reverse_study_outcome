package com.bytedance.android.ec.core.imagex.transform;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules;", "Ljava/io/Serializable;", "", PlayerResolution.SDKKEY.ORIGIN, "Lcom/bytedance/android/ec/core/imagex/transform/a;", "resizeConfig", "transform", "", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "filters", "[Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "getFilters", "()[Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "setFilters", "([Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;)V", "", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule;", "defaultRules", "Ljava/util/List;", "getDefaultRules", "()Ljava/util/List;", "setDefaultRules", "(Ljava/util/List;)V", "", "transformRules", "Ljava/util/Map;", "getTransformRules", "()Ljava/util/Map;", "setTransformRules", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TransformRuleFilter", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageUrlTransformRules implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("default_rules")
    private List<ImageUrlTransformRule> defaultRules;

    @SerializedName("filters")
    private TransformRuleFilter[] filters;

    @SerializedName("transform_rules")
    private Map<String, ? extends List<ImageUrlTransformRule>> transformRules;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "Ljava/io/Serializable;", "", PlayerResolution.SDKKEY.ORIGIN, "keyOfRule", "pattern", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "setPattern", "(Ljava/lang/String;)V", "", "filterType", "Ljava/lang/Integer;", "getFilterType", "()Ljava/lang/Integer;", "setFilterType", "(Ljava/lang/Integer;)V", "groupIndex", "getGroupIndex", "setGroupIndex", "targetRule", "getTargetRule", "setTargetRule", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TransformRuleFilter implements Serializable {
        public static final a Companion = null;
        private static final long serialVersionUID = 1;

        @SerializedName(EffectConfiguration.KEY_FILTER_TYPE)
        private Integer filterType;

        @SerializedName("group_index")
        private Integer groupIndex;

        @SerializedName("pattern")
        private String pattern;

        @SerializedName("target_rule")
        private String targetRule;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public TransformRuleFilter() {
        }

        public final Integer getFilterType() {
            return this.filterType;
        }

        public final Integer getGroupIndex() {
            return this.groupIndex;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public final String getTargetRule() {
            return this.targetRule;
        }

        public final String keyOfRule(String r100) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            if (StringsKt.isBlank(r100) == true) goto L37;
            String r101 = this.pattern;
            if (r101 != null) goto L7;
        L10:
            boolean r102 = true;
        L11:
            if (r102 == true) goto L37;
            if (this.filterType == null) goto L37;
            String r103 = this.pattern;
            Intrinsics.checkNotNull(r103);
            MatchResult r104 = Regex.find$default(new Regex(r103), r100, 0, 2, null);
            if (r104 != null) goto L18;
            return null;
        L18:
            Integer r105 = this.filterType;
            if (r105 != null) goto L22;
        L31:
            if (r105 == null) goto L37;
            if (r105.intValue() != 1) goto L37;
            return a2.d(this.targetRule);
        L22:
            if (r105.intValue() != 0) goto L31;
            Integer r106 = this.groupIndex;
            if (r106 == null) goto L38;
            int r107 = r106.intValue();
            List<String> r108 = r104.getGroupValues();
            int r109 = r108.size();
            if (r107 < 0) goto L40;
            if (r109 > r107) goto L30;
            return null;
        L30:
            return (String) ListProtector.get(r108, r107);
        L40:
            return null;
        L38:
            return null;
        L7:
            if (StringsKt.isBlank(r101) == true) goto L10;
            r102 = false;
        L37:
            return null;
        }

        public final void setFilterType(Integer r100) {
            this.filterType = r100;
        }

        public final void setGroupIndex(Integer r100) {
            this.groupIndex = r100;
        }

        public final void setPattern(String r100) {
            this.pattern = r100;
        }

        public final void setTargetRule(String r100) {
            this.targetRule = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageUrlTransformRules() {
    }

    public final List<ImageUrlTransformRule> getDefaultRules() {
        return this.defaultRules;
    }

    public final TransformRuleFilter[] getFilters() {
        return this.filters;
    }

    public final Map<String, List<ImageUrlTransformRule>> getTransformRules() {
        return this.transformRules;
    }

    public final void setDefaultRules(List<ImageUrlTransformRule> r100) {
        this.defaultRules = r100;
    }

    public final void setFilters(TransformRuleFilter[] r100) {
        this.filters = r100;
    }

    public final void setTransformRules(Map<String, ? extends List<ImageUrlTransformRule>> r100) {
        this.transformRules = r100;
    }

    public final String transform(String r110, com.bytedance.android.ec.core.imagex.transform.a r111) {
        Intrinsics.checkNotNullParameter(r110, PlayerResolution.SDKKEY.ORIGIN);
        TransformRuleFilter[] r100 = this.filters;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        List<ImageUrlTransformRule> r103 = this.defaultRules;
    L58:
        List<ImageUrlTransformRule> r104 = r103;
        if (r104 != null) goto L61;
    L64:
        boolean r105 = true;
    L65:
        if (r105 == false) goto L67;
        return null;
    L67:
        Iterator<T> r106 = r103.iterator();
        String r107 = null;
    L69:
        if (r106.hasNext() == false) goto L83;
        String r108 = ((ImageUrlTransformRule) r106.next()).transform(r110, r111);
        if (r108 != null) goto L73;
    L76:
        boolean r109 = true;
    L78:
        if ((!r109) == true) goto L81;
        r108 = null;
    L81:
        if (r108 == null) goto L69;
        r107 = r108;
        goto L69
    L73:
        if (StringsKt.isBlank(r108) == true) goto L76;
        r109 = false;
        goto L78
    L83:
        if (r107 != null) goto L85;
    L86:
        r101 = true;
    L88:
        if ((!r101) == true) goto L90;
        return null;
    L90:
        return r107;
    L85:
        if (StringsKt.isBlank(r107) == false) goto L88;
    L61:
        if (r104.isEmpty() == true) goto L64;
        r105 = false;
        goto L65
    L15:
        Map<String, ? extends List<ImageUrlTransformRule>> r112 = this.transformRules;
        if (r112 != null) goto L18;
    L21:
        boolean r113 = true;
    L22:
        if (r113 == true) goto L57;
        TransformRuleFilter[] r114 = this.filters;
        if (r114 == null) goto L42;
        int r115 = r114.length;
        String r116 = null;
        int r117 = 0;
    L27:
        if (r117 >= r115) goto L43;
        String r118 = r114[r117].keyOfRule(r110);
        if (r118 != null) goto L31;
    L34:
        boolean r119 = true;
    L36:
        if ((!r119) == true) goto L39;
        r118 = null;
    L39:
        if (r118 == null) goto L41;
        r116 = r118;
    L41:
        r117 = r117 + 1;
        goto L27
    L31:
        if (StringsKt.isBlank(r118) == true) goto L34;
        r119 = false;
    L43:
        if (r116 != null) goto L45;
    L48:
        boolean r120 = true;
    L50:
        if ((!r120) == false) goto L52;
        String r121 = r116;
    L53:
        if (r121 == null) goto L57;
        Map<String, ? extends List<ImageUrlTransformRule>> r122 = this.transformRules;
        if (r122 == null) goto L57;
        r103 = r122.get(r116);
        goto L58
    L52:
        r121 = null;
        goto L53
    L45:
        if (StringsKt.isBlank(r116) == true) goto L48;
        r120 = false;
        goto L50
    L42:
        r116 = null;
    L57:
        r103 = null;
        goto L58
    L18:
        if (r112.isEmpty() == true) goto L21;
        r113 = false;
        goto L22
    L5:
        if (r100.length != 0) goto L7;
        boolean r123 = true;
    L8:
        if (r123 == true) goto L11;
        r102 = false;
        goto L13
    L7:
        r123 = false;
        goto L8
    }
}
