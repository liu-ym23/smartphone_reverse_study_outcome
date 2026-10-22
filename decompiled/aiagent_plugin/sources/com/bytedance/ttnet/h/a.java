package com.bytedance.ttnet.h;

import android.os.Build;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CronetJavaInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "CronetJavaInterceptor";

    /* JADX INFO: renamed from: com.bytedance.ttnet.h.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: CronetJavaInterceptor.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.ttnet.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CronetJavaInterceptor.java */
    private static final class C0259a implements e<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.retrofit2.b.c f11494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11496c;

        /* synthetic */ C0259a(com.bytedance.retrofit2.b.c r1, AnonymousClass1 r2) {
            this(r1);
        }

        public /* synthetic */ Object clone() {
            return d();
        }

        private C0259a(com.bytedance.retrofit2.b.c r1) {
            this.f11494a = r1;
        }

        @Override // com.bytedance.retrofit2.e
        public ak<Object> a() {
            this.f11495b = true;
            return ak.a(null, new com.bytedance.retrofit2.b.d(this.f11494a.b(), 200, "Synthetic Call", Collections.emptyList(), null));
        }

        @Override // com.bytedance.retrofit2.e
        public void a(h<Object> r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            this.f11495b = true;
            if (r4 != null) goto L10;
            return;
        L10:
            r4.a(this, a());     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            r4.a(this, th);
        }

        @Override // com.bytedance.retrofit2.e
        public void b() {
            this.f11496c = true;
        }

        @Override // com.bytedance.retrofit2.e
        public boolean c() {
            return this.f11496c;
        }

        @Override // com.bytedance.retrofit2.e
        public e<Object> d() {
            return new C0259a(this.f11494a);
        }

        @Override // com.bytedance.retrofit2.e
        public com.bytedance.retrofit2.b.c e() {
            return this.f11494a;
        }
    }

    /* JADX INFO: compiled from: CronetJavaInterceptor.java */
    private static final class b implements com.bytedance.retrofit2.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.retrofit2.b.c f11497a;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ com.bytedance.retrofit2.b.c a(b r0) {
            return r0.a();
        }

        @Override // com.bytedance.retrofit2.d.b
        public ak a(com.bytedance.retrofit2.d.b.a r9) {
            com.bytedance.retrofit2.b.c r10 = ((com.bytedance.retrofit2.d.b.a) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.retrofit2.d.b.a.class, "com.obric.aiagent.plugin")).a();
            if (r10 == null) goto L5;
            this.f11497a = r10;
            af r1 = r10.p();
            if (r1 == null) goto L10;
            r1.Z();
            r1.c();
            r1.X();
            r1.Y();
            r1.b(this);
            r1.aE.j.f9424a = true;
        L10:
            return ak.a(null, new com.bytedance.retrofit2.b.d(r10.b(), 200, "Synthetic Interceptor Merge", Collections.emptyList(), null));
        L5:
            return ak.a(null, new com.bytedance.retrofit2.b.d("", 200, "Synthetic Interceptor Merge", Collections.emptyList(), null));
        }

        private com.bytedance.retrofit2.b.c a() {
            return this.f11497a;
        }
    }

    private static String b(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public static String a(String r10, Map<String, String> r11) {
        Map<String, String> r12 = d((Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin"));
        com.bytedance.retrofit2.b.c r0 = b(r10, r12);
        if (r0 != null) goto L5;
        r0 = a(r10, r12, false);
    L5:
        Map<String, String> r13 = a(r0);
        String r1 = b(r0.b());
        Map<String, String> r2 = e(r12);
        Map<String, String> r3 = e(r13);
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin");
        String r8 = a(r7);
        String r9 = b((String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.aiagent.plugin"));
        if (r2.containsKey(r8) == false) goto L10;
        if (b((String) ZeusTransformUtils.preCheckCast(r2.get(r8), String.class, "com.obric.aiagent.plugin")).equals(r9) == true) goto L7;
        r4.put(r7, r9);
        goto L7
    L10:
        r4.put(r7, r9);
        goto L7
    L14:
        Iterator<Map.Entry<String, String>> r15 = r12.entrySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L21;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r3.containsKey(a((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r5.put((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.aiagent.plugin"), b((String) ZeusTransformUtils.preCheckCast(r16.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L16
    L21:
        if (r12.get("x-ttnet-intcp-merge-feature") == null) goto L23;
        r5.put("x-ttnet-intcp-merge-feature", "");
    L23:
        JSONObject r17 = new JSONObject();
        r17.put("url", r1);
        r17.put("addHeaders", f(r4));
        r17.put("deleteHeaders", f(r5));
        return r17.toString();
    }

    private static boolean a(Map<String, String> r2) {
        String r3 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).get("x-ttnet-intcp-merge-feature"), String.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if ("1".equals(r3) == false) goto L7;
    L8:
        return true;
    L7:
        if ("2".equals(r3) == false) goto L9;
        goto L8
    }

    private static boolean b(Map<String, String> r2) {
        String r3 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).get("x-ttnet-intcp-merge-feature"), String.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if ("2".equals(r3) == false) goto L7;
        return true;
    }

    private static com.bytedance.retrofit2.b.c b(String r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        boolean r0 = a(r7);
        com.bytedance.retrofit2.b.c r8 = a(r5, r7, b(r7));
        List<com.bytedance.retrofit2.d.b> r9 = com.bytedance.ttnet.utils.d.c(r5);
        if (r9 != null) goto L5;
    L31:
        return r8;
    L5:
        if (r9.isEmpty() == true) goto L31;
        ArrayList r2 = new ArrayList(r9.size() + 1);
        Iterator<com.bytedance.retrofit2.d.b> r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L19;
        com.bytedance.retrofit2.d.b r3 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.retrofit2.d.a.class) == false) goto L15;
        if (((com.bytedance.retrofit2.d.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.d.a.class, "com.obric.aiagent.plugin")).b() == false) goto L15;
        r2.add(r3);
    L15:
        if (r0 == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.retrofit2.f.b.class) == false) goto L9;
        r2.add(r3);
        goto L9
    L19:
        AnonymousClass1 r1 = null;
        b r11 = new b(r1);
        r2.add(r11);
        com.bytedance.retrofit2.d.c r4 = new com.bytedance.retrofit2.d.c(r2, 0, r8, new C0259a(r8, r1));     // Catch: Throwable -> L28
        if (com.bytedance.retrofit2.d.c.b() == false) goto L23;
        r4.b(r8);     // Catch: Throwable -> L28
    L24:
        com.bytedance.retrofit2.b.c r12 = b.a(r11);
        if (r12 != null) goto L27;
        return r8;
    L27:
        return r12;
    L23:
        r4.a(r8);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw new com.bytedance.ttnet.h.b("Java interceptor execution failed.", th);
    }

    private static com.bytedance.retrofit2.b.c a(String r2, Map<String, String> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.b.c.a r6 = new com.bytedance.retrofit2.b.c.a().a().a(b(r2)).a(r4).a(String.class, "ttnet-intcp-native-flag");
        r6.a(c(r5));
        com.bytedance.retrofit2.b.c r7 = r6.b();
        af r8 = new af();
        r8.a(true);
        r8.d();
        r8.b(false);
        r8.e();
        r7.a(r8);
        return r7;
    }

    private static List<com.bytedance.retrofit2.b.b> c(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        if (r7 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r7.isEmpty() == true) goto L14;
        Iterator r8 = r7.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r2.getKey() == null) goto L9;
        r0.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"))));
        goto L9
    }

    private static Map<String, String> d(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L14;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r2.getKey() == null) goto L9;
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L9
    }

    private static Map<String, String> a(com.bytedance.retrofit2.b.c r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 != null) goto L5;
    L16:
        return r0;
    L5:
        if (r4.c() == null) goto L16;
        Iterator<com.bytedance.retrofit2.b.b> r5 = r4.c().iterator();
    L9:
        if (r5.hasNext() == false) goto L16;
        com.bytedance.retrofit2.b.b r1 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        if (r1.a() == null) goto L9;
        r0.put(r1.a(), b(r1.b()));
        goto L9
    }

    private static Map<String, String> e(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L14;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"));
        if (r3.length() == 0) goto L9;
        r0.put(r3, b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L9
    }

    private static String a(String r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        if (Build.VERSION.SDK_INT < 9) goto L9;
        return r2.toLowerCase(Locale.ROOT);
    L9:
        return r2.toLowerCase(Locale.US);
    }

    private static JSONObject f(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        JSONObject r0 = new JSONObject();
        if (r6 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L14;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r2.getKey() == null) goto L9;
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L9
    }
}
