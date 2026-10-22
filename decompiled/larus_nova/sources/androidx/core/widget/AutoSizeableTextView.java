package androidx.core.widget;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public interface AutoSizeableTextView {
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = false;

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int r100, int r101, int r102, int r103) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] r100, int r101) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int r100);

    static {
        if (Build.VERSION.SDK_INT < 27) goto L5;
        boolean r100 = true;
    L6:
        PLATFORM_SUPPORTS_AUTOSIZE = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }
}
