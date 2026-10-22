package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

/* loaded from: classes2.dex */
public final class g0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zak f19622a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zact f19623b;

    public g0(zact zactVar, zak zakVar) {
        this.f19623b = zactVar;
        this.f19622a = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zact.zad(this.f19623b, this.f19622a);
    }
}
