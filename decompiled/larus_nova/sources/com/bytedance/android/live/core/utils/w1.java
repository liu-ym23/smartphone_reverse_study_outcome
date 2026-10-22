package com.bytedance.android.live.core.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f66426a = null;

    static {
        f66426a = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        if (v.a() == false) goto L8;
        if (r101 == null) goto L9;
        f66426a.put(r100, r101);
        return;
    L9:
        return;
    }
}
