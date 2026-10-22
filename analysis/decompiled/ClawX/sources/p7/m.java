package p7;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public abstract class m implements a {
    public abstract m a(m mVar);

    public abstract m b();

    public int c() {
        return t().bitLength();
    }

    public abstract m d(m mVar);

    public final byte[] e() {
        return BigIntegers.asUnsignedByteArray((f() + 7) / 8, t());
    }

    public abstract int f();

    public abstract m g();

    public boolean h() {
        return c() == 1;
    }

    public boolean i() {
        return t().signum() == 0;
    }

    public abstract m j(m mVar);

    public m k(m mVar, m mVar2, m mVar3) {
        return j(mVar).r(mVar2.j(mVar3));
    }

    public m l(m mVar, m mVar2, m mVar3) {
        return j(mVar).a(mVar2.j(mVar3));
    }

    public abstract m m();

    public abstract m n();

    public abstract m o();

    public m p(m mVar, m mVar2) {
        return o().a(mVar.j(mVar2));
    }

    public m q(int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            this = this.o();
        }
        return this;
    }

    public abstract m r(m mVar);

    public boolean s() {
        return t().testBit(0);
    }

    public abstract BigInteger t();

    public final String toString() {
        return t().toString(16);
    }
}
