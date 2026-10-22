package kotlin;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NumbersJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\u0087\b¨\u0006\u0016"}, d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    public NumbersKt__NumbersJVMKt() {
    }

    private static final boolean isNaN(double r0) {
        return Double.isNaN(r0);
    }

    private static final boolean isNaN(float r0) {
        return Float.isNaN(r0);
    }

    private static final boolean isInfinite(double r0) {
        return Double.isInfinite(r0);
    }

    private static final boolean isInfinite(float r0) {
        return Float.isInfinite(r0);
    }

    private static final boolean isFinite(double r1) {
        if (Double.isInfinite(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isNaN(r1) == true) goto L7;
        return true;
    }

    private static final boolean isFinite(float r1) {
        if (Float.isInfinite(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (Float.isNaN(r1) == true) goto L7;
        return true;
    }

    private static final long toBits(double r0) {
        return Double.doubleToLongBits(r0);
    }

    private static final long toRawBits(double r0) {
        return Double.doubleToRawLongBits(r0);
    }

    private static final double fromBits(DoubleCompanionObject r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Double.longBitsToDouble(r2);
    }

    private static final int toBits(float r0) {
        return Float.floatToIntBits(r0);
    }

    private static final int toRawBits(float r0) {
        return Float.floatToRawIntBits(r0);
    }

    private static final float fromBits(FloatCompanionObject r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Float.intBitsToFloat(r2);
    }

    private static final int countOneBits(int r0) {
        return Integer.bitCount(r0);
    }

    private static final int countLeadingZeroBits(int r0) {
        return Integer.numberOfLeadingZeros(r0);
    }

    private static final int countTrailingZeroBits(int r0) {
        return Integer.numberOfTrailingZeros(r0);
    }

    private static final int takeHighestOneBit(int r0) {
        return Integer.highestOneBit(r0);
    }

    private static final int takeLowestOneBit(int r0) {
        return Integer.lowestOneBit(r0);
    }

    private static final int rotateLeft(int r0, int r1) {
        return Integer.rotateLeft(r0, r1);
    }

    private static final int rotateRight(int r0, int r1) {
        return Integer.rotateRight(r0, r1);
    }

    private static final int countOneBits(long r0) {
        return Long.bitCount(r0);
    }

    private static final int countLeadingZeroBits(long r0) {
        return Long.numberOfLeadingZeros(r0);
    }

    private static final int countTrailingZeroBits(long r0) {
        return Long.numberOfTrailingZeros(r0);
    }

    private static final long takeHighestOneBit(long r0) {
        return Long.highestOneBit(r0);
    }

    private static final long takeLowestOneBit(long r0) {
        return Long.lowestOneBit(r0);
    }

    private static final long rotateLeft(long r0, int r2) {
        return Long.rotateLeft(r0, r2);
    }

    private static final long rotateRight(long r0, int r2) {
        return Long.rotateRight(r0, r2);
    }
}
