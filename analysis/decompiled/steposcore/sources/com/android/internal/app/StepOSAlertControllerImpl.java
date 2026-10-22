package com.android.internal.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.Window;
import com.android.internal.app.AlertController;
import com.android.internal.app.StepOSAlertController;

/* loaded from: classes.dex */
public class StepOSAlertControllerImpl implements StepOSAlertControllerStub {
    public AlertController createForDeviceDefaultTheme(Context context, DialogInterface di, Window window) {
        if (!context.isDeviceDefaultTheme()) {
            return null;
        }
        return new StepOSAlertController(context, di, window);
    }

    public boolean applyStepOSAlertParamsIfNeeded(AlertController dialog, AlertController.AlertParams params) throws Resources.NotFoundException {
        if (dialog instanceof StepOSAlertController) {
            StepOSAlertController.AlertParamsWrapper wrapper = new StepOSAlertController.AlertParamsWrapper(params);
            wrapper.apply((StepOSAlertController) dialog);
            return true;
        }
        return false;
    }

    public void onAlertDialogStart(AlertController alertController) {
        if (alertController instanceof StepOSAlertController) {
            ((StepOSAlertController) alertController).setUpAnimation();
        }
    }
}
