package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001f\u0010!\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001c\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$ui_graphics_release", "()I", "setFilterQuality-vDHp3xo$ui_graphics_release", "(I)V", "I", "size", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "applyAlpha", "", "applyColorFilter", "validateSize", "validateSize-N5eqBDc", "(JJ)J", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapPainter extends Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap r100, long r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo5530getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m7731toSizeozmzZPI(this.size);
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m7678hashCodeimpl(this.srcOffset)) * 31) + IntSize.m7720hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m4923hashCodeimpl(this.filterQuality);
    }

    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + IntOffset.m7683toStringimpl(this.srcOffset) + ", srcSize=" + IntSize.m7722toStringimpl(this.srcSize) + ", filterQuality=" + FilterQuality.m4924toStringimpl(this.filterQuality) + ')';
    }

    /* JADX INFO: renamed from: getFilterQuality-f-v9h1I$ui_graphics_release, reason: not valid java name */
    public final int m5529getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean applyAlpha(float r100) {
        this.alpha = r100;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean applyColorFilter(ColorFilter r100) {
        this.colorFilter = r100;
        return true;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitmapPainter) == true) goto L8;
        return false;
    L8:
        BitmapPainter r101 = (BitmapPainter) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (IntOffset.m7675equalsimpl0(this.srcOffset, r101.srcOffset) == true) goto L15;
        return false;
    L15:
        if (IntSize.m7717equalsimpl0(this.srcSize, r101.srcSize) == true) goto L18;
        return false;
    L18:
        if (FilterQuality.m4922equalsimpl0(this.filterQuality, r101.filterQuality) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope r110) {
        ImageBitmap r100 = this.image;
        long r101 = this.srcOffset;
        long r102 = this.srcSize;
        int r103 = Math.round(Float.intBitsToFloat((int) (r110.mo5322getSizeNHjbRc() >> 32)));
        int r111 = Math.round(Float.intBitsToFloat((int) (r110.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax)));
        long r112 = ((long) r103) << 32;
        DrawScope.CC.m5396drawImageAZ2fEMs$default(r110, r100, r101, r102, 0, IntSize.m7714constructorimpl((((long) r111) & BodyPartID.bodyIdMax) | r112), this.alpha, null, this.colorFilter, 0, this.filterQuality, 328, null);
    }

    /* JADX INFO: renamed from: setFilterQuality-vDHp3xo$ui_graphics_release, reason: not valid java name */
    public final void m5531setFilterQualityvDHp3xo$ui_graphics_release(int r100) {
        this.filterQuality = r100;
    }

    /* JADX INFO: renamed from: validateSize-N5eqBDc, reason: not valid java name */
    private final long m5528validateSizeN5eqBDc(long r100, long r101) {
        if (IntOffset.m7676getXimpl(r100) >= 0) goto L5;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == false) goto L19;
        return r101;
    L19:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (IntOffset.m7677getYimpl(r100) < 0) goto L15;
        int r103 = (int) (r101 >> 32);
        if (r103 < 0) goto L15;
        int r104 = (int) (BodyPartID.bodyIdMax & r101);
        if (r104 < 0) goto L15;
        if (r103 > this.image.getWidth()) goto L15;
        if (r104 > this.image.getHeight()) goto L15;
        r102 = true;
        goto L16
    }

    private BitmapPainter(ImageBitmap r100, long r101, long r102) {
        this.image = r100;
        this.srcOffset = r101;
        this.srcSize = r102;
        this.filterQuality = FilterQuality.Companion.m4927getLowfv9h1I();
        this.size = m5528validateSizeN5eqBDc(r101, r102);
        this.alpha = 1.0f;
    }

    public /* synthetic */ BitmapPainter(ImageBitmap r100, long r101, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 2) == 0) goto L5;
        r101 = IntOffset.Companion.m7687getZeronOccac();
    L5:
        long r102 = r101;
        if ((r111 & 4) == 0) goto L8;
        int r103 = r100.getWidth();
        long r113 = ((long) r103) << 32;
        r110 = IntSize.m7714constructorimpl((((long) r100.getHeight()) & BodyPartID.bodyIdMax) | r113);
    L8:
        this(r100, r102, r110, null);
    }
}
