package com.fasterxml.jackson.a.d;

import com.fasterxml.jackson.a.h.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Writer;

/* JADX INFO: compiled from: SegmentedStringWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f12016a;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r1) {
        return append(r1);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3, int r4, int r5) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public l(com.fasterxml.jackson.a.h.a r2) {
        this.f12016a = new o(r2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char r1) {
        write(r1);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r4) {
        String r5 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        this.f12016a.a(r5, 0, r5.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r3, int r4, int r5) {
        String r6 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin")).subSequence(r4, r5).toString();
        this.f12016a.a(r6, 0, r6.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] r3) {
        this.f12016a.c(r3, 0, r3.length);
    }

    @Override // java.io.Writer
    public void write(char[] r1, int r2, int r3) {
        this.f12016a.c(r1, r2, r3);
    }

    @Override // java.io.Writer
    public void write(int r1) {
        this.f12016a.a((char) r1);
    }

    @Override // java.io.Writer
    public void write(String r3) {
        this.f12016a.a(r3, 0, r3.length());
    }

    @Override // java.io.Writer
    public void write(String r1, int r2, int r3) {
        this.f12016a.a(r1, r2, r3);
    }

    public String a() {
        String r0 = this.f12016a.e();
        this.f12016a.a();
        return r0;
    }
}
