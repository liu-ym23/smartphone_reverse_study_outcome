package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public static final class Column {
        public final int affinity;
        public final String defaultValue;
        private final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        @Deprecated
        public Column(String name, String type, boolean notNull, int primaryKeyPosition) {
            this(name, type, notNull, primaryKeyPosition, null, 0);
        }

        public Column(String name, String type, boolean notNull, int primaryKeyPosition, String defaultValue, int createdFrom) {
            this.name = name;
            this.type = type;
            this.notNull = notNull;
            this.primaryKeyPosition = primaryKeyPosition;
            this.affinity = findAffinity(type);
            this.defaultValue = defaultValue;
            this.mCreatedFrom = createdFrom;
        }

        private static int findAffinity(String type) {
            if (type != null) goto L5;
            return 5;
        L5:
            String r2 = type.toUpperCase(Locale.US);
            if (r2.contains("INT") == false) goto L10;
            return 3;
        L10:
            if (r2.contains("CHAR") == false) goto L12;
            return 2;
        L12:
            if (r2.contains("CLOB") == false) goto L14;
            return 2;
        L14:
            if (r2.contains("TEXT") == false) goto L17;
            return 2;
        L17:
            if (r2.contains("BLOB") == false) goto L20;
            return 5;
        L20:
            if (r2.contains("REAL") == false) goto L22;
            return 4;
        L22:
            if (r2.contains("FLOA") == false) goto L24;
            return 4;
        L24:
            if (r2.contains("DOUB") == true) goto L33;
            return 1;
        L33:
            return 4;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof Column) == true) goto L8;
            return false;
        L8:
            Column r6 = (Column) o;
            if (this.primaryKeyPosition == r6.primaryKeyPosition) goto L12;
            return false;
        L12:
            if (this.name.equals(r6.name) == true) goto L15;
            return false;
        L15:
            if (this.notNull == r6.notNull) goto L18;
            return false;
        L18:
            if (this.mCreatedFrom != 1) goto L27;
            if (r6.mCreatedFrom != 2) goto L27;
            String r1 = this.defaultValue;
            if (r1 == null) goto L27;
            if (r1.equals(r6.defaultValue) == true) goto L27;
            return false;
        L27:
            if (this.mCreatedFrom == 2) goto L29;
        L35:
            int r2 = this.mCreatedFrom;
            if (r2 == 0) goto L48;
            if (r2 != r6.mCreatedFrom) goto L48;
            String r3 = this.defaultValue;
            if (r3 == null) goto L45;
            if (r3.equals(r6.defaultValue) == true) goto L48;
        L46:
            return false;
        L45:
            if (r6.defaultValue != null) goto L46;
        L48:
            if (this.affinity != r6.affinity) goto L51;
            return true;
        L51:
            return false;
        L29:
            if (r6.mCreatedFrom != 1) goto L35;
            String r4 = r6.defaultValue;
            if (r4 == null) goto L35;
            if (r4.equals(this.defaultValue) == true) goto L35;
            return false;
        }

        public boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.primaryKeyPosition;
        L5:
            r1 = 1237;
            goto L7
        }

        public String toString() {
            return "Column{name='" + this.name + "', type='" + this.type + "', affinity='" + this.affinity + "', notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + ", defaultValue='" + this.defaultValue + "'}";
        }
    }

    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String referenceTable, String onDelete, String onUpdate, List<String> columnNames, List<String> referenceColumnNames) {
            this.referenceTable = referenceTable;
            this.onDelete = onDelete;
            this.onUpdate = onUpdate;
            this.columnNames = Collections.unmodifiableList(columnNames);
            this.referenceColumnNames = Collections.unmodifiableList(referenceColumnNames);
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof ForeignKey) == true) goto L8;
            return false;
        L8:
            ForeignKey r4 = (ForeignKey) o;
            if (this.referenceTable.equals(r4.referenceTable) == true) goto L12;
            return false;
        L12:
            if (this.onDelete.equals(r4.onDelete) == true) goto L15;
            return false;
        L15:
            if (this.onUpdate.equals(r4.onUpdate) == true) goto L18;
            return false;
        L18:
            if (this.columnNames.equals(r4.columnNames) == true) goto L21;
            return false;
        L21:
            return this.referenceColumnNames.equals(r4.referenceColumnNames);
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        final String mFrom;
        final int mId;
        final int mSequence;
        final String mTo;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ForeignKeyWithSequence o) {
            return compareTo2(o);
        }

        ForeignKeyWithSequence(int id, int sequence, String from, String to) {
            this.mId = id;
            this.mSequence = sequence;
            this.mFrom = from;
            this.mTo = to;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ForeignKeyWithSequence o) {
            int r0 = this.mId - o.mId;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return this.mSequence - o.mSequence;
        }
    }

    public static final class Index {
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public final boolean unique;

        public Index(String name, boolean unique, List<String> columns) {
            this.name = name;
            this.unique = unique;
            this.columns = columns;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof Index) == true) goto L8;
            return false;
        L8:
            Index r4 = (Index) o;
            if (this.unique == r4.unique) goto L12;
            return false;
        L12:
            if (this.columns.equals(r4.columns) == true) goto L15;
            return false;
        L15:
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L19;
            return r4.name.startsWith(DEFAULT_PREFIX);
        L19:
            return this.name.equals(r4.name);
        }

        public int hashCode() {
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L5;
            int r0 = -1184239155;
        L7:
            return (((r0 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode();
        L5:
            r0 = this.name.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + '}';
        }
    }

    public TableInfo(String name, Map<String, Column> columns, Set<ForeignKey> foreignKeys, Set<Index> indices) {
        this.name = name;
        this.columns = Collections.unmodifiableMap(columns);
        this.foreignKeys = Collections.unmodifiableSet(foreignKeys);
        if (indices != null) goto L5;
        Set<Index> r1 = null;
    L6:
        this.indices = r1;
        return;
    L5:
        r1 = Collections.unmodifiableSet(indices);
        goto L6
    }

    public TableInfo(String name, Map<String, Column> columns, Set<ForeignKey> foreignKeys) {
        this(name, columns, foreignKeys, Collections.emptySet());
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof TableInfo) == true) goto L8;
        return false;
    L8:
        TableInfo r5 = (TableInfo) o;
        String r1 = this.name;
        if (r1 == null) goto L14;
        if (r1.equals(r5.name) == false) goto L15;
    L16:
        Map<String, Column> r2 = this.columns;
        if (r2 == null) goto L22;
        if (r2.equals(r5.columns) == false) goto L23;
    L24:
        Set<ForeignKey> r3 = this.foreignKeys;
        if (r3 == null) goto L30;
        if (r3.equals(r5.foreignKeys) == false) goto L31;
    L32:
        Set<Index> r4 = this.indices;
        if (r4 == null) goto L39;
        Set<Index> r6 = r5.indices;
        if (r6 == null) goto L39;
        return r4.equals(r6);
    L39:
        return true;
    L31:
        return false;
    L30:
        if (r5.foreignKeys == null) goto L32;
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
        Map<String, Column> r4 = this.columns;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Set<ForeignKey> r7 = this.foreignKeys;
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
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public static TableInfo read(SupportSQLiteDatabase database, String tableName) {
        return new TableInfo(tableName, readColumns(database, tableName), readForeignKeys(database, tableName), readIndices(database, tableName));
    }

    private static Set<ForeignKey> readForeignKeys(SupportSQLiteDatabase database, String tableName) {
        HashSet r0 = new HashSet();
        Cursor r1 = database.query("PRAGMA foreign_key_list(`" + tableName + "`)");
        int r2 = r1.getColumnIndex("id");     // Catch: Throwable -> L18
        int r3 = r1.getColumnIndex("seq");     // Catch: Throwable -> L18
        int r4 = r1.getColumnIndex("table");     // Catch: Throwable -> L18
        int r5 = r1.getColumnIndex("on_delete");     // Catch: Throwable -> L18
        int r6 = r1.getColumnIndex("on_update");     // Catch: Throwable -> L18
        List<ForeignKeyWithSequence> r7 = readForeignKeyFieldMappings(r1);     // Catch: Throwable -> L18
        int r8 = r1.getCount();     // Catch: Throwable -> L18
        int r9 = 0;
    L4:
        if (r9 >= r8) goto L16;
        r1.moveToPosition(r9);     // Catch: Throwable -> L18
        if (r1.getInt(r3) != 0) goto L15;
        int r10 = r1.getInt(r2);     // Catch: Throwable -> L18
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L18
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<ForeignKeyWithSequence> r11 = r7.iterator();     // Catch: Throwable -> L18
    L10:
        if (r11.hasNext() == false) goto L14;
        ForeignKeyWithSequence r12 = r11.next();     // Catch: Throwable -> L18
        if (r12.mId != r10) goto L10;
        r15.add(r12.mFrom);     // Catch: Throwable -> L18
        r14.add(r12.mTo);     // Catch: Throwable -> L18
        goto L10
    L14:
        r0.add(new ForeignKey(r1.getString(r4), r1.getString(r5), r1.getString(r6), r15, r14));     // Catch: Throwable -> L18
    L15:
        r9 = r9 + 1;
        goto L4
    L16:
        r1.close();
        return r0;
    L18:
        th = move-exception;
        r1.close();
        throw th;
    }

    private static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int r0 = cursor.getColumnIndex("id");
        int r1 = cursor.getColumnIndex("seq");
        int r2 = cursor.getColumnIndex("from");
        int r3 = cursor.getColumnIndex("to");
        int r4 = cursor.getCount();
        ArrayList r5 = new ArrayList();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        cursor.moveToPosition(r6);
        r5.add(new ForeignKeyWithSequence(cursor.getInt(r0), cursor.getInt(r1), cursor.getString(r2), cursor.getString(r3)));
        r6 = r6 + 1;
        goto L3
    L5:
        Collections.sort(r5);
        return r5;
    }

    private static Map<String, Column> readColumns(SupportSQLiteDatabase database, String tableName) {
        Cursor r14 = database.query("PRAGMA table_info(`" + tableName + "`)");
        HashMap r15 = new HashMap();
    L16:
        th = move-exception;
        r14.close();
        throw th;
    L4:
        if (r14.getColumnCount() <= 0) goto L14;
        int r0 = r14.getColumnIndex("name");     // Catch: Throwable -> L16
        int r1 = r14.getColumnIndex("type");     // Catch: Throwable -> L16
        int r2 = r14.getColumnIndex("notnull");     // Catch: Throwable -> L16
        int r3 = r14.getColumnIndex("pk");     // Catch: Throwable -> L16
        int r4 = r14.getColumnIndex("dflt_value");     // Catch: Throwable -> L16
    L7:
        if (r14.moveToNext() == false) goto L14;
        String r5 = r14.getString(r0);     // Catch: Throwable -> L16
        String r8 = r14.getString(r1);     // Catch: Throwable -> L16
        if (r14.getInt(r2) == 0) goto L11;
        boolean r6 = true;
    L12:
        r15.put(r5, new Column(r5, r8, r6, r14.getInt(r3), r14.getString(r4), 2));     // Catch: Throwable -> L16
        goto L7
    L11:
        r6 = false;
    L14:
        r14.close();
        return r15;
    }

    private static Set<Index> readIndices(SupportSQLiteDatabase database, String tableName) {
        Cursor r9 = database.query("PRAGMA index_list(`" + tableName + "`)");
        int r0 = r9.getColumnIndex("name");     // Catch: Throwable -> L28
        int r1 = r9.getColumnIndex("origin");     // Catch: Throwable -> L28
        int r2 = r9.getColumnIndex("unique");     // Catch: Throwable -> L28
        if (r0 == (-1)) goto L26;
        if (r1 == (-1)) goto L26;
        if (r2 == (-1)) goto L26;
        HashSet r4 = new HashSet();     // Catch: Throwable -> L28
    L10:
        if (r9.moveToNext() == false) goto L24;
        if ("c".equals(r9.getString(r1)) == false) goto L10;
        String r5 = r9.getString(r0);     // Catch: Throwable -> L28
        boolean r7 = true;
        if (r9.getInt(r2) == 1) goto L18;
        r7 = false;
    L18:
        Index r6 = readIndex(database, r5, r7);     // Catch: Throwable -> L28
        if (r6 == null) goto L20;
        r4.add(r6);     // Catch: Throwable -> L28
        goto L10
    L20:
        r9.close();
        return null;
    L24:
        r9.close();
        return r4;
    L26:
        r9.close();
        return null;
    L28:
        th = move-exception;
        r9.close();
        throw th;
    }

    private static Index readIndex(SupportSQLiteDatabase database, String name, boolean unique) {
        Cursor r6 = database.query("PRAGMA index_xinfo(`" + name + "`)");
        int r0 = r6.getColumnIndex("seqno");     // Catch: Throwable -> L20
        int r1 = r6.getColumnIndex("cid");     // Catch: Throwable -> L20
        int r2 = r6.getColumnIndex("name");     // Catch: Throwable -> L20
        if (r0 == (-1)) goto L18;
        if (r1 == (-1)) goto L18;
        if (r2 == (-1)) goto L18;
        TreeMap r3 = new TreeMap();     // Catch: Throwable -> L20
    L10:
        if (r6.moveToNext() == false) goto L15;
        if (r6.getInt(r1) < 0) goto L10;
        int r4 = r6.getInt(r0);     // Catch: Throwable -> L20
        r3.put(Integer.valueOf(r4), r6.getString(r2));     // Catch: Throwable -> L20
        goto L10
    L15:
        ArrayList r5 = new ArrayList(r3.size());     // Catch: Throwable -> L20
        r5.addAll(r3.values());     // Catch: Throwable -> L20
        Index r7 = new Index(name, unique, r5);     // Catch: Throwable -> L20
        r6.close();
        return r7;
    L18:
        r6.close();
        return null;
    L20:
        th = move-exception;
        r6.close();
        throw th;
    }
}
