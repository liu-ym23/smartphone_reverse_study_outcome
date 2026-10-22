package com.stepos.core.common.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b.l;
import java.util.HashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NotificationSender {
    public static final Companion Companion = new Companion(null);
    private static final long DELAY_MS = 200;
    private final Handler handler;
    private final NotificationManager nm;
    private final HashMap<Integer, Runnable> tasks;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public NotificationSender(Context context) {
        g.f(context, "context");
        Object systemService = context.getSystemService("notification");
        g.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.nm = (NotificationManager) systemService;
        this.handler = new Handler(Looper.getMainLooper());
        this.tasks = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendDelayed$lambda$0(NotificationSender notificationSender, int i10, Notification notification) {
        notificationSender.nm.notify(i10, notification);
    }

    public final void cancelPending(int i10) {
        synchronized (this.tasks) {
            Runnable runnableRemove = this.tasks.remove(Integer.valueOf(i10));
            if (runnableRemove != null) {
                this.handler.removeCallbacks(runnableRemove);
                n nVar = n.f10413a;
            }
        }
    }

    public final void sendDelayed(int i10, Notification notification) {
        g.f(notification, "notification");
        cancelPending(i10);
        l lVar = new l(i10, 1, this, notification);
        synchronized (this.tasks) {
            this.tasks.put(Integer.valueOf(i10), lVar);
            this.handler.postDelayed(lVar, 200L);
        }
    }
}
