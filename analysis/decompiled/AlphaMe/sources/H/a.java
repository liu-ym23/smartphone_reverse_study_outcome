package H;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.C0290l;
import androidx.fragment.app.C0291m;
import androidx.fragment.app.q0;
import com.google.android.gms.common.api.internal.D;
import com.google.android.gms.common.api.internal.E;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior;
import d.C0527a;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import t0.r;
import t0.x;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f654a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f655b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f656c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f657d;

    public /* synthetic */ a(int i4, Object obj, Object obj2, Object obj3) {
        this.f654a = i4;
        this.f657d = obj;
        this.f655b = obj2;
        this.f656c = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        OverScroller overScroller;
        Object objCall = null;
        switch (this.f654a) {
            case 0:
                C0527a c0527a = (C0527a) this.f655b;
                Typeface typeface = (Typeface) this.f656c;
                C.b bVar = (C.b) c0527a.f12410b;
                if (bVar != null) {
                    bVar.h(typeface);
                    break;
                }
                break;
            case 1:
                ((J.a) this.f655b).accept(this.f656c);
                break;
            case 2:
                try {
                    objCall = ((Callable) this.f655b).call();
                } catch (Exception unused) {
                }
                ((Handler) this.f657d).post(new a(1, this, (J.a) this.f656c, objCall));
                break;
            case 3:
                if (((List) this.f655b).contains((q0) this.f656c)) {
                    ((List) this.f655b).remove((q0) this.f656c);
                    C0291m c0291m = (C0291m) this.f657d;
                    q0 q0Var = (q0) this.f656c;
                    c0291m.getClass();
                    C0291m.j(q0Var);
                    break;
                }
                break;
            case 4:
                ((C0290l) this.f655b).a();
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Transition for operation " + ((q0) this.f656c) + "has completed");
                    break;
                }
                break;
            case 5:
                ((r) this.f655b).i((x) this.f656c, (android.support.v4.media.session.c) this.f657d);
                break;
            case 6:
                D d4 = (D) this.f657d;
                if (d4.f9623b > 0) {
                    LifecycleCallback lifecycleCallback = (LifecycleCallback) this.f655b;
                    Bundle bundle = d4.f9624c;
                    lifecycleCallback.c(bundle != null ? bundle.getBundle((String) this.f656c) : null);
                }
                if (((D) this.f657d).f9623b >= 2) {
                    ((LifecycleCallback) this.f655b).f();
                }
                if (((D) this.f657d).f9623b >= 3) {
                    ((LifecycleCallback) this.f655b).d();
                }
                if (((D) this.f657d).f9623b >= 4) {
                    ((LifecycleCallback) this.f655b).g();
                }
                if (((D) this.f657d).f9623b >= 5) {
                    ((LifecycleCallback) this.f655b).getClass();
                    break;
                }
                break;
            case 7:
                E e4 = (E) this.f657d;
                if (e4.f9626b > 0) {
                    LifecycleCallback lifecycleCallback2 = (LifecycleCallback) this.f655b;
                    Bundle bundle2 = e4.f9627c;
                    lifecycleCallback2.c(bundle2 != null ? bundle2.getBundle((String) this.f656c) : null);
                }
                if (((E) this.f657d).f9626b >= 2) {
                    ((LifecycleCallback) this.f655b).f();
                }
                if (((E) this.f657d).f9626b >= 3) {
                    ((LifecycleCallback) this.f655b).d();
                }
                if (((E) this.f657d).f9626b >= 4) {
                    ((LifecycleCallback) this.f655b).g();
                }
                if (((E) this.f657d).f9626b >= 5) {
                    ((LifecycleCallback) this.f655b).getClass();
                    break;
                }
                break;
            default:
                if (((View) this.f656c) != null && (overScroller = ((com.google.android.material.appbar.i) this.f657d).f10322b) != null) {
                    if (!overScroller.computeScrollOffset()) {
                        com.google.android.material.appbar.i iVar = (com.google.android.material.appbar.i) this.f657d;
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f655b;
                        View view = (View) this.f656c;
                        AppBarLayout$BaseBehavior appBarLayout$BaseBehavior = (AppBarLayout$BaseBehavior) iVar;
                        appBarLayout$BaseBehavior.getClass();
                        com.google.android.material.appbar.h hVar = (com.google.android.material.appbar.h) view;
                        appBarLayout$BaseBehavior.l(coordinatorLayout, hVar);
                        if (hVar.f10306l) {
                            hVar.i(hVar.j(AppBarLayout$BaseBehavior.h(coordinatorLayout)));
                            break;
                        }
                    } else {
                        com.google.android.material.appbar.i iVar2 = (com.google.android.material.appbar.i) this.f657d;
                        iVar2.e((CoordinatorLayout) this.f655b, (View) this.f656c, iVar2.f10322b.getCurrY());
                        ((View) this.f656c).postOnAnimation(this);
                        break;
                    }
                }
                break;
        }
    }

    public a(r processor, x startStopToken, android.support.v4.media.session.c cVar) {
        this.f654a = 5;
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(startStopToken, "startStopToken");
        this.f655b = processor;
        this.f656c = startStopToken;
        this.f657d = cVar;
    }
}
