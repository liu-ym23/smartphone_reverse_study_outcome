package com.bytedance.android.annie.bridge.method;

import android.util.Base64;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.SendSocketDataResultModel;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "sendSocketData")
public final class d2 extends e7.z<e7.v0, SendSocketDataResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38649a;

    public d2(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        IHybridComponent r101 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r101 == null) goto L6;
        this.f38649a = r101;
        return;
    }

    public d2(IHybridComponent r100) {
        this.f38649a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.v0 r102 = (e7.v0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHybridComponent r103 = this.f38649a;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.containerId();
    L6:
        boolean r106 = true;
        if (r105 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L75;
        String r108 = r102.c();
        if (r108 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == true) goto L75;
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        String r111 = r102.b();
        if (Intrinsics.areEqual(r111, "string") == false) goto L29;
        String r112 = r102.a();
        if (r112 == null) goto L40;
        r104 = r112;
    L40:
        if (r104 != null) goto L42;
    L44:
        boolean r113 = false;
    L45:
        String r114 = "The socketTaskID doesn't exist";
        if (r113 == false) goto L55;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r115 = SocketManager.f40101a;
        SocketManager r116 = SocketManager.a.a();
        IHybridComponent r117 = this.f38649a;
        Intrinsics.checkNotNull(r117);
        String r118 = r117.containerId();
        String r119 = r102.c();
        Intrinsics.checkNotNull(r119);
        Intrinsics.checkNotNull(r104);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r118, "containerID");
        Intrinsics.checkNotNullParameter(r119, "socketTaskID");
        Intrinsics.checkNotNullParameter(r104, "txt");
        List r120 = SocketManager.c(r118, r119);
        if (r120 == null) goto L53;
        com.bytedance.android.annie.websocket.b r121 = (com.bytedance.android.annie.websocket.b) ListProtector.get(r120, 0);
        if (r121 == null) goto L53;
        r114 = r121.b(r104);
    L53:
        if (r114 == null) goto L74;
        finishWithFailure();
        return;
    L74:
        SendSocketDataResultModel r122 = new SendSocketDataResultModel();
        r122.a(SendSocketDataResultModel.Code.Success);
        finishWithResult(r122);
        return;
    L55:
        byte[] r123 = (byte[]) r110.element;
        if (r123 != null) goto L58;
    L64:
        r106 = false;
    L65:
        if (r106 == false) goto L74;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r124 = SocketManager.f40101a;
        SocketManager r125 = SocketManager.a.a();
        IHybridComponent r126 = this.f38649a;
        Intrinsics.checkNotNull(r126);
        String r127 = r126.containerId();
        String r128 = r102.c();
        Intrinsics.checkNotNull(r128);
        T r129 = r110.element;
        Intrinsics.checkNotNull(r129);
        byte[] r130 = (byte[]) r129;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r127, "containerID");
        Intrinsics.checkNotNullParameter(r128, "socketTaskID");
        Intrinsics.checkNotNullParameter(r130, "byteData");
        List r131 = SocketManager.c(r127, r128);
        if (r131 == null) goto L72;
        com.bytedance.android.annie.websocket.b r132 = (com.bytedance.android.annie.websocket.b) ListProtector.get(r131, 0);
        if (r132 == null) goto L72;
        r114 = r132.sendMessage(r130);
    L72:
        if (r114 == null) goto L74;
        finishWithFailure();
        return;
    L58:
        if (r123.length != 0) goto L60;
        boolean r133 = true;
    L62:
        if ((!r133) != true) goto L64;
    L60:
        r133 = false;
        goto L62
    L42:
        if ((!StringsKt.isBlank(r104)) != true) goto L44;
        r113 = true;
        goto L45
    L29:
        if (Intrinsics.areEqual(r111, TTVideoEngineInterface.PLAY_API_KEY_BASE64) == false) goto L40;
        String r134 = r102.a();
        if (r134 == null) goto L40;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L34
        Object r136 = Result.m9449constructorimpl(Base64.decode(r134, 0));     // Catch: Throwable -> L34
    L36:
        boolean r137 = Result.m9455isFailureimpl(r136);
        T r138 = r136;
        if (r137 == false) goto L39;
        r138 = 0;
    L39:
        r110.element = r138;
    L34:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L17:
        if (StringsKt.isBlank(r108) == true) goto L20;
        r109 = false;
    L75:
        finishWithFailure();
        return;
    L9:
        if (StringsKt.isBlank(r105) == true) goto L12;
        r107 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }
}
