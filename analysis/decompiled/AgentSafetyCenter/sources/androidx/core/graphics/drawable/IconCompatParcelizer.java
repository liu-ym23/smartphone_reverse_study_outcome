package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import e5.a;
import e5.b;
import g5.f;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1042a = -1;
        byte[] bArr = null;
        iconCompat.f1044c = null;
        iconCompat.f1045d = null;
        iconCompat.f1046e = 0;
        iconCompat.f1047f = 0;
        iconCompat.f1048g = null;
        iconCompat.f1049h = IconCompat.f1041k;
        iconCompat.i = null;
        iconCompat.f1042a = !aVar.e(1) ? -1 : ((b) aVar).f3500e.readInt();
        byte[] bArr2 = iconCompat.f1044c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f3500e;
            int i = parcel.readInt();
            if (i >= 0) {
                bArr = new byte[i];
                parcel.readByteArray(bArr);
            }
        } else {
            bArr = bArr2;
        }
        iconCompat.f1044c = bArr;
        iconCompat.f1045d = aVar.f(iconCompat.f1045d, 3);
        int i3 = iconCompat.f1046e;
        if (aVar.e(4)) {
            i3 = ((b) aVar).f3500e.readInt();
        }
        iconCompat.f1046e = i3;
        int i10 = iconCompat.f1047f;
        if (aVar.e(5)) {
            i10 = ((b) aVar).f3500e.readInt();
        }
        iconCompat.f1047f = i10;
        iconCompat.f1048g = (ColorStateList) aVar.f(iconCompat.f1048g, 6);
        String string = iconCompat.i;
        if (aVar.e(7)) {
            string = ((b) aVar).f3500e.readString();
        }
        iconCompat.i = string;
        String string2 = iconCompat.f1050j;
        if (aVar.e(8)) {
            string2 = ((b) aVar).f3500e.readString();
        }
        iconCompat.f1050j = string2;
        iconCompat.f1049h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.f1042a) {
            case -1:
                Parcelable parcelable = iconCompat.f1045d;
                if (parcelable != null) {
                    iconCompat.f1043b = parcelable;
                    return iconCompat;
                }
                f.s("Invalid icon");
                return null;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f1045d;
                if (parcelable2 != null) {
                    iconCompat.f1043b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f1044c;
                iconCompat.f1043b = bArr3;
                iconCompat.f1042a = 3;
                iconCompat.f1046e = 0;
                iconCompat.f1047f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f1044c, Charset.forName("UTF-16"));
                iconCompat.f1043b = str;
                if (iconCompat.f1042a == 2 && iconCompat.f1050j == null) {
                    iconCompat.f1050j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f1043b = iconCompat.f1044c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.i = iconCompat.f1049h.name();
        switch (iconCompat.f1042a) {
            case -1:
                iconCompat.f1045d = (Parcelable) iconCompat.f1043b;
                break;
            case 1:
            case 5:
                iconCompat.f1045d = (Parcelable) iconCompat.f1043b;
                break;
            case 2:
                iconCompat.f1044c = ((String) iconCompat.f1043b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1044c = (byte[]) iconCompat.f1043b;
                break;
            case 4:
            case 6:
                iconCompat.f1044c = iconCompat.f1043b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f1042a;
        if (-1 != i) {
            aVar.h(1);
            ((b) aVar).f3500e.writeInt(i);
        }
        byte[] bArr = iconCompat.f1044c;
        if (bArr != null) {
            aVar.h(2);
            Parcel parcel = ((b) aVar).f3500e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f1045d;
        if (parcelable != null) {
            aVar.h(3);
            ((b) aVar).f3500e.writeParcelable(parcelable, 0);
        }
        int i3 = iconCompat.f1046e;
        if (i3 != 0) {
            aVar.h(4);
            ((b) aVar).f3500e.writeInt(i3);
        }
        int i10 = iconCompat.f1047f;
        if (i10 != 0) {
            aVar.h(5);
            ((b) aVar).f3500e.writeInt(i10);
        }
        ColorStateList colorStateList = iconCompat.f1048g;
        if (colorStateList != null) {
            aVar.h(6);
            ((b) aVar).f3500e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.i;
        if (str != null) {
            aVar.h(7);
            ((b) aVar).f3500e.writeString(str);
        }
        String str2 = iconCompat.f1050j;
        if (str2 != null) {
            aVar.h(8);
            ((b) aVar).f3500e.writeString(str2);
        }
    }
}
