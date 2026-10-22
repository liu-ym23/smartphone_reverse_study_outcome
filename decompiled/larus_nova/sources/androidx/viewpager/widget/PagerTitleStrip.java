package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] ATTRS = null;
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS = null;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;
        final /* synthetic */ PagerTitleStrip this$0;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip r100 = this.this$0;
            r100.updateText(r100.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r101 = this.this$0;
            float r102 = r101.mLastKnownPositionOffset;
            if (r102 >= 0.0f) goto L6;
            r102 = 0.0f;
        L6:
            r101.updateTextPositions(r101.mPager.getCurrentItem(), r102, true);
        }

        public PageListener(PagerTitleStrip r100) {
            this.this$0 = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r100) {
            this.mScrollState = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r100) {
            if (this.mScrollState != 0) goto L10;
            PagerTitleStrip r101 = this.this$0;
            r101.updateText(r101.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r102 = this.this$0;
            float r103 = r102.mLastKnownPositionOffset;
            if (r103 >= 0.0f) goto L8;
            r103 = 0.0f;
        L8:
            r102.updateTextPositions(r102.mPager.getCurrentItem(), r103, true);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102) {
            this.this$0.updateAdapter(r101, r102);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r100, float r101, int r102) {
            if (r101 <= 0.5f) goto L5;
            r100 = r100 + 1;
        L5:
            this.this$0.updateTextPositions(r100, r101, false);
        }
    }

    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        public SingleLineAllCapsTransform(Context r100) {
            this.mLocale = r100.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence r100, View r101) {
            CharSequence r102 = super.getTransformation(r100, r101);
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.toString().toUpperCase(this.mLocale);
        }
    }

    static {
        ATTRS = new int[]{R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
        TEXT_ATTRS = new int[]{R.attr.textAllCaps};
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mUpdatingText == true) goto L6;
        super.requestLayout();
        return;
    }

    public int getMinHeight() {
        Drawable r100 = getBackground();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getIntrinsicHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewPager) == false) goto L11;
        ViewPager r101 = (ViewPager) r100;
        PagerAdapter r102 = r101.getAdapter();
        r101.setInternalPageChangeListener(this.mPageListener);
        r101.addOnAdapterChangeListener(this.mPageListener);
        this.mPager = r101;
        WeakReference<PagerAdapter> r103 = this.mWatchingAdapter;
        if (r103 == null) goto L7;
        PagerAdapter r104 = r103.get();
    L8:
        updateAdapter(r104, r102);
        return;
    L7:
        r104 = null;
        goto L8
    L11:
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager r100 = this.mPager;
        if (r100 == null) goto L6;
        updateAdapter(r100.getAdapter(), null);
        this.mPager.setInternalPageChangeListener(null);
        this.mPager.removeOnAdapterChangeListener(this.mPageListener);
        this.mPager = null;
        return;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    public PagerTitleStrip(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_viewpager_widget_PagerTitleStrip_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private static void setSingleLineAllCaps(TextView r100) {
        r100.setTransformationMethod(new SingleLineAllCapsTransform(r100.getContext()));
    }

    public void setGravity(int r100) {
        this.mGravity = r100;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float r100) {
        int r101 = ((int) (r100 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = r101;
        int r102 = (r101 << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(r102);
        this.mNextText.setTextColor(r102);
    }

    public void setTextColor(int r100) {
        this.mTextColor = r100;
        this.mCurrText.setTextColor(r100);
        int r101 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(r101);
        this.mNextText.setTextColor(r101);
    }

    public void setTextSpacing(int r100) {
        this.mScaledTextSpacing = r100;
        requestLayout();
    }

    public PagerTitleStrip(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener(this);
        TextView r102 = new TextView(r100);
        this.mPrevText = r102;
        addView(r102);
        TextView r103 = new TextView(r100);
        this.mCurrText = r103;
        addView(r103);
        TextView r104 = new TextView(r100);
        this.mNextText = r104;
        addView(r104);
        TypedArray r105 = r100.obtainStyledAttributes(r101, ATTRS);
        boolean r106 = false;
        int r107 = r105.getResourceId(0, 0);
        if (r107 == 0) goto L5;
        TextViewCompat.setTextAppearance(this.mPrevText, r107);
        TextViewCompat.setTextAppearance(this.mCurrText, r107);
        TextViewCompat.setTextAppearance(this.mNextText, r107);
    L5:
        int r108 = r105.getDimensionPixelSize(1, 0);
        if (r108 == 0) goto L9;
        setTextSize(0, r108);
    L9:
        if (r105.hasValue(2) == false) goto L11;
        int r109 = r105.getColor(2, 0);
        this.mPrevText.setTextColor(r109);
        this.mCurrText.setTextColor(r109);
        this.mNextText.setTextColor(r109);
    L11:
        this.mGravity = r105.getInteger(3, 80);
        r105.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (r107 == 0) goto L14;
        TypedArray r110 = r100.obtainStyledAttributes(r107, TEXT_ATTRS);
        r106 = r110.getBoolean(0, false);
        r110.recycle();
    L14:
        if (r106 == false) goto L16;
        setSingleLineAllCaps(this.mPrevText);
        setSingleLineAllCaps(this.mCurrText);
        setSingleLineAllCaps(this.mNextText);
    L17:
        this.mScaledTextSpacing = (int) (INVOKEVIRTUAL_androidx_viewpager_widget_PagerTitleStrip_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density * 16.0f);
        return;
    L16:
        this.mPrevText.setSingleLine();
        this.mCurrText.setSingleLine();
        this.mNextText.setSingleLine();
        goto L17
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        if (View.MeasureSpec.getMode(r100) != 1073741824) goto L11;
        int r102 = getPaddingTop() + getPaddingBottom();
        int r103 = ViewGroup.getChildMeasureSpec(r101, r102, -2);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = ViewGroup.getChildMeasureSpec(r100, (int) (r104 * 0.2f), -2);
        this.mPrevText.measure(r105, r103);
        this.mCurrText.measure(r105, r103);
        this.mNextText.measure(r105, r103);
        if (View.MeasureSpec.getMode(r101) != 1073741824) goto L7;
        int r106 = View.MeasureSpec.getSize(r101);
    L8:
        setMeasuredDimension(r104, View.resolveSizeAndState(r106, r101, this.mCurrText.getMeasuredState() << 16));
        return;
    L7:
        r106 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + r102);
        goto L8
    L11:
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void setTextSize(int r100, float r101) {
        this.mPrevText.setTextSize(r100, r101);
        this.mCurrText.setTextSize(r100, r101);
        this.mNextText.setTextSize(r100, r101);
    }

    public void updateAdapter(PagerAdapter r100, PagerAdapter r101) {
        if (r100 == null) goto L4;
        r100.unregisterDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = null;
    L4:
        if (r101 == null) goto L6;
        r101.registerDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = new WeakReference(r101);
    L6:
        ViewPager r102 = this.mPager;
        if (r102 == null) goto L10;
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        updateText(r102.getCurrentItem(), r101);
        requestLayout();
        return;
    }

    public void updateText(int r100, PagerAdapter r101) {
        if (r101 == null) goto L5;
        int r102 = r101.getCount();
    L6:
        this.mUpdatingText = true;
        CharSequence r103 = null;
        if (r100 < 1) goto L10;
        if (r101 == null) goto L10;
        CharSequence r104 = r101.getPageTitle(r100 - 1);
    L11:
        this.mPrevText.setText(r104);
        TextView r105 = this.mCurrText;
        if (r101 == null) goto L15;
        if (r100 >= r102) goto L15;
        CharSequence r106 = r101.getPageTitle(r100);
    L16:
        r105.setText(r106);
        int r107 = r100 + 1;
        if (r107 >= r102) goto L20;
        if (r101 == null) goto L20;
        r103 = r101.getPageTitle(r107);
    L20:
        this.mNextText.setText(r103);
        int r108 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int r109 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(r108, r109);
        this.mCurrText.measure(r108, r109);
        this.mNextText.measure(r108, r109);
        this.mLastKnownCurrentPage = r100;
        if (this.mUpdatingPositions == true) goto L23;
        updateTextPositions(r100, this.mLastKnownPositionOffset, false);
    L23:
        this.mUpdatingText = false;
        return;
    L15:
        r106 = null;
    L10:
        r104 = null;
        goto L11
    L5:
        r102 = 0;
        goto L6
    }

    public void updateTextPositions(int r110, float r111, boolean r210) {
        if (r110 == this.mLastKnownCurrentPage) goto L5;
        updateText(r110, this.mPager.getAdapter());
    L9:
        this.mUpdatingPositions = true;
        int r100 = this.mPrevText.getMeasuredWidth();
        int r101 = this.mCurrText.getMeasuredWidth();
        int r102 = this.mNextText.getMeasuredWidth();
        int r103 = r101 / 2;
        int r104 = getWidth();
        int r105 = getHeight();
        int r106 = getPaddingLeft();
        int r107 = getPaddingRight();
        int r112 = getPaddingTop();
        int r113 = getPaddingBottom();
        int r114 = r107 + r103;
        int r115 = (r104 - (r106 + r103)) - r114;
        float r116 = 0.5f + r111;
        if (r116 <= 1.0f) goto L12;
        r116 = r116 - 1.0f;
    L12:
        int r117 = ((r104 - r114) - ((int) (r115 * r116))) - r103;
        int r108 = r101 + r117;
        int r109 = this.mPrevText.getBaseline();
        int r118 = this.mCurrText.getBaseline();
        int r119 = this.mNextText.getBaseline();
        int r120 = Math.max(Math.max(r109, r118), r119);
        int r121 = r120 - r109;
        int r122 = r120 - r118;
        int r123 = r120 - r119;
        int r124 = this.mPrevText.getMeasuredHeight() + r121;
        int r125 = this.mCurrText.getMeasuredHeight() + r122;
        int r126 = Math.max(Math.max(r124, r125), this.mNextText.getMeasuredHeight() + r123);
        int r127 = this.mGravity & 112;
        if (r127 != 16) goto L15;
        int r128 = (((r105 - r112) - r113) - r126) / 2;
    L19:
        int r129 = r121 + r128;
        int r130 = r122 + r128;
        int r131 = r128 + r123;
    L20:
        TextView r132 = this.mCurrText;
        r132.layout(r117, r130, r108, r132.getMeasuredHeight() + r130);
        int r133 = Math.min(r106, (r117 - this.mScaledTextSpacing) - r100);
        TextView r134 = this.mPrevText;
        r134.layout(r133, r129, r100 + r133, r134.getMeasuredHeight() + r129);
        int r135 = Math.max((r104 - r107) - r102, r108 + this.mScaledTextSpacing);
        TextView r136 = this.mNextText;
        r136.layout(r135, r131, r135 + r102, r136.getMeasuredHeight() + r131);
        this.mLastKnownPositionOffset = r111;
        this.mUpdatingPositions = false;
        return;
    L15:
        if (r127 == 80) goto L17;
        r129 = r121 + r112;
        r130 = r122 + r112;
        r131 = r112 + r123;
        goto L20
    L17:
        r128 = (r105 - r113) - r126;
        goto L19
    L5:
        if (r210 == true) goto L9;
        if (r111 != this.mLastKnownPositionOffset) goto L9;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.mPager == null) goto L10;
        float r105 = this.mLastKnownPositionOffset;
        if (r105 >= 0.0f) goto L8;
        r105 = 0.0f;
    L8:
        updateTextPositions(this.mLastKnownCurrentPage, r105, true);
        return;
    }
}
