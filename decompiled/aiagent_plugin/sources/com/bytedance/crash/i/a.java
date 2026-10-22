package com.bytedance.crash.i;

import android.os.Process;
import com.bytedance.crash.i;
import com.bytedance.crash.mira.b;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.m;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: PluginInfoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f7512a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f7513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f7514c;

    static /* synthetic */ void b() {
        e();
    }

    static {
        f7512a = Pattern.compile("^(\\d+)-(\\d+)\\.json");
    }

    private static File c() {
        if (f7513b != null) goto L8;
        File r0 = i.d();
        if (r0 == null) goto L8;
        f7513b = com.bytedance.crash.o.i.a(r0, "plugin");
    L8:
        return f7513b;
    }

    private static File d() {
        if (f7514c != null) goto L8;
        long r0 = i.f();
        int r2 = Process.myPid();
        File r3 = c();
        if (r3 == null) goto L8;
        f7514c = new File(r3, r0 + "-" + r2 + ".json");
    L8:
        return f7514c;
    }

    private static File a(String r3) {
        File r0 = c();
        if (r0 != null) goto L5;
        return null;
    L5:
        return new File(r0, r3 + ".json");
    }

    public static void a() {
        com.example.npth_morpheus.a.a();     // Catch: Throwable -> L6
    L10:
        com.bytedance.crash.mira.a.a();     // Catch: Throwable -> L7
    L4:
        b.a(new AnonymousClass1());
        DefaultWorkThread.postDelayed(new AnonymousClass2(), 1000);
    }

    private static boolean b(String r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L12;
        char r2 = r4.charAt(r1);
        if (r2 < '0') goto L11;
        if (r2 > '9') goto L11;
        r1 = r1 + 1;
    L11:
        return false;
    L12:
        return true;
    }

    private static void e() {
        File r0 = c();
        if (r0 != null) goto L5;
        return;
    L5:
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.length == 0) goto L69;
        long r2 = System.currentTimeMillis();
        ArrayList r3 = new ArrayList();
        File[] r4 = new File("/proc").listFiles();
        int r5 = 0;
        if (r4 != null) goto L13;
    L20:
        ArrayList r6 = new ArrayList();
        File r7 = com.bytedance.crash.crash.b.a();
        if (r7 == null) goto L29;
        File[] r8 = r7.listFiles();
        if (r8 == null) goto L29;
        if (r8.length == 0) goto L29;
        int r9 = r8.length;
        int r10 = 0;
    L27:
        if (r10 >= r9) goto L29;
        r6.add(r8[r10].getName() + ".json");
        r10 = r10 + 1;
    L29:
        File[] r11 = new File(i.d(), "anr").listFiles();
        if (r11 != null) goto L32;
    L36:
        int r12 = r1.length;
    L37:
        if (r5 >= r12) goto L70;
        File r13 = r1[r5];
        String r14 = r13.getName();
        if (r6.contains(r14) == true) goto L56;
        Matcher r15 = f7512a.matcher(r14);
        if (r15.find() == true) goto L44;
    L55:
        com.bytedance.crash.o.i.c(r13);
        goto L56
    L44:
        if (r15.groupCount() != 2) goto L55;
        String r16 = r15.group(1);
        long r17 = 0;
        if (r16 == null) goto L48;
        r17 = Long.parseLong(r16);
    L48:
        String r18 = r15.group(2);
        if (r17 == i.f()) goto L56;
        if (r17 > r2) goto L56;
        if (r3.contains(r18) == false) goto L55;
    L56:
        r5 = r5 + 1;
        goto L37
    L70:
        return;
    L32:
        if (r11.length == 0) goto L36;
        int r19 = r11.length;
        int r20 = 0;
    L34:
        if (r20 >= r19) goto L36;
        r6.add(r11[r20].getName() + ".json");
        r20 = r20 + 1;
        goto L34
    L13:
        if (r4.length == 0) goto L20;
        int r21 = r4.length;
        int r22 = 0;
    L15:
        if (r22 >= r21) goto L20;
        File r23 = r4[r22];
        if (b(r23.getName()) == false) goto L19;
        r3.add(r23.getName());
    L19:
        r22 = r22 + 1;
        goto L15
    }

    private static void update() {
        if (b.b() == true) goto L5;
        return;
    L5:
        JSONArray r0 = b.a();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length() == 0) goto L21;
        BufferedWriter r1 = new BufferedWriter(new FileWriter(d(), false));     // Catch: Throwable -> L15
        JSONObject r2 = new JSONObject();
        r2.put("plugin_info", r0);     // Catch: Throwable -> L14
        r2.put("mira_init", true);     // Catch: Throwable -> L14
        m.a(r2, r1);     // Catch: Throwable -> L14
    L12:
        com.bytedance.crash.o.i.a(r1);
        return;
    L22:
        return;
    }

    public static void a(JSONObject r1, File r2) {
        File r3 = a(r2.getName());
        if (r3 != null) goto L5;
    L12:
        l.a(r1, "mira_init", false);
        return;
    L5:
        if (r3.exists() == false) goto L12;
        String r4 = com.bytedance.crash.o.i.d(r3);
        if (r4 == null) goto L12;
        l.b(r1, new JSONObject(r4));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        com.bytedance.crash.c.b.b("pushTo", th);
        goto L12
    }
}
