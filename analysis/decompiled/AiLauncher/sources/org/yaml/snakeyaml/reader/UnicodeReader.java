package org.yaml.snakeyaml.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* loaded from: classes5.dex */
public class UnicodeReader extends Reader {
    private static final int BOM_SIZE = 3;
    PushbackInputStream internalIn;
    InputStreamReader internalIn2 = null;
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final Charset UTF16BE = StandardCharsets.UTF_16BE;
    private static final Charset UTF16LE = StandardCharsets.UTF_16LE;

    public UnicodeReader(InputStream inputStream) {
        this.internalIn = new PushbackInputStream(inputStream, 3);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        init();
        this.internalIn2.close();
    }

    public String getEncoding() {
        return this.internalIn2.getEncoding();
    }

    public void init() throws IOException {
        Charset charset;
        int i10;
        if (this.internalIn2 != null) {
            return;
        }
        byte[] bArr = new byte[3];
        int i11 = this.internalIn.read(bArr, 0, 3);
        byte b10 = bArr[0];
        if (b10 == -17 && bArr[1] == -69 && bArr[2] == -65) {
            charset = UTF8;
            i10 = i11 - 3;
        } else {
            if (b10 == -2 && bArr[1] == -1) {
                charset = UTF16BE;
            } else if (b10 == -1 && bArr[1] == -2) {
                charset = UTF16LE;
            } else {
                charset = UTF8;
                i10 = i11;
            }
            i10 = i11 - 2;
        }
        if (i10 > 0) {
            this.internalIn.unread(bArr, i11 - i10, i10);
        }
        this.internalIn2 = new InputStreamReader(this.internalIn, charset.newDecoder().onUnmappableCharacter(CodingErrorAction.REPORT));
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) throws IOException {
        init();
        return this.internalIn2.read(cArr, i10, i11);
    }
}
