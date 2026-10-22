package dc;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class h extends b1 {
    public static float Z(float f8, float f9, float f10) {
        if (f9 <= f10) {
            return f8 < f9 ? f9 : f8 > f10 ? f10 : f8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f10 + " is less than minimum " + f9 + '.');
    }

    public static int a0(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static long b0(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        StringBuilder sbQ = ai.onnxruntime.a.q(j12, "Cannot coerce value to an empty range: maximum ", " is less than minimum ");
        sbQ.append(j11);
        sbQ.append('.');
        throw new IllegalArgumentException(sbQ.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long c0(long j10, g range) {
        kotlin.jvm.internal.g.f(range, "range");
        long j11 = range.f8464b;
        long j12 = range.f8463a;
        if (!(range instanceof a)) {
            if (!range.isEmpty()) {
                return j10 < Long.valueOf(j12).longValue() ? Long.valueOf(j12).longValue() : j10 > Long.valueOf(j11).longValue() ? Long.valueOf(j11).longValue() : j10;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        Object objValueOf = Long.valueOf(j10);
        a aVar = (a) range;
        if (aVar.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + aVar + '.');
        }
        if (aVar.a(objValueOf, aVar.b()) && !aVar.a(aVar.b(), objValueOf)) {
            objValueOf = aVar.b();
        } else if (aVar.a(aVar.c(), objValueOf) && !aVar.a(objValueOf, aVar.c())) {
            objValueOf = aVar.c();
        }
        return ((Number) objValueOf).longValue();
    }

    public static c d0(e eVar, int i10) {
        kotlin.jvm.internal.g.f(eVar, "<this>");
        boolean z = i10 > 0;
        Integer numValueOf = Integer.valueOf(i10);
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i11 = eVar.f8451a;
        int i12 = eVar.f8452b;
        if (eVar.f8453c <= 0) {
            i10 = -i10;
        }
        return new c(i11, i12, i10);
    }

    public static e e0(int i10, int i11) {
        if (i11 > Integer.MIN_VALUE) {
            return new e(i10, i11 - 1, 1);
        }
        e eVar = e.f8458d;
        return e.f8458d;
    }
}
