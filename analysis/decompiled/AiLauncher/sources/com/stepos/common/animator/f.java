package com.stepos.common.animator;

import Z2.o;
import android.annotation.SuppressLint;
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
import androidx.dynamicanimation.animation.e;
import androidx.dynamicanimation.animation.g;
import androidx.dynamicanimation.animation.i;
import androidx.dynamicanimation.animation.j;
import com.stepos.common.R$color;
import com.stepos.common.R$id;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class f {
    public static int CUSTOM_PRESS_EFFECT_ALPHA = 4;
    public static int CUSTOM_PRESS_EFFECT_MASK = 2;
    public static int CUSTOM_PRESS_EFFECT_SCALE = 1;
    private static final float DAMPING = 0.9f;
    private static final float SCALE_FROM = 1.0f;
    private static final float SCALE_TO = 0.95f;
    private static final float SPRING_ANIMATION_FLOAT_TO_INT_PROP = 100.0f;
    private static final float STIFFNESS = 250.0f;
    private Context mSourceContext;
    private boolean mUseHardwareLayer;
    private final List<c> spaInfoList = new ArrayList();
    private float mScaleTo = 0.95f;

    public class a implements View.OnTouchListener {
        final /* synthetic */ i val$springAnimation;
        final /* synthetic */ View val$view;

        public a(View view, i iVar) {
            this.val$view = view;
            this.val$springAnimation = iVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            f.this.h(this.val$view, motionEvent, this.val$springAnimation);
            return false;
        }
    }

    public class b implements e.r {
        final /* synthetic */ int val$pressColorFullAlpha;
        final /* synthetic */ float val$pressColorOriAlpha;
        final /* synthetic */ View val$view;

        public b(View view, float f10, int i10) {
            this.val$view = view;
            this.val$pressColorOriAlpha = f10;
            this.val$pressColorFullAlpha = i10;
        }

        @Override // androidx.dynamicanimation.animation.e.r
        public void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
            float f12 = f10 / 100.0f;
            View view = this.val$view;
            int i10 = R$id.press_anim_tag;
            if (view.getTag(i10) == null) {
                this.val$view.setScaleY(f12);
                this.val$view.setScaleX(f12);
                return;
            }
            int iIntValue = ((Integer) this.val$view.getTag(i10)).intValue();
            if ((f.CUSTOM_PRESS_EFFECT_SCALE & iIntValue) != 0) {
                this.val$view.setScaleY(f12);
                this.val$view.setScaleX(f12);
            }
            if ((f.CUSTOM_PRESS_EFFECT_MASK & iIntValue) != 0) {
                int iG = f.this.g(this.val$pressColorFullAlpha, (int) (((float) (this.val$pressColorOriAlpha * ((1.0f - f12) / 0.05d))) * 255.0f));
                View view2 = this.val$view;
                if (view2 instanceof ImageView) {
                    ((ImageView) view2).setColorFilter(iG, PorterDuff.Mode.SRC_ATOP);
                } else {
                    Drawable background = view2.getBackground();
                    if (background != null) {
                        background.setColorFilter(iG, PorterDuff.Mode.SRC_ATOP);
                    }
                }
            }
            if ((iIntValue & f.CUSTOM_PRESS_EFFECT_ALPHA) != 0) {
                this.val$view.setAlpha(1.0f - ((float) (((1.0f - f12) / 0.05d) * 0.4000000059604645d)));
            }
        }
    }

    public static class c {
        public Drawable drawable;
        public i springAnimation;
        public View view;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static /* synthetic */ void a(f fVar, View view, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        fVar.getClass();
        if (view.getLayerType() == 2 && fVar.mUseHardwareLayer) {
            view.setLayerType(0, null);
        }
    }

    public static /* synthetic */ void b(i iVar) {
        if (iVar != null) {
            iVar.t();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void e(final View view, boolean z10) {
        int iC;
        if (view == null) {
            return;
        }
        try {
            iC = androidx.core.content.a.c(view.getContext(), R$color.fd_sys_color_state_pressed_default);
        } catch (Exception unused) {
            if (this.mSourceContext != null) {
                Log.d("StepOSSPressAnimationHelper", " res not fond ,try to getColor By sourceContext");
                iC = androidx.core.content.a.c(this.mSourceContext, R$color.fd_sys_color_state_pressed_default);
            } else {
                Log.d("StepOSSPressAnimationHelper", " res not fond , sourceContext is null");
                iC = !j(view.getResources().getConfiguration()) ? 443971200 : 611743360;
            }
        }
        int iArgb = Color.argb(255, Color.red(iC), Color.green(iC), Color.blue(iC));
        float fAlpha = Color.alpha(iC) / 255.0f;
        i iVarB = new i(new g()).B(new j().f(0.9f).h(STIFFNESS));
        iVarB.q(100.0f);
        this.mUseHardwareLayer = l(view);
        if (z10) {
            c cVar = new c(null);
            cVar.view = view;
            cVar.springAnimation = iVarB;
            this.spaInfoList.add(cVar);
        } else {
            view.setOnTouchListener(new a(view, iVarB));
        }
        iVarB.b(new e.q() { // from class: com.stepos.common.animator.d
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z11, float f10, float f11) {
                f.a(this.f29506a, view, eVar, z11, f10, f11);
            }
        });
        iVarB.c(new b(view, fAlpha, iArgb));
    }

    public void f(View view, boolean z10, int i10) {
        view.setTag(R$id.press_anim_tag, Integer.valueOf(i10));
        e(view, z10);
    }

    public final int g(int i10, int i11) {
        return Color.argb(i11, Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    public final void h(View view, MotionEvent motionEvent, i iVar) {
        int action = motionEvent.getAction();
        if (action == 0) {
            iVar.y().g(this.mScaleTo * 100.0f);
            if (view.getLayerType() != 2 && this.mUseHardwareLayer) {
                view.setLayerType(2, null);
            }
            k(iVar);
            return;
        }
        if (action == 1 || action == 3) {
            iVar.y().g(100.0f);
            if (view.getLayerType() != 2 && this.mUseHardwareLayer) {
                view.setLayerType(2, null);
            }
            k(iVar);
        }
    }

    public void i(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            for (c cVar : this.spaInfoList) {
                if (view == cVar.view && view.isEnabled()) {
                    h(view, motionEvent, cVar.springAnimation);
                }
            }
        }
    }

    public final boolean j(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public final void k(final i iVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.common.animator.e
            @Override // java.lang.Runnable
            public final void run() {
                f.b(iVar);
            }
        });
    }

    public final boolean l(View view) {
        return !(view instanceof o);
    }
}
