package com.obric.aiagent.assistant.utils;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f16313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f16314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16316d;

    public c() {
        this(null, null, false, false, 15, null);
    }

    public c(a r2, f r3, boolean r4, boolean r5) {
        o.e(r2, "enableStatus");
        o.e(r3, "privacyApprovalStatus");
        this.f16313a = r2;
        this.f16314b = r3;
        this.f16315c = r4;
        this.f16316d = r5;
    }

    public /* synthetic */ c(a r2, f r3, boolean r4, boolean r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = a.f16303a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = f.f16325a;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }

    public final a a() {
        return this.f16313a;
    }

    public final void a(a r2) {
        o.e(r2, "<set-?>");
        this.f16313a = r2;
    }

    public final void a(f r2) {
        o.e(r2, "<set-?>");
        this.f16314b = r2;
    }

    public final void a(boolean r1) {
        this.f16315c = r1;
    }

    public final boolean b() {
        return this.f16315c;
    }

    public final void b(boolean r1) {
        this.f16316d = r1;
    }

    public String toString() {
        return "AppEnableStatus = " + this.f16313a.name() + ", PrivacyApprovalStatus = " + this.f16314b.name() + ", isRoleAssistant = " + this.f16315c + ", isLogin = " + this.f16316d;
    }
}
