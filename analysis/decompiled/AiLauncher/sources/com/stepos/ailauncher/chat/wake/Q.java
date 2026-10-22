package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/Q;", "", "<init>", "()V", "", "sceneName", "", "homeFollowing", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Z)Ljava/lang/String;", "session", "from", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "e", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "occupancy", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;)Z", "c", "msg", Const.INTENT_KEY_UMID, "SESSION_MINUS_ONE", "Ljava/lang/String;", "shownThisPanelSession", "Z", "boundSession", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Q {
    public static final String SESSION_MINUS_ONE = "minus_one";
    private static volatile String boundSession;
    private static volatile boolean shownThisPanelSession;
    public static final Q INSTANCE = new Q();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static /* synthetic */ void f(Q q10, Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        q10.e(context, str, str2);
    }

    public static final void g(String str, Context context) {
        INSTANCE.d("toast.show from=" + str);
        Toast.makeText(context, R$string.recording_concurrent_hint, 0).show();
    }

    public final void b(String session, String from) {
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(from, "from");
        String str = boundSession;
        if (str == null) {
            boundSession = session;
            return;
        }
        if (kotlin.jvm.internal.p.d(str, session)) {
            return;
        }
        shownThisPanelSession = false;
        boundSession = session;
        d("bindSession " + str + " -> " + session + " from=" + from);
    }

    public final boolean c(MicOccupancyMonitor.OccupancyKind occupancy) {
        kotlin.jvm.internal.p.i(occupancy, "occupancy");
        return occupancy == MicOccupancyMonitor.OccupancyKind.EXTERNAL_RECORDING || occupancy == MicOccupancyMonitor.OccupancyKind.SYSTEM_CALL || occupancy == MicOccupancyMonitor.OccupancyKind.EXTERNAL_VOIP;
    }

    public final void d(String msg) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.b(Integer.valueOf(C4148a.k("RecHint", msg, false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void e(Context context, final String from, String session) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(from, "from");
        if (session != null) {
            b(session, from);
        }
        MicOccupancyMonitor micOccupancyMonitor = MicOccupancyMonitor.INSTANCE;
        micOccupancyMonitor.D();
        if (!micOccupancyMonitor.r() && j(micOccupancyMonitor.i())) {
            final Context applicationContext = context.getApplicationContext();
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.P
                @Override // java.lang.Runnable
                public final void run() {
                    Q.g(from, applicationContext);
                }
            });
        }
    }

    public final void h(String from) {
        kotlin.jvm.internal.p.i(from, "from");
        shownThisPanelSession = false;
        boundSession = null;
        d("reset from=" + from);
    }

    public final String i(String sceneName, boolean homeFollowing) {
        return (sceneName == null || homeFollowing) ? SESSION_MINUS_ONE : sceneName;
    }

    public final boolean j(MicOccupancyMonitor.OccupancyKind occupancy) {
        kotlin.jvm.internal.p.i(occupancy, "occupancy");
        if (shownThisPanelSession || !c(occupancy)) {
            return false;
        }
        shownThisPanelSession = true;
        return true;
    }
}
