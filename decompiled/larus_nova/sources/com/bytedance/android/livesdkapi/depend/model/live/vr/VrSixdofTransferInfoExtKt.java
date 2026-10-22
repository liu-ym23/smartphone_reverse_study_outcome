package com.bytedance.android.livesdkapi.depend.model.live.vr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001d\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"layerStatusList", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/vr/VrSixdofTransferInfo;", "getLayerStatusList", "(Lcom/bytedance/android/livesdkapi/depend/model/live/vr/VrSixdofTransferInfo;)Ljava/util/List;", "livebase-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class VrSixdofTransferInfoExtKt {
    public static final List<Integer> getLayerStatusList(VrSixdofTransferInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layerStatusList");
        Map<String, Long> r101 = r100.getLayerStatus();
        if (r101 == null) goto L10;
        Collection<Long> r102 = r101.values();
        if (r102 == null) goto L10;
        Collection<Long> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L13;
        r104.add(Integer.valueOf((int) ((Number) r105.next()).longValue()));
        goto L8
    L13:
        return r104;
    L10:
        return null;
    }
}
