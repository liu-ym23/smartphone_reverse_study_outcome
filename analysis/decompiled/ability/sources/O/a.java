package O;

import H.h;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends N.a {
    public static volatile a e;

    public static a g() {
        if (e == null) {
            synchronized (a.class) {
                try {
                    if (e == null) {
                        e = new a();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    @Override // N.a
    public final void d(N.b bVar) {
        JSONObject jSONObjectA = bVar.a();
        boolean zB = bVar.b();
        if (h.b) {
            U7.a.o("<monitor><flow>", "logType: " + bVar.g() + ", subType: " + bVar.d() + "data: " + jSONObjectA, " ,sample: " + zB);
        }
        N.a.a(bVar.g(), bVar.d(), jSONObjectA, zB);
    }
}
