package u3;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f5) {
        float f10 = f5 - 1.0f;
        return (f10 * f10 * f10 * f10 * f10) + 1.0f;
    }
}
