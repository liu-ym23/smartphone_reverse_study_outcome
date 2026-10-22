package com.bytedance.dataplatform;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExperimentCache.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    private static volatile String h;
    private static volatile byte[] i;
    private static Map<String, String> l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f7920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Integer> f7921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, Object> f7922e;
    private j f;
    private i g;
    private f j;
    private Future k;
    private final Map<String, Runnable> m;

    static /* synthetic */ void a(c r0) {
        r0.a();
    }

    static /* synthetic */ f b(c r0) {
        return r0.j;
    }

    static {
        i = new byte[0];
        l = new ConcurrentHashMap();
    }

    private int c(String r4) {
        if (i.length <= 1) goto L15;
        if (b.f7905b.a(r4) == false) goto L15;
        int r3 = l.a(a(i, l.a(r4)));     // Catch: Exception -> L12
        if (r3 < 0) goto L10;
        if (r3 >= 1000) goto L10;
        return r3;
    L10:
        return ((r3 % 1000) + 1000) % 1000;
    L13:
        return new Random().nextInt(1000);
    L15:
        return new Random().nextInt(1000);
    }

    private byte[] a(byte[] r3, byte[] r4) {
        byte[] r2 = new byte[r3.length + r4.length];
        System.arraycopy(r3, 0, r2, 0, r3.length);
        System.arraycopy(r4, 0, r2, r3.length, r4.length);
        return r2;
    }

    private void a() {
        StringBuilder r4 = new StringBuilder(this.f7918a);     // Catch: Exception -> L28
        if (l.isEmpty() == false) goto L7;
    L18:
        JSONObject r3 = new JSONObject(this.g.a(r4.toString()));     // Catch: Exception -> L28
        if (r3.has(MonitorConstants.CODE) == true) goto L21;
        return;
    L21:
        if (r3.has("data") == true) goto L24;
        return;
    L24:
        if (r3.optInt(MonitorConstants.CODE, -1) == 0) goto L26;
        return;
    L26:
        a(r3.getJSONObject("data"));     // Catch: Exception -> L28
        return;
    L7:
        if (this.f7918a.indexOf(63) >= 0) goto L9;
        r4.append("?");     // Catch: Exception -> L28
    L10:
        boolean r5 = true;
        Iterator<Map.Entry<String, String>> r7 = l.entrySet().iterator();     // Catch: Exception -> L28
    L12:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r5 == false) goto L16;
        r5 = false;
    L17:
        r4.append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin"), "UTF-8")).append("=").append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.aiagent.plugin"), "UTF-8"));     // Catch: Exception -> L28
        goto L12
    L16:
        r4.append("&");     // Catch: Exception -> L28
        goto L17
    L9:
        r4.append("&");     // Catch: Exception -> L28
    }

    synchronized void a(Map<String, String> r5) {
        monitor-enter(this);
        Map<? extends String, ? extends String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Future r0 = this.k;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.cancel(true);     // Catch: Throwable -> L11
    L6:
        if (r6 == null) goto L8;
        l.putAll(r6);     // Catch: Throwable -> L11
    L8:
        this.k = m.a(new AnonymousClass1(this), 0, DownloadConstants.HOUR);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void a(JSONObject r10) {
        JSONObject r0 = new JSONObject();
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        Iterator<String> r3 = r10.keys();
    L4:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        JSONObject r5 = r10.getJSONObject(r4);     // Catch: JSONException -> L15
        r0.put(r4, r5.get("val"));     // Catch: JSONException -> L15
        String r6 = r5.getString("vid");     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r6) == true) goto L4;
        r1.put(r4, r6);     // Catch: JSONException -> L15
        long r7 = r5.getLong("et");     // Catch: JSONException -> L15
        if (r7 <= 0) goto L4;
        r2.put(r6, Long.valueOf(r7));     // Catch: JSONException -> L15
        goto L4
    L13:
        this.f7922e.clear();
        this.f7920c = r0;
        a.a(this.f7919b, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_CACHE", r0);
        this.j.a(r1, r2);
    }

    <T> T a(final String r3, Type r4, T r5, boolean r6, final boolean r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        if (r8 != Boolean.class) goto L5;
    L39:
        T r9 = (T) a(r3, (Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin"));
    L40:
        Runnable r10 = new AnonymousClass2(this, r3, r7);
        if (r6 == false) goto L43;
        r10.run();
    L44:
        return r9;
    L43:
        this.m.put(r3, r10);
        goto L44
    L5:
        if (r8 == Boolean.TYPE) goto L39;
        if (r8 != Integer.class) goto L10;
    L38:
        r9 = (T) a(r3, (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin"));
        goto L40
    L10:
        if (r8 == Short.class) goto L38;
        if (r8 == Integer.TYPE) goto L38;
        if (r8 == Short.TYPE) goto L38;
        if (r8 != Float.class) goto L19;
    L37:
        r9 = (T) a(r3, (Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.aiagent.plugin"));
        goto L40
    L19:
        if (r8 == Float.TYPE) goto L37;
        if (r8 != Long.class) goto L24;
    L36:
        r9 = (T) a(r3, (Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin"));
        goto L40
    L24:
        if (r8 == Long.TYPE) goto L36;
        if (r8 != Double.class) goto L29;
    L35:
        r9 = (T) a(r3, (Double) ZeusTransformUtils.preCheckCast(r5, Double.class, "com.obric.aiagent.plugin"));
        goto L40
    L29:
        if (r8 == Double.TYPE) goto L35;
        if (r8 != String.class) goto L34;
        r9 = (T) a(r3, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
        goto L40
    L34:
        r9 = (T) a(r3, r8, r5);
        goto L40
    }

    private <T> T a(String r3, Type r4, T r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
    L15:
        this.f7922e.remove(r3);
        return r5;
    L4:
        if (this.f7922e.containsKey(r3) == true) goto L6;
    L9:
        String r0 = this.f7920c.optString(r3, "");     // Catch: Exception -> L15
        T r7 = (T) this.f.a(r0, r6);
        if (r7 != null) goto L13;
        this.f7922e.remove(r3);     // Catch: Exception -> L15
        return r5;
    L13:
        this.f7922e.put(r3, r7);     // Catch: Exception -> L15
        return r7;
    L6:
        if (this.f7922e.get(r3).getClass() != r6) goto L9;
        return (T) this.f7922e.get(r3);
    }

    private Double a(String r2, Double r3) {
        if (this.f7920c.has(r2) == true) goto L5;
        return r3;
    L5:
        return Double.valueOf(this.f7920c.optDouble(r2));
    }

    private Long a(String r2, Long r3) {
        if (this.f7920c.has(r2) == true) goto L5;
        return r3;
    L5:
        return Long.valueOf(this.f7920c.optLong(r2));
    }

    private Float a(String r2, Float r3) {
        if (this.f7920c.has(r2) == true) goto L5;
        return r3;
    L5:
        return Float.valueOf((float) this.f7920c.optDouble(r2));
    }

    private Boolean a(String r2, Boolean r3) {
        if (this.f7920c.has(r2) == true) goto L5;
        return r3;
    L5:
        return Boolean.valueOf(this.f7920c.optBoolean(r2));
    }

    private Integer a(String r2, Integer r3) {
        if (this.f7920c.has(r2) == true) goto L5;
        return r3;
    L5:
        return Integer.valueOf(this.f7920c.optInt(r2));
    }

    private String a(String r1, String r2) {
        return this.f7920c.optString(r1, r2);
    }

    <T> T a(final String r17, final com.bytedance.dataplatform.b.a<T> r18, boolean r19) {
        if (r18 != null) goto L5;
    L40:
        return null;
    L5:
        if (TextUtils.isEmpty(r18.a()) == true) goto L40;
        if (r18.d() == null) goto L40;
        if (r18.d().length == 0) goto L40;
        String r4 = r18.a();
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L14:
        if (this.f7921d.containsKey(r4) == false) goto L16;
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(this.f7921d.get(r4), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L37
    L17:
        monitor-exit(this);     // Catch: Throwable -> L37
        int r6 = (int) (r18.c() * 1000.0d);
        if (r5 >= r6) goto L21;
        return null;
    L21:
        com.bytedance.dataplatform.b.b<T>[] r7 = r18.d();
        int r9 = r7.length;
        int r10 = 0;
    L22:
        if (r10 >= r9) goto L35;
        final com.bytedance.dataplatform.b.b<T> r11 = r7[r10];
        if (r11 == null) goto L34;
        r6 = (int) (((double) r6) + (r11.b() * 1000.0d));
        if (r5 >= r6) goto L34;
        Runnable r3 = new AnonymousClass3(this, r17, r18, r11);
        if (r19 == false) goto L31;
        r3.run();
    L33:
        return r11.c();
    L31:
        this.m.put(r17, r3);
    L34:
        r10 = r10 + 1;
        goto L22
    L35:
        m.a(new AnonymousClass4(this, r17, r18));
        return null;
    L16:
        int r8 = c(r17);     // Catch: Throwable -> L37
        this.f7921d.put(r4, Integer.valueOf(r8));     // Catch: Throwable -> L37
        a.a(this.f7919b, "CLIENT_EXPERIMENT_CACHE_TAG", r4, r8);     // Catch: Throwable -> L37
        com.bytedance.dataplatform.a.a.a(r4, Integer.valueOf(r8));     // Catch: Throwable -> L37
        r5 = r8;
        goto L17
    }

    public void a(String r4) {
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.m.get(r4), Runnable.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        this.m.remove(r4);
        r0.run();
        return;
    }

    String b(String r1) {
        return this.j.a(r1);
    }
}
