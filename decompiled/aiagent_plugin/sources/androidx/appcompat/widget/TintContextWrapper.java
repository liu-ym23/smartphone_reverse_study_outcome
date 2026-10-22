package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {
    private static final Object CACHE_LOCK = null;
    private static ArrayList<WeakReference<TintContextWrapper>> sCache;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    static {
        CACHE_LOCK = new Object();
    }

    public static Context wrap(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (shouldWrap(r7) == false) goto L35;
        Object r0 = CACHE_LOCK;
        monitor-enter(r0);
        ArrayList<WeakReference<TintContextWrapper>> r1 = sCache;     // Catch: Throwable -> L32
        if (r1 != null) goto L9;
        sCache = new ArrayList();     // Catch: Throwable -> L32
    L29:
        TintContextWrapper r2 = new TintContextWrapper(r7);     // Catch: Throwable -> L32
        sCache.add(new WeakReference(r2));     // Catch: Throwable -> L32
        monitor-exit(r0);     // Catch: Throwable -> L32
        return r2;
    L9:
        int r3 = r1.size() - 1;     // Catch: Throwable -> L32
    L10:
        if (r3 < 0) goto L17;
        WeakReference r4 = (WeakReference) ZeusTransformUtils.preCheckCast(sCache.get(r3), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r4 != null) goto L14;
    L15:
        sCache.remove(r3);     // Catch: Throwable -> L32
    L16:
        r3 = r3 - 1;     // Catch: Throwable -> L32
        goto L10
    L14:
        if (r4.get() != null) goto L16;
    L17:
        int r5 = sCache.size() - 1;     // Catch: Throwable -> L32
    L18:
        if (r5 < 0) goto L29;
        WeakReference r8 = (WeakReference) ZeusTransformUtils.preCheckCast(sCache.get(r5), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r8 == null) goto L22;
        TintContextWrapper r9 = (TintContextWrapper) ZeusTransformUtils.preCheckCast(r8.get(), TintContextWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
    L23:
        if (r9 == null) goto L28;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != r7) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L32
        return r9;
    L28:
        r5 = r5 - 1;     // Catch: Throwable -> L32
        goto L18
    L22:
        r9 = null;
    L32:
        th = move-exception;
        throw th;
    L35:
        return r7;
    }

    private static boolean shouldWrap(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, TintContextWrapper.class) == false) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), TintResources.class) == false) goto L7;
        return false;
    L7:
        if (ZeusTransformUtils.instanceOf(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), VectorEnabledTintResources.class) == false) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 21) goto L12;
    L13:
        return true;
    L12:
        if (VectorEnabledTintResources.shouldBeUsed() == true) goto L13;
        return false;
    }

    private TintContextWrapper(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r4);
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L5;
        VectorEnabledTintResources r0 = new VectorEnabledTintResources(this, ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin"));
        this.mResources = r0;
        Resources.Theme r1 = r0.newTheme();
        this.mTheme = r1;
        r1.setTo(r4.getTheme());
        return;
    L5:
        this.mResources = new TintResources(this, ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin"));
        this.mTheme = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r0 = this.mTheme;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        Resources.Theme r0 = this.mTheme;
        if (r0 != null) goto L5;
        super.setTheme(r2);
        return;
    L5:
        r0.applyStyle(r2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }
}
