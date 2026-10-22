package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(VersionedParcel r10) {
        RemoteActionCompat r11 = new RemoteActionCompat();
        r11.f2457a = (IconCompat) r10.v(r11.f2457a, 1);
        r11.f2458b = r10.l(r11.f2458b, 2);
        r11.f2459c = r10.l(r11.f2459c, 3);
        r11.f2460d = (PendingIntent) r10.r(r11.f2460d, 4);
        r11.f2461e = r10.h(r11.f2461e, 5);
        r11.f2462f = r10.h(r11.f2462f, 6);
        return r11;
    }

    public static void write(RemoteActionCompat r10, VersionedParcel r11) {
        r11.x(false, false);
        r11.M(r10.f2457a, 1);
        r11.D(r10.f2458b, 2);
        r11.D(r10.f2459c, 3);
        r11.H(r10.f2460d, 4);
        r11.z(r10.f2461e, 5);
        r11.z(r10.f2462f, 6);
    }
}
