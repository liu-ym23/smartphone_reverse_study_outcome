package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f408k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public Object f410b;

    /* renamed from: j, reason: collision with root package name */
    public String f417j;

    /* renamed from: a, reason: collision with root package name */
    public int f409a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f411c = null;
    public Parcelable d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f412e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f413f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f414g = null;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f415h = f408k;

    /* renamed from: i, reason: collision with root package name */
    public String f416i = null;

    public final String toString() {
        String str;
        int resId;
        if (this.f409a == -1) {
            return String.valueOf(this.f410b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f409a) {
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
        switch (this.f409a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f410b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f410b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f417j);
                sb.append(" id=");
                int i8 = this.f409a;
                if (i8 == -1) {
                    resId = ((Icon) this.f410b).getResId();
                } else {
                    if (i8 != 2) {
                        throw new IllegalStateException("called getResId() on " + this);
                    }
                    resId = this.f412e;
                }
                sb.append(String.format("0x%08x", Integer.valueOf(resId)));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f412e);
                if (this.f413f != 0) {
                    sb.append(" off=");
                    sb.append(this.f413f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f410b);
                break;
        }
        if (this.f414g != null) {
            sb.append(" tint=");
            sb.append(this.f414g);
        }
        if (this.f415h != f408k) {
            sb.append(" mode=");
            sb.append(this.f415h);
        }
        sb.append(")");
        return sb.toString();
    }
}
