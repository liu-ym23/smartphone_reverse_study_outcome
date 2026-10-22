package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f783k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public Object f785b;

    /* renamed from: j, reason: collision with root package name */
    public String f793j;

    /* renamed from: a, reason: collision with root package name */
    public int f784a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f786c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f787d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f788e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f789f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f790g = null;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f791h = f783k;

    /* renamed from: i, reason: collision with root package name */
    public String f792i = null;

    public final String toString() {
        String str;
        int resId;
        if (this.f784a == -1) {
            return String.valueOf(this.f785b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        switch (this.f784a) {
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
        sb2.append(str);
        switch (this.f784a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f785b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f785b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f793j);
                sb2.append(" id=");
                int i2 = this.f784a;
                if (i2 == -1) {
                    resId = ((Icon) this.f785b).getResId();
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("called getResId() on " + this);
                    }
                    resId = this.f788e;
                }
                sb2.append(String.format("0x%08x", Integer.valueOf(resId)));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f788e);
                if (this.f789f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f789f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f785b);
                break;
        }
        if (this.f790g != null) {
            sb2.append(" tint=");
            sb2.append(this.f790g);
        }
        if (this.f791h != f783k) {
            sb2.append(" mode=");
            sb2.append(this.f791h);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
