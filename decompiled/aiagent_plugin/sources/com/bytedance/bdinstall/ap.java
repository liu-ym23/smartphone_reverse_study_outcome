package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InstallUrl.java */
/* JADX INFO: loaded from: classes.dex */
public class ap implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6138c;

    public static ap a(String r3, boolean r4) {
        String r0 = r3 + "/service/2/device_register/";
        String r1 = r3 + "/service/2/app_alert_check/";
        if (r4 == false) goto L7;
        return new ap(r0, r1, r3 + "/service/1/client_context/");
    L7:
        return new ap(r0, r1);
    }

    public ap(String r2, String r3) {
        this.f6138c = "";
        this.f6136a = a(r2);
        this.f6137b = a(r3);
    }

    public ap(String r2, String r3, String r4) {
        this.f6138c = "";
        this.f6136a = a(r2);
        this.f6137b = a(r3);
        this.f6138c = a(r4);
    }

    private String a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        return r1;
    L5:
        if (r1.startsWith("https") == true) goto L9;
        throw new IllegalArgumentException("url protocol should be https");
    }

    public String a() {
        return this.f6136a;
    }

    public String b() {
        return this.f6137b;
    }

    public String c() {
        return this.f6138c;
    }

    public String toString() {
        return "{r='" + this.f6136a + "', a='" + this.f6137b + "', v='" + this.f6138c + "'}";
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ap.class) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(this.f6137b, ((ap) ZeusTransformUtils.preCheckCast(r7, ap.class, "com.obric.aiagent.plugin")).f6137b) == false) goto L15;
        if (TextUtils.equals(this.f6136a, ((ap) ZeusTransformUtils.preCheckCast(r7, ap.class, "com.obric.aiagent.plugin")).f6136a) == false) goto L15;
        if (TextUtils.equals(this.f6138c, ((ap) ZeusTransformUtils.preCheckCast(r7, ap.class, "com.obric.aiagent.plugin")).f6138c) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
