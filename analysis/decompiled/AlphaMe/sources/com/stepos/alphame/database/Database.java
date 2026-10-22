package com.stepos.alphame.database;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import net.zetetic.database.sqlcipher.SQLiteOpenHelper;

/* loaded from: classes.dex */
public class Database {
    public static final String AUTHORITY = "com.stepos.alphame.provider";
    private static final String BAK_NAME = "AlphaMe.db.plain.bak";
    private static final String DATABASE_NAME = "AlphaMe.db";
    private static final String TAG = "AlphaMeDb";
    private static final String TMP_NAME = "AlphaMe.db.enc.tmp";
    public static final int VERSION = 2;
    private final UriMatcher MATCHER;
    private ArrayList<Element> mElements;
    private SQLiteOpenHelper mOpenHelper;

    public static class Element {
        public String createTableSQL;
        public String tableName;
        public Uri uri;

        public Element(String str, String str2) {
            this.tableName = str;
            this.createTableSQL = str2;
            this.uri = Uri.parse("content://com.stepos.alphame.provider/" + str);
        }
    }

    public static class Instance {
        private static final Database INSTANCE = new Database(0);

        private Instance() {
        }
    }

    public /* synthetic */ Database(int i4) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean canOpenEncrypted(java.io.File r8, byte[] r9) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = r8.getAbsolutePath()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3f
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            r3 = r9
            net.zetetic.database.sqlcipher.SQLiteDatabase r8 = net.zetetic.database.sqlcipher.SQLiteDatabase.openDatabase(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3f
            java.lang.String r9 = "PRAGMA quick_check"
            android.database.Cursor r9 = r8.rawQuery(r9, r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
            if (r9 == 0) goto L2e
            boolean r1 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L2e
            r1 = 1
            goto L2f
        L1f:
            r1 = move-exception
            r9.close()     // Catch: java.lang.Throwable -> L24
            goto L28
        L24:
            r9 = move-exception
            r1.addSuppressed(r9)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
        L28:
            throw r1     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
        L29:
            r9 = move-exception
            r1 = r8
            goto L39
        L2c:
            r1 = r8
            goto L3f
        L2e:
            r1 = r0
        L2f:
            if (r9 == 0) goto L34
            r9.close()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
        L34:
            r8.close()     // Catch: java.lang.Exception -> L37
        L37:
            return r1
        L38:
            r9 = move-exception
        L39:
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.lang.Exception -> L3e
        L3e:
            throw r9
        L3f:
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.lang.Exception -> L44
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.database.Database.canOpenEncrypted(java.io.File, byte[]):boolean");
    }

    private void createHelper(byte[] bArr) {
        this.mOpenHelper = new SQLiteOpenHelper(ApplicationImpl.getApplication(), DATABASE_NAME, bArr, null, 2, 0, null, null, false) { // from class: com.stepos.alphame.database.Database.1
            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) throws SQLException {
                if (i4 <= 1) {
                    sQLiteDatabase.execSQL("alter table user_behavior add column hour_details text");
                }
            }
        };
    }

    private static void deleteDbAndSidecars(File file) {
        if (file == null) {
            return;
        }
        if (file.exists() && !file.delete()) {
            AlphaMeLogger.eLog("AlphaMeDb delete fail " + file.getName());
        }
        String absolutePath = file.getAbsolutePath();
        new File(AbstractC0351g.p(absolutePath, "-journal")).delete();
        new File(AbstractC0351g.p(absolutePath, "-wal")).delete();
        new File(AbstractC0351g.p(absolutePath, "-shm")).delete();
    }

    public static Database getInstance() {
        return Instance.INSTANCE;
    }

    public void addTable(String str, String str2) {
        SQLiteDatabase db;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        synchronized (this.mElements) {
            try {
                Iterator<Element> it = this.mElements.iterator();
                while (it.hasNext()) {
                    if (it.next().tableName.equals(str)) {
                        AlphaMeLogger.eLog(str + " is already added");
                        return;
                    }
                }
                int size = this.mElements.size();
                this.mElements.add(new Element(str, str2));
                try {
                    db = getDb();
                } catch (Exception e4) {
                    AlphaMeLogger.exceptionLog("addTable " + str + " error", e4);
                }
                if (db != null) {
                    db.execSQL(str2);
                    this.MATCHER.addURI(AUTHORITY, str, size);
                } else {
                    AlphaMeLogger.eLog("AlphaMeDb addTable skip, db not ready " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        try {
            SQLiteDatabase db = getDb();
            if (db == null) {
                return 0;
            }
            Element element = getElement(this.MATCHER.match(uri));
            if (element != null) {
                return db.delete(element.tableName, str, strArr);
            }
            AlphaMeLogger.eLog("Unknown Uri:" + uri.toString());
            return 0;
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("delete " + uri + " error", e4);
            return 0;
        }
    }

    public SQLiteDatabase getDb() {
        SQLiteOpenHelper sQLiteOpenHelper = this.mOpenHelper;
        if (sQLiteOpenHelper == null) {
            return null;
        }
        try {
            SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
            if (writableDatabase != null) {
                if (writableDatabase.isOpen()) {
                    return writableDatabase;
                }
            }
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("AlphaMeDb getWritableDatabase fail", e4);
        }
        return null;
    }

    public Element getElement(int i4) {
        synchronized (this.mElements) {
            try {
                if (i4 >= this.mElements.size()) {
                    return null;
                }
                return this.mElements.get(i4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getType(Uri uri) {
        Element element = getElement(this.MATCHER.match(uri));
        if (element != null) {
            return "vnd.android.cursor.dir/" + element.tableName;
        }
        throw new IllegalArgumentException("Unknown Uri:" + uri.toString());
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase db = getDb();
            if (db == null) {
                return null;
            }
            Element element = getElement(this.MATCHER.match(uri));
            if (element != null) {
                return ContentUris.withAppendedId(uri, db.insert(element.tableName, (String) null, contentValues));
            }
            AlphaMeLogger.eLog("Unknown Uri:" + uri.toString());
            return null;
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("insert " + uri + " error", e4);
            return null;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return query(uri, strArr, str, strArr2, str2, null);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            SQLiteDatabase db = getDb();
            if (db == null) {
                return 0;
            }
            Element element = getElement(this.MATCHER.match(uri));
            if (element != null) {
                return db.update(element.tableName, contentValues, str, strArr);
            }
            AlphaMeLogger.eLog("Unknown Uri:" + uri.toString());
            return 0;
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("update " + uri + " error", e4);
            return 0;
        }
    }

    private Database() {
        this.mElements = new ArrayList<>();
        this.MATCHER = new UriMatcher(-1);
        try {
            System.loadLibrary("sqlcipher");
            ApplicationImpl application = ApplicationImpl.getApplication();
            if (application == null) {
                AlphaMeLogger.eLog("AlphaMeDb prepare fail: application is null");
                return;
            }
            byte[] keyBytes = AlphaMeDbKey.toKeyBytes(AlphaMeDbKey.getKeySpec());
            File databasePath = application.getDatabasePath(DATABASE_NAME);
            File parentFile = databasePath.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                AlphaMeLogger.eLog("AlphaMeDb cannot create databases dir");
            }
            if (parentFile != null) {
                deleteDbAndSidecars(new File(parentFile, TMP_NAME));
                deleteDbAndSidecars(new File(parentFile, BAK_NAME));
            }
            if (databasePath.exists() && !canOpenEncrypted(databasePath, keyBytes)) {
                deleteDbAndSidecars(databasePath);
                AlphaMeLogger.wLog("AlphaMeDb discarded unreadable AlphaMe.db");
            } else if (databasePath.exists()) {
                AlphaMeLogger.wLog("AlphaMeDb opened encrypted");
            } else {
                AlphaMeLogger.wLog("AlphaMeDb new encrypted db created");
            }
            createHelper(keyBytes);
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("AlphaMeDb keystore derive or open fail", e4);
            this.mOpenHelper = null;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        int iMatch;
        try {
            SQLiteDatabase db = getDb();
            if (db == null || (iMatch = this.MATCHER.match(uri)) == -1) {
                return null;
            }
            Element element = getElement(iMatch);
            if (element != null) {
                return db.query(element.tableName, strArr, str, strArr2, null, null, str2, str3);
            }
            AlphaMeLogger.eLog("Unknown Uri:" + uri.toString());
            return null;
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("query " + uri + " error", e4);
            return null;
        }
    }

    public Element getElement(String str) {
        synchronized (this.mElements) {
            try {
                Iterator<Element> it = this.mElements.iterator();
                while (it.hasNext()) {
                    Element next = it.next();
                    if (next.tableName.equals(str)) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
