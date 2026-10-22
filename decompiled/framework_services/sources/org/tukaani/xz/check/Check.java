package org.tukaani.xz.check;

import org.tukaani.xz.UnsupportedOptionsException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Check {
    String name;
    int size;

    public abstract byte[] finish();

    public abstract void update(byte[] r1, int r2, int r3);

    public Check() {
    }

    public void update(byte[] buf) {
        update(buf, 0, buf.length);
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public static Check getInstance(int checkType) throws UnsupportedOptionsException {
        switch(checkType) {
            case 0: goto L14;
            case 1: goto L12;
            case 4: goto L10;
            case 10: goto L15;
            default: goto L8;
        };
    L15:
        return new SHA256();
    L10:
        return new CRC64();
    L12:
        return new CRC32();
    L14:
        return new None();
    L8:
        throw new UnsupportedOptionsException("Unsupported Check ID " + checkType);
    }
}
