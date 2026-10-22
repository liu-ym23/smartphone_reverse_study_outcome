package a09;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class f {
    public static final c a(String r100) throws Exception {
        c r101 = new c(0);
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L13;
        JSONObject r103 = new JSONObject(r100);
        if (Intrinsics.areEqual("success", r103.optString("message")) == false) goto L10;
        r101.f1327a = true;
        r101.f1328b = r103.optJSONObject("data");
    L11:
        return r101;
    L10:
        r101.f1327a = false;
        r101.f1328b = r103.optJSONObject("data");
        goto L11
    L13:
        throw new IllegalArgumentException("argument is null".toString());
    L5:
        r102 = false;
        goto L6
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "res");
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L15
        int r102 = r101.optInt("code");     // Catch: Exception -> L15
        String r103 = r101.optString("msg");     // Catch: Exception -> L15
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        if (r102 == 0) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r103, "success") == false) goto L23;
        String r104 = r101.optString("data");     // Catch: Exception -> L15
        if (r104 != null) goto L14;
        return "";
    L14:
        return r104;
    L23:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        FLogger.f375446a.e("parseDomainsAll", "getDomainsAll e=" + e.getMessage());
        return null;
    }
}
