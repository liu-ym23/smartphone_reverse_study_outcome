package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class P extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final String f14052a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f14053b = new StringBuilder(128);

    public P(String str) {
        this.f14052a = str;
    }

    public final void b() {
        if (this.f14053b.length() > 0) {
            Log.d(this.f14052a, this.f14053b.toString());
            StringBuilder sb2 = this.f14053b;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        b();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                b();
            } else {
                this.f14053b.append(c10);
            }
        }
    }
}
