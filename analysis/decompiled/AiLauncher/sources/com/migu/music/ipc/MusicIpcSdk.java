package com.migu.music.ipc;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.migu.music.ipc.IMusicIpcInitCallback;
import com.migu.music.ipc.IMusicPlayService;
import com.migu.music.ipc.wrap.MusicIpcSdkException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class MusicIpcSdk {

    /* renamed from: s, reason: collision with root package name */
    public static final Object f21862s = new Object();

    /* renamed from: t, reason: collision with root package name */
    public static volatile MusicIpcSdk f21863t;

    /* renamed from: a, reason: collision with root package name */
    public IMusicPlayService f21864a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f21865b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f21866c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f21867d;

    /* renamed from: f, reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f21869f;

    /* renamed from: i, reason: collision with root package name */
    public volatile Q3.c f21872i;

    /* renamed from: j, reason: collision with root package name */
    public Runnable f21873j;

    /* renamed from: k, reason: collision with root package name */
    public Application f21874k;

    /* renamed from: o, reason: collision with root package name */
    public String f21878o;

    /* renamed from: e, reason: collision with root package name */
    public final q f21868e = new q();

    /* renamed from: g, reason: collision with root package name */
    public final Handler f21870g = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<Q3.b> f21871h = new CopyOnWriteArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    public boolean f21875l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21876m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21877n = true;

    /* renamed from: p, reason: collision with root package name */
    public long f21879p = 8000;

    /* renamed from: q, reason: collision with root package name */
    public final IMusicIpcInitCallback f21880q = new IMusicIpcInitCallback.Stub() { // from class: com.migu.music.ipc.MusicIpcSdk.1

        /* renamed from: com.migu.music.ipc.MusicIpcSdk$1$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MusicIpcSdk.this.R();
            }
        }

        @Override // com.migu.music.ipc.IMusicIpcInitCallback
        public void onMusicIpcInitialized() {
            MusicIpcSdk.this.f21870g.post(new a());
        }
    };

    /* renamed from: r, reason: collision with root package name */
    public final ServiceConnection f21881r = new m();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentName f21883a;

        public a(ComponentName componentName) {
            this.f21883a = componentName;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MusicIpcSdk.this.f21871h.iterator();
            while (it.hasNext()) {
                ((Q3.b) it.next()).a(this.f21883a);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentName f21885a;

        public b(ComponentName componentName) {
            this.f21885a = componentName;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MusicIpcSdk.this.f21871h.iterator();
            while (it.hasNext()) {
                ((Q3.b) it.next()).onServiceDisconnected(this.f21885a);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentName f21887a;

        public c(ComponentName componentName) {
            this.f21887a = componentName;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MusicIpcSdk.this.f21871h.iterator();
            while (it.hasNext()) {
                ((Q3.b) it.next()).onBindingDied(this.f21887a);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentName f21889a;

        public d(ComponentName componentName) {
            this.f21889a = componentName;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MusicIpcSdk.this.f21871h.iterator();
            while (it.hasNext()) {
                ((Q3.b) it.next()).onNullBinding(this.f21889a);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21891a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Exception f21892b;

        public e(Q3.c cVar, Exception exc) {
            this.f21891a = cVar;
            this.f21892b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21891a.a(2, "bindService exception: " + this.f21892b.getMessage());
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21894a;

        public f(Q3.c cVar) {
            this.f21894a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21894a.a(2, "bindService returned false");
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activityA = MusicIpcSdk.this.f21868e.a();
            if (activityA == null || activityA.isFinishing()) {
                Log.w("MusicIpcSdk", "showDisconnectedDialog: no valid activity available");
            } else {
                P3.b.f(activityA);
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activityA = MusicIpcSdk.this.f21868e.a();
            if (activityA == null || activityA.isFinishing()) {
                Log.w("MusicIpcSdk", "showLoginDialog: no valid activity available");
            } else {
                P3.b.e(activityA, false);
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21898a;

        public i(Q3.c cVar) {
            this.f21898a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21898a.a(7, "previous init still in progress");
        }
    }

    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21900a;

        public j(Q3.c cVar) {
            this.f21900a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21900a.b();
        }
    }

    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21902a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21903b;

        public k(Context context, Q3.c cVar) {
            this.f21902a = context;
            this.f21903b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f21902a;
            if (context instanceof Activity) {
                MusicIpcSdk.this.d0((Activity) context);
            }
            this.f21903b.a(1, "host not installed");
        }
    }

    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21905a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21906b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f21907c;

        public l(Context context, Q3.c cVar, int i10) {
            this.f21905a = context;
            this.f21906b = cVar;
            this.f21907c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f21905a;
            if (context instanceof Activity) {
                MusicIpcSdk.this.f0((Activity) context);
            }
            this.f21906b.a(10, "host version too low: " + this.f21907c + " < 533");
        }
    }

    public class m implements ServiceConnection {
        public m() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            synchronized (MusicIpcSdk.f21862s) {
                MusicIpcSdk.this.f21872i = null;
                MusicIpcSdk.this.f21867d = false;
            }
            MusicIpcSdk.this.F();
            MusicIpcSdk.this.O(componentName);
            MusicIpcSdk.this.c0();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            Q3.c cVar = MusicIpcSdk.this.f21872i;
            MusicIpcSdk.this.f21872i = null;
            MusicIpcSdk.this.f21867d = false;
            MusicIpcSdk.this.F();
            MusicIpcSdk.this.P(componentName);
            MusicIpcSdk.this.c0();
            if (cVar != null) {
                MusicIpcSdk.this.G(cVar, 4, "onNullBinding: host onBind returned null or bind rejected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (MusicIpcSdk.f21862s) {
                if (!MusicIpcSdk.this.f21866c && MusicIpcSdk.this.f21867d) {
                    MusicIpcSdk.this.E();
                    MusicIpcSdk.this.f21864a = IMusicPlayService.Stub.asInterface(iBinder);
                    MusicIpcSdk.this.f21865b = false;
                    MusicIpcSdk.this.N(componentName);
                    Q3.c cVar = MusicIpcSdk.this.f21872i;
                    if (cVar != null) {
                        MusicIpcSdk.this.Z(cVar);
                        try {
                            MusicIpcSdk musicIpcSdk = MusicIpcSdk.this;
                            musicIpcSdk.V(musicIpcSdk.f21864a);
                            return;
                        } catch (RemoteException e10) {
                            synchronized (MusicIpcSdk.f21862s) {
                                MusicIpcSdk.this.f21872i = null;
                                MusicIpcSdk.this.f21867d = false;
                                MusicIpcSdk.this.f21864a = null;
                                MusicIpcSdk.this.G(cVar, 5, e10.getMessage() == null ? "registerMusicIpcInitCallback failed" : e10.getMessage());
                                return;
                            }
                        }
                    }
                    return;
                }
                Log.w("MusicIpcSdk", "onServiceConnected: stale callback ignored (destroyed=" + MusicIpcSdk.this.f21866c + ", bindingRequested=" + MusicIpcSdk.this.f21867d + ")");
                if (MusicIpcSdk.this.f21874k != null) {
                    try {
                        MusicIpcSdk.this.f21874k.unbindService(MusicIpcSdk.this.f21881r);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (MusicIpcSdk.f21862s) {
                MusicIpcSdk.this.f21872i = null;
                MusicIpcSdk.this.f21867d = false;
                MusicIpcSdk.this.E();
            }
            MusicIpcSdk.this.F();
            MusicIpcSdk.this.Q(componentName);
            MusicIpcSdk.this.c0();
        }
    }

    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21910a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21911b;

        public n(long j10, Q3.c cVar) {
            this.f21910a = j10;
            this.f21911b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (MusicIpcSdk.f21862s) {
                try {
                    MusicIpcSdk.this.f21873j = null;
                    if (MusicIpcSdk.this.f21865b) {
                        Log.w("MusicIpcSdk", "Init timeout triggered but bridge already ready, ignoring");
                    } else {
                        if (MusicIpcSdk.this.f21872i != null) {
                            Log.e("MusicIpcSdk", "Init timeout detected! Forcing cleanup.");
                            MusicIpcSdk.this.f21872i = null;
                            MusicIpcSdk.this.f21867d = false;
                            MusicIpcSdk.this.f21865b = false;
                            IMusicPlayService iMusicPlayService = MusicIpcSdk.this.f21864a;
                            MusicIpcSdk.this.f21864a = null;
                            if (iMusicPlayService != null && MusicIpcSdk.this.f21874k != null) {
                                try {
                                    MusicIpcSdk.this.f21874k.unbindService(MusicIpcSdk.this.f21881r);
                                    Log.w("MusicIpcSdk", "Unbound service due to timeout (host state recovery)");
                                } catch (IllegalArgumentException e10) {
                                    Log.w("MusicIpcSdk", "unbindService failed: " + e10.getMessage());
                                }
                            }
                            Log.w("MusicIpcSdk", "Init timeout after " + this.f21910a + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
                            MusicIpcSdk.this.c0();
                            MusicIpcSdk.this.G(this.f21911b, 3, "Initialization timeout after " + this.f21910a + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
                            return;
                        }
                        Log.w("MusicIpcSdk", "Init timeout triggered but callback already cleared, ignoring");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21913a;

        public o(Q3.c cVar) {
            this.f21913a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q3.c cVar = this.f21913a;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q3.c f21915a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21916b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f21917c;

        public p(Q3.c cVar, int i10, String str) {
            this.f21915a = cVar;
            this.f21916b = i10;
            this.f21917c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q3.c cVar = this.f21915a;
            if (cVar != null) {
                cVar.a(this.f21916b, this.f21917c);
            }
        }
    }

    public static class q implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public volatile WeakReference<Activity> f21919a;

        public q() {
        }

        public Activity a() {
            String string;
            Activity activity = this.f21919a != null ? this.f21919a.get() : null;
            if (activity != null) {
                boolean zIsFinishing = activity.isFinishing();
                Log.w("miguSdkActivityTracker", "getTopActivity: " + activity.getClass().getSimpleName() + " (finishing=" + zIsFinishing + ")");
                if (zIsFinishing) {
                    string = "getTopActivity: activity is finishing, may not be suitable for dialog";
                }
                return activity;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getTopActivity: null (ref=");
            sb2.append(this.f21919a != null ? "exists" : "null");
            sb2.append(")");
            string = sb2.toString();
            Log.w("miguSdkActivityTracker", string);
            return activity;
        }

        public void b(Activity activity) {
            if (activity != null) {
                this.f21919a = new WeakReference<>(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            this.f21919a = new WeakReference<>(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.f21919a = new WeakReference<>(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static MusicIpcSdk I() {
        if (f21863t == null) {
            synchronized (f21862s) {
                try {
                    if (f21863t == null) {
                        f21863t = new MusicIpcSdk();
                    }
                } finally {
                }
            }
        }
        return f21863t;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(Q3.c r7) {
        /*
            r6 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.migu.music.ipc.action.BIND_PLAY_SERVICE"
            r0.<init>(r1)
            java.lang.String r1 = "cmccwm.mobilemusic"
            android.content.Intent r0 = r0.setPackage(r1)
            java.lang.String r1 = r6.f21878o
            java.lang.String r2 = "bridgeAppId"
            r0.putExtra(r2, r1)
            java.lang.String r1 = "MusicIpcSdk"
            java.lang.String r2 = "bindService: start binding to cmccwm.mobilemusic"
            android.util.Log.w(r1, r2)
            r1 = 0
            r2 = 0
            android.app.Application r3 = r6.f21874k     // Catch: java.lang.Exception -> L40
            android.content.ServiceConnection r4 = r6.f21881r     // Catch: java.lang.Exception -> L40
            r5 = 65
            boolean r0 = r3.bindService(r0, r4, r5)     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = "MusicIpcSdk"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3e
            r4.<init>()     // Catch: java.lang.Exception -> L3e
            java.lang.String r5 = "bindService: result="
            r4.append(r5)     // Catch: java.lang.Exception -> L3e
            r4.append(r0)     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L3e
            android.util.Log.w(r3, r4)     // Catch: java.lang.Exception -> L3e
            goto L61
        L3e:
            r3 = move-exception
            goto L42
        L40:
            r3 = move-exception
            r0 = r2
        L42:
            java.lang.String r4 = "MusicIpcSdk"
            java.lang.String r5 = "bindService: exception"
            android.util.Log.e(r4, r5, r3)
            java.lang.Object r4 = com.migu.music.ipc.MusicIpcSdk.f21862s
            monitor-enter(r4)
            r6.f21872i = r1     // Catch: java.lang.Throwable -> L87
            r6.f21867d = r2     // Catch: java.lang.Throwable -> L87
            r6.E()     // Catch: java.lang.Throwable -> L87
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L87
            r6.c0()
            android.os.Handler r4 = r6.f21870g
            com.migu.music.ipc.MusicIpcSdk$e r5 = new com.migu.music.ipc.MusicIpcSdk$e
            r5.<init>(r7, r3)
            r4.post(r5)
        L61:
            if (r0 != 0) goto L86
            java.lang.String r0 = "MusicIpcSdk"
            java.lang.String r3 = "bindService: returned false"
            android.util.Log.w(r0, r3)
            java.lang.Object r0 = com.migu.music.ipc.MusicIpcSdk.f21862s
            monitor-enter(r0)
            r6.f21872i = r1     // Catch: java.lang.Throwable -> L83
            r6.f21867d = r2     // Catch: java.lang.Throwable -> L83
            r6.E()     // Catch: java.lang.Throwable -> L83
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            r6.c0()
            android.os.Handler r0 = r6.f21870g
            com.migu.music.ipc.MusicIpcSdk$f r1 = new com.migu.music.ipc.MusicIpcSdk$f
            r1.<init>(r7)
            r0.post(r1)
            return
        L83:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            throw r6
        L86:
            return
        L87:
            r6 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L87
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.migu.music.ipc.MusicIpcSdk.D(Q3.c):void");
    }

    public final void E() {
        Runnable runnable = this.f21873j;
        if (runnable != null) {
            this.f21870g.removeCallbacks(runnable);
            this.f21873j = null;
        }
    }

    public final void F() {
        synchronized (f21862s) {
            E();
        }
        this.f21865b = false;
        this.f21864a = null;
    }

    public final void G(Q3.c cVar, int i10, String str) {
        this.f21870g.post(new p(cVar, i10, str));
    }

    public final void H(Q3.c cVar) {
        this.f21870g.post(new o(cVar));
    }

    public void J(Context context, Q3.c cVar) throws MusicIpcSdkException, PackageManager.NameNotFoundException {
        Log.w("MusicIpcSdk", "initBind: start");
        if (context == null || cVar == null) {
            Log.e("MusicIpcSdk", "initBind: invalid params - context=" + context + ", callback=" + cVar);
            throw new MusicIpcSdkException(0, "context and callback must not be null");
        }
        if (!this.f21875l) {
            Log.e("MusicIpcSdk", "initBind: signature validation failed - mIsInitSuccess=" + this.f21875l);
            throw new MusicIpcSdkException(0, "Signature is Invalid");
        }
        Log.w("MusicIpcSdk", "initBind: signature validation passed");
        if (this.f21869f == null && this.f21874k != null) {
            Log.w("MusicIpcSdk", "initBind: registering ActivityLifecycleCallbacks");
            q qVar = this.f21868e;
            this.f21869f = qVar;
            this.f21874k.registerActivityLifecycleCallbacks(qVar);
        }
        Log.w("MusicIpcSdk", "initBind: updating top activity - " + context.getClass().getSimpleName());
        if (context instanceof Activity) {
            this.f21868e.b((Activity) context);
        }
        Object obj = f21862s;
        synchronized (obj) {
            try {
                if (this.f21866c) {
                    Log.w("MusicIpcSdk", "initBind: SDK was destroyed, resetting destroyed flag");
                    this.f21866c = false;
                }
                if (this.f21872i != null && !this.f21865b) {
                    Log.w("MusicIpcSdk", "initBind: already initializing, rejecting duplicate call");
                    this.f21870g.post(new i(cVar));
                } else {
                    if (!this.f21865b || this.f21864a == null) {
                        if (!P3.b.c(context, "cmccwm.mobilemusic")) {
                            Log.w("MusicIpcSdk", "initBind: host package not installed - cmccwm.mobilemusic");
                            this.f21870g.post(new k(context, cVar));
                            return;
                        }
                        Log.w("MusicIpcSdk", "initBind: host package installed");
                        if (this.f21877n) {
                            int iA = P3.b.a(context);
                            Log.w("MusicIpcSdk", "initBind: host version check - installed=" + iA + ", required=533");
                            if (iA < 533) {
                                Log.w("MusicIpcSdk", "initBind: host version too low - " + iA + " < 533");
                                this.f21870g.post(new l(context, cVar, iA));
                                return;
                            }
                        }
                        Log.w("MusicIpcSdk", "initBind: setting pendingInitCallback and bindingRequested");
                        synchronized (obj) {
                            this.f21872i = cVar;
                            this.f21867d = true;
                        }
                        Z(cVar);
                        Log.w("MusicIpcSdk", "initBind: calling bindHostPlayServiceOrReportFailure");
                        D(cVar);
                        Log.w("MusicIpcSdk", "initBind: completed");
                        return;
                    }
                    Log.w("MusicIpcSdk", "initBind: SDK already bound and ready. If you need to rebind, please call destroy() first.");
                    this.f21870g.post(new j(cVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void K(Application application, String str, String str2) throws MusicIpcSdkException {
        this.f21874k = application;
        boolean zD = O3.a.d(application, str, str2);
        this.f21875l = zD;
        if (!zD) {
            throw new MusicIpcSdkException(0, "Signature is Invalid");
        }
        this.f21878o = str;
        P3.a.c(str);
    }

    public boolean L() throws MusicIpcSdkException {
        try {
            return Y().isLoginSuccess();
        } catch (RemoteException e10) {
            throw new MusicIpcSdkException(5, e10.getMessage(), e10);
        }
    }

    public boolean M() {
        boolean z10;
        synchronized (f21862s) {
            try {
                z10 = (this.f21866c || !this.f21865b || this.f21864a == null) ? false : true;
            } finally {
            }
        }
        return z10;
    }

    public final void N(ComponentName componentName) {
        this.f21870g.post(new a(componentName));
    }

    public final void O(ComponentName componentName) {
        this.f21870g.post(new c(componentName));
    }

    public final void P(ComponentName componentName) {
        this.f21870g.post(new d(componentName));
    }

    public final void Q(ComponentName componentName) {
        this.f21870g.post(new b(componentName));
    }

    public final void R() {
        synchronized (f21862s) {
            if (!this.f21866c && !this.f21865b) {
                Q3.c cVar = this.f21872i;
                this.f21872i = null;
                E();
                this.f21865b = true;
                if (cVar != null) {
                    H(cVar);
                }
            }
        }
    }

    public void S() throws MusicIpcSdkException {
        X();
        try {
            Y().pause();
        } catch (RemoteException e10) {
            throw new MusicIpcSdkException(5, e10.getMessage(), e10);
        }
    }

    public void T(List<String> list, int i10) throws MusicIpcSdkException {
        X();
        try {
            Y().playSongByIds(list, i10);
        } catch (RemoteException e10) {
            throw new MusicIpcSdkException(5, e10.getMessage(), e10);
        }
    }

    public void U(Q3.b bVar) {
        if (bVar != null) {
            this.f21871h.addIfAbsent(bVar);
        }
    }

    public final void V(IMusicPlayService iMusicPlayService) throws RemoteException {
        iMusicPlayService.registerMusicIpcInitCallback(this.f21880q);
    }

    public void W(IMusicPlayCallbacks iMusicPlayCallbacks) throws MusicIpcSdkException {
        if (iMusicPlayCallbacks == null) {
            return;
        }
        try {
            Y().registerCallbacks(iMusicPlayCallbacks);
        } catch (RemoteException e10) {
            throw new MusicIpcSdkException(5, e10.getMessage(), e10);
        }
    }

    public final void X() throws MusicIpcSdkException {
        if (L()) {
            return;
        }
        e0();
        throw new MusicIpcSdkException(9, "User not logged in");
    }

    public final IMusicPlayService Y() throws MusicIpcSdkException {
        if (this.f21866c) {
            throw new MusicIpcSdkException(6, "SDK destroyed");
        }
        IMusicPlayService iMusicPlayService = this.f21864a;
        if (iMusicPlayService == null || !this.f21865b) {
            throw new MusicIpcSdkException(8, "bridge not ready");
        }
        return iMusicPlayService;
    }

    public final void Z(Q3.c cVar) {
        long j10 = this.f21879p;
        Log.w("MusicIpcSdk", "Init timeout protection started: " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        n nVar = new n(j10, cVar);
        this.f21873j = nVar;
        this.f21870g.postDelayed(nVar, j10);
    }

    public void a0(int i10) throws MusicIpcSdkException {
        X();
        try {
            Y().setPlayMode(i10);
        } catch (RemoteException e10) {
            throw new MusicIpcSdkException(5, e10.getMessage(), e10);
        }
    }

    public void b0(boolean z10) {
        this.f21876m = z10;
    }

    public final void c0() {
        if (this.f21876m) {
            this.f21870g.post(new g());
        }
    }

    public final void d0(Activity activity) {
        if (this.f21876m) {
            P3.b.d(activity);
        }
    }

    public final void e0() {
        if (this.f21876m) {
            this.f21870g.post(new h());
        }
    }

    public final void f0(Activity activity) {
        if (this.f21876m) {
            P3.b.g(activity);
        }
    }
}
