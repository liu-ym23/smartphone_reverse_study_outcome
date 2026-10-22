package n9;

import H7.h;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import m9.AbstractC1691I;
import m9.C1718k;
import m9.InterfaceC1693K;
import m9.n0;

/* renamed from: n9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1748d extends AbstractC1749e {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f5370a;
    public final String b;
    public final boolean c;
    public final C1748d d;

    public C1748d(Handler handler, String str, boolean z10) {
        this.f5370a = handler;
        this.b = str;
        this.c = z10;
        this.d = z10 ? this : new C1748d(handler, str, true);
    }

    public final void E(h hVar, Runnable runnable) {
        kotlinx.coroutines.a.d(hVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        u9.d dVar = AbstractC1691I.f5315a;
        u9.c.f6743a.dispatch(hVar, runnable);
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(h hVar, Runnable runnable) {
        if (this.f5370a.post(runnable)) {
            return;
        }
        E(hVar, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1748d)) {
            return false;
        }
        C1748d c1748d = (C1748d) obj;
        return c1748d.f5370a == this.f5370a && c1748d.c == this.c;
    }

    public final int hashCode() {
        return (this.c ? 1231 : 1237) ^ System.identityHashCode(this.f5370a);
    }

    @Override // m9.AbstractC1729v
    public final boolean isDispatchNeeded(h hVar) {
        return (this.c && k.b(Looper.myLooper(), this.f5370a.getLooper())) ? false : true;
    }

    @Override // m9.InterfaceC1688F
    public final InterfaceC1693K l(long j5, final Runnable runnable, h hVar) {
        if (j5 > 4611686018427387903L) {
            j5 = 4611686018427387903L;
        }
        if (this.f5370a.postDelayed(runnable, j5)) {
            return new InterfaceC1693K() { // from class: n9.c
                @Override // m9.InterfaceC1693K
                public final void dispose() {
                    this.f5369a.f5370a.removeCallbacks(runnable);
                }
            };
        }
        E(hVar, runnable);
        return n0.f5331a;
    }

    @Override // m9.InterfaceC1688F
    public final void s(long j5, C1718k c1718k) {
        A.a aVar = new A.a(14, c1718k, false, this);
        if (j5 > 4611686018427387903L) {
            j5 = 4611686018427387903L;
        }
        if (this.f5370a.postDelayed(aVar, j5)) {
            c1718k.j(new R3.b(26, this, aVar));
        } else {
            E(c1718k.e, aVar);
        }
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        C1748d c1748d;
        String str;
        u9.d dVar = AbstractC1691I.f5315a;
        C1748d c1748d2 = s9.k.f6003a;
        if (this == c1748d2) {
            str = "Dispatchers.Main";
        } else {
            try {
                c1748d = c1748d2.d;
            } catch (UnsupportedOperationException unused) {
                c1748d = null;
            }
            str = this == c1748d ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.b;
        if (string == null) {
            string = this.f5370a.toString();
        }
        return this.c ? androidx.appfunctions.metadata.a.l(string, ".immediate") : string;
    }

    public C1748d(Handler handler) {
        this(handler, null, false);
    }
}
