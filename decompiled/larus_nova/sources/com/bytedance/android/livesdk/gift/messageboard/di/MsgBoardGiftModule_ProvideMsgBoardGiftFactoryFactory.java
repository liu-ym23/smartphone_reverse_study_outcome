package com.bytedance.android.livesdk.gift.messageboard.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fz1.a;
import fz1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideMsgBoardGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory(b r100) {
        this.module = r100;
    }

    public static MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory create(b r100) {
        return new MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory(r100);
    }

    public static h.a provideMsgBoardGiftFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}
