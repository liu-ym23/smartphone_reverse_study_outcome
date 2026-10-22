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

/* JADX INFO: loaded from: classes39.dex */
public class SysUpdateUtil implements SysUpdateObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NACommonMemCache f32029a;

    public SysUpdateUtil() {
        f32029a = e.b();
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init(String r100) {
        if (f32029a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        r100 = SyncSysInfo.getPhoneInfoCache();
    L7:
        f32029a.b(r100);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateCuid(String r100) {
        NACommonMemCache r101 = f32029a;
        if (r101 == null) goto L6;
        r101.a(EngineImpl.KEY_CUID, r100);
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context r100) {
        NetworkUtil.updateNetworkProxy(r100);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkProxy(Context r100) {
        b.a().b(SysOSUtil.getNetType());
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo(String r100) {
        NACommonMemCache r101 = f32029a;
        if (r101 == null) goto L6;
        String r102 = r101.a("logstatistics");
        f32029a.b(r100);
        f32029a.b("logstatistics", r102);
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateZid(String r100) {
        NACommonMemCache r101 = f32029a;
        if (r101 == null) goto L6;
        r101.a("zid", r100);
        return;
    }
}
