package J8;

import Yb.u;
import Yb.x;
import Yb.z;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class m extends i {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3783e = Pattern.compile(" *$");

    @Override // J8.i
    public u e() {
        this.f3757d++;
        u uVarD = this.f3755b.d();
        if (uVarD instanceof z) {
            z zVar = (z) uVarD;
            if (zVar.m().endsWith(" ")) {
                String strM = zVar.m();
                Matcher matcher = f3783e.matcher(strM);
                int iEnd = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (iEnd > 0) {
                    zVar.n(strM.substring(0, strM.length() - iEnd));
                }
                return iEnd >= 2 ? new Yb.k() : new x();
            }
        }
        return new x();
    }

    @Override // J8.i
    public char m() {
        return '\n';
    }
}
