package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007\u001a5\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0002\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"TouchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "start", "", "top", "end", "bottom", "(IIII)J", "DpTouchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "Landroidx/compose/ui/unit/Dp;", "DpTouchBoundsExpansion-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TouchBoundsExpansionKt {
    /* JADX INFO: renamed from: DpTouchBoundsExpansion-a9UjIt4, reason: not valid java name */
    public static final DpTouchBoundsExpansion m6656DpTouchBoundsExpansiona9UjIt4(float r100, float r101, float r110, float r111) {
        return new DpTouchBoundsExpansion(r100, r101, r110, r111, true, null);
    }

    public static final long TouchBoundsExpansion(int r100, int r101, int r102, int r110) {
        boolean r103 = true;
        if (r100 < 0) goto L6;
        if (r100 >= 32768) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("Start must be in the range of 0 .. 32767");
    L9:
        if (r101 < 0) goto L12;
        if (r101 >= 32768) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
        InlineClassHelperKt.throwIllegalArgumentException("Top must be in the range of 0 .. 32767");
    L15:
        if (r102 < 0) goto L18;
        if (r102 >= 32768) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L21;
        InlineClassHelperKt.throwIllegalArgumentException("End must be in the range of 0 .. 32767");
    L21:
        if (r110 < 0) goto L24;
        if (r110 >= 32768) goto L24;
    L25:
        if (r103 == true) goto L28;
        InlineClassHelperKt.throwIllegalArgumentException("Bottom must be in the range of 0 .. 32767");
    L28:
        return TouchBoundsExpansion.m6642constructorimpl(TouchBoundsExpansion.Companion.pack$ui_release(r100, r101, r102, r110, true));
    L24:
        r103 = false;
    L18:
        r106 = false;
    L12:
        r105 = false;
    L6:
        r104 = false;
        goto L7
    }

    /* JADX INFO: renamed from: DpTouchBoundsExpansion-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ DpTouchBoundsExpansion m6657DpTouchBoundsExpansiona9UjIt4$default(float r100, float r101, float r102, float r103, int r104, Object r105) {
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
        return m6656DpTouchBoundsExpansiona9UjIt4(r100, r101, r102, r103);
    }

    public static /* synthetic */ long TouchBoundsExpansion$default(int r100, int r101, int r102, int r103, int r104, Object r105) {
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
        return TouchBoundsExpansion(r100, r101, r102, r103);
    }
}
