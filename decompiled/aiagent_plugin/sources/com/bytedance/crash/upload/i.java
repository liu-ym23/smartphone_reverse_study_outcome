package com.bytedance.crash.upload;

import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetState.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7809e;
    private int f;
    private int g;
    private int h;
    private long i;
    private String j;
    private JSONObject k;

    public i(String r3, String r4) {
        this.f7806b = r3;
        this.f7807c = r4;
        this.f = 0;
        this.g = 0;
        this.f7808d = 0;
        this.f7809e = "";
        this.h = 0;
        this.i = 0;
        this.j = "";
        this.k = new JSONObject();
        this.f7805a = k.a(this.f7806b, this.f7807c);
        this.k.put(WsConstants.KEY_APP_ID, this.f7806b);     // Catch: Throwable -> L5
        this.k.put(DownloadConstants.PATH_KEY, this.f7807c);     // Catch: Throwable -> L5
        return;
    }

    public i(JSONObject r3) {
        if (r3 == null) goto L7;
        this.f7806b = r3.optString(WsConstants.KEY_APP_ID);
        this.f7807c = r3.optString(DownloadConstants.PATH_KEY);
        this.f = r3.optInt("strategy");
        this.g = r3.optInt("alog_strategy");
        this.f7808d = r3.optLong("update_time");
        this.f7809e = r3.optString("update_time_format");
        this.h = r3.optInt("retreatCount");
        this.j = r3.optString("redirect");
        this.k = new JSONObject(r3.toString());
        this.f7805a = k.a(this.f7806b, this.f7807c);
        return;
    L7:
        throw new IllegalArgumentException("json can't be null");
    }

    public JSONObject a() {
        JSONObject r1 = new JSONObject();
        this.k.put(WsConstants.KEY_APP_ID, this.f7806b);     // Catch: Throwable -> L9
        this.k.put(DownloadConstants.PATH_KEY, this.f7807c);     // Catch: Throwable -> L9
        this.k.put("update_time", this.f7808d);     // Catch: Throwable -> L9
        this.k.put("update_time_format", com.bytedance.crash.o.d.d().format(new Date(this.f7808d)));     // Catch: Throwable -> L6
    L7:
        this.k.put("strategy", this.f);     // Catch: Throwable -> L9
        this.k.put("alog_strategy", this.g);     // Catch: Throwable -> L9
        this.k.put("retreatCount", this.h);     // Catch: Throwable -> L9
        this.k.put("redirect", this.j);     // Catch: Throwable -> L9
        r1.put(this.f7805a, this.k);     // Catch: Throwable -> L9
        goto L8
    L6:
        this.k.put("update_time_format", "");     // Catch: Throwable -> L9
    L8:
        return r1;
    }

    public int b() {
        int r0 = this.f;
        if (r0 == 1) goto L8;
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.h;
    L8:
        return 0;
    }

    public void a(int r3) {
        if (r3 == 1) goto L10;
        if (r3 == 0) goto L10;
        if (r3 == this.f) goto L9;
        this.h = 1;
    L11:
        this.f = r3;
        return;
    L9:
        this.h++;
    L10:
        this.h = 0;
        goto L11
    }

    public int c() {
        return this.f;
    }

    public void b(int r1) {
        this.g = r1;
    }

    public void a(long r1) {
        this.i = r1;
    }

    public long d() {
        return this.i;
    }

    public void b(long r3) {
        this.f7808d = r3;
        this.f7809e = com.bytedance.crash.o.d.d().format(new Date(this.f7808d));     // Catch: Throwable -> L5
        return;
    }

    public long e() {
        return this.f7808d;
    }

    public String f() {
        return this.f7806b;
    }

    public String g() {
        return this.f7807c;
    }

    public String toString() {
        return "[" + this.f7805a + " " + this.f + " " + this.g + " " + this.h + " " + this.i + "]";
    }
}
