package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class Slide extends Visibility {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f4984c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f4985d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CalculateSlide f4986e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CalculateSlide f4987f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CalculateSlide f4988g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CalculateSlide f4989h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CalculateSlide f4990i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CalculateSlide f4991j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CalculateSlide f4992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4993b;

    public interface CalculateSlide {
        float getGoneX(ViewGroup r10, View r11);

        float getGoneY(ViewGroup r10, View r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GravityFlag {
    }

    public class a extends g {
        public a() {
            super(null);
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11) {
            return r11.getTranslationX() - r10.getWidth();
        }
    }

    public class b extends g {
        public b() {
            super(null);
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11) {
            if (ViewCompat.A(r10) != 1) goto L6;
            return r11.getTranslationX() + r10.getWidth();
        L6:
            return r11.getTranslationX() - r10.getWidth();
        }
    }

    public class c extends h {
        public c() {
            super(null);
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r10, View r11) {
            return r11.getTranslationY() - r10.getHeight();
        }
    }

    public class d extends g {
        public d() {
            super(null);
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11) {
            return r11.getTranslationX() + r10.getWidth();
        }
    }

    public class e extends g {
        public e() {
            super(null);
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11) {
            if (ViewCompat.A(r10) != 1) goto L6;
            return r11.getTranslationX() - r10.getWidth();
        L6:
            return r11.getTranslationX() + r10.getWidth();
        }
    }

    public class f extends h {
        public f() {
            super(null);
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r10, View r11) {
            return r11.getTranslationY() + r10.getHeight();
        }
    }

    public static abstract class g implements CalculateSlide {
        public g() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r10, View r11) {
            return r11.getTranslationY();
        }

        public /* synthetic */ g(a r10) {
            this();
        }
    }

    public static abstract class h implements CalculateSlide {
        public h() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11) {
            return r11.getTranslationX();
        }

        public /* synthetic */ h(a r10) {
            this();
        }
    }

    static {
        f4984c = new DecelerateInterpolator();
        f4985d = new AccelerateInterpolator();
        f4986e = new a();
        f4987f = new b();
        f4988g = new c();
        f4989h = new d();
        f4990i = new e();
        f4991j = new f();
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        this.f4992a = f4991j;
        this.f4993b = 80;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f5001h);
        int r13 = n.g.c(r12, (XmlPullParser) r11, "slideEdge", 0, 80);
        r12.recycle();
        t(r13);
    }

    private void captureValues(s r10) {
        int[] r11 = new int[2];
        r10.f5086b.getLocationOnScreen(r11);
        r10.f5085a.put("android:slide:screenPosition", r11);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(s r10) {
        super.captureEndValues(r10);
        captureValues(r10);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(s r10) {
        super.captureStartValues(r10);
        captureValues(r10);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r11, View r12, s r13, s r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        int[] r15 = (int[]) r14.f5085a.get("android:slide:screenPosition");
        float r10 = r12.getTranslationX();
        float r16 = r12.getTranslationY();
        float r17 = this.f4992a.getGoneX(r11, r12);
        float r18 = this.f4992a.getGoneY(r11, r12);
        return u.a(r12, r14, r15[0], r15[1], r17, r18, r10, r16, f4984c, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r11, View r12, s r13, s r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        int[] r15 = (int[]) r13.f5085a.get("android:slide:screenPosition");
        float r10 = r12.getTranslationX();
        float r16 = r12.getTranslationY();
        float r17 = this.f4992a.getGoneX(r11, r12);
        float r18 = this.f4992a.getGoneY(r11, r12);
        return u.a(r12, r13, r15[0], r15[1], r10, r16, r17, r18, f4985d, this);
    }

    public void t(int r10) {
        if (r10 != 3) goto L5;
        this.f4992a = f4986e;
    L22:
        this.f4993b = r10;
        n r11 = new n();
        r11.j(r10);
        setPropagation(r11);
        return;
    L5:
        if (r10 != 5) goto L7;
        this.f4992a = f4989h;
        goto L22
    L7:
        if (r10 != 48) goto L9;
        this.f4992a = f4988g;
        goto L22
    L9:
        if (r10 != 80) goto L11;
        this.f4992a = f4991j;
        goto L22
    L11:
        if (r10 != 8388611) goto L13;
        this.f4992a = f4987f;
        goto L22
    L13:
        if (r10 != 8388613) goto L16;
        this.f4992a = f4990i;
        goto L22
    L16:
        throw new IllegalArgumentException("Invalid slide direction");
    }
}
