package com.google.android.gms.common.api.internal;

/* loaded from: classes2.dex */
public final class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19538a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ J f19539b;

    public G(J j10, int i10) {
        this.f19539b = j10;
        this.f19538a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f19539b.i(this.f19538a);
    }
}
