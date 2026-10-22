package com.obric.aiagent.executionengine.eventstaskmanager.migration;

import android.database.Cursor;
import android.os.Build;
import androidx.room.p;
import androidx.sqlite.db.f;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: TaskDatabaseBackupUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "TaskDatabaseBackup";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17455a = null;

    static {
        f17455a = new c();
    }

    private c() {
    }

    public final boolean a(p r5, String r6, String r7) {
        o.e(r5, MonitorConstants.DB);
        o.e(r6, "backupFileName");
        o.e(r7, "exportDir");
        File r8 = a(r6, r7);     // Catch: Exception -> L9
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "Start backing up database to " + r8.getAbsolutePath());     // Catch: Exception -> L9
        if (Build.VERSION.SDK_INT < 30) goto L6;
        a(r5, r8);     // Catch: Exception -> L9
    L7:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "Backup database " + r6 + " finished");     // Catch: Exception -> L9
        return true;
    L6:
        b(r5, r8);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "Failed to backup database " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    public final void a(p r7, String r8) {
        o.e(r7, MonitorConstants.DB);
        o.e(r8, "tableName");
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r7.query((f) ZeusTransformUtils.preCheckCast(new androidx.sqlite.db.a("SELECT COUNT(*) FROM " + r8), f.class, "com.obric.aiagent.plugin"), null), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1.moveToFirst() == false) goto L7;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "Table " + r8 + " has " + r1.getInt(0) + " records in backup.");     // Catch: Throwable -> L10
    L7:
        x r2 = x.f38692a;     // Catch: Throwable -> L10
        d.f.c.a(r9, null);     // Catch: Exception -> L15
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.f.c.a(r9, th);     // Catch: Exception -> L15
        throw th;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "Failed to print table records for " + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final File a(String r2, String r3) {
        File r1 = new File(r3, r2);
        File r4 = r1.getParentFile();
        if (r4 != null) goto L5;
    L11:
        return r1;
    L5:
        if (r4.exists() == true) goto L11;
        if (r4.mkdirs() == true) goto L11;
        throw new IOException("Failed to create export directory " + r3);
    }

    private final void a(p r4, File r5) {
        if (r5.exists() == true) goto L5;
    L7:
        Cursor r3 = r4.query((f) ZeusTransformUtils.preCheckCast(new androidx.sqlite.db.a("VACUUM INTO '" + r5.getAbsolutePath() + '\''), f.class, "com.obric.aiagent.plugin"), null);
        o.c(r3, "query(...)");
        r3.moveToFirst();
        r3.close();
        if (r5.exists() == false) goto L11;
        return;
    L11:
        throw new IOException("Backup file not found after VACUUM INTO: " + r5.getAbsolutePath());
    L5:
        if (r5.delete() == true) goto L7;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.a(TAG, "Failed to delete old export file: " + r5.getAbsolutePath(), null);
        goto L7
    }

    private final void b(p r4, File r5) {
        Cursor r0 = r4.query((f) ZeusTransformUtils.preCheckCast(new androidx.sqlite.db.a("PRAGMA wal_checkpoint(TRUNCATE)"), f.class, "com.obric.aiagent.plugin"), null);
        o.c(r0, "query(...)");
        r0.moveToFirst();
        r0.close();
        File r1 = new File(r4.b().b().h());
        if (r1.exists() == false) goto L7;
        a(r1, r5);
        return;
    L7:
        throw new IOException("Database file not found: " + r1.getAbsolutePath());
    }

    private final void a(File r5, File r6) {
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r7 = (FileInputStream) ZeusTransformUtils.preCheckCast(r4, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        FileOutputStream r1 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r8, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast(r7, InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r1, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L8
        d.f.c.a(r8, null);     // Catch: Throwable -> L13
        d.f.c.a(r4, null);
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d.f.c.a(r8, th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.f.c.a(r4, th);
        throw th;
    }
}
