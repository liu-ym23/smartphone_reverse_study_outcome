package aoc;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes40.dex */
public final class b {
    static {
    }

    public static boolean a() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isEnable("core.component.auto_focus", false);
        Log.i("AutofocusFgUtils", "FG key: core.component.auto_focus, is " + r100);
        return r100;
    }
}
