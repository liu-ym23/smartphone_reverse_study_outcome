package com.bytedance.android.shopping.sku.outer.business.ultimate;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SkuParams f183099a;

    public b(SkuParams r100) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        this.f183099a = r100;
    }

    public final void a(Map<String, String> r100) {
        String r101 = this.f183099a.getTransmissibleJson();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L25;
        JSONObject r103 = new JSONObject(r101);     // Catch: Exception -> L17
        Iterator<String> r104 = r103.keys();     // Catch: Exception -> L17
    L14:
        if (r104.hasNext() == false) goto L26;
        String r105 = r104.next();     // Catch: Exception -> L17
        r100.put(r105, r103.optString(r105));     // Catch: Exception -> L17
        goto L14
    L26:
        return;
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L25:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
