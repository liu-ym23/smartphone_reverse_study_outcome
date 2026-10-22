package com.obric.oui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.m;
import java.util.List;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OBanner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBanner extends RadiusLayout implements com.obric.oui.banner.b.a {
    public static final b Companion = null;
    public static final long DEFAULT_AUTO_SWITCH_INTERVAL_MS = 5000;
    public static final float DEFAULT_TRIPTYCH_BANNER_RATIO = 0.5625f;
    public static final int INVALID_VALUE = -1;
    public static final String TAG = "OBanner";
    private v<Integer> _selectedPosition;
    private final d.f adapter$delegate;
    private final Runnable checkAutoPlayRunnable;
    private final d.f compositePageTransformer$delegate;
    private long delayAfterUserTouch;
    private boolean haveVibratedAfterUserDragging;
    private boolean isAutoSwitchEnabled;
    private boolean isPadGridAdaptEnable;
    private boolean isUserDragging;
    private long lastUserTouchTime;
    private com.obric.oui.banner.b.b mBannerItemClickListener;
    private com.obric.oui.banner.c mBannerStyle;
    private int mLastWindowWidth;
    private ViewPager2.e mOnPageChangeListener;
    private a mPageChangeCallback;
    private w<com.obric.oui.window.a.g> mWindowGridConfigObserver;
    private androidx.viewpager2.widget.e marginPageTransformer;
    private boolean pageInvalid;
    private float proportion;
    private int startPosition;
    private float triptychBannerRatio;
    private final d.f viewPager2$delegate;

    /* JADX INFO: compiled from: OBanner.kt */
    public final class a extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBanner f34012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34013b;

        /* JADX INFO: renamed from: com.obric.oui.banner.OBanner$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OBanner.kt */
        public /* synthetic */ class C0924a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f34014a = null;

            static {
                int[] r0 = new int[com.obric.oui.banner.c.values().length];
                r0[com.obric.oui.banner.c.f34044c.ordinal()] = 1;
                f34014a = r0;
            }
        }

        public a(OBanner r2) {
            o.e(r2, "this$0");
            this.f34012a = r2;
            this.f34013b = -1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(int r5, float r6, int r7) {
            int r8 = com.obric.oui.banner.c.a.f34047a.a(this.f34012a.isInfiniteSwitchEnabled(), r5, this.f34012a.getRealCount());
            boolean r1 = false;
            if (C0924a.f34014a[OBanner.access$getMBannerStyle$p(this.f34012a).ordinal()] != 1) goto L8;
            if (r8 != (((this.f34012a.getCurrentItem() - 2) + this.f34012a.getRealCount()) % this.f34012a.getRealCount())) goto L11;
        L9:
            r1 = true;
        L11:
            if (OBanner.access$getMOnPageChangeListener$p(this.f34012a) == null) goto L18;
            if (r1 == false) goto L19;
            ViewPager2.e r4 = OBanner.access$getMOnPageChangeListener$p(this.f34012a);
            if (r4 == null) goto L20;
            r4.a(r8, r6, r7);
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L8:
            if (r8 != (this.f34012a.getCurrentItem() - 1)) goto L11;
            goto L9
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void b(int r4) {
            int r0 = com.obric.oui.banner.c.a.f34047a.a(this.f34012a.isInfiniteSwitchEnabled(), r4, this.f34012a.getRealCount());
            this.f34013b = r4;
            if (OBanner.access$getMOnPageChangeListener$p(this.f34012a) == null) goto L8;
            ViewPager2.e r1 = OBanner.access$getMOnPageChangeListener$p(this.f34012a);
            if (r1 == null) goto L8;
            r1.b(r0);
        L8:
            OBanner.access$setPageInvalid$p(this.f34012a, false);
            OBanner.access$get_selectedPosition$p(this.f34012a).b(Integer.valueOf(r0));
            if (OBanner.access$getHaveVibratedAfterUserDragging$p(this.f34012a) == true) goto L12;
            com.obric.oui.d.a.b.b(OBanner.TAG, "onPageSelected, position: " + r4 + ", realPosition: " + r0);
            com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f34012a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 3);
            OBanner.access$setHaveVibratedAfterUserDragging$p(this.f34012a, true);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(int r5) {
            if (r5 != 0) goto L29;
            if (this.f34013b == (-1)) goto L29;
            if (C0924a.f34014a[OBanner.access$getMBannerStyle$p(this.f34012a).ordinal()] != 1) goto L19;
            int r0 = this.f34013b;
            if (r0 != 0) goto L10;
            OBanner r1 = this.f34012a;
            r1.setCurrentItem(r1.getStartPosition(), false);
            goto L29
        L10:
            if (r0 != 1) goto L13;
            OBanner r2 = this.f34012a;
            r2.setCurrentItem(r2.getStartPosition() + 1, false);
            goto L29
        L13:
            if (r0 != (this.f34012a.getItemCount() - 1)) goto L16;
            OBanner r3 = this.f34012a;
            r3.setCurrentItem(r3.getStartPosition() - 1, false);
            goto L29
        L16:
            if (r0 != (this.f34012a.getItemCount() - 2)) goto L29;
            OBanner r4 = this.f34012a;
            r4.setCurrentItem(r4.getStartPosition(), false);
            goto L29
        L19:
            if (this.f34013b == (-1)) goto L29;
            if (this.f34012a.isInfiniteSwitchEnabled() == false) goto L29;
            int r6 = this.f34013b;
            if (r6 != 0) goto L26;
            OBanner r7 = this.f34012a;
            r7.setCurrentItem(r7.getRealCount(), false);
            goto L29
        L26:
            if (r6 != (this.f34012a.getItemCount() - 1)) goto L29;
            this.f34012a.setCurrentItem(1, false);
        L29:
            if (OBanner.access$getMOnPageChangeListener$p(this.f34012a) == null) goto L35;
            ViewPager2.e r8 = OBanner.access$getMOnPageChangeListener$p(this.f34012a);
            if (r8 == null) goto L36;
            r8.a(r5);
            return;
        L36:
            return;
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final com.obric.oui.banner.c a(int r1) {
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L13;
            return com.obric.oui.banner.c.f34042a;
        L13:
            return com.obric.oui.banner.c.f34044c;
        L14:
            return com.obric.oui.banner.c.f34043b;
        L11:
            return com.obric.oui.banner.c.f34042a;
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34015a = null;

        static {
            int[] r0 = new int[com.obric.oui.banner.c.values().length];
            r0[com.obric.oui.banner.c.f34044c.ordinal()] = 1;
            r0[com.obric.oui.banner.c.f34042a.ordinal()] = 2;
            r0[com.obric.oui.banner.c.f34043b.ordinal()] = 3;
            f34015a = r0;
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    static final class d extends p implements d.h.a.a<com.obric.oui.banner.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBanner f34016a;

        /* JADX INFO: compiled from: OBanner.kt */
        public static final class a implements com.obric.oui.banner.b.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OBanner f34017a;

            /* JADX INFO: renamed from: com.obric.oui.banner.OBanner$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: OBanner.kt */
            public /* synthetic */ class C0925a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f34018a = null;

                static {
                    int[] r0 = new int[com.obric.oui.banner.c.values().length];
                    r0[com.obric.oui.banner.c.f34044c.ordinal()] = 1;
                    f34018a = r0;
                }
            }

            a(OBanner r1) {
                this.f34017a = r1;
            }

            @Override // com.obric.oui.banner.b.b
            public void a(com.obric.oui.banner.b r3, int r4) {
                com.obric.oui.banner.b r5 = (com.obric.oui.banner.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.class, "com.obric.aiagent.plugin");
                o.e(r5, "data");
                com.obric.oui.banner.c r0 = OBanner.access$getMBannerStyle$p(this.f34017a);
                if (C0925a.f34018a[r0.ordinal()] != 1) goto L5;
                OBanner.access$onTriptychBannerItemClick(this.f34017a, r5, r4);
                return;
            L5:
                com.obric.oui.banner.b.b r2 = OBanner.access$getMBannerItemClickListener$p(this.f34017a);
                if (r2 == null) goto L11;
                r2.a(r5, r4);
                return;
            }
        }

        d(OBanner r1) {
            this.f34016a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ com.obric.oui.banner.a invoke() {
            return a();
        }

        public final com.obric.oui.banner.a a() {
            com.obric.oui.banner.a r0 = new com.obric.oui.banner.a((com.obric.oui.banner.b.a) ZeusTransformUtils.preCheckCast(this.f34016a, com.obric.oui.banner.b.a.class, "com.obric.aiagent.plugin"));
            r0.a((com.obric.oui.banner.b.b) ZeusTransformUtils.preCheckCast(new a(this.f34016a), com.obric.oui.banner.b.b.class, "com.obric.aiagent.plugin"));
            return r0;
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    static final class e extends p implements d.h.a.a<androidx.viewpager2.widget.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f34019a = null;

        static {
            f34019a = new e();
        }

        e() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.viewpager2.widget.c invoke() {
            return a();
        }

        public final androidx.viewpager2.widget.c a() {
            androidx.viewpager2.widget.c r4 = new androidx.viewpager2.widget.c();
            r4.a((ViewPager2.g) ZeusTransformUtils.preCheckCast(new com.obric.oui.banner.g(0, 1, null), ViewPager2.g.class, "com.obric.aiagent.plugin"));
            return r4;
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    public static final class f extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBanner f34020a;

        f(OBanner r1) {
            this.f34020a = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(ViewGroup r4, View r5, AccessibilityEvent r6) {
            boolean r0 = false;
            if (r6 != null) goto L6;
        L8:
            if (r0 == false) goto L13;
            int r1 = OBanner.access$getAdapter(this.f34020a).h();
            r6.setItemCount(r1);
            if (r1 <= 0) goto L13;
            r6.setFromIndex(this.f34020a.getViewPager2().getCurrentItem() % r1);
            r6.setToIndex(this.f34020a.getViewPager2().getCurrentItem() % r1);
        L13:
            return super.a(r4, r5, r6);
        L6:
            if (r6.getEventType() != 4096) goto L8;
            r0 = true;
            goto L8
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    static final class g extends p implements d.h.a.a<ViewPager2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f34021a;

        g(Context r3) {
            this.f34021a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ViewPager2 invoke() {
            return a();
        }

        public final ViewPager2 a() {
            ViewPager2 r0 = new ViewPager2(this.f34021a);
            r0.setOffscreenPageLimit(1);
            return r0;
        }
    }

    static {
        Companion = new b(null);
    }

    public OBanner(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBanner(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$0-ungOTZ52eHcVdcrVvgWrSHFfA, reason: not valid java name */
    public static /* synthetic */ void m973lambda$0ungOTZ52eHcVdcrVvgWrSHFfA(OBanner r0) {
        m972checkAutoPlayRunnable$lambda0(r0);
    }

    public static /* synthetic */ void lambda$K3o40ETndurApIgIhWPxJnsD294(OBanner r0) {
        m971adjustBannerParam$lambda7(r0);
    }

    public /* synthetic */ OBanner(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ com.obric.oui.banner.a access$getAdapter(OBanner r0) {
        return r0.getAdapter();
    }

    public static final /* synthetic */ boolean access$getHaveVibratedAfterUserDragging$p(OBanner r0) {
        return r0.haveVibratedAfterUserDragging;
    }

    public static final /* synthetic */ com.obric.oui.banner.b.b access$getMBannerItemClickListener$p(OBanner r0) {
        return r0.mBannerItemClickListener;
    }

    public static final /* synthetic */ com.obric.oui.banner.c access$getMBannerStyle$p(OBanner r0) {
        return r0.mBannerStyle;
    }

    public static final /* synthetic */ ViewPager2.e access$getMOnPageChangeListener$p(OBanner r0) {
        return r0.mOnPageChangeListener;
    }

    public static final /* synthetic */ v access$get_selectedPosition$p(OBanner r0) {
        return r0._selectedPosition;
    }

    public static final /* synthetic */ void access$onTriptychBannerItemClick(OBanner r2, com.obric.oui.banner.b r3, int r4) {
        r2.onTriptychBannerItemClick((com.obric.oui.banner.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ void access$setHaveVibratedAfterUserDragging$p(OBanner r0, boolean r1) {
        r0.haveVibratedAfterUserDragging = r1;
    }

    public static final /* synthetic */ void access$setPageInvalid$p(OBanner r0, boolean r1) {
        r0.pageInvalid = r1;
    }

    public OBanner(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r9, r7);
        this.delayAfterUserTouch = 5000;
        this.viewPager2$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.lastUserTouchTime = -1;
        this.adapter$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.checkAutoPlayRunnable = new $$Lambda$OBanner$0ungOTZ52eHcVdcrVvgWrSHFfA(this);
        this._selectedPosition = new v(0);
        this.compositePageTransformer$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(e.f34019a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.mBannerStyle = com.obric.oui.banner.c.f34042a;
        this.triptychBannerRatio = 0.5625f;
        this.mLastWindowWidth = -1;
        this.haveVibratedAfterUserDragging = true;
        if (r9 == null) goto L6;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.OBanner);
        o.c(r10, "context.obtainStyledAttr…trs, R.styleable.OBanner)");
        this.mBannerStyle = Companion.a(r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_style, "styleable", "OBanner_oui_banner_style"), 0));
        this.isPadGridAdaptEnable = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_is_pad_grid_adapt_enable, "styleable", "OBanner_oui_banner_is_pad_grid_adapt_enable"), false);
        setProportion(r10.getFloat(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_proportion, "styleable", "OBanner_oui_banner_proportion"), 0.0f));
        this.isAutoSwitchEnabled = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_enableAutoSwitch, "styleable", "OBanner_oui_banner_enableAutoSwitch"), false);
        this.delayAfterUserTouch = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_autoSwitchInterval, "styleable", "OBanner_oui_banner_autoSwitchInterval"), DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        setInfiniteSwitchEnabled(r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_enableInfiniteSwitch, "styleable", "OBanner_oui_banner_enableInfiniteSwitch"), true));
        r10.recycle();
        return;
    }

    public final long getDelayAfterUserTouch() {
        return this.delayAfterUserTouch;
    }

    public final void setDelayAfterUserTouch(long r1) {
        this.delayAfterUserTouch = r1;
    }

    public final boolean isInfiniteSwitchEnabled() {
        return getAdapter().g();
    }

    public final void setInfiniteSwitchEnabled(boolean r2) {
        getAdapter().b(r2);
        getAdapter().d();
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) ZeusTransformUtils.preCheckCast(this.viewPager2$delegate.b(), ViewPager2.class, "com.obric.aiagent.plugin");
    }

    public final long getLastUserTouchTime() {
        return this.lastUserTouchTime;
    }

    private final com.obric.oui.banner.a getAdapter() {
        return (com.obric.oui.banner.a) ZeusTransformUtils.preCheckCast(this.adapter$delegate.b(), com.obric.oui.banner.a.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: checkAutoPlayRunnable$lambda-0, reason: not valid java name */
    private static final void m972checkAutoPlayRunnable$lambda0(OBanner r1) {
        o.e(r1, "this$0");
        r1.checkAndSwitchPage();
    }

    private final androidx.viewpager2.widget.c getCompositePageTransformer() {
        return (androidx.viewpager2.widget.c) ZeusTransformUtils.preCheckCast(this.compositePageTransformer$delegate.b(), androidx.viewpager2.widget.c.class, "com.obric.aiagent.plugin");
    }

    public final int getRealCount() {
        return getAdapter().h();
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getItemCount() {
        return getAdapter().a();
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final void initViewPager2() {
        addView((View) ZeusTransformUtils.preCheckCast(getViewPager2(), View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        getViewPager2().setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(getAdapter(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        getViewPager2().setPageTransformer((ViewPager2.g) ZeusTransformUtils.preCheckCast(getCompositePageTransformer(), ViewPager2.g.class, "com.obric.aiagent.plugin"));
        a r0 = new a(this);
        getViewPager2().registerOnPageChangeCallback((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0, ViewPager2.e.class, "com.obric.aiagent.plugin"));
        this.mPageChangeCallback = r0;
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(getViewPager2(), View.class, "com.obric.aiagent.plugin"), (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(new f(this), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin"));
    }

    public final void setBannerItemClickListener(com.obric.oui.banner.b.b r3) {
        com.obric.oui.banner.b.b r4 = (com.obric.oui.banner.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mBannerItemClickListener = r4;
    }

    private final void onTriptychBannerItemClick(com.obric.oui.banner.b r6, int r7) {
        com.obric.oui.banner.b r8 = (com.obric.oui.banner.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.oui.banner.b.class, "com.obric.aiagent.plugin");
        int r0 = com.obric.oui.banner.c.a.f34047a.a(isInfiniteSwitchEnabled(), getCurrentItem(), getRealCount());
        if (getCurrentItem() != 2) goto L8;
        if (r7 != (getRealCount() - 1)) goto L8;
        setCurrentItem(1, true);
        return;
    L8:
        if (getCurrentItem() != (getItemCount() - 3)) goto L12;
        if (r7 != 0) goto L12;
        setCurrentItem(getItemCount() - 2, true);
        return;
    L12:
        if (r0 != (getRealCount() - 1)) goto L15;
        if (r7 != 0) goto L15;
        setCurrentItem(getCurrentItem() + 1, true);
        return;
    L15:
        if (r0 == 0) goto L17;
    L19:
        if (r0 <= r7) goto L21;
        setCurrentItem(getCurrentItem() - 1, true);
        return;
    L21:
        if (r0 >= r7) goto L23;
        setCurrentItem(getCurrentItem() + 1, true);
        return;
    L23:
        com.obric.oui.banner.b.b r5 = this.mBannerItemClickListener;
        if (r5 == null) goto L34;
        r5.a(r8, r7);
        return;
    L34:
        return;
    L17:
        if (r7 != (getRealCount() - 1)) goto L19;
        setCurrentItem(getCurrentItem() - 1, true);
    }

    public final void enableAutoSwitch() {
        this.isAutoSwitchEnabled = true;
        checkAndSwitchPage();
    }

    public final void disableAutoSwitch() {
        clearCheckTask();
        this.isAutoSwitchEnabled = false;
    }

    public final void release() {
        clearCheckTask();
        getAdapter().i();
        a r0 = this.mPageChangeCallback;
        if (r0 == null) goto L6;
        getViewPager2().unregisterOnPageChangeCallback((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0, ViewPager2.e.class, "com.obric.aiagent.plugin"));
    L6:
        androidx.lifecycle.p r2 = null;
        getViewPager2().setAdapter(null);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, androidx.lifecycle.p.class) == false) goto L9;
        r2 = (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r1, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
    L9:
        if (r2 == null) goto L13;
        com.obric.oui.window.a.f36851a.a(r2, this.mWindowGridConfigObserver);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 != null) goto L4;
        Integer r0 = null;
    L5:
        boolean r2 = true;
        if (r0 != null) goto L9;
    L11:
        if (r0 == null) goto L17;
        if (r0.intValue() != 1) goto L17;
    L23:
        if (r2 == false) goto L26;
        this.isUserDragging = false;
        this.lastUserTouchTime = SystemClock.uptimeMillis();
        checkAndSwitchPage();
    L26:
        return super.dispatchTouchEvent(r5);
    L17:
        if (r0 != null) goto L20;
    L22:
        r2 = false;
        goto L23
    L20:
        if (r0.intValue() != 3) goto L22;
    L9:
        if (r0.intValue() != 0) goto L11;
        this.isUserDragging = true;
        this.haveVibratedAfterUserDragging = false;
        goto L26
    L4:
        r0 = Integer.valueOf(r5.getAction());
        goto L5
    }

    public final void switchNext() {
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
    }

    public final void switchPrevious() {
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() - 1, true);
    }

    public final void setData(List<? extends com.obric.oui.banner.b> r4) {
        List<? extends com.obric.oui.banner.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "dataSet");
        getAdapter().a(r5);
        int r1 = 1;
        if (r5.size() != 1) goto L6;
        disableAutoSwitch();
        setInfiniteSwitchEnabled(false);
    L6:
        if (isInfiniteSwitchEnabled() == false) goto L9;
        r1 = getRealCount() * 100;
    L12:
        this.startPosition = r1;
        setCurrentItem(r1, false);
        getViewPager2().requestTransform();
        return;
    L9:
        if (c.f34015a[this.mBannerStyle.ordinal()] == 1) goto L12;
        r1 = 0;
        goto L12
    }

    public void currentItemPlayDone() {
        this.pageInvalid = true;
        checkAndSwitchPage();
    }

    @Override // com.obric.oui.banner.b.a
    public LiveData<Integer> getSelectedPosition() {
        return (LiveData) ZeusTransformUtils.preCheckCast(this._selectedPosition, LiveData.class, "com.obric.aiagent.plugin");
    }

    public long getAutoSwitchIntervalMs() {
        return this.delayAfterUserTouch;
    }

    private final void checkAndSwitchPage() {
        if (this.isAutoSwitchEnabled == true) goto L5;
    L27:
        com.obric.oui.common.util.f.a("检查换页：开关 false，不换页");
        return;
    L5:
        if (this.delayAfterUserTouch <= 0) goto L27;
        if (this.isUserDragging == false) goto L12;
        com.obric.oui.common.util.f.a("检查换页：正在拖动，不换页");
        return;
    L12:
        if (isAttachedToWindow() == true) goto L15;
        com.obric.oui.common.util.f.a("剥离window，不换页");
        return;
    L15:
        long r0 = SystemClock.uptimeMillis() - this.lastUserTouchTime;
        if (r0 >= this.delayAfterUserTouch) goto L23;
        com.obric.oui.common.util.f.a("检查换页: 刚松手" + r0 + " ms，delay换页");
        Handler r2 = getHandler();
        if (r2 == null) goto L29;
        r2.postDelayed(this.checkAutoPlayRunnable, this.delayAfterUserTouch - r0);
        return;
    L29:
        return;
    L23:
        if (this.pageInvalid == false) goto L25;
        switchNext();
        return;
    L25:
        com.obric.oui.common.util.f.a("检查换页：不是业务触发的，不换页");
    }

    private final void clearCheckTask() {
        Handler r0 = getHandler();
        if (r0 == null) goto L7;
        r0.removeCallbacks(this.checkAutoPlayRunnable);
        return;
    }

    public final void registerViewHolder(com.obric.oui.banner.f r3) {
        com.obric.oui.banner.f r4 = (com.obric.oui.banner.f) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.f.class, "com.obric.aiagent.plugin");
        o.e(r4, "factory");
        getAdapter().a(r4);
    }

    public final float getProportion() {
        return this.proportion;
    }

    public final void setProportion(float r3) {
        if (r3 >= 0.0f) goto L5;
        this.proportion = 0.0f;
        return;
    L5:
        this.proportion = r3;
        invalidate();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        if (this.proportion > 0.0f) goto L6;
        super.onMeasure(r3, r4);
        return;
    L6:
        int r5 = View.MeasureSpec.getSize(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r5 / this.proportion), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        checkAndSwitchPage();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setBannerStyle(com.obric.oui.banner.c r2) {
        o.e(r2, "style");
        this.mBannerStyle = r2;
    }

    public final void enablePadGridAdapt(boolean r1) {
        this.isPadGridAdaptEnable = r1;
    }

    public final OBanner setCurrentItem(int r3, boolean r4) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        INVOKESTATIC_com_obric_oui_banner_OBanner_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
    L9:
        return this;
    L10:
        getViewPager2().setCurrentItem(r3, r4);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_banner_OBanner_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, o.a("setCurrentItem error, msg: ", e.getMessage()));
        goto L9
    }

    public final void initTriptychBanner(int r3, int r4, int r5) {
        int r6 = (r4 - r3) >> 1;
        setRecyclerViewPadding(r6, r6);
        androidx.viewpager2.widget.e r7 = this.marginPageTransformer;
        if (r7 == null) goto L6;
        getCompositePageTransformer().b((ViewPager2.g) ZeusTransformUtils.preCheckCast(r7, ViewPager2.g.class, "com.obric.aiagent.plugin"));
    L6:
        androidx.viewpager2.widget.e r8 = new androidx.viewpager2.widget.e(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r5));
        getCompositePageTransformer().a((ViewPager2.g) ZeusTransformUtils.preCheckCast(r8, ViewPager2.g.class, "com.obric.aiagent.plugin"));
        this.marginPageTransformer = r8;
    }

    private final void setRecyclerViewPadding(int r5, int r6) {
        ViewPager2 r4 = getViewPager2();
        View r1 = r4.getChildAt(0);
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r2 = (RecyclerView) ZeusTransformUtils.preCheckCast(r1, RecyclerView.class, "com.obric.aiagent.plugin");
        if (r4.getOrientation() != 1) goto L5;
        r2.setPadding(r4.getPaddingLeft(), r5, r4.getPaddingRight(), r6);
    L6:
        r2.setClipToPadding(false);
        return;
    L5:
        r2.setPadding(r5, r4.getPaddingTop(), r6, r4.getPaddingBottom());
        goto L6
    }

    public final void setOnPageChangeListener(ViewPager2.e r2) {
        o.e(r2, "onPageChangeListener");
        this.mOnPageChangeListener = r2;
    }

    private final void adjustBannerForWindowConfigChange(com.obric.oui.window.a.g r3, boolean r4) {
        int r0 = r3.b().b();
        if (this.mLastWindowWidth == r0) goto L6;
        this.mLastWindowWidth = r0;
        adjustBannerParam(r3, r0, r4);
        configBanner(r3);
        getViewPager2().requestTransform();
        return;
    }

    private final void adjustBannerParam(com.obric.oui.window.a.g r8, int r9, boolean r10) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        int r1 = c.f34015a[this.mBannerStyle.ordinal()];
        if (r1 != 1) goto L5;
        r0.width = r9;
        r0.height = (int) (com.obric.oui.banner.a.f.b(r8.a()) * this.triptychBannerRatio);
        setRadius(0.0f);
    L32:
        setLayoutParams(r0);
        if (r10 == true) goto L36;
        postDelayed(new $$Lambda$OBanner$K3o40ETndurApIgIhWPxJnsD294(this), 200);
        return;
    L36:
        return;
    L5:
        if (r1 != 2) goto L7;
        r0.width = r9;
        r0.height = com.obric.oui.banner.a.b.a(r8);
        setRadius(0.0f);
        goto L32
    L7:
        if (r1 != 3) goto L32;
        m<Integer, Integer> r11 = com.obric.oui.banner.a.d.a(r8, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        r0.width = ((Number) ZeusTransformUtils.preCheckCast(r11.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        r0.height = ((Number) ZeusTransformUtils.preCheckCast(r11.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r12 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), com.obric.oui.window.a.f36851a.b().a().c().a());
        ViewGroup.LayoutParams r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L12;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L13:
        if (r3 == null) goto L32;
        ViewGroup.LayoutParams r4 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == true) goto L18;
        r4 = null;
    L18:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        int r6 = 0;
        if (r5 == null) goto L21;
        int r7 = r5.topMargin;
    L22:
        ViewGroup.LayoutParams r13 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.MarginLayoutParams.class) == false) goto L26;
        r2 = r13;
    L26:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L29;
        r6 = r14.bottomMargin;
    L29:
        r3.setMargins(r12, r7, r12, r6);
        goto L32
    L21:
        r7 = 0;
        goto L22
    L12:
        r3 = null;
        goto L13
    }

    /* JADX INFO: renamed from: adjustBannerParam$lambda-7, reason: not valid java name */
    private static final void m971adjustBannerParam$lambda7(OBanner r1) {
        o.e(r1, "this$0");
        r1.switchNext();
    }

    private final void configBanner(com.obric.oui.window.a.g r7) {
        int r0 = c.f34015a[this.mBannerStyle.ordinal()];
        if (r0 != 1) goto L5;
        com.obric.oui.banner.a.e r1 = com.obric.oui.banner.a.f.a(r7.a());
        int r3 = r1.b();
        initTriptychBanner((int) ((r3 * com.obric.oui.window.a.f36851a.c()) + ((r3 - 1) * com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r7.a().a().b().a()))), com.obric.oui.window.a.f36851a.a().b(), r1.c());
        getAdapter().a((com.obric.oui.banner.a.g) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.banner.a.g.class, "com.obric.aiagent.plugin"));
    L12:
        getAdapter().d();
        return;
    L5:
        if (r0 != 2) goto L7;
        getAdapter().a((com.obric.oui.banner.a.g) ZeusTransformUtils.preCheckCast(com.obric.oui.banner.a.b.a(r7.a()), com.obric.oui.banner.a.g.class, "com.obric.aiagent.plugin"));
        goto L12
    L7:
        if (r0 != 3) goto L12;
        getAdapter().a((com.obric.oui.banner.a.g) ZeusTransformUtils.preCheckCast(com.obric.oui.banner.a.d.a(r7.a()), com.obric.oui.banner.a.g.class, "com.obric.aiagent.plugin"));
        goto L12
    }

    public final int getCurrentRealPos() {
        return com.obric.oui.banner.c.a.f34047a.a(isInfiniteSwitchEnabled(), getCurrentItem(), getRealCount());
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_banner_OBanner_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_banner_OBanner_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
