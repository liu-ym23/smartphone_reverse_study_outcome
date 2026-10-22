package z3;

import java.io.InputStream;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends n4.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6448a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Long f6449b;

    /* renamed from: c, reason: collision with root package name */
    public final k4.g f6450c;
    public final /* synthetic */ Object d;

    public i(f4.c cVar, k4.g gVar, Object obj) {
        this.d = obj;
        k4.p pVar = cVar.f2593c;
        List list = k4.t.f3636a;
        String strF = pVar.f("Content-Length");
        this.f6449b = strF != null ? Long.valueOf(Long.parseLong(strF)) : null;
        if (gVar == null) {
            k4.g gVar2 = k4.d.f3601a;
            gVar = k4.d.f3602b;
        }
        this.f6450c = gVar;
    }

    @Override // n4.e
    public final Long a() {
        switch (this.f6448a) {
        }
        return this.f6449b;
    }

    @Override // n4.e
    public final k4.g b() {
        switch (this.f6448a) {
        }
        return this.f6450c;
    }

    public final io.ktor.utils.io.p d() {
        int i8 = this.f6448a;
        Object obj = this.d;
        switch (i8) {
            case 0:
                return (io.ktor.utils.io.p) obj;
            default:
                InputStream inputStream = (InputStream) obj;
                h6.e eVar = a6.r0.f210a;
                h6.d context = h6.d.f3059c;
                a5.a pool = a5.b.f122a;
                kotlin.jvm.internal.p.e(inputStream, "<this>");
                kotlin.jvm.internal.p.e(context, "context");
                kotlin.jvm.internal.p.e(pool, "pool");
                return new z4.c(new j6.b(inputStream), context);
        }
    }

    public i(v4.f fVar, k4.g gVar, Object obj) {
        this.d = obj;
        k4.p pVar = ((f4.c) fVar.f5973a).f2593c;
        List list = k4.t.f3636a;
        String strF = pVar.f("Content-Length");
        this.f6449b = strF != null ? Long.valueOf(Long.parseLong(strF)) : null;
        if (gVar == null) {
            k4.g gVar2 = k4.d.f3601a;
            gVar = k4.d.f3602b;
        }
        this.f6450c = gVar;
    }
}
