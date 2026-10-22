package com.bytedance.applet.impl;

import android.app.Application;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w implements r4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<r4.f.a, Application.ActivityLifecycleCallbacks> f192012a;

    public w() {
        this.f192012a = new ConcurrentHashMap();
    }

    @Override // r4.f
    public final void a(r4.f.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Application.ActivityLifecycleCallbacks r101 = this.f192012a.remove(r100);
        if (r101 == null) goto L6;
        gd9.i r102 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r102);
        r102.getApplication().unregisterActivityLifecycleCallbacks(r101);
        return;
    }

    @Override // r4.f
    public final void b(com.bytedance.ai.applet.login.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        v r101 = new v(r100);
        if (this.f192012a.putIfAbsent(r100, r101) == null) goto L5;
        return;
    L5:
        gd9.i r102 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r102);
        r102.getApplication().registerActivityLifecycleCallbacks(r101);
    }
}
