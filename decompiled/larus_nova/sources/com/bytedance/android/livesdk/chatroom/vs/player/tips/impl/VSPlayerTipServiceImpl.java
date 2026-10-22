package com.bytedance.android.livesdk.chatroom.vs.player.tips.impl;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.progress.context.a;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class VSPlayerTipServiceImpl implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f117751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f117752b;

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final PlayerTipsContext provideVSPlayTipsContext() {
        return (PlayerTipsContext) this.f117751a.getValue();
    }

    public VSPlayerTipServiceImpl() {
        this.f117751a = LazyKt.lazy(VSPlayerTipServiceImpl$mContext$2.INSTANCE);
        this.f117752b = "IVSPlayerTipService[" + hashCode() + ']';
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final void hidePlayerTip(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ALogger.d(this.f117752b, "start post hide event for " + r100);
        ((PlayerTipsContext) this.f117751a.getValue()).getMHidePlayerTipEvent().post(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final void showPlayerTipWithCustomView(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "view");
        a r102 = new a(r100, r101);
        ALogger.d(this.f117752b, "start post show custom tip for ".concat(r100));
        ((PlayerTipsContext) this.f117751a.getValue()).getMShowPlayerTipEvent().post(r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final void showPlayerTip(String r100, CharSequence r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "content");
        a r102 = new a(r100, 0, r101, null, r110);
        ALogger.d(this.f117752b, "start post show default tip for ".concat(r100));
        ((PlayerTipsContext) this.f117751a.getValue()).getMShowPlayerTipEvent().post(r102);
    }
}
