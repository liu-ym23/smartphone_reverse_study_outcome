package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetMusicResolutionInfoMethod;", "Lcom/bytedance/applet/aibridge/AbsGetMusicResolutionInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsGetMusicResolutionInfoMethodIDL$GetMusicResolutionInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsGetMusicResolutionInfoMethodIDL$GetMusicResolutionInfoResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetMusicResolutionInfoMethod extends AbsGetMusicResolutionInfoMethodIDL {
    public AIBridgeGetMusicResolutionInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetMusicResolutionInfoMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ArrayList r103 = new ArrayList();
        String r104 = i.f191169b;
        if (r104 == null) goto L10;
        Iterator<T> r105 = MusicPlayManagerDelegate.f290176b.i(r104).iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        String r106 = (String) r105.next();
        String r107 = i.f191168a.j(r106);
        if (r107 == null) goto L6;
        r103.add(r107);
    L10:
        String r108 = i.f191168a.j(MusicPlayManagerDelegate.f290176b.n());
        if (r108 != null) goto L13;
        r108 = "undefine";
    L13:
        Intrinsics.checkNotNullParameter(AbsGetMusicResolutionInfoMethodIDL.b.class, "<this>");
        BaseModel r109 = k3.c.a(AbsGetMusicResolutionInfoMethodIDL.b.class);
        AbsGetMusicResolutionInfoMethodIDL.b r110 = (AbsGetMusicResolutionInfoMethodIDL.b) r109;
        r110.setResolutionList(r103);
        r110.setCurrentResolution(r108);
        r102.b((ResultModel) r109, "");
    }
}
