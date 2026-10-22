package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    private ContentLengthInputStream(InputStream inputStream, long j10) {
        super(inputStream);
        this.contentLength = j10;
    }

    private int checkReadSoFarOrThrow(int i10) throws IOException {
        if (i10 >= 0) {
            this.readSoFar += i10;
            return i10;
        }
        if (this.contentLength - this.readSoFar <= 0) {
            return i10;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
    }

    public static InputStream obtain(InputStream inputStream, String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    private static int parseContentLength(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            if (!Log.isLoggable(TAG, 3)) {
                return -1;
            }
            Log.d(TAG, "failed to parse content length header: " + str, e10);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - this.readSoFar, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i10;
        i10 = super.read();
        checkReadSoFarOrThrow(i10 >= 0 ? 1 : -1);
        return i10;
    }

    public static InputStream obtain(InputStream inputStream, long j10) {
        return new ContentLengthInputStream(inputStream, j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i10, i11));
    }
}
