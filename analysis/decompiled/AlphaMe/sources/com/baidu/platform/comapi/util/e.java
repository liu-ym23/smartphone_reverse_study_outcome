package com.baidu.platform.comapi.util;

import android.os.Build;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.vi.VIContext;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static NACommonMemCache f9303a = new NACommonMemCache();

    public static void a() {
        c();
    }

    public static NACommonMemCache b() {
        return f9303a;
    }

    private static void c() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        f9303a.b(SyncSysInfo.initPhoneInfo());
        d();
        jsonBuilder.reset();
        jsonBuilder.object();
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, SyncSysInfo.getCid());
        jsonBuilder.putStringValue("app", "1");
        jsonBuilder.putStringValue("path", VIContext.getContext().getCacheDir().getAbsolutePath() + "/");
        jsonBuilder.putStringValue("domain", "");
        jsonBuilder.endObject();
        f9303a.b("longlink", jsonBuilder.getJson());
    }

    public static void d() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.key("sw").value(SysOSUtil.getInstance().getScreenWidth());
        jsonBuilder.key("sh").value(SysOSUtil.getInstance().getScreenHeight());
        jsonBuilder.putStringValue("ver", "2");
        jsonBuilder.putStringValue("pd", "mapsdk");
        jsonBuilder.putStringValue("os", "android");
        jsonBuilder.putStringValue("sv", SyncSysInfo.getSoftWareVer());
        jsonBuilder.putStringValue("ov", "Android" + Build.VERSION.SDK_INT);
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, SyncSysInfo.getCid());
        jsonBuilder.putStringValue("ch", "mapsdk");
        jsonBuilder.putStringValue("channel", "mapsdk");
        jsonBuilder.putStringValue("mb", SyncSysInfo.getPhoneType());
        jsonBuilder.putStringValue("path", SysOSUtil.getInstance().getExternalFilesDir());
        jsonBuilder.endObject();
        f9303a.b("logstatistics", jsonBuilder.getJson());
    }
}
