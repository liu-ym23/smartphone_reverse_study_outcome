package com.obric.matrix.platform.sdk.ones.account;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AccountException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f33607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33608b;

    public /* synthetic */ a(int r1, String r2, Throwable r3, int r4, h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    public a(int r2, String r3, Throwable r4) {
        o.e(r3, "msg");
        super(r4);
        this.f33607a = r2;
        this.f33608b = r3;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "code: " + this.f33607a + ", msg: " + this.f33608b + ", cause: " + getCause();
    }
}
