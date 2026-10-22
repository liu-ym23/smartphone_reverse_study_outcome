package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.router.ECLiveSchemaBuilder;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/GotoECLiveMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GotoECLiveMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f147839e;

    public static final class a {
    }

    static {
    }

    public GotoECLiveMethod() {
        this.f147839e = "gotoECLive";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f147839e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        boolean r102 = r100.optBoolean("open");
        String r103 = r100.optString("base_schema");
        String r104 = r100.optString("query");
        String r105 = r100.optString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS);
        ECLiveSchemaBuilder r106 = new ECLiveSchemaBuilder();
        r106.a(r103);
        r106.c(z1.f(r105));
        r106.d(z1.f(r104));
        if (r102 == false) goto L8;
        Context r107 = getContext();
        if (r107 == null) goto L7;
        String r108 = r106.i(r107);
    L9:
        JSONObject r109 = new JSONObject();
        r109.put("schema", r108);
        Unit r110 = Unit.INSTANCE;
        r101.onSuccess(r109);
        return;
    L7:
        r108 = "";
        goto L9
    L8:
        r108 = r106.build();
        goto L9
    }
}
