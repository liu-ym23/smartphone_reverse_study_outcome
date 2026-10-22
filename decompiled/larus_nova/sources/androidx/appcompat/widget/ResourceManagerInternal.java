package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import el9.a;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceManagerInternal {
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = null;
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = null;
    private static ResourceManagerInternal INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, InflateDelegate> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches;
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    /* JADX INFO: loaded from: classes2.dex */
    public static class AsldcInflateDelegate implements InflateDelegate {
        public AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) {
            return AnimatedStateListDrawableCompat.createFromXmlInner(r100, r100.getResources(), r101, r102, r103);
        L4:
            return null;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class AvdcInflateDelegate implements InflateDelegate {
        public AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) {
            return AnimatedVectorDrawableCompat.createFromXmlInner(r100, r100.getResources(), r101, r102, r103);
        L4:
            return null;
        }
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int r100) {
            super(r100);
        }

        private static int generateCacheKey(int r100, PorterDuff.Mode r101) {
            return ((r100 + 31) * 31) + r101.hashCode();
        }

        public PorterDuffColorFilter get(int r100, PorterDuff.Mode r101) {
            return get(Integer.valueOf(generateCacheKey(r100, r101)));
        }

        public PorterDuffColorFilter put(int r100, PorterDuff.Mode r101, PorterDuffColorFilter r102) {
            return put(Integer.valueOf(generateCacheKey(r100, r101)), r102);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class DrawableDelegate implements InflateDelegate {
        public DrawableDelegate() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_androidx_appcompat_widget_ResourceManagerInternal$DrawableDelegate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) {
            String r104 = r102.getClassAttribute();
            if (r104 != null) goto L8;
        L6:
            return null;
        L8:
            Drawable r105 = (Drawable) INVOKEVIRTUAL_androidx_appcompat_widget_ResourceManagerInternal$DrawableDelegate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(DrawableDelegate.class.getClassLoader(), r104).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L7
            r105.inflate(r100.getResources(), r101, r102, r103);     // Catch: Exception -> L7
            return r105;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface InflateDelegate {
        Drawable createFromXmlInner(Context r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103);
    }

    public interface ResourceManagerHooks {
        Drawable createDrawableFor(ResourceManagerInternal r100, Context r101, int r102);

        ColorStateList getTintListForDrawableRes(Context r100, int r101);

        PorterDuff.Mode getTintModeForDrawableRes(int r100);

        boolean tintDrawable(Context r100, int r101, Drawable r102);

        boolean tintDrawableUsingColorFilter(Context r100, int r101, Drawable r102);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class VdcInflateDelegate implements InflateDelegate {
        public VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) {
            return VectorDrawableCompat.createFromXmlInner(r100.getResources(), r101, r102, r103);
        L4:
            return null;
        }
    }

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    }

    public static synchronized ResourceManagerInternal get() {
        monitor-enter(ResourceManagerInternal.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        ResourceManagerInternal r100 = new ResourceManagerInternal();     // Catch: Throwable -> L10
        INSTANCE = r100;     // Catch: Throwable -> L10
        installDefaultInflateDelegates(r100);     // Catch: Throwable -> L10
    L7:
        ResourceManagerInternal r101 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(ResourceManagerInternal.class);
        return r101;
    }

    public ResourceManagerInternal() {
        this.mDrawableCaches = new WeakHashMap(0);
    }

    private void checkVectorDrawableSetup(Context r100) {
        if (this.mHasCheckedVectorDrawableSetup == false) goto L5;
        return;
    L5:
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable r101 = getDrawable(r100, R.drawable.abc_vector_test);
        if (r101 != null) goto L8;
    L10:
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    L8:
        if (isVectorDrawable(r101) == false) goto L10;
    }

    private static long createCacheKey(TypedValue r100) {
        return (((long) r100.assetCookie) << 32) | ((long) r100.data);
    }

    private static void installDefaultInflateDelegates(ResourceManagerInternal r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        r100.addDelegate("vector", new VdcInflateDelegate());
        r100.addDelegate("animated-vector", new AvdcInflateDelegate());
        r100.addDelegate("animated-selector", new AsldcInflateDelegate());
        r100.addDelegate("drawable", new DrawableDelegate());
        return;
    }

    private static boolean isVectorDrawable(Drawable r100) {
        if ((r100 instanceof VectorDrawableCompat) == false) goto L5;
    L8:
        return true;
    L5:
        if (PLATFORM_VD_CLAZZ.equals(r100.getClass().getName()) == true) goto L8;
        return false;
    }

    public PorterDuff.Mode getTintMode(int r100) {
        ResourceManagerHooks r101 = this.mHooks;
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.getTintModeForDrawableRes(r100);
    }

    public synchronized void onConfigurationChanged(Context r100) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r101 = this.mDrawableCaches.get(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.clear();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void setHooks(ResourceManagerHooks r100) {
        monitor-enter(this);
        this.mHooks = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void addDelegate(String r100, InflateDelegate r101) {
        if (this.mDelegates != null) goto L5;
        this.mDelegates = new SimpleArrayMap();
    L5:
        this.mDelegates.put(r100, r101);
    }

    private Drawable createDrawableIfNeeded(Context r100, int r101) {
        if (this.mTypedValue != null) goto L5;
        this.mTypedValue = new TypedValue();
    L5:
        TypedValue r102 = this.mTypedValue;
        r100.getResources().getValue(r101, r102, true);
        long r103 = createCacheKey(r102);
        Drawable r104 = getCachedDrawable(r100, r103);
        if (r104 == null) goto L8;
        return r104;
    L8:
        ResourceManagerHooks r105 = this.mHooks;
        if (r105 != null) goto L11;
        Drawable r106 = null;
    L12:
        if (r106 == null) goto L14;
        r106.setChangingConfigurations(r102.changingConfigurations);
        addDrawableToCache(r100, r103, r106);
    L14:
        return r106;
    L11:
        r106 = r105.createDrawableFor(this, r100, r101);
        goto L12
    }

    private synchronized Drawable getCachedDrawable(Context r100, long r101) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r102 = this.mDrawableCaches.get(r100);     // Catch: Throwable -> L18
        if (r102 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference<Drawable.ConstantState> r103 = r102.get(r101);     // Catch: Throwable -> L18
        if (r103 == null) goto L16;
        Drawable.ConstantState r104 = r103.get();     // Catch: Throwable -> L18
        if (r104 == null) goto L15;
        Drawable r105 = r104.newDrawable(r100.getResources());     // Catch: Throwable -> L18
        monitor-exit(this);
        return r105;
    L15:
        r102.remove(r101);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r100, PorterDuff.Mode r101) {
        monitor-enter(ResourceManagerInternal.class);
        ColorFilterLruCache r102 = COLOR_FILTER_CACHE;     // Catch: Throwable -> L9
        PorterDuffColorFilter r103 = r102.get(r100, r101);     // Catch: Throwable -> L9
        if (r103 != null) goto L7;
        r103 = new PorterDuffColorFilter(r100, r101);     // Catch: Throwable -> L9
        r102.put(r100, r101, r103);     // Catch: Throwable -> L9
    L7:
        monitor-exit(ResourceManagerInternal.class);
        return r103;
    L9:
        th = move-exception;
        throw th;
    }

    private ColorStateList getTintListFromCache(Context r100, int r101) {
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> r102 = this.mTintLists;
        if (r102 == null) goto L8;
        SparseArrayCompat<ColorStateList> r103 = r102.get(r100);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.get(r101);
    L8:
        return null;
    }

    private Drawable loadDrawableFromDelegates(Context r110, int r111) {
        SimpleArrayMap<String, InflateDelegate> r100 = this.mDelegates;
        if (r100 != null) goto L5;
    L42:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L42;
        SparseArrayCompat<String> r101 = this.mKnownDrawableIdTags;
        if (r101 == null) goto L14;
        String r102 = r101.get(r111);
        if (SKIP_DRAWABLE_TAG.equals(r102) == true) goto L13;
        if (r102 == null) goto L16;
        if (this.mDelegates.get(r102) == null) goto L13;
    L16:
        if (this.mTypedValue != null) goto L18;
        this.mTypedValue = new TypedValue();
    L18:
        TypedValue r103 = this.mTypedValue;
        Resources r104 = r110.getResources();
        r104.getValue(r111, r103, true);
        long r105 = createCacheKey(r103);
        Drawable r106 = getCachedDrawable(r110, r105);
        if (r106 == null) goto L21;
        return r106;
    L21:
        CharSequence r107 = r103.string;
        if (r107 != null) goto L24;
    L39:
        if (r106 != null) goto L41;
        this.mKnownDrawableIdTags.append(r111, SKIP_DRAWABLE_TAG);
    L41:
        return r106;
    L24:
        if (r107.toString().endsWith(".xml") == false) goto L39;
        XmlResourceParser r108 = r104.getXml(r111);     // Catch: Exception -> L38
        AttributeSet r109 = Xml.asAttributeSet(r108);     // Catch: Exception -> L38
    L26:
        int r112 = r108.next();     // Catch: Exception -> L38
        if (r112 == 2) goto L30;
        if (r112 != 1) goto L26;
    L30:
        if (r112 != 2) goto L37;
        String r113 = r108.getName();     // Catch: Exception -> L38
        this.mKnownDrawableIdTags.append(r111, r113);     // Catch: Exception -> L38
        InflateDelegate r114 = this.mDelegates.get(r113);     // Catch: Exception -> L38
        if (r114 == null) goto L34;
        r106 = r114.createFromXmlInner(r110, r108, r109, r110.getTheme());     // Catch: Exception -> L38
    L34:
        if (r106 == null) goto L39;
        r106.setChangingConfigurations(r103.changingConfigurations);     // Catch: Exception -> L38
        addDrawableToCache(r110, r105, r106);     // Catch: Exception -> L38
        goto L39
    L37:
        throw new XmlPullParserException("No start tag found");     // Catch: Exception -> L38
    L13:
        return null;
    L14:
        this.mKnownDrawableIdTags = new SparseArrayCompat();
        goto L16
    }

    public synchronized Drawable getDrawable(Context r100, int r101) {
        monitor-enter(this);
        Drawable r102 = getDrawable(r100, r101, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized ColorStateList getTintList(Context r100, int r101) {
        monitor-enter(this);
        ColorStateList r102 = getTintListFromCache(r100, r101);     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        ResourceManagerHooks r103 = this.mHooks;     // Catch: Throwable -> L13
        if (r103 != null) goto L8;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        addTintListToCache(r100, r101, r102);     // Catch: Throwable -> L13
        goto L11
    L8:
        r102 = r103.getTintListForDrawableRes(r100, r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r102;
    L13:
        th = move-exception;
        throw th;
    }

    private synchronized boolean addDrawableToCache(Context r100, long r101, Drawable r102) {
        monitor-enter(this);
        Drawable.ConstantState r103 = r102.getConstantState();     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        LongSparseArray<WeakReference<Drawable.ConstantState>> r104 = this.mDrawableCaches.get(r100);     // Catch: Throwable -> L15
        if (r104 != null) goto L8;
        r104 = new LongSparseArray();     // Catch: Throwable -> L15
        this.mDrawableCaches.put(r100, r104);     // Catch: Throwable -> L15
    L8:
        r104.put(r101, new WeakReference(r103));     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    L12:
        monitor-exit(this);
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    private void addTintListToCache(Context r100, int r101, ColorStateList r102) {
        if (this.mTintLists != null) goto L5;
        this.mTintLists = new WeakHashMap();
    L5:
        SparseArrayCompat<ColorStateList> r103 = this.mTintLists.get(r100);
        if (r103 != null) goto L8;
        r103 = new SparseArrayCompat();
        this.mTintLists.put(r100, r103);
    L8:
        r103.append(r101, r102);
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList r100, PorterDuff.Mode r101, int[] r102) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return getPorterDuffColorFilter(r100.getColorForState(r102, 0), r101);
    L7:
        return null;
    }

    public static void tintDrawable(Drawable r100, TintInfo r101, int[] r102) {
        if (DrawableUtils.canSafelyMutateDrawable(r100) == true) goto L5;
    L7:
        boolean r103 = r101.mHasTintList;
        if (r103 == false) goto L10;
    L13:
        if (r103 == false) goto L15;
        ColorStateList r104 = r101.mTintList;
    L17:
        if (r101.mHasTintMode == false) goto L19;
        PorterDuff.Mode r105 = r101.mTintMode;
    L20:
        r100.setColorFilter(createTintFilter(r104, r105, r102));
    L22:
        if (Build.VERSION.SDK_INT > 23) goto L25;
        r100.invalidateSelf();
        return;
    L25:
        return;
    L19:
        r105 = DEFAULT_MODE;
        goto L20
    L15:
        r104 = null;
        goto L17
    L10:
        if (r101.mHasTintMode == true) goto L13;
        r100.clearColorFilter();
        goto L22
    L5:
        if (r100.mutate() == r100) goto L7;
    }

    public synchronized Drawable getDrawable(Context r100, int r101, boolean r102) {
        monitor-enter(this);
        checkVectorDrawableSetup(r100);     // Catch: Throwable -> L14
        Drawable r103 = loadDrawableFromDelegates(r100, r101);     // Catch: Throwable -> L14
        if (r103 != null) goto L6;
        r103 = createDrawableIfNeeded(r100, r101);     // Catch: Throwable -> L14
    L6:
        if (r103 != null) goto L8;
        r103 = ContextCompat.getDrawable(r100, r101);     // Catch: Throwable -> L14
    L8:
        if (r103 == null) goto L10;
        r103 = tintDrawable(r100, r101, r102, r103);     // Catch: Throwable -> L14
    L10:
        if (r103 == null) goto L12;
        DrawableUtils.fixDrawable(r103);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r103;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable onDrawableLoadedFromResources(Context r100, VectorEnabledTintResources r101, int r102) {
        monitor-enter(this);
        Drawable r103 = loadDrawableFromDelegates(r100, r102);     // Catch: Throwable -> L13
        if (r103 != null) goto L6;
        r103 = r101.superGetDrawable(r102);     // Catch: Throwable -> L13
    L6:
        if (r103 == null) goto L10;
        Drawable r104 = tintDrawable(r100, r102, false, r103);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r104;
    L10:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean tintDrawableUsingColorFilter(Context r100, int r101, Drawable r102) {
        ResourceManagerHooks r103 = this.mHooks;
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.tintDrawableUsingColorFilter(r100, r101, r102) == false) goto L7;
        return true;
    }

    private Drawable tintDrawable(Context r100, int r101, boolean r102, Drawable r103) {
        ColorStateList r104 = getTintList(r100, r101);
        if (r104 != null) goto L5;
        ResourceManagerHooks r105 = this.mHooks;
        if (r105 == null) goto L16;
        if (r105.tintDrawable(r100, r101, r103) == false) goto L16;
        return r103;
    L16:
        if (tintDrawableUsingColorFilter(r100, r101, r103) == true) goto L22;
        if (r102 == false) goto L23;
        return null;
    L23:
        return r103;
    L22:
        return r103;
    L5:
        if (DrawableUtils.canSafelyMutateDrawable(r103) == false) goto L7;
        r103 = r103.mutate();
    L7:
        Drawable r106 = DrawableCompat.wrap(r103);
        DrawableCompat.setTintList(r106, r104);
        PorterDuff.Mode r107 = getTintMode(r101);
        if (r107 == null) goto L20;
        DrawableCompat.setTintMode(r106, r107);
        return r106;
    L20:
        return r106;
    }
}
