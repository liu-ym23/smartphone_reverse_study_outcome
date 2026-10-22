package com.bytedance.applog.log;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<j> f192477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, j> f192478b = null;

    static {
        f192477a = new CopyOnWriteArraySet();
        f192478b = new ConcurrentHashMap();
    }

    public static void a(k r100) {
        CopyOnWriteArraySet<j> r101 = f192477a;
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<j> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().a(r100);
        goto L7
    }
}
