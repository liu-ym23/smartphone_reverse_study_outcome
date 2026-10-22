package com.c.a.d.a;

import android.os.Debug;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: HeapOOMMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f11911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11912b;

    @Override // com.c.a.d.a
    public String b() {
        return "heap_oom";
    }

    public g() {
        this.f11911a = null;
        this.f11912b = 0;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r14) {
        JSONObject r0 = new JSONObject(r14.a());
        if (a(r0, r14) == false) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - this.f11912b) >= 300000) goto L8;
        return false;
    L8:
        this.f11912b = System.currentTimeMillis();
        boolean r1 = r0.optBoolean("isTryToCatch", false);
        String r2 = com.c.a.a.g();
        String r4 = "本地未设置dumpFileName";
        if (TextUtils.isEmpty(r2) == false) goto L12;
        a("本地未设置dumpFileName", r14);
        return true;
    L12:
        if (r1 == true) goto L30;
    L17:
        File r3 = new File(r2);
        if (TextUtils.isEmpty(r2) == true) goto L22;
        r4 = null;
    L22:
        if (r3.exists() == true) goto L25;
        r4 = "dumpFile不存在";
    L25:
        if (TextUtils.isEmpty(r4) == true) goto L28;
        a(r4, r14);
        return true;
    L28:
        this.f11911a = r3;
        com.c.a.h.b.a r5 = new com.c.a.h.b.a("log_heap_oom", 0, false, r14.d(), this, null);
        r5.a(true);
        com.c.a.h.a.a(r5);
        return true;
    L30:
        Debug.dumpHprofData(r2);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f11911a;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }
}
