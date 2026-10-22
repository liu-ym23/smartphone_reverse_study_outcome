package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class BERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    public BERGenerator(OutputStream outputStream) {
        super(outputStream);
        this._tagged = false;
    }

    private void writeHdr(int i8) throws IOException {
        this._out.write(i8);
        this._out.write(128);
    }

    @Override // org.bouncycastle.asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this._out;
    }

    public void writeBEREnd() throws IOException {
        this._out.write(0);
        this._out.write(0);
        if (this._tagged && this._isExplicit) {
            this._out.write(0);
            this._out.write(0);
        }
    }

    public void writeBERHeader(int i8) throws IOException {
        if (!this._tagged) {
            writeHdr(i8);
            return;
        }
        int i9 = this._tagNo;
        int i10 = i9 | 128;
        if (this._isExplicit) {
            writeHdr(i9 | 160);
        } else {
            if ((i8 & 32) == 0) {
                writeHdr(i10);
                return;
            }
            i8 = i9 | 160;
        }
        writeHdr(i8);
    }

    public BERGenerator(OutputStream outputStream, int i8, boolean z) {
        super(outputStream);
        this._tagged = true;
        this._isExplicit = z;
        this._tagNo = i8;
    }
}
