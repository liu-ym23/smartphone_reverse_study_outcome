package com.bytedance.android.live.browser.schema.core;

import com.bytedance.android.live.browser.schema.core.strategy.f;
import com.bytedance.android.live.browser.schema.core.strategy.g;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class RedirectRuleCreator implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f64191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.browser.schema.core.strategy.d f64192b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.schema.core.b
    public final RedirectRule get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        JSONObject r101 = this.f64191a.b();
        if (r101 == null) goto L18;
        Object r102 = r101.get(r100);     // Catch: JSONException -> L6
    L8:
        if (r102 == null) goto L19;
        return b(this, r102, RedirectRuleCreator$get$1$1$1.INSTANCE);
    L11:
        e = move-exception;
        com.bytedance.android.live.schema.api.utils.a.b("RedirectRuleCreator", "rule parse error", e);
        return null;
    L19:
        return null;
    L6:
        e = move-exception;
        com.bytedance.android.live.schema.api.utils.a.b("RedirectRuleCreator", "get key error", e);
        r102 = null;
        goto L8
    L18:
        return null;
    }

    public RedirectRuleCreator(d r100, com.bytedance.android.live.browser.schema.core.strategy.d r101) {
        Intrinsics.checkNotNullParameter(r100, "ruleSpec");
        Intrinsics.checkNotNullParameter(r101, "strategyRegister");
        this.f64191a = r100;
        this.f64192b = r101;
    }

    public static /* synthetic */ RedirectRule b(RedirectRuleCreator r100, Object r101, Function1 r102) {
        return r100.a(r101, new g(), r102);
    }

    public final RedirectRule a(Object r100, com.bytedance.android.live.browser.schema.core.strategy.c r101, Function1<Object, Boolean> r102) {
        if (r102.invoke(r100).booleanValue() == true) goto L7;
        r101 = new com.bytedance.android.live.browser.schema.core.strategy.b(-1, r100.toString());
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return new RedirectRule(r101, (String) r100, null);
    L11:
        if ((r100 instanceof JSONArray) == false) goto L21;
        JSONArray r103 = (JSONArray) r100;
        ArrayList r104 = new ArrayList();
        int r105 = r103.length();
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L19;
        RedirectRule r107 = b(this, r103.get(r106), RedirectRuleCreator$toRedirectRules$1.INSTANCE);
        if (r107 == null) goto L17;
        r104.add(r107);
    L17:
        r106 = r106 + 1;
        goto L13
    L19:
        return new RedirectRule(r101, null, r104);
    L21:
        if ((r100 instanceof JSONObject) == false) goto L32;
        JSONObject r108 = (JSONObject) r100;
        int r109 = JSONObjectProtectorUtils.getInt(r108, "ruleType");
        if (r102.invoke(r100).booleanValue() == false) goto L29;
        Map<Integer, com.bytedance.android.live.browser.schema.core.strategy.c.b> r110 = this.f64192b.f64221a;
        HashMap r111 = (HashMap) r110;
        com.bytedance.android.live.browser.schema.core.strategy.c.b r112 = (com.bytedance.android.live.browser.schema.core.strategy.c.b) r111.get(Integer.valueOf(r109));
        if (r112 == null) goto L28;
        com.bytedance.android.live.browser.schema.core.strategy.c r113 = r112.a(r108);
        if (r113 == null) goto L28;
    L31:
        return a(r108.get("location"), r113, RedirectRuleCreator$createRedirectRule$1.INSTANCE);
    L28:
        r113 = new f(r109);
        goto L31
    L29:
        r113 = new com.bytedance.android.live.browser.schema.core.strategy.b(r109, r100.toString());
        goto L31
    L32:
        return null;
    }
}
