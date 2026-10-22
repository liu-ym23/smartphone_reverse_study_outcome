package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0016J\f\u0010!\u001a\u00020\u001f*\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003JG\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Landroidx/compose/ui/draw/PainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/PainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PainterElement extends ModifierNodeElement<PainterNode> {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public static /* synthetic */ PainterElement copy$default(PainterElement r100, Painter r101, boolean r102, Alignment r103, ContentScale r104, float r105, ColorFilter r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.painter;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.sizeToIntrinsics;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.alignment;
    L11:
        Alignment r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.contentScale;
    L14:
        ContentScale r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.alpha;
    L17:
        float r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.colorFilter;
    L20:
        Painter r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Painter component1() {
        return this.painter;
    }

    public final boolean component2() {
        return this.sizeToIntrinsics;
    }

    public final Alignment component3() {
        return this.alignment;
    }

    public final ContentScale component4() {
        return this.contentScale;
    }

    public final float component5() {
        return this.alpha;
    }

    public final ColorFilter component6() {
        return this.colorFilter;
    }

    public final PainterElement copy(Painter r100, boolean r110, Alignment r111, ContentScale r112, float r113, ColorFilter r114) {
        return new PainterElement(r100, r110, r111, r112, r113, r114);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PainterElement) == true) goto L8;
        return false;
    L8:
        PainterElement r101 = (PainterElement) r100;
        if (Intrinsics.areEqual(this.painter, r101.painter) == true) goto L12;
        return false;
    L12:
        if (this.sizeToIntrinsics == r101.sizeToIntrinsics) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.alignment, r101.alignment) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentScale, r101.contentScale) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.alpha, r101.alpha) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.colorFilter, r101.colorFilter) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = this.painter.hashCode() * 31;
        if (this.sizeToIntrinsics == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((((((r100 + r101) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        ColorFilter r103 = this.colorFilter;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "PainterElement(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public PainterNode create() {
        return new PainterNode(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("paint");
        r100.getProperties().set("painter", this.painter);
        r100.getProperties().set("sizeToIntrinsics", Boolean.valueOf(this.sizeToIntrinsics));
        r100.getProperties().set("alignment", this.alignment);
        r100.getProperties().set("contentScale", this.contentScale);
        r100.getProperties().set("alpha", Float.valueOf(this.alpha));
        r100.getProperties().set("colorFilter", this.colorFilter);
    }

    public void update(PainterNode r100) {
        boolean r101 = r100.getSizeToIntrinsics();
        boolean r102 = this.sizeToIntrinsics;
        if (r101 != r102) goto L9;
        if (r102 == true) goto L6;
    L8:
        boolean r103 = false;
    L10:
        r100.setPainter(this.painter);
        r100.setSizeToIntrinsics(this.sizeToIntrinsics);
        r100.setAlignment(this.alignment);
        r100.setContentScale(this.contentScale);
        r100.setAlpha(this.alpha);
        r100.setColorFilter(this.colorFilter);
        if (r103 == false) goto L13;
        LayoutModifierNodeKt.invalidateMeasurement(r100);
    L13:
        DrawModifierNodeKt.invalidateDraw(r100);
        return;
    L6:
        if (Size.m4647equalsimpl0(r100.getPainter().mo5530getIntrinsicSizeNHjbRc(), this.painter.mo5530getIntrinsicSizeNHjbRc()) == true) goto L8;
    L9:
        r103 = true;
        goto L10
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((PainterNode) r100);
    }

    public PainterElement(Painter r100, boolean r101, Alignment r102, ContentScale r103, float r104, ColorFilter r105) {
        this.painter = r100;
        this.sizeToIntrinsics = r101;
        this.alignment = r102;
        this.contentScale = r103;
        this.alpha = r104;
        this.colorFilter = r105;
    }
}
