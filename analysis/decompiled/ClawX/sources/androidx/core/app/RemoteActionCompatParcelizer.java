package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import c1.a;
import c1.b;
import c1.c;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarG = remoteActionCompat.f398a;
        boolean z = true;
        if (aVar.e(1)) {
            cVarG = aVar.g();
        }
        remoteActionCompat.f398a = (IconCompat) cVarG;
        CharSequence charSequence = remoteActionCompat.f399b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f1054e);
        }
        remoteActionCompat.f399b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f400c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f1054e);
        }
        remoteActionCompat.f400c = charSequence2;
        remoteActionCompat.d = (PendingIntent) aVar.f(remoteActionCompat.d, 4);
        boolean z2 = remoteActionCompat.f401e;
        if (aVar.e(5)) {
            z2 = ((b) aVar).f1054e.readInt() != 0;
        }
        remoteActionCompat.f401e = z2;
        boolean z8 = remoteActionCompat.f402f;
        if (!aVar.e(6)) {
            z = z8;
        } else if (((b) aVar).f1054e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f402f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f398a;
        aVar.h(1);
        aVar.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f399b;
        aVar.h(2);
        Parcel parcel = ((b) aVar).f1054e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f400c;
        aVar.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.d;
        aVar.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z = remoteActionCompat.f401e;
        aVar.h(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f402f;
        aVar.h(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
