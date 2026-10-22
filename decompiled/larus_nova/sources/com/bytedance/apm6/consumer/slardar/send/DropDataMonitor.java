package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DropDataMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f190694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONArray f190695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f190696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f190697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f190698e;

    /* JADX INFO: loaded from: classes14.dex */
    public static final enum Reason extends Enum<Reason> {
        public static final Reason FULL_DISK = null;
        public static final Reason SERVER_DROP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Reason[] f190699a = null;
        private String reason;

        static {
            Reason r100 = new Reason("SERVER_DROP", 0, "server drop message");
            SERVER_DROP = r100;
            Reason r101 = new Reason("FULL_DISK", 1, "disk is full");
            FULL_DISK = r101;
            f190699a = new Reason[]{r100, r101};
        }

        public static Reason[] values() {
            return (Reason[]) f190699a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.reason;
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        public Reason(String r100, int r101, String r102) {
            super(r100, r101);
            this.reason = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DropDataMonitor f190700a = null;

        static {
            f190700a = new DropDataMonitor();
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f190696c == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.f190696c = true;     // Catch: Throwable -> L14
        SharedPreferences r100 = xu3.a.getContext().getSharedPreferences(du3.a.e() + "_drop_message", 0);     // Catch: Throwable -> L14
        this.f190694a = r100;     // Catch: Throwable -> L14
        String r101 = r100.getString("drop_data_items", "");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r101) == false) goto L18;
    L12:
        monitor-exit(this);
        return;
    L18:
        this.f190695b = new JSONArray(r101);     // Catch: Exception -> L17 Throwable -> L14
        goto L12
    }

    public DropDataMonitor() {
        this.f190695b = new JSONArray();
    }

    public final JSONArray b() {
        a();
        JSONArray r100 = new JSONArray();
        JSONArray r101 = new JSONArray();
        int r102 = 0;
    L13:
        if (r102 >= this.f190695b.length()) goto L10;
        if (r102 >= 10) goto L8;
        r100.put(this.f190695b.get(r102));     // Catch: Exception -> L12
    L9:
        r102 = r102 + 1;
        goto L13
    L8:
        r101.put(this.f190695b.get(r102));     // Catch: Exception -> L12
    L10:
        this.f190695b = r101;
        this.f190694a.edit().putString("drop_data_items", this.f190695b.toString()).commit();
        return r100;
    }

    public final void c(long r100, long r101, long r110, Reason r111) {
        a();
        JSONObject r102 = new JSONObject();
        r102.put(FrescoMonitorConst.LOG_TYPE, "server_drop_data");     // Catch: Exception -> L13
        r102.put("timestamp", r110);     // Catch: Exception -> L13
        r102.put("drop_data_count", r100);     // Catch: Exception -> L13
        r102.put("drop_data_bytes", r101);     // Catch: Exception -> L13
        if (r111 != Reason.SERVER_DROP) goto L6;
        r102.put(NetResponse.HEADER_KEY_LOG_ID, this.f190697d);     // Catch: Exception -> L13
        r102.put("drop_timestamp", this.f190698e);     // Catch: Exception -> L13
    L6:
        if (r111 == null) goto L8;
        r102.put("drop_reason", r111);     // Catch: Exception -> L13
    L8:
        this.f190695b.put(r102);     // Catch: Exception -> L13
        if (xu3.a.a() == false) goto L11;
        List<String> r103 = mt3.a.f515607a;     // Catch: Exception -> L13
        av3.b.a("APM-Slardar", "monitorDropLog:" + this.f190695b.toString());     // Catch: Exception -> L13
    L11:
        this.f190694a.edit().putString("drop_data_items", this.f190695b.toString()).commit();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        List<String> r104 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "monitorDropLog:", e);
    }
}
