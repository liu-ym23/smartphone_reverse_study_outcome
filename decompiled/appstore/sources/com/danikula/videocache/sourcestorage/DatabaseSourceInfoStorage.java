package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.Preconditions;
import com.danikula.videocache.SourceInfo;

/* JADX INFO: loaded from: classes2.dex */
class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    private static final String[] ALL_COLUMNS = null;
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_MIME = "mime";
    private static final String COLUMN_URL = "url";
    private static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final String TABLE = "SourceInfo";

    static {
        ALL_COLUMNS = new String[]{COLUMN_ID, "url", COLUMN_LENGTH, COLUMN_MIME};
    }

    public DatabaseSourceInfoStorage(Context r10) {
        super(r10, "AndroidVideoCache.db", null, 1);
        Preconditions.checkNotNull(r10);
    }

    private SourceInfo convert(Cursor r10) {
        return new SourceInfo(r10.getString(r10.getColumnIndexOrThrow("url")), r10.getLong(r10.getColumnIndexOrThrow(COLUMN_LENGTH)), r10.getString(r10.getColumnIndexOrThrow(COLUMN_MIME)));
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String r10) {
        Preconditions.checkNotNull(r10);
        Cursor r11 = null;
        SourceInfo r12 = null;
        r12 = null;
        Cursor r13 = getReadableDatabase().query(TABLE, ALL_COLUMNS, "url=?", new String[]{r10}, null, null, null);     // Catch: Throwable -> L15
        if (r13 != null) goto L21;
    L12:
        if (r13 == null) goto L14;
        r13.close();
    L14:
        return r12;
    L21:
    L10:
        th = th;
        r11 = r13;
    L16:
        if (r11 == null) goto L18;
        r11.close();
    L18:
        throw th;
    L6:
        if (r13.moveToFirst() == false) goto L12;
        r12 = convert(r13);     // Catch: Throwable -> L10
    L15:
        th = th;
        goto L16
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r10) {
        Preconditions.checkNotNull(r10);
        r10.execSQL(CREATE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void put(String r10, SourceInfo r11) {
        Preconditions.checkAllNotNull(new Object[]{r10, r11});
        if (get(r10) == null) goto L5;
        boolean r12 = true;
    L6:
        ContentValues r13 = convert(r11);
        if (r12 == false) goto L9;
        getWritableDatabase().update(TABLE, r13, "url=?", new String[]{r10});
        return;
    L9:
        getWritableDatabase().insert(TABLE, null, r13);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void release() {
        close();
    }

    private ContentValues convert(SourceInfo r10) {
        ContentValues r11 = new ContentValues();
        r11.put("url", r10.url);
        r11.put(COLUMN_LENGTH, Long.valueOf(r10.length));
        r11.put(COLUMN_MIME, r10.mime);
        return r11;
    }
}
