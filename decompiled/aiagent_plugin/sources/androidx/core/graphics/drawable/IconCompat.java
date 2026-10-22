package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.g;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final String TAG = "IconCompat";
    static final PorterDuff.Mode h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f1200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f1202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1203e;
    public int f;
    public ColorStateList g;
    PorterDuff.Mode i;
    public String j;
    public String k;

    static class a {
        static int getType(Object r7) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return c.getType(r7);
        L18:
            return ((Integer) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getType", new Class[0]).invoke(r7, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();
        L15:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon type " + r7, e);
            return -1;
        L9:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon type " + r7, e);
            return -1;
        L12:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon type " + r7, e);
            return -1;
        }

        static String a(Object r7) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return c.a(r7);
        L18:
            return (String) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getResPackage", new Class[0]).invoke(r7, new Object[0]), String.class, "com.obric.aiagent.plugin");
        L15:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon package", e);
            return null;
        L9:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon package", e);
            return null;
        L12:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon package", e);
            return null;
        }

        static IconCompat b(Object r2) {
            g.a(r2);
            int r0 = getType(r2);
            if (r0 == 2) goto L15;
            if (r0 == 4) goto L13;
            if (r0 == 6) goto L11;
            IconCompat r1 = new IconCompat(-1);
            r1.f1200b = r2;
            return r1;
        L11:
            return IconCompat.b(d(r2));
        L13:
            return IconCompat.a(d(r2));
        L15:
            return IconCompat.a(null, a(r2), c(r2));
        }

        static int c(Object r6) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return c.b(r6);
        L18:
            return ((Integer) ZeusTransformUtils.preCheckCast(r6.getClass().getMethod("getResId", new Class[0]).invoke(r6, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();
        L15:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon resource", e);
            return 0;
        L9:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon resource", e);
            return 0;
        L12:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon resource", e);
            return 0;
        }

        static Uri d(Object r7) {
            if (Build.VERSION.SDK_INT < 28) goto L18;
            return c.c(r7);
        L18:
            return (Uri) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getUri", new Class[0]).invoke(r7, new Object[0]), Uri.class, "com.obric.aiagent.plugin");
        L15:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon uri", e);
            return null;
        L9:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon uri", e);
            return null;
        L12:
            e = move-exception;
            a(IconCompat.TAG, "Unable to get icon uri", e);
            return null;
        }

        static Icon a(IconCompat r4, Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            switch(r4.f1199a) {
                case -1: goto L36;
                case 0: goto L5;
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L21;
                case 6: goto L7;
                default: goto L5;
            };
        L24:
            Icon r7 = Icon.createWithContentUri((String) ZeusTransformUtils.preCheckCast(r4.f1200b, String.class, "com.obric.aiagent.plugin"));
        L29:
            if (r4.g == null) goto L32;
            r7.setTintList(r4.g);
        L32:
            if (r4.i == IconCompat.h) goto L34;
            r7.setTintMode(r4.i);
        L34:
            return r7;
        L25:
            r7 = Icon.createWithData((byte[]) ZeusTransformUtils.preCheckCast(r4.f1200b, byte[].class, "com.obric.aiagent.plugin"), r4.f1203e, r4.f);
            goto L29
        L26:
            r7 = Icon.createWithResource(r4.a(), r4.f1203e);
            goto L29
        L27:
            r7 = Icon.createWithBitmap((Bitmap) ZeusTransformUtils.preCheckCast(r4.f1200b, Bitmap.class, "com.obric.aiagent.plugin"));
            goto L29
        L5:
            throw new IllegalArgumentException("Unknown type");
        L7:
            if (Build.VERSION.SDK_INT < 30) goto L9;
            r7 = d.a(r4.d());
            goto L29
        L9:
            if (r6 == null) goto L19;
            InputStream r8 = r4.b(r6);
            if (r8 == null) goto L17;
            if (Build.VERSION.SDK_INT < 26) goto L15;
            r7 = b.a(BitmapFactory.decodeStream(r8));
            goto L29
        L15:
            r7 = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(r8), false));
            goto L29
        L17:
            throw new IllegalStateException("Cannot load adaptive icon from uri: " + r4.d());
        L19:
            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + r4.d());
        L21:
            if (Build.VERSION.SDK_INT < 26) goto L23;
            r7 = b.a((Bitmap) ZeusTransformUtils.preCheckCast(r4.f1200b, Bitmap.class, "com.obric.aiagent.plugin"));
            goto L29
        L23:
            r7 = Icon.createWithBitmap(IconCompat.a((Bitmap) ZeusTransformUtils.preCheckCast(r4.f1200b, Bitmap.class, "com.obric.aiagent.plugin"), false));
            goto L29
        L36:
            return (Icon) ZeusTransformUtils.preCheckCast(r4.f1200b, Icon.class, "com.obric.aiagent.plugin");
        }

        static Drawable a(Icon r2, Context r3) {
            return r2.loadDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    static class b {
        static Drawable a(Drawable r1, Drawable r2) {
            return new AdaptiveIconDrawable(r1, r2);
        }

        static Icon a(Bitmap r0) {
            return Icon.createWithAdaptiveBitmap(r0);
        }
    }

    static class c {
        static String a(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.aiagent.plugin")).getResPackage();
        }

        static int getType(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.aiagent.plugin")).getType();
        }

        static int b(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.aiagent.plugin")).getResId();
        }

        static Uri c(Object r2) {
            return ((Icon) ZeusTransformUtils.preCheckCast(r2, Icon.class, "com.obric.aiagent.plugin")).getUri();
        }
    }

    static class d {
        static Icon a(Uri r0) {
            return Icon.createWithAdaptiveBitmapContentUri(r0);
        }
    }

    private static String a(int r0) {
        switch(r0) {
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

    static {
        h = PorterDuff.Mode.SRC_IN;
    }

    public static IconCompat a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        androidx.core.util.d.a(r4);
        return a(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin"), r4.getPackageName(), r3);
    }

    public static IconCompat a(Resources r2, String r3, int r4) {
        androidx.core.util.d.a(r3);
        if (r4 == 0) goto L14;
        IconCompat r0 = new IconCompat(2);
        r0.f1203e = r4;
        if (r2 != null) goto L15;
        r0.f1200b = r3;
    L11:
        r0.k = r3;
        return r0;
    L15:
        r0.f1200b = r2.getResourceName(r4);     // Catch: Resources.NotFoundException -> L8
    L9:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L14:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public static IconCompat a(String r2) {
        androidx.core.util.d.a(r2);
        IconCompat r0 = new IconCompat(4);
        r0.f1200b = r2;
        return r0;
    }

    public static IconCompat a(Uri r0) {
        androidx.core.util.d.a(r0);
        return a(r0.toString());
    }

    public static IconCompat b(String r2) {
        androidx.core.util.d.a(r2);
        IconCompat r0 = new IconCompat(6);
        r0.f1200b = r2;
        return r0;
    }

    public static IconCompat b(Uri r0) {
        androidx.core.util.d.a(r0);
        return b(r0.toString());
    }

    public IconCompat() {
        this.f1199a = -1;
        this.f1201c = null;
        this.f1202d = null;
        this.f1203e = 0;
        this.f = 0;
        this.g = null;
        this.i = h;
        this.j = null;
    }

    IconCompat(int r3) {
        this.f1199a = -1;
        this.f1201c = null;
        this.f1202d = null;
        this.f1203e = 0;
        this.f = 0;
        this.g = null;
        this.i = h;
        this.j = null;
        this.f1199a = r3;
    }

    public int getType() {
        if (this.f1199a != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return a.getType(this.f1200b);
    L9:
        return this.f1199a;
    }

    public String a() {
        if (this.f1199a != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return a.a(this.f1200b);
    L9:
        if (this.f1199a != 2) goto L20;
        String r0 = this.k;
        if (r0 == null) goto L18;
        if (TextUtils.isEmpty(r0) == true) goto L18;
        return this.k;
    L18:
        return ((String) ZeusTransformUtils.preCheckCast(this.f1200b, String.class, "com.obric.aiagent.plugin")).split(":", -1)[0];
    L20:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int b() {
        if (this.f1199a != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return a.c(this.f1200b);
    L9:
        if (this.f1199a != 2) goto L13;
        return this.f1203e;
    L13:
        throw new IllegalStateException("called getResId() on " + this);
    }

    public Bitmap c() {
        if (this.f1199a == (-1)) goto L5;
    L12:
        int r0 = this.f1199a;
        if (r0 != 1) goto L17;
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.f1200b, Bitmap.class, "com.obric.aiagent.plugin");
    L17:
        if (r0 != 5) goto L21;
        return a((Bitmap) ZeusTransformUtils.preCheckCast(this.f1200b, Bitmap.class, "com.obric.aiagent.plugin"), true);
    L21:
        throw new IllegalStateException("called getBitmap() on " + this);
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (ZeusTransformUtils.instanceOf(this.f1200b, Bitmap.class) == true) goto L9;
        return null;
    L9:
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.f1200b, Bitmap.class, "com.obric.aiagent.plugin");
    }

    public Uri d() {
        if (this.f1199a == (-1)) goto L5;
    L8:
        int r0 = this.f1199a;
        if (r0 == 4) goto L16;
        if (r0 == 6) goto L16;
        throw new IllegalStateException("called getUri() on " + this);
    L16:
        return Uri.parse((String) ZeusTransformUtils.preCheckCast(this.f1200b, String.class, "com.obric.aiagent.plugin"));
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        return a.d(this.f1200b);
    }

    @Deprecated
    public Icon e() {
        return a(null);
    }

    public Icon a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return a.a(this, r4);
    L7:
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public InputStream b(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Uri r0 = d();
        String r2 = r0.getScheme();
        if ("content".equals(r2) == false) goto L5;
    L17:
        return r7.getContentResolver().openInputStream(r0);
    L13:
        e = move-exception;
        b(TAG, "Unable to load image from URI: " + r0, e);
        return null;
    L5:
        if ("file".equals(r2) == true) goto L17;
        return new FileInputStream(new File((String) ZeusTransformUtils.preCheckCast(this.f1200b, String.class, "com.obric.aiagent.plugin")));
    L9:
        e = move-exception;
        b(TAG, "Unable to load image from path: " + r0, e);
        return null;
    }

    static Resources getResources(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if ("android".equals(r4) == true) goto L5;
        PackageManager r6 = r5.getPackageManager();
        ApplicationInfo r0 = r6.getApplicationInfo(r4, 8192);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r0 == null) goto L11;
        return r6.getResourcesForApplication(r0);
    L11:
        return null;
    L12:
        e = move-exception;
        a(TAG, String.format("Unable to find pkg=%s for icon", new Object[]{r4}), e);
        return null;
    L5:
        return Resources.getSystem();
    }

    public Bundle f() {
        Bundle r0 = new Bundle();
        switch(this.f1199a) {
            case -1: goto L9;
            case 0: goto L5;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L7;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L5;
        };
    L6:
        r0.putByteArray("obj", (byte[]) ZeusTransformUtils.preCheckCast(this.f1200b, byte[].class, "com.obric.aiagent.plugin"));
    L10:
        r0.putInt("type", this.f1199a);
        r0.putInt("int1", this.f1203e);
        r0.putInt("int2", this.f);
        r0.putString("string1", this.k);
        ColorStateList r1 = this.g;
        if (r1 == null) goto L13;
        r0.putParcelable("tint_list", r1);
    L13:
        PorterDuff.Mode r5 = this.i;
        if (r5 == h) goto L16;
        r0.putString("tint_mode", r5.name());
    L16:
        return r0;
    L7:
        r0.putString("obj", (String) ZeusTransformUtils.preCheckCast(this.f1200b, String.class, "com.obric.aiagent.plugin"));
        goto L10
    L8:
        r0.putParcelable("obj", (Bitmap) ZeusTransformUtils.preCheckCast(this.f1200b, Bitmap.class, "com.obric.aiagent.plugin"));
        goto L10
    L9:
        r0.putParcelable("obj", (Parcelable) ZeusTransformUtils.preCheckCast(this.f1200b, Parcelable.class, "com.obric.aiagent.plugin"));
        goto L10
    L5:
        throw new IllegalArgumentException("Invalid icon");
    }

    public String toString() {
        if (this.f1199a == (-1)) goto L5;
        StringBuilder r0 = new StringBuilder("Icon(typ=").append(a(this.f1199a));
        switch(this.f1199a) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L14;
            case 6: goto L9;
            default: goto L16;
        };
    L9:
        r0.append(" uri=").append(this.f1200b);
        goto L16
    L10:
        r0.append(" len=").append(this.f1203e);
        if (this.f == 0) goto L16;
        r0.append(" off=").append(this.f);
        goto L16
    L13:
        r0.append(" pkg=").append(this.k).append(" id=").append(String.format("0x%08x", new Object[]{Integer.valueOf(b())}));
        goto L16
    L14:
        r0.append(" size=").append(((Bitmap) ZeusTransformUtils.preCheckCast(this.f1200b, Bitmap.class, "com.obric.aiagent.plugin")).getWidth()).append("x").append(((Bitmap) ZeusTransformUtils.preCheckCast(this.f1200b, Bitmap.class, "com.obric.aiagent.plugin")).getHeight());
    L16:
        if (this.g == null) goto L19;
        r0.append(" tint=");
        r0.append(this.g);
    L19:
        if (this.i == h) goto L21;
        r0.append(" mode=").append(this.i);
    L21:
        r0.append(")");
        return r0.toString();
    L5:
        return String.valueOf(this.f1200b);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void a(boolean r4) {
        this.j = this.i.name();
        switch(this.f1199a) {
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
        this.f1201c = this.f1200b.toString().getBytes(Charset.forName("UTF-16"));
        return;
    L6:
        this.f1201c = (byte[]) ZeusTransformUtils.preCheckCast(this.f1200b, byte[].class, "com.obric.aiagent.plugin");
        return;
    L7:
        this.f1201c = ((String) ZeusTransformUtils.preCheckCast(this.f1200b, String.class, "com.obric.aiagent.plugin")).getBytes(Charset.forName("UTF-16"));
        return;
    L8:
        if (r4 == false) goto L10;
        Bitmap r5 = (Bitmap) ZeusTransformUtils.preCheckCast(this.f1200b, Bitmap.class, "com.obric.aiagent.plugin");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r5.compress(Bitmap.CompressFormat.PNG, 90, r0);
        this.f1201c = r0.toByteArray();
        return;
    L10:
        this.f1202d = (Parcelable) ZeusTransformUtils.preCheckCast(this.f1200b, Parcelable.class, "com.obric.aiagent.plugin");
        return;
    L11:
        if (r4 == true) goto L14;
        this.f1202d = (Parcelable) ZeusTransformUtils.preCheckCast(this.f1200b, Parcelable.class, "com.obric.aiagent.plugin");
        return;
    L14:
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void g() {
        this.i = PorterDuff.Mode.valueOf(this.j);
        switch(this.f1199a) {
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
        this.f1200b = this.f1201c;
        return;
    L6:
        String r0 = new String(this.f1201c, Charset.forName("UTF-16"));
        this.f1200b = r0;
        if (this.f1199a == 2) goto L9;
        return;
    L9:
        if (this.k != null) goto L22;
        this.k = ((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin")).split(":", -1)[0];
        return;
    L22:
        return;
    L11:
        Parcelable r1 = this.f1202d;
        if (r1 == null) goto L14;
        this.f1200b = r1;
        return;
    L14:
        byte[] r2 = this.f1201c;
        this.f1200b = r2;
        this.f1199a = 3;
        this.f1203e = 0;
        this.f = r2.length;
        return;
    L15:
        Parcelable r3 = this.f1202d;
        if (r3 == null) goto L19;
        this.f1200b = r3;
        return;
    L19:
        throw new IllegalArgumentException("Invalid icon");
    }

    public static IconCompat a(Icon r0) {
        return a.b(r0);
    }

    static Bitmap a(Bitmap r9, boolean r10) {
        int r0 = (int) (Math.min(r9.getWidth(), r9.getHeight()) * 0.6666667f);
        Bitmap r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        Paint r3 = new Paint(3);
        float r4 = r0;
        float r5 = 0.5f * r4;
        float r6 = 0.9166667f * r5;
        if (r10 == false) goto L5;
        float r11 = 0.010416667f * r4;
        r3.setColor(0);
        r3.setShadowLayer(r11, 0.0f, r4 * 0.020833334f, 1023410176);
        r2.drawCircle(r5, r5, r6, r3);
        r3.setShadowLayer(r11, 0.0f, 0.0f, 503316480);
        r2.drawCircle(r5, r5, r6, r3);
        r3.clearShadowLayer();
    L5:
        r3.setColor(-16777216);
        BitmapShader r12 = new BitmapShader(r9, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix r7 = new Matrix();
        r7.setTranslate((-(r9.getWidth() - r0)) / 2.0f, (-(r9.getHeight() - r0)) / 2.0f);
        r12.setLocalMatrix(r7);
        r3.setShader(r12);
        r2.drawCircle(r5, r5, r6, r3);
        r2.setBitmap(null);
        return r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
