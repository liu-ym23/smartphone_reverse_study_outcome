package androidx.room.b;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: DBUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    @Deprecated
    public static Cursor query(p r2, androidx.sqlite.db.f r3, boolean r4) {
        return query(r2, (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin"), r4, null);
    }

    public static Cursor query(p r2, androidx.sqlite.db.f r3, boolean r4, CancellationSignal r5) {
        Cursor r6 = r2.query((androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin"), r5);
        if (r4 == true) goto L5;
        return r6;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, AbstractWindowedCursor.class) == false) goto L16;
        AbstractWindowedCursor r7 = (AbstractWindowedCursor) ZeusTransformUtils.preCheckCast(r6, AbstractWindowedCursor.class, "com.obric.aiagent.plugin");
        int r8 = r7.getCount();
        if (r7.hasWindow() == false) goto L9;
        int r9 = r7.getWindow().getNumRows();
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r9 < r8) goto L14;
        return r6;
    L14:
        return b.a(r7);
    L9:
        r9 = r8;
        goto L11
    L16:
        return r6;
    }

    public static void a(androidx.sqlite.db.c r5) {
        androidx.sqlite.db.c r6 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r5, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        Cursor r2 = r6.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    L17:
    L14:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToNext() == false) goto L7;
        r0.add(r2.getString(0));     // Catch: Throwable -> L14
        goto L17
    L7:
        r2.close();
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (r3.startsWith("room_fts_content_sync_") == false) goto L9;
        r6.b("DROP TRIGGER IF EXISTS " + r3);
        goto L9
    }

    public static int a(File r10) {
        FileChannel r1 = null;
        ByteBuffer r2 = ByteBuffer.allocate(4);     // Catch: Throwable -> L11
        FileChannel r3 = new FileInputStream(r10).getChannel();     // Catch: Throwable -> L11
        r3.tryLock(60, 4, true);     // Catch: Throwable -> L11
        r3.position(60);     // Catch: Throwable -> L11
        if (r3.read(r2) != 4) goto L10;
        r2.rewind();     // Catch: Throwable -> L11
        int r11 = r2.getInt();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.close();
    L8:
        return r11;
    L10:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (0 == 0) goto L14;
        r1.close();
    L14:
        throw th;
    }
}
