package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.ConnectSocketResultModel;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "connectSocket")
public final class l extends e7.d<e7.e0, ConnectSocketResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38719a;

    public l(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        IHybridComponent r101 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r101 == null) goto L6;
        this.f38719a = r101;
        return;
    }

    public l(IHybridComponent r100) {
        this.f38719a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        e7.e0 r112 = (e7.e0) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = r112.c();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L59;
        IHybridComponent r102 = this.f38719a;
        Unit r103 = null;
        if (r102 == null) goto L13;
        String r104 = r102.containerId();
    L14:
        if (r104 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        if (r105 == true) goto L59;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r106 = SocketManager.f40101a;
        SocketManager r107 = SocketManager.a.a();
        Context r108 = r111.getContext();
        IHybridComponent r109 = this.f38719a;
        Intrinsics.checkNotNull(r109);
        String r113 = r109.containerId();
        String r114 = r112.c();
        Intrinsics.checkNotNull(r114);
        com.bytedance.android.annie.websocket.f r115 = new com.bytedance.android.annie.websocket.f(r114, r112.a(), r112.b());
        o2 r116 = new o2(r111);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "containerID");
        Intrinsics.checkNotNullParameter(r115, "requestTask");
        Intrinsics.checkNotNullParameter(r116, "callback");
        int r117 = com.bytedance.android.annie.websocket.g.f40119f;
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "requestTask");
        com.bytedance.android.annie.websocket.g r118 = new com.bytedance.android.annie.websocket.g(r108, r115);
        com.bytedance.android.annie.websocket.h r119 = new com.bytedance.android.annie.websocket.h(r118);     // Catch: Throwable -> L33
        Class r120 = com.bytedance.android.annie.websocket.i.a();     // Catch: Throwable -> L26
    L27:
        if (r120 == null) goto L34;
        Object r121 = r120.getDeclaredConstructor(new Class[]{IMessageReceiveListener.class}).newInstance(new Object[]{r119});     // Catch: Throwable -> L33
        if ((r121 instanceof IWsClient) == false) goto L34;
        IWsClient r122 = (IWsClient) r121;     // Catch: Throwable -> L33
    L35:
        if (r122 == null) goto L37;
        r118.f40120e = r122;
        Unit r123 = Unit.INSTANCE;
    L38:
        if (r123 != null) goto L40;
        r118 = null;
    L40:
        if (r118 == null) goto L54;
        String r124 = UUID.randomUUID().toString();
        r118.f40109c = new SocketManager.b(r107, r113, r124, r116);
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r125 = SocketManager.f40101a;
        monitor-enter(r125);
    L51:
        th = move-exception;
        throw th;
    L44:
        if (r125.containsKey(r113) == false) goto L48;
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r126 = r125.get(r113);     // Catch: Throwable -> L51
        if (r126 == null) goto L49;
        r126.put(r124, r118);     // Catch: Throwable -> L51
    L49:
        monitor-exit(r125);
        r118.f();
    L55:
        if (r124 == null) goto L57;
        ConnectSocketResultModel r127 = new ConnectSocketResultModel();
        r127.b(r124);
        r127.a(ConnectSocketResultModel.Code.Success);
        finishWithResult(r127);
        r103 = Unit.INSTANCE;
    L57:
        if (r103 != null) goto L66;
        finishWithFailure();
        return;
    L66:
        return;
    L48:
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r128 = new HashMap();     // Catch: Throwable -> L51
        r128.put(r124, r118);     // Catch: Throwable -> L51
        Unit r129 = Unit.INSTANCE;     // Catch: Throwable -> L51
        r125.put(r113, r128);     // Catch: Throwable -> L51
        goto L49
    L54:
        r124 = null;
        goto L55
    L37:
        r123 = null;
    L26:
        r120 = null;
    L34:
        r122 = null;
        goto L35
    L16:
        if (StringsKt.isBlank(r104) == true) goto L19;
        r105 = false;
        goto L20
    L13:
        r104 = null;
    L59:
        finishWithFailure();
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}
