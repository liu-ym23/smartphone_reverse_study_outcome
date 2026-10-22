package J9;

import La.D;

/* loaded from: classes5.dex */
public final class h {
    public static final String b(ga.b bVar) {
        String strS = D.S(bVar.g().a(), '.', '$', false, 4, null);
        if (bVar.f().c()) {
            return strS;
        }
        return bVar.f() + '.' + strS;
    }
}
