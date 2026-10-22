package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSetMegaObjectMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSetMegaObjectMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f44134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f44135g;

    public static final class a {
    }

    static {
    }

    public ECSetMegaObjectMethod() {
        this.f44133e = "setMegaObject";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44133e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        this.f44134f = r100.optString("id");
        this.f44135g = r100.optJSONObject("object");
        JSONObject r102 = new JSONObject();
        String r103 = this.f44134f;
        if (r103 == null) goto L6;
        HashMap<String, JSONObject> r104 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        com.bytedance.android.ec.core.hybrid.utils.j.h(r103, this.f44135g);
        if (r102.put("code", 0) == null) goto L6;
    L7:
        r101.a(r102);
        return;
    L6:
        r102.put("code", 1);
        goto L7
    }
}
