package androidx.room.util;

import B7.a;
import D7.q;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.core.os.EnvironmentCompat;
import j9.t;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\b\u001a%\u0010\u000b\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u000e\u001a1\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f*\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0010H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Landroid/database/Cursor;", "c", "copyAndClose", "(Landroid/database/Cursor;)Landroid/database/Cursor;", "", HintConstants.AUTOFILL_HINT_NAME, "", "getColumnIndex", "(Landroid/database/Cursor;Ljava/lang/String;)I", "getColumnIndexOrThrow", "cursor", "findColumnIndexBySuffix", "", "columnNames", "([Ljava/lang/String;Ljava/lang/String;)I", "R", "Lkotlin/Function1;", "block", "useCursor", "(Landroid/database/Cursor;LS7/k;)Ljava/lang/Object;", "", "mapping", "wrapMappedColumns", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor c) throws IOException {
        k.f(c, "c");
        Cursor cursor = c;
        try {
            Cursor cursor2 = cursor;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = c.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor2.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(cursor2.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(cursor2.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor2.getString(i);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i] = cursor2.getBlob(i);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            cursor.close();
            return matrixCursor;
        } finally {
        }
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        return -1;
    }

    public static final int getColumnIndex(Cursor c, String name) {
        k.f(c, "c");
        k.f(name, "name");
        int columnIndex = c.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c.getColumnIndex("`" + name + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c, name);
    }

    public static final int getColumnIndexOrThrow(Cursor c, String name) {
        String strX0;
        k.f(c, "c");
        k.f(name, "name");
        int columnIndex = getColumnIndex(c, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c.getColumnNames();
            k.e(columnNames, "getColumnNames(...)");
            strX0 = q.x0(columnNames, null, null, null, null, 63);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            strX0 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        throw new IllegalArgumentException(a.n("column '", name, "' does not exist. Available columns: ", strX0));
    }

    public static final <R> R useCursor(Cursor cursor, S7.k block) throws IOException {
        k.f(cursor, "<this>");
        k.f(block, "block");
        Cursor cursor2 = cursor;
        try {
            R r5 = (R) block.invoke(cursor2);
            cursor2.close();
            return r5;
        } finally {
        }
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, final String[] columnNames, final int[] mapping) {
        k.f(cursor, "cursor");
        k.f(columnNames, "columnNames");
        k.f(mapping, "mapping");
        if (columnNames.length == mapping.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil.wrapMappedColumns.2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(String columnName) {
                    k.f(columnName, "columnName");
                    String[] strArr = columnNames;
                    int[] iArr = mapping;
                    int length = strArr.length;
                    int i = 0;
                    int i6 = 0;
                    while (i < length) {
                        int i10 = i6 + 1;
                        if (t.X(strArr[i], columnName)) {
                            return iArr[i6];
                        }
                        i++;
                        i6 = i10;
                    }
                    return super.getColumnIndex(columnName);
                }
            };
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length");
    }

    @VisibleForTesting
    public static final int findColumnIndexBySuffix(String[] columnNames, String name) {
        k.f(columnNames, "columnNames");
        k.f(name, "name");
        String strConcat = ".".concat(name);
        String strM = b.m('`', ".", name);
        int length = columnNames.length;
        int i = 0;
        int i6 = 0;
        while (i < length) {
            String str = columnNames[i];
            int i10 = i6 + 1;
            if (str.length() >= name.length() + 2 && (t.W(str, strConcat, false) || (str.charAt(0) == '`' && t.W(str, strM, false)))) {
                return i6;
            }
            i++;
            i6 = i10;
        }
        return -1;
    }
}
