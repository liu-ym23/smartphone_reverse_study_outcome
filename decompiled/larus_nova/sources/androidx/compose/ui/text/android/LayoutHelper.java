package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\nJ\u001a\u0010\u0017\u001a\u00020\n2\b\b\u0001\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\u001a2\b\b\u0001\u0010\u0013\u001a\u00020\nJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper;", "", "layout", "Landroid/text/Layout;", "<init>", "(Landroid/text/Layout;)V", "getLayout", "()Landroid/text/Layout;", "paragraphEnds", "", "", "paragraphBidi", "", "Ljava/text/Bidi;", "bidiProcessedParagraphs", "", "tmpBuffer", "", "analyzeBidi", "paragraphIndex", "paragraphCount", "getParagraphCount", "()I", "getParagraphForOffset", "offset", "upstream", "", "getParagraphStart", "getParagraphEnd", "isRtlParagraph", "getHorizontalPosition", "", "usePrimaryDirection", "getLineVisibleEnd", "lineIndex", "getDownstreamHorizontal", "primary", "lineEndToVisibleEnd", "lineEnd", "lineStart", "getLineBidiRuns", "", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "getLineBidiRuns$ui_text", "(I)[Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "isLineEndSpace", "c", "", "BidiRun", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LayoutHelper {
    public static final int $stable = 8;
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;
    private final List<Integer> paragraphEnds;
    private char[] tmpBuffer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "", "start", "", "end", "isRtl", "", "<init>", "(IIZ)V", "getStart", "()I", "getEnd", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BidiRun {
        public static final int $stable = 0;
        private final int end;
        private final boolean isRtl;
        private final int start;

        public static /* synthetic */ BidiRun copy$default(BidiRun r100, int r101, int r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.start;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.end;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.isRtl;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final boolean component3() {
            return this.isRtl;
        }

        public final BidiRun copy(int r100, int r101, boolean r102) {
            return new BidiRun(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BidiRun) == true) goto L8;
            return false;
        L8:
            BidiRun r101 = (BidiRun) r100;
            if (this.start == r101.start) goto L12;
            return false;
        L12:
            if (this.end == r101.end) goto L15;
            return false;
        L15:
            if (this.isRtl == r101.isRtl) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.start * 31) + this.end) * 31;
            if (this.isRtl == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public final boolean isRtl() {
            return this.isRtl;
        }

        public BidiRun(int r100, int r101, boolean r102) {
            this.start = r100;
            this.end = r101;
            this.isRtl = r102;
        }
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public LayoutHelper(Layout r100) {
        this.layout = r100;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        int r103 = 0;
    L3:
        int r104 = StringsKt.indexOf$default(this.layout.getText(), '\n', r103, false, 4, null);
        if (r104 >= 0) goto L6;
        int r105 = this.layout.getText().length();
    L7:
        r103 = r105;
        r101.add(Integer.valueOf(r103));
        if (r103 < this.layout.getText().length()) goto L3;
        this.paragraphEnds = r101;
        int r106 = r101.size();
        ArrayList r107 = new ArrayList(r106);
    L10:
        if (r102 >= r106) goto L12;
        r107.add(null);
        r102 = r102 + 1;
        goto L10
    L12:
        this.paragraphBidi = r107;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
        return;
    L6:
        r105 = r104 + 1;
        goto L7
    }

    public final Bidi analyzeBidi(int r110) {
        if (this.bidiProcessedParagraphs[r110] == false) goto L7;
        return (Bidi) ListProtector.get(this.paragraphBidi, r110);
    L7:
        if (r110 != 0) goto L9;
        int r100 = 0;
    L10:
        int r101 = ((Number) ListProtector.get(this.paragraphEnds, r110)).intValue();
        int r102 = r101 - r100;
        char[] r103 = this.tmpBuffer;
        if (r103 != null) goto L13;
    L14:
        r103 = new char[r102];
    L15:
        char[] r111 = r103;
        TextUtils.getChars(this.layout.getText(), r100, r101, r111, 0);
        if (Bidi.requiresBidi(r111, 0, r102) == false) goto L19;
        Bidi r104 = new Bidi(r111, 0, null, 0, r102, isRtlParagraph(r110) ? 1 : 0);
        if (r104.getRunCount() == 1) goto L19;
    L20:
        ListProtector.set(this.paragraphBidi, r110, r104);
        this.bidiProcessedParagraphs[r110] = true;
        if (r104 == null) goto L26;
        char[] r112 = this.tmpBuffer;
        if (r111 != r112) goto L25;
        r111 = null;
        goto L26
    L25:
        r111 = r112;
    L26:
        this.tmpBuffer = r111;
        return r104;
    L19:
        r104 = null;
        goto L20
    L13:
        if (r103.length >= r102) goto L15;
    L9:
        r100 = ((Number) ListProtector.get(this.paragraphEnds, r110 - 1)).intValue();
        goto L10
    }

    public final BidiRun[] getLineBidiRuns$ui_text(int r110) {
        int r100 = this.layout.getLineStart(r110);
        int r111 = this.layout.getLineEnd(r110);
        int r101 = getParagraphForOffset$default(this, r100, false, 2, null);
        int r102 = getParagraphStart(r101);
        int r103 = r100 - r102;
        int r104 = r111 - r102;
        Bidi r105 = analyzeBidi(r101);
        if (r105 == null) goto L16;
        Bidi r106 = r105.createLineBidi(r103, r104);
        if (r106 == null) goto L16;
        int r112 = r106.getRunCount();
        BidiRun[] r107 = new BidiRun[r112];
        int r108 = 0;
    L8:
        if (r108 >= r112) goto L14;
        int r109 = r106.getRunStart(r108) + r100;
        int r113 = r106.getRunLimit(r108) + r100;
        if ((r106.getRunLevel(r108) % 2) != 1) goto L12;
        boolean r114 = true;
    L13:
        r107[r108] = new BidiRun(r109, r113, r114);
        r108 = r108 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L14:
        return r107;
    L16:
        return new BidiRun[]{new BidiRun(r100, r111, this.layout.isRtlCharAt(r100))};
    }

    public final int getLineVisibleEnd(int r100) {
        return lineEndToVisibleEnd(this.layout.getLineEnd(r100), this.layout.getLineStart(r100));
    }

    public final int getParagraphEnd(int r100) {
        return ((Number) ListProtector.get(this.paragraphEnds, r100)).intValue();
    }

    public final int getParagraphStart(int r100) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        return ((Number) ListProtector.get(this.paragraphEnds, r100 - 1)).intValue();
    }

    public final boolean isLineEndSpace(char r100) {
        if (r100 != ' ') goto L5;
    L20:
        return true;
    L5:
        if (r100 == '\n') goto L20;
        if (r100 == 5760) goto L20;
        if (Intrinsics.compare(r100, 8192) < 0) goto L15;
        if (Intrinsics.compare(r100, 8202) > 0) goto L15;
        if (r100 != 8199) goto L20;
    L15:
        if (r100 == 8287) goto L20;
        if (r100 == 12288) goto L20;
        return false;
    }

    public final boolean isRtlParagraph(int r100) {
        int r101 = this.layout.getLineForOffset(getParagraphStart(r100));
        if (this.layout.getParagraphDirection(r101) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getDownstreamHorizontal(int r100, boolean r101) {
        int r102 = this.layout.getLineForOffset(r100);
        int r103 = RangesKt.coerceAtMost(r100, this.layout.getLineEnd(r102));
        if (r101 == false) goto L6;
        return this.layout.getPrimaryHorizontal(r103);
    L6:
        return this.layout.getSecondaryHorizontal(r103);
    }

    private final int lineEndToVisibleEnd(int r100, int r101) {
    L2:
        if (r100 <= r101) goto L6;
        if (isLineEndSpace(this.layout.getText().charAt(r100 - 1)) == false) goto L6;
        r100 = r100 - 1;
    L6:
        return r100;
    }

    public final int getParagraphForOffset(int r100, boolean r101) {
        int r102 = CollectionsKt.binarySearch$default(this.paragraphEnds, Integer.valueOf(r100), 0, 0, 6, null);
        if (r102 >= 0) goto L5;
        int r103 = -(r102 + 1);
    L6:
        if (r101 == false) goto L11;
        if (r103 <= 0) goto L11;
        int r104 = r103 - 1;
        if (r100 != ((Number) ListProtector.get(this.paragraphEnds, r104)).intValue()) goto L11;
        return r104;
    L11:
        return r103;
    L5:
        r103 = r102 + 1;
        goto L6
    }

    public final float getHorizontalPosition(int r110, boolean r111, boolean r112) {
        int r100 = r110;
        if (r112 == false) goto L5;
        int r101 = LayoutCompat_androidKt.getLineForOffset(this.layout, r100, r112);
        int r102 = this.layout.getLineStart(r101);
        int r103 = this.layout.getLineEnd(r101);
        if (r100 == r102) goto L11;
        if (r100 == r103) goto L11;
        return getDownstreamHorizontal(r110, r111);
    L11:
        if (r100 == 0) goto L115;
        if (r100 == this.layout.getText().length()) goto L115;
        int r104 = getParagraphForOffset(r100, r112);
        boolean r105 = isRtlParagraph(r104);
        int r106 = lineEndToVisibleEnd(r103, r102);
        int r107 = getParagraphStart(r104);
        int r108 = r102 - r107;
        int r109 = r106 - r107;
        Bidi r113 = analyzeBidi(r104);
        if (r113 == null) goto L18;
        Bidi r114 = r113.createLineBidi(r108, r109);
    L19:
        boolean r115 = false;
        if (r114 != null) goto L22;
    L99:
        boolean r116 = this.layout.isRtlCharAt(r102);
        if (r111 == true) goto L102;
        if (r105 == r116) goto L102;
    L105:
        if (r100 != r102) goto L107;
        r115 = r105;
    L109:
        Layout r117 = this.layout;
        if (r115 == false) goto L113;
        return r117.getLineLeft(r101);
    L113:
        return r117.getLineRight(r101);
    L107:
        if (r105 == true) goto L109;
        r115 = true;
    L102:
        if (r105 == true) goto L104;
        r105 = true;
        goto L105
    L104:
        r105 = false;
        goto L105
    L22:
        if (r114.getRunCount() == 1) goto L99;
        int r118 = r114.getRunCount();
        BidiRun[] r119 = new BidiRun[r118];
        int r120 = 0;
    L25:
        if (r120 >= r118) goto L31;
        int r121 = r114.getRunStart(r120) + r102;
        int r122 = r114.getRunLimit(r120) + r102;
        if ((r114.getRunLevel(r120) % 2) != 1) goto L29;
        boolean r123 = true;
    L30:
        r119[r120] = new BidiRun(r121, r122, r123);
        r120 = r120 + 1;
        goto L25
    L29:
        r123 = false;
        goto L30
    L31:
        int r124 = r114.getRunCount();
        byte[] r125 = new byte[r124];
        int r126 = 0;
    L32:
        if (r126 >= r124) goto L34;
        r125[r126] = (byte) r114.getRunLevel(r126);
        r126 = r126 + 1;
        goto L32
    L34:
        Bidi.reorderVisually(r125, 0, r119, 0, r118);
        int r127 = -1;
        if (r100 != r102) goto L66;
        int r128 = 0;
    L37:
        if (r128 >= r118) goto L45;
        if (r119[r128].getStart() != r100) goto L41;
        boolean r129 = true;
    L42:
        if (r129 == true) goto L43;
        r128 = r128 + 1;
        goto L37
    L43:
        r127 = r128;
        goto L45
    L41:
        r129 = false;
    L45:
        BidiRun r130 = r119[r127];
        if (r111 == false) goto L48;
    L49:
        if (r105 == true) goto L51;
        r105 = true;
    L52:
        if (r127 != 0) goto L57;
        if (r105 == false) goto L57;
        return this.layout.getLineLeft(r101);
    L57:
        if (r127 != ArraysKt.getLastIndex(r119)) goto L61;
        if (r105 == true) goto L61;
        return this.layout.getLineRight(r101);
    L61:
        if (r105 == false) goto L65;
        return this.layout.getPrimaryHorizontal(r119[r127 - 1].getStart());
    L65:
        return this.layout.getPrimaryHorizontal(r119[r127 + 1].getStart());
    L51:
        r105 = false;
        goto L52
    L48:
        if (r105 != r130.isRtl()) goto L52;
    L66:
        if (r100 <= r106) goto L68;
        r100 = lineEndToVisibleEnd(r100, r102);
    L68:
        int r131 = 0;
    L69:
        if (r131 >= r118) goto L77;
        if (r119[r131].getEnd() != r100) goto L73;
        boolean r132 = true;
    L74:
        if (r132 == true) goto L75;
        r131 = r131 + 1;
        goto L69
    L75:
        r127 = r131;
        goto L77
    L73:
        r132 = false;
    L77:
        BidiRun r133 = r119[r127];
        if (r111 == false) goto L80;
    L85:
        if (r127 != 0) goto L90;
        if (r105 == false) goto L90;
        return this.layout.getLineLeft(r101);
    L90:
        if (r127 != ArraysKt.getLastIndex(r119)) goto L94;
        if (r105 == true) goto L94;
        return this.layout.getLineRight(r101);
    L94:
        if (r105 == false) goto L98;
        return this.layout.getPrimaryHorizontal(r119[r127 - 1].getEnd());
    L98:
        return this.layout.getPrimaryHorizontal(r119[r127 + 1].getEnd());
    L80:
        if (r105 == r133.isRtl()) goto L85;
        if (r105 == true) goto L84;
        r105 = true;
        goto L85
    L84:
        r105 = false;
        goto L85
    L18:
        r114 = null;
    L115:
        return getDownstreamHorizontal(r110, r111);
    L5:
        return getDownstreamHorizontal(r110, r111);
    }

    public static /* synthetic */ int getParagraphForOffset$default(LayoutHelper r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.getParagraphForOffset(r101, r102);
    }
}
