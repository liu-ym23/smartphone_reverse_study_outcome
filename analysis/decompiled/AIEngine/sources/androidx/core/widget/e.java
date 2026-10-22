package androidx.core.widget;

import android.os.Build;
import android.util.TypedValue;
import android.view.ActionMode;
import android.widget.TextView;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements ActionMode.Callback {
    }

    public static void a(TextView textView, int i10) {
        y.m(i10);
        if (i10 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i10 - r0, 1.0f);
        }
    }

    public static void b(TextView textView, int i10, float f8) {
        if (Build.VERSION.SDK_INT >= 34) {
            textView.setLineHeight(i10, f8);
        } else {
            a(textView, Math.round(TypedValue.applyDimension(i10, f8, textView.getResources().getDisplayMetrics())));
        }
    }

    public static ActionMode.Callback c(ActionMode.Callback callback) {
        if (callback instanceof a) {
            throw null;
        }
        return callback;
    }
}
