package com.obric.aiagent.skill.virt.impl.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VirtBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21896d;

    public static /* synthetic */ b a(b r3, String r4, String r5, long r6, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f21893a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f21894b;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f21895c;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.f21896d;
    L14:
        String r7 = r4;
        return r3.a(r7, r11, r0, r8);
    }

    public final b a(String r7, String r8, long r9, String r11) {
        o.e(r7, "command");
        o.e(r8, "workDir");
        o.e(r11, DBHelper.BATTERY_COL_SCENE);
        return new b(r7, r8, r9, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21893a, r10.f21893a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21894b, r10.f21894b) == true) goto L15;
        return false;
    L15:
        if (this.f21895c == r10.f21895c) goto L18;
        return false;
    L18:
        if (o.a(this.f21896d, r10.f21896d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f21893a.hashCode() * 31) + this.f21894b.hashCode()) * 31) + Long.hashCode(this.f21895c)) * 31) + this.f21896d.hashCode();
    }

    public String toString() {
        return "BackendSyncShellRequest(command=" + this.f21893a + ", workDir=" + this.f21894b + ", timeoutMs=" + this.f21895c + ", scene=" + this.f21896d + ')';
    }

    public b(String r2, String r3, long r4, String r6) {
        o.e(r2, "command");
        o.e(r3, "workDir");
        o.e(r6, DBHelper.BATTERY_COL_SCENE);
        this.f21893a = r2;
        this.f21894b = r3;
        this.f21895c = r4;
        this.f21896d = r6;
    }

    public final String a() {
        return this.f21893a;
    }

    public final String b() {
        return this.f21894b;
    }

    public final long c() {
        return this.f21895c;
    }

    public final String d() {
        return this.f21896d;
    }
}
