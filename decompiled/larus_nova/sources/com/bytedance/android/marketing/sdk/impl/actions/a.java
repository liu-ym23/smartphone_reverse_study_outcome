package com.bytedance.android.marketing.sdk.impl.actions;

import android.content.Context;
import com.bytedance.android.marketing.sdk.impl.data.ECMarketingDataCenter;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f162691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f162692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f162693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f162694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f162695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f162696f;

    /* JADX INFO: renamed from: com.bytedance.android.marketing.sdk.impl.actions.a$a, reason: collision with other inner class name */
    public static final class C2486a {
    }

    static {
    }

    public a() {
    }

    public abstract String a();

    public void b() {
        com.bytedance.android.marketing.sdk.api.c r100 = (com.bytedance.android.marketing.sdk.api.c) ((LinkedHashMap) ECMarketingDataCenter.f162720b).get(this.f162693c);
        int r101 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        String r102 = this.f162691a;
        String r103 = this.f162692b;
        String r104 = a();
        String r105 = null;
        if (r100 == null) goto L5;
        String r106 = ex2.c.e(r100);
    L6:
        if (r100 == null) goto L8;
        r105 = ex2.c.b(r100);
    L8:
        com.bytedance.android.marketing.sdk.impl.utils.d.g(r102, r103, r104, r106, r105);
        return;
    L5:
        r106 = null;
        goto L6
    }

    public void c(Map<String, ? extends Object> r100, Context r101, p r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r100 != null) goto L5;
        r102.onFailed("params 为空");
        return;
    L5:
        Object r103 = r100.get(BdpAppEventConstant.PARAMS_RIT);
        String r104 = null;
        if (r103 == null) goto L8;
        String r105 = r103.toString();
    L9:
        this.f162691a = r105;
        Object r106 = r100.get("compName");
        if (r106 == null) goto L12;
        String r107 = r106.toString();
    L13:
        this.f162692b = r107;
        Object r108 = r100.get("pageId");
        if (r108 == null) goto L16;
        String r109 = r108.toString();
    L17:
        this.f162693c = r109;
        this.f162695e = r100.get("data");
        Object r110 = r100.get("bizId");
        if (r110 == null) goto L20;
        r104 = r110.toString();
    L20:
        this.f162694d = r104;
        Object r111 = r100.get("timestamp");
        if (r111 != null) goto L23;
    L28:
        b();
        return;
    L23:
        if ((r111 instanceof Long) == false) goto L26;
        this.f162696f = ((Number) r111).longValue();
        goto L28
    L26:
        if ((r111 instanceof Integer) == false) goto L28;
        this.f162696f = ((Number) r111).intValue();
        goto L28
    L16:
        r109 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    L8:
        r105 = null;
        goto L9
    }
}
