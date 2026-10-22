package cc4;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f23248a;

    public static JSONObject a() {
        JSONObject r100 = f23248a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.bytedance.bdturing.setting.e r101 = com.bytedance.bdturing.setting.e.f202077a;
        JSONObject r102 = com.bytedance.bdturing.setting.e.e("nocaptcha");
        f23248a = r102;
        return r102;
    }
}
