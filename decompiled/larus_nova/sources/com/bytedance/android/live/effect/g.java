package com.bytedance.android.live.effect;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.effect.beauty.BeautyModeSelectPanel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBeautifyDialogFragment f68002a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f68003a;

        public a(g r100) {
            this.f68003a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f68003a.f68002a.S90(R.id.shadow_view);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setVisibility(4);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public g(LiveBeautifyDialogFragment r100) {
        this.f68002a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BeautyModeSelectPanel r101 = (BeautyModeSelectPanel) this.f68002a.S90(R.id.beauty_mode_select_panel);
        if (r101 == null) goto L5;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, r101.getHeight()});
        r102.setDuration(300);
        r102.addListener(new com.bytedance.android.live.effect.beauty.a(r101));
        r102.start();
    L5:
        r100.postDelayed(new a(this), 300);
    }
}
