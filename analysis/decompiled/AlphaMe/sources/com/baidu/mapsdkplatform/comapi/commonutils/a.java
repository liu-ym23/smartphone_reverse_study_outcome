package com.baidu.mapsdkplatform.comapi.commonutils;

import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.NAEngine;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7906a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f7907b = false;

    /* renamed from: com.baidu.mapsdkplatform.comapi.commonutils.a$a, reason: collision with other inner class name */
    public class RunnableC0025a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7908a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7909b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7910c;

        public RunnableC0025a(c cVar, String str, String str2) {
            this.f7908a = cVar;
            this.f7909b = str;
            this.f7910c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NAEngine.a(this.f7908a.ordinal(), this.f7909b, this.f7910c);
        }
    }

    public enum b {
        eMonitorConsole(1),
        eMonitorNative(2),
        eMonitorNet(4);


        /* renamed from: e, reason: collision with root package name */
        private int f7916e;

        b(int i4) {
            this.f7916e = i4;
        }

        public int a() {
            return this.f7916e;
        }
    }

    public enum c {
        eNone,
        eMonitorVerbose,
        eMonitorDebug,
        eMonitorInfo,
        eMonitorWarn,
        eMonitorError,
        eMonitorRealTime
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7925a = new a(null);
    }

    public enum e {
        SDK_MAP,
        Net,
        Engine
    }

    public /* synthetic */ a(RunnableC0025a runnableC0025a) {
        this();
    }

    public static a a() {
        return d.f7925a;
    }

    private void d() {
        NAEngine.a(new String[]{e.SDK_MAP.name(), e.Engine.name()});
    }

    public void b() {
        boolean zIsMapLogEnable = OpenLogUtil.isMapLogEnable();
        f7906a = zIsMapLogEnable;
        if (!zIsMapLogEnable || f7907b) {
            return;
        }
        String mapLogFilePath = OpenLogUtil.getMapLogFilePath();
        if (TextUtils.isEmpty(mapLogFilePath)) {
            mapLogFilePath = SysOSUtil.getInstance().getExternalFilesDir();
        }
        NAEngine.a(false);
        NAEngine.a(mapLogFilePath);
        NAEngine.b(b.eMonitorNative.a());
        NAEngine.a(c.eMonitorError.ordinal());
        d();
        NAEngine.a(true);
        f7907b = true;
    }

    public void c() {
        if (f7906a && f7907b) {
            f7907b = false;
            f7906a = false;
            NAEngine.a(false);
        }
    }

    private a() {
    }

    public void a(String str) {
        a(c.eMonitorRealTime, e.SDK_MAP.name(), str);
    }

    private void a(c cVar, String str, String str2) {
        if (f7906a) {
            MapTaskManager.getSingleThreadPool().submit(new RunnableC0025a(cVar, str, str2));
        }
    }
}
