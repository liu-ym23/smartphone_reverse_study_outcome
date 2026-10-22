package com.bytedance.crash.dumper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: compiled from: ProtectorInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f7440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7444e;
    private boolean f;
    private boolean g;
    private String h;
    private String i;
    private String j;
    private String k;

    public o(File r3) {
        this.f7440a = null;
        this.f7441b = false;
        this.f7442c = null;
        this.f7443d = 0;
        this.f7444e = 0;
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.f7440a = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a() {
        char r3 = 0;
        if (this.f7440a != null) goto L5;
        return false;
    L5:
        File r2 = new File(com.bytedance.crash.i.d(), "protector_history.txt");
        if (r2.exists() == false) goto L82;
        if (r2.length() == 0) goto L82;
        String[] r4 = this.f7440a.getName().split("-");     // Catch: Throwable -> L79
        if (r4.length != 1) goto L15;
        long r9 = Long.parseLong(r4[0]);     // Catch: Throwable -> L79
        File r5 = this.f7440a.getParentFile();     // Catch: Throwable -> L79
        if (r5 == null) goto L16;
        r4 = r5.getName().split("-");     // Catch: Throwable -> L79
    L16:
        char r6 = 3;
        char r11 = 2;
        if (r4.length != 2) goto L19;
    L21:
        long r12 = Long.parseLong(r4[0]);     // Catch: Throwable -> L79
        int r1 = Integer.parseInt(r4[1]);     // Catch: Throwable -> L79
        if (r4.length != 3) goto L24;
        this.f7443d = Integer.parseInt(r4[2]);     // Catch: Throwable -> L79
        this.f = true;     // Catch: Throwable -> L79
    L24:
        BufferedReader r7 = new BufferedReader(new FileReader(r2));     // Catch: Throwable -> L79
        String r8 = r7.readLine();     // Catch: Throwable -> L79
        if (r8 == null) goto L78;
        if (r8.equals("V002") == false) goto L78;
        StringBuilder r10 = null;
    L30:
        String r14 = r7.readLine();     // Catch: Throwable -> L79
        if (r14 == null) goto L91;
        String[] r15 = r14.split(" ");     // Catch: Throwable -> L79
        if (r15.length == 5) goto L89;
    L35:
        char r16 = r11;
    L67:
        r11 = r16;
        r3 = 0;
        r6 = 3;
        goto L30
    L89:
        long r13 = Long.parseLong(r15[r3]);     // Catch: Throwable -> L83
        long r18 = Long.parseLong(r15[1]);     // Catch: Throwable -> L83
        int r17 = Integer.parseInt(r15[r11]);     // Catch: Throwable -> L83
        int r19 = Integer.parseInt(r15[r6]);     // Catch: Throwable -> L83
        String r20 = r15[4];     // Catch: Throwable -> L83
        if (r17 != r1) goto L35;
        if (r13 < r12) goto L35;
        if (r9 == 0) goto L43;
    L44:
        if (r9 != 0) goto L46;
    L48:
        this.f7444e = r19;     // Catch: Throwable -> L83
        if (r19 != 1) goto L52;
        this.h = r20;     // Catch: Throwable -> L83
    L52:
        if (this.f == true) goto L54;
        this.f7443d = r19;     // Catch: Throwable -> L83
        this.i = r20;     // Catch: Throwable -> L83
    L61:
        if (r10 == null) goto L87;
        r16 = 2;
    L66:
        r10.append("No.").append(r19).append("\n  time: ").append(com.bytedance.crash.o.d.a(r13)).append("\n  scope: ").append(r20).append("\n");     // Catch: Throwable -> L84
        goto L67
    L87:
        this.f7441b = true;     // Catch: Throwable -> L58
        r16 = 2;
        this.f7442c = new StringBuilder().append(r15[1]).append('-').append(r15[2]).toString();     // Catch: Throwable -> L84
        r10 = new StringBuilder();     // Catch: Throwable -> L84
    L58:
        r16 = 2;
        goto L67
    L54:
        int r110 = this.f7443d;     // Catch: Throwable -> L83
        if (r110 != (r19 + 1)) goto L59;
        this.i = r20;     // Catch: Throwable -> L58
        goto L61
    L59:
        if (r110 != r19) goto L61;
        this.j = r20;     // Catch: Throwable -> L58
        goto L61
    L46:
        if (r13 <= r9) goto L48;
    L43:
        if (r18 != r12) goto L35;
    L91:
    L76:
        return false;
    L69:
        if (this.f == true) goto L71;
    L73:
        if (r10 == null) goto L75;
        this.k = ("sid: " + this.f7442c + "\nperformed_count: " + this.f7443d + "\ntotal_performed_count: " + this.f7444e + "\n--- --- ---\n") + r10.toString();     // Catch: Throwable -> L76
    L75:
        return true;
    L71:
        if (this.f7443d != this.f7444e) goto L73;
        this.g = true;     // Catch: Throwable -> L76
    L78:
        return false;
    L19:
        if (r4.length == 3) goto L21;
        return false;
    L15:
        r9 = 0;
    L80:
        return r3;
    L82:
        return false;
    }

    public void b() {
        if (this.f7440a != null) goto L5;
        return;
    L5:
        if (this.k == null) goto L12;
        com.bytedance.crash.o.j.a(new File(this.f7440a, "protector_history.txt"), this.k, false);     // Catch: Throwable -> L8
        com.bytedance.crash.o.r.b("NPTH_PROT", "dump history file: " + this.f7440a.getName());     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public boolean c() {
        return this.f7441b;
    }

    public String d() {
        return this.f7442c;
    }

    public int e() {
        return this.f7443d;
    }

    public int f() {
        return this.f7444e;
    }

    public boolean g() {
        return this.f;
    }

    public boolean h() {
        return this.g;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.h;
    }

    public String k() {
        return this.j;
    }
}
