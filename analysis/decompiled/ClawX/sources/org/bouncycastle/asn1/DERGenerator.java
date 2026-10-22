package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class DERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    public DERGenerator(OutputStream outputStream) {
        super(outputStream);
        this._tagged = false;
    }

    private void writeLength(OutputStream outputStream, int i8) throws IOException {
        if (i8 <= 127) {
            outputStream.write((byte) i8);
            return;
        }
        int i9 = 1;
        int i10 = i8;
        while (true) {
            i10 >>>= 8;
            if (i10 == 0) {
                break;
            } else {
                i9++;
            }
        }
        outputStream.write((byte) (i9 | 128));
        for (int i11 = (i9 - 1) * 8; i11 >= 0; i11 -= 8) {
            outputStream.write((byte) (i8 >> i11));
        }
    }

    public void writeDEREncoded(int i8, byte[] bArr) throws IOException {
        if (!this._tagged) {
            writeDEREncoded(this._out, i8, bArr);
            return;
        }
        int i9 = this._tagNo;
        int i10 = i9 | 128;
        if (this._isExplicit) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            writeDEREncoded(byteArrayOutputStream, i8, bArr);
            writeDEREncoded(this._out, i9 | 160, byteArrayOutputStream.toByteArray());
            return;
        }
        if ((i8 & 32) != 0) {
            writeDEREncoded(this._out, i9 | 160, bArr);
        } else {
            writeDEREncoded(this._out, i10, bArr);
        }
    }

    public DERGenerator(OutputStream outputStream, int i8, boolean z) {
        super(outputStream);
        this._tagged = true;
        this._isExplicit = z;
        this._tagNo = i8;
    }

    public void writeDEREncoded(OutputStream outputStream, int i8, byte[] bArr) throws IOException {
        outputStream.write(i8);
        writeLength(outputStream, bArr.length);
        outputStream.write(bArr);
    }
}
