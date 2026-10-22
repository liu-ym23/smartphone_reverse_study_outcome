package H4;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.stepos.ability.voicewakeup.training.TrainingListenEffect;
import com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$PlayMask;
import com.stepos.motionkit.FxInstance;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import m9.q0;
import w0.C2086g;

/* loaded from: classes3.dex */
public final class d implements TrainingListenEffect {

    /* renamed from: a, reason: collision with root package name */
    public final View f736a;
    public com.stepos.ability.voicewakeup.training.motionkit.a c;
    public C2086g d;
    public boolean f;
    public long g;
    public final ArrayList b = new ArrayList();
    public final u e = new u();
    public final A6.l h = new A6.l(this, 6);

    public d(View view) {
        this.f736a = view;
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingListenEffect
    public final void destroy() {
        ArrayList arrayList = this.b;
        this.f = false;
        this.f736a.removeCallbacks(this.h);
        u uVar = this.e;
        uVar.f753a = 0.0f;
        uVar.b = Math.abs(0.0f) <= Float.MAX_VALUE ? AbstractC1451a.t(0.0f, 0.0f, 1.0f) : 0.0f;
        C2086g c2086g = this.d;
        if (c2086g != null) {
            View view = (View) c2086g.f6811a;
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.d = null;
        try {
            com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.c;
            if (aVar != null) {
                aVar.i();
            }
        } finally {
            this.c = null;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                ViewGroup viewGroup2 = cVar.f735a;
                boolean z10 = cVar.b;
                boolean z11 = cVar.c;
                viewGroup2.setClipChildren(z10);
                viewGroup2.setClipToPadding(z11);
            }
            arrayList.clear();
        }
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingListenEffect
    public final long release() {
        this.f = false;
        this.f736a.removeCallbacks(this.h);
        u uVar = this.e;
        uVar.f753a = 0.0f;
        uVar.b = Math.abs(0.0f) <= Float.MAX_VALUE ? AbstractC1451a.t(0.0f, 0.0f, 1.0f) : 0.0f;
        com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.c;
        if (aVar == null) {
            return 0L;
        }
        aVar.v(0.0f);
        aVar.p();
        I4.e eVar = aVar.c;
        float fFloatValue = ((Number) eVar.b.getValue(eVar, I4.e.c[22])).floatValue();
        I4.p pVar = aVar.b;
        double dMax = Math.max(fFloatValue, ((Number) pVar.f806a.getValue(pVar, I4.p.b[10])).floatValue()) * 1000.0d;
        float f = aVar.f;
        if (f < 0.01f) {
            f = 0.01f;
        }
        return (long) Math.ceil(dMax / f);
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingListenEffect
    public final void setVolume(float f) {
        u uVar = this.e;
        uVar.getClass();
        uVar.b = Math.abs(f) <= Float.MAX_VALUE ? AbstractC1451a.t(f, 0.0f, 1.0f) : 0.0f;
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingListenEffect
    public final void start() {
        View view = this.f736a;
        View viewFindViewById = view.getRootView().findViewById(R.id.content);
        int i = 0;
        while (true) {
            if (i >= 4) {
                break;
            }
            ViewGroup viewGroup = (ViewGroup) viewFindViewById;
            if (viewGroup != null) {
                this.b.add(new c(viewGroup, viewGroup.getClipChildren(), viewGroup.getClipToPadding()));
                ViewParent parent = viewGroup.getParent();
                viewFindViewById = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            }
            i++;
        }
        View viewFindViewById2 = view.getRootView().findViewById(R.id.content);
        if (viewFindViewById2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById2;
        C2086g c2086g = new C2086g();
        View view2 = new View(viewGroup2.getContext());
        view2.setImportantForAccessibility(2);
        view2.setClickable(false);
        view2.setFocusable(false);
        c2086g.f6811a = view2;
        viewGroup2.addView(view2, new ViewGroup.LayoutParams(1, 1));
        this.d = c2086g;
        com.stepos.ability.voicewakeup.training.motionkit.a aVar = new com.stepos.ability.voicewakeup.training.motionkit.a((View) c2086g.f6811a);
        this.c = aVar;
        aVar.v(0.0f);
        VoiceListenAnimation$PlayMask[] voiceListenAnimation$PlayMaskArr = VoiceListenAnimation$PlayMask.f3398a;
        q0 q0Var = aVar.f3428z;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        aVar.f3428z = null;
        aVar.E = false;
        aVar.n.d();
        aVar.f3416G = 0L;
        FxInstance fxInstance = (FxInstance) aVar.g.get("WaterDrop");
        if (fxInstance != null) {
            fxInstance.setUniform("uRippleTime", -1.0f);
        }
        if (aVar.h()) {
            aVar.s();
        }
        aVar.o();
        this.f = true;
        this.g = System.nanoTime();
        view.postOnAnimation(this.h);
    }
}
