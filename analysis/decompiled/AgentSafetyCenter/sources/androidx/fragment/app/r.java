package androidx.fragment.app;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.stepos.common.app.LibraryInitProvider;
import com.stepos.common.widget.CircularProgressButton;
import com.stepos.common.widget.EmptyView;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import m.j1;
import n3.k0;
import stepos.support.v7.app.p0;
import stepos.support.v7.app.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1300c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1301f;

    public /* synthetic */ r(int i) {
        this.f1300c = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws ClassNotFoundException {
        dd.a aVarC;
        long jNanoTime;
        m.k kVar;
        int i = 3;
        switch (this.f1300c) {
            case 0:
                ((v) this.f1301f).e(true);
                return;
            case 1:
                ((CircularProgressButton) this.f1301f).invalidate();
                return;
            case 2:
                ((EmptyView) ((aa.l) this.f1301f).f332f).f2589h.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            case 3:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.f fVar = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.f) this.f1301f;
                ta.a aVar = fVar.f2835f;
                ta.a aVar2 = fVar.f2835f;
                if (aVar.f13291a.getAll().size() >= 500) {
                    ua.c.a("V3OfflineEmitter", "Sp data more than 500, into the clear.");
                    aVar2.f13291a.edit().clear().commit();
                }
                Log.d("V3OfflineEmitter", "init thread:" + Thread.currentThread().getName());
                Iterator<Map.Entry<String, ?>> it = aVar2.f13291a.getAll().entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    try {
                        long j10 = Integer.parseInt(key);
                        if (fVar.f2836g < j10) {
                            fVar.f2836g = j10;
                        }
                    } catch (Exception e10) {
                        ua.c.b("V3OfflineEmitter", e10.getMessage());
                        aVar2.f13291a.edit().remove(key).apply();
                    }
                }
                return;
            case 4:
                StringBuilder sb2 = new StringBuilder("clean sessionId: ");
                p5.i iVar = (p5.i) this.f1301f;
                sb2.append((String) iVar.f9732g);
                ua.c.a("RpkPageController", sb2.toString());
                iVar.f9732g = null;
                return;
            case 5:
                break;
            case 6:
                j1 j1Var = (j1) this.f1301f;
                j1Var.f7942p = null;
                j1Var.drawableStateChanged();
                return;
            case 7:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) this.f1301f;
                if (searchView$SearchAutoComplete.f802j) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.f802j = false;
                    return;
                }
                return;
            case 8:
                ActionMenuView actionMenuView = ((Toolbar) this.f1301f).f804c;
                if (actionMenuView == null || (kVar = actionMenuView.f796x) == null) {
                    return;
                }
                kVar.l();
                return;
            case 9:
                pe.c.a((stepos.support.v7.widget.n) this.f1301f);
                return;
            case 10:
                r3.c cVar = (r3.c) this.f1301f;
                j1 j1Var2 = cVar.f10446g;
                r3.a aVar3 = cVar.f10444c;
                if (cVar.f10457s) {
                    if (cVar.f10455q) {
                        cVar.f10455q = false;
                        aVar3.getClass();
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar3.f10439e = jCurrentAnimationTimeMillis;
                        aVar3.f10441g = -1L;
                        aVar3.f10440f = jCurrentAnimationTimeMillis;
                        aVar3.f10442h = 0.5f;
                    }
                    if ((aVar3.f10441g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.f10441g + aVar3.i) || !cVar.e()) {
                        cVar.f10457s = false;
                        return;
                    }
                    if (cVar.f10456r) {
                        cVar.f10456r = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        j1Var2.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (aVar3.f10440f == 0) {
                        od.f.o("Cannot compute scroll delta before calling start()");
                        return;
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = aVar3.a(jCurrentAnimationTimeMillis2);
                    long j11 = jCurrentAnimationTimeMillis2 - aVar3.f10440f;
                    aVar3.f10440f = jCurrentAnimationTimeMillis2;
                    cVar.f10459u.scrollListBy((int) (j11 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * aVar3.f10438d));
                    WeakHashMap weakHashMap = k0.f8724a;
                    j1Var2.postOnAnimation(this);
                    return;
                }
                return;
            case 11:
                try {
                    Class.forName("com.meizu.nightmode.MzHighContrastManager");
                    Log.i("[LibraryInitProvider]", "start init");
                    Application application = (Application) ((LibraryInitProvider) this.f1301f).getContext().getApplicationContext();
                    if (application == null || a1.g.f17g != null) {
                        StringBuilder sb3 = new StringBuilder("init return application is null :");
                        sb3.append(application == null);
                        Log.i("HighContrast_Common", sb3.toString());
                        return;
                    } else {
                        a1.g gVar = new a1.g(29, z);
                        new Handler(Looper.getMainLooper());
                        gVar.f19f = application;
                        a1.g.f17g = gVar;
                        Log.i("HighContrast_Common", "sInstance init success");
                        new Thread(new a4.o(i)).start();
                        return;
                    }
                } catch (Exception unused) {
                    Log.i("[LibraryInitProvider]", "not Support high contrast");
                    return;
                }
            case 12:
                se.e eVar = (se.e) this.f1301f;
                se.e.a(eVar, eVar.f12210e, eVar.f12209d, eVar.f12214j);
                return;
            case 13:
                q0 q0Var = (q0) this.f1301f;
                p0 p0Var = q0Var.f12454c;
                Menu menuT = q0Var.t();
                te.l lVar = menuT instanceof te.l ? (te.l) menuT : null;
                if (lVar != null) {
                    lVar.v();
                }
                try {
                    menuT.clear();
                    if (!p0Var.f12411c.onCreatePanelMenu(0, menuT) || !p0Var.onPreparePanel(0, null, menuT)) {
                        menuT.clear();
                    }
                    if (lVar != null) {
                        lVar.u();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (lVar != null) {
                        lVar.u();
                    }
                    throw th;
                }
            case 14:
                g7.f fVar2 = (g7.f) this.f1301f;
                fVar2.f4363c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) fVar2.f4365e;
                u3.b bVar = bottomSheetBehavior.O;
                if (bVar != null && bVar.f()) {
                    fVar2.a(fVar2.f4362b);
                    return;
                } else {
                    if (bottomSheetBehavior.N == 2) {
                        bottomSheetBehavior.n(fVar2.f4362b);
                        return;
                    }
                    return;
                }
            case 15:
                ((u3.b) this.f1301f).o(0);
                return;
            default:
                v1.t tVar = (v1.t) this.f1301f;
                tVar.removeCallbacks(this);
                MotionEvent motionEvent = tVar.f14568u0;
                if (motionEvent != null) {
                    z = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    tVar.G(motionEvent, (actionMasked == 7 || actionMasked == 9) ? 7 : 2, tVar.f14570v0, false);
                    return;
                }
                return;
        }
        while (true) {
            dd.d dVar = (dd.d) this.f1301f;
            synchronized (dVar) {
                aVarC = dVar.c();
            }
            if (aVarC == null) {
                return;
            }
            dd.c cVar2 = aVarC.f3301c;
            cVar2.getClass();
            dd.d dVar2 = (dd.d) this.f1301f;
            boolean zIsLoggable = dd.d.i.isLoggable(Level.FINE);
            if (zIsLoggable) {
                jNanoTime = System.nanoTime();
                a.a.g(aVarC, cVar2, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                dd.d.a(dVar2, aVarC);
                if (zIsLoggable) {
                    a.a.g(aVarC, cVar2, "finished run in ".concat(a.a.w(System.nanoTime() - jNanoTime)));
                }
            } catch (Throwable th2) {
                try {
                    ((ThreadPoolExecutor) dVar2.f3312a.f19f).execute(this);
                    throw th2;
                } catch (Throwable th3) {
                    if (zIsLoggable) {
                        a.a.g(aVarC, cVar2, "failed a run in ".concat(a.a.w(System.nanoTime() - jNanoTime)));
                    }
                    throw th3;
                }
            }
        }
    }
}
