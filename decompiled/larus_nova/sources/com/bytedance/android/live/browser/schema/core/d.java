package com.bytedance.android.live.browser.schema.core;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f64207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64208b;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ d() {
        throw null;
    }

    public final long a() {
        JSONObject r100 = this.f64207a.optJSONObject("common_config");
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.optLong("limit_second");
    }

    public final JSONObject b() {
        return JSONObjectProtectorUtils.getJSONObject(this.f64207a, "redirect_rules");
    L4:
        StringBuilder r100 = new StringBuilder("redirectRuleJsonObj get failed, geckoVersion: ");
        r100.append(this.f64208b);
        r100.append(", settingVersion: ");
        JSONObject r101 = this.f64207a.optJSONObject("common_config");
        if (r101 == null) goto L7;
        String r102 = r101.optString("config_version");
    L8:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r100.append(r102);
        com.bytedance.android.live.schema.api.utils.a.b("RedirectRuleSpec", r100.toString(), null);
        return null;
    L7:
        r102 = null;
        goto L8
    }

    public d(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        this.f64207a = r100;
        this.f64208b = r101;
    }
}
