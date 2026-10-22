package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import p7.a;
import p7.h;
import p7.m;
import p7.r;

/* loaded from: classes.dex */
public abstract class DSTU4145PointEncoder {
    public static r decodePoint(h hVar, byte[] bArr) {
        m mVarJ;
        m mVarJ2 = hVar.j(BigInteger.valueOf(bArr[bArr.length - 1] & 1));
        m mVarJ3 = hVar.j(new BigInteger(1, bArr));
        if (!trace(mVarJ3).equals(hVar.f4798b)) {
            mVarJ3 = mVarJ3.b();
        }
        if (mVarJ3.i()) {
            mVarJ = hVar.f4799c.n();
        } else {
            m mVarSolveQuadraticEquation = solveQuadraticEquation(hVar, mVarJ3.o().g().j(hVar.f4799c).a(hVar.f4798b).a(mVarJ3));
            if (mVarSolveQuadraticEquation != null) {
                if (!trace(mVarSolveQuadraticEquation).equals(mVarJ2)) {
                    mVarSolveQuadraticEquation = mVarSolveQuadraticEquation.b();
                }
                mVarJ = mVarJ3.j(mVarSolveQuadraticEquation);
            } else {
                mVarJ = null;
            }
        }
        if (mVarJ != null) {
            return hVar.t(mVarJ3.t(), mVarJ.t());
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    public static byte[] encodePoint(r rVar) {
        r rVarO = rVar.o();
        rVarO.b();
        m mVar = rVarO.f4818b;
        byte[] bArrE = mVar.e();
        if (!mVar.i()) {
            if (trace(rVarO.d().d(mVar)).h()) {
                int length = bArrE.length - 1;
                bArrE[length] = (byte) (bArrE[length] | 1);
                return bArrE;
            }
            int length2 = bArrE.length - 1;
            bArrE[length2] = (byte) (bArrE[length2] & 254);
        }
        return bArrE;
    }

    private static m solveQuadraticEquation(h hVar, m mVar) {
        m mVarA;
        if (mVar.i()) {
            return mVar;
        }
        m mVarJ = hVar.j(a.f4757a);
        Random random = new Random();
        int iF = mVar.f();
        do {
            m mVarJ2 = hVar.j(new BigInteger(iF, random));
            m mVarA2 = mVar;
            mVarA = mVarJ;
            for (int i8 = 1; i8 <= iF - 1; i8++) {
                m mVarO = mVarA2.o();
                mVarA = mVarA.o().a(mVarO.j(mVarJ2));
                mVarA2 = mVarO.a(mVar);
            }
            if (!mVarA2.i()) {
                return null;
            }
        } while (mVarA.o().a(mVarA).i());
        return mVarA;
    }

    private static m trace(m mVar) {
        m mVarA = mVar;
        for (int i8 = 1; i8 < mVar.f(); i8++) {
            mVarA = mVarA.o().a(mVar);
        }
        return mVarA;
    }
}
