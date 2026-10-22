package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f664a;

    /* renamed from: b, reason: collision with root package name */
    public final kb.j f665b = new kb.j();

    /* renamed from: c, reason: collision with root package name */
    public u f666c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f667d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f668e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f669f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f670g;

    public e0(Runnable runnable) {
        OnBackInvokedCallback onBackInvokedCallbackA;
        this.f664a = runnable;
        if (Build.VERSION.SDK_INT >= 34) {
            onBackInvokedCallbackA = a0.f650a.a(new v(this, 0), new v(this, 1), new w(this, 0), new w(this, 1));
        } else {
            onBackInvokedCallbackA = y.f708a.a(new w(this, 2));
        }
        this.f667d = onBackInvokedCallbackA;
    }

    public final void a(androidx.lifecycle.x xVar, u uVar) {
        xVar.getClass();
        uVar.getClass();
        androidx.lifecycle.q lifecycle = xVar.getLifecycle();
        if (lifecycle.b() == androidx.lifecycle.p.f1418c) {
            return;
        }
        b0 b0Var = new b0();
        b0Var.f654h = this;
        b0Var.f651c = lifecycle;
        b0Var.f652f = uVar;
        lifecycle.a(b0Var);
        VarHandle.storeStoreFence();
        uVar.f700b.add(b0Var);
        d();
        uVar.f701c = new d0(0, this, e0.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void b() {
        u uVarPrevious;
        u uVar = this.f666c;
        if (uVar == null) {
            kb.j jVar = this.f665b;
            ListIterator listIterator = jVar.listIterator(jVar.a());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVarPrevious = 0;
                    break;
                } else {
                    uVarPrevious = listIterator.previous();
                    if (((u) uVarPrevious).f699a) {
                        break;
                    }
                }
            }
            uVar = uVarPrevious;
        }
        this.f666c = null;
        if (uVar != null) {
            uVar.a();
        } else {
            this.f664a.run();
        }
    }

    public final void c(boolean z10) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f668e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f667d) == null) {
            return;
        }
        y yVar = y.f708a;
        if (z10 && !this.f669f) {
            yVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f669f = true;
        } else {
            if (z10 || !this.f669f) {
                return;
            }
            yVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f669f = false;
        }
    }

    public final void d() {
        boolean z10 = this.f670g;
        boolean z11 = false;
        kb.j jVar = this.f665b;
        if (jVar == null || !jVar.isEmpty()) {
            Iterator it = jVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((u) it.next()).f699a) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f670g = z11;
        if (z11 != z10) {
            c(z11);
        }
    }
}
