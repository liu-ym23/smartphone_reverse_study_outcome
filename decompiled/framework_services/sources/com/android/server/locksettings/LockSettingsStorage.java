package com.android.server.locksettings;

import android.app.backup.BackupManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.UserInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.os.Environment;
import android.os.UserManager;
import android.service.persistentdata.PersistentDataBlockManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.pdb.PersistentDataBlockManagerInternal;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class LockSettingsStorage {
    private static final String CHILD_PROFILE_LOCK_FILE = "gatekeeper.profile.key";
    private static final String[] COLUMNS_FOR_PREFETCH = null;
    private static final String[] COLUMNS_FOR_QUERY = null;
    private static final String COLUMN_KEY = "name";
    private static final String COLUMN_USERID = "user";
    private static final String COLUMN_VALUE = "value";
    private static final Object DEFAULT = null;
    private static final String REBOOT_ESCROW_FILE = "reboot.escrow.key";
    private static final String REBOOT_ESCROW_SERVER_BLOB_FILE = "reboot.escrow.server.blob.key";
    private static final String REPAIR_MODE_DIRECTORY = "repair-mode/";
    private static final String REPAIR_MODE_PERSISTENT_FILE = "pst";
    private static final String[] SETTINGS_TO_BACKUP = null;
    private static final String SYNTHETIC_PASSWORD_DIRECTORY = "spblob/";
    private static final String TABLE = "locksettings";
    private static final String TAG = "LockSettingsStorage";
    private final Cache mCache;
    private final Context mContext;
    private final Object mFileWriteLock;
    private final DatabaseHelper mOpenHelper;
    private PersistentDataBlockManagerInternal mPersistentDataBlockManagerInternal;

    private static class Cache {
        private final ArrayMap<CacheKey, Object> mCache;
        private final CacheKey mCacheKey;
        private int mVersion;

        private static final class CacheKey {
            static final int TYPE_FETCHED = 2;
            static final int TYPE_FILE = 1;
            static final int TYPE_KEY_VALUE = 0;
            String key;
            int type;
            int userId;

            /* synthetic */ CacheKey(LockSettingsStorageIA r1) {
                this();
            }

            private CacheKey() {
            }

            public CacheKey set(int type, String key, int userId) {
                this.type = type;
                this.key = key;
                this.userId = userId;
                return this;
            }

            public boolean equals(Object obj) {
                if ((obj instanceof CacheKey) == true) goto L5;
                return false;
            L5:
                CacheKey o = (CacheKey) obj;
                if (this.userId == o.userId) goto L8;
                return false;
            L8:
                if (this.type == o.type) goto L10;
                return false;
            L10:
                if (Objects.equals(this.key, o.key) == false) goto L15;
                return true;
            L15:
                return false;
            }

            public int hashCode() {
                int hashCode = Objects.hashCode(this.key);
                int hashCode2 = (hashCode * 31) + this.userId;
                return (hashCode2 * 31) + this.type;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$mgetVersion, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5451$$Nest$mgetVersion(Cache r0) {
            return r0.getVersion();
        }

        /* synthetic */ Cache(LockSettingsStorageIA r1) {
            this();
        }

        private Cache() {
            this.mCache = new ArrayMap();
            this.mCacheKey = new CacheKey(null);
            this.mVersion = 0;
        }

        String peekKeyValue(String key, String defaultValue, int userId) {
            Object cached = peek(0, key, userId);
            if (cached != LockSettingsStorage.m5450$$Nest$sfgetDEFAULT()) goto L6;
            return defaultValue;
        L6:
            return (String) cached;
        }

        boolean hasKeyValue(String key, int userId) {
            return contains(0, key, userId);
        }

        void putKeyValue(String key, String value, int userId) {
            put(0, key, value, userId);
        }

        void putKeyValueIfUnchanged(String key, Object value, int userId, int version) {
            putIfUnchanged(0, key, value, userId, version);
        }

        void removeKey(String key, int userId) {
            remove(0, key, userId);
        }

        byte[] peekFile(File path) {
            return copyOf((byte[]) peek(1, path.toString(), -1));
        }

        boolean hasFile(File path) {
            return contains(1, path.toString(), -1);
        }

        void putFile(File path, byte[] data) {
            put(1, path.toString(), copyOf(data), -1);
        }

        void putFileIfUnchanged(File path, byte[] data, int version) {
            putIfUnchanged(1, path.toString(), copyOf(data), -1, version);
        }

        void setFetched(int userId) {
            put(2, "", "true", userId);
        }

        boolean isFetched(int userId) {
            return contains(2, "", userId);
        }

        private synchronized void remove(int type, String key, int userId) {
            monitor-enter(this);
            this.mCache.remove(this.mCacheKey.set(type, key, userId));     // Catch: Throwable -> L6
            this.mVersion++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized void put(int type, String key, Object value, int userId) {
            monitor-enter(this);
            this.mCache.put(new CacheKey(null).set(type, key, userId), value);     // Catch: Throwable -> L6
            this.mVersion++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized void putIfUnchanged(int type, String key, Object value, int userId, int version) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (contains(type, key, userId) == false) goto L6;
        L11:
            monitor-exit(this);
            return;
        L6:
            if (this.mVersion != version) goto L11;
            this.mCache.put(new CacheKey(null).set(type, key, userId), value);     // Catch: Throwable -> L9
            goto L11
        }

        private synchronized boolean contains(int type, String key, int userId) {
            monitor-enter(this);
            boolean r0 = this.mCache.containsKey(this.mCacheKey.set(type, key, userId));     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized Object peek(int type, String key, int userId) {
            monitor-enter(this);
            Object r0 = this.mCache.get(this.mCacheKey.set(type, key, userId));     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized int getVersion() {
            monitor-enter(this);
            int r0 = this.mVersion;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void removeUser(int userId) {
            monitor-enter(this);
            int i = this.mCache.size() - 1;     // Catch: Throwable -> L8
        L4:
            if (i < 0) goto L11;
            if (this.mCache.keyAt(i).userId != userId) goto L10;
            this.mCache.removeAt(i);     // Catch: Throwable -> L8
        L10:
            i = i - 1;     // Catch: Throwable -> L8
            goto L4
        L11:
            int i2 = this.mVersion;     // Catch: Throwable -> L8
            this.mVersion = i2 + 1;     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private byte[] copyOf(byte[] data) {
            if (data != null) goto L6;
            return null;
        L6:
            return Arrays.copyOf(data, data.length);
        }

        synchronized void purgePath(File path) {
            monitor-enter(this);
            String pathStr = path.toString();     // Catch: Throwable -> L10
            int i = this.mCache.size() - 1;     // Catch: Throwable -> L10
        L4:
            if (i < 0) goto L13;
            CacheKey entry = this.mCache.keyAt(i);     // Catch: Throwable -> L10
            if (entry.type != 1) goto L12;
            if (entry.key.startsWith(pathStr) == false) goto L12;
            this.mCache.removeAt(i);     // Catch: Throwable -> L10
        L12:
            i = i - 1;     // Catch: Throwable -> L10
            goto L4
        L13:
            int i2 = this.mVersion;     // Catch: Throwable -> L10
            this.mVersion = i2 + 1;     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        synchronized void clear() {
            monitor-enter(this);
            this.mCache.clear();     // Catch: Throwable -> L6
            this.mVersion++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public interface Callback {
        void initialize(SQLiteDatabase r1);
    }

    static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "locksettings.db";
        private static final int DATABASE_VERSION = 2;
        private static final int IDLE_CONNECTION_TIMEOUT_MS = 30000;
        private static final String TAG = "LockSettingsDB";
        private Callback mCallback;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 2);
            setWriteAheadLoggingEnabled(false);
            setIdleConnectionTimeout(30000);
        }

        public void setCallback(Callback callback) {
            this.mCallback = callback;
        }

        private void createTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE locksettings (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,user INTEGER,value TEXT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            createTable(db);
            if (this.mCallback == null) goto L6;
            this.mCallback.initialize(db);
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {
            int upgradeVersion = oldVersion;
            if (upgradeVersion != 1) goto L6;
            upgradeVersion = 2;
        L6:
            if (upgradeVersion == 2) goto L9;
            Slog.w(TAG, "Failed to upgrade database!");
            return;
        }
    }

    public static class PersistentData {
        public static final PersistentData NONE = null;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_SP_GATEKEEPER = 1;
        public static final int TYPE_SP_WEAVER = 2;
        static final byte VERSION_1 = 1;
        static final int VERSION_1_HEADER_SIZE = 10;
        final byte[] payload;
        final int qualityForUi;
        final int type;
        final int userId;

        static {
            NONE = new PersistentData(0, ProcessList.INVALID_ADJ, 0, null);
        }

        private PersistentData(int type, int userId, int qualityForUi, byte[] payload) {
            this.type = type;
            this.userId = userId;
            this.qualityForUi = qualityForUi;
            this.payload = payload;
        }

        public boolean isBadFormatFromAndroid14Beta() {
            if (this.type == 1) goto L7;
            if (this.type == 2) goto L7;
        L9:
            return false;
        L7:
            if (SyntheticPasswordManager.PasswordData.isBadFormatFromAndroid14Beta(this.payload) == false) goto L9;
            return true;
        }

        public static PersistentData fromBytes(byte[] frpData) {
            if (frpData == null) goto L19;
            if (frpData.length == 0) goto L19;
            DataInputStream is = new DataInputStream(new ByteArrayInputStream(frpData));
            byte version = is.readByte();     // Catch: IOException -> L12
            if (version != 1) goto L14;
            int type = is.readByte() & CecDeviceType.INACTIVE;     // Catch: IOException -> L12
            int userId = is.readInt();     // Catch: IOException -> L12
            int qualityForUi = is.readInt();     // Catch: IOException -> L12
            byte[] payload = new byte[frpData.length - 10];     // Catch: IOException -> L12
            System.arraycopy(frpData, 10, payload, 0, payload.length);     // Catch: IOException -> L12
            return new PersistentData(type, userId, qualityForUi, payload);
        L14:
            Slog.wtf(LockSettingsStorage.TAG, "Unknown PersistentData version code: " + version);     // Catch: IOException -> L12
            return NONE;
        L12:
            e = move-exception;
            Slog.wtf(LockSettingsStorage.TAG, "Could not parse PersistentData", e);
            return NONE;
        L19:
            return NONE;
        }

        public static byte[] toBytes(int persistentType, int userId, int qualityForUi, byte[] payload) {
            boolean r0 = false;
            if (persistentType != 0) goto L8;
            if (payload != null) goto L6;
            r0 = true;
        L6:
            Preconditions.checkArgument(r0, "TYPE_NONE must have empty payload");
            return null;
        L8:
            if (payload != null) goto L10;
        L12:
            Preconditions.checkArgument(r0, "empty payload must only be used with TYPE_NONE");
            ByteArrayOutputStream os = new ByteArrayOutputStream(payload.length + 10);
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeByte(1);     // Catch: IOException -> L16
            dos.writeByte(persistentType);     // Catch: IOException -> L16
            dos.writeInt(userId);     // Catch: IOException -> L16
            dos.writeInt(qualityForUi);     // Catch: IOException -> L16
            dos.write(payload);     // Catch: IOException -> L16
            return os.toByteArray();
        L18:
            throw new IllegalStateException("ByteArrayOutputStream cannot throw IOException");
        L10:
            if (payload.length <= 0) goto L12;
            r0 = true;
            goto L12
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEFAULT, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5450$$Nest$sfgetDEFAULT() {
        return DEFAULT;
    }

    static {
        COLUMNS_FOR_QUERY = new String[]{COLUMN_VALUE};
        COLUMNS_FOR_PREFETCH = new String[]{"name", COLUMN_VALUE};
        DEFAULT = new Object();
        SETTINGS_TO_BACKUP = new String[]{"lock_screen_owner_info_enabled", "lock_screen_owner_info", "lock_pattern_visible_pattern", "lockscreen.power_button_instantly_locks"};
    }

    public LockSettingsStorage(Context context) {
        this.mCache = new Cache(null);
        this.mFileWriteLock = new Object();
        this.mContext = context;
        this.mOpenHelper = new DatabaseHelper(context);
    }

    public void setDatabaseOnCreateCallback(Callback callback) {
        this.mOpenHelper.setCallback(callback);
    }

    public void writeKeyValue(String key, String value, int userId) {
        writeKeyValue(this.mOpenHelper.getWritableDatabase(), key, value, userId);
    }

    public boolean isAutoPinConfirmSettingEnabled(int userId) {
        return getBoolean("lockscreen.auto_pin_confirm", false, userId);
    }

    public void writeKeyValue(SQLiteDatabase db, String key, String value, int userId) {
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put(COLUMN_USERID, Integer.valueOf(userId));
        cv.put(COLUMN_VALUE, value);
        db.beginTransaction();
        db.delete(TABLE, "name=? AND user=?", new String[]{key, Integer.toString(userId)});     // Catch: Throwable -> L6
        db.insertOrThrow(TABLE, null, cv);     // Catch: Throwable -> L6
        db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mCache.putKeyValue(key, value, userId);     // Catch: Throwable -> L6
        db.endTransaction();
        return;
    L6:
        th = move-exception;
        db.endTransaction();
        throw th;
    }

    public String readKeyValue(String key, String defaultValue, int userId) {
        Cache r1 = this.mCache;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCache.hasKeyValue(key, userId) == false) goto L11;
        String r0 = this.mCache.peekKeyValue(key, defaultValue, userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    L11:
        int version = Cache.m5451$$Nest$mgetVersion(this.mCache);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        Object result = DEFAULT;
        SQLiteDatabase db = this.mOpenHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE, COLUMNS_FOR_QUERY, "user=? AND name=?", new String[]{Integer.toString(userId), key}, null, null, null);
        if (cursor != null) goto L16;
    L19:
        this.mCache.putKeyValueIfUnchanged(key, result, userId, version);
        if (result != DEFAULT) goto L23;
        return defaultValue;
    L23:
        return (String) result;
    L16:
        if (cursor.moveToFirst() == false) goto L18;
        result = cursor.getString(0);
    L18:
        cursor.close();
        goto L19
    }

    boolean isKeyValueCached(String key, int userId) {
        return this.mCache.hasKeyValue(key, userId);
    }

    boolean isUserPrefetched(int userId) {
        return this.mCache.isFetched(userId);
    }

    public void removeKey(String key, int userId) {
        removeKey(this.mOpenHelper.getWritableDatabase(), key, userId);
    }

    private void removeKey(SQLiteDatabase db, String key, int userId) {
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put(COLUMN_USERID, Integer.valueOf(userId));
        db.beginTransaction();
        db.delete(TABLE, "name=? AND user=?", new String[]{key, Integer.toString(userId)});     // Catch: Throwable -> L6
        db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mCache.removeKey(key, userId);     // Catch: Throwable -> L6
        db.endTransaction();
        return;
    L6:
        th = move-exception;
        db.endTransaction();
        throw th;
    }

    public void prefetchUser(int userId) {
        Cache r1 = this.mCache;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCache.isFetched(userId) == false) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        this.mCache.setFetched(userId);     // Catch: Throwable -> L8
        int version = Cache.m5451$$Nest$mgetVersion(this.mCache);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        SQLiteDatabase db = this.mOpenHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE, COLUMNS_FOR_PREFETCH, "user=?", new String[]{Integer.toString(userId)}, null, null, null);
        if (cursor != null) goto L15;
        return;
    L15:
        if (cursor.moveToNext() == false) goto L17;
        String key = cursor.getString(0);
        String value = cursor.getString(1);
        this.mCache.putKeyValueIfUnchanged(key, value, userId, version);
        goto L15
    L17:
        cursor.close();
    }

    public void removeChildProfileLock(int userId) {
        deleteFile(getChildProfileLockFile(userId));
    }

    public void writeChildProfileLock(int userId, byte[] lock) {
        writeFile(getChildProfileLockFile(userId), lock);
    }

    public byte[] readChildProfileLock(int userId) {
        return readFile(getChildProfileLockFile(userId));
    }

    public boolean hasChildProfileLock(int userId) {
        return hasFile(getChildProfileLockFile(userId));
    }

    public void writeRebootEscrow(int userId, byte[] rebootEscrow) {
        writeFile(getRebootEscrowFile(userId), rebootEscrow);
    }

    public byte[] readRebootEscrow(int userId) {
        return readFile(getRebootEscrowFile(userId));
    }

    public boolean hasRebootEscrow(int userId) {
        return hasFile(getRebootEscrowFile(userId));
    }

    public void removeRebootEscrow(int userId) {
        deleteFile(getRebootEscrowFile(userId));
    }

    public void writeRebootEscrowServerBlob(byte[] serverBlob) {
        writeFile(getRebootEscrowServerBlobFile(), serverBlob);
    }

    public byte[] readRebootEscrowServerBlob() {
        return readFile(getRebootEscrowServerBlobFile());
    }

    public boolean hasRebootEscrowServerBlob() {
        return hasFile(getRebootEscrowServerBlobFile());
    }

    public void removeRebootEscrowServerBlob() {
        deleteFile(getRebootEscrowServerBlobFile());
    }

    private boolean hasFile(File path) {
        byte[] contents = readFile(path);
        if (contents != null) goto L5;
    L7:
        return false;
    L5:
        if (contents.length <= 0) goto L7;
        return true;
    }

    private byte[] readFile(File path) {
        Cache r0 = this.mCache;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCache.hasFile(path) == false) goto L11;
        byte[] r1 = this.mCache.peekFile(path);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        int version = Cache.m5451$$Nest$mgetVersion(this.mCache);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        byte[] data = null;
        RandomAccessFile raf = new RandomAccessFile(path, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);     // Catch: IOException -> L18 FileNotFoundException -> L20
        data = new byte[(int) raf.length()];     // Catch: Throwable -> L22
        raf.readFully(data, 0, data.length);     // Catch: Throwable -> L22
        raf.close();     // Catch: Throwable -> L22
        raf.close();     // Catch: IOException -> L18 FileNotFoundException -> L20
        goto L29
    L22:
        th = move-exception;
        raf.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: IOException -> L18 FileNotFoundException -> L20
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18 FileNotFoundException -> L20
    L18:
        e = move-exception;
        Slog.e(TAG, "Cannot read file " + e);
    L29:
        this.mCache.putFileIfUnchanged(path, data, version);
        return data;
    }

    private void fsyncDirectory(File directory) {
        FileChannel file = FileChannel.open(directory.toPath(), new OpenOption[]{StandardOpenOption.READ});     // Catch: IOException -> L6
        file.force(true);     // Catch: Throwable -> L8
        file.close();     // Catch: IOException -> L6
        return;
    L8:
        th = move-exception;
        if (file != null) goto L18;
    L15:
        throw th;     // Catch: IOException -> L6
    L18:
        file.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Error syncing directory: " + directory, e);
    }

    private void writeFile(File path, byte[] data) {
        writeFile(path, data, true);
    }

    private void writeFile(File path, byte[] data, boolean syncParentDir) {
        Object r0 = this.mFileWriteLock;
        monitor-enter(r0);
        AtomicFile file = new AtomicFile(path);     // Catch: Throwable -> L10
        FileOutputStream out = null;
        out = file.startWrite();     // Catch: Throwable -> L12 IOException -> L14
        out.write(data);     // Catch: Throwable -> L12 IOException -> L14
        file.finishWrite(out);     // Catch: Throwable -> L12 IOException -> L14
        out = null;
    L8:
        file.failWrite(out);     // Catch: Throwable -> L10
        if (syncParentDir == false) goto L19;
        fsyncDirectory(path.getParentFile());     // Catch: Throwable -> L10
    L19:
        this.mCache.putFile(path, data);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        file.failWrite(out);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        Slog.e(TAG, "Error writing file " + path, e);     // Catch: Throwable -> L12
    L10:
        th = move-exception;
        throw th;
    }

    private void deleteFile(File path) {
        Object r0 = this.mFileWriteLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (path.exists() == true) goto L31;
    L22:
        new AtomicFile(path).delete();     // Catch: Throwable -> L10
        this.mCache.putFile(path, null);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L31:
        RandomAccessFile raf = new RandomAccessFile(path, "rws");     // Catch: Throwable -> L10 Exception -> L12
        int fileSize = (int) raf.length();     // Catch: Throwable -> L14
        raf.write(new byte[fileSize]);     // Catch: Throwable -> L14
        raf.close();     // Catch: Throwable -> L10 Exception -> L12
    L14:
        th = move-exception;
        raf.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L10 Exception -> L12
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to zeroize " + path, e);     // Catch: Throwable -> L10
        goto L22
    }

    File getChildProfileLockFile(int userId) {
        return getLockCredentialFileForUser(userId, CHILD_PROFILE_LOCK_FILE);
    }

    File getRebootEscrowFile(int userId) {
        return getLockCredentialFileForUser(userId, REBOOT_ESCROW_FILE);
    }

    File getRebootEscrowServerBlobFile() {
        return getLockCredentialFileForUser(0, REBOOT_ESCROW_SERVER_BLOB_FILE);
    }

    private File getLockCredentialFileForUser(int userId, String fileName) {
        if (userId != 0) goto L6;
        return new File(Environment.getDataSystemDirectory(), fileName);
    L6:
        return new File(Environment.getUserSystemDirectory(userId), fileName);
    }

    File getRepairModePersistentDataFile() {
        File directory = new File(Environment.getMetadataDirectory(), REPAIR_MODE_DIRECTORY);
        return new File(directory, REPAIR_MODE_PERSISTENT_FILE);
    }

    public PersistentData readRepairModePersistentData() {
        byte[] data = readFile(getRepairModePersistentDataFile());
        if (data != null) goto L7;
        return PersistentData.NONE;
    L7:
        return PersistentData.fromBytes(data);
    }

    public void writeRepairModePersistentData(int persistentType, int userId, byte[] payload) {
        writeFile(getRepairModePersistentDataFile(), PersistentData.toBytes(persistentType, userId, 0, payload));
    }

    public void deleteRepairModePersistentData() {
        deleteFile(getRepairModePersistentDataFile());
    }

    public void writeSyntheticPasswordState(int userId, long protectorId, String name, byte[] data) {
        ensureSyntheticPasswordDirectoryForUser(userId);
        writeFile(getSyntheticPasswordStateFileForUser(userId, protectorId, name), data, false);
    }

    public byte[] readSyntheticPasswordState(int userId, long protectorId, String name) {
        return readFile(getSyntheticPasswordStateFileForUser(userId, protectorId, name));
    }

    public void deleteSyntheticPasswordState(int userId, long protectorId, String name) {
        deleteFile(getSyntheticPasswordStateFileForUser(userId, protectorId, name));
    }

    public void syncSyntheticPasswordState(int userId) {
        fsyncDirectory(getSyntheticPasswordDirectoryForUser(userId));
    }

    public Map<Integer, List<Long>> listSyntheticPasswordProtectorsForAllUsers(String stateName) {
        Map<Integer, List<Long>> result = new ArrayMap();
        UserManager um = UserManager.get(this.mContext);
        Iterator r2 = um.getUsers().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        UserInfo user = (UserInfo) r2.next();
        result.put(Integer.valueOf(user.id), listSyntheticPasswordProtectorsForUser(stateName, user.id));
        goto L4
    L6:
        return result;
    }

    public List<Long> listSyntheticPasswordProtectorsForUser(String stateName, int userId) {
        File baseDir = getSyntheticPasswordDirectoryForUser(userId);
        List<Long> result = new ArrayList();
        File[] files = baseDir.listFiles();
        if (files != null) goto L5;
        return result;
    L5:
        int r3 = files.length;
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L16;
        File file = files[r5];
        String[] parts = file.getName().split("\\.");
        if (parts.length != 2) goto L15;
        if (parts[1].equals(stateName) == false) goto L15;
        result.add(Long.valueOf(Long.parseUnsignedLong(parts[0], 16)));     // Catch: NumberFormatException -> L13
    L14:
        Slog.e(TAG, "Failed to parse protector ID " + parts[0]);
    L15:
        r5 = r5 + 1;
        goto L6
    L16:
        return result;
    }

    protected File getSyntheticPasswordDirectoryForUser(int userId) {
        return new File(Environment.getDataSystemDeDirectory(userId), SYNTHETIC_PASSWORD_DIRECTORY);
    }

    private void ensureSyntheticPasswordDirectoryForUser(int userId) {
        File baseDir = getSyntheticPasswordDirectoryForUser(userId);
        if (baseDir.exists() == true) goto L6;
        baseDir.mkdir();
        return;
    }

    private File getSyntheticPasswordStateFileForUser(int userId, long protectorId, String name) {
        String fileName = TextUtils.formatSimple("%016x.%s", new Object[]{Long.valueOf(protectorId), name});
        return new File(getSyntheticPasswordDirectoryForUser(userId), fileName);
    }

    public void removeUser(int userId) {
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        UserManager um = (UserManager) this.mContext.getSystemService(COLUMN_USERID);
        UserInfo parentInfo = um.getProfileParent(userId);
        if (parentInfo != null) goto L5;
        deleteFile(getRebootEscrowFile(userId));
    L6:
        File spStateDir = getSyntheticPasswordDirectoryForUser(userId);
        db.beginTransaction();     // Catch: Throwable -> L10
        db.delete(TABLE, "user='" + userId + "'", null);     // Catch: Throwable -> L10
        db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.mCache.removeUser(userId);     // Catch: Throwable -> L10
        this.mCache.purgePath(spStateDir);     // Catch: Throwable -> L10
        db.endTransaction();
        return;
    L10:
        th = move-exception;
        db.endTransaction();
        throw th;
    L5:
        removeChildProfileLock(userId);
        goto L6
    }

    public void setBoolean(String key, boolean value, int userId) {
        if (value == false) goto L4;
        String r0 = "1";
    L5:
        setString(key, r0, userId);
        return;
    L4:
        r0 = "0";
        goto L5
    }

    public void setLong(String key, long value, int userId) {
        setString(key, Long.toString(value), userId);
    }

    public void setInt(String key, int value, int userId) {
        setString(key, Integer.toString(value), userId);
    }

    public void setString(String key, String value, int userId) {
        Preconditions.checkArgument(!LockPatternUtils.isSpecialUserId(userId), "cannot store lock settings for special user: %d", new Object[]{Integer.valueOf(userId)});
        writeKeyValue(key, value, userId);
        if (ArrayUtils.contains(SETTINGS_TO_BACKUP, key) == false) goto L6;
        BackupManager.dataChanged(UserBackupManagerService.SETTINGS_PACKAGE);
        return;
    }

    public boolean getBoolean(String key, boolean defaultValue, int userId) {
        String value = getString(key, null, userId);
        if (TextUtils.isEmpty(value) == false) goto L6;
        return defaultValue;
    L6:
        if (value.equals("1") == false) goto L8;
    L11:
        return true;
    L8:
        if (value.equals("true") == true) goto L11;
        return false;
    }

    public long getLong(String key, long defaultValue, int userId) {
        String value = getString(key, null, userId);
        if (TextUtils.isEmpty(value) == false) goto L6;
        return defaultValue;
    L6:
        return Long.parseLong(value);
    }

    public int getInt(String key, int defaultValue, int userId) {
        String value = getString(key, null, userId);
        if (TextUtils.isEmpty(value) == false) goto L6;
        return defaultValue;
    L6:
        return Integer.parseInt(value);
    }

    public String getString(String key, String defaultValue, int userId) {
        if (LockPatternUtils.isSpecialUserId(userId) == false) goto L7;
        return null;
    L7:
        return readKeyValue(key, defaultValue, userId);
    }

    void closeDatabase() {
        this.mOpenHelper.close();
    }

    void clearCache() {
        this.mCache.clear();
    }

    PersistentDataBlockManagerInternal getPersistentDataBlockManager() {
        if (this.mPersistentDataBlockManagerInternal != null) goto L6;
        this.mPersistentDataBlockManagerInternal = (PersistentDataBlockManagerInternal) LocalServices.getService(PersistentDataBlockManagerInternal.class);
    L6:
        return this.mPersistentDataBlockManagerInternal;
    }

    public void writePersistentDataBlock(int persistentType, int userId, int qualityForUi, byte[] payload) {
        PersistentDataBlockManagerInternal persistentDataBlock = getPersistentDataBlockManager();
        if (persistentDataBlock != null) goto L5;
        return;
    L5:
        persistentDataBlock.setFrpCredentialHandle(PersistentData.toBytes(persistentType, userId, qualityForUi, payload));
    }

    public PersistentData readPersistentDataBlock() {
        PersistentDataBlockManagerInternal persistentDataBlock = getPersistentDataBlockManager();
        if (persistentDataBlock == null) goto L5;
        return PersistentData.fromBytes(persistentDataBlock.getFrpCredentialHandle());
    L8:
        e = move-exception;
        Slog.e(TAG, "Error reading persistent data block", e);
        return PersistentData.NONE;
    L5:
        return PersistentData.NONE;
    }

    public void deactivateFactoryResetProtectionWithoutSecret() {
        PersistentDataBlockManagerInternal persistentDataBlock = getPersistentDataBlockManager();
        if (persistentDataBlock == null) goto L5;
        persistentDataBlock.deactivateFactoryResetProtectionWithoutSecret();
        return;
    L5:
        Slog.wtf(TAG, "Failed to get PersistentDataBlockManagerInternal");
    }

    public boolean isFactoryResetProtectionActive() {
        PersistentDataBlockManager persistentDataBlockManager = (PersistentDataBlockManager) this.mContext.getSystemService(PersistentDataBlockManager.class);
        if (persistentDataBlockManager != null) goto L5;
        Slog.wtf(TAG, "Failed to get PersistentDataBlockManager");
        return false;
    L5:
        return persistentDataBlockManager.isFactoryResetProtectionActive();
    }

    public void dump(IndentingPrintWriter pw) {
        UserManager um = UserManager.get(this.mContext);
        Iterator r1 = um.getUsers().iterator();
    L3:
        int r4 = 0;
        if (r1.hasNext() == false) goto L13;
        UserInfo user = (UserInfo) r1.next();
        File userPath = getSyntheticPasswordDirectoryForUser(user.id);
        pw.println(TextUtils.formatSimple("User %d [%s]:", new Object[]{Integer.valueOf(user.id), userPath}));
        pw.increaseIndent();
        File[] files = userPath.listFiles();
        if (files == null) goto L11;
        Arrays.sort(files);
        int r7 = files.length;
    L9:
        if (r4 >= r7) goto L12;
        File file = files[r4];
        pw.println(TextUtils.formatSimple("%6d %s %s", new Object[]{Long.valueOf(file.length()), LockSettingsService.timestampToString(file.lastModified()), file.getName()}));
        r4 = r4 + 1;
    L12:
        pw.decreaseIndent();
        goto L3
    L11:
        pw.println("[Not found]");
        goto L12
    L13:
        File repairModeFile = getRepairModePersistentDataFile();
        if (repairModeFile.exists() == false) goto L23;
        pw.println(TextUtils.formatSimple("Repair Mode [%s]:", new Object[]{repairModeFile.getParent()}));
        pw.increaseIndent();
        pw.println(TextUtils.formatSimple("%6d %s %s", new Object[]{Long.valueOf(repairModeFile.length()), LockSettingsService.timestampToString(repairModeFile.lastModified()), repairModeFile.getName()}));
        PersistentData data = readRepairModePersistentData();
        Integer r3 = Integer.valueOf(data.type);
        Integer r5 = Integer.valueOf(data.userId);
        if (data.payload == null) goto L18;
        r4 = data.payload.length;
    L18:
        pw.println(TextUtils.formatSimple("type: %d, user id: %d, payload size: %d", new Object[]{r3, r5, Integer.valueOf(r4)}));
        pw.decreaseIndent();
        return;
    }
}
