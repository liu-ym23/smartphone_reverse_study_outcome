package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class VectorEnabledTintResources extends Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private static boolean sCompatVectorFromResourcesEnabled;
    private final WeakReference<Context> mContextRef;

    public static boolean shouldBeUsed() {
        isCompatVectorFromResourcesEnabled();
        return false;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_VectorEnabledTintResources_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static void setCompatVectorFromResourcesEnabled(boolean r100) {
        sCompatVectorFromResourcesEnabled = r100;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r100) throws Resources.NotFoundException {
        Context r101 = this.mContextRef.get();
        if (r101 == null) goto L7;
        return ResourceManagerInternal.get().onDrawableLoadedFromResources(r101, this, r100);
    L7:
        return super.getDrawable(r100);
    }

    public final Drawable superGetDrawable(int r100) {
        return super.getDrawable(r100);
    }

    public VectorEnabledTintResources(Context r100, Resources r101) {
        super(r101.getAssets(), INVOKEVIRTUAL_androidx_appcompat_widget_VectorEnabledTintResources_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101), r101.getConfiguration());
        this.mContextRef = new WeakReference(r100);
    }
}
