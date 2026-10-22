package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import c1.a;
import c1.b;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        int i8 = iconCompat.f409a;
        if (aVar.e(1)) {
            i8 = ((b) aVar).f1054e.readInt();
        }
        iconCompat.f409a = i8;
        byte[] bArr = iconCompat.f411c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f1054e;
            int i9 = parcel.readInt();
            if (i9 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i9];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f411c = bArr;
        iconCompat.d = aVar.f(iconCompat.d, 3);
        int i10 = iconCompat.f412e;
        if (aVar.e(4)) {
            i10 = ((b) aVar).f1054e.readInt();
        }
        iconCompat.f412e = i10;
        int i11 = iconCompat.f413f;
        if (aVar.e(5)) {
            i11 = ((b) aVar).f1054e.readInt();
        }
        iconCompat.f413f = i11;
        iconCompat.f414g = (ColorStateList) aVar.f(iconCompat.f414g, 6);
        String string = iconCompat.f416i;
        if (aVar.e(7)) {
            string = ((b) aVar).f1054e.readString();
        }
        iconCompat.f416i = string;
        String string2 = iconCompat.f417j;
        if (aVar.e(8)) {
            string2 = ((b) aVar).f1054e.readString();
        }
        iconCompat.f417j = string2;
        iconCompat.f415h = PorterDuff.Mode.valueOf(iconCompat.f416i);
        switch (iconCompat.f409a) {
            case -1:
                Parcelable parcelable = iconCompat.d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f410b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.d;
                if (parcelable2 != null) {
                    iconCompat.f410b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f411c;
                iconCompat.f410b = bArr3;
                iconCompat.f409a = 3;
                iconCompat.f412e = 0;
                iconCompat.f413f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f411c, Charset.forName("UTF-16"));
                iconCompat.f410b = str;
                if (iconCompat.f409a == 2 && iconCompat.f417j == null) {
                    iconCompat.f417j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f410b = iconCompat.f411c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f416i = iconCompat.f415h.name();
        switch (iconCompat.f409a) {
            case -1:
                iconCompat.d = (Parcelable) iconCompat.f410b;
                break;
            case 1:
            case 5:
                iconCompat.d = (Parcelable) iconCompat.f410b;
                break;
            case 2:
                iconCompat.f411c = ((String) iconCompat.f410b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f411c = (byte[]) iconCompat.f410b;
                break;
            case 4:
            case 6:
                iconCompat.f411c = iconCompat.f410b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i8 = iconCompat.f409a;
        if (-1 != i8) {
            aVar.h(1);
            ((b) aVar).f1054e.writeInt(i8);
        }
        byte[] bArr = iconCompat.f411c;
        if (bArr != null) {
            aVar.h(2);
            Parcel parcel = ((b) aVar).f1054e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            aVar.h(3);
            ((b) aVar).f1054e.writeParcelable(parcelable, 0);
        }
        int i9 = iconCompat.f412e;
        if (i9 != 0) {
            aVar.h(4);
            ((b) aVar).f1054e.writeInt(i9);
        }
        int i10 = iconCompat.f413f;
        if (i10 != 0) {
            aVar.h(5);
            ((b) aVar).f1054e.writeInt(i10);
        }
        ColorStateList colorStateList = iconCompat.f414g;
        if (colorStateList != null) {
            aVar.h(6);
            ((b) aVar).f1054e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f416i;
        if (str != null) {
            aVar.h(7);
            ((b) aVar).f1054e.writeString(str);
        }
        String str2 = iconCompat.f417j;
        if (str2 != null) {
            aVar.h(8);
            ((b) aVar).f1054e.writeString(str2);
        }
    }
}
