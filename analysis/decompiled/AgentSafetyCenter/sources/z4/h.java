package z4;

import android.content.Context;
import java.io.IOException;
import jb.k;
import jb.s;
import n3.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements y4.c {

    /* renamed from: c, reason: collision with root package name */
    public Context f16402c;

    /* renamed from: f, reason: collision with root package name */
    public String f16403f;

    /* renamed from: g, reason: collision with root package name */
    public r0 f16404g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16405h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public k f16406j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16407k;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f16406j.f6767f != s.f6773a) {
            ((g) this.f16406j.getValue()).close();
        }
    }

    @Override // y4.c
    public final String getDatabaseName() {
        return this.f16403f;
    }

    @Override // y4.c
    public final void setWriteAheadLoggingEnabled(boolean z10) {
        if (this.f16406j.f6767f != s.f6773a) {
            ((g) this.f16406j.getValue()).setWriteAheadLoggingEnabled(z10);
        }
        this.f16407k = z10;
    }

    @Override // y4.c
    public final c w() {
        return ((g) this.f16406j.getValue()).d(true);
    }
}
