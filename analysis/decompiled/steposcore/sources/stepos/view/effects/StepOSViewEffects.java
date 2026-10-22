package stepos.view.effects;

import android.graphics.RenderEffect;
import android.util.Log;
import android.view.View;
import com.stepos.feature.StepOSFeature;

/* loaded from: classes.dex */
public final class StepOSViewEffects {
    private static final String TAG = "StepOSViewEffects";

    private StepOSViewEffects() {
    }

    public static void setBackdropRenderEffect(View view, RenderEffect effect) {
        RenderEffect applied = StepOSFeature.isEnabled(33) ? effect : null;
        try {
            view.setBackdropRenderEffect(applied);
        } catch (LinkageError e) {
            Log.w(TAG, "View#setBackdropRenderEffect unavailable on this build; skipping", e);
        }
    }
}
