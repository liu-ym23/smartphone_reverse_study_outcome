package com.bytedance.android.live.effect;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.effect.beauty.BeautyModeSelectPanel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBeautifyDialogFragment f68000a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f68001a;

        public a(f r100) {
            this.f68001a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f68001a.f68000a.S90(R.id.shadow_view);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setVisibility(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public f(LiveBeautifyDialogFragment r100) {
        this.f68000a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BeautyModeSelectPanel r101 = (BeautyModeSelectPanel) this.f68000a.S90(R.id.beauty_mode_select_panel);
        if (r101 == null) goto L5;
        r101.R5(((com.bytedance.android.live.effect.sticker.presenter.n) this.f68000a.f66673f.getValue()).i(), (String) m90.b.F.c(this.f68000a.f66672e).first);
    L5:
        BeautyModeSelectPanel r102 = (BeautyModeSelectPanel) this.f68000a.S90(R.id.beauty_mode_select_panel);
        if (r102 == null) goto L8;
        r102.setVisibility(0);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r102, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102.getHeight(), 0.0f});
        r103.setDuration(300);
        r103.start();
    L8:
        r100.postDelayed(new a(this), 300);
    }
}
