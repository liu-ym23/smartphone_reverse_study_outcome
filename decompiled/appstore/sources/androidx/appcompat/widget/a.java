package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0007a f958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.core.view.r f963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f965h;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0007a implements ViewPropertyAnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f968c;

        public C0007a(a r10) {
            this.f968c = r10;
            this.f966a = false;
        }

        public C0007a a(androidx.core.view.r r10, int r11) {
            this.f968c.f963f = r10;
            this.f967b = r11;
            return this;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r10) {
            this.f966a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r10) {
            if (this.f966a == false) goto L5;
            return;
        L5:
            a r11 = this.f968c;
            r11.f963f = null;
            a.b(r11, this.f967b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r10) {
            a.a(this.f968c, 0);
            this.f966a = false;
        }
    }

    public a(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f958a = new C0007a(this);
        TypedValue r13 = new TypedValue();
        if (r10.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, r13, true) == true) goto L5;
    L7:
        this.f959b = r10;
        return;
    L5:
        if (r13.resourceId == 0) goto L7;
        this.f959b = new ContextThemeWrapper(r10, r13.resourceId);
    }

    public static /* synthetic */ void a(a r10, int r11) {
        super.setVisibility(r11);
    }

    public static /* synthetic */ void b(a r10, int r11) {
        super.setVisibility(r11);
    }

    public static int d(int r10, int r11, boolean r12) {
        if (r12 == false) goto L5;
        return r10 - r11;
    L5:
        return r10 + r11;
    }

    public int c(View r10, int r11, int r12, int r13) {
        r10.measure(View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE), r12);
        return Math.max(0, (r11 - r10.getMeasuredWidth()) - r13);
    }

    public int e(View r10, int r11, int r12, int r13, boolean r14) {
        int r15 = r10.getMeasuredWidth();
        int r16 = r10.getMeasuredHeight();
        int r17 = r12 + ((r13 - r16) / 2);
        if (r14 == false) goto L5;
        r10.layout(r11 - r15, r17, r11, r16 + r17);
    L6:
        if (r14 == true) goto L8;
        return r15;
    L8:
        return -r15;
    L5:
        r10.layout(r11, r17, r11 + r15, r16 + r17);
        goto L6
    }

    public androidx.core.view.r f(int r10, long r11) {
        androidx.core.view.r r12 = this.f963f;
        if (r12 == null) goto L6;
        r12.c();
    L6:
        if (r10 == 0) goto L8;
        androidx.core.view.r r13 = ViewCompat.e(this).b(0.0f);
        r13.f(r11);
        r13.h(this.f958a.a(r13, r10));
        return r13;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        androidx.core.view.r r14 = ViewCompat.e(this).b(1.0f);
        r14.f(r11);
        r14.h(this.f958a.a(r14, r10));
        return r14;
    }

    public int getAnimatedVisibility() {
        if (this.f963f == null) goto L7;
        return this.f958a.f967b;
    L7:
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f962e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        TypedArray r11 = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(r11.getLayoutDimension(R$styleable.ActionBar_height, 0));
        r11.recycle();
        ActionMenuPresenter r12 = this.f961d;
        if (r12 == null) goto L6;
        r12.w(r10);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 9) goto L6;
        this.f965h = false;
    L6:
        if (this.f965h == true) goto L12;
        boolean r12 = super.onHoverEvent(r10);
        if (r11 != 9) goto L12;
        if (r12 == true) goto L12;
        this.f965h = true;
    L12:
        if (r11 != 10) goto L14;
    L15:
        this.f965h = false;
    L16:
        return true;
    L14:
        if (r11 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L6;
        this.f964g = false;
    L6:
        if (this.f964g == true) goto L11;
        boolean r12 = super.onTouchEvent(r10);
        if (r11 != 0) goto L11;
        if (r12 == true) goto L11;
        this.f964g = true;
    L11:
        if (r11 != 1) goto L13;
    L14:
        this.f964g = false;
    L15:
        return true;
    L13:
        if (r11 != 3) goto L15;
        goto L14
    }

    public abstract void setContentHeight(int r10);

    @Override // android.view.View
    public void setVisibility(int r10) {
        if (r10 == getVisibility()) goto L9;
        androidx.core.view.r r11 = this.f963f;
        if (r11 == null) goto L7;
        r11.c();
    L7:
        super.setVisibility(r10);
        return;
    }
}
