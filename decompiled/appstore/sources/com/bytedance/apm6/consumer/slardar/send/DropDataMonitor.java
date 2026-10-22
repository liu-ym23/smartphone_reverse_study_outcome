package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DropDataMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f6680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONArray f6681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6684e;

    public static final enum Reason extends Enum<Reason> {
        private static final /* synthetic */ Reason[] $VALUES = null;
        public static final Reason FULL_DISK = null;
        public static final Reason SERVER_DROP = null;
        private String reason;

        static {
            Reason r10 = new Reason("SERVER_DROP", 0, "server drop message");
            SERVER_DROP = r10;
            Reason r11 = new Reason("FULL_DISK", 1, "disk is full");
            FULL_DISK = r11;
            $VALUES = new Reason[]{r10, r11};
        }

        private Reason(String r10, int r11, String r12) {
            super(r10, r11);
            this.reason = r12;
        }

        public static Reason valueOf(String r10) {
            return (Reason) Enum.valueOf(Reason.class, r10);
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.reason;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DropDataMonitor f6685a = null;

        static {
            f6685a = new DropDataMonitor();
        }

        public static /* synthetic */ DropDataMonitor a() {
            return f6685a;
        }
    }

    public DropDataMonitor() {
        this.f6681b = new JSONArray();
    }

    public static DropDataMonitor b() {
        return a.a();
    }

    public final synchronized void a() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f6682c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f6682c = true;     // Catch: Throwable -> L12
        SharedPreferences r10 = r3.a.b().getSharedPreferences(d3.a.m() + "_drop_message", 0);     // Catch: Throwable -> L12
        this.f6680a = r10;     // Catch: Throwable -> L12
        String r11 = r10.getString("drop_data_items", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r11) == false) goto L21;
    L14:
        monitor-exit(this);
        return;
    L21:
        this.f6681b = new JSONArray(r11);     // Catch: Throwable -> L12 Exception -> L18
        goto L14
    }

    public JSONArray c() {
        a();
        JSONArray r10 = new JSONArray();
        JSONArray r11 = new JSONArray();
        int r12 = 0;
    L13:
        if (r12 >= this.f6681b.length()) goto L10;
        if (r12 >= 10) goto L8;
        r10.put(this.f6681b.get(r12));     // Catch: Exception -> L12
    L9:
        r12 = r12 + 1;
        goto L13
    L8:
        r11.put(this.f6681b.get(r12));     // Catch: Exception -> L12
    L10:
        this.f6681b = r11;
        this.f6680a.edit().putString("drop_data_items", this.f6681b.toString()).commit();
        return r10;
    }

    public void d(long r10, long r11, long r12, Reason r13) {
        a();
        JSONObject r14 = new JSONObject();
        r14.put("log_type", "server_drop_data");     // Catch: Exception -> L6
        r14.put("timestamp", r12);     // Catch: Exception -> L6
        r14.put("drop_data_count", r10);     // Catch: Exception -> L6
        r14.put("drop_data_bytes", r11);     // Catch: Exception -> L6
        if (r13 != Reason.SERVER_DROP) goto L8;
        r14.put("x-tt-logid", this.f6683d);     // Catch: Exception -> L6
        r14.put("drop_timestamp", this.f6684e);     // Catch: Exception -> L6
    L8:
        if (r13 == null) goto L10;
        r14.put("drop_reason", r13);     // Catch: Exception -> L6
    L10:
        this.f6681b.put(r14);     // Catch: Exception -> L6
        if (r3.a.c() == false) goto L13;
        s3.a.a(n2.a.f22354a, "monitorDropLog:" + this.f6681b.toString());     // Catch: Exception -> L6
    L13:
        this.f6680a.edit().putString("drop_data_items", this.f6681b.toString()).commit();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        s3.a.c(n2.a.f22354a, "monitorDropLog:", e);
    }

    public void e(String r10) {
        this.f6683d = r10;
    }

    public void f(long r10) {
        this.f6684e = r10;
    }
}
