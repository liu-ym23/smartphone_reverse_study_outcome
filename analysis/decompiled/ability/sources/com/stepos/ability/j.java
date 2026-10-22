package com.stepos.ability;

import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;

/* loaded from: classes3.dex */
public final class j implements ComponentSupplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3099a;

    public j(k kVar) {
        this.f3099a = kVar;
    }

    @Override // dagger.hilt.android.internal.managers.ComponentSupplier
    public final Object get() {
        return new DaggerApp_HiltComponents_SingletonC$SingletonCImpl(new ApplicationContextModule(this.f3099a));
    }
}
