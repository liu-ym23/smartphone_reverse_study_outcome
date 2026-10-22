package com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.d;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends DynamicParamsController {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Double> f178315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f178316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f178317g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a$a, reason: collision with other inner class name */
    public static final class C2647a {
    }

    static {
    }

    public a() {
        this.f178315e = new LinkedHashMap();
    }

    public static final void c(a r100, DynamicParamsType r101, Object r102) {
        r100.getClass();
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r103 = (String) r102;
        if (r103 == null) goto L14;
        Map<String, Object> r104 = cd.a.e(new JSONObject(r103));     // Catch: JSONException -> L9
        r100.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("paramsType", Integer.valueOf(r101.getValue())), TuplesKt.to("params", r104)}));     // Catch: JSONException -> L9
        r100.f178317g = true;     // Catch: JSONException -> L9
        Lazy r105 = ECMallLogUtil.f47441a;     // Catch: JSONException -> L9
        ECMallLogUtil.c(d.c.f47467b, "handleWhiteBoardParams ," + r104);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "paras white board dynamic params error");
        return;
    }
}
