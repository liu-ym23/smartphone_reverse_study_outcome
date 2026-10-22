package v1;

import android.database.Cursor;
import android.util.Log;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static final int a(Cursor c9, String str) {
        String strJ0;
        g.f(c9, "c");
        int columnIndex = c9.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = c9.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                columnIndex = -1;
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c9.getColumnNames();
            g.e(columnNames, "c.columnNames");
            strJ0 = l.j0(columnNames, null, 63);
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            strJ0 = "unknown";
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.l("column '", str, "' does not exist. Available columns: ", strJ0));
    }
}
