package p;

import android.graphics.drawable.Drawable;

/* renamed from: p.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0910f extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f19279a = Math.cos(Math.toRadians(45.0d));

    static float a(float f5, float f6, boolean z5) {
        return z5 ? (float) (f5 + ((1.0d - f19279a) * f6)) : f5;
    }

    static float b(float f5, float f6, boolean z5) {
        return z5 ? (float) ((f5 * 1.5f) + ((1.0d - f19279a) * f6)) : f5 * 1.5f;
    }
}
