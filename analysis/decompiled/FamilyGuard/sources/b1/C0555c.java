package b1;

import android.animation.TypeEvaluator;

/* renamed from: b1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0555c implements TypeEvaluator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    private static final C0555c f11788a = new C0555c();

    public static C0555c b() {
        return f11788a;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer evaluate(float f5, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        float f6 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = num2.intValue();
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f7 = f6 + (((((iIntValue2 >> 24) & 255) / 255.0f) - f6) * f5);
        float fPow5 = fPow2 + ((((float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d)) - fPow2) * f5);
        float fPow6 = fPow3 + (f5 * (((float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d)) - fPow3));
        float fPow7 = ((float) Math.pow(fPow + ((fPow4 - fPow) * f5), 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fPow5, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fPow6, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(f7 * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
