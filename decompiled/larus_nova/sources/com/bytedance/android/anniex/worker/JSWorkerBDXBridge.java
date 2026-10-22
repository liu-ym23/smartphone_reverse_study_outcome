package com.bytedance.android.anniex.worker;

import android.content.Context;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class JSWorkerBDXBridge extends BDXBridge<ReadableMap, ReadableMap> implements ue7.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f41494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f41495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g f41496m;

    public static final class a implements com.bytedance.sdk.xbridge.cn.protocol.e<ReadableMap, ReadableMap> {
        public a() {
        }

        @Override // com.bytedance.sdk.xbridge.cn.protocol.e
        public final void a(le7.a r100, me7.d r101) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final com.bytedance.sdk.xbridge.cn.protocol.e<ReadableMap, ReadableMap> i() {
        return new a();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final com.bytedance.sdk.xbridge.cn.protocol.c<ReadableMap, ReadableMap> j() {
        return (k) this.f41495l.getValue();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final void u() {
        this.f41496m.b();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final IDLXBridgeMethod.XBridgeThreadType n(le7.a<ReadableMap> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        return IDLXBridgeMethod.XBridgeThreadType.ASYNC_THREAD;
    }

    public JSWorkerBDXBridge(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerID");
        super(r100, r101);
        this.f41495l = LazyKt.lazy(JSWorkerBDXBridge$bridgeHandler$2.INSTANCE);
        this.f41496m = new g(r101, new View(r100), r100, this);
    }

    @Override // ue7.d
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        c r102 = this.f41494k;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Gson r103 = new Gson();     // Catch: Exception -> L9
        JsonObject r104 = new JsonObject();     // Catch: Exception -> L9
        r104.addProperty(ReportCardMonitorPlugin.EVENT_NAME, r100);     // Catch: Exception -> L9
        r104.add("data", r103.toJsonTree(r101));     // Catch: Exception -> L9
        String r105 = r103.toJson(r104);     // Catch: Exception -> L9
        JsWorker r106 = r102.f41500b;     // Catch: Exception -> L9
        if (r106 == null) goto L15;
        r106.postMessage(r105);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        HybridLogger r107 = HybridLogger.f246343a;
        HybridLogger.i("AnnieXJSWorker", "postMessage: " + e, null, 12);
        return;
    }
}
