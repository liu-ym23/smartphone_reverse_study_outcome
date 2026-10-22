package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.EOFException;

/* JADX INFO: loaded from: classes4.dex */
public final class TTBuffer {
    private Segment head;
    public int size;

    public TTBuffer() {
        this.head = null;
        this.size = 0;
    }

    Segment getWritableSegment() {
        Segment r0 = this.head;
        if (r0 != null) goto L6;
        Segment r1 = SegmentPool.take();
        this.head = r1;
        r1.prev = r1;
        r1.next = r1;
        return r1;
    L6:
        Segment r2 = r0.prev;
        if (r2.isWritable() == true) goto L10;
        r2.push(SegmentPool.take());
    L10:
        return this.head.prev;
    }

    public byte get() {
        if (this.size > 0) goto L5;
        return 0;
    L5:
        byte[] r2 = new byte[1];
        read(r2, 0, 1);
        return r2[0];
    }

    public int readToByteArray(byte[] r8, int r9, int r10) throws EOFException {
        checkOffsetAndCount(r8.length, r9, r10);
        int r0 = Math.min(this.size, r10);
        if (Logger.debug() == false) goto L5;
        Logger.d("TTBuffer", "start get buffer, size is " + this.size + " byteCount is " + r10);
    L5:
        int r11 = r9;
    L6:
        if (r0 <= 0) goto L15;
        int r1 = read(r8, r11, r0);
        if (r1 == (-1)) goto L13;
        r11 = r11 + r1;
        r0 = r0 - r1;
        if (Logger.debug() == false) goto L6;
        Logger.d("TTBuffer", "get segment buffer, n is " + r1 + " offset is " + r11 + " bytesRead is " + r0);
        goto L6
    L13:
        throw new EOFException();
    L15:
        return r11 - r9;
    }

    private int read(byte[] r8, int r9, int r10) {
        checkOffsetAndCount(r8.length, r9, r10);
        Segment r0 = this.head;
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r11 = r0.getInnerBufferTo(r8, r9, r10);
        if (Logger.debug() == false) goto L9;
        Logger.d("TTBuffer", "head curReadLength is " + r11);
    L9:
        this.size -= r11;
        if (r0.getInnerBuffer().hasRemaining() == true) goto L12;
        this.head = r0.release();
    L12:
        return r11;
    }

    public void releaseAllSegments() {
    L2:
        Segment r0 = this.head;
        if (r0 == null) goto L5;
        this.head = r0.release();
        goto L2
    }

    public static void checkOffsetAndCount(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(r4), Long.valueOf(r6), Long.valueOf(r8)}));
    }
}
