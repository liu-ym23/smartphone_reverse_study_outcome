package android.view;

import android.app.WindowConfiguration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class StepOSWindowLayoutExtImpl implements IStepOSWindowLayoutExt {
    private WindowLayout mHost;

    public void onAttach(WindowLayout host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public void computeMinBarInsets(InsetsState state, int windowingMode, Rect windowBounds, int requestedVisibleTypes, int[] out) {
        if (state == null || windowBounds == null || out == null || out.length < 2 || !isEligibleWindowMode(windowingMode, windowBounds)) {
            return;
        }
        Rect displayFrame = state.getDisplayFrame();
        Insets systemBarsInsets = state.calculateInsets(displayFrame, 3, 3);
        if ((WindowInsets.Type.statusBars() & requestedVisibleTypes) == 0) {
            out[0] = systemBarsInsets.top;
        }
        if ((WindowInsets.Type.navigationBars() & requestedVisibleTypes) == 0) {
            out[1] = systemBarsInsets.bottom;
        }
    }

    private static boolean isEligibleWindowMode(int windowingMode, Rect windowBounds) {
        if (WindowConfiguration.isStepOSMagicWindow(windowingMode)) {
            return true;
        }
        if (WindowConfiguration.isStepOSWindowMode(windowingMode)) {
            return windowBounds.width() < windowBounds.height() && windowBounds.height() < windowBounds.width() * 2;
        }
        return false;
    }
}
