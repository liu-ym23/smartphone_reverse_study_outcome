package com.bytedance.android.live.browser.schema.core;

import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class RedirectRuleSettingsHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f64193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f64194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f64195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WebcastRedirectReportInfo f64196d;

    public final com.bytedance.android.live.schema.api.a a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        RedirectRule r101 = this.f64195c.get(r100);
        String r102 = "";
        String r103 = null;
        if (r101 == null) goto L13;
        JSONObject r104 = this.f64193a;
        JSONObject r105 = this.f64195c.f64201a.b();
        if (r105 == null) goto L9;
        Object r106 = r105.opt(r100);
        if (r106 == null) goto L9;
        String r107 = r106.toString();
    L10:
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        r104.put("setting_value", r107);
        com.bytedance.android.live.schema.api.a r108 = r101.a(this.f64193a, new RedirectRuleSettingsHandler$getFinalSchemaWithEntryKey$$inlined$let$lambda$1(this, r100));
    L14:
        WebcastRedirectReportInfo r109 = this.f64196d;
        r109.a("rule_type", this.f64194b);
        JSONObject r110 = this.f64195c.f64201a.f64207a.optJSONObject("common_config");
        if (r110 == null) goto L17;
        r103 = r110.optString("config_version");
    L17:
        if (r103 == null) goto L20;
        r102 = r103;
    L20:
        r109.a("config_version", r102);
        String r111 = this.f64193a.toString();
        Intrinsics.checkNotNullParameter("extra_env_info", "key");
        Intrinsics.checkNotNullParameter(r111, "value");
        r109.c().put("extra_env_info", r111);
        return r108;
    L9:
        r107 = null;
        goto L10
    L13:
        r108 = null;
        goto L14
    }

    public RedirectRuleSettingsHandler(c r100, WebcastRedirectReportInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        Intrinsics.checkNotNullParameter(r101, "reportInfo");
        this.f64195c = r100;
        this.f64196d = r101;
        this.f64193a = new JSONObject();
        this.f64194b = "-1";
    }
}
