package com.bytedance.android.live.platformplayer.effect;

import com.bytedance.android.livehostapi.foundation.depend.IToolsPluginInstallCallback;
import com.lynx.tasm.LynxError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements IToolsPluginInstallCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f85482a;

    @Override // com.bytedance.android.livehostapi.foundation.depend.IToolsPluginInstallCallback
    public final void onSuccess() {
        this.f85482a.invoke();
        com.bytedance.android.live.player.utils.b.g("LiveVrEffect_VrEffectDownloader", "tools plugin install success");
    }

    public c(Function0 r100) {
        this.f85482a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IToolsPluginInstallCallback
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.android.live.player.utils.b.e("tools plugin install failed");
    }
}
