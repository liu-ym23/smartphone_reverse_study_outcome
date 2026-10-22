package com.obric.autoaction.app.launcherpage.detail.base.container;

import java.time.LocalDate;

/* JADX INFO: compiled from: DetailDateViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocalDate f23310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocalDate f23311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23312c;

    public e() {
        this(null, null, false, 7, null);
    }

    public e(LocalDate r1, LocalDate r2, boolean r3) {
        this.f23310a = r1;
        this.f23311b = r2;
        this.f23312c = r3;
    }

    public /* synthetic */ e(LocalDate r2, LocalDate r3, boolean r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    public final LocalDate a() {
        return this.f23310a;
    }

    public final void a(LocalDate r1) {
        this.f23310a = r1;
    }

    public final LocalDate b() {
        return this.f23311b;
    }

    public final void b(LocalDate r1) {
        this.f23311b = r1;
    }

    public final boolean c() {
        return this.f23312c;
    }
}
