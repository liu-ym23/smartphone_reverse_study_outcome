package com.bytedance.android.shopping.feed.event;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f174834a = 0;

    static {
    }

    public static Map a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toStringMap");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = r103.getKey().toString();
        Object r105 = r103.getValue();
        if (r105 == null) goto L8;
        String r106 = r105.toString();
    L10:
        if (com.bytedance.android.shopping.extensions.k.c(r104) == false) goto L4;
        if (r106 == null) goto L4;
        if (com.bytedance.android.shopping.extensions.k.c(r106) == false) goto L4;
        r101.put(r104, r106);
        goto L4
    L8:
        r106 = null;
        goto L10
    L15:
        return r101;
    }
}
