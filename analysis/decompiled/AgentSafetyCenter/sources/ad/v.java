package ad;

import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final p5.i f583a;

    /* renamed from: b, reason: collision with root package name */
    public a2.i f584b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f585c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f586d;

    /* renamed from: e, reason: collision with root package name */
    public final b8.z f587e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f588f;

    /* renamed from: g, reason: collision with root package name */
    public final b f589g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f590h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final b f591j;

    /* renamed from: k, reason: collision with root package name */
    public final b f592k;

    /* renamed from: l, reason: collision with root package name */
    public final b f593l;

    /* renamed from: m, reason: collision with root package name */
    public final SocketFactory f594m;

    /* renamed from: n, reason: collision with root package name */
    public final List f595n;

    /* renamed from: o, reason: collision with root package name */
    public final List f596o;

    /* renamed from: p, reason: collision with root package name */
    public final md.d f597p;

    /* renamed from: q, reason: collision with root package name */
    public final e f598q;

    /* renamed from: r, reason: collision with root package name */
    public int f599r;

    /* renamed from: s, reason: collision with root package name */
    public int f600s;

    /* renamed from: t, reason: collision with root package name */
    public int f601t;

    /* renamed from: u, reason: collision with root package name */
    public int f602u;

    public v() {
        p5.i iVar = new p5.i();
        iVar.f9731f = new ArrayDeque();
        iVar.f9732g = new ArrayDeque();
        iVar.f9733h = new ArrayDeque();
        VarHandle.storeStoreFence();
        this.f583a = iVar;
        this.f584b = new a2.i();
        this.f585c = new ArrayList();
        this.f586d = new ArrayList();
        b8.z zVar = new b8.z(3);
        VarHandle.storeStoreFence();
        this.f587e = zVar;
        this.f588f = true;
        b bVar = b.f433a;
        this.f589g = bVar;
        this.f590h = true;
        this.i = true;
        this.f591j = b.f434b;
        this.f592k = b.f435c;
        this.f593l = bVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        socketFactory.getClass();
        this.f594m = socketFactory;
        this.f595n = w.F;
        this.f596o = w.E;
        this.f597p = md.d.f8608a;
        this.f598q = e.f465c;
        this.f600s = 10000;
        this.f601t = 10000;
        this.f602u = 10000;
    }

    public final void a(long j10, TimeUnit timeUnit) {
        timeUnit.getClass();
        this.f600s = bd.b.b(j10, timeUnit);
    }
}
