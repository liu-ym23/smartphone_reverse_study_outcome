package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Mac;

/* loaded from: classes.dex */
public class MacInputStream extends FilterInputStream {
    protected Mac mac;

    public MacInputStream(InputStream inputStream, Mac mac) {
        super(inputStream);
        this.mac = mac;
    }

    public Mac getMac() {
        return this.mac;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i8 = ((FilterInputStream) this).in.read();
        if (i8 >= 0) {
            this.mac.update((byte) i8);
        }
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = ((FilterInputStream) this).in.read(bArr, i8, i9);
        if (i10 >= 0) {
            this.mac.update(bArr, i8, i10);
        }
        return i10;
    }
}
