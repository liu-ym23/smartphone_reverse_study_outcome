package com.bytedance.android.shopping.orderlist.common.widgets.exposure;

import android.graphics.Rect;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.shopping.orderlist.list.slice.elements.oftenbuy.OrderListOftenBuyRecyclerView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/exposure/RecyclerViewItemExposureHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewItemExposureHelper extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Unit> f180016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f180017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f180018c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerViewItemExposureHelper f180019a;

        public a(RecyclerViewItemExposureHelper r100) {
            this.f180019a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f180019a.j();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void j() {
        RecyclerView.LayoutManager r100 = this.f180017b.getLayoutManager();
        if (r100 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof LinearLayoutManager) == false) goto L9;
        LinearLayoutManager r101 = (LinearLayoutManager) r100;
        int r102 = r101.findFirstVisibleItemPosition();
        int r103 = r101.findLastVisibleItemPosition();
    L27:
        Pair r104 = TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r103));
        int r105 = ((Number) r104.component1()).intValue();
        int r106 = ((Number) r104.component2()).intValue();
        if (r105 > r106) goto L68;
    L29:
        View r107 = r100.findViewByPosition(r105);
        if (r107 != null) goto L32;
    L31:
        RecyclerView.LayoutManager r110 = r100;
        int r111 = r106;
    L60:
        boolean r108 = false;
    L61:
        if (r108 == false) goto L65;
        Function1<? super Integer, Unit> r109 = this.f180016a;
        if (r109 == null) goto L65;
        Unit r112 = r109.invoke(Integer.valueOf(r105));
    L65:
        int r113 = r111;
        if (r105 == r113) goto L76;
        r105 = r105 + 1;
        r106 = r113;
        r100 = r110;
        goto L29
    L76:
        return;
    L32:
        Rect r114 = new Rect();
        if (r107.getLocalVisibleRect(r114) == false) goto L31;
        double r115 = r107.getHeight();
        double r116 = r107.getWidth();
        if (r115 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        if (r116 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        double r117 = r114.left;
        double r118 = r114.top;
        r110 = r100;
        r111 = r106;
        double r119 = r114.right;
        double r120 = r114.bottom;
        if (r117 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L45;
        if (r116 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L45;
        r119 = r116 - r117;
    L43:
        double r121 = r119 / r116;
    L58:
        if ((r121 * ((double) 100)) < (this.f180018c * 100)) goto L60;
        r108 = true;
    L45:
        if (r119 == r116) goto L49;
        if (r116 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L43;
    L49:
        if (r118 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L53;
        if (r115 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L53;
        r121 = (r115 - r118) / r115;
    L53:
        if (r120 == r115) goto L56;
        if (r115 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L56;
        r121 = r120 / r115;
    L56:
        r121 = 1.0d;
        goto L58
    L68:
        return;
    L9:
        if ((r100 instanceof GridLayoutManager) == false) goto L12;
        GridLayoutManager r122 = (GridLayoutManager) r100;
        r102 = r122.findFirstVisibleItemPosition();
        r103 = r122.findLastVisibleItemPosition();
        goto L27
    L12:
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L26;
        StaggeredGridLayoutManager r123 = (StaggeredGridLayoutManager) r100;
        int r124 = r123.getSpanCount();
        int[] r125 = new int[r124];
        int r126 = r123.getSpanCount();
        int[] r127 = new int[r126];
        r123.findFirstVisibleItemPositions(r125);
        r123.findLastVisibleItemPositions(r127);
        int r128 = r125[0];
        int r129 = r127[0];
        int r130 = 1;
    L14:
        if (r130 >= r124) goto L19;
        int r131 = r125[r130];
        if (r128 <= r131) goto L18;
        r128 = r131;
    L18:
        r130 = r130 + 1;
        goto L14
    L19:
        int r132 = 1;
    L20:
        if (r132 >= r126) goto L25;
        int r133 = r127[r132];
        if (r129 >= r133) goto L24;
        r129 = r133;
    L24:
        r132 = r132 + 1;
        goto L20
    L25:
        r102 = r128;
        r103 = r129;
        goto L27
    L26:
        r102 = -1;
        r103 = -1;
        goto L27
    }

    public RecyclerViewItemExposureHelper(OrderListOftenBuyRecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f180017b = r100;
        this.f180018c = 0.8f;
    }

    public final void k(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onShow);
        this.f180016a = r100;
        this.f180017b.removeOnScrollListener(this);
        this.f180017b.addOnScrollListener(this);
        this.f180017b.post(new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        j();
    }
}
