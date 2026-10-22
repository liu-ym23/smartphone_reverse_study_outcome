package a0;

import D.C0759a0;
import D.InterfaceC0771h;
import D.InterfaceC0778o;
import D.o0;
import G.ResolvedFeatureGroup;
import K.InterfaceC0898v;
import android.annotation.SuppressLint;
import android.view.A;
import android.view.InterfaceC1397o;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@SuppressLint({"UsesNonDefaultVisibleForTesting"})
/* loaded from: classes.dex */
public final class c implements InterfaceC1397o, InterfaceC0771h {

    /* renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f7782b;

    /* renamed from: c, reason: collision with root package name */
    public final CameraUseCaseAdapter f7783c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.l f7784d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f7781a = new Object();

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f7785e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7786f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7787g = false;

    /* renamed from: h, reason: collision with root package name */
    public o0 f7788h = null;

    public c(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter, androidx.camera.core.l lVar) {
        this.f7782b = lifecycleOwner;
        this.f7783c = cameraUseCaseAdapter;
        this.f7784d = lVar;
        if (lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            cameraUseCaseAdapter.u();
        } else {
            cameraUseCaseAdapter.F();
        }
        lifecycleOwner.getLifecycle().a(this);
    }

    public static /* synthetic */ void c(ResolvedFeatureGroup aVar, o0 o0Var) {
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            hashSet.addAll(aVar.a());
        }
        o0Var.e().accept(hashSet);
    }

    public final void A(List<UseCase> list, androidx.camera.core.l lVar) {
        for (UseCase useCase : list) {
            if (useCase.F()) {
                useCase.Z(lVar);
            }
        }
    }

    @Override // D.InterfaceC0771h
    public InterfaceC0778o a() {
        return this.f7783c.a();
    }

    public void k(final o0 o0Var) throws CameraUseCaseAdapter.CameraException {
        synchronized (this.f7781a) {
            try {
                if (this.f7788h == null) {
                    this.f7788h = o0Var;
                } else if (o0Var.getIsLegacy()) {
                    if (!this.f7788h.getIsLegacy()) {
                        throw new IllegalStateException("Cannot bind use cases when a SessionConfig is already bound to this LifecycleOwner. Please unbind first");
                    }
                    ArrayList arrayList = new ArrayList(this.f7788h.m());
                    arrayList.addAll(o0Var.m());
                    o0Var.n();
                    this.f7788h = new C0759a0(arrayList, null, o0Var.d());
                } else {
                    if (this.f7788h.getIsLegacy()) {
                        throw new IllegalStateException("Cannot bind the SessionConfig when use cases are bound to this LifecycleOwner already. Please unbind first");
                    }
                    this.f7788h = o0Var;
                    CameraUseCaseAdapter cameraUseCaseAdapter = this.f7783c;
                    cameraUseCaseAdapter.b0(cameraUseCaseAdapter.M());
                }
                CameraUseCaseAdapter cameraUseCaseAdapter2 = this.f7783c;
                o0Var.n();
                cameraUseCaseAdapter2.i0(null);
                this.f7783c.e0(o0Var.d());
                this.f7783c.h0(o0Var.getSessionType());
                this.f7783c.g0(o0Var.g());
                if (o0Var.getIsAutoRotationEnabled()) {
                    A(o0Var.m(), this.f7784d);
                }
                final ResolvedFeatureGroup aVarB = ResolvedFeatureGroup.b(o0Var, (InterfaceC0898v) a());
                o0Var.getFeatureSelectionListenerExecutor().execute(new Runnable() { // from class: a0.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.c(aVarB, o0Var);
                    }
                });
                this.f7783c.k(o0Var.m(), aVarB);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @A(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7781a) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.f7783c;
            cameraUseCaseAdapter.b0(cameraUseCaseAdapter.M());
        }
    }

    @A(Lifecycle.Event.ON_PAUSE)
    public void onPause(LifecycleOwner lifecycleOwner) {
        this.f7783c.f(false);
    }

    @A(Lifecycle.Event.ON_RESUME)
    public void onResume(LifecycleOwner lifecycleOwner) {
        this.f7783c.f(true);
    }

    @A(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7781a) {
            try {
                if (!this.f7786f && !this.f7787g) {
                    this.f7783c.u();
                    this.f7785e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @A(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7781a) {
            try {
                if (!this.f7786f && !this.f7787g) {
                    this.f7783c.F();
                    this.f7785e = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CameraUseCaseAdapter r() {
        return this.f7783c;
    }

    public LifecycleOwner s() {
        LifecycleOwner lifecycleOwner;
        synchronized (this.f7781a) {
            lifecycleOwner = this.f7782b;
        }
        return lifecycleOwner;
    }

    public List<UseCase> t() {
        List<UseCase> listUnmodifiableList;
        synchronized (this.f7781a) {
            listUnmodifiableList = Collections.unmodifiableList(this.f7783c.M());
        }
        return listUnmodifiableList;
    }

    public boolean u(UseCase useCase) {
        boolean zContains;
        synchronized (this.f7781a) {
            zContains = this.f7783c.M().contains(useCase);
        }
        return zContains;
    }

    public boolean v() {
        boolean zP;
        synchronized (this.f7781a) {
            o0 o0Var = this.f7788h;
            zP = o0Var == null ? false : o0Var.getIsLegacy();
        }
        return zP;
    }

    public void w() {
        synchronized (this.f7781a) {
            try {
                if (this.f7786f) {
                    return;
                }
                onStop(this.f7782b);
                this.f7786f = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x(o0 o0Var) {
        C0759a0 c0759a0;
        synchronized (this.f7781a) {
            try {
                o0 o0Var2 = this.f7788h;
                if (o0Var2 != null && o0Var2.getIsLegacy() == o0Var.getIsLegacy()) {
                    if (this.f7788h.getIsLegacy() || o0Var.getIsLegacy()) {
                        if (this.f7788h.getIsLegacy() && o0Var.getIsLegacy()) {
                            ArrayList arrayList = new ArrayList(this.f7788h.m());
                            arrayList.removeAll(o0Var.m());
                            if (arrayList.isEmpty()) {
                                c0759a0 = null;
                            } else {
                                this.f7788h.n();
                                c0759a0 = new C0759a0(arrayList, null, this.f7788h.d());
                            }
                            this.f7788h = c0759a0;
                        }
                    } else if (this.f7788h != o0Var) {
                        return;
                    } else {
                        this.f7788h = null;
                    }
                    ArrayList arrayList2 = new ArrayList(o0Var.m());
                    arrayList2.retainAll(this.f7783c.M());
                    this.f7783c.b0(arrayList2);
                    A(arrayList2, null);
                }
            } finally {
            }
        }
    }

    public void y() {
        synchronized (this.f7781a) {
            List<UseCase> listM = this.f7783c.M();
            this.f7783c.b0(listM);
            A(listM, null);
            this.f7788h = null;
        }
    }

    public void z() {
        synchronized (this.f7781a) {
            try {
                if (this.f7786f) {
                    this.f7786f = false;
                    if (this.f7782b.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                        onStart(this.f7782b);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
