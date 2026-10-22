package androidx.fragment.app;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import e0.a0;
import g.t0;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import k4.v;
import kotlin.jvm.internal.p;
import org.bouncycastle.asn1.BERTags;
import v0.n0;
import v0.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f660a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f661b;

    public /* synthetic */ b(int i8, Object obj) {
        this.f660a = i8;
        this.f661b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        g.i iVar;
        q6.a aVarB;
        long jNanoTime;
        int i8 = 2;
        int i9 = 1;
        int i10 = 0;
        switch (this.f660a) {
            case 0:
                ((e) this.f661b).f662l.getClass();
                return;
            case 1:
                ((k) this.f661b).getClass();
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            case 2:
                t0 t0Var = (t0) this.f661b;
                t0Var.f2838m = null;
                t0Var.drawableStateChanged();
                return;
            case 3:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) this.f661b;
                if (searchView$SearchAutoComplete.f331f) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.f331f = false;
                    return;
                }
                return;
            case 4:
                ActionMenuView actionMenuView = ((Toolbar) this.f661b).f333a;
                if (actionMenuView == null || (iVar = actionMenuView.f315t) == null) {
                    return;
                }
                iVar.k();
                return;
            case 5:
                g0.c cVar = (g0.c) this.f661b;
                t0 t0Var2 = cVar.f2891c;
                g0.a aVar = cVar.f2889a;
                if (cVar.f2902p) {
                    if (cVar.f2900n) {
                        cVar.f2900n = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f2883e = jCurrentAnimationTimeMillis;
                        aVar.f2885g = -1L;
                        aVar.f2884f = jCurrentAnimationTimeMillis;
                        aVar.f2886h = 0.5f;
                    }
                    if ((aVar.f2885g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar.f2885g + aVar.f2887i) || !cVar.e()) {
                        cVar.f2902p = false;
                        return;
                    }
                    if (cVar.f2901o) {
                        cVar.f2901o = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        t0Var2.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (aVar.f2884f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = aVar.a(jCurrentAnimationTimeMillis2);
                    long j4 = jCurrentAnimationTimeMillis2 - aVar.f2884f;
                    aVar.f2884f = jCurrentAnimationTimeMillis2;
                    cVar.f2904r.scrollListBy((int) (j4 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * aVar.d));
                    int[] iArr = a0.f2285a;
                    t0Var2.postOnAnimation(this);
                    return;
                }
                return;
            case 6:
                ((i0.e) this.f661b).n(0);
                return;
            case 7:
                a aVar2 = (a) this.f661b;
                aVar2.f658c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) aVar2.f659e;
                i0.e eVar = bottomSheetBehavior.O;
                if (eVar != null && eVar.f()) {
                    aVar2.a(aVar2.f657b);
                    return;
                } else {
                    if (bottomSheetBehavior.N == 2) {
                        bottomSheetBehavior.C(aVar2.f657b);
                        return;
                    }
                    return;
                }
            case 8:
                q6.d dVar = (q6.d) this.f661b;
                synchronized (dVar) {
                    dVar.f4885g++;
                    aVarB = dVar.b();
                }
                if (aVarB == null) {
                    return;
                }
                Thread threadCurrentThread = Thread.currentThread();
                String name = threadCurrentThread.getName();
                do {
                    q6.a aVar3 = aVarB;
                    try {
                        threadCurrentThread.setName(aVar3.f4868a);
                        Logger logger = ((q6.d) this.f661b).f4881b;
                        q6.c cVar2 = aVar3.f4870c;
                        p.b(cVar2);
                        boolean zIsLoggable = logger.isLoggable(Level.FINE);
                        if (zIsLoggable) {
                            jNanoTime = System.nanoTime();
                            v.c(logger, aVar3, cVar2, "starting");
                        } else {
                            jNanoTime = -1;
                        }
                        try {
                            long jA = aVar3.a();
                            if (zIsLoggable) {
                                v.c(logger, aVar3, cVar2, "finished run in " + v.y(System.nanoTime() - jNanoTime));
                            }
                            q6.d dVar2 = (q6.d) this.f661b;
                            synchronized (dVar2) {
                                q6.d.a(dVar2, aVar3, jA, true);
                                aVarB = dVar2.b();
                            }
                        } catch (Throwable th) {
                            if (zIsLoggable) {
                                v.c(logger, aVar3, cVar2, "failed a run in " + v.y(System.nanoTime() - jNanoTime));
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        try {
                            q6.d dVar3 = (q6.d) this.f661b;
                            synchronized (dVar3) {
                                q6.d.a(dVar3, aVar3, -1L, false);
                                if (!(th2 instanceof InterruptedException)) {
                                    throw th2;
                                }
                                Thread.currentThread().interrupt();
                            }
                        } catch (Throwable th3) {
                            threadCurrentThread.setName(name);
                            throw th3;
                        }
                    }
                } while (aVarB != null);
                threadCurrentThread.setName(name);
                return;
            case 9:
                v0.j jVar = (v0.j) this.f661b;
                ValueAnimator valueAnimator = jVar.f5857u;
                int i11 = jVar.f5858v;
                if (i11 == 1) {
                    valueAnimator.cancel();
                } else if (i11 != 2) {
                    return;
                }
                jVar.f5858v = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            case 10:
                y yVar = ((RecyclerView) this.f661b).G;
                if (yVar != null) {
                    v0.g gVar = (v0.g) yVar;
                    ArrayList arrayList = gVar.f5816h;
                    boolean zIsEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = gVar.f5818j;
                    boolean zIsEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = gVar.f5819k;
                    boolean zIsEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = gVar.f5817i;
                    boolean zIsEmpty4 = arrayList4.isEmpty();
                    if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
                        return;
                    }
                    if (arrayList.size() > 0) {
                        ((n0) arrayList.get(0)).getClass();
                        throw null;
                    }
                    arrayList.clear();
                    if (!zIsEmpty2) {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.addAll(arrayList2);
                        gVar.f5821m.add(arrayList5);
                        arrayList2.clear();
                        v0.b bVar = new v0.b(gVar, arrayList5, i10);
                        if (!zIsEmpty) {
                            ((v0.f) arrayList5.get(0)).getClass();
                            throw null;
                        }
                        bVar.run();
                    }
                    if (!zIsEmpty3) {
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.addAll(arrayList3);
                        gVar.f5822n.add(arrayList6);
                        arrayList3.clear();
                        v0.b bVar2 = new v0.b(gVar, arrayList6, i9);
                        if (!zIsEmpty) {
                            ((v0.e) arrayList6.get(0)).getClass();
                            throw null;
                        }
                        bVar2.run();
                    }
                    if (zIsEmpty4) {
                        return;
                    }
                    ArrayList arrayList7 = new ArrayList();
                    arrayList7.addAll(arrayList4);
                    gVar.f5820l.add(arrayList7);
                    arrayList4.clear();
                    v0.b bVar3 = new v0.b(gVar, arrayList7, i8);
                    if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                        bVar3.run();
                        return;
                    }
                    Math.max(!zIsEmpty2 ? gVar.f5946e : 0L, zIsEmpty3 ? 0L : gVar.f5947f);
                    ((n0) arrayList7.get(0)).getClass();
                    int[] iArr2 = a0.f2285a;
                    throw null;
                }
                return;
            case BERTags.EMBEDDED_PDV /* 11 */:
                ((StaggeredGridLayoutManager) this.f661b).c0();
                return;
            default:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f661b).f1356c.f6123g;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
        }
    }
}
