package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f3353b;

    public g0(String r10) {
        this.f3353b = new StringBuilder(128);
        this.f3352a = r10;
    }

    public final void a() {
        if (this.f3353b.length() <= 0) goto L6;
        Log.d(this.f3352a, this.f3353b.toString());
        StringBuilder r10 = this.f3353b;
        r10.delete(0, r10.length());
        return;
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
    public void write(char[] r10, int r11, int r12) {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        char r14 = r10[r11 + r13];
        if (r14 != '\n') goto L7;
        a();
    L8:
        r13 = r13 + 1;
        goto L3
    L7:
        this.f3353b.append(r14);
        goto L8
    }
}
