package com.obric.oui.textswitcher;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f36488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f36489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f36490c;

    public e() {
        this(0, 0, false, 7, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
        return false;
    L8:
        e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if (this.f36488a == r10.f36488a) goto L12;
        return false;
    L12:
        if (this.f36489b == r10.f36489b) goto L15;
        return false;
    L15:
        if (this.f36490c == r10.f36490c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((Long.hashCode(this.f36488a) * 31) + Long.hashCode(this.f36489b)) * 31;
        boolean r3 = this.f36490c;
        ?? r4 = r3;
        if (r3 == false) goto L6;
        r4 = 1;
    L6:
        return r0 + r4;
    }

    public String toString() {
        return "TextSwitcherTriggerSpec(startDelayMs=" + this.f36488a + ", showInternalMs=" + this.f36489b + ", isOneLineNeedSwitch=" + this.f36490c + ')';
    }

    public e(long r1, long r3, boolean r5) {
        this.f36488a = r1;
        this.f36489b = r3;
        this.f36490c = r5;
    }

    public /* synthetic */ e(long r7, long r9, boolean r11, int r12, h r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = 1000;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r11 = false;
    L11:
        this(r1, r3, r11);
    }

    public final long a() {
        return this.f36488a;
    }

    public final long b() {
        return this.f36489b;
    }

    public final boolean c() {
        return this.f36490c;
    }
}
