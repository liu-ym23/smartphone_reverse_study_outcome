package I1;

import H1.h;
import P.e;
import P.g;
import P.i;
import P.j;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import t1.o;

/* loaded from: classes.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    public static int f2929e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static int f2930f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static int f2931g = 4;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2933b;

    /* renamed from: d, reason: collision with root package name */
    private Context f2935d;

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f2932a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private float f2934c = 0.95f;

    class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2936a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f2937b;

        a(View view, i iVar) {
            this.f2936a = view;
            this.f2937b = iVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            f.this.h(this.f2936a, motionEvent, this.f2937b);
            return false;
        }
    }

    class b implements e.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2939a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f2940b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2941c;

        b(View view, float f5, int i5) {
            this.f2939a = view;
            this.f2940b = f5;
            this.f2941c = i5;
        }

        @Override // P.e.r
        public void a(P.e eVar, float f5, float f6) {
            float f7 = f5 / 100.0f;
            View view = this.f2939a;
            int i5 = h.f2248f0;
            if (view.getTag(i5) == null) {
                this.f2939a.setScaleY(f7);
                this.f2939a.setScaleX(f7);
                return;
            }
            int iIntValue = ((Integer) this.f2939a.getTag(i5)).intValue();
            if ((f.f2929e & iIntValue) != 0) {
                this.f2939a.setScaleY(f7);
                this.f2939a.setScaleX(f7);
            }
            if ((f.f2930f & iIntValue) != 0) {
                int iG = f.this.g(this.f2941c, (int) (((float) (this.f2940b * ((1.0f - f7) / 0.05d))) * 255.0f));
                View view2 = this.f2939a;
                if (view2 instanceof ImageView) {
                    ((ImageView) view2).setColorFilter(iG, PorterDuff.Mode.SRC_ATOP);
                } else {
                    Drawable background = view2.getBackground();
                    if (background != null) {
                        background.setColorFilter(iG, PorterDuff.Mode.SRC_ATOP);
                    }
                }
            }
            if ((iIntValue & f.f2931g) != 0) {
                this.f2939a.setAlpha(1.0f - ((float) (((1.0f - f7) / 0.05d) * 0.4000000059604645d)));
            }
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public View f2943a;

        /* renamed from: b, reason: collision with root package name */
        public i f2944b;

        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static /* synthetic */ void a(f fVar, View view, P.e eVar, boolean z5, float f5, float f6) {
        fVar.getClass();
        if (view.getLayerType() == 2 && fVar.f2933b) {
            view.setLayerType(0, null);
        }
    }

    public static /* synthetic */ void b(i iVar) {
        if (iVar != null) {
            iVar.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(int i5, int i6) {
        return Color.argb(i6, Color.red(i5), Color.green(i5), Color.blue(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view, MotionEvent motionEvent, i iVar) {
        int action = motionEvent.getAction();
        if (action == 0) {
            iVar.u().g(this.f2934c * 100.0f);
            if (view.getLayerType() != 2 && this.f2933b) {
                view.setLayerType(2, null);
            }
            k(iVar);
            return;
        }
        if (action == 1 || action == 3) {
            iVar.u().g(100.0f);
            if (view.getLayerType() != 2 && this.f2933b) {
                view.setLayerType(2, null);
            }
            k(iVar);
        }
    }

    private boolean j(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    private void k(final i iVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: I1.e
            @Override // java.lang.Runnable
            public final void run() {
                f.b(iVar);
            }
        });
    }

    private boolean l(View view) {
        return !(view instanceof o);
    }

    public void e(final View view, boolean z5) {
        int iC;
        if (view == null) {
            return;
        }
        try {
            iC = androidx.core.content.a.c(view.getContext(), H1.e.f2086h);
        } catch (Exception unused) {
            if (this.f2935d != null) {
                Log.d("StepOSSPressAnimationHelper", " res not fond ,try to getColor By sourceContext");
                iC = androidx.core.content.a.c(this.f2935d, H1.e.f2086h);
            } else {
                Log.d("StepOSSPressAnimationHelper", " res not fond , sourceContext is null");
                iC = !j(view.getResources().getConfiguration()) ? 443971200 : 611743360;
            }
        }
        int iArgb = Color.argb(255, Color.red(iC), Color.green(iC), Color.blue(iC));
        float fAlpha = Color.alpha(iC) / 255.0f;
        i iVarX = new i(new g()).x(new j().f(0.9f).h(250.0f));
        iVarX.m(100.0f);
        this.f2933b = l(view);
        if (z5) {
            c cVar = new c(null);
            cVar.f2943a = view;
            cVar.f2944b = iVarX;
            this.f2932a.add(cVar);
        } else {
            view.setOnTouchListener(new a(view, iVarX));
        }
        iVarX.b(new e.q() { // from class: I1.d
            @Override // P.e.q
            public final void a(P.e eVar, boolean z6, float f5, float f6) {
                f.a(this.f2926a, view, eVar, z6, f5, f6);
            }
        });
        iVarX.c(new b(view, fAlpha, iArgb));
    }

    public void f(View view, boolean z5, int i5) {
        view.setTag(h.f2248f0, Integer.valueOf(i5));
        e(view, z5);
    }

    public void i(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            for (c cVar : this.f2932a) {
                if (view == cVar.f2943a && view.isEnabled()) {
                    h(view, motionEvent, cVar.f2944b);
                }
            }
        }
    }
}
