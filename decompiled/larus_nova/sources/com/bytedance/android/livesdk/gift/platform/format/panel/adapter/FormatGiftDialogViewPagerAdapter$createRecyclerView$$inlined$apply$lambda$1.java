package com.bytedance.android.livesdk.gift.platform.format.panel.adapter;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revenue.core.util.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.q;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/livesdk/gift/platform/format/panel/adapter/FormatGiftDialogViewPagerAdapter$createRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f132120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f132121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f132122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f132123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FormatGiftDialogViewPagerAdapter f132124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f132125f;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "recyclerView");
        this.f132122c = r111;
        RecyclerView.LayoutManager r112 = r110.getLayoutManager();
        List<AbsPanel<?>> r100 = null;
        if ((r112 instanceof LinearLayoutManager) == true) goto L5;
        r112 = null;
    L5:
        LinearLayoutManager r113 = (LinearLayoutManager) r112;
        if (r113 == null) goto L9;
        FormatGiftDialogViewPagerAdapter r101 = this.f132124e;
        int r102 = r113.findFirstCompletelyVisibleItemPosition();
        int r114 = r113.findLastCompletelyVisibleItemPosition();
        int r103 = FormatGiftDialogViewPagerAdapter.f132101o;
        r101.m(r102, r114);
    L9:
        if (r111 == 0) goto L17;
        if (r111 != 1) goto L12;
        this.f132124e.f132110i = System.currentTimeMillis();
        return;
    L12:
        if (r111 != 2) goto L50;
        this.f132120a.postDelayed(this.f132121b, 20);
        return;
    L50:
        return;
    L17:
        if ((!Intrinsics.areEqual(this.f132124e.f132106e, new IntRange(-1, -1))) == false) goto L48;
        FormatGiftDialogViewPagerAdapter r115 = this.f132124e;
        if ((!Intrinsics.areEqual(r115.f132106e, (IntRange) ((LinkedHashMap) r115.f132109h).get(Integer.valueOf(this.f132125f)))) == true) goto L21;
        return;
    L21:
        if (this.f132124e.f132115n.getDataCenter() != null) goto L23;
    L41:
        FormatGiftDialogViewPagerAdapter r116 = this.f132124e;
        IntRange r117 = (IntRange) ((LinkedHashMap) r116.f132109h).get(Integer.valueOf(this.f132125f));
        if (r117 != null) goto L44;
        r117 = new IntRange(-1, -1);
    L44:
        r116.f132106e = r117;
        return;
    L23:
        if (x.d() == false) goto L26;
        String r118 = h.f132038a;
        int r104 = this.f132125f;
        IntRange r105 = new IntRange((this.f132124e.f132106e.getFirst() / 4) + 1, (this.f132124e.f132106e.getLast() / 4) + 1);
        int r106 = (this.f132124e.f132106e.getLast() - this.f132124e.f132106e.getFirst()) + 1;
        long r107 = (System.currentTimeMillis() - this.f132124e.f132110i) / ((long) 1000);
        boolean r108 = u.p();
        this.f132124e.getClass();
        int r119 = i.f91038a;
        q r120 = m.f163446b;
        h.D(r104, r105, r106, r107, r108 ? 1 : 0, "");
        goto L41
    L26:
        if (x.b() == false) goto L41;
        FormatGiftDialogAdapter r121 = (FormatGiftDialogAdapter) ((LinkedHashMap) this.f132124e.f132105d).get(Integer.valueOf(this.f132125f));
        if (r121 == null) goto L30;
        r100 = r121.f132096a;
    L30:
        if (r100 == null) goto L40;
        GiftContext r122 = b.b();
        if (r122 == null) goto L38;
        n<Integer> r123 = r122.getCurrentSelectedGiftPosition();
        if (r123 == null) goto L38;
        Integer r124 = r123.getValue();
        if (r124 == null) goto L38;
        int r125 = r124.intValue();
    L39:
        AbsPanel r126 = (AbsPanel) CollectionsKt.getOrNull(r100, r125);
    L38:
        r125 = 0;
    L40:
        int r127 = d22.a.f466508a;
        d22.a.a(this.f132125f, new IntRange((this.f132124e.f132106e.getFirst() / 4) + 1, (this.f132124e.f132106e.getLast() / 4) + 1), (this.f132124e.f132106e.getLast() - this.f132124e.f132106e.getFirst()) + 1, (System.currentTimeMillis() - this.f132124e.f132110i) / ((long) 1000));
        goto L41
    }

    public FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1(RecyclerView r100, FormatGiftDialogViewPagerAdapter r101, int r102) {
        this.f132123d = r100;
        this.f132124e = r101;
        this.f132125f = r102;
        this.f132120a = new Handler();
        this.f132121b = new a(this);
        this.f132122c = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r101 != 0) goto L5;
        if (r102 != 0) goto L5;
    L6:
        this.f132120a.removeCallbacks(this.f132121b);
        if (this.f132122c != 2) goto L10;
        this.f132120a.postDelayed(this.f132121b, 20);
        return;
    L10:
        return;
    L5:
        this.f132124e.l(r100, this.f132125f, false, true);
        goto L6
    }
}
