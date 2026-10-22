package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/utils/PagerSnapScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PagerSnapScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f152159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f152160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PagerSnapHelper f152161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f152162d;

    public interface a {
        void a(int r100, float r101);

        void onPageScrollStateChanged(int r100);

        void onPageSelected(int r100);
    }

    public PagerSnapScrollListener(PagerSnapHelper r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "snapHelper");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f152161c = r100;
        this.f152162d = r101;
        this.f152160b = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        this.f152159a = r101;
        this.f152162d.onPageScrollStateChanged(r101);
        if (r101 != 0) goto L14;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if (r102 != null) goto L7;
        return;
    L7:
        View r103 = this.f152161c.findSnapView(r102);
        if (r103 != null) goto L10;
        return;
    L10:
        int r104 = r102.getPosition(r103);
        if (this.f152160b == r104) goto L15;
        this.f152160b = r104;
        this.f152162d.onPageSelected(r104);
        return;
    L15:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        if (this.f152159a != 0) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        ViewGroup.LayoutParams r104 = null;
        if ((r103 instanceof LinearLayoutManager) == true) goto L8;
        r103 = null;
    L8:
        LinearLayoutManager r105 = (LinearLayoutManager) r103;
        if (r105 != null) goto L11;
        return;
    L11:
        int r106 = r105.findFirstVisibleItemPosition();
        View r107 = r105.findViewByPosition(r106);
        if (r107 != null) goto L14;
        return;
    L14:
        int r108 = r105.getDecoratedLeft(r107);
        if (r105.canScrollHorizontally() == false) goto L23;
        ViewGroup.LayoutParams r109 = r100.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r104 = r109;
    L20:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r104;
        if (r110 == null) goto L30;
        int r111 = r110.leftMargin;
    L31:
        int r112 = Math.abs(r108 - r111);
        int r113 = r107.getWidth();
        if (r113 <= 0) goto L34;
        float r114 = r112 / r113;
    L36:
        if (r114 >= 0.0f) goto L38;
        return;
    L38:
        if (r114 > 1.0f) goto L42;
        this.f152162d.a(r106, r114);
        return;
    L42:
        return;
    L34:
        r114 = 0.0f;
    L30:
        r111 = 0;
        goto L31
    L23:
        ViewGroup.LayoutParams r115 = r100.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r104 = r115;
    L27:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r104;
        if (r116 == null) goto L30;
        r111 = r116.topMargin;
        goto L31
    }
}
