package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.R;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public class LivePagerTabsStrip extends HorizontalScrollView {
    public static final int[] O = null;
    public int A;
    public int B;
    public final ColorStateList C;
    public int D;
    public final ColorStateList E;
    public int F;
    public int G;
    public final Locale H;
    public final SparseArray<String> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final SparseArray<String> f159799J;
    public e K;
    public int L;
    public boolean M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout.LayoutParams f159800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout.LayoutParams f159801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout.LayoutParams f159802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, d> f159803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f159804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f159805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f159806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f159807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewPager f159808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f159809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<String, Animator> f159810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f159811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f159812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f159813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f159814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f159815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f159816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f159817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f159818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f159819t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f159820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f159821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f159822w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f159823x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f159824y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f159825z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f159826a;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f159826a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f159826a);
        }
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePagerTabsStrip f159827a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f159827a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            LivePagerTabsStrip r100 = this.f159827a;
            r100.f159811l = r100.f159808i.getCurrentItem();
            LivePagerTabsStrip r101 = this.f159827a;
            int r102 = r101.f159811l;
            int r103 = r101.f159807h.getChildCount();
            if (r103 == 0) goto L16;
            if (r102 < 0) goto L16;
            if (r102 >= r103) goto L16;
            View r104 = r101.f159807h.getChildAt(r102);
            r104.setSelected(true);
            Object r105 = r104.getTag();
            if ((r105 instanceof d) == false) goto L16;
            d r106 = (d) r105;
            String r107 = r101.I.get(r102);
            if (TextUtils.isEmpty(r101.f159799J.get(r102)) == true) goto L16;
            if (r106 == null) goto L16;
            TextView r108 = r106.f159834a;
            if (r108 == null) goto L16;
            r108.setTextColor(s1.i(r101.f159799J.get(r102), r101.f159817r));
        L16:
            LivePagerTabsStrip r109 = this.f159827a;
            LivePagerTabsStrip.a(r109, r109.f159811l, 0);
        }

        public a(LivePagerTabsStrip r100) {
            this.f159827a = r100;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f159828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f159829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f159830c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LivePagerTabsStrip f159831d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f159832a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f159833b;

            public final void a() {
                b r100 = this.f159833b;
                int r101 = r100.f159828a;
                if (r101 != 2) goto L8;
                LivePagerTabsStrip r102 = r100.f159831d;
                e r103 = r102.K;
                if (r103 == null) goto L8;
                r103.d(r102.f159811l);
            L12:
                this.f159833b.f159829b.removeCallbacksAndMessages(null);
                this.f159833b.f159828a = 0;
                return;
            L8:
                if (r101 != 1) goto L12;
                if (r100.f159831d.K == null) goto L12;
                int[] r104 = new int[2];
                this.f159832a.getLocationOnScreen(r104);
                r104[0] = r104[0] + (this.f159832a.getWidth() / 2);
                new HashMap().put("clickCenterX", Integer.valueOf(r104[0]));
                this.f159833b.f159831d.K.c();
                LivePagerTabsStrip r105 = this.f159833b.f159831d;
                r105.K.a(r105.f159811l);
                goto L12
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100, View r101) {
                this.f159833b = r100;
                this.f159832a = r101;
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            List<? extends com.bytedance.android.livesdk.vscore_impl.component.tabs.e> r101 = ((LiveTabsPageAdapter) this.f159831d.f159808i.getAdapter()).f159858o;
            int r102 = 0;
        L4:
            if (r102 >= r101.size()) goto L9;
            if (((com.bytedance.android.livesdk.vscore_impl.component.tabs.e) ListProtector.get(r101, r102)).f159951b == this.f159830c) goto L11;
            r102 = r102 + 1;
        L11:
            if (this.f159831d.f159811l == r102) goto L13;
        L15:
            LivePagerTabsStrip r103 = this.f159831d;
            if (r103.f159811l != r102) goto L18;
            int[] r104 = new int[2];
            r100.getLocationOnScreen(r104);
            r104[0] = r104[0] + (r100.getWidth() / 2);
            new HashMap().put("clickCenterX", Integer.valueOf(r104[0]));
            this.f159831d.K.a(r102);
            this.f159831d.K.c();
            return;
        L18:
            r103.K.a(r102);
            this.f159831d.f159808i.setCurrentItem(r102, false);
            return;
        L13:
            if (this.f159830c == MultiTabType.CHANNEL_CHAT_TAB.getTabId()) goto L15;
            this.f159828a++;
            this.f159829b.postDelayed(new a(this, r100), 200);
            return;
        L9:
            r102 = -1;
            goto L11
        }

        public b(LivePagerTabsStrip r100, long r101) {
            this.f159831d = r100;
            this.f159830c = r101;
            this.f159828a = 0;
            this.f159829b = new Handler();
        }
    }

    public class c extends d {
        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f159834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f159835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f159836c;

        public d() {
        }
    }

    public interface e {
        void a(int r100);

        void b(int r100);

        void c();

        void d(int r100);
    }

    public class f implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePagerTabsStrip f159837a;

        public f(LivePagerTabsStrip r100) {
            this.f159837a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 0) goto L4;
            LivePagerTabsStrip r101 = this.f159837a;
            LivePagerTabsStrip.a(r101, r101.f159808i.getCurrentItem(), 0);
        L4:
            ViewPager.OnPageChangeListener r102 = this.f159837a.f159805f;
            if (r102 == null) goto L8;
            r102.onPageScrollStateChanged(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            this.f159837a.K.b(r100);
            LivePagerTabsStrip r101 = this.f159837a;
            r101.f159812m = r100;
            ViewPager.OnPageChangeListener r102 = r101.f159805f;
            if (r102 == null) goto L5;
            r102.onPageSelected(r100);
        L5:
            this.f159837a.d();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            LivePagerTabsStrip r103 = this.f159837a;
            r103.f159811l = r100;
            r103.f159813n = r101;
            LivePagerTabsStrip.a(r103, r100, (int) (r103.f159807h.getChildAt(r100).getWidth() * r101));
            this.f159837a.invalidate();
            ViewPager.OnPageChangeListener r104 = this.f159837a.f159805f;
            if (r104 == null) goto L6;
            r104.onPageScrolled(r100, r101, r102);
            return;
        }
    }

    static {
        O = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public void setIconResId(int r100) {
    }

    public void setTextSelectedStyle(int r100) {
    }

    public final void c() {
        this.f159807h.removeAllViews();
        ViewPager r100 = this.f159808i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getAdapter() == null) goto L35;
        this.f159809j = this.f159808i.getAdapter().getCount();
        int r101 = 0;
    L8:
        if (r101 >= this.f159809j) goto L26;
        if ((this.f159808i.getAdapter() instanceof LiveTabsPageAdapter) == false) goto L25;
        LiveTabsPageAdapter r102 = (LiveTabsPageAdapter) this.f159808i.getAdapter();
        CharSequence r103 = r102.getPageTitle(r101);
        String r104 = r102.f(r101);
        String r105 = ((String) r103).toString();
        if (r104.equals(String.valueOf(MultiTabType.CHANNEL_CHAT_TAB.getTabId())) == false) goto L14;
        d r106 = new c();
    L15:
        View r107 = LayoutInflater.from(getContext()).inflate(com.larus.nova.R.layout.ttlive_tabs_item_pager_sliding_tab_strip, null, false);
        r106.f159834a = (TextView) r107.findViewById(com.larus.nova.R.id.text);
        r106.f159836c = (ImageView) r107.findViewById(com.larus.nova.R.id.icon_right);
        r106.f159835b = r107.findViewById(com.larus.nova.R.id.tab_red_dot);
        r106.f159834a.setText(r105);
        r106.f159834a.setMaxLines(1);
        r106.f159834a.setGravity(17);
        r106.f159836c.setVisibility(8);
        int r108 = this.f159808i.getAdapter().getCount();
        if (r101 != 0) goto L19;
        r107.findViewById(com.larus.nova.R.id.v_left_padding).setVisibility(0);
    L21:
        r3.e(r107, new com.bytedance.android.livesdk.vscore_impl.component.tabs.f(this, r105, r101));
        r107.setTag(r106);
        this.f159803d.put(r104, r106);
        b(r101, r107, CastLongProtector.parseLong(((LiveTabsPageAdapter) this.f159808i.getAdapter()).f(r101)));     // Catch: NumberFormatException -> L24
    L24:
        ALogger.d("LiveTabsWidget", "e: Add tab failed!");
        goto L25
    L19:
        if (r101 != (r108 - 1)) goto L21;
        r107.findViewById(com.larus.nova.R.id.v_right_padding).setVisibility(0);
        goto L21
    L14:
        r106 = new d();
    L25:
        r101 = r101 + 1;
        goto L8
    L26:
        d();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        return;
    }

    public final void d() {
        if (this.f159810k != null) goto L5;
        this.f159810k = new HashMap();
    L5:
        int r100 = 0;
    L7:
        if (r100 >= this.f159809j) goto L67;
        View r101 = this.f159807h.getChildAt(r100);
        r101.setBackgroundResource(this.G);
        Object r102 = r101.getTag();
        if ((r102 instanceof d) == false) goto L66;
        d r103 = (d) r102;
        TextView r104 = r103.f159834a;
        if (this.f159812m != r100) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        int r106 = this.D;
    L17:
        r104.setTextSize(0, r106);
        TextView r107 = r103.f159834a;
        if (this.f159812m != r100) goto L20;
        int r108 = 1;
    L21:
        r107.setTypeface(null, r108);
        if (r100 != this.f159812m) goto L24;
        boolean r109 = true;
    L25:
        if (r109 == false) goto L27;
        ColorStateList r110 = this.E;
    L29:
        if (VSSettingKeys.LIVE_TAB_TEXT_COLOR_BUGFIX.getValue().booleanValue() == false) goto L52;
        ColorStateList r111 = r103.f159834a.getTextColors();
        int r112 = this.f159812m;
        if (r100 != r112) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == false) goto L36;
        ColorStateList r114 = this.E;
    L37:
        if (r111 != r114) goto L46;
        if (r100 == r112) goto L46;
        if (this.f159810k.containsKey(r103.f159834a.getText().toString()) == false) goto L45;
        String r115 = r103.f159834a.getText().toString();
        Animator r116 = this.f159810k.get(r115);
        if (r116 == null) goto L45;
        r116.removeAllListeners();
        r116.cancel();
        this.f159810k.remove(r115);
    L45:
        r103.f159834a.setTextColor(r110);
    L64:
        if (this.f159821v == false) goto L66;
        r103.f159834a.setAllCaps(true);
    L46:
        TextView r117 = r103.f159834a;
        ObjectAnimator r118 = ObjectAnimator.ofInt(r117, "textColor", new int[]{r117.getCurrentTextColor(), r110.getDefaultColor()});
        r118.setEvaluator(new ArgbEvaluator());
        r118.setDuration(300);
        if (this.f159810k.containsKey(r103.f159834a.getText().toString()) == false) goto L51;
        String r119 = r103.f159834a.getText().toString();
        Animator r120 = this.f159810k.get(r119);
        if (r120 == null) goto L51;
        r120.removeAllListeners();
        r120.cancel();
        this.f159810k.remove(r119);
    L51:
        this.f159810k.put(r103.f159834a.getText().toString(), r118);
        r118.start();
        goto L64
    L36:
        r114 = this.C;
        goto L37
    L33:
        r113 = false;
        goto L34
    L52:
        ColorStateList r121 = r103.f159834a.getTextColors();
        int r122 = this.f159812m;
        if (r100 != r122) goto L55;
        boolean r123 = true;
    L56:
        if (r123 == false) goto L58;
        ColorStateList r124 = this.E;
    L59:
        if (r121 != r124) goto L61;
        if (r100 == r122) goto L61;
    L62:
        r103.f159834a.setTextColor(r110);
    L61:
        TextView r125 = r103.f159834a;
        ObjectAnimator r126 = ObjectAnimator.ofInt(r125, "textColor", new int[]{r125.getCurrentTextColor(), r110.getDefaultColor()});
        r126.setEvaluator(new ArgbEvaluator());
        r126.setDuration(300);
        r126.start();
        goto L62
    L58:
        r124 = this.C;
        goto L59
    L55:
        r123 = false;
        goto L56
    L27:
        r110 = this.C;
        goto L29
    L24:
        r109 = false;
        goto L25
    L20:
        r108 = 0;
        goto L21
    L16:
        r106 = this.B;
        goto L17
    L13:
        r105 = false;
    L66:
        r100 = r100 + 1;
        goto L7
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f159826a = this.f159811l;
        return r100;
    }

    public int getCurrentPosition() {
        return this.f159811l;
    }

    public int getDividerColor() {
        return this.f159819t;
    }

    public int getDividerPadding() {
        return this.f159825z;
    }

    public int getIndicatorColor() {
        return this.f159817r;
    }

    public int getIndicatorHeight() {
        return this.f159823x;
    }

    public int getIndicatorWidth() {
        return this.f159815p;
    }

    public ViewPager getPager() {
        return this.f159808i;
    }

    public int getScrollOffset() {
        return this.f159822w;
    }

    public boolean getShouldExpand() {
        return this.f159820u;
    }

    public int getTabBackground() {
        return this.G;
    }

    public int getTabPaddingLeftRight() {
        return this.A;
    }

    public ColorStateList getTextColor() {
        return this.C;
    }

    public int getTextSize() {
        return this.B;
    }

    public int getUnderlineColor() {
        return this.f159818s;
    }

    public int getUnderlineHeight() {
        return this.f159824y;
    }

    public LivePagerTabsStrip(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(true);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f159809j == 0) goto L62;
        int r100 = getHeight();
        if (TextUtils.isEmpty(this.f159799J.get(this.f159811l)) == true) goto L10;
        this.f159814o.setColor(s1.i(this.f159799J.get(this.f159811l), this.f159817r));
    L12:
        if (this.f159806g == false) goto L51;
        View r101 = this.f159807h.getChildAt(this.f159811l);
        float r102 = r101.getLeft();
        float r103 = r101.getRight();
        if (this.f159813n <= 0.0f) goto L18;
        int r104 = this.f159811l;
        if (r104 >= (this.f159809j - 1)) goto L18;
        View r105 = this.f159807h.getChildAt(r104 + 1);
        float r106 = r105.getLeft();
        float r107 = r105.getRight();
        float r108 = this.f159813n;
        float r109 = 1.0f - r108;
        r102 = (r102 * r109) + (r106 * r108);
        r103 = (r107 * r108) + (r109 * r103);
    L18:
        int r111 = s1.f(12.0f) + ((this.f159809j - 1) * this.f159800a.width);
        int r112 = s1.f(12.0f);
        int r113 = this.f159809j;
        int r114 = r112 + (this.f159800a.width * r113);
        int r115 = this.f159815p;
        if (r115 == 0) goto L27;
        int r116 = this.f159811l;
        if (r116 != 0) goto L24;
        r102 = r102 + ((r103 - r102) - r115);
        goto L27
    L24:
        if (r116 != (r113 - 1)) goto L26;
        r103 = r103 - ((r103 - r102) - r115);
        r102 = r101.getLeft();
        goto L27
    L26:
        float r117 = ((r103 - r102) - r115) / 2.0f;
        r102 = r102 + r117;
        r103 = r103 - r117;
    L27:
        float r118 = r111;
        if (r102 <= r118) goto L30;
        r102 = r118;
    L30:
        float r119 = r114;
        if (r103 <= r119) goto L34;
        r103 = r119;
    L34:
        if (r102 >= 0.0f) goto L36;
    L44:
        float r120 = r102;
        float r121 = r103;
    L46:
        if (this.f159816q > 0) goto L48;
    L50:
        ALogger.d("scrool_tab", "drawRoundRect lineLeft " + r120);
        int r122 = r100 - this.f159823x;
        int r123 = this.L;
        r110.drawRect(r120, r122 - r123, r121, r100 - r123, this.f159814o);
        goto L51
    L48:
        if (Build.VERSION.SDK_INT <= 21) goto L50;
        ALogger.d("scrool_tab", "drawRoundRect lineLeft " + r120 + "   lineRight" + r121);
        int r124 = r100 - this.f159823x;
        int r125 = this.L;
        float r126 = this.f159816q;
        r110.drawRoundRect(r120, (float) (r124 - r125), r121, (float) (r100 - r125), r126, r126, this.f159814o);
        goto L51
    L36:
        if (r103 <= r102) goto L44;
        if ((r103 - r102) <= s1.j(com.larus.nova.R.dimen.ttlive_match_tab_minwidth)) goto L44;
        if (PadConfigUtils.c() == false) goto L42;
        int r127 = s1.j(com.larus.nova.R.dimen.ttlive_match_tab_pad_defalutwidth);
    L43:
        int r128 = ((int) (r102 + r103)) / 2;
        int r129 = r127 / 2;
        r121 = r128 + r129;
        r120 = r128 - r129;
        goto L46
    L42:
        r127 = s1.j(com.larus.nova.R.dimen.ttlive_match_tab_defalutwidth);
    L51:
        this.f159814o.setColor(this.f159818s);
        r110.drawRect(0.0f, r100 - this.f159824y, this.f159807h.getWidth(), r100, this.f159814o);
        if (this.M == false) goto L61;
        Iterator<d> r130 = this.f159803d.values().iterator();
    L55:
        if (r130.hasNext() == false) goto L57;
        d r131 = r130.next();
        int r132 = x.f160015a;
        x.a(r131.f159834a, this);
        goto L55
    L57:
        this.M = false;
        return;
    L61:
        return;
    L10:
        this.f159814o.setColor(this.f159817r);
        goto L12
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f159811l = r101.f159826a;
        requestLayout();
    }

    public void setAllCaps(boolean r100) {
        this.f159821v = r100;
    }

    public void setDividerColor(int r100) {
        this.f159819t = r100;
        invalidate();
    }

    public void setDividerColorResource(int r100) {
        this.f159819t = getResources().getColor(r100);
        invalidate();
    }

    public void setDividerPadding(int r100) {
        this.f159825z = r100;
        invalidate();
    }

    public void setIndicatorBottomMargin(int r100) {
        this.L = r100;
    }

    public void setIndicatorColor(int r100) {
        this.f159817r = r100;
        invalidate();
    }

    public void setIndicatorColorResource(int r100) {
        this.f159817r = getResources().getColor(r100);
        invalidate();
    }

    public void setIndicatorHeight(int r100) {
        this.f159823x = r100;
        invalidate();
    }

    public void setIndicatorRadius(int r100) {
        this.f159816q = r100;
        d();
    }

    public void setIndicatorWidth(int r100) {
        this.f159815p = r100;
        d();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.f159805f = r100;
    }

    public void setOnTabClickListener(e r100) {
        this.K = r100;
    }

    public void setScrollOffset(int r100) {
        this.f159822w = r100;
        invalidate();
    }

    public void setShouldExpand(boolean r100) {
        this.f159820u = r100;
        requestLayout();
    }

    public void setTabBackground(int r100) {
        this.G = r100;
    }

    public void setTabPaddingLeftRight(int r100) {
        this.A = r100;
        d();
    }

    public void setTabTextSelectSize(int r100) {
        this.D = r100;
        d();
    }

    public void setTextSize(int r100) {
        this.B = r100;
        d();
    }

    public void setUnderlineColor(int r100) {
        this.f159818s = r100;
        invalidate();
    }

    public void setUnderlineColorResource(int r100) {
        this.f159818s = getResources().getColor(r100);
        invalidate();
    }

    public void setUnderlineHeight(int r100) {
        this.f159824y = r100;
        invalidate();
    }

    public void setViewPager(ViewPager r100) {
        this.f159808i = r100;
        if (r100.getAdapter() == null) goto L7;
        r100.setOnPageChangeListener(this.f159804e);
        c();
        return;
    L7:
        throw new IllegalStateException("ViewPager does not have adapter INSTANCE.");
    }

    public LivePagerTabsStrip(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LivePagerTabsStrip(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f159803d = new HashMap();
        this.f159804e = new f(this);
        this.f159806g = true;
        this.f159810k = new HashMap();
        this.f159811l = 0;
        this.f159812m = 0;
        this.f159813n = 0.0f;
        this.f159815p = 0;
        this.f159816q = 0;
        this.f159817r = 16737894;
        this.f159818s = 436207616;
        this.f159819t = 436207616;
        this.f159820u = false;
        this.f159821v = false;
        this.f159822w = 52;
        this.f159823x = 8;
        this.f159824y = 2;
        this.f159825z = 12;
        this.A = 0;
        this.B = 15;
        this.C = ColorStateList.valueOf(16737894);
        this.D = 15;
        ColorStateList r100 = getResources().getColorStateList(com.larus.nova.R.color.ttlive_feed_tab_select_color);
        this.E = r100;
        this.F = 0;
        this.G = com.larus.nova.R.drawable.ttlive_background_tab;
        this.I = new SparseArray();
        new SparseArray();
        this.f159799J = new SparseArray();
        this.L = 0;
        this.M = true;
        this.N = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r101 = new LinearLayout(r110);
        this.f159807h = r101;
        r101.setOrientation(0);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r101);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        this.f159822w = (int) TypedValue.applyDimension(1, this.f159822w, r103);
        this.f159823x = (int) TypedValue.applyDimension(1, this.f159823x, r103);
        this.f159824y = (int) TypedValue.applyDimension(1, this.f159824y, r103);
        this.f159825z = (int) TypedValue.applyDimension(1, this.f159825z, r103);
        this.A = (int) TypedValue.applyDimension(1, this.A, r103);
        int r104 = (int) TypedValue.applyDimension(1, 1, r103);
        this.B = (int) TypedValue.applyDimension(1, this.B, r103);
        this.D = (int) TypedValue.applyDimension(1, this.D, r103);
        this.f159815p = (int) TypedValue.applyDimension(1, this.f159815p, r103);
        TypedArray r105 = r110.obtainStyledAttributes(r111, O);
        this.B = r105.getDimensionPixelSize(0, this.B);
        this.C = r105.getColorStateList(1);
        r105.recycle();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.tab_background, com.larus.nova.R.attr.tab_divider_color, com.larus.nova.R.attr.tab_divider_padding, com.larus.nova.R.attr.tab_height, com.larus.nova.R.attr.tab_indicator_color, com.larus.nova.R.attr.tab_indicator_height, com.larus.nova.R.attr.tab_indicator_radius, com.larus.nova.R.attr.tab_indicator_width, com.larus.nova.R.attr.tab_margin_left, com.larus.nova.R.attr.tab_margin_right, com.larus.nova.R.attr.tab_padding_left_right, com.larus.nova.R.attr.tab_scroll_offset, com.larus.nova.R.attr.tab_should_expand, com.larus.nova.R.attr.tab_text_all_caps, com.larus.nova.R.attr.tab_text_color, com.larus.nova.R.attr.tab_text_select_size, com.larus.nova.R.attr.tab_text_size, com.larus.nova.R.attr.tab_typeface_style, com.larus.nova.R.attr.tab_underline_color, com.larus.nova.R.attr.tab_underline_height, com.larus.nova.R.attr.tab_widget});
        this.f159817r = r113.getColor(4, this.f159817r);
        this.f159818s = r113.getColor(18, this.f159818s);
        this.f159819t = r113.getColor(1, this.f159819t);
        this.f159823x = r113.getDimensionPixelSize(5, this.f159823x);
        int r114 = r113.getDimensionPixelSize(20, 0);
        this.f159824y = r113.getDimensionPixelSize(19, this.f159824y);
        this.f159825z = r113.getDimensionPixelSize(2, this.f159825z);
        this.A = r113.getDimensionPixelSize(10, this.A);
        this.G = r113.getResourceId(0, this.G);
        this.f159820u = r113.getBoolean(12, this.f159820u);
        this.f159822w = r113.getDimensionPixelSize(11, this.f159822w);
        this.f159821v = r113.getBoolean(13, this.f159821v);
        this.B = r113.getDimensionPixelSize(16, this.B);
        ColorStateList r106 = r113.getColorStateList(14);
        this.C = r106;
        this.D = r113.getDimensionPixelSize(15, this.D);
        this.f159815p = r113.getDimensionPixelSize(7, this.f159815p);
        this.f159816q = r113.getDimensionPixelSize(6, 0);
        r113.getInt(17, 1);
        r113.recycle();
        Paint r115 = new Paint();
        this.f159814o = r115;
        r115.setAntiAlias(true);
        r115.setStyle(Paint.Style.FILL);
        Paint r116 = new Paint();
        r116.setAntiAlias(true);
        r116.setStrokeWidth(r104);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-2, -1);
        this.f159800a = r117;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -1);
        this.f159801b = r107;
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.f159802c = r118;
        r117.width = r114;
        r107.width = r114;
        r118.width = r114;
        if (this.H != null) goto L5;
        this.H = getResources().getConfiguration().locale;
    L5:
        if (r106 != null) goto L7;
        this.C = ColorStateList.valueOf(16737894);
    L7:
        if (r100 != null) goto L10;
        this.E = this.C;
        return;
    }

    public static void a(LivePagerTabsStrip r100, int r101, int r102) {
        if (r100.f159809j == 0) goto L20;
        View r103 = r100.f159807h.getChildAt(r101);
        if (r103 != null) goto L9;
        return;
    L9:
        if (RTLUtil.isAppRTL(r100.getContext()) == false) goto L11;
        int r104 = r103.getLeft() - r102;
    L12:
        if (r101 > 0) goto L14;
        if (r102 > 0) goto L14;
    L16:
        if (r104 == r100.F) goto L19;
        r100.F = r104;
        r100.scrollTo(r104, 0);
        return;
    L19:
        return;
    L14:
        r104 = r104 - r100.f159822w;
        goto L16
    L11:
        r104 = r103.getLeft() + r102;
        goto L12
    }

    public final void b(int r100, View r101, long r102) {
        boolean r103 = true;
        r101.setFocusable(true);
        r101.setOnClickListener(new b(this, r102));
        this.N = Math.max(this.N, r101.getWidth());
        int r104 = this.f159808i.getAdapter().getCount();
        if (r100 != 0) goto L5;
    L8:
        int r105 = this.A;
        r101.setPadding(r105, 0, r105, 0);
        if (RTLUtil.isAppRTL(getContext()) == false) goto L11;
        int r106 = this.A;
        r101.setPaddingRelative(r106, 0, r106, 0);
    L11:
        LinearLayout r107 = this.f159807h;
        if (r103 == false) goto L14;
        LinearLayout.LayoutParams r108 = this.f159801b;
    L15:
        r107.addView(r101, r100, r108);
        this.f159820u = false;
        return;
    L14:
        r108 = this.f159800a;
        goto L15
    L5:
        if (r100 == (r104 - 1)) goto L8;
        r103 = false;
        goto L8
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        Iterator<d> r104 = this.f159803d.values().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        d r105 = r104.next();
        int r106 = x.f160015a;
        x.a(r105.f159834a, this);
        goto L4
    }
}
