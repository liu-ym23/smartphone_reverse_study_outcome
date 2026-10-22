package com.obric.oui.animation.easy;

import android.view.View;
import com.obric.oui.animation.engine.DynamicAnimation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewPropertySpringAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f12267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f12269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f12270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f12271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorListener f12272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DynamicAnimation.OnAnimationUpdateListener f12273g;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator$AnimatorListener;", "T", "Landroid/view/View;", "", "onAnimationCancel", "", "animator", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "onAnimationEnd", "onAnimationStart", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AnimatorListener<T extends View> {
        void onAnimationCancel(@NotNull ViewPropertySpringAnimator r10);

        void onAnimationEnd(@NotNull ViewPropertySpringAnimator r10);

        void onAnimationStart(@NotNull ViewPropertySpringAnimator r10);
    }

    public static final class a implements DynamicAnimation.OnAnimationEndListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPropertySpringAnimator f12274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.obric.oui.animation.engine.a f12275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f12276c;

        public a(ViewPropertySpringAnimator r10, com.obric.oui.animation.engine.a r11, b r12) {
            this.f12274a = r10;
            this.f12275b = r11;
            this.f12276c = r12;
        }

        @Override // com.obric.oui.animation.engine.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation r10, boolean r11, float r12, float r13) {
            ViewPropertySpringAnimator.b(this.f12274a).remove(this.f12275b);
            if (r10 == null) goto L6;
            r10.removeEndListener(this);
        L6:
            if (r10 == null) goto L9;
            r10.removeUpdateListener(this.f12276c);
        L9:
            ViewPropertySpringAnimator.d(this.f12274a, null);
            if (ViewPropertySpringAnimator.b(this.f12274a).isEmpty() == false) goto L17;
            if (r11 == true) goto L18;
            AnimatorListener r14 = ViewPropertySpringAnimator.a(this.f12274a);
            if (r14 == null) goto L19;
            r14.onAnimationEnd(this.f12274a);
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    public static final class b implements DynamicAnimation.OnAnimationUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPropertySpringAnimator f12277a;

        public b(ViewPropertySpringAnimator r10) {
            this.f12277a = r10;
        }

        @Override // com.obric.oui.animation.engine.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation r10, float r11, float r12) {
            DynamicAnimation.OnAnimationUpdateListener r13 = ViewPropertySpringAnimator.c(this.f12277a);
            if (r13 == null) goto L7;
            r13.onAnimationUpdate(r10, r11, r12);
            return;
        }
    }

    public static final class c implements AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f12278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f12279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f12280c;

        public c(Function1 r10, Function1 r11, Function1 r12) {
            this.f12278a = r10;
            this.f12279b = r11;
            this.f12280c = r12;
        }

        @Override // com.obric.oui.animation.easy.ViewPropertySpringAnimator.AnimatorListener
        public void onAnimationCancel(ViewPropertySpringAnimator r10) {
            q.g(r10, "animator");
            this.f12279b.invoke(r10);
        }

        @Override // com.obric.oui.animation.easy.ViewPropertySpringAnimator.AnimatorListener
        public void onAnimationEnd(ViewPropertySpringAnimator r10) {
            q.g(r10, "animator");
            this.f12280c.invoke(r10);
        }

        @Override // com.obric.oui.animation.easy.ViewPropertySpringAnimator.AnimatorListener
        public void onAnimationStart(ViewPropertySpringAnimator r10) {
            q.g(r10, "animator");
            this.f12278a.invoke(r10);
        }
    }

    public ViewPropertySpringAnimator(View r10) {
        q.g(r10, "view");
        this.f12267a = r10;
        this.f12268b = new ArrayList();
        this.f12269c = new LinkedHashMap();
        this.f12270d = 0.5f;
        this.f12271e = 1500.0f;
    }

    public static final /* synthetic */ AnimatorListener a(ViewPropertySpringAnimator r10) {
        return r10.f12272f;
    }

    public static final /* synthetic */ Map b(ViewPropertySpringAnimator r10) {
        return r10.f12269c;
    }

    public static final /* synthetic */ DynamicAnimation.OnAnimationUpdateListener c(ViewPropertySpringAnimator r10) {
        return r10.f12273g;
    }

    public static final /* synthetic */ void d(ViewPropertySpringAnimator r10, DynamicAnimation.OnAnimationUpdateListener r11) {
        r10.f12273g = r11;
    }

    public static /* synthetic */ ViewPropertySpringAnimator f(ViewPropertySpringAnimator r10, com.obric.oui.animation.engine.a r11, float r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = ViewPropertySpringAnimator$animateProperty$2.INSTANCE;
    L6:
        return r10.e(r11, r12, r13);
    }

    public static /* synthetic */ ViewPropertySpringAnimator o(ViewPropertySpringAnimator r10, Function1 r11, Function1 r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = ViewPropertySpringAnimator$setListener$1.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = ViewPropertySpringAnimator$setListener$2.INSTANCE;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = ViewPropertySpringAnimator$setListener$3.INSTANCE;
    L12:
        return r10.n(r11, r12, r13);
    }

    public final ViewPropertySpringAnimator e(com.obric.oui.animation.engine.a r10, float r11, Function1 r12) {
        q.g(r10, "property");
        q.g(r12, "config");
        g(r10, r11, r12);
        return this;
    }

    public final void g(com.obric.oui.animation.engine.a r10, float r11, Function1 r12) {
        com.obric.oui.animation.engine.b r13 = (com.obric.oui.animation.engine.b) this.f12269c.get(r10);
        if (r13 != null) goto L5;
        r13 = new com.obric.oui.animation.engine.b(this.f12267a, r10);
        i(r13, r10);
        this.f12269c.put(r10, r13);
    L5:
        com.obric.oui.animation.easy.a r14 = new com.obric.oui.animation.easy.a(r11);
        r12.invoke(r14);
        r14.e(this.f12270d);
        r14.f(this.f12271e);
        this.f12268b.add(new k9.a(r13, r14));
    }

    public final void h() {
        this.f12268b.clear();
        List r10 = b0.x0(this.f12269c.values());
        this.f12269c.clear();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((com.obric.oui.animation.engine.b) r11.next()).c();
        goto L4
    L6:
        AnimatorListener r12 = this.f12272f;
        if (r12 == null) goto L12;
        r12.onAnimationCancel(this);
        return;
    }

    public final void i(com.obric.oui.animation.engine.b r10, com.obric.oui.animation.engine.a r11) {
        b r12 = new b(this);
        r10.b(r12);
        r10.a(new a(this, r11, r12));
    }

    public final ViewPropertySpringAnimator j(float r10) {
        this.f12270d = r10;
        return this;
    }

    public final ViewPropertySpringAnimator k(float r10) {
        this.f12271e = r10;
        return this;
    }

    public final boolean l() {
        Collection r10 = this.f12269c.values();
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (((com.obric.oui.animation.engine.b) r11.next()).g() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return false;
    }

    public final ViewPropertySpringAnimator m(AnimatorListener r10) {
        this.f12272f = r10;
        return this;
    }

    public final ViewPropertySpringAnimator n(Function1 r10, Function1 r11, Function1 r12) {
        q.g(r10, "onStart");
        q.g(r11, "onCancel");
        q.g(r12, "onEnd");
        return m(new c(r10, r11, r12));
    }

    public final void p() {
        this.f12268b.clear();
        List r10 = b0.x0(this.f12269c.values());
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((com.obric.oui.animation.engine.b) r13).r() == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        Iterator r14 = r11.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        ((com.obric.oui.animation.engine.b) r14.next()).w();
        goto L10
    }

    public final ViewPropertySpringAnimator q() {
        if (this.f12268b.isEmpty() == true) goto L13;
        List r10 = b0.x0(this.f12268b);
        this.f12268b.clear();
        AnimatorListener r11 = this.f12272f;
        if (r11 == null) goto L9;
        r11.onAnimationStart(this);
    L9:
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        ((k9.a) r12.next()).a();
    L13:
        return this;
    }

    public final ViewPropertySpringAnimator r(float r10, Function1 r11) {
        q.g(r11, "config");
        DynamicAnimation.p r12 = DynamicAnimation.f12313n;
        q.f(r12, "TRANSLATION_Y");
        return e(r12, r10, r11);
    }

    public final void removeEndListener(@NotNull DynamicAnimation.OnAnimationEndListener r10) {
        q.g(r10, "listener");
        Iterator r11 = this.f12269c.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((com.obric.oui.animation.engine.b) ((Map.Entry) r11.next()).getValue()).removeEndListener(r10);
        goto L4
    }

    public final void removeUpdateListener(@NotNull DynamicAnimation.OnAnimationUpdateListener r10) {
        q.g(r10, "listener");
        Iterator r11 = this.f12269c.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((com.obric.oui.animation.engine.b) ((Map.Entry) r11.next()).getValue()).removeUpdateListener(r10);
        goto L4
    }

    public final void setUpdateListener(@NotNull DynamicAnimation.OnAnimationUpdateListener r10) {
        q.g(r10, "listener");
        this.f12273g = r10;
    }
}
