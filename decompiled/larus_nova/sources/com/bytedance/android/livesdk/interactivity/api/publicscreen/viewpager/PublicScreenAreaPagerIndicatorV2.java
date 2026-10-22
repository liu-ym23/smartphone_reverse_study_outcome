package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.b0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\t\nB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerIndicatorV2;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/f;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TabView", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenAreaPagerIndicatorV2 extends LinearLayout implements f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f133663g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f133664h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f133665i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f133666j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f133667k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f133668l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f133669m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f133670n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f133671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f133672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPager f133673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f133674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<PublicScreenAreaPageType> f133675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublicScreenAreaPagerIndicatorV2$pageChangeListener$1 f133676f;

    public final class TabView extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f133677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f133678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f133679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f133680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PublicScreenAreaPageType f133681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f133682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ PublicScreenAreaPagerIndicatorV2 f133683g;

        public final void b(final boolean r100) {
            this.f133677a = r100;
            a(false, null);
            postInvalidate();
            ViewCompat.setAccessibilityDelegate(this, new PublicScreenAreaPagerIndicatorV2$TabView$setSelect$1(this, r100));
        }

        @Override // android.view.View
        public final void onDraw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            super.onDraw(r100);
            if (this.f133677a == false) goto L5;
            Paint r101 = this.f133683g.f133672b;
        L6:
            this.f133680d = r101;
            float r102 = r101.measureText(this.f133682f);
            r100.drawText(this.f133682f, 0.0f, PublicScreenAreaPagerIndicatorV2.f133664h - this.f133680d.getFontMetrics().descent, this.f133680d);
            if (this.f133678b == false) goto L10;
            float r103 = PublicScreenAreaPagerIndicatorV2.f133665i;
            r100.drawCircle(r102 + r103, PublicScreenAreaPagerIndicatorV2.f133663g + r103, r103, this.f133679c);
            return;
        L10:
            return;
        L5:
            r101 = this.f133683g.f133671a;
            goto L6
        }

        public final void a(boolean r100, Function0<Unit> r101) {
            PublicScreenAreaPageType r102 = this.f133681e;
            if (r102 != PublicScreenAreaPageType.PublicScreen) goto L6;
            return;
        L6:
            if (r102 != PublicScreenAreaPageType.ChatChannel) goto L19;
            boolean r103 = this.f133678b;
            if (this.f133677a == false) goto L10;
            this.f133678b = false;
        L12:
            if (r103 == this.f133678b) goto L35;
            postInvalidate();
            if (this.f133678b == false) goto L36;
            if (r101 == null) goto L37;
            Unit r104 = r101.invoke();
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L10:
            this.f133678b = r100;
            goto L12
        L19:
            if (r102 == PublicScreenAreaPageType.Square) goto L21;
            return;
        L21:
            if (this.f133678b != r100) goto L24;
            return;
        L24:
            if (this.f133677a == false) goto L26;
            com.bytedance.android.livesdk.sharedpref.e<Long> r105 = PublicScreenAreaPagerIndicatorV2.f133670n;
            r105.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r105, 3L);
            this.f133678b = false;
        L33:
            postInvalidate();
            return;
        L26:
            com.bytedance.android.livesdk.sharedpref.e<Long> r106 = PublicScreenAreaPagerIndicatorV2.f133670n;
            com.bytedance.android.livesdk.sharedpref.f.d(r106, Long.valueOf(r106.getValue().longValue() + 1));
            this.f133678b = true;
            com.bytedance.android.livesdk.interactivity.api.h r107 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
            if (r107 == null) goto L33;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b> r108 = r107.getSquareTabManager();
            if (r108 == null) goto L33;
            com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r109 = r108.getValue();
            if (r109 == null) goto L33;
            r109.c();
            goto L33
        }

        public TabView(PublicScreenAreaPagerIndicatorV2 r100, Context r101, PublicScreenAreaPageType r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "pageType");
            Intrinsics.checkNotNullParameter(r103, "tabTitle");
            this.f133683g = r100;
            super(r101);
            this.f133681e = r102;
            this.f133682f = r103;
            Paint r104 = new Paint();
            r104.setColor(PublicScreenAreaPagerIndicatorV2.f133669m);
            Unit r105 = Unit.INSTANCE;
            this.f133679c = r104;
            this.f133680d = r100.f133671a;
        }
    }

    public static final class a {
    }

    public static final class b extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicScreenAreaPagerIndicatorV2 f133686a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            PublicScreenAreaPagerIndicatorV2 r100 = this.f133686a;
            int r101 = PublicScreenAreaPagerIndicatorV2.f133663g;
            r100.d();
            this.f133686a.f();
        }

        public b(PublicScreenAreaPagerIndicatorV2 r100) {
            this.f133686a = r100;
        }
    }

    static {
        f133663g = s1.f(8.0f);
        f133664h = s1.j(R.dimen.ttlive_public_screen_indicator_height);
        f133665i = s1.f(4.0f);
        f133666j = ColorProtector.parseColor("#99FFFFFF");
        f133667k = -1;
        f133668l = ColorProtector.parseColor("#4D000000");
        f133669m = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED);
        IMiddlewareUserService r100 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.user.e r101 = r100.user();
        if (r101 == null) goto L8;
        String r102 = r101.n();
        if (r102 == null) goto L8;
    L9:
        f133670n = new com.bytedance.android.livesdk.sharedpref.e("live_square_tab_red_dot_show_times_".concat(r102), 0L);
        return;
    L8:
        r102 = "";
        goto L9
    }

    public final void f() {
        ViewPager r100 = this.f133673c;
        if (r100 == null) goto L12;
        int r101 = r100.getCurrentItem();
        int r102 = getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L17;
        View r104 = getChildAt(r103);
        if ((r104 instanceof TabView) == false) goto L11;
        if (r103 != r101) goto L10;
        ((TabView) r104).b(true);
        goto L11
    L10:
        ((TabView) r104).b(false);
    L11:
        r103 = r103 + 1;
        goto L5
    L17:
        return;
    }

    public final void d() {
        removeAllViews();
        ViewPager r100 = this.f133673c;
        if (r100 == null) goto L32;
        PagerAdapter r101 = r100.getAdapter();
        int r102 = 0;
        if (r101 == null) goto L7;
        int r103 = r101.getCount();
    L8:
        if (r102 >= r103) goto L23;
        PublicScreenAreaPageType r104 = (PublicScreenAreaPageType) ListProtector.get(this.f133675e, r102);
        int r105 = g.f133708a[r104.ordinal()];
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L14;
        String r106 = "广场";
    L22:
        TabView r107 = new TabView(this, getContext(), (PublicScreenAreaPageType) ListProtector.get(this.f133675e, r102), r106);
        r107.setLayoutParams(new LinearLayout.LayoutParams(((int) this.f133671a.measureText(r106)) + UtilityKotlinExtentionsKt.i(12), f133664h));
        r107.setOnClickListener(new h(this, r107));
        addView(r107);
        r102 = r102 + 1;
        goto L8
    L14:
        if (r105 == 3) goto L16;
        r106 = "";
        goto L22
    L16:
        r106 = "聊天频道";
        goto L22
    L19:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.d.f133733b == false) goto L21;
        r106 = "房间";
        goto L22
    L21:
        r106 = "评论区";
        goto L22
    L23:
        requestLayout();
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public PublicScreenAreaPagerIndicatorV2(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.f
    public final void a(PublicScreenAreaPagerLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        ViewPager r101 = this.f133673c;
        if (r101 == null) goto L7;
        r101.removeOnPageChangeListener(this.f133676f);
        PagerAdapter r102 = r101.getAdapter();
        if (r102 == null) goto L7;
        r102.unregisterDataSetObserver(this.f133674d);
    L7:
        this.f133673c = r100;
        r100.addOnPageChangeListener(this.f133676f);
        PagerAdapter r103 = r100.getAdapter();
        if (r103 == null) goto L10;
        r103.registerDataSetObserver(this.f133674d);
    L10:
        d();
        f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.f
    public final void b(List<? extends PublicScreenAreaPageType> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ((ArrayList) this.f133675e).clear();
        ((ArrayList) this.f133675e).addAll(r100);
    }

    public final boolean c(PublicScreenAreaPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        int r101 = ((ArrayList) this.f133675e).indexOf(r100);
        if (r101 <= 0) goto L8;
        View r102 = getChildAt(r101);
        if ((r102 instanceof TabView) == true) goto L7;
        return false;
    L7:
        return ((TabView) r102).f133678b;
    L8:
        return false;
    }

    public final void e(final j r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        List<PublicScreenAreaPageType> r101 = this.f133675e;
        ArrayList r102 = (ArrayList) r101;
        int r103 = r102.indexOf(PublicScreenAreaPageType.ChatChannel);
        if (r103 <= 0) goto L8;
        View r104 = getChildAt(r103);
        if ((r104 instanceof TabView) == false) goto L9;
        ((TabView) r104).a(true, new PublicScreenAreaPagerIndicatorV2$showChannelRedDot$1(r100));
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPagerIndicatorV2$pageChangeListener$1] */
    public PublicScreenAreaPagerIndicatorV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        boolean r102 = b0.f104229a.getValue().booleanValue();
        Paint r103 = new Paint();
        r103.setColor(f133666j);
        r103.setTextSize(UtilityKotlinExtentionsKt.i(12));
        if (r102 == false) goto L5;
        r103.setShadowLayer(8.0f, 0.0f, 0.0f, f133668l);
    L5:
        Unit r104 = Unit.INSTANCE;
        this.f133671a = r103;
        Paint r105 = new Paint();
        r105.setColor(f133667k);
        r105.setTextSize(UtilityKotlinExtentionsKt.i(12));
        if (r102 == false) goto L8;
        r105.setShadowLayer(8.0f, 0.0f, 0.0f, f133668l);
    L8:
        this.f133672b = r105;
        this.f133674d = new b(this);
        this.f133675e = new ArrayList();
        this.f133676f = new PublicScreenAreaPagerIndicatorV2$pageChangeListener$1(this);
        setOrientation(0);
    }
}
