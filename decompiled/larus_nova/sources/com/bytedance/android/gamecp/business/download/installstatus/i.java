package com.bytedance.android.gamecp.business.download.installstatus;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f52786a = null;

    static {
        f52786a = new CopyOnWriteArrayList();
    }

    public static String a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.append((String) r102.next());
        goto L4
    L7:
        return r101.toString();
    }
}
