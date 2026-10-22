package A0;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.Service;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.work.impl.foreground.SystemForegroundService;
import s0.t;

/* loaded from: classes.dex */
public abstract class f {
    @DoNotInline
    public static void a(Service service, int i4, Notification notification, int i5) {
        try {
            service.startForeground(i4, notification, i5);
        } catch (ForegroundServiceStartNotAllowedException e4) {
            t tVarD = t.d();
            String str = SystemForegroundService.f4340f;
            if (tVarD.f14213a <= 5) {
                Log.w(str, "Unable to start foreground service", e4);
            }
        }
    }
}
