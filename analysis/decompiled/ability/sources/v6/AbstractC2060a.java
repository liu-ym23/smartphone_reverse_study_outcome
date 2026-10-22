package v6;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* renamed from: v6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2060a {

    /* renamed from: a, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f6770a;

    static {
        new LinearInterpolator();
        f6770a = new FastOutSlowInInterpolator();
        new DecelerateInterpolator();
    }
}
