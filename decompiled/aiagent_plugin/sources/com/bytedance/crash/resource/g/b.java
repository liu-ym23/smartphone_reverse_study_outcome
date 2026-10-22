package com.bytedance.crash.resource.g;

import com.bytedance.crash.config.h;
import com.bytedance.crash.resource.c;
import org.json.JSONArray;

/* JADX INFO: compiled from: VmMonitorConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    protected int h;
    protected int i;
    protected final int j;
    protected boolean k;
    protected boolean l;
    private int m;
    private int n;
    private String o;
    private String p;
    private String q;
    private String r;

    public b(int r5, JSONArray r6, JSONArray r7, JSONArray r8, JSONArray r9) {
        super(23, 35, 3);
        this.m = 350;
        this.n = 650;
        this.h = 3000;
        this.i = 0;
        this.k = false;
        this.l = false;
        this.o = "test";
        this.p = "0";
        this.q = "0";
        this.r = "0";
        if (h.g() == false) goto L5;
        this.j = 3;
        this.m = 0;
        this.n = 200;
        this.h = 1000;
        this.o = "new_test";
        this.q = "3";
        this.r = "5";
        this.i = 32;
        this.l = true;
        this.k = true;
        return;
    L5:
        this.j = r5;
        if (r6 != null) goto L8;
    L10:
        b(r7);
        a(r8);
        c(r9);
        return;
    L8:
        if (r6.length() != 2) goto L10;
        this.m = r6.optInt(0);
        this.n = r6.optInt(1);
        goto L10
    }

    private void a(JSONArray r5) {
        if (r5 == null) goto L7;
        int r0 = 0;
        this.i = 0;
    L5:
        if (r0 >= r5.length()) goto L9;
        this.i |= 1 << r5.optInt(r0);
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    private void b(JSONArray r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.length() != 5) goto L35;
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r7.length()) goto L26;
        String r3 = r7.optString(r1);
        if (r1 != 0) goto L11;
        this.o = r3;
    L25:
        r1 = r1 + 1;
        goto L7
    L11:
        if (r1 != 1) goto L13;
        this.p = a(r3);
        goto L25
    L13:
        if (r1 != 2) goto L15;
        int r4 = Integer.parseInt(r3) << 0;
    L22:
        r2 = r2 | r4;
        goto L25
    L15:
        if (r1 != 3) goto L17;
        r4 = Integer.parseInt(r3) << 1;
        goto L22
    L17:
        if (r1 != 4) goto L25;
        this.r = r3;
        goto L25
    L26:
        this.q = String.valueOf(r2);
        return;
    }

    private void c(JSONArray r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length() != 2) goto L24;
        int r0 = 0;
    L7:
        if (r0 >= r4.length()) goto L25;
        String r1 = r4.optString(r0);
        if (r0 != 0) goto L11;
        this.l = "1".equals(r1);
    L17:
        r0 = r0 + 1;
        goto L7
    L11:
        if (r0 != 1) goto L17;
        if (this.l == false) goto L17;
        this.o = r1;
        goto L17
    L25:
        return;
    }

    public long i() {
        return ((long) this.m) * 1024;
    }

    public long j() {
        return ((long) this.n) * 1024;
    }

    private static String a(String r8) {
        if (r8 == null) goto L21;
        if (r8.endsWith("M") == false) goto L8;
        Long r9 = Long.valueOf((Long.parseLong(r8.substring(0, r8.indexOf("M"))) * 1024) * 1024);     // Catch: Throwable -> L18
    L14:
        if (r9 == null) goto L22;
        return r9.toString();
    L22:
        return null;
    L8:
        if (r8.endsWith("G") == false) goto L11;
        r9 = Long.valueOf(((Long.parseLong(r8.substring(0, r8.indexOf("G"))) * 1024) * 1024) * 1024);     // Catch: Throwable -> L18
        goto L14
    L11:
        if (r8.endsWith("K") == false) goto L13;
        r9 = Long.valueOf(Long.parseLong(r8.substring(0, r8.indexOf("K"))) * 1024);     // Catch: Throwable -> L18
        goto L14
    L13:
        r9 = null;
    L23:
        return null;
    L21:
        return null;
    }

    @Override // com.bytedance.crash.resource.c
    public String toString() {
        return "monitorType=" + this.j + "\nwaterLineMB=" + this.m + "\ndumpSizeMB=" + this.n + "\nmprotectProts=" + this.i + "\nmemType=" + this.o + "\nmemSize=" + this.p + "\nbacktraceRules=" + this.q + "\nmonitorRules=" + this.r + "\nsleepTime=" + this.h + "\ndebug=" + this.k + "\npEnable=" + this.l + "\n";
    }
}
