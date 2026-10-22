package com.bytedance.android.live.broadcastgame.opengame.debug;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements com.bytedance.android.live.broadcastgame.opengame.i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f60006a;

    @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
    public final void onInitSuccess() {
        d.b(this.f60006a);
    }

    public f(d r100) {
        this.f60006a = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
    public final void a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        d.a(this.f60006a, r100);
    }
}
