package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: compiled from: LarkAuthModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.c.g f10387c;

    public /* synthetic */ m(String r8, String r9, String r10, com.bytedance.safetyguard.lxc.internal.e.c.g r11, Throwable r12, int r13, d.h.b.h r14) {
        if ((r13 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        com.bytedance.safetyguard.lxc.internal.e.c.g r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        Throwable r6 = null;
    L14:
        this(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public final String a() {
        return this.f10385a;
    }

    public final String b() {
        return this.f10386b;
    }

    public final com.bytedance.safetyguard.lxc.internal.e.c.g c() {
        return this.f10387c;
    }

    public m(String r2, String r3, String r4, com.bytedance.safetyguard.lxc.internal.e.c.g r5, Throwable r6) {
        d.h.b.o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
        d.h.b.o.e(r3, "message");
        super(r3, r6);
        this.f10385a = r2;
        this.f10386b = r4;
        this.f10387c = r5;
    }
}
