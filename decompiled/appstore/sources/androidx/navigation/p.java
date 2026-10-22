package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.r0;
import kotlin.collections.s0;
import kotlin.collections.t;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.f1;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f3919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableStateFlow f3920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableStateFlow f3921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlow f3923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StateFlow f3924f;

    public p() {
        this.f3919a = new ReentrantLock(true);
        MutableStateFlow r10 = f1.a(t.i());
        this.f3920b = r10;
        MutableStateFlow r11 = f1.a(r0.e());
        this.f3921c = r11;
        this.f3923e = kotlinx.coroutines.flow.c.b(r10);
        this.f3924f = kotlinx.coroutines.flow.c.b(r11);
    }

    public abstract NavBackStackEntry a(NavDestination r10, Bundle r11);

    public final StateFlow b() {
        return this.f3923e;
    }

    public final StateFlow c() {
        return this.f3924f;
    }

    public final boolean d() {
        return this.f3922d;
    }

    public void e(NavBackStackEntry r10) {
        kotlin.jvm.internal.q.g(r10, "entry");
        MutableStateFlow r11 = this.f3921c;
        r11.setValue(s0.j((Set) r11.getValue(), r10));
    }

    public void f(NavBackStackEntry r10) {
        kotlin.jvm.internal.q.g(r10, "backStackEntry");
        MutableStateFlow r11 = this.f3920b;
        r11.setValue(b0.o0(b0.m0((Iterable) r11.getValue(), b0.i0((List) this.f3920b.getValue())), r10));
    }

    public void g(NavBackStackEntry r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "popUpTo");
        ReentrantLock r12 = this.f3919a;
        r12.lock();
        MutableStateFlow r13 = this.f3920b;     // Catch: Throwable -> L10
        Iterable r14 = (Iterable) r13.getValue();     // Catch: Throwable -> L10
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L10
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L10
    L5:
        if (r16.hasNext() == false) goto L12;
        Object r17 = r16.next();     // Catch: Throwable -> L10
        if (kotlin.jvm.internal.q.b((NavBackStackEntry) r17, r10) == true) goto L12;
        r15.add(r17);     // Catch: Throwable -> L10
    L12:
        r13.setValue(r15);     // Catch: Throwable -> L10
        Unit r18 = Unit.f21064a;     // Catch: Throwable -> L10
        r12.unlock();
        return;
    L10:
        th = move-exception;
        r12.unlock();
        throw th;
    }

    public void h(NavBackStackEntry r10) {
        kotlin.jvm.internal.q.g(r10, "backStackEntry");
        ReentrantLock r11 = this.f3919a;
        r11.lock();
        MutableStateFlow r12 = this.f3920b;     // Catch: Throwable -> L6
        r12.setValue(b0.o0((Collection) r12.getValue(), r10));     // Catch: Throwable -> L6
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L6
        r11.unlock();
        return;
    L6:
        th = move-exception;
        r11.unlock();
        throw th;
    }

    public final void i(boolean r10) {
        this.f3922d = r10;
    }
}
