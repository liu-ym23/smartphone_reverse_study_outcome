package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.C1669j;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class LifecycleCallback {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1642h f19557a;

    public LifecycleCallback(InterfaceC1642h interfaceC1642h) {
        this.f19557a = interfaceC1642h;
    }

    public static InterfaceC1642h c(Activity activity) {
        return d(new C1641g(activity));
    }

    public static InterfaceC1642h d(C1641g c1641g) {
        if (c1641g.d()) {
            return B0.q(c1641g.b());
        }
        if (c1641g.c()) {
            return z0.e(c1641g.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static InterfaceC1642h getChimeraLifecycleFragmentImpl(C1641g c1641g) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity activityI = this.f19557a.i();
        C1669j.k(activityI);
        return activityI;
    }

    public void e(int i10, int i11, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
