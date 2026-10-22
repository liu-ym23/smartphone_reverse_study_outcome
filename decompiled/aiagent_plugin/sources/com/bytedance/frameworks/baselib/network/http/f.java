package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeRequestInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String TAG = "NativeRequestInterceptor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8305a;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: NativeRequestInterceptor.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8306a = null;

        static {
            int[] r0 = new int[b.values().length];
            f8306a = r0;
            r0[b.f8308b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f8306a[b.f8309c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f8306a[b.f8310d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: compiled from: NativeRequestInterceptor.java */
    public interface a {
        c a(String r1, Map<String, String> r2, List<String> r3);

        d a(String r1, Map<String, List<String>> r2, int r3);
    }

    /* JADX INFO: compiled from: NativeRequestInterceptor.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8307a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f8308b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f8309c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f8310d = null;
        private static final /* synthetic */ b[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f8311e;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("NOT_MODIFIED", 0, 0);
            f8307a = r0;
            b r1 = new b("URL_MODIFIED", 1, 1);
            f8308b = r1;
            b r3 = new b("HEADER_MODIFIED", 2, 2);
            f8309c = r3;
            b r5 = new b("BOTH_MODIFIED", 3, 3);
            f8310d = r5;
            f = new b[]{r0, r1, r3, r5};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f8311e = r3;
        }

        public int a() {
            return this.f8311e;
        }
    }

    /* JADX INFO: compiled from: NativeRequestInterceptor.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f8312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f8313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, String> f8314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Set<String> f8315d;

        public String a() {
            JSONObject r0 = new JSONObject();
            int r1 = AnonymousClass1.f8306a[this.f8312a.ordinal()];     // Catch: JSONException -> L16
            if (r1 != 1) goto L7;
            r0.put("modified", b.f8308b.a());     // Catch: JSONException -> L16
            a(r0, this.f8313b);     // Catch: JSONException -> L16
        L17:
            goto L15
        L7:
            if (r1 != 2) goto L9;
            r0.put("modified", b.f8309c.a());     // Catch: JSONException -> L16
            a(r0, this.f8314c, this.f8315d);     // Catch: JSONException -> L16
            goto L17
        L9:
            if (r1 != 3) goto L17;
            r0.put("modified", b.f8310d.a());     // Catch: JSONException -> L16
            a(r0, this.f8313b);     // Catch: JSONException -> L16
            a(r0, this.f8314c, this.f8315d);     // Catch: JSONException -> L16
        L15:
            return r0.toString();
        }

        private static void a(JSONObject r1, String r2) {
            if (TextUtils.isEmpty(r2) == false) goto L8;
            return;
        L8:
            new URI(r2);     // Catch: Exception -> L7
            r1.put("new_url", r2);     // Catch: Exception -> L7
            return;
        }

        private static void a(JSONObject r4, Map<String, String> r5, Set<String> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L9;
            JSONArray r0 = new JSONArray();
            Iterator r9 = r8.iterator();
        L6:
            if (r9.hasNext() == false) goto L8;
            r0.put((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin"));
            goto L6
        L8:
            r4.put("removed_headers", r0);
        L9:
            if (r7 != null) goto L11;
            return;
        L11:
            JSONObject r10 = new JSONObject();
            Iterator r11 = r7.entrySet().iterator();
        L13:
            if (r11.hasNext() == false) goto L18;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            if (((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L13;
            r10.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());
            goto L13
        L18:
            r4.put("new_headers", r10);
        }
    }

    /* JADX INFO: compiled from: NativeRequestInterceptor.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f8316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<String> f8317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, List<String>> f8318c;

        public String a() {
            if (this.f8316a == b.f8309c) goto L7;
            if (this.f8316a == b.f8310d) goto L7;
            return null;
        L7:
            if (this.f8318c == null) goto L9;
        L12:
            JSONObject r0 = new JSONObject();
            r0.put("modified", this.f8316a.a());     // Catch: JSONException -> L25
            Map<String, List<String>> r1 = this.f8318c;     // Catch: JSONException -> L25
            if (r1 == null) goto L17;
            r0.put("new_headers", a(r1));     // Catch: JSONException -> L25
        L17:
            if (this.f8317b == null) goto L24;
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L25
            Iterator<String> r5 = this.f8317b.iterator();     // Catch: JSONException -> L25
        L20:
            if (r5.hasNext() == false) goto L22;
            r2.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L25
            goto L20
        L22:
            r0.put("removed_headers", r2);     // Catch: JSONException -> L25
        L24:
            return r0.toString();
        L9:
            if (this.f8317b != null) goto L12;
            return null;
        }

        private static JSONObject a(Map<String, List<String>> r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L5;
            return null;
        L5:
            if (r8.isEmpty() == true) goto L26;
            JSONObject r0 = new JSONObject();
            Iterator r9 = r8.entrySet().iterator();
        L9:
            if (r9.hasNext() == false) goto L17;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            JSONArray r3 = new JSONArray();
            Iterator r4 = ((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
        L12:
            if (r4.hasNext() == false) goto L16;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty(r5) == true) goto L12;
            r3.put(r5);
            goto L12
        L16:
            r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r3);
            goto L9
        L17:
            return r0;
        L26:
            return null;
        }
    }

    public static String a(String r4, Map<String, String> r5, List<String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        if (f8305a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "request url:" + r4 + " headers:" + r7.toString() + " domains:" + r8);
    L8:
        c r9 = f8305a.a(r4, r7, r8);
        if (r9 != null) goto L11;
        return null;
    L11:
        String r10 = r9.a();
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "request json:" + r10);
    L14:
        return r10;
    }

    public static String a(String r4, Map<String, List<String>> r5, int r6) {
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (f8305a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "response url:" + r4 + " headers:" + r7.toString() + " code:" + r6);
    L8:
        d r8 = f8305a.a(r4, r7, r6);
        if (r8 != null) goto L11;
        return null;
    L11:
        String r9 = r8.a();
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "response json:" + r9);
    L14:
        return r9;
    }
}
