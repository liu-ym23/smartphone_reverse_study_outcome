package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

/* JADX INFO: loaded from: classes17.dex */
public final class CursorWindowCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CursorWindow createCursorWindow(String r100, long r101) {
            return new CursorWindow(r100, r101);
        }
    }

    private CursorWindowCompat() {
    }

    public static CursorWindow create(String r100, long r101) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.createCursorWindow(r100, r101);
    L7:
        return new CursorWindow(r100);
    }
}
