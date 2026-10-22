package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0003\u0010\u0012\u001a\u00020\n2\b\b\u0003\u0010\u0013\u001a\u00020\n2\b\b\u0003\u0010\u0014\u001a\u00020\n¨\u0006\u0015"}, d2 = {"CutCornerShape", "Landroidx/compose/foundation/shape/CutCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "CutCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/CutCornerShape;", "", "percent", "", "topStart", "topEnd", "bottomEnd", "bottomStart", "CutCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/CutCornerShape;", "topStartPercent", "topEndPercent", "bottomEndPercent", "bottomStartPercent", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CutCornerShapeKt {
    public static final CutCornerShape CutCornerShape(float r100) {
        return CutCornerShape(CornerSizeKt.CornerSize(r100));
    }

    /* JADX INFO: renamed from: CutCornerShape-0680j_4, reason: not valid java name */
    public static final CutCornerShape m1019CutCornerShape0680j_4(float r100) {
        return CutCornerShape(CornerSizeKt.m1018CornerSize0680j_4(r100));
    }

    public static final CutCornerShape CutCornerShape(int r100) {
        return CutCornerShape(CornerSizeKt.CornerSize(r100));
    }

    public static final CutCornerShape CutCornerShape(CornerSize r100) {
        return new CutCornerShape(r100, r100, r100, r100);
    }

    public static final CutCornerShape CutCornerShape(float r100, float r101, float r102, float r103) {
        return new CutCornerShape(CornerSizeKt.CornerSize(r100), CornerSizeKt.CornerSize(r101), CornerSizeKt.CornerSize(r102), CornerSizeKt.CornerSize(r103));
    }

    /* JADX INFO: renamed from: CutCornerShape-a9UjIt4, reason: not valid java name */
    public static final CutCornerShape m1020CutCornerShapea9UjIt4(float r100, float r101, float r102, float r103) {
        return new CutCornerShape(CornerSizeKt.m1018CornerSize0680j_4(r100), CornerSizeKt.m1018CornerSize0680j_4(r101), CornerSizeKt.m1018CornerSize0680j_4(r102), CornerSizeKt.m1018CornerSize0680j_4(r103));
    }

    public static final CutCornerShape CutCornerShape(int r100, int r101, int r102, int r103) {
        return new CutCornerShape(CornerSizeKt.CornerSize(r100), CornerSizeKt.CornerSize(r101), CornerSizeKt.CornerSize(r102), CornerSizeKt.CornerSize(r103));
    }

    public static /* synthetic */ CutCornerShape CutCornerShape$default(float r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0.0f;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = 0.0f;
    L15:
        return CutCornerShape(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: CutCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ CutCornerShape m1021CutCornerShapea9UjIt4$default(float r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Dp.m7544constructorimpl(0);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Dp.m7544constructorimpl(0);
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Dp.m7544constructorimpl(0);
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = Dp.m7544constructorimpl(0);
    L15:
        return m1020CutCornerShapea9UjIt4(r100, r101, r102, r103);
    }

    public static /* synthetic */ CutCornerShape CutCornerShape$default(int r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        return CutCornerShape(r100, r101, r102, r103);
    }
}
