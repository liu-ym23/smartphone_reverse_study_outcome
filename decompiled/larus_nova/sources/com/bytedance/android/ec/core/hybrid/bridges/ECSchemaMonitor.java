package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSchemaMonitor;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSchemaMonitor extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44132e;

    public static final class a {
    }

    static {
    }

    public ECSchemaMonitor() {
        this.f44132e = "ecSchemaMonitor";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44132e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r110, ECBaseBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "iReturn");
        String r100 = r110.optString("scene");     // Catch: Exception -> L32
        if (cg4.a.a(r100) == false) goto L6;
        String r101 = r100;
    L7:
        String r102 = r110.optString("params");     // Catch: Exception -> L32
        if (cg4.a.a(r102) == false) goto L10;
        String r103 = r102;
    L11:
        Context r104 = getContext();     // Catch: Exception -> L32
        if (r104 == null) goto L34;
        if (r101 == null) goto L34;
        if (r103 == null) goto L34;
        String r105 = r110.optString("contextProvider");     // Catch: Exception -> L32
        if (cg4.a.a(r105) == false) goto L18;
        String r106 = r105;
    L19:
        String r112 = r110.optString("scriptPath");     // Catch: Exception -> L32
        if (r112 == null) goto L31;
        String r113 = StringsKt.trim(r112).toString();     // Catch: Exception -> L32
        if (cg4.a.a(r113) == false) goto L24;
        String r107 = r113;
    L25:
        int r114 = ECSdk.f48106a;     // Catch: Exception -> L32
        o r108 = (o) ECSdk.a(o.class);     // Catch: Exception -> L32
        if (r108 == null) goto L28;
        r108.a(r104, r101, r103, r106, r107);     // Catch: Exception -> L32
    L28:
        r111.onSuccess(null);     // Catch: Exception -> L32
        return;
    L24:
        r107 = null;
        goto L25
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L32
    L18:
        r106 = null;
    L34:
        r111.onFailed(0, null);
        return;
    L10:
        r103 = null;
        goto L11
    L6:
        r101 = null;
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L34
    }
}
