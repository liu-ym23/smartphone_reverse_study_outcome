package com.bytedance.android.shopping.store.router.hybridpage.view;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Boolean> f185975a = null;

    static {
        f185975a = new LinkedHashMap();
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "customElementName");
        Boolean r101 = (Boolean) ((LinkedHashMap) f185975a).get(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "customElementName");
        f185975a.put(r100, Boolean.TRUE);
    }
}
