package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f148549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f148550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f148551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f148552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f148553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f148554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f148555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f148556h;

    public CategoryItemDecoration() {
        this(0, 0, null, null, null, null, null, null, 255);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        Integer r104 = this.f148555g;
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
    L6:
        r100.left = r105;
        Integer r106 = this.f148556h;
        int r107 = 0;
        if (r106 == null) goto L9;
        int r108 = r106.intValue();
    L10:
        r100.right = r108;
        Integer r109 = this.f148553e;
        if (r109 == null) goto L13;
        int r110 = r109.intValue();
    L14:
        r100.top = r110;
        Integer r111 = this.f148554f;
        if (r111 == null) goto L17;
        int r112 = r111.intValue();
    L18:
        r100.bottom = r112;
        RecyclerView.LayoutManager r113 = r102.getLayoutManager();
        if (r102.getChildAdapterPosition(r101) != 0) goto L30;
        Integer r114 = this.f148551c;
        if (r114 != null) goto L26;
        Integer r115 = this.f148555g;
        if (r115 == null) goto L25;
        r114 = Integer.valueOf(r115.intValue() * 2);
        goto L26
    L25:
        r114 = null;
    L26:
        if (r114 == null) goto L28;
        int r116 = r114.intValue();
    L29:
        r100.left = r116;
        goto L30
    L28:
        r116 = this.f148549a * 2;
    L30:
        int r117 = r102.getChildAdapterPosition(r101);
        if (r113 == null) goto L34;
        r107 = r113.getItemCount();
    L34:
        if (r117 != (r107 - 1)) goto L47;
        Integer r118 = this.f148555g;
        if (r118 == null) goto L38;
        int r119 = r118.intValue();
    L39:
        r100.left = r119;
        Integer r120 = this.f148552d;
        if (r120 != null) goto L42;
        r120 = this.f148556h;
    L42:
        if (r120 == null) goto L44;
        int r121 = r120.intValue();
    L45:
        r100.right = r121;
        return;
    L44:
        r121 = this.f148549a;
        goto L45
    L38:
        r119 = this.f148549a;
        goto L39
    L47:
        return;
    L17:
        r112 = this.f148550b;
        goto L18
    L13:
        r110 = this.f148550b;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = this.f148549a;
        goto L6
    }

    public CategoryItemDecoration(int r100, int r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L26;
        r110 = null;
    L26:
        this.f148549a = r100;
        this.f148550b = r101;
        this.f148551c = r102;
        this.f148552d = r103;
        this.f148553e = r104;
        this.f148554f = r105;
        this.f148555g = r106;
        this.f148556h = r110;
    }
}
