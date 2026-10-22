package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;

/* JADX INFO: loaded from: classes17.dex */
public final class SQLiteCursorCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static void setFillWindowForwardOnly(SQLiteCursor r100, boolean r101) {
            r100.setFillWindowForwardOnly(r101);
        }
    }

    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(SQLiteCursor r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.setFillWindowForwardOnly(r100, r101);
        return;
    }
}
