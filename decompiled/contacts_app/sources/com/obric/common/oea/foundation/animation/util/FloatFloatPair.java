package com.obric.common.oea.foundation.animation.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: FloatFloatPair.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u0086\nJ\t\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/foundation/animation/util/FloatFloatPair;", "", "first", "", "second", "(FF)V", "packedValue", "", "(J)V", "getFirst", "()F", "getPackedValue$annotations", "()V", "getSecond", "component1", "component2", "toString", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatFloatPair {
    public final long packedValue;

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public FloatFloatPair(long r1) {
        this.packedValue = r1;
    }

    public final float getFirst() {
        return Float.intBitsToFloat((int) (this.packedValue >> 32));
    }

    public final float getSecond() {
        return Float.intBitsToFloat((int) (this.packedValue & 4294967295L));
    }

    public final float component1() {
        return Float.intBitsToFloat((int) (this.packedValue >> 32));
    }

    public final float component2() {
        return Float.intBitsToFloat((int) (this.packedValue & 4294967295L));
    }

    public String toString() {
        return "(" + Float.intBitsToFloat((int) (this.packedValue >> 32)) + ", " + Float.intBitsToFloat((int) (this.packedValue & 4294967295L)) + ')';
    }

    public FloatFloatPair(float r5, float r6) {
        long r0 = Float.floatToRawIntBits(r5);
        this((((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r0 << 32));
    }
}
