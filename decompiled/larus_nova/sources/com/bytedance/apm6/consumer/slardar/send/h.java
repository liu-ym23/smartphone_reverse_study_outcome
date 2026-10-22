package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface h {

    public static class a implements h {
        public a() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final String getName() {
            return com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final List<String> getUrls() {
            d r100 = d.a.f190725a;
            nt3.a r101 = r100.f190723l;
            if (r101 == null) goto L8;
            if (xu3.e.b(r101.f520478c) == true) goto L8;
            return r100.f190723l.f520478c;
        L8:
            return r100.f190719h;
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final byte[] a(HashMap<Long, JSONArray> r100) {
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L14
            JSONArray r102 = new JSONArray();     // Catch: Exception -> L14
            Iterator<Long> r103 = r100.keySet().iterator();     // Catch: Exception -> L14
        L4:
            if (r103.hasNext() == false) goto L12;
            JSONArray r104 = r100.get(r103.next());     // Catch: Exception -> L14
            if (r104 == null) goto L4;
            int r105 = 0;
        L10:
            if (r105 >= r104.length()) goto L4;
            r102.put(r104.get(r105));     // Catch: Exception -> L14
            r105 = r105 + 1;     // Catch: Exception -> L14
            goto L10
        L12:
            r101.put("header", ot3.e.b(ot3.b.b().a(String.valueOf(ot3.e.a()))));     // Catch: Exception -> L14
            r101.put("data", r102);     // Catch: Exception -> L14
            return xu3.g.a(r101.toString());
        L14:
            return null;
        }
    }

    public static class b implements h {
        public b() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final String getName() {
            return "log";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final List<String> getUrls() {
            d r100 = d.a.f190725a;
            nt3.a r101 = r100.f190723l;
            if (r101 == null) goto L8;
            if (xu3.e.b(r101.f520477b) == true) goto L8;
            return r100.f190723l.f520477b;
        L8:
            return r100.f190717f;
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final byte[] a(HashMap<Long, JSONArray> r100) {
            JSONArray r101 = new JSONArray();     // Catch: Exception -> L27
            Iterator<Long> r102 = r100.keySet().iterator();     // Catch: Exception -> L27
        L5:
            if (r102.hasNext() == false) goto L14;
            Long r103 = r102.next();     // Catch: Exception -> L27
            ot3.a r104 = ot3.b.b().a(String.valueOf(r103));     // Catch: Exception -> L27
            if (r104 == null) goto L9;
            JSONObject r105 = new JSONObject();     // Catch: Exception -> L27
            r105.put("data", r100.get(r103));     // Catch: Exception -> L27
            r105.put("header", ot3.e.b(r104));     // Catch: Exception -> L27
            r101.put(r105);     // Catch: Exception -> L27
            goto L5
        L9:
            if (xu3.a.a() == false) goto L5;
            List<String> r106 = mt3.a.f515607a;     // Catch: Exception -> L27
            av3.a r107 = av3.b.f16366a;     // Catch: Exception -> L27
            if (r107 == null) goto L5;
            r107.a();     // Catch: Exception -> L27
            goto L5
        L14:
            JSONArray r108 = DropDataMonitor.a.f190700a.b();     // Catch: Exception -> L27
            if (r108.length() <= 0) goto L19;
            ot3.a r109 = ot3.b.b().a(String.valueOf(ot3.e.a()));     // Catch: Exception -> L27
            if (r109 == null) goto L19;
            JSONObject r110 = new JSONObject();     // Catch: Exception -> L27
            r110.put("data", r108);     // Catch: Exception -> L27
            r110.put("header", ot3.e.b(r109));     // Catch: Exception -> L27
            r101.put(r110);     // Catch: Exception -> L27
        L19:
            JSONObject r111 = new JSONObject();     // Catch: Exception -> L27
            r111.put("list", r101);     // Catch: Exception -> L27
            if (xu3.a.a() == false) goto L22;
            List<String> r112 = mt3.a.f515607a;     // Catch: Exception -> L27
            av3.b.a("APM-Slardar", "request:" + r111);     // Catch: Exception -> L27
        L22:
            wu3.a r113 = (wu3.a) qu3.c.a(wu3.a.class);     // Catch: Exception -> L27
            if (r113 == null) goto L25;
            r111 = r113.a();     // Catch: Exception -> L27
        L25:
            return xu3.g.a(r111.toString());
        L27:
            return null;
        }
    }

    public static class c implements h {
        public c() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final String getName() {
            return "trace";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final List<String> getUrls() {
            d r100 = d.a.f190725a;
            nt3.a r101 = r100.f190723l;
            if (r101 == null) goto L8;
            if (xu3.e.b(r101.f520479d) == true) goto L8;
            return r100.f190723l.f520479d;
        L8:
            return r100.f190718g;
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.h
        public final byte[] a(HashMap<Long, JSONArray> r110) {
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L45
            JSONArray r101 = new JSONArray();     // Catch: Exception -> L45
            Iterator<Long> r102 = r110.keySet().iterator();     // Catch: Exception -> L45
        L6:
            if (r102.hasNext() == false) goto L41;
            JSONArray r103 = r110.get(r102.next());     // Catch: Exception -> L45
            if (r103 == null) goto L6;
            int r104 = 0;
        L12:
            if (r104 >= r103.length()) goto L6;
            JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r103, r104);     // Catch: Exception -> L37
            if (r105 != null) goto L16;
        L15:
            ArrayList r106 = null;
        L28:
            if (xu3.e.b(r106) == true) goto L39;
            Iterator r107 = r106.iterator();     // Catch: Exception -> L37
        L32:
            if (r107.hasNext() == false) goto L39;
            Object r108 = r107.next();     // Catch: Exception -> L37
            r101.put(r108);     // Catch: Exception -> L37
            if (xu3.a.a() == false) goto L32;
            List<String> r111 = mt3.a.f515607a;     // Catch: Exception -> L37
            av3.b.a("APM-Slardar", ":" + r108);     // Catch: Exception -> L37
        L39:
            r104 = r104 + 1;     // Catch: Exception -> L45
            goto L12
        L16:
            r106 = new ArrayList();     // Catch: Exception -> L37
            if (r105.optInt("wrapper_type_description", -1) == 1) goto L19;
            r106.add(r105);     // Catch: Exception -> L37
            goto L28
        L19:
            JSONArray r109 = r105.optJSONArray("wrapper_array_data");     // Catch: Exception -> L37
            if (r109 == null) goto L15;
            int r112 = 0;
        L24:
            if (r112 >= r109.length()) goto L28;
            r106.add(r109.get(r112));     // Catch: Exception -> L46
        L26:
            r112 = r112 + 1;
            goto L24
        L37:
            e = move-exception;
            List<String> r113 = mt3.a.f515607a;     // Catch: Exception -> L45
            av3.b.c("APM-Slardar", "serialize", e);     // Catch: Exception -> L45
            goto L39
        L41:
            if (xu3.a.a() == false) goto L43;
            List<String> r114 = mt3.a.f515607a;     // Catch: Exception -> L45
            av3.b.a("APM-Slardar", "jsonArray:" + r101);     // Catch: Exception -> L45
        L43:
            r100.put("header", ot3.e.b(ot3.b.b().a(String.valueOf(ot3.e.a()))));     // Catch: Exception -> L45
            r100.put("data", r101);     // Catch: Exception -> L45
            return xu3.g.a(r100.toString());
        L45:
            return null;
        }
    }

    byte[] a(HashMap<Long, JSONArray> r100);

    String getName();

    List<String> getUrls();
}
