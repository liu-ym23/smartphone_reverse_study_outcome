package uc;

import androidx.datastore.preferences.protobuf.b1;
import kotlin.collections.builders.MapBuilder;
import mb.y;
import rc.d;
import tc.k1;
import tc.v0;
import tc.w0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements pc.a<m> {

    /* renamed from: a, reason: collision with root package name */
    public static final n f13216a = new n();

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f13217b;

    static {
        d.i kind = d.i.f11785a;
        kotlin.jvm.internal.g.f(kind, "kind");
        if (gc.q.t0("kotlinx.serialization.json.JsonLiteral")) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        Object it = ((kotlin.collections.builders.c) w0.f13064a.values()).iterator();
        while (((MapBuilder.d) it).hasNext()) {
            pc.a aVar = (pc.a) ((MapBuilder.f) it).next();
            if ("kotlinx.serialization.json.JsonLiteral".equals(aVar.d().i())) {
                throw new IllegalArgumentException(gc.k.Z("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name kotlinx.serialization.json.JsonLiteral there already exists " + kotlin.jvm.internal.i.a(aVar.getClass()).c() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
        f13217b = new v0("kotlinx.serialization.json.JsonLiteral", kind);
    }

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        m value = (m) obj;
        kotlin.jvm.internal.g.f(value, "value");
        String str = value.f13215b;
        jd.b.b(kVar);
        if (value.f13214a) {
            kVar.B(str);
            return;
        }
        Long lD0 = gc.n.d0(str);
        if (lD0 != null) {
            kVar.i(lD0.longValue());
            return;
        }
        lb.i iVarY = b1.Y(str);
        if (iVarY != null) {
            kVar.z(k1.f13004b).i(iVarY.f10404a);
            return;
        }
        Boolean bool = null;
        Double dValueOf = gc.j.f9142a.c(str) ? Double.valueOf(Double.parseDouble(str)) : null;
        if (dValueOf != null) {
            kVar.c(dValueOf.doubleValue());
            return;
        }
        if (str.equals("true")) {
            bool = Boolean.TRUE;
        } else if (str.equals("false")) {
            bool = Boolean.FALSE;
        }
        if (bool != null) {
            kVar.o(bool.booleanValue());
        } else {
            kVar.B(str);
        }
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        g gVarG = jd.b.d(dVar).g();
        if (gVarG instanceof m) {
            return (m) gVarG;
        }
        throw y.b(-1, gVarG.toString(), "Unexpected JSON element, expected JsonLiteral, had " + kotlin.jvm.internal.i.a(gVarG.getClass()));
    }

    @Override // pc.c
    public final rc.e d() {
        return f13217b;
    }
}
