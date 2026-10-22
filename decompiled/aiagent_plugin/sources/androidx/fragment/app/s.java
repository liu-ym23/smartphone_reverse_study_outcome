package androidx.fragment.app;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.io.Writer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LogWriter.java */
/* JADX INFO: loaded from: classes.dex */
final class s extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f1881b;

    s(String r3) {
        this.f1881b = new StringBuilder(128);
        this.f1880a = r3;
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
    public void write(char[] r4, int r5, int r6) {
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L9;
        char r1 = r4[r5 + r0];
        if (r1 != '\n') goto L7;
        a();
    L8:
        r0 = r0 + 1;
        goto L3
    L7:
        this.f1881b.append(r1);
        goto L8
    }

    private void a() {
        if (this.f1881b.length() <= 0) goto L6;
        a(this.f1880a, this.f1881b.toString());
        StringBuilder r2 = this.f1881b;
        r2.delete(0, r2.length());
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
