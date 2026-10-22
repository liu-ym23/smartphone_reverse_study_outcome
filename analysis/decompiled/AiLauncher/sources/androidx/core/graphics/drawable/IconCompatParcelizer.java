package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import r1.AbstractC5197a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC5197a abstractC5197a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f13086a = abstractC5197a.p(iconCompat.f13086a, 1);
        iconCompat.f13088c = abstractC5197a.j(iconCompat.f13088c, 2);
        iconCompat.f13089d = abstractC5197a.r(iconCompat.f13089d, 3);
        iconCompat.f13090e = abstractC5197a.p(iconCompat.f13090e, 4);
        iconCompat.f13091f = abstractC5197a.p(iconCompat.f13091f, 5);
        iconCompat.f13092g = (ColorStateList) abstractC5197a.r(iconCompat.f13092g, 6);
        iconCompat.f13094i = abstractC5197a.t(iconCompat.f13094i, 7);
        iconCompat.f13095j = abstractC5197a.t(iconCompat.f13095j, 8);
        iconCompat.h();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC5197a abstractC5197a) {
        abstractC5197a.x(true, true);
        iconCompat.i(abstractC5197a.f());
        int i10 = iconCompat.f13086a;
        if (-1 != i10) {
            abstractC5197a.F(i10, 1);
        }
        byte[] bArr = iconCompat.f13088c;
        if (bArr != null) {
            abstractC5197a.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f13089d;
        if (parcelable != null) {
            abstractC5197a.H(parcelable, 3);
        }
        int i11 = iconCompat.f13090e;
        if (i11 != 0) {
            abstractC5197a.F(i11, 4);
        }
        int i12 = iconCompat.f13091f;
        if (i12 != 0) {
            abstractC5197a.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f13092g;
        if (colorStateList != null) {
            abstractC5197a.H(colorStateList, 6);
        }
        String str = iconCompat.f13094i;
        if (str != null) {
            abstractC5197a.J(str, 7);
        }
        String str2 = iconCompat.f13095j;
        if (str2 != null) {
            abstractC5197a.J(str2, 8);
        }
    }
}
