package com.apm.lite.k;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class f extends PrintWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageDigest f29998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f29999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f30000c;

    public static class a {
        public a() {
        }

        public boolean a(String r100) {
            return true;
        }
    }

    public f(OutputStream r100, MessageDigest r101, a r102) {
        super(r100);
        this.f29998a = null;
        this.f29999b = null;
        this.f30000c = null;
        this.f29998a = r101;
        this.f30000c = r102;
        if (r101 == null) goto L6;
        this.f29999b = Charset.defaultCharset();
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(int r100) {
        super.write(r100);
        MessageDigest r101 = this.f29998a;
        if (r101 == null) goto L6;
        r101.update((byte) r100);
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(String r100, int r101, int r102) {
        super.write(r100, r101, r102);
        if (this.f29998a == null) goto L10;
        a r103 = this.f30000c;
        if (r103 != null) goto L7;
    L8:
        this.f29998a.update(this.f29999b.encode(CharBuffer.wrap(r100, r101, r102 + r101)).array());
        return;
    L7:
        if (r103.a(r100) == true) goto L8;
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(char[] r100, int r101, int r102) {
        super.write(r100, r101, r102);
        MessageDigest r103 = this.f29998a;
        if (r103 == null) goto L6;
        r103.update(this.f29999b.encode(CharBuffer.wrap(r100)).array());
        return;
    }
}
