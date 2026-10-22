package com.mdisdk.capability.framework;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public interface IFrameworkBridge {
    public static final String KEY_SCREENSHOT_RESULT_BITMAP = "android.view.screenshot.result_bitmap";
    public static final String KEY_SCREENSHOT_RESULT_CODE = "android.view.screenshot.result_code";
    public static final String KEY_SCREENSHOT_RESULT_MESSAGE = "android.view.screenshot.result_message";
    public static final int SCREENSHOT_RESULT_ERROR_CAPTURE_FAILED = 3;
    public static final int SCREENSHOT_RESULT_ERROR_SECURE = 2;
    public static final int SCREENSHOT_RESULT_ERROR_UNKNOWN = 1;
    public static final int SCREENSHOT_RESULT_ERROR_UNSUPPORTED = 4;
    public static final int SCREENSHOT_RESULT_SUCCESS = 0;

    boolean addDisplayControlPackage(String str);

    void addEventListener(Handler handler, int i, int i6);

    void addOmniDisplayCallback(Handler handler, int i);

    void apexRequest(Intent intent);

    @Nullable
    Intent getActivityIntentByPackage(String str, int i);

    int getShowingDisplayId(String str);

    @Nullable
    Intent getTopActivityIntent(int i);

    boolean isOmniDisplayId(String str);

    boolean isOmniDisplayImeEnabled(int i);

    boolean isOmniDisplayTakeover(int i);

    boolean moveAppToDisplay(String str, int i, boolean z10, int i6);

    void removeEventListener(Handler handler, int i, int i6);

    void removeOmniDisplayCallback(Handler handler, int i);

    void setOmniDisplayImeEnabled(int i, boolean z10);

    void setOmniDisplayTakeover(int i, boolean z10);

    void setRedirectActivity(@Nullable ComponentName componentName);

    Bitmap takeScreenShot(int i, @Nullable String str);

    Bundle takeScreenshotWithScaleResult(int i, int i6, @Nullable String str, float f);
}
