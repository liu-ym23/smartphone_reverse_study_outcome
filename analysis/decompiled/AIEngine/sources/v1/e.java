package v1;

import android.database.Cursor;
import androidx.datastore.preferences.protobuf.b1;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.g;
import v1.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {
    public static final List<c.C0154c> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(ModelDownloadNotifier.EXTRA_NOTIF_ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        ListBuilder listBuilderY = b1.y();
        while (cursor.moveToNext()) {
            int i10 = cursor.getInt(columnIndex);
            int i11 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            g.e(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            g.e(string2, "cursor.getString(toColumnIndex)");
            listBuilderY.add(new c.C0154c(string, i10, i11, string2));
        }
        return kotlin.collections.a.H0(b1.i(listBuilderY));
    }

    public static final c.d b(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, boolean z) throws IOException {
        Cursor cursorO0 = frameworkSQLiteDatabase.o0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorO0.getColumnIndex("seqno");
            int columnIndex2 = cursorO0.getColumnIndex("cid");
            int columnIndex3 = cursorO0.getColumnIndex("name");
            int columnIndex4 = cursorO0.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorO0.moveToNext()) {
                    if (cursorO0.getInt(columnIndex2) >= 0) {
                        int i10 = cursorO0.getInt(columnIndex);
                        String columnName = cursorO0.getString(columnIndex3);
                        String str2 = cursorO0.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i10);
                        g.e(columnName, "columnName");
                        treeMap.put(numValueOf, columnName);
                        treeMap2.put(Integer.valueOf(i10), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                g.e(collectionValues, "columnsMap.values");
                List listO0 = kotlin.collections.a.O0(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                g.e(collectionValues2, "ordersMap.values");
                c.d dVar = new c.d(str, z, listO0, kotlin.collections.a.O0(collectionValues2));
                cursorO0.close();
                return dVar;
            }
            cursorO0.close();
            return null;
        } finally {
        }
    }
}
