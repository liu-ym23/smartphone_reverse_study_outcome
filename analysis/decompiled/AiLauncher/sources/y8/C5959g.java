package y8;

import Yb.u;
import java.util.regex.Pattern;

/* renamed from: y8.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5959g extends J8.i {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f43955e = Pattern.compile("(\\${2})([\\s\\S]+?)\\1");

    @Override // J8.i
    public u e() {
        String strD = d(f43955e);
        if (strD == null) {
            return null;
        }
        C5960h c5960h = new C5960h();
        c5960h.n(strD.substring(2, strD.length() - 2));
        return c5960h;
    }

    @Override // J8.i
    public char m() {
        return '$';
    }
}
