package M;

import java.io.Writer;

/* loaded from: classes2.dex */
public final class b extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public int f949a = 0;

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c) {
        this.f949a++;
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i6) {
        this.f949a += i6;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c) {
        this.f949a++;
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i) {
        this.f949a++;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f949a = charSequence.length() + this.f949a;
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        this.f949a = str.length() + this.f949a;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        this.f949a = charSequence.length() + this.f949a;
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr) {
        this.f949a += cArr.length;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i, int i6) {
        this.f949a = (i6 - i) + this.f949a;
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i, int i6) {
        this.f949a += i6;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i6) {
        this.f949a = (i6 - i) + this.f949a;
        return this;
    }
}
