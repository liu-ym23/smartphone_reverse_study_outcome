package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/alibaba/gaiax/template/GXProgressConfig;", "", "strokeColor", "Lcom/alibaba/gaiax/template/GXColor;", "trailColor", "progressType", "", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "", "(Lcom/alibaba/gaiax/template/GXColor;Lcom/alibaba/gaiax/template/GXColor;Ljava/lang/String;Z)V", "getAnimated", "()Z", "getProgressType", "()Ljava/lang/String;", "getStrokeColor", "()Lcom/alibaba/gaiax/template/GXColor;", "getTrailColor", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXProgressConfig {
    public static final Companion Companion = null;
    private final boolean animated;
    private final String progressType;
    private final GXColor strokeColor;
    private final GXColor trailColor;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/GXProgressConfig$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXProgressConfig;", "srcConfig", "data", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXProgressConfig create(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            String r101 = r100.optString(GXTemplateKey.GAIAX_LAYER_PROGRESS_STROKE_COLOR, null);
            if (r101 == null) goto L6;
            GXColor r102 = GXColor.Companion.create(r101);
            if (r102 == null) goto L6;
        L7:
            String r103 = r100.optString(GXTemplateKey.GAIAX_LAYER_PROGRESS_TRAIL_COLOR, null);
            if (r103 == null) goto L11;
            GXColor r104 = GXColor.Companion.create(r103);
            if (r104 == null) goto L11;
        L12:
            String r105 = r100.optString(GXTemplateKey.GAIAX_LAYER_PROGRESS_TYPE, null);
            if (r105 != null) goto L16;
            r105 = "line";
        L16:
            return new GXProgressConfig(r102, r104, r105, r100.optBoolean(GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, true));
        L11:
            r104 = GXColor.Companion.createHex("#BBBBBB");
        L6:
            r102 = GXColor.Companion.createHex("#0000FF");
            goto L7
        }

        public final GXProgressConfig create(GXProgressConfig r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "srcConfig");
            Intrinsics.checkNotNullParameter(r101, "data");
            String r102 = r101.optString(GXTemplateKey.GAIAX_LAYER_PROGRESS_STROKE_COLOR, null);
            if (r102 == null) goto L6;
            GXColor r103 = GXColor.Companion.create(r102);
            if (r103 == null) goto L6;
        L7:
            String r104 = r101.optString(GXTemplateKey.GAIAX_LAYER_PROGRESS_TRAIL_COLOR, null);
            if (r104 == null) goto L11;
            GXColor r105 = GXColor.Companion.create(r104);
            if (r105 == null) goto L11;
        L12:
            String r106 = r101.optString(GXTemplateKey.GAIAX_LAYER_PROGRESS_TYPE, null);
            if (r106 != null) goto L16;
            r106 = r100.getProgressType();
        L16:
            return new GXProgressConfig(r103, r105, r106, r101.optBoolean(GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, r100.getAnimated()));
        L11:
            r105 = r100.getTrailColor();
        L6:
            r103 = r100.getStrokeColor();
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ GXProgressConfig copy$default(GXProgressConfig r100, GXColor r101, GXColor r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.strokeColor;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.trailColor;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.progressType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.animated;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final GXColor component1() {
        return this.strokeColor;
    }

    public final GXColor component2() {
        return this.trailColor;
    }

    public final String component3() {
        return this.progressType;
    }

    public final boolean component4() {
        return this.animated;
    }

    public final GXProgressConfig copy(GXColor r100, GXColor r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "strokeColor");
        Intrinsics.checkNotNullParameter(r101, "trailColor");
        Intrinsics.checkNotNullParameter(r102, "progressType");
        return new GXProgressConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXProgressConfig) == true) goto L8;
        return false;
    L8:
        GXProgressConfig r101 = (GXProgressConfig) r100;
        if (Intrinsics.areEqual(this.strokeColor, r101.strokeColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trailColor, r101.trailColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.progressType, r101.progressType) == true) goto L18;
        return false;
    L18:
        if (this.animated == r101.animated) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int r100 = ((((this.strokeColor.hashCode() * 31) + this.trailColor.hashCode()) * 31) + this.progressType.hashCode()) * 31;
        boolean r101 = this.animated;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public String toString() {
        return "GXProgressConfig(strokeColor=" + this.strokeColor + ", trailColor=" + this.trailColor + ", progressType=" + this.progressType + ", animated=" + this.animated + ')';
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    public final String getProgressType() {
        return this.progressType;
    }

    public final GXColor getStrokeColor() {
        return this.strokeColor;
    }

    public final GXColor getTrailColor() {
        return this.trailColor;
    }

    public GXProgressConfig(GXColor r100, GXColor r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "strokeColor");
        Intrinsics.checkNotNullParameter(r101, "trailColor");
        Intrinsics.checkNotNullParameter(r102, "progressType");
        this.strokeColor = r100;
        this.trailColor = r101;
        this.progressType = r102;
        this.animated = r103;
    }
}
