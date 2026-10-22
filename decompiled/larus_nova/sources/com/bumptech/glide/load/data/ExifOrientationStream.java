package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT = null;
    private static final int ORIENTATION_POSITION = 0;
    private static final int SEGMENT_LENGTH = 0;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    static {
        byte[] r100 = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = r100;
        int r101 = r100.length;
        SEGMENT_LENGTH = r101;
        ORIENTATION_POSITION = r101 + 2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r100 = this.position;
        if (r100 < 2) goto L10;
        int r101 = ORIENTATION_POSITION;
        if (r100 > r101) goto L10;
        if (r100 != r101) goto L9;
        int r102 = this.orientation;
    L12:
        if (r102 == (-1)) goto L14;
        this.position++;
    L14:
        return r102;
    L9:
        r102 = EXIF_SEGMENT[r100 - 2] & UByte.MAX_VALUE;
    L10:
        r102 = super.read();
        goto L12
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        long r101 = super.skip(r100);
        if (r101 <= 0) goto L5;
        this.position = (int) (((long) this.position) + r101);
    L5:
        return r101;
    }

    public ExifOrientationStream(InputStream r100, int r101) {
        super(r100);
        if (r101 < (-1)) goto L9;
        if (r101 > 8) goto L9;
        this.orientation = (byte) r101;
        return;
    L9:
        throw new IllegalArgumentException("Cannot add invalid orientation: " + r101);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.position;
        int r104 = ORIENTATION_POSITION;
        if (r103 <= r104) goto L5;
        int r105 = super.read(r100, r101, r102);
    L11:
        if (r105 <= 0) goto L13;
        this.position += r105;
    L13:
        return r105;
    L5:
        if (r103 != r104) goto L8;
        r100[r101] = this.orientation;
        r105 = 1;
        goto L11
    L8:
        if (r103 >= 2) goto L10;
        r105 = super.read(r100, r101, 2 - r103);
        goto L11
    L10:
        int r106 = Math.min(r104 - r103, r102);
        System.arraycopy(EXIF_SEGMENT, this.position - 2, r100, r101, r106);
        r105 = r106;
        goto L11
    }
}
