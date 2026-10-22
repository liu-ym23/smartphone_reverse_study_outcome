package stepos.statusbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSStatusBarManager {
    public static final String SERVICE_NAME = "stepos_statusbar";
    private static final String TAG = "StepOSStatusBarManager";
    private final Context mContext;
    private final IStepOSStatusBarService mService;

    public StepOSStatusBarManager(Context context, IStepOSStatusBarService service) {
        this.mContext = context;
        this.mService = service;
    }

    public void setHomeChipEnable(boolean enable) {
        try {
            this.mService.setHomeChipEnable(enable);
        } catch (Exception e) {
            Log.e(TAG, "setHomeChipEnable failed", e);
        }
    }

    public void setNavigationBarMode(boolean show, boolean mback) {
        try {
            this.mService.setNavigationBarMode(show, mback);
        } catch (Exception e) {
            Log.e(TAG, "setNavigationBarMode failed", e);
        }
    }

    public void showAlwaysTextAndIcon(Bundle info) {
        try {
            this.mService.showAlwaysTextAndIcon(info);
        } catch (Exception e) {
            Log.e(TAG, "showAlwaysTextAndIcon failed", e);
        }
    }

    public void hideAlwaysTextAndIcon(String packageName) {
        try {
            this.mService.hideAlwaysTextAndIcon(packageName);
        } catch (Exception e) {
            Log.e(TAG, "hideAlwaysTextAndIcon failed", e);
        }
    }

    public void hideAlwaysPermission(Bundle info) {
        try {
            this.mService.hideAlwaysPermission(info);
        } catch (Exception e) {
            Log.e(TAG, "hideAlwaysPermission failed", e);
        }
    }

    public void registerStatusBar(IStepOSStatusBarCallback bar) {
        try {
            this.mService.registerStatusBar(bar);
        } catch (Exception e) {
            Log.e(TAG, "registerStatusBar failed", e);
        }
    }
}
