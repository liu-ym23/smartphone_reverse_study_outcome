package q0;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f23485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object[] f23486b;

    static {
        f23485a = new Object[0];
        f23486b = new Object[73];
    }

    public static List a(long[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r11.add(Long.valueOf(r10[r13]));
        r13 = r13 + 1;
        goto L6
    L8:
        return r11;
    }
}
