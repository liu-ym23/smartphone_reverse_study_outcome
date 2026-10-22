package com.bytedance.crash.general;

import android.content.Context;
import com.bytedance.crash.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: GeneralInfoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f7488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f7489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppInfo f7491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RomInfo f7492e;
    private HardwareInfo f;

    public static void a() {
        a r0 = e();
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    private static a e() {
        if (f7488a != null) goto L18;
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f7488a != null) goto L12;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        File r2 = i.d();     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        if (r2 == null) goto L12;
        f7488a = new a(r1, r2);     // Catch: Throwable -> L14
    L12:
        monitor-exit(a.class);     // Catch: Throwable -> L14
    L18:
        return f7488a;
    }

    private a(Context r3, File r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f7489b = com.bytedance.crash.o.i.a(r4, "general");
        this.f7490c = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    public static long b() {
        a r0 = e();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.f().getJiffy();
    }

    private HardwareInfo f() {
        if (this.f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f != null) goto L8;
        this.f = HardwareInfo.get(this.f7490c, this.f7489b);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f;
    }

    private RomInfo g() {
        if (this.f7492e != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f7492e != null) goto L8;
        this.f7492e = RomInfo.get(this.f7489b);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f7492e;
    }

    private AppInfo h() {
        if (this.f7491d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f7491d != null) goto L8;
        this.f7491d = AppInfo.get(this.f7490c, this.f7489b);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f7491d;
    }

    public static void a(JSONObject r1) {
        a r0 = e();
        if (r0 == null) goto L6;
        r0.f().putTo(r1);
        return;
    }

    public static void b(JSONObject r1) {
        a r0 = e();
        if (r0 == null) goto L6;
        r0.g().putTo(r1);
        return;
    }

    public static void a(JSONObject r4, long r5) {
        a r0 = e();
        if (r0 == null) goto L13;
        AppInfo r1 = r0.h();
        if (r5 > 0) goto L7;
    L11:
        r1.putTo(r4);
        return;
    L7:
        if (r5 >= r1.mLastUpdateTime) goto L11;
        AppInfo r6 = AppInfo.findAppInfo(r0.f7489b, r5);
        if (r6 == null) goto L11;
        r1 = r6;
        goto L11
    }

    public static long a(long r4) {
        a r0 = e();
        if (r0 != null) goto L5;
    L12:
        return 0;
    L5:
        if (r4 == 0) goto L7;
        AppInfo r5 = AppInfo.findAppInfo(r0.f7489b, r4);
        if (r5 == null) goto L12;
        return r5.mLastUpdateTime;
    L7:
        return r0.h().mLastUpdateTime;
    }

    public static boolean c() {
        return c.a();
    }

    public static String d() {
        a r0 = e();
        if (r0 == null) goto L7;
        return r0.g().getRandomDeviceId();
    L7:
        return c.d();
    }
}
