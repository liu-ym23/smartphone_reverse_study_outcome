package org.tukaani.xz.delta;

/* JADX INFO: loaded from: classes3.dex */
public class DeltaDecoder extends DeltaCoder {
    public DeltaDecoder(int distance) {
        super(distance);
    }

    public void decode(byte[] buf, int off, int len) {
        int end = off + len;
        int i = off;
    L3:
        if (i >= end) goto L6;
        buf[i] = (byte) (buf[i] + this.history[(this.distance + this.pos) & 255]);
        byte[] r2 = this.history;
        int r3 = this.pos;
        this.pos = r3 - 1;
        r2[r3 & 255] = buf[i];
        i = i + 1;
        goto L3
    }
}
