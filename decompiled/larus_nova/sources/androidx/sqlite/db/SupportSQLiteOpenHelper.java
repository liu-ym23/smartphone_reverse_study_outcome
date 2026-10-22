package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Pair;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "Callback", "Configuration", "Factory", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SupportSQLiteOpenHelper extends Closeable {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "version", "", "(I)V", "deleteDatabaseFile", "", "fileName", "", "onConfigure", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onCorruption", WidgetCostModule.TYPE_ON_CREATE, "onDowngrade", "oldVersion", "newVersion", "onOpen", "onUpgrade", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Callback {
        public static final Companion Companion = null;
        private static final String TAG = "SupportSQLite";
        public final int version;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback$Companion;", "", "()V", "TAG", "", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public void onConfigure(SupportSQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "db");
        }

        public abstract void onCreate(SupportSQLiteDatabase r100);

        public void onOpen(SupportSQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "db");
        }

        public abstract void onUpgrade(SupportSQLiteDatabase r100, int r101, int r102);

        public Callback(int r100) {
            this.version = r100;
        }

        private final void deleteDatabaseFile(String r100) {
            boolean r101 = true;
            if (StringsKt.equals(r100, SQLiteDatabase.MEMORY, true) == true) goto L42;
            int r102 = r100.length() - 1;
            int r103 = 0;
            boolean r104 = false;
        L5:
            if (r103 > r102) goto L21;
            if (r104 == true) goto L8;
            int r105 = r103;
        L10:
            if (Intrinsics.compare(r100.charAt(r105), 32) > 0) goto L12;
            boolean r106 = true;
        L13:
            if (r104 == false) goto L14;
            if (r106 == false) goto L21;
            r102 = r102 - 1;
            goto L5
        L14:
            if (r106 == false) goto L15;
            r103 = r103 + 1;
            goto L5
        L15:
            r104 = true;
            goto L5
        L12:
            r106 = false;
            goto L13
        L8:
            r105 = r102;
        L21:
            if (r100.subSequence(r103, r102 + 1).toString().length() == 0) goto L24;
            r101 = false;
        L24:
            if (r101 == false) goto L30;
            return;
        L30:
            SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(r100));     // Catch: Exception -> L29
            return;
        L44:
            return;
        }

        public void onCorruption(SupportSQLiteDatabase r100) {
            Intrinsics.checkNotNullParameter(r100, "db");
            Objects.toString(r100);
            if (r100.isOpen() == true) goto L8;
            String r101 = r100.getPath();
            if (r101 == null) goto L41;
            deleteDatabaseFile(r101);
            return;
        L41:
            return;
        L8:
            List<Pair<String, String>> r102 = null;
            r102 = r100.getAttachedDbs();     // Catch: Throwable -> L11 SQLiteException -> L34
        L11:
            th = move-exception;
            if (r102 == null) goto L20;
            Iterator<T> r103 = r102.iterator();
        L18:
            if (r103.hasNext() == false) goto L23;
            deleteDatabaseFile((String) ((Pair) r103.next()).second);
        L23:
            throw th;
        L20:
            String r104 = r100.getPath();
            if (r104 == null) goto L23;
            deleteDatabaseFile(r104);
        L38:
            r100.close();     // Catch: Throwable -> L11 IOException -> L24
        L25:
            if (r102 == null) goto L30;
            Iterator<T> r105 = r102.iterator();
        L28:
            if (r105.hasNext() == false) goto L43;
            deleteDatabaseFile((String) ((Pair) r105.next()).second);
            goto L28
        L43:
            return;
        L30:
            String r106 = r100.getPath();
            if (r106 == null) goto L42;
            deleteDatabaseFile(r106);
            return;
        }

        public void onDowngrade(SupportSQLiteDatabase r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "db");
            throw new SQLiteException("Can't downgrade database from version " + r101 + " to " + r102);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "Builder", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Configuration {
        public static final Companion Companion = null;
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowDataLossOnRecovery", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "name", "", "useNoBackupDirectory", "build", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "noBackupDirectory", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Configuration build() {
                Callback r100 = this.callback;
                if (r100 == null) goto L22;
                boolean r101 = true;
                if (this.useNoBackupDirectory == false) goto L16;
                String r102 = this.name;
                if (r102 != null) goto L9;
            L12:
                boolean r103 = true;
            L13:
                if (r103 == false) goto L16;
                r101 = false;
                goto L16
            L9:
                if (r102.length() == 0) goto L12;
                r103 = false;
            L16:
                if (r101 == false) goto L20;
                return new Configuration(this.context, this.name, r100, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            L20:
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
            L22:
                throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
            }

            public Builder(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                this.context = r100;
            }

            public Builder allowDataLossOnRecovery(boolean r100) {
                this.allowDataLossOnRecovery = r100;
                return this;
            }

            public Builder callback(Callback r100) {
                Intrinsics.checkNotNullParameter(r100, "callback");
                this.callback = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder noBackupDirectory(boolean r100) {
                this.useNoBackupDirectory = r100;
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Companion;", "", "()V", "builder", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final Builder builder(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                return new Builder(r100);
            }
        }

        static {
            Companion = new Companion(null);
        }

        @JvmStatic
        public static final Builder builder(Context r100) {
            return Companion.builder(r100);
        }

        public Configuration(Context r100, String r101, Callback r102, boolean r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "callback");
            this.context = r100;
            this.name = r101;
            this.callback = r102;
            this.useNoBackupDirectory = r103;
            this.allowDataLossOnRecovery = r104;
        }

        public /* synthetic */ Configuration(Context r100, String r101, Callback r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 8) == 0) goto L5;
            boolean r102 = false;
        L7:
            if ((r113 & 16) == 0) goto L9;
            boolean r103 = false;
        L10:
            this(r100, r101, r110, r102, r103);
            return;
        L9:
            r103 = r112;
            goto L10
        L5:
            r102 = r111;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration r100);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean r100);
}
