package com.bytedance.bdinstall.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdinstall.BuildConfig;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.av;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DRSpecialLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final an f6222a;

    j(an r1) {
        this.f6222a = r1;
    }

    public boolean a(JSONObject r4, com.bytedance.bdinstall.u r5) {
        if (r5.d() == false) goto L5;
        r4.put(DBHelper.BATTERY_COL_SCENE, 2);
    L5:
        r4.put("device_platform", "android");
        new q().a(r4);
        r4.put("git_hash", BuildConfig.GIT_HASH);
        r4.put("sdk_version_code", com.bytedance.bdinstall.t.f6444b);
        r4.put("sdk_target_version", 30);
        r4.put("req_id", com.bytedance.bdinstall.j.o.a());
        r4.put("sdk_version", BuildConfig.BDINSTALL_VERSION_NAME);
        r4.put("guest_mode", this.f6222a.M() ? 1 : 0);
        r4.put("sdk_flavor", BuildConfig.FLAVOR);
        if (com.bytedance.bdinstall.migrate.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6222a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f6222a) == false) goto L14;
        String r0 = com.bytedance.bdinstall.migrate.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6222a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f6222a);
        if (TextUtils.isEmpty(r0) == false) goto L19;
        r0 = "";
    L19:
        r4.put("old_did", r0);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        a(r4);
        com.bytedance.bdinstall.g.c r1 = (com.bytedance.bdinstall.g.c) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.c.class, String.valueOf(this.f6222a.a())), com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L17;
        r1.a(r4);
    L17:
        a(this.f6222a, r5, r1);
        return true;
    }

    private void a(JSONObject r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6222a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        av r4 = this.f6222a.G();
        if (r4 == null) goto L19;
        r5.put("pre_installed_channel", r4.a(r0));
    L19:
        int r1 = 0;
        PackageInfo r6 = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);     // Catch: Throwable -> L16
        if (r6 == null) goto L21;
        r5.put("apk_first_install_time", r6.firstInstallTime);     // Catch: Throwable -> L16
        if ((r6.applicationInfo.flags & 1) != 1) goto L10;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        r1 = 1;
    L14:
        r5.put("is_system_app", r1);     // Catch: Throwable -> L16
        return;
    L10:
        r7 = false;
        goto L12
    L21:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    private void a(an r3, com.bytedance.bdinstall.u r4, com.bytedance.bdinstall.g.c r5) {
        com.bytedance.bdinstall.g.c r2 = (com.bytedance.bdinstall.g.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.b.c r6 = com.bytedance.bdinstall.j.e.a().c(r3.a());
        com.bytedance.bdinstall.b.a r0 = com.bytedance.bdinstall.j.e.a().d(r3.a());
        if (r4.d() == false) goto L6;
        r6.a(2);
        r0.a(2);
    L9:
        if (r2 == null) goto L12;
        r6.b(r2.a() ? 1 : 0);
        r0.b(r2.a() ? 1 : 0);
        return;
    L12:
        return;
    L6:
        if (r3.M() == false) goto L8;
        r6.a(1);
        r0.a(1);
        goto L9
    L8:
        r6.a(0);
        r0.a(0);
        goto L9
    }
}
