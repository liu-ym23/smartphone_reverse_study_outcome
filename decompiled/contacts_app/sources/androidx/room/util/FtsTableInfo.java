package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class FtsTableInfo {
    private static final String[] FTS_OPTIONS = null;
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    static {
        FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    }

    public FtsTableInfo(String name, Set<String> columns, Set<String> options) {
        this.name = name;
        this.columns = columns;
        this.options = options;
    }

    public FtsTableInfo(String name, Set<String> columns, String createSql) {
        this.name = name;
        this.columns = columns;
        this.options = parseOptions(createSql);
    }

    public static FtsTableInfo read(SupportSQLiteDatabase database, String tableName) {
        return new FtsTableInfo(tableName, readColumns(database, tableName), readOptions(database, tableName));
    }

    private static Set<String> readColumns(SupportSQLiteDatabase database, String tableName) {
        Cursor r2 = database.query("PRAGMA table_info(`" + tableName + "`)");
        HashSet r3 = new HashSet();
    L12:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.getColumnCount() <= 0) goto L10;
        int r0 = r2.getColumnIndex("name");     // Catch: Throwable -> L12
    L7:
        if (r2.moveToNext() == false) goto L10;
        r3.add(r2.getString(r0));     // Catch: Throwable -> L12
    L10:
        r2.close();
        return r3;
    }

    private static Set<String> readOptions(SupportSQLiteDatabase database, String tableName) {
        Cursor r2 = database.query("SELECT * FROM sqlite_master WHERE `name` = '" + tableName + "'");
    L10:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        String r3 = r2.getString(r2.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L10
    L8:
        r2.close();
        return parseOptions(r3);
    L7:
        r3 = "";
        goto L8
    }

    static Set<String> parseOptions(String createStatement) {
        if (createStatement.isEmpty() == true) goto L5;
        String r8 = createStatement.substring(createStatement.indexOf(40) + 1, createStatement.lastIndexOf(41));
        ArrayList r0 = new ArrayList();
        ArrayDeque r1 = new ArrayDeque();
        int r3 = -1;
        int r4 = 0;
    L8:
        if (r4 >= r8.length()) goto L40;
        char r5 = r8.charAt(r4);
        if (r5 == '\"') goto L34;
        if (r5 == '\'') goto L34;
        if (r5 == ',') goto L31;
        if (r5 == '[') goto L28;
        if (r5 == ']') goto L23;
        if (r5 == '`') goto L34;
    L39:
        r4 = r4 + 1;
        goto L8
    L23:
        if (r1.isEmpty() == true) goto L39;
        if (((Character) r1.peek()).charValue() != '[') goto L39;
        r1.pop();
        goto L39
    L28:
        if (r1.isEmpty() == false) goto L39;
        r1.push(Character.valueOf(r5));
        goto L39
    L31:
        if (r1.isEmpty() == false) goto L39;
        r0.add(r8.substring(r3 + 1, r4).trim());
        r3 = r4;
    L34:
        if (r1.isEmpty() == false) goto L37;
        r1.push(Character.valueOf(r5));
        goto L39
    L37:
        if (((Character) r1.peek()).charValue() != r5) goto L39;
        r1.pop();
        goto L39
    L40:
        r0.add(r8.substring(r3 + 1).trim());
        HashSet r9 = new HashSet();
        Iterator r2 = r0.iterator();
    L42:
        if (r2.hasNext() == false) goto L49;
        String r6 = (String) r2.next();
        String[] r7 = FTS_OPTIONS;
        int r10 = r7.length;
        int r11 = 0;
    L44:
        if (r11 >= r10) goto L42;
        if (r6.startsWith(r7[r11]) == false) goto L48;
        r9.add(r6);
    L48:
        r11 = r11 + 1;
        goto L44
    L49:
        return r9;
    L5:
        return new HashSet();
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof FtsTableInfo) == true) goto L8;
        return false;
    L8:
        FtsTableInfo r5 = (FtsTableInfo) o;
        String r1 = this.name;
        if (r1 == null) goto L14;
        if (r1.equals(r5.name) == false) goto L15;
    L16:
        Set<String> r2 = this.columns;
        if (r2 == null) goto L22;
        if (r2.equals(r5.columns) == false) goto L23;
    L24:
        Set<String> r4 = this.options;
        if (r4 == null) goto L28;
        return r4.equals(r5.options);
    L28:
        if (r5.options != null) goto L31;
        return true;
    L31:
        return false;
    L23:
        return false;
    L22:
        if (r5.columns == null) goto L24;
    L15:
        return false;
    L14:
        if (r5.name == null) goto L16;
        goto L15
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Set<String> r4 = this.columns;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Set<String> r7 = this.options;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + '}';
    }
}
