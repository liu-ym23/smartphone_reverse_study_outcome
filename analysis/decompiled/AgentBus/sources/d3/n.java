package d3;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import la.u0;

/* loaded from: classes.dex */
public final class n implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f2835a;

    public n(l lVar) {
        this.f2835a = lVar;
    }

    public final void onBackCancelled() {
        l lVar = this.f2835a;
        i5.f fVar = lVar.f2812a;
        if (fVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!lVar.f2813b) {
            fVar.B(lVar, null);
        }
        g gVar = (g) fVar.f4654h;
        gVar.getClass();
        if (lVar.equals(gVar.f2821h) && -1 == gVar.f2820g) {
            d dVarC = gVar.f2819f;
            if (dVarC == null) {
                dVarC = gVar.c(-1);
            }
            gVar.f2819f = null;
            gVar.f2820g = 0;
            gVar.f2821h = null;
            if (dVarC != null) {
                dVarC.a();
            }
            u0 u0Var = gVar.f2814a;
            u0Var.getClass();
            u0Var.g(null, h.f2828a);
        }
        lVar.f2813b = false;
    }

    public final void onBackInvoked() {
        this.f2835a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        q7.k.e(backEvent, "backEvent");
        b bVarB = ib.k.b(backEvent);
        l lVar = this.f2835a;
        i5.f fVar = lVar.f2812a;
        if (fVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (lVar.f2813b) {
            g gVar = (g) fVar.f4654h;
            gVar.getClass();
            if (lVar.equals(gVar.f2821h) && -1 == gVar.f2820g) {
                d dVarC = gVar.f2819f;
                if (dVarC == null) {
                    dVarC = gVar.c(-1);
                }
                if (dVarC != null) {
                    dVarC.c(bVarB);
                }
                u0 u0Var = gVar.f2814a;
                i iVar = new i(bVarB);
                u0Var.getClass();
                u0Var.g(null, iVar);
            }
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        q7.k.e(backEvent, "backEvent");
        b bVarB = ib.k.b(backEvent);
        l lVar = this.f2835a;
        i5.f fVar = lVar.f2812a;
        if (fVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (lVar.f2813b) {
            return;
        }
        fVar.B(lVar, bVarB);
        lVar.f2813b = true;
    }
}
