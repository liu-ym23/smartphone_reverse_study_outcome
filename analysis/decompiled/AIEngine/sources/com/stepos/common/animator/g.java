package com.stepos.common.animator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.y0;
import com.stepos.aiengine.R;
import h1.d;
import java.util.ArrayList;
import y4.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public boolean f6472b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6471a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final float f6473c = 0.95f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f6474a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h1.f f6475b;

        public a(View view, h1.f fVar) {
            this.f6474a = view;
            this.f6475b = fVar;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            g.this.c(this.f6474a, motionEvent, this.f6475b);
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements d.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f6477a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f6478b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f6479c;

        public b(g gVar, View view, float f8, int i10) {
            this.f6477a = view;
            this.f6478b = f8;
            this.f6479c = i10;
        }

        @Override // h1.d.l
        public final void a(float f8) {
            float f9 = f8 / 100.0f;
            View view = this.f6477a;
            if (view.getTag(R.id.press_anim_tag) == null) {
                view.setScaleY(f9);
                view.setScaleX(f9);
                return;
            }
            int iIntValue = ((Integer) view.getTag(R.id.press_anim_tag)).intValue();
            if ((iIntValue & 1) != 0) {
                view.setScaleY(f9);
                view.setScaleX(f9);
            }
            if ((iIntValue & 2) != 0) {
                double d8 = this.f6478b;
                int i10 = this.f6479c;
                int iArgb = Color.argb((int) (((float) (((1.0f - f9) / 0.05d) * d8)) * 255.0f), Color.red(i10), Color.green(i10), Color.blue(i10));
                if (view instanceof ImageView) {
                    ((ImageView) view).setColorFilter(iArgb, PorterDuff.Mode.SRC_ATOP);
                } else {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        background.setColorFilter(iArgb, PorterDuff.Mode.SRC_ATOP);
                    }
                }
            }
            if ((iIntValue & 4) != 0) {
                view.setAlpha(1.0f - ((float) (((1.0f - f9) / 0.05d) * 0.4000000059604645d)));
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public View f6480a;

        /* renamed from: b, reason: collision with root package name */
        public h1.f f6481b;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a(final View view, boolean z) {
        int color;
        if (view == null) {
            return;
        }
        try {
            color = view.getContext().getColor(R.color.fd_sys_color_state_pressed_default);
        } catch (Exception unused) {
            Log.d("StepOSSPressAnimationHelper", " res not fond , sourceContext is null");
            color = (view.getResources().getConfiguration().uiMode & 48) == 32 ? 611743360 : 443971200;
        }
        int iArgb = Color.argb(255, Color.red(color), Color.green(color), Color.blue(color));
        float fAlpha = Color.alpha(color) / 255.0f;
        h1.g gVar = new h1.g();
        gVar.a(0.9f);
        gVar.b(250.0f);
        h1.f fVar = new h1.f(new h1.e());
        fVar.f9241t = gVar;
        fVar.f9228b = 100.0f;
        fVar.f9229c = true;
        this.f6472b = true ^ (view instanceof n);
        if (z) {
            c cVar = new c();
            cVar.f6480a = view;
            cVar.f6481b = fVar;
            this.f6471a.add(cVar);
        } else {
            view.setOnTouchListener(new a(view, fVar));
        }
        fVar.a(new d.k() { // from class: com.stepos.common.animator.f
            @Override // h1.d.k
            public final void a(boolean z3) {
                View view2 = view;
                if (view2.getLayerType() == 2 && this.f6469a.f6472b) {
                    view2.setLayerType(0, null);
                }
            }
        });
        fVar.b(new b(this, view, fAlpha, iArgb));
    }

    public final void b(View view, int i10, boolean z) {
        view.setTag(R.id.press_anim_tag, Integer.valueOf(i10));
        a(view, z);
    }

    public final void c(View view, MotionEvent motionEvent, h1.f fVar) {
        int action = motionEvent.getAction();
        if (action == 0) {
            fVar.f9241t.f9251i = this.f6473c * 100.0f;
            if (view.getLayerType() != 2 && this.f6472b) {
                view.setLayerType(2, null);
            }
            new Handler(Looper.getMainLooper()).post(new y0(fVar, 6));
            return;
        }
        if (action == 1 || action == 3) {
            fVar.f9241t.f9251i = 100.0f;
            if (view.getLayerType() != 2 && this.f6472b) {
                view.setLayerType(2, null);
            }
            new Handler(Looper.getMainLooper()).post(new y0(fVar, 6));
        }
    }
}
