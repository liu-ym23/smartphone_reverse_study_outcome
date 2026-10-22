package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(f2.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object objL = remoteActionCompat.f1479a;
        if (aVar.h(1)) {
            objL = aVar.l();
        }
        remoteActionCompat.f1479a = (IconCompat) objL;
        CharSequence charSequenceG = remoteActionCompat.f1480b;
        if (aVar.h(2)) {
            charSequenceG = aVar.g();
        }
        remoteActionCompat.f1480b = charSequenceG;
        CharSequence charSequenceG2 = remoteActionCompat.f1481c;
        if (aVar.h(3)) {
            charSequenceG2 = aVar.g();
        }
        remoteActionCompat.f1481c = charSequenceG2;
        Parcelable parcelableJ = remoteActionCompat.f1482d;
        if (aVar.h(4)) {
            parcelableJ = aVar.j();
        }
        remoteActionCompat.f1482d = (PendingIntent) parcelableJ;
        boolean zE = remoteActionCompat.f1483e;
        if (aVar.h(5)) {
            zE = aVar.e();
        }
        remoteActionCompat.f1483e = zE;
        boolean zE2 = remoteActionCompat.f1484f;
        if (aVar.h(6)) {
            zE2 = aVar.e();
        }
        remoteActionCompat.f1484f = zE2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, f2.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1479a;
        aVar.m(1);
        aVar.t(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1480b;
        aVar.m(2);
        aVar.p(charSequence);
        CharSequence charSequence2 = remoteActionCompat.f1481c;
        aVar.m(3);
        aVar.p(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.f1482d;
        aVar.m(4);
        aVar.r(pendingIntent);
        boolean z = remoteActionCompat.f1483e;
        aVar.m(5);
        aVar.n(z);
        boolean z3 = remoteActionCompat.f1484f;
        aVar.m(6);
        aVar.n(z3);
    }
}
