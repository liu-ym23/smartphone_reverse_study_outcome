package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class ResourcesLoaderColorResourcesOverride implements ColorResourcesOverride {

    /* JADX INFO: renamed from: com.google.android.material.color.ResourcesLoaderColorResourcesOverride$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ResourcesLoaderColorResourcesOverrideSingleton {
        private static final ResourcesLoaderColorResourcesOverride INSTANCE = null;

        private ResourcesLoaderColorResourcesOverrideSingleton() {
        }

        static /* synthetic */ ResourcesLoaderColorResourcesOverride access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new ResourcesLoaderColorResourcesOverride(null);
        }
    }

    /* synthetic */ ResourcesLoaderColorResourcesOverride(AnonymousClass1 r1) {
        this();
    }

    private ResourcesLoaderColorResourcesOverride() {
    }

    @Override // com.google.android.material.color.ColorResourcesOverride
    public boolean applyIfPossible(Context r1, Map<Integer, Integer> r2) {
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r1, r2) == false) goto L6;
        ThemeUtils.applyThemeOverlay(r1, R.style.ThemeOverlay_Material3_PersonalizedColors);
        return true;
    L6:
        return false;
    }

    @Override // com.google.android.material.color.ColorResourcesOverride
    public Context wrapContextIfPossible(Context r2, Map<Integer, Integer> r3) {
        ContextThemeWrapper r1 = new ContextThemeWrapper(r2, R.style.ThemeOverlay_Material3_PersonalizedColors);
        r1.applyOverrideConfiguration(new Configuration());
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r1, r3) == true) goto L5;
        return r2;
    L5:
        return r1;
    }

    static ColorResourcesOverride getInstance() {
        return ResourcesLoaderColorResourcesOverrideSingleton.access$000();
    }
}
