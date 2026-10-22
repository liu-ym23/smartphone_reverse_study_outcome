package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\u001aH\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0000\u001aV\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0012\u001a\u00020\rH\u0002\u001af\u0010\u0013\u001a\u00020\n*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u001af\u0010\u001d\u001a\u00020\n*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u001a \u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a \u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u001c\u0010!\u001a\u00020\r*\u00020\b2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0002¨\u0006$"}, d2 = {"getRangeForRect", "", "Landroidx/compose/ui/text/android/TextLayout;", "layout", "Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", SVGRenderEngine.RECT, "Landroid/graphics/RectF;", "granularity", "", "inclusionStrategy", "Lkotlin/Function2;", "", "getStartOrEndOffsetForRectWithinLine", "lineIndex", "segmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "getStart", "getStartOffsetForRectWithinRun", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "lineStart", "lineTop", "lineBottom", "runLeft", "", "runRight", "horizontalBounds", "", "getEndOffsetForRectWithinRun", "getCharacterLeftBounds", "offset", "getCharacterRightBounds", "horizontalOverlap", "left", "right", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutGetRangeForRectExtensions_androidKt {
    private static final float getCharacterLeftBounds(int r100, int r101, float[] r102) {
        return r102[(r100 - r101) * 2];
    }

    private static final float getCharacterRightBounds(int r100, int r101, float[] r102) {
        return r102[((r100 - r101) * 2) + 1];
    }

    private static final boolean horizontalOverlap(RectF r100, float r101, float r102) {
        if (r102 >= r100.left) goto L5;
    L7:
        return false;
    L5:
        if (r101 > r100.right) goto L7;
        return true;
    }

    public static final int[] getRangeForRect(TextLayout r110, Layout r111, LayoutHelper r210, RectF r211, int r212, Function2<? super RectF, ? super RectF, Boolean> r213) {
        if (r212 != 1) goto L5;
        SegmentFinder r100 = new WordSegmentFinder(r110.getText(), r110.getWordIterator());
    L6:
        SegmentFinder r112 = r100;
        int r101 = r111.getLineForVertical((int) r211.top);
        if (r211.top <= r110.getLineBottom(r101)) goto L11;
        r101 = r101 + 1;
        if (r101 < r110.getLineCount()) goto L11;
        return null;
    L11:
        int r113 = r101;
        int r114 = r111.getLineForVertical((int) r211.bottom);
        if (r114 == 0) goto L14;
    L16:
        int r102 = getStartOrEndOffsetForRectWithinLine(r110, r111, r210, r113, r211, r112, r213, true);
    L17:
        int r103 = r113;
        int r115 = r102;
        if (r115 != (-1)) goto L21;
        if (r103 >= r114) goto L21;
        r113 = r103 + 1;
        r102 = getStartOrEndOffsetForRectWithinLine(r110, r111, r210, r113, r211, r112, r213, true);
    L21:
        if (r115 != (-1)) goto L23;
        return null;
    L23:
        int r104 = getStartOrEndOffsetForRectWithinLine(r110, r111, r210, r114, r211, r112, r213, false);
    L24:
        if (r104 != (-1)) goto L27;
        if (r103 >= r114) goto L27;
        r114 = r114 - 1;
        r104 = getStartOrEndOffsetForRectWithinLine(r110, r111, r210, r114, r211, r112, r213, false);
    L27:
        if (r104 != (-1)) goto L31;
        return null;
    L31:
        return new int[]{r112.previousStartBoundary(r115 + 1), r112.nextEndBoundary(r104 - 1)};
    L14:
        if (r211.bottom >= r110.getLineTop(0)) goto L16;
        return null;
    L5:
        r100 = SegmentFinder_androidKt.createGraphemeClusterSegmentFinder(r110.getText(), r110.getTextPaint());
        goto L6
    }

    private static final int getStartOrEndOffsetForRectWithinLine(TextLayout r110, Layout r111, LayoutHelper r112, int r210, RectF r211, SegmentFinder r212, Function2<? super RectF, ? super RectF, Boolean> r213, boolean r214) {
        int r113 = r111.getLineTop(r210);
        int r114 = r111.getLineBottom(r210);
        int r115 = r111.getLineStart(r210);
        int r100 = r111.getLineEnd(r210);
        if (r115 != r100) goto L5;
        return -1;
    L5:
        float[] r116 = new float[(r100 - r115) * 2];
        r110.fillLineHorizontalBounds$ui_text(r210, r116);
        LayoutHelper.BidiRun[] r117 = r112.getLineBidiRuns$ui_text(r210);
        if (r214 == false) goto L8;
        IntProgression r101 = ArraysKt.getIndices(r117);
    L9:
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        int r118 = r101.getStep();
        if (r118 <= 0) goto L12;
        if (r102 > r103) goto L12;
    L14:
        int r104 = r102;
    L15:
        LayoutHelper.BidiRun r105 = r117[r104];
        if (r105.isRtl() == false) goto L18;
        float r106 = getCharacterLeftBounds(r105.getEnd() - 1, r115, r116);
    L19:
        float r107 = r106;
        if (r105.isRtl() == false) goto L22;
        float r108 = getCharacterRightBounds(r105.getStart(), r115, r116);
    L23:
        float r109 = r108;
        if (r214 == false) goto L26;
        int r119 = getStartOffsetForRectWithinRun(r105, r211, r115, r113, r114, r107, r109, r116, r212, r213);
    L27:
        if (r119 >= 0) goto L28;
        if (r104 == r103) goto L36;
        r104 = r104 + r118;
        r103 = r103;
        r117 = r117;
        goto L15
    L36:
        return -1;
    L28:
        return r119;
    L26:
        r119 = getEndOffsetForRectWithinRun(r105, r211, r115, r113, r114, r107, r109, r116, r212, r213);
        goto L27
    L22:
        r108 = getCharacterRightBounds(r105.getEnd() - 1, r115, r116);
        goto L23
    L18:
        r106 = getCharacterLeftBounds(r105.getStart(), r115, r116);
    L12:
        if (r118 >= 0) goto L31;
        if (r103 <= r102) goto L14;
        return -1;
    L31:
        return -1;
    L8:
        r101 = RangesKt.downTo(ArraysKt.getLastIndex(r117), 0);
        goto L9
    }

    private static final int getEndOffsetForRectWithinRun(LayoutHelper.BidiRun r100, RectF r101, int r102, int r103, int r104, float r110, float r111, float[] r112, SegmentFinder r113, Function2<? super RectF, ? super RectF, Boolean> r114) {
        if (horizontalOverlap(r101, r110, r111) == true) goto L6;
        return -1;
    L6:
        if (r100.isRtl() == true) goto L10;
        if (r101.right < r111) goto L10;
    L13:
        int r115 = r100.getEnd() - 1;
    L30:
        int r116 = r113.previousStartBoundary(r115 + 1);
        if (r116 != (-1)) goto L33;
        return -1;
    L33:
        int r117 = r113.nextEndBoundary(r116);
        if (r117 > r100.getStart()) goto L36;
        return -1;
    L36:
        int r118 = RangesKt.coerceAtLeast(r116, r100.getStart());
        int r119 = RangesKt.coerceAtMost(r117, r100.getEnd());
        RectF r105 = new RectF(0.0f, r103, 0.0f, r104);
    L38:
        if (r100.isRtl() == false) goto L40;
        float r106 = getCharacterLeftBounds(r119 - 1, r102, r112);
    L41:
        r105.left = r106;
        if (r100.isRtl() == false) goto L44;
        float r107 = getCharacterRightBounds(r118, r102, r112);
    L45:
        r105.right = r107;
        if (r114.invoke(r105, r101).booleanValue() == true) goto L47;
        r119 = r113.previousEndBoundary(r119);
        if (r119 == (-1)) goto L54;
        if (r119 <= r100.getStart()) goto L54;
        r118 = RangesKt.coerceAtLeast(r113.previousStartBoundary(r119), r100.getStart());
    L54:
        return -1;
    L47:
        return r119;
    L44:
        r107 = getCharacterRightBounds(r119 - 1, r102, r112);
        goto L45
    L40:
        r106 = getCharacterLeftBounds(r118, r102, r112);
    L10:
        if (r100.isRtl() == true) goto L12;
    L14:
        r115 = r100.getStart();
        int r120 = r100.getEnd();
    L16:
        if ((r120 - r115) <= 1) goto L28;
        int r108 = (r120 + r115) / 2;
        float r109 = getCharacterLeftBounds(r108, r102, r112);
        if (r100.isRtl() == true) goto L22;
        if (r109 <= r101.right) goto L22;
    L25:
        r120 = r108;
    L22:
        if (r100.isRtl() == false) goto L26;
        if (r109 < r101.left) goto L25;
    L26:
        r115 = r108;
        goto L16
    L28:
        if (r100.isRtl() == false) goto L30;
        r115 = r120;
        goto L30
    L12:
        if (r101.left > r110) goto L14;
        goto L13
    }

    private static final int getStartOffsetForRectWithinRun(LayoutHelper.BidiRun r100, RectF r101, int r102, int r103, int r104, float r105, float r110, float[] r111, SegmentFinder r112, Function2<? super RectF, ? super RectF, Boolean> r113) {
        if (horizontalOverlap(r101, r105, r110) == true) goto L6;
        return -1;
    L6:
        if (r100.isRtl() == true) goto L10;
        if (r101.left > r105) goto L10;
    L13:
        int r106 = r100.getStart();
    L30:
        int r107 = r112.nextEndBoundary(r106);
        if (r107 != (-1)) goto L33;
        return -1;
    L33:
        int r114 = r112.previousStartBoundary(r107);
        if (r114 < r100.getEnd()) goto L36;
        return -1;
    L36:
        int r115 = RangesKt.coerceAtLeast(r114, r100.getStart());
        int r108 = RangesKt.coerceAtMost(r107, r100.getEnd());
        RectF r109 = new RectF(0.0f, r103, 0.0f, r104);
    L38:
        if (r100.isRtl() == false) goto L40;
        float r116 = getCharacterLeftBounds(r108 - 1, r102, r111);
    L41:
        r109.left = r116;
        if (r100.isRtl() == false) goto L44;
        float r117 = getCharacterRightBounds(r115, r102, r111);
    L45:
        r109.right = r117;
        if (r113.invoke(r109, r101).booleanValue() == true) goto L47;
        r115 = r112.nextStartBoundary(r115);
        if (r115 == (-1)) goto L54;
        if (r115 >= r100.getEnd()) goto L54;
        r108 = RangesKt.coerceAtMost(r112.nextEndBoundary(r115), r100.getEnd());
    L54:
        return -1;
    L47:
        return r115;
    L44:
        r117 = getCharacterRightBounds(r108 - 1, r102, r111);
        goto L45
    L40:
        r116 = getCharacterLeftBounds(r115, r102, r111);
    L10:
        if (r100.isRtl() == true) goto L12;
    L14:
        r106 = r100.getStart();
        int r118 = r100.getEnd();
    L16:
        if ((r118 - r106) <= 1) goto L28;
        int r119 = (r118 + r106) / 2;
        float r120 = getCharacterLeftBounds(r119, r102, r111);
        if (r100.isRtl() == true) goto L22;
        if (r120 <= r101.left) goto L22;
    L25:
        r118 = r119;
    L22:
        if (r100.isRtl() == false) goto L26;
        if (r120 < r101.right) goto L25;
    L26:
        r106 = r119;
        goto L16
    L28:
        if (r100.isRtl() == false) goto L30;
        r106 = r118;
        goto L30
    L12:
        if (r101.right < r110) goto L14;
        goto L13
    }
}
