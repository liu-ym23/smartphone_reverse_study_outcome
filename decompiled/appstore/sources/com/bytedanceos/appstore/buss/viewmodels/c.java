package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ViewModelProvider.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8996e;

    public c(int r10, int r11) {
        this.f8995d = r10;
        this.f8996e = r11;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        q.g(r10, "modelClass");
        return new PageAppsViewModel(this.f8995d, this.f8996e);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        return new PageAppsViewModel(this.f8995d, this.f8996e);
    }
}
