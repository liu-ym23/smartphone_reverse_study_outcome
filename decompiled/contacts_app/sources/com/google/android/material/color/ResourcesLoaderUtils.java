package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class ResourcesLoaderUtils {
    static boolean isColorResource(int r1) {
        if (28 <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 31) goto L7;
        return true;
    }

    private ResourcesLoaderUtils() {
    }

    static boolean addResourcesLoaderToContext(Context r3, Map<Integer, Integer> r4) {
        ResourcesLoader r5 = ColorResourcesLoaderCreator.create(r3, r4);
        if (r5 == null) goto L6;
        r3.getResources().addLoaders(new ResourcesLoader[]{r5});
        return true;
    L6:
        return false;
    }
}
