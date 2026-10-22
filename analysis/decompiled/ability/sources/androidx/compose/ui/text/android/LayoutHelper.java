package androidx.compose.ui.text.android;

import H4.o;
import android.text.Layout;
import androidx.annotation.IntRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import j9.m;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\nJ\u001a\u0010\u0017\u001a\u00020\n2\b\b\u0001\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\u001a2\b\b\u0001\u0010\u0013\u001a\u00020\nJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper;", "", "layout", "Landroid/text/Layout;", AppAgent.CONSTRUCT, "(Landroid/text/Layout;)V", "getLayout", "()Landroid/text/Layout;", "paragraphEnds", "", "", "paragraphBidi", "", "Ljava/text/Bidi;", "bidiProcessedParagraphs", "", "tmpBuffer", "", "analyzeBidi", "paragraphIndex", "paragraphCount", "getParagraphCount", "()I", "getParagraphForOffset", TypedValues.CycleType.S_WAVE_OFFSET, "upstream", "", "getParagraphStart", "getParagraphEnd", "isRtlParagraph", "getHorizontalPosition", "", "usePrimaryDirection", "getLineVisibleEnd", "lineIndex", "getDownstreamHorizontal", "primary", "lineEndToVisibleEnd", "lineEnd", "lineStart", "getLineBidiRuns", "", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "getLineBidiRuns$ui_text", "(I)[Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "isLineEndSpace", "c", "", "BidiRun", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutHelper {
    public static final int $stable = 8;
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;
    private final List<Integer> paragraphEnds;
    private char[] tmpBuffer;

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "", "start", "", "end", "isRtl", "", AppAgent.CONSTRUCT, "(IIZ)V", "getStart", "()I", "getEnd", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class BidiRun {
        public static final int $stable = 0;
        private final int end;
        private final boolean isRtl;
        private final int start;

        public BidiRun(int i, int i6, boolean z10) {
            this.start = i;
            this.end = i6;
            this.isRtl = z10;
        }

        public static /* synthetic */ BidiRun copy$default(BidiRun bidiRun, int i, int i6, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i = bidiRun.start;
            }
            if ((i10 & 2) != 0) {
                i6 = bidiRun.end;
            }
            if ((i10 & 4) != 0) {
                z10 = bidiRun.isRtl;
            }
            return bidiRun.copy(i, i6, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsRtl() {
            return this.isRtl;
        }

        public final BidiRun copy(int start, int end, boolean isRtl) {
            return new BidiRun(start, end, isRtl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) other;
            return this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isRtl) + androidx.constraintlayout.core.dsl.a.a(this.end, Integer.hashCode(this.start) * 31, 31);
        }

        public final boolean isRtl() {
            return this.isRtl;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BidiRun(start=");
            sb.append(this.start);
            sb.append(", end=");
            sb.append(this.end);
            sb.append(", isRtl=");
            return androidx.appfunctions.metadata.a.r(sb, this.isRtl, ')');
        }
    }

    public LayoutHelper(Layout layout) {
        this.layout = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iP0 = m.p0(this.layout.getText(), '\n', length, 4);
            length = iP0 < 0 ? this.layout.getText().length() : iP0 + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < this.layout.getText().length());
        this.paragraphEnds = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        this.paragraphBidi = arrayList2;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    private final float getDownstreamHorizontal(int offset, boolean primary) {
        int lineEnd = this.layout.getLineEnd(this.layout.getLineForOffset(offset));
        if (offset > lineEnd) {
            offset = lineEnd;
        }
        return primary ? this.layout.getPrimaryHorizontal(offset) : this.layout.getSecondaryHorizontal(offset);
    }

    public static /* synthetic */ int getParagraphForOffset$default(LayoutHelper layoutHelper, int i, boolean z10, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        return layoutHelper.getParagraphForOffset(i, z10);
    }

    private final int lineEndToVisibleEnd(int lineEnd, int lineStart) {
        while (lineEnd > lineStart && isLineEndSpace(this.layout.getText().charAt(lineEnd - 1))) {
            lineEnd--;
        }
        return lineEnd;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.text.Bidi analyzeBidi(int r11) {
        /*
            r10 = this;
            boolean[] r0 = r10.bidiProcessedParagraphs
            boolean r0 = r0[r11]
            if (r0 == 0) goto Lf
            java.util.List<java.text.Bidi> r10 = r10.paragraphBidi
            java.lang.Object r10 = r10.get(r11)
            java.text.Bidi r10 = (java.text.Bidi) r10
            return r10
        Lf:
            r0 = 0
            if (r11 != 0) goto L14
            r1 = r0
            goto L22
        L14:
            java.util.List<java.lang.Integer> r1 = r10.paragraphEnds
            int r2 = r11 + (-1)
            java.lang.Object r1 = r1.get(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L22:
            java.util.List<java.lang.Integer> r2 = r10.paragraphEnds
            java.lang.Object r2 = r2.get(r11)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r8 = r2 - r1
            char[] r3 = r10.tmpBuffer
            if (r3 == 0) goto L3a
            int r4 = r3.length
            if (r4 >= r8) goto L38
            goto L3a
        L38:
            r4 = r3
            goto L3d
        L3a:
            char[] r3 = new char[r8]
            goto L38
        L3d:
            android.text.Layout r3 = r10.layout
            java.lang.CharSequence r3 = r3.getText()
            android.text.TextUtils.getChars(r3, r1, r2, r4, r0)
            boolean r0 = java.text.Bidi.requiresBidi(r4, r0, r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L60
            boolean r9 = r10.isRtlParagraph(r11)
            java.text.Bidi r3 = new java.text.Bidi
            r6 = 0
            r7 = 0
            r5 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r0 = r3.getRunCount()
            if (r0 != r2) goto L61
        L60:
            r3 = r1
        L61:
            java.util.List<java.text.Bidi> r0 = r10.paragraphBidi
            r0.set(r11, r3)
            boolean[] r0 = r10.bidiProcessedParagraphs
            r0[r11] = r2
            if (r3 == 0) goto L73
            char[] r11 = r10.tmpBuffer
            if (r4 != r11) goto L72
            r4 = r1
            goto L73
        L72:
            r4 = r11
        L73:
            r10.tmpBuffer = r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutHelper.analyzeBidi(int):java.text.Bidi");
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection, boolean upstream) {
        int iLineEndToVisibleEnd = offset;
        if (!upstream) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        int lineForOffset = LayoutCompat_androidKt.getLineForOffset(this.layout, iLineEndToVisibleEnd, upstream);
        int lineStart = this.layout.getLineStart(lineForOffset);
        int lineEnd = this.layout.getLineEnd(lineForOffset);
        if (iLineEndToVisibleEnd != lineStart && iLineEndToVisibleEnd != lineEnd) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        if (iLineEndToVisibleEnd == 0 || iLineEndToVisibleEnd == this.layout.getText().length()) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        int paragraphForOffset = getParagraphForOffset(iLineEndToVisibleEnd, upstream);
        boolean zIsRtlParagraph = isRtlParagraph(paragraphForOffset);
        int iLineEndToVisibleEnd2 = lineEndToVisibleEnd(lineEnd, lineStart);
        int paragraphStart = getParagraphStart(paragraphForOffset);
        int i = lineStart - paragraphStart;
        int i6 = iLineEndToVisibleEnd2 - paragraphStart;
        Bidi bidiAnalyzeBidi = analyzeBidi(paragraphForOffset);
        Bidi bidiCreateLineBidi = bidiAnalyzeBidi != null ? bidiAnalyzeBidi.createLineBidi(i, i6) : null;
        boolean z10 = false;
        if (bidiCreateLineBidi == null || bidiCreateLineBidi.getRunCount() == 1) {
            boolean zIsRtlCharAt = this.layout.isRtlCharAt(lineStart);
            if (usePrimaryDirection || zIsRtlParagraph == zIsRtlCharAt) {
                zIsRtlParagraph = !zIsRtlParagraph;
            }
            if (iLineEndToVisibleEnd == lineStart) {
                z10 = zIsRtlParagraph;
            } else if (!zIsRtlParagraph) {
                z10 = true;
            }
            Layout layout = this.layout;
            return z10 ? layout.getLineLeft(lineForOffset) : layout.getLineRight(lineForOffset);
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i10 = 0; i10 < runCount; i10++) {
            bidiRunArr[i10] = new BidiRun(bidiCreateLineBidi.getRunStart(i10) + lineStart, bidiCreateLineBidi.getRunLimit(i10) + lineStart, bidiCreateLineBidi.getRunLevel(i10) % 2 == 1);
        }
        int runCount2 = bidiCreateLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i11 = 0; i11 < runCount2; i11++) {
            bArr[i11] = (byte) bidiCreateLineBidi.getRunLevel(i11);
        }
        Bidi.reorderVisually(bArr, 0, bidiRunArr, 0, runCount);
        int i12 = -1;
        if (iLineEndToVisibleEnd == lineStart) {
            int i13 = 0;
            while (true) {
                if (i13 >= runCount) {
                    break;
                }
                if (bidiRunArr[i13].getStart() == iLineEndToVisibleEnd) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
            BidiRun bidiRun = bidiRunArr[i12];
            if (usePrimaryDirection || zIsRtlParagraph == bidiRun.isRtl()) {
                zIsRtlParagraph = !zIsRtlParagraph;
            }
            return (i12 == 0 && zIsRtlParagraph) ? this.layout.getLineLeft(lineForOffset) : (i12 != runCount - 1 || zIsRtlParagraph) ? zIsRtlParagraph ? this.layout.getPrimaryHorizontal(bidiRunArr[i12 - 1].getStart()) : this.layout.getPrimaryHorizontal(bidiRunArr[i12 + 1].getStart()) : this.layout.getLineRight(lineForOffset);
        }
        if (iLineEndToVisibleEnd > iLineEndToVisibleEnd2) {
            iLineEndToVisibleEnd = lineEndToVisibleEnd(iLineEndToVisibleEnd, lineStart);
        }
        int i14 = 0;
        while (true) {
            if (i14 >= runCount) {
                break;
            }
            if (bidiRunArr[i14].getEnd() == iLineEndToVisibleEnd) {
                i12 = i14;
                break;
            }
            i14++;
        }
        BidiRun bidiRun2 = bidiRunArr[i12];
        if (!usePrimaryDirection && zIsRtlParagraph != bidiRun2.isRtl()) {
            zIsRtlParagraph = !zIsRtlParagraph;
        }
        return (i12 == 0 && zIsRtlParagraph) ? this.layout.getLineLeft(lineForOffset) : (i12 != runCount - 1 || zIsRtlParagraph) ? zIsRtlParagraph ? this.layout.getPrimaryHorizontal(bidiRunArr[i12 - 1].getEnd()) : this.layout.getPrimaryHorizontal(bidiRunArr[i12 + 1].getEnd()) : this.layout.getLineRight(lineForOffset);
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final BidiRun[] getLineBidiRuns$ui_text(int lineIndex) {
        Bidi bidiCreateLineBidi;
        int lineStart = this.layout.getLineStart(lineIndex);
        int lineEnd = this.layout.getLineEnd(lineIndex);
        int paragraphForOffset$default = getParagraphForOffset$default(this, lineStart, false, 2, null);
        int paragraphStart = getParagraphStart(paragraphForOffset$default);
        int i = lineStart - paragraphStart;
        int i6 = lineEnd - paragraphStart;
        Bidi bidiAnalyzeBidi = analyzeBidi(paragraphForOffset$default);
        if (bidiAnalyzeBidi == null || (bidiCreateLineBidi = bidiAnalyzeBidi.createLineBidi(i, i6)) == null) {
            return new BidiRun[]{new BidiRun(lineStart, lineEnd, this.layout.isRtlCharAt(lineStart))};
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i10 = 0; i10 < runCount; i10++) {
            int runStart = bidiCreateLineBidi.getRunStart(i10) + lineStart;
            int runLimit = bidiCreateLineBidi.getRunLimit(i10) + lineStart;
            boolean z10 = true;
            if (bidiCreateLineBidi.getRunLevel(i10) % 2 != 1) {
                z10 = false;
            }
            bidiRunArr[i10] = new BidiRun(runStart, runLimit, z10);
        }
        return bidiRunArr;
    }

    public final int getLineVisibleEnd(int lineIndex) {
        return lineEndToVisibleEnd(this.layout.getLineEnd(lineIndex), this.layout.getLineStart(lineIndex));
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public final int getParagraphEnd(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int paragraphIndex) {
        return this.paragraphEnds.get(paragraphIndex).intValue();
    }

    public final int getParagraphForOffset(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int offset, boolean upstream) {
        int iP = o.p(this.paragraphEnds, Integer.valueOf(offset));
        int i = iP < 0 ? -(iP + 1) : iP + 1;
        if (upstream && i > 0) {
            int i6 = i - 1;
            if (offset == this.paragraphEnds.get(i6).intValue()) {
                return i6;
            }
        }
        return i;
    }

    public final int getParagraphStart(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int paragraphIndex) {
        if (paragraphIndex == 0) {
            return 0;
        }
        return this.paragraphEnds.get(paragraphIndex - 1).intValue();
    }

    public final boolean isLineEndSpace(char c) {
        if (c == ' ' || c == '\n' || c == 5760) {
            return true;
        }
        return (k.g(c, 8192) >= 0 && k.g(c, 8202) <= 0 && c != 8199) || c == 8287 || c == 12288;
    }

    public final boolean isRtlParagraph(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int paragraphIndex) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(getParagraphStart(paragraphIndex))) == -1;
    }
}
