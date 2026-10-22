package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import e.EnumC0546d;
import java.lang.reflect.InvocationTargetException;
import q0.AbstractC0822a;
import q0.C0823b;
import q0.InterfaceC0824c;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0822a abstractC0822a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC0824c interfaceC0824cH = remoteActionCompat.f3275a;
        if (abstractC0822a.e(1)) {
            interfaceC0824cH = abstractC0822a.h();
        }
        remoteActionCompat.f3275a = (IconCompat) interfaceC0824cH;
        CharSequence charSequence = remoteActionCompat.f3276b;
        if (abstractC0822a.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0823b) abstractC0822a).f13979e);
        }
        remoteActionCompat.f3276b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f3277c;
        if (abstractC0822a.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0823b) abstractC0822a).f13979e);
        }
        remoteActionCompat.f3277c = charSequence2;
        remoteActionCompat.f3278d = (PendingIntent) abstractC0822a.g(remoteActionCompat.f3278d, 4);
        boolean z4 = remoteActionCompat.f3279e;
        if (abstractC0822a.e(5)) {
            z4 = ((C0823b) abstractC0822a).f13979e.readInt() != 0;
        }
        remoteActionCompat.f3279e = z4;
        boolean z5 = remoteActionCompat.f3280f;
        if (abstractC0822a.e(6)) {
            z5 = ((C0823b) abstractC0822a).f13979e.readInt() != 0;
        }
        remoteActionCompat.f3280f = z5;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0822a abstractC0822a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0822a.getClass();
        IconCompat iconCompat = remoteActionCompat.f3275a;
        abstractC0822a.i(1);
        abstractC0822a.k(iconCompat);
        CharSequence charSequence = remoteActionCompat.f3276b;
        abstractC0822a.i(2);
        Parcel parcel = ((C0823b) abstractC0822a).f13979e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f3277c;
        abstractC0822a.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f3278d;
        abstractC0822a.i(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z4 = remoteActionCompat.f3279e;
        abstractC0822a.i(5);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = remoteActionCompat.f3280f;
        abstractC0822a.i(6);
        parcel.writeInt(z5 ? 1 : 0);
    }
}
