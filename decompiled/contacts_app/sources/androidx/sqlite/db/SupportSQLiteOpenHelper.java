package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    public static abstract class Callback {
        private static final String TAG = "SupportSQLite";
        public final int version;

        public void onConfigure(SupportSQLiteDatabase r1) {
        }

        public abstract void onCreate(SupportSQLiteDatabase r1);

        public void onOpen(SupportSQLiteDatabase r1) {
        }

        public abstract void onUpgrade(SupportSQLiteDatabase r1, int r2, int r3);

        public Callback(int r1) {
            this.version = r1;
        }

        public void onDowngrade(SupportSQLiteDatabase r2, int r3, int r4) {
            throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
        }

        public void onCorruption(SupportSQLiteDatabase r3) {
            Log.e(TAG, "Corruption reported by sqlite on database: " + r3.getPath());
            if (r3.isOpen() == true) goto L6;
            deleteDatabaseFile(r3.getPath());
            return;
        L6:
            List<Pair<String, String>> r0 = null;
            r0 = r3.getAttachedDbs();     // Catch: Throwable -> L9 SQLiteException -> L27
        L9:
            th = move-exception;
            if (r0 == null) goto L18;
            Iterator<Pair<String, String>> r4 = r0.iterator();
        L16:
            if (r4.hasNext() == false) goto L19;
            deleteDatabaseFile((String) r4.next().second);
        L19:
            throw th;
        L18:
            deleteDatabaseFile(r3.getPath());
        L29:
            r3.close();     // Catch: Throwable -> L9 IOException -> L28
        L20:
            if (r0 == null) goto L25;
            Iterator<Pair<String, String>> r5 = r0.iterator();
        L23:
            if (r5.hasNext() == false) goto L35;
            deleteDatabaseFile((String) r5.next().second);
            goto L23
        L35:
            return;
        L25:
            deleteDatabaseFile(r3.getPath());
        }

        private void deleteDatabaseFile(String r2) {
            if (r2.equalsIgnoreCase(":memory:") == false) goto L5;
            return;
        L5:
            if (r2.trim().length() == 0) goto L16;
            Log.w(TAG, "deleting the database file: " + r2);
            SQLiteDatabase.deleteDatabase(new File(r2));     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            Log.w(TAG, "delete failed: ", e);
            return;
        }
    }

    public static class Configuration {
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        public static class Builder {
            Callback mCallback;
            Context mContext;
            String mName;
            boolean mUseNoBackUpDirectory;

            public Configuration build() {
                if (this.mCallback == null) goto L18;
                if (this.mContext == null) goto L16;
                if (this.mUseNoBackUpDirectory == false) goto L14;
                if (TextUtils.isEmpty(this.mName) == false) goto L14;
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            L14:
                return new Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackUpDirectory);
            L16:
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            L18:
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            Builder(Context r1) {
                this.mContext = r1;
            }

            public Builder name(String r1) {
                this.mName = r1;
                return this;
            }

            public Builder callback(Callback r1) {
                this.mCallback = r1;
                return this;
            }

            public Builder noBackupDirectory(boolean r1) {
                this.mUseNoBackUpDirectory = r1;
                return this;
            }
        }

        Configuration(Context r2, String r3, Callback r4) {
            this(r2, r3, r4, false);
        }

        Configuration(Context r1, String r2, Callback r3, boolean r4) {
            this.context = r1;
            this.name = r2;
            this.callback = r3;
            this.useNoBackupDirectory = r4;
        }

        public static Builder builder(Context r1) {
            return new Builder(r1);
        }
    }

    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean r1);
}
