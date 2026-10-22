package com.bytedanceos.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.ImageView;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedanceos.common.ad.Ad;
import com.bytedanceos.common.download.IJobScheduler;
import com.bytedanceos.common.model.MobileInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.DeviceUtil;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.g0;
import com.bytedanceos.common.toolbox.h;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.tt.helper.IMessageContext;
import com.bytedanceos.common.ui.listener.AppStateHelper;
import com.bytedanceos.common.ui.widget.AbstractAppItemView;
import com.bytedanceos.common.utils.ReflectTool;
import com.bytedanceos.common.utils.t;
import com.danikula.videocache.HttpProxyCacheServer;
import com.tencent.mmkv.MMKV;
import com.tmall.wireless.tangram.util.IInnerImageSetter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseApplication extends Application implements IMessageContext, ConnectionClassManager.ConnectionClassStateChangeListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f9540m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static BaseApplication f9541n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f9542o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f9543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Handler f9544q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f9545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MobileInfo f9549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IInnerImageSetter f9550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t f9551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HttpProxyCacheServer f9553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9556l;

    public class a implements IInnerImageSetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseApplication f9557a;

        public a(BaseApplication r10) {
            this.f9557a = r10;
        }

        @Override // com.tmall.wireless.tangram.util.IInnerImageSetter
        public void doLoadImageUrl(ImageView r10, String r11, float r12, boolean r13) {
            if ((r10 instanceof NetworkImageView) == false) goto L5;
            ((NetworkImageView) r10).f(r11, r12, r13);
            return;
        L5:
            j.a("class error,url:" + r11);
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what != 130) goto L7;
            e0.e(R$string.tip_bandwidth_state);
            return;
        }
    }

    static {
        f9544q = new b();
    }

    public BaseApplication() {
        this.f9548d = -1;
        this.f9552h = 0;
        this.f9555k = true;
    }

    public static BaseApplication c() {
        return f9541n;
    }

    public static HttpProxyCacheServer k(Context r10) {
        BaseApplication r11 = (BaseApplication) r10.getApplicationContext();
        HttpProxyCacheServer r12 = r11.f9553i;
        if (r12 != null) goto L6;
        HttpProxyCacheServer r13 = r11.s();
        r11.f9553i = r13;
        return r13;
    L6:
        return r12;
    }

    public static void u(String r10, boolean r11) {
        if (r11 == false) goto L4;
        f9543p--;
    L5:
        f9544q.removeCallbacksAndMessages(null);
        if (f9543p != 0) goto L8;
        f9544q.sendEmptyMessageDelayed(129, 300000);
    L8:
        j.e(r10 + " setCount:" + r11 + " |" + f9543p);
        return;
    L4:
        f9543p++;
        goto L5
    }

    public abstract void a();

    public abstract CommonCache b();

    public Activity d() {
        return this.f9545a;
    }

    public void destroy() {
        ConnectionClassManager.c().g(this);
        HttpProxyCacheServer r10 = this.f9553i;
        if (r10 == null) goto L5;
        r10.shutdown();
    L5:
        AbstractAppItemView.clearCache();
    }

    public int e() {
        if (this.f9548d != (-1)) goto L6;
        this.f9548d = DeviceUtil.f();
    L6:
        return this.f9548d;
    }

    public IInnerImageSetter f() {
        if (this.f9550f != null) goto L6;
        this.f9550f = new a(this);
    L6:
        return this.f9550f;
    }

    public abstract com.bytedanceos.common.download.a g();

    @Override // com.bytedanceos.common.tt.helper.IMessageContext
    public int getAid() {
        return ((Integer) getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.get("SS_APP_ID")).intValue();
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.bytedanceos.common.tt.helper.IMessageContext
    public String getTweakedChannel() {
        return String.valueOf(getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.get("SS_CHANNEL_ID"));
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @Override // com.bytedanceos.common.tt.helper.IMessageContext
    public String getVersion() {
        return "1.0.3";
    }

    @Override // com.bytedanceos.common.tt.helper.IMessageContext
    public int getVersionCode() {
        if (this.f9546b != 0) goto L9;
        this.f9546b = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        return this.f9546b;
    }

    public abstract IJobScheduler h();

    public MobileInfo i() {
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == false) goto L12;
        MobileInfo r10 = this.f9549e;
        if (r10 != null) goto L7;
    L8:
        this.f9549e = new MobileInfo();
    L10:
        return this.f9549e;
    L7:
        if (r10.isValid() == true) goto L10;
    L12:
        return new MobileInfo(true);
    }

    public String j() {
        if (o() == false) goto L5;
        String r10 = w8.b.a(600002);
    L7:
        return r10 + "?from=AppStoreGlobalReceiver";
    L5:
        r10 = w8.b.b(600002);
        goto L7
    }

    public String l() {
        StringBuilder r10 = new StringBuilder();
        if (o() == false) goto L5;
        String r11 = w8.b.a(1100000);
    L6:
        r10.append(r11);
        r10.append("&");
        r10.append(NetKey.MODEL);
        r10.append("=");
        r10.append(String.valueOf(com.bytedanceos.common.toolbox.d.f10009a));
        r10.append("&");
        r10.append("osver");
        r10.append("=");
        r10.append(com.bytedanceos.common.toolbox.e.U(false));
        return r10.toString();
    L5:
        r11 = w8.b.b(1100000);
        goto L6
    }

    public String m() {
        return f9542o;
    }

    public final void n() {
    }

    public abstract boolean o();

    @Override // com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager.ConnectionClassStateChangeListener
    public void onBandwidthStateChange(ConnectionQuality r10) {
        boolean r11 = ReflectTool.isAppInTop(getPackageName());
        j.m("bandwidthState " + r10.name() + "isAppInTop = " + r11);
        if (ConnectionQuality.POOR == r10) goto L9;
        if (ConnectionQuality.MODERATE == r10) goto L9;
        this.f9556l = false;
        f9544q.removeMessages(130);
        return;
    L9:
        if (this.f9556l == true) goto L14;
        if (r11 == false) goto L15;
        f9544q.removeMessages(130);
        f9544q.sendEmptyMessageDelayed(130, 10000);
        this.f9556l = true;
        return;
    L15:
        return;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        AbstractAppItemView.clearCache();
        this.f9554j = com.bytedanceos.common.toolbox.e.n0();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        t(this);
        t r10 = new t();
        this.f9551g = r10;
        r10.c();
        ConnectionClassManager.c().f(this);
        new com.bytedanceos.common.a().a();
        MMKV.j(this);     // Catch: UnsatisfiedLinkError -> L5
        g0.f10054b = true;     // Catch: UnsatisfiedLinkError -> L5
    L7:
        AppStateHelper.getInstance().register(c());
        Ad.getInstance().init();
        this.f9554j = com.bytedanceos.common.toolbox.e.n0();
        n();
        re.a.q("Application", "onCreate: version = 1.0.3,code = 100003070type = release");
        return;
    L5:
        e = move-exception;
        g0.f10054b = false;
        e.printStackTrace();
        h.d("mmkv");
        goto L7
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        AbstractAppItemView.clearCache();
    }

    @Override // android.app.Application
    public void onTerminate() {
        MMKV.onExit();
        super.onTerminate();
        HttpProxyCacheServer r10 = this.f9553i;
        if (r10 == null) goto L5;
        r10.shutdown();
    L5:
        AbstractAppItemView.clearCache();
    }

    public boolean p() {
        return this.f9555k;
    }

    public boolean q() {
        if (this.f9552h != 0) goto L6;
        this.f9552h = ((ActivityManager) getSystemService("activity")).getMemoryClass();
    L6:
        if (((Runtime.getRuntime().totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) / this.f9552h) <= 0.75d) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean r() {
        return this.f9547c;
    }

    public final HttpProxyCacheServer s() {
        return new HttpProxyCacheServer(this);
    }

    public final void t(BaseApplication r10) {
        f9541n = r10;
    }

    public void v(boolean r10) {
        this.f9555k = r10;
    }

    public void w(boolean r10) {
        this.f9547c = r10;
    }

    public abstract void x();
}
