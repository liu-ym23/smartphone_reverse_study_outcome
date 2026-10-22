package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.widget.HSImageView;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f69552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> f69553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f69554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f69555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> f69556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<Integer, HSImageView, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> f69557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> f69558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f69559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f69560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f69561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<FrameLayout, Unit> f69562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function3<TabLayout, FrameLayout, FrameLayout, Unit> f69563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Boolean> f69564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Boolean> f69565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Boolean> f69566o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Unit> f69567p;

    public u() {
        this(null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 65535);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L38;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f69552a, r101.f69552a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f69553b, r101.f69553b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f69554c, r101.f69554c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f69555d, r101.f69555d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f69556e, r101.f69556e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f69557f, r101.f69557f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f69558g, r101.f69558g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f69559h, r101.f69559h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f69560i, r101.f69560i) == true) goto L24;
        return false;
    L24:
        if (this.f69561j == r101.f69561j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f69562k, r101.f69562k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f69563l, r101.f69563l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f69564m, r101.f69564m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f69565n, r101.f69565n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f69566o, r101.f69566o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f69567p, r101.f69567p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v56 */
    public final int hashCode() {
        Function0<Unit> r100 = this.f69552a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r104 = this.f69553b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Unit> r107 = this.f69554c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<Unit> r110 = this.f69555d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r113 = this.f69556e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Function3<Integer, HSImageView, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r116 = this.f69557f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r119 = this.f69558g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f69559h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f69560i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        boolean r128 = this.f69561j;
        ?? r129 = r128;
        if (r128 == false) goto L41;
        r129 = 1;
    L41:
        int r130 = (r127 + r129) * 31;
        Function1<FrameLayout, Unit> r131 = this.f69562k;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        Function3<TabLayout, FrameLayout, FrameLayout, Unit> r134 = this.f69563l;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        Function0<Boolean> r137 = this.f69564m;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        Function0<Boolean> r140 = this.f69565n;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        Function0<Boolean> r143 = this.f69566o;
        if (r143 == null) goto L60;
        int r144 = r143.hashCode();
    L61:
        int r145 = (r142 + r144) * 31;
        Function0<Unit> r146 = this.f69567p;
        if (r146 == null) goto L65;
        r101 = r146.hashCode();
    L65:
        return r145 + r101;
    L60:
        r144 = 0;
        goto L61
    L56:
        r141 = 0;
        goto L57
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongOptionalConfig(postFillCustomTabAction=" + this.f69552a + ", setCartAnimAction=" + this.f69553b + ", selectDefaultFirstLevelTabAction=" + this.f69554c + ", syncOrderedSongListAction=" + this.f69555d + ", firstLevelTabPageSelectedAction=" + this.f69556e + ", showBusinessEntryIfNeedAction=" + this.f69557f + ", initBusinessEntryAction=" + this.f69558g + ", dialogLayoutId=" + this.f69559h + ", dialogHeight=" + this.f69560i + ", shouldInitTopControlBar=" + this.f69561j + ", initTopControlBarAction=" + this.f69562k + ", updateOrderSongDialogTopAreaAction=" + this.f69563l + ", needBackBtn=" + this.f69564m + ", needDividerLine=" + this.f69565n + ", needTabIndicator=" + this.f69566o + ", clickBackAction=" + this.f69567p + ")";
    }

    public u(Function0 r110, Function3 r111, Function0 r210, Function0 r211, Function3 r212, Function3 r213, Function5 r214, Integer r215, boolean r216, Function1 r217, Function3 r218, Function0 r219, Function0 r310, Function0 r311, Function0 r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        Function0 r100 = OrderSongOptionalConfig$1.INSTANCE;
    L7:
        if ((r313 & 2) == 0) goto L9;
        Function3 r101 = null;
    L11:
        if ((r313 & 4) == 0) goto L13;
        Function0 r102 = OrderSongOptionalConfig$2.INSTANCE;
    L15:
        if ((r313 & 8) == 0) goto L17;
        Function0 r103 = OrderSongOptionalConfig$3.INSTANCE;
    L19:
        if ((r313 & 16) == 0) goto L21;
        Function3 r104 = OrderSongOptionalConfig$4.INSTANCE;
    L23:
        if ((r313 & 32) == 0) goto L25;
        Function3 r105 = OrderSongOptionalConfig$5.INSTANCE;
    L27:
        if ((r313 & 64) == 0) goto L29;
        Function5 r106 = OrderSongOptionalConfig$6.INSTANCE;
    L31:
        if ((r313 & 256) == 0) goto L33;
        Integer r112 = null;
    L35:
        if ((r313 & 512) == 0) goto L37;
        boolean r113 = false;
    L39:
        if ((r313 & 1024) == 0) goto L41;
        Function1 r114 = null;
    L43:
        if ((r313 & 2048) == 0) goto L45;
        Function3 r115 = null;
    L47:
        if ((r313 & 4096) == 0) goto L49;
        Function0 r116 = OrderSongOptionalConfig$7.INSTANCE;
    L51:
        if ((r313 & 8192) == 0) goto L53;
        Function0 r117 = OrderSongOptionalConfig$8.INSTANCE;
    L55:
        if ((r313 & 16384) == 0) goto L57;
        Function0 r107 = OrderSongOptionalConfig$9.INSTANCE;
    L59:
        if ((r313 & 32768) == 0) goto L61;
        Function0 r108 = OrderSongOptionalConfig$10.INSTANCE;
    L62:
        Intrinsics.checkNotNullParameter(r100, "postFillCustomTabAction");
        Intrinsics.checkNotNullParameter(r102, "selectDefaultFirstLevelTabAction");
        Intrinsics.checkNotNullParameter(r103, "syncOrderedSongListAction");
        Intrinsics.checkNotNullParameter(r104, "firstLevelTabPageSelectedAction");
        Intrinsics.checkNotNullParameter(r105, "showBusinessEntryIfNeedAction");
        Intrinsics.checkNotNullParameter(r106, "initBusinessEntryAction");
        Intrinsics.checkNotNullParameter(r116, "needBackBtn");
        Intrinsics.checkNotNullParameter(r117, "needDividerLine");
        Intrinsics.checkNotNullParameter(r107, "needTabIndicator");
        Intrinsics.checkNotNullParameter(r108, "clickBackAction");
        this.f69552a = r100;
        this.f69553b = r101;
        this.f69554c = r102;
        this.f69555d = r103;
        this.f69556e = r104;
        this.f69557f = r105;
        this.f69558g = r106;
        this.f69559h = null;
        this.f69560i = r112;
        this.f69561j = r113;
        this.f69562k = r114;
        this.f69563l = r115;
        this.f69564m = r116;
        this.f69565n = r117;
        this.f69566o = r107;
        this.f69567p = r108;
        return;
    L61:
        r108 = r312;
        goto L62
    L57:
        r107 = r311;
        goto L59
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
