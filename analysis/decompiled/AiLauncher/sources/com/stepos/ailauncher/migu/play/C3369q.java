package com.stepos.ailauncher.migu.play;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import org.json.JSONObject;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001#\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/migu/play/q;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "o", "(Landroid/content/Context;)V", "appContext", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "p", "", "data", "", "m", "(Ljava/lang/String;)Ljava/lang/Integer;", "CODE_DOWNLOADING", "I", "CODE_INSTALL_SUCCESS", "LISTENER_VERSION", "Ljava/util/concurrent/atomic/AtomicBoolean;", RobotInfo.STATUS_STARTED, "Ljava/util/concurrent/atomic/AtomicBoolean;", "packageReceiverRegistered", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "queryExecutor", "Ljava/util/concurrent/ExecutorService;", "Lcom/stepos/appcenter/appcentersdk/AppCenterSdk$Listener;", "listener", "Lcom/stepos/appcenter/appcentersdk/AppCenterSdk$Listener;", "com/stepos/ailauncher/migu/play/q$a", "packageReceiver", "Lcom/stepos/ailauncher/migu/play/q$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/String;", "pkg", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3369q {
    private static final int CODE_DOWNLOADING = 11;
    private static final int CODE_INSTALL_SUCCESS = 21;
    private static final int LISTENER_VERSION = 0;
    public static final C3369q INSTANCE = new C3369q();
    private static final AtomicBoolean started = new AtomicBoolean(false);
    private static final AtomicBoolean packageReceiverRegistered = new AtomicBoolean(false);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService queryExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.ailauncher.migu.play.o
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return C3369q.n(runnable);
        }
    });
    private static final AppCenterSdk.Listener listener = new AppCenterSdk.Listener() { // from class: com.stepos.ailauncher.migu.play.p
        @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
        public final void onCallback(int i10, String str) {
            C3369q.j(i10, str);
        }
    };
    private static final a packageReceiver = new a();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/migu/play/q$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.migu.play.q$a */
    public static final class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri data;
            String schemeSpecificPart;
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.PACKAGE_ADDED") && (data = intent.getData()) != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null && kotlin.jvm.internal.p.d(schemeSpecificPart, C3369q.INSTANCE.i())) {
                R5.b.INSTANCE.c("music.download.packageAdded", new Pair[0]);
                MiguInstallState miguInstallState = MiguInstallState.INSTANCE;
                miguInstallState.e();
                miguInstallState.d();
            }
        }
    }

    public static final void j(int i10, String str) {
        R5.b.INSTANCE.c("music.download.callback", Y8.j.a("code", Integer.valueOf(i10)), Y8.j.a("data", str != null ? La.K.R1(str, 120) : null));
        if (i10 != 11) {
            if (i10 != 21) {
                return;
            }
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.m
                @Override // java.lang.Runnable
                public final void run() {
                    C3369q.l();
                }
            });
        } else {
            Integer numM = INSTANCE.m(str);
            if (numM != null) {
                MiguInstallState.INSTANCE.f(numM.intValue());
                mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3369q.k();
                    }
                });
            }
        }
    }

    public static final void k() {
        MiguInstallState.INSTANCE.d();
    }

    public static final void l() {
        MiguInstallState miguInstallState = MiguInstallState.INSTANCE;
        miguInstallState.e();
        miguInstallState.d();
    }

    public static final Thread n(Runnable runnable) {
        Thread thread = new Thread(runnable, "migu-install-sync");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void q() {
        /*
            com.stepos.ailauncher.migu.play.q r0 = com.stepos.ailauncher.migu.play.C3369q.INSTANCE
            r1 = 0
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2f
            com.stepos.appcenter.appcentersdk.AppCenterSdk r2 = com.stepos.appcenter.appcentersdk.AppCenterSdk.getInstance()     // Catch: java.lang.Throwable -> L2f
            java.util.List r2 = r2.getAllDownloadTasks()     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L3b
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L2f
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L2f
        L15:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L31
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L2f
            r4 = r3
            android.util.Pair r4 = (android.util.Pair) r4     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r4 = r4.first     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = r0.i()     // Catch: java.lang.Throwable -> L2f
            boolean r4 = kotlin.jvm.internal.p.d(r4, r5)     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L15
            goto L32
        L2f:
            r0 = move-exception
            goto L41
        L31:
            r3 = r1
        L32:
            android.util.Pair r3 = (android.util.Pair) r3     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L3b
            java.lang.Object r0 = r3.second     // Catch: java.lang.Throwable -> L2f
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L2f
            goto L3c
        L3b:
            r0 = r1
        L3c:
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L2f
            goto L4b
        L41:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L4b:
            boolean r2 = kotlin.Result.g(r0)
            if (r2 == 0) goto L52
            goto L53
        L52:
            r1 = r0
        L53:
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L65
            int r0 = r1.intValue()
            android.os.Handler r1 = com.stepos.ailauncher.migu.play.C3369q.mainHandler
            com.stepos.ailauncher.migu.play.n r2 = new com.stepos.ailauncher.migu.play.n
            r2.<init>()
            r1.post(r2)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.migu.play.C3369q.q():void");
    }

    public static final void r(int i10) {
        MiguInstallState miguInstallState = MiguInstallState.INSTANCE;
        miguInstallState.f(i10);
        miguInstallState.d();
    }

    public final void h(Context appContext) {
        Object objB;
        if (packageReceiverRegistered.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(androidx.core.content.a.j(appContext, packageReceiver, intentFilter, 4));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                packageReceiverRegistered.set(false);
                R5.b bVar = R5.b.INSTANCE;
                String message = thE.getMessage();
                if (message == null) {
                    message = "";
                }
                bVar.h("music.download.receiver.fail", Y8.j.a("message", message));
            }
        }
    }

    public final String i() {
        return "cmccwm.mobilemusic";
    }

    public final Integer m(String data) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (data == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(data);
        String strOptString = jSONObject.optString("packageName");
        kotlin.jvm.internal.p.f(strOptString);
        if (strOptString.length() > 0 && !kotlin.jvm.internal.p.d(strOptString, i())) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(jSONObject.optInt("progress", -1));
        int iIntValue = numValueOf.intValue();
        if (1 > iIntValue || iIntValue >= 101) {
            numValueOf = null;
        }
        objB = Result.b(numValueOf);
        return (Integer) (Result.g(objB) ? null : objB);
    }

    public final void o(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (started.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AppCenterSdk.getInstance().registerListener(i(), 0, listener);
                objB = Result.b(Boolean.TRUE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                R5.b.INSTANCE.h("music.download.register.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
                started.set(false);
            }
            Boolean bool = Boolean.FALSE;
            if (Result.g(objB)) {
                objB = bool;
            }
            if (((Boolean) objB).booleanValue()) {
                p();
            }
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        h(applicationContext);
    }

    public final void p() {
        queryExecutor.execute(new Runnable() { // from class: com.stepos.ailauncher.migu.play.k
            @Override // java.lang.Runnable
            public final void run() {
                C3369q.q();
            }
        });
    }
}
