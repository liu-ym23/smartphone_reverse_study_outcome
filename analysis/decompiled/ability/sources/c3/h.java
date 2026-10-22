package c3;

import android.content.res.Configuration;
import android.graphics.Typeface;
import androidx.core.math.MathUtils;

/* loaded from: classes3.dex */
public abstract class h {
    public static Typeface a(Configuration configuration, Typeface typeface) {
        int i = configuration.fontWeightAdjustment;
        if (i == Integer.MAX_VALUE || i == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, MathUtils.clamp(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }
}
