package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = null;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    public AppCompatDrawableManager() {
    }

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public static synchronized AppCompatDrawableManager get() {
        monitor-enter(AppCompatDrawableManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        preload();     // Catch: Throwable -> L10
    L7:
        AppCompatDrawableManager r100 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(AppCompatDrawableManager.class);
        return r100;
    }

    public static synchronized void preload() {
        monitor-enter(AppCompatDrawableManager.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        AppCompatDrawableManager r100 = new AppCompatDrawableManager();     // Catch: Throwable -> L9
        INSTANCE = r100;     // Catch: Throwable -> L9
        r100.mResourceManager = ResourceManagerInternal.get();     // Catch: Throwable -> L9
        INSTANCE.mResourceManager.setHooks(new AnonymousClass1());     // Catch: Throwable -> L9
    L7:
        monitor-exit(AppCompatDrawableManager.class);
    }

    public static /* synthetic */ PorterDuff.Mode access$000() {
        return DEFAULT_MODE;
    }

    public synchronized void onConfigurationChanged(Context r100) {
        monitor-enter(this);
        this.mResourceManager.onConfigurationChanged(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r100, PorterDuff.Mode r101) {
        monitor-enter(AppCompatDrawableManager.class);
        PorterDuffColorFilter r102 = ResourceManagerInternal.getPorterDuffColorFilter(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(AppCompatDrawableManager.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable getDrawable(Context r100, int r101) {
        monitor-enter(this);
        Drawable r102 = this.mResourceManager.getDrawable(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ColorStateList getTintList(Context r100, int r101) {
        monitor-enter(this);
        ColorStateList r102 = this.mResourceManager.getTintList(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public static void tintDrawable(Drawable r100, TintInfo r101, int[] r102) {
        ResourceManagerInternal.tintDrawable(r100, r101, r102);
    }

    public synchronized Drawable getDrawable(Context r100, int r101, boolean r102) {
        monitor-enter(this);
        Drawable r103 = this.mResourceManager.getDrawable(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable onDrawableLoadedFromResources(Context r100, VectorEnabledTintResources r101, int r102) {
        monitor-enter(this);
        Drawable r103 = this.mResourceManager.onDrawableLoadedFromResources(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean tintDrawableUsingColorFilter(Context r100, int r101, Drawable r102) {
        return this.mResourceManager.tintDrawableUsingColorFilter(r100, r101, r102);
    }
}
