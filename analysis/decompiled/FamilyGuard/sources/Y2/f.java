package Y2;

import a3.C0424b;
import a3.C0426d;
import android.app.Application;
import android.content.Context;
import b3.C0565c;
import com.stepos.statsapp.v3.SdkVer;
import e3.C0688b;
import e3.ExecutorC0690d;
import f3.C0719a;
import g3.C0742e;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Application f6486a;

    /* renamed from: b, reason: collision with root package name */
    private int f6487b;

    /* renamed from: c, reason: collision with root package name */
    private String f6488c;

    /* renamed from: d, reason: collision with root package name */
    private String f6489d;

    /* renamed from: e, reason: collision with root package name */
    private C0565c f6490e;

    /* renamed from: f, reason: collision with root package name */
    private Y2.a f6491f;

    /* renamed from: g, reason: collision with root package name */
    private C0426d f6492g;

    /* renamed from: h, reason: collision with root package name */
    private C0424b f6493h;

    /* renamed from: i, reason: collision with root package name */
    private U2.d f6494i;

    /* renamed from: j, reason: collision with root package name */
    private ScheduledFuture<?> f6495j;

    /* renamed from: k, reason: collision with root package name */
    private long f6496k;

    /* renamed from: l, reason: collision with root package name */
    private Map<String, String> f6497l;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final f f6498a = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Map map) {
        if (p() == null) {
            this.f6497l = map;
            C0742e.d("SDKInstanceImpl", "setEventAttributes fail, subject is empty");
        } else {
            this.f6497l = null;
            p().j(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(boolean z5) {
        C0742e.i("SDKInstanceImpl", "realInit start");
        if (i(this.f6486a, this.f6487b, this.f6488c, this.f6489d)) {
            R2.a.b(this.f6486a);
            t();
        } else if (z5) {
            u();
        }
    }

    private boolean i(Context context, int i5, String str, String str2) {
        if (this.f6490e != null) {
            C0742e.l("SDKInstanceImpl", "initTracker fail, tracker is no null");
            return false;
        }
        try {
            C0742e.i("SDKInstanceImpl", "initTracker start");
            this.f6490e = new C0565c.a(context, com.stepos.statsapp.v3.lib.plugin.emitter.a.f(context, str, str2)).a(c3.c.a(context, str, i5, SdkVer.verName)).b(C0719a.b(context)).c();
            C0742e.i("SDKInstanceImpl", "initTracker success");
            return true;
        } catch (Exception e6) {
            C0742e.d("SDKInstanceImpl", "initTracker error, " + e6);
            this.f6490e = null;
            return false;
        }
    }

    public static f m() {
        return b.f6498a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        l(true);
    }

    private void t() {
        if (this.f6495j != null) {
            C0742e.c("SDKInstanceImpl", "cancel retry core init task");
            this.f6495j.cancel(true);
        }
        s();
        this.f6492g.k();
        this.f6494i.c();
    }

    private void u() {
        C0742e.i("SDKInstanceImpl", "schedule " + this.f6496k + " milliseconds retry real init");
        this.f6495j = ExecutorC0690d.b().c(this.f6496k, TimeUnit.MILLISECONDS, new Runnable() { // from class: Y2.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f6485a.r();
            }
        });
        this.f6496k = this.f6496k * 2;
    }

    public Y2.a d() {
        return this.f6491f;
    }

    public void e(Application application, int i5, String str, String str2) {
        C0742e.i("SDKInstanceImpl", "SDKInstanceImpl, pkgType: " + i5 + ", appId: " + str + ", channel: " + str2 + ", initConfig: " + new Q2.a() + ", sdkVersion: " + SdkVer.verName);
        this.f6486a = application;
        this.f6487b = i5;
        this.f6488c = str;
        this.f6489d = str2;
        S2.a.a();
        this.f6491f = new Y2.a(str);
        this.f6494i = new U2.d();
        this.f6492g = new C0426d(application);
        this.f6493h = new C0424b();
        l(true);
    }

    public void f(String str, String str2, Map<String, String> map, Map<String, Object> map2) {
        this.f6494i.h(this.f6486a, str, str2, map, 1, map2);
    }

    public com.stepos.statsapp.v3.lib.plugin.emitter.a j() {
        C0565c c0565c = this.f6490e;
        if (c0565c != null) {
            return c0565c.c();
        }
        C0742e.d("SDKInstanceImpl", "getEmitter fail, tracker is null");
        return null;
    }

    public void k(final Map<String, String> map) {
        C0742e.c("SDKInstanceImpl", "setEventAttributes attributes: " + map);
        C0688b.b(new Runnable() { // from class: Y2.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f6483a.g(map);
            }
        });
    }

    public void l(final boolean z5) {
        C0688b.b(new Runnable() { // from class: Y2.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f6481a.h(z5);
            }
        });
    }

    public C0426d n() {
        return this.f6492g;
    }

    public void o(String str, Map<String, String> map) {
        this.f6494i.h(this.f6486a, str, null, map, 0, null);
    }

    public c3.c p() {
        C0565c c0565c = this.f6490e;
        if (c0565c != null) {
            return c0565c.i();
        }
        C0742e.d("SDKInstanceImpl", "getSubject fail, tracker is null");
        return null;
    }

    public C0565c q() {
        return this.f6490e;
    }

    public void s() {
        Map<String, String> map = this.f6497l;
        if (map != null) {
            k(map);
        }
    }

    private f() {
        this.f6496k = 60000L;
    }
}
