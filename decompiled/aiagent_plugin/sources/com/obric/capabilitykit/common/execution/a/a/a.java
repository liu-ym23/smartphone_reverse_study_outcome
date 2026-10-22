package com.obric.capabilitykit.common.execution.a.a;

import d.h.b.h;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.capabilitykit.common.execution.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f32048c;

    public a() {
        this(null, null, null, 7, null);
    }

    public a(String r1, String r2, String r3) {
        this.f32046a = r1;
        this.f32047b = r2;
        this.f32048c = r3;
    }

    public /* synthetic */ a(String r2, String r3, String r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f32046a;
    }

    public final String b() {
        return this.f32047b;
    }

    public final String d() {
        return this.f32048c;
    }
}
