package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class AppCompatResources {
    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = null;
    private static final Object sColorStateCacheLock = null;
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = null;

    /* JADX INFO: loaded from: classes2.dex */
    public static class ColorStateListCacheEntry {
        final Configuration configuration;
        final ColorStateList value;

        public ColorStateListCacheEntry(ColorStateList r100, Configuration r101) {
            this.value = r100;
            this.configuration = r101;
        }
    }

    private AppCompatResources() {
    }

    static {
        TL_TYPED_VALUE = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r100 = TL_TYPED_VALUE;
        TypedValue r101 = r100.get();
        if (r101 != null) goto L6;
        TypedValue r102 = new TypedValue();
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    private static ColorStateList getCachedColorStateList(Context r100, int r101) {
        Object r102 = sColorStateCacheLock;
        monitor-enter(r102);
        SparseArray<ColorStateListCacheEntry> r103 = sColorStateCaches.get(r100);     // Catch: Throwable -> L19
        if (r103 != null) goto L7;
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return null;
    L7:
        if (r103.size() <= 0) goto L16;
        ColorStateListCacheEntry r104 = r103.get(r101);     // Catch: Throwable -> L19
        if (r104 == null) goto L16;
        if (r104.configuration.equals(r100.getResources().getConfiguration()) == false) goto L15;
        ColorStateList r105 = r104.value;     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        return r105;
    L15:
        r103.remove(r101);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static ColorStateList getColorStateList(Context r100, int r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        ColorStateList r102 = getCachedColorStateList(r100, r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        ColorStateList r103 = inflateColorStateList(r100, r101);
        if (r103 == null) goto L14;
        addColorStateListToCache(r100, r101, r103);
        return r103;
    L14:
        return ContextCompat.getColorStateList(r100, r101);
    L5:
        return r100.getColorStateList(r101);
    }

    public static Drawable getDrawable(Context r100, int r101) {
        return ResourceManagerInternal.get().getDrawable(r100, r101);
    }

    private static ColorStateList inflateColorStateList(Context r100, int r101) {
        if (isColorInt(r100, r101) == false) goto L5;
        return null;
    L5:
        Resources r102 = r100.getResources();
        XmlResourceParser r103 = r102.getXml(r101);
        return ColorStateListInflaterCompat.createFromXml(r102, r103, r100.getTheme());
    L8:
        return null;
    }

    private static boolean isColorInt(Context r100, int r101) {
        Resources r102 = r100.getResources();
        TypedValue r103 = getTypedValue();
        r102.getValue(r101, r103, true);
        int r104 = r103.type;
        if (r104 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r104 > 31) goto L7;
        return true;
    }

    private static void addColorStateListToCache(Context r100, int r101, ColorStateList r102) {
        Object r103 = sColorStateCacheLock;
        monitor-enter(r103);
        WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> r104 = sColorStateCaches;     // Catch: Throwable -> L10
        SparseArray<ColorStateListCacheEntry> r105 = r104.get(r100);     // Catch: Throwable -> L10
        if (r105 != null) goto L7;
        r105 = new SparseArray();     // Catch: Throwable -> L10
        r104.put(r100, r105);     // Catch: Throwable -> L10
    L7:
        r105.append(r101, new ColorStateListCacheEntry(r102, r100.getResources().getConfiguration()));     // Catch: Throwable -> L10
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
