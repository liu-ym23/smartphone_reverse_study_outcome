package C2;

import android.opengl.Matrix;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f338b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f339c = new float[16];

    /* renamed from: a, reason: collision with root package name */
    public final float[] f340a;

    public c() {
        float[] fArr = new float[16];
        this.f340a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }
}
