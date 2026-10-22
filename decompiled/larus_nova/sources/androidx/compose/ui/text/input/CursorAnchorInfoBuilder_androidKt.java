package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u001ad\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0001\u001a,\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a4\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¨\u0006\u001d"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "containsInclusive", "x", "", "y", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CursorAnchorInfoBuilder_androidKt {
    private static final boolean containsInclusive(Rect r100, float r101, float r102) {
        float r103 = r100.getLeft();
        if (r101 <= r100.getRight()) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L17;
        float r105 = r100.getTop();
        if (r102 <= r100.getBottom()) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == false) goto L17;
        return true;
    L12:
        if (r105 > r102) goto L14;
        r106 = true;
    L17:
        return false;
    L5:
        if (r103 > r101) goto L7;
        r104 = true;
        goto L8
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder r100, int r110, OffsetMapping r111, TextLayoutResult r112, Rect r113) {
        if (r110 >= 0) goto L4;
        return r100;
    L4:
        int r114 = r111.originalToTransformed(r110);
        Rect r115 = r112.getCursorRect(r114);
        float r101 = RangesKt.coerceIn(r115.getLeft(), 0.0f, (int) (r112.m6969getSizeYbymL2g() >> 32));
        boolean r102 = containsInclusive(r113, r101, r115.getTop());
        boolean r116 = containsInclusive(r113, r101, r115.getBottom());
        int r103 = 1;
        if (r112.getBidiRunDirection(r114) != ResolvedTextDirection.Rtl) goto L7;
        boolean r117 = true;
    L8:
        if (r102 == true) goto L12;
        if (r116 == true) goto L12;
        r103 = 0;
    L12:
        if (r102 == false) goto L14;
        if (r116 == false) goto L14;
    L15:
        if (r117 == false) goto L17;
        int r104 = r103 | 4;
    L18:
        r100.setInsertionMarkerLocation(r101, r115.getTop(), r115.getBottom(), r115.getBottom(), r104);
        return r100;
    L17:
        r104 = r103;
    L14:
        r103 = r103 | 2;
        goto L15
    L7:
        r117 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [int] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.view.inputmethod.CursorAnchorInfo$Builder] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder r110, int r111, int r112, OffsetMapping r210, TextLayoutResult r211, Rect r212) {
        int r100 = r111;
        int r101 = r210.originalToTransformed(r100);
        int r102 = r210.originalToTransformed(r112);
        float[] r103 = new float[(r102 - r101) * 4];
        r211.getMultiParagraph().m6858fillBoundingBoxes8ffj60Q(TextRangeKt.TextRange(r101, r102), r103, 0);
    L3:
        if (r100 >= r112) goto L14;
        int r104 = r210.originalToTransformed(r100);
        int r105 = (r104 - r101) * 4;
        Rect r106 = new Rect(r103[r105], r103[r105 + 1], r103[r105 + 2], r103[r105 + 3]);
        boolean r107 = r212.overlaps(r106);
        if (containsInclusive(r212, r106.getLeft(), r106.getTop()) == false) goto L8;
        ?? r108 = r107;
        if (containsInclusive(r212, r106.getRight(), r106.getBottom()) == false) goto L8;
    L10:
        if (r211.getBidiRunDirection(r104) != ResolvedTextDirection.Rtl) goto L12;
        ?? r113 = r108 | 4;
    L13:
        int r114 = r100;
        r110.addCharacterBounds(r114, r106.getLeft(), r106.getTop(), r106.getRight(), r106.getBottom(), r113);
        r100 = r100 + 1;
        goto L3
    L12:
        r113 = r108;
    L8:
        r108 = (r107 ? 1 : 0) | 2;
        goto L10
    L14:
        return r110;
    }

    @Deprecated(message = "Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this function in foundation is used by the legacy BasicTextField.")
    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder r100, TextFieldValue r110, OffsetMapping r111, TextLayoutResult r112, Matrix r113, Rect r114, Rect r115, boolean r116, boolean r117, boolean r118, boolean r119) {
        r100.reset();
        r100.setMatrix(r113);
        int r101 = TextRange.m6996getMinimpl(r110.m7249getSelectiond9O1mEE());
        r100.setSelectionRange(r101, TextRange.m6995getMaximpl(r110.m7249getSelectiond9O1mEE()));
        if (r116 == false) goto L5;
        setInsertionMarker(r100, r101, r111, r112, r114);
    L5:
        if (r117 == false) goto L20;
        TextRange r102 = r110.m7248getCompositionMzsxiRA();
        if (r102 == null) goto L9;
        int r103 = TextRange.m6996getMinimpl(r102.m7002unboximpl());
    L10:
        TextRange r104 = r110.m7248getCompositionMzsxiRA();
        if (r104 == null) goto L13;
        int r105 = TextRange.m6995getMaximpl(r104.m7002unboximpl());
    L14:
        boolean r106 = false;
        if (r103 < 0) goto L18;
        if (r103 >= r105) goto L18;
        r106 = true;
    L18:
        if (r106 == false) goto L20;
        r100.setComposingText(r103, r110.getText().subSequence(r103, r105));
        addCharacterBounds(r100, r103, r105, r111, r112, r114);
        goto L20
    L13:
        r105 = -1;
        goto L14
    L9:
        r103 = -1;
    L20:
        int r107 = Build.VERSION.SDK_INT;
        if (r107 < 33) goto L25;
        if (r118 == false) goto L25;
        CursorAnchorInfoApi33Helper.setEditorBoundsInfo(r100, r115);
    L25:
        if (r107 < 34) goto L29;
        if (r119 == false) goto L29;
        CursorAnchorInfoApi34Helper.addVisibleLineBounds(r100, r112, r114);
    L29:
        return r100.build();
    }

    public static /* synthetic */ CursorAnchorInfo build$default(CursorAnchorInfo.Builder r110, TextFieldValue r111, OffsetMapping r112, TextLayoutResult r113, Matrix r114, Rect r115, Rect r210, boolean r211, boolean r212, boolean r213, boolean r214, int r215, Object r216) {
        if ((r215 & 64) == 0) goto L5;
        boolean r116 = true;
    L7:
        if ((r215 & 128) == 0) goto L9;
        boolean r117 = true;
    L11:
        if ((r215 & 256) == 0) goto L13;
        boolean r118 = true;
    L15:
        if ((r215 & 512) == 0) goto L17;
        boolean r119 = true;
    L19:
        return build(r110, r111, r112, r113, r114, r115, r210, r116, r117, r118, r119);
    L17:
        r119 = r214;
        goto L19
    L13:
        r118 = r213;
        goto L15
    L9:
        r117 = r212;
        goto L11
    L5:
        r116 = r211;
        goto L7
    }
}
