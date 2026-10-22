package org.tukaani.xz.delta;

/* JADX INFO: loaded from: classes3.dex */
public class DeltaEncoder extends DeltaCoder {
    public DeltaEncoder(int distance) {
        super(distance);
    }

    public void encode(byte[] in, int in_off, int len, byte[] out) {
        int i = 0;
    L3:
        if (i >= len) goto L6;
        byte tmp = this.history[(this.distance + this.pos) & 255];
        byte[] r2 = this.history;
        int r3 = this.pos;
        this.pos = r3 - 1;
        r2[r3 & 255] = in[in_off + i];
        out[i] = (byte) (in[in_off + i] - tmp);
        i = i + 1;
        goto L3
    }
}
