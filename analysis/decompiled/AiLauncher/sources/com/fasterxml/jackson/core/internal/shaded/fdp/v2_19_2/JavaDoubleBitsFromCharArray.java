package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* loaded from: classes.dex */
final class JavaDoubleBitsFromCharArray extends AbstractJavaFloatingPointBitsFromCharArray {
    @Override // com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.AbstractJavaFloatingPointBitsFromCharArray
    public long nan() {
        return Double.doubleToRawLongBits(Double.NaN);
    }

    @Override // com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.AbstractJavaFloatingPointBitsFromCharArray
    public long negativeInfinity() {
        return Double.doubleToRawLongBits(Double.NEGATIVE_INFINITY);
    }

    @Override // com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.AbstractJavaFloatingPointBitsFromCharArray
    public long positiveInfinity() {
        return Double.doubleToRawLongBits(Double.POSITIVE_INFINITY);
    }

    @Override // com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.AbstractJavaFloatingPointBitsFromCharArray
    public long valueOfFloatLiteral(char[] cArr, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13) throws NumberFormatException {
        double dTryDecFloatToDoubleTruncated = FastDoubleMath.tryDecFloatToDoubleTruncated(z10, j10, i12, z11, i13);
        if (Double.isNaN(dTryDecFloatToDoubleTruncated)) {
            dTryDecFloatToDoubleTruncated = Double.parseDouble(new String(cArr, i10, i11 - i10));
        }
        return Double.doubleToRawLongBits(dTryDecFloatToDoubleTruncated);
    }

    @Override // com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.AbstractJavaFloatingPointBitsFromCharArray
    public long valueOfHexLiteral(char[] cArr, int i10, int i11, boolean z10, long j10, int i12, boolean z11, int i13) throws NumberFormatException {
        double dTryHexFloatToDoubleTruncated = FastDoubleMath.tryHexFloatToDoubleTruncated(z10, j10, i12, z11, i13);
        if (Double.isNaN(dTryHexFloatToDoubleTruncated)) {
            dTryHexFloatToDoubleTruncated = Double.parseDouble(new String(cArr, i10, i11 - i10));
        }
        return Double.doubleToRawLongBits(dTryHexFloatToDoubleTruncated);
    }
}
