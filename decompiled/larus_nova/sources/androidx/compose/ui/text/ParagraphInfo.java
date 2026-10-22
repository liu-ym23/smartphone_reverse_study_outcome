package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010 \u001a\u00020\u0005*\u00020\u0005J\n\u0010!\u001a\u00020\u0005*\u00020\u0005J\n\u0010\"\u001a\u00020\u0005*\u00020\u0005J\n\u0010#\u001a\u00020\u0005*\u00020\u0005J\n\u0010$\u001a\u00020\n*\u00020\nJ\n\u0010%\u001a\u00020\n*\u00020\nJ\u0011\u0010&\u001a\u00020'*\u00020'¢\u0006\u0004\b(\u0010)J\n\u0010*\u001a\u00020+*\u00020+J\n\u0010&\u001a\u00020+*\u00020+J\n\u0010*\u001a\u00020,*\u00020,J\u001b\u0010*\u001a\u00020-*\u00020-2\b\b\u0002\u0010.\u001a\u00020/¢\u0006\u0004\b0\u00101J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003JO\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010:\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011¨\u0006?"}, d2 = {"Landroidx/compose/ui/text/ParagraphInfo;", "", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "startIndex", "", "endIndex", "startLineIndex", "endLineIndex", "top", "", "bottom", "<init>", "(Landroidx/compose/ui/text/Paragraph;IIIIFF)V", "getParagraph", "()Landroidx/compose/ui/text/Paragraph;", "getStartIndex", "()I", "getEndIndex", "getStartLineIndex", "setStartLineIndex", "(I)V", "getEndLineIndex", "setEndLineIndex", "getTop", "()F", "setTop", "(F)V", "getBottom", "setBottom", "length", "getLength", "toLocalIndex", "toGlobalIndex", "toLocalLineIndex", "toGlobalLineIndex", "toGlobalYPosition", "toLocalYPosition", "toLocal", "Landroidx/compose/ui/geometry/Offset;", "toLocal-MK-Hz9U", "(J)J", "toGlobal", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextRange;", "treatZeroAsNull", "", "toGlobal-xdX6-G0", "(JZ)J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParagraphInfo {
    public static final int $stable = 8;
    private float bottom;
    private final int endIndex;
    private int endLineIndex;
    private final Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;

    public static /* synthetic */ ParagraphInfo copy$default(ParagraphInfo r100, Paragraph r101, int r102, int r103, int r104, int r110, float r111, float r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.paragraph;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.startIndex;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.endIndex;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.startLineIndex;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.endLineIndex;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.top;
    L20:
        float r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.bottom;
    L23:
        Paragraph r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Paragraph component1() {
        return this.paragraph;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final int component4() {
        return this.startLineIndex;
    }

    public final int component5() {
        return this.endLineIndex;
    }

    public final float component6() {
        return this.top;
    }

    public final float component7() {
        return this.bottom;
    }

    public final ParagraphInfo copy(Paragraph r110, int r111, int r112, int r113, int r114, float r115, float r116) {
        return new ParagraphInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ParagraphInfo) == true) goto L8;
        return false;
    L8:
        ParagraphInfo r101 = (ParagraphInfo) r100;
        if (Intrinsics.areEqual(this.paragraph, r101.paragraph) == true) goto L12;
        return false;
    L12:
        if (this.startIndex == r101.startIndex) goto L15;
        return false;
    L15:
        if (this.endIndex == r101.endIndex) goto L18;
        return false;
    L18:
        if (this.startLineIndex == r101.startLineIndex) goto L21;
        return false;
    L21:
        if (this.endLineIndex == r101.endLineIndex) goto L24;
        return false;
    L24:
        if (Float.compare(this.top, r101.top) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.bottom, r101.bottom) == 0) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.paragraph.hashCode() * 31) + this.startIndex) * 31) + this.endIndex) * 31) + this.startLineIndex) * 31) + this.endLineIndex) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.bottom);
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.paragraph + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.startLineIndex + ", endLineIndex=" + this.endLineIndex + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    public final int getLength() {
        return this.endIndex - this.startIndex;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public final void setBottom(float r100) {
        this.bottom = r100;
    }

    public final void setEndLineIndex(int r100) {
        this.endLineIndex = r100;
    }

    public final void setStartLineIndex(int r100) {
        this.startLineIndex = r100;
    }

    public final void setTop(float r100) {
        this.top = r100;
    }

    public final Rect toGlobal(Rect r100) {
        float r101 = this.top;
        return r100.m4619translatek4lQ0M(Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(r101) & BodyPartID.bodyIdMax)));
    }

    public final int toGlobalIndex(int r100) {
        return r100 + this.startIndex;
    }

    public final int toGlobalLineIndex(int r100) {
        return r100 + this.startLineIndex;
    }

    public final float toGlobalYPosition(float r100) {
        return r100 + this.top;
    }

    public final Rect toLocal(Rect r100) {
        float r101 = -this.top;
        return r100.m4619translatek4lQ0M(Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(r101) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: toLocal-MK-Hz9U, reason: not valid java name */
    public final long m6874toLocalMKHz9U(long r100) {
        float r101 = Float.intBitsToFloat((int) (r100 >> 32));
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) - this.top;
        long r103 = Float.floatToRawIntBits(r101);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32));
    }

    public final int toLocalIndex(int r100) {
        return RangesKt.coerceIn(r100, this.startIndex, this.endIndex) - this.startIndex;
    }

    public final int toLocalLineIndex(int r100) {
        return r100 - this.startLineIndex;
    }

    public final float toLocalYPosition(float r100) {
        return r100 - this.top;
    }

    public final Path toGlobal(Path r100) {
        float r101 = this.top;
        r100.mo4720translatek4lQ0M(Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(r101) & BodyPartID.bodyIdMax)));
        return r100;
    }

    /* JADX INFO: renamed from: toGlobal-xdX6-G0, reason: not valid java name */
    public final long m6873toGlobalxdX6G0(long r100, boolean r101) {
        if (r101 == false) goto L8;
        TextRange.Companion r102 = TextRange.Companion;
        if (TextRange.m6991equalsimpl0(r100, r102.m7003getZerod9O1mEE()) == false) goto L8;
        return r102.m7003getZerod9O1mEE();
    L8:
        return TextRangeKt.TextRange(toGlobalIndex(TextRange.m6998getStartimpl(r100)), toGlobalIndex(TextRange.m6993getEndimpl(r100)));
    }

    /* JADX INFO: renamed from: toGlobal-xdX6-G0$default, reason: not valid java name */
    public static /* synthetic */ long m6872toGlobalxdX6G0$default(ParagraphInfo r100, long r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r102 = true;
    L6:
        return r100.m6873toGlobalxdX6G0(r101, r102);
    }

    public ParagraphInfo(Paragraph r100, int r101, int r102, int r103, int r104, float r105, float r106) {
        this.paragraph = r100;
        this.startIndex = r101;
        this.endIndex = r102;
        this.startLineIndex = r103;
        this.endLineIndex = r104;
        this.top = r105;
        this.bottom = r106;
    }

    public /* synthetic */ ParagraphInfo(Paragraph r110, int r111, int r112, int r113, int r114, float r115, float r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 8) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r117 & 16) == 0) goto L9;
        int r101 = -1;
    L11:
        if ((r117 & 32) == 0) goto L13;
        float r102 = -1.0f;
    L15:
        if ((r117 & 64) == 0) goto L17;
        float r103 = -1.0f;
    L18:
        this(r110, r111, r112, r100, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
