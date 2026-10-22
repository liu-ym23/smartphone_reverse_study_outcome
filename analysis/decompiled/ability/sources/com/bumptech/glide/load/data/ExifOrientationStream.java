package com.bumptech.glide.load.data;

import B7.a;
import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(a.h(i, "Cannot add invalid orientation: "));
        }
        this.orientation = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i;
        int i6 = this.position;
        int i10 = (i6 < 2 || i6 > (i = ORIENTATION_POSITION)) ? super.read() : i6 == i ? this.orientation : EXIF_SEGMENT[i6 - 2] & 255;
        if (i10 != -1) {
            this.position++;
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j5) throws IOException {
        long jSkip = super.skip(j5);
        if (jSkip > 0) {
            this.position = (int) (this.position + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i6) throws IOException {
        int i10;
        int i11 = this.position;
        int i12 = ORIENTATION_POSITION;
        if (i11 > i12) {
            i10 = super.read(bArr, i, i6);
        } else if (i11 == i12) {
            bArr[i] = this.orientation;
            i10 = 1;
        } else if (i11 < 2) {
            i10 = super.read(bArr, i, 2 - i11);
        } else {
            int iMin = Math.min(i12 - i11, i6);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i, iMin);
            i10 = iMin;
        }
        if (i10 > 0) {
            this.position += i10;
        }
        return i10;
    }
}
