package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.livehostapi.business.IBcmSearchTrack;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class h0 extends a<am2.t> implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public am2.t f153298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f153299d;

    public h0() {
        this.f153299d = Collections.synchronizedMap(new LinkedHashMap());
    }

    @Override // com.bytedance.android.livesdk.log.filter.s
    public final am2.t getData() {
        return this.f153298c;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(am2.t r100) {
        this.f153298c = r100;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r110, am2.t r111) {
        am2.t r112 = r111;
        if (r112 == null) goto L5;
        long r100 = r112.f4339a;
    L6:
        am2.t r101 = this.f153298c;
        String r102 = "";
        if (r101 == null) goto L19;
        Map<Long, String> r103 = r101.f4341c;
        if (r103 == null) goto L19;
        if (r103.containsKey(Long.valueOf(r100)) != true) goto L19;
        am2.t r104 = this.f153298c;
        if (r104 == null) goto L25;
        Map<Long, String> r105 = r104.f4341c;
        if (r105 == null) goto L25;
        String r106 = r105.get(Long.valueOf(r100));
        if (r106 == null) goto L25;
    L26:
        am2.t r107 = this.f153298c;
        if (r107 == null) goto L39;
        Map<Long, String> r108 = r107.f4340b;
        if (r108 == null) goto L39;
        if (r108.containsKey(Long.valueOf(r100)) != true) goto L39;
        am2.t r109 = this.f153298c;
        if (r109 == null) goto L45;
        Map<Long, String> r113 = r109.f4340b;
        if (r113 == null) goto L45;
        String r114 = r113.get(Long.valueOf(r100));
        if (r114 == null) goto L45;
    L46:
        am2.t r115 = this.f153298c;
        if (r115 == null) goto L59;
        Map<Long, String> r116 = r115.f4343e;
        if (r116 == null) goto L59;
        if (r116.containsKey(Long.valueOf(r100)) != true) goto L59;
        am2.t r117 = this.f153298c;
        if (r117 == null) goto L65;
        Map<Long, String> r118 = r117.f4343e;
        if (r118 == null) goto L65;
        String r119 = r118.get(Long.valueOf(r100));
        if (r119 == null) goto L65;
    L66:
        am2.t r120 = this.f153298c;
        if (r120 == null) goto L72;
        Map<Long, String> r121 = r120.f4342d;
        if (r121 == null) goto L72;
        String r122 = r121.get(Long.valueOf(r100));
        if (r122 == null) goto L72;
    L77:
        am2.t r123 = this.f153298c;
        if (r123 == null) goto L84;
        String r124 = r123.f4346h;
        if (r124 == null) goto L84;
        r102 = r124;
    L84:
        if (TextUtils.isEmpty(r106) == true) goto L88;
        if (r110 == null) goto L88;
        String r125 = (String) r110.put("search_id", r106);
    L88:
        if (TextUtils.isEmpty(r114) == true) goto L92;
        if (r110 == null) goto L92;
        String r126 = (String) r110.put("search_result_id", r114);
    L92:
        if (TextUtils.isEmpty(r119) == true) goto L96;
        if (r110 == null) goto L96;
        String r127 = (String) r110.put("search_jump", r119);
    L96:
        if (TextUtils.isEmpty(r122) == true) goto L100;
        if (r110 == null) goto L100;
        String r128 = (String) r110.put("search_params", r122);
    L100:
        if (TextUtils.isEmpty(r102) == true) goto L103;
        if (r110 == null) goto L103;
        String r129 = (String) r110.put("log_extra", r102);
    L103:
        if (r112 == null) goto L105;
        String r130 = r112.f4345g;
    L106:
        if (r130 == null) goto L122;
        if (r110 == null) goto L122;
        IBcmSearchTrack r131 = (IBcmSearchTrack) jc1.k.f(IBcmSearchTrack.class);
        if (r131 == null) goto L122;
        Map<String, Object> r132 = r131.appendSearchParams(r130, MapsKt.toMutableMap(r110));
        if (r132 == null) goto L122;
        Iterator<Map.Entry<String, Object>> r133 = r132.entrySet().iterator();
    L114:
        if (r133.hasNext() == false) goto L122;
        Map.Entry<String, Object> r134 = r133.next();
        String r135 = r134.getKey();
        Object r136 = r134.getValue();
        if (r135.length() <= 0) goto L118;
        boolean r137 = true;
    L119:
        if (r137 == false) goto L114;
        String r138 = (String) r110.put(r135, String.valueOf(r136));
        goto L114
    L118:
        r137 = false;
    L122:
        if (TextUtils.isEmpty(r106) == true) goto L130;
        super.u(r110, r112);
        return;
    L130:
        return;
    L105:
        r130 = null;
    L72:
        am2.t r139 = this.f153298c;
        if (r139 == null) goto L76;
        r122 = r139.f4344f;
        if (r122 != null) goto L77;
    L76:
        r122 = "";
    L65:
        r119 = "";
    L59:
        am2.t r140 = this.f153298c;
        if (r140 == null) goto L65;
        Map<String, String> r141 = r140.b();
        if (r141 == null) goto L65;
        r119 = r141.get("search_jump");
        if (r119 != null) goto L66;
    L45:
        r114 = "";
    L39:
        am2.t r142 = this.f153298c;
        if (r142 == null) goto L45;
        Map<String, String> r143 = r142.b();
        if (r143 == null) goto L45;
        r114 = r143.get("search_result_id");
        if (r114 != null) goto L46;
    L25:
        r106 = "";
    L19:
        am2.t r144 = this.f153298c;
        if (r144 == null) goto L25;
        Map<String, String> r145 = r144.b();
        if (r145 == null) goto L25;
        r106 = r145.get("search_id");
        if (r106 != null) goto L26;
    L5:
        r100 = 0;
        goto L6
    }
}
