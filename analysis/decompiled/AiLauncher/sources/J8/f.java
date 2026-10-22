package J8;

import Yb.u;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class f extends i {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3752e = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    @Override // J8.i
    public u e() {
        String strD = d(f3752e);
        if (strD != null) {
            return o(Xb.b.a(strD));
        }
        return null;
    }

    @Override // J8.i
    public char m() {
        return '&';
    }
}
