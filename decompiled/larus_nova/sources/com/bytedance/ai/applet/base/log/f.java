package com.bytedance.ai.applet.base.log;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Map<String, String>> f34527a = null;

    static {
        f34527a = new ThreadLocal();
    }

    public static Map a() {
        Map<String, String> r100 = f34527a.get();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return MapsKt.emptyMap();
    }

    public static void b(Map r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        f34527a.remove();
        return;
    L10:
        f34527a.set(r100);
        return;
    L4:
        if (r100.isEmpty() == true) goto L7;
        r101 = false;
        goto L8
    }
}
