package wb;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements TimeInterpolator {
    public a() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        float r11 = 1;
        return ((float) Math.pow(r10 - r11, 3)) + r11;
    }
}
