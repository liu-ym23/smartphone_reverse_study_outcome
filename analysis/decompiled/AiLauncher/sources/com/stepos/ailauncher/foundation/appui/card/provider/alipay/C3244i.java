package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import org.json.JSONObject;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/i;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "data", "", "f", "(Ljava/lang/String;)Ljava/lang/Integer;", "CODE_DOWNLOADING", "I", "CODE_INSTALL_SUCCESS", "LISTENER_VERSION", "", RobotInfo.STATUS_STARTED, "Z", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "queryExecutor", "Ljava/util/concurrent/ExecutorService;", "Lcom/stepos/appcenter/appcentersdk/AppCenterSdk$Listener;", "listener", "Lcom/stepos/appcenter/appcentersdk/AppCenterSdk$Listener;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3244i {
    private static final int CODE_DOWNLOADING = 11;
    private static final int CODE_INSTALL_SUCCESS = 21;
    private static final int LISTENER_VERSION = 0;
    private static volatile boolean started;
    public static final C3244i INSTANCE = new C3244i();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService queryExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.e
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return C3244i.g(runnable);
        }
    });
    private static final AppCenterSdk.Listener listener = new AppCenterSdk.Listener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.f
        @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
        public final void onCallback(int i10, String str) {
            C3244i.e(i10, str);
        }
    };

    public static final void e(int i10, String str) {
        R5.b.INSTANCE.c("alipay.download.callback", Y8.j.a("code", Integer.valueOf(i10)), Y8.j.a("data", str != null ? La.K.R1(str, 120) : null));
        if (i10 == 11) {
            Integer numF = INSTANCE.f(str);
            if (numF != null) {
                C3245j.INSTANCE.h(numF.intValue());
            }
        } else if (i10 == 21) {
            C3245j.INSTANCE.g();
        }
        C3245j.INSTANCE.f();
    }

    public static final Thread g(Runnable runnable) {
        Thread thread = new Thread(runnable, "alipay-install-sync");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j() {
        /*
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2b
            com.stepos.appcenter.appcentersdk.AppCenterSdk r1 = com.stepos.appcenter.appcentersdk.AppCenterSdk.getInstance()     // Catch: java.lang.Throwable -> L2b
            java.util.List r1 = r1.getAllDownloadTasks()     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L37
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L2b
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L2b
        L13:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L2b
            r3 = r2
            android.util.Pair r3 = (android.util.Pair) r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r3 = r3.first     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = "com.eg.android.AlipayGphone"
            boolean r3 = kotlin.jvm.internal.p.d(r3, r4)     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L13
            goto L2e
        L2b:
            r1 = move-exception
            goto L3d
        L2d:
            r2 = r0
        L2e:
            android.util.Pair r2 = (android.util.Pair) r2     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L37
            java.lang.Object r1 = r2.second     // Catch: java.lang.Throwable -> L2b
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L2b
            goto L38
        L37:
            r1 = r0
        L38:
            java.lang.Object r1 = kotlin.Result.b(r1)     // Catch: java.lang.Throwable -> L2b
            goto L47
        L3d:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.C4849c.a(r1)
            java.lang.Object r1 = kotlin.Result.b(r1)
        L47:
            boolean r2 = kotlin.Result.g(r1)
            if (r2 == 0) goto L4e
            goto L4f
        L4e:
            r0 = r1
        L4f:
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L61
            int r0 = r0.intValue()
            android.os.Handler r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.C3244i.mainHandler
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.h r2 = new com.stepos.ailauncher.foundation.appui.card.provider.alipay.h
            r2.<init>()
            r1.post(r2)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.C3244i.j():void");
    }

    public static final void k(int i10) {
        C3245j c3245j = C3245j.INSTANCE;
        c3245j.h(i10);
        c3245j.f();
    }

    public final Integer f(String data) {
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
        if (strOptString.length() > 0 && !kotlin.jvm.internal.p.d(strOptString, C3236a.PKG_ALIPAY)) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(jSONObject.optInt("progress", -1));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        objB = Result.b(numValueOf);
        return (Integer) (Result.g(objB) ? null : objB);
    }

    public final void h() {
        Object objB;
        if (started) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AppCenterSdk.getInstance().registerListener(C3236a.PKG_ALIPAY, 0, listener);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("alipay.download.register.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        started = ((Boolean) objB).booleanValue();
        if (started) {
            i();
        }
    }

    public final void i() {
        queryExecutor.execute(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.g
            @Override // java.lang.Runnable
            public final void run() {
                C3244i.j();
            }
        });
    }
}
