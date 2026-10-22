package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.bytedance.common.wschannel.WsConstants;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Callback> f25167e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f25168f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25169g = 122;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f25170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f25171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Callback f25172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f25173d;

    public static final enum BizType extends Enum<BizType> {
        public static final /* synthetic */ BizType[] $VALUES = null;
        public static final BizType AccountAuth = null;
        public static final BizType Deduct = null;
        public static final BizType Invoice = null;
        public String appId;

        static {
            BizType r100 = new BizType("Invoice", 0, "20000920");
            Invoice = r100;
            BizType r101 = new BizType("AccountAuth", 1, "20000067");
            AccountAuth = r101;
            BizType r102 = new BizType("Deduct", 2, "60000157");
            Deduct = r102;
            $VALUES = new BizType[]{r100, r101, r102};
        }

        public static BizType[] values() {
            return (BizType[]) $VALUES.clone();
        }

        public static /* synthetic */ String access$100(BizType r100) {
            return r100.appId;
        }

        public static BizType valueOf(String r100) {
            return (BizType) r27.a.a(BizType.class, r100);
        }

        public BizType(String r100, int r101, String r102) {
            super(r100, r101);
            this.appId = r102;
        }
    }

    public interface Callback {
        void onResult(int r100, String r101, Bundle r102);
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25174a = null;

        static {
            int[] r100 = new int[BizType.values().length];
            f25174a = r100;
            r100[BizType.Deduct.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f25174a[BizType.AccountAuth.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f25174a[BizType.Invoice.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f25175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f25177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OpenAuthTask f25178d;

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_app_OpenAuthTask$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_app_OpenAuthTask$b__run$___twin___() {
            if (OpenAuthTask.a(this.f25178d) == null) goto L6;
            OpenAuthTask.a(this.f25178d).onResult(this.f25175a, this.f25176b, this.f25177c);
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_app_OpenAuthTask$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_alipay_sdk_app_OpenAuthTask$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(OpenAuthTask r100, int r101, String r102, Bundle r103) {
            this.f25178d = r100;
            this.f25175a = r101;
            this.f25176b = r102;
            this.f25177c = r103;
        }

        public /* synthetic */ b(OpenAuthTask r100, int r101, String r102, Bundle r103, a r104) {
            this(r100, r101, r102, r103);
        }
    }

    static {
        f25167e = new ConcurrentHashMap();
        f25168f = -1;
    }

    public OpenAuthTask(Activity r100) {
        this.f25170a = false;
        this.f25173d = new Handler(Looper.getMainLooper());
        this.f25171b = r100;
        com.alipay.sdk.m.s.b.d().a(r100);
    }

    public static /* synthetic */ Callback a(OpenAuthTask r100) {
        return r100.f25172c;
    }

    private String a(BizType r100, Map<String, String> r101) {
        if (r100 == null) goto L14;
        Uri.Builder r102 = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", BizType.access$100(r100));
        if (a.f25174a[r100.ordinal()] != 1) goto L7;
        r102.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
    L7:
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, String> r104 = r103.next();
        r102.appendQueryParameter(r104.getKey(), r104.getValue());
        goto L9
    L12:
        return r102.build().toString();
    L14:
        throw new RuntimeException("missing bizType");
    }

    private String a(long r100, String r101, BizType r102, String r103) throws JSONException {
        JSONObject r104 = new JSONObject();
        r104.put(DyPayConstant.KEY_START_TIME, String.valueOf(r100));
        r104.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r101);
        r104.put("package", this.f25171b.getPackageName());
        if (r102 == null) goto L5;
        r104.put("appId", BizType.access$100(r102));
    L5:
        r104.put(com.heytap.mcssdk.constant.b.C, "h.a.3.8.15");
        r104.put("mqpURL", r103);
        return Base64.encodeToString(r104.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    public static void a(String r100, int r101, String r102, Bundle r103) {
        Callback r104 = f25167e.remove(r100);
        if (r104 == null) goto L11;
        r104.onResult(r101, r102, r103);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        e.a(th);
        return;
    }

    private boolean a(com.alipay.sdk.m.s.a r110, String r111, BizType r210, Map<String, String> r211, boolean r212) {
        if (this.f25170a == false) goto L6;
        this.f25173d.post(new b(this, 4000, "该 OpenAuthTask 已在执行", null, null));
        return true;
    L6:
        this.f25170a = true;
        long r112 = SystemClock.elapsedRealtime();
        if ((r112 - f25168f) > 3000) goto L10;
        this.f25173d.post(new b(this, 5000, "3s 内重复支付", null, null));
        return true;
    L10:
        f25168f = r112;
        com.alipay.sdk.m.j.a.a("");
        String r113 = n.a(32);
        HashMap r100 = new HashMap(r211);
        r100.put("mqpPkgName", this.f25171b.getPackageName());
        r100.put("mqpScene", "sdk");
        List<com.alipay.sdk.m.m.a.b> r101 = com.alipay.sdk.m.m.a.D().l();
        if (com.alipay.sdk.m.m.a.D().f25566h == false) goto L13;
        if (r101 == null) goto L13;
    L14:
        n.c r114 = n.a(r110, this.f25171b, r101);
        if (r114 != null) goto L17;
    L51:
        if (r212 == false) goto L54;
        r100.put("mqpScheme", String.valueOf(r111));
        r100.put("mqpNotifyName", r113);
        r100.put("mqpScene", "landing");
        String r102 = a(r210, r100);
        Intent r103 = new Intent(this.f25171b, H5OpenAuthActivity.class);
        r103.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", new Object[]{Uri.encode(r102)}));
        com.alipay.sdk.m.s.a.C0493a.a(r110, r103);
        this.f25171b.startActivity(r103);
        return false;
    L54:
        this.f25173d.post(new b(this, 4001, "支付宝未安装或签名错误", null, null));
        return true;
    L17:
        if (r114.a(r110) == true) goto L51;
        if (r114.a() == true) goto L51;
        PackageInfo r104 = r114.f25880a;
        if (r104 == null) goto L51;
        if (r104.versionCode < 122) goto L51;
        HashMap<String, String> r105 = com.alipay.sdk.m.s.a.a(r110);     // Catch: Throwable -> L31
        r105.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L31
        r100.put("mqpLoc", new JSONObject(r105).toString());     // Catch: Throwable -> L31
    L33:
        String r106 = a(r210, r100);     // Catch: Throwable -> L49
        f25167e.put(r113, this.f25172c);
        String r107 = a(r112, r113, r210, r106);     // Catch: JSONException -> L37
    L40:
        if (TextUtils.isEmpty(r107) == false) goto L43;
        this.f25173d.post(new b(this, 4000, "参数错误", null, null));
        return true;
    L43:
        Intent r108 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20001129").appendQueryParameter(WsConstants.KEY_PAYLOAD, r107).build());
        r108.addFlags(268435456);
        r108.setPackage(r114.f25880a.packageName);
        com.alipay.sdk.m.k.a.a(r110, "biz", com.alipay.sdk.m.k.b.Y, "" + r112);     // Catch: Throwable -> L46
        com.alipay.sdk.m.s.a.C0493a.a(r110, r113);     // Catch: Throwable -> L46
        this.f25171b.startActivity(r108);     // Catch: Throwable -> L46
    L48:
        return false;
    L46:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r110, "biz", "StartWalletEx", th);
    L37:
        e = move-exception;
        com.alipay.sdk.m.k.a.a(r110, "biz", com.alipay.sdk.m.k.b.f25419q0, e);
        r107 = null;
        goto L40
    L31:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r110, "biz", "OpenAuthLocEx", th);     // Catch: Throwable -> L49
    L49:
        this.f25173d.post(new b(this, 4000, "业务参数错误", null, null));
        return true;
    L13:
        r101 = com.alipay.sdk.m.j.a.f25359d;
        goto L14
    }

    public void execute(String r100, BizType r101, Map<String, String> r110, Callback r111, boolean r112) {
        com.alipay.sdk.m.s.a r102 = new com.alipay.sdk.m.s.a(this.f25171b, String.valueOf(r110), "oa-" + r101);
        this.f25172c = r111;     // Catch: Throwable -> L7
        if (a(r102, r100, r101, r110, r112) == false) goto L11;
        com.alipay.sdk.m.k.a.b(this.f25171b, r102, "", r102.f25772d);
        return;
    L11:
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
