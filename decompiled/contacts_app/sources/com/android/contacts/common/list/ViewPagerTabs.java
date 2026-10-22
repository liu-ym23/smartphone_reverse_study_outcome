package com.android.contacts.common.list;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.contacts.common.compat.CompatUtils;

/* JADX INFO: loaded from: classes.dex */
public class ViewPagerTabs extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    private static final int[] ATTRS = null;
    private static final int TAB_SIDE_PADDING_IN_DPS = 10;
    private static final ViewOutlineProvider VIEW_BOUNDS_OUTLINE_PROVIDER = null;
    ViewPager mPager;
    int mPrevSelected;
    int mSidePadding;
    private int[] mTabIcons;
    private ViewPagerTabStrip mTabStrip;
    final boolean mTextAllCaps;
    final ColorStateList mTextColor;
    final int mTextSize;
    final int mTextStyle;
    private int[] mUnreadCounts;

    private class OnTabLongClickListener implements View.OnLongClickListener {
        final int mPosition;
        final /* synthetic */ ViewPagerTabs this$0;

        public OnTabLongClickListener(ViewPagerTabs r1, int r2) {
            this.this$0 = r1;
            this.mPosition = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r7) {
            int[] r0 = new int[2];
            this.this$0.getLocationOnScreen(r0);
            Context r1 = this.this$0.getContext();
            int r2 = this.this$0.getWidth();
            int r3 = this.this$0.getHeight();
            int r4 = r1.getResources().getDisplayMetrics().widthPixels;
            Toast r6 = Toast.makeText(r1, this.this$0.mPager.getAdapter().getPageTitle(this.mPosition), 0);
            r6.setGravity(49, (r0[0] + (r2 / 2)) - (r4 / 2), r0[1] + r3);
            r6.show();
            return true;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int r1) {
    }

    static /* synthetic */ int access$000(ViewPagerTabs r0, int r1) {
        return r0.getRtlPosition(r1);
    }

    static {
        if (CompatUtils.isLollipopCompatible() == false) goto L5;
        VIEW_BOUNDS_OUTLINE_PROVIDER = new AnonymousClass1();
    L6:
        ATTRS = new int[]{R.attr.textSize, R.attr.textStyle, R.attr.textColor, R.attr.textAllCaps};
        return;
    L5:
        VIEW_BOUNDS_OUTLINE_PROVIDER = null;
        goto L6
    }

    public ViewPagerTabs(Context r2) {
        this(r2, null);
    }

    public ViewPagerTabs(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ViewPagerTabs(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.mPrevSelected = -1;
        setFillViewport(true);
        this.mSidePadding = (int) (getResources().getDisplayMetrics().density * 10.0f);
        TypedArray r7 = r4.obtainStyledAttributes(r5, ATTRS);
        this.mTextSize = r7.getDimensionPixelSize(0, 0);
        this.mTextStyle = r7.getInt(1, 0);
        this.mTextColor = r7.getColorStateList(2);
        this.mTextAllCaps = r7.getBoolean(3, false);
        ViewPagerTabStrip r0 = new ViewPagerTabStrip(r4);
        this.mTabStrip = r0;
        addView(r0, new FrameLayout.LayoutParams(-2, -1));
        r7.recycle();
        if (CompatUtils.isLollipopCompatible() == false) goto L6;
        setOutlineProvider(VIEW_BOUNDS_OUTLINE_PROVIDER);
        return;
    }

    public void setViewPager(ViewPager r1) {
        this.mPager = r1;
        addTabs(r1.getAdapter());
    }

    public void configureTabIcons(int[] r1) {
        this.mTabIcons = r1;
        this.mUnreadCounts = new int[r1.length];
    }

    public void setUnreadCount(int r2, int r3) {
        int[] r1 = this.mUnreadCounts;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r3 >= r1.length) goto L10;
        r1[r3] = r2;
        return;
    }

    private void addTabs(PagerAdapter r4) {
        this.mTabStrip.removeAllViews();
        int r0 = r4.getCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addTab(r4.getPageTitle(r1), r1);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void addTab(CharSequence r9, final int r10) {
        int[] r0 = this.mTabIcons;
        if (r0 != null) goto L5;
    L12:
        TextView r1 = new TextView(getContext());
        r1.setText(r9);
        r1.setBackgroundResource(com.android.contacts.common.R.drawable.view_pager_tab_background);
        if (this.mTextStyle <= 0) goto L15;
        r1.setTypeface(r1.getTypeface(), this.mTextStyle);
    L15:
        int r11 = this.mTextSize;
        if (r11 <= 0) goto L18;
        r1.setTextSize(0, r11);
    L18:
        ColorStateList r12 = this.mTextColor;
        if (r12 == null) goto L21;
        r1.setTextColor(r12);
    L21:
        r1.setAllCaps(this.mTextAllCaps);
        r1.setGravity(17);
        View r2 = r1;
    L22:
        r2.setOnClickListener(new AnonymousClass2(this, r10));
        r2.setOnLongClickListener(new OnTabLongClickListener(this, r10));
        int r13 = this.mSidePadding;
        r2.setPadding(r13, 0, r13, 0);
        this.mTabStrip.addView(r2, r10, new LinearLayout.LayoutParams(-2, -1, 1.0f));
        if (r10 != 0) goto L26;
        this.mPrevSelected = 0;
        r2.setSelected(true);
        return;
    L26:
        return;
    L5:
        if (r10 >= r0.length) goto L12;
        View r3 = LayoutInflater.from(getContext()).inflate(com.android.contacts.common.R.layout.unread_count_tab, null);
        View r4 = r3.findViewById(com.android.contacts.common.R.id.icon);
        r4.setBackgroundResource(this.mTabIcons[r10]);
        r4.setContentDescription(r9);
        TextView r5 = (TextView) r3.findViewById(com.android.contacts.common.R.id.count);
        int[] r6 = this.mUnreadCounts;
        if (r6 == null) goto L11;
        int r7 = r6[r10];
        if (r7 <= 0) goto L11;
        r5.setText(Integer.toString(r7));
        r5.setVisibility(0);
        r4.setContentDescription(getResources().getQuantityString(com.android.contacts.common.R.plurals.tab_title_with_unread_items, this.mUnreadCounts[r10], new Object[]{r9.toString(), Integer.valueOf(this.mUnreadCounts[r10])}));
        r2 = r3;
    L11:
        r5.setVisibility(4);
        r4.setContentDescription(r9);
        r2 = r3;
        goto L22
    }

    public void removeTab(int r2) {
        View r3 = this.mTabStrip.getChildAt(r2);
        if (r3 == null) goto L6;
        this.mTabStrip.removeView(r3);
        return;
    }

    public void updateTab(int r2) {
        removeTab(r2);
        if (r2 >= this.mPager.getAdapter().getCount()) goto L6;
        addTab(this.mPager.getAdapter().getPageTitle(r2), r2);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int r2, float r3, int r4) {
        int r5 = getRtlPosition(r2);
        int r0 = this.mTabStrip.getChildCount();
        if (r0 == 0) goto L9;
        if (r5 < 0) goto L10;
        if (r5 >= r0) goto L11;
        this.mTabStrip.onPageScrolled(r5, r3, r4);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int r5) {
        int r6 = getRtlPosition(r5);
        int r0 = this.mTabStrip.getChildCount();
        if (r0 == 0) goto L17;
        if (r6 < 0) goto L18;
        if (r6 >= r0) goto L20;
        int r1 = this.mPrevSelected;
        if (r1 < 0) goto L13;
        if (r1 >= r0) goto L13;
        View r2 = this.mTabStrip.getChildAt(r1);
        if (r2 == null) goto L13;
        r2.setSelected(false);
    L13:
        View r3 = this.mTabStrip.getChildAt(r6);
        if (r3 == null) goto L19;
        r3.setSelected(true);
        smoothScrollTo(r3.getLeft() - ((getWidth() - r3.getWidth()) / 2), 0);
        this.mPrevSelected = r6;
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    }

    private int getRtlPosition(int r3) {
        if (getLayoutDirection() == 1) goto L5;
        return r3;
    L5:
        return (this.mTabStrip.getChildCount() - 1) - r3;
    }
}
