package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.util.ImageUtils;
import java.util.Collections;
import java.util.List;
import org.apache.http.protocol.HttpRequestExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class BannerViewPager extends RelativeLayout implements ViewPager.OnPageChangeListener {
    public static final int GRAVITY_CENTER = 1;
    BannerViewPageAdapter mAdapter;
    private List<String> mBannerUrls;
    private Context mContext;
    private BannerIndicator mIndicator;
    private int mIndicatorGap;
    private RelativeLayout.LayoutParams mIndicatorLayoutParams;
    private int mIndicatorMargin;
    private UltraViewPager mUltraViewPager;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.widget.BannerViewPager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BannerIndicator extends LinearLayout {
        private ImageView[] mImageViews;
        final /* synthetic */ BannerViewPager this$0;

        public BannerIndicator(BannerViewPager r10, Context r11) {
            this.this$0 = r10;
            super(r11);
        }

        public void setCurrItem(int r10) {
            if (this.mImageViews == null) goto L14;
            int r11 = 0;
        L5:
            ImageView[] r12 = this.mImageViews;
            if (r11 >= r12.length) goto L18;
            ImageView r13 = r12[r11];
            if (r13 == null) goto L13;
            if (r10 != r11) goto L11;
            int r14 = R$drawable.banner_indicator_active;
        L12:
            r13.setBackgroundResource(r14);
            goto L13
        L11:
            r14 = R$drawable.banner_indicator_nor;
        L13:
            r11 = r11 + 1;
            goto L5
        L18:
            return;
        }

        public void updateIndicators() {
            if (BannerViewPager.access$100(this.this$0).getAdapter() != null) goto L6;
            return;
        L6:
            if (BannerViewPager.access$200(this.this$0).size() <= 1) goto L8;
            setVisibility(0);
        L9:
            int r10 = BannerViewPager.access$200(this.this$0).size();
            ImageView[] r11 = this.mImageViews;
            if (r11 != null) goto L19;
            this.mImageViews = new ImageView[r10];
            int r12 = 0;
        L12:
            ImageView[] r13 = this.mImageViews;
            if (r12 >= r13.length) goto L36;
            r13[r12] = ImageUtils.createImageInstance(getContext());
            ImageView r14 = this.mImageViews[r12];
            if (r14 == null) goto L17;
            r14.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            addView(this.mImageViews[r12]);
        L17:
            r12 = r12 + 1;
        L36:
            int r15 = BannerViewPager.access$100(this.this$0).getCurrentItem();
            int r16 = 0;
        L37:
            ImageView[] r17 = this.mImageViews;
            if (r16 >= r17.length) goto L47;
            ImageView r18 = r17[r16];
            if (r18 == null) goto L46;
            LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) r18.getLayoutParams();
            r19.width = Style.dp2px(6.0d);
            r19.height = Style.dp2px(6.0d);
            r19.setMargins(0, BannerViewPager.access$300(this.this$0), BannerViewPager.access$400(this.this$0), Style.dp2px(20.0d));
            ImageView r20 = this.mImageViews[r16];
            if (r15 != r16) goto L44;
            int r21 = R$drawable.banner_indicator_active;
        L45:
            r20.setBackgroundResource(r21);
            goto L46
        L44:
            r21 = R$drawable.banner_indicator_nor;
        L46:
            r16 = r16 + 1;
            goto L37
        L47:
            return;
        L19:
            if (r11.length == r10) goto L36;
            int r22 = 0;
        L21:
            ImageView[] r23 = this.mImageViews;
            if (r22 >= r23.length) goto L24;
            removeView(r23[r22]);
            r22 = r22 + 1;
            goto L21
        L24:
            ImageView[] r24 = new ImageView[r10];
            this.mImageViews = r24;
            System.arraycopy(r23, 0, r24, 0, Math.min(r23.length, r10));
            int r25 = 0;
        L25:
            ImageView[] r26 = this.mImageViews;
            if (r25 >= r26.length) goto L36;
            if (r26[r25] != null) goto L32;
            r26[r25] = ImageUtils.createImageInstance(getContext());
            ImageView r27 = this.mImageViews[r25];
            if (r27 == null) goto L32;
            r27.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        L32:
            ImageView r28 = this.mImageViews[r25];
            if (r28 == null) goto L35;
            addView(r28);
        L35:
            r25 = r25 + 1;
            goto L25
        L8:
            setVisibility(8);
            goto L9
        }
    }

    public class BannerViewPageAdapter extends PagerAdapter {
        final /* synthetic */ BannerViewPager this$0;

        private BannerViewPageAdapter(BannerViewPager r10) {
            this.this$0 = r10;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup r10, int r11, Object r12) {
            if ((r12 instanceof View) == false) goto L6;
            r10.removeView((View) r12);
            return;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (BannerViewPager.access$200(this.this$0) != null) goto L7;
            return 0;
        L7:
            return BannerViewPager.access$200(this.this$0).size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup r10, int r11) {
            View r12 = LayoutInflater.from(BannerViewPager.access$500(this.this$0)).inflate(R$layout.topic_header_banner, r10, false);
            NetworkImageView r13 = (NetworkImageView) r12.findViewById(R$id.topic_banner);
            r13.setVisibility(0);
            loadTopicBanner(r13, (String) BannerViewPager.access$200(this.this$0).get(r11));
            r10.addView(r12);
            return r12;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View r10, Object r11) {
            if (r10 != r11) goto L4;
            return true;
        L4:
            return false;
        }

        public void loadTopicBanner(NetworkImageView r10, String r11) {
            r10.setImageUrl(r11);
        }

        public /* synthetic */ BannerViewPageAdapter(BannerViewPager r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public BannerViewPager(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ UltraViewPager access$100(BannerViewPager r10) {
        return r10.mUltraViewPager;
    }

    public static /* synthetic */ List access$200(BannerViewPager r10) {
        return r10.mBannerUrls;
    }

    public static /* synthetic */ int access$300(BannerViewPager r10) {
        return r10.mIndicatorMargin;
    }

    public static /* synthetic */ int access$400(BannerViewPager r10) {
        return r10.mIndicatorGap;
    }

    public static /* synthetic */ Context access$500(BannerViewPager r10) {
        return r10.mContext;
    }

    private void init() {
        UltraViewPager r10 = new UltraViewPager(getContext());
        this.mUltraViewPager = r10;
        r10.setAutoMeasureHeight(true);
        this.mUltraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        this.mUltraViewPager.setAutoScroll(HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
        this.mUltraViewPager.setInfiniteLoop(true);
        UltraViewPager r11 = this.mUltraViewPager;
        int r12 = R$id.TANGRAM_BANNER_ID;
        r11.setId(r12);
        this.mIndicator = new BannerIndicator(this, getContext());
        addView(this.mUltraViewPager);
        addView(this.mIndicator, new LinearLayout.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams r13 = (RelativeLayout.LayoutParams) this.mIndicator.getLayoutParams();
        this.mIndicatorLayoutParams = r13;
        r13.addRule(8, r12);
        this.mIndicator.setPadding(this.mIndicatorGap, 0, 0, 0);
        this.mIndicator.updateIndicators();
        this.mIndicator.setGravity(1);
        this.mAdapter = new BannerViewPageAdapter(this, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mAdapter == null) goto L6;
        setBannerUrls(this.mBannerUrls);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int r10) {
        this.mIndicator.setCurrItem(this.mUltraViewPager.getCurrentItem());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int r10, float r11, int r12) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int r10) {
    }

    public void setAdapter(PagerAdapter r10) {
        this.mUltraViewPager.setAdapter(r10);
        this.mUltraViewPager.setOnPageChangeListener(this);
    }

    public void setBannerUrls(List<String> r10) {
        if (r10 == null) goto L8;
        this.mBannerUrls = r10;
        setAdapter(this.mAdapter);
        this.mIndicator.updateIndicators();
        this.mAdapter.notifyDataSetChanged();
        if (r10.size() != 1) goto L6;
        this.mUltraViewPager.disableAutoScroll();
        this.mUltraViewPager.setInfiniteLoop(false);
        return;
    L6:
        this.mUltraViewPager.setInfiniteLoop(true);
        this.mUltraViewPager.setAutoScroll(HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
        return;
    }

    public BannerViewPager(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public BannerViewPager(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mBannerUrls = Collections.emptyList();
        this.mIndicatorGap = Style.dp2px(6.0d);
        this.mIndicatorMargin = Style.dp2px(10.0d);
        this.mContext = r10;
        init();
    }
}
