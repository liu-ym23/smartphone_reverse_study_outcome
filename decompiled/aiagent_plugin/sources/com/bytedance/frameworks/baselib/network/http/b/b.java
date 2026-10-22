package com.bytedance.frameworks.baselib.network.http.b;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: CookieMetricManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Keva f8147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f8148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile JSONObject f8149c;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.b.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: CookieMetricManager.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8150a = null;

        static {
            int[] r0 = new int[a.values().length];
            f8150a = r0;
            r0[a.f8151a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f8150a[a.f8152b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f8150a[a.f8153c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: compiled from: CookieMetricManager.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8151a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8152b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8153c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f8154d = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f8154d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("All", 0);
            f8151a = r0;
            a r1 = new a("Session", 1);
            f8152b = r1;
            a r3 = new a("Expired", 2);
            f8153c = r3;
            f8154d = new a[]{r0, r1, r3};
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CookieMetricManager.java */
    private static class C0183b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f8155a = null;

        static /* synthetic */ b a() {
            return f8155a;
        }

        static {
            f8155a = new b(null);
        }
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    private b() {
        this.f8148b = new AtomicBoolean(true);
        this.f8149c = null;
        this.f8147a = Keva.getRepo("ttnetCookieDetailRepo", 1);
    }

    public static b a() {
        return C0183b.a();
    }

    public JSONObject b() {
        if (com.bytedance.frameworks.baselib.network.b.b.d() == false) goto L7;
        return null;
    L7:
        if (this.f8148b.compareAndSet(true, false) == false) goto L10;
        this.f8149c = c();
    L10:
        return this.f8149c;
    }

    private JSONObject c() {
        Map<String, ?> r2 = this.f8147a.getAll();     // Catch: Throwable -> L38
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.isEmpty() == true) goto L61;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L38
        Iterator<Map.Entry<String, ?>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L38
    L10:
        if (r4.hasNext() == false) goto L34;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r6) == true) goto L10;
        boolean r7 = r6.startsWith(";remove");     // Catch: Throwable -> L38
        if (r7 == false) goto L17;
    L43:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
    L25:
        if (TextUtils.isEmpty(r8) == true) goto L10;
        if (r7 == false) goto L30;
        r6 = r6.substring(1);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L38
    L30:
        r3.put(r6, new JSONObject(r8));     // Catch: Throwable -> L32
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L38
        r8 = null;
        goto L25
    L17:
        if (com.bytedance.frameworks.baselib.network.b.b.b(r6) == true) goto L43;
        this.f8147a.erase(r6);     // Catch: Throwable -> L38
        goto L10
    L34:
        if (r3.length() > 0) goto L37;
        return null;
    L37:
        return r3;
    L61:
        return null;
    L38:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    void a(URI r2, f r3) {
        if (r2 == null) goto L18;
        if (r3 != null) goto L5;
        return;
    L5:
        if (com.bytedance.frameworks.baselib.network.b.b.d() == false) goto L7;
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.b.b.b(r3.c()) == false) goto L22;
        String r4 = b(r2, r3);
        if (TextUtils.isEmpty(r4) == true) goto L21;
        this.f8147a.storeString(r3.c(), r4);     // Catch: Throwable -> L13
        this.f8148b.set(true);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L21:
        return;
    L22:
        return;
    }

    private String b(URI r10, f r11) {
        String r9 = null;
        if (r10 == null) goto L31;
        if (r11 == null) goto L32;
        String r0 = e.a(r10);
        String r12 = r10.getPath();
        if (TextUtils.isEmpty(r11.f()) == false) goto L29;
    L12:
        String r1 = r11.a();
        String r2 = r11.d();
        boolean r3 = r11.e();
        long r4 = r11.i();
        long r6 = r11.g();
        StringBuilder r13 = new StringBuilder().append("{\"r_host\":\"");
        if (r0 != null) goto L15;
        r0 = "-";
    L15:
        StringBuilder r14 = r13.append(r0).append("\",\"r_path\":\"");
        if (r12 != null) goto L18;
        r12 = "-";
    L18:
        StringBuilder r15 = r14.append(r12).append("\",\"v_md5\":\"");
        if (r9 != null) goto L21;
        r9 = "-";
    L21:
        StringBuilder r16 = r15.append(r9).append("\",\"domain\":\"");
        if (r1 != null) goto L24;
        r1 = "-";
    L24:
        StringBuilder r17 = r16.append(r1).append("\",\"path\":\"");
        if (r2 != null) goto L28;
        r2 = "-";
    L28:
        return r17.append(r2).append("\",\"sec\":").append(r3).append(",\"age\":").append(r4).append(",\"exp_t\":").append(r6).append("}").toString();
    L29:
        r9 = e.h.c(r11.f()).f().i();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        String r5 = String.valueOf(r11.f().length());
        th.printStackTrace();
        r9 = r5;
        goto L12
    L32:
        return null;
    L31:
        return null;
    }
}
