package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.w;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelPreloadViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "fullCacheCount", "", "getFullCacheCount", "()I", "fullCacheCount$delegate", "Lkotlin/Lazy;", "layoutViewTypeMap", "", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelPreloadView;", "panelViewCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getCachedViewCount", "viewInfo", "getViewByLayoutId", "layoutId", "getViewTypeByLayoutId", "isCacheFull", "", "onCleared", "", "putView", "view", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPanelPreloadViewModel extends ViewModel {
    private final Lazy fullCacheCount$delegate;
    private final Map<Integer, GiftPanelPreloadView> layoutViewTypeMap;
    private final ConcurrentHashMap<GiftPanelPreloadView, ArrayList<View>> panelViewCache;

    private final int getFullCacheCount() {
        return ((Number) this.fullCacheCount$delegate.getValue()).intValue();
    }

    public final boolean isCacheFull() {
        if (this.panelViewCache.size() != this.layoutViewTypeMap.size()) goto L12;
        ConcurrentHashMap<GiftPanelPreloadView, ArrayList<View>> r100 = this.panelViewCache;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<GiftPanelPreloadView, ArrayList<View>>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        r101.add(Integer.valueOf(r102.next().getValue().size()));
        goto L6
    L9:
        if (CollectionsKt.sumOfInt(r101) != getFullCacheCount()) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public GiftPanelPreloadViewModel() {
        this.panelViewCache = new ConcurrentHashMap();
        GiftPanelPreloadView.Companion.getClass();
        List r100 = (List) GiftPanelPreloadView.access$getAllViews$cp().getValue();
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        r101.put(Integer.valueOf(((GiftPanelPreloadView) r103).getLayoutId()), r103);
        goto L4
    L6:
        this.layoutViewTypeMap = r101;
        this.fullCacheCount$delegate = LazyKt.lazy(GiftPanelPreloadViewModel$fullCacheCount$2.INSTANCE);
        c0.f127389d.getClass();
        c0.f127388c = (a) GiftPreloadSettingsKt.f128178b.getValue(null, GiftPreloadSettingsKt.f128177a[0]);
        x r104 = x.f127488e;
        r104.getClass();
        x.f127487d = (w) x.f127485b.getValue(r104, x.f127484a[0]);
        GiftPanelBizBoostUtils r105 = GiftPanelBizBoostUtils.E;
        r105.getClass();
        ReadOnlyProperty r106 = GiftPanelBizBoostUtils.f127348c;
        KProperty<?>[] r107 = GiftPanelBizBoostUtils.f127346a;
        GiftPanelBizBoostUtils.f127370y = ((Boolean) r106.getValue(r105, r107[1])).booleanValue();
        GiftPanelBizBoostUtils.A = (d0) GiftPanelBizBoostUtils.f127354i.getValue(r105, r107[7]);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.panelViewCache.clear();
        ((RevenueImageUrlService) f.a(RevenueImageUrlService.class)).f130575a.clear();
    }

    public final int getCachedViewCount(GiftPanelPreloadView r100) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        ArrayList<View> r101 = this.panelViewCache.get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.size();
    }

    public final View getViewByLayoutId(int r100) {
        GiftPanelPreloadView r101 = this.layoutViewTypeMap.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList<View> r102 = this.panelViewCache.get(r101);
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return null;
    L14:
        return (View) ListProtector.remove(r102, 0);
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public final GiftPanelPreloadView getViewTypeByLayoutId(int r100) {
        return this.layoutViewTypeMap.get(Integer.valueOf(r100));
    }

    public final void putView(GiftPanelPreloadView r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        Intrinsics.checkNotNullParameter(r101, "view");
        ArrayList<View> r102 = this.panelViewCache.get(r100);
        if (r102 != null) goto L5;
        this.panelViewCache.put(r100, CollectionsKt.arrayListOf(new View[]{r101}));
    L10:
        if (r100 != GiftPanelPreloadView.GridViewHolderItem) goto L17;
        ArrayList<View> r103 = this.panelViewCache.get(r100);
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.size() != r100.getCount()) goto L19;
        jy0.b.d("ttlive_gift_preload", "async inflate done for gridItem, cache cnt: " + r100.getCount());
        return;
    L19:
        return;
    L17:
        return;
    L5:
        if (r102.size() < r100.getCount()) goto L7;
        jy0.b.d("ttlive_gift_preload", r100 + " cache is full, count=" + r102.size());
        goto L10
    L7:
        r102.add(r101);
        goto L10
    }
}
