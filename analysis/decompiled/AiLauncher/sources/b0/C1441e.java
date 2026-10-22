package b0;

import android.graphics.drawable.Drawable;

/* renamed from: b0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1441e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final double f15236a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f10, float f11, boolean z10) {
        return z10 ? (float) (f10 + ((1.0d - f15236a) * f11)) : f10;
    }

    public static float b(float f10, float f11, boolean z10) {
        return z10 ? (float) ((f10 * 1.5f) + ((1.0d - f15236a) * f11)) : f10 * 1.5f;
    }
}
