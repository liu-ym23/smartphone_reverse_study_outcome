package p7;

import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
public abstract class i extends m {
    @Override // p7.m
    public m r(m mVar) {
        return a(mVar);
    }

    public m u() {
        int iF = f();
        if ((iF & 1) == 0) {
            throw new IllegalStateException("Half-trace only defined for odd m");
        }
        int i8 = (iF + 1) >>> 1;
        int iNumberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(i8);
        m mVarA = this;
        int i9 = 1;
        while (iNumberOfLeadingZeros > 0) {
            mVarA = mVarA.q(i9 << 1).a(mVarA);
            iNumberOfLeadingZeros--;
            i9 = i8 >>> iNumberOfLeadingZeros;
            if ((i9 & 1) != 0) {
                mVarA = mVarA.q(2).a(this);
            }
        }
        return mVarA;
    }

    public boolean v() {
        return this instanceof s7.y;
    }

    public int w() {
        int iF = f();
        int iNumberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(iF);
        m mVarA = this;
        int i8 = 1;
        while (iNumberOfLeadingZeros > 0) {
            mVarA = mVarA.q(i8).a(mVarA);
            iNumberOfLeadingZeros--;
            i8 = iF >>> iNumberOfLeadingZeros;
            if ((i8 & 1) != 0) {
                mVarA = mVarA.o().a(this);
            }
        }
        if (mVarA.i()) {
            return 0;
        }
        if (mVarA.h()) {
            return 1;
        }
        throw new IllegalStateException("Internal error in trace calculation");
    }
}
