package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TintContextWrapper extends ContextWrapper {
    private static final Object CACHE_LOCK = null;
    private static ArrayList<WeakReference<TintContextWrapper>> sCache;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    static {
        CACHE_LOCK = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r100 = this.mTheme;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    private TintContextWrapper(Context r100) {
        super(r100);
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L5;
        VectorEnabledTintResources r101 = new VectorEnabledTintResources(this, r100.getResources());
        this.mResources = r101;
        Resources.Theme r102 = r101.newTheme();
        this.mTheme = r102;
        r102.setTo(r100.getTheme());
        return;
    L5:
        this.mResources = new TintResources(this, r100.getResources());
        this.mTheme = null;
    }

    private static boolean shouldWrap(Context r100) {
        if ((r100 instanceof TintContextWrapper) == false) goto L5;
        return false;
    L5:
        if ((r100.getResources() instanceof TintResources) == false) goto L7;
        return false;
    L7:
        if ((r100.getResources() instanceof VectorEnabledTintResources) == false) goto L10;
        return false;
    L10:
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static Context wrap(Context r100) {
        if (shouldWrap(r100) == false) goto L35;
        Object r101 = CACHE_LOCK;
        monitor-enter(r101);
        ArrayList<WeakReference<TintContextWrapper>> r102 = sCache;     // Catch: Throwable -> L32
        if (r102 != null) goto L9;
        sCache = new ArrayList();     // Catch: Throwable -> L32
    L29:
        TintContextWrapper r103 = new TintContextWrapper(r100);     // Catch: Throwable -> L32
        sCache.add(new WeakReference(r103));     // Catch: Throwable -> L32
        monitor-exit(r101);     // Catch: Throwable -> L32
        return r103;
    L9:
        int r104 = r102.size() - 1;     // Catch: Throwable -> L32
    L10:
        if (r104 < 0) goto L17;
        WeakReference<TintContextWrapper> r105 = sCache.get(r104);     // Catch: Throwable -> L32
        if (r105 != null) goto L14;
    L15:
        sCache.remove(r104);     // Catch: Throwable -> L32
    L16:
        r104 = r104 - 1;     // Catch: Throwable -> L32
        goto L10
    L14:
        if (r105.get() != null) goto L16;
    L17:
        int r106 = sCache.size() - 1;     // Catch: Throwable -> L32
    L18:
        if (r106 < 0) goto L29;
        WeakReference<TintContextWrapper> r107 = sCache.get(r106);     // Catch: Throwable -> L32
        if (r107 == null) goto L22;
        TintContextWrapper r108 = r107.get();     // Catch: Throwable -> L32
    L23:
        if (r108 == null) goto L28;
        if (r108.getBaseContext() != r100) goto L28;
        monitor-exit(r101);     // Catch: Throwable -> L32
        return r108;
    L28:
        r106 = r106 - 1;     // Catch: Throwable -> L32
        goto L18
    L22:
        r108 = null;
    L32:
        th = move-exception;
        throw th;
    L35:
        return r100;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r100) {
        Resources.Theme r101 = this.mTheme;
        if (r101 != null) goto L5;
        super.setTheme(r100);
        return;
    L5:
        r101.applyStyle(r100, true);
    }
}
