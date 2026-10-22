package stepos.support.v7.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* renamed from: stepos.support.v7.widget.z, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2010z {

    /* renamed from: a, reason: collision with root package name */
    public static final FastOutLinearInInterpolator f6648a;
    public static final LinearOutSlowInInterpolator b;
    public static final Interpolator c;
    public static final Interpolator d;

    static {
        new LinearInterpolator();
        new FastOutSlowInInterpolator();
        f6648a = new FastOutLinearInInterpolator();
        b = new LinearOutSlowInInterpolator();
        new DecelerateInterpolator();
        new AccelerateDecelerateInterpolator();
        PathInterpolatorCompat.create(0.0f, 0.33f, 0.1f, 1.0f);
        PathInterpolatorCompat.create(0.0f, 0.66f, 0.66f, 1.0f);
        c = PathInterpolatorCompat.create(0.0f, 0.0f, 0.6f, 1.0f);
        d = PathInterpolatorCompat.create(0.4f, 0.0f, 0.4f, 1.0f);
    }
}
