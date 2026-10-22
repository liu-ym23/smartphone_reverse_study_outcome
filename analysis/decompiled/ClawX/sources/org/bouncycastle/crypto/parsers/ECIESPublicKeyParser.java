package org.bouncycastle.crypto.parsers;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.util.io.Streams;
import p7.h;

/* loaded from: classes.dex */
public class ECIESPublicKeyParser implements KeyParser {
    private ECDomainParameters ecParams;

    public ECIESPublicKeyParser(ECDomainParameters eCDomainParameters) {
        this.ecParams = eCDomainParameters;
    }

    @Override // org.bouncycastle.crypto.KeyParser
    public AsymmetricKeyParameter readKey(InputStream inputStream) throws IOException {
        boolean z;
        int i8 = inputStream.read();
        if (i8 < 0) {
            throw new EOFException();
        }
        if (i8 == 0) {
            throw new IOException("Sender's public key invalid.");
        }
        if (i8 == 2 || i8 == 3) {
            z = true;
        } else {
            if (i8 != 4 && i8 != 6 && i8 != 7) {
                throw new IOException("Sender's public key has invalid point encoding 0x" + Integer.toString(i8, 16));
            }
            z = false;
        }
        h curve = this.ecParams.getCurve();
        int iK = curve.k();
        if (!z) {
            iK *= 2;
        }
        int i9 = iK + 1;
        byte[] bArr = new byte[i9];
        bArr[0] = (byte) i8;
        int i10 = i9 - 1;
        if (Streams.readFully(inputStream, bArr, 1, i10) == i10) {
            return new ECPublicKeyParameters(curve.g(bArr), this.ecParams);
        }
        throw new EOFException();
    }
}
