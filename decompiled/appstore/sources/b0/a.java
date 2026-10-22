package b0;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import kotlin.collections.n;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Cursor a(Cursor r10) {
        q.g(r10, "c");
        MatrixCursor r11 = new MatrixCursor(r10.getColumnNames(), r10.getCount());     // Catch: Throwable -> L19
    L5:
        if (r10.moveToNext() == false) goto L30;
        Object[] r12 = new Object[r10.getColumnCount()];     // Catch: Throwable -> L19
        int r13 = r10.getColumnCount();     // Catch: Throwable -> L19
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L28;
        int r15 = r10.getType(r14);     // Catch: Throwable -> L19
        if (r15 != 0) goto L11;
        r12[r14] = null;     // Catch: Throwable -> L19
    L27:
        r14 = r14 + 1;     // Catch: Throwable -> L19
        goto L7
    L11:
        if (r15 != 1) goto L13;
        r12[r14] = Long.valueOf(r10.getLong(r14));     // Catch: Throwable -> L19
        goto L27
    L13:
        if (r15 != 2) goto L15;
        r12[r14] = Double.valueOf(r10.getDouble(r14));     // Catch: Throwable -> L19
        goto L27
    L15:
        if (r15 != 3) goto L17;
        r12[r14] = r10.getString(r14);     // Catch: Throwable -> L19
        goto L27
    L17:
        if (r15 != 4) goto L22;
        r12[r14] = r10.getBlob(r14);     // Catch: Throwable -> L19
        goto L27
    L22:
        throw new IllegalStateException();     // Catch: Throwable -> L19
    L28:
        r11.addRow(r12);     // Catch: Throwable -> L19
        goto L5
    L30:
        kotlin.io.b.a(r10, null);
        return r11;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        kotlin.io.b.a(r10, th);
        throw th;
    }

    public static final int b(Cursor r10, String r11) {
        return -1;
    }

    public static final int c(Cursor r10, String r11) {
        q.g(r10, "c");
        q.g(r11, "name");
        int r12 = r10.getColumnIndex(r11);
        if (r12 < 0) goto L5;
        return r12;
    L5:
        int r13 = r10.getColumnIndex('`' + r11 + '`');
        if (r13 < 0) goto L9;
        return r13;
    L9:
        return b(r10, r11);
    }

    public static final int d(Cursor r10, String r11) {
        q.g(r10, "c");
        q.g(r11, "name");
        int r12 = c(r10, r11);
        if (r12 < 0) goto L11;
        return r12;
    L11:
        String[] r13 = r10.getColumnNames();     // Catch: Exception -> L7
        q.f(r13, "c.columnNames");     // Catch: Exception -> L7
        String r14 = n.C(r13, null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException("column '" + r11 + "' does not exist. Available columns: " + r14);
    L7:
        e = move-exception;
        Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
        r14 = "unknown";
        goto L10
    }
}
