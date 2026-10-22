package com.android.ttcjpaysdk.kmp.common.ui;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/NinePatchPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "centerSlice", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/geometry/Rect;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NinePatchPainter extends Painter {
    public static final int $stable = 8;
    private final Rect centerSlice;
    private final ImageBitmap image;
    private final long intrinsicSize;

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo5530getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        float r110 = this.image.getWidth();
        float r111 = this.image.getHeight();
        float r112 = this.centerSlice.getLeft();
        float r113 = this.centerSlice.getRight();
        float r114 = this.centerSlice.getTop();
        float r115 = this.centerSlice.getBottom();
        float r116 = Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() >> 32)) - (r110 - r113);
        float r211 = Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax)) - (r111 - r115);
        onDraw$drawPatch(r210, this, 0.0f, 0.0f, r112, r114, 0.0f, 0.0f, r112, r114);
        onDraw$drawPatch(r210, this, r112, 0.0f, r113, r114, r112, 0.0f, r116, r114);
        onDraw$drawPatch(r210, this, r113, 0.0f, r110, r114, r116, 0.0f, Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() >> 32)), r114);
        onDraw$drawPatch(r210, this, 0.0f, r114, r112, r115, 0.0f, r114, r112, r211);
        onDraw$drawPatch(r210, this, r112, r114, r113, r115, r112, r114, r116, r211);
        onDraw$drawPatch(r210, this, r113, r114, r110, r115, r116, r114, Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() >> 32)), r211);
        onDraw$drawPatch(r210, this, 0.0f, r115, r112, r111, 0.0f, r211, r112, Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax)));
        onDraw$drawPatch(r210, this, r112, r115, r113, r111, r112, r211, r116, Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax)));
        onDraw$drawPatch(r210, this, r113, r115, r110, r111, r116, r211, Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() >> 32)), Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax)));
    }

    public NinePatchPainter(ImageBitmap r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r101, "centerSlice");
        this.image = r100;
        this.centerSlice = r101;
        float r102 = r100.getWidth();
        float r103 = r100.getHeight();
        long r104 = Float.floatToRawIntBits(r102);
        this.intrinsicSize = Size.m4642constructorimpl((((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax) | (r104 << 32));
    }

    private static final void onDraw$drawPatch(DrawScope r210, NinePatchPainter r211, float r212, float r213, float r214, float r215, float r216, float r217, float r218, float r310) {
        float r100 = r214 - r212;
        float r101 = r215 - r213;
        float r102 = r218 - r216;
        float r103 = r310 - r217;
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r101 > 0.0f) goto L7;
        return;
    L7:
        if (r102 > 0.0f) goto L9;
        return;
    L9:
        if (r103 <= 0.0f) goto L15;
        ImageBitmap r104 = r211.image;
        int r105 = MathKt.roundToInt(r212);
        long r106 = IntOffset.m7670constructorimpl((((long) r105) << 32) | (((long) MathKt.roundToInt(r213)) & BodyPartID.bodyIdMax));
        int r107 = MathKt.roundToInt(r100);
        long r108 = ((long) r107) << 32;
        long r109 = IntSize.m7714constructorimpl((((long) MathKt.roundToInt(r101)) & BodyPartID.bodyIdMax) | r108);
        int r110 = MathKt.roundToInt(r216);
        long r111 = ((long) r110) << 32;
        long r112 = IntOffset.m7670constructorimpl((((long) MathKt.roundToInt(r217)) & BodyPartID.bodyIdMax) | r111);
        int r113 = MathKt.roundToInt(r102);
        long r114 = ((long) r113) << 32;
        DrawScope.CC.m5396drawImageAZ2fEMs$default(r210, r104, r106, r109, r112, IntSize.m7714constructorimpl((((long) MathKt.roundToInt(r103)) & BodyPartID.bodyIdMax) | r114), 0.0f, null, null, 0, 0, 992, null);
        return;
    }
}
