package android.ss.com.vboost.utils;

import android.ss.com.vboost.CapabilityScheduler;
import android.ss.com.vboost.request.RequestManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c<b> f4783b;

    /* JADX INFO: renamed from: android.ss.com.vboost.utils.a$a, reason: collision with other inner class name */
    public static class C0093a extends c<b> {
        public C0093a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public b initialValue() {
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
            return null;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getApplogListener() != null) goto L7;
            return null;
        L7:
            return RequestManager.getInstance().getApplogListener();
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ b initialValue() {
            return initialValue();
        }
    }

    public interface b {
        void onInternalEventV3(String r100, JSONObject r101, String r102, String r103, String r104);
    }

    static {
        f4783b = new C0093a();
    }

    public static void a(b r100) {
        f4783b.set(r100);
    }

    public static void a(String r100, JSONObject r101, String r102) {
        if (f4783b.get() != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L20;
        r101 = new JSONObject();
    L20:
        r101.put(com.heytap.mcssdk.constant.b.C, "2.2.22.mt-alpha.1-lchj-mt");     // Catch: JSONException -> L9
    L12:
        if (f4782a == false) goto L22;
        f4783b.get().onInternalEventV3(r100, r101, null, null, r102);
    L22:
        r101.put("second_appid", "4159");     // Catch: JSONException -> L16
        r101.put("second_appname", "vboost_oversea");     // Catch: JSONException -> L16
    L18:
        LogUtil.debug("ApplogUtils", "onInternalEventV3 " + r100 + ": " + r101);
        f4783b.get().onInternalEventV3(r100, r101, "4160", "vboost", r102);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static boolean a() {
        if (f4783b.get() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
