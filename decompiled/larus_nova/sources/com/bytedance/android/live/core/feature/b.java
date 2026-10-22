package com.bytedance.android.live.core.feature;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {
    public b() {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Map<String, DynamicDataRespItem> r101 = ((DynamicDataResp) ((Response) r100).data).getAnchorInfos();
        long r102 = System.currentTimeMillis();
        if (r101 == null) goto L10;
        Set<Map.Entry<String, DynamicDataRespItem>> r103 = r101.entrySet();
        if (r103 == null) goto L12;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r104.next();
        ((DynamicDataRespItem) r105.getValue()).setTimeStrap(r102);
        a<String, DynamicDataRespItem> r106 = RoomFeatureUtils.f64783b;
        Object r107 = r105.getKey();
        r106.a((String) r107, (DynamicDataRespItem) r105.getValue());
        ((DynamicDataRespItem) r105.getValue()).getRoomId();
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
