package n6;

import java.io.Closeable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final s f4146a;

    /* renamed from: b, reason: collision with root package name */
    public final r f4147b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4148c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final j f4149e;

    /* renamed from: f, reason: collision with root package name */
    public final k f4150f;

    /* renamed from: g, reason: collision with root package name */
    public final w f4151g;

    /* renamed from: h, reason: collision with root package name */
    public final c7.u f4152h;

    /* renamed from: j, reason: collision with root package name */
    public final u f4153j;

    /* renamed from: k, reason: collision with root package name */
    public final u f4154k;

    /* renamed from: l, reason: collision with root package name */
    public final u f4155l;

    /* renamed from: m, reason: collision with root package name */
    public final long f4156m;

    /* renamed from: n, reason: collision with root package name */
    public final long f4157n;

    /* renamed from: o, reason: collision with root package name */
    public final r6.g f4158o;

    /* renamed from: p, reason: collision with root package name */
    public final z f4159p;

    public u(s request, r protocol, String message, int i8, j jVar, k kVar, w body, c7.u uVar, u uVar2, u uVar3, u uVar4, long j4, long j8, r6.g gVar, z trailersSource) {
        kotlin.jvm.internal.p.e(request, "request");
        kotlin.jvm.internal.p.e(protocol, "protocol");
        kotlin.jvm.internal.p.e(message, "message");
        kotlin.jvm.internal.p.e(body, "body");
        kotlin.jvm.internal.p.e(trailersSource, "trailersSource");
        this.f4146a = request;
        this.f4147b = protocol;
        this.f4148c = message;
        this.d = i8;
        this.f4149e = jVar;
        this.f4150f = kVar;
        this.f4151g = body;
        this.f4152h = uVar;
        this.f4153j = uVar2;
        this.f4154k = uVar3;
        this.f4155l = uVar4;
        this.f4156m = j4;
        this.f4157n = j8;
        this.f4158o = gVar;
        this.f4159p = trailersSource;
    }

    public final t a() {
        t tVar = new t();
        tVar.f4134c = -1;
        tVar.f4137g = w.f4162a;
        tVar.f4145o = z.f4173a;
        tVar.f4132a = this.f4146a;
        tVar.f4133b = this.f4147b;
        tVar.f4134c = this.d;
        tVar.d = this.f4148c;
        tVar.f4135e = this.f4149e;
        tVar.f4136f = this.f4150f.h();
        tVar.f4137g = this.f4151g;
        tVar.f4138h = this.f4152h;
        tVar.f4139i = this.f4153j;
        tVar.f4140j = this.f4154k;
        tVar.f4141k = this.f4155l;
        tVar.f4142l = this.f4156m;
        tVar.f4143m = this.f4157n;
        tVar.f4144n = this.f4158o;
        tVar.f4145o = this.f4159p;
        return tVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4151g.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.f4147b + ", code=" + this.d + ", message=" + this.f4148c + ", url=" + this.f4146a.f4128a + AbstractJsonLexerKt.END_OBJ;
    }
}
