package com.bumptech.glide.manager;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: RequestTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private static final String TAG = "RequestTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.d> f3902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.request.d> f3903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3904c;

    public l() {
        this.f3902a = Collections.newSetFromMap(new WeakHashMap());
        this.f3903b = new ArrayList();
    }

    public void a(com.bumptech.glide.request.d r3) {
        com.bumptech.glide.request.d r4 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        this.f3902a.add(r4);
        if (this.f3904c == true) goto L5;
        r4.a();
        return;
    L5:
        r4.b();
        if (a(TAG, 2) == false) goto L8;
        a(TAG, "Paused, delaying request");
    L8:
        this.f3903b.add(r4);
    }

    public boolean b(com.bumptech.glide.request.d r3) {
        com.bumptech.glide.request.d r4 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r4 != null) goto L5;
        return true;
    L5:
        boolean r1 = this.f3902a.remove(r4);
        if (this.f3903b.remove(r4) == true) goto L10;
        if (r1 == true) goto L10;
        r0 = false;
    L10:
        if (r0 == false) goto L12;
        r4.b();
    L12:
        return r0;
    }

    public boolean a() {
        return this.f3904c;
    }

    public void b() {
        this.f3904c = true;
        Iterator r0 = com.bumptech.glide.f.k.a(this.f3902a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        if (r1.d() == false) goto L4;
        r1.c();
        this.f3903b.add(r1);
        goto L4
    }

    public void c() {
        this.f3904c = true;
        Iterator r0 = com.bumptech.glide.f.k.a(this.f3902a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        if (r1.d() == true) goto L9;
        if (r1.e() == false) goto L4;
    L9:
        r1.b();
        this.f3903b.add(r1);
        goto L4
    }

    public void d() {
        this.f3904c = false;
        Iterator r0 = com.bumptech.glide.f.k.a(this.f3902a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        if (r1.e() == true) goto L4;
        if (r1.d() == true) goto L4;
        r1.a();
        goto L4
    L10:
        this.f3903b.clear();
    }

    public void e() {
        Iterator r0 = com.bumptech.glide.f.k.a(this.f3902a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        b((com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        this.f3903b.clear();
    }

    public void f() {
        Iterator r0 = com.bumptech.glide.f.k.a(this.f3902a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        if (r1.e() == true) goto L4;
        if (r1.f() == true) goto L4;
        r1.b();
        if (this.f3904c == false) goto L11;
        this.f3903b.add(r1);
        goto L4
    L11:
        r1.a();
        goto L4
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f3902a.size() + ", isPaused=" + this.f3904c + "}";
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
