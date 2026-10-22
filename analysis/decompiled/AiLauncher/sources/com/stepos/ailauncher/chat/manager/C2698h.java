package com.stepos.ailauncher.chat.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.blankj.utilcode.util.ToastUtils;
import com.stepos.ailauncher.chat.R$mipmap;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J%\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R*\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\u001bR\u0014\u0010.\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010\u001bR\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00100R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00100R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00100R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00100¨\u00068"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/h;", "", "<init>", "()V", "", "status", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Z", "k", "Landroid/content/Context;", "context", "LY8/t;", "p", "(Landroid/content/Context;)V", "r", "e", "success", "msg", "l", "(ZLjava/lang/String;)V", "n", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "", "configStartTime", "J", "appContext", "Landroid/content/Context;", UxipConstants.f30680s, "isRunning", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "Lkotlin/Function0;", "onConfigComplete", "Lp9/a;", "getOnConfigComplete", "()Lp9/a;", "o", "(Lp9/a;)V", "Ljava/lang/Runnable;", "statusCheckRunnable", "Ljava/lang/Runnable;", "STATUS_CHECK_INTERVAL_MS", "CONFIG_TIMEOUT_MS", "NOTI_CHANNEL_ID", "Ljava/lang/String;", "", "NOTI_DEPLOY_SUCCESS_ID", "I", "STATUS_RUNNING", "STATUS_CREATING", "STATUS_STARTING", "STATUS_UNKNOWN", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2698h {
    private static final long CONFIG_TIMEOUT_MS = 180000;
    private static final String NOTI_CHANNEL_ID = "agent_config";
    private static final int NOTI_DEPLOY_SUCCESS_ID = 1001;
    private static final long STATUS_CHECK_INTERVAL_MS = 3000;
    private static final String STATUS_CREATING = "DeployStatus_CREATING";
    private static final String STATUS_RUNNING = "DeployStatus_RUNNING";
    private static final String STATUS_STARTING = "DeployStatus_STARTING";
    private static final String STATUS_UNKNOWN = "DeployStatus_UNKNOWN";
    private static Context appContext;
    private static long configStartTime;
    private static boolean isRunning;
    private static InterfaceC5063a<Y8.t> onConfigComplete;
    public static final C2698h INSTANCE = new C2698h();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final Runnable statusCheckRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.manager.d
        @Override // java.lang.Runnable
        public final void run() {
            C2698h.q();
        }
    };

    public static final Y8.t f(final Context context, final String str) {
        C2698h c2698h = INSTANCE;
        if (c2698h.j(str)) {
            c2698h.r();
            AuthManager.INSTANCE.T0(true);
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.f
                @Override // java.lang.Runnable
                public final void run() {
                    C2698h.g();
                }
            });
        } else if (str == null || str.length() == 0) {
            c2698h.r();
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.g
                @Override // java.lang.Runnable
                public final void run() {
                    C2698h.h(str, context);
                }
            });
        } else {
            handler.postDelayed(statusCheckRunnable, 3000L);
        }
        return Y8.t.f7040a;
    }

    public static final void g() {
        m(INSTANCE, true, null, 2, null);
    }

    public static final void h(String str, Context context) {
        INSTANCE.l(false, str == null ? null : context.getString(R$string.agent_config_status_failed));
    }

    public static /* synthetic */ void m(C2698h c2698h, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        c2698h.l(z10, str);
    }

    public static final void q() {
        INSTANCE.e();
    }

    public final void e() {
        final Context context = appContext;
        if (context == null) {
            return;
        }
        if (System.currentTimeMillis() - configStartTime < 180000) {
            ClawVMManager.INSTANCE.a().z(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return C2698h.f(context, (String) obj);
                }
            });
        } else {
            r();
            l(false, context.getString(R$string.agent_config_timeout));
        }
    }

    public final boolean i() {
        return isRunning;
    }

    public final boolean j(String status) {
        return kotlin.jvm.internal.p.d(status, STATUS_RUNNING) || kotlin.jvm.internal.p.d(status, STATUS_CREATING) || kotlin.jvm.internal.p.d(status, STATUS_STARTING);
    }

    public final boolean k(String status) {
        return status == null || status.length() == 0;
    }

    public final void l(boolean success, String msg) {
        Log.i("VmConfigDiag", "poll complete success=" + success + " elapsedMs=" + (System.currentTimeMillis() - configStartTime) + " reason=" + msg);
        if (success) {
            Context context = appContext;
            if (context != null) {
                INSTANCE.n(context);
                S0 s02 = S0.INSTANCE;
                if (s02.c()) {
                    s02.d(context);
                    s02.a("vm_ready");
                }
            }
        } else {
            S0.INSTANCE.a("vm_failed");
            if (msg != null && msg.length() != 0) {
                ToastUtils.w(msg, new Object[0]);
            }
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = onConfigComplete;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        onConfigComplete = null;
    }

    public final void n(Context context) {
        Object systemService = context.getSystemService("notification");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.createNotificationChannel(new NotificationChannel(NOTI_CHANNEL_ID, context.getString(R$string.agent_config_channel_name), 3));
        Notification notificationBuild = new Notification.Builder(context, NOTI_CHANNEL_ID).setContentTitle(context.getString(R$string.agent_config_success_title)).setContentText(context.getString(R$string.agent_config_success_content)).setSmallIcon(R$mipmap.appicon_amoo).setContentIntent(PendingIntent.getBroadcast(context, 0, new Intent(), 201326592)).setAutoCancel(true).build();
        kotlin.jvm.internal.p.h(notificationBuild, "build(...)");
        notificationManager.notify(1001, notificationBuild);
    }

    public final void o(InterfaceC5063a<Y8.t> interfaceC5063a) {
        onConfigComplete = interfaceC5063a;
    }

    public final void p(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        appContext = context.getApplicationContext();
        configStartTime = System.currentTimeMillis();
        isRunning = true;
        Handler handler2 = handler;
        Runnable runnable = statusCheckRunnable;
        handler2.removeCallbacks(runnable);
        handler2.post(runnable);
    }

    public final void r() {
        isRunning = false;
        handler.removeCallbacks(statusCheckRunnable);
    }
}
