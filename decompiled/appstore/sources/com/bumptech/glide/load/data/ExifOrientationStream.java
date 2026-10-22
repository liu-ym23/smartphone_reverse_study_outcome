package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT = null;
    private static final int ORIENTATION_POSITION = 0;
    private static final int SEGMENT_LENGTH = 0;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        byte[] r10 = {-1, -31, 0, Ascii.FS, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = r10;
        int r11 = r10.length;
        SEGMENT_LENGTH = r11;
        ORIENTATION_POSITION = r11 + 2;
    }

    public ExifOrientationStream(InputStream r10, int r11) {
        super(r10);
        if (r11 < (-1)) goto L9;
        if (r11 > 8) goto L9;
        this.orientation = (byte) r11;
        return;
    L9:
        throw new IllegalArgumentException("Cannot add invalid orientation: " + r11);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r10 = this.position;
        if (r10 < 2) goto L10;
        int r11 = ORIENTATION_POSITION;
        if (r10 > r11) goto L10;
        if (r10 != r11) goto L9;
        int r12 = this.orientation;
    L12:
        if (r12 == (-1)) goto L14;
        this.position++;
    L14:
        return r12;
    L9:
        r12 = EXIF_SEGMENT[r10 - 2] & UnsignedBytes.MAX_VALUE;
    L10:
        r12 = super.read();
        goto L12
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r10) throws IOException {
        long r11 = super.skip(r10);
        if (r11 <= 0) goto L5;
        this.position = (int) (((long) this.position) + r11);
    L5:
        return r11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] r10, int r11, int r12) throws IOException {
        int r13 = this.position;
        int r14 = ORIENTATION_POSITION;
        if (r13 <= r14) goto L5;
        int r15 = super.read(r10, r11, r12);
    L11:
        if (r15 <= 0) goto L13;
        this.position += r15;
    L13:
        return r15;
    L5:
        if (r13 != r14) goto L8;
        r10[r11] = this.orientation;
        r15 = 1;
        goto L11
    L8:
        if (r13 >= 2) goto L10;
        r15 = super.read(r10, r11, 2 - r13);
        goto L11
    L10:
        int r16 = Math.min(r14 - r13, r12);
        System.arraycopy(EXIF_SEGMENT, this.position - 2, r10, r11, r16);
        r15 = r16;
        goto L11
    }
}
