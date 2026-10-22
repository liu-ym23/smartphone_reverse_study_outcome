package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm6.service.tob.IReportDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.h;

/* JADX INFO: loaded from: classes.dex */
interface UploadLogInfo {

    public static class a implements UploadLogInfo {
        public a() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "exception";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List getUrls() {
            return com.bytedance.apm6.consumer.slardar.send.b.e().d();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap r10) {
            JSONObject r11 = new JSONObject();     // Catch: Exception -> L14
            JSONArray r12 = new JSONArray();     // Catch: Exception -> L14
            Iterator r13 = r10.keySet().iterator();     // Catch: Exception -> L14
        L4:
            if (r13.hasNext() == false) goto L12;
            JSONArray r14 = (JSONArray) r10.get((Long) r13.next());     // Catch: Exception -> L14
            if (r14 == null) goto L4;
            int r15 = 0;
        L10:
            if (r15 >= r14.length()) goto L4;
            r12.put(r14.get(r15));     // Catch: Exception -> L14
            r15 = r15 + 1;     // Catch: Exception -> L14
            goto L10
        L12:
            r11.put("header", p2.d.d(p2.b.f().e(String.valueOf(p2.d.c()))));     // Catch: Exception -> L14
            r11.put("data", r12);     // Catch: Exception -> L14
            return h.b(r11.toString());
        L14:
            return null;
        }
    }

    public static class b implements UploadLogInfo {
        public b() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "log";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List getUrls() {
            return com.bytedance.apm6.consumer.slardar.send.b.e().f();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap r10) {
            JSONArray r11 = new JSONArray();     // Catch: Exception -> L27
            Iterator r12 = r10.keySet().iterator();     // Catch: Exception -> L27
        L5:
            if (r12.hasNext() == false) goto L12;
            Long r13 = (Long) r12.next();     // Catch: Exception -> L27
            p2.a r14 = p2.b.f().e(String.valueOf(r13));     // Catch: Exception -> L27
            if (r14 == null) goto L9;
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L27
            r15.put("data", r10.get(r13));     // Catch: Exception -> L27
            r15.put("header", p2.d.d(r14));     // Catch: Exception -> L27
            r11.put(r15);     // Catch: Exception -> L27
            goto L5
        L9:
            if (r3.a.c() == false) goto L5;
            s3.a.f(n2.a.f22354a, "HeaderInfo null for key " + r13);     // Catch: Exception -> L27
            goto L5
        L12:
            JSONArray r16 = DropDataMonitor.b().c();     // Catch: Exception -> L27
            if (r16 != null) goto L15;
        L19:
            JSONObject r17 = new JSONObject();     // Catch: Exception -> L27
            r17.put(ServerElements.LIST, r11);     // Catch: Exception -> L27
            if (r3.a.c() == false) goto L22;
            s3.a.a(n2.a.f22354a, "request:" + r17);     // Catch: Exception -> L27
        L22:
            IReportDataService r18 = (IReportDataService) o3.a.a(IReportDataService.class);     // Catch: Exception -> L27
            if (r18 == null) goto L25;
            r17 = r18.changeReportData(r17);     // Catch: Exception -> L27
        L25:
            return h.b(r17.toString());
        L15:
            if (r16.length() <= 0) goto L19;
            p2.a r19 = p2.b.f().e(String.valueOf(p2.d.c()));     // Catch: Exception -> L27
            if (r19 == null) goto L19;
            JSONObject r20 = new JSONObject();     // Catch: Exception -> L27
            r20.put("data", r16);     // Catch: Exception -> L27
            r20.put("header", p2.d.d(r19));     // Catch: Exception -> L27
            r11.put(r20);     // Catch: Exception -> L27
        L27:
            return null;
        }
    }

    public static class c implements UploadLogInfo {
        public c() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return TraceStatsConsts.STATS_KEY_TRACE;
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List getUrls() {
            return com.bytedance.apm6.consumer.slardar.send.b.e().h();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap r10) {
            JSONObject r11 = new JSONObject();     // Catch: Exception -> L29
            JSONArray r12 = new JSONArray();     // Catch: Exception -> L29
            Iterator r13 = r10.keySet().iterator();     // Catch: Exception -> L29
        L4:
            if (r13.hasNext() == false) goto L25;
            JSONArray r14 = (JSONArray) r10.get((Long) r13.next());     // Catch: Exception -> L29
            if (r14 == null) goto L4;
            int r15 = 0;
        L10:
            if (r15 >= r14.length()) goto L4;
            List r16 = r3.b.a(r14.getJSONObject(r15));     // Catch: Exception -> L21
            if (ListUtils.b(r16) == true) goto L23;
            Iterator r17 = r16.iterator();     // Catch: Exception -> L21
        L16:
            if (r17.hasNext() == false) goto L23;
            Object r18 = r17.next();     // Catch: Exception -> L21
            r12.put(r18);     // Catch: Exception -> L21
            if (r3.a.c() == false) goto L16;
            s3.a.a(n2.a.f22354a, ":" + r18);     // Catch: Exception -> L21
        L23:
            r15 = r15 + 1;     // Catch: Exception -> L29
        L21:
            e = move-exception;
            s3.a.c(n2.a.f22354a, "serialize", e);     // Catch: Exception -> L29
            goto L23
        L25:
            if (r3.a.c() == false) goto L27;
            s3.a.a(n2.a.f22354a, "jsonArray:" + r12);     // Catch: Exception -> L29
        L27:
            r11.put("header", p2.d.d(p2.b.f().e(String.valueOf(p2.d.c()))));     // Catch: Exception -> L29
            r11.put("data", r12);     // Catch: Exception -> L29
            return h.b(r11.toString());
        L29:
            return null;
        }
    }

    String getName();

    List<String> getUrls();

    byte[] serialize(HashMap<Long, JSONArray> r10);
}
