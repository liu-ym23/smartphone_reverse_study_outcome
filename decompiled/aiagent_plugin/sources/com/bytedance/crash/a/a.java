package com.bytedance.crash.a;

import com.bytedance.crash.config.h;
import org.json.JSONArray;

/* JADX INFO: compiled from: CoreDumpConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONArray f7102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7105e;

    public a(JSONArray r4, boolean r5, boolean r6, boolean r7) {
        this.f7105e = null;
        int r1 = 0;
        if (r5 == false) goto L6;
        if (r6 == false) goto L6;
        boolean r8 = true;
    L7:
        this.f7101a = r8;
        if (r4 != null) goto L10;
    L11:
        this.f7101a = false;
    L13:
        if (this.f7101a == false) goto L20;
        StringBuffer r9 = new StringBuffer("");
        boolean r10 = "1".equals(r4.optString(0));
    L16:
        if (r1 >= r4.length()) goto L18;
        r9.append(r4.optString(r1) + "#");
        r1 = r1 + 1;
        goto L16
    L18:
        this.f7101a = r10;
        this.f7105e = r9.toString();
    L22:
        this.f7103c = r7;
        return;
    L20:
        if (h.g() == false) goto L22;
        this.f7101a = true;
        this.f7105e = "1#all#all#null#lib#SIG#0#0#7#";
        goto L22
    L10:
        if (r4.length() < 10) goto L13;
    L6:
        r8 = false;
        goto L7
    }

    public String a() {
        return this.f7105e;
    }

    public boolean b() {
        return this.f7101a;
    }

    public boolean c() {
        return this.f7104d;
    }

    public String toString() {
        return "CoreDumpConfig{isEnable=" + this.f7101a + ", nativeCrashFeature=" + this.f7102b + '}';
    }
}
