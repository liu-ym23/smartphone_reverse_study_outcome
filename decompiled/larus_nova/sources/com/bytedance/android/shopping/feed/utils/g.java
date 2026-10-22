package com.bytedance.android.shopping.feed.utils;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f175448a = null;

    static {
        f175448a = new HashSet();
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        Iterator<String> r101 = f175448a.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L13;
        String r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r100.append(r103);
        if (r102 >= (f175448a.size() - 1)) goto L11;
        r100.append(",");
    L11:
        r102 = r104;
        goto L4
    L13:
        return r100.toString();
    }
}
