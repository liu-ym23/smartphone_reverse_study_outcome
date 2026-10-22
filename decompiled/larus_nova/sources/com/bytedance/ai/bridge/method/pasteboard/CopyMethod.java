package com.bytedance.ai.bridge.method.pasteboard;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/pasteboard/CopyMethod;", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL$CopyParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL$CopyResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CopyMethod extends AbsCopyMethodIDL {
    public CopyMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsCopyMethodIDL.a r103 = (AbsCopyMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getContent();
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
        h.a.a(r102, "The content parameter should not be empty.", null, null, 14);
        return;
    L9:
        Activity r106 = r100.getOwnerActivity();
        if (r106 != null) goto L14;
        r106 = k.b();
        if (r106 != null) goto L14;
        h.a.a(r102, "context is null", null, null, 14);
        return;
    L14:
        r4.k r107 = a.f535984k;
        if (r107 != null) goto L17;
        h.a.a(r102, "system action depend is null", null, null, 14);
        return;
    L17:
        r107.b(r106, r100, this.f35759a, ClipData.newPlainText(r104, r104));
        if (r107.a(r106, r100, this.f35759a) == true) goto L20;
        h.a.a(r102, "no permission to copy", null, null, 14);
        return;
    L20:
        Intrinsics.checkNotNullParameter(AbsCopyMethodIDL.b.class, "<this>");
        r102.b((ResultModel) c.a(AbsCopyMethodIDL.b.class), "");
        return;
    L5:
        r105 = false;
        goto L7
    }
}
