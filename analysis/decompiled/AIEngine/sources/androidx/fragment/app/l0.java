package androidx.fragment.app;

import android.util.Log;
import com.stepos.core.common.util.TraceIdKeys;
import java.io.Writer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l0 extends Writer {

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f2166b = new StringBuilder(TraceIdKeys.MAX_LENGTH);

    /* renamed from: a, reason: collision with root package name */
    public final String f2165a = "FragmentManager";

    public final void a() {
        StringBuilder sb2 = this.f2166b;
        if (sb2.length() > 0) {
            Log.d(this.f2165a, sb2.toString());
            sb2.delete(0, sb2.length());
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
    public final void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c9 = cArr[i10 + i12];
            if (c9 == '\n') {
                a();
            } else {
                this.f2166b.append(c9);
            }
        }
    }
}
