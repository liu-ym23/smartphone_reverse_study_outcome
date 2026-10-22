package com.stepos.statsapp.v3.lib.plugin.sdk;

import android.app.Application;
import android.content.Context;
import com.stepos.statsapp.v3.InitConfig;
import com.stepos.statsapp.v3.SdkVer;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.emitter.Emitter;
import com.stepos.statsapp.v3.lib.plugin.tracker.b;
import com.stepos.statsapp.v3.lib.plugin.utils.thread.GlobalExecutor;
import com.stepos.statsapp.v3.lib.plugin.utils.thread.ScheduledExecutor;
import com.stepos.statsapp.v3.utils.CommonUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: m, reason: collision with root package name */
    private static final String f30897m = "SDKInstanceImpl";

    /* renamed from: n, reason: collision with root package name */
    private static final long f30898n = 60000;

    /* renamed from: a, reason: collision with root package name */
    private Application f30899a;

    /* renamed from: b, reason: collision with root package name */
    private int f30900b;

    /* renamed from: c, reason: collision with root package name */
    private String f30901c;

    /* renamed from: d, reason: collision with root package name */
    private String f30902d;

    /* renamed from: e, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.tracker.b f30903e;

    /* renamed from: f, reason: collision with root package name */
    private ConfigController f30904f;

    /* renamed from: g, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.session.c f30905g;

    /* renamed from: h, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.session.b f30906h;

    /* renamed from: i, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.events.c f30907i;

    /* renamed from: j, reason: collision with root package name */
    private ScheduledFuture<?> f30908j;

    /* renamed from: k, reason: collision with root package name */
    private long f30909k;

    /* renamed from: l, reason: collision with root package name */
    private Map<String, String> f30910l;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f30911a = new a();

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        if (g() == null) {
            Logger.e(f30897m, "refreshDeviceInfo fail, subject is null");
        } else {
            g().b(this.f30899a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        b(true);
    }

    private void p() {
        if (this.f30908j != null) {
            Logger.d(f30897m, "cancel retry core init task");
            this.f30908j.cancel(true);
        }
        o();
        this.f30905g.i();
        this.f30907i.a();
    }

    private void q() {
        Logger.i(f30897m, "schedule " + this.f30909k + " milliseconds retry real init");
        this.f30908j = ScheduledExecutor.getInstance().schedule(this.f30909k, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.sdk.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f30917a.k();
            }
        });
        this.f30909k = this.f30909k * 2;
    }

    public String e() {
        return this.f30905g.c();
    }

    public String f() {
        return this.f30905g.d();
    }

    public com.stepos.statsapp.v3.lib.plugin.tracker.subject.c g() {
        com.stepos.statsapp.v3.lib.plugin.tracker.b bVar = this.f30903e;
        if (bVar != null) {
            return bVar.b();
        }
        Logger.e(f30897m, "getSubject fail, tracker is null");
        return null;
    }

    public com.stepos.statsapp.v3.lib.plugin.tracker.b h() {
        return this.f30903e;
    }

    public String i() {
        if (b() != null) {
            return b().getUMID();
        }
        Logger.e(f30897m, "getUmId fail, emitter is null");
        return "";
    }

    public void l() {
        this.f30905g.e();
    }

    public void m() {
        this.f30905g.f();
    }

    public void n() {
        GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.sdk.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f30912a.j();
            }
        });
    }

    public void o() {
        Map<String, String> map = this.f30910l;
        if (map != null) {
            b(map);
        }
    }

    private a() {
        this.f30909k = 60000L;
    }

    public static a c() {
        return b.f30911a;
    }

    public void a(Application application, int i10, String str, String str2) {
        Logger.i(f30897m, "SDKInstanceImpl, pkgType: " + i10 + ", appId: " + str + ", channel: " + str2 + ", initConfig: " + new InitConfig() + ", sdkVersion: " + SdkVer.verName);
        this.f30899a = application;
        this.f30900b = i10;
        this.f30901c = str;
        this.f30902d = str2;
        UxipConstants.a();
        this.f30904f = new ConfigController(str);
        this.f30907i = new com.stepos.statsapp.v3.lib.plugin.events.c();
        this.f30905g = new com.stepos.statsapp.v3.lib.plugin.session.c(application);
        this.f30906h = new com.stepos.statsapp.v3.lib.plugin.session.b();
        b(true);
    }

    public void b(final boolean z10) {
        GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.sdk.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f30915a.a(z10);
            }
        });
    }

    public com.stepos.statsapp.v3.lib.plugin.session.c d() {
        return this.f30905g;
    }

    public Emitter b() {
        com.stepos.statsapp.v3.lib.plugin.tracker.b bVar = this.f30903e;
        if (bVar == null) {
            Logger.e(f30897m, "getEmitter fail, tracker is null");
            return null;
        }
        return bVar.a();
    }

    public void c(String str, String str2, Map<String, String> map, Map<String, Object> map2) {
        this.f30907i.b(this.f30899a, str, str2, map, 2, map2);
    }

    public void d(String str, Map<String, String> map) {
        this.f30907i.b(this.f30899a, str, null, map, 0, null);
    }

    public void c(String str, Map<String, String> map) {
        this.f30907i.a(this.f30899a, this.f30906h, str, map, 1);
    }

    public void c(String str) {
        Logger.d(f30897m, "setSource source: " + str);
        if (this.f30903e == null) {
            Logger.e(f30897m, "setSource fail, tracker is empty");
        } else {
            this.f30905g.b(str);
        }
    }

    public void b(String str, String str2, Map<String, String> map, Map<String, Object> map2) {
        this.f30907i.b(this.f30899a, str, str2, map, 3, map2);
    }

    public void b(String str, Map<String, String> map) {
        this.f30907i.b(this.f30899a, str, map, 2);
    }

    public void b(String str) {
        this.f30907i.a(this.f30906h, str);
    }

    public void b(final Map<String, String> map) {
        Logger.d(f30897m, "setEventAttributes attributes: " + map);
        GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.sdk.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f30913a.a(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z10) {
        Logger.i(f30897m, "realInit start");
        if (a((Context) this.f30899a, this.f30900b, this.f30901c, this.f30902d)) {
            com.stepos.statsapp.v3.lib.plugin.boot.a.a(this.f30899a);
            p();
        } else if (z10) {
            q();
        }
    }

    private boolean a(Context context, int i10, String str, String str2) {
        if (this.f30903e != null) {
            Logger.w(f30897m, "initTracker fail, tracker is no null");
            return false;
        }
        try {
            Logger.i(f30897m, "initTracker start");
            this.f30903e = new b.a(context, Emitter.createEmitter(context, str, str2)).a(com.stepos.statsapp.v3.lib.plugin.tracker.subject.c.a(context, str, i10, SdkVer.verName)).a(CommonUtils.isDebugMode(context)).a();
            Logger.i(f30897m, "initTracker success");
            return true;
        } catch (Exception e10) {
            Logger.e(f30897m, "initTracker error, " + e10);
            this.f30903e = null;
            return false;
        }
    }

    public ConfigController a() {
        return this.f30904f;
    }

    public void a(String str, String str2, Map<String, String> map, Map<String, Object> map2) {
        this.f30907i.b(this.f30899a, str, str2, map, 1, map2);
    }

    public void a(String str, Map<String, String> map) {
        this.f30907i.b(this.f30899a, str, map, 1);
    }

    public long a(String str) {
        return this.f30906h.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Map map) {
        if (g() == null) {
            this.f30910l = map;
            Logger.e(f30897m, "setEventAttributes fail, subject is empty");
        } else {
            this.f30910l = null;
            g().a((Map<String, String>) map);
        }
    }
}
