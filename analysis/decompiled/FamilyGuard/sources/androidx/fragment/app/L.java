package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
final class L extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f10485a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f10486b = new StringBuilder(128);

    L(String str) {
        this.f10485a = str;
    }

    private void a() {
        if (this.f10486b.length() > 0) {
            Log.d(this.f10485a, this.f10486b.toString());
            StringBuilder sb = this.f10486b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            char c6 = cArr[i5 + i7];
            if (c6 == '\n') {
                a();
            } else {
                this.f10486b.append(c6);
            }
        }
    }
}
