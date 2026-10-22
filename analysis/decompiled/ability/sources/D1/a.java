package D1;

import A6.l;
import M0.h;
import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
public final class a {
    public static volatile a g;

    /* renamed from: a, reason: collision with root package name */
    public Context f371a;
    public cc.dd.hh.hh.a b;
    public h c;
    public volatile boolean d;
    public volatile boolean e;
    public String f;

    public static a b() {
        if (g == null) {
            synchronized (a.class) {
                try {
                    if (g == null) {
                        a aVar = new a();
                        aVar.c = new h(1);
                        g = aVar;
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final boolean a() {
        try {
            cc.dd.hh.hh.a aVar = this.b;
            if (aVar != null && aVar.f2146a) {
                try {
                    if ((this.f371a.getApplicationInfo().flags & 2) != 0) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            U7.a.j(Log.getStackTraceString(e), new Object[0]);
        }
        return false;
    }

    public final void c() {
        if (this.e) {
            return;
        }
        U7.a.j("MemoryApi start", new Object[0]);
        this.e = true;
        if (!this.d) {
            throw new IllegalStateException("You must call init() first before using !!!");
        }
        E1.a.b.execute(new l(this, 3));
    }
}
