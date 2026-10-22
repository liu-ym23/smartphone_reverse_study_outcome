package com.bytedance.apm6.consumer.slardar.d;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DropDataMonitor.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONArray f5130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5133e;

    /* JADX INFO: compiled from: DropDataMonitor.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5134a = null;

        static /* synthetic */ b a() {
            return f5134a;
        }

        static {
            f5134a = new b();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DropDataMonitor.java */
    static final enum EnumC0126b extends Enum<EnumC0126b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0126b f5135a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0126b f5136b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0126b[] f5137d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f5138c;

        public static EnumC0126b valueOf(String r2) {
            return (EnumC0126b) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0126b.class, r2), EnumC0126b.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0126b[] values() {
            return (EnumC0126b[]) ZeusTransformUtils.preCheckCast(f5137d.clone(), EnumC0126b[].class, "com.obric.aiagent.plugin");
        }

        static {
            EnumC0126b r0 = new EnumC0126b("SERVER_DROP", 0, "server drop message");
            f5135a = r0;
            EnumC0126b r1 = new EnumC0126b("FULL_DISK", 1, "disk is full");
            f5136b = r1;
            f5137d = new EnumC0126b[]{r0, r1};
        }

        private EnumC0126b(String r1, int r2, String r3) {
            super(r1, r2);
            this.f5138c = r3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f5138c;
        }
    }

    b() {
        this.f5130b = new JSONArray();
    }

    static b a() {
        return a.a();
    }

    void a(String r1) {
        this.f5132d = r1;
    }

    void a(long r1) {
        this.f5133e = r1;
    }

    void a(long r5, long r7, long r9, EnumC0126b r11) {
        c();
        JSONObject r1 = new JSONObject();
        r1.put("log_type", "server_drop_data");     // Catch: Exception -> L13
        r1.put(DBHelper.COL_TIME, r9);     // Catch: Exception -> L13
        r1.put("drop_data_count", r5);     // Catch: Exception -> L13
        r1.put("drop_data_bytes", r7);     // Catch: Exception -> L13
        if (r11 != EnumC0126b.f5135a) goto L6;
        r1.put("x-tt-logid", this.f5132d);     // Catch: Exception -> L13
        r1.put("drop_timestamp", this.f5133e);     // Catch: Exception -> L13
    L6:
        if (r11 == null) goto L8;
        r1.put("drop_reason", r11);     // Catch: Exception -> L13
    L8:
        this.f5130b.put(r1);     // Catch: Exception -> L13
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L11;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "monitorDropLog:" + this.f5130b.toString());     // Catch: Exception -> L13
    L11:
        this.f5129a.edit().putString("drop_data_items", this.f5130b.toString()).commit();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "monitorDropLog:", e);
    }

    JSONArray b() {
        c();
        JSONArray r0 = new JSONArray();
        JSONArray r1 = new JSONArray();
        int r2 = 0;
    L13:
        if (r2 >= this.f5130b.length()) goto L10;
        if (r2 >= 10) goto L8;
        r0.put(this.f5130b.get(r2));     // Catch: Exception -> L12
    L9:
        r2 = r2 + 1;
        goto L13
    L8:
        r1.put(this.f5130b.get(r2));     // Catch: Exception -> L12
    L10:
        this.f5130b = r1;
        this.f5129a.edit().putString("drop_data_items", this.f5130b.toString()).commit();
        return r0;
    }

    private synchronized void c() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f5131c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f5131c = true;     // Catch: Throwable -> L13
        SharedPreferences r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSharedPreferences(com.bytedance.apm6.foundation.context.a.f() + "_drop_message", 0);     // Catch: Throwable -> L13
        this.f5129a = r0;     // Catch: Throwable -> L13
        String r1 = r0.getString("drop_data_items", "");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r1) == false) goto L17;
    L11:
        monitor-exit(this);
        return;
    L17:
        this.f5130b = new JSONArray(r1);     // Catch: Exception -> L16 Throwable -> L13
        goto L11
    }
}
