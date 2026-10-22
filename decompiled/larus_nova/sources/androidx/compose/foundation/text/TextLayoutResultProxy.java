package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u0016J\u0015\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0000¢\u0006\u0004\b'\u0010%J\u0013\u0010(\u001a\u00020\u0014*\u00020\u0014H\u0002¢\u0006\u0004\b)\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "decorationBoxCoordinates", "<init>", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getInnerTextFieldCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setInnerTextFieldCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "setDecorationBoxCoordinates", "getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "getLineForVerticalPosition", "vertical", "", "getLineEnd", "lineIndex", "visibleEnd", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "translateDecorationToInnerCoordinates", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "(J)J", "translateInnerToDecorationCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutResultProxy {
    public static final int $stable = 8;
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    private final long m1159coercedInVisibleBoundsOfInputTextMKHz9U(long r100) {
        LayoutCoordinates r101 = this.innerTextFieldCoordinates;
        if (r101 != null) goto L5;
    L11:
        Rect r102 = Rect.Companion.getZero();
    L13:
        return TextLayoutResultProxyKt.m1165access$coerceIn3MmeM6k(r100, r102);
    L5:
        if (r101.isAttached() == false) goto L9;
        LayoutCoordinates r103 = this.decorationBoxCoordinates;
        r102 = null;
        if (r103 == null) goto L10;
        r102 = LayoutCoordinates.CC.localBoundingBoxOf$default(r103, r101, false, 2, null);
    L10:
        if (r102 != null) goto L13;
    L9:
        r102 = Rect.Companion.getZero();
        goto L10
    }

    public final int getLineForVerticalPosition(float r100) {
        return this.value.getLineForVerticalPosition(Float.intBitsToFloat((int) (m1163translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1159coercedInVisibleBoundsOfInputTextMKHz9U(Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (((long) Float.floatToRawIntBits(r100)) & BodyPartID.bodyIdMax)))) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m1162isPositionOnTextk4lQ0M(long r100) {
        long r101 = m1163translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1159coercedInVisibleBoundsOfInputTextMKHz9U(r100));
        int r102 = this.value.getLineForVerticalPosition(Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r101)));
        int r103 = (int) (r101 >> 32);
        if (Float.intBitsToFloat(r103) >= this.value.getLineLeft(r102)) goto L5;
    L7:
        return false;
    L5:
        if (Float.intBitsToFloat(r103) > this.value.getLineRight(r102)) goto L7;
        return true;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates r100) {
        this.decorationBoxCoordinates = r100;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates r100) {
        this.innerTextFieldCoordinates = r100;
    }

    /* JADX INFO: renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1163translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long r100) {
        LayoutCoordinates r101 = this.innerTextFieldCoordinates;
        if (r101 == null) goto L19;
        LayoutCoordinates r102 = null;
        if (r101.isAttached() == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L21;
        LayoutCoordinates r103 = this.decorationBoxCoordinates;
        if (r103 != null) goto L13;
        return r100;
    L13:
        if (r103.isAttached() == false) goto L15;
        r102 = r103;
    L15:
        if (r102 != null) goto L18;
        return r100;
    L18:
        return r101.mo6259localPositionOfR5De75A(r102, r100);
    L21:
        return r100;
    L19:
        return r100;
    }

    /* JADX INFO: renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1164translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long r100) {
        LayoutCoordinates r101 = this.innerTextFieldCoordinates;
        if (r101 == null) goto L19;
        LayoutCoordinates r102 = null;
        if (r101.isAttached() == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L21;
        LayoutCoordinates r103 = this.decorationBoxCoordinates;
        if (r103 != null) goto L13;
        return r100;
    L13:
        if (r103.isAttached() == false) goto L15;
        r102 = r103;
    L15:
        if (r102 != null) goto L18;
        return r100;
    L18:
        return r102.mo6259localPositionOfR5De75A(r101, r100);
    L21:
        return r100;
    L19:
        return r100;
    }

    public final int getLineEnd(int r100, boolean r101) {
        return this.value.getLineEnd(r100, r101);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m1161getOffsetForPosition3MmeM6k(long r100, boolean r101) {
        if (r101 == false) goto L4;
        r100 = m1159coercedInVisibleBoundsOfInputTextMKHz9U(r100);
    L4:
        long r102 = m1163translateDecorationToInnerCoordinatesMKHz9U$foundation_release(r100);
        return this.value.m6968getOffsetForPositionk4lQ0M(r102);
    }

    public TextLayoutResultProxy(TextLayoutResult r100, LayoutCoordinates r101, LayoutCoordinates r102) {
        this.value = r100;
        this.innerTextFieldCoordinates = r101;
        this.decorationBoxCoordinates = r102;
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult r100, LayoutCoordinates r101, LayoutCoordinates r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.getLineEnd(r101, r102);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m1160getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy r100, long r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        return r100.m1161getOffsetForPosition3MmeM6k(r101, r102);
    }
}
