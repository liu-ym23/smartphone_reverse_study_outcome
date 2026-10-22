package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* JADX INFO: loaded from: classes17.dex */
public class BlendModeColorFilterCompat {

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static ColorFilter createBlendModeColorFilter(int r100, Object r101) {
            return new BlendModeColorFilter(r100, (BlendMode) r101);
        }
    }

    private BlendModeColorFilterCompat() {
    }

    public static ColorFilter createBlendModeColorFilterCompat(int r100, BlendModeCompat r101) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Object r102 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return Api29Impl.createBlendModeColorFilter(r100, r102);
    L8:
        PorterDuff.Mode r103 = BlendModeUtils.obtainPorterDuffFromCompat(r101);
        if (r103 != null) goto L11;
        return null;
    L11:
        return new PorterDuffColorFilter(r100, r103);
    }
}
