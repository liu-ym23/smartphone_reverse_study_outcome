package com.obric.common.upgrade.a;

import com.bytedance.crash.general.RomInfo;
import com.google.gson.Gson;
import com.obric.common.upgrade.f;
import com.obric.common.upgrade.i;
import com.obric.common.upgrade.util.c;
import com.obric.common.upgrade.util.e;
import com.obric.common.upgrade.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.o.d;
import java.io.Closeable;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpgradeCheckManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "UpgradeCheckManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0892a f32592a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final x f32593e = null;
    private static volatile a f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f32594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Gson f32595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32596d;

    /* JADX INFO: renamed from: com.obric.common.upgrade.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UpgradeCheckManager.kt */
    public static final class C0892a {
        public /* synthetic */ C0892a(h r1) {
            this();
        }

        private C0892a() {
        }

        public final a a() {
            a r0 = a.e();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = a.e();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new a(null);     // Catch: Throwable -> L10
            C0892a r1 = a.f32592a;     // Catch: Throwable -> L10
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
        this.f32594b = e.f32653a.a();
        this.f32595c = new Gson();
    }

    public static final /* synthetic */ void a(a r0) {
        f = r0;
    }

    public static final /* synthetic */ a e() {
        return f;
    }

    static {
        f32592a = new C0892a(null);
        f32593e = x.c("application/json; charset=utf-8");
    }

    public final JSONObject a() {
        JSONArray r5 = new JSONArray();
        JSONObject r0 = new JSONObject();
        r0.put("pkg_name", com.obric.common.upgrade.e.f32625a.a().a().e());
        r5.put(r0);
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        r2.put("apk_identity", "4ee46b65f081fd83f59b5d8c54c0f193");
        r2.put("pkg_name", com.obric.common.upgrade.e.f32625a.a().a().e());
        r2.put("version_code", com.obric.common.upgrade.e.f32625a.a().a().c());
        r2.put("version_name", com.obric.common.upgrade.e.f32625a.a().a().d());
        r1.put(r2);
        JSONObject r3 = new JSONObject();
        r3.put("need_upgrade_apps", r5);
        if (com.obric.common.upgrade.e.f32625a.a().a().f() == false) goto L5;
        int r6 = 335;
    L6:
        r3.put("business_id", r6);
        r3.put("apps", r1);
        return r3;
    L5:
        r6 = 48;
        goto L6
    }

    public final JSONObject b() {
        JSONObject r2 = new JSONObject();
        r2.put("uuid", com.obric.common.upgrade.e.f32625a.a().a().a());
        r2.put("did", com.obric.common.upgrade.e.f32625a.a().a().a());
        r2.put(RomInfo.KEY_ROM_OS_VERSION, com.obric.common.upgrade.e.f32625a.a().a().g());
        r2.put("model", com.obric.common.upgrade.e.f32625a.a().a().b());
        r2.put("app_id", com.obric.common.upgrade.e.f32625a.a().a().h());
        return r2;
    }

    public final f c() {
        this.f32596d = true;
        String r1 = f();
        c.f32650a.b("requestUpgradeInfo url = " + r1);
        JSONObject r2 = b();
        JSONObject r3 = a();
        JSONObject r4 = new JSONObject();
        r4.put("body", r3);
        r4.put("head", r2);
        String r5 = r4.toString();
        o.c(r5, "fullData.toString()");
        ac r6 = ac.a(f32593e, r5);
        i r7 = com.obric.common.upgrade.e.f32625a.a().a();
        ab.a r8 = new ab.a().a(r1);
        g r9 = g.f32658a;
        String r10 = r7.i();
        String r11 = r7.j();
        byte[] r12 = r5.getBytes(d.f38623b);
        o.c(r12, "this as java.lang.String).getBytes(charset)");
        ab r13 = r8.b("X-Signature", r9.a(r10, r11, r12)).a(r6).b();
        c.f32650a.a("requestBody = " + r5);
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(this.f32594b.a(r13).b(), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        ad r15 = (ad) ZeusTransformUtils.preCheckCast(r14, ad.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r15.n() == false) goto L9;
        String r16 = r15.g().f();     // Catch: Throwable -> L13
        if (r16 == null) goto L10;
        o.c(r16, "responseBody");     // Catch: Throwable -> L13
        c.f32650a.a("responseBody = " + r16);     // Catch: Throwable -> L13
        this.f32596d = false;     // Catch: Throwable -> L13
        f r0 = (f) ZeusTransformUtils.preCheckCast(this.f32595c.fromJson(r16, f.class), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
    L11:
        d.f.c.a(r14, null);     // Catch: Exception -> L18
        return r0;
    L10:
        r0 = null;
        goto L11
    L9:
        this.f32596d = false;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.f.c.a(r14, th);     // Catch: Exception -> L18
        throw th;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        this.f32596d = false;
        return null;
    }

    private final String f() {
        if (com.obric.common.upgrade.e.f32625a.a().a().f() == false) goto L5;
        return "https://os-boe.bytedance.net/api/upgrade/v1/check/single";
    L5:
        return "https://os.oceancloudapi.com/api/upgrade/v1/check/single";
    }

    public final boolean d() {
        return this.f32596d;
    }
}
