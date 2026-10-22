package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: LogInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f5704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5708e;
    private List<String> f;
    private String g;
    private long h;
    private Throwable i;

    public h() {
        this.f5707d = 1;
        this.f5708e = 0;
        this.h = System.currentTimeMillis();
    }

    static {
        f5704a = new AnonymousClass1();
    }

    public static i a() {
        return new i();
    }

    public void a(long r1) {
        this.h = r1;
    }

    public void a(String r1) {
        this.f5705b = r1;
    }

    public void b(String r1) {
        this.f5706c = r1;
    }

    public int b() {
        return this.f5707d;
    }

    public void a(int r1) {
        this.f5707d = r1;
    }

    public void b(int r1) {
        this.f5708e = r1;
    }

    public void a(List<String> r3) {
        this.f = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void c(String r1) {
        this.g = r1;
    }

    public Throwable c() {
        return this.i;
    }

    public void a(Throwable r1) {
        this.i = r1;
    }

    public String d() {
        int r1 = this.f5707d;
        if (r1 != 0) goto L5;
        return "VERBOSE";
    L5:
        if (r1 != 1) goto L7;
        return "DEBUG";
    L7:
        if (r1 != 2) goto L9;
        return "INFO";
    L9:
        if (r1 != 3) goto L11;
        return "WARN";
    L11:
        if (r1 != 4) goto L13;
        return "ERROR";
    L13:
        if (r1 == 5) goto L16;
        return "";
    L16:
        return "ASSERT";
    }

    public String e() {
        switch(this.f5708e) {
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L16;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L10;
            case 14: goto L8;
            case 15: goto L6;
            default: goto L4;
        };
    L4:
        return "DEFAULT";
    L6:
        return "ONE_ID";
    L8:
        return "COMPRESS";
    L10:
        return "EVENT_PRIORITY";
    L12:
        return "EVENT_SAMPLING";
    L14:
        return "REQUEST";
    L16:
        return "PICKER";
    L18:
        return "USER_PROFILE";
    L20:
        return "MONITOR";
    L22:
        return "VIEW_EXPOSURE";
    L24:
        return "EVENT_VERIFY";
    L26:
        return "DATABASE";
    L28:
        return "EVENT";
    L30:
        return "ALINK";
    L32:
        return "ABTEST";
    L34:
        return "DEVICE_REGISTER";
    }

    public String f() {
        List<String> r0 = this.f;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.size() <= 0) goto L20;
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
    L8:
        if (r2 >= this.f.size()) goto L14;
        r1.append((String) ZeusTransformUtils.preCheckCast(this.f.get(r2), String.class, "com.obric.aiagent.plugin"));
        if (r2 >= (this.f.size() - 1)) goto L12;
        r1.append(",");
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return r1.toString();
    L20:
        return "";
    }

    public String g() {
        if (this.h > 0) goto L5;
        return "--";
    L5:
        return ((SimpleDateFormat) ZeusTransformUtils.preCheckCast(f5704a.get(), SimpleDateFormat.class, "com.obric.aiagent.plugin")).format(new Date(this.h));
    }

    public String toString() {
        String r0 = "[" + g() + "][" + d() + "][" + a(this.f5705b) + "][" + a(this.f5706c) + "][" + e() + "][" + f() + "] " + a(this.g);
        if (c() != null) goto L5;
        return r0;
    L5:
        return r0 + "\nstacktrace: " + b(c());
    }

    public String h() {
        return "[" + d() + "][" + a(this.f5705b) + "] " + a(this.g);
    }

    public String i() {
        return a(this.g);
    }

    private String a(Object r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.toString();
    }

    private String b(Throwable r2) {
        StringBuilder r0 = new StringBuilder();
    L3:
        if (r2 == null) goto L6;
        a(r0, r2);
        r2 = r2.getCause();
        goto L3
    L6:
        return r0.toString();
    }

    private void a(StringBuilder r4, Throwable r5) {
        r4.append(r5.toString());
        StackTraceElement[] r3 = r5.getStackTrace();
        int r6 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        StackTraceElement r1 = r3[r0];
        r4.append("\n\tat ").append(r1);
        r0 = r0 + 1;
        goto L3
    }
}
