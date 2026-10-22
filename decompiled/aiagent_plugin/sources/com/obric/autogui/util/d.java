package com.obric.autogui.util;

import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: CommonParamsUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31513a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d f31514d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f31515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.f f31516c;

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final d a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            if (d.g() != null) goto L5;
            d.a(new d(r1, null));
        L5:
            d r3 = d.g();
            d.h.b.o.a(r3);
            return r3;
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.a<String> {
        b(Object r8) {
            super(0, r8, d.class, "getDeviceBrand", "getDeviceBrand()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.b((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.a<String> {
        c(Object r8) {
            super(0, r8, d.class, "getDeviceResolution", "getDeviceResolution()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.j((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.util.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class C0864d extends d.h.b.l implements d.h.a.a<String> {
        C0864d(Object r8) {
            super(0, r8, d.class, "getTotalStorageSize", "getTotalStorageSize()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.k((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class e extends d.h.b.l implements d.h.a.a<String> {
        e(Object r8) {
            super(0, r8, d.class, "getSDAvailableSize", "getSDAvailableSize()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.l((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.a<Integer> {
        f(Object r8) {
            super(0, r8, d.class, "getDeviceWidth", "getDeviceWidth()I", 0);
        }

        public final Integer a() {
            return Integer.valueOf(((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin")).a());
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class g extends d.h.b.l implements d.h.a.a<Integer> {
        g(Object r8) {
            super(0, r8, d.class, "getDeviceBatteryPercent", "getDeviceBatteryPercent()I", 0);
        }

        public final Integer a() {
            return Integer.valueOf(d.m((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class h extends d.h.b.l implements d.h.a.a<Integer> {
        h(Object r8) {
            super(0, r8, d.class, "getOsApi", "getOsApi()I", 0);
        }

        public final Integer a() {
            return Integer.valueOf(d.n((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class i extends d.h.b.l implements d.h.a.a<String> {
        i(Object r8) {
            super(0, r8, d.class, "getOsBaseband", "getOsBaseband()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.o((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class j extends d.h.b.l implements d.h.a.a<String> {
        j(Object r8) {
            super(0, r8, d.class, "getOsBuildDate", "getOsBuildDate()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.p((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.a<String> {
        k(Object r8) {
            super(0, r8, d.class, "getOsKernel", "getOsKernel()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.q((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class l extends d.h.b.l implements d.h.a.a<String> {
        l(Object r8) {
            super(0, r8, d.class, "getOsLanguage", "getOsLanguage()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.r((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class m extends d.h.b.l implements d.h.a.a<Float> {
        m(Object r8) {
            super(0, r8, d.class, "getCurrentScreenBrightness", "getCurrentScreenBrightness()F", 0);
        }

        public final Float a() {
            return Float.valueOf(d.c((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class n extends d.h.b.l implements d.h.a.a<String> {
        n(Object r8) {
            super(0, r8, d.class, "getOsNetworkType", "getOsNetworkType()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.s((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class o extends d.h.b.l implements d.h.a.a<String> {
        o(Object r8) {
            super(0, r8, d.class, "getOsOtaVersion", "getOsOtaVersion()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.t((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class p extends d.h.b.l implements d.h.a.a<String> {
        p(Object r8) {
            super(0, r8, d.class, "getOsOtaMajorVersion", "getOsOtaMajorVersion()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.u((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class q extends d.h.b.l implements d.h.a.a<String> {
        q(Object r8) {
            super(0, r8, d.class, "getOsTimezone", "getOsTimezone()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.v((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class r extends d.h.b.l implements d.h.a.a<String> {
        r(Object r8) {
            super(0, r8, d.class, "getDeviceId", "getDeviceId()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.w((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class s extends d.h.b.l implements d.h.a.a<String> {
        s(Object r8) {
            super(0, r8, d.class, "getCpuArchitecture", "getCpuArchitecture()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.d((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class t extends d.h.b.l implements d.h.a.a<Integer> {
        t(Object r8) {
            super(0, r8, d.class, "getCpuCoreCount", "getCpuCoreCount()I", 0);
        }

        public final Integer a() {
            return Integer.valueOf(d.e((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class u extends d.h.b.l implements d.h.a.a<String> {
        u(Object r8) {
            super(0, r8, d.class, "getCpuString", "getCpuString()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.f((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class v extends d.h.b.l implements d.h.a.a<Integer> {
        v(Object r8) {
            super(0, r8, d.class, "getDeviceHeight", "getDeviceHeight()I", 0);
        }

        public final Integer a() {
            return Integer.valueOf(((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin")).b());
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class w extends d.h.b.l implements d.h.a.a<Boolean> {
        w(Object r8) {
            super(0, r8, d.class, "getDeviceIsCharging", "getDeviceIsCharging()Z", 0);
        }

        public final Boolean a() {
            return Boolean.valueOf(d.g((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class x extends d.h.b.l implements d.h.a.a<String> {
        x(Object r8) {
            super(0, r8, d.class, "getDeviceModel", "getDeviceModel()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.h((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    /* synthetic */ class y extends d.h.b.l implements d.h.a.a<String> {
        y(Object r8) {
            super(0, r8, d.class, "getDevicePoweronDuration", "getDevicePoweronDuration()Ljava/lang/String;", 0);
        }

        public final String a() {
            return d.i((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CommonParamsUtil.kt */
    public static final class z extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f31517a;

        z(d.h.b.z.d r1) {
            this.f31517a = r1;
        }

        public void onReceive(Context r5, Intent r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "context");
            d.h.b.o.e(r6, MemorySourceLinkType.INTENT);
            this.f31517a.f38502a = (int) ((r6.getIntExtra("level", -1) / r6.getIntExtra("scale", -1)) * 100);
            ZeusTransformUtils.unregisterReceiver(r7, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }
    }

    static {
        f31513a = new a(null);
    }

    public /* synthetic */ d(Context r2, d.h.b.h r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private final String D() {
        return RomInfo.KEY_OS_TYPE;
    }

    public static /* synthetic */ Map lambda$8rkeBUR4DgkxBEFPzCmzuUkBbc8(d r0) {
        return x(r0);
    }

    private d(Context r3) {
        this.f31515b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f31516c = d.g.a(new $$Lambda$d$8rkeBUR4DgkxBEFPzCmzuUkBbc8(this));
    }

    public static final /* synthetic */ void a(d r0) {
        f31514d = r0;
    }

    public static final /* synthetic */ String b(d r0) {
        return r0.j();
    }

    public static final /* synthetic */ float c(d r0) {
        return r0.C();
    }

    public static final /* synthetic */ String d(d r0) {
        return r0.G();
    }

    public static final /* synthetic */ int e(d r0) {
        return r0.H();
    }

    public static final /* synthetic */ String f(d r0) {
        return r0.A();
    }

    public static final /* synthetic */ d g() {
        return f31514d;
    }

    public static final /* synthetic */ boolean g(d r0) {
        return r0.l();
    }

    public static final /* synthetic */ String h(d r0) {
        return r0.k();
    }

    public static final /* synthetic */ String i(d r0) {
        return r0.n();
    }

    public static final /* synthetic */ String j(d r0) {
        return r0.i();
    }

    public static final /* synthetic */ String k(d r0) {
        return r0.E();
    }

    public static final /* synthetic */ String l(d r0) {
        return r0.F();
    }

    public static final /* synthetic */ int m(d r0) {
        return r0.m();
    }

    public static final /* synthetic */ int n(d r0) {
        return r0.o();
    }

    public static final /* synthetic */ String o(d r0) {
        return r0.q();
    }

    public static final /* synthetic */ String p(d r0) {
        return r0.s();
    }

    public static final /* synthetic */ String q(d r0) {
        return r0.r();
    }

    public static final /* synthetic */ String r(d r0) {
        return r0.u();
    }

    public static final /* synthetic */ String s(d r0) {
        return r0.w();
    }

    public static final /* synthetic */ String t(d r0) {
        return r0.p();
    }

    public static final /* synthetic */ String u(d r0) {
        return r0.t();
    }

    public static final /* synthetic */ String v(d r0) {
        return r0.v();
    }

    public static final /* synthetic */ String w(d r0) {
        return r0.I();
    }

    private final Map<String, d.h.a.a<Object>> h() {
        return (Map) ZeusTransformUtils.preCheckCast(this.f31516c.b(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final Map x(d r3) {
        return ao.a(new d.m[]{d.s.a(HardwareInfo.KEY_HW_VENDOR_BRAND, new b(r3)), d.s.a("device_brightness", new m(r3)), d.s.a("device_cpu_architecture", new s(r3)), d.s.a("device_cpu_corenum", new t(r3)), d.s.a("device_cpu_info", new u(r3)), d.s.a("device_height", new v(r3)), d.s.a("device_is_charging", new w(r3)), d.s.a(HardwareInfo.KEY_HW_VENDOR_MODEL, new x(r3)), d.s.a("device_poweron_duration", new y(r3)), d.s.a("device_resolution", new c(r3)), d.s.a("device_storage_total", new C0864d(r3)), d.s.a("device_storage_available", new e(r3)), d.s.a("device_width", new f(r3)), d.s.a("device_battery_percent", new g(r3)), d.s.a(RomInfo.KEY_ROM_OS_API, new h(r3)), d.s.a("os_baseband", new i(r3)), d.s.a("os_build_date", new j(r3)), d.s.a("os_kernel", new k(r3)), d.s.a("os_language", new l(r3)), d.s.a("os_network_type", new n(r3)), d.s.a("os_ota_version", new o(r3)), d.s.a("os_rom_version", new p(r3)), d.s.a("os_timezone", new q(r3)), d.s.a("device_id", new r(r3))});
    }

    public final int a() {
        Object r2 = this.f31515b.getSystemService("window");
        d.h.b.o.a(r2, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r3 = (WindowManager) ZeusTransformUtils.preCheckCast(r2, WindowManager.class, "com.obric.aiagent.plugin");
        DisplayMetrics r0 = new DisplayMetrics();
        r3.getDefaultDisplay().getMetrics(r0);
        return r0.widthPixels;
    }

    public final int b() {
        Object r2 = this.f31515b.getSystemService("window");
        d.h.b.o.a(r2, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r3 = (WindowManager) ZeusTransformUtils.preCheckCast(r2, WindowManager.class, "com.obric.aiagent.plugin");
        DisplayMetrics r0 = new DisplayMetrics();
        r3.getDefaultDisplay().getMetrics(r0);
        return r0.heightPixels;
    }

    public final d.m<Integer, Integer> c() {
        Rect r2 = ((WindowManager) ZeusTransformUtils.preCheckCast(this.f31515b.getSystemService(WindowManager.class), WindowManager.class, "com.obric.aiagent.plugin")).getCurrentWindowMetrics().getBounds();
        d.h.b.o.c(r2, "getBounds(...)");
        return d.s.a(Integer.valueOf(r2.width()), Integer.valueOf(r2.height()));
    }

    private final String i() {
        return new StringBuilder().append(a()).append('x').append(b()).toString();
    }

    private final String j() {
        return AOPlatform.INSTANCE.getPlatform().getInformation().getBrand();
    }

    private final String k() {
        String r1 = Build.MODEL;
        d.h.b.o.c(r1, "MODEL");
        return r1;
    }

    private final boolean l() {
        IntentFilter r0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r3 = ZeusTransformUtils.registerReceiver(this.f31515b, null, r0, "com.obric.aiagent.plugin");
        int r1 = -1;
        if (r3 == null) goto L6;
        r1 = r3.getIntExtra("status", -1);
    L6:
        if (r1 != 2) goto L8;
    L11:
        return true;
    L8:
        if (r1 == 5) goto L11;
        return false;
    }

    private final int m() {
        d.h.b.z.d r0 = new d.h.b.z.d();
        IntentFilter r1 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        z r2 = new z(r0);
        ZeusTransformUtils.registerReceiver(this.f31515b, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r2, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r1, "com.obric.aiagent.plugin");
        return r0.f38502a;
    }

    private final String n() {
        int r0 = (int) (SystemClock.elapsedRealtime() / ((long) 1000));     // Catch: Exception -> L4
        int r1 = r0 / 3600;     // Catch: Exception -> L4
        int r2 = r0 % 3600;     // Catch: Exception -> L4
        String r6 = this.f31515b.getString(ZeusTransformUtils.mapRes(R.string.obric_time_format_hms, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_time_format_hms"), new Object[]{Integer.valueOf(r1), Integer.valueOf(r2 / 60), Integer.valueOf(r2 % 60)});     // Catch: Exception -> L4
        d.h.b.o.a(r6);     // Catch: Exception -> L4
        return r6;
    L4:
        return SensitiveType.UNKNOWN;
    }

    private final int o() {
        return Build.VERSION.SDK_INT;
    }

    private final String p() {
        return a("ro.os.ota.version");
    }

    private final String q() {
        String r0 = Build.getRadioVersion();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    private final String r() {
        return System.getProperty("os.version").toString();
    }

    private final String s() {
        return String.valueOf(Build.TIME);
    }

    private final String t() {
        String r5 = p();     // Catch: Exception -> L10
        d.o.i r6 = d.o.k.a(new d.o.k("^\\d+\\.\\d+\\.\\d+"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Exception -> L10
        if (r6 == null) goto L13;
        String r7 = r6.b();     // Catch: Exception -> L10
        if (r7 != null) goto L9;
        return SensitiveType.UNKNOWN;
    L9:
        return r7;
    L13:
        return SensitiveType.UNKNOWN;
    L15:
        return SensitiveType.UNKNOWN;
    }

    private final String u() {
        String r1 = ZeusTransformUtils.getResources(this.f31515b, "com.obric.aiagent.plugin").getConfiguration().getLocales().get(0).getLanguage();
        d.h.b.o.c(r1, "getLanguage(...)");
        return r1;
    }

    private final String v() {
        String r1 = TimeZone.getDefault().getID();
        d.h.b.o.c(r1, "getID(...)");
        return r1;
    }

    private final String w() {
        if (this.f31515b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) goto L15;
        Object r3 = this.f31515b.getSystemService("connectivity");     // Catch: Exception -> L12
        d.h.b.o.a(r3, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L12
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r3, ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r4 == null) goto L16;
        String r5 = r4.getTypeName();     // Catch: Exception -> L12
        if (r5 != null) goto L11;
        return "Unknown";
    L11:
        return r5;
    L16:
        return "Unknown";
    L15:
        return "Unknown";
    L18:
        return "Unknown";
    }

    private final String x() {
        String r1 = this.f31515b.getPackageName();
        d.h.b.o.c(r1, "getPackageName(...)");
        return r1;
    }

    private final int y() {
        return this.f31515b.getPackageManager().getPackageInfo(this.f31515b.getPackageName(), 0).versionCode;
    L4:
        return -1;
    }

    private final String z() {
        String r2 = this.f31515b.getPackageManager().getPackageInfo(this.f31515b.getPackageName(), 0).versionName;     // Catch: Exception -> L4
        d.h.b.o.a(r2);     // Catch: Exception -> L4
        return r2;
    L4:
        return "Unknown";
    }

    private final String A() {
        if (d.h.b.o.a(a(PlatformConst.PROP_SOC_MODEL), "SM8750") == false) goto L6;
        return "Qualcomm® Snapdragon™ 8 Gen 4";
    L6:
        return B();
    }

    private final String B() {
        BufferedReader r2 = new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new FileReader("/proc/cpuinfo"), Reader.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
    L20:
        String r3 = r2.readLine();     // Catch: Throwable -> L15
        d.h.b.o.a(r3);     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        if (d.o.o.b(r3, "Hardware", false, 2, null) == false) goto L20;
        Matcher r4 = Pattern.compile("Hardware\\s*:\\s*(.*)$").matcher((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        if (r4.matches() == false) goto L20;
        String r8 = r4.group(1);     // Catch: Throwable -> L15
        d.h.b.o.c(r8, "group(...)");     // Catch: Throwable -> L15
        r2.close();     // Catch: Exception -> L18
        return r8;
    L13:
        r2.close();     // Catch: Exception -> L18
        return "Unknown";
    L15:
        th = move-exception;
        r2.close();     // Catch: Exception -> L18
        throw th;     // Catch: Exception -> L18
    L18:
        return "Unknown";
    }

    private final float C() {
        return Settings.System.getInt(this.f31515b.getContentResolver(), "screen_brightness") / 255.0f;
    L4:
        return -1.0f;
    }

    public final Map<String, Object> a(Map<String, ? extends Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map<String, Object> r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r5.putAll(d());
        r5.putAll(e());
        r5.putAll(f());
        return r5;
    }

    public final Map<String, Object> d() {
        return ao.a(new d.m[]{d.s.a("app_package_name", x()), d.s.a("app_version_code", Integer.valueOf(y())), d.s.a("app_version_name", z()), d.s.a(IBdInstall.PARAM_APP_CHANNEL, D())});
    }

    public final Map<String, Object> e() {
        return ao.a(new d.m[]{d.s.a(HardwareInfo.KEY_HW_VENDOR_BRAND, j()), d.s.a("device_brightness", Float.valueOf(C())), d.s.a("device_cpu_architecture", G()), d.s.a("device_cpu_corenum", Integer.valueOf(H())), d.s.a("device_cpu_info", A()), d.s.a("device_height", Integer.valueOf(b())), d.s.a("device_is_charging", Boolean.valueOf(l())), d.s.a(HardwareInfo.KEY_HW_VENDOR_MODEL, k()), d.s.a("device_poweron_duration", n()), d.s.a("device_resolution", i()), d.s.a("device_storage_total", E()), d.s.a("device_storage_available", F()), d.s.a("device_width", Integer.valueOf(a())), d.s.a("device_battery_percent", Integer.valueOf(m()))});
    }

    public final Map<String, Object> f() {
        return ao.a(new d.m[]{d.s.a(RomInfo.KEY_ROM_OS_API, Integer.valueOf(o())), d.s.a("os_baseband", q()), d.s.a("os_build_date", s()), d.s.a("os_kernel", r()), d.s.a("os_language", u()), d.s.a("os_network_type", w()), d.s.a("os_ota_version", p()), d.s.a("os_rom_version", t()), d.s.a("os_timezone", v())});
    }

    public final Map<String, Object> a(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "targetKeys");
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(h().get(r2), d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L4;
        Object r4 = r3.invoke();
        if (r4 == null) goto L4;
        r0.put(r2, r4);
        goto L4
    L10:
        return r0;
    }

    private final String a(String r8) {
        String r9 = (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{r8}), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        if (r9 != null) goto L12;
        return SensitiveType.UNKNOWN;
    L12:
        return r9;
    L7:
        e = move-exception;
        e.printStackTrace();
        return SensitiveType.UNKNOWN;
    }

    private final String E() {
        Context r10 = this.f31515b;     // Catch: Exception -> L18
        Object r2 = r10.getSystemService("storagestats");     // Catch: Exception -> L18
        d.h.b.o.a(r2, "null cannot be cast to non-null type android.app.usage.StorageStatsManager");     // Catch: Exception -> L18
        StorageStatsManager r3 = (StorageStatsManager) ZeusTransformUtils.preCheckCast(r2, StorageStatsManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        StorageManager r11 = (StorageManager) ZeusTransformUtils.preCheckCast(r10.getSystemService(StorageManager.class), StorageManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        Object r12 = r11.getClass().getMethod("getVolumes", new Class[0]).invoke(r11, new Object[0]);     // Catch: Exception -> L18
        Object r4 = null;
        if (ZeusTransformUtils.instanceOf(r12, List.class) == false) goto L6;
        List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
    L7:
        Class r5 = ZeusTransformUtils.forName("android.os.storage.VolumeInfo", "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        Method r6 = r5.getMethod("isPrimary", new Class[0]);     // Catch: Exception -> L18
        Method r7 = r5.getMethod("getFsUuid", new Class[0]);     // Catch: Exception -> L18
        if (r13 == null) goto L15;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L18
    L11:
        if (r14.hasNext() == false) goto L15;
        Object r8 = r14.next();     // Catch: Exception -> L18
        Object r9 = r6.invoke(r8, new Object[0]);     // Catch: Exception -> L18
        d.h.b.o.a(r9, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L18
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L11;
        r4 = r8;
    L15:
        if (r4 == null) goto L26;
        Object r15 = r3.getClass().getMethod("getTotalBytes", new Class[]{String.class}).invoke(r3, new Object[]{r7.invoke(r4, new Object[0])});     // Catch: Exception -> L18
        d.h.b.o.a(r15, "null cannot be cast to non-null type kotlin.Long");     // Catch: Exception -> L18
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(((((Long) ZeusTransformUtils.preCheckCast(r15, Long.class, "com.obric.aiagent.plugin")).longValue() / 1000.0d) / 1000.0d) / 1000.0d) + " GB";
    L26:
        return SensitiveType.UNKNOWN;
    L6:
        r13 = null;
    L18:
        e = move-exception;
        e.printStackTrace();
        return SensitiveType.UNKNOWN;
    }

    private final String F() {
        return (new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes() / ((long) 1000000)) + " MB";
    }

    private final String G() {
        String[] r2 = Build.SUPPORTED_ABIS;
        d.h.b.o.c(r2, "SUPPORTED_ABIS");
        String r3 = (String) ZeusTransformUtils.preCheckCast(d.a.i.c((Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return SensitiveType.UNKNOWN;
    L6:
        return r3;
    }

    private final int H() {
        return Runtime.getRuntime().availableProcessors();
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    private final String I() {
        return AODeviceInfo.INSTANCE.getDeviceInfo().getDeviceId();
    }
}
