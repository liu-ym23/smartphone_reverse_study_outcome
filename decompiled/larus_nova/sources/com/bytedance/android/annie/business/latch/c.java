package com.bytedance.android.annie.business.latch;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends com.bytedance.sdk.xbridge.cn.protocol.d<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.lynx.a f39018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f39019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ kx.b.a.InterfaceC6625a f39020e;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.d
    public final void b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Map<String, ?> r101 = (Map) r100;     // Catch: Exception -> L21
        boolean r102 = true;
        if (Intrinsics.areEqual(r101.get("code"), 1) == true) goto L16;
        Object r103 = r101.get("__jsb2__data__");     // Catch: Exception -> L21
        if ((r103 instanceof JSONObject) == false) goto L8;
        JSONObject r104 = (JSONObject) r103;     // Catch: Exception -> L21
    L10:
        if (r104 == null) goto L12;
        boolean r105 = Intrinsics.areEqual(r104.get("code"), 1);     // Catch: Exception -> L21
    L13:
        if (r105 == true) goto L16;
        r102 = false;
        goto L16
    L12:
        r105 = false;
        goto L13
    L8:
        r104 = null;
    L16:
        HybridLogger r106 = HybridLogger.f246343a;     // Catch: Exception -> L21
        HybridLogger.f("AnnieBusinessLatchService", "handle " + this.f39019d + ".success:" + r102 + ", message:" + this.f39018c.f508954l, null, 12);     // Catch: Exception -> L21
        if (r102 == false) goto L19;
        this.f39020e.onSuccess(r101);     // Catch: Exception -> L21
        return;
    L19:
        this.f39020e.onFail(this.f39018c.f508954l);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        HybridLogger r107 = HybridLogger.f246343a;
        HybridLogger.i("AnnieBusinessLatchService", "dispatchPlatformInvoke  " + this.f39019d + " exception:. " + e, null, 12);
    }

    public c(com.bytedance.sdk.xbridge.cn.platform.lynx.a r100, String r101, kx.b.a.InterfaceC6625a r102) {
        this.f39018c = r100;
        this.f39019d = r101;
        this.f39020e = r102;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
        super(r100);
    }
}
