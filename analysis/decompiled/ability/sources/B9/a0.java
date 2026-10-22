package B9;

import java.util.Iterator;
import k9.C1650a;
import kotlin.collections.builders.MapBuilder;
import kotlin.uuid.Uuid;

/* loaded from: classes4.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final MapBuilder f235a;

    static {
        MapBuilder mapBuilder = new MapBuilder();
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        mapBuilder.put(nVar.b(String.class), h0.f242a);
        mapBuilder.put(nVar.b(Character.TYPE), C0187n.f248a);
        mapBuilder.put(nVar.b(char[].class), C0186m.c);
        mapBuilder.put(nVar.b(Double.TYPE), r.f254a);
        mapBuilder.put(nVar.b(double[].class), C0190q.c);
        mapBuilder.put(nVar.b(Float.TYPE), C0198z.f264a);
        mapBuilder.put(nVar.b(float[].class), C0197y.c);
        mapBuilder.put(nVar.b(Long.TYPE), L.f223a);
        mapBuilder.put(nVar.b(long[].class), K.c);
        mapBuilder.put(nVar.b(C7.m.class), q0.f253a);
        mapBuilder.put(nVar.b(Integer.TYPE), F.f218a);
        mapBuilder.put(nVar.b(int[].class), E.c);
        mapBuilder.put(nVar.b(C7.k.class), n0.f249a);
        mapBuilder.put(nVar.b(Short.TYPE), g0.f240a);
        mapBuilder.put(nVar.b(short[].class), f0.c);
        mapBuilder.put(nVar.b(C7.p.class), t0.f258a);
        mapBuilder.put(nVar.b(Byte.TYPE), C0183j.f244a);
        mapBuilder.put(nVar.b(byte[].class), C0182i.c);
        mapBuilder.put(nVar.b(C7.h.class), k0.f245a);
        mapBuilder.put(nVar.b(Boolean.TYPE), C0180g.f239a);
        mapBuilder.put(nVar.b(boolean[].class), C0179f.c);
        mapBuilder.put(nVar.b(C7.r.class), u0.b);
        mapBuilder.put(nVar.b(Void.class), O.f226a);
        try {
            Z7.d dVarB = nVar.b(C1650a.class);
            int i = C1650a.d;
            mapBuilder.put(dVarB, C0191s.f256a);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            mapBuilder.put(kotlin.jvm.internal.m.f4928a.b(C7.n.class), p0.c);
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            mapBuilder.put(kotlin.jvm.internal.m.f4928a.b(C7.l.class), m0.c);
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            mapBuilder.put(kotlin.jvm.internal.m.f4928a.b(C7.q.class), s0.c);
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            mapBuilder.put(kotlin.jvm.internal.m.f4928a.b(C7.j.class), j0.c);
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            mapBuilder.put(kotlin.jvm.internal.m.f4928a.b(Uuid.class), v0.f261a);
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        f235a = mapBuilder.b();
    }

    public static final void a(String str) {
        Iterator it = ((E7.e) f235a.values()).iterator();
        while (it.hasNext()) {
            x9.b bVar = (x9.b) it.next();
            if (str.equals(bVar.getDescriptor().h())) {
                StringBuilder sbV = B7.a.v("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exists ");
                sbV.append(kotlin.jvm.internal.m.f4928a.b(bVar.getClass()).m());
                sbV.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                throw new IllegalArgumentException(j9.n.R(sbV.toString()));
            }
        }
    }
}
