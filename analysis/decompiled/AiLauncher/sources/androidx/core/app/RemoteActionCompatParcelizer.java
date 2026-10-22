package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
import r1.AbstractC5197a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC5197a abstractC5197a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f12932a = (IconCompat) abstractC5197a.v(remoteActionCompat.f12932a, 1);
        remoteActionCompat.f12933b = abstractC5197a.l(remoteActionCompat.f12933b, 2);
        remoteActionCompat.f12934c = abstractC5197a.l(remoteActionCompat.f12934c, 3);
        remoteActionCompat.f12935d = (PendingIntent) abstractC5197a.r(remoteActionCompat.f12935d, 4);
        remoteActionCompat.f12936e = abstractC5197a.h(remoteActionCompat.f12936e, 5);
        remoteActionCompat.f12937f = abstractC5197a.h(remoteActionCompat.f12937f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC5197a abstractC5197a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC5197a.x(false, false);
        abstractC5197a.M(remoteActionCompat.f12932a, 1);
        abstractC5197a.D(remoteActionCompat.f12933b, 2);
        abstractC5197a.D(remoteActionCompat.f12934c, 3);
        abstractC5197a.H(remoteActionCompat.f12935d, 4);
        abstractC5197a.z(remoteActionCompat.f12936e, 5);
        abstractC5197a.z(remoteActionCompat.f12937f, 6);
    }
}
