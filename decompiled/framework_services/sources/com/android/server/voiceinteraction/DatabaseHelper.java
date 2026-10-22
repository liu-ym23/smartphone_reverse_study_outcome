package com.android.server.voiceinteraction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.soundtrigger.SoundTrigger;
import android.text.TextUtils;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class DatabaseHelper extends SQLiteOpenHelper implements IEnrolledModelDb {
    private static final String CREATE_TABLE_SOUND_MODEL = "CREATE TABLE sound_model(model_uuid TEXT,vendor_uuid TEXT,keyphrase_id INTEGER,type INTEGER,data BLOB,recognition_modes INTEGER,locale TEXT,hint_text TEXT,users TEXT,model_version INTEGER,PRIMARY KEY (keyphrase_id,locale,users))";
    static final boolean DBG = false;
    private static final String NAME = "sound_model.db";
    static final String TAG = "SoundModelDBHelper";
    private static final int VERSION = 7;

    public interface SoundModelContract {
        public static final String KEY_DATA = "data";
        public static final String KEY_HINT_TEXT = "hint_text";
        public static final String KEY_KEYPHRASE_ID = "keyphrase_id";
        public static final String KEY_LOCALE = "locale";
        public static final String KEY_MODEL_UUID = "model_uuid";
        public static final String KEY_MODEL_VERSION = "model_version";
        public static final String KEY_RECOGNITION_MODES = "recognition_modes";
        public static final String KEY_TYPE = "type";
        public static final String KEY_USERS = "users";
        public static final String KEY_VENDOR_UUID = "vendor_uuid";
        public static final String TABLE = "sound_model";
    }

    private static class SoundModelRecord {
        public final byte[] data;
        public final String hintText;
        public final int keyphraseId;
        public final String locale;
        public final String modelUuid;
        public final int recognitionModes;
        public final int type;
        public final String users;
        public final String vendorUuid;

        public SoundModelRecord(int version, Cursor c) {
            this.modelUuid = c.getString(c.getColumnIndex("model_uuid"));
            if (version < 5) goto L5;
            this.vendorUuid = c.getString(c.getColumnIndex("vendor_uuid"));
        L6:
            this.keyphraseId = c.getInt(c.getColumnIndex(SoundModelContract.KEY_KEYPHRASE_ID));
            this.type = c.getInt(c.getColumnIndex(SoundModelContract.KEY_TYPE));
            this.data = c.getBlob(c.getColumnIndex("data"));
            this.recognitionModes = c.getInt(c.getColumnIndex(SoundModelContract.KEY_RECOGNITION_MODES));
            this.locale = c.getString(c.getColumnIndex(SoundModelContract.KEY_LOCALE));
            this.hintText = c.getString(c.getColumnIndex(SoundModelContract.KEY_HINT_TEXT));
            this.users = c.getString(c.getColumnIndex(SoundModelContract.KEY_USERS));
            return;
        L5:
            this.vendorUuid = null;
            goto L6
        }

        private boolean V6PrimaryKeyMatches(SoundModelRecord record) {
            if (this.keyphraseId == record.keyphraseId) goto L5;
        L9:
            return false;
        L5:
            if (stringComparisonHelper(this.locale, record.locale) == false) goto L9;
            if (stringComparisonHelper(this.users, record.users) == false) goto L9;
            return true;
        }

        public boolean ifViolatesV6PrimaryKeyIsFirstOfAnyDuplicates(List<SoundModelRecord> records) {
            Iterator<SoundModelRecord> r0 = records.iterator();
        L4:
            if (r0.hasNext() == false) goto L14;
            SoundModelRecord record = r0.next();
            if (this == record) goto L4;
            if (V6PrimaryKeyMatches(record) == false) goto L4;
            if (Arrays.equals(this.data, record.data) == true) goto L4;
            return false;
        L14:
            Iterator<SoundModelRecord> r1 = records.iterator();
        L16:
            if (r1.hasNext() == false) goto L23;
            SoundModelRecord record2 = r1.next();
            if (V6PrimaryKeyMatches(record2) == false) goto L16;
            if (this == record2) goto L21;
            return false;
        L21:
            return true;
        L23:
            return true;
        }

        public long writeToDatabase(int version, SQLiteDatabase db) {
            ContentValues values = new ContentValues();
            values.put("model_uuid", this.modelUuid);
            if (version < 5) goto L5;
            values.put("vendor_uuid", this.vendorUuid);
        L5:
            values.put(SoundModelContract.KEY_KEYPHRASE_ID, Integer.valueOf(this.keyphraseId));
            values.put(SoundModelContract.KEY_TYPE, Integer.valueOf(this.type));
            values.put("data", this.data);
            values.put(SoundModelContract.KEY_RECOGNITION_MODES, Integer.valueOf(this.recognitionModes));
            values.put(SoundModelContract.KEY_LOCALE, this.locale);
            values.put(SoundModelContract.KEY_HINT_TEXT, this.hintText);
            values.put(SoundModelContract.KEY_USERS, this.users);
            return db.insertWithOnConflict(SoundModelContract.TABLE, null, values, 5);
        }

        private static boolean stringComparisonHelper(String a, String b) {
            if (a != null) goto L4;
            if (a != b) goto L7;
            return true;
        L7:
            return false;
        L4:
            return a.equals(b);
        }
    }

    public DatabaseHelper(Context context) {
        super(context, NAME, null, 7);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SOUND_MODEL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= 4) goto L5;
        db.execSQL("DROP TABLE IF EXISTS sound_model");
        onCreate(db);
    L8:
        if (oldVersion != 5) goto L37;
        Cursor c = db.rawQuery("SELECT * FROM sound_model", null);
        List<SoundModelRecord> old_records = new ArrayList();
    L14:
        th = move-exception;
        c.close();
        throw th;
    L11:
        if (c.moveToFirst() == true) goto L40;
    L20:
        c.close();
        db.execSQL("DROP TABLE IF EXISTS sound_model");
        onCreate(db);
        Iterator<SoundModelRecord> r0 = old_records.iterator();
    L22:
        if (r0.hasNext() == false) goto L34;
        SoundModelRecord record = r0.next();
        if (record.ifViolatesV6PrimaryKeyIsFirstOfAnyDuplicates(old_records) == false) goto L22;
        long return_value = record.writeToDatabase(6, db);     // Catch: Exception -> L29
        if (return_value != (-1)) goto L22;
        Slog.e(TAG, "Database write failed " + record.modelUuid + ": " + return_value);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Slog.e(TAG, "Failed to update V6 record " + record.modelUuid, e);
        goto L22
    L34:
        oldVersion = oldVersion + 1;
    L40:
        old_records.add(new SoundModelRecord(5, c));     // Catch: Throwable -> L14 Exception -> L16
    L19:
        if (c.moveToNext() == true) goto L40;
    L16:
        e = move-exception;
        Slog.e(TAG, "Failed to extract V5 record", e);     // Catch: Throwable -> L14
    L37:
        if (oldVersion != 6) goto L54;
        Slog.d(TAG, "Adding model version column");
        db.execSQL("ALTER TABLE sound_model ADD COLUMN model_version INTEGER DEFAULT -1");
        int r13 = oldVersion + 1;
        return;
    L54:
        return;
    L5:
        if (oldVersion != 4) goto L8;
        Slog.d(TAG, "Adding vendor UUID column");
        db.execSQL("ALTER TABLE sound_model ADD COLUMN vendor_uuid TEXT");
        oldVersion = oldVersion + 1;
        goto L8
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public boolean updateKeyphraseSoundModel(SoundTrigger.KeyphraseSoundModel soundModel) {
        monitor-enter(this);
        SQLiteDatabase db = getWritableDatabase();     // Catch: Throwable -> L6
        ContentValues values = new ContentValues();     // Catch: Throwable -> L6
        values.put("model_uuid", soundModel.getUuid().toString());     // Catch: Throwable -> L6
        if (soundModel.getVendorUuid() == null) goto L8;
        values.put("vendor_uuid", soundModel.getVendorUuid().toString());     // Catch: Throwable -> L6
    L8:
        boolean r3 = false;
        values.put(SoundModelContract.KEY_TYPE, 0);     // Catch: Throwable -> L6
        values.put("data", soundModel.getData());     // Catch: Throwable -> L6
        values.put("model_version", Integer.valueOf(soundModel.getVersion()));     // Catch: Throwable -> L6
        if (soundModel.getKeyphrases() != null) goto L11;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L6
        return false;
    L11:
        if (soundModel.getKeyphrases().length != 1) goto L23;
        values.put(SoundModelContract.KEY_KEYPHRASE_ID, Integer.valueOf(soundModel.getKeyphrases()[0].getId()));     // Catch: Throwable -> L6
        values.put(SoundModelContract.KEY_RECOGNITION_MODES, Integer.valueOf(soundModel.getKeyphrases()[0].getRecognitionModes()));     // Catch: Throwable -> L6
        values.put(SoundModelContract.KEY_USERS, getCommaSeparatedString(soundModel.getKeyphrases()[0].getUsers()));     // Catch: Throwable -> L6
        values.put(SoundModelContract.KEY_LOCALE, soundModel.getKeyphrases()[0].getLocale().toLanguageTag());     // Catch: Throwable -> L6
        values.put(SoundModelContract.KEY_HINT_TEXT, soundModel.getKeyphrases()[0].getText());     // Catch: Throwable -> L6
    L15:
        if (db.insertWithOnConflict(SoundModelContract.TABLE, null, values, 5) == (-1)) goto L17;
        r3 = true;
    L17:
        db.close();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r3;
    L20:
        th = move-exception;
        db.close();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public boolean deleteKeyphraseSoundModel(int keyphraseId, int userHandle, String bcp47Locale) {
        String bcp47Locale2 = Locale.forLanguageTag(bcp47Locale).toLanguageTag();
        monitor-enter(this);
        SoundTrigger.KeyphraseSoundModel soundModel = getKeyphraseSoundModel(keyphraseId, userHandle, bcp47Locale2);     // Catch: Throwable -> L8
        boolean r1 = false;
        if (soundModel != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        SQLiteDatabase db = getWritableDatabase();     // Catch: Throwable -> L8
        String soundModelClause = "model_uuid='" + soundModel.getUuid().toString() + "'";     // Catch: Throwable -> L8
        if (db.delete(SoundModelContract.TABLE, soundModelClause, null) == 0) goto L14;
        r1 = true;
    L14:
        db.close();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r1;
    L17:
        th = move-exception;
        db.close();     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public SoundTrigger.KeyphraseSoundModel getKeyphraseSoundModel(int keyphraseId, int userHandle, String bcp47Locale) {
        String bcp47Locale2 = Locale.forLanguageTag(bcp47Locale).toLanguageTag();
        monitor-enter(this);
        String selectQuery = "SELECT  * FROM sound_model WHERE keyphrase_id= '" + keyphraseId + "' AND " + SoundModelContract.KEY_LOCALE + "='" + bcp47Locale2 + "'";     // Catch: Throwable -> L7
        SoundTrigger.KeyphraseSoundModel r1 = getValidKeyphraseSoundModelForUser(selectQuery, userHandle);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public SoundTrigger.KeyphraseSoundModel getKeyphraseSoundModel(String keyphrase, int userHandle, String bcp47Locale) {
        String bcp47Locale2 = Locale.forLanguageTag(bcp47Locale).toLanguageTag();
        monitor-enter(this);
        String selectQuery = "SELECT  * FROM sound_model WHERE hint_text= '" + keyphrase + "' AND " + SoundModelContract.KEY_LOCALE + "='" + bcp47Locale2 + "'";     // Catch: Throwable -> L7
        SoundTrigger.KeyphraseSoundModel r1 = getValidKeyphraseSoundModelForUser(selectQuery, userHandle);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private SoundTrigger.KeyphraseSoundModel getValidKeyphraseSoundModelForUser(String selectQuery, int userHandle) {
        SQLiteDatabase db = getReadableDatabase();
        SoundTrigger.KeyphraseSoundModel r0 = null;
        Cursor c = db.rawQuery(selectQuery, null);
    L33:
        th = th;
        SQLiteDatabase db2 = db;
    L53:
        c.close();
        db2.close();
        throw th;
    L4:
        if (c.moveToFirst() == false) goto L50;
    L5:
        int type = c.getInt(c.getColumnIndex(SoundModelContract.KEY_TYPE));     // Catch: Throwable -> L33
        if (type == 0) goto L8;
        db2 = db;
    L57:
    L41:
        th = th;
        goto L53
    L38:
        if (c.moveToNext() == false) goto L51;
        r0 = r0;
        db = db2;
    L51:
        c.close();
        db2.close();
        return r0;
    L8:
        String modelUuid = c.getString(c.getColumnIndex("model_uuid"));     // Catch: Throwable -> L33
        if (modelUuid == null) goto L55;
        String vendorUuidString = null;
        int vendorUuidColumn = c.getColumnIndex("vendor_uuid");     // Catch: Throwable -> L33
        if (vendorUuidColumn != (-1)) goto L20;
    L21:
        int keyphraseId = c.getInt(c.getColumnIndex(SoundModelContract.KEY_KEYPHRASE_ID));     // Catch: Throwable -> L33
        byte[] data = c.getBlob(c.getColumnIndex("data"));     // Catch: Throwable -> L33
        int recognitionModes = c.getInt(c.getColumnIndex(SoundModelContract.KEY_RECOGNITION_MODES));     // Catch: Throwable -> L33
        int[] users = getArrayForCommaSeparatedString(c.getString(c.getColumnIndex(SoundModelContract.KEY_USERS)));     // Catch: Throwable -> L33
        Locale modelLocale = Locale.forLanguageTag(c.getString(c.getColumnIndex(SoundModelContract.KEY_LOCALE)));     // Catch: Throwable -> L33
        String text = c.getString(c.getColumnIndex(SoundModelContract.KEY_HINT_TEXT));     // Catch: Throwable -> L33
        int version = c.getInt(c.getColumnIndex("model_version"));     // Catch: Throwable -> L33
        if (users != null) goto L25;
        Slog.w(TAG, "Ignoring SoundModel since it doesn't specify users");     // Catch: Throwable -> L13
        db2 = db;
        goto L57
    L25:
        boolean isAvailableForCurrentUser = false;
        int r10 = users.length;     // Catch: Throwable -> L33
        int user = 0;
    L27:
        if (user >= r10) goto L35;
        int user2 = user;
        db2 = db;
        if (userHandle == users[user]) goto L31;
        user = user2 + 1;
        db = db2;
        goto L27
    L31:
        isAvailableForCurrentUser = true;
    L36:
        if (isAvailableForCurrentUser == false) goto L57;
        SoundTrigger.Keyphrase[] keyphrases = {new SoundTrigger.Keyphrase(keyphraseId, recognitionModes, modelLocale, text, users)};     // Catch: Throwable -> L41
        if (vendorUuidString == null) goto L46;
        UUID vendorUuid = UUID.fromString(vendorUuidString);     // Catch: Throwable -> L41
        UUID vendorUuid2 = vendorUuid;
    L47:
        SoundTrigger.KeyphraseSoundModel model = new SoundTrigger.KeyphraseSoundModel(UUID.fromString(modelUuid), vendorUuid2, data, keyphrases, version);     // Catch: Throwable -> L41
        c.close();
        db2.close();
        return model;
    L46:
        vendorUuid2 = null;
        goto L47
    L35:
        db2 = db;
        goto L36
    L20:
        vendorUuidString = c.getString(vendorUuidColumn);     // Catch: Throwable -> L13
        goto L21
    L55:
        Slog.w(TAG, "Ignoring SoundModel since it doesn't specify an ID");     // Catch: Throwable -> L13
        db2 = db;
    L13:
        th = th;
        db2 = db;
        goto L53
    L50:
        r0 = null;
        db2 = db;
        goto L51
    }

    private static String getCommaSeparatedString(int[] users) {
        if (users != null) goto L5;
        return "";
    L5:
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L7:
        if (i >= users.length) goto L12;
        if (i == 0) goto L10;
        sb.append(',');
    L10:
        sb.append(users[i]);
        i = i + 1;
        goto L7
    L12:
        return sb.toString();
    }

    private static int[] getArrayForCommaSeparatedString(String text) {
        if (TextUtils.isEmpty(text) == false) goto L6;
        return null;
    L6:
        String[] usersStr = text.split(",");
        int[] users = new int[usersStr.length];
        int i = 0;
    L8:
        if (i >= usersStr.length) goto L11;
        users[i] = Integer.parseInt(usersStr[i]);
        i = i + 1;
        goto L8
    L11:
        return users;
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public void dump(PrintWriter pw) {
        monitor-enter(this);
        SQLiteDatabase db = getReadableDatabase();     // Catch: Throwable -> L25
        Cursor c = db.rawQuery("SELECT  * FROM sound_model", null);     // Catch: Throwable -> L25
        pw.println("  Enrolled KeyphraseSoundModels:");     // Catch: Throwable -> L13
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
