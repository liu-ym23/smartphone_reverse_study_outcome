package com.bytedance.android.livesdk.paas;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Objects;
import java.util.Properties;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f154200d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Properties f154201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f154202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f154203c;

    public final String a() {
        JSONObject r100 = this.f154202b;     // Catch: Throwable -> L30
        if (r100 == null) goto L7;
        Object r101 = r100.get("LIVESDK_VERSION");     // Catch: Throwable -> L30
    L8:
        if (r101 == null) goto L33;
        r101.toString();
    L25:
        if ((r101 instanceof String) == true) goto L29;
        return "";
    L29:
        return (String) r101;
    L33:
        if (this.f154201a != null) goto L17;
        Properties r102 = new Properties();     // Catch: Throwable -> L23
        this.f154201a = r102;     // Catch: Throwable -> L23
        r102.load(this.f154203c.getAssets().open("live_build_info.properties"));     // Catch: Exception -> L15 Throwable -> L23
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
    L17:
        Properties r103 = this.f154201a;     // Catch: Throwable -> L23
        if (r103 == null) goto L25;
        if (r103.containsKey("LIVESDK_VERSION") == false) goto L25;
        r101 = this.f154201a.get("LIVESDK_VERSION");     // Catch: Throwable -> L23
        Objects.toString(r101);     // Catch: Throwable -> L23
    L7:
        r101 = null;
        goto L8
    }

    public b(Context r100) {
        this.f154203c = r100;
        JSONObject r101 = null;
        ApplicationInfo r102 = r100.getApplicationInfo();     // Catch: Throwable -> L25
        if (r102 == null) goto L8;
        String r103 = r102.sourceDir;     // Catch: Throwable -> L25
    L28:
        String r104 = ApkUtil.b(r103);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r104) == true) goto L30;
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L24
        boolean r106 = !TextUtils.isEmpty(JSONObjectProtectorUtils.getString(r105, "meta_channel"));
    L16:
        if (r106 == false) goto L30;
        r101 = r105;
    L15:
        r106 = false;
    L30:
        this.f154202b = r101;     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        r103 = null;
        goto L28
    }
}
