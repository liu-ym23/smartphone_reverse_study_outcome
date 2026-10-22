package com.alibaba.gaiax.template;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006%"}, d2 = {"Lcom/alibaba/gaiax/template/GXScrollConfig;", "", "data", "Lorg/json/JSONObject;", "direction", "", "itemSpacing", "edgeInsets", "Landroid/graphics/Rect;", GXTemplateKey.GAIAX_LAYER_GRAVITY, "(Lorg/json/JSONObject;IILandroid/graphics/Rect;I)V", "getData", "()Lorg/json/JSONObject;", "getDirection", "()I", "getEdgeInsets", "()Landroid/graphics/Rect;", "getGravity", "setGravity", "(I)V", "isHorizontal", "", "()Z", "isVertical", "getItemSpacing", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXScrollConfig {
    public static final Companion Companion = null;
    private final JSONObject data;
    private final int direction;
    private final Rect edgeInsets;
    private int gravity;
    private final int itemSpacing;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/template/GXScrollConfig$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXScrollConfig;", "srcConfig", "data", "Lorg/json/JSONObject;", "direction", "", "edgeInsets", "itemSpacing", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/alibaba/gaiax/template/GXScrollConfig;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXScrollConfig create(GXScrollConfig r110, JSONObject r111) {
            Intrinsics.checkNotNullParameter(r110, "srcConfig");
            Intrinsics.checkNotNullParameter(r111, "data");
            String r100 = r111.optString(GXTemplateKey.GAIAX_LAYER_EDGE_INSETS, null);
            String r101 = r111.optString(GXTemplateKey.GAIAX_LAYER_ITEM_SPACING, null);
            if (r101 != null) goto L5;
            r101 = r111.optString(GXTemplateKey.GAIAX_LAYER_LINE_SPACING, null);
        L5:
            JSONObject r102 = r110.getData();
            int r103 = r110.getDirection();
            if (r101 == null) goto L8;
            int r104 = GXContainerConvert.INSTANCE.spacing(r101);
        L9:
            int r105 = r104;
            if (r100 == null) goto L13;
            Rect r106 = GXContainerConvert.INSTANCE.edgeInsets(r100);
            if (r106 == null) goto L13;
        L15:
            return new GXScrollConfig(r102, r103, r105, r106, r110.getGravity());
        L13:
            r106 = r110.getEdgeInsets();
            goto L15
        L8:
            r104 = r110.getItemSpacing();
            goto L9
        }

        public final GXScrollConfig create(JSONObject r100, String r101, String r110, String r111, Integer r112) {
            Intrinsics.checkNotNullParameter(r100, "data");
            GXContainerConvert r102 = GXContainerConvert.INSTANCE;
            if (r101 != null) goto L5;
            r101 = "vertical";
        L5:
            int r103 = r102.direction(r101);
            int r104 = r102.spacing(r111);
            Rect r105 = r102.edgeInsets(r110);
            if (r105 != null) goto L8;
            r105 = new Rect(0, 0, 0, 0);
        L8:
            Rect r106 = r105;
            if (r112 == null) goto L11;
            int r107 = r112.intValue();
        L13:
            return new GXScrollConfig(r100, r103, r104, r106, r107);
        L11:
            r107 = 48;
            goto L13
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ GXScrollConfig copy$default(GXScrollConfig r100, JSONObject r101, int r102, int r103, Rect r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.direction;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.itemSpacing;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.edgeInsets;
    L14:
        Rect r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.gravity;
    L17:
        JSONObject r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final JSONObject component1() {
        return this.data;
    }

    public final int component2() {
        return this.direction;
    }

    public final int component3() {
        return this.itemSpacing;
    }

    public final Rect component4() {
        return this.edgeInsets;
    }

    public final int component5() {
        return this.gravity;
    }

    public final GXScrollConfig copy(JSONObject r100, int r101, int r110, Rect r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r111, "edgeInsets");
        return new GXScrollConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXScrollConfig) == true) goto L8;
        return false;
    L8:
        GXScrollConfig r101 = (GXScrollConfig) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.direction == r101.direction) goto L15;
        return false;
    L15:
        if (this.itemSpacing == r101.itemSpacing) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.edgeInsets, r101.edgeInsets) == true) goto L21;
        return false;
    L21:
        if (this.gravity == r101.gravity) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.data.hashCode() * 31) + this.direction) * 31) + this.itemSpacing) * 31) + this.edgeInsets.hashCode()) * 31) + this.gravity;
    }

    public final boolean isHorizontal() {
        if (this.direction != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isVertical() {
        if (this.direction == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "GXScrollConfig(direction=" + this.direction + ", itemSpacing=" + this.itemSpacing + ", edgeInsets=" + this.edgeInsets + ')';
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final Rect getEdgeInsets() {
        return this.edgeInsets;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final void setGravity(int r100) {
        this.gravity = r100;
    }

    public GXScrollConfig(JSONObject r100, int r101, int r102, Rect r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r103, "edgeInsets");
        this.data = r100;
        this.direction = r101;
        this.itemSpacing = r102;
        this.edgeInsets = r103;
        this.gravity = r104;
    }

    public /* synthetic */ GXScrollConfig(JSONObject r100, int r101, int r102, Rect r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        int r103 = 1;
    L7:
        if ((r112 & 4) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r112 & 8) == 0) goto L13;
        r110 = new Rect(0, 0, 0, 0);
    L13:
        Rect r105 = r110;
        if ((r112 & 16) == 0) goto L16;
        int r106 = 48;
    L17:
        this(r100, r103, r104, r105, r106);
        return;
    L16:
        r106 = r111;
        goto L17
    L9:
        r104 = r102;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }
}
