package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.baseui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import j40.h2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
@RemoteViews.RemoteView
public class LiveMeasureOnceRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f64570l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f64571m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f64572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f64573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f64574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f64575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View[] f64576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View[] f64577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f64578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<View, Integer> f64579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f64580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f64581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f64582k;

    public static class LayoutParams extends RelativeLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f64583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f64584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f64585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f64586d;

        public LayoutParams() {
            super(-2, -2);
        }

        @Override // android.widget.RelativeLayout.LayoutParams
        public final int[] getRules() {
            super.resolveLayoutDirection(getLayoutDirection());
            return super.getRules();
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        @Override // android.widget.RelativeLayout.LayoutParams
        public final String debug(String r100) {
            return r100 + "ViewGroup.LayoutParams={ width=" + ((RelativeLayout.LayoutParams) this).width + ", height=" + ((RelativeLayout.LayoutParams) this).height + " }";
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
        }

        public LayoutParams(RelativeLayout.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<C1060a> f64587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<C1060a> f64588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayDeque<C1060a> f64589c;

        /* JADX INFO: renamed from: com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.baseui.LiveMeasureOnceRelativeLayout$a$a, reason: collision with other inner class name */
        public static class C1060a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final Pools.SynchronizedPool<C1060a> f64590d = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public View f64591a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ArrayMap<C1060a, a> f64592b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final SparseArray<C1060a> f64593c;

            static {
                f64590d = new Pools.SynchronizedPool(100);
            }

            public C1060a() {
                this.f64592b = new ArrayMap();
                this.f64593c = new SparseArray();
            }
        }

        public a() {
            this.f64587a = new ArrayList();
            this.f64588b = new SparseArray();
            this.f64589c = new ArrayDeque();
        }

        public final void a(boolean r110, Map<View, Integer> r111, int r112, View[] r210, int... r211) {
            SparseArray<C1060a> r100 = this.f64588b;
            ArrayList<C1060a> r101 = this.f64587a;
            int r102 = r101.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            C1060a r104 = (C1060a) ListProtector.get(r101, r103);
            r104.f64592b.clear();
            r104.f64593c.clear();
            r103 = r103 + 1;
            goto L3
        L5:
            int r105 = 0;
        L7:
            if (r105 >= r102) goto L28;
            C1060a r106 = (C1060a) ListProtector.get(r101, r105);
            int[] r113 = ((LayoutParams) r106.f64591a.getLayoutParams()).getRules();
            int r114 = r211.length;
            int r115 = 0;
        L9:
            if (r115 >= r114) goto L27;
            int r116 = r113[r211[r115]];
            if (r116 > 0) goto L21;
            int[] r117 = LiveMeasureOnceRelativeLayout.f64570l;
            if (r116 != (-1)) goto L15;
        L19:
            boolean r118 = false;
        L20:
            if (r118 == true) goto L21;
        L26:
            r115 = r115 + 1;
            goto L9
        L15:
            if (((-16777216) & r116) == 0) goto L19;
            if ((16711680 & r116) == 0) goto L19;
            r118 = true;
        L21:
            C1060a r119 = r100.get(r116);
            if (r119 == null) goto L26;
            if (r119 == r106) goto L26;
            r119.f64592b.put(r106, this);
            r106.f64593c.put(r116, r119);
            goto L26
        L27:
            r105 = r105 + 1;
            goto L7
        L28:
            ArrayDeque<C1060a> r107 = this.f64589c;
            r107.clear();
            int r108 = 0;
        L29:
            if (r108 >= r102) goto L34;
            C1060a r109 = (C1060a) ListProtector.get(r101, r108);
            if (r109.f64593c.size() != 0) goto L33;
            r107.addLast(r109);
        L33:
            r108 = r108 + 1;
            goto L29
        L34:
            int r120 = 0;
        L35:
            C1060a r121 = r107.pollLast();
            if (r121 == null) goto L53;
            View r122 = r121.f64591a;
            int r123 = r122.getId();
            int r124 = r120 + 1;
            r210[r120] = r122;
            ArrayMap<C1060a, a> r125 = r121.f64592b;
            int r126 = r125.size();
            int r127 = 0;
        L38:
            if (r127 >= r126) goto L43;
            C1060a r128 = r125.keyAt(r127);
            SparseArray<C1060a> r129 = r128.f64593c;
            r129.remove(r123);
            if (r129.size() != 0) goto L42;
            r107.add(r128);
        L42:
            r127 = r127 + 1;
            goto L38
        L43:
            if (r110 == false) goto L51;
            if (r126 != 0) goto L46;
            int r130 = 0;
        L47:
            int r131 = r130 * r112;
            HashMap r132 = (HashMap) r111;
            if (r132.containsKey(r122) == false) goto L50;
            r132.put(r122, Integer.valueOf(((Integer) r132.get(r122)).intValue() + r131));
            goto L51
        L50:
            r132.put(r122, Integer.valueOf(r131));
            goto L51
        L46:
            r130 = 1;
        L51:
            r120 = r124;
            goto L35
        L53:
            if (r120 < r210.length) goto L56;
            return;
        L56:
            throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
        }
    }

    static {
        f64570l = new int[]{2, 3, 4, 6, 8};
        f64571m = new int[]{0, 1, 5, 7, 16, 17, 18, 19};
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f64582k == false) goto L7;
        return new LayoutParams();
    L7:
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return LiveMeasureOnceRelativeLayout.class.getName();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public int getBaseline() {
        if (this.f64582k == false) goto L10;
        View r100 = this.f64572a;
        if (r100 == null) goto L8;
        return r100.getBaseline();
    L8:
        return super.getBaseline();
    L10:
        return super.getBaseline();
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        this.f64575d = true;
    }

    public LiveMeasureOnceRelativeLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        if (this.f64582k == false) goto L12;
        if (r100 == null) goto L12;
        if (r100.getLayoutParams() == null) goto L12;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof LayoutParams) == true) goto L12;
        if ((r101 instanceof RelativeLayout.LayoutParams) == false) goto L12;
        r100.setLayoutParams(new LayoutParams((RelativeLayout.LayoutParams) r101));
    L12:
        super.addView(r100);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if (this.f64582k == false) goto L7;
        return r100 instanceof LayoutParams;
    L7:
        return super.checkLayoutParams(r100);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if (this.f64582k == false) goto L19;
        if ((r100 instanceof LayoutParams) == false) goto L9;
        return new LayoutParams((LayoutParams) r100);
    L9:
        if ((r100 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        return new LayoutParams((RelativeLayout.LayoutParams) r100);
    L13:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L17:
        return new LayoutParams(r100);
    L19:
        return super.generateLayoutParams(r100);
    }

    public void setEnableOptimize(boolean r100) {
        this.f64582k = r100;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final RelativeLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        if (this.f64582k == false) goto L7;
        return new LayoutParams(getContext(), r100);
    L7:
        return super.generateLayoutParams(r100);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public LiveMeasureOnceRelativeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        if (this.f64582k == false) goto L11;
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        if ((r101 instanceof LayoutParams) == true) goto L11;
        if ((r101 instanceof RelativeLayout.LayoutParams) == false) goto L11;
        r101 = new LayoutParams((RelativeLayout.LayoutParams) r101);
    L11:
        super.addView(r100, r101);
    }

    public final View d(int[] r100, int r101) {
        int r102 = r100[r101];
        if (r102 == 0) goto L18;
        a.C1060a r103 = this.f64578g.f64588b.get(r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        View r104 = r103.f64591a;
    L9:
        if (r104.getVisibility() != 8) goto L17;
        int[] r105 = ((LayoutParams) r104.getLayoutParams()).getRules();
        a.C1060a r106 = this.f64578g.f64588b.get(r105[r101]);
        if (r106 == null) goto L16;
        View r107 = r106.f64591a;
        if (r104 == r107) goto L16;
        r104 = r107;
    L16:
        return null;
    L17:
        return r104;
    L18:
        return null;
    }

    public final LayoutParams e(int[] r100, int r101) {
        View r102 = d(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if ((r102.getLayoutParams() instanceof LayoutParams) == true) goto L7;
        return null;
    L7:
        return (LayoutParams) r102.getLayoutParams();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r310, int r311) {
        if (this.f64582k == true) goto L7;
        super.onMeasure(r310, r311);
        return;
    L7:
        if (this.f64575d == false) goto L34;
        this.f64575d = false;
        Map<View, Integer> r100 = this.f64579h;
        if (r100 == null) goto L11;
        ((HashMap) r100).clear();
    L11:
        int r101 = getChildCount();
        View[] r102 = this.f64577f;
        if (r102 != null) goto L14;
    L15:
        this.f64577f = new View[r101];
    L16:
        View[] r103 = this.f64576e;
        if (r103 != null) goto L19;
    L20:
        this.f64576e = new View[r101];
    L21:
        a r104 = this.f64578g;
        ArrayList<a.C1060a> r105 = r104.f64587a;
        int r106 = r105.size();
        int r107 = 0;
    L22:
        if (r107 >= r106) goto L24;
        a.C1060a r108 = (a.C1060a) ListProtector.get(r105, r107);
        r108.f64591a = null;
        r108.f64592b.clear();
        r108.f64593c.clear();
        a.C1060a.f64590d.release(r108);
        r107 = r107 + 1;
        goto L22
    L24:
        r105.clear();
        r104.f64588b.clear();
        r104.f64589c.clear();
        int r109 = 0;
    L25:
        if (r109 >= r101) goto L33;
        View r110 = getChildAt(r109);
        int r111 = r110.getId();
        a.C1060a r112 = a.C1060a.f64590d.acquire();
        if (r112 != null) goto L29;
        r112 = new a.C1060a();
    L29:
        r112.f64591a = r110;
        if (r111 == (-1)) goto L32;
        r104.f64588b.put(r111, r112);
    L32:
        r104.f64587a.add(r112);
        r109 = r109 + 1;
        goto L25
    L33:
        r104.a(this.f64582k, this.f64579h, 2, this.f64577f, f64570l);
        r104.a(this.f64582k, this.f64579h, 1, this.f64576e, f64571m);
        goto L34
    L19:
        if (r103.length == r101) goto L21;
    L14:
        if (r102.length == r101) goto L16;
    L34:
        int r113 = View.MeasureSpec.getMode(r310);
        int r114 = View.MeasureSpec.getMode(r311);
        int r115 = View.MeasureSpec.getSize(r310);
        int r116 = View.MeasureSpec.getSize(r311);
        if (r113 == 0) goto L37;
        int r117 = r115;
    L38:
        if (r114 == 0) goto L40;
        int r118 = r116;
    L42:
        if (r113 != 1073741824) goto L44;
        int r119 = r117;
    L45:
        if (r114 != 1073741824) goto L47;
        int r120 = r118;
    L48:
        int r121 = getGravity();
        int r122 = r121 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r122 == 8388611) goto L52;
        if (r122 == 0) goto L52;
        boolean r210 = true;
    L53:
        int r123 = r121 & 112;
        if (r123 == 48) goto L57;
        if (r123 == 0) goto L57;
        boolean r211 = true;
    L59:
        if (Build.VERSION.SDK_INT < 29) goto L61;
        int r124 = getIgnoreGravity();
    L62:
        if (r210 == true) goto L64;
        if (r211 == true) goto L64;
    L66:
        View r125 = null;
    L67:
        if (r113 == 1073741824) goto L69;
        boolean r126 = true;
    L70:
        if (r114 == 1073741824) goto L72;
        boolean r127 = true;
    L73:
        int r212 = getLayoutDirection();
        View[] r128 = this.f64576e;
        int r129 = r128.length;
        int r130 = 0;
        boolean r213 = false;
        boolean r214 = false;
    L74:
        int r131 = 8;
        if (r130 >= r129) goto L137;
        View r132 = r128[r130];
        if (r132.getVisibility() == 8) goto L135;
        LayoutParams r133 = (LayoutParams) r132.getLayoutParams();
        int[] r134 = r133.getRules();
        if (this.f64582k == true) goto L81;
    L85:
        boolean r135 = false;
    L87:
        if (this.f64582k == false) goto L92;
        if (r135 == false) goto L92;
        if ((((Integer) ((HashMap) this.f64579h).get(r132)).intValue() % 2) != 0) goto L92;
        boolean r136 = true;
    L94:
        if (this.f64582k == false) goto L99;
        if (r135 == false) goto L99;
        if (((((Integer) ((HashMap) this.f64579h).get(r132)).intValue() >> 1) % 2) != 0) goto L99;
        boolean r137 = true;
    L100:
        if (r136 == true) goto L123;
        if (r137 == true) goto L123;
        a(r133, r117, r134);
        int r312 = r130;
        View[] r313 = r128;
        boolean r138 = r127;
        boolean r139 = r126;
        int r215 = r129;
        View r140 = r125;
        int r141 = c(r133.f64583a, r133.f64585c, ((RelativeLayout.LayoutParams) r133).width, ((RelativeLayout.LayoutParams) r133).leftMargin, ((RelativeLayout.LayoutParams) r133).rightMargin, getPaddingLeft(), getPaddingRight(), r117);
        if (r118 < 0) goto L105;
    L111:
        LayoutParams r142 = r133;
        if (this.f64581j == false) goto L114;
        int r143 = Math.max(0, (((r118 - getPaddingTop()) - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r142).topMargin) - ((RelativeLayout.LayoutParams) r142).bottomMargin);
    L116:
        if (((RelativeLayout.LayoutParams) r142).height != (-1)) goto L118;
        int r144 = 1073741824;
    L119:
        int r145 = View.MeasureSpec.makeMeasureSpec(r143, r144);
    L120:
        r132.measure(r141, r145);
        boolean r146 = r139;
        if (g(r132, r142, r117, r139) == false) goto L136;
        r213 = true;
    L136:
        r130 = r312 + 1;
        r126 = r146;
        r125 = r140;
        r127 = r138;
        r129 = r215;
        r128 = r313;
        goto L74
    L118:
        r144 = Integer.MIN_VALUE;
        goto L119
    L114:
        r143 = Math.max(0, r118);
        goto L116
    L105:
        if (this.f64580i == true) goto L111;
        r142 = r133;
        int r147 = ((RelativeLayout.LayoutParams) r142).height;
        if (r147 < 0) goto L109;
        r145 = View.MeasureSpec.makeMeasureSpec(r147, 1073741824);
        goto L120
    L109:
        r145 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L123:
        r312 = r130;
        r215 = r129;
        r313 = r128;
        r138 = r127;
        r146 = r126;
        r140 = r125;
        if (r136 == false) goto L127;
        if (r137 == true) goto L127;
        a(r133, r117, r134);
    L127:
        if (r136 == true) goto L136;
        if (r137 == false) goto L136;
        a(r133, r117, r134);
        b(r133, r118, r132.getBaseline());
        f(r132, r133, r117, r118);
        if (g(r132, r133, r117, r146) == false) goto L133;
        r213 = true;
    L133:
        if (h(r132, r133, r118, r138) == false) goto L136;
        r214 = true;
    L99:
        r137 = false;
    L92:
        r136 = false;
        goto L94
    L81:
        if (((HashMap) this.f64579h).containsKey(r132) == false) goto L85;
        if (((HashMap) this.f64579h).get(r132) == null) goto L85;
        r135 = true;
        goto L87
    L135:
        r312 = r130;
        r215 = r129;
        r313 = r128;
        r138 = r127;
        r146 = r126;
        r140 = r125;
        goto L136
    L137:
        boolean r148 = r127;
        boolean r149 = r126;
        View r150 = r125;
        View[] r151 = this.f64577f;
        int r152 = r151.length;
        int r153 = getContext().getApplicationInfo().targetSdkVersion;
        int r154 = r119;
        int r155 = r120;
        int r156 = 0;
        int r157 = Integer.MAX_VALUE;
        int r158 = Integer.MIN_VALUE;
        int r159 = Integer.MAX_VALUE;
        int r314 = Integer.MIN_VALUE;
    L138:
        if (r156 >= r152) goto L206;
        int r160 = r152;
        View r161 = r151[r156];
        View[] r162 = r151;
        if (r161.getVisibility() == r131) goto L204;
        LayoutParams r163 = (LayoutParams) r161.getLayoutParams();
        if (this.f64582k == true) goto L144;
    L148:
        boolean r164 = false;
    L150:
        if (this.f64582k == false) goto L155;
        if (r164 == false) goto L155;
        if ((((Integer) ((HashMap) this.f64579h).get(r161)).intValue() % 2) != 0) goto L155;
        boolean r165 = true;
    L157:
        if (this.f64582k == false) goto L162;
        if (r164 == false) goto L162;
        if (((((Integer) ((HashMap) this.f64579h).get(r161)).intValue() >> 1) % 2) != 0) goto L162;
        boolean r166 = true;
    L163:
        if (r165 == true) goto L168;
        if (r166 == true) goto L168;
        b(r163, r118, r161.getBaseline());
        f(r161, r163, r117, r118);
        if (h(r161, r163, r118, r148) == false) goto L188;
    L186:
        r214 = true;
    L188:
        if (r149 == false) goto L192;
        if (r153 >= 19) goto L191;
        r154 = Math.max(r154, r163.f64585c);
        goto L192
    L191:
        r154 = Math.max(r154, r163.f64585c + ((RelativeLayout.LayoutParams) r163).rightMargin);
    L192:
        if (r148 == false) goto L196;
        if (r153 >= 19) goto L195;
        r155 = Math.max(r155, r163.f64586d);
        goto L196
    L195:
        r155 = Math.max(r155, r163.f64586d + ((RelativeLayout.LayoutParams) r163).bottomMargin);
    L196:
        if (r161 != r150) goto L198;
        if (r211 == true) goto L198;
    L199:
        if (r161 != r150) goto L203;
        if (r210 == true) goto L203;
        r158 = r158;
    L205:
        r156 = r156 + 1;
        r152 = r160;
        r151 = r162;
        r131 = 8;
    L203:
        int r167 = Math.max(r158, r163.f64585c + ((RelativeLayout.LayoutParams) r163).rightMargin);
        r158 = r167;
        r314 = Math.max(r314, r163.f64586d + ((RelativeLayout.LayoutParams) r163).bottomMargin);
    L198:
        r157 = Math.min(r157, r163.f64583a - ((RelativeLayout.LayoutParams) r163).leftMargin);
        r159 = Math.min(r159, r163.f64584b - ((RelativeLayout.LayoutParams) r163).topMargin);
    L168:
        if (r165 == false) goto L176;
        if (r166 == true) goto L176;
        b(r163, r118, r161.getBaseline());
        f(r161, r163, r117, r118);
        if (g(r161, r163, r117, r149) == false) goto L174;
        r213 = true;
    L174:
        if (h(r161, r163, r118, r148) == false) goto L188;
    L176:
        if (r165 == true) goto L179;
        if (r166 == true) goto L188;
    L179:
        if (r166 == false) goto L188;
        if (r165 == false) goto L188;
        a(r163, r117, r163.getRules());
        b(r163, r118, r161.getBaseline());
        f(r161, r163, r117, r118);
        if (g(r161, r163, r117, r149) == false) goto L185;
        r213 = true;
    L185:
        if (h(r161, r163, r118, r148) == false) goto L188;
    L162:
        r166 = false;
    L155:
        r165 = false;
        goto L157
    L144:
        if (((HashMap) this.f64579h).containsKey(r161) == false) goto L148;
        if (((HashMap) this.f64579h).get(r161) == null) goto L148;
        r164 = true;
        goto L150
    L204:
        r156 = r156;
        goto L205
    L206:
        View[] r168 = r151;
        int r169 = r158;
        int r170 = r314;
        int r171 = r152;
        LayoutParams r172 = null;
        int r173 = 0;
        View r174 = null;
    L207:
        if (r173 >= r171) goto L222;
        View r175 = r168[r173];
        View r176 = r150;
        if (r175.getVisibility() == 8) goto L221;
        LayoutParams r177 = (LayoutParams) r175.getLayoutParams();
        if (r174 == null) goto L220;
        if (r172 == null) goto L220;
        int r178 = r177.f64584b - r172.f64584b;
        if (r178 != 0) goto L217;
        r178 = r177.f64583a - r172.f64583a;
    L217:
        if (r178 >= 0) goto L221;
    L220:
        r172 = r177;
        r174 = r175;
    L221:
        r173 = r173 + 1;
        r150 = r176;
        goto L207
    L222:
        View r179 = r150;
        this.f64572a = r174;
        if (r149 == false) goto L245;
        int r180 = r154 + getPaddingRight();
        if (getLayoutParams() != null) goto L227;
    L229:
        r154 = RelativeLayout.resolveSize(Math.max(r180, getSuggestedMinimumWidth()), r310);
        if (r213 == false) goto L245;
        int r181 = 0;
    L232:
        if (r181 >= r171) goto L245;
        View r182 = r168[r181];
        if (r182.getVisibility() == 8) goto L244;
        LayoutParams r183 = (LayoutParams) r182.getLayoutParams();
        int[] r184 = r183.getRules();
        if (r184[13] == 0) goto L238;
    L243:
        int r185 = r182.getMeasuredWidth();
        int r186 = (r154 - r185) / 2;
        r183.f64583a = r186;
        r183.f64585c = r186 + r185;
        goto L244
    L238:
        if (r184[14] != 0) goto L243;
        if (r184[11] == 0) goto L244;
        int r187 = r182.getMeasuredWidth();
        int r188 = (r154 - getPaddingRight()) - r187;
        r183.f64583a = r188;
        r183.f64585c = r188 + r187;
    L244:
        r181 = r181 + 1;
        goto L232
    L227:
        if (getLayoutParams().width < 0) goto L229;
        r180 = Math.max(r180, getLayoutParams().width);
    L245:
        int r189 = r154;
        if (r148 == false) goto L268;
        int r190 = r155 + getPaddingBottom();
        if (getLayoutParams() != null) goto L250;
    L252:
        r155 = RelativeLayout.resolveSize(Math.max(r190, getSuggestedMinimumHeight()), r311);
        if (r214 == false) goto L268;
        int r191 = 0;
    L255:
        if (r191 >= r171) goto L268;
        View r192 = r168[r191];
        if (r192.getVisibility() == 8) goto L267;
        LayoutParams r193 = (LayoutParams) r192.getLayoutParams();
        int[] r194 = r193.getRules();
        if (r194[13] == 0) goto L261;
    L266:
        int r195 = r192.getMeasuredHeight();
        int r196 = (r155 - r195) / 2;
        r193.f64584b = r196;
        r193.f64586d = r196 + r195;
        goto L267
    L261:
        if (r194[15] != 0) goto L266;
        if (r194[12] == 0) goto L267;
        int r197 = r192.getMeasuredHeight();
        int r198 = (r155 - getPaddingBottom()) - r197;
        r193.f64584b = r198;
        r193.f64586d = r198 + r197;
    L267:
        r191 = r191 + 1;
        goto L255
    L250:
        if (getLayoutParams().height < 0) goto L252;
        r190 = Math.max(r190, getLayoutParams().height);
    L268:
        int r199 = r155;
        if (r210 == true) goto L271;
        if (r211 == true) goto L271;
    L287:
        setMeasuredDimension(r189, r199);
        return;
    L271:
        Rect r200 = this.f64574c;
        r200.set(getPaddingLeft(), getPaddingTop(), r189 - getPaddingRight(), r199 - getPaddingBottom());
        Rect r1100 = this.f64573b;
        Gravity.apply(r121, r169 - r157, r170 - r159, r200, r1100, r212);
        int r201 = r1100.left - r157;
        int r202 = r1100.top - r159;
        if (r201 != 0) goto L274;
        if (r202 == 0) goto L287;
    L274:
        int r1101 = 0;
    L275:
        if (r1101 >= r171) goto L287;
        View r203 = r168[r1101];
        if (r203.getVisibility() == 8) goto L285;
        View r204 = r179;
        if (r203 == r204) goto L286;
        LayoutParams r205 = (LayoutParams) r203.getLayoutParams();
        if (r210 == false) goto L283;
        r205.f64583a += r201;
        r205.f64585c += r201;
    L283:
        if (r211 == false) goto L286;
        r205.f64584b += r202;
        r205.f64586d += r202;
    L286:
        r1101 = r1101 + 1;
        r179 = r204;
        goto L275
    L285:
        r204 = r179;
        goto L286
    L72:
        r127 = false;
        goto L73
    L69:
        r126 = false;
    L64:
        if (r124 == (-1)) goto L66;
        r125 = findViewById(r124);
        goto L67
    L61:
        r124 = 0;
    L57:
        r211 = false;
    L52:
        r210 = false;
        goto L53
    L47:
        r120 = 0;
        goto L48
    L44:
        r119 = 0;
        goto L45
    L40:
        r118 = -1;
        goto L42
    L37:
        r117 = -1;
        goto L38
    }

    public void onSetLayoutParams(View r100, ViewGroup.LayoutParams r101) {
        if (this.f64582k == true) goto L5;
    L7:
        requestLayout();
        return;
    L5:
        if ((r101 instanceof LayoutParams) == true) goto L7;
        r100.setLayoutParams(generateLayoutParams(r101));
    }

    public LiveMeasureOnceRelativeLayout(Context r100, AttributeSet r101, int r102) {
        boolean r103 = false;
        super(r100, r101, r102, 0);
        this.f64572a = null;
        this.f64573b = new Rect();
        this.f64574c = new Rect();
        this.f64578g = new a();
        this.f64579h = new HashMap();
        this.f64580i = false;
        this.f64581j = false;
        this.f64582k = h2.f497233a.getValue().booleanValue();
        int r104 = r100.getApplicationInfo().targetSdkVersion;
        if (r104 > 17) goto L5;
        boolean r105 = true;
    L6:
        this.f64580i = r105;
        if (r104 < 18) goto L9;
        r103 = true;
    L9:
        this.f64581j = r103;
        return;
    L5:
        r105 = false;
        goto L6
    }

    public final void a(LayoutParams r100, int r101, int[] r102) {
        r100.f64583a = Integer.MIN_VALUE;
        r100.f64585c = Integer.MIN_VALUE;
        LayoutParams r103 = e(r102, 0);
        if (r103 == null) goto L6;
        r100.f64585c = r103.f64583a - (((RelativeLayout.LayoutParams) r103).leftMargin + ((RelativeLayout.LayoutParams) r100).rightMargin);
    L11:
        LayoutParams r104 = e(r102, 1);
        if (r104 == null) goto L15;
        r100.f64583a = r104.f64585c + (((RelativeLayout.LayoutParams) r104).rightMargin + ((RelativeLayout.LayoutParams) r100).leftMargin);
    L19:
        LayoutParams r105 = e(r102, 5);
        if (r105 == null) goto L23;
        r100.f64583a = r105.f64583a + ((RelativeLayout.LayoutParams) r100).leftMargin;
    L27:
        LayoutParams r106 = e(r102, 7);
        if (r106 == null) goto L31;
        r100.f64585c = r106.f64585c - ((RelativeLayout.LayoutParams) r100).rightMargin;
    L37:
        if (r102[9] == 0) goto L40;
        r100.f64583a = getPaddingLeft() + ((RelativeLayout.LayoutParams) r100).leftMargin;
    L40:
        if (r102[11] == 0) goto L44;
        if (r101 < 0) goto L45;
        r100.f64585c = (r101 - getPaddingRight()) - ((RelativeLayout.LayoutParams) r100).rightMargin;
        return;
    L45:
        return;
    L44:
        return;
    L31:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L37;
        if (r102[7] == 0) goto L37;
        if (r101 < 0) goto L37;
        r100.f64585c = (r101 - getPaddingRight()) - ((RelativeLayout.LayoutParams) r100).rightMargin;
        goto L37
    L23:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L27;
        if (r102[5] == 0) goto L27;
        r100.f64583a = getPaddingLeft() + ((RelativeLayout.LayoutParams) r100).leftMargin;
        goto L27
    L15:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L19;
        if (r102[1] == 0) goto L19;
        r100.f64583a = getPaddingLeft() + ((RelativeLayout.LayoutParams) r100).leftMargin;
        goto L19
    L6:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L11;
        if (r102[0] == 0) goto L11;
        if (r101 < 0) goto L11;
        r100.f64585c = (r101 - getPaddingRight()) - ((RelativeLayout.LayoutParams) r100).rightMargin;
        goto L11
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (this.f64582k == false) goto L11;
        if (r100 == null) goto L11;
        if (r102 == null) goto L11;
        if ((r102 instanceof LayoutParams) == true) goto L11;
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L11;
        r102 = new LayoutParams((RelativeLayout.LayoutParams) r102);
    L11:
        super.addView(r100, r101, r102);
    }

    public final void b(LayoutParams r100, int r101, int r102) {
        int[] r103 = r100.getRules();
        View r104 = d(r103, 4);
        if (r104 == null) goto L9;
        int r105 = r104.getBaseline();
        if (r105 == (-1)) goto L9;
        if ((r104.getLayoutParams() instanceof LayoutParams) == false) goto L9;
        int r106 = ((LayoutParams) r104.getLayoutParams()).f64584b + r105;
    L11:
        if (r106 == (-1)) goto L16;
        if (r102 == (-1)) goto L14;
        r106 = r106 - r102;
    L14:
        r100.f64584b = r106;
        r100.f64586d = Integer.MIN_VALUE;
        return;
    L16:
        r100.f64584b = Integer.MIN_VALUE;
        r100.f64586d = Integer.MIN_VALUE;
        LayoutParams r107 = e(r103, 2);
        if (r107 == null) goto L20;
        r100.f64586d = r107.f64584b - (((RelativeLayout.LayoutParams) r107).topMargin + ((RelativeLayout.LayoutParams) r100).bottomMargin);
    L25:
        LayoutParams r108 = e(r103, 3);
        if (r108 == null) goto L29;
        r100.f64584b = r108.f64586d + (((RelativeLayout.LayoutParams) r108).bottomMargin + ((RelativeLayout.LayoutParams) r100).topMargin);
    L33:
        LayoutParams r109 = e(r103, 6);
        if (r109 == null) goto L37;
        r100.f64584b = r109.f64584b + ((RelativeLayout.LayoutParams) r100).topMargin;
    L41:
        LayoutParams r110 = e(r103, 8);
        if (r110 == null) goto L45;
        r100.f64586d = r110.f64586d - ((RelativeLayout.LayoutParams) r100).bottomMargin;
    L51:
        if (r103[10] == 0) goto L54;
        r100.f64584b = getPaddingTop() + ((RelativeLayout.LayoutParams) r100).topMargin;
    L54:
        if (r103[12] == 0) goto L58;
        if (r101 < 0) goto L59;
        r100.f64586d = (r101 - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r100).bottomMargin;
        return;
    L59:
        return;
    L58:
        return;
    L45:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L51;
        if (r103[8] == 0) goto L51;
        if (r101 < 0) goto L51;
        r100.f64586d = (r101 - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r100).bottomMargin;
        goto L51
    L37:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L41;
        if (r103[6] == 0) goto L41;
        r100.f64584b = getPaddingTop() + ((RelativeLayout.LayoutParams) r100).topMargin;
        goto L41
    L29:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L33;
        if (r103[3] == 0) goto L33;
        r100.f64584b = getPaddingTop() + ((RelativeLayout.LayoutParams) r100).topMargin;
        goto L33
    L20:
        if (((RelativeLayout.LayoutParams) r100).alignWithParent == false) goto L25;
        if (r103[2] == 0) goto L25;
        if (r101 < 0) goto L25;
        r100.f64586d = (r101 - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r100).bottomMargin;
    L9:
        r106 = -1;
        goto L11
    }

    public final void f(View r110, LayoutParams r111, int r112, int r113) {
        r110.measure(c(r111.f64583a, r111.f64585c, ((RelativeLayout.LayoutParams) r111).width, ((RelativeLayout.LayoutParams) r111).leftMargin, ((RelativeLayout.LayoutParams) r111).rightMargin, getPaddingLeft(), getPaddingRight(), r112), c(r111.f64584b, r111.f64586d, ((RelativeLayout.LayoutParams) r111).height, ((RelativeLayout.LayoutParams) r111).topMargin, ((RelativeLayout.LayoutParams) r111).bottomMargin, getPaddingTop(), getPaddingBottom(), r113));
    }

    public final boolean g(View r100, LayoutParams r101, int r102, boolean r103) {
        getLayoutDirection();
        int[] r104 = r101.getRules();
        int r105 = r101.f64583a;
        if (r105 != Integer.MIN_VALUE) goto L7;
        int r106 = r101.f64585c;
        if (r106 == Integer.MIN_VALUE) goto L7;
        r101.f64583a = r106 - r100.getMeasuredWidth();
    L25:
        if (r104[21] != 0) goto L29;
        return false;
    L29:
        return true;
    L7:
        if (r105 != Integer.MIN_VALUE) goto L9;
    L11:
        if (r105 != Integer.MIN_VALUE) goto L25;
        if (r101.f64585c != Integer.MIN_VALUE) goto L25;
        if (r104[13] == 0) goto L17;
    L20:
        if (r103 == true) goto L22;
        int r107 = r100.getMeasuredWidth();
        int r108 = (r102 - r107) / 2;
        r101.f64583a = r108;
        r101.f64585c = r108 + r107;
    L23:
        return true;
    L22:
        int r109 = getPaddingLeft() + ((RelativeLayout.LayoutParams) r101).leftMargin;
        r101.f64583a = r109;
        r101.f64585c = r109 + r100.getMeasuredWidth();
        goto L23
    L17:
        if (r104[14] != 0) goto L20;
        int r110 = getPaddingLeft() + ((RelativeLayout.LayoutParams) r101).leftMargin;
        r101.f64583a = r110;
        r101.f64585c = r110 + r100.getMeasuredWidth();
        goto L25
    L9:
        if (r101.f64585c != Integer.MIN_VALUE) goto L11;
        r101.f64585c = r105 + r100.getMeasuredWidth();
        goto L25
    }

    public final boolean h(View r100, LayoutParams r101, int r102, boolean r103) {
        int[] r104 = r101.getRules();
        int r105 = r101.f64584b;
        if (r105 != Integer.MIN_VALUE) goto L7;
        int r106 = r101.f64586d;
        if (r106 == Integer.MIN_VALUE) goto L7;
        r101.f64584b = r106 - r100.getMeasuredHeight();
    L25:
        if (r104[12] != 0) goto L29;
        return false;
    L29:
        return true;
    L7:
        if (r105 != Integer.MIN_VALUE) goto L9;
    L11:
        if (r105 != Integer.MIN_VALUE) goto L25;
        if (r101.f64586d != Integer.MIN_VALUE) goto L25;
        if (r104[13] == 0) goto L17;
    L20:
        if (r103 == true) goto L22;
        int r107 = r100.getMeasuredHeight();
        int r108 = (r102 - r107) / 2;
        r101.f64584b = r108;
        r101.f64586d = r108 + r107;
    L23:
        return true;
    L22:
        int r109 = getPaddingTop() + ((RelativeLayout.LayoutParams) r101).topMargin;
        r101.f64584b = r109;
        r101.f64586d = r109 + r100.getMeasuredHeight();
        goto L23
    L17:
        if (r104[15] != 0) goto L20;
        int r110 = getPaddingTop() + ((RelativeLayout.LayoutParams) r101).topMargin;
        r101.f64584b = r110;
        r101.f64586d = r110 + r100.getMeasuredHeight();
        goto L25
    L9:
        if (r101.f64586d != Integer.MIN_VALUE) goto L11;
        r101.f64586d = r105 + r100.getMeasuredHeight();
        goto L25
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.f64582k == true) goto L6;
        super.onLayout(r100, r101, r102, r103, r104);
        return;
    L6:
        int r105 = getChildCount();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L12;
        View r107 = getChildAt(r106);
        if (r107.getVisibility() == 8) goto L11;
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        r107.layout(r108.f64583a, r108.f64584b, r108.f64585c, r108.f64586d);
    L11:
        r106 = r106 + 1;
        goto L7
    }

    public final int c(int r100, int r101, int r102, int r103, int r110, int r111, int r112, int r113) {
        int r104 = 0;
        if (r113 >= 0) goto L5;
        boolean r105 = true;
    L6:
        int r106 = 1073741824;
        if (r105 == true) goto L9;
    L18:
        if (r100 != Integer.MIN_VALUE) goto L20;
        int r114 = r111 + r103;
    L21:
        if (r101 != Integer.MIN_VALUE) goto L23;
        int r115 = (r113 - r112) - r110;
    L24:
        int r116 = r115 - r114;
        if (r100 == Integer.MIN_VALUE) goto L31;
        if (r101 == Integer.MIN_VALUE) goto L31;
        if (r105 == false) goto L29;
        r106 = 0;
    L29:
        r102 = Math.max(0, r116);
    L30:
        r104 = r106;
    L46:
        return View.MeasureSpec.makeMeasureSpec(r102, r104);
    L31:
        if (r102 < 0) goto L36;
        if (r116 < 0) goto L34;
        r102 = Math.min(r116, r102);
    L34:
        r104 = 1073741824;
        goto L46
    L36:
        if (r102 != (-1)) goto L41;
        if (r105 == false) goto L39;
        r106 = 0;
    L39:
        r102 = Math.max(0, r116);
        goto L30
    L41:
        if (r102 != (-2)) goto L44;
        if (r116 < 0) goto L44;
        r102 = r116;
        r104 = Integer.MIN_VALUE;
    L44:
        r102 = 0;
        goto L46
    L23:
        r115 = r101;
        goto L24
    L20:
        r114 = r100;
        goto L21
    L9:
        if (this.f64580i == true) goto L18;
        if (r100 == Integer.MIN_VALUE) goto L13;
        if (r101 == Integer.MIN_VALUE) goto L13;
        r102 = Math.max(0, r101 - r100);
    L14:
        r104 = 1073741824;
    L17:
        return View.MeasureSpec.makeMeasureSpec(r102, r104);
    L13:
        if (r102 >= 0) goto L14;
        r102 = 0;
        goto L17
    L5:
        r105 = false;
        goto L6
    }
}
