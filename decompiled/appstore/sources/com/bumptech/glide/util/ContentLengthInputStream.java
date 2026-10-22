package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    private ContentLengthInputStream(@NonNull InputStream r10, long r11) {
        super(r10);
        this.contentLength = r11;
    }

    private int checkReadSoFarOrThrow(int r10) throws IOException {
        if (r10 < 0) goto L5;
        this.readSoFar += r10;
    L6:
        return r10;
    L5:
        if ((this.contentLength - ((long) this.readSoFar)) <= 0) goto L6;
        throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream r10, @Nullable String r11) {
        return obtain(r10, parseContentLength(r11));
    }

    private static int parseContentLength(@Nullable String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L12;
    L10:
        return -1;
    L12:
        return Integer.parseInt(r10);
    L6:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L10;
        Log.d(TAG, "failed to parse content length header: " + r10, e);
        goto L10
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        int r10 = (int) Math.max(this.contentLength - ((long) this.readSoFar), ((FilterInputStream) this).in.available());
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        int r10 = super.read();     // Catch: Throwable -> L10
        if (r10 < 0) goto L6;
        int r11 = 1;
    L7:
        checkReadSoFarOrThrow(r11);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r10;
    L6:
        r11 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream r10, long r11) {
        return new ContentLengthInputStream(r10, r11);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r10) throws IOException {
        return read(r10, 0, r10.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r10, int r11, int r12) throws IOException {
        monitor-enter(this);
        int r13 = checkReadSoFarOrThrow(super.read(r10, r11, r12));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }
}
