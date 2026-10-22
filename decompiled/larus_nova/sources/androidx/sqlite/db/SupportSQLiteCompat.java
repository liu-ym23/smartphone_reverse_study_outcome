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
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat;", "", "()V", "Api16Impl", "Api19Impl", "Api21Impl", "Api23Impl", "Api29Impl", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SupportSQLiteCompat {

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007JI\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0007¨\u0006 "}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api16Impl;", "", "()V", "cancel", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "createCancellationSignal", "deleteDatabase", "", "file", "Ljava/io/File;", "disableWriteAheadLogging", "sQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "isWriteAheadLoggingEnabled", "rawQueryWithFactory", "Landroid/database/Cursor;", "sql", "", "selectionArgs", "", "editTable", "cursorFactory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enable", "setWriteAheadLoggingEnabled", "sQLiteOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "enabled", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api16Impl {
        public static final Api16Impl INSTANCE = null;

        static {
            INSTANCE = new Api16Impl();
        }

        private Api16Impl() {
        }

        @JvmStatic
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @JvmStatic
        public static final void cancel(CancellationSignal r100) {
            Intrinsics.checkNotNullParameter(r100, "cancellationSignal");
            r100.cancel();
        }

        @JvmStatic
        public static final boolean deleteDatabase(File r100) {
            Intrinsics.checkNotNullParameter(r100, "file");
            return SQLiteDatabase.deleteDatabase(r100);
        }

        @JvmStatic
        public static final void disableWriteAheadLogging(SQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "sQLiteDatabase");
            r100.disableWriteAheadLogging();
        }

        @JvmStatic
        public static final boolean isWriteAheadLoggingEnabled(SQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "sQLiteDatabase");
            return r100.isWriteAheadLoggingEnabled();
        }

        @JvmStatic
        public static final void setForeignKeyConstraintsEnabled(SQLiteDatabase r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "sQLiteDatabase");
            r100.setForeignKeyConstraintsEnabled(r101);
        }

        @JvmStatic
        public static final void setWriteAheadLoggingEnabled(SQLiteOpenHelper r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "sQLiteOpenHelper");
            r100.setWriteAheadLoggingEnabled(r101);
        }

        @JvmStatic
        public static final Cursor rawQueryWithFactory(SQLiteDatabase r100, String r101, String[] r102, String r103, CancellationSignal r110, SQLiteDatabase.CursorFactory r111) {
            Intrinsics.checkNotNullParameter(r100, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(r101, "sql");
            Intrinsics.checkNotNullParameter(r102, "selectionArgs");
            Intrinsics.checkNotNullParameter(r110, "cancellationSignal");
            Intrinsics.checkNotNullParameter(r111, "cursorFactory");
            return r100.rawQueryWithFactory(r111, r101, r102, r103, r110);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api19Impl;", "", "()V", "getNotificationUri", "Landroid/net/Uri;", EffectConfiguration.KEY_CURSOR, "Landroid/database/Cursor;", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api19Impl {
        public static final Api19Impl INSTANCE = null;

        static {
            INSTANCE = new Api19Impl();
        }

        private Api19Impl() {
        }

        @JvmStatic
        public static final Uri getNotificationUri(Cursor r100) {
            Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_CURSOR);
            return r100.getNotificationUri();
        }

        @JvmStatic
        public static final boolean isLowRamDevice(ActivityManager r100) {
            Intrinsics.checkNotNullParameter(r100, "activityManager");
            return r100.isLowRamDevice();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api21Impl;", "", "()V", "getNoBackupFilesDir", "Ljava/io/File;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api21Impl {
        public static final Api21Impl INSTANCE = null;

        static {
            INSTANCE = new Api21Impl();
        }

        private Api21Impl() {
        }

        @JvmStatic
        public static final File getNoBackupFilesDir(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return r100.getNoBackupFilesDir();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api23Impl;", "", "()V", "setExtras", "", EffectConfiguration.KEY_CURSOR, "Landroid/database/Cursor;", "extras", "Landroid/os/Bundle;", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api23Impl {
        public static final Api23Impl INSTANCE = null;

        static {
            INSTANCE = new Api23Impl();
        }

        private Api23Impl() {
        }

        @JvmStatic
        public static final void setExtras(Cursor r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_CURSOR);
            Intrinsics.checkNotNullParameter(r101, "extras");
            r100.setExtras(r101);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0007¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api29Impl;", "", "()V", "getNotificationUris", "", "Landroid/net/Uri;", EffectConfiguration.KEY_CURSOR, "Landroid/database/Cursor;", "setNotificationUris", "", SRStrategy.KEY_CURRENT_RESOLUTION, "Landroid/content/ContentResolver;", "uris", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = null;

        static {
            INSTANCE = new Api29Impl();
        }

        private Api29Impl() {
        }

        @JvmStatic
        public static final List<Uri> getNotificationUris(Cursor r100) {
            Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_CURSOR);
            List<Uri> r101 = r100.getNotificationUris();
            Intrinsics.checkNotNull(r101);
            return r101;
        }

        @JvmStatic
        public static final void setNotificationUris(Cursor r100, ContentResolver r101, List<? extends Uri> r102) {
            Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_CURSOR);
            Intrinsics.checkNotNullParameter(r101, SRStrategy.KEY_CURRENT_RESOLUTION);
            Intrinsics.checkNotNullParameter(r102, "uris");
            r100.setNotificationUris(r101, r102);
        }
    }

    private SupportSQLiteCompat() {
    }
}
