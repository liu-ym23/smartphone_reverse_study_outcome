package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    static final String EXTRA_INT1 = "int1";
    static final String EXTRA_INT2 = "int2";
    static final String EXTRA_OBJ = "obj";
    static final String EXTRA_STRING1 = "string1";
    static final String EXTRA_TINT_LIST = "tint_list";
    static final String EXTRA_TINT_MODE = "tint_mode";
    static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    Object mObj1;
    public Parcelable mParcelable;
    public String mString1;
    public ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    public String mTintModeStr;
    public int mType;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static IconCompat createFromIconInner(Object r100) {
            Preconditions.checkNotNull(r100);
            int r101 = getType(r100);
            if (r101 == 2) goto L15;
            if (r101 == 4) goto L13;
            if (r101 == 6) goto L11;
            IconCompat r102 = new IconCompat(-1);
            r102.mObj1 = r100;
            return r102;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r100));
        L13:
            return IconCompat.createWithContentUri(getUri(r100));
        L15:
            return IconCompat.createWithResource(null, getResPackage(r100), getResId(r100));
        }

        public static int getResId(Object r100) {
            if (Build.VERSION.SDK_INT < 28) goto L10;
            return Api28Impl.getResId(r100);
        L10:
            return ((Integer) r100.getClass().getMethod("getResId", new Class[0]).invoke(r100, new Object[0])).intValue();
        L9:
            return 0;
        }

        public static String getResPackage(Object r100) {
            if (Build.VERSION.SDK_INT < 28) goto L10;
            return Api28Impl.getResPackage(r100);
        L10:
            return (String) r100.getClass().getMethod("getResPackage", new Class[0]).invoke(r100, new Object[0]);
        L9:
            return null;
        }

        public static int getType(Object r100) {
            if (Build.VERSION.SDK_INT < 28) goto L15;
            return Api28Impl.getType(r100);
        L15:
            return ((Integer) r100.getClass().getMethod("getType", new Class[0]).invoke(r100, new Object[0])).intValue();
        L13:
            Objects.toString(r100);
            return -1;
        L9:
            Objects.toString(r100);
            return -1;
        L11:
            Objects.toString(r100);
            return -1;
        }

        public static Uri getUri(Object r100) {
            if (Build.VERSION.SDK_INT < 28) goto L10;
            return Api28Impl.getUri(r100);
        L10:
            return (Uri) r100.getClass().getMethod("getUri", new Class[0]).invoke(r100, new Object[0]);
        L9:
            return null;
        }

        public static IconCompat createFromIcon(Context r100, Icon r101) {
            int r102 = getType(r101);
            if (r102 != 2) goto L5;
            String r103 = getResPackage(r101);
            return IconCompat.createWithResource(IconCompat.getResources(r100, r103), r103, getResId(r101));
        L18:
            throw new IllegalArgumentException("Icon resource cannot be found");
        L5:
            if (r102 == 4) goto L13;
            if (r102 == 6) goto L11;
            IconCompat r104 = new IconCompat(-1);
            r104.mObj1 = r101;
            return r104;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r101));
        L13:
            return IconCompat.createWithContentUri(getUri(r101));
        }

        public static Drawable loadDrawable(Icon r100, Context r101) {
            return r100.loadDrawable(r101);
        }

        public static Icon toIcon(IconCompat r100, Context r101) {
            switch(r100.mType) {
                case -1: goto L35;
                case 0: goto L5;
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L20;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            int r102 = Build.VERSION.SDK_INT;
            if (r102 < 30) goto L9;
            Icon r103 = Api30Impl.createWithAdaptiveBitmapContentUri(r100.getUri());
        L27:
            ColorStateList r104 = r100.mTintList;
            if (r104 == null) goto L30;
            r103.setTintList(r104);
        L30:
            PorterDuff.Mode r105 = r100.mTintMode;
            if (r105 == IconCompat.DEFAULT_TINT_MODE) goto L33;
            r103.setTintMode(r105);
        L33:
            return r103;
        L9:
            if (r101 == null) goto L18;
            InputStream r106 = r100.getUriInputStream(r101);
            if (r106 == null) goto L16;
            if (r102 < 26) goto L14;
            r103 = Api26Impl.createWithAdaptiveBitmap(BitmapFactory.decodeStream(r106));
            goto L27
        L14:
            r103 = Icon.createWithBitmap(IconCompat.createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(r106), false));
            goto L27
        L16:
            throw new IllegalStateException("Cannot load adaptive icon from uri: " + r100.getUri());
        L18:
            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + r100.getUri());
        L23:
            r103 = Icon.createWithContentUri((String) r100.mObj1);
            goto L27
        L24:
            r103 = Icon.createWithData((byte[]) r100.mObj1, r100.mInt1, r100.mInt2);
            goto L27
        L25:
            r103 = Icon.createWithResource(r100.getResPackage(), r100.mInt1);
            goto L27
        L26:
            r103 = Icon.createWithBitmap((Bitmap) r100.mObj1);
            goto L27
        L5:
            throw new IllegalArgumentException("Unknown type");
        L20:
            if (Build.VERSION.SDK_INT < 26) goto L22;
            r103 = Api26Impl.createWithAdaptiveBitmap((Bitmap) r100.mObj1);
            goto L27
        L22:
            r103 = Icon.createWithBitmap(IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap) r100.mObj1, false));
            goto L27
        L35:
            return (Icon) r100.mObj1;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Icon createWithAdaptiveBitmap(Bitmap r100) {
            return Icon.createWithAdaptiveBitmap(r100);
        }

        public static Drawable createAdaptiveIconDrawable(Drawable r100, Drawable r101) {
            return new AdaptiveIconDrawable(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static int getResId(Object r100) {
            return ((Icon) r100).getResId();
        }

        public static String getResPackage(Object r100) {
            return ((Icon) r100).getResPackage();
        }

        public static int getType(Object r100) {
            return ((Icon) r100).getType();
        }

        public static Uri getUri(Object r100) {
            return ((Icon) r100).getUri();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static Icon createWithAdaptiveBitmapContentUri(Uri r100) {
            return Icon.createWithAdaptiveBitmapContentUri(r100);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    private static String typeToString(int r100) {
        switch(r100) {
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

    public Icon toIcon() {
        return toIcon(null);
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public Bitmap getBitmap() {
        int r100 = this.mType;
        if (r100 != (-1)) goto L13;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Object r101 = this.mObj1;
        if ((r101 instanceof Bitmap) == true) goto L9;
        return null;
    L9:
        return (Bitmap) r101;
    L13:
        if (r100 != 1) goto L17;
        return (Bitmap) this.mObj1;
    L17:
        if (r100 != 5) goto L21;
        return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
    L21:
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int getResId() {
        int r100 = this.mType;
        if (r100 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResId(this.mObj1);
    L9:
        if (r100 != 2) goto L13;
        return this.mInt1;
    L13:
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String getResPackage() {
        int r100 = this.mType;
        if (r100 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getResPackage(this.mObj1);
    L9:
        if (r100 != 2) goto L20;
        String r101 = this.mString1;
        if (r101 == null) goto L18;
        if (TextUtils.isEmpty(r101) == true) goto L18;
        return this.mString1;
    L18:
        return ((String) this.mObj1).split(":", -1)[0];
    L20:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int r100 = this.mType;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return r100;
    L7:
        return Api23Impl.getType(this.mObj1);
    }

    public Uri getUri() {
        int r100 = this.mType;
        if (r100 != (-1)) goto L9;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        return Api23Impl.getUri(this.mObj1);
    L9:
        if (r100 == 4) goto L16;
        if (r100 == 6) goto L16;
        throw new IllegalStateException("called getUri() on " + this);
    L16:
        return UriProtector.parse((String) this.mObj1);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch(this.mType) {
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
        this.mObj1 = this.mData;
        return;
    L6:
        String r100 = new String(this.mData, Charset.forName("UTF-16"));
        this.mObj1 = r100;
        if (this.mType == 2) goto L9;
        return;
    L9:
        if (this.mString1 != null) goto L22;
        this.mString1 = r100.split(":", -1)[0];
        return;
    L22:
        return;
    L11:
        Parcelable r101 = this.mParcelable;
        if (r101 == null) goto L14;
        this.mObj1 = r101;
        return;
    L14:
        byte[] r102 = this.mData;
        this.mObj1 = r102;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = r102.length;
        return;
    L15:
        Parcelable r103 = this.mParcelable;
        if (r103 == null) goto L19;
        this.mObj1 = r103;
        return;
    L19:
        throw new IllegalArgumentException("Invalid icon");
    }

    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        switch(this.mType) {
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
        r100.putByteArray("obj", (byte[]) this.mObj1);
    L10:
        r100.putInt("type", this.mType);
        r100.putInt(EXTRA_INT1, this.mInt1);
        r100.putInt(EXTRA_INT2, this.mInt2);
        r100.putString(EXTRA_STRING1, this.mString1);
        ColorStateList r101 = this.mTintList;
        if (r101 == null) goto L13;
        r100.putParcelable(EXTRA_TINT_LIST, r101);
    L13:
        PorterDuff.Mode r102 = this.mTintMode;
        if (r102 == DEFAULT_TINT_MODE) goto L16;
        r100.putString(EXTRA_TINT_MODE, r102.name());
    L16:
        return r100;
    L7:
        r100.putString("obj", (String) this.mObj1);
        goto L10
    L8:
        r100.putParcelable("obj", (Bitmap) this.mObj1);
        goto L10
    L9:
        r100.putParcelable("obj", (Parcelable) this.mObj1);
        goto L10
    L5:
        throw new IllegalArgumentException("Invalid icon");
    }

    public String toString() {
        if (this.mType == (-1)) goto L5;
        StringBuilder r100 = new StringBuilder("Icon(typ=");
        r100.append(typeToString(this.mType));
        switch(this.mType) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L14;
            case 6: goto L9;
            default: goto L16;
        };
    L9:
        r100.append(" uri=");
        r100.append(this.mObj1);
        goto L16
    L10:
        r100.append(" len=");
        r100.append(this.mInt1);
        if (this.mInt2 == 0) goto L16;
        r100.append(" off=");
        r100.append(this.mInt2);
        goto L16
    L13:
        r100.append(" pkg=");
        r100.append(this.mString1);
        r100.append(" id=");
        r100.append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
        goto L16
    L14:
        r100.append(" size=");
        r100.append(((Bitmap) this.mObj1).getWidth());
        r100.append("x");
        r100.append(((Bitmap) this.mObj1).getHeight());
    L16:
        if (this.mTintList == null) goto L19;
        r100.append(" tint=");
        r100.append(this.mTintList);
    L19:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L21;
        r100.append(" mode=");
        r100.append(this.mTintMode);
    L21:
        r100.append(")");
        return r100.toString();
    L5:
        return String.valueOf(this.mObj1);
    }

    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    public IconCompat(int r100) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = r100;
    }

    public static IconCompat createFromBundle(Bundle r100) {
        int r101 = r100.getInt("type");
        IconCompat r102 = new IconCompat(r101);
        r102.mInt1 = r100.getInt(EXTRA_INT1);
        r102.mInt2 = r100.getInt(EXTRA_INT2);
        r102.mString1 = r100.getString(EXTRA_STRING1);
        if (r100.containsKey(EXTRA_TINT_LIST) == false) goto L6;
        r102.mTintList = (ColorStateList) r100.getParcelable(EXTRA_TINT_LIST);
    L6:
        if (r100.containsKey(EXTRA_TINT_MODE) == false) goto L9;
        r102.mTintMode = PorterDuff.Mode.valueOf(r100.getString(EXTRA_TINT_MODE));
    L9:
        switch(r101) {
            case -1: goto L14;
            case 0: goto L11;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L13;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L11;
        };
    L12:
        r102.mObj1 = r100.getByteArray("obj");
    L15:
        return r102;
    L13:
        r102.mObj1 = r100.getString("obj");
        goto L15
    L14:
        r102.mObj1 = r100.getParcelable("obj");
        goto L15
    L11:
        return null;
    }

    public static IconCompat createFromIcon(Icon r100) {
        return Api23Impl.createFromIconInner(r100);
    }

    public static IconCompat createFromIconOrNullIfZeroResId(Icon r100) {
        if (Api23Impl.getType(r100) != 2) goto L9;
        if (Api23Impl.getResId(r100) != 0) goto L9;
        return null;
    L9:
        return Api23Impl.createFromIconInner(r100);
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap r100) {
        ObjectsCompat.requireNonNull(r100);
        IconCompat r101 = new IconCompat(5);
        r101.mObj1 = r100;
        return r101;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(Uri r100) {
        ObjectsCompat.requireNonNull(r100);
        return createWithAdaptiveBitmapContentUri(r100.toString());
    }

    public static IconCompat createWithBitmap(Bitmap r100) {
        ObjectsCompat.requireNonNull(r100);
        IconCompat r101 = new IconCompat(1);
        r101.mObj1 = r100;
        return r101;
    }

    public static IconCompat createWithContentUri(Uri r100) {
        ObjectsCompat.requireNonNull(r100);
        return createWithContentUri(r100.toString());
    }

    private Drawable loadDrawableInner(Context r100) {
        switch(this.mType) {
            case 1: goto L29;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L5;
            default: goto L30;
        };
    L5:
        InputStream r101 = getUriInputStream(r100);
        if (r101 == null) goto L30;
        if (Build.VERSION.SDK_INT < 26) goto L12;
        return Api26Impl.createAdaptiveIconDrawable(null, new BitmapDrawable(r100.getResources(), BitmapFactory.decodeStream(r101)));
    L12:
        return new BitmapDrawable(r100.getResources(), createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(r101), false));
    L15:
        InputStream r102 = getUriInputStream(r100);
        if (r102 == null) goto L30;
        return new BitmapDrawable(r100.getResources(), BitmapFactory.decodeStream(r102));
    L21:
        String r103 = getResPackage();
        if (TextUtils.isEmpty(r103) == false) goto L31;
        r103 = r100.getPackageName();
    L31:
        return ResourcesCompat.getDrawable(getResources(r100, r103), this.mInt1, r100.getTheme());
    L27:
        String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1});
    L30:
        return null;
    L14:
        return new BitmapDrawable(r100.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
    L20:
        return new BitmapDrawable(r100.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
    L29:
        return new BitmapDrawable(r100.getResources(), (Bitmap) this.mObj1);
    }

    public void checkResource(Context r100) {
        if (this.mType != 2) goto L16;
        Object r101 = this.mObj1;
        if (r101 == null) goto L17;
        String r102 = (String) r101;
        if (r102.contains(":") == true) goto L9;
        return;
    L9:
        String r103 = r102.split(":", -1)[1];
        String r104 = r103.split(HTTP.URL_DEFAULT, -1)[0];
        String r105 = r103.split(HTTP.URL_DEFAULT, -1)[1];
        String r106 = r102.split(":", -1)[0];
        if ("0_resource_name_obfuscated".equals(r105) == false) goto L12;
        return;
    L12:
        int r107 = getResources(r100, getResPackage()).getIdentifier(r105, r104, r106);
        if (this.mInt1 == r107) goto L18;
        this.mInt1 = r107;
        return;
    L18:
        return;
    L17:
        return;
    }

    public InputStream getUriInputStream(Context r100) {
        Uri r101 = getUri();
        String r102 = r101.getScheme();
        if ("content".equals(r102) == false) goto L5;
    L17:
        return r100.getContentResolver().openInputStream(r101);
    L12:
        r101.toString();
        return null;
    L5:
        if ("file".equals(r102) == true) goto L17;
        return new FileInputStream(new File((String) this.mObj1));
    L9:
        r101.toString();
        return null;
    }

    public Drawable loadDrawable(Context r100) {
        checkResource(r100);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Drawable r101 = loadDrawableInner(r100);
        if (r101 != null) goto L9;
    L13:
        return r101;
    L9:
        if (this.mTintList == null) goto L11;
    L12:
        r101.mutate();
        DrawableCompat.setTintList(r101, this.mTintList);
        DrawableCompat.setTintMode(r101, this.mTintMode);
        goto L13
    L11:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L13;
    L5:
        return Api23Impl.loadDrawable(toIcon(r100), r100);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean r100) {
        this.mTintModeStr = this.mTintMode.name();
        switch(this.mType) {
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
        this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
        return;
    L6:
        this.mData = (byte[]) this.mObj1;
        return;
    L7:
        this.mData = ((String) this.mObj1).getBytes(Charset.forName("UTF-16"));
        return;
    L8:
        if (r100 == false) goto L10;
        Bitmap r101 = (Bitmap) this.mObj1;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        r101.compress(Bitmap.CompressFormat.PNG, 90, r102);
        this.mData = r102.toByteArray();
        return;
    L10:
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L11:
        if (r100 == true) goto L14;
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L14:
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    public IconCompat setTint(int r100) {
        return setTintList(ColorStateList.valueOf(r100));
    }

    public IconCompat setTintList(ColorStateList r100) {
        this.mTintList = r100;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode r100) {
        this.mTintMode = r100;
        return this;
    }

    public Icon toIcon(Context r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.toIcon(this, r100);
    L7:
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String r100) {
        ObjectsCompat.requireNonNull(r100);
        IconCompat r101 = new IconCompat(6);
        r101.mObj1 = r100;
        return r101;
    }

    public static IconCompat createWithContentUri(String r100) {
        ObjectsCompat.requireNonNull(r100);
        IconCompat r101 = new IconCompat(4);
        r101.mObj1 = r100;
        return r101;
    }

    public static IconCompat createFromIcon(Context r100, Icon r101) {
        Preconditions.checkNotNull(r101);
        return Api23Impl.createFromIcon(r100, r101);
    }

    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap r100, boolean r110) {
        int r101 = (int) (Math.min(r100.getWidth(), r100.getHeight()) * 0.6666667f);
        Bitmap r102 = Bitmap.createBitmap(r101, r101, Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint(3);
        float r105 = r101;
        float r106 = 0.5f * r105;
        float r107 = ICON_DIAMETER_FACTOR * r106;
        if (r110 == false) goto L5;
        float r111 = BLUR_FACTOR * r105;
        r104.setColor(0);
        r104.setShadowLayer(r111, 0.0f, r105 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
        r103.drawCircle(r106, r106, r107, r104);
        r104.setShadowLayer(r111, 0.0f, 0.0f, 503316480);
        r103.drawCircle(r106, r106, r107, r104);
        r104.clearShadowLayer();
    L5:
        r104.setColor(-16777216);
        Shader.TileMode r108 = Shader.TileMode.CLAMP;
        BitmapShader r112 = new BitmapShader(r100, r108, r108);
        Matrix r109 = new Matrix();
        r109.setTranslate((-(r100.getWidth() - r101)) / 2.0f, (-(r100.getHeight() - r101)) / 2.0f);
        r112.setLocalMatrix(r109);
        r104.setShader(r112);
        r103.drawCircle(r106, r106, r107, r104);
        r103.setBitmap(null);
        return r102;
    }

    public static IconCompat createWithResource(Context r100, int r101) {
        ObjectsCompat.requireNonNull(r100);
        return createWithResource(r100.getResources(), r100.getPackageName(), r101);
    }

    public static Resources getResources(Context r100, String r101) {
        if ("android".equals(r101) == true) goto L5;
        PackageManager r102 = r100.getPackageManager();
        ApplicationInfo r103 = r102.getApplicationInfo(r101, 8192);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r103 == null) goto L11;
        return r102.getResourcesForApplication(r103);
    L11:
        return null;
    L12:
        String.format("Unable to find pkg=%s for icon", new Object[]{r101});
        return null;
    L5:
        return Resources.getSystem();
    }

    public static IconCompat createWithData(byte[] r100, int r101, int r102) {
        ObjectsCompat.requireNonNull(r100);
        IconCompat r103 = new IconCompat(3);
        r103.mObj1 = r100;
        r103.mInt1 = r101;
        r103.mInt2 = r102;
        return r103;
    }

    public static IconCompat createWithResource(Resources r100, String r101, int r102) {
        ObjectsCompat.requireNonNull(r101);
        if (r102 == 0) goto L14;
        IconCompat r103 = new IconCompat(2);
        r103.mInt1 = r102;
        if (r100 != null) goto L15;
        r103.mObj1 = r101;
    L11:
        r103.mString1 = r101;
        return r103;
    L15:
        r103.mObj1 = r100.getResourceName(r102);     // Catch: Resources.NotFoundException -> L8
    L9:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L14:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public void addToShortcutIntent(Intent r100, Drawable r101, Context r102) {
        checkResource(r102);
        int r103 = this.mType;
        if (r103 != 1) goto L5;
        Bitmap r104 = (Bitmap) this.mObj1;
        if (r101 == null) goto L30;
        r104 = r104.copy(r104.getConfig(), true);
    L30:
        if (r101 == null) goto L32;
        int r105 = r104.getWidth();
        int r106 = r104.getHeight();
        r101.setBounds(r105 / 2, r106 / 2, r105, r106);
        r101.draw(new Canvas(r104));
    L32:
        r100.putExtra("android.intent.extra.shortcut.ICON", r104);
        return;
    L5:
        if (r103 != 2) goto L7;
        Context r107 = r102.createPackageContext(getResPackage(), 0);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r101 != null) goto L15;
        r100.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(r107, this.mInt1));     // Catch: PackageManager.NameNotFoundException -> L24
        return;
    L15:
        Drawable r108 = ContextCompat.getDrawable(r107, this.mInt1);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r108.getIntrinsicWidth() > 0) goto L18;
    L21:
        int r109 = ((ActivityManager) r107.getSystemService("activity")).getLauncherLargeIconSize();     // Catch: PackageManager.NameNotFoundException -> L24
        r104 = Bitmap.createBitmap(r109, r109, Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L22:
        r108.setBounds(0, 0, r104.getWidth(), r104.getHeight());     // Catch: PackageManager.NameNotFoundException -> L24
        r108.draw(new Canvas(r104));     // Catch: PackageManager.NameNotFoundException -> L24
        goto L30
    L18:
        if (r108.getIntrinsicHeight() <= 0) goto L21;
        r104 = Bitmap.createBitmap(r108.getIntrinsicWidth(), r108.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L24:
        e = move-exception;
        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
    L7:
        if (r103 != 5) goto L10;
        r104 = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        goto L30
    L10:
        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    }
}
