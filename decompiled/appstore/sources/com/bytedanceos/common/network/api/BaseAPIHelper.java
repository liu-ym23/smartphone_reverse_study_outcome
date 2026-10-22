package com.bytedanceos.common.network.api;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.lifecycle.p;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.common.AdUtil;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.DeviceUtil;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import p8.b;
import y8.a;
import y8.f;
import y8.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAPIHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicReference f9847a;

    public interface Interceptor {
        boolean interceptRequest(int r10, int r11, int r12, Object[] r13, Map<String, String> r14, String r15, a r16, String r17);
    }

    static {
        f9847a = new AtomicReference();
    }

    public BaseAPIHelper() {
    }

    public static String a(String r10, Object... r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = r10.replaceFirst("#", String.valueOf(r11[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public static Map b(int r10) {
        HashMap r11 = new HashMap();
        r11.put("store-source", "obric");
        r11.put("User-Agent", b.f());
        r11.put(NetKey.DEVICE_ID, BaseApplication.c().i().getClientId());
        r11.put(NetKey.FEATURES, "1");
        r11.put("Content-Type", "application/json");
        r11.put(NetKey.TICKET, AccountDataCache.b().i());
        r11.put(NetKey.TOKEN, AccountDataCache.b().j());
        r11.put(NetKey.LANGUAGE, e.P());
        r11.put("Market-Version", "6.3");
        r11.put(NetKey.APP_VERSION, String.valueOf(e.f0()));
        r11.put(NetKey.MAC_ADDRESS, BaseApplication.c().i().mMacAdress);
        if (BaseApplication.c().o() == false) goto L6;
        r11.put(NetKey.KEY_TYPE, e.N(BaseApplication.c()));
    L6:
        if (r10 != 600002) goto L8;
        r11.put("androidver", String.valueOf(Build.VERSION.RELEASE));
        r11.put(NetKey.OSVER, e.U(true));
    L9:
        String r12 = "";
        String r13 = SystemProperties.get("ro.product.submodel", "");
        String r14 = String.valueOf(d.f10009a);
        if (TextUtils.isEmpty(r13) == true) goto L12;
        r14 = r14 + "-" + r13;
    L12:
        r11.put(NetKey.MODEL, r14);
        r11.put("Terminal", DeviceUtil.j());
        r11.put("Is-Tnt", String.valueOf(DeviceUtil.k(BaseApplication.c())));
        r11.put("Orientation", String.valueOf(AdUtil.getOrientation(BaseApplication.c())));
        r11.put("Is-Teenager", "false");
        r11.put("Open-Id", AccountDataCache.b().k());
        if (100001 == r10) goto L15;
    L19:
        return r11;
    L15:
        if (c.e() == null) goto L18;
        r12 = c.e().e();
    L18:
        r11.put("Source-Pkg-Name", r12);
        r11.put("Launch-Type", "unknown");
        goto L19
    L8:
        r11.put(NetKey.OSVER, e.U(false));
        goto L9
    }

    public static int c(int r10) {
        if (r10 != 1) goto L5;
        return 0;
    L5:
        if (r10 != 2) goto L7;
        return 1;
    L7:
        if (r10 != 3) goto L9;
        return 2;
    L9:
        if (r10 == 4) goto L12;
        return -1;
    L12:
        return 3;
    }

    public static String d(int r10, int r11, Object[] r12, Map r13) {
        String r14 = w8.b.c(r10, r11);
        if (TextUtils.isEmpty(r14) == false) goto L6;
        j.a("request url is null with api: " + r11);
        return null;
    L6:
        if (r12 != null) goto L8;
    L10:
        if (r13 != null) goto L12;
        r13 = new HashMap();
    L12:
        r13.put(NetKey.MODEL, String.valueOf(d.f10009a));
        if (r11 != 600002) goto L15;
        r13.put("osver", e.U(true));
    L17:
        return g.h(r14, r13);
    L15:
        r13.put("osver", e.U(false));
        goto L17
    L8:
        if (r12.length <= 0) goto L10;
        r14 = a(r14, r12);
        goto L10
    }

    public static void e(int r10, int r11, int r12, Object[] r13, Map r14, String r15, a r16) {
        f(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public static void f(int r13, int r14, int r15, Object[] r16, Map r17, String r18, a r19, String r20) {
        d9.a.e().B(r13, r15, r16, r17);
        Interceptor r10 = (Interceptor) f9847a.get();
        if (r10 != null) goto L5;
    L7:
        int r11 = c(r14);
        Map r12 = b(r15);
        if (r15 != 1000002) goto L10;
        r12.put(NetKey.TICKET, (String) r16[0]);
    L10:
        if (r17 != null) goto L12;
    L20:
        r12.put(NetKey.UID, BaseApplication.c().m());
        r12.put(NetKey.ANDROID_ID, BaseApplication.c().i().mAndroid_Id);
        r12.put(NetKey.NETWORK, e.S());
        r12.put(NetKey.RESOLUTION, BaseApplication.c().i().mResolution);
        r12.put(NetKey.TIME_STAMP, String.valueOf(System.currentTimeMillis()));
        String r21 = d(r13, r15, r16, r17);
        g r22 = new g(r11, r21, r19, r15);
        if (1000008 == r15) goto L26;
        if (r12.size() == 0) goto L26;
        r22.g(r12);
    L26:
        if (TextUtils.isEmpty(r18) == true) goto L29;
        r22.e(c0.a(r18));
    L29:
        if (TextUtils.isEmpty(r20) == true) goto L31;
        r22.setTag(r20);
    L31:
        j.a("[ApiCode:" + r15 + "]===========================BaseAPIHelper.sendRequest======================================");
        j.a("[ApiCode:" + r15 + "]method   : " + r14);
        j.a("[ApiCode:" + r15 + "]url      : " + r21);
        j.a("[ApiCode:" + r15 + "]headers  : " + r12);
        j.a("[ApiCode:" + r15 + "]body     : " + r18);
        StringBuilder r23 = new StringBuilder();
        r23.append("[ApiCode:");
        r23.append(r15);
        r23.append("]==========================================================================================");
        j.a(r23.toString());
        f.h().e(r22, r15);
        f.b(r22);
        return;
    L12:
        if (r15 != 900002) goto L14;
    L15:
        Iterator r24 = r17.keySet().iterator();
    L17:
        if (r24.hasNext() == false) goto L19;
        String r25 = (String) r24.next();
        r12.put(r25, (String) r17.get(r25));
        goto L17
    L19:
        r17.clear();
        goto L20
    L14:
        if (r15 != 1100002) goto L20;
    L5:
        if (r10.interceptRequest(r13, r14, r15, r16, r17, r18, r19, r20) == false) goto L7;
    }

    public static void g(int r10, String r11, Object[] r12, Map r13, String r14, a r15) {
        int r16 = c(r10);
        String r17 = g.h(r11, r13);
        Map r18 = b(0);
        r18.put(NetKey.UID, BaseApplication.c().m());
        r18.put(NetKey.ANDROID_ID, BaseApplication.c().i().mAndroid_Id);
        r18.put(NetKey.NETWORK, e.S());
        r18.put(NetKey.RESOLUTION, BaseApplication.c().i().mResolution);
        r18.put(NetKey.TIME_STAMP, String.valueOf(System.currentTimeMillis()));
        g r19 = new g(r16, r17, r15);
        if (r18.size() == 0) goto L6;
        r19.g(r18);
    L6:
        if (TextUtils.isEmpty(r14) == true) goto L8;
        r19.e(c0.a(r14));
    L8:
        j.a("[ApiURL]===========================BaseAPIHelper.sendRequest======================================");
        j.a("[ApiURL]method   : " + r10);
        j.a("[ApiURL]url      : " + r17);
        j.a("[ApiURL]headers  : " + r18);
        j.a("[ApiURL]body     : " + r14);
        j.a("[ApiURL]==========================================================================================");
        f.h().e(r19, 0);
        f.b(r19);
    }

    public static void h(int r10, int r11, int r12, Object[] r13, Map r14, String r15, FetchDataCallBack r16) {
        i(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public static void i(int r10, int r11, int r12, Object[] r13, Map r14, String r15, FetchDataCallBack r16, Object r17) {
        e(r10, r11, r12, r13, r14, r15, new y8.c(r12, r16, r17));
    }

    public static void j(int r10, int r11, int r12, Object[] r13, Map r14, String r15, FetchDataCallBack r16, Object r17, String r18) {
        e(r10, r11, r12, r13, r14, r15, new y8.c(r12, r16, r17));
    }

    public static void k(int r10, int r11, int r12, Object[] r13, Map r14, String r15, FetchDataCallBack r16) {
        e(r10, r11, r12, r13, r14, r15, new y8.c(r12, r16, null));
    }

    public static void l(int r10, int r11, int r12, Object[] r13, Map r14, String r15, FetchDataCallBack r16, Object r17) {
        e(r10, r11, r12, r13, r14, r15, new y8.c(r12, r16, r17));
    }

    public static void m(Interceptor r10) {
        p.a(f9847a, null, r10);
    }
}
