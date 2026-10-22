package ma;

import ja.C1618a;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final C1618a f5342a;
    public final Pattern b;
    public final int c;

    public b(C1618a c1618a, Pattern pattern, int i) {
        this.f5342a = c1618a;
        this.b = pattern;
        this.c = i;
    }

    public final String toString() {
        return "Tuple tag=" + this.f5342a + " regexp=" + this.b + " limit=" + this.c;
    }
}
