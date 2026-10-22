package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v.a f152487a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f152488a;

        public a(u r100) {
            this.f152488a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f152488a.f152487a.f152490b.w().f().setBackgroundColor(-1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public u(v.a r100) {
        this.f152487a = r100;
    }

    public final void a() {
        this.f152487a.f152490b.w().g(0);
        View r100 = this.f152487a.f152490b.w().b(R.id.fl_small_card_cover).f();
        r100.setAlpha(0.0f);
        r100.animate().alpha(1.0f).setDuration(300).setInterpolator(new FastOutSlowInInterpolator()).withEndAction(new a(this)).start();
        View r101 = this.f152487a.f152490b.w().b(R.id.fl_small_card_title).f();
        r101.setAlpha(0.0f);
        r101.animate().alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(300).start();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
