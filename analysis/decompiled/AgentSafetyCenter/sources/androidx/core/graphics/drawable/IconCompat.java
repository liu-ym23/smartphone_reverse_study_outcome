package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f1041k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f1042a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1043b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f1044c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f1045d;

    /* renamed from: e, reason: collision with root package name */
    public int f1046e;

    /* renamed from: f, reason: collision with root package name */
    public int f1047f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f1048g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1049h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f1050j;

    public final String toString() {
        String str;
        int resId;
        if (this.f1042a == -1) {
            return String.valueOf(this.f1043b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        switch (this.f1042a) {
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
        switch (this.f1042a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f1043b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f1043b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f1050j);
                sb2.append(" id=");
                int i = this.f1042a;
                if (i == -1) {
                    resId = ((Icon) this.f1043b).getResId();
                } else {
                    if (i != 2) {
                        f.r(this, "called getResId() on ");
                        return null;
                    }
                    resId = this.f1046e;
                }
                sb2.append(String.format("0x%08x", Integer.valueOf(resId)));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f1046e);
                if (this.f1047f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f1047f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f1043b);
                break;
        }
        if (this.f1048g != null) {
            sb2.append(" tint=");
            sb2.append(this.f1048g);
        }
        if (this.f1049h != f1041k) {
            sb2.append(" mode=");
            sb2.append(this.f1049h);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
