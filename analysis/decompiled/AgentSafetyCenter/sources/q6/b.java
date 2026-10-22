package q6;

import android.animation.TypeEvaluator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b implements TypeEvaluator {
    public static Integer a(float f5, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        float f10 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = num2.intValue();
        float f11 = ((iIntValue2 >> 24) & 255) / 255.0f;
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float fPow5 = (float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d);
        float fPow6 = (float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d);
        float f12 = k0.a.f(f11, f10, f5, f10);
        float f13 = k0.a.f(fPow4, fPow, f5, fPow);
        float f14 = k0.a.f(fPow5, fPow2, f5, fPow2);
        float f15 = k0.a.f(fPow6, fPow3, f5, fPow3);
        float fPow7 = ((float) Math.pow(f13, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(f14, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(f15, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(f12 * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
