package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comapi.b.b;
import com.baidu.platform.comapi.util.e;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;

/* loaded from: classes.dex */
public class SysUpdateUtil implements SysUpdateObserver {

    /* renamed from: a, reason: collision with root package name */
    private static NACommonMemCache f7905a;

    public SysUpdateUtil() {
        f7905a = e.b();
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init(String str) {
        if (f7905a != null) {
            if (TextUtils.isEmpty(str)) {
                str = SyncSysInfo.getPhoneInfoCache();
            }
            f7905a.b(str);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateCuid(String str) {
        NACommonMemCache nACommonMemCache = f7905a;
        if (nACommonMemCache != null) {
            nACommonMemCache.a(EngineImpl.KEY_CUID, str);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context context) {
        NetworkUtil.updateNetworkProxy(context);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkProxy(Context context) {
        b.a().b(SysOSUtil.getNetType());
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo(String str) {
        NACommonMemCache nACommonMemCache = f7905a;
        if (nACommonMemCache != null) {
            String strA = nACommonMemCache.a("logstatistics");
            f7905a.b(str);
            f7905a.b("logstatistics", strA);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateZid(String str) {
        NACommonMemCache nACommonMemCache = f7905a;
        if (nACommonMemCache != null) {
            nACommonMemCache.a("zid", str);
        }
    }
}
