package b0;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f5918a = null;

    static {
        f5918a = new String[0];
    }

    public static final void a(StringBuilder r10, int r11) {
        q.g(r10, "builder");
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        r10.append("?");
        if (r12 >= (r11 - 1)) goto L7;
        r10.append(",");
    L7:
        r12 = r12 + 1;
        goto L3
    }

    public static final StringBuilder b() {
        return new StringBuilder();
    }
}
