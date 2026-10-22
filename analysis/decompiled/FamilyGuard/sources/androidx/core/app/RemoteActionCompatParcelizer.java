package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f9451a = (IconCompat) aVar.v(remoteActionCompat.f9451a, 1);
        remoteActionCompat.f9452b = aVar.l(remoteActionCompat.f9452b, 2);
        remoteActionCompat.f9453c = aVar.l(remoteActionCompat.f9453c, 3);
        remoteActionCompat.f9454d = (PendingIntent) aVar.r(remoteActionCompat.f9454d, 4);
        remoteActionCompat.f9455e = aVar.h(remoteActionCompat.f9455e, 5);
        remoteActionCompat.f9456f = aVar.h(remoteActionCompat.f9456f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f9451a, 1);
        aVar.D(remoteActionCompat.f9452b, 2);
        aVar.D(remoteActionCompat.f9453c, 3);
        aVar.H(remoteActionCompat.f9454d, 4);
        aVar.z(remoteActionCompat.f9455e, 5);
        aVar.z(remoteActionCompat.f9456f, 6);
    }
}
