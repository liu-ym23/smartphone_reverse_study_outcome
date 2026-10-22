package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.CloseSocketResultModel;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "closeSocket")
public final class k extends e7.c<e7.d0, CloseSocketResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38714a;

    public k(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        IHybridComponent r101 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r101 == null) goto L6;
        this.f38714a = r101;
        return;
    }

    public k(IHybridComponent r100) {
        this.f38714a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.d0 r102 = (e7.d0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHybridComponent r103 = this.f38714a;
        if (r103 == null) goto L5;
        String r104 = r103.containerId();
    L6:
        boolean r105 = false;
        if (r104 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L25;
        String r107 = r102.a();
        if (r107 != null) goto L17;
    L18:
        r105 = true;
    L19:
        if (r105 == true) goto L25;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r108 = SocketManager.f40101a;
        SocketManager r109 = SocketManager.a.a();
        IHybridComponent r110 = this.f38714a;
        Intrinsics.checkNotNull(r110);
        String r111 = r110.containerId();
        String r112 = r102.a();
        Intrinsics.checkNotNull(r112);
        r109.getClass();
        if (SocketManager.b(r111, r112) == null) goto L24;
        finishWithFailure();
        return;
    L24:
        CloseSocketResultModel r113 = new CloseSocketResultModel();
        r113.a(CloseSocketResultModel.Code.Success);
        finishWithResult(r113);
        return;
    L17:
        if (StringsKt.isBlank(r107) == false) goto L19;
    L25:
        finishWithFailure();
        return;
    L9:
        if (StringsKt.isBlank(r104) == true) goto L12;
        r106 = false;
        goto L13
    L5:
        r104 = null;
        goto L6
    }
}
