package com.bytedance.safetyguard.lxc.internal.e.h;

import com.bytedance.safetyguard.lxc.internal.e.c.g;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarTokenResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f10848d;

    public /* synthetic */ a(String r2, String r3, String r4, g r5, int r6, h r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public final String a() {
        return this.f10845a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f10846b;
    }

    public final String b() {
        return this.f10847c;
    }

    public final g c() {
        return this.f10848d;
    }

    public a(String r2, String r3, String r4, g r5) {
        o.e(r2, "subtype");
        o.e(r3, "message");
        super(r3);
        this.f10845a = r2;
        this.f10846b = r3;
        this.f10847c = r4;
        this.f10848d = r5;
    }
}
