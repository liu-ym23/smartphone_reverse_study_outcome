package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DBUtil {
    @Deprecated
    public static Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean maybeCopy) {
        return query(db, sqLiteQuery, maybeCopy, null);
    }

    public static Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean maybeCopy, CancellationSignal signal) {
        Cursor r0 = db.query(sqLiteQuery, signal);
        if (maybeCopy == true) goto L5;
        return r0;
    L5:
        if ((r0 instanceof AbstractWindowedCursor) == false) goto L14;
        AbstractWindowedCursor r1 = (AbstractWindowedCursor) r0;
        int r2 = r1.getCount();
        if (r1.hasWindow() == false) goto L9;
        int r3 = r1.getWindow().getNumRows();
    L10:
        if (r3 < r2) goto L12;
        return r0;
    L12:
        return CursorUtil.copyAndClose(r1);
    L9:
        r3 = r2;
        goto L10
    L14:
        return r0;
    }

    public static void dropFtsSyncTriggers(SupportSQLiteDatabase db) {
        ArrayList r0 = new ArrayList();
        Cursor r1 = db.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    L17:
    L14:
        th = move-exception;
        r1.close();
        throw th;
    L4:
        if (r1.moveToNext() == false) goto L7;
        r0.add(r1.getString(0));     // Catch: Throwable -> L14
        goto L17
    L7:
        r1.close();
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) r2.next();
        if (r3.startsWith("room_fts_content_sync_") == false) goto L9;
        db.execSQL("DROP TRIGGER IF EXISTS " + r3);
        goto L9
    }

    public static int readVersion(File databaseFile) throws IOException {
        FileChannel r1 = null;
        ByteBuffer r2 = ByteBuffer.allocate(4);     // Catch: Throwable -> L11
        FileChannel r3 = new FileInputStream(databaseFile).getChannel();     // Catch: Throwable -> L11
        r3.tryLock(60, 4, true);     // Catch: Throwable -> L11
        r3.position(60);     // Catch: Throwable -> L11
        if (r3.read(r2) != 4) goto L10;
        r2.rewind();     // Catch: Throwable -> L11
        int r10 = r2.getInt();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.close();
    L8:
        return r10;
    L10:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (0 == 0) goto L14;
        r1.close();
    L14:
        throw th;
    }

    public static CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    private DBUtil() {
    }
}
