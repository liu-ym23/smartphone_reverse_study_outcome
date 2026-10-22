package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BEROctetStringGenerator extends BERGenerator {

    public class BufferedBEROctetStream extends OutputStream {
        private byte[] _buf;
        private DEROutputStream _derOut;
        private int _off = 0;

        public BufferedBEROctetStream(byte[] bArr) {
            this._buf = bArr;
            this._derOut = new DEROutputStream(BEROctetStringGenerator.this._out);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i8 = this._off;
            if (i8 != 0) {
                DEROctetString.encode(this._derOut, true, this._buf, 0, i8);
            }
            this._derOut.flushInternal();
            BEROctetStringGenerator.this.writeBEREnd();
        }

        @Override // java.io.OutputStream
        public void write(int i8) throws IOException {
            byte[] bArr = this._buf;
            int i9 = this._off;
            int i10 = i9 + 1;
            this._off = i10;
            bArr[i9] = (byte) i8;
            if (i10 == bArr.length) {
                DEROctetString.encode(this._derOut, true, bArr, 0, bArr.length);
                this._off = 0;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) throws IOException {
            byte[] bArr2 = this._buf;
            int length = bArr2.length;
            int i10 = this._off;
            int i11 = length - i10;
            if (i9 < i11) {
                System.arraycopy(bArr, i8, bArr2, i10, i9);
                this._off += i9;
                return;
            }
            if (i10 > 0) {
                System.arraycopy(bArr, i8, bArr2, i10, i11);
                DEROctetString.encode(this._derOut, true, this._buf, 0, length);
            } else {
                i11 = 0;
            }
            while (true) {
                int i12 = i9 - i11;
                if (i12 < length) {
                    System.arraycopy(bArr, i8 + i11, this._buf, 0, i12);
                    this._off = i12;
                    return;
                } else {
                    DEROctetString.encode(this._derOut, true, bArr, i8 + i11, length);
                    i11 += length;
                }
            }
        }
    }

    public BEROctetStringGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return getOctetOutputStream(new byte[1000]);
    }

    public BEROctetStringGenerator(OutputStream outputStream, int i8, boolean z) throws IOException {
        super(outputStream, i8, z);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream(byte[] bArr) {
        return new BufferedBEROctetStream(bArr);
    }
}
