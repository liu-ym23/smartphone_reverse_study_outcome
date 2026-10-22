package androidx.fragment.app;

import android.util.Log;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends Writer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1275c;

    /* renamed from: f, reason: collision with root package name */
    public final StringBuilder f1276f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f1277g;

    public c0() {
        this.f1275c = 0;
        this.f1276f = new StringBuilder(128);
        this.f1277g = "FragmentManager";
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        switch (this.f1275c) {
            case 1:
                this.f1276f.append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f1275c) {
            case 0:
                g();
                break;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        switch (this.f1275c) {
            case 0:
                g();
                break;
        }
    }

    public void g() {
        StringBuilder sb2 = this.f1276f;
        if (sb2.length() > 0) {
            Log.d((String) this.f1277g, sb2.toString());
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i3) {
        switch (this.f1275c) {
            case 0:
                for (int i10 = 0; i10 < i3; i10++) {
                    char c9 = cArr[i + i10];
                    if (c9 == '\n') {
                        g();
                    } else {
                        this.f1276f.append(c9);
                    }
                }
                break;
            default:
                o7.p pVar = (o7.p) this.f1277g;
                pVar.f9281c = cArr;
                pVar.f9282f = null;
                this.f1276f.append((CharSequence) pVar, i, i3 + i);
                break;
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(CharSequence charSequence) {
        switch (this.f1275c) {
            case 1:
                this.f1276f.append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i3) {
        switch (this.f1275c) {
            case 1:
                this.f1276f.append(charSequence, i, i3);
                return this;
            default:
                return super.append(charSequence, i, i3);
        }
    }

    private final void d() {
    }

    private final void e() {
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i, int i3) {
        switch (this.f1275c) {
            case 1:
                this.f1276f.append(charSequence, i, i3);
                return this;
            default:
                return super.append(charSequence, i, i3);
        }
    }

    public c0(StringBuilder sb2) {
        this.f1275c = 1;
        this.f1277g = new o7.p();
        this.f1276f = sb2;
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        switch (this.f1275c) {
            case 1:
                this.f1276f.append((char) i);
                break;
            default:
                super.write(i);
                break;
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i3) throws IOException {
        switch (this.f1275c) {
            case 1:
                Objects.requireNonNull(str);
                this.f1276f.append((CharSequence) str, i, i3 + i);
                break;
            default:
                super.write(str, i, i3);
                break;
        }
    }
}
