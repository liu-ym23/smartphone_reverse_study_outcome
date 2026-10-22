package w3;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import u3.k;

/* renamed from: w3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2096a extends Z0.a {
    public final ConcurrentHashMap c;

    public C2096a() {
        this.f1582a = null;
        this.c = new ConcurrentHashMap();
    }

    @Override // Z0.a
    public final C2097b F(String str, k kVar) {
        C2097b c2097b;
        Ba.g gVar = (Ba.g) this.f1582a;
        if (gVar != null && (c2097b = (C2097b) gVar.apply(str)) != null) {
            return c2097b;
        }
        C2097b c2097b2 = null;
        if (str != null) {
            switch (str) {
                case "http://json-schema.org/draft-06/schema#":
                    c2097b2 = h.f6846a;
                    break;
                case "https://json-schema.org/draft/2020-12/schema":
                    HashMap map = f.f6844a;
                    c2097b2 = AbstractC2100e.f6843a;
                    break;
                case "http://json-schema.org/draft-07/schema#":
                    c2097b2 = i.f6847a;
                    break;
                case "https://json-schema.org/draft/2019-09/schema":
                    HashMap map2 = AbstractC2099d.f6842a;
                    c2097b2 = AbstractC2098c.f6841a;
                    break;
                case "http://json-schema.org/draft-04/schema#":
                    c2097b2 = g.f6845a;
                    break;
            }
        }
        return c2097b2 != null ? c2097b2 : (C2097b) this.c.computeIfAbsent(str, new Ba.g(this, kVar));
    }
}
