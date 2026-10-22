package com.bytedance.android.live.soloktv.viewmodel;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytedance.ies.videoclip.api.player.IPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/live/soloktv/viewmodel/g;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/soloktv/viewmodel/g;)Lcom/bytedance/android/live/soloktv/viewmodel/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SoloKtvEditViewModel$init$1$onStatusChanged$1 extends Lambda implements Function1<g, g> {
    final /* synthetic */ IPlayer.PlayerStatus $status;

    public SoloKtvEditViewModel$init$1$onStatusChanged$1(IPlayer.PlayerStatus r100) {
        this.$status = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g invoke2(g r110) {
        Intrinsics.checkNotNullParameter(r110, "$receiver");
        return g.a(r110, 0, 0, 0, 0.0f, 0, this.$status, null, null, 479);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ g invoke(g r100) {
        return invoke2(r100);
    }
}
