package com.bytedance.crash.alog;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DefaultAlogUploadStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7161a;

    public b(String r1) {
        this.f7161a = r1;
    }

    public b() {
    }

    @Override // com.bytedance.crash.alog.d
    public List<String> a(String r22, long r23) {
        ArrayList r2 = new ArrayList();
        if (TextUtils.isEmpty(r22) == false) goto L65;
        return r2;
    L65:
        File[] r3 = new File(r22).listFiles();     // Catch: Exception -> L62
        if (r3 != null) goto L9;
        return r2;
    L9:
        if (this.f7161a != null) goto L12;
        this.f7161a = com.bytedance.crash.o.b.a();     // Catch: Exception -> L62
    L12:
        if (this.f7161a.contains(":") == true) goto L14;
        boolean r5 = true;
    L16:
        if (this.f7161a.contains(":") == false) goto L18;
        String r0 = this.f7161a.replace(":", "-");     // Catch: Exception -> L62
    L19:
        int r1 = r3.length;     // Catch: Exception -> L62
        File r8 = null;
        File r11 = null;
        int r12 = 0;
        long r13 = 0;
        long r15 = 0;
    L20:
        if (r12 >= r1) goto L53;
        File r17 = r3[r12];     // Catch: Exception -> L62
        String r9 = r17.getName();     // Catch: Exception -> L62
        if (r9.endsWith(".hot") == false) goto L52;
        if (r5 == true) goto L26;
    L27:
        if (r5 == true) goto L32;
        if (r17.getName().contains("-") == false) goto L52;
    L32:
        if (r9.contains(r0) == false) goto L52;
        String[] r10 = r9.split("_");     // Catch: Exception -> L62
        long r18 = -1;
        if (r10.length < 4) goto L38;
        r18 = Long.parseLong(r10[3]);     // Catch: Exception -> L62
    L42:
        if (r23 <= 0) goto L47;
        if (r18 > r23) goto L52;
    L47:
        if (r13 >= r18) goto L50;
        r8 = r11;
        r15 = r13;
        r11 = r17;
        r13 = r18;
        goto L52
    L50:
        if (r15 >= r18) goto L52;
        r8 = r17;
        r15 = r18;
        goto L52
    L38:
        if (r10.length <= 1) goto L42;
        r18 = Long.parseLong(r10[0]);     // Catch: Exception -> L62
        goto L42
    L26:
        if (r17.getName().contains("-") == false) goto L27;
    L52:
        r12 = r12 + 1;     // Catch: Exception -> L62
        goto L20
    L53:
        if (r8 != null) goto L55;
    L57:
        if (r11 != null) goto L59;
    L64:
        return r2;
    L59:
        if (r11.length() <= 0) goto L64;
        r2.add(r11.getAbsolutePath());     // Catch: Exception -> L62
        goto L64
    L55:
        if (r8.length() <= 0) goto L57;
        r2.add(r8.getAbsolutePath());     // Catch: Exception -> L62
        goto L57
    L18:
        r0 = this.f7161a;     // Catch: Exception -> L62
        goto L19
    L14:
        r5 = false;
    L62:
        e = move-exception;
        com.bytedance.crash.c.b.a(e);
        goto L64
    }
}
