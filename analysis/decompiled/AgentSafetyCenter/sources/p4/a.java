package p4;

import hc.h;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements x4.a {

    /* renamed from: c, reason: collision with root package name */
    public z4.c f9697c;

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9697c.close();
    }

    @Override // x4.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final g K(String str) {
        str.getClass();
        z4.c cVar = this.f9697c;
        cVar.getClass();
        String string = h.w0(str).toString();
        if (string.length() >= 3) {
            String upperCase = string.substring(0, 3).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            int iHashCode = upperCase.hashCode();
            if (iHashCode == 79487 ? upperCase.equals("PRA") : !(iHashCode == 81978 ? !upperCase.equals("SEL") : !(iHashCode == 85954 && upperCase.equals("WIT")))) {
                e eVar = new e(cVar, str);
                eVar.f9704h = new int[0];
                eVar.i = new long[0];
                eVar.f9705j = new double[0];
                eVar.f9706k = new String[0];
                eVar.f9707l = new byte[0][];
                return eVar;
            }
        }
        f fVar = new f(cVar, str);
        fVar.f9709h = cVar.g(str);
        VarHandle.storeStoreFence();
        return fVar;
    }
}
