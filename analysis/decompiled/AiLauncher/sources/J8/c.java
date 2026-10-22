package J8;

import Yb.u;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class c extends i {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3749e = Pattern.compile("`+");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f3750f = Pattern.compile("^`+");

    @Override // J8.i
    public u e() {
        String strD;
        String strD2 = d(f3750f);
        if (strD2 == null) {
            return null;
        }
        int i10 = this.f3757d;
        do {
            strD = d(f3749e);
            if (strD == null) {
                this.f3757d = i10;
                return o(strD2);
            }
        } while (!strD.equals(strD2));
        Yb.e eVar = new Yb.e();
        String strReplace = this.f3756c.substring(i10, this.f3757d - strD2.length()).replace('\n', ' ');
        if (strReplace.length() >= 3 && strReplace.charAt(0) == ' ' && strReplace.charAt(strReplace.length() - 1) == ' ' && Xb.d.e(strReplace)) {
            strReplace = strReplace.substring(1, strReplace.length() - 1);
        }
        eVar.n(strReplace);
        return eVar;
    }

    @Override // J8.i
    public char m() {
        return '`';
    }
}
