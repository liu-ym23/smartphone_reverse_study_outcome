package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import f2.a;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        int i10 = iconCompat.f1520a;
        if (aVar.h(1)) {
            i10 = aVar.i();
        }
        iconCompat.f1520a = i10;
        byte[] bArrF = iconCompat.f1522c;
        if (aVar.h(2)) {
            bArrF = aVar.f();
        }
        iconCompat.f1522c = bArrF;
        Parcelable parcelableJ = iconCompat.f1523d;
        if (aVar.h(3)) {
            parcelableJ = aVar.j();
        }
        iconCompat.f1523d = parcelableJ;
        int i11 = iconCompat.f1524e;
        if (aVar.h(4)) {
            i11 = aVar.i();
        }
        iconCompat.f1524e = i11;
        int i12 = iconCompat.f1525f;
        if (aVar.h(5)) {
            i12 = aVar.i();
        }
        iconCompat.f1525f = i12;
        Parcelable parcelableJ2 = iconCompat.f1526g;
        if (aVar.h(6)) {
            parcelableJ2 = aVar.j();
        }
        iconCompat.f1526g = (ColorStateList) parcelableJ2;
        String strK = iconCompat.f1527i;
        if (aVar.h(7)) {
            strK = aVar.k();
        }
        iconCompat.f1527i = strK;
        String strK2 = iconCompat.f1528j;
        if (aVar.h(8)) {
            strK2 = aVar.k();
        }
        iconCompat.f1528j = strK2;
        iconCompat.h = PorterDuff.Mode.valueOf(iconCompat.f1527i);
        switch (iconCompat.f1520a) {
            case -1:
                Parcelable parcelable = iconCompat.f1523d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f1521b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f1523d;
                if (parcelable2 != null) {
                    iconCompat.f1521b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr = iconCompat.f1522c;
                iconCompat.f1521b = bArr;
                iconCompat.f1520a = 3;
                iconCompat.f1524e = 0;
                iconCompat.f1525f = bArr.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f1522c, Charset.forName("UTF-16"));
                iconCompat.f1521b = str;
                if (iconCompat.f1520a == 2 && iconCompat.f1528j == null) {
                    iconCompat.f1528j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f1521b = iconCompat.f1522c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f1527i = iconCompat.h.name();
        switch (iconCompat.f1520a) {
            case -1:
                iconCompat.f1523d = (Parcelable) iconCompat.f1521b;
                break;
            case 1:
            case 5:
                iconCompat.f1523d = (Parcelable) iconCompat.f1521b;
                break;
            case 2:
                iconCompat.f1522c = ((String) iconCompat.f1521b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1522c = (byte[]) iconCompat.f1521b;
                break;
            case 4:
            case 6:
                iconCompat.f1522c = iconCompat.f1521b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i10 = iconCompat.f1520a;
        if (-1 != i10) {
            aVar.m(1);
            aVar.q(i10);
        }
        byte[] bArr = iconCompat.f1522c;
        if (bArr != null) {
            aVar.m(2);
            aVar.o(bArr);
        }
        Parcelable parcelable = iconCompat.f1523d;
        if (parcelable != null) {
            aVar.m(3);
            aVar.r(parcelable);
        }
        int i11 = iconCompat.f1524e;
        if (i11 != 0) {
            aVar.m(4);
            aVar.q(i11);
        }
        int i12 = iconCompat.f1525f;
        if (i12 != 0) {
            aVar.m(5);
            aVar.q(i12);
        }
        ColorStateList colorStateList = iconCompat.f1526g;
        if (colorStateList != null) {
            aVar.m(6);
            aVar.r(colorStateList);
        }
        String str = iconCompat.f1527i;
        if (str != null) {
            aVar.m(7);
            aVar.s(str);
        }
        String str2 = iconCompat.f1528j;
        if (str2 != null) {
            aVar.m(8);
            aVar.s(str2);
        }
    }
}
