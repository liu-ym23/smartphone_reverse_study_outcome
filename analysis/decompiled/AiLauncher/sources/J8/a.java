package J8;

import Yb.q;
import Yb.u;
import Yb.z;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class a extends i {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3746e = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f3747f = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    @Override // J8.i
    public u e() {
        String strD = d(f3746e);
        if (strD != null) {
            String strSubstring = strD.substring(1, strD.length() - 1);
            q qVar = new q("mailto:" + strSubstring, null);
            qVar.b(new z(strSubstring));
            return qVar;
        }
        String strD2 = d(f3747f);
        if (strD2 == null) {
            return null;
        }
        String strSubstring2 = strD2.substring(1, strD2.length() - 1);
        q qVar2 = new q(strSubstring2, null);
        qVar2.b(new z(strSubstring2));
        return qVar2;
    }

    @Override // J8.i
    public char m() {
        return '<';
    }
}
