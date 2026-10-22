package O0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import v0.ComponentCallbacks2C1180c;
import x0.InterfaceC1277a;
import z0.InterfaceC1340f;
import z0.k;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC1277a f4317a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f4318b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f4319c;

    /* renamed from: d, reason: collision with root package name */
    final v0.j f4320d;

    /* renamed from: e, reason: collision with root package name */
    private final D0.d f4321e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4322f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4323g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4324h;

    /* renamed from: i, reason: collision with root package name */
    private v0.i<Bitmap> f4325i;

    /* renamed from: j, reason: collision with root package name */
    private a f4326j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4327k;

    /* renamed from: l, reason: collision with root package name */
    private a f4328l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f4329m;

    /* renamed from: n, reason: collision with root package name */
    private k<Bitmap> f4330n;

    /* renamed from: o, reason: collision with root package name */
    private a f4331o;

    static class a extends U0.c<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f4332d;

        /* renamed from: e, reason: collision with root package name */
        final int f4333e;

        /* renamed from: f, reason: collision with root package name */
        private final long f4334f;

        /* renamed from: g, reason: collision with root package name */
        private Bitmap f4335g;

        a(Handler handler, int i5, long j5) {
            this.f4332d = handler;
            this.f4333e = i5;
            this.f4334f = j5;
        }

        Bitmap h() {
            return this.f4335g;
        }

        @Override // U0.e
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void l(Bitmap bitmap, V0.b<? super Bitmap> bVar) {
            this.f4335g = bitmap;
            this.f4332d.sendMessageAtTime(this.f4332d.obtainMessage(1, this), this.f4334f);
        }
    }

    public interface b {
        void a();
    }

    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 1) {
                g.this.n((a) message.obj);
                return true;
            }
            if (i5 != 2) {
                return false;
            }
            g.this.f4320d.o((a) message.obj);
            return false;
        }
    }

    g(ComponentCallbacks2C1180c componentCallbacks2C1180c, InterfaceC1277a interfaceC1277a, int i5, int i6, k<Bitmap> kVar, Bitmap bitmap) {
        this(componentCallbacks2C1180c.f(), ComponentCallbacks2C1180c.t(componentCallbacks2C1180c.h()), interfaceC1277a, null, j(ComponentCallbacks2C1180c.t(componentCallbacks2C1180c.h()), i5, i6), kVar, bitmap);
    }

    private static InterfaceC1340f g() {
        return new W0.b(Double.valueOf(Math.random()));
    }

    private int h() {
        return X0.k.g(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private static v0.i<Bitmap> j(v0.j jVar, int i5, int i6) {
        return jVar.i().b(T0.h.Z(C0.j.f395b).X(true).T(true).N(i5, i6));
    }

    private void m() {
        if (!this.f4322f || this.f4323g) {
            return;
        }
        if (this.f4324h) {
            X0.j.a(this.f4331o == null, "Pending target must be null when starting from the first frame");
            this.f4317a.g();
            this.f4324h = false;
        }
        a aVar = this.f4331o;
        if (aVar != null) {
            this.f4331o = null;
            n(aVar);
            return;
        }
        this.f4323g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.f4317a.e();
        this.f4317a.c();
        this.f4328l = new a(this.f4318b, this.f4317a.h(), jUptimeMillis);
        this.f4325i.b(T0.h.a0(g())).m0(this.f4317a).g0(this.f4328l);
    }

    private void o() {
        Bitmap bitmap = this.f4329m;
        if (bitmap != null) {
            this.f4321e.c(bitmap);
            this.f4329m = null;
        }
    }

    private void q() {
        if (this.f4322f) {
            return;
        }
        this.f4322f = true;
        this.f4327k = false;
        m();
    }

    private void r() {
        this.f4322f = false;
    }

    void a() {
        this.f4319c.clear();
        o();
        r();
        a aVar = this.f4326j;
        if (aVar != null) {
            this.f4320d.o(aVar);
            this.f4326j = null;
        }
        a aVar2 = this.f4328l;
        if (aVar2 != null) {
            this.f4320d.o(aVar2);
            this.f4328l = null;
        }
        a aVar3 = this.f4331o;
        if (aVar3 != null) {
            this.f4320d.o(aVar3);
            this.f4331o = null;
        }
        this.f4317a.clear();
        this.f4327k = true;
    }

    ByteBuffer b() {
        return this.f4317a.a().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.f4326j;
        return aVar != null ? aVar.h() : this.f4329m;
    }

    int d() {
        a aVar = this.f4326j;
        if (aVar != null) {
            return aVar.f4333e;
        }
        return -1;
    }

    Bitmap e() {
        return this.f4329m;
    }

    int f() {
        return this.f4317a.d();
    }

    int i() {
        return c().getHeight();
    }

    int k() {
        return this.f4317a.i() + h();
    }

    int l() {
        return c().getWidth();
    }

    void n(a aVar) {
        this.f4323g = false;
        if (this.f4327k) {
            this.f4318b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f4322f) {
            this.f4331o = aVar;
            return;
        }
        if (aVar.h() != null) {
            o();
            a aVar2 = this.f4326j;
            this.f4326j = aVar;
            for (int size = this.f4319c.size() - 1; size >= 0; size--) {
                this.f4319c.get(size).a();
            }
            if (aVar2 != null) {
                this.f4318b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        m();
    }

    void p(k<Bitmap> kVar, Bitmap bitmap) {
        this.f4330n = (k) X0.j.d(kVar);
        this.f4329m = (Bitmap) X0.j.d(bitmap);
        this.f4325i = this.f4325i.b(new T0.h().V(kVar));
    }

    void s(b bVar) {
        if (this.f4327k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f4319c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f4319c.isEmpty();
        this.f4319c.add(bVar);
        if (zIsEmpty) {
            q();
        }
    }

    void t(b bVar) {
        this.f4319c.remove(bVar);
        if (this.f4319c.isEmpty()) {
            r();
        }
    }

    g(D0.d dVar, v0.j jVar, InterfaceC1277a interfaceC1277a, Handler handler, v0.i<Bitmap> iVar, k<Bitmap> kVar, Bitmap bitmap) {
        this.f4319c = new ArrayList();
        this.f4320d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f4321e = dVar;
        this.f4318b = handler;
        this.f4325i = iVar;
        this.f4317a = interfaceC1277a;
        p(kVar, bitmap);
    }
}
