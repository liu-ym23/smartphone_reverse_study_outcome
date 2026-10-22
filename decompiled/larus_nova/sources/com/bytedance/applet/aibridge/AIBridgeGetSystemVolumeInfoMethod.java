package com.bytedance.applet.aibridge;

import android.media.AudioManager;
import android.os.Build;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetSystemVolumeInfoMethod;", "Lcom/bytedance/applet/aibridge/AbsGetSystemVolumeInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsGetSystemVolumeInfoMethodIDL$GetSystemVolumeInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsGetSystemVolumeInfoMethodIDL$GetSystemVolumeInfoResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetSystemVolumeInfoMethod extends AbsGetSystemVolumeInfoMethodIDL {
    public AIBridgeGetSystemVolumeInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetSystemVolumeInfoMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Object r103 = AppHost.f326268a.getApplication().getSystemService("audio");
        if ((r103 instanceof AudioManager) == false) goto L5;
        AudioManager r104 = (AudioManager) r103;
    L6:
        int r105 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L10;
        if (r104 == null) goto L10;
        int r106 = r104.getStreamMinVolume(3);
    L11:
        if (r104 == null) goto L13;
        r105 = r104.getStreamVolume(3);
    L13:
        if (r104 == null) goto L15;
        int r107 = r104.getStreamMaxVolume(3);
    L16:
        double r108 = ((double) (r105 - r106)) / ((double) (r107 - r106));
        Intrinsics.checkNotNullParameter(AbsGetSystemVolumeInfoMethodIDL.b.class, "<this>");
        BaseModel r109 = k3.c.a(AbsGetSystemVolumeInfoMethodIDL.b.class);
        ((AbsGetSystemVolumeInfoMethodIDL.b) r109).setVolume(r108);
        r102.b((ResultModel) r109, "");
        return;
    L15:
        r107 = 15;
    L10:
        r106 = 0;
        goto L11
    L5:
        r104 = null;
        goto L6
    }
}
