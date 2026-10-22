package q7;

import java.util.List;

/* loaded from: classes.dex */
public class x {
    public w7.g a(h hVar) {
        return hVar;
    }

    public w7.d b(Class cls) {
        return new e(cls);
    }

    public w7.f c(Class cls, String str) {
        return new o(cls, str);
    }

    public w7.j d(n nVar) {
        return nVar;
    }

    public w7.q e(na.j jVar) {
        return jVar;
    }

    public w7.s f(p pVar) {
        return pVar;
    }

    public String g(g gVar) {
        String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String h(m mVar) {
        return g(mVar);
    }

    public w7.u i(w7.d dVar, List list, boolean z4) {
        return new b0(dVar, list, z4);
    }
}
