package com.bytedance.android.ec.search.host.impl;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAddressService;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements ITradeSearchAddressService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f48182a = null;

    static {
        f48182a = new o();
    }

    public o() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAddressService
    public final boolean isLocationEnable() {
        wi.c r100 = com.bytedance.android.ec.sdk.helper.d.f48119b.getLocationService();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAddressService
    public final String getAddress(Object r100, String r101, String r102) {
        int r103 = ECSdk.f48106a;
        IAddressService r104 = (IAddressService) ECSdk.a(IAddressService.class);
        Object r105 = null;
        if (r104 == null) goto L40;
        o83.a r106 = IAddressService.a.a(r104, r100, r101, 4);
        if (r106 == null) goto L40;
        List<o83.b> r107 = r106.f522361a;
        if (r107 == null) goto L40;
        if (r102 == null) goto L40;
        Iterator<T> r108 = r107.iterator();
    L11:
        if (r108.hasNext() == false) goto L40;
        o83.b r109 = (o83.b) r108.next();
        if (Intrinsics.areEqual(r102, r109.f522368e) == false) goto L11;
        int r110 = o83.b.f522363f;
        JSONObject r111 = o83.b.a.a(r109.f522364a, false);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        if (r111 == null) goto L34;
        JSONObject r113 = r109.f522364a;     // Catch: Throwable -> L36
        if (r113 == null) goto L20;
        JSONObject r114 = r113.optJSONObject("poi_info");     // Catch: Throwable -> L36
    L21:
        if (r114 == null) goto L24;
        JSONObject r115 = r114.optJSONObject("coordinate");     // Catch: Throwable -> L36
    L26:
        if (r115 == null) goto L28;
        String r116 = Double.valueOf(r115.optDouble("latitude")).toString();     // Catch: Throwable -> L36
    L29:
        r111.put("latitude", r116);     // Catch: Throwable -> L36
        if (r115 == null) goto L33;
        r105 = Double.valueOf(r115.optDouble("longitude")).toString();     // Catch: Throwable -> L36
    L33:
        r105 = r111.put("longitude", r105);     // Catch: Throwable -> L36
        goto L34
    L28:
        r116 = null;
        goto L29
    L24:
        r115 = null;
        goto L26
    L20:
        r114 = null;
    L34:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L36
    L39:
        return String.valueOf(r111);
    L36:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAddressService
    public final void setAddress(JSONObject r100, int r101, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "address");
        int r102 = ECSdk.f48106a;
        IAddressService r103 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r103 == null) goto L6;
        IAddressService.a.b(r103, r100, r101, r110, new o83.d(Boolean.valueOf(r111), 6), 8);
        return;
    }
}
