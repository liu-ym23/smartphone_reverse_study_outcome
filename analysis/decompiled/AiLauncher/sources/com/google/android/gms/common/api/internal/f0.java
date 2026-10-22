package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes2.dex */
public final class f0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zact f19620a;

    public f0(zact zactVar) {
        this.f19620a = zactVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f19620a.zah.c(new ConnectionResult(4));
    }
}
