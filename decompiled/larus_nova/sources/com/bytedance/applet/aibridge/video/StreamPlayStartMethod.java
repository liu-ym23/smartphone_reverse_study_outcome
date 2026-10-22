package com.bytedance.applet.aibridge.video;

import c68.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaScene;
import com.larus.nova.R;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayStartMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL$PlayStreamParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL$PlayStreamResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayStartMethod extends AbsAIBridgePlayStreamMethodIDL {
    public StreamPlayStartMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r110, ParamModel r111, h r112) {
        AbsAIBridgePlayStreamMethodIDL.a r100 = (AbsAIBridgePlayStreamMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r101 = r100.getTitle();
        if (r101 != null) goto L5;
        r101 = AppHost.f326268a.getApplication().getString(R.string.larus_aiPodcast_title_cn);
    L5:
        String r102 = r101;
        String r103 = r100.getArtist();
        if (r103 != null) goto L8;
        r103 = AppHost.f326268a.getApplication().getString(R.string.larus_applet_stream_audio_default_artist_cn);
    L8:
        String r104 = r103;
        String r105 = r100.getAlbumArtUrl();
        String r106 = r100.getUuid();
        String r107 = r100.getUrl();
        JSONObject r108 = r100.getExtra();
        if (r108 != null) goto L11;
        r108 = new JSONObject();
    L11:
        JSONObject r113 = r108;
        g.f37637a.e("flow.playStreamAudio", "stream play url=" + r100.getUrl() + ", uuid=" + r100.getUuid() + ", title=" + r102 + ", albumArtUrl=" + r105 + ", extra=" + r113);
        int r109 = b.f22600a;
        b.d("AudioStream:JSB", "StreamPlayStartMethod called: url=" + r100.getUrl() + ", uuid=" + r100.getUuid() + ", title=" + r102 + ", albumArtUrl=" + r105 + ", extra=" + r113);
        AudioStreamPlayerDelegate r114 = AudioStreamPlayerDelegate.f290191b;
        a0 r115 = r110.getContainerContext();
        if (r115 == null) goto L14;
        String r116 = r115.getAppletId();
    L16:
        if (r116 != null) goto L18;
        String r117 = "";
    L19:
        com.bytedance.applet.utils.b r118 = com.bytedance.applet.utils.b.f192281a;
        r114.c(r117, r102, r104, r105, r107, r106, r100.getTimeOffset(), MediaScene.STREAM_PLAYER, r113);
        b.d("AudioStream:JSB", "AudioStreamPlayerDelegate.start called successfully");
        Intrinsics.checkNotNullParameter(AbsAIBridgePlayStreamMethodIDL.b.class, "<this>");
        r112.b((ResultModel) c.a(AbsAIBridgePlayStreamMethodIDL.b.class), "");
        return;
    L18:
        r117 = r116;
        goto L19
    L14:
        r116 = null;
        goto L16
    }
}
