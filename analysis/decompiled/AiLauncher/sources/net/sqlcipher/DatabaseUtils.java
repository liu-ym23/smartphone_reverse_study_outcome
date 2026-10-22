package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.SQLException;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import io.ktor.util.date.GMTDateParser;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

/* loaded from: classes5.dex */
public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "DatabaseUtils";
    private static final String[] countProjection = {"count(*)"};
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    private static Collator mColl = null;

    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private final String mTableName;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private SQLiteStatement mPreparedStatement = null;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        private void buildSQL() throws SQLException {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("INSERT INTO ");
            sb2.append(this.mTableName);
            sb2.append(" (");
            StringBuilder sb3 = new StringBuilder(128);
            sb3.append("VALUES (");
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", (String[]) null);
                this.mColumns = new HashMap<>(cursorRawQuery.getCount());
                int i10 = 1;
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(1);
                    String string2 = cursorRawQuery.getString(4);
                    this.mColumns.put(string, Integer.valueOf(i10));
                    sb2.append("'");
                    sb2.append(string);
                    sb2.append("'");
                    if (string2 == null) {
                        sb3.append("?");
                    } else {
                        sb3.append("COALESCE(?, ");
                        sb3.append(string2);
                        sb3.append(")");
                    }
                    sb2.append(i10 == cursorRawQuery.getCount() ? ") " : ", ");
                    sb3.append(i10 == cursorRawQuery.getCount() ? ");" : ", ");
                    i10++;
                }
                cursorRawQuery.close();
                sb2.append((CharSequence) sb3);
                this.mInsertSQL = sb2.toString();
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        }

        private SQLiteStatement getStatement(boolean z10) throws SQLException {
            if (!z10) {
                if (this.mInsertStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
                }
                return this.mInsertStatement;
            }
            if (this.mReplaceStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
            }
            return this.mReplaceStatement;
        }

        private synchronized long insertInternal(ContentValues contentValues, boolean z10) {
            SQLiteStatement statement;
            try {
                try {
                    statement = getStatement(z10);
                    statement.clearBindings();
                    for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                        DatabaseUtils.bindObjectToProgram(statement, getColumnIndex(entry.getKey()), entry.getValue());
                    }
                } catch (SQLException e10) {
                    Log.e(DatabaseUtils.TAG, "Error inserting " + contentValues + " into table  " + this.mTableName, e10);
                    return -1L;
                }
            } catch (Throwable th) {
                throw th;
            }
            return statement.executeInsert();
        }

        public void bind(int i10, double d10) {
            this.mPreparedStatement.bindDouble(i10, d10);
        }

        public void bindNull(int i10) {
            this.mPreparedStatement.bindNull(i10);
        }

        public void close() {
            SQLiteStatement sQLiteStatement = this.mInsertStatement;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
                this.mInsertStatement = null;
            }
            SQLiteStatement sQLiteStatement2 = this.mReplaceStatement;
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
        }

        public long execute() {
            SQLiteStatement sQLiteStatement = this.mPreparedStatement;
            if (sQLiteStatement == null) {
                throw new IllegalStateException("you must prepare this inserter before calling execute");
            }
            try {
                try {
                    return sQLiteStatement.executeInsert();
                } catch (SQLException e10) {
                    Log.e(DatabaseUtils.TAG, "Error executing InsertHelper with table " + this.mTableName, e10);
                    this.mPreparedStatement = null;
                    return -1L;
                }
            } finally {
                this.mPreparedStatement = null;
            }
        }

        public int getColumnIndex(String str) throws SQLException {
            getStatement(false);
            Integer num = this.mColumns.get(str);
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalArgumentException("column '" + str + "' is invalid");
        }

        public long insert(ContentValues contentValues) {
            return insertInternal(contentValues, false);
        }

        public void prepareForInsert() throws SQLException {
            SQLiteStatement statement = getStatement(false);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public void prepareForReplace() throws SQLException {
            SQLiteStatement statement = getStatement(true);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public long replace(ContentValues contentValues) {
            return insertInternal(contentValues, true);
        }

        public void bind(int i10, float f10) {
            this.mPreparedStatement.bindDouble(i10, f10);
        }

        public void bind(int i10, long j10) {
            this.mPreparedStatement.bindLong(i10, j10);
        }

        public void bind(int i10, int i11) {
            this.mPreparedStatement.bindLong(i10, i11);
        }

        public void bind(int i10, boolean z10) {
            this.mPreparedStatement.bindLong(i10, z10 ? 1L : 0L);
        }

        public void bind(int i10, byte[] bArr) {
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i10);
            } else {
                this.mPreparedStatement.bindBlob(i10, bArr);
            }
        }

        public void bind(int i10, String str) {
            if (str == null) {
                this.mPreparedStatement.bindNull(i10);
            } else {
                this.mPreparedStatement.bindString(i10, str);
            }
        }
    }

    public static void appendEscapedSQLString(StringBuilder sb2, String str) {
        sb2.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == '\'') {
                    sb2.append('\'');
                }
                sb2.append(cCharAt);
            }
        } else {
            sb2.append(str);
        }
        sb2.append('\'');
    }

    public static final void appendValueToSql(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("NULL");
            return;
        }
        if (!(obj instanceof Boolean)) {
            appendEscapedSQLString(sb2, obj.toString());
        } else if (((Boolean) obj).booleanValue()) {
            sb2.append('1');
        } else {
            sb2.append('0');
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i10, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i10);
            return;
        }
        if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i10, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Number) {
            sQLiteProgram.bindLong(i10, ((Number) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i10, 1L);
                return;
            } else {
                sQLiteProgram.bindLong(i10, 0L);
                return;
            }
        }
        if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i10, (byte[]) obj);
        } else {
            sQLiteProgram.bindString(i10, obj.toString());
        }
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return "(" + str + ") AND (" + str2 + ")";
    }

    public static void cursorDoubleToContentValues(android.database.Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Double) null);
        } else {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        }
    }

    public static void cursorDoubleToContentValuesIfPresent(android.database.Cursor cursor, ContentValues contentValues, String str) throws IllegalArgumentException {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndexOrThrow)));
    }

    public static void cursorDoubleToCursorValues(android.database.Cursor cursor, String str, ContentValues contentValues) {
        cursorDoubleToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorFillWindow(android.database.Cursor cursor, int i10, android.database.CursorWindow cursorWindow) {
        boolean zPutNull;
        if (i10 < 0 || i10 >= cursor.getCount()) {
            return;
        }
        int position = cursor.getPosition();
        int columnCount = cursor.getColumnCount();
        cursorWindow.clear();
        cursorWindow.setStartPosition(i10);
        cursorWindow.setNumColumns(columnCount);
        if (cursor.moveToPosition(i10)) {
            while (cursorWindow.allocRow()) {
                int i11 = 0;
                while (true) {
                    if (i11 >= columnCount) {
                        break;
                    }
                    int type = cursor.getType(i11);
                    if (type == 0) {
                        zPutNull = cursorWindow.putNull(i10, i11);
                    } else if (type == 1) {
                        zPutNull = cursorWindow.putLong(cursor.getLong(i11), i10, i11);
                    } else if (type == 2) {
                        zPutNull = cursorWindow.putDouble(cursor.getDouble(i11), i10, i11);
                    } else if (type != 4) {
                        String string = cursor.getString(i11);
                        zPutNull = string != null ? cursorWindow.putString(string, i10, i11) : cursorWindow.putNull(i10, i11);
                    } else {
                        byte[] blob = cursor.getBlob(i11);
                        zPutNull = blob != null ? cursorWindow.putBlob(blob, i10, i11) : cursorWindow.putNull(i10, i11);
                    }
                    if (!zPutNull) {
                        cursorWindow.freeLastRow();
                        break;
                    }
                    i11++;
                }
                i10++;
                if (!cursor.moveToNext()) {
                    break;
                }
            }
        }
        cursor.moveToPosition(position);
    }

    public static void cursorFloatToContentValuesIfPresent(android.database.Cursor cursor, ContentValues contentValues, String str) throws IllegalArgumentException {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndexOrThrow)));
    }

    public static void cursorIntToContentValues(android.database.Cursor cursor, String str, ContentValues contentValues) {
        cursorIntToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorIntToContentValuesIfPresent(android.database.Cursor cursor, ContentValues contentValues, String str) throws IllegalArgumentException {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndexOrThrow)));
    }

    public static void cursorLongToContentValues(android.database.Cursor cursor, String str, ContentValues contentValues) {
        cursorLongToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorLongToContentValuesIfPresent(android.database.Cursor cursor, ContentValues contentValues, String str) throws IllegalArgumentException {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Long.valueOf(cursor.getLong(columnIndexOrThrow)));
    }

    public static void cursorRowToContentValues(android.database.Cursor cursor, ContentValues contentValues) {
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (abstractWindowedCursor == null || !abstractWindowedCursor.isBlob(i10)) {
                contentValues.put(columnNames[i10], cursor.getString(i10));
            } else {
                contentValues.put(columnNames[i10], cursor.getBlob(i10));
            }
        }
    }

    public static void cursorShortToContentValuesIfPresent(android.database.Cursor cursor, ContentValues contentValues, String str) throws IllegalArgumentException {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Short.valueOf(cursor.getShort(columnIndexOrThrow)));
    }

    public static void cursorStringToContentValues(android.database.Cursor cursor, String str, ContentValues contentValues) {
        cursorStringToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorStringToContentValuesIfPresent(android.database.Cursor cursor, ContentValues contentValues, String str) throws IllegalArgumentException {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, cursor.getString(columnIndexOrThrow));
    }

    public static void cursorStringToInsertHelper(android.database.Cursor cursor, String str, InsertHelper insertHelper, int i10) {
        insertHelper.bind(i10, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(android.database.Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static String dumpCurrentRowToString(android.database.Cursor cursor) {
        StringBuilder sb2 = new StringBuilder();
        dumpCurrentRow(cursor, sb2);
        return sb2.toString();
    }

    public static void dumpCursor(android.database.Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static String dumpCursorToString(android.database.Cursor cursor) {
        StringBuilder sb2 = new StringBuilder();
        dumpCursor(cursor, sb2);
        return sb2.toString();
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 & 240) >>> 4];
            i10 += 2;
            cArr2[i11] = cArr[b10 & 15];
        }
        return cArr2;
    }

    public static String getCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            return new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] getCollationKeyInBytes(String str) {
        if (mColl == null) {
            Collator collator = Collator.getInstance();
            mColl = collator;
            collator.setStrength(0);
        }
        return mColl.getCollationKey(str).toByteArray();
    }

    public static String getHexCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        return new String(encodeHex(collationKeyInBytes, HEX_DIGITS_LOWER), 0, getKeyLen(collationKeyInBytes) * 2);
    }

    private static int getKeyLen(byte[] bArr) {
        return bArr[bArr.length + (-1)] != 0 ? bArr.length : bArr.length - 1;
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        return ((obj instanceof Long) || (obj instanceof Integer)) ? 1 : 3;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return longForQuery(sQLiteStatementCompileStatement, strArr);
        } finally {
            sQLiteStatementCompileStatement.close();
        }
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query(str, countProjection, null, null, null, null, null);
        try {
            cursorQuery.moveToFirst();
            return cursorQuery.getLong(0);
        } finally {
            cursorQuery.close();
        }
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        int i10 = parcel.readInt();
        if (i10 == 0) {
            return;
        }
        readExceptionFromParcel(parcel, parcel.readString(), i10);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) throws FileNotFoundException {
        int i10 = parcel.readInt();
        if (i10 == 0) {
            return;
        }
        String string = parcel.readString();
        if (i10 == 1) {
            throw new FileNotFoundException(string);
        }
        readExceptionFromParcel(parcel, string, i10);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) throws OperationApplicationException {
        int i10 = parcel.readInt();
        if (i10 == 0) {
            return;
        }
        String string = parcel.readString();
        if (i10 == 10) {
            throw new OperationApplicationException(string);
        }
        readExceptionFromParcel(parcel, string, i10);
    }

    public static String sqlEscapeString(String str) {
        StringBuilder sb2 = new StringBuilder();
        appendEscapedSQLString(sb2, str);
        return sb2.toString();
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return stringForQuery(sQLiteStatementCompileStatement, strArr);
        } finally {
            sQLiteStatementCompileStatement.close();
        }
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exc) {
        int i10;
        boolean z10;
        int i11 = 1;
        if (exc instanceof FileNotFoundException) {
            z10 = false;
        } else {
            if (exc instanceof IllegalArgumentException) {
                i10 = 2;
            } else if (exc instanceof UnsupportedOperationException) {
                i10 = 3;
            } else if (exc instanceof SQLiteAbortException) {
                i10 = 4;
            } else if (exc instanceof SQLiteConstraintException) {
                i10 = 5;
            } else if (exc instanceof SQLiteDatabaseCorruptException) {
                i10 = 6;
            } else if (exc instanceof SQLiteFullException) {
                i10 = 7;
            } else if (exc instanceof SQLiteDiskIOException) {
                i10 = 8;
            } else if (exc instanceof SQLiteException) {
                i10 = 9;
            } else {
                if (!(exc instanceof OperationApplicationException)) {
                    parcel.writeException(exc);
                    Log.e(TAG, "Writing exception to parcel", exc);
                    return;
                }
                i10 = 10;
            }
            i11 = i10;
            z10 = true;
        }
        parcel.writeInt(i11);
        parcel.writeString(exc.getMessage());
        if (z10) {
            Log.e(TAG, "Writing exception to parcel", exc);
        }
    }

    public static void cursorIntToContentValues(android.database.Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Integer) null);
        } else {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        }
    }

    public static void cursorLongToContentValues(android.database.Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Long) null);
        } else {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        }
    }

    public static void cursorStringToContentValues(android.database.Cursor cursor, String str, ContentValues contentValues, String str2) {
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(android.database.Cursor cursor, PrintStream printStream) {
        String string;
        String[] columnNames = cursor.getColumnNames();
        printStream.println("" + cursor.getPosition() + " {");
        int length = columnNames.length;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                string = cursor.getString(i10);
            } catch (SQLiteException unused) {
                string = "<unprintable>";
            }
            printStream.println("   " + columnNames[i10] + '=' + string);
        }
        printStream.println("}");
    }

    public static void dumpCursor(android.database.Cursor cursor, PrintStream printStream) {
        printStream.println(">>>>> Dumping cursor " + cursor);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i10) {
        switch (i10) {
            case 2:
                throw new IllegalArgumentException(str);
            case 3:
                throw new UnsupportedOperationException(str);
            case 4:
                throw new SQLiteAbortException(str);
            case 5:
                throw new SQLiteConstraintException(str);
            case 6:
                throw new SQLiteDatabaseCorruptException(str);
            case 7:
                throw new SQLiteFullException(str);
            case 8:
                throw new SQLiteDiskIOException(str);
            case 9:
                throw new SQLiteException(str);
            default:
                parcel.readException(i10, str);
                return;
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                bindObjectToProgram(sQLiteStatement, i11, strArr[i10]);
                i10 = i11;
            }
        }
        return sQLiteStatement.simpleQueryForLong();
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                bindObjectToProgram(sQLiteStatement, i11, strArr[i10]);
                i10 = i11;
            }
        }
        return sQLiteStatement.simpleQueryForString();
    }

    public static void dumpCurrentRow(android.database.Cursor cursor, StringBuilder sb2) {
        String string;
        String[] columnNames = cursor.getColumnNames();
        sb2.append("" + cursor.getPosition() + " {\n");
        int length = columnNames.length;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                string = cursor.getString(i10);
            } catch (SQLiteException unused) {
                string = "<unprintable>";
            }
            sb2.append("   " + columnNames[i10] + '=' + string + "\n");
        }
        sb2.append("}\n");
    }

    public static void dumpCursor(android.database.Cursor cursor, StringBuilder sb2) {
        sb2.append(">>>>> Dumping cursor " + cursor + "\n");
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb2);
            }
            cursor.moveToPosition(position);
        }
        sb2.append("<<<<<\n");
    }
}
