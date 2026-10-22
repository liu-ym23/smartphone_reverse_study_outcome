package r2;

import android.content.Context;
import android.os.PowerManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11706a;

    static {
        String strF = h2.j.f("WakeLocks");
        kotlin.jvm.internal.g.e(strF, "tagWithPrefix(\"WakeLocks\")");
        f11706a = strF;
    }

    public static final PowerManager.WakeLock a(Context context, String tag) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(tag, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        kotlin.jvm.internal.g.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String strConcat = "WorkManager: ".concat(tag);
        PowerManager.WakeLock wakeLock = ((PowerManager) systemService).newWakeLock(1, strConcat);
        synchronized (n.f11707a) {
            n.f11708b.put(wakeLock, strConcat);
        }
        kotlin.jvm.internal.g.e(wakeLock, "wakeLock");
        return wakeLock;
    }
}
