package com.bytedance.android.livesdkapi.room.handler.enterroom;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ>\u0010\f\u001a\u00020\u00002.\u0010\r\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0086\b¢\u0006\u0002\u0010\u0010J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/PreviewReportBuilder;", "", "dc", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "getDc", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "map", "", "", "build", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/PreviewReportData;", "put", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lcom/bytedance/android/livesdkapi/room/handler/enterroom/PreviewReportBuilder;", "key", "value", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewReportBuilder {

    /* JADX INFO: renamed from: dc, reason: collision with root package name */
    private final DataCenter f162651dc;
    private final Map<String, Object> map;

    /* JADX WARN: Multi-variable type inference failed */
    public final PreviewReportData build() {
        Map<String, Object> r100 = this.map;
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L9;
        String r106 = r105.toString();
        if (r106 == null) goto L9;
    L10:
        r101.put(r104, r106);
    L9:
        r106 = "";
        goto L10
    L11:
        DataCenter r107 = null;
        return new PreviewReportData(r101, r107, 2, 0 == true ? 1 : 0);
    }

    public final DataCenter getDc() {
        return this.f162651dc;
    }

    public PreviewReportBuilder(DataCenter r100) {
        this.f162651dc = r100;
        this.map = new LinkedHashMap();
    }

    public final PreviewReportBuilder put(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        Pair<String, ? extends Object> r103 = r100[r102];
        if (r103 == null) goto L9;
        Object r104 = r103.getSecond();
        if (r104 == null) goto L9;
        put(r103.getFirst(), r104);
    L9:
        r102 = r102 + 1;
        goto L3
    L10:
        return this;
    }

    public final PreviewReportBuilder put(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L5;
        this.map.put(r100, r101);
    L5:
        return this;
    }
}
