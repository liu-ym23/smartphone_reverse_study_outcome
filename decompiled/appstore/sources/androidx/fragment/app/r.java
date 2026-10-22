package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f3380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentManager f3381b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FragmentManager.l f3382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3383b;

        public a(FragmentManager.l r10, boolean r11) {
            this.f3382a = r10;
            this.f3383b = r11;
        }
    }

    public r(FragmentManager r10) {
        this.f3380a = new CopyOnWriteArrayList();
        this.f3381b = r10;
    }

    public void a(Fragment r10, Bundle r11, boolean r12) {
        Fragment r13 = this.f3381b.B0();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().A0().a(r10, r11, true);
    L5:
        Iterator r14 = this.f3380a.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        a r15 = (a) r14.next();
        if (r12 == false) goto L12;
        if (r15.f3383b == false) goto L7;
    L12:
        r15.f3382a.a(this.f3381b, r10, r11);
        goto L7
    }

    public void b(Fragment r10, boolean r11) {
        Context r12 = this.f3381b.y0().e();
        Fragment r13 = this.f3381b.B0();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().A0().b(r10, true);
    L5:
        Iterator r14 = this.f3380a.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        a r15 = (a) r14.next();
        if (r11 == false) goto L12;
        if (r15.f3383b == false) goto L7;
    L12:
        r15.f3382a.b(this.f3381b, r10, r12);
        goto L7
    }

    public void c(Fragment r10, Bundle r11, boolean r12) {
        Fragment r13 = this.f3381b.B0();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().A0().c(r10, r11, true);
    L5:
        Iterator r14 = this.f3380a.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        a r15 = (a) r14.next();
        if (r12 == false) goto L12;
        if (r15.f3383b == false) goto L7;
    L12:
        r15.f3382a.c(this.f3381b, r10, r11);
        goto L7
    }

    public void d(Fragment r10, boolean r11) {
        Fragment r12 = this.f3381b.B0();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().A0().d(r10, true);
    L5:
        Iterator r13 = this.f3380a.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        a r14 = (a) r13.next();
        if (r11 == false) goto L12;
        if (r14.f3383b == false) goto L7;
    L12:
        r14.f3382a.d(this.f3381b, r10);
        goto L7
    }

    public void e(Fragment r10, boolean r11) {
        Fragment r12 = this.f3381b.B0();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().A0().e(r10, true);
    L5:
        Iterator r13 = this.f3380a.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        a r14 = (a) r13.next();
        if (r11 == false) goto L12;
        if (r14.f3383b == false) goto L7;
    L12:
        r14.f3382a.e(this.f3381b, r10);
        goto L7
    }

    public void f(Fragment r10, boolean r11) {
        Fragment r12 = this.f3381b.B0();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().A0().f(r10, true);
    L5:
        Iterator r13 = this.f3380a.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        a r14 = (a) r13.next();
        if (r11 == false) goto L12;
        if (r14.f3383b == false) goto L7;
    L12:
        r14.f3382a.f(this.f3381b, r10);
        goto L7
    }

    public void g(Fragment r10, boolean r11) {
        Context r12 = this.f3381b.y0().e();
        Fragment r13 = this.f3381b.B0();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().A0().g(r10, true);
    L5:
        Iterator r14 = this.f3380a.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        a r15 = (a) r14.next();
        if (r11 == false) goto L12;
        if (r15.f3383b == false) goto L7;
    L12:
        r15.f3382a.g(this.f3381b, r10, r12);
        goto L7
    }

    public void h(Fragment r10, Bundle r11, boolean r12) {
        Fragment r13 = this.f3381b.B0();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().A0().h(r10, r11, true);
    L5:
        Iterator r14 = this.f3380a.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        a r15 = (a) r14.next();
        if (r12 == false) goto L12;
        if (r15.f3383b == false) goto L7;
    L12:
        r15.f3382a.h(this.f3381b, r10, r11);
        goto L7
    }

    public void i(Fragment r10, boolean r11) {
        Fragment r12 = this.f3381b.B0();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().A0().i(r10, true);
    L5:
        Iterator r13 = this.f3380a.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        a r14 = (a) r13.next();
        if (r11 == false) goto L12;
        if (r14.f3383b == false) goto L7;
    L12:
        r14.f3382a.i(this.f3381b, r10);
        goto L7
    }

    public void j(Fragment r10, Bundle r11, boolean r12) {
        Fragment r13 = this.f3381b.B0();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().A0().j(r10, r11, true);
    L5:
        Iterator r14 = this.f3380a.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        a r15 = (a) r14.next();
        if (r12 == false) goto L12;
        if (r15.f3383b == false) goto L7;
    L12:
        r15.f3382a.j(this.f3381b, r10, r11);
        goto L7
    }

    public void k(Fragment r10, boolean r11) {
        Fragment r12 = this.f3381b.B0();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().A0().k(r10, true);
    L5:
        Iterator r13 = this.f3380a.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        a r14 = (a) r13.next();
        if (r11 == false) goto L12;
        if (r14.f3383b == false) goto L7;
    L12:
        r14.f3382a.k(this.f3381b, r10);
        goto L7
    }

    public void l(Fragment r10, boolean r11) {
        Fragment r12 = this.f3381b.B0();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().A0().l(r10, true);
    L5:
        Iterator r13 = this.f3380a.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        a r14 = (a) r13.next();
        if (r11 == false) goto L12;
        if (r14.f3383b == false) goto L7;
    L12:
        r14.f3382a.l(this.f3381b, r10);
        goto L7
    }

    public void m(Fragment r10, View r11, Bundle r12, boolean r13) {
        Fragment r14 = this.f3381b.B0();
        if (r14 == null) goto L5;
        r14.getParentFragmentManager().A0().m(r10, r11, r12, true);
    L5:
        Iterator r15 = this.f3380a.iterator();
    L7:
        if (r15.hasNext() == false) goto L13;
        a r16 = (a) r15.next();
        if (r13 == false) goto L12;
        if (r16.f3383b == false) goto L7;
    L12:
        r16.f3382a.m(this.f3381b, r10, r11, r12);
        goto L7
    }

    public void n(Fragment r10, boolean r11) {
        Fragment r12 = this.f3381b.B0();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().A0().n(r10, true);
    L5:
        Iterator r13 = this.f3380a.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        a r14 = (a) r13.next();
        if (r11 == false) goto L12;
        if (r14.f3383b == false) goto L7;
    L12:
        r14.f3382a.n(this.f3381b, r10);
        goto L7
    }

    public void o(FragmentManager.l r10, boolean r11) {
        this.f3380a.add(new a(r10, r11));
    }

    public void p(FragmentManager.l r10) {
        CopyOnWriteArrayList r11 = this.f3380a;
        monitor-enter(r11);
        int r12 = this.f3380a.size();     // Catch: Throwable -> L9
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L12;
        if (((a) this.f3380a.get(r13)).f3382a == r10) goto L8;
        r13 = r13 + 1;     // Catch: Throwable -> L9
        goto L5
    L8:
        this.f3380a.remove(r13);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
