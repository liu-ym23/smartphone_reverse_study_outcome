package com.bytedance.crash.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnsureConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7353e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f7354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f7356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7357d;

    public d(Set<String> r3, JSONObject r4, boolean r5) {
        this.f7354a = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        this.f7355b = r5;
        if (r4 == null) goto L5;
        this.f7356c = r4;
        return;
    L5:
        this.f7356c = new JSONObject();
    }

    public d(boolean r1) {
        this.f7357d = r1;
    }

    public boolean a(String r5) {
        if (this.f7357d == false) goto L5;
        return true;
    L5:
        JSONObject r4 = this.f7356c;
        if (r4 == null) goto L12;
        double r6 = r4.optDouble(r5, 1.0d);
        if (Math.random() <= r6) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    }

    public static void a(boolean r0) {
        f7353e = r0;
    }

    public boolean a() {
        if (this.f7357d == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f7355b == true) goto L8;
        return false;
    }

    public boolean a(String r3, String r4) {
        if (f7353e == false) goto L6;
        return false;
    L6:
        if (b(r3) == true) goto L9;
        return false;
    L9:
        return a(r4);
    }

    public boolean b(String r4) {
        if (f7353e == false) goto L6;
        return false;
    L6:
        if (this.f7357d == false) goto L9;
        return true;
    L9:
        if ("core_exception_monitor".equals(r4) == true) goto L11;
        Set<String> r3 = this.f7354a;
        if (r3 != null) goto L15;
        return false;
    L15:
        if (r3.contains(r4) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return this.f7355b;
    }

    public String toString() {
        return "EnsureConfig{sampledLogType=" + this.f7354a + ", isCoreExceptionEnable=" + this.f7355b + ", exceptionMessage=" + this.f7356c + ", isAllEnable=" + this.f7357d + '}';
    }
}
