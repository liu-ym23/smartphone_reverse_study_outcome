package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.Q;
import androidx.fragment.app.Y;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.ArrayDeque;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f2372a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f2373b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public Q f2374c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f2375d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f2376e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2377f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2378g;

    public A(Runnable runnable) {
        OnBackInvokedCallback onBackInvokedCallbackA;
        this.f2372a = runnable;
        if (Build.VERSION.SDK_INT >= 34) {
            int i4 = 0;
            int i5 = 1;
            onBackInvokedCallbackA = w.f2448a.a(new r(this, i4), new r(this, i5), new s(this, i4), new s(this, i5));
        } else {
            onBackInvokedCallbackA = u.f2443a.a(new s(this, 2));
        }
        this.f2375d = onBackInvokedCallbackA;
    }

    public final void a() {
        Object objPrevious;
        ArrayDeque arrayDeque = this.f2373b;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((Q) objPrevious).f3637a) {
                    break;
                }
            }
        }
        Q q4 = (Q) objPrevious;
        this.f2374c = null;
        if (q4 == null) {
            Runnable runnable = this.f2372a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        Y y4 = q4.f3640d;
        y4.x(true);
        if (y4.f3669h.f3637a) {
            y4.L();
        } else {
            y4.f3668g.a();
        }
    }

    public final void b(boolean z4) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f2376e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f2375d) == null) {
            return;
        }
        u uVar = u.f2443a;
        if (z4 && !this.f2377f) {
            uVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f2377f = true;
        } else {
            if (z4 || !this.f2377f) {
                return;
            }
            uVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f2377f = false;
        }
    }

    public final void c() {
        boolean z4 = this.f2378g;
        ArrayDeque arrayDeque = this.f2373b;
        boolean z5 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((Q) it.next()).f3637a) {
                    z5 = true;
                    break;
                }
            }
        }
        this.f2378g = z5;
        if (z5 != z4) {
            b(z5);
        }
    }
}
