package c64;

import android.util.Size;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22591a = 0;

    static {
    }

    public static Size a(int r100, int r101, int r102, int r103) {
        if (r102 <= 0) goto L20;
        if (r103 <= 0) goto L20;
        if (r100 > r102) goto L10;
        if (r101 > r103) goto L10;
        float r104 = r100;
        float r105 = r101;
        float r106 = Math.max((r104 * 1.0f) / r102, (1.0f * r105) / r103);
        return new Size((int) (r104 / r106), (int) (r105 / r106));
    L10:
        if (r100 < r102) goto L14;
        if (r101 < r103) goto L14;
        float r107 = r100;
        float r108 = r101;
        float r109 = Math.max((r107 * 1.0f) / r102, (1.0f * r108) / r103);
        return new Size((int) (r107 / r109), (int) (r108 / r109));
    L14:
        if (r100 < r102) goto L17;
        float r110 = r100;
        float r111 = (1.0f * r110) / r102;
        return new Size((int) (r110 / r111), (int) (r101 / r111));
    L17:
        float r112 = r101;
        float r113 = (1.0f * r112) / r103;
        return new Size((int) (r100 / r113), (int) (r112 / r113));
    L20:
        return new Size(r100, r101);
    }
}
