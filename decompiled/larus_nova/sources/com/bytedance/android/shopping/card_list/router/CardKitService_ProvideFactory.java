package com.bytedance.android.shopping.card_list.router;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes13.dex */
public final class CardKitService_ProvideFactory implements Factory<sc3.d> {
    private final a module;

    @Override // javax.inject.Provider
    public sc3.d get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CardKitService_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static CardKitService_ProvideFactory create(a r100) {
        return new CardKitService_ProvideFactory(r100);
    }

    public static sc3.d provideInstance(a r100) {
        return proxyProvide(r100);
    }

    public static sc3.d proxyProvide(a r100) {
        r100.getClass();
        return (sc3.d) Preconditions.checkNotNull(new b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
