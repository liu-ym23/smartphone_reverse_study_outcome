package com.bytedance.android.livesdk.livecommerce.playback;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.j;
import zi2.a;
import zi2.b;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackModule_ProvideFactory implements Factory<j> {
    private final a module;

    @Override // javax.inject.Provider
    public j get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ExplainPlaybackModule_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static ExplainPlaybackModule_ProvideFactory create(a r100) {
        return new ExplainPlaybackModule_ProvideFactory(r100);
    }

    public static j provideInstance(a r100) {
        return proxyProvide(r100);
    }

    public static j proxyProvide(a r100) {
        r100.getClass();
        return (j) Preconditions.checkNotNull(b.f572232a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
