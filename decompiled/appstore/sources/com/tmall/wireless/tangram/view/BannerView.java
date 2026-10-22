package com.tmall.wireless.tangram.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$id;
import com.obric.oui.indicator.OCarouselIndicator;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.wireless.tangram.core.adapter.BinderViewHolder;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.cell.BannerCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import java.util.ArrayList;
import java.util.List;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public class BannerView extends RelativeLayout implements ViewPager.OnPageChangeListener, ITangramViewLifeCycle {
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_LEFT = 0;
    public static final int GRAVITY_RIGHT = 2;
    private BaseCell cell;
    private BannerIndicator mIndicator;
    private int mIndicatorGap;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mNextPageScrollDelay;
    private UltraViewPager mUltraViewPager;
    private List<BinderViewHolder> mViewHolders;
    private float xDown;
    private float yDown;

    public class BannerIndicator extends LinearLayout {
        private final int STYLE_DOT;
        private final int STYLE_IMG;
        private final int STYLE_NONE;
        private int focusColor;
        private String focusUrl;
        private ImageView[] mImageViews;
        private OCarouselIndicator mIndicator;
        private int norColor;
        private String norUrl;
        private float radius;
        private int style;
        final /* synthetic */ BannerView this$0;

        public BannerIndicator(BannerView r10, Context r11) {
            this.this$0 = r10;
            super(r11);
            this.STYLE_NONE = 0;
            this.STYLE_DOT = 1;
            this.STYLE_IMG = 2;
            OCarouselIndicator r12 = new OCarouselIndicator(r11);
            this.mIndicator = r12;
            r12.setDotsWidth(f.i(24));
            this.mIndicator.setDotsHeight(f.i(4));
            this.mIndicator.setDotsSpacing(f.i(2));
            this.mIndicator.setDotsColor(getContext().getColor(R$color.oui_text_4));
            this.mIndicator.setSelectedDotColor(getContext().getColor(R$color.oui_text_1));
            View r13 = this.mIndicator.getChildAt(0);
            if ((r13 instanceof LinearLayout) == false) goto L5;
            r13.getLayoutParams().height = f.i(16);
        L5:
            addView(this.mIndicator);
        }

        private GradientDrawable getGradientDrawable(int r10, float r11) {
            GradientDrawable r12 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r10, r10});
            r12.setShape(1);
            r12.setCornerRadius(r11);
            return r12;
        }

        public void setCurrItem(int r10) {
        }

        public void updateIndicators(String r10, String r11, int r12, int r13, int r14) {
            ViewPager r15 = BannerView.access$000(this.this$0).getViewPager();
            PagerAdapter r16 = BannerView.access$000(this.this$0).getAdapter();
            if (r15 == null) goto L8;
            if (r16 == null) goto L9;
            this.mIndicator.x(r15, r16.getCount());
            return;
        L9:
            return;
        }
    }

    public BannerView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ UltraViewPager access$000(BannerView r10) {
        return r10.mUltraViewPager;
    }

    private void bindFooterView(BaseCell r10) {
        if (r10 == null) goto L10;
        View r11 = getViewFromRecycler(r10);
        if (r11 == null) goto L11;
        r11.setId(R$id.TANGRAM_BANNER_FOOTER_ID);
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(-1, -2);
        r12.addRule(3, R$id.TANGRAM_BANNER_ID);
        Style r13 = r10.style;
        if (r13 == null) goto L8;
        int[] r14 = r13.margin;
        r12.topMargin = r14[0];
        r12.leftMargin = r14[3];
        r12.bottomMargin = r14[2];
        r12.rightMargin = r14[1];
    L8:
        addView(r11, r12);
        return;
    L11:
        return;
    }

    private void bindHeaderView(BaseCell r10) {
        if (r10 == null) goto L10;
        View r11 = getViewFromRecycler(r10);
        if (r11 == null) goto L11;
        int r12 = R$id.TANGRAM_BANNER_HEADER_ID;
        r11.setId(r12);
        ((RelativeLayout.LayoutParams) this.mUltraViewPager.getLayoutParams()).addRule(3, r12);
        RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(-1, -2);
        Style r14 = r10.style;
        if (r14 == null) goto L8;
        int[] r15 = r14.margin;
        r13.topMargin = r15[0];
        r13.leftMargin = r15[3];
        r13.bottomMargin = r15[2];
        r13.rightMargin = r15[1];
    L8:
        addView(r11, r13);
        return;
    L11:
        return;
    }

    private int getIndicatorGravity(String r10) {
        if ("left".equals(r10) == false) goto L7;
        return 0;
    L7:
        if ("right".equals(r10) == false) goto L10;
        return 2;
    L10:
        return 1;
    }

    private View getViewFromRecycler(@NonNull BaseCell r10) {
        ServiceManager r11 = r10.serviceManager;
        if (r11 != null) goto L6;
        return null;
    L6:
        GroupBasicAdapter r12 = (GroupBasicAdapter) r11.getService(GroupBasicAdapter.class);
        RecyclerView.RecycledViewPool r13 = (RecyclerView.RecycledViewPool) r10.serviceManager.getService(RecyclerView.RecycledViewPool.class);
        int r14 = r12.getItemType(r10);
        BinderViewHolder r15 = (BinderViewHolder) r13.getRecycledView(r14);
        if (r15 != null) goto L9;
        r15 = (BinderViewHolder) r12.createViewHolder(this, r14);
    L9:
        r15.bind(r10);
        this.mViewHolders.add(r15);
        return r15.itemView;
    }

    private void init() {
        UltraViewPager r10 = new UltraViewPager(getContext());
        this.mUltraViewPager = r10;
        int r11 = R$id.TANGRAM_BANNER_ID;
        r10.setId(r11);
        this.mIndicator = new BannerIndicator(this, getContext());
        addView(this.mUltraViewPager);
        addView(this.mIndicator, new RelativeLayout.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) this.mIndicator.getLayoutParams();
        r12.addRule(3, r11);
        r12.bottomMargin = f.i(10);
        this.mIndicator.setLayoutParams(r12);
    }

    private void recycleView() {
        if (this.mViewHolders.isEmpty() == true) goto L13;
        ServiceManager r10 = this.cell.serviceManager;
        if (r10 != null) goto L7;
        return;
    L7:
        RecyclerView.RecycledViewPool r11 = (RecyclerView.RecycledViewPool) r10.getService(RecyclerView.RecycledViewPool.class);
        int r12 = this.mViewHolders.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L10;
        BinderViewHolder r14 = this.mViewHolders.get(r13);
        r14.unbind();
        removeView(r14.itemView);
        r11.putRecycledView(r14);
        r13 = r13 + 1;
        goto L8
    L10:
        this.mViewHolders.clear();
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
        this.cell = r10;
    }

    public UltraViewPager getUltraViewPager() {
        return this.mUltraViewPager;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        float r12 = r10.getRawX();
        float r13 = r10.getRawY();
        if (r11 != 0) goto L5;
        this.xDown = r12;
        this.yDown = r13;
    L12:
        return false;
    L5:
        if (r11 != 2) goto L12;
        int r14 = (int) (r12 - this.xDown);
        int r15 = (int) (r13 - this.yDown);
        if (Math.abs(r14) < Math.abs(r15)) goto L10;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L12
    L10:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L12
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int r10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int r10, float r11, int r12) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int r10) {
        this.mIndicator.setCurrItem(this.mUltraViewPager.getCurrentItem());
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r12) {
        BannerCell r10 = (BannerCell) r12;
        r10.initAdapter();
        Style r13 = r12.style;
        if (r13 == null) goto L5;
        int[] r14 = r13.padding;
        setPadding(r14[3], r14[0], r14[1], r14[2]);
    L5:
        setBackgroundColor(r10.mBgColor);
        PagerAdapter r15 = getUltraViewPager().getAdapter();
        BannerCell.BannerAdapter r11 = r10.mBannerAdapter;
        if (r15 == r11) goto L8;
        setAdapter(r11);
    L8:
        getUltraViewPager().setAutoMeasureHeight(true);
        getUltraViewPager().setRatio(r10.mRatio);
        getUltraViewPager().setAutoScroll(r10.mAutoScrollInternal);
        if (this.mNextPageScrollDelay <= (-1)) goto L11;
        getUltraViewPager().scheduleNextPageScroll(this.mNextPageScrollDelay);
        this.mNextPageScrollDelay = -1;
    L11:
        getUltraViewPager().getViewPager().setPageMargin(r10.hGap);
        if (r10.mCells.size() > r10.mInfiniteMinCount) goto L14;
        getUltraViewPager().setInfiniteLoop(false);
    L15:
        setIndicatorGravity(getIndicatorGravity(r10.mIndicatorGravity));
        setIndicatorPos(r10.mIndicatorPos);
        int r16 = r10.mIndicatorGap;
        if (r16 > 0) goto L18;
        r16 = this.mIndicatorGap;
    L18:
        setIndicatorGap(r16);
        int r17 = r10.mIndicatorMargin;
        if (r17 > 0) goto L21;
        r17 = this.mIndicatorMargin;
    L21:
        setIndicatorMargin(r17);
        setIndicatorHeight(r10.mIndicatorHeight);
        int[] r18 = r10.itemMargin;
        if (r18[0] <= 0) goto L24;
    L27:
        UltraViewPager r19 = getUltraViewPager();
        int[] r20 = r10.itemMargin;
        r19.setScrollMargin(r20[0], r20[1]);
        getUltraViewPager().getViewPager().setClipToPadding(false);
        getUltraViewPager().getViewPager().setClipChildren(false);
    L28:
        VirtualLayoutManager.LayoutParams r110 = (VirtualLayoutManager.LayoutParams) getLayoutParams();
        int[] r21 = r10.margin;
        r110.setMargins(r21[3], r21[0], r21[1], r21[2]);
        updateIndicators(r10.mIndicatorFocus, r10.mIndicatorNor, r10.mIndicatorRadius, r10.mIndicatorColor, r10.mIndicatorDefaultColor);
        recycleView();
        bindHeaderView(r10.mHeader);
        bindFooterView(r10.mFooter);
        return;
    L24:
        if (r18[1] > 0) goto L27;
        getUltraViewPager().setScrollMargin(0, 0);
        getUltraViewPager().getViewPager().setClipToPadding(true);
        getUltraViewPager().getViewPager().setClipChildren(true);
        goto L28
    L14:
        getUltraViewPager().setInfiniteLoop(r10.mInfinite);
        goto L15
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
        recycleView();
    }

    public void setAdapter(PagerAdapter r10) {
        this.mUltraViewPager.setAdapter(r10);
        this.mUltraViewPager.setOnPageChangeListener(this);
    }

    public void setIndicatorGap(int r10) {
        if (r10 <= 0) goto L5;
        this.mIndicatorGap = r10;
        return;
    }

    public void setIndicatorGravity(int r10) {
        if (r10 != 0) goto L4;
        BannerIndicator r11 = this.mIndicator;
        if (r11 == null) goto L22;
        r11.setGravity(3);
        return;
    L22:
        return;
    L4:
        if (r10 != 1) goto L6;
        BannerIndicator r12 = this.mIndicator;
        if (r12 == null) goto L20;
        r12.setGravity(1);
        return;
    L20:
        return;
    L6:
        if (r10 != 2) goto L23;
        BannerIndicator r13 = this.mIndicator;
        if (r13 == null) goto L18;
        r13.setGravity(5);
        return;
    L18:
        return;
    }

    public void setIndicatorHeight(int r10) {
        if (r10 <= 0) goto L4;
        this.mIndicatorHeight = r10;
        return;
    L4:
        this.mIndicatorHeight = -2;
    }

    public void setIndicatorMargin(int r10) {
        if (r10 <= 0) goto L5;
        this.mIndicatorMargin = r10;
        return;
    }

    public void setIndicatorPos(String r10) {
    }

    public void setNextPageScrollDelay(int r10) {
        this.mNextPageScrollDelay = r10;
    }

    public void updateIndicators(String r10, String r11, int r12, int r13, int r14) {
        BannerIndicator r15 = this.mIndicator;
        if (r15 == null) goto L6;
        r15.updateIndicators(r10, r11, r12, r13, r14);
        return;
    }

    public BannerView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public BannerView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mIndicatorHeight = -2;
        this.mIndicatorGap = Style.dp2px(6.0d);
        this.mIndicatorMargin = Style.dp2px(10.0d);
        this.mViewHolders = new ArrayList();
        this.mNextPageScrollDelay = -1;
        init();
    }
}
