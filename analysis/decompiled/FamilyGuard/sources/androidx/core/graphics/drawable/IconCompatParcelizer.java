package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f9652a = aVar.p(iconCompat.f9652a, 1);
        iconCompat.f9654c = aVar.j(iconCompat.f9654c, 2);
        iconCompat.f9655d = aVar.r(iconCompat.f9655d, 3);
        iconCompat.f9656e = aVar.p(iconCompat.f9656e, 4);
        iconCompat.f9657f = aVar.p(iconCompat.f9657f, 5);
        iconCompat.f9658g = (ColorStateList) aVar.r(iconCompat.f9658g, 6);
        iconCompat.f9660i = aVar.t(iconCompat.f9660i, 7);
        iconCompat.f9661j = aVar.t(iconCompat.f9661j, 8);
        iconCompat.l();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.m(aVar.f());
        int i5 = iconCompat.f9652a;
        if (-1 != i5) {
            aVar.F(i5, 1);
        }
        byte[] bArr = iconCompat.f9654c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f9655d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i6 = iconCompat.f9656e;
        if (i6 != 0) {
            aVar.F(i6, 4);
        }
        int i7 = iconCompat.f9657f;
        if (i7 != 0) {
            aVar.F(i7, 5);
        }
        ColorStateList colorStateList = iconCompat.f9658g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f9660i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f9661j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
