package com.baidu.platform.comapi.util;

import android.os.Build;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.vi.VIContext;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.tencent.qqmusic.third.api.contract.Keys;

/* JADX INFO: loaded from: classes39.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NACommonMemCache f33423a;

    static {
        f33423a = new NACommonMemCache();
    }

    private static void c() {
        JsonBuilder r100 = new JsonBuilder();
        f33423a.b(SyncSysInfo.initPhoneInfo());
        d();
        r100.reset();
        r100.object();
        r100.putStringValue(EngineImpl.KEY_CUID, SyncSysInfo.getCid());
        r100.putStringValue("app", "1");
        r100.putStringValue("path", VIContext.getContext().getCacheDir().getAbsolutePath() + HTTP.URL_DEFAULT);
        r100.putStringValue("domain", "");
        r100.endObject();
        f33423a.b("longlink", r100.getJson());
    }

    public static void d() {
        JsonBuilder r100 = new JsonBuilder();
        r100.object();
        r100.key("sw").value(SysOSUtil.getInstance().getScreenWidth());
        r100.key("sh").value(SysOSUtil.getInstance().getScreenHeight());
        r100.putStringValue("ver", "2");
        r100.putStringValue("pd", "mapsdk");
        r100.putStringValue("os", "android");
        r100.putStringValue(com.alipay.sdk.m.s.a.f25762t, SyncSysInfo.getSoftWareVer());
        r100.putStringValue("ov", "Android" + Build.VERSION.SDK_INT);
        r100.putStringValue(EngineImpl.KEY_CUID, SyncSysInfo.getCid());
        r100.putStringValue("ch", "mapsdk");
        r100.putStringValue("channel", "mapsdk");
        r100.putStringValue(Keys.API_PARAM_KEY_MB, SyncSysInfo.getPhoneType());
        r100.putStringValue("path", SysOSUtil.getInstance().getExternalFilesDir());
        r100.endObject();
        f33423a.b("logstatistics", r100.getJson());
    }

    public static void a() {
        c();
    }

    public static NACommonMemCache b() {
        return f33423a;
    }
}
