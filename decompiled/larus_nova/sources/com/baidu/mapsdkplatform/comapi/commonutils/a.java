package com.baidu.mapsdkplatform.comapi.commonutils;

import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.NAEngine;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f32030a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f32031b;

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.commonutils.a$a, reason: collision with other inner class name */
    public class RunnableC0642a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f32032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f32035d;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapsdkplatform_comapi_commonutils_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapsdkplatform_comapi_commonutils_a$a__run$___twin___() {
            NAEngine.a(this.f32032a.ordinal(), this.f32033b, this.f32034c);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapsdkplatform_comapi_commonutils_a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0642a r100) {
            r100.com_baidu_mapsdkplatform_comapi_commonutils_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0642a(a r100, c r101, String r102, String r103) {
            this.f32035d = r100;
            this.f32032a = r101;
            this.f32033b = r102;
            this.f32034c = r103;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32036a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f32037b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f32038c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f32039d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32040e;

        static {
            b r100 = new b("eMonitorConsole", 0, 1);
            f32036a = r100;
            b r101 = new b("eMonitorNative", 1, 2);
            f32037b = r101;
            b r102 = new b("eMonitorNet", 2, 4);
            f32038c = r102;
            f32039d = new b[]{r100, r101, r102};
        }

        public static b[] values() {
            return (b[]) f32039d.clone();
        }

        public int a() {
            return this.f32040e;
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        private b(String r100, int r101, int r102) {
            super(r100, r101);
            this.f32040e = r102;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32041a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f32042b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f32043c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f32044d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f32045e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f32046f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f32047g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ c[] f32048h = null;

        static {
            c r100 = new c("eNone", 0);
            f32041a = r100;
            c r101 = new c("eMonitorVerbose", 1);
            f32042b = r101;
            c r102 = new c("eMonitorDebug", 2);
            f32043c = r102;
            c r103 = new c("eMonitorInfo", 3);
            f32044d = r103;
            c r104 = new c("eMonitorWarn", 4);
            f32045e = r104;
            c r105 = new c("eMonitorError", 5);
            f32046f = r105;
            c r110 = new c("eMonitorRealTime", 6);
            f32047g = r110;
            f32048h = new c[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static c[] values() {
            return (c[]) f32048h.clone();
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        private c(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f32049a = null;

        static {
            f32049a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f32049a;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32050a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f32051b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f32052c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f32053d = null;

        static {
            e r100 = new e("SDK_MAP", 0);
            f32050a = r100;
            e r101 = new e("Net", 1);
            f32051b = r101;
            e r102 = new e("Engine", 2);
            f32052c = r102;
            f32053d = new e[]{r100, r101, r102};
        }

        public static e[] values() {
            return (e[]) f32053d.clone();
        }

        public static e valueOf(String r100) {
            return (e) r27.a.a(e.class, r100);
        }

        private e(String r100, int r101) {
            super(r100, r101);
        }
    }

    private void d() {
        NAEngine.a(new String[]{e.f32050a.name(), e.f32052c.name()});
    }

    public void c() {
        if (f32030a == true) goto L5;
        return;
    L5:
        if (f32031b == false) goto L10;
        f32031b = false;
        f32030a = false;
        NAEngine.a(false);
        return;
    }

    public static a a() {
        return d.a();
    }

    public void b() {
        boolean r100 = OpenLogUtil.isMapLogEnable();
        f32030a = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (f32031b == true) goto L13;
        String r101 = OpenLogUtil.getMapLogFilePath();
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = SysOSUtil.getInstance().getExternalFilesDir();
    L10:
        NAEngine.a(false);
        NAEngine.a(r101);
        NAEngine.b(b.f32037b.a());
        NAEngine.a(c.f32046f.ordinal());
        d();
        NAEngine.a(true);
        f32031b = true;
        return;
    }

    private a() {
    }

    public /* synthetic */ a(RunnableC0642a r100) {
        this();
    }

    public void a(String r100) {
        a(c.f32047g, e.f32050a.name(), r100);
    }

    private void a(c r100, String r101, String r102) {
        if (f32030a == true) goto L5;
        return;
    L5:
        MapTaskManager.getSingleThreadPool().submit(new RunnableC0642a(this, r100, r101, r102));
    }
}
