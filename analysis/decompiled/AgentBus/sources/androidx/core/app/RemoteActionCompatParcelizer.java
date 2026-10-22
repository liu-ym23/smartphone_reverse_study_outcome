package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
import r3.a;
import r3.b;
import r3.c;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarG = remoteActionCompat.f777a;
        boolean z4 = true;
        if (aVar.e(1)) {
            cVarG = aVar.g();
        }
        remoteActionCompat.f777a = (IconCompat) cVarG;
        CharSequence charSequence = remoteActionCompat.f778b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f8974e);
        }
        remoteActionCompat.f778b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f779c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f8974e);
        }
        remoteActionCompat.f779c = charSequence2;
        remoteActionCompat.f780d = (PendingIntent) aVar.f(remoteActionCompat.f780d, 4);
        boolean z10 = remoteActionCompat.f781e;
        if (aVar.e(5)) {
            z10 = ((b) aVar).f8974e.readInt() != 0;
        }
        remoteActionCompat.f781e = z10;
        boolean z11 = remoteActionCompat.f782f;
        if (!aVar.e(6)) {
            z4 = z11;
        } else if (((b) aVar).f8974e.readInt() == 0) {
            z4 = false;
        }
        remoteActionCompat.f782f = z4;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f777a;
        aVar.h(1);
        aVar.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f778b;
        aVar.h(2);
        Parcel parcel = ((b) aVar).f8974e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f779c;
        aVar.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f780d;
        aVar.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z4 = remoteActionCompat.f781e;
        aVar.h(5);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z10 = remoteActionCompat.f782f;
        aVar.h(6);
        parcel.writeInt(z10 ? 1 : 0);
    }
}
