package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import c63.d;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.header.AnchorV4VideoImageIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.b;
import com.bytedance.android.shopping.anchorv4.voavhs.head.c;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import f83.e;
import f83.f;
import f83.g;
import f83.h;
import f83.i;
import f83.l;
import f83.n;
import f83.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wg.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4HeadIndicator;", "Landroid/widget/FrameLayout;", "Lf83/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameElement", "Lf83/p;", ce.f26395j, "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "Lc63/d;", ce.f26396k, "Lc63/d;", "getLogAction", "()Lc63/d;", "logAction", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadIndicator extends FrameLayout implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f168756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorV4FindSameIndicator f168757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f168758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f168759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f168760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AnchorV4TabIndicator f168761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AnchorV4FoldableTabIndicator f168762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f168763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f168764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p f168765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f168766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CommonFindSameElement f168767l;

    public AnchorV4HeadIndicator(Context r110) {
        this(r110, null, 0, null, null, null, false, 126);
    }

    public AnchorV4HeadIndicator(Context r110, AttributeSet r111) {
        this(r110, r111, 0, null, null, null, false, 124);
    }

    public AnchorV4HeadIndicator(Context r110, AttributeSet r111, int r112) {
        this(r110, r111, r112, null, null, null, false, 120);
    }

    @Override // f83.l
    public CommonFindSameElement getFindSameElement() {
        return this.f168767l;
    }

    public final d getLogAction() {
        return this.f168766k;
    }

    public final p getTabLogicInterceptor() {
        return this.f168765j;
    }

    @Override // f83.l
    public final void a(boolean r100) {
        AnchorV4FindSameIndicator r101 = this.f168757b;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // f83.l
    public final void h(boolean r100) {
        if (this.f168758c == true) goto L12;
        AnchorV4TabIndicator r101 = this.f168761f;
        if (r100 == true) goto L7;
    L9:
        int r102 = 8;
    L10:
        r101.setVisibility(r102);
        goto L12
    L7:
        if (this.f168756a == false) goto L9;
        r102 = 0;
    L12:
        if (this.f168759d == false) goto L15;
        a.h(this.f168762g, r100);
        return;
    }

    @Override // f83.l
    public final void c(List<String> r210, List<b> r211, List<String> r212) {
        Intrinsics.checkNotNullParameter(r210, "titleTags");
        Intrinsics.checkNotNullParameter(r211, "originTags");
        Intrinsics.checkNotNullParameter(r212, "tabTypes");
        if (this.f168758c == true) goto L10;
        this.f168761f.b(CollectionsKt.filterNotNull(r210), CollectionsKt.filterNotNull(r212));
        AnchorV4TabIndicator r100 = this.f168761f;
        if (((ArrayList) r210).size() <= 1) goto L7;
        int r110 = 0;
    L8:
        r100.setVisibility(r110);
        goto L10
    L7:
        r110 = 8;
    L10:
        if (this.f168759d == false) goto L69;
        AnchorV4FoldableTabIndicator r101 = this.f168762g;
        List r111 = CollectionsKt.filterNotNull(r210);
        List r102 = CollectionsKt.filterNotNull(r212);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, "indicatorTags");
        Intrinsics.checkNotNullParameter(r211, "originTags");
        Intrinsics.checkNotNullParameter(r102, "tabTypes");
        r101.f168734a.removeAllViews();
        r101.f168735b.removeAllViews();
        ((ArrayList) r101.f168738e).clear();
        ((ArrayList) r101.f168742i).clear();
        List<b> r103 = r211;
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L18;
        b r105 = (b) r104.next();
        Iterator<T> r112 = r105.f168486c.iterator();
    L16:
        if (r112.hasNext() == false) goto L13;
        c r113 = (c) r112.next();
        List<String> r114 = r101.f168742i;
        ArrayList r115 = (ArrayList) r114;
        r115.add(r105.f168484a);
        goto L16
    L18:
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r103.iterator();
    L20:
        if (r107.hasNext() == false) goto L27;
        Object r108 = r107.next();
        if (((b) r108).f168484a == null) goto L24;
        boolean r116 = true;
    L25:
        if (r116 == false) goto L20;
        r106.add(r108);
        goto L20
    L24:
        r116 = false;
        goto L25
    L27:
        Iterator r109 = r111.iterator();
        int r117 = 0;
    L29:
        if (r109.hasNext() == false) goto L69;
        Object r118 = r109.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        String r120 = (String) r118;
        b r121 = (b) CollectionsKt.getOrNull(r106, r117);
        if (r121 != null) goto L36;
    L41:
        String r122 = null;
    L42:
        int r123 = AnchorV4FoldableTabIndicator.f168733p;
        if (r117 != 0) goto L49;
        Context r124 = r101.getContext();
        StringBuilder r125 = new StringBuilder();
        r125.append(r120);
        p r126 = r101.f168746m;
        if (r126 == null) goto L47;
        Integer r127 = Integer.valueOf(r126.d());
    L48:
        r125.append(j.e(R.string.shopping_tip_indicator_num, 1, Integer.valueOf(k.f(r127))));
        TextView r128 = AnchorV4FoldableTabIndicator.a.a(r124, r125.toString());
        r101.f168740g = r128;
        r101.f168735b.addView(r128, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        n r129 = new n(r101.f168740g, r120, r122);
        String r130 = r120;
        r101.f168740g.setOnClickListener(new f83.d(r129, r117, r101, r106, r111, r102));
        ((ArrayList) r101.f168738e).add(r129);
    L50:
        if (r117 != 0) goto L65;
        r101.f168741h = r130;
        if (r111.size() <= 1) goto L54;
        String r131 = r130;
    L56:
        if (r111.size() != 1) goto L58;
        boolean r132 = true;
    L59:
        r101.f168743j = r132;
        Context r133 = r101.getContext();
        StringBuilder r134 = new StringBuilder();
        r134.append(r131);
        p r135 = r101.f168746m;
        if (r135 == null) goto L62;
        Integer r136 = Integer.valueOf(r135.d());
    L63:
        r134.append(j.e(R.string.shopping_tip_indicator_num, 1, Integer.valueOf(k.f(r136))));
        TextView r137 = AnchorV4FoldableTabIndicator.a.a(r133, r134.toString());
        r137.setBackgroundDrawable(ag4.a.c(R.drawable.anchor_v4_head_foldable_indicator_anim_bg));
        Unit r138 = Unit.INSTANCE;
        r101.f168739f = r137;
        r101.f168734a.addView(r137, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        f r139 = new f(new n(r101.f168739f, r130, null), r117, r101, r106, r111, r102);
        r101.f168739f.setOnClickListener(r139);
    L67:
        r101.d(0, (String) CollectionsKt.getOrNull(r102, 0), true);
        r117 = r119;
        r109 = r109;
        r111 = r111;
        goto L29
    L62:
        r136 = null;
        goto L63
    L58:
        r132 = false;
        goto L59
    L54:
        r131 = "";
        goto L56
    L65:
        if (r117 != 1) goto L67;
        Context r140 = r101.getContext();
        Intrinsics.checkNotNullParameter(r140, PerfLog.PARAM_KEY_CONTEXT_ID);
        ImageView r141 = new ImageView(r140);
        r141.setImageResource(R.drawable.ec_commerce_tab_right_icon_new);
        int r142 = (int) UIUtils.dip2Px(r140, 4.0f);
        r141.setPadding(r142, r142, r142, r142);
        r141.post(new h(r141));
        r141.setOnClickListener(new g(new n(r141, r130, null), r101, r106, r111, r102));
        r101.f168734a.setContentDescription("展开");
        r101.f168734a.addView(r141, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        goto L67
    L47:
        r127 = null;
        goto L48
    L49:
        r130 = r120;
        TextView r143 = AnchorV4FoldableTabIndicator.a.a(r101.getContext(), r130);
        n r144 = new n(r143, r130, r122);
        r143.setOnClickListener(new e(r144, r117, r101, r106, r111, r102));
        r101.f168735b.addView(r143, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        ((ArrayList) r101.f168738e).add(r144);
        goto L50
    L36:
        if (Intrinsics.areEqual(r121.f168484a, r120) == true) goto L39;
        r121 = null;
    L39:
        if (r121 == null) goto L41;
        r122 = r121.f168488e;
    L69:
        if (((ArrayList) r210).size() <= 1) goto L71;
        boolean r145 = true;
    L72:
        this.f168756a = r145;
        return;
    L71:
        r145 = false;
        goto L72
    }

    @Override // f83.l
    public final void b(Integer r100, int r101, String r102, boolean r103) {
        if (r100 != null) goto L4;
    L9:
        TextView r104 = this.f168763h;
        Integer r105 = Integer.valueOf(r101 + 1);
        p r106 = this.f168765j;
        if (r106 == null) goto L12;
        Integer r107 = Integer.valueOf(r106.d());
    L13:
        r104.setText(j.e(R.string.shopping_tip_indicator_num, r105, Integer.valueOf(k.f(r107))));
        return;
    L12:
        r107 = null;
        goto L13
    L4:
        if (this.f168758c == true) goto L7;
        this.f168761f.a(r100.intValue(), r102, r103);
    L7:
        if (this.f168759d == false) goto L9;
        this.f168762g.b(r100, r101, r102, r103);
        goto L9
    }

    public AnchorV4HeadIndicator(Context r210, AttributeSet r211, int r212, p r213, d r214, CommonFindSameElement r215, boolean r216, int r217) {
        CommonFindSameElement r100 = null;
        if ((r217 & 2) == 0) goto L5;
        AttributeSet r101 = null;
    L7:
        if ((r217 & 4) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r217 & 8) == 0) goto L13;
        p r103 = null;
    L15:
        if ((r217 & 16) == 0) goto L17;
        d r104 = null;
    L19:
        if ((r217 & 32) != 0) goto L23;
        r100 = r215;
    L23:
        if ((r217 & 64) == 0) goto L25;
        boolean r105 = false;
    L26:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r101, r102);
        this.f168765j = r103;
        this.f168766k = r104;
        this.f168767l = r100;
        this.f168756a = true;
        boolean r110 = com.bytedance.android.shopping.anchorv4.experiment.d.a();
        this.f168758c = r110;
        boolean r111 = com.bytedance.android.shopping.anchorv4.experiment.d.a();
        this.f168759d = r111;
        AnchorV4TabIndicator r106 = new AnchorV4TabIndicator(r210, null, 0, new f83.j(this), 22);
        this.f168761f = r106;
        AnchorV4FoldableTabIndicator r107 = new AnchorV4FoldableTabIndicator(r210, null, 0, r103, r104, r105, new i(this), 6);
        this.f168762g = r107;
        AnchorV4VideoImageIndicator.f164821d.getClass();
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("", "textValue");
        TextView r108 = new TextView(r210);
        r108.setBackgroundResource(R.drawable.commerce_bg_indicator_container_v4);
        ColorStateList r109 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        int r112 = (int) UIUtils.dip2Px(r108.getContext(), 10.0f);
        int r113 = (int) UIUtils.dip2Px(r108.getContext(), 2.5f);
        r108.setTextSize(12.0f);
        r108.setTypeface(Typeface.DEFAULT_BOLD);
        r108.setTextColor(r109);
        r108.setPadding(r112, r113, r112, r113);
        r108.setText("");
        r108.setGravity(17);
        this.f168763h = r108;
        int r114 = 20;
        if (r111 == false) goto L30;
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20));
        r115.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        Unit r116 = Unit.INSTANCE;
        r115.rightMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r107, r115);
        return;
    L30:
        if (r110 == false) goto L32;
        r114 = 24;
    L32:
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r114)));
        r117.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        Unit r118 = Unit.INSTANCE;
        r117.rightMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r108, r117);
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(-2, -2);
        r119.gravity = 17;
        addView(r106, r119);
        return;
    L25:
        r105 = r216;
        goto L26
    L17:
        r104 = r214;
        goto L19
    L13:
        r103 = r213;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}
