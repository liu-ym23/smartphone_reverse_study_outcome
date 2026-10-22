package C2;

import java.io.Serializable;
import java.io.Writer;

/* loaded from: classes.dex */
public final class h extends Writer implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f347a = new StringBuilder();

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c4) {
        this.f347a.append(c4);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    public final String toString() {
        return this.f347a.toString();
    }

    @Override // java.io.Writer
    public final void write(String str) {
        if (str != null) {
            this.f347a.append(str);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c4) {
        this.f347a.append(c4);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f347a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i4, int i5) {
        if (cArr != null) {
            this.f347a.append(cArr, i4, i5);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        this.f347a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i4, int i5) {
        this.f347a.append(charSequence, i4, i5);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i4, int i5) {
        this.f347a.append(charSequence, i4, i5);
        return this;
    }
}
