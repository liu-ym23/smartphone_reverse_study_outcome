package com.baidu.platform.comapi.b;

import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.networkdetect.NANetworkDetect;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NANetworkDetect f32732a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f32733a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_b_b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_b_b$a__run$___twin___() {
            b.a(this.f32733a, "netchanged");
        }

        public a(b r100) {
            this.f32733a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_b_b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_platform_comapi_b_b$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.baidu.platform.comapi.b.b$b, reason: collision with other inner class name */
    public static final class C0662b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f32734a = null;

        static {
            f32734a = new b(null);
        }

        public static /* synthetic */ b a() {
            return f32734a;
        }
    }

    public static b a() {
        return C0662b.a();
    }

    private b() {
    }

    public /* synthetic */ b(com.baidu.platform.comapi.b.a r100) {
        this();
    }

    private void a(String r100) {
        if (e.b() > 0) goto L6;
        return;
    L6:
        if (this.f32732a != null) goto L8;
        this.f32732a = new NANetworkDetect();
    L8:
        String r101 = NetworkUtil.getCurrentNetMode(JNIInitializer.getCachedContext());
        SysOSUtil.getInstance().updateNetType(r101);
        if (this.f32732a == null) goto L21;
        JsonBuilder r102 = new JsonBuilder();     // Catch: Exception -> L16
        r102.object();     // Catch: Exception -> L16
        r102.key("nettype").value(CastIntegerProtector.parseInt(r101));     // Catch: NumberFormatException -> L13 Exception -> L16
    L14:
        int r103 = NetworkUtil.getNetworkOperatorType(JNIInitializer.getCachedContext());     // Catch: Exception -> L16
        r102.key("telecomtype").value(r103);     // Catch: Exception -> L16
        r102.key("triggerType").value(r100);     // Catch: Exception -> L16
        r102.endObject();     // Catch: Exception -> L16
        this.f32732a.a(r102.toString());     // Catch: Exception -> L16
        return;
    L13:
        r102.key("nettype").value(-1);     // Catch: Exception -> L16
    L22:
        return;
    }

    public void b(String r100) {
        String r101 = SysOSUtil.getInstance().getNetType();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.equals(r101) == true) goto L9;
        MapTaskManager.getSingleThreadPool().submit(new a(this));
        return;
    }

    public static /* synthetic */ void a(b r100, String r101) {
        r100.a(r101);
    }
}
