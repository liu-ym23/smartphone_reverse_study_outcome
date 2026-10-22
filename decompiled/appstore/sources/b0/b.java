package b0;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final CancellationSignal a() {
        return c0.b.b();
    }

    public static final void b(SupportSQLiteDatabase r10) {
        q.g(r10, CloudControlInf.DB);
        List r11 = s.c();
        Cursor r12 = r10.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    L20:
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        kotlin.io.b.a(r12, th);
        throw th;
    L4:
        if (r12.moveToNext() == false) goto L8;
        r11.add(r12.getString(0));     // Catch: Throwable -> L6
        goto L20
    L8:
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L6
        kotlin.io.b.a(r12, null);
        Iterator r14 = s.a(r11).iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        String r15 = (String) r14.next();
        q.f(r15, "triggerName");
        if (o.B(r15, "room_fts_content_sync_", false, 2, null) == false) goto L11;
        r10.execSQL("DROP TRIGGER IF EXISTS " + r15);
        goto L11
    }

    public static final Cursor c(RoomDatabase r10, SupportSQLiteQuery r11, boolean r12, CancellationSignal r13) {
        q.g(r10, CloudControlInf.DB);
        q.g(r11, "sqLiteQuery");
        Cursor r14 = r10.A(r11, r13);
        if (r12 == true) goto L5;
        return r14;
    L5:
        if ((r14 instanceof AbstractWindowedCursor) == false) goto L14;
        AbstractWindowedCursor r15 = (AbstractWindowedCursor) r14;
        int r16 = r15.getCount();
        if (r15.hasWindow() == false) goto L9;
        int r17 = r15.getWindow().getNumRows();
    L10:
        if (r17 < r16) goto L12;
        return r14;
    L12:
        return a.a(r14);
    L9:
        r17 = r16;
        goto L10
    L14:
        return r14;
    }

    public static final int d(File r10) {
        q.g(r10, "databaseFile");
        FileChannel r11 = new FileInputStream(r10).getChannel();
        ByteBuffer r12 = ByteBuffer.allocate(4);     // Catch: Throwable -> L8
        r11.tryLock(60, 4, true);     // Catch: Throwable -> L8
        r11.position(60);     // Catch: Throwable -> L8
        if (r11.read(r12) != 4) goto L11;
        r12.rewind();     // Catch: Throwable -> L8
        int r13 = r12.getInt();     // Catch: Throwable -> L8
        kotlin.io.b.a(r11, null);
        return r13;
    L11:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        kotlin.io.b.a(r11, th);
        throw th;
    }
}
