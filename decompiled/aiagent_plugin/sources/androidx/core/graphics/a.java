package androidx.core.graphics;

import android.graphics.Bitmap;
import android.os.Build;

/* JADX INFO: compiled from: BitmapCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.core.graphics.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BitmapCompat.java */
    static class C0027a {
        static boolean a(Bitmap r0) {
            return r0.hasMipMap();
        }

        static void a(Bitmap r0, boolean r1) {
            r0.setHasMipMap(r1);
        }
    }

    public static boolean a(Bitmap r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return C0027a.a(r2);
    }

    public static void a(Bitmap r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        C0027a.a(r2, r3);
        return;
    }
}
