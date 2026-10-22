package b84;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.o0;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f18062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f18063f;

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException {
        String r101 = this.f18062e.getPackageName();
        if (TextUtils.isEmpty(this.f18063f.f199732e) == false) goto L5;
        r100.put("package", r101);
    L28:
        r100.put("app_version", this.f18063f.e());     // Catch: Throwable -> L23
        r100.put("app_version_minor", this.f18063f.f199744q.f199644b);     // Catch: Throwable -> L23
        r100.put("version_code", this.f18063f.f());     // Catch: Throwable -> L23
        r100.put("update_version_code", this.f18063f.d());     // Catch: Throwable -> L23
        r100.put("manifest_version_code", this.f18063f.b());     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(this.f18063f.f199733f) == true) goto L11;
        r100.put("app_name", this.f18063f.f199733f);     // Catch: Throwable -> L23
    L11:
        if (TextUtils.isEmpty(this.f18063f.f199735h) == true) goto L26;
        r100.put("tweaked_channel", this.f18063f.f199735h);     // Catch: Throwable -> L23
    L26:
        ApplicationInfo r102 = this.f18062e.getPackageManager().getPackageInfo(r101, 0).applicationInfo;     // Catch: Throwable -> L19
        if (r102 == null) goto L30;
        int r103 = r102.labelRes;     // Catch: Throwable -> L19
        if (r103 <= 0) goto L31;
        r100.put(IGoogleService.ResponseKey.DISPLAY_NAME, this.f18062e.getString(r103));     // Catch: Throwable -> L19
    L32:
        return true;
    L31:
        return true;
    L30:
        return true;
    L19:
        th = move-exception;
        com.bytedance.bdinstall.t.c("PackageLoader#getPackageInfo error", th);     // Catch: Throwable -> L23
        return true;
    L23:
        th = move-exception;
        com.bytedance.bdinstall.t.e(th);
        return false;
    L5:
        int r104 = com.bytedance.bdinstall.t.f199790a;
        r100.put("package", this.f18063f.f199732e);
        r100.put("real_package_name", r101);
        goto L28
    }

    public u(Context r100, o0 r101) {
        super(false, false);
        this.f18062e = r100;
        this.f18063f = r101;
    }
}
