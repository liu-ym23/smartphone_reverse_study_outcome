package com.bytedance.android.livesdk.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdkapi.view.ISupportNestedScrollViewPager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class LiveTabIndicator extends HorizontalScrollView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f124586g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f124587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f124588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f124589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, Boolean> f124590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<e> f124591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f124592f;

    public interface a {
        void a(e r100);
    }

    public class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<e> f124593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveTabIndicator f124594b;

        public b(LiveTabIndicator r100, List<e> r101) {
            this.f124594b = r100;
            this.f124593a = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            LiveTabIndicator r109 = this.f124594b;
            List<e> r110 = this.f124593a;
            int r111 = LiveTabIndicator.f124586g;
            r109.b(r110);
            this.f124594b.removeOnLayoutChangeListener(this);
        }
    }

    private ISupportNestedScrollViewPager getParentViewPager() {
        ViewParent r100 = this;
    L3:
        if (r100 == null) goto L8;
        if ((r100 instanceof ISupportNestedScrollViewPager) == true) goto L8;
        r100 = r100.getParent();
    L8:
        return (ISupportNestedScrollViewPager) r100;
    }

    public int getLayoutId() {
        return R.layout.ttlive_view_live_tab;
    }

    public int getItemGap() {
        if (this.f124591e.size() > 5) goto L21;
        if (this.f124591e.size() <= 1) goto L21;
        TextPaint r100 = new TextPaint();
        Resources r101 = getResources();
        r100.setTextSize(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).scaledDensity * 16.0f);
        Context r102 = getContext();
        if (this.f124591e.size() > 5) goto L9;
        float r103 = (MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS / this.f124591e.size()) - 32;
    L10:
        float r104 = UIUtils.dip2Px(r102, r103);
        Iterator<e> r105 = this.f124591e.iterator();
        int r106 = 0;
    L12:
        if (r105.hasNext() == false) goto L18;
        float r107 = r100.measureText(r105.next().i());
        float r108 = r106;
        if (r107 > r104) goto L17;
        r107 = r104;
    L17:
        r106 = (int) (r108 + r107);
        goto L12
    L18:
        int r109 = getWidth();
        int[] r110 = getLeftAndRightPadding();
        return (((r109 - r110[0]) - r110[1]) - r106) / (this.f124591e.size() - 1);
    L9:
        r103 = 48.0f;
    L21:
        return (int) UIUtils.dip2Px(getContext(), 30.0f);
    }

    public int[] getLeftAndRightPadding() {
        if (this.f124591e.size() != 1) goto L6;
        TextPaint r100 = new TextPaint();
        Resources r101 = getResources();
        r100.setTextSize(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 16.0f);
        int r102 = (int) ((UIUtils.getScreenWidth(getContext()) - r100.measureText(((e) ListProtector.get(this.f124591e, 0)).i())) / 2.0f);
        return new int[]{r102, r102};
    L6:
        int r103 = (int) UIUtils.dip2Px(getContext(), 16.0f);
        return new int[]{r103, r103};
    }

    public final void a() {
        HorizontalScrollView.inflate(getContext(), getLayoutId(), this);
        setHorizontalScrollBarEnabled(false);
        this.f124587a = (LinearLayout) findViewById(R.id.container_root);
    }

    public LiveTabIndicator(Context r100) {
        super(r100);
        this.f124589c = true;
        this.f124590d = new HashMap();
        a();
    }

    public final void b(List<e> r110) {
        LinearLayout r100 = this.f124587a;
        if (r100 == null) goto L43;
        r100.removeAllViews();
        if (CollectionUtils.isEmpty(r110) == true) goto L44;
        this.f124591e = r110;
        final int r101 = 0;
    L8:
        if (r101 >= r110.size()) goto L37;
        final e r102 = (e) ListProtector.get(r110, r101);
        if (r101 == 0) goto L12;
    L14:
        final yw1.a r103 = new yw1.a(getContext());
        Context r104 = getContext();
        float r105 = 48.0f;
        if (this.f124591e.size() > 5) goto L17;
        float r106 = (MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS / this.f124591e.size()) - 32;
    L18:
        float r107 = UIUtils.dip2Px(r104, r106);
        TextPaint r108 = new TextPaint();
        float r111 = r108.measureText(r102.i());
        Resources r112 = getResources();
        r108.setTextSize(WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density * 16.0f);
        if (r107 > r111) goto L22;
        r107 = r111;
    L22:
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams((int) r107, -1);
        int[] r113 = getLeftAndRightPadding();
        int r114 = getItemGap();
        if (r101 != 0) goto L26;
        r109.setMargins(r113[0], 0, 0, 0);
        r109.setMarginStart(r113[0]);
        r109.setMarginEnd(0);
    L29:
        r103.setLayoutParams(r109);
        r103.setGravity(17);
        r103.setTextAlignment(4);
        r103.setTextColor(getResources().getColorStateList(R.color.ttlive_live_tab_text));
        r103.setText(r102.i());
        Context r115 = getContext();
        if (this.f124591e.size() > 5) goto L32;
        r105 = (MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS / this.f124591e.size()) - 32;
    L32:
        r103.setIndicatorWidth((int) UIUtils.dip2Px(r115, r105));
        if (((HashMap) this.f124590d).containsKey(Long.valueOf(r102.f())) == false) goto L35;
        r103.setChecked(((Boolean) ((HashMap) this.f124590d).get(Long.valueOf(r102.f()))).booleanValue());
    L35:
        r103.f569335a.setTextSize(1, 16.0f);
        r103.setOnClickListener(new cx1.a(this, r101, r102, r103));
        this.f124587a.addView(r103);
        r101 = r101 + 1;
        goto L8
    L26:
        if (r101 != (this.f124591e.size() - 1)) goto L28;
        r109.setMargins(r114, 0, r113[1], 0);
        r109.setMarginStart(r114);
        r109.setMarginEnd(r113[1]);
        goto L29
    L28:
        r109.setMargins(r114, 0, 0, 0);
        r109.setMarginStart(r114);
        r109.setMarginEnd(0);
        goto L29
    L17:
        r106 = 48.0f;
        goto L18
    L12:
        if (this.f124589c == false) goto L14;
        ((HashMap) this.f124590d).put(Long.valueOf(r102.f()), Boolean.TRUE);
        this.f124589c = false;
        goto L14
    L37:
        if (r110.size() != 1) goto L45;
        setVisibility(8);
        return;
    L45:
        return;
    L44:
        return;
    }

    public final void c(e r110) {
        int r100 = this.f124587a.getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        yw1.a r102 = (yw1.a) this.f124587a.getChildAt(r101);
        long r103 = ((e) ListProtector.get(this.f124591e, r101)).f();
        if (r103 != r110.f()) goto L7;
        r102.setChecked(true);
        Map<Long, Boolean> r104 = this.f124590d;
        HashMap r105 = (HashMap) r104;
        r105.put(Long.valueOf(r103), Boolean.TRUE);
        ((e) ListProtector.get(this.f124591e, r101)).f124012a = true;
    L8:
        r101 = r101 + 1;
        goto L3
    L7:
        r102.setChecked(false);
        Map<Long, Boolean> r106 = this.f124590d;
        HashMap r107 = (HashMap) r106;
        r107.put(Long.valueOf(r103), Boolean.FALSE);
        ((e) ListProtector.get(this.f124591e, r101)).f124012a = false;
        goto L8
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = super.onInterceptTouchEvent(r100);
        if (r100.getAction() != 0) goto L8;
        ISupportNestedScrollViewPager r102 = getParentViewPager();
        if (r102 == null) goto L16;
        r102.supportNestViewPagerNoScroll(false);
    L16:
        return r101;
    L8:
        if (r100.getAction() != 2) goto L13;
        if (r101 == false) goto L16;
        ISupportNestedScrollViewPager r103 = getParentViewPager();
        if (r103 == null) goto L16;
        r103.supportNestViewPagerNoScroll(false);
        goto L16
    L13:
        ISupportNestedScrollViewPager r104 = getParentViewPager();
        if (r104 == null) goto L16;
        r104.supportNestViewPagerNoScroll(true);
        goto L16
    }

    public void setOnTabClickListener(a r100) {
        this.f124588b = r100;
    }

    public void setTitles(List<e> r100) {
        if (getWidth() == 0) goto L6;
        b(r100);
        return;
    L6:
        if (this.f124592f != null) goto L8;
        this.f124592f = new b(this, r100);
    L8:
        b r101 = this.f124592f;
        r101.f124593a = r100;
        removeOnLayoutChangeListener(r101);
        addOnLayoutChangeListener(this.f124592f);
    }

    public LiveTabIndicator(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f124589c = true;
        this.f124590d = new HashMap();
        a();
    }

    public LiveTabIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f124589c = true;
        this.f124590d = new HashMap();
        a();
    }
}
