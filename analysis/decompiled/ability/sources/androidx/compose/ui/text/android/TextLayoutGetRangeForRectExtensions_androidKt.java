package androidx.compose.ui.text.android;

import D7.q;
import S7.n;
import Y7.d;
import Y7.f;
import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.LayoutHelper;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\r\u001aO\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a]\u0010\u0013\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001am\u0010\u001e\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001am\u0010 \u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b \u0010\u001f\u001a'\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#\u001a'\u0010$\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b$\u0010#\u001a#\u0010'\u001a\u00020\n*\u00020\u00052\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0019H\u0002¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "Landroid/text/Layout;", "layout", "Landroidx/compose/ui/text/android/LayoutHelper;", "layoutHelper", "Landroid/graphics/RectF;", "rect", "", "granularity", "Lkotlin/Function2;", "", "inclusionStrategy", "", "getRangeForRect", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/text/Layout;Landroidx/compose/ui/text/android/LayoutHelper;Landroid/graphics/RectF;ILS7/n;)[I", "lineIndex", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "segmentFinder", "getStart", "getStartOrEndOffsetForRectWithinLine", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/text/Layout;Landroidx/compose/ui/text/android/LayoutHelper;ILandroid/graphics/RectF;Landroidx/compose/ui/text/android/selection/SegmentFinder;LS7/n;Z)I", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "lineStart", "lineTop", "lineBottom", "", "runLeft", "runRight", "", "horizontalBounds", "getStartOffsetForRectWithinRun", "(Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;Landroid/graphics/RectF;IIIFF[FLandroidx/compose/ui/text/android/selection/SegmentFinder;LS7/n;)I", "getEndOffsetForRectWithinRun", TypedValues.CycleType.S_WAVE_OFFSET, "getCharacterLeftBounds", "(II[F)F", "getCharacterRightBounds", "left", "right", "horizontalOverlap", "(Landroid/graphics/RectF;FF)Z", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextLayoutGetRangeForRectExtensions_androidKt {
    private static final float getCharacterLeftBounds(int i, int i6, float[] fArr) {
        return fArr[(i - i6) * 2];
    }

    private static final float getCharacterRightBounds(int i, int i6, float[] fArr) {
        return fArr[((i - i6) * 2) + 1];
    }

    private static final int getEndOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i6, int i10, float f, float f7, float[] fArr, SegmentFinder segmentFinder, n nVar) {
        int start;
        int iNextEndBoundary;
        if (!horizontalOverlap(rectF, f, f7)) {
            return -1;
        }
        if ((bidiRun.isRtl() || rectF.right < f7) && (!bidiRun.isRtl() || rectF.left > f)) {
            start = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - start > 1) {
                int i11 = (end + start) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i11, i, fArr);
                if ((bidiRun.isRtl() || characterLeftBounds <= rectF.right) && (!bidiRun.isRtl() || characterLeftBounds >= rectF.left)) {
                    start = i11;
                } else {
                    end = i11;
                }
            }
            if (bidiRun.isRtl()) {
                start = end;
            }
        } else {
            start = bidiRun.getEnd() - 1;
        }
        int iPreviousStartBoundary = segmentFinder.previousStartBoundary(start + 1);
        if (iPreviousStartBoundary == -1 || (iNextEndBoundary = segmentFinder.nextEndBoundary(iPreviousStartBoundary)) <= bidiRun.getStart()) {
            return -1;
        }
        int start2 = bidiRun.getStart();
        if (iPreviousStartBoundary < start2) {
            iPreviousStartBoundary = start2;
        }
        int end2 = bidiRun.getEnd();
        if (iNextEndBoundary > end2) {
            iNextEndBoundary = end2;
        }
        RectF rectF2 = new RectF(0.0f, i6, 0.0f, i10);
        while (true) {
            rectF2.left = bidiRun.isRtl() ? getCharacterLeftBounds(iNextEndBoundary - 1, i, fArr) : getCharacterLeftBounds(iPreviousStartBoundary, i, fArr);
            rectF2.right = bidiRun.isRtl() ? getCharacterRightBounds(iPreviousStartBoundary, i, fArr) : getCharacterRightBounds(iNextEndBoundary - 1, i, fArr);
            if (((Boolean) nVar.invoke(rectF2, rectF)).booleanValue()) {
                return iNextEndBoundary;
            }
            iNextEndBoundary = segmentFinder.previousEndBoundary(iNextEndBoundary);
            if (iNextEndBoundary == -1 || iNextEndBoundary <= bidiRun.getStart()) {
                break;
            }
            int iPreviousStartBoundary2 = segmentFinder.previousStartBoundary(iNextEndBoundary);
            int start3 = bidiRun.getStart();
            iPreviousStartBoundary = iPreviousStartBoundary2 < start3 ? start3 : iPreviousStartBoundary2;
        }
        return -1;
    }

    public static final int[] getRangeForRect(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, RectF rectF, int i, n nVar) {
        int i6;
        SegmentFinder wordSegmentFinder = i == 1 ? new WordSegmentFinder(textLayout.getText(), textLayout.getWordIterator()) : SegmentFinder_androidKt.createGraphemeClusterSegmentFinder(textLayout.getText(), textLayout.getTextPaint());
        int lineForVertical = layout.getLineForVertical((int) rectF.top);
        if (rectF.top > textLayout.getLineBottom(lineForVertical) && (lineForVertical = lineForVertical + 1) >= textLayout.getLineCount()) {
            return null;
        }
        int i10 = lineForVertical;
        int lineForVertical2 = layout.getLineForVertical((int) rectF.bottom);
        if (lineForVertical2 == 0 && rectF.bottom < textLayout.getLineTop(0)) {
            return null;
        }
        int startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i10, rectF, wordSegmentFinder, nVar, true);
        while (true) {
            i6 = i10;
            if (startOrEndOffsetForRectWithinLine != -1 || i6 >= lineForVertical2) {
                break;
            }
            i10 = i6 + 1;
            startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i10, rectF, wordSegmentFinder, nVar, true);
        }
        if (startOrEndOffsetForRectWithinLine == -1) {
            return null;
        }
        int startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, lineForVertical2, rectF, wordSegmentFinder, nVar, false);
        while (startOrEndOffsetForRectWithinLine2 == -1 && i6 < lineForVertical2) {
            int i11 = lineForVertical2 - 1;
            startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i11, rectF, wordSegmentFinder, nVar, false);
            lineForVertical2 = i11;
        }
        if (startOrEndOffsetForRectWithinLine2 == -1) {
            return null;
        }
        return new int[]{wordSegmentFinder.previousStartBoundary(startOrEndOffsetForRectWithinLine + 1), wordSegmentFinder.nextEndBoundary(startOrEndOffsetForRectWithinLine2 - 1)};
    }

    private static final int getStartOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i6, int i10, float f, float f7, float[] fArr, SegmentFinder segmentFinder, n nVar) {
        int start;
        int iPreviousStartBoundary;
        if (!horizontalOverlap(rectF, f, f7)) {
            return -1;
        }
        if ((bidiRun.isRtl() || rectF.left > f) && (!bidiRun.isRtl() || rectF.right < f7)) {
            start = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - start > 1) {
                int i11 = (end + start) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i11, i, fArr);
                if ((bidiRun.isRtl() || characterLeftBounds <= rectF.left) && (!bidiRun.isRtl() || characterLeftBounds >= rectF.right)) {
                    start = i11;
                } else {
                    end = i11;
                }
            }
            if (bidiRun.isRtl()) {
                start = end;
            }
        } else {
            start = bidiRun.getStart();
        }
        int iNextEndBoundary = segmentFinder.nextEndBoundary(start);
        if (iNextEndBoundary == -1 || (iPreviousStartBoundary = segmentFinder.previousStartBoundary(iNextEndBoundary)) >= bidiRun.getEnd()) {
            return -1;
        }
        int start2 = bidiRun.getStart();
        if (iPreviousStartBoundary < start2) {
            iPreviousStartBoundary = start2;
        }
        int end2 = bidiRun.getEnd();
        if (iNextEndBoundary > end2) {
            iNextEndBoundary = end2;
        }
        RectF rectF2 = new RectF(0.0f, i6, 0.0f, i10);
        while (true) {
            rectF2.left = bidiRun.isRtl() ? getCharacterLeftBounds(iNextEndBoundary - 1, i, fArr) : getCharacterLeftBounds(iPreviousStartBoundary, i, fArr);
            rectF2.right = bidiRun.isRtl() ? getCharacterRightBounds(iPreviousStartBoundary, i, fArr) : getCharacterRightBounds(iNextEndBoundary - 1, i, fArr);
            if (((Boolean) nVar.invoke(rectF2, rectF)).booleanValue()) {
                return iPreviousStartBoundary;
            }
            iPreviousStartBoundary = segmentFinder.nextStartBoundary(iPreviousStartBoundary);
            if (iPreviousStartBoundary == -1 || iPreviousStartBoundary >= bidiRun.getEnd()) {
                break;
            }
            int iNextEndBoundary2 = segmentFinder.nextEndBoundary(iPreviousStartBoundary);
            int end3 = bidiRun.getEnd();
            iNextEndBoundary = iNextEndBoundary2 > end3 ? end3 : iNextEndBoundary2;
        }
        return -1;
    }

    private static final int getStartOrEndOffsetForRectWithinLine(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, int i, RectF rectF, SegmentFinder segmentFinder, n nVar, boolean z10) {
        d dVar;
        int lineTop = layout.getLineTop(i);
        int lineBottom = layout.getLineBottom(i);
        int lineStart = layout.getLineStart(i);
        int lineEnd = layout.getLineEnd(i);
        if (lineStart != lineEnd) {
            float[] fArr = new float[(lineEnd - lineStart) * 2];
            textLayout.fillLineHorizontalBounds$ui_text(i, fArr);
            LayoutHelper.BidiRun[] lineBidiRuns$ui_text = layoutHelper.getLineBidiRuns$ui_text(i);
            if (z10) {
                k.f(lineBidiRuns$ui_text, "<this>");
                dVar = new f(0, lineBidiRuns$ui_text.length - 1, 1);
            } else {
                dVar = new d(q.q0(lineBidiRuns$ui_text), 0, -1);
            }
            int i6 = dVar.f1569a;
            int i10 = dVar.b;
            int i11 = dVar.c;
            if ((i11 > 0 && i6 <= i10) || (i11 < 0 && i10 <= i6)) {
                int i12 = i6;
                while (true) {
                    LayoutHelper.BidiRun bidiRun = lineBidiRuns$ui_text[i12];
                    float characterLeftBounds = bidiRun.isRtl() ? getCharacterLeftBounds(bidiRun.getEnd() - 1, lineStart, fArr) : getCharacterLeftBounds(bidiRun.getStart(), lineStart, fArr);
                    float characterRightBounds = bidiRun.isRtl() ? getCharacterRightBounds(bidiRun.getStart(), lineStart, fArr) : getCharacterRightBounds(bidiRun.getEnd() - 1, lineStart, fArr);
                    int startOffsetForRectWithinRun = z10 ? getStartOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, characterLeftBounds, characterRightBounds, fArr, segmentFinder, nVar) : getEndOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, characterLeftBounds, characterRightBounds, fArr, segmentFinder, nVar);
                    if (startOffsetForRectWithinRun < 0) {
                        if (i12 == i10) {
                            break;
                        }
                        i12 += i11;
                    } else {
                        return startOffsetForRectWithinRun;
                    }
                }
            }
        }
        return -1;
    }

    private static final boolean horizontalOverlap(RectF rectF, float f, float f7) {
        return f7 >= rectF.left && f <= rectF.right;
    }
}
