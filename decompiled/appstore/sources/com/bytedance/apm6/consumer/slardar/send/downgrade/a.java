package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile DowngradeInfo f6739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r2.a f6740b;

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.send.downgrade.a$a, reason: collision with other inner class name */
    public static class C0081a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6741a = null;

        static {
            f6741a = new a();
        }

        public static /* synthetic */ a a() {
            return f6741a;
        }
    }

    public a() {
    }

    public static a a() {
        return C0081a.a();
    }

    public void b(Context r10) {
        r2.a r11 = new r2.a(r10);
        this.f6740b = r11;
        c(r11.a(), false);
    }

    public void c(DowngradeInfo r10, boolean r11) {
        if (r10 == null) goto L13;
        monitor-enter(this);
        this.f6739a = r10;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r11 == false) goto L16;
        r2.a r12 = this.f6740b;
        if (r12 == null) goto L17;
        r12.b(r10);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean d(JSONObject r10, int r11) {
        boolean r12 = true;
        if (this.f6739a != null) goto L5;
    L47:
        return true;
    L5:
        if (System.currentTimeMillis() > this.f6739a.f6735a) goto L47;
        String r13 = String.valueOf(r11);
        String r14 = r10.optString("log_type");
        monitor-enter(this);
        DowngradeInfo.LogType r15 = DowngradeInfo.LogType.SERVICE_MONITOR;     // Catch: Throwable -> L23
        if (r15.logType.equals(r14) == false) goto L28;
        String r16 = r10.optString("service");     // Catch: Throwable -> L23
        DowngradeInfo.a r17 = (DowngradeInfo.a) this.f6739a.f6736b.get(r15);     // Catch: Throwable -> L23
        if (r17 == null) goto L43;
        JSONObject r18 = (JSONObject) r17.f6738b.get(r13);     // Catch: Throwable -> L23
        if (r18 != null) goto L16;
    L25:
        boolean r19 = r17.f6737a;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r19;
    L16:
        if (r18.optInt(r16, -1) == (-1)) goto L25;
        if (r18.optInt(r16, -1) == 1) goto L21;
        r12 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        return r12;
    L43:
        monitor-exit(this);     // Catch: Throwable -> L23
        return true;
    L28:
        DowngradeInfo.a r20 = (DowngradeInfo.a) this.f6739a.f6736b.get(DowngradeInfo.LogType.OTHER_LOG_TYPE);     // Catch: Throwable -> L23
        if (r20 == null) goto L43;
        JSONObject r21 = (JSONObject) r20.f6738b.get(r13);     // Catch: Throwable -> L23
        if (r21 != null) goto L33;
    L40:
        boolean r22 = r20.f6737a;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r22;
    L33:
        if (r21.optInt(r14, -1) == (-1)) goto L40;
        if (r21.optInt(r14, -1) == 1) goto L38;
        r12 = false;
    L38:
        monitor-exit(this);     // Catch: Throwable -> L23
        return r12;
    L23:
        th = move-exception;
        throw th;
    }
}
