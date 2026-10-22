package com.bytedance.apm.block;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f190346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f190347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f190348c;

    static {
        f190346a = new HashSet();
        f190347b = "";
        f190348c = true;
    }

    public static String a() {
        if (f190348c == false) goto L18;
        HashSet<String> r100 = f190346a;     // Catch: ConcurrentModificationException -> L19
        if (r100 != null) goto L7;
        String r101 = null;
    L16:
        f190347b = r101;     // Catch: ConcurrentModificationException -> L19
        f190348c = false;     // Catch: ConcurrentModificationException -> L19
        goto L18
    L7:
        StringBuilder r102 = new StringBuilder();     // Catch: ConcurrentModificationException -> L19
        Iterator<String> r103 = r100.iterator();     // Catch: ConcurrentModificationException -> L19
        boolean r104 = true;
    L9:
        if (r103.hasNext() == false) goto L15;
        String r105 = r103.next();     // Catch: ConcurrentModificationException -> L19
        if (r104 == false) goto L13;
        r104 = false;
    L14:
        r102.append(r105.toString());     // Catch: ConcurrentModificationException -> L19
        goto L9
    L13:
        r102.append(",");     // Catch: ConcurrentModificationException -> L19
        goto L14
    L15:
        r101 = r102.toString();     // Catch: ConcurrentModificationException -> L19
    L18:
        return f190347b;
    }
}
