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
import androidx.core.widget.TextViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.a
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
    private WeakReference<a> mWatchingAdapter;

    private class PageListener extends DataSetObserver implements ViewPager.d, ViewPager.e {
        private int mScrollState;
        final /* synthetic */ PagerTitleStrip this$0;

        PageListener(PagerTitleStrip r1) {
            this.this$0 = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int r1, float r2, int r3) {
            if (r2 <= 0.5f) goto L5;
            r1 = r1 + 1;
        L5:
            this.this$0.updateTextPositions(r1, r2, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int r3) {
            if (this.mScrollState != 0) goto L9;
            PagerTitleStrip r4 = this.this$0;
            r4.updateText(r4.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            float r0 = 0.0f;
            if (this.this$0.mLastKnownPositionOffset < 0.0f) goto L7;
            r0 = this.this$0.mLastKnownPositionOffset;
        L7:
            PagerTitleStrip r2 = this.this$0;
            r2.updateTextPositions(r2.mPager.getCurrentItem(), r0, true);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int r1) {
            this.mScrollState = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void onAdapterChanged(ViewPager r1, a r2, a r3) {
            this.this$0.updateAdapter(r2, r3);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip r0 = this.this$0;
            r0.updateText(r0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            float r1 = 0.0f;
            if (this.this$0.mLastKnownPositionOffset < 0.0f) goto L5;
            r1 = this.this$0.mLastKnownPositionOffset;
        L5:
            PagerTitleStrip r3 = this.this$0;
            r3.updateTextPositions(r3.mPager.getCurrentItem(), r1, true);
        }
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        SingleLineAllCapsTransform(Context r3) {
            this.mLocale = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence r3, View r4) {
            CharSequence r5 = super.getTransformation((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.toString().toUpperCase(this.mLocale);
        }
    }

    static {
        ATTRS = new int[]{R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
        TEXT_ATTRS = new int[]{R.attr.textAllCaps};
    }

    private static void setSingleLineAllCaps(TextView r4) {
        r4.setTransformationMethod(new SingleLineAllCapsTransform((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    }

    public PagerTitleStrip(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public PagerTitleStrip(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r8, r9);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener(this);
        TextView r0 = new TextView(r8);
        this.mPrevText = r0;
        addView(r0);
        TextView r1 = new TextView(r8);
        this.mCurrText = r1;
        addView(r1);
        TextView r2 = new TextView(r8);
        this.mNextText = r2;
        addView(r2);
        TypedArray r10 = r8.obtainStyledAttributes(r9, ATTRS);
        boolean r3 = false;
        int r4 = r10.getResourceId(0, 0);
        if (r4 == 0) goto L5;
        TextViewCompat.a(this.mPrevText, r4);
        TextViewCompat.a(this.mCurrText, r4);
        TextViewCompat.a(this.mNextText, r4);
    L5:
        int r5 = r10.getDimensionPixelSize(1, 0);
        if (r5 == 0) goto L9;
        setTextSize(0, r5);
    L9:
        if (r10.hasValue(2) == false) goto L11;
        int r11 = r10.getColor(2, 0);
        this.mPrevText.setTextColor(r11);
        this.mCurrText.setTextColor(r11);
        this.mNextText.setTextColor(r11);
    L11:
        this.mGravity = r10.getInteger(3, 80);
        r10.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (r4 == 0) goto L14;
        TypedArray r12 = r8.obtainStyledAttributes(r4, TEXT_ATTRS);
        r3 = r12.getBoolean(0, false);
        r12.recycle();
    L14:
        if (r3 == false) goto L16;
        setSingleLineAllCaps(this.mPrevText);
        setSingleLineAllCaps(this.mCurrText);
        setSingleLineAllCaps(this.mNextText);
    L17:
        this.mScaledTextSpacing = (int) (ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDisplayMetrics().density * 16.0f);
        return;
    L16:
        this.mPrevText.setSingleLine();
        this.mCurrText.setSingleLine();
        this.mNextText.setSingleLine();
        goto L17
    }

    public void setTextSpacing(int r1) {
        this.mScaledTextSpacing = r1;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    public void setNonPrimaryAlpha(float r3) {
        int r4 = ((int) (r3 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = r4;
        int r5 = (r4 << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(r5);
        this.mNextText.setTextColor(r5);
    }

    public void setTextColor(int r3) {
        this.mTextColor = r3;
        this.mCurrText.setTextColor(r3);
        int r4 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(r4);
        this.mNextText.setTextColor(r4);
    }

    public void setTextSize(int r2, float r3) {
        this.mPrevText.setTextSize(r2, r3);
        this.mCurrText.setTextSize(r2, r3);
        this.mNextText.setTextSize(r2, r3);
    }

    public void setGravity(int r1) {
        this.mGravity = r1;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewPager.class) == false) goto L11;
        ViewPager r1 = (ViewPager) ZeusTransformUtils.preCheckCast(r0, ViewPager.class, "com.obric.aiagent.plugin");
        a r2 = r1.getAdapter();
        r1.setInternalPageChangeListener(this.mPageListener);
        r1.addOnAdapterChangeListener(this.mPageListener);
        this.mPager = r1;
        WeakReference<a> r3 = this.mWatchingAdapter;
        if (r3 == null) goto L7;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.get(), a.class, "com.obric.aiagent.plugin");
    L8:
        updateAdapter(r4, r2);
        return;
    L7:
        r4 = null;
        goto L8
    L11:
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager r0 = this.mPager;
        if (r0 == null) goto L6;
        updateAdapter(r0.getAdapter(), null);
        this.mPager.setInternalPageChangeListener(null);
        this.mPager.removeOnAdapterChangeListener(this.mPageListener);
        this.mPager = null;
        return;
    }

    void updateText(int r6, a r7) {
        if (r7 == null) goto L5;
        int r1 = r7.a();
    L6:
        this.mUpdatingText = true;
        CharSequence r3 = null;
        if (r6 < 1) goto L10;
        if (r7 == null) goto L10;
        CharSequence r2 = r7.a(r6 - 1);
    L11:
        this.mPrevText.setText(r2);
        TextView r4 = this.mCurrText;
        if (r7 == null) goto L15;
        if (r6 >= r1) goto L15;
        CharSequence r5 = r7.a(r6);
    L16:
        r4.setText(r5);
        int r8 = r6 + 1;
        if (r8 >= r1) goto L20;
        if (r7 == null) goto L20;
        r3 = r7.a(r8);
    L20:
        this.mNextText.setText(r3);
        int r9 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int r10 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(r9, r10);
        this.mCurrText.measure(r9, r10);
        this.mNextText.measure(r9, r10);
        this.mLastKnownCurrentPage = r6;
        if (this.mUpdatingPositions == true) goto L23;
        updateTextPositions(r6, this.mLastKnownPositionOffset, false);
    L23:
        this.mUpdatingText = false;
        return;
    L15:
        r5 = null;
    L10:
        r2 = null;
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mUpdatingText == true) goto L6;
        super.requestLayout();
        return;
    }

    void updateAdapter(a r2, a r3) {
        if (r2 == null) goto L4;
        r2.b(this.mPageListener);
        this.mWatchingAdapter = null;
    L4:
        if (r3 == null) goto L6;
        r3.a(this.mPageListener);
        this.mWatchingAdapter = new WeakReference(r3);
    L6:
        ViewPager r4 = this.mPager;
        if (r4 == null) goto L10;
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        updateText(r4.getCurrentItem(), r3);
        requestLayout();
        return;
    }

    void updateTextPositions(int r18, float r19, boolean r20) {
        if (r18 == this.mLastKnownCurrentPage) goto L5;
        updateText(r18, this.mPager.getAdapter());
    L9:
        this.mUpdatingPositions = true;
        int r1 = this.mPrevText.getMeasuredWidth();
        int r3 = this.mCurrText.getMeasuredWidth();
        int r4 = this.mNextText.getMeasuredWidth();
        int r5 = r3 / 2;
        int r6 = getWidth();
        int r7 = getHeight();
        int r8 = getPaddingLeft();
        int r9 = getPaddingRight();
        int r10 = getPaddingTop();
        int r11 = getPaddingBottom();
        int r13 = r9 + r5;
        int r12 = (r6 - (r8 + r5)) - r13;
        float r14 = 0.5f + r19;
        if (r14 <= 1.0f) goto L12;
        r14 = r14 - 1.0f;
    L12:
        int r15 = ((r6 - r13) - ((int) (r12 * r14))) - r5;
        int r16 = r3 + r15;
        int r17 = this.mPrevText.getBaseline();
        int r110 = this.mCurrText.getBaseline();
        int r111 = this.mNextText.getBaseline();
        int r112 = Math.max(Math.max(r17, r110), r111);
        int r21 = r112 - r17;
        int r113 = r112 - r110;
        int r114 = r112 - r111;
        int r115 = this.mPrevText.getMeasuredHeight() + r21;
        int r2 = this.mCurrText.getMeasuredHeight() + r113;
        int r22 = Math.max(Math.max(r115, r2), this.mNextText.getMeasuredHeight() + r114);
        int r23 = this.mGravity & 112;
        if (r23 != 16) goto L15;
        int r24 = (((r7 - r10) - r11) - r22) / 2;
    L19:
        int r25 = r21 + r24;
        int r116 = r113 + r24;
        int r117 = r24 + r114;
    L20:
        TextView r26 = this.mCurrText;
        r26.layout(r15, r116, r16, r26.getMeasuredHeight() + r116);
        int r27 = Math.min(r8, (r15 - this.mScaledTextSpacing) - r1);
        TextView r28 = this.mPrevText;
        r28.layout(r27, r25, r1 + r27, r28.getMeasuredHeight() + r25);
        int r29 = Math.max((r6 - r9) - r4, r16 + this.mScaledTextSpacing);
        TextView r30 = this.mNextText;
        r30.layout(r29, r117, r29 + r4, r30.getMeasuredHeight() + r117);
        this.mLastKnownPositionOffset = r19;
        this.mUpdatingPositions = false;
        return;
    L15:
        if (r23 == 80) goto L17;
        r25 = r21 + r10;
        r116 = r113 + r10;
        r117 = r10 + r114;
        goto L20
    L17:
        r24 = (r7 - r11) - r22;
        goto L19
    L5:
        if (r20 == true) goto L9;
        if (r19 != this.mLastKnownPositionOffset) goto L9;
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r9) {
        if (View.MeasureSpec.getMode(r8) != 1073741824) goto L11;
        int r0 = getPaddingTop() + getPaddingBottom();
        int r3 = getChildMeasureSpec(r9, r0, -2);
        int r4 = View.MeasureSpec.getSize(r8);
        int r10 = getChildMeasureSpec(r8, (int) (r4 * 0.2f), -2);
        this.mPrevText.measure(r10, r3);
        this.mCurrText.measure(r10, r3);
        this.mNextText.measure(r10, r3);
        if (View.MeasureSpec.getMode(r9) != 1073741824) goto L7;
        int r11 = View.MeasureSpec.getSize(r9);
    L8:
        setMeasuredDimension(r4, View.resolveSizeAndState(r11, r9, this.mCurrText.getMeasuredState() << 16));
        return;
    L7:
        r11 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + r0);
        goto L8
    L11:
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (this.mPager == null) goto L10;
        float r6 = this.mLastKnownPositionOffset;
        if (r6 >= 0.0f) goto L8;
        r6 = 0.0f;
    L8:
        updateTextPositions(this.mLastKnownCurrentPage, r6, true);
        return;
    }

    int getMinHeight() {
        Drawable r0 = getBackground();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getIntrinsicHeight();
    }
}
