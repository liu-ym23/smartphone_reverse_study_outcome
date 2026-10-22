package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f31914a = null;

    static {
        f31914a = new ThreadLocal();
    }

    public static boolean a() {
        String r100 = (String) AccessController.doPrivileged(new b());     // Catch: AccessControlException -> L19
        if (r100 != null) goto L6;
        return false;
    L6:
        int r101 = d.f31915a;     // Catch: AccessControlException -> L19
        char[] r102 = r100.toCharArray();     // Catch: AccessControlException -> L19
        int r103 = 0;
        boolean r104 = false;
    L8:
        if (r103 == r102.length) goto L15;
        char r105 = r102[r103];     // Catch: AccessControlException -> L19
        if ('A' > r105) goto L14;
        if ('Z' < r105) goto L14;
        r102[r103] = (char) ((r105 - 'A') + 97);     // Catch: AccessControlException -> L19
        r104 = true;
    L14:
        r103 = r103 + 1;     // Catch: AccessControlException -> L19
        goto L8
    L15:
        if (r104 == false) goto L17;
        r100 = new String(r102);     // Catch: AccessControlException -> L19
    L17:
        return "true".equals(r100);
    L27:
        return false;
    }
}
