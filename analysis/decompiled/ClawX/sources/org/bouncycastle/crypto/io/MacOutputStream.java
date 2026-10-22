package org.bouncycastle.crypto.io;

import java.io.OutputStream;
import org.bouncycastle.crypto.Mac;

/* loaded from: classes.dex */
public class MacOutputStream extends OutputStream {
    protected Mac mac;

    public MacOutputStream(Mac mac) {
        this.mac = mac;
    }

    public byte[] getMac() {
        byte[] bArr = new byte[this.mac.getMacSize()];
        this.mac.doFinal(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i8) {
        this.mac.update((byte) i8);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) {
        this.mac.update(bArr, i8, i9);
    }
}
