package org.apache.commons.compress.compressors.lz4;

import java.util.zip.Checksum;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public class XXHash32 implements Checksum {
    private static final int BUF_SIZE = 16;
    private static final int PRIME1 = -1640531535;
    private static final int PRIME2 = -2048144777;
    private static final int PRIME3 = -1028477379;
    private static final int PRIME4 = 668265263;
    private static final int PRIME5 = 374761393;
    private static final int ROTATE_BITS = 13;
    private final byte[] buffer;
    private final byte[] oneByte;
    private int pos;
    private final int seed;
    private final int[] state;
    private int totalLen;

    public XXHash32() {
        this(0);
    }

    public XXHash32(int seed) {
        this.oneByte = new byte[1];
        this.state = new int[4];
        this.buffer = new byte[16];
        this.seed = seed;
        initializeState();
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        initializeState();
        this.totalLen = 0;
        this.pos = 0;
    }

    @Override // java.util.zip.Checksum
    public void update(int b) {
        this.oneByte[0] = (byte) (b & 255);
        update(this.oneByte, 0, 1);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] b, int off, int len) {
        if (len > 0) goto L4;
        return;
    L4:
        this.totalLen += len;
        int end = off + len;
        if ((this.pos + len) >= 16) goto L9;
        System.arraycopy(b, off, this.buffer, this.pos, len);
        this.pos += len;
        return;
    L9:
        if (this.pos <= 0) goto L11;
        int size = 16 - this.pos;
        System.arraycopy(b, off, this.buffer, this.pos, size);
        process(this.buffer, 0);
        off = off + size;
    L11:
        int limit = end - 16;
    L12:
        if (off > limit) goto L14;
        process(b, off);
        off = off + 16;
        goto L12
    L14:
        if (off >= end) goto L18;
        this.pos = end - off;
        System.arraycopy(b, off, this.buffer, 0, this.pos);
        return;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        if (this.totalLen <= 16) goto L5;
        int hash = ((Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7)) + Integer.rotateLeft(this.state[2], 12)) + Integer.rotateLeft(this.state[3], 18);
    L6:
        int hash2 = hash + this.totalLen;
        int idx = 0;
        int limit = this.pos - 4;
    L8:
        if (idx > limit) goto L11;
        hash2 = Integer.rotateLeft((getInt(this.buffer, idx) * PRIME3) + hash2, 17) * PRIME4;
        idx = idx + 4;
    L11:
        if (idx >= this.pos) goto L13;
        hash2 = Integer.rotateLeft(((this.buffer[idx] & 255) * PRIME5) + hash2, 11) * PRIME1;
        idx = idx + 1;
        goto L11
    L13:
        int hash3 = (hash2 ^ (hash2 >>> 15)) * PRIME2;
        int hash4 = (hash3 ^ (hash3 >>> 13)) * PRIME3;
        return ((long) (hash4 ^ (hash4 >>> 16))) & 4294967295L;
    L5:
        hash = this.state[2] + PRIME5;
        goto L6
    }

    private static int getInt(byte[] buffer, int idx) {
        return (int) (ByteUtils.fromLittleEndian(buffer, idx, 4) & 4294967295L);
    }

    private void initializeState() {
        this.state[0] = (this.seed + PRIME1) + PRIME2;
        this.state[1] = this.seed + PRIME2;
        this.state[2] = this.seed;
        this.state[3] = this.seed - PRIME1;
    }

    private void process(byte[] b, int offset) {
        int s0 = this.state[0];
        int s1 = this.state[1];
        int s2 = this.state[2];
        int s3 = this.state[3];
        int s4 = Integer.rotateLeft((getInt(b, offset) * PRIME2) + s0, 13) * PRIME1;
        int s5 = offset + 4;
        int s6 = Integer.rotateLeft((getInt(b, s5) * PRIME2) + s1, 13) * PRIME1;
        int s7 = offset + 8;
        int s8 = Integer.rotateLeft((getInt(b, s7) * PRIME2) + s2, 13) * PRIME1;
        int s9 = offset + 12;
        int s10 = Integer.rotateLeft((getInt(b, s9) * PRIME2) + s3, 13) * PRIME1;
        this.state[0] = s4;
        this.state[1] = s6;
        this.state[2] = s8;
        this.state[3] = s10;
        this.pos = 0;
    }
}
