package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\f"}, d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(TextLayoutResult r100, int r101, boolean r102, boolean r103) {
        boolean r104 = false;
        if (r102 == false) goto L5;
        if (r103 == true) goto L5;
    L7:
        int r105 = r101;
    L10:
        if (r100.getBidiRunDirection(r105) != r100.getParagraphDirection(r101)) goto L13;
        r104 = true;
    L13:
        return r100.getHorizontalPosition(r101, r104);
    L5:
        if (r102 == true) goto L8;
        if (r103 == true) goto L7;
    L8:
        r105 = Math.max(r101 - 1, 0);
        goto L10
    }

    public static final long getSelectionHandleCoordinates(TextLayoutResult r100, int r101, boolean r102, boolean r103) {
        int r104 = r100.getLineForOffset(r101);
        if (r104 >= r100.getLineCount()) goto L5;
        float r105 = RangesKt.coerceIn(getHorizontalPosition(r100, r101, r102, r103), 0.0f, (int) (r100.m6969getSizeYbymL2g() >> 32));
        float r106 = RangesKt.coerceIn(r100.getLineBottom(r104), 0.0f, (int) (r100.m6969getSizeYbymL2g() & BodyPartID.bodyIdMax));
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r105) << 32) | (Float.floatToRawIntBits(r106) & BodyPartID.bodyIdMax));
    L5:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    }
}
