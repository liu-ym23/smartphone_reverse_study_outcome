package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: SupportSQLiteCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: SupportSQLiteCompat.java */
    public static final class a {
        public static boolean a(File r0) {
            return SQLiteDatabase.deleteDatabase(r0);
        }

        public static Cursor a(SQLiteDatabase r6, String r7, String[] r8, String r9, CancellationSignal r10, SQLiteDatabase.CursorFactory r11) {
            return r6.rawQueryWithFactory((SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r11, SQLiteDatabase.CursorFactory.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
        }

        public static boolean a(SQLiteDatabase r0) {
            return r0.isWriteAheadLoggingEnabled();
        }

        public static void a(SQLiteOpenHelper r0, boolean r1) {
            r0.setWriteAheadLoggingEnabled(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.sqlite.db.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SupportSQLiteCompat.java */
    public static final class C0076b {
        public static Uri a(Cursor r2) {
            return ((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin")).getNotificationUri();
        }

        public static boolean a(ActivityManager r0) {
            return r0.isLowRamDevice();
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteCompat.java */
    public static final class c {
        public static File a(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getNoBackupFilesDir();
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteCompat.java */
    public static final class d {
        public static void a(Cursor r2, Bundle r3) {
            ((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin")).setExtras(r3);
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteCompat.java */
    public static final class e {
        public static void a(Cursor r2, ContentResolver r3, List<Uri> r4) {
            ((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin")).setNotificationUris(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
        }

        public static List<Uri> a(Cursor r2) {
            return ((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin")).getNotificationUris();
        }
    }
}
