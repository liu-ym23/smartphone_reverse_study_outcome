package com.smt.obric.appstore.ui.app;

import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.k0;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends androidx.lifecycle.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f18185e;

    public c(SavedStateRegistryOwner r10, Bundle r11) {
        q.g(r10, "owner");
        super(r10, r11);
        this.f18185e = r11;
    }

    @Override // androidx.lifecycle.a
    public k0 c(String r10, Class r11, b0 r12) {
        q.g(r10, "key");
        q.g(r11, "modelClass");
        q.g(r12, "handle");
        if (q.b(r11, AppStatusViewModel.class) == false) goto L6;
        AppStatusViewModel r13 = AppStatusViewModel.a.f18167a.a();
        q.e(r13, "null cannot be cast to non-null type T of com.smt.obric.appstore.ui.app.AppStatusViewModelFactory.create");
        return r13;
    L6:
        q.e(null, "null cannot be cast to non-null type T of com.smt.obric.appstore.ui.app.AppStatusViewModelFactory.create");
        return null;
    }
}
