package com.bytedance.android.ec.hybrid.card.service;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends d>, SoftReference<? extends d>> f46583a = null;

    static {
        f46583a = new ConcurrentHashMap();
    }

    public static d a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        SoftReference<? extends d> r101 = f46583a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }
}
