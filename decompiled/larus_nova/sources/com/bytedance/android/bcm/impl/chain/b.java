package com.bytedance.android.bcm.impl.chain;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl.config.BcmConfig;
import com.bytedance.crash.dumper.Scraps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends kc.a.C6534a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f41806j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f41807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f41808i;

    public static final class a {
        public static b a(kc.a.C6534a r100) {
            b r101 = new b();
            r101.f502356c = r100.f502356c;
            r101.f502358e = r100.f502358e;
            r101.f502359f = r100.f502359f;
            BcmConfig.a();
            List<String> r102 = BcmConfig.f41809a.c();
            kc.a.C6534a.C6535a r103 = r100.f502360g;
            if (r103 == null) goto L17;
            BcmParams r104 = r103.f502361a;
            if (r104 == null) goto L17;
            Map<String, Object> r105 = r104.toMap();
            if (r105 == null) goto L17;
            LinkedHashMap r106 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r107 = r105.entrySet().iterator();
        L10:
            if (r107.hasNext() == false) goto L15;
            Map.Entry<String, Object> r108 = r107.next();
            if (r102.contains(r108.getKey()) == false) goto L10;
            r106.put(r108.getKey(), r108.getValue());
            goto L10
        L15:
            if ((!r106.isEmpty()) == false) goto L17;
            r101.f41807h = cd.a.a(r106);
        L17:
            kc.a.C6534a.C6535a r109 = r100.f502360g;
            if (r109 == null) goto L32;
            BcmParams r110 = r109.f502362b;
            if (r110 == null) goto L32;
            Map<String, Object> r111 = r110.toMap();
            if (r111 == null) goto L32;
            LinkedHashMap r112 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r113 = r111.entrySet().iterator();
        L25:
            if (r113.hasNext() == false) goto L30;
            Map.Entry<String, Object> r114 = r113.next();
            if (r102.contains(r114.getKey()) == false) goto L25;
            r112.put(r114.getKey(), r114.getValue());
            goto L25
        L30:
            if ((!r112.isEmpty()) == false) goto L32;
            r101.f41808i = cd.a.a(r112);
        L32:
            return r101;
        }
    }

    static {
    }

    @Override // kc.a.C6534a
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("btm", this.f502356c);     // Catch: Throwable -> L13
        r100.put("btm_show_id", this.f502358e);     // Catch: Throwable -> L13
        if (this.f41807h == null) goto L6;
    L7:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L13
        r101.put("page", this.f41807h);     // Catch: Throwable -> L12
        r101.put(Scraps.INNER_UNIT, this.f41808i);     // Catch: Throwable -> L12
    L9:
        r100.put("content", r101);     // Catch: Throwable -> L13
    L10:
        r100.put("jump_with_token", this.f502359f);     // Catch: Throwable -> L13
        goto L11
    L6:
        if (this.f41808i == null) goto L10;
    L11:
        return r100;
    }

    public b() {
    }
}
