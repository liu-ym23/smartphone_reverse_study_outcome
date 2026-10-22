package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f13085k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f13086a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13087b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f13088c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f13089d;

    /* renamed from: e, reason: collision with root package name */
    public int f13090e;

    /* renamed from: f, reason: collision with root package name */
    public int f13091f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f13092g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f13093h;

    /* renamed from: i, reason: collision with root package name */
    public String f13094i;

    /* renamed from: j, reason: collision with root package name */
    public String f13095j;

    public static class a {
        public static int a(Object obj) {
            return c.a(obj);
        }

        public static String b(Object obj) {
            return c.b(obj);
        }

        public static int c(Object obj) {
            return c.c(obj);
        }

        public static Uri d(Object obj) {
            return c.d(obj);
        }

        public static Icon e(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f13086a) {
                case -1:
                    return (Icon) iconCompat.f13087b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f13087b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.e(), iconCompat.f13090e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f13087b, iconCompat.f13090e, iconCompat.f13091f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f13087b);
                    break;
                case 5:
                    iconCreateWithBitmap = b.a((Bitmap) iconCompat.f13087b);
                    break;
                case 6:
                    iconCreateWithBitmap = d.a(iconCompat.g());
                    break;
            }
            ColorStateList colorStateList = iconCompat.f13092g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f13093h;
            if (mode != IconCompat.f13085k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    public static class b {
        public static Icon a(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f13086a = -1;
        this.f13088c = null;
        this.f13089d = null;
        this.f13090e = 0;
        this.f13091f = 0;
        this.f13092g = null;
        this.f13093h = f13085k;
        this.f13094i = null;
    }

    public static IconCompat a(Bitmap bitmap) {
        B0.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f13087b = bitmap;
        return iconCompat;
    }

    public static IconCompat b(Context context, int i10) {
        B0.c.c(context);
        return c(context.getResources(), context.getPackageName(), i10);
    }

    public static IconCompat c(Resources resources, String str, int i10) {
        B0.c.c(str);
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f13090e = i10;
        if (resources != null) {
            try {
                iconCompat.f13087b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f13087b = str;
        }
        iconCompat.f13095j = str;
        return iconCompat;
    }

    public static String l(int i10) {
        switch (i10) {
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

    public int d() {
        int i10 = this.f13086a;
        if (i10 == -1) {
            return a.a(this.f13087b);
        }
        if (i10 == 2) {
            return this.f13090e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String e() {
        int i10 = this.f13086a;
        if (i10 == -1) {
            return a.b(this.f13087b);
        }
        if (i10 == 2) {
            String str = this.f13095j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f13087b).split(ServerSentEventKt.COLON, -1)[0] : this.f13095j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int f() {
        int i10 = this.f13086a;
        return i10 == -1 ? a.c(this.f13087b) : i10;
    }

    public Uri g() {
        int i10 = this.f13086a;
        if (i10 == -1) {
            return a.d(this.f13087b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f13087b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public void h() {
        this.f13093h = PorterDuff.Mode.valueOf(this.f13094i);
        switch (this.f13086a) {
            case -1:
                Parcelable parcelable = this.f13089d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f13087b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f13089d;
                if (parcelable2 != null) {
                    this.f13087b = parcelable2;
                    return;
                }
                byte[] bArr = this.f13088c;
                this.f13087b = bArr;
                this.f13086a = 3;
                this.f13090e = 0;
                this.f13091f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f13088c, Charset.forName(e.f30862u));
                this.f13087b = str;
                if (this.f13086a == 2 && this.f13095j == null) {
                    this.f13095j = str.split(ServerSentEventKt.COLON, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f13087b = this.f13088c;
                return;
        }
    }

    public void i(boolean z10) {
        this.f13094i = this.f13093h.name();
        switch (this.f13086a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f13089d = (Parcelable) this.f13087b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f13089d = (Parcelable) this.f13087b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f13087b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f13088c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f13088c = ((String) this.f13087b).getBytes(Charset.forName(e.f30862u));
                return;
            case 3:
                this.f13088c = (byte[]) this.f13087b;
                return;
            case 4:
            case 6:
                this.f13088c = this.f13087b.toString().getBytes(Charset.forName(e.f30862u));
                return;
        }
    }

    @Deprecated
    public Icon j() {
        return k(null);
    }

    public Icon k(Context context) {
        return a.e(this, context);
    }

    public String toString() {
        if (this.f13086a == -1) {
            return String.valueOf(this.f13087b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(l(this.f13086a));
        switch (this.f13086a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f13087b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f13087b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f13095j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(d())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f13090e);
                if (this.f13091f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f13091f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f13087b);
                break;
        }
        if (this.f13092g != null) {
            sb2.append(" tint=");
            sb2.append(this.f13092g);
        }
        if (this.f13093h != f13085k) {
            sb2.append(" mode=");
            sb2.append(this.f13093h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public IconCompat(int i10) {
        this.f13088c = null;
        this.f13089d = null;
        this.f13090e = 0;
        this.f13091f = 0;
        this.f13092g = null;
        this.f13093h = f13085k;
        this.f13094i = null;
        this.f13086a = i10;
    }
}
