package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f2544k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f2547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f2548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f2551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2554j;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IconType {
    }

    public static class a {
        public static int a(Object r10) {
            return c.a(r10);
        }

        public static String b(Object r10) {
            return c.b(r10);
        }

        @Nullable
        @DoNotInline
        public static Uri c(@NonNull Object r10) {
            return c.d(r10);
        }

        @DoNotInline
        public static Drawable d(Icon r10, Context r11) {
            return r10.loadDrawable(r11);
        }

        @DoNotInline
        public static Icon e(IconCompat r10, Context r11) {
            switch(r10.f2545a) {
                case -1: goto L20;
                case 0: goto L5;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            Icon r12 = d.a(r10.c());
        L12:
            ColorStateList r13 = r10.f2551g;
            if (r13 == null) goto L15;
            r12.setTintList(r13);
        L15:
            PorterDuff.Mode r14 = r10.f2552h;
            if (r14 == IconCompat.f2544k) goto L18;
            r12.setTintMode(r14);
        L18:
            return r12;
        L7:
            r12 = b.b((Bitmap) r10.f2546b);
            goto L12
        L8:
            r12 = Icon.createWithContentUri((String) r10.f2546b);
            goto L12
        L9:
            r12 = Icon.createWithData((byte[]) r10.f2546b, r10.f2549e, r10.f2550f);
            goto L12
        L10:
            r12 = Icon.createWithResource(r10.b(), r10.f2549e);
            goto L12
        L11:
            r12 = Icon.createWithBitmap((Bitmap) r10.f2546b);
            goto L12
        L5:
            throw new IllegalArgumentException("Unknown type");
        L20:
            return (Icon) r10.f2546b;
        }
    }

    public static class b {
        @DoNotInline
        public static Drawable a(Drawable r10, Drawable r11) {
            return new AdaptiveIconDrawable(r10, r11);
        }

        @DoNotInline
        public static Icon b(Bitmap r10) {
            return Icon.createWithAdaptiveBitmap(r10);
        }
    }

    public static class c {
        @DoNotInline
        public static int a(Object r10) {
            return ((Icon) r10).getResId();
        }

        @DoNotInline
        public static String b(Object r10) {
            return ((Icon) r10).getResPackage();
        }

        @DoNotInline
        public static int c(Object r10) {
            return ((Icon) r10).getType();
        }

        @DoNotInline
        public static Uri d(Object r10) {
            return ((Icon) r10).getUri();
        }
    }

    public static class d {
        @DoNotInline
        public static Icon a(Uri r10) {
            return Icon.createWithAdaptiveBitmapContentUri(r10);
        }
    }

    static {
        f2544k = PorterDuff.Mode.SRC_IN;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.f2545a = -1;
        this.f2547c = null;
        this.f2548d = null;
        this.f2549e = 0;
        this.f2550f = 0;
        this.f2551g = null;
        this.f2552h = f2544k;
        this.f2553i = null;
    }

    public static String f(int r10) {
        switch(r10) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "URI_MASKABLE";
    L7:
        return "BITMAP_MASKABLE";
    L9:
        return "URI";
    L11:
        return "DATA";
    L13:
        return "RESOURCE";
    L15:
        return "BITMAP";
    }

    public int a() {
        int r10 = this.f2545a;
        if (r10 != (-1)) goto L7;
        return a.a(this.f2546b);
    L7:
        if (r10 != 2) goto L11;
        return this.f2549e;
    L11:
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String b() {
        int r10 = this.f2545a;
        if (r10 != (-1)) goto L7;
        return a.b(this.f2546b);
    L7:
        if (r10 != 2) goto L18;
        String r11 = this.f2554j;
        if (r11 == null) goto L16;
        if (TextUtils.isEmpty(r11) == true) goto L16;
        return this.f2554j;
    L16:
        return ((String) this.f2546b).split(":", -1)[0];
    L18:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public Uri c() {
        int r10 = this.f2545a;
        if (r10 != (-1)) goto L7;
        return a.c(this.f2546b);
    L7:
        if (r10 == 4) goto L14;
        if (r10 == 6) goto L14;
        throw new IllegalStateException("called getUri() on " + this);
    L14:
        return Uri.parse((String) this.f2546b);
    }

    public void d() {
        this.f2552h = PorterDuff.Mode.valueOf(this.f2553i);
        switch(this.f2545a) {
            case -1: goto L15;
            case 0: goto L27;
            case 1: goto L11;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L6;
            case 5: goto L11;
            case 6: goto L6;
            default: goto L27;
        };
    L5:
        this.f2546b = this.f2547c;
        return;
    L6:
        String r10 = new String(this.f2547c, Charset.forName(HTTP.UTF_16));
        this.f2546b = r10;
        if (this.f2545a == 2) goto L9;
        return;
    L9:
        if (this.f2554j != null) goto L23;
        this.f2554j = r10.split(":", -1)[0];
        return;
    L23:
        return;
    L11:
        Parcelable r11 = this.f2548d;
        if (r11 == null) goto L14;
        this.f2546b = r11;
        return;
    L14:
        byte[] r12 = this.f2547c;
        this.f2546b = r12;
        this.f2545a = 3;
        this.f2549e = 0;
        this.f2550f = r12.length;
        return;
    L15:
        Parcelable r13 = this.f2548d;
        if (r13 == null) goto L20;
        this.f2546b = r13;
        return;
    L20:
        throw new IllegalArgumentException("Invalid icon");
    }

    public void e(boolean r10) {
        this.f2553i = this.f2552h.name();
        switch(this.f2545a) {
            case -1: goto L11;
            case 0: goto L21;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            case 5: goto L8;
            case 6: goto L5;
            default: goto L21;
        };
    L5:
        this.f2547c = this.f2546b.toString().getBytes(Charset.forName(HTTP.UTF_16));
        return;
    L6:
        this.f2547c = (byte[]) this.f2546b;
        return;
    L7:
        this.f2547c = ((String) this.f2546b).getBytes(Charset.forName(HTTP.UTF_16));
        return;
    L8:
        if (r10 == false) goto L10;
        Bitmap r11 = (Bitmap) this.f2546b;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        r11.compress(Bitmap.CompressFormat.PNG, 90, r12);
        this.f2547c = r12.toByteArray();
        return;
    L10:
        this.f2548d = (Parcelable) this.f2546b;
        return;
    L11:
        if (r10 == true) goto L15;
        this.f2548d = (Parcelable) this.f2546b;
        return;
    L15:
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    public String toString() {
        if (this.f2545a == (-1)) goto L5;
        StringBuilder r10 = new StringBuilder("Icon(typ=");
        r10.append(f(this.f2545a));
        switch(this.f2545a) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L14;
            case 6: goto L9;
            default: goto L16;
        };
    L9:
        r10.append(" uri=");
        r10.append(this.f2546b);
        goto L16
    L10:
        r10.append(" len=");
        r10.append(this.f2549e);
        if (this.f2550f == 0) goto L16;
        r10.append(" off=");
        r10.append(this.f2550f);
        goto L16
    L13:
        r10.append(" pkg=");
        r10.append(this.f2554j);
        r10.append(" id=");
        r10.append(String.format("0x%08x", new Object[]{Integer.valueOf(a())}));
        goto L16
    L14:
        r10.append(" size=");
        r10.append(((Bitmap) this.f2546b).getWidth());
        r10.append(FixCard.FixStyle.KEY_X);
        r10.append(((Bitmap) this.f2546b).getHeight());
    L16:
        if (this.f2551g == null) goto L19;
        r10.append(" tint=");
        r10.append(this.f2551g);
    L19:
        if (this.f2552h == f2544k) goto L21;
        r10.append(" mode=");
        r10.append(this.f2552h);
    L21:
        r10.append(")");
        return r10.toString();
    L5:
        return String.valueOf(this.f2546b);
    }
}
