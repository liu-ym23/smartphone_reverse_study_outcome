package com.bytedance.android.openlive.realtime.utils;

import com.bytedance.android.openlive.realtime.data.WatchLiveItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/openlive/realtime/utils/ViewLiveItemAggregator;", "", "watchAggregationTime", "", "(J)V", "aggregate", "", "Lcom/bytedance/android/openlive/realtime/data/WatchLiveItem;", "needReportItems", "aggregateForRoom", "viewLiveItems", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ViewLiveItemAggregator {
    private final long watchAggregationTime;

    public ViewLiveItemAggregator(long r100) {
        this.watchAggregationTime = r100;
    }

    private final List<WatchLiveItem> aggregateForRoom(List<WatchLiveItem> r210) {
        int r100 = 1;
        if (r210.size() > 1) goto L5;
        return r210;
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L7:
        if (r102 >= r210.size()) goto L17;
        long r103 = ((WatchLiveItem) ListProtector.get(r210, r102)).getStartTime() + ((WatchLiveItem) ListProtector.get(r210, r102)).getDuration();
        long r104 = ((WatchLiveItem) ListProtector.get(r210, r102)).getDuration();
    L10:
        if (r100 >= r210.size()) goto L15;
        if ((((WatchLiveItem) ListProtector.get(r210, r100)).getStartTime() - r103) > this.watchAggregationTime) goto L15;
        r104 = r104 + ((WatchLiveItem) ListProtector.get(r210, r100)).getDuration();
        r100 = r100 + 1;
    L15:
        WatchLiveItem r105 = WatchLiveItem.copy$default((WatchLiveItem) ListProtector.get(r210, r102), 0, 0, 0, 0, null, 31, null);
        r105.setDuration(r104);
        Unit r106 = Unit.INSTANCE;
        r101.add(r105);
        r102 = r100;
        r100 = r100 + 1;
        goto L7
    L17:
        return CollectionsKt.toList(r101);
    }

    public final List<WatchLiveItem> aggregate(List<WatchLiveItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "needReportItems");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        Long r104 = Long.valueOf(((WatchLiveItem) r103).getRoomId());
        Object r105 = r101.get(r104);
        if (r105 != null) goto L8;
        r105 = new ArrayList();
        r101.put(r104, r105);
    L8:
        ((List) r105).add(r103);
        goto L4
    L9:
        ArrayList r106 = new ArrayList(r101.size());
        Iterator r107 = r101.entrySet().iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        r106.add(aggregateForRoom((List) ((Map.Entry) r107.next()).getValue()));
        goto L11
    L13:
        List<WatchLiveItem> r108 = CollectionsKt.toMutableList(CollectionsKt.flatten(r106));
        if (r108.size() <= 1) goto L16;
        CollectionsKt.sortWith(r108, new ViewLiveItemAggregator$$special$$inlined$sortBy$1());
    L16:
        return r108;
    }
}
