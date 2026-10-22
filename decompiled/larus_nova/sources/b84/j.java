package b84;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.x0;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f18033a;

    public j(o0 r100) {
        this.f18033a = r100;
    }

    public final void a(JSONObject r100, com.bytedance.bdinstall.u r101) throws JSONException, SecurityException {
        if (r101.f199613a == false) goto L5;
        r100.put("scene", 2);
    L5:
        r100.put("device_platform", "android");
        boolean r102 = i84.p.f488631a.b(new Object[0]).booleanValue();
        if (r102 == false) goto L9;
        Object r103 = "Harmony";
    L69:
        r100.put("os", r103);     // Catch: JSONException -> L12
    L14:
        if (r102 == false) goto L25;
        JSONObject r104 = new JSONObject();
        r104.put("os_api", i84.u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L19
        r104.put("os_version", i84.u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L19
        r104.put("release_type", i84.u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L19
    L67:
        r100.put(RomUtils.OS_HARMONY, r104);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = move-exception;
        th.printStackTrace();
    L25:
        r100.put("git_hash", "f079d36");
        r100.put("sdk_version_code", com.bytedance.bdinstall.t.f199790a);
        r100.put("sdk_target_version", 30);
        r100.put("req_id", (String) i84.o.f488630a.b(new Object[0]));
        r100.put("sdk_version", "4.3.2-rc.41-doubao");
        r100.put("guest_mode", this.f18033a.f199748u ? 1 : 0);
        r100.put("sdk_flavor", "cnInner");
        if (i84.a.a(this.f18033a.getContext(), this.f18033a).getBoolean("is_migrate", false) == false) goto L34;
        String r105 = i84.a.a(this.f18033a.getContext(), this.f18033a).getString("old_did", null);
        if (TextUtils.isEmpty(r105) == false) goto L63;
        r105 = "";
    L63:
        r100.put("old_did", r105);     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L34:
        Context r106 = this.f18033a.getContext();
        x0 r107 = this.f18033a.G;
        if (r107 == null) goto L65;
        r100.put("pre_installed_channel", r107.getChannel(r106));
    L65:
        PackageInfo r108 = r106.getPackageManager().getPackageInfo(r106.getPackageName(), 0);     // Catch: Throwable -> L46
        if (r108 == null) goto L48;
        r100.put("apk_first_install_time", r108.firstInstallTime);     // Catch: Throwable -> L46
        if ((r108.applicationInfo.flags & 1) != 1) goto L43;
        int r109 = 1;
    L44:
        r100.put("is_system_app", r109);     // Catch: Throwable -> L46
        goto L48
    L43:
        r109 = 0;
    L48:
        g84.c r110 = (g84.c) g84.e.a(g84.c.class, String.valueOf(this.f18033a.f199728a));
        if (r110 == null) goto L51;
        r110.b();
    L51:
        o0 r111 = this.f18033a;
        z74.c r112 = i84.d.b().d(r111.f199728a);
        z74.a r113 = i84.d.b().a(r111.f199728a);
        if (r101.f199613a == false) goto L55;
        r112.f570664g = 2;
        r113.f570652f = 2;
    L58:
        if (r110 == null) goto L71;
        r112.f570663f = r110.c() ? 1 : 0;
        r113.f570651e = r110.c() ? 1 : 0;
        return;
    L71:
        return;
    L55:
        if (r111.f199748u == false) goto L57;
        r112.f570664g = 1;
        r113.f570652f = 1;
        goto L58
    L57:
        r112.f570664g = 0;
        r113.f570652f = 0;
    L46:
        th = move-exception;
        th.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L9:
        r103 = "Android";
        goto L69
    }
}
