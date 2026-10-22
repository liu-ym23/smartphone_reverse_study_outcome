package com.stepos.agentbus.config;

import android.content.Context;
import android.provider.Settings;
import kotlin.Metadata;
import q7.k;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"getHost", "", "context", "Landroid/content/Context;", "getNetEnv", "domain_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PushConfigKt {
    public static final String getHost(Context context) {
        k.e(context, "context");
        String netEnv = getNetEnv(context);
        int iHashCode = netEnv.hashCode();
        return iHashCode != 99349 ? iHashCode != 114214 ? (iHashCode == 3556498 && netEnv.equals("test")) ? "https://biz-gw.t-stepos.com/" : "https://biz-gw.stepaos.com/" : !netEnv.equals("stg") ? "https://biz-gw.stepaos.com/" : "https://biz-gw-in.zyql.com/" : !netEnv.equals("dev") ? "https://biz-gw.stepaos.com/" : "https://biz-gw.t-stepos.com/";
    }

    public static final String getNetEnv(Context context) {
        k.e(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "net_env");
        return string == null ? "" : string;
    }
}
