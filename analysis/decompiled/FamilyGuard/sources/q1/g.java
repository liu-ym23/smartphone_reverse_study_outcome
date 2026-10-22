package q1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public class g {
    public static Typeface a(Context context, Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        int i5 = configuration.fontWeightAdjustment;
        if (i5 == Integer.MAX_VALUE || i5 == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, B.a.b(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }
}
