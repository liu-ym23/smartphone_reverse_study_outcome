package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import fl2.a;
import hh2.c;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveReplayModule_ProvideFactory implements Factory<a> {
    private final c module;

    @Override // javax.inject.Provider
    public a get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ECLiveReplayModule_ProvideFactory(c r100) {
    }

    public static ECLiveReplayModule_ProvideFactory create(c r100) {
        return new ECLiveReplayModule_ProvideFactory(r100);
    }

    public static a provideInstance(c r100) {
        return proxyProvide(r100);
    }

    public static a proxyProvide(c r100) {
        throw null;
    }
}
