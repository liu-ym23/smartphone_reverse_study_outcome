package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%J\u0018\u0010*\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\b\b\u0002\u0010+\u001a\u00020\u0018J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020%J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010)\u001a\u00020%J\u000e\u0010.\u001a\u00020\u00122\u0006\u0010)\u001a\u00020%J\u000e\u0010/\u001a\u00020\u00122\u0006\u0010)\u001a\u00020%J\u000e\u00100\u001a\u00020\u00122\u0006\u0010)\u001a\u00020%J\u000e\u00101\u001a\u00020\u00122\u0006\u0010)\u001a\u00020%J\u000e\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%J\u000e\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u0012J\u0016\u00106\u001a\u00020\u00122\u0006\u00103\u001a\u00020%2\u0006\u00107\u001a\u00020\u0018J\u000e\u00108\u001a\u0002092\u0006\u00103\u001a\u00020%J\u000e\u0010:\u001a\u0002092\u0006\u00103\u001a\u00020%J\u0015\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020=¢\u0006\u0004\b>\u0010?J\u000e\u0010@\u001a\u00020!2\u0006\u00103\u001a\u00020%J\u0015\u0010A\u001a\u00020B2\u0006\u00103\u001a\u00020%¢\u0006\u0004\bC\u0010DJ\u000e\u0010E\u001a\u00020!2\u0006\u00103\u001a\u00020%J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%J!\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020\u00182\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010O\u001a\u00020%H\u0016J\b\u0010P\u001a\u00020QH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006R"}, d2 = {"Landroidx/compose/ui/text/TextLayoutResult;", "", "layoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "size", "Landroidx/compose/ui/unit/IntSize;", "<init>", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/MultiParagraph;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "getMultiParagraph", "()Landroidx/compose/ui/text/MultiParagraph;", "getSize-YbymL2g", "()J", "J", "firstBaseline", "", "getFirstBaseline", "()F", "lastBaseline", "getLastBaseline", "didOverflowHeight", "", "getDidOverflowHeight", "()Z", "didOverflowWidth", "getDidOverflowWidth", "hasVisualOverflow", "getHasVisualOverflow", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "lineCount", "", "getLineCount", "()I", "getLineStart", "lineIndex", "getLineEnd", "visibleEnd", "isLineEllipsized", "getLineTop", "getLineBaseline", "getLineBottom", "getLineLeft", "getLineRight", "getLineForOffset", "offset", "getLineForVerticalPosition", "vertical", "getHorizontalPosition", "usePrimaryDirection", "getParagraphDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getBoundingBox", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "getCursorRect", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "copy", "copy-O0kMr_c", "(Landroidx/compose/ui/text/TextLayoutInput;J)Landroidx/compose/ui/text/TextLayoutResult;", "equals", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutResult {
    public static final int $stable = 8;
    private final float firstBaseline;
    private final float lastBaseline;
    private final TextLayoutInput layoutInput;
    private final MultiParagraph multiParagraph;
    private final List<Rect> placeholderRects;
    private final long size;

    public /* synthetic */ TextLayoutResult(TextLayoutInput r100, MultiParagraph r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public final boolean getDidOverflowHeight() {
        if (this.multiParagraph.getDidExceedMaxLines() == false) goto L5;
    L8:
        return true;
    L5:
        if (((int) (this.size & BodyPartID.bodyIdMax)) < this.multiParagraph.getHeight()) goto L8;
        return false;
    }

    public final boolean getDidOverflowWidth() {
        if (((int) (this.size >> 32)) >= this.multiParagraph.getWidth()) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getLineCount() {
        return this.multiParagraph.getLineCount();
    }

    public int hashCode() {
        return (((((((((this.layoutInput.hashCode() * 31) + this.multiParagraph.hashCode()) * 31) + IntSize.m7720hashCodeimpl(this.size)) * 31) + Float.floatToIntBits(this.firstBaseline)) * 31) + Float.floatToIntBits(this.lastBaseline)) * 31) + this.placeholderRects.hashCode();
    }

    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.layoutInput + ", multiParagraph=" + this.multiParagraph + ", size=" + IntSize.m7722toStringimpl(this.size) + ", firstBaseline=" + this.firstBaseline + ", lastBaseline=" + this.lastBaseline + ", placeholderRects=" + this.placeholderRects + ')';
    }

    public final boolean getHasVisualOverflow() {
        if (getDidOverflowWidth() == false) goto L5;
    L8:
        return true;
    L5:
        if (getDidOverflowHeight() == true) goto L8;
        return false;
    }

    public final float getFirstBaseline() {
        return this.firstBaseline;
    }

    public final float getLastBaseline() {
        return this.lastBaseline;
    }

    public final TextLayoutInput getLayoutInput() {
        return this.layoutInput;
    }

    public final MultiParagraph getMultiParagraph() {
        return this.multiParagraph;
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m6969getSizeYbymL2g() {
        return this.size;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextLayoutResult) == true) goto L8;
        return false;
    L8:
        TextLayoutResult r101 = (TextLayoutResult) r100;
        if (Intrinsics.areEqual(this.layoutInput, r101.layoutInput) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.multiParagraph, r101.multiParagraph) == true) goto L15;
        return false;
    L15:
        if (IntSize.m7717equalsimpl0(this.size, r101.size) == true) goto L18;
        return false;
    L18:
        if (this.firstBaseline != r101.firstBaseline) goto L20;
        boolean r102 = true;
    L21:
        if (r102 == true) goto L24;
        return false;
    L24:
        if (this.lastBaseline != r101.lastBaseline) goto L26;
        boolean r103 = true;
    L27:
        if (r103 == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.placeholderRects, r101.placeholderRects) == true) goto L32;
        return false;
    L32:
        return true;
    L26:
        r103 = false;
        goto L27
    L20:
        r102 = false;
        goto L21
    }

    public final ResolvedTextDirection getBidiRunDirection(int r100) {
        return this.multiParagraph.getBidiRunDirection(r100);
    }

    public final Rect getBoundingBox(int r100) {
        return this.multiParagraph.getBoundingBox(r100);
    }

    public final Rect getCursorRect(int r100) {
        return this.multiParagraph.getCursorRect(r100);
    }

    public final float getLineBaseline(int r100) {
        return this.multiParagraph.getLineBaseline(r100);
    }

    public final float getLineBottom(int r100) {
        return this.multiParagraph.getLineBottom(r100);
    }

    public final int getLineForOffset(int r100) {
        return this.multiParagraph.getLineForOffset(r100);
    }

    public final int getLineForVerticalPosition(float r100) {
        return this.multiParagraph.getLineForVerticalPosition(r100);
    }

    public final float getLineLeft(int r100) {
        return this.multiParagraph.getLineLeft(r100);
    }

    public final float getLineRight(int r100) {
        return this.multiParagraph.getLineRight(r100);
    }

    public final int getLineStart(int r100) {
        return this.multiParagraph.getLineStart(r100);
    }

    public final float getLineTop(int r100) {
        return this.multiParagraph.getLineTop(r100);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m6968getOffsetForPositionk4lQ0M(long r100) {
        return this.multiParagraph.m6859getOffsetForPositionk4lQ0M(r100);
    }

    public final ResolvedTextDirection getParagraphDirection(int r100) {
        return this.multiParagraph.getParagraphDirection(r100);
    }

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m6970getWordBoundaryjx7JFs(int r100) {
        return this.multiParagraph.m6861getWordBoundaryjx7JFs(r100);
    }

    public final boolean isLineEllipsized(int r100) {
        return this.multiParagraph.isLineEllipsized(r100);
    }

    /* JADX INFO: renamed from: copy-O0kMr_c, reason: not valid java name */
    public final TextLayoutResult m6967copyO0kMr_c(TextLayoutInput r100, long r101) {
        return new TextLayoutResult(r100, this.multiParagraph, r101, null);
    }

    public final float getHorizontalPosition(int r100, boolean r101) {
        return this.multiParagraph.getHorizontalPosition(r100, r101);
    }

    public final int getLineEnd(int r100, boolean r101) {
        return this.multiParagraph.getLineEnd(r100, r101);
    }

    public final Path getPathForRange(int r100, int r101) {
        return this.multiParagraph.getPathForRange(r100, r101);
    }

    private TextLayoutResult(TextLayoutInput r100, MultiParagraph r101, long r102) {
        this.layoutInput = r100;
        this.multiParagraph = r101;
        this.size = r102;
        this.firstBaseline = r101.getFirstBaseline();
        this.lastBaseline = r101.getLastBaseline();
        this.placeholderRects = r101.getPlaceholderRects();
    }

    /* JADX INFO: renamed from: copy-O0kMr_c$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m6966copyO0kMr_c$default(TextLayoutResult r100, TextLayoutInput r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.layoutInput;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.size;
    L9:
        return r100.m6967copyO0kMr_c(r101, r102);
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResult r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.getLineEnd(r101, r102);
    }
}
