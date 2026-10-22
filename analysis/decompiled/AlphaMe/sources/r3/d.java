package r3;

import com.google.android.gms.common.api.internal.p;
import java.util.Objects;
import org.tensorflow.Operation;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Operation f14091a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14092b;

    public d(Operation operation, int i4) {
        this.f14091a = operation;
        this.f14092b = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14092b == dVar.f14092b && this.f14091a.equals(dVar.f14091a);
    }

    public final int hashCode() {
        return Objects.hash(this.f14091a, Integer.valueOf(this.f14092b));
    }

    public final String toString() {
        Operation operation = this.f14091a;
        String strD = operation.d();
        String strB = operation.b();
        int i4 = this.f14092b;
        return String.format("<%s '%s:%d' shape=%s dtype=%s>", strD, strB, Integer.valueOf(i4), new p(26, operation.c(i4)).toString(), operation.a(i4));
    }
}
