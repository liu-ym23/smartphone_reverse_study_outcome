package ara;

import com.bytedance.android.ec.slice.SliceInitService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16045a = 0;

    public a() {
    }

    static {
    }

    public static void b(String r100, String r101, String r102, long r103, String r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = SliceInitService.DEFAULT_SWITCH;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        tb7.a.a("account-jsb", "account_sdk_jsb_invoke{" + r100 + "} success,duration:" + r103 + ",params:" + r101 + ",response:" + r102);
        JSONObject r106 = new JSONObject();
        r106.put(com.alipay.sdk.m.p.e.f25671s, r100);
        r106.put("params", r101);
        r106.put("response", r102);
        r106.put("duration", r103);
        r106.put("status", "success");
        if (r104 == null) goto L14;
        r106.put("extra_0", r104);
    L14:
        com.bytedance.sdk.account.monitor.a.a("account_sdk_jsb_invoke", r106);
    }

    public static void a(String r100, String r101, String r102, long r103, String r104, String r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r106 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 32) == 0) goto L14;
        r105 = null;
    L14:
        tb7.a.a("account-jsb", "account_sdk_jsb_invoke{" + r100 + "} fail,duration:" + r103 + ",params:" + r101 + ",fail_info:" + r102);
        JSONObject r107 = new JSONObject();
        r107.put(com.alipay.sdk.m.p.e.f25671s, r100);
        r107.put("params", r101);
        r107.put("duration", r103);
        r107.put("status", "fail");
        r107.put("fail_info", r102);
        if (r104 == null) goto L17;
        r107.put("extra_0", r104);
    L17:
        if (r105 == null) goto L19;
        r107.put("extra_1", r105);
    L19:
        com.bytedance.sdk.account.monitor.a.a("account_sdk_jsb_invoke", r107);
    }
}
