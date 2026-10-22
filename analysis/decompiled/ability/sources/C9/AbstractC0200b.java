package C9;

import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.internal.WriteMode;
import x9.InterfaceC2123a;

/* renamed from: C9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0200b {
    public static final C0199a d = new C0199a(new i(false, false, false, false, true, "    ", false, "type", true, ClassDiscriminatorMode.b), E9.g.f499a);

    /* renamed from: a, reason: collision with root package name */
    public final i f321a;
    public final E9.e b;
    public final O0.a c;

    public AbstractC0200b(i iVar, E9.e eVar) {
        this.f321a = iVar;
        this.b = eVar;
        O0.a aVar = new O0.a();
        aVar.f1031a = new ConcurrentHashMap(16);
        this.c = aVar;
    }

    public final Object a(InterfaceC2123a deserializer, String string) {
        kotlin.jvm.internal.k.f(deserializer, "deserializer");
        kotlin.jvm.internal.k.f(string, "string");
        D9.t tVar = new D9.t(string);
        Object objDecodeSerializableValue = new kotlinx.serialization.json.internal.c(this, WriteMode.c, tVar, deserializer.getDescriptor(), null).decodeSerializableValue(deserializer);
        if (tVar.f() == 10) {
            return objDecodeSerializableValue;
        }
        D9.t.o(tVar, "Expected EOF after parsing, but had " + string.charAt(tVar.c - 1) + " instead", 0, null, 6);
        throw null;
    }

    public final String b(x9.f serializer, Object obj) {
        char[] cArr;
        kotlin.jvm.internal.k.f(serializer, "serializer");
        B1.b bVar = new B1.b(2, (byte) 0);
        D9.c cVar = D9.c.c;
        synchronized (cVar) {
            D7.p pVar = cVar.f437a;
            cArr = null;
            char[] cArr2 = (char[]) (pVar.isEmpty() ? null : pVar.removeLast());
            if (cArr2 != null) {
                cVar.b -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        bVar.c = cArr;
        try {
            D9.j.h(this, bVar, serializer, obj);
            return bVar.toString();
        } finally {
            bVar.j();
        }
    }
}
