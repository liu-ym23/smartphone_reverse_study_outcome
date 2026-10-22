package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends f {

    /* renamed from: g, reason: collision with root package name */
    public String f1988g;

    /* renamed from: h, reason: collision with root package name */
    public Map f1989h;
    public String i;

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        m mVar;
        String str = this.f1988g;
        m mVar2 = (m) fVar.f15310e.get(aVar);
        androidx.room.q qVar = this.f1954d;
        w7.n nVar = this.f1909c;
        if (mVar2 == null) {
            mVar = new m();
            mVar.f1984c = null;
            mVar.f1985d = false;
            mVar.f1982a = str;
            fVar.f15310e.put(aVar, mVar);
        } else {
            if (((w7.o) qVar.f1601d).f15349g.b("discriminator", Boolean.FALSE)) {
                throw new w7.m("Schema at " + nVar + " has a discriminator keyword for which another discriminator keyword has already been set for at " + aVar);
            }
            if (!"".equals(str) && !mVar2.f1982a.equals(str)) {
                throw new w7.m("Schema at " + nVar + " is redefining the discriminator property that has already been set for at " + aVar);
            }
            mVar = mVar2;
        }
        JsonNode jsonNode3 = jsonNode.get(mVar.f1982a);
        if (jsonNode3 == null || !jsonNode3.isTextual()) {
            String str2 = this.i;
            if (str2 != null) {
                mVar.f1984c = str2;
                mVar.f1985d = true;
                return;
            } else {
                if (((w7.o) qVar.f1601d).f15349g.b("discriminator", Boolean.FALSE)) {
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ.i = "discriminator.missing_discriminating_value";
                    jVarJ.f15294e = new Object[]{str};
                    fVar.a(jVarJ.a());
                    return;
                }
                return;
            }
        }
        String strAsText = jsonNode3.asText();
        mVar.f1983b = strAsText;
        String str3 = (String) this.f1989h.get(strAsText);
        if (mVar2 == null || str3 == null || !mVar2.f1985d || mVar2.f1984c.equals(str3)) {
            if (str3 != null) {
                mVar.f1984c = str3;
                mVar.f1985d = true;
                return;
            } else {
                if (mVar.f1985d) {
                    return;
                }
                mVar.f1984c = strAsText;
                mVar.f1985d = false;
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder("Schema at ");
        sb2.append(nVar);
        sb2.append(" is mapping that has already been set for ");
        sb2.append(aVar);
        String str4 = mVar2.f1984c;
        sb2.append(" from ");
        sb2.append(str4);
        sb2.append(" to ");
        sb2.append(str3);
        throw new w7.m(sb2.toString());
    }
}
