package com.baidu.xclient.gdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.b.a.g;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f33618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f33619b;

    public h() {
        this.f33619b = new AtomicBoolean(false);
    }

    public static h a() {
        if (f33618a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33618a != null) goto L9;
        f33618a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f33618a;
    }

    public final JSONObject a(Context r100, StringBuilder r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L23
        String r103 = d.a().d()[0];     // Catch: Throwable -> L23
        String r104 = "";
        if (TextUtils.isEmpty(r103) == false) goto L9;
        r103 = "";
    L9:
        r102.put("15028", r103);     // Catch: Throwable -> L23
        String r105 = com.baidu.xclient.gdid.j.c.a("02018", d.a().c("arid"), r101);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r104 = r105;
    L13:
        r102.put("02018", r104);     // Catch: Throwable -> L23
        r102.put("15003", com.baidu.mshield.b.b.a.a(r100));     // Catch: Throwable -> L23
        r102.put("02003", d.a().c("mod"));     // Catch: Throwable -> L23
        r102.put("02002", com.baidu.xclient.gdid.jni.c.a(r100).f());     // Catch: Throwable -> L23
        String r106 = g.b(r100);     // Catch: Throwable -> L23
        String r107 = g.c(r100);     // Catch: Throwable -> L23
        r102.put("15029", r106);     // Catch: Throwable -> L23
        r102.put("15030", r107);     // Catch: Throwable -> L23
        if (com.baidu.mshield.b.a.e.c() == false) goto L18;
        String r108 = "1";
    L17:
        r102.put("p", r108);     // Catch: Throwable -> L23
        r102.put("02020", com.baidu.xclient.gdid.j.d.b());     // Catch: Throwable -> L23
        r102.put("02015", d.a().c("arv"));     // Catch: Throwable -> L23
        r102.put("s", com.baidu.xclient.gdid.jni.c.a(r100).a());     // Catch: Throwable -> L23
        return r102;
    L18:
        r108 = "0";
    L23:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return null;
    }

    public void a(Context r100) {
        if (this.f33619b.get() == false) goto L34;
        return;
    L34:
        this.f33619b.set(true);     // Catch: Throwable -> L26
        if (e.e().x() == false) goto L11;
    L8:
        this.f33619b.set(false);
        return;
    L11:
        if (com.baidu.xclient.gdid.j.d.a(r100) == false) goto L8;
        if (com.baidu.mshield.b.e.a.d(r100) == false) goto L8;
        long r101 = e.e().n();     // Catch: Throwable -> L26
        long r102 = e.e().o();     // Catch: Throwable -> L26
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L26
        if ((r103 - r101) < r102) goto L8;
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L26
        JSONObject r105 = a(r100, r104);     // Catch: Throwable -> L26
        r105.put("15057", r104);     // Catch: Throwable -> L26
        JSONObject r106 = com.baidu.xclient.gdid.j.d.a(r100, r105, "1072102");     // Catch: Throwable -> L26
        if (r106 == null) goto L8;
        if (new com.baidu.xclient.gdid.g.a(r100, null).a(r106) == null) goto L8;
        e.e().d();     // Catch: Throwable -> L26
        e.e().g(r103);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        this.f33619b.set(false);
        throw th;
    }
}
