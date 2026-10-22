package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DBUtil {
    public static CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    private DBUtil() {
    }

    public static void dropFtsSyncTriggers(SupportSQLiteDatabase r100) {
        ArrayList r101 = new ArrayList();
        Cursor r102 = r100.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    L17:
    L14:
        th = move-exception;
        r102.close();
        throw th;
    L4:
        if (r102.moveToNext() == false) goto L7;
        r101.add(r102.getString(0));     // Catch: Throwable -> L14
        goto L17
    L7:
        r102.close();
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        String r104 = (String) r103.next();
        if (r104.startsWith("room_fts_content_sync_") == false) goto L9;
        r100.execSQL("DROP TRIGGER IF EXISTS ".concat(r104));
        goto L9
    }

    private static String processForeignKeyCheckFailure(Cursor r100) {
        int r101 = r100.getCount();
        HashMap r102 = new HashMap();
        String r103 = null;
    L4:
        if (r100.moveToNext() == false) goto L10;
        if (r103 != null) goto L7;
        r103 = r100.getString(0);
    L7:
        String r104 = r100.getString(3);
        if (r102.containsKey(r104) == true) goto L4;
        r102.put(r104, r100.getString(2));
        goto L4
    L10:
        StringBuilder r105 = new StringBuilder("Foreign key violation(s) detected in '");
        r105.append(r103);
        r105.append("'.\nNumber of different violations discovered: ");
        r105.append(r102.keySet().size());
        r105.append("\nNumber of rows in violation: ");
        r105.append(r101);
        r105.append("\nViolation(s) detected in the following constraint(s):\n");
        Iterator r106 = r102.entrySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L15;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.append("\tParent Table = ");
        r105.append((String) r107.getValue());
        r105.append(", Foreign Key Constraint Index = ");
        r105.append((String) r107.getKey());
        r105.append("\n");
        goto L12
    L15:
        return r105.toString();
    }

    public static int readVersion(File r110) throws IOException {
        FileChannel r100 = null;
        ByteBuffer r101 = ByteBuffer.allocate(4);     // Catch: Throwable -> L10
        FileChannel r102 = new FileInputStream(r110).getChannel();     // Catch: Throwable -> L10
        r102.tryLock(60, 4, true);     // Catch: Throwable -> L10
        r102.position(60);     // Catch: Throwable -> L10
        if (r102.read(r101) != 4) goto L9;
        r101.rewind();     // Catch: Throwable -> L10
        int r111 = r101.getInt();     // Catch: Throwable -> L10
        r102.close();
        return r111;
    L9:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (0 == 0) goto L13;
        r100.close();
    L13:
        throw th;
    }

    public static void foreignKeyCheck(SupportSQLiteDatabase r100, String r101) {
        Cursor r102 = r100.query("PRAGMA foreign_key_check(`" + r101 + "`)");
    L9:
        th = move-exception;
        r102.close();
        throw th;
    L4:
        if (r102.getCount() > 0) goto L8;
        r102.close();
        return;
    L8:
        throw new IllegalStateException(processForeignKeyCheckFailure(r102));     // Catch: Throwable -> L9
    }

    public static Cursor query(RoomDatabase r100, SupportSQLiteQuery r101, boolean r102) {
        return query(r100, r101, r102, null);
    }

    public static Cursor query(RoomDatabase r100, SupportSQLiteQuery r101, boolean r102, CancellationSignal r103) {
        Cursor r104 = r100.query(r101, r103);
        if (r102 == true) goto L5;
        return r104;
    L5:
        if ((r104 instanceof AbstractWindowedCursor) == false) goto L16;
        AbstractWindowedCursor r105 = (AbstractWindowedCursor) r104;
        int r106 = r105.getCount();
        if (r105.hasWindow() == false) goto L9;
        int r107 = r105.getWindow().getNumRows();
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r107 < r106) goto L14;
        return r104;
    L14:
        return CursorUtil.copyAndClose(r105);
    L9:
        r107 = r106;
        goto L11
    L16:
        return r104;
    }
}
