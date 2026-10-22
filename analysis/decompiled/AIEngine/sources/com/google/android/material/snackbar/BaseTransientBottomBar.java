package com.google.android.material.snackbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.m;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.stepos.aiengine.R;
import y4.g;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5168a = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: l, reason: collision with root package name */
        public final b f5169l;

        public Behavior() {
            b bVar = new b();
            this.h = Math.min(Math.max(0.0f, 0.1f), 1.0f);
            this.f4635j = Math.min(Math.max(0.0f, 0.6f), 1.0f);
            this.f4633d = 0;
            this.f5169l = bVar;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public final boolean g(View view) {
            this.f5169l.getClass();
            return view instanceof c;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f5169l.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    synchronized (z4.b.a().f14259a) {
                    }
                }
            } else if (coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                synchronized (z4.b.a().f14259a) {
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                ((BaseTransientBottomBar) message.obj).getClass();
                throw null;
            }
            if (i10 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).getClass();
            throw null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends FrameLayout {

        /* renamed from: m, reason: collision with root package name */
        public static final a f5170m = new a();

        /* renamed from: a, reason: collision with root package name */
        public BaseTransientBottomBar<?> f5171a;

        /* renamed from: b, reason: collision with root package name */
        public final j f5172b;

        /* renamed from: c, reason: collision with root package name */
        public int f5173c;

        /* renamed from: d, reason: collision with root package name */
        public final float f5174d;

        /* renamed from: e, reason: collision with root package name */
        public final float f5175e;
        public final int h;

        /* renamed from: j, reason: collision with root package name */
        public final int f5176j;

        /* renamed from: k, reason: collision with root package name */
        public ColorStateList f5177k;

        /* renamed from: l, reason: collision with root package name */
        public PorterDuff.Mode f5178l;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
            GradientDrawable gradientDrawable;
            super(b5.a.a(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, k4.a.F);
            if (typedArrayObtainStyledAttributes.hasValue(6)) {
                setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
            }
            this.f5173c = typedArrayObtainStyledAttributes.getInt(2, 0);
            if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
                this.f5172b = j.b(context2, attributeSet, 0, 0).a();
            }
            this.f5174d = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
            setBackgroundTintList(w4.c.a(context2, typedArrayObtainStyledAttributes, 4));
            setBackgroundTintMode(m.b(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
            this.f5175e = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
            this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.f5176j = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f5170m);
            setFocusable(true);
            if (getBackground() == null) {
                int iC = jd.b.C(getBackgroundOverlayColorAlpha(), jd.b.s(R.attr.colorSurface, this), jd.b.s(R.attr.colorOnSurface, this));
                j jVar = this.f5172b;
                if (jVar != null) {
                    int i10 = BaseTransientBottomBar.f5168a;
                    g gVar = new g(jVar);
                    gVar.n(ColorStateList.valueOf(iC));
                    gradientDrawable = gVar;
                } else {
                    Resources resources = getResources();
                    int i11 = BaseTransientBottomBar.f5168a;
                    float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(0);
                    gradientDrawable2.setCornerRadius(dimension);
                    gradientDrawable2.setColor(iC);
                    gradientDrawable = gradientDrawable2;
                }
                ColorStateList colorStateList = this.f5177k;
                if (colorStateList != null) {
                    gradientDrawable.setTintList(colorStateList);
                }
                setBackground(gradientDrawable);
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f5171a = baseTransientBottomBar;
        }

        public float getActionTextColorAlpha() {
            return this.f5175e;
        }

        public int getAnimationMode() {
            return this.f5173c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f5174d;
        }

        public int getMaxInlineActionWidth() {
            return this.f5176j;
        }

        public int getMaxWidth() {
            return this.h;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f5171a;
            if (baseTransientBottomBar == null) {
                requestApplyInsets();
            } else {
                baseTransientBottomBar.getClass();
                throw null;
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f5171a != null) {
                synchronized (z4.b.a().f14259a) {
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
            super.onLayout(z, i10, i11, i12, i13);
            if (this.f5171a != null) {
                throw null;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int i12 = this.h;
            if (i12 <= 0 || getMeasuredWidth() <= i12) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
        }

        public void setAnimationMode(int i10) {
            this.f5173c = i10;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f5177k != null) {
                drawable = drawable.mutate();
                drawable.setTintList(this.f5177k);
                drawable.setTintMode(this.f5178l);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f5177k = colorStateList;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintList(colorStateList);
                drawableMutate.setTintMode(this.f5178l);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f5178l = mode;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintMode(mode);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                if (this.f5171a == null) {
                    return;
                }
                int i10 = BaseTransientBottomBar.f5168a;
                throw null;
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f5170m);
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        LinearInterpolator linearInterpolator = l4.a.f10220a;
        new Handler(Looper.getMainLooper(), new a());
    }
}
