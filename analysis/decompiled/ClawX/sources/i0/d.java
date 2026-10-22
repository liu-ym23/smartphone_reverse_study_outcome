package i0;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3105a;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f3) {
        switch (this.f3105a) {
        }
        float f7 = f3 - 1.0f;
        return (f7 * f7 * f7 * f7 * f7) + 1.0f;
    }
}
