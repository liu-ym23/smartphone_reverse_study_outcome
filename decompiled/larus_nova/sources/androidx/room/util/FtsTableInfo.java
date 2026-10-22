package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
public final class FtsTableInfo {
    private static final String[] FTS_OPTIONS = null;
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Set<String> r104 = this.columns;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Set<String> r107 = this.options;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + '}';
    }

    static {
        FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    }

    public static Set<String> parseOptions(String r100) {
        if (r100.isEmpty() == true) goto L5;
        String r101 = r100.substring(r100.indexOf(40) + 1, r100.lastIndexOf(41));
        ArrayList r102 = new ArrayList();
        ArrayDeque r103 = new ArrayDeque();
        int r104 = -1;
        int r105 = 0;
    L8:
        if (r105 >= r101.length()) goto L40;
        char r106 = r101.charAt(r105);
        if (r106 == '\"') goto L34;
        if (r106 == '\'') goto L34;
        if (r106 == ',') goto L31;
        if (r106 == '[') goto L28;
        if (r106 == ']') goto L23;
        if (r106 == '`') goto L34;
    L39:
        r105 = r105 + 1;
        goto L8
    L23:
        if (r103.isEmpty() == true) goto L39;
        if (((Character) r103.peek()).charValue() != '[') goto L39;
        r103.pop();
        goto L39
    L28:
        if (r103.isEmpty() == false) goto L39;
        r103.push(Character.valueOf(r106));
        goto L39
    L31:
        if (r103.isEmpty() == false) goto L39;
        r102.add(r101.substring(r104 + 1, r105).trim());
        r104 = r105;
    L34:
        if (r103.isEmpty() == false) goto L37;
        r103.push(Character.valueOf(r106));
        goto L39
    L37:
        if (((Character) r103.peek()).charValue() != r106) goto L39;
        r103.pop();
        goto L39
    L40:
        r102.add(r101.substring(r104 + 1).trim());
        HashSet r107 = new HashSet();
        Iterator r108 = r102.iterator();
    L42:
        if (r108.hasNext() == false) goto L49;
        String r109 = (String) r108.next();
        String[] r110 = FTS_OPTIONS;
        int r111 = r110.length;
        int r112 = 0;
    L44:
        if (r112 >= r111) goto L42;
        if (r109.startsWith(r110[r112]) == false) goto L48;
        r107.add(r109);
    L48:
        r112 = r112 + 1;
        goto L44
    L49:
        return r107;
    L5:
        return new HashSet();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FtsTableInfo) == true) goto L8;
        return false;
    L8:
        FtsTableInfo r101 = (FtsTableInfo) r100;
        String r102 = this.name;
        if (r102 == null) goto L14;
        if (r102.equals(r101.name) == false) goto L15;
    L16:
        Set<String> r103 = this.columns;
        if (r103 == null) goto L22;
        if (r103.equals(r101.columns) == false) goto L23;
    L24:
        Set<String> r104 = this.options;
        Set<String> r105 = r101.options;
        if (r104 != null) goto L31;
        if (r105 == null) goto L32;
        return false;
    L32:
        return true;
    L31:
        return r104.equals(r105);
    L23:
        return false;
    L22:
        if (r101.columns == null) goto L24;
    L15:
        return false;
    L14:
        if (r101.name == null) goto L16;
        goto L15
    }

    public static FtsTableInfo read(SupportSQLiteDatabase r100, String r101) {
        return new FtsTableInfo(r101, readColumns(r100, r101), readOptions(r100, r101));
    }

    private static Set<String> readColumns(SupportSQLiteDatabase r100, String r101) {
        Cursor r102 = r100.query("PRAGMA table_info(`" + r101 + "`)");
        HashSet r103 = new HashSet();
    L12:
        th = move-exception;
        r102.close();
        throw th;
    L4:
        if (r102.getColumnCount() <= 0) goto L10;
        int r104 = r102.getColumnIndex("name");     // Catch: Throwable -> L12
    L7:
        if (r102.moveToNext() == false) goto L10;
        r103.add(r102.getString(r104));     // Catch: Throwable -> L12
    L10:
        r102.close();
        return r103;
    }

    private static Set<String> readOptions(SupportSQLiteDatabase r100, String r101) {
        Cursor r102 = r100.query("SELECT * FROM sqlite_master WHERE `name` = '" + r101 + "'");
    L10:
        th = move-exception;
        r102.close();
        throw th;
    L4:
        if (r102.moveToFirst() == false) goto L7;
        String r103 = r102.getString(r102.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L10
    L8:
        r102.close();
        return parseOptions(r103);
    L7:
        r103 = "";
        goto L8
    }

    public FtsTableInfo(String r100, Set<String> r101, String r102) {
        this.name = r100;
        this.columns = r101;
        this.options = parseOptions(r102);
    }

    public FtsTableInfo(String r100, Set<String> r101, Set<String> r102) {
        this.name = r100;
        this.columns = r101;
        this.options = r102;
    }
}
