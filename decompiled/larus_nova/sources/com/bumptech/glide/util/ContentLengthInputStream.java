package com.bumptech.glide.util;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        int r100 = (int) Math.max(this.contentLength - ((long) this.readSoFar), ((FilterInputStream) this).in.available());
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        int r100 = super.read();     // Catch: Throwable -> L10
        if (r100 < 0) goto L6;
        int r101 = 1;
    L7:
        checkReadSoFarOrThrow(r101);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L6:
        r101 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    private int checkReadSoFarOrThrow(int r100) throws IOException {
        if (r100 < 0) goto L5;
        this.readSoFar += r100;
    L6:
        return r100;
    L5:
        if ((this.contentLength - ((long) this.readSoFar)) <= 0) goto L6;
        throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
    }

    private static int parseContentLength(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
    L8:
        return -1;
    L10:
        return CastIntegerProtector.parseInt(r100);
    L6:
        e = move-exception;
        GlideLogUtil.e(TAG, "failed to parse content length header: " + r100, e);
        goto L8
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    private ContentLengthInputStream(InputStream r100, long r101) {
        super(r100);
        this.contentLength = r101;
    }

    public static InputStream obtain(InputStream r100, String r101) {
        return obtain(r100, parseContentLength(r101));
    }

    public static InputStream obtain(InputStream r100, long r101) {
        return new ContentLengthInputStream(r100, r101);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r100, int r101, int r102) throws IOException {
        monitor-enter(this);
        int r103 = checkReadSoFarOrThrow(super.read(r100, r101, r102));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }
}
