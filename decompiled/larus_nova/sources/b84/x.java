package b84;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f18066e;

    public x(Context r100) {
        super(true, false);
        this.f18066e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException {
        String r101 = null;
        PackageInfo r102 = this.f18066e.getPackageManager().getPackageInfo(this.f18066e.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r102 == null) goto L22;
        Signature[] r103 = r102.signatures;
        if (r103 == null) goto L22;
        if (r103.length <= 0) goto L22;
        Signature r104 = r103[0];
        if (r104 == null) goto L22;
        byte[] r105 = r104.toByteArray();
        if (r105 == null) goto L22;
        if (r105.length == 0) goto L22;
        MessageDigest r106 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L21
        r106.update(r105);     // Catch: Exception -> L21
        r101 = i84.c.a(r106.digest());     // Catch: Exception -> L21
    L22:
        if (r101 == null) goto L30;
        r100.put("sig_hash", r101);
        return true;
    L30:
        return true;
    L5:
        e = move-exception;
        com.bytedance.bdinstall.t.e(e);
        r102 = null;
        goto L7
    }
}
