package com.android.server.soundtrigger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.soundtrigger.SoundTrigger;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerDbHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_ST_SOUND_MODEL = "CREATE TABLE st_sound_model(model_uuid TEXT PRIMARY KEY,vendor_uuid TEXT,data BLOB,model_version INTEGER )";
    static final boolean DBG = false;
    private static final String NAME = "st_sound_model.db";
    static final String TAG = "SoundTriggerDbHelper";
    private static final int VERSION = 2;

    public interface GenericSoundModelContract {
        public static final String KEY_DATA = "data";
        public static final String KEY_MODEL_UUID = "model_uuid";
        public static final String KEY_MODEL_VERSION = "model_version";
        public static final String KEY_VENDOR_UUID = "vendor_uuid";
        public static final String TABLE = "st_sound_model";
    }

    public SoundTriggerDbHelper(Context context) {
        super(context, NAME, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ST_SOUND_MODEL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != 1) goto L6;
        Slog.d(TAG, "Adding model version column");
        db.execSQL("ALTER TABLE st_sound_model ADD COLUMN model_version INTEGER DEFAULT -1");
        int r4 = oldVersion + 1;
        return;
    }

    public boolean updateGenericSoundModel(SoundTrigger.GenericSoundModel soundModel) {
        monitor-enter(this);
        SQLiteDatabase db = getWritableDatabase();     // Catch: Throwable -> L12
        ContentValues values = new ContentValues();     // Catch: Throwable -> L12
        values.put("model_uuid", soundModel.getUuid().toString());     // Catch: Throwable -> L12
        values.put("vendor_uuid", soundModel.getVendorUuid().toString());     // Catch: Throwable -> L12
        values.put("data", soundModel.getData());     // Catch: Throwable -> L12
        values.put("model_version", Integer.valueOf(soundModel.getVersion()));     // Catch: Throwable -> L12
    L6:
        if (db.insertWithOnConflict(GenericSoundModelContract.TABLE, null, values, 5) == (-1)) goto L8;
        boolean r2 = true;
    L9:
        db.close();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r2;
    L8:
        r2 = false;
    L14:
        th = move-exception;
        db.close();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public SoundTrigger.GenericSoundModel getGenericSoundModel(UUID model_uuid) {
        monitor-enter(this);
        String selectQuery = "SELECT  * FROM st_sound_model WHERE model_uuid= '" + model_uuid + "'";     // Catch: Throwable -> L10
        SQLiteDatabase db = getReadableDatabase();     // Catch: Throwable -> L10
        Cursor c = db.rawQuery(selectQuery, null);     // Catch: Throwable -> L10
    L12:
        th = move-exception;
        c.close();     // Catch: Throwable -> L10
        db.close();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L5:
        if (c.moveToFirst() == false) goto L14;
        byte[] data = c.getBlob(c.getColumnIndex("data"));     // Catch: Throwable -> L12
        String vendor_uuid = c.getString(c.getColumnIndex("vendor_uuid"));     // Catch: Throwable -> L12
        int version = c.getInt(c.getColumnIndex("model_version"));     // Catch: Throwable -> L12
        SoundTrigger.GenericSoundModel r6 = new SoundTrigger.GenericSoundModel(model_uuid, UUID.fromString(vendor_uuid), data, version);     // Catch: Throwable -> L12
        c.close();     // Catch: Throwable -> L10
        db.close();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r6;
    L14:
        c.close();     // Catch: Throwable -> L10
        db.close();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean deleteGenericSoundModel(UUID model_uuid) {
        monitor-enter(this);
        SoundTrigger.GenericSoundModel soundModel = getGenericSoundModel(model_uuid);     // Catch: Throwable -> L7
        boolean r1 = false;
        if (soundModel != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L9:
        SQLiteDatabase db = getWritableDatabase();     // Catch: Throwable -> L7
        String soundModelClause = "model_uuid='" + soundModel.getUuid().toString() + "'";     // Catch: Throwable -> L7
        if (db.delete(GenericSoundModelContract.TABLE, soundModelClause, null) == 0) goto L13;
        r1 = true;
    L13:
        db.close();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r1;
    L16:
        th = move-exception;
        db.close();     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        monitor-enter(this);
        SQLiteDatabase db = getReadableDatabase();     // Catch: Throwable -> L25
        Cursor c = db.rawQuery("SELECT  * FROM st_sound_model", null);     // Catch: Throwable -> L25
        pw.println("  Enrolled GenericSoundModels:");     // Catch: Throwable -> L13
        if (c.moveToFirst() == false) goto L22;
        String[] columnNames = c.getColumnNames();     // Catch: Throwable -> L13
    L7:
        int r4 = columnNames.length;     // Catch: Throwable -> L13
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L20;
        String name = columnNames[r5];     // Catch: Throwable -> L13
        int colNameIndex = c.getColumnIndex(name);     // Catch: Throwable -> L13
        int type = c.getType(colNameIndex);     // Catch: Throwable -> L13
        switch(type) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L12;
            default: goto L19;
        };     // Catch: Throwable -> L13
    L12:
        pw.printf("    %s: data blob\n", new Object[]{name});     // Catch: Throwable -> L13
        goto L19
    L15:
        pw.printf("    %s: %s\n", new Object[]{name, c.getString(colNameIndex)});     // Catch: Throwable -> L13
        goto L19
    L16:
        pw.printf("    %s: %f\n", new Object[]{name, Float.valueOf(c.getFloat(colNameIndex))});     // Catch: Throwable -> L13
        goto L19
    L17:
        pw.printf("    %s: %d\n", new Object[]{name, Integer.valueOf(c.getInt(colNameIndex))});     // Catch: Throwable -> L13
        goto L19
    L18:
        pw.printf("    %s: null\n", new Object[]{name});     // Catch: Throwable -> L13
    L19:
        r5 = r5 + 1;     // Catch: Throwable -> L13
        goto L8
    L20:
        pw.println();     // Catch: Throwable -> L13
        if (c.moveToNext() == true) goto L7;
    L22:
        c.close();     // Catch: Throwable -> L25
        db.close();     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L13:
        th = move-exception;
        c.close();     // Catch: Throwable -> L25
        db.close();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
