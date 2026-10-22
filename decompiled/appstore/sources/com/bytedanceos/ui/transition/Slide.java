package com.bytedanceos.ui.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Slide extends Visibility {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f10237e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TimeInterpolator f10238f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TimeInterpolator f10239g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CalculateSlide f10240h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CalculateSlide f10241i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CalculateSlide f10242j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CalculateSlide f10243k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CalculateSlide f10244l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CalculateSlide f10245m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CalculateSlide f10246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f10248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Listener f10249d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedanceos/ui/transition/Slide$CalculateSlide;", "", "getGoneX", "", "sceneRoot", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "fraction", "getGoneY", "resource_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface CalculateSlide {
        float getGoneX(@NotNull ViewGroup r10, @NotNull View r11, float r12);

        float getGoneY(@NotNull ViewGroup r10, @NotNull View r11, float r12);
    }

    @Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedanceos/ui/transition/Slide$GravityFlag;", "", "resource_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface GravityFlag {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedanceos/ui/transition/Slide$Listener;", "", "onPreAppear", "", "sceneRoot", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "startValues", "Landroid/transition/TransitionValues;", "endValues", "onPreDisappear", "resource_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onPreAppear(@NotNull ViewGroup r10, @NotNull View r11, @Nullable TransitionValues r12, @Nullable TransitionValues r13);

        void onPreDisappear(@NotNull ViewGroup r10, @NotNull View r11, @Nullable TransitionValues r12, @Nullable TransitionValues r13);
    }

    public static abstract class a implements CalculateSlide {
        public a() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            return r11.getTranslationY();
        }
    }

    public static abstract class b implements CalculateSlide {
        public b() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            return r11.getTranslationX();
        }
    }

    public static final class c extends b {
        public c() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            return r11.getTranslationY() + (r10.getHeight() * r12);
        }
    }

    public static final class d extends a {
        public d() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            if (r10.getLayoutDirection() != 1) goto L6;
            return r11.getTranslationX() - (r10.getWidth() * r12);
        L6:
            return r11.getTranslationX() + (r10.getWidth() * r12);
        }
    }

    public static final class e extends a {
        public e() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            return r11.getTranslationX() - (r10.getWidth() * r12);
        }
    }

    public static final class f extends a {
        public f() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            return r11.getTranslationX() + (r10.getWidth() * r12);
        }
    }

    public static final class g extends a {
        public g() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            if (r10.getLayoutDirection() != 1) goto L6;
            return r11.getTranslationX() + (r10.getWidth() * r12);
        L6:
            return r11.getTranslationX() - (r10.getWidth() * r12);
        }
    }

    public static final class h extends b {
        public h() {
        }

        @Override // com.bytedanceos.ui.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r10, View r11, float r12) {
            q.g(r10, "sceneRoot");
            q.g(r11, "view");
            return r11.getTranslationY() - (r10.getHeight() * r12);
        }
    }

    public static final class i {
        public /* synthetic */ i(DefaultConstructorMarker r10) {
            this();
        }

        public i() {
        }
    }

    static {
        f10237e = new i(null);
        f10238f = new LinearInterpolator();
        f10239g = new LinearInterpolator();
        f10240h = new e();
        f10241i = new g();
        f10242j = new h();
        f10243k = new f();
        f10244l = new d();
        f10245m = new c();
    }

    public Slide(int r10) {
        this.f10246a = f10245m;
        this.f10247b = 80;
        this.f10248c = 1.0f;
        a(r10);
    }

    public final void a(int r10) {
        if (r10 != 3) goto L5;
        CalculateSlide r11 = f10240h;
    L22:
        this.f10246a = r11;
        this.f10247b = r10;
        com.bytedanceos.ui.transition.a r12 = new com.bytedanceos.ui.transition.a();
        r12.setSide(r10);
        setPropagation(r12);
        return;
    L5:
        if (r10 != 5) goto L7;
        r11 = f10243k;
        goto L22
    L7:
        if (r10 != 48) goto L9;
        r11 = f10242j;
        goto L22
    L9:
        if (r10 != 80) goto L11;
        r11 = f10245m;
        goto L22
    L11:
        if (r10 != 8388611) goto L13;
        r11 = f10241i;
        goto L22
    L13:
        if (r10 != 8388613) goto L16;
        r11 = f10244l;
        goto L22
    L16:
        throw new IllegalArgumentException("Invalid slide direction");
    }

    public final void b(float r10) {
        this.f10248c = r10;
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues r10) {
        q.g(r10, "transitionValues");
        super.captureEndValues(r10);
        captureValues(r10);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues r10) {
        q.g(r10, "transitionValues");
        super.captureStartValues(r10);
        captureValues(r10);
    }

    public final void captureValues(TransitionValues r10) {
        View r11 = r10.view;
        q.f(r11, "view");
        int[] r12 = new int[2];
        r11.getLocationOnScreen(r12);
        Map r13 = r10.values;
        q.f(r13, "values");
        r13.put("android:slide:screenPosition", r12);
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup r12, View r13, TransitionValues r14, TransitionValues r15) {
        q.g(r12, "sceneRoot");
        q.g(r13, "view");
        if (r15 != null) goto L6;
        return null;
    L6:
        Listener r10 = this.f10249d;
        if (r10 == null) goto L9;
        r10.onPreAppear(r12, r13, r14, r15);
    L9:
        Object r16 = r15.values.get("android:slide:screenPosition");
        q.e(r16, "null cannot be cast to non-null type kotlin.IntArray");
        int[] r17 = (int[]) r16;
        float r11 = r13.getTranslationX();
        float r18 = r13.getTranslationY();
        float r19 = this.f10246a.getGoneX(r12, r13, this.f10248c);
        float r20 = this.f10246a.getGoneY(r12, r13, this.f10248c);
        return com.bytedanceos.ui.transition.b.f10250a.a(r13, r15, r17[0], r17[1], r19, r20, r11, r18, f10238f, this);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup r12, View r13, TransitionValues r14, TransitionValues r15) {
        q.g(r12, "sceneRoot");
        q.g(r13, "view");
        if (r14 != null) goto L6;
        return null;
    L6:
        Listener r10 = this.f10249d;
        if (r10 == null) goto L9;
        r10.onPreDisappear(r12, r13, r14, r15);
    L9:
        Object r16 = r14.values.get("android:slide:screenPosition");
        q.e(r16, "null cannot be cast to non-null type kotlin.IntArray");
        int[] r17 = (int[]) r16;
        float r11 = r13.getTranslationX();
        float r18 = r13.getTranslationY();
        float r19 = this.f10246a.getGoneX(r12, r13, this.f10248c);
        float r20 = this.f10246a.getGoneY(r12, r13, this.f10248c);
        return com.bytedanceos.ui.transition.b.f10250a.a(r13, r14, r17[0], r17[1], r11, r18, r19, r20, f10239g, this);
    }
}
