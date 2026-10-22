package n3;

import ab.x;
import android.content.Context;
import c7.o;
import c7.q;
import q7.k;

/* loaded from: classes.dex */
public final class h implements m3.a {

    /* renamed from: f, reason: collision with root package name */
    public final Context f6830f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6831g;

    /* renamed from: h, reason: collision with root package name */
    public final x f6832h;

    /* renamed from: i, reason: collision with root package name */
    public final o f6833i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6834j;

    public h(Context context, String str, x xVar) {
        k.e(context, "context");
        k.e(xVar, "callback");
        this.f6830f = context;
        this.f6831g = str;
        this.f6832h = xVar;
        this.f6833i = s7.a.H(new a8.c(15, this));
    }

    @Override // m3.a
    public final c N() {
        return ((g) this.f6833i.getValue()).a(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6833i.f1980g != q.f1985a) {
            ((g) this.f6833i.getValue()).close();
        }
    }

    @Override // m3.a
    public final void setWriteAheadLoggingEnabled(boolean z4) {
        if (this.f6833i.f1980g != q.f1985a) {
            g gVar = (g) this.f6833i.getValue();
            k.e(gVar, "sQLiteOpenHelper");
            gVar.setWriteAheadLoggingEnabled(z4);
        }
        this.f6834j = z4;
    }
}
