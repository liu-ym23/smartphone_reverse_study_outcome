package com.bytedance.android.livesdk.player;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class t0 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ILivePlayerClient> f156199a;

    @Override // com.bytedance.android.livesdk.player.g
    public final ILivePlayerClient get() {
        return this.f156199a.get();
    }

    public t0(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f156199a = new WeakReference(r100);
    }
}
