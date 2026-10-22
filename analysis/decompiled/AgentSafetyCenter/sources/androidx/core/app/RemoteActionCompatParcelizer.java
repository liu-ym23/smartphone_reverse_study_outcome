package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import e5.a;
import e5.b;
import e5.c;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarG = remoteActionCompat.f1033a;
        boolean z10 = true;
        if (aVar.e(1)) {
            cVarG = aVar.g();
        }
        remoteActionCompat.f1033a = (IconCompat) cVarG;
        CharSequence charSequence = remoteActionCompat.f1034b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f3500e);
        }
        remoteActionCompat.f1034b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1035c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f3500e);
        }
        remoteActionCompat.f1035c = charSequence2;
        remoteActionCompat.f1036d = (PendingIntent) aVar.f(remoteActionCompat.f1036d, 4);
        boolean z11 = remoteActionCompat.f1037e;
        if (aVar.e(5)) {
            z11 = ((b) aVar).f3500e.readInt() != 0;
        }
        remoteActionCompat.f1037e = z11;
        boolean z12 = remoteActionCompat.f1038f;
        if (!aVar.e(6)) {
            z10 = z12;
        } else if (((b) aVar).f3500e.readInt() == 0) {
            z10 = false;
        }
        remoteActionCompat.f1038f = z10;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1033a;
        aVar.h(1);
        aVar.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1034b;
        aVar.h(2);
        Parcel parcel = ((b) aVar).f3500e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f1035c;
        aVar.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f1036d;
        aVar.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z10 = remoteActionCompat.f1037e;
        aVar.h(5);
        parcel.writeInt(z10 ? 1 : 0);
        boolean z11 = remoteActionCompat.f1038f;
        aVar.h(6);
        parcel.writeInt(z11 ? 1 : 0);
    }
}
