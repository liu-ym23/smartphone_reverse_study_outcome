package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourcesCompat {
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock = null;
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = null;
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Drawable getDrawable(Resources r100, int r101, Resources.Theme r102) {
            return r100.getDrawable(r101, r102);
        }

        public static Drawable getDrawableForDensity(Resources r100, int r101, int r102, Resources.Theme r103) {
            return r100.getDrawableForDensity(r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static int getColor(Resources r100, int r101, Resources.Theme r102) {
            return r100.getColor(r101, r102);
        }

        public static ColorStateList getColorStateList(Resources r100, int r101, Resources.Theme r102) {
            return r100.getColorStateList(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static float getFloat(Resources r100, int r101) {
            return r100.getFloat(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        public ColorStateListCacheEntry(ColorStateList r100, Configuration r101, Resources.Theme r102) {
            this.mValue = r100;
            this.mConfiguration = r101;
            if (r102 != null) goto L5;
            int r103 = 0;
        L6:
            this.mThemeHash = r103;
            return;
        L5:
            r103 = r102.hashCode();
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mResources, this.mTheme});
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (ColorStateListCacheKey.class != r100.getClass()) goto L17;
            ColorStateListCacheKey r101 = (ColorStateListCacheKey) r100;
            if (this.mResources.equals(r101.mResources) == true) goto L13;
        L15:
            return false;
        L13:
            if (ObjectsCompat.equals(this.mTheme, r101.mTheme) == false) goto L15;
            return true;
        }

        public ColorStateListCacheKey(Resources r100, Resources.Theme r101) {
            this.mResources = r100;
            this.mTheme = r101;
        }
    }

    public static abstract class FontCallback {
        public FontCallback() {
        }

        public static /* synthetic */ void a(FontCallback r100, int r101) {
            r100.lambda$callbackFailAsync$1(r101);
        }

        public static /* synthetic */ void b(FontCallback r100, Typeface r101) {
            r100.lambda$callbackSuccessAsync$0(r101);
        }

        public abstract void onFontRetrievalFailed(int r100);

        public abstract void onFontRetrieved(Typeface r100);

        public static Handler getHandler(Handler r100) {
            if (r100 == null) goto L4;
            return r100;
        L4:
            return new Handler(Looper.getMainLooper());
        }

        private /* synthetic */ void lambda$callbackFailAsync$1(int r100) {
            onFontRetrievalFailed(r100);
        }

        private /* synthetic */ void lambda$callbackSuccessAsync$0(Typeface r100) {
            onFontRetrieved(r100);
        }

        public final void callbackFailAsync(final int r100, Handler r101) {
            getHandler(r101).post(new b(this, r100));
        }

        public final void callbackSuccessAsync(final Typeface r100, Handler r101) {
            getHandler(r101).post(new a(this, r100));
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final class ThemeCompat {

        public static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = null;

            static {
                sRebaseMethodLock = new Object();
            }

            private Api23Impl() {
            }

            public static void rebase(Resources.Theme r100) {
                Object r101 = sRebaseMethodLock;
                monitor-enter(r101);
            L18:
                th = move-exception;
                throw th;
            L6:
                if (sRebaseMethodFetched == false) goto L24;
            L10:
                Method r102 = sRebaseMethod;     // Catch: Throwable -> L18
                if (r102 != null) goto L22;
            L16:
                monitor-exit(r101);     // Catch: Throwable -> L18
                return;
            L22:
                r102.invoke(r100, new Object[0]);     // Catch: Throwable -> L14 Throwable -> L18
            L15:
                sRebaseMethod = null;     // Catch: Throwable -> L18
                goto L16
            L24:
                Method r103 = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);     // Catch: NoSuchMethodException -> L21 Throwable -> L18
                sRebaseMethod = r103;     // Catch: NoSuchMethodException -> L21 Throwable -> L18
                r103.setAccessible(true);     // Catch: NoSuchMethodException -> L21 Throwable -> L18
            L9:
                sRebaseMethodFetched = true;     // Catch: Throwable -> L18
                goto L10
            }
        }

        public static class Api29Impl {
            private Api29Impl() {
            }

            public static void rebase(Resources.Theme r100) {
                r100.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(Resources.Theme r100) {
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 29) goto L6;
            Api29Impl.rebase(r100);
            return;
        L6:
            if (r101 < 23) goto L10;
            Api23Impl.rebase(r100);
            return;
        }
    }

    static {
        sTempTypedValue = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r100 = sTempTypedValue;
        TypedValue r101 = r100.get();
        if (r101 != null) goto L6;
        TypedValue r102 = new TypedValue();
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    private ResourcesCompat() {
    }

    public static void clearCachesForTheme(Resources.Theme r100) {
        Object r101 = sColorStateCacheLock;
        monitor-enter(r101);
        Iterator<ColorStateListCacheKey> r102 = sColorStateCaches.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L12;
        ColorStateListCacheKey r103 = r102.next();     // Catch: Throwable -> L14
        if (r103 == null) goto L6;
        if (r100.equals(r103.mTheme) == false) goto L6;
        r102.remove();     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static ColorStateList getCachedColorStateList(ColorStateListCacheKey r100, int r101) {
        Object r102 = sColorStateCacheLock;
        monitor-enter(r102);
        SparseArray<ColorStateListCacheEntry> r103 = sColorStateCaches.get(r100);     // Catch: Throwable -> L26
        if (r103 != null) goto L7;
    L23:
        monitor-exit(r102);     // Catch: Throwable -> L26
        return null;
    L7:
        if (r103.size() <= 0) goto L23;
        ColorStateListCacheEntry r104 = r103.get(r101);     // Catch: Throwable -> L26
        if (r104 == null) goto L23;
        if (r104.mConfiguration.equals(r100.mResources.getConfiguration()) == false) goto L22;
        Resources.Theme r105 = r100.mTheme;     // Catch: Throwable -> L26
        if (r105 == null) goto L15;
    L16:
        if (r105 == null) goto L22;
        if (r104.mThemeHash != r105.hashCode()) goto L22;
    L19:
        ColorStateList r106 = r104.mValue;     // Catch: Throwable -> L26
        monitor-exit(r102);     // Catch: Throwable -> L26
        return r106;
    L15:
        if (r104.mThemeHash == 0) goto L19;
    L22:
        r103.remove(r101);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static Typeface getCachedFont(Context r100, int r101) throws Resources.NotFoundException {
        if (r100.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r100, r101, new TypedValue(), 0, null, null, false, true);
    }

    public static float getFloat(Resources r100, int r101) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        TypedValue r102 = getTypedValue();
        r100.getValue(r101, r102, true);
        if (r102.type != 4) goto L11;
        return r102.getFloat();
    L11:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r101) + " type #0x" + Integer.toHexString(r102.type) + " is not valid");
    L5:
        return Api29Impl.getFloat(r100, r101);
    }

    public static Typeface getFont(Context r100, int r101) throws Resources.NotFoundException {
        if (r100.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r100, r101, new TypedValue(), 0, null, null, false, false);
    }

    private static boolean isColorInt(Resources r100, int r101) {
        TypedValue r102 = getTypedValue();
        r100.getValue(r101, r102, true);
        int r103 = r102.type;
        if (r103 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r103 > 31) goto L7;
        return true;
    }

    public static int getColor(Resources r100, int r101, Resources.Theme r102) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getColor(r100, r101, r102);
    L7:
        return r100.getColor(r101);
    }

    public static ColorStateList getColorStateList(Resources r100, int r101, Resources.Theme r102) throws Resources.NotFoundException {
        ColorStateListCacheKey r103 = new ColorStateListCacheKey(r100, r102);
        ColorStateList r104 = getCachedColorStateList(r103, r101);
        if (r104 == null) goto L5;
        return r104;
    L5:
        ColorStateList r105 = inflateColorStateList(r100, r101, r102);
        if (r105 == null) goto L10;
        addColorStateListToCache(r103, r101, r105, r102);
        return r105;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        return Api23Impl.getColorStateList(r100, r101, r102);
    L14:
        return r100.getColorStateList(r101);
    }

    public static Drawable getDrawable(Resources r100, int r101, Resources.Theme r102) throws Resources.NotFoundException {
        return Api21Impl.getDrawable(r100, r101, r102);
    }

    private static ColorStateList inflateColorStateList(Resources r100, int r101, Resources.Theme r102) {
        if (isColorInt(r100, r101) == false) goto L9;
        return null;
    L9:
        return ColorStateListInflaterCompat.createFromXml(r100, r100.getXml(r101), r102);
    L8:
        return null;
    }

    private static void addColorStateListToCache(ColorStateListCacheKey r100, int r101, ColorStateList r102, Resources.Theme r103) {
        Object r104 = sColorStateCacheLock;
        monitor-enter(r104);
        WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> r105 = sColorStateCaches;     // Catch: Throwable -> L10
        SparseArray<ColorStateListCacheEntry> r106 = r105.get(r100);     // Catch: Throwable -> L10
        if (r106 != null) goto L7;
        r106 = new SparseArray();     // Catch: Throwable -> L10
        r105.put(r100, r106);     // Catch: Throwable -> L10
    L7:
        r106.append(r101, new ColorStateListCacheEntry(r102, r100.mResources.getConfiguration(), r103));     // Catch: Throwable -> L10
        monitor-exit(r104);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static Drawable getDrawableForDensity(Resources r100, int r101, int r102, Resources.Theme r103) throws Resources.NotFoundException {
        return Api21Impl.getDrawableForDensity(r100, r101, r102, r103);
    }

    public static void getFont(Context r100, int r101, FontCallback r110, Handler r111) throws Resources.NotFoundException {
        Preconditions.checkNotNull(r110);
        if (r100.isRestricted() == false) goto L6;
        r110.callbackFailAsync(-4, r111);
        return;
    L6:
        loadFont(r100, r101, new TypedValue(), 0, r110, r111, false, false);
    }

    public static Typeface getFont(Context r100, int r101, TypedValue r110, int r111, FontCallback r112) throws Resources.NotFoundException {
        if (r100.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r100, r101, r110, r111, r112, null, true, false);
    }

    private static Typeface loadFont(Context r110, int r111, TypedValue r112, int r113, FontCallback r114, Handler r115, boolean r116, boolean r117) {
        Resources r100 = r110.getResources();
        r100.getValue(r111, r112, true);
        Typeface r101 = loadFont(r110, r100, r112, r111, r113, r114, r115, r116, r117);
        if (r101 != null) goto L9;
        if (r114 != null) goto L9;
        if (r117 == true) goto L9;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r111) + " could not be retrieved.");
    L9:
        return r101;
    }

    private static Typeface loadFont(Context r110, Resources r111, TypedValue r112, int r113, int r114, FontCallback r115, Handler r210, boolean r211, boolean r212) {
        CharSequence r100 = r112.string;
        if (r100 == null) goto L37;
        String r101 = r100.toString();
        if (r101.startsWith("res/") == true) goto L9;
        if (r115 == null) goto L8;
        r115.callbackFailAsync(-3, r210);
    L8:
        return null;
    L9:
        Typeface r102 = TypefaceCompat.findFromCache(r111, r113, r101, r112.assetCookie, r114);
        if (r102 == null) goto L14;
        if (r115 == null) goto L13;
        r115.callbackSuccessAsync(r102, r210);
    L13:
        return r102;
    L14:
        if (r212 == false) goto L38;
        return null;
    L38:
        if (r101.toLowerCase().endsWith(".xml") == false) goto L25;
        FontResourcesParserCompat.FamilyResourceEntry r103 = FontResourcesParserCompat.parse(r111.getXml(r113), r111);     // Catch: IOException -> L31 XmlPullParserException -> L32
        if (r103 != null) goto L24;
        if (r115 == null) goto L22;
        r115.callbackFailAsync(-3, r210);     // Catch: IOException -> L31 XmlPullParserException -> L32
    L22:
        return null;
    L24:
        return TypefaceCompat.createFromResourcesFamilyXml(r110, r103, r111, r113, r101, r112.assetCookie, r114, r115, r210, r211);
    L25:
        Typeface r104 = TypefaceCompat.createFromResourcesFontFile(r110, r111, r113, r101, r112.assetCookie, r114);     // Catch: IOException -> L31 XmlPullParserException -> L32
        if (r115 == null) goto L30;
        if (r104 == null) goto L29;
        r115.callbackSuccessAsync(r104, r210);     // Catch: IOException -> L31 XmlPullParserException -> L32
        goto L30
    L29:
        r115.callbackFailAsync(-3, r210);     // Catch: IOException -> L31 XmlPullParserException -> L32
    L30:
        return r104;
    L33:
        if (r115 == null) goto L35;
        r115.callbackFailAsync(-3, r210);
    L35:
        return null;
    L37:
        throw new Resources.NotFoundException("Resource \"" + r111.getResourceName(r113) + "\" (" + Integer.toHexString(r113) + ") is not a Font: " + r112);
    }
}
