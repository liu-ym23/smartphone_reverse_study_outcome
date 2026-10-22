package bw2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.widget.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.s;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPropertyAnimator f21010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Boolean> f21011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Boolean> f21012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v70.a f21013d;

    /* JADX INFO: renamed from: bw2.a$a, reason: collision with other inner class name */
    public static final class C0367a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f21014a;

        public C0367a(a r100) {
            this.f21014a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0<Boolean> r101 = this.f21014a.f21011b;
            if (r101 != null) goto L5;
        L6:
            this.f21014a.f21013d.setVisibility(8);
            return;
        L5:
            if (r101.invoke().booleanValue() != true) goto L6;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f21015a;

        public b(a r100) {
            this.f21015a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationCancel(r100);
            Function0<Boolean> r101 = this.f21015a.f21011b;
            if (r101 != null) goto L5;
        L6:
            this.f21015a.f21013d.setVisibility(0);
            this.f21015a.f21013d.setAlpha(1.0f);
            return;
        L5:
            if (r101.invoke().booleanValue() == true) goto L6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0<Boolean> r101 = this.f21015a.f21011b;
            if (r101 != null) goto L5;
        L6:
            this.f21015a.f21013d.setVisibility(0);
            this.f21015a.f21013d.setAlpha(1.0f);
            return;
        L5:
            if (r101.invoke().booleanValue() == true) goto L6;
        }
    }

    public final void a() {
        ViewPropertyAnimator r100 = this.f21010a;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public a(v70.a r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProxy");
        this.f21013d = r100;
    }

    public final void onEvent(s r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ViewPropertyAnimator r101 = null;
        if (r100.f571933a == false) goto L27;
        ViewPropertyAnimator r102 = this.f21010a;
        if (r102 == null) goto L7;
        r102.setListener(null);
    L7:
        ViewPropertyAnimator r103 = this.f21010a;
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        Function0<Boolean> r104 = this.f21012c;
        if (r104 != null) goto L13;
    L15:
        ViewPropertyAnimator r105 = this.f21013d.a();
        if (r105 == null) goto L24;
        ViewPropertyAnimator r106 = r105.alpha(0.0f);
        if (r106 == null) goto L24;
        ViewPropertyAnimator r107 = r106.setDuration(200);
        if (r107 == null) goto L24;
        ViewPropertyAnimator r108 = r107.setInterpolator(new g());
        if (r108 == null) goto L24;
        r101 = r108.setListener(new C0367a(this));
    L24:
        this.f21010a = r101;
        if (r101 == null) goto L51;
        r101.start();
        return;
    L51:
        return;
    L13:
        if (r104.invoke().booleanValue() == true) goto L15;
        return;
    L27:
        Function0<Boolean> r109 = this.f21011b;
        if (r109 != null) goto L30;
    L31:
        this.f21013d.setVisibility(0);
    L32:
        ViewPropertyAnimator r110 = this.f21010a;
        if (r110 == null) goto L35;
        r110.setListener(null);
    L35:
        ViewPropertyAnimator r111 = this.f21010a;
        if (r111 == null) goto L38;
        r111.cancel();
    L38:
        ViewPropertyAnimator r112 = this.f21013d.a();
        if (r112 == null) goto L47;
        ViewPropertyAnimator r113 = r112.alpha(1.0f);
        if (r113 == null) goto L47;
        ViewPropertyAnimator r114 = r113.setDuration(200);
        if (r114 == null) goto L47;
        ViewPropertyAnimator r115 = r114.setInterpolator(new g());
        if (r115 == null) goto L47;
        r101 = r115.setListener(new b(this));
    L47:
        this.f21010a = r101;
        if (r101 == null) goto L53;
        r101.start();
        return;
    L53:
        return;
    L30:
        if (r109.invoke().booleanValue() == false) goto L32;
        goto L31
    }
}
