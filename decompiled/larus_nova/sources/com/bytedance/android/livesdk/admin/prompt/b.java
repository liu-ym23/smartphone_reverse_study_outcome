package com.bytedance.android.livesdk.admin.prompt;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromptDisplayWidget f103085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f103086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f103087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f103088d;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f103089a;

        public a(b r100) {
            this.f103089a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "anim");
            b r101 = this.f103089a;
            if (r101.f103085a.isViewValid == true) goto L6;
            r100.cancel();
            return;
        L6:
            View r102 = r101.f103086b;
            Object r103 = r100.getAnimatedValue();
            if (r103 == null) goto L11;
            a1.k(r102, ((Integer) r103).intValue());
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public b(PromptDisplayWidget r100, View r101, int r102, View r103) {
        this.f103085a = r100;
        this.f103086b = r101;
        this.f103087c = r102;
        this.f103088d = r103;
    }

    public final void a() {
        int r100 = this.f103086b.findViewById(R.id.tv_prompt_content).getHeight();
        if (this.f103087c == r100) goto L5;
        ValueAnimator r101 = ObjectAnimator.ofInt(new int[]{this.f103088d.getHeight(), this.f103086b.getHeight()}).setDuration(150);
        r101.addUpdateListener(new a(this));
        r101.start();
    L5:
        View r102 = this.f103086b.findViewById(R.id.tv_prompt_content);
        r102.setTranslationY(r100);
        this.f103086b.setAlpha(1.0f);
        r102.animate().translationYBy(-r100).setDuration(150).start();
        this.f103088d.findViewById(R.id.tv_prompt_content).animate().translationYBy(-this.f103087c).setDuration(150).start();
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
