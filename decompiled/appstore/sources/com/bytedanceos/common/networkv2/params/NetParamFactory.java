package com.bytedanceos.common.networkv2.params;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p8.b;

/* JADX INFO: loaded from: classes2.dex */
public class NetParamFactory {
    private static volatile NetParamFactory sInstance;
    private HashMap mHeaderParams;
    private HashMap mUrlParams;

    private NetParamFactory() {
    }

    public static NetParamFactory instance() {
        if (sInstance != null) goto L16;
        monitor-enter(NetParamFactory.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new NetParamFactory();     // Catch: Throwable -> L9
    L11:
        monitor-exit(NetParamFactory.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public Map getHeaderParams() {
        HashMap r10 = new HashMap();
        HashMap r11 = this.mHeaderParams;
        if (r11 == null) goto L5;
        r11.put(NetKey.DEVICE_ID, BaseApplication.c().i().getClientId());
        this.mHeaderParams.put(NetKey.IMEI, BaseApplication.c().i().getClientId());
        r10.putAll(this.mHeaderParams);
    L5:
        r10.put(NetKey.TIME_STAMP, String.valueOf(System.currentTimeMillis()));
        r10.put(NetKey.TICKET, AccountDataCache.b().i());
        r10.put(NetKey.TOKEN, AccountDataCache.b().j());
        r10.put(NetKey.LANGUAGE, e.P());
        Iterator r12 = r10.keySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        if (r10.get(r13) != null) goto L7;
        r10.put(r13, "");
        goto L7
    L11:
        return r10;
    }

    public Map getUrlParams() {
        HashMap r10 = this.mUrlParams;
        if (r10 == null) goto L6;
        r10.put(NetKey.IMEI, BaseApplication.c().i().getClientId());
    L6:
        return this.mUrlParams;
    }

    public void init() {
        HashMap r10 = this.mHeaderParams;
        if (r10 != null) goto L5;
        this.mHeaderParams = new HashMap();
    L6:
        this.mHeaderParams.put("store-source", "obric");
        this.mHeaderParams.put("User-Agent", b.f());
        this.mHeaderParams.put(NetKey.APP_VERSION, String.valueOf(e.f0()));
        this.mHeaderParams.put(NetKey.UID, BaseApplication.c().m());
        this.mHeaderParams.put(NetKey.ANDROID_ID, BaseApplication.c().i().mAndroid_Id);
        this.mHeaderParams.put(NetKey.NETWORK, e.S());
        this.mHeaderParams.put(NetKey.RESOLUTION, BaseApplication.c().i().mResolution);
        String r11 = SystemProperties.get("ro.product.submodel", "");
        String r12 = d.f10009a;
        String r13 = String.valueOf(r12);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        r13 = r13 + "-" + r11;
    L9:
        this.mHeaderParams.put(NetKey.MODEL, r13);
        this.mHeaderParams.put(NetKey.OSVER, e.U(false));
        this.mHeaderParams.put(NetKey.MAC_ADDRESS, BaseApplication.c().i().mMacAdress);
        if (BaseApplication.c().o() == false) goto L12;
        this.mHeaderParams.put(NetKey.KEY_TYPE, e.N(BaseApplication.c()));
    L12:
        HashMap r14 = this.mUrlParams;
        if (r14 != null) goto L15;
        this.mUrlParams = new HashMap();
    L16:
        this.mUrlParams.put(NetKey.OSVER, e.U(false));
        this.mUrlParams.put(NetKey.MODEL, r12);
        if (BaseApplication.c().o() == false) goto L19;
        this.mUrlParams.put("source", "1");
        return;
    L19:
        this.mUrlParams.put("source", "2");
        return;
    L15:
        r14.clear();
        goto L16
    L5:
        r10.clear();
        goto L6
    }
}
