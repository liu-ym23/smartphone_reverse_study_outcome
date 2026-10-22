package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayNewAdBannerCarouselView extends FrameLayout {
    private static final int FIRST_PAGE = 1;
    private static final int mAutoPlayTime = 2000;
    private int currentPosition;
    private float downX;
    private float downY;
    private boolean isAutoPlay;
    private List<Integer> mAutoPlayTimes;
    private Handler mHandler;
    private volatile boolean mIsMoveEvent;
    private LinearLayout mLayoutDots;
    private OnItemBannerClick mListener;
    private LinkedList<String> mNetImage;
    private OnItemShow mOnItemShowListener;
    private int mRealBannerCount;
    private ViewPager mViewPager;

    public class BannerAdapter extends PagerAdapter {
        final /* synthetic */ CJPayNewAdBannerCarouselView this$0;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View r100, Object r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CJPayNewAdBannerCarouselView.access$300(this.this$0).size();
        }

        public BannerAdapter(CJPayNewAdBannerCarouselView r100) {
            this.this$0 = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup r100, int r101) {
            ImageView r102 = new ImageView(this.this$0.getContext());
            r102.setScaleType(ImageView.ScaleType.CENTER_CROP);
            CJPayNewAdBannerCarouselView r103 = this.this$0;
            CJPayNewAdBannerCarouselView.access$900(r103, (String) CJPayNewAdBannerCarouselView.access$300(r103).get(r101), r102);
            r100.addView(r102);
            return r102;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup r100, int r101, Object r102) {
            r100.removeView((View) r102);
        }
    }

    public interface OnItemBannerClick {
        void onItemClick(int r100);
    }

    public interface OnItemShow {
        void onItemShow(int r100);
    }

    public void stop() {
        this.isAutoPlay = false;
        stopAutoPlay();
    }

    private void createDots() {
        int r100 = this.mRealBannerCount;
        if (r100 > 1) goto L5;
        return;
    L5:
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L12;
        ImageView r102 = new ImageView(getContext());
        if (r101 != 0) goto L10;
        r102.setImageResource(R.drawable.cj_pay_bg_banner_point_select);
    L11:
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.setMargins(CJPayBasicUtils.dipToPX(getContext(), 5.0f), 0, CJPayBasicUtils.dipToPX(getContext(), 5.0f), 0);
        this.mLayoutDots.addView(r102, r103);
        r101 = r101 + 1;
        goto L6
    L10:
        r102.setImageResource(R.drawable.cj_pay_bg_banner_point_normal);
        goto L11
    }

    private void initViewPager() {
        this.mViewPager.setAdapter(new BannerAdapter(this));
        if (this.mRealBannerCount != 1) goto L5;
        this.mViewPager.setCurrentItem(0);
    L6:
        onItemShow(1);
        this.mViewPager.addOnPageChangeListener(new AnonymousClass1(this));
        return;
    L5:
        this.mViewPager.setCurrentItem(1);
        goto L6
    }

    private void stopAutoPlay() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public int getCurrentAutoPlayTime() {
        List<Integer> r100 = this.mAutoPlayTimes;
        if (r100 != null) goto L5;
        return 2000;
    L5:
        int r101 = this.currentPosition;
        if ((r101 - 1) >= 0) goto L8;
    L12:
        return 2000;
    L8:
        if ((r101 - 1) >= r100.size()) goto L12;
        return ((Integer) ListProtector.get(this.mAutoPlayTimes, this.currentPosition - 1)).intValue();
    }

    private void intViews() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_view_ad_banner_carousel_layout, this, true);
        this.mViewPager = (ViewPager) r100.findViewById(R.id.cj_pay_ad_banner_pager);
        this.mLayoutDots = (LinearLayout) r100.findViewById(R.id.cj_pay_ad_banner_dots);
    }

    private void startAutoPlay() {
        stopAutoPlay();
        this.mHandler.postDelayed(new AnonymousClass2(this), getCurrentAutoPlayTime());
    }

    public void start() {
        stop();
        this.isAutoPlay = true;
        if (this.mRealBannerCount <= 1) goto L6;
        startAutoPlay();
        return;
    }

    public CJPayNewAdBannerCarouselView(Context r100) {
        super(r100);
        this.currentPosition = 1;
        this.mHandler = new Handler();
        this.isAutoPlay = true;
        intViews();
    }

    public static /* synthetic */ void access$000(CJPayNewAdBannerCarouselView r100) {
        r100.stopAutoPlay();
    }

    public static /* synthetic */ int access$100(CJPayNewAdBannerCarouselView r100) {
        return r100.mRealBannerCount;
    }

    public static /* synthetic */ int access$200(CJPayNewAdBannerCarouselView r100) {
        return r100.currentPosition;
    }

    public static /* synthetic */ int access$208(CJPayNewAdBannerCarouselView r100) {
        int r101 = r100.currentPosition;
        r100.currentPosition = r101 + 1;
        return r101;
    }

    public static /* synthetic */ LinkedList access$300(CJPayNewAdBannerCarouselView r100) {
        return r100.mNetImage;
    }

    public static /* synthetic */ ViewPager access$600(CJPayNewAdBannerCarouselView r100) {
        return r100.mViewPager;
    }

    public static /* synthetic */ boolean access$700(CJPayNewAdBannerCarouselView r100) {
        return r100.isAutoPlay;
    }

    public static /* synthetic */ void access$800(CJPayNewAdBannerCarouselView r100) {
        r100.startAutoPlay();
    }

    private void onItemShow(int r100) {
        OnItemShow r101 = this.mOnItemShowListener;
        if (r101 == null) goto L6;
        r101.onItemShow(r100);
        return;
    }

    private void updateDot(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.mRealBannerCount) goto L17;
        int r101 = this.mLayoutDots.getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L18;
        ImageView r103 = (ImageView) this.mLayoutDots.getChildAt(r102);
        if (r100 != r102) goto L11;
        r103.setImageResource(R.drawable.cj_pay_bg_banner_point_select);
    L12:
        r102 = r102 + 1;
        goto L7
    L11:
        r103.setImageResource(R.drawable.cj_pay_bg_banner_point_normal);
        goto L12
    L18:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.isAutoPlay == false) goto L23;
        int r101 = r100.getAction();
        if (r101 == 0) goto L21;
        if (r101 != 1) goto L8;
        this.downX = 0.0f;
        this.downY = 0.0f;
        if (this.mIsMoveEvent == true) goto L20;
        OnItemBannerClick r102 = this.mListener;
        if (r102 == null) goto L20;
        r102.onItemClick(this.currentPosition);
    L20:
        this.mIsMoveEvent = false;
        goto L23
    L8:
        if (r101 != 2) goto L23;
        if (Math.abs(r100.getRawX() - this.downX) <= 100.0f) goto L13;
    L14:
        this.mIsMoveEvent = true;
        goto L23
    L13:
        if (Math.abs(r100.getRawY() - this.downY) <= 100.0f) goto L23;
    L21:
        this.downX = r100.getRawX();
        this.downY = r100.getRawY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L23:
        return super.dispatchTouchEvent(r100);
    }

    public void setAutoPlay(boolean r100) {
        this.isAutoPlay = r100;
    }

    public void setAutoPlayTimes(List<Integer> r100) {
        this.mAutoPlayTimes = r100;
    }

    public void setNetImage(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L16;
        this.mRealBannerCount = r100.size();
        LinkedList<String> r101 = new LinkedList();
        this.mNetImage = r101;
        int r102 = this.mRealBannerCount;
        if (r102 != 1) goto L10;
        r101.addAll(r100);
        initViewPager();
        return;
    L10:
        if (r102 < 2) goto L15;
        r101.addAll(r100);
        this.mNetImage.addFirst((String) ListProtector.get(r100, r100.size() - 1));
        this.mNetImage.addLast((String) ListProtector.get(r100, 0));
        createDots();
        initViewPager();
        return;
    L15:
        return;
    }

    public void setOnItemClickListener(OnItemBannerClick r100) {
        this.mListener = r100;
    }

    public void setOnItemShowListener(OnItemShow r100) {
        this.mOnItemShowListener = r100;
    }

    public CJPayNewAdBannerCarouselView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.currentPosition = 1;
        this.mHandler = new Handler();
        this.isAutoPlay = true;
        intViews();
    }

    public static /* synthetic */ int access$202(CJPayNewAdBannerCarouselView r100, int r101) {
        r100.currentPosition = r101;
        return r101;
    }

    public static /* synthetic */ void access$400(CJPayNewAdBannerCarouselView r100, int r101) {
        r100.updateDot(r101);
    }

    public static /* synthetic */ void access$500(CJPayNewAdBannerCarouselView r100, int r101) {
        r100.onItemShow(r101);
    }

    private void loadImage(final String r100, final ImageView r101) {
        r101.setTag(r100);
        ImageLoader.Companion.getInstance().loadImage(r100, new AnonymousClass3(this, r100, r101));
    }

    public CJPayNewAdBannerCarouselView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.currentPosition = 1;
        this.mHandler = new Handler();
        this.isAutoPlay = true;
        intViews();
    }

    public static /* synthetic */ void access$900(CJPayNewAdBannerCarouselView r100, String r101, ImageView r102) {
        r100.loadImage(r101, r102);
    }

    public CJPayNewAdBannerCarouselView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.currentPosition = 1;
        this.mHandler = new Handler();
        this.isAutoPlay = true;
        intViews();
    }
}
