package com.stepos.common.animator;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.stepos.ability.R;
import e3.InterfaceC1407A;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class m {
    public boolean b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3570a = new ArrayList();
    public final float c = 0.95f;

    public final void a(final View view, boolean z10) {
        int color;
        if (view == null) {
            return;
        }
        try {
            color = ContextCompat.getColor(view.getContext(), R.color.fd_sys_color_state_pressed_default);
        } catch (Exception unused) {
            Log.d("StepOSSPressAnimationHelper", " res not fond , sourceContext is null");
            color = (view.getResources().getConfiguration().uiMode & 48) == 32 ? 611743360 : 443971200;
        }
        int iArgb = Color.argb(255, Color.red(color), Color.green(color), Color.blue(color));
        float fAlpha = Color.alpha(color) / 255.0f;
        SpringAnimation spring = new SpringAnimation(new FloatValueHolder()).setSpring(new SpringForce().setDampingRatio(0.9f).setStiffness(250.0f));
        spring.setStartValue(100.0f);
        this.b = !(view instanceof InterfaceC1407A);
        if (z10) {
            l lVar = new l();
            lVar.f3569a = view;
            lVar.b = spring;
            this.f3570a.add(lVar);
        } else {
            view.setOnTouchListener(new j(this, view, spring));
        }
        spring.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.stepos.common.animator.i
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z11, float f, float f7) {
                m mVar = this.f3566a;
                mVar.getClass();
                View view2 = view;
                if (view2.getLayerType() == 2 && mVar.b) {
                    view2.setLayerType(0, null);
                }
            }
        });
        spring.addUpdateListener(new k(this, view, fAlpha, iArgb));
    }

    public final void b(View view, int i, boolean z10) {
        view.setTag(R.id.press_anim_tag, Integer.valueOf(i));
        a(view, z10);
    }

    public final void c(View view, MotionEvent motionEvent, SpringAnimation springAnimation) {
        int action = motionEvent.getAction();
        if (action == 0) {
            springAnimation.getSpring().setFinalPosition(this.c * 100.0f);
            if (view.getLayerType() != 2 && this.b) {
                view.setLayerType(2, null);
            }
            new Handler(Looper.getMainLooper()).post(new e(springAnimation, 1));
            return;
        }
        if (action == 1 || action == 3) {
            springAnimation.getSpring().setFinalPosition(100.0f);
            if (view.getLayerType() != 2 && this.b) {
                view.setLayerType(2, null);
            }
            new Handler(Looper.getMainLooper()).post(new e(springAnimation, 1));
        }
    }
}
