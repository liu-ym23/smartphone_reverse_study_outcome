package com.bytedance.applet.aibridge;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applet/aibridge/IsFromPushMethod;", "Lcom/bytedance/applet/aibridge/AbsIsFromPushMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsIsFromPushMethodIDL$IsFromPushParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsIsFromPushMethodIDL$IsFromPushResultModel;", "findFlowActivity", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsFromPushMethod extends AbsIsFromPushMethodIDL {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f190870a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f190870a = r100;
        }
    }

    public IsFromPushMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsIsFromPushMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r103 = r100.getContainerContext();
        FlowCommonAppCompatActivity r104 = null;
        if (r103 == null) goto L5;
        ContainerType r105 = r103.getContainerType();
    L6:
        if (r105 != null) goto L8;
        int r106 = -1;
    L10:
        if (r106 != 1) goto L12;
    L14:
        View r107 = r100.getEngineView();
        if (r107 == null) goto L25;
        Context r108 = r107.getContext();
        if (r108 == null) goto L25;
    L18:
        if (r108 == null) goto L25;
        if ((r108 instanceof FlowCommonAppCompatActivity) == true) goto L21;
        if ((r108 instanceof ContextWrapper) == false) goto L25;
        r108 = ((ContextWrapper) r108).getBaseContext();
        goto L18
    L21:
        r104 = (FlowCommonAppCompatActivity) r108;
    L25:
        if (r104 == null) goto L27;
        boolean r109 = r104.f326855a;
    L28:
        Intrinsics.checkNotNullParameter(AbsIsFromPushMethodIDL.b.class, "<this>");
        BaseModel r110 = k3.c.a(AbsIsFromPushMethodIDL.b.class);
        ((AbsIsFromPushMethodIDL.b) r110).setValue(r109);
        r102.b((ResultModel) r110, "");
        return;
    L27:
        r109 = false;
        goto L28
    L12:
        if (r106 == 2) goto L14;
        f3.h.a.a(r102, "MUST invoke applet.isFromPush in page and widget.", null, null, 14);
        return;
    L8:
        r106 = a.f190870a[r105.ordinal()];
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
