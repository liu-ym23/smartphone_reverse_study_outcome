package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.google.gson.internal.LinkedTreeMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends a<com.bytedance.android.shopping.anchorv4.voavhs.headv2.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.b f169674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f169675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f169676c;

    public final Context getContext() {
        return this.f169675b;
    }

    public c(Context r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        this.f169675b = r100;
        this.f169676c = r101;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final void l(Object r110, int r111, Integer r112) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.j r113 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.j) r110;
        Intrinsics.checkNotNullParameter(r113, "data");
        if (this.f169674a != null) goto L31;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.b r114 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.b(this.f169675b, this.f169676c.rR());
        this.f169674a = r114;
        Intrinsics.checkNotNullParameter(r113, "data");
        if (r114.f169596a != null) goto L28;
        r114.f169597b = r113;
        String r115 = r113.e();
        LinkedHashMap r100 = new LinkedHashMap();
        Map<String, String> r116 = r113.b();
        if (r116 == null) goto L14;
        Set<Map.Entry<String, String>> r117 = r116.entrySet();
        if (r117 == null) goto L14;
        Iterator<T> r118 = r117.iterator();
    L12:
        if (r118.hasNext() == false) goto L14;
        Map.Entry r101 = (Map.Entry) r118.next();
        r100.put(r101.getKey(), r101.getValue());
    L14:
        LinkedTreeMap<String, Object> r119 = r114.f169598c.getTrackMeta();
        if (r119 == null) goto L17;
        r100.put("pdp_track_meta", MapsKt.toMap(r119));
    L17:
        CommonMeta r120 = r114.f169598c.r0();
        if (r120 == null) goto L20;
        String r121 = r120.getEntranceInfo();
    L21:
        if (r121 == null) goto L23;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r121);
    L23:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r114.f169598c.getSessionId());
        Context r102 = r114.getContext();
        if (r115 != null) goto L26;
        String r103 = "";
    L27:
        r114.f169596a = ECLiveHybridUtil.b(r102, r103, r100, r114, null, null, null, false, null, null, false, 4080);
        goto L28
    L26:
        r103 = r115;
        goto L27
    L20:
        r121 = null;
    L28:
        this.f169676c.eh().h(true);
        return;
    }
}
