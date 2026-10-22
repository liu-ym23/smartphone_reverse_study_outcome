package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ASN1OutputStream {
    private OutputStream os;

    public ASN1OutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    public static ASN1OutputStream create(OutputStream outputStream) {
        return new ASN1OutputStream(outputStream);
    }

    public static int getLengthOfDL(int i8) {
        if (i8 < 128) {
            return 1;
        }
        int i9 = 2;
        while (true) {
            i8 >>>= 8;
            if (i8 == 0) {
                return i9;
            }
            i9++;
        }
    }

    public static int getLengthOfEncodingDL(boolean z, int i8) {
        return getLengthOfDL(i8) + (z ? 1 : 0) + i8;
    }

    public static int getLengthOfIdentifier(int i8) {
        if (i8 < 31) {
            return 1;
        }
        int i9 = 2;
        while (true) {
            i8 >>>= 7;
            if (i8 == 0) {
                return i9;
            }
            i9++;
        }
    }

    public void close() throws IOException {
        this.os.close();
    }

    public void flush() throws IOException {
        this.os.flush();
    }

    public DEROutputStream getDERSubStream() {
        return new DEROutputStream(this.os);
    }

    public DLOutputStream getDLSubStream() {
        return new DLOutputStream(this.os);
    }

    public final void write(int i8) throws IOException {
        this.os.write(i8);
    }

    public final void writeDL(int i8) throws IOException {
        if (i8 < 128) {
            write(i8);
            return;
        }
        int i9 = 5;
        byte[] bArr = new byte[5];
        while (true) {
            int i10 = i9 - 1;
            bArr[i10] = (byte) i8;
            i8 >>>= 8;
            if (i8 == 0) {
                int i11 = i9 - 2;
                bArr[i11] = (byte) ((5 - i10) | 128);
                write(bArr, i11, 6 - i10);
                return;
            }
            i9 = i10;
        }
    }

    public void writeElements(ASN1Encodable[] aSN1EncodableArr) {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            aSN1Encodable.toASN1Primitive().encode(this, true);
        }
    }

    public final void writeEncodingDL(boolean z, int i8, byte b9) throws IOException {
        writeIdentifier(z, i8);
        writeDL(1);
        write(b9);
    }

    public final void writeEncodingIL(boolean z, int i8, ASN1Encodable[] aSN1EncodableArr) throws IOException {
        writeIdentifier(z, i8);
        write(128);
        writeElements(aSN1EncodableArr);
        write(0);
        write(0);
    }

    public final void writeIdentifier(boolean z, int i8) throws IOException {
        if (z) {
            write(i8);
        }
    }

    public final void writeObject(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable == null) {
            throw new IOException("null object detected");
        }
        writePrimitive(aSN1Encodable.toASN1Primitive(), true);
        flushInternal();
    }

    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean z) {
        aSN1Primitive.encode(this, z);
    }

    public void writePrimitives(ASN1Primitive[] aSN1PrimitiveArr) {
        for (ASN1Primitive aSN1Primitive : aSN1PrimitiveArr) {
            aSN1Primitive.encode(this, true);
        }
    }

    public static ASN1OutputStream create(OutputStream outputStream, String str) {
        return str.equals(ASN1Encoding.DER) ? new DEROutputStream(outputStream) : str.equals(ASN1Encoding.DL) ? new DLOutputStream(outputStream) : new ASN1OutputStream(outputStream);
    }

    public final void write(byte[] bArr, int i8, int i9) throws IOException {
        this.os.write(bArr, i8, i9);
    }

    public final void writeEncodingDL(boolean z, int i8, byte b9, byte[] bArr, int i9, int i10) throws IOException {
        writeIdentifier(z, i8);
        writeDL(i10 + 1);
        write(b9);
        write(bArr, i9, i10);
    }

    public final void writeIdentifier(boolean z, int i8, int i9) throws IOException {
        if (z) {
            if (i9 < 31) {
                write(i8 | i9);
                return;
            }
            byte[] bArr = new byte[6];
            int i10 = 5;
            bArr[5] = (byte) (i9 & 127);
            while (i9 > 127) {
                i9 >>>= 7;
                i10--;
                bArr[i10] = (byte) ((i9 & 127) | 128);
            }
            int i11 = i10 - 1;
            bArr[i11] = (byte) (31 | i8);
            write(bArr, i11, 6 - i11);
        }
    }

    public final void writeObject(ASN1Primitive aSN1Primitive) throws IOException {
        if (aSN1Primitive == null) {
            throw new IOException("null object detected");
        }
        writePrimitive(aSN1Primitive, true);
        flushInternal();
    }

    public final void writeEncodingDL(boolean z, int i8, int i9, byte[] bArr) throws IOException {
        writeIdentifier(z, i8, i9);
        writeDL(bArr.length);
        write(bArr, 0, bArr.length);
    }

    public final void writeEncodingDL(boolean z, int i8, byte[] bArr) throws IOException {
        writeIdentifier(z, i8);
        writeDL(bArr.length);
        write(bArr, 0, bArr.length);
    }

    public final void writeEncodingDL(boolean z, int i8, byte[] bArr, int i9, int i10) throws IOException {
        writeIdentifier(z, i8);
        writeDL(i10);
        write(bArr, i9, i10);
    }

    public final void writeEncodingDL(boolean z, int i8, byte[] bArr, int i9, int i10, byte b9) throws IOException {
        writeIdentifier(z, i8);
        writeDL(i10 + 1);
        write(bArr, i9, i10);
        write(b9);
    }

    public void flushInternal() {
    }
}
