package com.baidu.mshield.x6.e;

import android.content.Context;
import com.baidu.mshield.x6.f.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f32583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.baidu.mshield.x6.b.b f32584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32585d;

    public final long a() {
        long r100 = 300000;
        int r101 = h.f32599d;     // Catch: Throwable -> L19
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L10;
        if (r101 == 2) goto L10;
        if (r101 < 3) goto L15;
        if (r101 >= 10) goto L15;
    L17:
        h.f32599d = r101 + 1;     // Catch: Throwable -> L19
    L21:
        return r100;
    L15:
        if (r101 < 10) goto L17;
        r100 = -1;
    L10:
        r100 = 5000;
    L19:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
        goto L21
    }

    public void b() {
        com.baidu.mshield.b.c.a.a("report static alive for start");     // Catch: Throwable -> L21
        JSONObject r100 = this.f32583b.a();     // Catch: Throwable -> L21
        if (r100 == null) goto L6;
        JSONObject r101 = com.baidu.mshield.x6.f.f.a(this.f32582a, r100, com.baidu.mshield.x6.f.g.f32614c, true);     // Catch: Throwable -> L21
    L7:
        com.baidu.mshield.b.c.a.a("sendJson:" + r101);     // Catch: Throwable -> L21
        if (com.baidu.mshield.b.a.d.b(this.f32582a) == true) goto L12;
        h.f32598c = false;     // Catch: Throwable -> L21
        h.f32598c = false;
        return;
    L12:
        int r102 = l.a(this.f32582a, r101.toString());     // Catch: Throwable -> L21
        com.baidu.mshield.b.c.a.c("result: " + r102);     // Catch: Throwable -> L21
        if (r102 != 0) goto L15;
        this.f32584c.s(com.baidu.mshield.x6.f.f.c());     // Catch: Throwable -> L21
        this.f32584c.b(true);     // Catch: Throwable -> L21
        this.f32584c.e(false);     // Catch: Throwable -> L21
    L23:
        h.f32598c = false;
        return;
    L15:
        long r103 = a();     // Catch: Throwable -> L21
        if (com.baidu.mshield.b.a.d.b(this.f32582a) == false) goto L23;
        if (r103 <= 0) goto L23;
        f.b(this.f32582a).a(r103);     // Catch: Throwable -> L21
        goto L23
    L6:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L21
        r104.put("11111", "-1");     // Catch: Throwable -> L21
        r101 = com.baidu.mshield.x6.f.f.a(this.f32582a, r104, com.baidu.mshield.x6.f.g.f32614c, true);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        h.f32598c = false;
        throw th;
    }

    public c(Context r100, int r101) {
        this.f32582a = r100;
        this.f32585d = r101;
        this.f32583b = new g(r100, r101);
        this.f32584c = new com.baidu.mshield.x6.b.b(this.f32582a);
    }
}
