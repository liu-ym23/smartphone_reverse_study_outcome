package t3;

import a4.j;
import a6.c0;
import a6.f0;
import a6.h1;
import a6.j1;
import androidx.emoji2.text.m;
import f5.h;
import java.io.Closeable;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import p5.l;
import z3.g;
import z3.j0;
import z3.k0;
import z3.n;
import z3.p0;
import z3.x;
import z3.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements f0, Closeable {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5566m = AtomicIntegerFieldUpdater.newUpdater(c.class, "closed");

    /* renamed from: a, reason: collision with root package name */
    public final x3.d f5567a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5568b;

    /* renamed from: c, reason: collision with root package name */
    public final j1 f5569c;
    private volatile /* synthetic */ int closed = 0;
    public final h d;

    /* renamed from: e, reason: collision with root package name */
    public final f4.f f5570e;

    /* renamed from: f, reason: collision with root package name */
    public final h4.b f5571f;

    /* renamed from: g, reason: collision with root package name */
    public final f4.f f5572g;

    /* renamed from: h, reason: collision with root package name */
    public final h4.b f5573h;

    /* renamed from: j, reason: collision with root package name */
    public final r4.d f5574j;

    /* renamed from: k, reason: collision with root package name */
    public final m f5575k;

    /* renamed from: l, reason: collision with root package name */
    public final d f5576l;

    public c(x3.d dVar, d dVar2) {
        this.f5567a = dVar;
        j1 j1Var = new j1((h1) dVar.b().o(c0.f143b));
        this.f5569c = j1Var;
        this.d = dVar.b().t(j1Var);
        this.f5570e = new f4.f(0);
        int i8 = 1;
        this.f5571f = new h4.b(1);
        f4.f fVar = new f4.f(1);
        this.f5572g = fVar;
        this.f5573h = new h4.b(0);
        this.f5574j = new r4.d();
        this.f5575k = new m(15);
        d dVar3 = new d();
        this.f5576l = dVar3;
        if (this.f5568b) {
            j1Var.A(new a(this));
        }
        f5.c cVar = null;
        fVar.f(f4.f.f2611o, new a4.h(this, dVar, null));
        fVar.f(f4.f.f2612p, new a4.m(this, i8, cVar));
        int i9 = 18;
        dVar3.a(k0.f6471b, new o3.a(i9));
        dVar3.a(z3.d.f6430c, new o3.a(i9));
        dVar3.a(n.f6482c, new o3.a(i9));
        if (dVar2.f5581f) {
            dVar3.f5579c.put("DefaultTransformers", new o3.a(16));
        }
        dVar3.a(p0.f6492b, new o3.a(i9));
        a4.d dVar4 = x.f6525b;
        dVar3.a(dVar4, new o3.a(i9));
        if (dVar2.f5580e) {
            dVar3.a(j0.d, new o3.a(i9));
        }
        dVar3.f5580e = dVar2.f5580e;
        dVar3.f5581f = dVar2.f5581f;
        dVar3.f5577a.putAll(dVar2.f5577a);
        dVar3.f5578b.putAll(dVar2.f5578b);
        dVar3.f5579c.putAll(dVar2.f5579c);
        if (dVar2.f5581f) {
            dVar3.a(z3.f0.f6441b, new o3.a(i9));
        }
        r4.a aVar = g.f6442a;
        dVar3.a(dVar4, new o3.a(dVar3));
        Iterator it = dVar3.f5577a.values().iterator();
        while (it.hasNext()) {
            ((l) it.next()).invoke(this);
        }
        Iterator it2 = dVar3.f5579c.values().iterator();
        while (it2.hasNext()) {
            ((l) it2.next()).invoke(this);
        }
        this.f5571f.f(h4.b.f3013j, new j(this, 2, cVar));
        this.f5568b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(f4.c r5, h5.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof t3.b
            if (r0 == 0) goto L13
            r0 = r6
            t3.b r0 = (t3.b) r0
            int r1 = r0.f5565c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5565c = r1
            goto L18
        L13:
            t3.b r0 = new t3.b
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f5563a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f5565c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            a.a.c0(r6)
            goto L46
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            a.a.c0(r6)
            androidx.emoji2.text.m r6 = r4.f5575k
            t1.f r2 = i4.a.f3146a
            r6.p(r2)
            java.lang.Object r6 = r5.d
            r0.f5565c = r3
            f4.f r4 = r4.f5570e
            java.lang.Object r6 = r4.a(r5, r6, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            java.lang.String r4 = "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall"
            kotlin.jvm.internal.p.c(r6, r4)
            u3.c r6 = (u3.c) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.c.a(f4.c, h5.c):java.lang.Object");
    }

    @Override // a6.f0
    public final h b() {
        return this.d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Exception {
        boolean zIsTerminated;
        if (f5566m.compareAndSet(this, 0, 1)) {
            r4.d dVar = (r4.d) this.f5574j.b(z.f6527a);
            for (r4.a aVar : c5.m.N0(dVar.c().keySet())) {
                p.c(aVar, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object objB = dVar.b(aVar);
                if (objB instanceof AutoCloseable) {
                    AutoCloseable autoCloseable = (AutoCloseable) objB;
                    if (autoCloseable instanceof AutoCloseable) {
                        autoCloseable.close();
                    } else {
                        if (!(autoCloseable instanceof ExecutorService)) {
                            throw new IllegalArgumentException();
                        }
                        ExecutorService executorService = (ExecutorService) autoCloseable;
                        if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated = executorService.isTerminated())) {
                            executorService.shutdown();
                            boolean z = false;
                            while (!zIsTerminated) {
                                try {
                                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                                } catch (InterruptedException unused) {
                                    if (!z) {
                                        executorService.shutdownNow();
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
            this.f5569c.f0();
            if (this.f5568b) {
                this.f5567a.close();
            }
        }
    }

    public final String toString() {
        return "HttpClient[" + this.f5567a + AbstractJsonLexerKt.END_LIST;
    }
}
