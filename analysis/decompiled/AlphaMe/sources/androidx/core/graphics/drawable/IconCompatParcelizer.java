package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.awareness.AwarenessDataItem;
import e.EnumC0546d;
import java.nio.charset.Charset;
import q0.AbstractC0822a;
import q0.C0823b;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC0822a abstractC0822a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3314a = abstractC0822a.f(iconCompat.f3314a, 1);
        byte[] bArr = iconCompat.f3316c;
        if (abstractC0822a.e(2)) {
            Parcel parcel = ((C0823b) abstractC0822a).f13979e;
            int i4 = parcel.readInt();
            if (i4 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i4];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f3316c = bArr;
        iconCompat.f3317d = abstractC0822a.g(iconCompat.f3317d, 3);
        iconCompat.f3318e = abstractC0822a.f(iconCompat.f3318e, 4);
        iconCompat.f3319f = abstractC0822a.f(iconCompat.f3319f, 5);
        iconCompat.f3320g = (ColorStateList) abstractC0822a.g(iconCompat.f3320g, 6);
        String string = iconCompat.f3322i;
        if (abstractC0822a.e(7)) {
            string = ((C0823b) abstractC0822a).f13979e.readString();
        }
        iconCompat.f3322i = string;
        String string2 = iconCompat.f3323j;
        if (abstractC0822a.e(8)) {
            string2 = ((C0823b) abstractC0822a).f13979e.readString();
        }
        iconCompat.f3323j = string2;
        iconCompat.f3321h = PorterDuff.Mode.valueOf(iconCompat.f3322i);
        switch (iconCompat.f3314a) {
            case -1:
                Parcelable parcelable = iconCompat.f3317d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f3315b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f3317d;
                if (parcelable2 != null) {
                    iconCompat.f3315b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.f3316c;
                    iconCompat.f3315b = bArr3;
                    iconCompat.f3314a = 3;
                    iconCompat.f3318e = 0;
                    iconCompat.f3319f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f3316c, Charset.forName("UTF-16"));
                iconCompat.f3315b = str;
                if (iconCompat.f3314a == 2 && iconCompat.f3323j == null) {
                    iconCompat.f3323j = str.split(AwarenessDataItem.USERID_SPLITTER, -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f3315b = iconCompat.f3316c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC0822a abstractC0822a) {
        abstractC0822a.getClass();
        iconCompat.f3322i = iconCompat.f3321h.name();
        switch (iconCompat.f3314a) {
            case -1:
                iconCompat.f3317d = (Parcelable) iconCompat.f3315b;
                break;
            case 1:
            case 5:
                iconCompat.f3317d = (Parcelable) iconCompat.f3315b;
                break;
            case 2:
                iconCompat.f3316c = ((String) iconCompat.f3315b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f3316c = (byte[]) iconCompat.f3315b;
                break;
            case 4:
            case 6:
                iconCompat.f3316c = iconCompat.f3315b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i4 = iconCompat.f3314a;
        if (-1 != i4) {
            abstractC0822a.j(i4, 1);
        }
        byte[] bArr = iconCompat.f3316c;
        if (bArr != null) {
            abstractC0822a.i(2);
            int length = bArr.length;
            Parcel parcel = ((C0823b) abstractC0822a).f13979e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f3317d;
        if (parcelable != null) {
            abstractC0822a.i(3);
            ((C0823b) abstractC0822a).f13979e.writeParcelable(parcelable, 0);
        }
        int i5 = iconCompat.f3318e;
        if (i5 != 0) {
            abstractC0822a.j(i5, 4);
        }
        int i6 = iconCompat.f3319f;
        if (i6 != 0) {
            abstractC0822a.j(i6, 5);
        }
        ColorStateList colorStateList = iconCompat.f3320g;
        if (colorStateList != null) {
            abstractC0822a.i(6);
            ((C0823b) abstractC0822a).f13979e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f3322i;
        if (str != null) {
            abstractC0822a.i(7);
            ((C0823b) abstractC0822a).f13979e.writeString(str);
        }
        String str2 = iconCompat.f3323j;
        if (str2 != null) {
            abstractC0822a.i(8);
            ((C0823b) abstractC0822a).f13979e.writeString(str2);
        }
    }
}
