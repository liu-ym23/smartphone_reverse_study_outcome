package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j40.w3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class g {
    public static final com.bytedance.android.livesdk.vscore_api.paidlive.c b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        com.bytedance.android.livesdk.vscore_api.paidlive.c r101 = (com.bytedance.android.livesdk.vscore_api.paidlive.c) m.f163449e.d(r100, com.bytedance.android.livesdk.vscore_api.paidlive.c.class);
        if (r101 != null) goto L6;
        LinkedHashMap<String, b> r102 = f.f159507a;
        return f.g(null);
    L6:
        return r101;
    }

    public static final com.bytedance.android.livesdk.vscore_api.paidlive.c c(IRoom r100) {
        if (r100 != null) goto L6;
        return f.h();
    L6:
        return a(r100.getRoomId(), r100);
    }

    public static final com.bytedance.android.livesdk.vscore_api.paidlive.c d(DataCenter r110) {
        LinkedHashMap<String, b> r100 = f.f159507a;
        if (r110 != null) goto L5;
        ALogger.e("PaidScopeUtil", "getPaidManagerService by dataCenter {null} to default");
        return f.h();
    L5:
        IRoom r101 = lu2.c.f(r110);
        if (r101 == null) goto L8;
        Long r102 = Long.valueOf(r101.getRoomId());
    L9:
        long r103 = r102.longValue();
        Integer r104 = (Integer) r110.get("data_fragment_hashcode", 0);
        if (r104 == null) goto L12;
        Long r105 = Long.valueOf(r104.intValue());
    L14:
        if (r103 == 0) goto L16;
        Long r106 = Long.valueOf(r103);
    L17:
        LinkedHashMap<String, b> r107 = f.f159507a;
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator<Map.Entry<String, b>> r108 = r107.entrySet().iterator();
    L19:
        if (r108.hasNext() == false) goto L26;
        Map.Entry<String, b> r112 = r108.next();
        if (r112.getValue().D().getDataCenter().hashCode() != r110.hashCode()) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == false) goto L19;
        r111.put(r112.getKey(), r112.getValue());
        goto L19
    L23:
        r113 = false;
        goto L24
    L26:
        Map.Entry r109 = z0.a(r111);
        if (r109 == null) goto L29;
        b r114 = (b) r109.getValue();
    L30:
        if (r114 != null) goto L45;
        if (r106 != null) goto L34;
    L35:
        LinkedHashMap<String, b> r115 = f.f159507a;
        LinkedHashMap r116 = new LinkedHashMap();
        Iterator<Map.Entry<String, b>> r117 = r115.entrySet().iterator();
    L37:
        if (r117.hasNext() == false) goto L41;
        Map.Entry<String, b> r118 = r117.next();
        if (StringsKt.contains$default(r118.getKey(), String.valueOf(r106), false, 2, null) == false) goto L37;
        r116.put(r118.getKey(), r118.getValue());
        goto L37
    L41:
        Pair r119 = (Pair) CollectionsKt.lastOrNull(MapsKt.toList(r116));
        if (r119 == null) goto L44;
        r114 = (b) r119.getSecond();
        goto L45
    L44:
        r114 = null;
        goto L45
    L34:
        if (r106.longValue() != 0) goto L35;
    L45:
        if (r114 == null) goto L47;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r120 = (com.bytedance.android.livesdk.vscore_api.paidlive.c) m.f163449e.d(r114, com.bytedance.android.livesdk.vscore_api.paidlive.c.class);
    L48:
        if (r120 != null) goto L63;
        ALogger.e("PaidScopeUtil", "getPaidManagerService by dataCenter:" + r110 + ", roomId = " + r103 + ", replayId = " + r105 + ", return default service");
        return f.g(null);
    L63:
        return r120;
    L47:
        r120 = null;
        goto L48
    L29:
        r114 = null;
        goto L30
    L16:
        r106 = r105;
        goto L17
    L12:
        r105 = null;
        goto L14
    L8:
        r102 = null;
        goto L9
    }

    public static final com.bytedance.android.livesdk.vscore_api.paidlive.c a(long r100, IRoom r110) {
        LinkedHashMap<String, b> r101 = f.f159507a;
        LinkedHashMap<String, b> r102 = f.f159507a;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, b>> r104 = r102.entrySet().iterator();
    L3:
        com.bytedance.android.livesdk.vscore_api.paidlive.c r105 = null;
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, b> r106 = r104.next();
        if (StringsKt.contains$default(r106.getKey(), String.valueOf(r100), false, 2, null) == false) goto L3;
        r103.put(r106.getKey(), r106.getValue());
        goto L3
    L8:
        Pair r107 = (Pair) CollectionsKt.lastOrNull(MapsKt.toList(r103));
        if (r107 == null) goto L11;
        b r108 = (b) r107.getSecond();
    L12:
        if (r108 == null) goto L14;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r109 = (com.bytedance.android.livesdk.vscore_api.paidlive.c) m.f163449e.d(r108, com.bytedance.android.livesdk.vscore_api.paidlive.c.class);
    L15:
        if (r109 != null) goto L47;
        Map<String, b> r111 = f.f159508b;
        LinkedHashMap r112 = new LinkedHashMap();
        Iterator r113 = ((LinkedHashMap) r111).entrySet().iterator();
    L19:
        if (r113.hasNext() == false) goto L23;
        Map.Entry r114 = (Map.Entry) r113.next();
        if (StringsKt.contains$default((CharSequence) r114.getKey(), String.valueOf(r100), false, 2, null) == false) goto L19;
        r112.put(r114.getKey(), r114.getValue());
        goto L19
    L23:
        Map.Entry r115 = z0.a(r112);
        if (r115 == null) goto L26;
        b r116 = (b) r115.getValue();
    L27:
        if (r116 == null) goto L29;
        r105 = (com.bytedance.android.livesdk.vscore_api.paidlive.c) m.f163449e.d(r116, com.bytedance.android.livesdk.vscore_api.paidlive.c.class);
    L29:
        if (r105 == null) goto L32;
        return r105;
    L32:
        if (w3.f497318a.getValue().booleanValue() == true) goto L35;
        ALogger.d("PaidScopeUtil", "getPaidManagerService by id:" + r100 + " return default service");
    L35:
        return f.g(r110);
    L26:
        r116 = null;
        goto L27
    L47:
        return r109;
    L14:
        r109 = null;
        goto L15
    L11:
        r108 = null;
        goto L12
    }
}
