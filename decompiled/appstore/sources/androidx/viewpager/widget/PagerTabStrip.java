package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public boolean A;
    public int B;
    public boolean C;
    public float D;
    public float E;
    public int F;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5110q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5111r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5112s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f5113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Paint f5116w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f5117x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f5118y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5119z;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagerTabStrip f5120a;

        public a(PagerTabStrip r10) {
            this.f5120a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            ViewPager r11 = this.f5120a.f5124a;
            r11.setCurrentItem(r11.getCurrentItem() - 1);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagerTabStrip f5121a;

        public b(PagerTabStrip r10) {
            this.f5121a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            ViewPager r11 = this.f5121a.f5124a;
            r11.setCurrentItem(r11.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(@NonNull Context r10) {
        this(r10, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void d(int r10, float r11, boolean r12) {
        Rect r13 = this.f5117x;
        int r14 = getHeight();
        int r15 = this.f5126c.getLeft() - this.f5115v;
        int r16 = this.f5126c.getRight() + this.f5115v;
        int r17 = r14 - this.f5111r;
        r13.set(r15, r17, r16, r14);
        super.d(r10, r11, r12);
        this.f5118y = (int) ((Math.abs(r11 - 0.5f) * 2.0f) * 255.0f);
        r13.union(this.f5126c.getLeft() - this.f5115v, r17, this.f5126c.getRight() + this.f5115v, r14);
        invalidate(r13);
    }

    public boolean getDrawFullUnderline() {
        return this.f5119z;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f5114u);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.f5110q;
    }

    @Override // android.view.View
    public void onDraw(Canvas r15) {
        super.onDraw(r15);
        int r10 = getHeight();
        int r11 = this.f5126c.getLeft() - this.f5115v;
        int r12 = this.f5126c.getRight() + this.f5115v;
        int r13 = r10 - this.f5111r;
        this.f5116w.setColor((this.f5118y << 24) | (this.f5110q & 16777215));
        float r14 = r10;
        r15.drawRect(r11, r13, r12, r14, this.f5116w);
        if (this.f5119z == false) goto L6;
        this.f5116w.setColor((this.f5110q & 16777215) | (-16777216));
        r15.drawRect(getPaddingLeft(), r10 - this.B, getWidth() - getPaddingRight(), r14, this.f5116w);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
    L7:
        float r12 = r10.getX();
        float r13 = r10.getY();
        if (r11 == 0) goto L24;
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L14;
    L25:
        return true;
    L14:
        if (Math.abs(r12 - this.D) <= this.F) goto L16;
    L17:
        this.C = true;
        goto L25
    L16:
        if (Math.abs(r13 - this.E) <= this.F) goto L25;
    L19:
        if (r12 >= (this.f5126c.getLeft() - this.f5115v)) goto L22;
        ViewPager r14 = this.f5124a;
        r14.setCurrentItem(r14.getCurrentItem() - 1);
        goto L25
    L22:
        if (r12 <= (this.f5126c.getRight() + this.f5115v)) goto L25;
        ViewPager r15 = this.f5124a;
        r15.setCurrentItem(r15.getCurrentItem() + 1);
        goto L25
    L24:
        this.D = r12;
        this.E = r13;
        this.C = false;
        goto L25
    L5:
        if (this.C == false) goto L7;
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r10) {
        super.setBackgroundColor(r10);
        if (this.A == false) goto L5;
        return;
    L5:
        if ((r10 & (-16777216)) != 0) goto L7;
        boolean r11 = true;
    L8:
        this.f5119z = r11;
        return;
    L7:
        r11 = false;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r10) {
        super.setBackgroundDrawable(r10);
        if (this.A == true) goto L9;
        if (r10 != null) goto L6;
        boolean r11 = true;
    L7:
        this.f5119z = r11;
        return;
    L6:
        r11 = false;
        goto L7
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        if (this.A == true) goto L9;
        if (r10 != 0) goto L6;
        boolean r11 = true;
    L7:
        this.f5119z = r11;
        return;
    L6:
        r11 = false;
        goto L7
    }

    public void setDrawFullUnderline(boolean r10) {
        this.f5119z = r10;
        this.A = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        int r14 = this.f5112s;
        if (r13 >= r14) goto L5;
        r13 = r14;
    L5:
        super.setPadding(r10, r11, r12, r13);
    }

    public void setTabIndicatorColor(@ColorInt int r10) {
        this.f5110q = r10;
        this.f5116w.setColor(r10);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int r10) {
        setTabIndicatorColor(ContextCompat.b(getContext(), r10));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int r10) {
        int r11 = this.f5113t;
        if (r10 >= r11) goto L5;
        r10 = r11;
    L5:
        super.setTextSpacing(r10);
    }

    public PagerTabStrip(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        Paint r12 = new Paint();
        this.f5116w = r12;
        this.f5117x = new Rect();
        this.f5118y = PrivateKeyType.INVALID;
        this.f5119z = false;
        this.A = false;
        int r13 = this.f5137n;
        this.f5110q = r13;
        r12.setColor(r13);
        float r14 = r10.getResources().getDisplayMetrics().density;
        this.f5111r = (int) ((3.0f * r14) + 0.5f);
        this.f5112s = (int) ((6.0f * r14) + 0.5f);
        this.f5113t = (int) (64.0f * r14);
        this.f5115v = (int) ((16.0f * r14) + 0.5f);
        this.B = (int) ((1.0f * r14) + 0.5f);
        this.f5114u = (int) ((r14 * 32.0f) + 0.5f);
        this.F = ViewConfiguration.get(r10).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f5125b.setFocusable(true);
        this.f5125b.setOnClickListener(new a(this));
        this.f5127d.setFocusable(true);
        this.f5127d.setOnClickListener(new b(this));
        if (getBackground() != null) goto L6;
        this.f5119z = true;
        return;
    }
}
