package com.bytedance.android.shopping.sku.common.jsb;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.extensions.k;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f182734a;

    public c(Function1 r100) {
        this.f182734a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r101 = r100.optString(SlcCommonAction.KEY_PARAMS);
        JSONObject r102 = k.u(r100.optString("session_params"));
        String r103 = r102.optString("session_id", "none");
        String r104 = r100.optString("type", "");
        String r105 = r102.optString("node_id", "");
        Function1 r106 = this.f182734a;
        Map<String, Object> r107 = k.z(r101);
        if (r107 == null) goto L5;
        Map r108 = MapsKt.toMap(r107);
    L6:
        r106.invoke(new b(r103, r105, r104, r108));
        return;
    L5:
        r108 = null;
        goto L6
    }
}
