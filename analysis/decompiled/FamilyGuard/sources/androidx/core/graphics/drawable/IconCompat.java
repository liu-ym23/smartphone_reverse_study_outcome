package androidx.core.graphics.drawable;

import D.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f9651k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f9652a;

    /* renamed from: b, reason: collision with root package name */
    Object f9653b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f9654c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f9655d;

    /* renamed from: e, reason: collision with root package name */
    public int f9656e;

    /* renamed from: f, reason: collision with root package name */
    public int f9657f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f9658g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f9659h;

    /* renamed from: i, reason: collision with root package name */
    public String f9660i;

    /* renamed from: j, reason: collision with root package name */
    public String f9661j;

    static class a {
        static IconCompat a(Object obj) {
            h.e(obj);
            int iD = d(obj);
            if (iD == 2) {
                return IconCompat.g(null, c(obj), b(obj));
            }
            if (iD == 4) {
                return IconCompat.d(e(obj));
            }
            if (iD == 6) {
                return IconCompat.b(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f9653b = obj;
            return iconCompat;
        }

        static int b(Object obj) {
            return c.a(obj);
        }

        static String c(Object obj) {
            return c.b(obj);
        }

        static int d(Object obj) {
            return c.c(obj);
        }

        static Uri e(Object obj) {
            return c.d(obj);
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon g(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f9652a) {
                case -1:
                    return (Icon) iconCompat.f9653b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f9653b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.i(), iconCompat.f9656e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f9653b, iconCompat.f9656e, iconCompat.f9657f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f9653b);
                    break;
                case 5:
                    iconCreateWithBitmap = b.b((Bitmap) iconCompat.f9653b);
                    break;
                case 6:
                    iconCreateWithBitmap = d.a(iconCompat.k());
                    break;
            }
            ColorStateList colorStateList = iconCompat.f9658g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f9659h;
            if (mode != IconCompat.f9651k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f9652a = -1;
        this.f9654c = null;
        this.f9655d = null;
        this.f9656e = 0;
        this.f9657f = 0;
        this.f9658g = null;
        this.f9659h = f9651k;
        this.f9660i = null;
    }

    public static IconCompat a(Icon icon) {
        return a.a(icon);
    }

    public static IconCompat b(Uri uri) {
        D.c.c(uri);
        return c(uri.toString());
    }

    public static IconCompat c(String str) {
        D.c.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f9653b = str;
        return iconCompat;
    }

    public static IconCompat d(Uri uri) {
        D.c.c(uri);
        return e(uri.toString());
    }

    public static IconCompat e(String str) {
        D.c.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f9653b = str;
        return iconCompat;
    }

    public static IconCompat f(Context context, int i5) {
        D.c.c(context);
        return g(context.getResources(), context.getPackageName(), i5);
    }

    public static IconCompat g(Resources resources, String str, int i5) {
        D.c.c(str);
        if (i5 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f9656e = i5;
        if (resources != null) {
            try {
                iconCompat.f9653b = resources.getResourceName(i5);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f9653b = str;
        }
        iconCompat.f9661j = str;
        return iconCompat;
    }

    private static String p(int i5) {
        switch (i5) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int h() {
        int i5 = this.f9652a;
        if (i5 == -1) {
            return a.b(this.f9653b);
        }
        if (i5 == 2) {
            return this.f9656e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String i() {
        int i5 = this.f9652a;
        if (i5 == -1) {
            return a.c(this.f9653b);
        }
        if (i5 == 2) {
            String str = this.f9661j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f9653b).split(":", -1)[0] : this.f9661j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int j() {
        int i5 = this.f9652a;
        return i5 == -1 ? a.d(this.f9653b) : i5;
    }

    public Uri k() {
        int i5 = this.f9652a;
        if (i5 == -1) {
            return a.e(this.f9653b);
        }
        if (i5 == 4 || i5 == 6) {
            return Uri.parse((String) this.f9653b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public void l() {
        this.f9659h = PorterDuff.Mode.valueOf(this.f9660i);
        switch (this.f9652a) {
            case -1:
                Parcelable parcelable = this.f9655d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f9653b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f9655d;
                if (parcelable2 != null) {
                    this.f9653b = parcelable2;
                    return;
                }
                byte[] bArr = this.f9654c;
                this.f9653b = bArr;
                this.f9652a = 3;
                this.f9656e = 0;
                this.f9657f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f9654c, Charset.forName("UTF-16"));
                this.f9653b = str;
                if (this.f9652a == 2 && this.f9661j == null) {
                    this.f9661j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f9653b = this.f9654c;
                return;
        }
    }

    public void m(boolean z5) {
        this.f9660i = this.f9659h.name();
        switch (this.f9652a) {
            case -1:
                if (z5) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f9655d = (Parcelable) this.f9653b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z5) {
                    this.f9655d = (Parcelable) this.f9653b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f9653b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f9654c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f9654c = ((String) this.f9653b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f9654c = (byte[]) this.f9653b;
                return;
            case 4:
            case 6:
                this.f9654c = this.f9653b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Deprecated
    public Icon n() {
        return o(null);
    }

    public Icon o(Context context) {
        return a.g(this, context);
    }

    public String toString() {
        if (this.f9652a == -1) {
            return String.valueOf(this.f9653b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(p(this.f9652a));
        switch (this.f9652a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f9653b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f9653b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f9661j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(h())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f9656e);
                if (this.f9657f != 0) {
                    sb.append(" off=");
                    sb.append(this.f9657f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f9653b);
                break;
        }
        if (this.f9658g != null) {
            sb.append(" tint=");
            sb.append(this.f9658g);
        }
        if (this.f9659h != f9651k) {
            sb.append(" mode=");
            sb.append(this.f9659h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i5) {
        this.f9654c = null;
        this.f9655d = null;
        this.f9656e = 0;
        this.f9657f = 0;
        this.f9658g = null;
        this.f9659h = f9651k;
        this.f9660i = null;
        this.f9652a = i5;
    }
}
