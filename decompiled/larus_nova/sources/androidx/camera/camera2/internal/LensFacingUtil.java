package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes2.dex */
public class LensFacingUtil {
    private LensFacingUtil() {
    }

    public static int getCameraSelectorLensFacing(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        if (r100 != 1) goto L6;
        return 1;
    L6:
        if (r100 != 2) goto L9;
        return 2;
    L9:
        throw new IllegalArgumentException("The given lens facing integer: " + r100 + " can not be recognized.");
    }

    public static int getLensFacingInt(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        if (r100 != 1) goto L6;
        return 1;
    L6:
        if (r100 != 2) goto L9;
        return 2;
    L9:
        throw new IllegalArgumentException("The given lens facing: " + r100 + " can not be recognized.");
    }
}
