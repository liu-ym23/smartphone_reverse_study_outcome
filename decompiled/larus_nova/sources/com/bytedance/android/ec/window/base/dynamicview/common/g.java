package com.bytedance.android.ec.window.base.dynamicview.common;

import androidx.core.view.ViewCompat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> f49252a = null;

    static {
        f49252a = new ConcurrentHashMap();
    }

    public static int a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "uniqueId");
        ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> r102 = f49252a;
        ConcurrentHashMap<String, Integer> r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new ConcurrentHashMap();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r103, "idMapping");
        r102.put(r100, r103);
    L5:
        Integer r104 = r103.get(r101);
        if (r104 != null) goto L10;
        int r105 = ViewCompat.generateViewId();
        r103.put(r101, Integer.valueOf(r105));
        return r105;
    L10:
        return r104.intValue();
    }
}
