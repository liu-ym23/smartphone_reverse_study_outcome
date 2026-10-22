package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", "<init>", "()V", "ops", "Landroidx/compose/foundation/text/input/internal/OpArray;", "[I", "opsSize", "", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "mapFromSource", "Landroidx/compose/ui/text/TextRange;", "offset", "mapFromSource--jx7JFs", "(I)J", "mapFromDest", "mapFromDest--jx7JFs", "map", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops;
    private int opsSize;

    public OffsetMappingCalculator() {
        this.ops = OpArray.m1272constructorimpl(10);
    }

    /* JADX INFO: renamed from: mapFromDest--jx7JFs, reason: not valid java name */
    public final long m1269mapFromDestjx7JFs(int r100) {
        return m1267mapfzxv0v0(r100, false);
    }

    /* JADX INFO: renamed from: mapFromSource--jx7JFs, reason: not valid java name */
    public final long m1270mapFromSourcejx7JFs(int r100) {
        return m1267mapfzxv0v0(r100, true);
    }

    /* JADX INFO: renamed from: map-fzxv0v0, reason: not valid java name */
    private final long m1267mapfzxv0v0(int r110, boolean r111) {
        int[] r100 = this.ops;
        int r101 = this.opsSize;
        boolean r102 = !r111;
        if (r101 < 0) goto L14;
        if (r102 == false) goto L10;
        int r103 = r101 - 1;
        int r104 = r110;
    L7:
        if ((-1) >= r103) goto L9;
        int r105 = r103 * 3;
        int r106 = r100[r105];
        int r107 = r100[r105 + 1];
        int r112 = r100[r105 + 2];
        long r108 = m1268mapStepC6uMEY(r104, r106, r107, r112, r111);
        long r109 = m1268mapStepC6uMEY(r110, r106, r107, r112, r111);
        int r113 = Math.min(TextRange.m6998getStartimpl(r108), TextRange.m6998getStartimpl(r109));
        r103 = r103 - 1;
        r104 = r113;
        r110 = Math.max(TextRange.m6993getEndimpl(r108), TextRange.m6993getEndimpl(r109));
        goto L7
    L9:
        int r114 = r110;
        r110 = r104;
    L16:
        return TextRangeKt.TextRange(r110, r114);
    L10:
        int r115 = 0;
        int r116 = r110;
    L11:
        if (r115 >= r101) goto L13;
        int r117 = r115 * 3;
        int r118 = r100[r117];
        int r119 = r100[r117 + 1];
        int r120 = r100[r117 + 2];
        long r121 = m1268mapStepC6uMEY(r116, r118, r119, r120, r111);
        long r122 = m1268mapStepC6uMEY(r110, r118, r119, r120, r111);
        int r123 = Math.min(TextRange.m6998getStartimpl(r121), TextRange.m6998getStartimpl(r122));
        r115 = r115 + 1;
        r116 = r123;
        r110 = Math.max(TextRange.m6993getEndimpl(r121), TextRange.m6993getEndimpl(r122));
        goto L11
    L13:
        r114 = r110;
        r110 = r116;
        goto L16
    L14:
        r114 = r110;
        goto L16
    }

    public final void recordEditOperation(int r100, int r101, int r102) {
        if (r102 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Expected newLen to be ≥ 0, was " + r102);
    L8:
        int r104 = Math.min(r100, r101);
        int r105 = Math.max(r104, r101) - r104;
        if (r105 >= 2) goto L12;
        if (r105 != r102) goto L12;
        return;
    L12:
        int r106 = this.opsSize + 1;
        if (r106 <= OpArray.m1279getSizeimpl(this.ops)) goto L15;
        this.ops = OpArray.m1274copyOfpSmdads(this.ops, Math.max(r106 * 2, OpArray.m1279getSizeimpl(this.ops) * 2));
    L15:
        OpArray.m1281setimpl(this.ops, this.opsSize, r104, r105, r102);
        this.opsSize = r106;
        return;
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: mapStep-C6u-MEY, reason: not valid java name */
    private final long m1268mapStepC6uMEY(int r100, int r101, int r102, int r103, boolean r104) {
        if (r104 == false) goto L4;
        int r105 = r102;
    L5:
        if (r104 == false) goto L7;
        r102 = r103;
    L7:
        if (r100 < r101) goto L20;
        if (r100 != r101) goto L14;
        if (r105 != 0) goto L22;
        return TextRangeKt.TextRange(r101, r102 + r101);
    L22:
        return TextRangeKt.TextRange(r101);
    L14:
        if (r100 >= (r101 + r105)) goto L19;
        if (r102 != 0) goto L24;
        return TextRangeKt.TextRange(r101);
    L24:
        return TextRangeKt.TextRange(r101, r102 + r101);
    L19:
        return TextRangeKt.TextRange((r100 - r105) + r102);
    L20:
        return TextRangeKt.TextRange(r100);
    L4:
        r105 = r103;
        goto L5
    }
}
