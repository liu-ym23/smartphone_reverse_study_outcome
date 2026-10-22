package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.TextRange;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010 \u001a\u00020\u0005*\u00020\u0005J\n\u0010!\u001a\u00020\u0005*\u00020\u0005J\n\u0010\"\u001a\u00020\u0005*\u00020\u0005J\n\u0010#\u001a\u00020\u0005*\u00020\u0005J\n\u0010$\u001a\u00020\n*\u00020\nJ\n\u0010%\u001a\u00020\n*\u00020\nJ\u0011\u0010&\u001a\u00020'*\u00020'¢\u0006\u0004\b(\u0010)J\n\u0010*\u001a\u00020+*\u00020+J\n\u0010&\u001a\u00020+*\u00020+J\n\u0010*\u001a\u00020,*\u00020,J\u001b\u0010*\u001a\u00020-*\u00020-2\b\b\u0002\u0010.\u001a\u00020/¢\u0006\u0004\b0\u00101J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003JO\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010:\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011¨\u0006?"}, d2 = {"Landroidx/compose/ui/text/ParagraphInfo;", "", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "startIndex", "", "endIndex", "startLineIndex", "endLineIndex", "top", "", "bottom", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/Paragraph;IIIIFF)V", "getParagraph", "()Landroidx/compose/ui/text/Paragraph;", "getStartIndex", "()I", "getEndIndex", "getStartLineIndex", "setStartLineIndex", "(I)V", "getEndLineIndex", "setEndLineIndex", "getTop", "()F", "setTop", "(F)V", "getBottom", "setBottom", "length", "getLength", "toLocalIndex", "toGlobalIndex", "toLocalLineIndex", "toGlobalLineIndex", "toGlobalYPosition", "toLocalYPosition", "toLocal", "Landroidx/compose/ui/geometry/Offset;", "toLocal-MK-Hz9U", "(J)J", "toGlobal", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextRange;", "treatZeroAsNull", "", "toGlobal-xdX6-G0", "(JZ)J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ParagraphInfo {
    public static final int $stable = 8;
    private float bottom;
    private final int endIndex;
    private int endLineIndex;
    private final Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;

    public ParagraphInfo(Paragraph paragraph, int i, int i6, int i10, int i11, float f, float f7) {
        this.paragraph = paragraph;
        this.startIndex = i;
        this.endIndex = i6;
        this.startLineIndex = i10;
        this.endLineIndex = i11;
        this.top = f;
        this.bottom = f7;
    }

    public static /* synthetic */ ParagraphInfo copy$default(ParagraphInfo paragraphInfo, Paragraph paragraph, int i, int i6, int i10, int i11, float f, float f7, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            paragraph = paragraphInfo.paragraph;
        }
        if ((i12 & 2) != 0) {
            i = paragraphInfo.startIndex;
        }
        if ((i12 & 4) != 0) {
            i6 = paragraphInfo.endIndex;
        }
        if ((i12 & 8) != 0) {
            i10 = paragraphInfo.startLineIndex;
        }
        if ((i12 & 16) != 0) {
            i11 = paragraphInfo.endLineIndex;
        }
        if ((i12 & 32) != 0) {
            f = paragraphInfo.top;
        }
        if ((i12 & 64) != 0) {
            f7 = paragraphInfo.bottom;
        }
        float f9 = f;
        float f10 = f7;
        int i13 = i11;
        int i14 = i6;
        return paragraphInfo.copy(paragraph, i, i14, i10, i13, f9, f10);
    }

    /* renamed from: toGlobal-xdX6-G0$default, reason: not valid java name */
    public static /* synthetic */ long m6185toGlobalxdX6G0$default(ParagraphInfo paragraphInfo, long j5, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return paragraphInfo.m6186toGlobalxdX6G0(j5, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    /* renamed from: component5, reason: from getter */
    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    /* renamed from: component6, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    /* renamed from: component7, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    public final ParagraphInfo copy(Paragraph paragraph, int startIndex, int endIndex, int startLineIndex, int endLineIndex, float top, float bottom) {
        return new ParagraphInfo(paragraph, startIndex, endIndex, startLineIndex, endLineIndex, top, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) other;
        return k.b(this.paragraph, paragraphInfo.paragraph) && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && Float.compare(this.top, paragraphInfo.top) == 0 && Float.compare(this.bottom, paragraphInfo.bottom) == 0;
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

    public final int getLength() {
        return this.endIndex - this.startIndex;
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

    public int hashCode() {
        return Float.hashCode(this.bottom) + androidx.appfunctions.metadata.a.b(this.top, androidx.constraintlayout.core.dsl.a.a(this.endLineIndex, androidx.constraintlayout.core.dsl.a.a(this.startLineIndex, androidx.constraintlayout.core.dsl.a.a(this.endIndex, androidx.constraintlayout.core.dsl.a.a(this.startIndex, this.paragraph.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final void setBottom(float f) {
        this.bottom = f;
    }

    public final void setEndLineIndex(int i) {
        this.endLineIndex = i;
    }

    public final void setStartLineIndex(int i) {
        this.startLineIndex = i;
    }

    public final void setTop(float f) {
        this.top = f;
    }

    public final Rect toGlobal(Rect rect) {
        float f = this.top;
        return rect.m3932translatek4lQ0M(Offset.m3887constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)));
    }

    /* renamed from: toGlobal-xdX6-G0, reason: not valid java name */
    public final long m6186toGlobalxdX6G0(long j5, boolean z10) {
        if (z10) {
            TextRange.Companion companion = TextRange.INSTANCE;
            if (TextRange.m6304equalsimpl0(j5, companion.m6316getZerod9O1mEE())) {
                return companion.m6316getZerod9O1mEE();
            }
        }
        return TextRangeKt.TextRange(toGlobalIndex(TextRange.m6311getStartimpl(j5)), toGlobalIndex(TextRange.m6306getEndimpl(j5)));
    }

    public final int toGlobalIndex(int i) {
        return i + this.startIndex;
    }

    public final int toGlobalLineIndex(int i) {
        return i + this.startLineIndex;
    }

    public final float toGlobalYPosition(float f) {
        return f + this.top;
    }

    public final Rect toLocal(Rect rect) {
        float f = -this.top;
        return rect.m3932translatek4lQ0M(Offset.m3887constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)));
    }

    /* renamed from: toLocal-MK-Hz9U, reason: not valid java name */
    public final long m6187toLocalMKHz9U(long j5) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) - this.top;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public final int toLocalIndex(int i) {
        return AbstractC1451a.u(i, this.startIndex, this.endIndex) - this.startIndex;
    }

    public final int toLocalLineIndex(int i) {
        return i - this.startLineIndex;
    }

    public final float toLocalYPosition(float f) {
        return f - this.top;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParagraphInfo(paragraph=");
        sb.append(this.paragraph);
        sb.append(", startIndex=");
        sb.append(this.startIndex);
        sb.append(", endIndex=");
        sb.append(this.endIndex);
        sb.append(", startLineIndex=");
        sb.append(this.startLineIndex);
        sb.append(", endLineIndex=");
        sb.append(this.endLineIndex);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", bottom=");
        return androidx.appfunctions.metadata.a.n(sb, this.bottom, ')');
    }

    public final Path toGlobal(Path path) {
        float f = this.top;
        path.mo4032translatek4lQ0M(Offset.m3887constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)));
        return path;
    }

    public /* synthetic */ ParagraphInfo(Paragraph paragraph, int i, int i6, int i10, int i11, float f, float f7, int i12, e eVar) {
        this(paragraph, i, i6, (i12 & 8) != 0 ? -1 : i10, (i12 & 16) != 0 ? -1 : i11, (i12 & 32) != 0 ? -1.0f : f, (i12 & 64) != 0 ? -1.0f : f7);
    }
}
