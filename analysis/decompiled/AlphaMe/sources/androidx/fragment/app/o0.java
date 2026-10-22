package androidx.fragment.app;

import android.util.Log;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* loaded from: classes.dex */
public final class o0 extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3792a = 0;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f3794c = new StringBuilder(128);

    /* renamed from: b, reason: collision with root package name */
    public final Object f3793b = "FragmentManager";

    public final void a() {
        if (((StringBuilder) this.f3794c).length() > 0) {
            Log.d((String) this.f3793b, ((StringBuilder) this.f3794c).toString());
            CharSequence charSequence = this.f3794c;
            ((StringBuilder) charSequence).delete(0, ((StringBuilder) charSequence).length());
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        switch (this.f3792a) {
            case 1:
                return append(charSequence);
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f3792a) {
            case 0:
                a();
                break;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        switch (this.f3792a) {
            case 0:
                a();
                break;
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i4, int i5) throws IOException {
        switch (this.f3792a) {
            case 0:
                for (int i6 = 0; i6 < i5; i6++) {
                    char c4 = cArr[i4 + i6];
                    if (c4 == '\n') {
                        a();
                    } else {
                        ((StringBuilder) this.f3794c).append(c4);
                    }
                }
                break;
            default:
                G1.t tVar = (G1.t) this.f3794c;
                tVar.getClass();
                tVar.getClass();
                ((Appendable) this.f3793b).append(tVar, i4, i5 + i4);
                break;
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i4, int i5) {
        switch (this.f3792a) {
            case 1:
                return append(charSequence, i4, i5);
            default:
                return super.append(charSequence, i4, i5);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) throws IOException {
        switch (this.f3792a) {
            case 1:
                ((Appendable) this.f3793b).append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i4, int i5) throws IOException {
        switch (this.f3792a) {
            case 1:
                ((Appendable) this.f3793b).append(charSequence, i4, i5);
                return this;
            default:
                return super.append(charSequence, i4, i5);
        }
    }

    @Override // java.io.Writer
    public final void write(int i4) throws IOException {
        switch (this.f3792a) {
            case 1:
                ((Appendable) this.f3793b).append((char) i4);
                break;
            default:
                super.write(i4);
                break;
        }
    }

    @Override // java.io.Writer
    public final void write(String str, int i4, int i5) throws IOException {
        switch (this.f3792a) {
            case 1:
                Objects.requireNonNull(str);
                ((Appendable) this.f3793b).append(str, i4, i5 + i4);
                break;
            default:
                super.write(str, i4, i5);
                break;
        }
    }
}
