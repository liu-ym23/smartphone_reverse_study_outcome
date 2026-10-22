package androidx.core.content.res;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes17.dex */
public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(Resources r100) {
        return r100.getConfiguration().densityDpi;
    }
}
