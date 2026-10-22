package com.stepos.common.animator;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.stepos.alphame.R;
import java.util.ArrayList;
import y1.y;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public boolean f11308b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11307a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final float f11309c = 0.95f;

    public final void a(final View view, boolean z4) {
        int iA;
        if (view == null) {
            return;
        }
        try {
            iA = androidx.core.content.b.a(view.getContext(), R.color.fd_sys_color_state_pressed_default);
        } catch (Exception unused) {
            Log.d("StepOSSPressAnimationHelper", " res not fond , sourceContext is null");
            iA = (view.getResources().getConfiguration().uiMode & 48) == 32 ? 611743360 : 443971200;
        }
        int iArgb = Color.argb(255, Color.red(iA), Color.green(iA), Color.blue(iA));
        float fAlpha = Color.alpha(iA) / 255.0f;
        W.n nVar = new W.n();
        nVar.a(0.9f);
        nVar.b(250.0f);
        W.m mVar = new W.m(new W.l());
        mVar.f1974m = nVar;
        mVar.g(100.0f);
        this.f11308b = !(view instanceof y);
        if (z4) {
            l lVar = new l();
            lVar.f11305a = view;
            lVar.f11306b = mVar;
            this.f11307a.add(lVar);
        } else {
            view.setOnTouchListener(new j(this, view, mVar));
        }
        mVar.a(new W.i() { // from class: com.stepos.common.animator.i
            @Override // W.i
            public final void a(boolean z5) {
                m mVar2 = this.f11296a;
                mVar2.getClass();
                View view2 = view;
                if (view2.getLayerType() == 2 && mVar2.f11308b) {
                    view2.setLayerType(0, null);
                }
            }
        });
        mVar.b(new k(this, view, fAlpha, iArgb));
    }

    public final void b(View view, int i4, boolean z4) {
        view.setTag(R.id.press_anim_tag, Integer.valueOf(i4));
        a(view, z4);
    }

    public final void c(View view, MotionEvent motionEvent, W.m mVar) {
        int action = motionEvent.getAction();
        int i4 = 1;
        if (action == 0) {
            mVar.f1974m.f1985i = this.f11309c * 100.0f;
            if (view.getLayerType() != 2 && this.f11308b) {
                view.setLayerType(2, null);
            }
            new Handler(Looper.getMainLooper()).post(new e(mVar, i4));
            return;
        }
        if (action == 1 || action == 3) {
            mVar.f1974m.f1985i = 100.0f;
            if (view.getLayerType() != 2 && this.f11308b) {
                view.setLayerType(2, null);
            }
            new Handler(Looper.getMainLooper()).post(new e(mVar, i4));
        }
    }
}
