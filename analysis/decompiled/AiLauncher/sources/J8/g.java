package J8;

import Yb.u;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class g extends i {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3753e = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    @Override // J8.i
    public u e() {
        String strD = d(f3753e);
        if (strD == null) {
            return null;
        }
        Yb.n nVar = new Yb.n();
        nVar.n(strD);
        return nVar;
    }

    @Override // J8.i
    public char m() {
        return '<';
    }
}
