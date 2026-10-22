package androidx.core.database;

import android.database.CursorWindow;
import androidx.annotation.RequiresApi;

/* loaded from: classes2.dex */
public final class CursorWindowCompat {

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CursorWindow createCursorWindow(String str, long j5) {
            return new CursorWindow(str, j5);
        }
    }

    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j5) {
        return Api28Impl.createCursorWindow(str, j5);
    }
}
