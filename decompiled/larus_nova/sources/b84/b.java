package b84;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f18017e;

    public b(Context r100) {
        super(true, false);
        this.f18017e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException, SecurityException {
        String r101 = this.f18017e.getPackageName();
        Bundle r102 = this.f18017e.getPackageManager().getApplicationInfo(r101, 128).metaData;     // Catch: Exception -> L7
        if (r102 == null) goto L13;
        r100.put("appkey", r102.getString("UMENG_APPKEY"));     // Catch: Exception -> L7
        return true;
    L13:
        return true;
    L7:
        e = move-exception;
        com.bytedance.bdinstall.t.c("getApplicationInfo error", e);
        return true;
    }
}
