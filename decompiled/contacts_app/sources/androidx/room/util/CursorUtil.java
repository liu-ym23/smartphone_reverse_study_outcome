package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CursorUtil {
    private static int findColumnIndexBySuffix(Cursor cursor, String name) {
        return -1;
    }

    public static Cursor copyAndClose(Cursor c) {
        MatrixCursor r0 = new MatrixCursor(c.getColumnNames(), c.getCount());     // Catch: Throwable -> L30
    L4:
        if (c.moveToNext() == false) goto L28;
        Object[] r1 = new Object[c.getColumnCount()];     // Catch: Throwable -> L30
        int r2 = 0;
    L7:
        if (r2 >= c.getColumnCount()) goto L26;
        int r3 = c.getType(r2);     // Catch: Throwable -> L30
        if (r3 != 0) goto L11;
        r1[r2] = null;     // Catch: Throwable -> L30
    L25:
        r2 = r2 + 1;     // Catch: Throwable -> L30
        goto L7
    L11:
        if (r3 != 1) goto L13;
        r1[r2] = Long.valueOf(c.getLong(r2));     // Catch: Throwable -> L30
        goto L25
    L13:
        if (r3 != 2) goto L15;
        r1[r2] = Double.valueOf(c.getDouble(r2));     // Catch: Throwable -> L30
        goto L25
    L15:
        if (r3 != 3) goto L17;
        r1[r2] = c.getString(r2);     // Catch: Throwable -> L30
        goto L25
    L17:
        if (r3 != 4) goto L20;
        r1[r2] = c.getBlob(r2);     // Catch: Throwable -> L30
        goto L25
    L20:
        throw new IllegalStateException();     // Catch: Throwable -> L30
    L26:
        r0.addRow(r1);     // Catch: Throwable -> L30
        goto L4
    L28:
        c.close();
        return r0;
    L30:
        th = move-exception;
        c.close();
        throw th;
    }

    public static int getColumnIndex(Cursor c, String name) {
        int r0 = c.getColumnIndex(name);
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = c.getColumnIndex("`" + name + "`");
        if (r1 < 0) goto L9;
        return r1;
    L9:
        return findColumnIndexBySuffix(c, name);
    }

    public static int getColumnIndexOrThrow(Cursor c, String name) {
        int r0 = getColumnIndex(c, name);
        if (r0 < 0) goto L11;
        return r0;
    L11:
        String r3 = Arrays.toString(c.getColumnNames());     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + r3);
    L7:
        e = move-exception;
        Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
        r3 = "";
        goto L10
    }

    static int findColumnIndexBySuffix(String[] columnNames, String name) {
        String r0 = LibrarianImpl.Constants.DOT + name;
        String r1 = LibrarianImpl.Constants.DOT + name + "`";
        int r3 = 0;
    L4:
        if (r3 >= columnNames.length) goto L16;
        String r4 = columnNames[r3];
        if (r4.length() < (name.length() + 2)) goto L15;
        if (r4.endsWith(r0) == true) goto L9;
        if (r4.charAt(0) != '`') goto L15;
        if (r4.endsWith(r1) == false) goto L15;
        return r3;
    L9:
        return r3;
    L15:
        r3 = r3 + 1;
        goto L4
    L16:
        return -1;
    }

    private CursorUtil() {
    }
}
