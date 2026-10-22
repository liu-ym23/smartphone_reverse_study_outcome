package org.bouncycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;

/* loaded from: classes.dex */
public class PemWriter extends BufferedWriter {
    private static final int LINE_LENGTH = 64;
    private char[] buf;
    private final int nlLength;

    public PemWriter(Writer writer) {
        super(writer);
        this.buf = new char[64];
        String strLineSeparator = Strings.lineSeparator();
        this.nlLength = strLineSeparator != null ? strLineSeparator.length() : 2;
    }

    private void writeEncoded(byte[] bArr) throws IOException {
        char[] cArr;
        int i8;
        byte[] bArrEncode = Base64.encode(bArr);
        int length = 0;
        while (length < bArrEncode.length) {
            int i9 = 0;
            while (true) {
                cArr = this.buf;
                if (i9 == cArr.length || (i8 = length + i9) >= bArrEncode.length) {
                    break;
                }
                cArr[i9] = (char) bArrEncode[i8];
                i9++;
            }
            write(cArr, 0, i9);
            newLine();
            length += this.buf.length;
        }
    }

    private void writePostEncapsulationBoundary(String str) throws IOException {
        write("-----END " + str + "-----");
        newLine();
    }

    private void writePreEncapsulationBoundary(String str) throws IOException {
        write("-----BEGIN " + str + "-----");
        newLine();
    }

    public int getOutputSize(PemObject pemObject) {
        int length = ((pemObject.getType().length() + 10 + this.nlLength) * 2) + 10;
        if (!pemObject.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : pemObject.getHeaders()) {
                length += pemHeader.getValue().length() + pemHeader.getName().length() + 2 + this.nlLength;
            }
            length += this.nlLength;
        }
        int length2 = ((pemObject.getContent().length + 2) / 3) * 4;
        return (((length2 + 63) / 64) * this.nlLength) + length2 + length;
    }

    public void writeObject(PemObjectGenerator pemObjectGenerator) throws IOException {
        PemObject pemObjectGenerate = pemObjectGenerator.generate();
        writePreEncapsulationBoundary(pemObjectGenerate.getType());
        if (!pemObjectGenerate.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : pemObjectGenerate.getHeaders()) {
                write(pemHeader.getName());
                write(": ");
                write(pemHeader.getValue());
                newLine();
            }
            newLine();
        }
        writeEncoded(pemObjectGenerate.getContent());
        writePostEncapsulationBoundary(pemObjectGenerate.getType());
    }
}
