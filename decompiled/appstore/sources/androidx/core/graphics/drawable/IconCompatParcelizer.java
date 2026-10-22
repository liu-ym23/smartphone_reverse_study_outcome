package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IconCompatParcelizer {
    public IconCompatParcelizer() {
    }

    public static IconCompat read(VersionedParcel r10) {
        IconCompat r11 = new IconCompat();
        r11.f2545a = r10.p(r11.f2545a, 1);
        r11.f2547c = r10.j(r11.f2547c, 2);
        r11.f2548d = r10.r(r11.f2548d, 3);
        r11.f2549e = r10.p(r11.f2549e, 4);
        r11.f2550f = r10.p(r11.f2550f, 5);
        r11.f2551g = (ColorStateList) r10.r(r11.f2551g, 6);
        r11.f2553i = r10.t(r11.f2553i, 7);
        r11.f2554j = r10.t(r11.f2554j, 8);
        r11.d();
        return r11;
    }

    public static void write(IconCompat r10, VersionedParcel r11) {
        r11.x(true, true);
        r10.e(r11.f());
        int r12 = r10.f2545a;
        if ((-1) == r12) goto L5;
        r11.F(r12, 1);
    L5:
        byte[] r13 = r10.f2547c;
        if (r13 == null) goto L8;
        r11.B(r13, 2);
    L8:
        Parcelable r14 = r10.f2548d;
        if (r14 == null) goto L11;
        r11.H(r14, 3);
    L11:
        int r15 = r10.f2549e;
        if (r15 == 0) goto L14;
        r11.F(r15, 4);
    L14:
        int r16 = r10.f2550f;
        if (r16 == 0) goto L17;
        r11.F(r16, 5);
    L17:
        ColorStateList r17 = r10.f2551g;
        if (r17 == null) goto L20;
        r11.H(r17, 6);
    L20:
        String r18 = r10.f2553i;
        if (r18 == null) goto L23;
        r11.J(r18, 7);
    L23:
        String r19 = r10.f2554j;
        if (r19 == null) goto L27;
        r11.J(r19, 8);
        return;
    }
}
