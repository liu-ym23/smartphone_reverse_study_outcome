package com.alibaba.gaiax.template;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/alibaba/gaiax/template/GXSliderConfig;", "", "scrollTimeInterval", "", "infinityScroll", "", "hasIndicator", "selectedIndex", "", "indicatorSelectedColor", "Lcom/alibaba/gaiax/template/GXColor;", "indicatorUnselectedColor", "(JZZILcom/alibaba/gaiax/template/GXColor;Lcom/alibaba/gaiax/template/GXColor;)V", "getHasIndicator", "()Z", "getIndicatorSelectedColor", "()Lcom/alibaba/gaiax/template/GXColor;", "getIndicatorUnselectedColor", "getInfinityScroll", "getScrollTimeInterval", "()J", "getSelectedIndex", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXSliderConfig {
    public static final Companion Companion = null;
    private final boolean hasIndicator;
    private final GXColor indicatorSelectedColor;
    private final GXColor indicatorUnselectedColor;
    private final boolean infinityScroll;
    private final long scrollTimeInterval;
    private final int selectedIndex;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/alibaba/gaiax/template/GXSliderConfig$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXSliderConfig;", "srcConfig", "data", "Lorg/json/JSONObject;", "getBoolean", "", "key", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXSliderConfig create(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "data");
            long r100 = r110.optLong(GXTemplateKey.GAIAX_LAYER_SLIDER_SCROLL_TIME_INTERVAL, 3000);
            Boolean r101 = getBoolean(r110, GXTemplateKey.GAIAX_LAYER_SLIDER_INFINITY_SCROLL);
            if (r101 == null) goto L5;
            boolean r102 = r101.booleanValue();
        L6:
            Boolean r103 = getBoolean(r110, GXTemplateKey.GAIAX_LAYER_SLIDER_HAS_INDICATOR);
            if (r103 == null) goto L9;
            boolean r104 = r103.booleanValue();
        L10:
            int r105 = r110.optInt(GXTemplateKey.GAIAX_LAYER_SLIDER_SELECTED_INDEX, 0);
            String r106 = r110.optString(GXTemplateKey.GAIAX_LAYER_SLIDER_INDICATOR_SELECTED_COLOR, null);
            if (r106 == null) goto L14;
            GXColor r107 = GXColor.Companion.create(r106);
            if (r107 == null) goto L14;
        L15:
            GXColor r108 = r107;
            String r111 = r110.optString(GXTemplateKey.GAIAX_LAYER_SLIDER_INDICATOR_UNSELECTED_COLOR, null);
            if (r111 == null) goto L19;
            GXColor r112 = GXColor.Companion.create(r111);
            if (r112 == null) goto L19;
        L21:
            return new GXSliderConfig(r100, r102, r104, r105, r108, r112);
        L19:
            r112 = GXColor.Companion.createHex("#BBBBBB");
        L14:
            r107 = GXColor.Companion.createHex(CustomHeaderConfig.COLOR_LIGHT);
            goto L15
        L9:
            r104 = true;
            goto L10
        L5:
            r102 = true;
            goto L6
        }

        private final Boolean getBoolean(JSONObject r100, String r101) {
            if (r100.has(r101) == true) goto L5;
            return null;
        L5:
            return Boolean.valueOf(r100.optBoolean(r101));
        }

        public final GXSliderConfig create(GXSliderConfig r110, JSONObject r111) {
            Intrinsics.checkNotNullParameter(r110, "srcConfig");
            Intrinsics.checkNotNullParameter(r111, "data");
            long r100 = r111.optLong(GXTemplateKey.GAIAX_LAYER_SLIDER_SCROLL_TIME_INTERVAL, r110.getScrollTimeInterval());
            Boolean r101 = getBoolean(r111, GXTemplateKey.GAIAX_LAYER_SLIDER_INFINITY_SCROLL);
            if (r101 == null) goto L5;
            boolean r102 = r101.booleanValue();
        L6:
            boolean r103 = r102;
            Boolean r104 = getBoolean(r111, GXTemplateKey.GAIAX_LAYER_SLIDER_HAS_INDICATOR);
            if (r104 == null) goto L9;
            boolean r105 = r104.booleanValue();
        L10:
            boolean r106 = r105;
            int r107 = r111.optInt(GXTemplateKey.GAIAX_LAYER_SLIDER_SELECTED_INDEX, r110.getSelectedIndex());
            String r108 = r111.optString(GXTemplateKey.GAIAX_LAYER_SLIDER_INDICATOR_SELECTED_COLOR, null);
            if (r108 == null) goto L14;
            GXColor r109 = GXColor.Companion.create(r108);
            if (r109 == null) goto L14;
        L15:
            GXColor r112 = r109;
            String r113 = r111.optString(GXTemplateKey.GAIAX_LAYER_SLIDER_INDICATOR_UNSELECTED_COLOR, null);
            if (r113 == null) goto L21;
            GXColor r114 = GXColor.Companion.create(r113);
            if (r114 == null) goto L21;
            GXColor r115 = r114;
        L23:
            return new GXSliderConfig(r100, r103, r106, r107, r112, r115);
        L21:
            r115 = r110.getIndicatorUnselectedColor();
        L14:
            r109 = r110.getIndicatorSelectedColor();
            goto L15
        L9:
            r105 = r110.getHasIndicator();
            goto L10
        L5:
            r102 = r110.getInfinityScroll();
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ GXSliderConfig copy$default(GXSliderConfig r100, long r101, boolean r110, boolean r111, int r112, GXColor r113, GXColor r114, int r115, Object r116) {
        if ((r115 & 1) == 0) goto L5;
        long r102 = r100.scrollTimeInterval;
    L7:
        if ((r115 & 2) == 0) goto L9;
        boolean r103 = r100.infinityScroll;
    L11:
        if ((r115 & 4) == 0) goto L13;
        boolean r104 = r100.hasIndicator;
    L15:
        if ((r115 & 8) == 0) goto L17;
        int r105 = r100.selectedIndex;
    L19:
        if ((r115 & 16) == 0) goto L21;
        GXColor r106 = r100.indicatorSelectedColor;
    L23:
        if ((r115 & 32) == 0) goto L25;
        GXColor r107 = r100.indicatorUnselectedColor;
    L27:
        return r100.copy(r102, r103, r104, r105, r106, r107);
    L25:
        r107 = r114;
        goto L27
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.scrollTimeInterval;
    }

    public final boolean component2() {
        return this.infinityScroll;
    }

    public final boolean component3() {
        return this.hasIndicator;
    }

    public final int component4() {
        return this.selectedIndex;
    }

    public final GXColor component5() {
        return this.indicatorSelectedColor;
    }

    public final GXColor component6() {
        return this.indicatorUnselectedColor;
    }

    public final GXSliderConfig copy(long r110, boolean r111, boolean r112, int r113, GXColor r114, GXColor r115) {
        Intrinsics.checkNotNullParameter(r114, "indicatorSelectedColor");
        Intrinsics.checkNotNullParameter(r115, "indicatorUnselectedColor");
        return new GXSliderConfig(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXSliderConfig) == true) goto L8;
        return false;
    L8:
        GXSliderConfig r101 = (GXSliderConfig) r100;
        if (this.scrollTimeInterval == r101.scrollTimeInterval) goto L12;
        return false;
    L12:
        if (this.infinityScroll == r101.infinityScroll) goto L15;
        return false;
    L15:
        if (this.hasIndicator == r101.hasIndicator) goto L18;
        return false;
    L18:
        if (this.selectedIndex == r101.selectedIndex) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.indicatorSelectedColor, r101.indicatorSelectedColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.indicatorUnselectedColor, r101.indicatorUnselectedColor) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        long r100 = this.scrollTimeInterval;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.infinityScroll;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.hasIndicator;
        if (r106 == true) goto L10;
        r103 = r106;
    L10:
        return ((((((r105 + r103) * 31) + this.selectedIndex) * 31) + this.indicatorSelectedColor.hashCode()) * 31) + this.indicatorUnselectedColor.hashCode();
    }

    public String toString() {
        return "GXSliderConfig(scrollTimeInterval=" + this.scrollTimeInterval + ", infinityScroll=" + this.infinityScroll + ", hasIndicator=" + this.hasIndicator + ", selectedIndex=" + this.selectedIndex + ", indicatorSelectedColor=" + this.indicatorSelectedColor + ", indicatorUnselectedColor=" + this.indicatorUnselectedColor + ')';
    }

    public final boolean getHasIndicator() {
        return this.hasIndicator;
    }

    public final GXColor getIndicatorSelectedColor() {
        return this.indicatorSelectedColor;
    }

    public final GXColor getIndicatorUnselectedColor() {
        return this.indicatorUnselectedColor;
    }

    public final boolean getInfinityScroll() {
        return this.infinityScroll;
    }

    public final long getScrollTimeInterval() {
        return this.scrollTimeInterval;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public GXSliderConfig(long r100, boolean r101, boolean r102, int r103, GXColor r104, GXColor r105) {
        Intrinsics.checkNotNullParameter(r104, "indicatorSelectedColor");
        Intrinsics.checkNotNullParameter(r105, "indicatorUnselectedColor");
        this.scrollTimeInterval = r100;
        this.infinityScroll = r101;
        this.hasIndicator = r102;
        this.selectedIndex = r103;
        this.indicatorSelectedColor = r104;
        this.indicatorUnselectedColor = r105;
    }
}
