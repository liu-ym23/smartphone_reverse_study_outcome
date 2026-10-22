package com.bytedance.android.livesdk.chatroom.detail;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements com.bytedance.android.livesdk.log.filter.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f105633a = null;

    public b0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f105633a = new b0();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "params");
        int r100 = r110.hashCode();
        long r101 = 0;
        if (r100 == 479193863) goto L37;
        if (r100 == 1499179894) goto L8;
        return;
    L8:
        if (r110.equals("livesdk_live_play") == false) goto L84;
        String r112 = r111.get("room_id");
        Lazy r102 = LiveRoomDurationRetrieveLogger.f105611a;
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r112 != null) goto L68;
    L16:
        e0 r103 = (e0) LiveRoomDurationRetrieveLogger.d().get(Long.valueOf(r101));
        if (r103 == null) goto L85;
        ((LinkedHashMap) r103.f105659h).clear();
        List<String> r104 = LiveRoomDurationRetrieveLogger.a().d();
        if (r104 != null) goto L21;
        r104 = new ArrayList();
    L21:
        Iterator<T> r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L35;
        String r106 = (String) r105.next();
        String r107 = r111.get(r106);
        if (r107 == null) goto L23;
        if (r107.length() <= 0) goto L29;
        boolean r108 = true;
    L30:
        if (r108 == true) goto L33;
        r107 = null;
    L33:
        if (r107 == null) goto L23;
        r103.f105659h.put(r106, r107);
        goto L23
    L29:
        r108 = false;
        goto L30
    L35:
        LiveRoomDurationRetrieveLogger.h("recordLivePlay " + r112 + ", roomRetrieveMap.size:" + LiveRoomDurationRetrieveLogger.d().size());
        return;
    L85:
        return;
    L68:
        Long r109 = Long.valueOf(CastLongProtector.parseLong(r112));     // Catch: Exception -> L13
    L14:
        if (r109 == null) goto L16;
        r101 = r109.longValue();
    L13:
        r109 = null;
        goto L14
    L84:
        return;
    L37:
        if (r110.equals("livesdk_rec_live_play") == false) goto L87;
        String r113 = r111.get("room_id");
        Lazy r114 = LiveRoomDurationRetrieveLogger.f105611a;
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r113 != null) goto L66;
    L45:
        e0 r115 = (e0) LiveRoomDurationRetrieveLogger.d().get(Long.valueOf(r101));
        if (r115 == null) goto L88;
        ((LinkedHashMap) r115.f105659h).clear();
        List<String> r116 = LiveRoomDurationRetrieveLogger.a().d();
        if (r116 != null) goto L50;
        r116 = new ArrayList();
    L50:
        Iterator<T> r117 = r116.iterator();
    L52:
        if (r117.hasNext() == false) goto L64;
        String r118 = (String) r117.next();
        String r119 = r111.get(r118);
        if (r119 == null) goto L52;
        if (r119.length() <= 0) goto L58;
        boolean r120 = true;
    L59:
        if (r120 == true) goto L62;
        r119 = null;
    L62:
        if (r119 == null) goto L52;
        r115.f105659h.put(r118, r119);
        goto L52
    L58:
        r120 = false;
        goto L59
    L64:
        LiveRoomDurationRetrieveLogger.h("recordRecLivePlay " + r113 + ", roomRetrieveMap.size:" + LiveRoomDurationRetrieveLogger.d().size());
        return;
    L88:
        return;
    L66:
        Long r121 = Long.valueOf(CastLongProtector.parseLong(r113));     // Catch: Exception -> L42
    L43:
        if (r121 == null) goto L45;
        r101 = r121.longValue();
    L42:
        r121 = null;
        goto L43
    }
}
