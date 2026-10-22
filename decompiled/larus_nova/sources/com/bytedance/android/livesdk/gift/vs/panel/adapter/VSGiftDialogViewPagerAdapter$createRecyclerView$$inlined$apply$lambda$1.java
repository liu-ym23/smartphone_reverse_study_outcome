package com.bytedance.android.livesdk.gift.vs.panel.adapter;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import yz0.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/livesdk/gift/vs/panel/adapter/VSGiftDialogViewPagerAdapter$createRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f132367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f132368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f132369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f132370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ VSGiftDialogViewPagerAdapter f132371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f132372f;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "recyclerView");
        this.f132369c = r111;
        RecyclerView.LayoutManager r112 = r110.getLayoutManager();
        List<AbsPanel<?>> r100 = null;
        String r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        if ((r112 instanceof LinearLayoutManager) == true) goto L5;
        r112 = null;
    L5:
        LinearLayoutManager r113 = (LinearLayoutManager) r112;
        if (r113 == null) goto L9;
        VSGiftDialogViewPagerAdapter r102 = this.f132371e;
        int r103 = r113.findFirstCompletelyVisibleItemPosition();
        int r114 = r113.findLastCompletelyVisibleItemPosition();
        int r104 = VSGiftDialogViewPagerAdapter.f132347p;
        r102.m(r103, r114);
    L9:
        if (r111 == 0) goto L17;
        if (r111 != 1) goto L12;
        this.f132371e.f132356i = System.currentTimeMillis();
        return;
    L12:
        if (r111 != 2) goto L69;
        this.f132367a.postDelayed(this.f132368b, 20);
        return;
    L69:
        return;
    L17:
        if ((!Intrinsics.areEqual(this.f132371e.f132352e, new IntRange(-1, -1))) == false) goto L67;
        VSGiftDialogViewPagerAdapter r115 = this.f132371e;
        if ((!Intrinsics.areEqual(r115.f132352e, (IntRange) ((LinkedHashMap) r115.f132355h).get(Integer.valueOf(this.f132372f)))) == true) goto L21;
        return;
    L21:
        if (this.f132371e.f132361n.getDataCenter() != null) goto L23;
    L60:
        VSGiftDialogViewPagerAdapter r116 = this.f132371e;
        IntRange r117 = (IntRange) ((LinkedHashMap) r116.f132355h).get(Integer.valueOf(this.f132372f));
        if (r117 != null) goto L63;
        r117 = new IntRange(-1, -1);
    L63:
        r116.f132352e = r117;
        return;
    L23:
        if (x.d() == false) goto L45;
        String r118 = h.f132038a;
        int r105 = this.f132372f;
        IntRange r106 = new IntRange((this.f132371e.f132352e.getFirst() / 4) + 1, (this.f132371e.f132352e.getLast() / 4) + 1);
        int r107 = (this.f132371e.f132352e.getLast() - this.f132371e.f132352e.getFirst()) + 1;
        long r108 = (System.currentTimeMillis() - this.f132371e.f132356i) / ((long) 1000);
        boolean r109 = u.p();
        this.f132371e.getClass();
        j.a r119 = j.C0;
        k r120 = (k) f.d(r119.a(), k.class);
        n01.a r121 = (n01.a) f.d(r119.a(), n01.a.class);
        if (r121 == null) goto L32;
        Episode r122 = r121.jf();
        if (r122 == null) goto L32;
        String r123 = r122.getSeasonIdFlex();
        if (r123 == null) goto L32;
        r101 = r123;
    L40:
        if (r101 != null) goto L42;
        String r124 = "";
    L43:
        h.D(r105, r106, r107, r108, r109 ? 1 : 0, r124);
        goto L60
    L42:
        r124 = r101;
    L32:
        if (r120 == null) goto L40;
        IRoom r125 = r120.getRoom();
        if (r125 == null) goto L40;
        IEpisodeExtraInfo r126 = r125.getEpisodeExtra();
        if (r126 == null) goto L40;
        Long r127 = r126.getSeasonId();
        if (r127 == null) goto L40;
        r101 = String.valueOf(r127.longValue());
        goto L40
    L45:
        if (x.b() == false) goto L60;
        VSGiftDialogAdapterNew r128 = (VSGiftDialogAdapterNew) ((LinkedHashMap) this.f132371e.f132351d).get(Integer.valueOf(this.f132372f));
        if (r128 == null) goto L49;
        r100 = r128.f132342a;
    L49:
        if (r100 == null) goto L59;
        GiftContext r129 = b.b();
        if (r129 == null) goto L57;
        n<Integer> r130 = r129.getCurrentSelectedGiftPosition();
        if (r130 == null) goto L57;
        Integer r131 = r130.getValue();
        if (r131 == null) goto L57;
        int r132 = r131.intValue();
    L58:
        AbsPanel r133 = (AbsPanel) CollectionsKt.getOrNull(r100, r132);
    L57:
        r132 = 0;
    L59:
        int r134 = d22.a.f466508a;
        d22.a.a(this.f132372f, new IntRange((this.f132371e.f132352e.getFirst() / 4) + 1, (this.f132371e.f132352e.getLast() / 4) + 1), (this.f132371e.f132352e.getLast() - this.f132371e.f132352e.getFirst()) + 1, (System.currentTimeMillis() - this.f132371e.f132356i) / ((long) 1000));
        goto L60
    }

    public VSGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1(RecyclerView r100, VSGiftDialogViewPagerAdapter r101, int r102) {
        this.f132370d = r100;
        this.f132371e = r101;
        this.f132372f = r102;
        this.f132367a = new Handler();
        this.f132368b = new a(this);
        this.f132369c = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r101 != 0) goto L5;
        if (r102 != 0) goto L5;
    L6:
        this.f132367a.removeCallbacks(this.f132368b);
        if (this.f132369c != 2) goto L10;
        this.f132367a.postDelayed(this.f132368b, 20);
        return;
    L10:
        return;
    L5:
        this.f132371e.l(r100, this.f132372f, false, true);
        goto L6
    }
}
