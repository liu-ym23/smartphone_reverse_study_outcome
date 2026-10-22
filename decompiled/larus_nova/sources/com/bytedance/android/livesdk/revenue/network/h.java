package com.bytedance.android.livesdk.revenue.network;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f157220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f157221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f157222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f157223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InputStream f157224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f157225f;

    @Override // com.bytedance.android.livesdk.revenue.network.b
    public final byte[] getBody() {
        return this.f157223d;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.b
    public final Map<String, String> getHeaders() {
        return this.f157221b;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.b
    public final String getMimeType() {
        return this.f157222c;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.b
    public final String getReason() {
        return this.f157225f;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.b
    public final int getStatusCode() {
        return this.f157220a;
    }

    public h(HttpResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        r100.getUrl();
        int r101 = r100.getStatusCode();
        List<NameValuePair> r102 = r100.getHeaders();
        String r103 = "";
        if (r102 == null) goto L14;
        List<NameValuePair> r104 = r102;
        Map r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L15;
        NameValuePair r107 = (NameValuePair) r106.next();
        String r108 = r107.getName();
        if (r108 != null) goto L10;
        r108 = "";
    L10:
        String r109 = r107.getValue();
        if (r109 != null) goto L13;
        r109 = "";
    L13:
        Pair r110 = new Pair(r108, r109);
        r105.put(r110.getFirst(), r110.getSecond());
    L15:
        String r111 = r100.getMimeType();
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        byte[] r112 = r100.getBody();
        InputStream r113 = r100.getStream();
        String r114 = r100.getReason();
        if (r114 == null) goto L22;
        r103 = r114;
    L22:
        this.f157220a = r101;
        this.f157221b = r105;
        this.f157222c = r111;
        this.f157223d = r112;
        this.f157224e = r113;
        this.f157225f = r103;
        return;
    L14:
        r105 = MapsKt.emptyMap();
        goto L15
    }
}
