package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.stepos.core.common.telemetry.FailStage;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f1519k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public Object f1521b;

    /* renamed from: j, reason: collision with root package name */
    public String f1528j;

    /* renamed from: a, reason: collision with root package name */
    public int f1520a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f1522c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f1523d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f1524e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1525f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f1526g = null;
    public PorterDuff.Mode h = f1519k;

    /* renamed from: i, reason: collision with root package name */
    public String f1527i = null;

    public static IconCompat a(Resources resources, String str, int i10) {
        str.getClass();
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1522c = null;
        iconCompat.f1523d = null;
        iconCompat.f1525f = 0;
        iconCompat.f1526g = null;
        iconCompat.h = f1519k;
        iconCompat.f1527i = null;
        iconCompat.f1520a = 2;
        iconCompat.f1524e = i10;
        if (resources != null) {
            try {
                iconCompat.f1521b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f1521b = str;
        }
        iconCompat.f1528j = str;
        return iconCompat;
    }

    public final int b() {
        int i10 = this.f1520a;
        if (i10 == -1) {
            return ((Icon) this.f1521b).getResId();
        }
        if (i10 == 2) {
            return this.f1524e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final String toString() {
        String str;
        if (this.f1520a == -1) {
            return String.valueOf(this.f1521b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        switch (this.f1520a) {
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
                str = FailStage.UNKNOWN;
                break;
        }
        sb2.append(str);
        switch (this.f1520a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f1521b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f1521b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f1528j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f1524e);
                if (this.f1525f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f1525f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f1521b);
                break;
        }
        if (this.f1526g != null) {
            sb2.append(" tint=");
            sb2.append(this.f1526g);
        }
        if (this.h != f1519k) {
            sb2.append(" mode=");
            sb2.append(this.h);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
