package com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/ui/LinkRoomFightItemDecoration;", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class LinkRoomFightItemDecoration extends BaseEqualGridItemDecoration {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78547c;

    public LinkRoomFightItemDecoration(int r100, Drawable r101) {
        super(r101);
        this.f78546b = 1;
        this.f78547c = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "state");
        Drawable r112 = this.f79761a;
        if (r112 == null) goto L97;
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r110, "parent");
        int r101 = r110.getChildCount();
        int r102 = this.f78547c;
        int r103 = 0;
        if (r102 != 51) goto L31;
    L6:
        if (r103 >= r101) goto L122;
        if ((r103 % 2) != 0) goto L19;
        View r104 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L17;
        RecyclerView.LayoutParams r106 = (RecyclerView.LayoutParams) r105;
        int r107 = r104.getTop() - ((ViewGroup.MarginLayoutParams) r106).topMargin;
        int r108 = r104.getBottom() + ((ViewGroup.MarginLayoutParams) r106).bottomMargin;
        int r109 = r104.getRight() + ((ViewGroup.MarginLayoutParams) r106).rightMargin;
        int r113 = this.f78546b;
        int r114 = r109 - r113;
        int r115 = r113 + r114;
        if (r112 == null) goto L14;
        r112.setBounds(r114, r107, r115, r108);
    L14:
        if (r112 == null) goto L19;
        r112.draw(r100);
        goto L19
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L19:
        if (((r103 - 1) % 2) != 0) goto L29;
        View r116 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L28;
        RecyclerView.LayoutParams r118 = (RecyclerView.LayoutParams) r117;
        int r119 = r116.getTop() - ((ViewGroup.MarginLayoutParams) r118).topMargin;
        int r120 = r116.getBottom() + ((ViewGroup.MarginLayoutParams) r118).bottomMargin;
        int r121 = r116.getLeft() - ((ViewGroup.MarginLayoutParams) r118).leftMargin;
        int r122 = this.f78546b + r121;
        if (r112 == null) goto L25;
        r112.setBounds(r121, r119, r122, r120);
    L25:
        if (r112 == null) goto L29;
        r112.draw(r100);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L29:
        r103 = r103 + 1;
        goto L6
    L122:
        return;
    L31:
        if (r102 != 58) goto L46;
    L32:
        if (r103 >= r101) goto L123;
        if ((r103 % 2) != 0) goto L44;
        View r123 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L43;
        RecyclerView.LayoutParams r125 = (RecyclerView.LayoutParams) r124;
        int r126 = r123.getTop() - ((ViewGroup.MarginLayoutParams) r125).topMargin;
        int r127 = r123.getBottom() + ((ViewGroup.MarginLayoutParams) r125).bottomMargin;
        int r128 = r123.getRight() + ((ViewGroup.MarginLayoutParams) r125).rightMargin;
        int r129 = this.f78546b;
        int r130 = r128 - r129;
        int r131 = r129 + r130;
        if (r112 == null) goto L40;
        r112.setBounds(r130, r126, r131, r127);
    L40:
        if (r112 == null) goto L44;
        r112.draw(r100);
        goto L44
    L43:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L44:
        r103 = r103 + 1;
        goto L32
    L123:
        return;
    L46:
        if (r102 != 56) goto L72;
    L47:
        if (r103 >= r101) goto L124;
        if ((r103 % 2) != 0) goto L60;
        View r132 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (r133 == null) goto L58;
        RecyclerView.LayoutParams r134 = (RecyclerView.LayoutParams) r133;
        int r135 = r132.getTop() - ((ViewGroup.MarginLayoutParams) r134).topMargin;
        int r136 = r132.getBottom() + ((ViewGroup.MarginLayoutParams) r134).bottomMargin;
        int r137 = r132.getRight() + ((ViewGroup.MarginLayoutParams) r134).rightMargin;
        int r138 = this.f78546b;
        int r139 = r137 - r138;
        int r140 = r138 + r139;
        if (r112 == null) goto L55;
        r112.setBounds(r139, r135, r140, r136);
    L55:
        if (r112 == null) goto L60;
        r112.draw(r100);
        goto L60
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L60:
        if ((r103 % 3) != 0) goto L70;
        View r141 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        if (r142 == null) goto L69;
        RecyclerView.LayoutParams r143 = (RecyclerView.LayoutParams) r142;
        int r144 = r141.getTop() - ((ViewGroup.MarginLayoutParams) r143).topMargin;
        int r145 = r141.getBottom() + ((ViewGroup.MarginLayoutParams) r143).bottomMargin;
        int r146 = r141.getLeft() - ((ViewGroup.MarginLayoutParams) r143).leftMargin;
        int r147 = this.f78546b + r146;
        if (r112 == null) goto L66;
        r112.setBounds(r146, r144, r147, r145);
    L66:
        if (r112 == null) goto L70;
        r112.draw(r100);
        goto L70
    L69:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L70:
        r103 = r103 + 1;
        goto L47
    L124:
        return;
    L72:
        if (r102 != 57) goto L121;
    L73:
        if (r103 >= r101) goto L125;
        if ((r103 % 2) != 0) goto L86;
        View r148 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r149 = r148.getLayoutParams();
        if (r149 == null) goto L84;
        RecyclerView.LayoutParams r150 = (RecyclerView.LayoutParams) r149;
        int r151 = r148.getTop() - ((ViewGroup.MarginLayoutParams) r150).topMargin;
        int r152 = r148.getBottom() + ((ViewGroup.MarginLayoutParams) r150).bottomMargin;
        int r153 = r148.getRight() + ((ViewGroup.MarginLayoutParams) r150).rightMargin;
        int r154 = this.f78546b;
        int r155 = r153 - r154;
        int r156 = r154 + r155;
        if (r112 == null) goto L81;
        r112.setBounds(r155, r151, r156, r152);
    L81:
        if (r112 == null) goto L86;
        r112.draw(r100);
        goto L86
    L84:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L86:
        if (((r103 - 1) % 4) != 0) goto L96;
        View r157 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r158 = r157.getLayoutParams();
        if (r158 == null) goto L95;
        RecyclerView.LayoutParams r159 = (RecyclerView.LayoutParams) r158;
        int r160 = r157.getTop() - ((ViewGroup.MarginLayoutParams) r159).topMargin;
        int r161 = r157.getBottom() + ((ViewGroup.MarginLayoutParams) r159).bottomMargin;
        int r162 = r157.getLeft() - ((ViewGroup.MarginLayoutParams) r159).leftMargin;
        int r163 = this.f78546b + r162;
        if (r112 == null) goto L92;
        r112.setBounds(r162, r160, r163, r161);
    L92:
        if (r112 == null) goto L96;
        r112.draw(r100);
        goto L96
    L95:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L96:
        r103 = r103 + 1;
        goto L73
    L125:
        return;
    L121:
        return;
    }
}
