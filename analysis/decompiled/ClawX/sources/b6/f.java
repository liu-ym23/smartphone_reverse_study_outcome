package b6;

import a6.b0;
import a6.b2;
import a6.c0;
import a6.h1;
import a6.n0;
import a6.r0;
import a6.s0;
import a6.s1;
import android.os.Handler;
import android.os.Looper;
import f5.h;
import f6.m;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends b0 implements n0 {

    /* renamed from: c, reason: collision with root package name */
    public final Handler f929c;
    public final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final f f930e;

    public f(Handler handler, boolean z) {
        this.f929c = handler;
        this.d = z;
        this.f930e = z ? this : new f(handler, true);
    }

    @Override // a6.b0
    public final void C(h hVar, Runnable runnable) {
        if (this.f929c.post(runnable)) {
            return;
        }
        H(hVar, runnable);
    }

    @Override // a6.b0
    public final boolean F(h hVar) {
        return (this.d && p.a(Looper.myLooper(), this.f929c.getLooper())) ? false : true;
    }

    public final void H(h hVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        h1 h1Var = (h1) hVar.o(c0.f143b);
        if (h1Var != null) {
            h1Var.e(cancellationException);
        }
        h6.e eVar = r0.f210a;
        h6.d.f3059c.C(hVar, runnable);
    }

    @Override // a6.n0
    public final s0 b(long j4, final b2 b2Var, h hVar) {
        if (j4 > 4611686018427387903L) {
            j4 = 4611686018427387903L;
        }
        if (this.f929c.postDelayed(b2Var, j4)) {
            return new s0() { // from class: b6.c
                @Override // a6.s0
                public final void b() {
                    this.f921a.f929c.removeCallbacks(b2Var);
                }
            };
        }
        H(hVar, b2Var);
        return s1.f213a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return fVar.f929c == this.f929c && fVar.d == this.d;
    }

    public final int hashCode() {
        return (this.d ? 1231 : 1237) ^ System.identityHashCode(this.f929c);
    }

    @Override // a6.b0
    public final String toString() {
        f fVar;
        String str;
        h6.e eVar = r0.f210a;
        f fVar2 = m.f2657a;
        if (this == fVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                fVar = fVar2.f930e;
            } catch (UnsupportedOperationException unused) {
                fVar = null;
            }
            str = this == fVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f929c.toString();
        return this.d ? a8.b.n(string, ".immediate") : string;
    }

    @Override // a6.n0
    public final void u(long j4, a6.m mVar) {
        d dVar = new d(mVar, 0, this);
        if (j4 > 4611686018427387903L) {
            j4 = 4611686018427387903L;
        }
        if (this.f929c.postDelayed(dVar, j4)) {
            mVar.v(new e(this, 0, dVar));
        } else {
            H(mVar.f192e, dVar);
        }
    }
}
