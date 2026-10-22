package x2;

import a3.i;
import java.io.Writer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final i f13730a;

    public f(a3.a aVar) {
        this.f13730a = new i(aVar);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr) {
        this.f13730a.b(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i10, int i11) {
        append(charSequence, i10, i11);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i10, int i11) {
        this.f13730a.b(cArr, i10, i11);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c9) {
        write(c9);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        this.f13730a.a(0, str.length(), str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c9) {
        write(c9);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i10, int i11) {
        this.f13730a.a(i10, i11, str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this.f13730a.a(0, string.length(), string);
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i10) {
        char c9 = (char) i10;
        i iVar = this.f13730a;
        if (iVar.f26c >= 0) {
            iVar.q(16);
        }
        iVar.f32j = null;
        iVar.f33k = null;
        char[] cArr = iVar.h;
        if (iVar.f31i >= cArr.length) {
            iVar.j();
            cArr = iVar.h;
        }
        int i11 = iVar.f31i;
        iVar.f31i = i11 + 1;
        cArr[i11] = c9;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i10, int i11) {
        String string = charSequence.subSequence(i10, i11).toString();
        this.f13730a.a(0, string.length(), string);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
