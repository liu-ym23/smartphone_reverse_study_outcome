package h4;

import io.ktor.utils.io.h0;
import io.ktor.utils.io.p;
import k4.o;
import k4.q;
import k4.x;
import k4.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3002a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final y f3003b;

    /* renamed from: c, reason: collision with root package name */
    public final x f3004c;
    public final u4.d d;

    /* renamed from: e, reason: collision with root package name */
    public final u4.d f3005e;

    /* renamed from: f, reason: collision with root package name */
    public final f5.h f3006f;

    /* renamed from: g, reason: collision with root package name */
    public final u3.c f3007g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3008h;

    /* renamed from: j, reason: collision with root package name */
    public final o f3009j;

    public a(u3.c cVar, f4.g gVar) {
        this.f3007g = cVar;
        this.f3006f = gVar.f2619f;
        this.f3003b = gVar.f2615a;
        this.f3004c = gVar.d;
        this.d = gVar.f2616b;
        this.f3005e = gVar.f2620g;
        Object obj = gVar.f2618e;
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar == null) {
            p.f3226a.getClass();
            pVar = io.ktor.utils.io.o.f3223b;
        }
        this.f3008h = pVar;
        this.f3009j = gVar.f2617c;
    }

    @Override // k4.u
    public final o a() {
        switch (this.f3002a) {
            case 0:
                return (q) this.f3009j;
            default:
                return this.f3009j;
        }
    }

    @Override // a6.f0
    public final f5.h b() {
        switch (this.f3002a) {
        }
        return this.f3006f;
    }

    @Override // h4.c
    public final u3.c c() {
        switch (this.f3002a) {
            case 0:
                return this.f3007g;
            default:
                return (u3.f) this.f3007g;
        }
    }

    @Override // h4.c
    public final p d() {
        switch (this.f3002a) {
            case 0:
                return (p) this.f3008h;
            default:
                return h0.a((byte[]) this.f3008h);
        }
    }

    @Override // h4.c
    public final u4.d e() {
        switch (this.f3002a) {
        }
        return this.d;
    }

    @Override // h4.c
    public final u4.d f() {
        switch (this.f3002a) {
        }
        return this.f3005e;
    }

    @Override // h4.c
    public final y g() {
        switch (this.f3002a) {
        }
        return this.f3003b;
    }

    @Override // h4.c
    public final x h() {
        switch (this.f3002a) {
        }
        return this.f3004c;
    }

    public a(u3.f fVar, byte[] bArr, c cVar) {
        this.f3007g = fVar;
        this.f3008h = bArr;
        this.f3003b = cVar.g();
        this.f3004c = cVar.h();
        this.d = cVar.e();
        this.f3005e = cVar.f();
        this.f3009j = cVar.a();
        this.f3006f = cVar.b();
    }
}
