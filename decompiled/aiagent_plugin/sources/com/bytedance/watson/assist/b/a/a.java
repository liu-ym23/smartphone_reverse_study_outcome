package com.bytedance.watson.assist.b.a;

import android.os.SystemClock;
import com.bytedance.watson.assist.a.c;
import com.bytedance.watson.assist.d.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AbnormalManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f11819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11821c;

    public a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        this.f11820b = false;
        this.f11819a = r4;
    }

    public boolean a() {
        b();
        return this.f11820b;
    }

    private void b() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.f11821c;
        if (r2 != 0) goto L5;
    L6:
        this.f11821c = r0;
        float r1 = this.f11819a.e();
        int r3 = this.f11819a.d();
        int r4 = this.f11819a.c();
        boolean r5 = false;
        if (r1 <= this.f11819a.a().b()) goto L9;
        boolean r6 = false;
    L11:
        if (r3 >= this.f11819a.a().c()) goto L13;
        r6 = false;
    L13:
        if (r4 == 1) goto L16;
        r5 = r6;
    L16:
        b.b("updateCpuSampleEnvironment:" + r5 + ", temp:" + r1 + ", level:" + r3 + ", powerSave:" + r4);
        this.f11820b = r5;
        return;
    L9:
        r6 = true;
        goto L11
    L5:
        if ((r0 - r2) >= 5000) goto L6;
    }

    public boolean a(float r10) {
        if (a() == true) goto L6;
        b.b("isAbnormalProcess false, cpuSpeed " + r10 + ", not sample environment");
        return false;
    L6:
        com.bytedance.watson.assist.a.a.C0262a r0 = this.f11819a.a().a();
        if (r0 != null) goto L10;
        b.b("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:null");
        return true;
    L10:
        float r4 = r0.a();
        float r1 = r0.b();
        if (r10 >= r4) goto L13;
        return false;
    L13:
        if (r1 <= 0.0d) goto L20;
        c.b r9 = this.f11819a.g();
        if (r9 == null) goto L20;
        b.b("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r4 + ", bigCorePercent:" + r9.o + ", config bigCorePercent:" + r1);
        if (r9.o > r1) goto L19;
        return false;
    L19:
        return true;
    L20:
        b.b("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r4);
        return true;
    }
}
