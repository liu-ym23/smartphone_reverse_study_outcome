package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ=\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019R\u001c\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", AppAgent.CONSTRUCT, "()V", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "fromSource", "Landroidx/compose/ui/text/TextRange;", "map-fzxv0v0", "(IZ)J", "map", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "mapStep", "sourceStart", "sourceEnd", "newLength", "LC7/r;", "recordEditOperation", "(III)V", "mapFromSource--jx7JFs", "(I)J", "mapFromSource", "mapFromDest--jx7JFs", "mapFromDest", "Landroidx/compose/foundation/text/input/internal/OpArray;", "ops", "[I", "opsSize", "I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops = OpArray.m1212constructorimpl(10);
    private int opsSize;

    /* renamed from: map-fzxv0v0, reason: not valid java name */
    private final long m1207mapfzxv0v0(int offset, boolean fromSource) {
        int i;
        int iMin;
        int[] iArr = this.ops;
        int i6 = this.opsSize;
        if (i6 >= 0) {
            if (fromSource) {
                iMin = offset;
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = i10 * 3;
                    int i12 = iArr[i11];
                    int i13 = iArr[i11 + 1];
                    int i14 = iArr[i11 + 2];
                    long jM1208mapStepC6uMEY = m1208mapStepC6uMEY(iMin, i12, i13, i14, fromSource);
                    long jM1208mapStepC6uMEY2 = m1208mapStepC6uMEY(offset, i12, i13, i14, fromSource);
                    iMin = Math.min(TextRange.m6311getStartimpl(jM1208mapStepC6uMEY), TextRange.m6311getStartimpl(jM1208mapStepC6uMEY2));
                    offset = Math.max(TextRange.m6306getEndimpl(jM1208mapStepC6uMEY), TextRange.m6306getEndimpl(jM1208mapStepC6uMEY2));
                }
            } else {
                int i15 = i6 - 1;
                iMin = offset;
                while (-1 < i15) {
                    int i16 = i15 * 3;
                    int i17 = iArr[i16];
                    int i18 = iArr[i16 + 1];
                    int i19 = iArr[i16 + 2];
                    OffsetMappingCalculator offsetMappingCalculator = this;
                    boolean z10 = fromSource;
                    long jM1208mapStepC6uMEY3 = offsetMappingCalculator.m1208mapStepC6uMEY(iMin, i17, i18, i19, z10);
                    long jM1208mapStepC6uMEY4 = offsetMappingCalculator.m1208mapStepC6uMEY(offset, i17, i18, i19, z10);
                    iMin = Math.min(TextRange.m6311getStartimpl(jM1208mapStepC6uMEY3), TextRange.m6311getStartimpl(jM1208mapStepC6uMEY4));
                    offset = Math.max(TextRange.m6306getEndimpl(jM1208mapStepC6uMEY3), TextRange.m6306getEndimpl(jM1208mapStepC6uMEY4));
                    i15--;
                    this = offsetMappingCalculator;
                    fromSource = z10;
                }
            }
            i = offset;
            offset = iMin;
        } else {
            i = offset;
        }
        return TextRangeKt.TextRange(offset, i);
    }

    /* renamed from: mapStep-C6u-MEY, reason: not valid java name */
    private final long m1208mapStepC6uMEY(int offset, int opOffset, int untransformedLen, int transformedLen, boolean fromSource) {
        int i = fromSource ? untransformedLen : transformedLen;
        if (fromSource) {
            untransformedLen = transformedLen;
        }
        return offset < opOffset ? TextRangeKt.TextRange(offset) : offset == opOffset ? i == 0 ? TextRangeKt.TextRange(opOffset, untransformedLen + opOffset) : TextRangeKt.TextRange(opOffset) : offset < opOffset + i ? untransformedLen == 0 ? TextRangeKt.TextRange(opOffset) : TextRangeKt.TextRange(opOffset, untransformedLen + opOffset) : TextRangeKt.TextRange((offset - i) + untransformedLen);
    }

    /* renamed from: mapFromDest--jx7JFs, reason: not valid java name */
    public final long m1209mapFromDestjx7JFs(int offset) {
        return m1207mapfzxv0v0(offset, false);
    }

    /* renamed from: mapFromSource--jx7JFs, reason: not valid java name */
    public final long m1210mapFromSourcejx7JFs(int offset) {
        return m1207mapfzxv0v0(offset, true);
    }

    public final void recordEditOperation(int sourceStart, int sourceEnd, int newLength) {
        if (newLength < 0) {
            throw new IllegalArgumentException(B7.a.h(newLength, "Expected newLen to be ≥ 0, was ").toString());
        }
        int iMin = Math.min(sourceStart, sourceEnd);
        int iMax = Math.max(iMin, sourceEnd) - iMin;
        if (iMax >= 2 || iMax != newLength) {
            int i = this.opsSize + 1;
            if (i > OpArray.m1219getSizeimpl(this.ops)) {
                this.ops = OpArray.m1214copyOfpSmdads(this.ops, Math.max(i * 2, OpArray.m1219getSizeimpl(this.ops) * 2));
            }
            OpArray.m1221setimpl(this.ops, this.opsSize, iMin, iMax, newLength);
            this.opsSize = i;
        }
    }
}
