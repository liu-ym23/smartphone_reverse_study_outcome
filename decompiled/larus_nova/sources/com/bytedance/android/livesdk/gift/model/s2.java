package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.livesdk.message.model.o7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s2 implements gm2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o7 f126412a;

    @Override // gm2.g
    public final o7 getGiftMessage() {
        return this.f126412a;
    }

    public s2(o7 r100) {
        Intrinsics.checkNotNullParameter(r100, "giftMessage");
        this.f126412a = r100;
    }
}
