package d4;

import f5.h;
import k4.o;
import k4.x;
import k4.y;
import kotlin.jvm.internal.p;
import u4.d;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h4.c {

    /* renamed from: a, reason: collision with root package name */
    public final a f1811a;

    /* renamed from: b, reason: collision with root package name */
    public final p5.a f1812b;

    /* renamed from: c, reason: collision with root package name */
    public final h4.c f1813c;
    public final o d;

    /* renamed from: e, reason: collision with root package name */
    public final h f1814e;

    public c(a aVar, p5.a aVar2, h4.c cVar, o headers) {
        p.e(headers, "headers");
        this.f1811a = aVar;
        this.f1812b = aVar2;
        this.f1813c = cVar;
        this.d = headers;
        this.f1814e = cVar.b();
    }

    @Override // k4.u
    public final o a() {
        return this.d;
    }

    @Override // a6.f0
    public final h b() {
        return this.f1814e;
    }

    @Override // h4.c
    public final u3.c c() {
        return this.f1811a;
    }

    @Override // h4.c
    public final io.ktor.utils.io.p d() {
        return (io.ktor.utils.io.p) this.f1812b.invoke();
    }

    @Override // h4.c
    public final d e() {
        return this.f1813c.e();
    }

    @Override // h4.c
    public final d f() {
        return this.f1813c.f();
    }

    @Override // h4.c
    public final y g() {
        return this.f1813c.g();
    }

    @Override // h4.c
    public final x h() {
        return this.f1813c.h();
    }
}
