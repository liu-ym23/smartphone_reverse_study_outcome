package com.obric.common.upgrade.d;

import com.bytedance.crash.general.RomInfo;
import com.google.gson.Gson;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.common.upgrade.i;
import com.obric.common.upgrade.util.c;
import com.obric.common.upgrade.util.e;
import com.obric.common.upgrade.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.o.d;
import java.io.Closeable;
import java.io.IOException;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "ReportManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0895a f32620a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final x f32621e = null;
    private static volatile a f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f32622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Gson f32623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32624d;

    /* JADX INFO: renamed from: com.obric.common.upgrade.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReportManager.kt */
    public static final class C0895a {
        public /* synthetic */ C0895a(h r1) {
            this();
        }

        private C0895a() {
        }

        public final a a() {
            a r0 = a.b();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = a.b();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new a(null);     // Catch: Throwable -> L10
            C0895a r1 = a.f32620a;     // Catch: Throwable -> L10
            a.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    public /* synthetic */ a(h r1) {
        this();
    }

    private a() {
        this.f32622b = e.f32653a.a();
        this.f32623c = new Gson();
    }

    public static final /* synthetic */ void a(a r0) {
        f = r0;
    }

    public static final /* synthetic */ a b() {
        return f;
    }

    static {
        f32620a = new C0895a(null);
        f32621e = x.c("application/json; charset=utf-8");
    }

    public final JSONArray a(int r4, long r5, long r7, long r9, String r11) {
        o.e(r11, "reason");
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put(KnowledgeActivity.KEY_TASK_ID, r5);
        r1.put("app_id", com.obric.common.upgrade.e.f32625a.a().a().h());
        r1.put("package", com.obric.common.upgrade.e.f32625a.a().a().e());
        r1.put("old_version_code", r7);
        r1.put("new_version_code", r9);
        r1.put("reason", r11);
        r1.put("event_time", System.currentTimeMillis());
        r1.put("status", r4);
        r0.put(r1);
        return r0;
    }

    public final JSONObject a() {
        JSONObject r2 = new JSONObject();
        r2.put("uuid", com.obric.common.upgrade.e.f32625a.a().a().a());
        r2.put("did", com.obric.common.upgrade.e.f32625a.a().a().a());
        r2.put(RomInfo.KEY_ROM_OS_VERSION, com.obric.common.upgrade.e.f32625a.a().a().g());
        r2.put("model", com.obric.common.upgrade.e.f32625a.a().a().b());
        r2.put("app_id", com.obric.common.upgrade.e.f32625a.a().a().h());
        return r2;
    }

    public static /* synthetic */ boolean a(a r10, int r11, long r12, long r14, long r16, String r18, int r19, Object r20) {
        if ((r19 & 16) == 0) goto L5;
        String r9 = "";
    L7:
        return r10.b(r11, r12, r14, r16, r9);
    L5:
        r9 = r18;
        goto L7
    }

    public final boolean b(int r7, long r8, long r10, long r12, String r14) {
        o.e(r14, "reason");
        boolean r1 = true;
        this.f32624d = true;
        String r2 = c();
        c.f32650a.b("reportStatus url = " + r2);
        JSONObject r3 = a();
        JSONArray r9 = a(r7, r8, r10, r12, r14);
        JSONObject r11 = new JSONObject();
        r11.put("body", r9);
        r11.put("head", r3);
        String r13 = r11.toString();
        o.c(r13, "fullData.toString()");
        ac r15 = ac.a(f32621e, r13);
        i r16 = com.obric.common.upgrade.e.f32625a.a().a();
        ab.a r17 = new ab.a().a(r2);
        g r18 = g.f32658a;
        String r19 = r16.i();
        String r20 = r16.j();
        byte[] r110 = r13.getBytes(d.f38623b);
        o.c(r110, "this as java.lang.String).getBytes(charset)");
        ab r21 = r17.b("X-Signature", r18.a(r19, r20, r110)).a(r15).b();
        c.f32650a.a("reportStatus_requestBody = " + r13);
        Closeable r22 = (Closeable) ZeusTransformUtils.preCheckCast(this.f32622b.a(r21).b(), Closeable.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L22
        ad r23 = (ad) ZeusTransformUtils.preCheckCast(r22, ad.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r23.n() == false) goto L13;
        ae r24 = r23.g();     // Catch: Throwable -> L17
        if (r24 == null) goto L9;
        String r25 = r24.f();     // Catch: Throwable -> L17
    L10:
        if (r25 == null) goto L12;
        c.f32650a.a("reportStatus_responseBody = " + r25);     // Catch: Throwable -> L17
    L12:
        this.f32624d = false;     // Catch: Throwable -> L17
    L15:
        d.f.c.a(r22, null);     // Catch: IOException -> L22
        return r1;
    L9:
        r25 = null;
        goto L10
    L13:
        this.f32624d = false;     // Catch: Throwable -> L17
        r1 = false;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        d.f.c.a(r22, th);     // Catch: IOException -> L22
        throw th;     // Catch: IOException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        this.f32624d = false;
        return false;
    }

    private final String c() {
        if (com.obric.common.upgrade.e.f32625a.a().a().f() == false) goto L5;
        return "https://os-boe.bytedance.net/api/upgrade/v1/batch_report";
    L5:
        return "https://os.oceancloudapi.com/api/upgrade/v1/batch_report";
    }
}
