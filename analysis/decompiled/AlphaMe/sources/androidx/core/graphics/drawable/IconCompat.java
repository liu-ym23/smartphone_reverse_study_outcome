package androidx.core.graphics.drawable;

import E.e;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.CustomVersionedParcelable;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f3313k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public Object f3315b;

    /* renamed from: j, reason: collision with root package name */
    public String f3323j;

    /* renamed from: a, reason: collision with root package name */
    public int f3314a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3316c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f3317d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f3318e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f3319f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f3320g = null;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f3321h = f3313k;

    /* renamed from: i, reason: collision with root package name */
    public String f3322i = null;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12492a})
    public @interface IconType {
    }

    @RestrictTo({EnumC0546d.f12492a})
    public IconCompat() {
    }

    public static IconCompat a(int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3316c = null;
        iconCompat.f3317d = null;
        iconCompat.f3319f = 0;
        iconCompat.f3320g = null;
        iconCompat.f3321h = f3313k;
        iconCompat.f3322i = null;
        iconCompat.f3314a = 2;
        iconCompat.f3318e = i4;
        iconCompat.f3315b = "";
        iconCompat.f3323j = "";
        return iconCompat;
    }

    public final int b() {
        int i4 = this.f3314a;
        if (i4 == -1) {
            return e.a(this.f3315b);
        }
        if (i4 == 2) {
            return this.f3318e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final String toString() {
        String str;
        if (this.f3314a == -1) {
            return String.valueOf(this.f3315b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f3314a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f3314a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f3315b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f3315b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f3323j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f3318e);
                if (this.f3319f != 0) {
                    sb.append(" off=");
                    sb.append(this.f3319f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f3315b);
                break;
        }
        if (this.f3320g != null) {
            sb.append(" tint=");
            sb.append(this.f3320g);
        }
        if (this.f3321h != f3313k) {
            sb.append(" mode=");
            sb.append(this.f3321h);
        }
        sb.append(")");
        return sb.toString();
    }
}
