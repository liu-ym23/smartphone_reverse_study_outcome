package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f5122o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f5123p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f5125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f5126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f5127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f5134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference f5135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5137n;

    public class a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PagerTitleStrip f5139b;

        public a(PagerTitleStrip r10) {
            this.f5139b = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r10, PagerAdapter r11, PagerAdapter r12) {
            this.f5139b.b(r11, r12);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip r10 = this.f5139b;
            r10.c(r10.f5124a.getCurrentItem(), this.f5139b.f5124a.getAdapter());
            PagerTitleStrip r11 = this.f5139b;
            float r12 = r11.f5129f;
            if (r12 >= 0.0f) goto L6;
            r12 = 0.0f;
        L6:
            r11.d(r11.f5124a.getCurrentItem(), r12, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
            this.f5138a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
            if (r11 <= 0.5f) goto L5;
            r10 = r10 + 1;
        L5:
            this.f5139b.d(r10, r11, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            if (this.f5138a != 0) goto L10;
            PagerTitleStrip r11 = this.f5139b;
            r11.c(r11.f5124a.getCurrentItem(), this.f5139b.f5124a.getAdapter());
            PagerTitleStrip r12 = this.f5139b;
            float r13 = r12.f5129f;
            if (r13 >= 0.0f) goto L8;
            r13 = 0.0f;
        L8:
            r12.d(r12.f5124a.getCurrentItem(), r13, true);
            return;
        }
    }

    public static class b extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Locale f5140a;

        public b(Context r10) {
            this.f5140a = r10.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence r10, View r11) {
            CharSequence r12 = super.getTransformation(r10, r11);
            if (r12 != null) goto L7;
            return null;
        L7:
            return r12.toString().toUpperCase(this.f5140a);
        }
    }

    static {
        f5122o = new int[]{R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
        f5123p = new int[]{R.attr.textAllCaps};
    }

    public PagerTitleStrip(@NonNull Context r10) {
        this(r10, null);
    }

    private static void setSingleLineAllCaps(TextView r10) {
        r10.setTransformationMethod(new b(r10.getContext()));
    }

    public void a(int r10, float r11) {
        this.f5125b.setTextSize(r10, r11);
        this.f5126c.setTextSize(r10, r11);
        this.f5127d.setTextSize(r10, r11);
    }

    public void b(PagerAdapter r10, PagerAdapter r11) {
        if (r10 == null) goto L4;
        r10.unregisterDataSetObserver(this.f5134k);
        this.f5135l = null;
    L4:
        if (r11 == null) goto L6;
        r11.registerDataSetObserver(this.f5134k);
        this.f5135l = new WeakReference(r11);
    L6:
        ViewPager r12 = this.f5124a;
        if (r12 == null) goto L10;
        this.f5128e = -1;
        this.f5129f = -1.0f;
        c(r12.getCurrentItem(), r11);
        requestLayout();
        return;
    }

    public void c(int r10, PagerAdapter r11) {
        if (r11 == null) goto L5;
        int r12 = r11.getCount();
    L6:
        this.f5132i = true;
        CharSequence r13 = null;
        if (r10 < 1) goto L10;
        if (r11 == null) goto L10;
        CharSequence r14 = r11.getPageTitle(r10 - 1);
    L11:
        this.f5125b.setText(r14);
        TextView r15 = this.f5126c;
        if (r11 == null) goto L15;
        if (r10 >= r12) goto L15;
        CharSequence r16 = r11.getPageTitle(r10);
    L16:
        r15.setText(r16);
        int r17 = r10 + 1;
        if (r17 >= r12) goto L20;
        if (r11 == null) goto L20;
        r13 = r11.getPageTitle(r17);
    L20:
        this.f5127d.setText(r13);
        int r18 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int r19 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f5125b.measure(r18, r19);
        this.f5126c.measure(r18, r19);
        this.f5127d.measure(r18, r19);
        this.f5128e = r10;
        if (this.f5133j == true) goto L23;
        d(r10, this.f5129f, false);
    L23:
        this.f5132i = false;
        return;
    L15:
        r16 = null;
    L10:
        r14 = null;
        goto L11
    L5:
        r12 = 0;
        goto L6
    }

    public void d(int r18, float r19, boolean r20) {
        if (r18 == this.f5128e) goto L5;
        c(r18, this.f5124a.getAdapter());
    L9:
        this.f5133j = true;
        int r10 = this.f5125b.getMeasuredWidth();
        int r11 = this.f5126c.getMeasuredWidth();
        int r12 = this.f5127d.getMeasuredWidth();
        int r13 = r11 / 2;
        int r14 = getWidth();
        int r15 = getHeight();
        int r16 = getPaddingLeft();
        int r17 = getPaddingRight();
        int r110 = getPaddingTop();
        int r111 = getPaddingBottom();
        int r112 = r17 + r13;
        int r113 = (r14 - (r16 + r13)) - r112;
        float r114 = 0.5f + r19;
        if (r114 <= 1.0f) goto L12;
        r114 = r114 - 1.0f;
    L12:
        int r115 = ((r14 - r112) - ((int) (r113 * r114))) - r13;
        int r21 = r11 + r115;
        int r22 = this.f5125b.getBaseline();
        int r116 = this.f5126c.getBaseline();
        int r117 = this.f5127d.getBaseline();
        int r118 = Math.max(Math.max(r22, r116), r117);
        int r23 = r118 - r22;
        int r119 = r118 - r116;
        int r120 = r118 - r117;
        int r121 = this.f5125b.getMeasuredHeight() + r23;
        int r24 = this.f5126c.getMeasuredHeight() + r119;
        int r25 = Math.max(Math.max(r121, r24), this.f5127d.getMeasuredHeight() + r120);
        int r26 = this.f5131h & 112;
        if (r26 != 16) goto L15;
        int r27 = (((r15 - r110) - r111) - r25) / 2;
    L18:
        int r28 = r23 + r27;
        int r122 = r119 + r27;
        int r123 = r27 + r120;
    L20:
        TextView r29 = this.f5126c;
        r29.layout(r115, r122, r21, r29.getMeasuredHeight() + r122);
        int r30 = Math.min(r16, (r115 - this.f5130g) - r10);
        TextView r31 = this.f5125b;
        r31.layout(r30, r28, r10 + r30, r31.getMeasuredHeight() + r28);
        int r32 = Math.max((r14 - r17) - r12, r21 + this.f5130g);
        TextView r33 = this.f5127d;
        r33.layout(r32, r123, r32 + r12, r33.getMeasuredHeight() + r123);
        this.f5129f = r19;
        this.f5133j = false;
        return;
    L15:
        if (r26 == 80) goto L17;
        r28 = r23 + r110;
        r122 = r119 + r110;
        r123 = r110 + r120;
        goto L20
    L17:
        r27 = (r15 - r111) - r25;
        goto L18
    L5:
        if (r20 == true) goto L9;
        if (r19 != this.f5129f) goto L9;
    }

    public int getMinHeight() {
        Drawable r10 = getBackground();
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getIntrinsicHeight();
    }

    public int getTextSpacing() {
        return this.f5130g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewPager) == false) goto L11;
        ViewPager r11 = (ViewPager) r10;
        PagerAdapter r12 = r11.getAdapter();
        r11.setInternalPageChangeListener(this.f5134k);
        r11.addOnAdapterChangeListener(this.f5134k);
        this.f5124a = r11;
        WeakReference r13 = this.f5135l;
        if (r13 == null) goto L7;
        PagerAdapter r14 = (PagerAdapter) r13.get();
    L8:
        b(r14, r12);
        return;
    L7:
        r14 = null;
        goto L8
    L11:
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager r10 = this.f5124a;
        if (r10 == null) goto L6;
        b(r10.getAdapter(), null);
        this.f5124a.setInternalPageChangeListener(null);
        this.f5124a.removeOnAdapterChangeListener(this.f5134k);
        this.f5124a = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (this.f5124a == null) goto L10;
        float r15 = this.f5129f;
        if (r15 >= 0.0f) goto L8;
        r15 = 0.0f;
    L8:
        d(this.f5128e, r15, true);
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L11;
        int r12 = getPaddingTop() + getPaddingBottom();
        int r13 = ViewGroup.getChildMeasureSpec(r11, r12, -2);
        int r14 = View.MeasureSpec.getSize(r10);
        int r15 = ViewGroup.getChildMeasureSpec(r10, (int) (r14 * 0.2f), -2);
        this.f5125b.measure(r15, r13);
        this.f5126c.measure(r15, r13);
        this.f5127d.measure(r15, r13);
        if (View.MeasureSpec.getMode(r11) != 1073741824) goto L7;
        int r16 = View.MeasureSpec.getSize(r11);
    L8:
        setMeasuredDimension(r14, View.resolveSizeAndState(r16, r11, this.f5126c.getMeasuredState() << 16));
        return;
    L7:
        r16 = Math.max(getMinHeight(), this.f5126c.getMeasuredHeight() + r12);
        goto L8
    L11:
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f5132i == true) goto L6;
        super.requestLayout();
        return;
    }

    public void setGravity(int r10) {
        this.f5131h = r10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        int r11 = ((int) (r10 * 255.0f)) & PrivateKeyType.INVALID;
        this.f5136m = r11;
        int r12 = (r11 << 24) | (this.f5137n & 16777215);
        this.f5125b.setTextColor(r12);
        this.f5127d.setTextColor(r12);
    }

    public void setTextColor(@ColorInt int r10) {
        this.f5137n = r10;
        this.f5126c.setTextColor(r10);
        int r11 = (this.f5136m << 24) | (this.f5137n & 16777215);
        this.f5125b.setTextColor(r11);
        this.f5127d.setTextColor(r11);
    }

    public void setTextSpacing(int r10) {
        this.f5130g = r10;
        requestLayout();
    }

    public PagerTitleStrip(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f5128e = -1;
        this.f5129f = -1.0f;
        this.f5134k = new a(this);
        TextView r12 = new TextView(r10);
        this.f5125b = r12;
        addView(r12);
        TextView r13 = new TextView(r10);
        this.f5126c = r13;
        addView(r13);
        TextView r14 = new TextView(r10);
        this.f5127d = r14;
        addView(r14);
        TypedArray r15 = r10.obtainStyledAttributes(r11, f5122o);
        boolean r16 = false;
        int r17 = r15.getResourceId(0, 0);
        if (r17 == 0) goto L5;
        TextViewCompat.n(this.f5125b, r17);
        TextViewCompat.n(this.f5126c, r17);
        TextViewCompat.n(this.f5127d, r17);
    L5:
        int r18 = r15.getDimensionPixelSize(1, 0);
        if (r18 == 0) goto L9;
        a(0, r18);
    L9:
        if (r15.hasValue(2) == false) goto L11;
        int r19 = r15.getColor(2, 0);
        this.f5125b.setTextColor(r19);
        this.f5126c.setTextColor(r19);
        this.f5127d.setTextColor(r19);
    L11:
        this.f5131h = r15.getInteger(3, 80);
        r15.recycle();
        this.f5137n = this.f5126c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextView r20 = this.f5125b;
        TextUtils.TruncateAt r21 = TextUtils.TruncateAt.END;
        r20.setEllipsize(r21);
        this.f5126c.setEllipsize(r21);
        this.f5127d.setEllipsize(r21);
        if (r17 == 0) goto L14;
        TypedArray r22 = r10.obtainStyledAttributes(r17, f5123p);
        r16 = r22.getBoolean(0, false);
        r22.recycle();
    L14:
        if (r16 == false) goto L16;
        setSingleLineAllCaps(this.f5125b);
        setSingleLineAllCaps(this.f5126c);
        setSingleLineAllCaps(this.f5127d);
    L17:
        this.f5130g = (int) (r10.getResources().getDisplayMetrics().density * 16.0f);
        return;
    L16:
        this.f5125b.setSingleLine();
        this.f5126c.setSingleLine();
        this.f5127d.setSingleLine();
        goto L17
    }
}
