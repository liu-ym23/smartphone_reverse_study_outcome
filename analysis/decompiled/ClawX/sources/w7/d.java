package w7;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public final a f6227a;

    /* renamed from: b, reason: collision with root package name */
    public final c f6228b;

    public d(a aVar, c cVar) {
        this.f6227a = aVar;
        this.f6228b = cVar;
    }

    @Override // w7.a
    public final int a() {
        return this.f6227a.a() * this.f6228b.f6226a[r2.length - 1];
    }

    @Override // w7.a
    public final BigInteger b() {
        return this.f6227a.b();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6227a.equals(dVar.f6227a) && this.f6228b.equals(dVar.f6228b);
    }

    public final int hashCode() {
        return Integers.rotateLeft(this.f6228b.hashCode(), 16) ^ this.f6227a.hashCode();
    }
}
