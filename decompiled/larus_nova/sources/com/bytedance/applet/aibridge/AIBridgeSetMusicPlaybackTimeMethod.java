package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeSetMusicPlaybackTimeMethod;", "Lcom/bytedance/applet/aibridge/AbsSetMusicPlaybackTimeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsSetMusicPlaybackTimeMethodIDL$SetMusicPlaybackTimeParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsSetMusicPlaybackTimeMethodIDL$SetMusicPlaybackTimeResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeSetMusicPlaybackTimeMethod extends AbsSetMusicPlaybackTimeMethodIDL {
    public AIBridgeSetMusicPlaybackTimeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsSetMusicPlaybackTimeMethodIDL.a r103 = (AbsSetMusicPlaybackTimeMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = i.f191169b;
        if (r104 == null) goto L13;
        MusicPlayManagerDelegate r105 = MusicPlayManagerDelegate.f290176b;
        a88.e r106 = r105.a();
        if (r106 == null) goto L8;
        String r107 = r106.f2189a;
        if (r107 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r104, r107) == false) goto L12;
        r105.o(r104, r103.getPlaybackTime(), new m(r102));
        return;
    L12:
        f3.h.a.a(r102, "Failed to set music playback_time: current_music_id = " + r107 + ", latest_music_id = " + r104, null, null, 14);
        return;
    L8:
        r107 = "";
        goto L10
    L13:
        f3.h.a.a(r102, "Failed to set music playback_time: latest_music_id is null", null, null, 14);
    }
}
