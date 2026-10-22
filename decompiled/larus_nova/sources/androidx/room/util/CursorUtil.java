package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class CursorUtil {
    private CursorUtil() {
    }

    public static Cursor copyAndClose(Cursor r100) {
        MatrixCursor r101 = new MatrixCursor(r100.getColumnNames(), r100.getCount());     // Catch: Throwable -> L30
    L4:
        if (r100.moveToNext() == false) goto L28;
        Object[] r102 = new Object[r100.getColumnCount()];     // Catch: Throwable -> L30
        int r103 = 0;
    L7:
        if (r103 >= r100.getColumnCount()) goto L26;
        int r104 = r100.getType(r103);     // Catch: Throwable -> L30
        if (r104 != 0) goto L11;
        r102[r103] = null;     // Catch: Throwable -> L30
    L25:
        r103 = r103 + 1;     // Catch: Throwable -> L30
        goto L7
    L11:
        if (r104 != 1) goto L13;
        r102[r103] = Long.valueOf(r100.getLong(r103));     // Catch: Throwable -> L30
        goto L25
    L13:
        if (r104 != 2) goto L15;
        r102[r103] = Double.valueOf(r100.getDouble(r103));     // Catch: Throwable -> L30
        goto L25
    L15:
        if (r104 != 3) goto L17;
        r102[r103] = r100.getString(r103);     // Catch: Throwable -> L30
        goto L25
    L17:
        if (r104 != 4) goto L20;
        r102[r103] = r100.getBlob(r103);     // Catch: Throwable -> L30
        goto L25
    L20:
        throw new IllegalStateException();     // Catch: Throwable -> L30
    L26:
        r101.addRow(r102);     // Catch: Throwable -> L30
        goto L4
    L28:
        r100.close();
        return r101;
    L30:
        th = move-exception;
        r100.close();
        throw th;
    }

    public static int findColumnIndexBySuffix(String[] r100, String r101) {
        String r102 = "." + r101;
        String r103 = "." + r101 + InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER;
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L16;
        String r105 = r100[r104];
        if (r105.length() < (r101.length() + 2)) goto L15;
        if (r105.endsWith(r102) == true) goto L9;
        if (r105.charAt(0) != '`') goto L15;
        if (r105.endsWith(r103) == false) goto L15;
        return r104;
    L9:
        return r104;
    L15:
        r104 = r104 + 1;
        goto L4
    L16:
        return -1;
    }

    public static int getColumnIndex(Cursor r100, String r101) {
        int r102 = r100.getColumnIndex(r101);
        if (r102 < 0) goto L5;
        return r102;
    L5:
        int r103 = r100.getColumnIndex(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER + r101 + InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER);
        if (r103 < 0) goto L9;
        return r103;
    L9:
        return findColumnIndexBySuffix(r100, r101);
    }

    public static int getColumnIndexOrThrow(Cursor r100, String r101) {
        int r102 = getColumnIndex(r100, r101);
        if (r102 < 0) goto L10;
        return r102;
    L10:
        String r103 = Arrays.toString(r100.getColumnNames());     // Catch: Exception -> L7
    L9:
        throw new IllegalArgumentException("column '" + r101 + "' does not exist. Available columns: " + r103);
    L7:
        r103 = "";
        goto L9
    }

    private static int findColumnIndexBySuffix(Cursor r100, String r101) {
        if (Build.VERSION.SDK_INT <= 25) goto L6;
        return -1;
    L6:
        if (r101.length() != 0) goto L9;
        return -1;
    L9:
        return findColumnIndexBySuffix(r100.getColumnNames(), r101);
    }
}
