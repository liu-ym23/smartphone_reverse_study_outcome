package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJB\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001f\u0010\u001d¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/sheet/f0;", "", "Lcom/stepos/ailauncher/sheet/g0;", "offset", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "", "collapsedScale", "travelWidthFraction", "collapsedScaleY", "<init>", "(Lcom/stepos/ailauncher/sheet/g0;Lcom/stepos/ailauncher/sheet/g0;FFF)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/sheet/g0;Lcom/stepos/ailauncher/sheet/g0;FFF)Lcom/stepos/ailauncher/sheet/f0;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/sheet/g0;", "e", "()Lcom/stepos/ailauncher/sheet/g0;", "f", "F", "c", "()F", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.f0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SheetScaleMotion {
    private final float collapsedScale;
    private final float collapsedScaleY;
    private final SheetSpring offset;
    private final SheetSpring scale;
    private final float travelWidthFraction;

    public SheetScaleMotion(SheetSpring offset, SheetSpring scale, float f10, float f11, float f12) {
        kotlin.jvm.internal.p.i(offset, "offset");
        kotlin.jvm.internal.p.i(scale, "scale");
        this.offset = offset;
        this.scale = scale;
        this.collapsedScale = f10;
        this.travelWidthFraction = f11;
        this.collapsedScaleY = f12;
    }

    public static /* synthetic */ SheetScaleMotion b(SheetScaleMotion sheetScaleMotion, SheetSpring sheetSpring, SheetSpring sheetSpring2, float f10, float f11, float f12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sheetSpring = sheetScaleMotion.offset;
        }
        if ((i10 & 2) != 0) {
            sheetSpring2 = sheetScaleMotion.scale;
        }
        if ((i10 & 4) != 0) {
            f10 = sheetScaleMotion.collapsedScale;
        }
        if ((i10 & 8) != 0) {
            f11 = sheetScaleMotion.travelWidthFraction;
        }
        if ((i10 & 16) != 0) {
            f12 = sheetScaleMotion.collapsedScaleY;
        }
        float f13 = f12;
        float f14 = f10;
        return sheetScaleMotion.a(sheetSpring, sheetSpring2, f14, f11, f13);
    }

    public final SheetScaleMotion a(SheetSpring offset, SheetSpring scale, float collapsedScale, float travelWidthFraction, float collapsedScaleY) {
        kotlin.jvm.internal.p.i(offset, "offset");
        kotlin.jvm.internal.p.i(scale, "scale");
        return new SheetScaleMotion(offset, scale, collapsedScale, travelWidthFraction, collapsedScaleY);
    }

    /* renamed from: c, reason: from getter */
    public final float getCollapsedScale() {
        return this.collapsedScale;
    }

    /* renamed from: d, reason: from getter */
    public final float getCollapsedScaleY() {
        return this.collapsedScaleY;
    }

    /* renamed from: e, reason: from getter */
    public final SheetSpring getOffset() {
        return this.offset;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SheetScaleMotion)) {
            return false;
        }
        SheetScaleMotion sheetScaleMotion = (SheetScaleMotion) other;
        return kotlin.jvm.internal.p.d(this.offset, sheetScaleMotion.offset) && kotlin.jvm.internal.p.d(this.scale, sheetScaleMotion.scale) && Float.compare(this.collapsedScale, sheetScaleMotion.collapsedScale) == 0 && Float.compare(this.travelWidthFraction, sheetScaleMotion.travelWidthFraction) == 0 && Float.compare(this.collapsedScaleY, sheetScaleMotion.collapsedScaleY) == 0;
    }

    /* renamed from: f, reason: from getter */
    public final SheetSpring getScale() {
        return this.scale;
    }

    /* renamed from: g, reason: from getter */
    public final float getTravelWidthFraction() {
        return this.travelWidthFraction;
    }

    public int hashCode() {
        return (((((((this.offset.hashCode() * 31) + this.scale.hashCode()) * 31) + Float.hashCode(this.collapsedScale)) * 31) + Float.hashCode(this.travelWidthFraction)) * 31) + Float.hashCode(this.collapsedScaleY);
    }

    public String toString() {
        return "SheetScaleMotion(offset=" + this.offset + ", scale=" + this.scale + ", collapsedScale=" + this.collapsedScale + ", travelWidthFraction=" + this.travelWidthFraction + ", collapsedScaleY=" + this.collapsedScaleY + ")";
    }

    public /* synthetic */ SheetScaleMotion(SheetSpring sheetSpring, SheetSpring sheetSpring2, float f10, float f11, float f12, int i10, kotlin.jvm.internal.i iVar) {
        this(sheetSpring, sheetSpring2, f10, f11, (i10 & 16) != 0 ? f10 : f12);
    }
}
