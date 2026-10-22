package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import p7.d0;
import p7.h;
import p7.n;
import p7.r;
import p7.s;

/* loaded from: classes.dex */
public class ECFixedTransform implements ECPairFactorTransform {

    /* renamed from: k, reason: collision with root package name */
    private BigInteger f4433k;
    private ECPublicKeyParameters key;

    public ECFixedTransform(BigInteger bigInteger) {
        this.f4433k = bigInteger;
    }

    public n createBasePointMultiplier() {
        return new s(0);
    }

    @Override // org.bouncycastle.crypto.ec.ECPairFactorTransform
    public BigInteger getTransformValue() {
        return this.f4433k;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public void init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ECPublicKeyParameters)) {
            throw new IllegalArgumentException("ECPublicKeyParameters are required for fixed transform.");
        }
        this.key = (ECPublicKeyParameters) cipherParameters;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public ECPair transform(ECPair eCPair) {
        ECPublicKeyParameters eCPublicKeyParameters = this.key;
        if (eCPublicKeyParameters == null) {
            throw new IllegalStateException("ECFixedTransform not initialised");
        }
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        BigInteger n3 = parameters.getN();
        n nVarCreateBasePointMultiplier = createBasePointMultiplier();
        BigInteger bigIntegerMod = this.f4433k.mod(n3);
        r[] rVarArr = {((d0) nVarCreateBasePointMultiplier).m(parameters.getG(), bigIntegerMod).a(d0.a(parameters.getCurve(), eCPair.getX())), this.key.getQ().m(bigIntegerMod).a(d0.a(parameters.getCurve(), eCPair.getY()))};
        h curve = parameters.getCurve();
        curve.getClass();
        curve.p(rVarArr, 0, 2, null);
        return new ECPair(rVarArr[0], rVarArr[1]);
    }
}
