package com.bytedance.bdinstall.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: PackageLoader.java */
/* JADX INFO: loaded from: classes.dex */
class w extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6235e;
    private final an f;

    w(Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(false, false);
        this.f6235e = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f = r4;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r6) {
        String r0 = this.f6235e.getPackageName();
        if (TextUtils.isEmpty(this.f.d()) == false) goto L6;
        r6.put("package", r0);
    L31:
        r6.put(WsConstants.KEY_APP_VERSION, this.f.e());     // Catch: Throwable -> L26
        r6.put("app_version_minor", this.f.f());     // Catch: Throwable -> L26
        r6.put("version_code", this.f.g());     // Catch: Throwable -> L26
        r6.put("update_version_code", this.f.h());     // Catch: Throwable -> L26
        r6.put("manifest_version_code", this.f.i());     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(this.f.j()) == true) goto L14;
        r6.put(IBdInstall.PARAM_APP_NAME, this.f.j());     // Catch: Throwable -> L26
    L14:
        if (TextUtils.isEmpty(this.f.l()) == true) goto L29;
        r6.put("tweaked_channel", this.f.l());     // Catch: Throwable -> L26
    L29:
        PackageInfo r1 = this.f6235e.getPackageManager().getPackageInfo(r0, 0);     // Catch: Throwable -> L22
        if (r1.applicationInfo == null) goto L33;
        int r2 = r1.applicationInfo.labelRes;     // Catch: Throwable -> L22
        if (r2 <= 0) goto L34;
        r6.put("display_name", this.f6235e.getString(r2));     // Catch: Throwable -> L22
    L35:
        return true;
    L34:
        return true;
    L33:
        return true;
    L22:
        th = move-exception;
        com.bytedance.bdinstall.t.b("PackageLoader#getPackageInfo error", th);     // Catch: Throwable -> L26
        return true;
    L26:
        th = move-exception;
        com.bytedance.bdinstall.t.a(th);
        return false;
    L6:
        if (com.bytedance.bdinstall.t.a() == false) goto L8;
        com.bytedance.bdinstall.t.a("has zijie pkg");
    L8:
        r6.put("package", this.f.d());
        r6.put("real_package_name", r0);
        goto L31
    }
}
