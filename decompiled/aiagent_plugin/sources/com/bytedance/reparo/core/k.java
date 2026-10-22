package com.bytedance.reparo.core;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PatchManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final String TAG = "PatchManager";
    private static final Object g = null;
    private static final Object h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f9299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f9300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.reparo.core.g.f f9301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.reparo.core.g.e f9302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Application f9303e;
    private com.bytedance.reparo.core.g.a f;
    private List<a> i;
    private ConcurrentHashMap<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> j;
    private ConcurrentHashMap<String, n> k;
    private final Set<com.bytedance.reparo.core.h.d> l;
    private boolean m;
    private String n;

    /* JADX INFO: compiled from: PatchManager.java */
    public interface a {
        void onChanged(ConcurrentHashMap<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> r1);
    }

    static /* synthetic */ e a(k r0) {
        return r0.f9300b;
    }

    static /* synthetic */ void a(k r0, com.bytedance.reparo.core.h.d r1, int r2, com.bytedance.reparo.core.e.a r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void a(k r0, com.bytedance.reparo.core.h.d r1, com.bytedance.reparo.core.e.a r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(k r0, com.bytedance.reparo.core.h.d r1, boolean r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ g b(k r0) {
        return r0.f9299a;
    }

    static /* synthetic */ com.bytedance.reparo.core.g.a c(k r0) {
        return r0.f;
    }

    static /* synthetic */ ConcurrentHashMap d(k r0) {
        return r0.k;
    }

    static /* synthetic */ void e(k r0) {
        r0.f();
    }

    static {
        g = new Object();
        h = new Object();
    }

    private k() {
        this.j = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        this.l = new HashSet();
    }

    k(Application r3, g r4, e r5, com.bytedance.reparo.core.g.a r6, String r7, boolean r8) {
        Application r9 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.g.a r10 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        this.j = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        this.l = new HashSet();
        this.f9303e = r9;
        this.f9299a = r4;
        this.f9300b = r5;
        this.f = r10;
        this.m = r8;
        this.n = r7;
        com.bytedance.reparo.core.g.f r11 = new com.bytedance.reparo.core.g.f(r4);
        this.f9301c = r11;
        this.f9302d = r11.a();
    }

    void a() {
        String r0 = this.f9302d.b();
        StringBuilder r1 = new StringBuilder().append("init in ");
        if (this.m == false) goto L5;
        String r2 = InitTaskProcess.MAIN;
    L6:
        a(TAG, r1.append(r2).append(" process, current host app version is ").append(this.n).toString());
        if (TextUtils.isEmpty(r0) == true) goto L12;
        if (TextUtils.equals(this.n, r0) == true) goto L12;
        this.f9302d.a(this.n);
        a(false);
        return;
    L12:
        if (TextUtils.isEmpty(this.f9302d.b()) == false) goto L14;
        this.f9302d.a(this.n);
    L14:
        b(false);
        return;
    L5:
        r2 = "sub";
        goto L6
    }

    void a(boolean r7) {
        Object r0 = h;
        monitor-enter(r0);
        Object[] r3 = new Object[1];     // Catch: Throwable -> L15
        if (this.m == false) goto L7;
        String r5 = InitTaskProcess.MAIN;
    L8:
        r3[0] = r5;     // Catch: Throwable -> L15
        j.b(TAG, String.format("clear all patches in %s process.", r3));     // Catch: Throwable -> L15
        this.f9302d.a().clear();     // Catch: Throwable -> L15
        e();     // Catch: Throwable -> L15
        if (this.m == false) goto L13;
        f();     // Catch: Throwable -> L15
        com.bytedance.reparo.core.a.b.b.delete(this.f9299a.e());     // Catch: Throwable -> L15
        if (r7 == false) goto L13;
        d();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        r5 = "sub";
    L15:
        th = move-exception;
        throw th;
    }

    public void update(final n r15) {
        if (this.m == true) goto L5;
        return;
    L5:
        final String r6 = r15.j();
        Object r0 = g;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (this.k.containsKey(r6) == false) goto L13;
        j.b(TAG, "the patch update request already exist. " + r15.toString());     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L13:
        if (a(r15) == false) goto L17;
        j.b(TAG, "the patch already updated." + r15.toString());     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L17:
        this.k.put(r6, r15);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        final long r4 = SystemClock.elapsedRealtime();
        new com.bytedance.reparo.core.d.a(this.f9303e, r15.a(), this.f9299a.a(r15), this.f9300b, this.f, this.f9299a).a(new AnonymousClass1(this, r15, r4, r6));
    }

    private boolean a(n r5) {
        Object r0 = h;
        monitor-enter(r0);
        Iterator<com.bytedance.reparo.core.g.h> r4 = this.j.keySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r4.hasNext() == false) goto L13;
        if (r5.a((com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin")) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    private boolean a(com.bytedance.reparo.core.h.d r8) {
        Object r0 = h;
        monitor-enter(r0);
        Iterator<com.bytedance.reparo.core.g.h> r1 = this.j.keySet().iterator();     // Catch: Throwable -> L25
    L6:
        if (r1.hasNext() == false) goto L15;
        com.bytedance.reparo.core.g.h r2 = (com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        com.bytedance.reparo.core.h.d r4 = (com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(this.j.get(r2), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r4 == null) goto L6;
        if (r4.a() == false) goto L6;
        if (TextUtils.equals(r2.l(), r8.g().l()) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return true;
    L15:
        Iterator<com.bytedance.reparo.core.h.d> r7 = this.l.iterator();     // Catch: Throwable -> L25
    L17:
        if (r7.hasNext() == false) goto L23;
        if (TextUtils.equals(((com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin")).g().l(), r8.g().l()) == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return true;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return false;
    L25:
        th = move-exception;
        throw th;
    }

    private void a(com.bytedance.reparo.core.h.d r4, boolean r5) {
        Object r0 = h;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.j.contains(r4) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.j.put(r4.g(), r4);     // Catch: Throwable -> L13
        this.f9302d.a(r4.g());     // Catch: Throwable -> L13
        f();     // Catch: Throwable -> L13
        if (r5 == false) goto L11;
        d();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private void d() {
        List<a> r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L12;
        Iterator<a> r1 = this.i.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        ((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin")).onChanged(this.j);
        goto L8
    L13:
        return;
    }

    void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        if (this.i != null) goto L6;
        this.i = new ArrayList();
    L6:
        if (this.i.contains(r4) == true) goto L9;
        this.i.add(r4);
        return;
    }

    void b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        List<a> r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.contains(r4) == false) goto L9;
        this.i.remove(r4);
        return;
    }

    private void a(com.bytedance.reparo.core.h.d r4, int r5, com.bytedance.reparo.core.e.a r6) {
        if ((r5 & 1) == 0) goto L6;
        j.b(TAG, "load in fake " + r4.g().toString() + " : there are so libraries in the patch");
    L6:
        if ((r5 & 2) == 0) goto L8;
        j.b(TAG, "load in fake " + r4.g().toString() + " : the patch of the same issueId has been posted online");
    L8:
        r4.b();
        r4.a(true);
        r6.b();
    }

    private synchronized void a(final com.bytedance.reparo.core.h.d r11, final com.bytedance.reparo.core.e.a r12) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (r11.a() == false) goto L8;
        j.b(TAG, "already load " + r11.g().toString());     // Catch: Throwable -> L20
        r12.b();     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L8:
        j.b(TAG, "start load patch " + r11.g().toString());     // Catch: Throwable -> L20
        if (a(r11) == false) goto L13;
        a(r11, 2, r12);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L13:
        final com.bytedance.reparo.core.g.h r5 = r11.g().a();     // Catch: Throwable -> L20
        final long r6 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L20
        final com.bytedance.reparo.core.h.b r0 = new com.bytedance.reparo.core.h.b();     // Catch: Throwable -> L20
        r11.a(new AnonymousClass2(this, r12, r11, r5, r6, r0), r0);     // Catch: Throwable -> L16
    L18:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        r12.b(new com.bytedance.reparo.core.b.d("unknownError", th, 0));     // Catch: Throwable -> L20
        goto L18
    }

    List<Map.Entry<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d>> a(Collection<Map.Entry<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d>> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        r0.addAll(r4);
        Collections.sort(r0, new AnonymousClass3(this));
        return r0;
    }

    void b(boolean r6) {
        if (r6 == false) goto L4;
        h();
    L4:
        e();
        if (r6 == true) goto L14;
        Iterator<Map.Entry<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d>> r1 = a(this.j.entrySet()).iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        com.bytedance.reparo.core.h.e r2 = ((com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin")).f9263d;
        if (r2 == null) goto L8;
        if (r2.i() == false) goto L8;
        WandTrick.f9137c = r2.g();
    L14:
        Iterator<Map.Entry<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d>> r3 = this.j.entrySet().iterator();
    L16:
        if (r3.hasNext() == false) goto L33;
        com.bytedance.reparo.core.h.d r4 = (com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L16;
        if (r4.a() == true) goto L16;
        if (r6 == true) goto L23;
        c(r4);
        goto L16
    L23:
        int r5 = 0;
        if (r4.g().g() == false) goto L27;
        r5 = 1;
    L29:
        if (r5 != 0) goto L30;
        c(r4);
        goto L16
    L30:
        a(r4, r5, com.bytedance.reparo.core.e.a.f);
        goto L16
    L27:
        if (a(r4) == false) goto L29;
        r5 = 2;
        goto L29
    }

    private void e() {
        Object r0 = h;
        monitor-enter(r0);
        Iterator<com.bytedance.reparo.core.g.h> r1 = this.f9302d.a().iterator();     // Catch: Throwable -> L29
    L6:
        if (r1.hasNext() == false) goto L12;
        com.bytedance.reparo.core.g.h r2 = (com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (this.f9302d.b(r2) == true) goto L6;
        r1.remove();     // Catch: Throwable -> L29
        if (this.m == false) goto L6;
        com.bytedance.reparo.core.a.b.b.delete(r2.b());     // Catch: Throwable -> L29
        f();     // Catch: Throwable -> L29
        goto L6
    L12:
        Iterator<Map.Entry<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d>> r3 = this.j.entrySet().iterator();     // Catch: Throwable -> L29
    L14:
        if (r3.hasNext() == false) goto L21;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        com.bytedance.reparo.core.h.d r5 = (com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(r4.getValue(), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (r5 == null) goto L14;
        com.bytedance.reparo.core.g.h r6 = (com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r4.getKey(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (this.f9302d.a().contains(r6) == true) goto L14;
        b(r5);     // Catch: Throwable -> L29
        r3.remove();     // Catch: Throwable -> L29
        goto L14
    L21:
        Iterator<com.bytedance.reparo.core.g.h> r7 = this.f9302d.a().iterator();     // Catch: Throwable -> L29
    L23:
        if (r7.hasNext() == false) goto L27;
        com.bytedance.reparo.core.g.h r8 = (com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (((com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(this.j.get(r8), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin")) != null) goto L23;
        this.j.put(r8, com.bytedance.reparo.core.h.d.a(r8, this.f9300b, this.f9299a, this.f));     // Catch: Throwable -> L29
        goto L23
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    private void b(com.bytedance.reparo.core.h.d r3) {
        j.b(TAG, "start offline patch " + r3.g().toString());
        r3.f();
        this.l.add(r3);
        r3.a(false);
        if (this.m == false) goto L6;
        com.bytedance.reparo.core.a.b.b.delete(r3.g().b());
        return;
    }

    private void f() {
        if (this.m == false) goto L6;
        this.f9302d.a(this.f9301c);
        return;
    }

    private void c(final com.bytedance.reparo.core.h.d r5) {
        com.bytedance.reparo.core.g.h r0 = r5.g();
        if (this.m == false) goto L5;
    L8:
        boolean r1 = r0.r();
        j.b(TAG, "postLoadTask, asyncLoad = " + r1);
        if (r1 == true) goto L11;
        a(r5, com.bytedance.reparo.core.e.a.f);
        return;
    L11:
        g().execute(new AnonymousClass4(this, r5));
        return;
    L5:
        if (r0.s() == true) goto L8;
        j.b(TAG, "the patch doesn't support sub process " + r0.toString());
    }

    private ExecutorService g() {
        return com.bytedance.reparo.core.i.c.a();
    }

    private void h() {
        Object r0 = h;
        monitor-enter(r0);
        com.bytedance.reparo.core.g.e r1 = this.f9301c.a();     // Catch: Throwable -> L16
        if (TextUtils.equals(this.f9302d.b(), r1.b()) == true) goto L7;
        this.f9302d.a(r1.b());     // Catch: Throwable -> L16
    L7:
        Set<com.bytedance.reparo.core.g.h> r6 = this.f9302d.a();     // Catch: Throwable -> L16
        Iterator<com.bytedance.reparo.core.g.h> r2 = r6.iterator();     // Catch: Throwable -> L16
    L9:
        if (r2.hasNext() == false) goto L13;
        com.bytedance.reparo.core.g.h r3 = (com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r1.a().contains(r3) == true) goto L9;
        r2.remove();     // Catch: Throwable -> L16
        goto L9
    L13:
        r6.addAll(r1.a());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    void b() {
        Object r0 = h;
        monitor-enter(r0);
        boolean r1 = false;
        Iterator<Map.Entry<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d>> r2 = this.j.entrySet().iterator();     // Catch: Throwable -> L21
    L7:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        com.bytedance.reparo.core.h.d r4 = (com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(r3.getValue(), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r4 == null) goto L7;
        if (r4.i() == false) goto L7;
        r1 = true;
        if (r4.f9263d == null) goto L15;
        ((com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r3.getKey(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin")).p();     // Catch: Throwable -> L21
        goto L7
    L15:
        this.f9302d.a().remove(r3.getKey());     // Catch: Throwable -> L21
        goto L7
    L17:
        if (r1 == false) goto L19;
        e();     // Catch: Throwable -> L21
        f();     // Catch: Throwable -> L21
        d();     // Catch: Throwable -> L21
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    Map<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> c() {
        e();
        return this.j;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
