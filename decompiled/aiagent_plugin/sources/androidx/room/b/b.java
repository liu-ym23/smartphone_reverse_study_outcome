package androidx.room.b;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CursorUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static Cursor a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.aiagent.plugin");
        MatrixCursor r0 = new MatrixCursor(r6.getColumnNames(), r6.getCount());     // Catch: Throwable -> L31
    L5:
        if (r6.moveToNext() == false) goto L29;
        Object[] r1 = new Object[r6.getColumnCount()];     // Catch: Throwable -> L31
        int r2 = 0;
    L8:
        if (r2 >= r6.getColumnCount()) goto L27;
        int r3 = r6.getType(r2);     // Catch: Throwable -> L31
        if (r3 != 0) goto L12;
        r1[r2] = null;     // Catch: Throwable -> L31
    L26:
        r2 = r2 + 1;     // Catch: Throwable -> L31
        goto L8
    L12:
        if (r3 != 1) goto L14;
        r1[r2] = Long.valueOf(r6.getLong(r2));     // Catch: Throwable -> L31
        goto L26
    L14:
        if (r3 != 2) goto L16;
        r1[r2] = Double.valueOf(r6.getDouble(r2));     // Catch: Throwable -> L31
        goto L26
    L16:
        if (r3 != 3) goto L18;
        r1[r2] = r6.getString(r2);     // Catch: Throwable -> L31
        goto L26
    L18:
        if (r3 != 4) goto L21;
        r1[r2] = r6.getBlob(r2);     // Catch: Throwable -> L31
        goto L26
    L21:
        throw new IllegalStateException();     // Catch: Throwable -> L31
    L27:
        r0.addRow(r1);     // Catch: Throwable -> L31
        goto L5
    L29:
        r6.close();
        return r0;
    L31:
        th = move-exception;
        r6.close();
        throw th;
    }

    public static int a(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        int r0 = r4.getColumnIndex(r3);
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r4.getColumnIndex("`" + r3 + "`");
        if (r1 < 0) goto L9;
        return r1;
    L9:
        return c(r4, r3);
    }

    public static int b(Cursor r3, String r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.aiagent.plugin");
        int r0 = a(r5, r4);
        if (r0 < 0) goto L11;
        return r0;
    L11:
        String r6 = Arrays.toString(r5.getColumnNames());     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException("column '" + r4 + "' does not exist. Available columns: " + r6);
    L7:
        e = move-exception;
        a("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
        r6 = "";
        goto L10
    }

    private static int c(Cursor r3, String r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT <= 25) goto L6;
        return -1;
    L6:
        if (r4.length() != 0) goto L9;
        return -1;
    L9:
        return a(r5.getColumnNames(), r4);
    }

    static int a(String[] r7, String r8) {
        String r0 = "." + r8;
        String r1 = "." + r8 + "`";
        int r3 = 0;
    L4:
        if (r3 >= r7.length) goto L16;
        String r4 = r7[r3];
        if (r4.length() < (r8.length() + 2)) goto L15;
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

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
