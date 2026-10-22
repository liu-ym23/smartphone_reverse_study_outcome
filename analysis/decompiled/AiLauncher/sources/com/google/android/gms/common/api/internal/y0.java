package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class y0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f19697a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19698b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z0 f19699c;

    public y0(z0 z0Var, LifecycleCallback lifecycleCallback, String str) {
        this.f19699c = z0Var;
        this.f19697a = lifecycleCallback;
        this.f19698b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        z0 z0Var = this.f19699c;
        if (z0Var.f19702b > 0) {
            LifecycleCallback lifecycleCallback = this.f19697a;
            if (z0Var.f19703c != null) {
                bundle = z0Var.f19703c.getBundle(this.f19698b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.f19699c.f19702b >= 2) {
            this.f19697a.j();
        }
        if (this.f19699c.f19702b >= 3) {
            this.f19697a.h();
        }
        if (this.f19699c.f19702b >= 4) {
            this.f19697a.k();
        }
        if (this.f19699c.f19702b >= 5) {
            this.f19697a.g();
        }
    }
}
