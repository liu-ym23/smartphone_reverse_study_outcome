package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
@RemoteViews.RemoteView
public class BadgeCompatRelativeLayout extends ViewGroup {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f177885o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f177886p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f177887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f177888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f177889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f177890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f177891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f177892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View[] f177893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f177894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f177895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f177896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f177897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f177898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f177899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f177900n;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty(category = "layout", indexMapping = {@ViewDebug.IntToString(from = 2, to = "above"), @ViewDebug.IntToString(from = 4, to = "alignBaseline"), @ViewDebug.IntToString(from = 8, to = "alignBottom"), @ViewDebug.IntToString(from = 5, to = "alignLeft"), @ViewDebug.IntToString(from = 12, to = "alignParentBottom"), @ViewDebug.IntToString(from = 9, to = "alignParentLeft"), @ViewDebug.IntToString(from = 11, to = "alignParentRight"), @ViewDebug.IntToString(from = 10, to = "alignParentTop"), @ViewDebug.IntToString(from = 7, to = "alignRight"), @ViewDebug.IntToString(from = 6, to = "alignTop"), @ViewDebug.IntToString(from = 3, to = "below"), @ViewDebug.IntToString(from = 14, to = "centerHorizontal"), @ViewDebug.IntToString(from = 13, to = "center"), @ViewDebug.IntToString(from = 15, to = "centerVertical"), @ViewDebug.IntToString(from = 0, to = "leftOf"), @ViewDebug.IntToString(from = 1, to = "rightOf"), @ViewDebug.IntToString(from = 18, to = "alignStart"), @ViewDebug.IntToString(from = 19, to = "alignEnd"), @ViewDebug.IntToString(from = 20, to = "alignParentStart"), @ViewDebug.IntToString(from = 21, to = "alignParentEnd"), @ViewDebug.IntToString(from = 16, to = "startOf"), @ViewDebug.IntToString(from = 17, to = "endOf")}, mapping = {@ViewDebug.IntToString(from = -1, to = "true"), @ViewDebug.IntToString(from = 0, to = "false/NO_ID")}, resolveId = true)
        public final int[] f177901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f177902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f177903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f177904d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f177905e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f177906f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f177907g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f177908h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f177909i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @ViewDebug.ExportedProperty(category = "layout")
        public final boolean f177910j;

        public LayoutParams(LayoutParams r100) {
            super(r100);
            int[] r101 = new int[22];
            this.f177901a = r101;
            int[] r102 = new int[22];
            this.f177902b = r102;
            this.f177908h = false;
            this.f177909i = false;
            this.f177909i = r100.f177909i;
            this.f177908h = r100.f177908h;
            this.f177910j = r100.f177910j;
            System.arraycopy(r100.f177901a, 0, r101, 0, 22);
            System.arraycopy(r100.f177902b, 0, r102, 0, 22);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public final void resolveLayoutDirection(int r110) {
            if (this.f177907g == true) goto L21;
            int[] r100 = this.f177902b;
            if (r100[16] == 0) goto L7;
        L18:
            boolean r101 = true;
        L19:
            if (r101 == true) goto L21;
        L25:
            boolean r102 = false;
        L27:
            if (r102 == false) goto L122;
            if (r110 != 1) goto L30;
            char r103 = 1;
        L31:
            System.arraycopy(this.f177902b, 0, this.f177901a, 0, 22);
            char r111 = 7;
            char r112 = 11;
            if (this.f177909i == false) goto L69;
            int[] r104 = this.f177901a;
            int r113 = r104[18];
            if (r113 != 0) goto L36;
        L39:
            int r105 = r104[19];
            if (r105 != 0) goto L42;
        L45:
            int r106 = r104[16];
            if (r106 != 0) goto L48;
        L51:
            int r107 = r104[17];
            if (r107 != 0) goto L54;
        L57:
            int r108 = r104[20];
            if (r108 != 0) goto L60;
        L63:
            int r109 = r104[21];
            if (r109 != 0) goto L66;
        L121:
            this.f177908h = false;
            this.f177907g = false;
            goto L122
        L66:
            if (r104[11] != 0) goto L68;
            r104[11] = r109;
        L68:
            r104[21] = 0;
            goto L121
        L60:
            if (r104[9] != 0) goto L62;
            r104[9] = r108;
        L62:
            r104[20] = 0;
            goto L63
        L54:
            if (r104[1] != 0) goto L56;
            r104[1] = r107;
        L56:
            r104[17] = 0;
            goto L57
        L48:
            if (r104[0] != 0) goto L50;
            r104[0] = r106;
        L50:
            r104[16] = 0;
            goto L51
        L42:
            if (r104[7] != 0) goto L44;
            r104[7] = r105;
        L44:
            r104[19] = 0;
            goto L45
        L36:
            if (r104[5] != 0) goto L38;
            r104[5] = r113;
        L38:
            r104[18] = 0;
            goto L39
        L69:
            int[] r114 = this.f177901a;
            int r115 = r114[18];
            if (r115 != 0) goto L74;
            if (r114[19] != 0) goto L74;
        L78:
            if (r115 == 0) goto L83;
            if (r103 == 0) goto L81;
            char r116 = 7;
        L82:
            r114[r116] = r115;
            r114[18] = 0;
            goto L83
        L81:
            r116 = 5;
        L83:
            int r117 = r114[19];
            if (r117 == 0) goto L88;
            if (r103 == 0) goto L87;
            r111 = 5;
        L87:
            r114[r111] = r117;
            r114[19] = 0;
        L88:
            int r118 = r114[16];
            if (r118 != 0) goto L93;
            if (r114[17] != 0) goto L93;
        L97:
            if (r118 == 0) goto L99;
            r114[r103] = r118;
            r114[16] = 0;
        L99:
            int r119 = r114[17];
            if (r119 == 0) goto L102;
            r114[r103 ^ 1] = r119;
            r114[17] = 0;
        L102:
            int r120 = r114[20];
            if (r120 != 0) goto L107;
            if (r114[21] != 0) goto L107;
        L111:
            if (r120 == 0) goto L116;
            if (r103 == 0) goto L114;
            char r121 = 11;
        L115:
            r114[r121] = r120;
            r114[20] = 0;
            goto L116
        L114:
            r121 = '\t';
        L116:
            int r122 = r114[21];
            if (r122 == 0) goto L121;
            if (r103 == 0) goto L120;
            r112 = '\t';
        L120:
            r114[r112] = r122;
            r114[21] = 0;
        L107:
            if (r114[9] == 0) goto L109;
        L110:
            r114[9] = 0;
            r114[11] = 0;
            goto L111
        L109:
            if (r114[11] == 0) goto L111;
        L93:
            if (r114[0] == 0) goto L95;
        L96:
            r114[0] = 0;
            r114[1] = 0;
            goto L97
        L95:
            if (r114[1] == 0) goto L97;
        L74:
            if (r114[5] == 0) goto L76;
        L77:
            r114[5] = 0;
            r114[7] = 0;
            goto L78
        L76:
            if (r114[7] == 0) goto L78;
        L30:
            r103 = 0;
        L122:
            super.resolveLayoutDirection(r110);
            return;
        L7:
            if (r100[17] != 0) goto L18;
            if (r100[18] != 0) goto L18;
            if (r100[19] != 0) goto L18;
            if (r100[20] != 0) goto L18;
            if (r100[21] != 0) goto L18;
            r101 = false;
        L21:
            if (this.f177908h == false) goto L23;
        L26:
            r102 = true;
            goto L27
        L23:
            if (r110 == getLayoutDirection()) goto L25;
            goto L25
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f177901a = new int[22];
            this.f177902b = new int[22];
            this.f177908h = false;
            this.f177909i = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f177901a = new int[22];
            this.f177902b = new int[22];
            this.f177908h = false;
            this.f177909i = false;
        }

        public LayoutParams(Context r110, AttributeSet r111) {
            super(r110, r111);
            int[] r100 = new int[22];
            this.f177901a = r100;
            int[] r101 = new int[22];
            this.f177902b = r101;
            this.f177908h = false;
            this.f177909i = false;
            TypedArray r102 = r110.obtainStyledAttributes(r111, new int[]{R.attr.layout_above, R.attr.layout_alignBaseline, R.attr.layout_alignBottom, R.attr.layout_alignEnd, R.attr.layout_alignLeft, R.attr.layout_alignParentBottom, R.attr.layout_alignParentEnd, R.attr.layout_alignParentLeft, R.attr.layout_alignParentRight, R.attr.layout_alignParentStart, R.attr.layout_alignParentTop, R.attr.layout_alignRight, R.attr.layout_alignStart, R.attr.layout_alignTop, R.attr.layout_alignWithParentIfMissing, R.attr.layout_below, R.attr.layout_centerHorizontal, R.attr.layout_centerInParent, R.attr.layout_centerVertical, R.attr.layout_toEndOf, R.attr.layout_toLeftOf, R.attr.layout_toRightOf, R.attr.layout_toStartOf});
            int r103 = 1;
            if (r110.getApplicationInfo().targetSdkVersion >= 17) goto L5;
        L8:
            boolean r104 = true;
        L9:
            this.f177909i = r104;
            int r105 = r102.getIndexCount();
            int r106 = 0;
        L10:
            if (r106 >= r105) goto L113;
            int r112 = r102.getIndex(r106);
            if (r112 != 14) goto L15;
            this.f177910j = r102.getBoolean(r112, false);
        L112:
            r106 = r106 + 1;
            r103 = 1;
            goto L10
        L15:
            if (r112 != 20) goto L18;
            r100[0] = r102.getResourceId(r112, 0);
            goto L112
        L18:
            if (r112 != 21) goto L21;
            r100[r103] = r102.getResourceId(r112, 0);
            goto L112
        L21:
            if (r112 != 0) goto L24;
            r100[2] = r102.getResourceId(r112, 0);
            goto L112
        L24:
            if (r112 != 15) goto L27;
            r100[3] = r102.getResourceId(r112, 0);
            goto L112
        L27:
            if (r112 != r103) goto L30;
            r100[4] = r102.getResourceId(r112, 0);
            goto L112
        L30:
            if (r112 != 4) goto L33;
            r100[5] = r102.getResourceId(r112, 0);
            goto L112
        L33:
            if (r112 != 13) goto L36;
            r100[6] = r102.getResourceId(r112, 0);
            goto L112
        L36:
            if (r112 != 11) goto L39;
            r100[7] = r102.getResourceId(r112, 0);
            goto L112
        L39:
            if (r112 != 2) goto L41;
            r100[8] = r102.getResourceId(r112, 0);
            goto L112
        L41:
            int r113 = -1;
            if (r112 != 7) goto L49;
            if (r102.getBoolean(r112, false) == true) goto L47;
            r113 = 0;
        L47:
            r100[9] = r113;
            goto L112
        L49:
            if (r112 == 10) goto L51;
            if (r112 != 8) goto L62;
            if (r102.getBoolean(r112, false) == true) goto L60;
            r113 = 0;
        L60:
            r100[11] = r113;
            goto L112
        L62:
            if (r112 == 5) goto L64;
            if (r112 != 17) goto L75;
            if (r102.getBoolean(r112, false) == true) goto L73;
            r113 = 0;
        L73:
            r100[13] = r113;
            goto L112
        L75:
            if (r112 != 16) goto L82;
            if (r102.getBoolean(r112, false) == true) goto L80;
            r113 = 0;
        L80:
            r100[14] = r113;
            goto L112
        L82:
            if (r112 != 18) goto L89;
            if (r102.getBoolean(r112, false) == false) goto L86;
            char r107 = 15;
        L87:
            r100[r107] = r113;
            goto L112
        L86:
            r107 = 15;
            r113 = 0;
            goto L87
        L89:
            if (r112 != 22) goto L92;
            r100[16] = r102.getResourceId(r112, 0);
            goto L112
        L92:
            if (r112 != 19) goto L94;
            r100[17] = r102.getResourceId(r112, 0);
            goto L112
        L94:
            if (r112 != 12) goto L97;
            r100[18] = r102.getResourceId(r112, 0);
            goto L112
        L97:
            if (r112 != 3) goto L99;
            r100[19] = r102.getResourceId(r112, 0);
            goto L112
        L99:
            if (r112 != 9) goto L106;
            if (r102.getBoolean(r112, false) == false) goto L103;
            char r108 = 20;
        L104:
            r100[r108] = r113;
            goto L112
        L103:
            r108 = 20;
            r113 = 0;
            goto L104
        L106:
            if (r112 != 6) goto L112;
            if (r102.getBoolean(r112, false) == false) goto L110;
            char r109 = 21;
        L111:
            r100[r109] = r113;
            goto L112
        L110:
            r109 = 21;
            r113 = 0;
            goto L111
        L64:
            if (r102.getBoolean(r112, false) == true) goto L67;
            r113 = 0;
        L67:
            r100[12] = r113;
            goto L112
        L51:
            if (r102.getBoolean(r112, false) == true) goto L54;
            r113 = 0;
        L54:
            r100[10] = r113;
            goto L112
        L113:
            this.f177908h = true;
            System.arraycopy(r100, 0, r101, 0, 22);
            r102.recycle();
            return;
        L5:
            if ((r110.getApplicationInfo().flags & 4194304) != 4194304) goto L8;
            r104 = false;
            goto L9
        }

        public final void a(int r100, int r101) {
            if (this.f177907g == false) goto L5;
        L24:
            this.f177901a[r100] = r101;
            this.f177902b[r100] = r101;
            this.f177908h = true;
            return;
        L5:
            if (r100 != 16) goto L7;
        L18:
            boolean r102 = true;
        L19:
            if (r102 == false) goto L24;
            if (this.f177902b[r100] == 0) goto L24;
            if (r101 != 0) goto L24;
            this.f177907g = true;
            goto L24
        L7:
            if (r100 == 17) goto L18;
            if (r100 == 18) goto L18;
            if (r100 == 19) goto L18;
            if (r100 == 20) goto L18;
            if (r100 == 21) goto L18;
            r102 = false;
            goto L19
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.f177901a = new int[22];
            this.f177902b = new int[22];
            this.f177908h = false;
            this.f177909i = false;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<C2639a> f177911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<C2639a> f177912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayDeque<C2639a> f177913c;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeCompatRelativeLayout$a$a, reason: collision with other inner class name */
        public static class C2639a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final Pools.SynchronizedPool<C2639a> f177914d = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public View f177915a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ArrayMap<C2639a, a> f177916b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final SparseArray<C2639a> f177917c;

            static {
                f177914d = new Pools.SynchronizedPool(100);
            }

            public C2639a() {
                this.f177916b = new ArrayMap();
                this.f177917c = new SparseArray();
            }
        }

        public a() {
            this.f177911a = new ArrayList();
            this.f177912b = new SparseArray();
            this.f177913c = new ArrayDeque();
        }

        public final void a(View[] r110, int... r111) {
            SparseArray<C2639a> r100 = this.f177912b;
            ArrayList<C2639a> r101 = this.f177911a;
            int r102 = r101.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            C2639a r104 = (C2639a) ListProtector.get(r101, r103);
            r104.f177916b.clear();
            r104.f177917c.clear();
            r103 = r103 + 1;
            goto L3
        L5:
            int r105 = 0;
        L6:
            if (r105 >= r102) goto L27;
            C2639a r106 = (C2639a) ListProtector.get(r101, r105);
            int[] r107 = ((LayoutParams) r106.f177915a.getLayoutParams()).f177901a;
            int r108 = r111.length;
            int r109 = 0;
        L8:
            if (r109 >= r108) goto L26;
            int r112 = r107[r111[r109]];
            if (r112 > 0) goto L20;
            int[] r113 = BadgeCompatRelativeLayout.f177885o;
            if (r112 != (-1)) goto L14;
        L18:
            boolean r114 = false;
        L19:
            if (r114 == true) goto L20;
        L25:
            r109 = r109 + 1;
            goto L8
        L14:
            if (((-16777216) & r112) == 0) goto L18;
            if ((16711680 & r112) == 0) goto L18;
            r114 = true;
        L20:
            C2639a r115 = r100.get(r112);
            if (r115 == null) goto L25;
            if (r115 == r106) goto L25;
            r115.f177916b.put(r106, this);
            r106.f177917c.put(r112, r115);
            goto L25
        L26:
            r105 = r105 + 1;
            goto L6
        L27:
            ArrayDeque<C2639a> r116 = this.f177913c;
            r116.clear();
            int r117 = 0;
        L28:
            if (r117 >= r102) goto L33;
            C2639a r118 = (C2639a) ListProtector.get(r101, r117);
            if (r118.f177917c.size() != 0) goto L32;
            r116.addLast(r118);
        L32:
            r117 = r117 + 1;
            goto L28
        L33:
            int r119 = 0;
        L34:
            C2639a r120 = r116.pollLast();
            if (r120 == null) goto L44;
            View r121 = r120.f177915a;
            int r122 = r121.getId();
            int r123 = r119 + 1;
            r110[r119] = r121;
            ArrayMap<C2639a, a> r124 = r120.f177916b;
            int r125 = r124.size();
            int r126 = 0;
        L37:
            if (r126 >= r125) goto L42;
            C2639a r127 = r124.keyAt(r126);
            SparseArray<C2639a> r128 = r127.f177917c;
            r128.remove(r122);
            if (r128.size() != 0) goto L41;
            r116.add(r127);
        L41:
            r126 = r126 + 1;
            goto L37
        L42:
            r119 = r123;
            goto L34
        L44:
            if (r119 < r110.length) goto L47;
            return;
        L47:
            throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
        }
    }

    static {
        f177885o = new int[]{2, 3, 4, 6, 8};
        f177886p = new int[]{0, 1, 5, 7, 16, 17, 18, 19};
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return BadgeCompatRelativeLayout.class.getName();
    }

    @Override // android.view.View
    public int getBaseline() {
        View r100 = this.f177887a;
        if (r100 == null) goto L6;
        return r100.getBaseline();
    L6:
        return super.getBaseline();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        this.f177892f = true;
    }

    public int getGravity() {
        return this.f177888b;
    }

    public int getIgnoreGravity() {
        return this.f177891e;
    }

    public BadgeCompatRelativeLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r100);
    L7:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L11:
        return new LayoutParams(r100);
    }

    public void setAllowChildHorizontalBeyond(boolean r100) {
        this.f177898l = r100;
    }

    public void setAllowChildVerticalBeyond(boolean r100) {
        this.f177899m = r100;
    }

    public void setGravity(int r100) {
        if (this.f177888b != r100) goto L5;
        return;
    L5:
        if ((8388615 & r100) != 0) goto L8;
        r100 = r100 | GravityCompat.START;
    L8:
        if ((r100 & 112) != 0) goto L10;
        r100 = r100 | 48;
    L10:
        this.f177888b = r100;
        requestLayout();
    }

    public void setHorizontalGravity(int r100) {
        int r101 = r100 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r102 = this.f177888b;
        if ((8388615 & r102) == r101) goto L6;
        this.f177888b = r101 | ((-8388616) & r102);
        requestLayout();
        return;
    }

    public void setIgnoreAlignMarginForLeftRightOf(boolean r100) {
        this.f177900n = r100;
    }

    public void setIgnoreGravity(int r100) {
        this.f177891e = r100;
    }

    public void setVerticalGravity(int r100) {
        int r101 = r100 & 112;
        int r102 = this.f177888b;
        if ((r102 & 112) == r101) goto L6;
        this.f177888b = r101 | (r102 & (-113));
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public BadgeCompatRelativeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final View b(int[] r100, int r101) {
        int r102 = r100[r101];
        if (r102 == 0) goto L18;
        a.C2639a r103 = this.f177895i.f177912b.get(r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        View r104 = r103.f177915a;
    L9:
        if (r104.getVisibility() != 8) goto L17;
        LayoutParams r105 = (LayoutParams) r104.getLayoutParams();
        r105.resolveLayoutDirection(r104.getLayoutDirection());
        int[] r106 = r105.f177901a;
        a.C2639a r107 = this.f177895i.f177912b.get(r106[r101]);
        if (r107 == null) goto L16;
        View r108 = r107.f177915a;
        if (r104 == r108) goto L16;
        r104 = r108;
    L16:
        return null;
    L17:
        return r104;
    L18:
        return null;
    }

    public final LayoutParams c(int[] r100, int r101) {
        View r102 = b(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if ((r102.getLayoutParams() instanceof LayoutParams) == true) goto L7;
        return null;
    L7:
        return (LayoutParams) r102.getLayoutParams();
    }

    @Override // android.view.View
    public final void onMeasure(int r410, int r411) {
        int r110 = 0;
        if (this.f177892f == false) goto L27;
        this.f177892f = false;
        int r100 = getChildCount();
        View[] r101 = this.f177894h;
        if (r101 != null) goto L7;
    L8:
        this.f177894h = new View[r100];
    L9:
        View[] r102 = this.f177893g;
        if (r102 != null) goto L12;
    L13:
        this.f177893g = new View[r100];
    L14:
        a r103 = this.f177895i;
        ArrayList<a.C2639a> r104 = r103.f177911a;
        int r105 = r104.size();
        int r106 = 0;
    L15:
        if (r106 >= r105) goto L17;
        a.C2639a r107 = (a.C2639a) ListProtector.get(r104, r106);
        r107.f177915a = null;
        r107.f177916b.clear();
        r107.f177917c.clear();
        a.C2639a.f177914d.release(r107);
        r106 = r106 + 1;
        goto L15
    L17:
        r104.clear();
        r103.f177912b.clear();
        r103.f177913c.clear();
        int r108 = 0;
    L18:
        if (r108 >= r100) goto L26;
        View r109 = getChildAt(r108);
        int r111 = r109.getId();
        a.C2639a r112 = a.C2639a.f177914d.acquire();
        if (r112 != null) goto L22;
        r112 = new a.C2639a();
    L22:
        r112.f177915a = r109;
        if (r111 == (-1)) goto L25;
        r103.f177912b.put(r111, r112);
    L25:
        r103.f177911a.add(r112);
        r108 = r108 + 1;
        goto L18
    L26:
        r103.a(this.f177894h, f177885o);
        r103.a(this.f177893g, f177886p);
        goto L27
    L12:
        if (r102.length == r100) goto L14;
    L7:
        if (r101.length == r100) goto L9;
    L27:
        int r113 = View.MeasureSpec.getMode(r410);
        int r114 = View.MeasureSpec.getMode(r411);
        int r115 = View.MeasureSpec.getSize(r410);
        int r116 = View.MeasureSpec.getSize(r411);
        if (r113 == 0) goto L30;
        int r117 = r115;
    L31:
        if (r114 == 0) goto L33;
        int r118 = r116;
    L35:
        if (r113 != 1073741824) goto L37;
        int r119 = r117;
    L38:
        if (r114 != 1073741824) goto L40;
        int r120 = r118;
    L41:
        int r121 = this.f177888b;
        int r122 = 8388615 & r121;
        int r123 = 1;
        if (r122 == 8388611) goto L45;
        if (r122 == 0) goto L45;
        boolean r124 = true;
    L46:
        int r125 = r121 & 112;
        if (r125 == 48) goto L50;
        if (r125 == 0) goto L50;
        boolean r126 = true;
    L51:
        if (r124 == true) goto L53;
        if (r126 == true) goto L53;
    L56:
        View r127 = null;
    L57:
        if (r113 == 1073741824) goto L59;
        boolean r210 = true;
    L60:
        if (r114 == 1073741824) goto L62;
        boolean r211 = true;
    L63:
        int r128 = getLayoutDirection();
        View[] r129 = this.f177893g;
        int r130 = r129.length;
        int r131 = 0;
        boolean r212 = false;
    L64:
        int r132 = 8;
        if (r131 >= r130) goto L168;
        View r133 = r129[r131];
        if (r133.getVisibility() == 8) goto L166;
        LayoutParams r134 = (LayoutParams) r133.getLayoutParams();
        r134.resolveLayoutDirection(r128);
        int[] r135 = r134.f177901a;
        r134.f177903c = Integer.MIN_VALUE;
        r134.f177905e = Integer.MIN_VALUE;
        LayoutParams r136 = c(r135, r110);
        if (r136 == null) goto L76;
        if (this.f177900n == true) goto L73;
        int r137 = ((ViewGroup.MarginLayoutParams) r136).leftMargin;
    L74:
        r134.f177905e = r136.f177903c - (r137 + ((ViewGroup.MarginLayoutParams) r134).rightMargin);
    L81:
        LayoutParams r138 = c(r135, r123);
        if (r138 == null) goto L89;
        if (this.f177900n == true) goto L86;
        int r139 = ((ViewGroup.MarginLayoutParams) r138).rightMargin;
    L87:
        r134.f177903c = r138.f177905e + (r139 + ((ViewGroup.MarginLayoutParams) r134).leftMargin);
    L93:
        LayoutParams r140 = c(r135, 5);
        if (r140 == null) goto L97;
        r134.f177903c = r140.f177903c + ((ViewGroup.MarginLayoutParams) r134).leftMargin;
    L101:
        LayoutParams r141 = c(r135, 7);
        if (r141 == null) goto L105;
        r134.f177905e = r141.f177905e - ((ViewGroup.MarginLayoutParams) r134).rightMargin;
    L111:
        if (r135[9] == 0) goto L114;
        r134.f177903c = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r134).leftMargin;
    L114:
        if (r135[11] == 0) goto L117;
        if (r117 < 0) goto L117;
        r134.f177905e = (r117 - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r134).rightMargin;
    L117:
        boolean r142 = this.f177898l;
        if ((r133 instanceof BadgeView) == false) goto L120;
        boolean r143 = true;
    L121:
        int r144 = r131;
        int r213 = r130;
        View[] r214 = r129;
        int r310 = r128;
        View r311 = r127;
        int r145 = a(r134.f177903c, r134.f177905e, ((ViewGroup.MarginLayoutParams) r134).width, ((ViewGroup.MarginLayoutParams) r134).leftMargin, ((ViewGroup.MarginLayoutParams) r134).rightMargin, getPaddingLeft(), getPaddingRight(), r117, r143);
        if (r118 >= 0) goto L131;
        if (this.f177896j == true) goto L131;
        int r146 = ((ViewGroup.MarginLayoutParams) r134).height;
        if (r146 < 0) goto L128;
        int r147 = View.MeasureSpec.makeMeasureSpec(r146, 1073741824);
    L139:
        r34.measure(r145, r147);
        r134.resolveLayoutDirection(getLayoutDirection());
        int[] r148 = r134.f177901a;
        int r149 = r134.f177903c;
        if (r149 != Integer.MIN_VALUE) goto L144;
        int r150 = r134.f177905e;
        if (r150 == Integer.MIN_VALUE) goto L144;
        r134.f177903c = r150 - r133.getMeasuredWidth();
    L161:
        if (r148[21] == 0) goto L163;
    L162:
        boolean r151 = true;
    L164:
        if (r151 == false) goto L167;
        r212 = true;
    L167:
        r131 = r144 + 1;
        r130 = r213;
        r129 = r214;
        r128 = r310;
        r127 = r311;
        r123 = 1;
        r110 = 0;
        goto L64
    L163:
        r151 = false;
    L144:
        if (r149 != Integer.MIN_VALUE) goto L146;
    L148:
        if (r149 != Integer.MIN_VALUE) goto L161;
        if (r134.f177905e != Integer.MIN_VALUE) goto L161;
        if (r148[13] == 0) goto L154;
    L157:
        if (r210 == true) goto L159;
        int r152 = r34.getMeasuredWidth();
        int r153 = (r117 - r152) / 2;
        r134.f177903c = r153;
        r134.f177905e = r153 + r152;
        goto L162
    L159:
        int r154 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r134).leftMargin;
        r134.f177903c = r154;
        r134.f177905e = r154 + r34.getMeasuredWidth();
        goto L162
    L154:
        if (r148[14] != 0) goto L157;
        int r155 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r134).leftMargin;
        r134.f177903c = r155;
        r134.f177905e = r155 + r34.getMeasuredWidth();
        goto L161
    L146:
        if (r134.f177905e != Integer.MIN_VALUE) goto L148;
        r134.f177905e = r149 + r34.getMeasuredWidth();
        goto L161
    L128:
        r147 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L131:
        if (this.f177897k == false) goto L133;
        int r156 = Math.max(0, (((r118 - getPaddingTop()) - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r134).topMargin) - ((ViewGroup.MarginLayoutParams) r134).bottomMargin);
    L135:
        if (((ViewGroup.MarginLayoutParams) r134).height != (-1)) goto L137;
        int r157 = 1073741824;
    L138:
        r147 = View.MeasureSpec.makeMeasureSpec(r156, r157);
        goto L139
    L137:
        r157 = Integer.MIN_VALUE;
        goto L138
    L133:
        r156 = Math.max(0, r118);
        goto L135
    L120:
        r143 = r142;
        goto L121
    L105:
        if (r134.f177910j == false) goto L111;
        if (r135[7] == 0) goto L111;
        if (r117 < 0) goto L111;
        r134.f177905e = (r117 - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r134).rightMargin;
        goto L111
    L97:
        if (r134.f177910j == false) goto L101;
        if (r135[5] == 0) goto L101;
        r134.f177903c = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r134).leftMargin;
        goto L101
    L86:
        r139 = 0;
        goto L87
    L89:
        if (r134.f177910j == false) goto L93;
        if (r135[r123] == 0) goto L93;
        r134.f177903c = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r134).leftMargin;
        goto L93
    L73:
        r137 = 0;
        goto L74
    L76:
        if (r134.f177910j == false) goto L81;
        if (r135[r110] == 0) goto L81;
        if (r117 < 0) goto L81;
        r134.f177905e = (r117 - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r134).rightMargin;
        goto L81
    L166:
        r144 = r131;
        r213 = r130;
        r214 = r129;
        r310 = r128;
        r311 = r127;
        goto L167
    L168:
        int r312 = r128;
        View r313 = r127;
        View[] r158 = this.f177894h;
        int r159 = r158.length;
        int r160 = getContext().getApplicationInfo().targetSdkVersion;
        int r161 = r119;
        int r314 = r120;
        int r162 = 0;
        int r163 = Integer.MIN_VALUE;
        int r164 = Integer.MIN_VALUE;
        int r165 = Integer.MAX_VALUE;
        int r166 = Integer.MAX_VALUE;
        boolean r167 = false;
    L170:
        if (r162 >= r159) goto L283;
        View r168 = r158[r162];
        if (r168.getVisibility() == r132) goto L281;
        LayoutParams r169 = (LayoutParams) r168.getLayoutParams();
        int r170 = r168.getBaseline();
        int[] r171 = r169.f177901a;
        int r215 = r161;
        View r172 = b(r171, 4);
        if (r172 == null) goto L180;
        int r315 = r162;
        int r173 = r172.getBaseline();
        int r316 = r163;
        if (r173 != (-1)) goto L178;
    L181:
        int r174 = -1;
        int r175 = -1;
    L182:
        if (r175 == r174) goto L186;
        if (r170 == r174) goto L185;
        r175 = r175 - r170;
    L185:
        r169.f177904d = r175;
        r169.f177906f = Integer.MIN_VALUE;
    L227:
        boolean r176 = this.f177898l;
        if ((r168 instanceof BadgeView) == false) goto L230;
        boolean r216 = true;
    L231:
        int r317 = r164;
        int r318 = r165;
        View[] r412 = r158;
        int r217 = r315;
        int r177 = r316;
        int r218 = r159;
        int r178 = r166;
        int r413 = r117;
        r168.measure(a(r169.f177903c, r169.f177905e, ((ViewGroup.MarginLayoutParams) r169).width, ((ViewGroup.MarginLayoutParams) r169).leftMargin, ((ViewGroup.MarginLayoutParams) r169).rightMargin, getPaddingLeft(), getPaddingRight(), r117, r216), a(r169.f177904d, r169.f177906f, ((ViewGroup.MarginLayoutParams) r169).height, ((ViewGroup.MarginLayoutParams) r169).topMargin, ((ViewGroup.MarginLayoutParams) r169).bottomMargin, getPaddingTop(), getPaddingBottom(), r118, this.f177899m));
        int[] r179 = r169.f177901a;
        int r180 = r169.f177904d;
        if (r180 != Integer.MIN_VALUE) goto L236;
        int r181 = r169.f177906f;
        if (r181 == Integer.MIN_VALUE) goto L236;
        r169.f177904d = r181 - r168.getMeasuredHeight();
    L253:
        if (r179[12] == 0) goto L255;
    L254:
        boolean r182 = true;
    L256:
        if (r182 == false) goto L258;
        boolean r183 = true;
    L260:
        if (r210 == false) goto L264;
        if (r160 >= 19) goto L263;
        int r184 = Math.max(r215, r169.f177905e);
    L265:
        if (r211 == false) goto L270;
        if (r160 >= 19) goto L268;
        r314 = Math.max(r314, r169.f177906f);
        goto L270
    L268:
        r314 = Math.max(r314, r169.f177906f + ((ViewGroup.MarginLayoutParams) r169).bottomMargin);
    L270:
        View r185 = r313;
        if (r168 != r185) goto L275;
        if (r126 == true) goto L275;
        int r186 = r178;
        r165 = r318;
    L276:
        if (r168 != r185) goto L280;
        if (r124 == true) goto L280;
        int r187 = r186;
        r161 = r184;
        r167 = r183;
        r164 = r317;
        r163 = r177;
    L282:
        r162 = r217 + 1;
        r313 = r185;
        r166 = r187;
        r159 = r218;
        r158 = r412;
        r117 = r413;
        r132 = 8;
    L280:
        r163 = Math.max(r177, r169.f177905e + ((ViewGroup.MarginLayoutParams) r169).rightMargin);
        r164 = Math.max(r317, r169.f177906f + ((ViewGroup.MarginLayoutParams) r169).bottomMargin);
        r187 = r186;
        r161 = r184;
        r167 = r183;
    L275:
        r186 = Math.min(r178, r169.f177903c - ((ViewGroup.MarginLayoutParams) r169).leftMargin);
        r165 = Math.min(r318, r169.f177904d - ((ViewGroup.MarginLayoutParams) r169).topMargin);
        goto L276
    L263:
        r184 = Math.max(r215, r169.f177905e + ((ViewGroup.MarginLayoutParams) r169).rightMargin);
        goto L265
    L264:
        r184 = r215;
        goto L265
    L258:
        r183 = r167;
        goto L260
    L255:
        r182 = false;
    L236:
        if (r180 != Integer.MIN_VALUE) goto L238;
    L240:
        if (r180 != Integer.MIN_VALUE) goto L253;
        if (r169.f177906f != Integer.MIN_VALUE) goto L253;
        if (r179[13] == 0) goto L246;
    L249:
        if (r211 == true) goto L251;
        int r188 = r168.getMeasuredHeight();
        int r189 = (r118 - r188) / 2;
        r169.f177904d = r189;
        r169.f177906f = r189 + r188;
        goto L254
    L251:
        int r190 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r169).topMargin;
        r169.f177904d = r190;
        r169.f177906f = r190 + r168.getMeasuredHeight();
        goto L254
    L246:
        if (r179[15] != 0) goto L249;
        int r191 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r169).topMargin;
        r169.f177904d = r191;
        r169.f177906f = r191 + r168.getMeasuredHeight();
        goto L253
    L238:
        if (r169.f177906f != Integer.MIN_VALUE) goto L240;
        r169.f177906f = r180 + r168.getMeasuredHeight();
        goto L253
    L230:
        r216 = r176;
        goto L231
    L186:
        r169.f177904d = Integer.MIN_VALUE;
        r169.f177906f = Integer.MIN_VALUE;
        LayoutParams r192 = c(r171, 2);
        if (r192 == null) goto L190;
        r169.f177906f = r192.f177904d - (((ViewGroup.MarginLayoutParams) r192).topMargin + ((ViewGroup.MarginLayoutParams) r169).bottomMargin);
    L195:
        LayoutParams r193 = c(r171, 3);
        if (r193 == null) goto L199;
        r169.f177904d = r193.f177906f + (((ViewGroup.MarginLayoutParams) r193).bottomMargin + ((ViewGroup.MarginLayoutParams) r169).topMargin);
    L203:
        LayoutParams r194 = c(r171, 6);
        if (r194 == null) goto L207;
        r169.f177904d = r194.f177904d + ((ViewGroup.MarginLayoutParams) r169).topMargin;
    L211:
        LayoutParams r195 = c(r171, 8);
        if (r195 == null) goto L215;
        r169.f177906f = r195.f177906f - ((ViewGroup.MarginLayoutParams) r169).bottomMargin;
    L221:
        if (r171[10] == 0) goto L224;
        r169.f177904d = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r169).topMargin;
    L224:
        if (r171[12] == 0) goto L227;
        if (r118 < 0) goto L227;
        r169.f177906f = (r118 - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r169).bottomMargin;
        goto L227
    L215:
        if (r169.f177910j == false) goto L221;
        if (r171[8] == 0) goto L221;
        if (r118 < 0) goto L221;
        r169.f177906f = (r118 - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r169).bottomMargin;
        goto L221
    L207:
        if (r169.f177910j == false) goto L211;
        if (r171[6] == 0) goto L211;
        r169.f177904d = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r169).topMargin;
        goto L211
    L199:
        if (r169.f177910j == false) goto L203;
        if (r171[3] == 0) goto L203;
        r169.f177904d = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r169).topMargin;
        goto L203
    L190:
        if (r169.f177910j == false) goto L195;
        if (r171[2] == 0) goto L195;
        if (r118 < 0) goto L195;
        r169.f177906f = (r118 - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r169).bottomMargin;
        goto L195
    L178:
        if ((r172.getLayoutParams() instanceof LayoutParams) == false) goto L181;
        r175 = r173 + ((LayoutParams) r172.getLayoutParams()).f177904d;
        r174 = -1;
        goto L182
    L180:
        r315 = r162;
        r316 = r163;
        goto L181
    L281:
        r217 = r162;
        r187 = r166;
        r412 = r158;
        r218 = r159;
        r413 = r117;
        r185 = r313;
        r164 = r164;
        r163 = r163;
        goto L282
    L283:
        int r196 = r165;
        int r197 = r166;
        View[] r414 = r158;
        int r219 = r159;
        View r198 = r313;
        int r199 = r163;
        int r1100 = r164;
        int r200 = r314;
        int r201 = r161;
        View r202 = null;
        int r203 = 0;
        LayoutParams r204 = null;
    L284:
        if (r203 >= r219) goto L297;
        View r205 = r414[r203];
        if (r205.getVisibility() == 8) goto L296;
        LayoutParams r1101 = (LayoutParams) r205.getLayoutParams();
        if (r202 == null) goto L295;
        if (r204 == null) goto L295;
        int r1102 = r1101.f177904d - r204.f177904d;
        if (r1102 != 0) goto L294;
        r1102 = r1101.f177903c - r204.f177903c;
    L294:
        if (r1102 >= 0) goto L296;
    L295:
        r202 = r205;
        r204 = r1101;
    L296:
        r203 = r203 + 1;
        goto L284
    L297:
        this.f177887a = r202;
        if (r210 == false) goto L322;
        int r206 = getPaddingRight() + r201;
        if (getLayoutParams() != null) goto L302;
    L304:
        int r207 = ViewGroup.resolveSize(Math.max(r206, getSuggestedMinimumWidth()), r410);
        if (r212 == false) goto L321;
        int r208 = 0;
    L307:
        if (r208 >= r219) goto L321;
        View r209 = r414[r208];
        if (r209.getVisibility() == 8) goto L319;
        LayoutParams r220 = (LayoutParams) r209.getLayoutParams();
        int r221 = r312;
        r220.resolveLayoutDirection(r221);
        int[] r1103 = r220.f177901a;
        if (r1103[13] == 0) goto L313;
    L318:
        int r222 = r209.getMeasuredWidth();
        int r1104 = (r207 - r222) / 2;
        r220.f177903c = r1104;
        r220.f177905e = r1104 + r222;
    L320:
        r208 = r208 + 1;
        r312 = r221;
        goto L307
    L313:
        if (r1103[14] != 0) goto L318;
        if (r1103[11] == 0) goto L320;
        int r223 = r209.getMeasuredWidth();
        int r1105 = (r207 - getPaddingRight()) - r223;
        r220.f177903c = r1105;
        r220.f177905e = r1105 + r223;
        goto L320
    L319:
        r221 = r312;
    L321:
        int r224 = r312;
        int r1106 = r207;
    L323:
        if (r211 == false) goto L346;
        int r225 = getPaddingBottom() + r200;
        if (getLayoutParams() != null) goto L327;
    L329:
        int r319 = ViewGroup.resolveSize(Math.max(r225, getSuggestedMinimumHeight()), r411);
        if (r167 == false) goto L345;
        int r226 = 0;
    L332:
        if (r226 >= r219) goto L345;
        View r227 = r414[r226];
        if (r227.getVisibility() == 8) goto L344;
        LayoutParams r228 = (LayoutParams) r227.getLayoutParams();
        r228.resolveLayoutDirection(r224);
        int[] r229 = r228.f177901a;
        if (r229[13] == 0) goto L338;
    L343:
        int r230 = r227.getMeasuredHeight();
        int r231 = (r319 - r230) / 2;
        r228.f177904d = r231;
        r228.f177906f = r231 + r230;
        goto L344
    L338:
        if (r229[15] != 0) goto L343;
        if (r229[12] == 0) goto L344;
        int r232 = r227.getMeasuredHeight();
        int r233 = (r319 - getPaddingBottom()) - r232;
        r228.f177904d = r233;
        r228.f177906f = r233 + r232;
    L344:
        r226 = r226 + 1;
    L345:
        int r1107 = r319;
    L347:
        if (r124 == true) goto L349;
        if (r126 == true) goto L349;
    L363:
        setMeasuredDimension(r1106, r1107);
        return;
    L349:
        Rect r234 = this.f177890d;
        r234.set(getPaddingLeft(), getPaddingTop(), r1106 - getPaddingRight(), r1107 - getPaddingBottom());
        Rect r1108 = this.f177889c;
        Gravity.apply(this.f177888b, r199 - r197, r1100 - r196, r234, r1108, r224);
        int r235 = r1108.left - r197;
        int r236 = r1108.top - r196;
        if (r235 != 0) goto L352;
        if (r236 == 0) goto L363;
    L352:
        int r237 = 0;
    L353:
        if (r237 >= r219) goto L363;
        View r238 = r414[r237];
        if (r238.getVisibility() == 8) goto L362;
        if (r238 == r198) goto L362;
        LayoutParams r239 = (LayoutParams) r238.getLayoutParams();
        if (r124 == false) goto L360;
        r239.f177903c += r235;
        r239.f177905e += r235;
    L360:
        if (r126 == false) goto L362;
        r239.f177904d += r236;
        r239.f177906f += r236;
    L362:
        r237 = r237 + 1;
        goto L353
    L327:
        if (getLayoutParams().height < 0) goto L329;
        r225 = Math.max(r225, getLayoutParams().height);
        goto L329
    L346:
        r1107 = r200;
        goto L347
    L302:
        if (getLayoutParams().width < 0) goto L304;
        r206 = Math.max(r206, getLayoutParams().width);
        goto L304
    L322:
        r224 = r312;
        r1106 = r201;
        goto L323
    L62:
        r211 = false;
        goto L63
    L59:
        r210 = false;
    L53:
        int r240 = this.f177891e;
        if (r240 == (-1)) goto L56;
        r127 = findViewById(r240);
    L50:
        r126 = false;
    L45:
        r124 = false;
        goto L46
    L40:
        r120 = 0;
        goto L41
    L37:
        r119 = 0;
        goto L38
    L33:
        r118 = -1;
        goto L35
    L30:
        r117 = -1;
        goto L31
    }

    public BadgeCompatRelativeLayout(Context r110, AttributeSet r111, int r112) {
        boolean r100 = false;
        super(r110, r111, r112, 0);
        this.f177887a = null;
        this.f177888b = 8388659;
        this.f177889c = new Rect();
        this.f177890d = new Rect();
        this.f177895i = new a();
        this.f177896j = false;
        this.f177897k = false;
        this.f177898l = false;
        this.f177899m = false;
        this.f177900n = false;
        TypedArray r101 = r110.obtainStyledAttributes(r111, new int[]{R.attr.gravity2, R.attr.ignoreGravity}, r112, 0);
        if (Build.VERSION.SDK_INT < 29) goto L5;
        saveAttributeDataForStyleable(r110, new int[]{R.attr.gravity2, R.attr.ignoreGravity}, r111, r101, r112, 0);
    L5:
        this.f177891e = r101.getResourceId(1, -1);
        this.f177888b = r101.getInt(0, this.f177888b);
        r101.recycle();
        int r113 = r110.getApplicationInfo().targetSdkVersion;
        if (r113 > 17) goto L8;
        boolean r114 = true;
    L9:
        this.f177896j = r114;
        if (r113 < 18) goto L12;
        r100 = true;
    L12:
        this.f177897k = r100;
        return;
    L8:
        r114 = false;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L8;
        View r107 = getChildAt(r106);
        if (r107.getVisibility() == 8) goto L7;
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        r107.layout(r108.f177903c, r108.f177904d, r108.f177905e, r108.f177906f);
    L7:
        r106 = r106 + 1;
        goto L3
    }

    public final int a(int r100, int r101, int r102, int r103, int r110, int r111, int r112, int r113, boolean r114) {
        int r104 = 0;
        if (r113 >= 0) goto L5;
        boolean r105 = true;
    L6:
        int r106 = 1073741824;
        if (r105 == true) goto L9;
    L18:
        if (r100 != Integer.MIN_VALUE) goto L20;
        int r115 = r111 + r103;
    L21:
        if (r101 != Integer.MIN_VALUE) goto L23;
        int r116 = (r113 - r112) - r110;
    L24:
        int r117 = r116 - r115;
        if (r100 == Integer.MIN_VALUE) goto L31;
        if (r101 == Integer.MIN_VALUE) goto L31;
        if (r105 == false) goto L29;
        r106 = 0;
    L29:
        r102 = Math.max(0, r117);
    L30:
        r104 = r106;
    L50:
        return View.MeasureSpec.makeMeasureSpec(r102, r104);
    L31:
        if (r102 < 0) goto L38;
        if (r117 < 0) goto L36;
        if (r114 == false) goto L35;
        r102 = Math.max(r117, r102);
        goto L36
    L35:
        r102 = Math.min(r117, r102);
    L36:
        r104 = 1073741824;
        goto L50
    L38:
        if (r102 != (-1)) goto L43;
        if (r105 == false) goto L41;
        r106 = 0;
    L41:
        r102 = Math.max(0, r117);
        goto L30
    L43:
        if (r102 != (-2)) goto L48;
        if (r117 < 0) goto L48;
        if (r114 == true) goto L48;
        r102 = r117;
        r104 = Integer.MIN_VALUE;
    L48:
        r102 = 0;
        goto L50
    L23:
        r116 = r101;
        goto L24
    L20:
        r115 = r100;
        goto L21
    L9:
        if (this.f177896j == true) goto L18;
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
