package b09;

import android.os.Handler;
import android.os.Looper;
import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import n38.j;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f16894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b09.a f16895b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f16896c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f16897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f16898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f16899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f16900g;

    public static final class a implements j {
        public a() {
        }

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FLogger.f375446a.i("SecurityTokenBeatScheduler", "account logged out, stop heartbeat");
            Handler r101 = e.f16894a;
            e.f16894a.post(new b());
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FLogger.f375446a.i("SecurityTokenBeatScheduler", "account logged in, start heartbeat");
            Handler r101 = e.f16894a;
            e.f16894a.post(new c());
        }
    }

    public e() {
    }

    public static void c() {
        f16898e = false;
        f16899f = false;
        f16900g++;
        f16894a.removeCallbacks(f16895b);
    }

    static {
        f16894a = new Handler(Looper.getMainLooper());
        f16895b = new b09.a();
        f16896c = new a();
    }

    public static final void a() {
        if (f16898e == true) goto L5;
    L8:
        c();
        return;
    L5:
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L8;
        Handler r100 = f16894a;
        b09.a r101 = f16895b;
        r100.removeCallbacks(r101);
        r100.postDelayed(r101, 900000);
    }

    public static void b() {
        if (f16898e == false) goto L5;
        return;
    L5:
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L10;
        f16898e = true;
        f16900g++;
        Handler r100 = f16894a;
        b09.a r101 = f16895b;
        r100.removeCallbacks(r101);
        r101.run();
        return;
    }
}
