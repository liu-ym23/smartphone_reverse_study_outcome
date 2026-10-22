package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\rJ\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/v;", "", "<init>", "()V", "", "taskId", "", "sessionId", "LY8/t;", "l", "(Ljava/lang/String;J)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Z", "m", "cardTaskId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "status", "k", "(Ljava/lang/String;Ljava/lang/Integer;)V", "reason", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "TIMEOUT_MS", "J", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "io", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ConcurrentHashMap;", "sessions", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Runnable;", "timeouts", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class v {
    public static final long TIMEOUT_MS = 5000;
    public static final v INSTANCE = new v();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService io = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.q
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return v.g(runnable);
        }
    });
    private static final ConcurrentHashMap<String, Long> sessions = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Runnable> timeouts = new ConcurrentHashMap<>();

    public static final Thread g(Runnable runnable) {
        Thread thread = new Thread(runnable, "XuiCommand");
        thread.setDaemon(true);
        return thread;
    }

    public static final void j(String str, Long l10) {
        D6.a.INSTANCE.c(str, l10.longValue());
    }

    public static final void n(String str) {
        INSTANCE.f(str, "timeout");
    }

    public static final void o(final String str, Long l10) {
        if (D6.a.INSTANCE.b(str, l10.longValue(), 5)) {
            return;
        }
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.u
            @Override // java.lang.Runnable
            public final void run() {
                v.p(str);
            }
        });
    }

    public static final void p(String str) {
        INSTANCE.f(str, "ipcFail");
    }

    public final void f(String taskId, String reason) {
        Runnable runnableRemove;
        if (taskId.length() == 0 || (runnableRemove = timeouts.remove(taskId)) == null) {
            return;
        }
        mainHandler.removeCallbacks(runnableRemove);
        R5.b.INSTANCE.c("alipay.cancel.done", Y8.j.a("taskId", taskId), Y8.j.a("reason", reason));
        N5.d dVarA = N5.z.INSTANCE.a(taskId);
        AlipayXuiCardView alipayXuiCardView = dVarA instanceof AlipayXuiCardView ? (AlipayXuiCardView) dVarA : null;
        if (alipayXuiCardView != null) {
            alipayXuiCardView.J0();
        }
    }

    public final boolean h(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return taskId.length() > 0 && timeouts.containsKey(taskId);
    }

    public final boolean i(final String cardTaskId) {
        kotlin.jvm.internal.p.i(cardTaskId, "cardTaskId");
        if (cardTaskId.length() == 0) {
            return false;
        }
        final Long l10 = sessions.get(cardTaskId);
        if (l10 == null || l10.longValue() == 0) {
            R5.b.INSTANCE.h("alipay.view.skip", Y8.j.a("taskId", cardTaskId), Y8.j.a("reason", "noSession"));
            return false;
        }
        R5.b.INSTANCE.c("alipay.view.send", Y8.j.a("taskId", cardTaskId), Y8.j.a("sessionId", l10), Y8.j.a(D6.a.KEY_TASK_STATUS, 8));
        io.execute(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.r
            @Override // java.lang.Runnable
            public final void run() {
                v.j(cardTaskId, l10);
            }
        });
        return true;
    }

    public final void k(String taskId, Integer status) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if ((status != null && status.intValue() == 4) || ((status != null && status.intValue() == 5) || (status != null && status.intValue() == 6))) {
            f(taskId, "binder" + status);
        }
    }

    public final void l(String taskId, long sessionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() == 0 || sessionId == 0) {
            return;
        }
        sessions.put(taskId, Long.valueOf(sessionId));
    }

    public final boolean m(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() == 0) {
            return false;
        }
        ConcurrentHashMap<String, Runnable> concurrentHashMap = timeouts;
        if (concurrentHashMap.containsKey(taskId)) {
            R5.b.INSTANCE.c("alipay.cancel.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", AuthSessionDto.STATUS_PENDING));
            return false;
        }
        final Long l10 = sessions.get(taskId);
        if (l10 == null || l10.longValue() == 0) {
            R5.b.INSTANCE.h("alipay.cancel.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", "noSession"));
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.s
            @Override // java.lang.Runnable
            public final void run() {
                v.n(taskId);
            }
        };
        concurrentHashMap.put(taskId, runnable);
        mainHandler.postDelayed(runnable, 5000L);
        R5.b.INSTANCE.c("alipay.cancel.send", Y8.j.a("taskId", taskId), Y8.j.a("sessionId", l10), Y8.j.a(D6.a.KEY_TASK_STATUS, 5));
        io.execute(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.t
            @Override // java.lang.Runnable
            public final void run() {
                v.o(taskId, l10);
            }
        });
        return true;
    }
}
