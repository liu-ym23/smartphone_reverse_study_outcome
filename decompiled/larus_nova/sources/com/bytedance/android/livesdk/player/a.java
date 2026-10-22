package com.bytedance.android.livesdk.player;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILivePlayerClient f155150a;

    @Override // com.bytedance.android.livesdk.player.g
    public final ILivePlayerClient get() {
        return this.f155150a;
    }

    public a(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f155150a = r100;
    }
}
