package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n extends Writer {

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f689b = new StringBuilder(128);

    /* renamed from: a, reason: collision with root package name */
    public final String f688a = "FragmentManager";

    public final void a() {
        StringBuilder sb = this.f689b;
        if (sb.length() > 0) {
            Log.d(this.f688a, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            char c3 = cArr[i8 + i10];
            if (c3 == '\n') {
                a();
            } else {
                this.f689b.append(c3);
            }
        }
    }
}
