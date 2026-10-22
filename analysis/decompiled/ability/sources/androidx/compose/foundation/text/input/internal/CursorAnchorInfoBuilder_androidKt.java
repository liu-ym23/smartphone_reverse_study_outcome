package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001ax\u0010\t\u001a\u00020\n*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", "", "endOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Landroid/view/inputmethod/CursorAnchorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CursorAnchorInfoBuilder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.inputmethod.CursorAnchorInfo.Builder addCharacterBounds(android.view.inputmethod.CursorAnchorInfo.Builder r14, int r15, int r16, androidx.compose.ui.text.TextLayoutResult r17, androidx.compose.ui.geometry.Rect r18) {
        /*
            r0 = r16
            r1 = r18
            int r2 = r0 - r15
            int r2 = r2 * 4
            float[] r2 = new float[r2]
            androidx.compose.ui.text.MultiParagraph r3 = r17.getMultiParagraph()
            long r4 = androidx.compose.ui.text.TextRangeKt.TextRange(r15, r16)
            r6 = 0
            r3.m6171fillBoundingBoxes8ffj60Q(r4, r2, r6)
            r8 = r15
        L17:
            if (r8 >= r0) goto L79
            int r3 = r8 - r15
            int r3 = r3 * 4
            androidx.compose.ui.geometry.Rect r4 = new androidx.compose.ui.geometry.Rect
            r5 = r2[r3]
            int r6 = r3 + 1
            r6 = r2[r6]
            int r7 = r3 + 2
            r7 = r2[r7]
            int r3 = r3 + 3
            r3 = r2[r3]
            r4.<init>(r5, r6, r7, r3)
            boolean r3 = r1.overlaps(r4)
            float r5 = r4.getLeft()
            float r6 = r4.getTop()
            boolean r5 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r1, r5, r6)
            if (r5 == 0) goto L54
            float r5 = r4.getRight()
            float r6 = r4.getBottom()
            boolean r5 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r1, r5, r6)
            if (r5 != 0) goto L51
            goto L54
        L51:
            r5 = r17
            goto L57
        L54:
            r3 = r3 | 2
            goto L51
        L57:
            androidx.compose.ui.text.style.ResolvedTextDirection r6 = r5.getBidiRunDirection(r8)
            androidx.compose.ui.text.style.ResolvedTextDirection r7 = androidx.compose.ui.text.style.ResolvedTextDirection.Rtl
            if (r6 != r7) goto L61
            r3 = r3 | 4
        L61:
            r13 = r3
            float r9 = r4.getLeft()
            float r10 = r4.getTop()
            float r11 = r4.getRight()
            float r12 = r4.getBottom()
            r7 = r14
            r7.addCharacterBounds(r8, r9, r10, r11, r12, r13)
            int r8 = r8 + 1
            goto L17
        L79:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnchorInfoBuilder_androidKt.addCharacterBounds(android.view.inputmethod.CursorAnchorInfo$Builder, int, int, androidx.compose.ui.text.TextLayoutResult, androidx.compose.ui.geometry.Rect):android.view.inputmethod.CursorAnchorInfo$Builder");
    }

    /* renamed from: build-vxqZcH0, reason: not valid java name */
    public static final CursorAnchorInfo m1170buildvxqZcH0(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j5, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z10, boolean z11, boolean z12, boolean z13) {
        builder.reset();
        builder.setMatrix(matrix);
        int iM6309getMinimpl = TextRange.m6309getMinimpl(j5);
        builder.setSelectionRange(iM6309getMinimpl, TextRange.m6308getMaximpl(j5));
        if (z10) {
            setInsertionMarker(builder, iM6309getMinimpl, textLayoutResult, rect);
        }
        if (z11) {
            int iM6309getMinimpl2 = textRange != null ? TextRange.m6309getMinimpl(textRange.getPackedValue()) : -1;
            int iM6308getMaximpl = textRange != null ? TextRange.m6308getMaximpl(textRange.getPackedValue()) : -1;
            if (iM6309getMinimpl2 >= 0 && iM6309getMinimpl2 < iM6308getMaximpl) {
                builder.setComposingText(iM6309getMinimpl2, charSequence.subSequence(iM6309getMinimpl2, iM6308getMaximpl));
                addCharacterBounds(builder, iM6309getMinimpl2, iM6308getMaximpl, textLayoutResult, rect);
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (z12) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (i >= 34 && z13) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    /* renamed from: build-vxqZcH0$default, reason: not valid java name */
    public static /* synthetic */ CursorAnchorInfo m1171buildvxqZcH0$default(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j5, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z10, boolean z11, boolean z12, boolean z13, int i, Object obj) {
        if ((i & 128) != 0) {
            z10 = true;
        }
        if ((i & 256) != 0) {
            z11 = true;
        }
        if ((i & 512) != 0) {
            z12 = true;
        }
        if ((i & 1024) != 0) {
            z13 = true;
        }
        return m1170buildvxqZcH0(builder, charSequence, j5, textRange, textLayoutResult, matrix, rect, rect2, z10, z11, z12, z13);
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        float fT = AbstractC1451a.t(cursorRect.getLeft(), 0.0f, IntSize.m7015getWidthimpl(textLayoutResult.getSize()));
        boolean zContainsInclusive = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, fT, cursorRect.getTop());
        boolean zContainsInclusive2 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, fT, cursorRect.getBottom());
        boolean z10 = textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl;
        int i6 = (zContainsInclusive || zContainsInclusive2) ? 1 : 0;
        if (!zContainsInclusive || !zContainsInclusive2) {
            i6 |= 2;
        }
        if (z10) {
            i6 |= 4;
        }
        builder.setInsertionMarkerLocation(fT, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), i6);
        return builder;
    }
}
