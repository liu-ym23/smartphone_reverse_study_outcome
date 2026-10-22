package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.q;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.c;

/* JADX INFO: loaded from: classes45.dex */
public final class H5Module_ProvideInternalServiceFactory implements Factory<q> {
    private final c module;

    @Override // javax.inject.Provider
    public q get() {
        return provideInternalService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public H5Module_ProvideInternalServiceFactory(c r100) {
        this.module = r100;
    }

    public static H5Module_ProvideInternalServiceFactory create(c r100) {
        return new H5Module_ProvideInternalServiceFactory(r100);
    }

    public static q provideInternalService(c r100) {
        r100.getClass();
        return (q) Preconditions.checkNotNullFromProvides(new q());
    }
}
