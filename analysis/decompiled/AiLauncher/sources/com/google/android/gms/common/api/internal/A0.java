package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class A0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f19512a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19513b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ B0 f19514c;

    public A0(B0 b02, LifecycleCallback lifecycleCallback, String str) {
        this.f19514c = b02;
        this.f19512a = lifecycleCallback;
        this.f19513b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        B0 b02 = this.f19514c;
        if (b02.f19518b > 0) {
            LifecycleCallback lifecycleCallback = this.f19512a;
            if (b02.f19519c != null) {
                bundle = b02.f19519c.getBundle(this.f19513b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.f19514c.f19518b >= 2) {
            this.f19512a.j();
        }
        if (this.f19514c.f19518b >= 3) {
            this.f19512a.h();
        }
        if (this.f19514c.f19518b >= 4) {
            this.f19512a.k();
        }
        if (this.f19514c.f19518b >= 5) {
            this.f19512a.g();
        }
    }
}
