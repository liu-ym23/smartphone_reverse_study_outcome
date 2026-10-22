package com.bytedance.applet.aibridge.ecommerce.impl;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsUpdateECommercePageInfoMethodIDL;
import com.larus.platform.api.l2;
import com.larus.platform.service.l0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/UpdateECommercePageInfoMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL$UpdateECommercePageInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL$UpdateECommercePageInfoResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateECommercePageInfoMethod extends AbsUpdateECommercePageInfoMethodIDL {

    public static final class a {
    }

    static {
    }

    public UpdateECommercePageInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsUpdateECommercePageInfoMethodIDL.a r103 = (AbsUpdateECommercePageInfoMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r104 = r100.getOwnerActivity();
        if ((r104 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r105 = (FragmentActivity) r104;
    L6:
        if (r105 == null) goto L10;
        l2 r106 = l0.a();
        if (r106 == null) goto L10;
        r106.d(r105, r103.getPageAction(), r103.getCurrentPage(), r103.getSource());
    L10:
        Intrinsics.checkNotNullParameter(AbsUpdateECommercePageInfoMethodIDL.b.class, "<this>");
        r102.b((ResultModel) c.a(AbsUpdateECommercePageInfoMethodIDL.b.class), "");
        return;
    L5:
        r105 = null;
        goto L6
    }
}
