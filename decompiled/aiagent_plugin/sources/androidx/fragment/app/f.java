package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f1806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentManager f1807b;

    /* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final FragmentManager.b f1808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f1809b;

        a(FragmentManager.b r1, boolean r2) {
            this.f1808a = r1;
            this.f1809b = r2;
        }
    }

    f(FragmentManager r2) {
        this.f1806a = new CopyOnWriteArrayList();
        this.f1807b = r2;
    }

    public void a(FragmentManager.b r2, boolean r3) {
        this.f1806a.add(new a(r2, r3));
    }

    public void a(FragmentManager.b r7) {
        CopyOnWriteArrayList<a> r0 = this.f1806a;
        monitor-enter(r0);
        int r1 = 0;
        int r2 = this.f1806a.size();     // Catch: Throwable -> L13
    L6:
        if (r1 >= r2) goto L11;
        if (((a) ZeusTransformUtils.preCheckCast(this.f1806a.get(r1), a.class, "com.obric.aiagent.plugin")).f1808a == r7) goto L9;
        r1 = r1 + 1;     // Catch: Throwable -> L13
        goto L6
    L9:
        this.f1806a.remove(r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void a(Fragment r6, boolean r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1807b.l().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Fragment r2 = this.f1807b.m();
        if (r2 == null) goto L5;
        r2.getParentFragmentManager().F().a(r6, true);
    L5:
        Iterator<a> r3 = this.f1806a.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L12;
        if (r4.f1809b == false) goto L7;
    L12:
        r4.f1808a.a(this.f1807b, r6, r0);
        goto L7
    }

    void b(Fragment r6, boolean r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1807b.l().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Fragment r2 = this.f1807b.m();
        if (r2 == null) goto L5;
        r2.getParentFragmentManager().F().b(r6, true);
    L5:
        Iterator<a> r3 = this.f1806a.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L12;
        if (r4.f1809b == false) goto L7;
    L12:
        r4.f1808a.b(this.f1807b, r6, r0);
        goto L7
    }

    void a(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().a(r5, r6, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.a(this.f1807b, r5, r6);
        goto L7
    }

    void b(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().b(r5, r6, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.b(this.f1807b, r5, r6);
        goto L7
    }

    void c(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().c(r5, r6, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.c(this.f1807b, r5, r6);
        goto L7
    }

    void a(Fragment r5, View r6, Bundle r7, boolean r8) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().a(r5, r6, r7, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r8 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.a(this.f1807b, r5, r6, r7);
        goto L7
    }

    void c(Fragment r5, boolean r6) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().c(r5, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.a(this.f1807b, r5);
        goto L7
    }

    void d(Fragment r5, boolean r6) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().d(r5, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.b(this.f1807b, r5);
        goto L7
    }

    void e(Fragment r5, boolean r6) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().e(r5, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.c(this.f1807b, r5);
        goto L7
    }

    void f(Fragment r5, boolean r6) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().f(r5, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.d(this.f1807b, r5);
        goto L7
    }

    void d(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().d(r5, r6, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.d(this.f1807b, r5, r6);
        goto L7
    }

    void g(Fragment r5, boolean r6) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().g(r5, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.e(this.f1807b, r5);
        goto L7
    }

    void h(Fragment r5, boolean r6) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().h(r5, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.f(this.f1807b, r5);
        goto L7
    }

    void i(Fragment r5, boolean r6) {
        Fragment r0 = this.f1807b.m();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().F().i(r5, true);
    L5:
        Iterator<a> r1 = this.f1806a.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L12;
        if (r2.f1809b == false) goto L7;
    L12:
        r2.f1808a.g(this.f1807b, r5);
        goto L7
    }
}
