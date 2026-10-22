package com.stepos.ailauncher.chat.wake.homebar;

import La.D;
import Z8.F;
import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.chat.sheet.i0;
import h8.C4148a;
import io.ktor.http.ContentType;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\u001f\u0010\r\u001a\u00020\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0003J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/g;", "", "<init>", "()V", "Landroid/app/Application;", ContentType.Application.TYPE, "LY8/t;", "m", "(Landroid/app/Application;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlin/Function0;", "onFinished", Const.INTENT_KEY_PKGNAME, "(Lp9/a;)V", Const.INTENT_KEY_UMID, "", "f", "(Lp9/a;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "reason", "", "delayMs", "k", "(Ljava/lang/String;J)V", "o", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "n", "(Landroid/content/Context;)Ljava/lang/String;", "topPkg", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "NINE_SPLIT_COLLAPSE_DELAY_MS", "J", "HOME_COLLAPSE_DELAY_MS", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "launchToken", "Ljava/lang/Object;", "launchLock", "app", "Landroid/app/Application;", RobotInfo.STATUS_STARTED, "Z", "consumed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    private static final long HOME_COLLAPSE_DELAY_MS = 280;
    private static final long NINE_SPLIT_COLLAPSE_DELAY_MS = 450;
    private static final String TAG = "HomeBarLpGuide";
    private static Application app;
    private static volatile boolean consumed;
    private static boolean started;
    public static final g INSTANCE = new g();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Object launchToken = new Object();
    private static final Object launchLock = new Object();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(g gVar, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        gVar.b(interfaceC5063a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(g gVar, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        gVar.d(interfaceC5063a);
    }

    public static final void l(String str) {
        INSTANCE.o(str);
    }

    public final void b(InterfaceC5063a<Y8.t> onFinished) {
        HomeBarLongPressGuideActivity.INSTANCE.d(onFinished);
    }

    public final void d(InterfaceC5063a<Y8.t> onFinished) {
        HomeBarLongPressGuideActivity.INSTANCE.a(onFinished);
    }

    public final boolean f(InterfaceC5063a<Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        return HomeBarLongPressGuideActivity.INSTANCE.b(onFinished);
    }

    public final boolean g(Context context, String topPkg) {
        if (kotlin.jvm.internal.p.d(topPkg, context.getPackageName()) || kotlin.jvm.internal.p.d(topPkg, "com.android.launcher3") || D.X(topPkg, "com.android.systemui", false, 2, null)) {
            return false;
        }
        String strB = i0.INSTANCE.b(context);
        return strB == null || !kotlin.jvm.internal.p.d(topPkg, strB);
    }

    public final void h() {
        k("nine_split_collapse", NINE_SPLIT_COLLAPSE_DELAY_MS);
    }

    public final void i() {
        k("nine_split_collapse_home", 280L);
    }

    public final void j() {
        mainHandler.removeCallbacksAndMessages(launchToken);
    }

    public final void k(final String reason, long delayMs) {
        Handler handler = mainHandler;
        Object obj = launchToken;
        handler.removeCallbacksAndMessages(obj);
        handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.homebar.f
            @Override // java.lang.Runnable
            public final void run() {
                g.l(reason);
            }
        }, obj, delayMs);
    }

    public final void m(Application application) {
        kotlin.jvm.internal.p.i(application, "application");
        if (started) {
            return;
        }
        started = true;
        app = application;
        if (w.INSTANCE.a(application)) {
            consumed = true;
            C4148a.k(TAG, "already completed, skip", false, 4, null);
        }
    }

    public final String n(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || (runningTaskInfo = (ActivityManager.RunningTaskInfo) F.s0(runningTasks)) == null || (componentName = runningTaskInfo.topActivity) == null) {
                return null;
            }
            return componentName.getPackageName();
        } catch (Throwable th) {
            C4148a.u(TAG, "getRunningTasks failed: " + th.getMessage(), false, 4, null);
            return null;
        }
    }

    public final void o(String reason) {
        String str;
        Object objB;
        Application application = app;
        if (application == null) {
            return;
        }
        String strN = n(application);
        boolean z10 = strN != null && INSTANCE.g(application, strN);
        synchronized (launchLock) {
            try {
                if (!consumed) {
                    w wVar = w.INSTANCE;
                    if (!wVar.a(application)) {
                        if (HomeBarLongPressGuideActivity.INSTANCE.c()) {
                            return;
                        }
                        KeyguardManager keyguardManager = (KeyguardManager) application.getSystemService(KeyguardManager.class);
                        if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                            str = "keyguard";
                        } else if (DesktopChatResidentController.P1()) {
                            str = "chat foreground";
                        } else {
                            RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
                            str = recentsWindowMonitor.h() == RecentsWindowMonitor.RecentsState.PEEK ? "peek" : (!recentsWindowMonitor.l() || z10) ? null : "recents";
                        }
                        if (str != null) {
                            C4148a.d(TAG, "skip launch, " + str + " reason=" + reason, false, 4, null);
                            return;
                        }
                        consumed = true;
                        Y8.t tVar = Y8.t.f7040a;
                        C4148a.k(TAG, "launch guide page reason=" + reason, false, 4, null);
                        wVar.b(application);
                        Intent intent = new Intent(application, (Class<?>) HomeBarLongPressGuideActivity.class);
                        intent.addFlags(813760512);
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            application.startActivity(intent);
                            objB = Result.b(Y8.t.f7040a);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objB = Result.b(C4849c.a(th));
                        }
                        if (Result.h(objB)) {
                            INSTANCE.j();
                        }
                        Throwable thE = Result.e(objB);
                        if (thE != null) {
                            C4148a.t(TAG, "startActivity failed reason=" + reason, thE, false, 8, null);
                            synchronized (launchLock) {
                                consumed = false;
                                Y8.t tVar2 = Y8.t.f7040a;
                            }
                            return;
                        }
                        return;
                    }
                }
                consumed = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
