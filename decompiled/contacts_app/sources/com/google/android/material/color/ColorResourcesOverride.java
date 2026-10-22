package com.google.android.material.color;

import android.content.Context;
import android.os.Build;
import androidx.core.os.BuildCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ColorResourcesOverride {
    boolean applyIfPossible(Context r1, Map<Integer, Integer> r2);

    Context wrapContextIfPossible(Context r1, Map<Integer, Integer> r2);

    static ColorResourcesOverride getInstance() {
        if (Build.VERSION.SDK_INT > 33) goto L7;
        return ResourcesLoaderColorResourcesOverride.getInstance();
    L7:
        if (BuildCompat.isAtLeastU() == true) goto L9;
        return null;
    L9:
        return ResourcesLoaderColorResourcesOverride.getInstance();
    }
}
