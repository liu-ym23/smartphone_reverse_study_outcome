package androidx.core.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f1448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f1449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<View> f1451d;

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    static class a {
        static ViewPropertyAnimator a(ViewPropertyAnimator r2, ValueAnimator.AnimatorUpdateListener r3) {
            return r2.setUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.wrapperContextForParams(r3, ValueAnimator.AnimatorUpdateListener.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    static class b implements af {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ae f1452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1453b;

        b(ae r1) {
            this.f1452a = r1;
        }

        @Override // androidx.core.view.af
        public void a(View r4) {
            this.f1453b = false;
            af r1 = null;
            if (this.f1452a.f1450c <= (-1)) goto L6;
            r4.setLayerType(2, null);
        L6:
            if (this.f1452a.f1448a == null) goto L8;
            Runnable r0 = this.f1452a.f1448a;
            this.f1452a.f1448a = null;
            r0.run();
        L8:
            Object r3 = r4.getTag(2113929216);
            if (ZeusTransformUtils.instanceOf(r3, af.class) == false) goto L11;
            r1 = (af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.aiagent.plugin");
        L11:
            if (r1 == null) goto L14;
            r1.a(r4);
            return;
        }

        @Override // androidx.core.view.af
        public void b(View r4) {
            af r2 = null;
            if (this.f1452a.f1450c <= (-1)) goto L6;
            r4.setLayerType(this.f1452a.f1450c, null);
            this.f1452a.f1450c = -1;
        L6:
            if (Build.VERSION.SDK_INT >= 16) goto L10;
            if (this.f1453b == false) goto L10;
            return;
        L10:
            if (this.f1452a.f1449b == null) goto L12;
            Runnable r0 = this.f1452a.f1449b;
            this.f1452a.f1449b = null;
            r0.run();
        L12:
            Object r1 = r4.getTag(2113929216);
            if (ZeusTransformUtils.instanceOf(r1, af.class) == false) goto L15;
            r2 = (af) ZeusTransformUtils.preCheckCast(r1, af.class, "com.obric.aiagent.plugin");
        L15:
            if (r2 == null) goto L17;
            r2.b(r4);
        L17:
            this.f1453b = true;
        }

        @Override // androidx.core.view.af
        public void c(View r3) {
            Object r2 = r3.getTag(2113929216);
            if (ZeusTransformUtils.instanceOf(r2, af.class) == false) goto L5;
            af r4 = (af) ZeusTransformUtils.preCheckCast(r2, af.class, "com.obric.aiagent.plugin");
        L6:
            if (r4 == null) goto L9;
            r4.c(r3);
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static /* synthetic */ void lambda$czEy8glpFFuo4NfaTKrECkVxSao(ah r0, View r1, ValueAnimator r2) {
        a(r0, r1, r2);
    }

    ae(View r2) {
        this.f1448a = null;
        this.f1449b = null;
        this.f1450c = -1;
        this.f1451d = new WeakReference(r2);
    }

    public ae a(long r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.animate().setDuration(r4);
    L5:
        return this;
    }

    public ae a(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.animate().alpha(r4);
    L5:
        return this;
    }

    public ae b(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.animate().translationY(r4);
    L5:
        return this;
    }

    public long a() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.animate().getDuration();
    }

    public ae a(Interpolator r4) {
        Interpolator r5 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.aiagent.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.animate().setInterpolator(r5);
    L5:
        return this;
    }

    public ae b(long r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.animate().setStartDelay(r4);
    L5:
        return this;
    }

    public void b() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.animate().cancel();
        return;
    }

    public void c() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.animate().start();
        return;
    }

    public ae a(af r4) {
        af r5 = (af) ZeusTransformUtils.wrapperContextForParams(r4, af.class, "com.obric.aiagent.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        a(r0, r5);
        goto L8
    L7:
        r0.setTag(2113929216, r5);
        a(r0, new b(this));
        goto L8
    }

    private void a(final View r3, af r4) {
        final af r5 = (af) ZeusTransformUtils.wrapperContextForParams(r4, af.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        r3.animate().setListener(new ViewPropertyAnimatorCompat$1(this, r5, r3));
        return;
    L5:
        r3.animate().setListener(null);
    }

    public ae a(ah r4) {
        final ah r5 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.aiagent.plugin");
        final View r0 = (View) ZeusTransformUtils.preCheckCast(this.f1451d.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L10:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        ValueAnimator.AnimatorUpdateListener r1 = null;
        if (r5 == null) goto L9;
        r1 = new $$Lambda$ae$czEy8glpFFuo4NfaTKrECkVxSao(r5, r0);
    L9:
        a.a(r0.animate(), r1);
        goto L10
    }

    private static /* synthetic */ void a(ah r1, View r2, ValueAnimator r3) {
        ((ah) ZeusTransformUtils.wrapperContextForParams(r1, ah.class, "com.obric.aiagent.plugin")).a(r2);
    }
}
