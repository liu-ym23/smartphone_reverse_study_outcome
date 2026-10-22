package com.bytedance.apm6.consumer.slardar.d;

import com.bytedance.apm6.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UploadLogInfo.java */
/* JADX INFO: loaded from: classes.dex */
interface f {

    /* JADX INFO: compiled from: UploadLogInfo.java */
    public static class a implements f {
        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public String a() {
            return "exception";
        }

        public a() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public List<String> b() {
            return com.bytedance.apm6.consumer.slardar.d.c.a().k();
        }

        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public byte[] a(HashMap<Long, JSONArray> r7) {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L15
            JSONArray r1 = new JSONArray();     // Catch: Exception -> L15
            Iterator<Long> r2 = r7.keySet().iterator();     // Catch: Exception -> L15
        L5:
            if (r2.hasNext() == false) goto L13;
            JSONArray r3 = (JSONArray) ZeusTransformUtils.preCheckCast(r7.get((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.aiagent.plugin")), JSONArray.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
            if (r3 == null) goto L5;
            int r4 = 0;
        L11:
            if (r4 >= r3.length()) goto L5;
            r1.put(r3.get(r4));     // Catch: Exception -> L15
            r4 = r4 + 1;     // Catch: Exception -> L15
            goto L11
        L13:
            r0.put("header", com.bytedance.apm6.consumer.slardar.b.d.a(com.bytedance.apm6.consumer.slardar.b.b.a().a(String.valueOf(com.bytedance.apm6.consumer.slardar.b.d.a()))));     // Catch: Exception -> L15
            r0.put("data", r1);     // Catch: Exception -> L15
            return i.a(r0.toString());
        L15:
            return null;
        }
    }

    /* JADX INFO: compiled from: UploadLogInfo.java */
    public static class b implements f {
        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public String a() {
            return "log";
        }

        public b() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public List<String> b() {
            return com.bytedance.apm6.consumer.slardar.d.c.a().i();
        }

        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public byte[] a(HashMap<Long, JSONArray> r8) {
            JSONArray r7 = new JSONArray();     // Catch: Exception -> L27
            Iterator<Long> r0 = r8.keySet().iterator();     // Catch: Exception -> L27
        L5:
            if (r0.hasNext() == false) goto L12;
            Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
            com.bytedance.apm6.consumer.slardar.b.a r4 = com.bytedance.apm6.consumer.slardar.b.b.a().a(String.valueOf(r1));     // Catch: Exception -> L27
            if (r4 == null) goto L9;
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L27
            r5.put("data", r8.get(r1));     // Catch: Exception -> L27
            r5.put("header", com.bytedance.apm6.consumer.slardar.b.d.a(r4));     // Catch: Exception -> L27
            r7.put(r5);     // Catch: Exception -> L27
            goto L5
        L9:
            if (com.bytedance.apm6.foundation.context.a.u() == false) goto L5;
            com.bytedance.apm6.util.c.b.c(com.bytedance.apm6.consumer.slardar.a.f5054a, "HeaderInfo null for key " + r1);     // Catch: Exception -> L27
            goto L5
        L12:
            JSONArray r9 = com.bytedance.apm6.consumer.slardar.d.b.a().b();     // Catch: Exception -> L27
            if (r9 != null) goto L15;
        L19:
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L27
            r10.put("list", r7);     // Catch: Exception -> L27
            if (com.bytedance.apm6.foundation.context.a.u() == false) goto L22;
            com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "request:" + r10);     // Catch: Exception -> L27
        L22:
            com.bytedance.apm6.service.f.a r11 = (com.bytedance.apm6.service.f.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.f.a.class), com.bytedance.apm6.service.f.a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
            if (r11 == null) goto L25;
            r10 = r11.a(r10);     // Catch: Exception -> L27
        L25:
            return i.a(r10.toString());
        L15:
            if (r9.length() <= 0) goto L19;
            com.bytedance.apm6.consumer.slardar.b.a r2 = com.bytedance.apm6.consumer.slardar.b.b.a().a(String.valueOf(com.bytedance.apm6.consumer.slardar.b.d.a()));     // Catch: Exception -> L27
            if (r2 == null) goto L19;
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L27
            r3.put("data", r9);     // Catch: Exception -> L27
            r3.put("header", com.bytedance.apm6.consumer.slardar.b.d.a(r2));     // Catch: Exception -> L27
            r7.put(r3);     // Catch: Exception -> L27
        L27:
            return null;
        }
    }

    /* JADX INFO: compiled from: UploadLogInfo.java */
    public static class c implements f {
        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public String a() {
            return "trace";
        }

        public c() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public List<String> b() {
            return com.bytedance.apm6.consumer.slardar.d.c.a().j();
        }

        @Override // com.bytedance.apm6.consumer.slardar.d.f
        public byte[] a(HashMap<Long, JSONArray> r11) {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L30
            JSONArray r1 = new JSONArray();     // Catch: Exception -> L30
            Iterator<Long> r2 = r11.keySet().iterator();     // Catch: Exception -> L30
        L5:
            if (r2.hasNext() == false) goto L26;
            JSONArray r3 = (JSONArray) ZeusTransformUtils.preCheckCast(r11.get((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.aiagent.plugin")), JSONArray.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
            if (r3 == null) goto L5;
            int r4 = 0;
        L11:
            if (r4 >= r3.length()) goto L5;
            List<Object> r5 = com.bytedance.apm6.util.b.a(r3.getJSONObject(r4));     // Catch: Exception -> L22
            if (com.bytedance.apm6.util.f.a(r5) == true) goto L24;
            Iterator<Object> r6 = r5.iterator();     // Catch: Exception -> L22
        L17:
            if (r6.hasNext() == false) goto L24;
            Object r7 = r6.next();     // Catch: Exception -> L22
            r1.put(r7);     // Catch: Exception -> L22
            if (com.bytedance.apm6.foundation.context.a.u() == false) goto L17;
            com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, ":" + r7);     // Catch: Exception -> L22
        L24:
            r4 = r4 + 1;     // Catch: Exception -> L30
        L22:
            e = move-exception;
            com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "serialize", e);     // Catch: Exception -> L30
            goto L24
        L26:
            if (com.bytedance.apm6.foundation.context.a.u() == false) goto L28;
            com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "jsonArray:" + r1);     // Catch: Exception -> L30
        L28:
            r0.put("header", com.bytedance.apm6.consumer.slardar.b.d.a(com.bytedance.apm6.consumer.slardar.b.b.a().a(String.valueOf(com.bytedance.apm6.consumer.slardar.b.d.a()))));     // Catch: Exception -> L30
            r0.put("data", r1);     // Catch: Exception -> L30
            return i.a(r0.toString());
        L30:
            return null;
        }
    }

    String a();

    byte[] a(HashMap<Long, JSONArray> r1);

    List<String> b();
}
