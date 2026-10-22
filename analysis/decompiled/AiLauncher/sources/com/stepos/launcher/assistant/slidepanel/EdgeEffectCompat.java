package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import com.stepos.launcher.assistant.utils.Utils;
import o7.C5011b;

/* loaded from: classes.dex */
public class EdgeEffectCompat extends C5011b {
    public EdgeEffectCompat(Context context) {
        super(context);
    }

    @Override // o7.C5011b
    public float getDistance() {
        if (Utils.ATLEAST_S) {
            return super.getDistance();
        }
        return 0.0f;
    }

    @Override // o7.C5011b
    public float onPullDistance(float f10, float f11) {
        if (Utils.ATLEAST_S) {
            return super.onPullDistance(f10, f11);
        }
        onPull(f10, f11);
        return f10;
    }
}
