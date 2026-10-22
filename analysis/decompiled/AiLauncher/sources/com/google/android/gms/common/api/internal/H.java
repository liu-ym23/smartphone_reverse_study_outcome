package com.google.android.gms.common.api.internal;

/* loaded from: classes2.dex */
public final class H implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f19540a;

    public H(I i10) {
        this.f19540a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J j10 = this.f19540a.f19541a;
        j10.f19543b.a(j10.f19543b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
