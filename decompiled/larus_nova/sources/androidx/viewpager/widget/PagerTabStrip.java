package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes17.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    public PagerTabStrip(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_viewpager_widget_PagerTabStrip_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getHeight();
        int r101 = this.mCurrText.getLeft() - this.mTabPadding;
        int r102 = this.mCurrText.getRight() + this.mTabPadding;
        int r103 = r100 - this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & 16777215));
        float r104 = r100;
        r110.drawRect(r101, r103, r102, r104, this.mTabPaint);
        if (this.mDrawFullUnderline == false) goto L6;
        this.mTabPaint.setColor((this.mIndicatorColor & 16777215) | (-16777216));
        r110.drawRect(getPaddingLeft(), r100 - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), r104, this.mTabPaint);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
    L7:
        float r102 = r100.getX();
        float r103 = r100.getY();
        if (r101 == 0) goto L24;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L14;
    L25:
        return true;
    L14:
        if (Math.abs(r102 - this.mInitialMotionX) <= this.mTouchSlop) goto L16;
    L17:
        this.mIgnoreTap = true;
        goto L25
    L16:
        if (Math.abs(r103 - this.mInitialMotionY) <= this.mTouchSlop) goto L25;
    L19:
        if (r102 >= (this.mCurrText.getLeft() - this.mTabPadding)) goto L22;
        ViewPager r104 = this.mPager;
        r104.setCurrentItem(r104.getCurrentItem() - 1);
        goto L25
    L22:
        if (r102 <= (this.mCurrText.getRight() + this.mTabPadding)) goto L25;
        ViewPager r105 = this.mPager;
        r105.setCurrentItem(r105.getCurrentItem() + 1);
        goto L25
    L24:
        this.mInitialMotionX = r102;
        this.mInitialMotionY = r103;
        this.mIgnoreTap = false;
        goto L25
    L5:
        if (this.mIgnoreTap == false) goto L7;
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        super.setBackgroundColor(r100);
        if (this.mDrawFullUnderlineSet == false) goto L5;
        return;
    L5:
        if ((r100 & (-16777216)) != 0) goto L7;
        boolean r101 = true;
    L8:
        this.mDrawFullUnderline = r101;
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        super.setBackgroundDrawable(r100);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r100 != null) goto L6;
        boolean r101 = true;
    L7:
        this.mDrawFullUnderline = r101;
        return;
    L6:
        r101 = false;
        goto L7
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        super.setBackgroundResource(r100);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r100 != 0) goto L6;
        boolean r101 = true;
    L7:
        this.mDrawFullUnderline = r101;
        return;
    L6:
        r101 = false;
        goto L7
    }

    public void setDrawFullUnderline(boolean r100) {
        this.mDrawFullUnderline = r100;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    public void setTabIndicatorColor(int r100) {
        this.mIndicatorColor = r100;
        this.mTabPaint.setColor(r100);
        invalidate();
    }

    public void setTabIndicatorColorResource(int r100) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), r100));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int r100) {
        int r101 = this.mMinTextSpacing;
        if (r100 >= r101) goto L5;
        r100 = r101;
    L5:
        super.setTextSpacing(r100);
    }

    public PagerTabStrip(Context r100, AttributeSet r101) {
        super(r100, r101);
        Paint r102 = new Paint();
        this.mTabPaint = r102;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int r103 = this.mTextColor;
        this.mIndicatorColor = r103;
        r102.setColor(r103);
        float r104 = INVOKEVIRTUAL_androidx_viewpager_widget_PagerTabStrip_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        this.mIndicatorHeight = (int) ((3.0f * r104) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * r104) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * r104);
        this.mTabPadding = (int) ((16.0f * r104) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * r104) + 0.5f);
        this.mMinStripHeight = (int) ((r104 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(r100).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new AnonymousClass1(this));
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new AnonymousClass2(this));
        if (getBackground() != null) goto L6;
        this.mDrawFullUnderline = true;
        return;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void updateTextPositions(int r100, float r101, boolean r102) {
        Rect r103 = this.mTempRect;
        int r104 = getHeight();
        int r105 = this.mCurrText.getLeft() - this.mTabPadding;
        int r106 = this.mCurrText.getRight() + this.mTabPadding;
        int r107 = r104 - this.mIndicatorHeight;
        r103.set(r105, r107, r106, r104);
        super.updateTextPositions(r100, r101, r102);
        this.mTabAlpha = (int) ((Math.abs(r101 - 0.5f) * 2.0f) * 255.0f);
        r103.union(this.mCurrText.getLeft() - this.mTabPadding, r107, this.mCurrText.getRight() + this.mTabPadding, r104);
        invalidate(r103);
    }

    @Override // android.view.View
    public void setPadding(int r100, int r101, int r102, int r103) {
        int r104 = this.mMinPaddingBottom;
        if (r103 >= r104) goto L5;
        r103 = r104;
    L5:
        super.setPadding(r100, r101, r102, r103);
    }
}
