package com.alibaba.gaiax.template;

import android.graphics.Rect;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\b\u0010(\u001a\u00020)H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006+"}, d2 = {"Lcom/alibaba/gaiax/template/GXGridConfig;", "", "data", "Lorg/json/JSONObject;", "column", "", "direction", "itemSpacing", "rowSpacing", "edgeInsets", "Landroid/graphics/Rect;", "scrollEnable", "", "(Lorg/json/JSONObject;IIIILandroid/graphics/Rect;Z)V", "getColumn", "()I", "getData", "()Lorg/json/JSONObject;", "getDirection", "getEdgeInsets", "()Landroid/graphics/Rect;", "isHorizontal", "()Z", "isVertical", "getItemSpacing", "getRowSpacing", "getScrollEnable", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/alibaba/gaiax/context/GXTemplateContext;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXGridConfig {
    public static final Companion Companion = null;
    private final int column;
    private final JSONObject data;
    private final int direction;
    private final Rect edgeInsets;
    private final int itemSpacing;
    private final int rowSpacing;
    private final boolean scrollEnable;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/template/GXGridConfig$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXGridConfig;", "srcConfig", "data", "Lorg/json/JSONObject;", "direction", "", "edgeInsets", "itemSpacing", "rowSpacing", "column", "", "scrollable", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXGridConfig create(GXGridConfig r110, JSONObject r111) {
            Intrinsics.checkNotNullParameter(r110, "srcConfig");
            Intrinsics.checkNotNullParameter(r111, "data");
            int r100 = r111.optInt("column");
            boolean r101 = r111.optBoolean(GXTemplateKey.GAIAX_LAYER_SCROLL_ENABLE);
            String r102 = r111.optString(GXTemplateKey.GAIAX_LAYER_EDGE_INSETS, null);
            String r103 = r111.optString(GXTemplateKey.GAIAX_LAYER_ITEM_SPACING, null);
            if (r103 != null) goto L5;
            r103 = r111.optString(GXTemplateKey.GAIAX_LAYER_LINE_SPACING, null);
        L5:
            String r104 = r111.optString(GXTemplateKey.GAIAX_LAYER_ROW_SPACING, null);
            if (r104 != null) goto L8;
            r104 = r111.optString(GXTemplateKey.GAIAX_LAYER_INTERITEM_SPACING, null);
        L8:
            JSONObject r105 = r110.getData();
            int r106 = Math.max(r100, 1);
            int r107 = r110.getDirection();
            if (r103 == null) goto L11;
            int r108 = GXContainerConvert.INSTANCE.spacing(r103);
        L12:
            int r109 = r108;
            if (r104 == null) goto L15;
            int r112 = GXContainerConvert.INSTANCE.spacing(r104);
        L16:
            int r113 = r112;
            if (r102 == null) goto L22;
            Rect r114 = GXContainerConvert.INSTANCE.edgeInsets(r102);
            if (r114 == null) goto L22;
            Rect r115 = r114;
        L24:
            return new GXGridConfig(r105, r106, r107, r109, r113, r115, r101);
        L22:
            r115 = r110.getEdgeInsets();
            goto L24
        L15:
            r112 = r110.getRowSpacing();
            goto L16
        L11:
            r108 = r110.getItemSpacing();
            goto L12
        }

        public final GXGridConfig create(JSONObject r110, String r111, String r112, String r113, String r114, int r115, boolean r116) {
            Intrinsics.checkNotNullParameter(r110, "data");
            int r100 = Math.max(r115, 1);
            GXContainerConvert r101 = GXContainerConvert.INSTANCE;
            if (r111 != null) goto L5;
            String r102 = "vertical";
        L6:
            int r103 = r101.direction(r102);
            int r104 = r101.spacing(r113);
            int r105 = r101.spacing(r114);
            Rect r106 = r101.edgeInsets(r112);
            if (r106 != null) goto L10;
            r106 = new Rect(0, 0, 0, 0);
        L10:
            return new GXGridConfig(r110, r100, r103, r104, r105, r106, r116);
        L5:
            r102 = r111;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ GXGridConfig copy$default(GXGridConfig r100, JSONObject r101, int r102, int r103, int r104, int r110, Rect r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.column;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.direction;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.itemSpacing;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.rowSpacing;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.edgeInsets;
    L20:
        Rect r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.scrollEnable;
    L23:
        JSONObject r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final JSONObject component1() {
        return this.data;
    }

    public final int component2() {
        return this.column;
    }

    public final int component3() {
        return this.direction;
    }

    public final int component4() {
        return this.itemSpacing;
    }

    public final int component5() {
        return this.rowSpacing;
    }

    public final Rect component6() {
        return this.edgeInsets;
    }

    public final boolean component7() {
        return this.scrollEnable;
    }

    public final GXGridConfig copy(JSONObject r110, int r111, int r112, int r113, int r114, Rect r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r115, "edgeInsets");
        return new GXGridConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXGridConfig) == true) goto L8;
        return false;
    L8:
        GXGridConfig r101 = (GXGridConfig) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.column == r101.column) goto L15;
        return false;
    L15:
        if (this.direction == r101.direction) goto L18;
        return false;
    L18:
        if (this.itemSpacing == r101.itemSpacing) goto L21;
        return false;
    L21:
        if (this.rowSpacing == r101.rowSpacing) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.edgeInsets, r101.edgeInsets) == true) goto L27;
        return false;
    L27:
        if (this.scrollEnable == r101.scrollEnable) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int r100 = ((((((((((this.data.hashCode() * 31) + this.column) * 31) + this.direction) * 31) + this.itemSpacing) * 31) + this.rowSpacing) * 31) + this.edgeInsets.hashCode()) * 31;
        boolean r101 = this.scrollEnable;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
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
        return "GXGridConfig(column=" + this.column + ", direction=" + this.direction + ", itemSpacing=" + this.itemSpacing + ", rowSpacing=" + this.rowSpacing + ", edgeInsets=" + this.edgeInsets + ')';
    }

    public final int getColumn() {
        return this.column;
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

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final int getRowSpacing() {
        return this.rowSpacing;
    }

    public final boolean getScrollEnable() {
        return this.scrollEnable;
    }

    public final int column(GXTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GXRegisterCenter.GXIExtensionGrid r101 = GXRegisterCenter.Companion.getInstance().getExtensionGrid$GaiaX();
        if (r101 == null) goto L9;
        Object r102 = r101.convert("column", r100, this);
        if (r102 == null) goto L9;
        return ((Integer) r102).intValue();
    L9:
        return this.column;
    }

    public GXGridConfig(JSONObject r100, int r101, int r102, int r103, int r104, Rect r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r105, "edgeInsets");
        this.data = r100;
        this.column = r101;
        this.direction = r102;
        this.itemSpacing = r103;
        this.rowSpacing = r104;
        this.edgeInsets = r105;
        this.scrollEnable = r106;
    }

    public /* synthetic */ GXGridConfig(JSONObject r100, int r101, int r110, int r111, int r112, Rect r113, boolean r114, int r115, DefaultConstructorMarker r116) {
        int r102 = 1;
        if ((r115 & 2) == 0) goto L5;
        int r103 = 1;
    L7:
        if ((r115 & 4) != 0) goto L10;
        r102 = r110;
    L10:
        boolean r104 = false;
        if ((r115 & 8) == 0) goto L13;
        int r105 = 0;
    L15:
        if ((r115 & 16) == 0) goto L17;
        int r106 = 0;
    L19:
        if ((r115 & 32) == 0) goto L21;
        Rect r107 = new Rect(0, 0, 0, 0);
    L23:
        if ((r115 & 64) != 0) goto L26;
        r104 = r114;
    L26:
        this(r100, r103, r102, r105, r106, r107, r104);
        return;
    L21:
        r107 = r113;
        goto L23
    L17:
        r106 = r112;
        goto L19
    L13:
        r105 = r111;
        goto L15
    L5:
        r103 = r101;
        goto L7
    }
}
