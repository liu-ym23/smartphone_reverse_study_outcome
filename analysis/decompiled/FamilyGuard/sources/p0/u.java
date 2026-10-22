package p0;

import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import o0.C0888a;
import q0.C0946I;
import q0.U;

/* loaded from: classes.dex */
public class u implements U, t {

    /* renamed from: a, reason: collision with root package name */
    public static u f19340a = new u();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        if (obj == null) {
            c0946i.I();
            return;
        }
        if (obj instanceof Optional) {
            Optional optional = (Optional) obj;
            c0946i.G(optional.isPresent() ? optional.get() : null);
            return;
        }
        if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                c0946i.G(Double.valueOf(optionalDouble.getAsDouble()));
                return;
            } else {
                c0946i.I();
                return;
            }
        }
        if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent()) {
                c0946i.f19676k.V(optionalInt.getAsInt());
                return;
            } else {
                c0946i.I();
                return;
            }
        }
        if (!(obj instanceof OptionalLong)) {
            throw new l0.d("not support optional : " + obj.getClass());
        }
        OptionalLong optionalLong = (OptionalLong) obj;
        if (optionalLong.isPresent()) {
            c0946i.f19676k.X(optionalLong.getAsLong());
        } else {
            c0946i.I();
        }
    }

    @Override // p0.t
    public int d() {
        return 12;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer numT = u0.o.t(c0888a.h0(Integer.class));
            return numT == null ? (T) OptionalInt.empty() : (T) OptionalInt.of(numT.intValue());
        }
        if (type == OptionalLong.class) {
            Long lV = u0.o.v(c0888a.h0(Long.class));
            return lV == null ? (T) OptionalLong.empty() : (T) OptionalLong.of(lV.longValue());
        }
        if (type == OptionalDouble.class) {
            Double dQ = u0.o.q(c0888a.h0(Double.class));
            return dQ == null ? (T) OptionalDouble.empty() : (T) OptionalDouble.of(dQ.doubleValue());
        }
        Object objJ0 = c0888a.j0(u0.o.O0(type));
        return objJ0 == null ? (T) Optional.empty() : (T) Optional.of(objJ0);
    }
}
