package l8;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {
    public static int a(Context context, double d8) {
        return (int) TypedValue.applyDimension(1, (float) d8, context.getResources().getDisplayMetrics());
    }
}
