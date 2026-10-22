package b0;

import a6.i0;
import android.graphics.Typeface;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.behavior.SwipeDismissBehavior;
import g.v1;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import r6.x;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f806a;

    /* renamed from: b, reason: collision with root package name */
    public Object f807b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f808c;

    public /* synthetic */ a(Object obj, int i8, Object obj2) {
        this.f806a = i8;
        this.f807b = obj;
        this.f808c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx.emoji2.text.m mVar;
        v1 v1Var;
        g.f fVar;
        switch (this.f806a) {
            case 0:
                x xVar = (x) this.f807b;
                Typeface typeface = (Typeface) this.f808c;
                w.b bVar = (w.b) xVar.f5220a;
                if (bVar != null) {
                    bVar.e(typeface);
                    return;
                }
                return;
            case 1:
                ((g) this.f807b).accept(this.f808c);
                return;
            case 2:
                int i8 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f807b).run();
                    } catch (Throwable th) {
                        i0.n(f5.i.f2626a, th);
                    }
                    Runnable runnableH = ((f6.f) this.f808c).H();
                    if (runnableH == null) {
                        return;
                    }
                    try {
                        this.f807b = runnableH;
                        i8++;
                        if (i8 >= 16) {
                            f6.f fVar2 = (f6.f) this.f808c;
                            if (f6.a.j(fVar2.d, fVar2)) {
                                f6.f fVar3 = (f6.f) this.f808c;
                                f6.a.i(fVar3.d, fVar3, this);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        f6.f fVar4 = (f6.f) this.f808c;
                        synchronized (fVar4.f2645g) {
                            f6.f.f2641h.decrementAndGet(fVar4);
                            throw th2;
                        }
                    }
                }
            case 3:
                g.f fVar5 = (g.f) this.f807b;
                g.i iVar = (g.i) this.f808c;
                f.j jVar = iVar.f2714c;
                if (jVar != null && (mVar = jVar.f2457e) != null && (v1Var = ((ActionMenuView) mVar.f621a).f316u) != null) {
                    Toolbar toolbar = v1Var.f2848a;
                    g.i iVar2 = toolbar.f333a.f315t;
                    if (iVar2 == null || (fVar = iVar2.f2728s) == null || !fVar.b()) {
                        Iterator it = ((CopyOnWriteArrayList) toolbar.H.f621a).iterator();
                        if (it.hasNext()) {
                            ((androidx.fragment.app.i) it.next()).getClass();
                            throw null;
                        }
                    }
                }
                ActionMenuView actionMenuView = iVar.f2717g;
                if (actionMenuView != null && actionMenuView.getWindowToken() != null) {
                    if (fVar5.b()) {
                        iVar.f2728s = fVar5;
                    } else if (fVar5.f2501e != null) {
                        fVar5.d(0, 0, false, false);
                        iVar.f2728s = fVar5;
                    }
                }
                iVar.f2730u = null;
                return;
            default:
                i0.e eVar = ((SwipeDismissBehavior) this.f808c).f1226a;
                if (eVar == null || !eVar.f()) {
                    return;
                }
                ((View) this.f807b).postOnAnimation(this);
                return;
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, int i8, boolean z) {
        this.f806a = i8;
        this.f808c = obj;
        this.f807b = obj2;
    }

    public a(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.f806a = 4;
        this.f808c = swipeDismissBehavior;
        this.f807b = view;
    }
}
