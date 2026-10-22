package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import r3.a;
import r3.b;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        int i2 = iconCompat.f784a;
        if (aVar.e(1)) {
            i2 = ((b) aVar).f8974e.readInt();
        }
        iconCompat.f784a = i2;
        byte[] bArr = iconCompat.f786c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f8974e;
            int i10 = parcel.readInt();
            if (i10 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i10];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f786c = bArr;
        iconCompat.f787d = aVar.f(iconCompat.f787d, 3);
        int i11 = iconCompat.f788e;
        if (aVar.e(4)) {
            i11 = ((b) aVar).f8974e.readInt();
        }
        iconCompat.f788e = i11;
        int i12 = iconCompat.f789f;
        if (aVar.e(5)) {
            i12 = ((b) aVar).f8974e.readInt();
        }
        iconCompat.f789f = i12;
        iconCompat.f790g = (ColorStateList) aVar.f(iconCompat.f790g, 6);
        String string = iconCompat.f792i;
        if (aVar.e(7)) {
            string = ((b) aVar).f8974e.readString();
        }
        iconCompat.f792i = string;
        String string2 = iconCompat.f793j;
        if (aVar.e(8)) {
            string2 = ((b) aVar).f8974e.readString();
        }
        iconCompat.f793j = string2;
        iconCompat.f791h = PorterDuff.Mode.valueOf(iconCompat.f792i);
        switch (iconCompat.f784a) {
            case -1:
                Parcelable parcelable = iconCompat.f787d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f785b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f787d;
                if (parcelable2 != null) {
                    iconCompat.f785b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f786c;
                iconCompat.f785b = bArr3;
                iconCompat.f784a = 3;
                iconCompat.f788e = 0;
                iconCompat.f789f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f786c, Charset.forName("UTF-16"));
                iconCompat.f785b = str;
                if (iconCompat.f784a == 2 && iconCompat.f793j == null) {
                    iconCompat.f793j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f785b = iconCompat.f786c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f792i = iconCompat.f791h.name();
        switch (iconCompat.f784a) {
            case -1:
                iconCompat.f787d = (Parcelable) iconCompat.f785b;
                break;
            case 1:
            case 5:
                iconCompat.f787d = (Parcelable) iconCompat.f785b;
                break;
            case 2:
                iconCompat.f786c = ((String) iconCompat.f785b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f786c = (byte[]) iconCompat.f785b;
                break;
            case 4:
            case 6:
                iconCompat.f786c = iconCompat.f785b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.f784a;
        if (-1 != i2) {
            aVar.h(1);
            ((b) aVar).f8974e.writeInt(i2);
        }
        byte[] bArr = iconCompat.f786c;
        if (bArr != null) {
            aVar.h(2);
            Parcel parcel = ((b) aVar).f8974e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f787d;
        if (parcelable != null) {
            aVar.h(3);
            ((b) aVar).f8974e.writeParcelable(parcelable, 0);
        }
        int i10 = iconCompat.f788e;
        if (i10 != 0) {
            aVar.h(4);
            ((b) aVar).f8974e.writeInt(i10);
        }
        int i11 = iconCompat.f789f;
        if (i11 != 0) {
            aVar.h(5);
            ((b) aVar).f8974e.writeInt(i11);
        }
        ColorStateList colorStateList = iconCompat.f790g;
        if (colorStateList != null) {
            aVar.h(6);
            ((b) aVar).f8974e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f792i;
        if (str != null) {
            aVar.h(7);
            ((b) aVar).f8974e.writeString(str);
        }
        String str2 = iconCompat.f793j;
        if (str2 != null) {
            aVar.h(8);
            ((b) aVar).f8974e.writeString(str2);
        }
    }
}
