package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.trace.CopyContentTypeString;
import com.tencent.open.SocialConstants;
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

/* JADX INFO: loaded from: classes6.dex */
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

        public int hashCode() {
            int r100 = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.primaryKeyPosition;
        L5:
            r101 = 1237;
            goto L7
        }

        public boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "Column{name='" + this.name + "', type='" + this.type + "', affinity='" + this.affinity + "', notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + ", defaultValue='" + this.defaultValue + "'}";
        }

        private static boolean containsSurroundingParenthesis(String r100) {
            if (r100.length() != 0) goto L5;
            return false;
        L5:
            int r101 = 0;
            int r102 = 0;
        L7:
            if (r101 >= r100.length()) goto L22;
            char r103 = r100.charAt(r101);
            if (r101 != 0) goto L12;
            if (r103 == '(') goto L12;
            return false;
        L12:
            if (r103 != '(') goto L15;
            r102 = r102 + 1;
        L21:
            r101 = r101 + 1;
            goto L7
        L15:
            if (r103 != ')') goto L21;
            r102 = r102 - 1;
            if (r102 != 0) goto L21;
            if (r101 == (r100.length() - 1)) goto L21;
            return false;
        L22:
            if (r102 != 0) goto L32;
            return true;
        L32:
            return false;
        }

        private static int findAffinity(String r100) {
            if (r100 != null) goto L5;
            return 5;
        L5:
            String r101 = r100.toUpperCase(Locale.US);
            if (r101.contains("INT") == false) goto L10;
            return 3;
        L10:
            if (r101.contains("CHAR") == false) goto L12;
            return 2;
        L12:
            if (r101.contains("CLOB") == false) goto L14;
            return 2;
        L14:
            if (r101.contains(CardAdapter.TEXT) == false) goto L17;
            return 2;
        L17:
            if (r101.contains("BLOB") == false) goto L20;
            return 5;
        L20:
            if (r101.contains("REAL") == false) goto L22;
            return 4;
        L22:
            if (r101.contains("FLOA") == false) goto L24;
            return 4;
        L24:
            if (r101.contains("DOUB") == true) goto L33;
            return 1;
        L33:
            return 4;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Column) == true) goto L8;
            return false;
        L8:
            Column r101 = (Column) r100;
            if (this.primaryKeyPosition == r101.primaryKeyPosition) goto L12;
            return false;
        L12:
            if (this.name.equals(r101.name) == true) goto L15;
            return false;
        L15:
            if (this.notNull == r101.notNull) goto L18;
            return false;
        L18:
            if (this.mCreatedFrom != 1) goto L27;
            if (r101.mCreatedFrom != 2) goto L27;
            String r102 = this.defaultValue;
            if (r102 == null) goto L27;
            if (defaultValueEquals(r102, r101.defaultValue) == true) goto L27;
            return false;
        L27:
            if (this.mCreatedFrom == 2) goto L29;
        L35:
            int r103 = this.mCreatedFrom;
            if (r103 == 0) goto L48;
            if (r103 != r101.mCreatedFrom) goto L48;
            String r104 = this.defaultValue;
            if (r104 == null) goto L45;
            if (defaultValueEquals(r104, r101.defaultValue) == true) goto L48;
        L46:
            return false;
        L45:
            if (r101.defaultValue != null) goto L46;
        L48:
            if (this.affinity == r101.affinity) goto L52;
            return false;
        L52:
            return true;
        L29:
            if (r101.mCreatedFrom != 1) goto L35;
            String r105 = r101.defaultValue;
            if (r105 == null) goto L35;
            if (defaultValueEquals(r105, this.defaultValue) == true) goto L35;
            return false;
        }

        public static boolean defaultValueEquals(String r100, String r101) {
            if (r101 != null) goto L6;
            return false;
        L6:
            if (r100.equals(r101) == false) goto L9;
            return true;
        L9:
            if (containsSurroundingParenthesis(r100) == true) goto L11;
            return false;
        L11:
            return r100.substring(1, r100.length() - 1).trim().equals(r101);
        }

        public Column(String r100, String r101, boolean r110, int r111) {
            this(r100, r101, r110, r111, null, 0);
        }

        public Column(String r100, String r101, boolean r102, int r103, String r104, int r105) {
            this.name = r100;
            this.type = r101;
            this.notNull = r102;
            this.primaryKeyPosition = r103;
            this.affinity = findAffinity(r101);
            this.defaultValue = r104;
            this.mCreatedFrom = r105;
        }
    }

    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ForeignKey) == true) goto L8;
            return false;
        L8:
            ForeignKey r101 = (ForeignKey) r100;
            if (this.referenceTable.equals(r101.referenceTable) == true) goto L12;
            return false;
        L12:
            if (this.onDelete.equals(r101.onDelete) == true) goto L15;
            return false;
        L15:
            if (this.onUpdate.equals(r101.onUpdate) == true) goto L18;
            return false;
        L18:
            if (this.columnNames.equals(r101.columnNames) == true) goto L21;
            return false;
        L21:
            return this.referenceColumnNames.equals(r101.referenceColumnNames);
        }

        public ForeignKey(String r100, String r101, String r102, List<String> r103, List<String> r104) {
            this.referenceTable = r100;
            this.onDelete = r101;
            this.onUpdate = r102;
            this.columnNames = Collections.unmodifiableList(r103);
            this.referenceColumnNames = Collections.unmodifiableList(r104);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        final String mFrom;
        final int mId;
        final int mSequence;
        final String mTo;

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ForeignKeyWithSequence r100) {
            int r101 = this.mId - r100.mId;
            if (r101 == 0) goto L5;
            return r101;
        L5:
            return this.mSequence - r100.mSequence;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ForeignKeyWithSequence r100) {
            return compareTo2(r100);
        }

        public ForeignKeyWithSequence(int r100, int r101, String r102, String r103) {
            this.mId = r100;
            this.mSequence = r101;
            this.mFrom = r102;
            this.mTo = r103;
        }
    }

    public static final class Index {
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public final List<String> orders;
        public final boolean unique;

        public int hashCode() {
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L5;
            int r100 = -1184239155;
        L7:
            return (((((r100 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        L5:
            r100 = this.name.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + '}';
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Index) == true) goto L8;
            return false;
        L8:
            Index r101 = (Index) r100;
            if (this.unique == r101.unique) goto L12;
            return false;
        L12:
            if (this.columns.equals(r101.columns) == true) goto L15;
            return false;
        L15:
            if (this.orders.equals(r101.orders) == true) goto L18;
            return false;
        L18:
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L22;
            return r101.name.startsWith(DEFAULT_PREFIX);
        L22:
            return this.name.equals(r101.name);
        }

        public Index(String r100, boolean r101, List<String> r102) {
            this(r100, r101, r102, null);
        }

        public Index(String r100, boolean r101, List<String> r102, List<String> r103) {
            this.name = r100;
            this.unique = r101;
            this.columns = r102;
            if (r103 != null) goto L5;
        L6:
            r103 = Collections.nCopies(r102.size(), androidx.room.Index.Order.ASC.name());
        L7:
            this.orders = r103;
            return;
        L5:
            if (r103.size() != 0) goto L7;
            goto L6
        }
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Column> r104 = this.columns;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Set<ForeignKey> r107 = this.foreignKeys;
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
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    private static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor r110) {
        int r100 = r110.getColumnIndex("id");
        int r101 = r110.getColumnIndex(OnekeyLoginConstants.CU_KEY_SEQ);
        int r102 = r110.getColumnIndex("from");
        int r103 = r110.getColumnIndex(RemoteMessageConst.TO);
        int r104 = r110.getCount();
        ArrayList r105 = new ArrayList();
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L5;
        r110.moveToPosition(r106);
        r105.add(new ForeignKeyWithSequence(r110.getInt(r100), r110.getInt(r101), r110.getString(r102), r110.getString(r103)));
        r106 = r106 + 1;
        goto L3
    L5:
        Collections.sort(r105);
        return r105;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TableInfo) == true) goto L8;
        return false;
    L8:
        TableInfo r101 = (TableInfo) r100;
        String r102 = this.name;
        if (r102 == null) goto L14;
        if (r102.equals(r101.name) == false) goto L15;
    L16:
        Map<String, Column> r103 = this.columns;
        if (r103 == null) goto L22;
        if (r103.equals(r101.columns) == false) goto L23;
    L24:
        Set<ForeignKey> r104 = this.foreignKeys;
        if (r104 == null) goto L30;
        if (r104.equals(r101.foreignKeys) == false) goto L31;
    L32:
        Set<Index> r105 = this.indices;
        if (r105 == null) goto L39;
        Set<Index> r106 = r101.indices;
        if (r106 == null) goto L39;
        return r105.equals(r106);
    L39:
        return true;
    L31:
        return false;
    L30:
        if (r101.foreignKeys == null) goto L32;
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

    public static TableInfo read(SupportSQLiteDatabase r100, String r101) {
        return new TableInfo(r101, readColumns(r100, r101), readForeignKeys(r100, r101), readIndices(r100, r101));
    }

    private static Map<String, Column> readColumns(SupportSQLiteDatabase r110, String r111) {
        Cursor r112 = r110.query("PRAGMA table_info(`" + r111 + "`)");
        HashMap r113 = new HashMap();
    L16:
        th = move-exception;
        r112.close();
        throw th;
    L4:
        if (r112.getColumnCount() <= 0) goto L14;
        int r100 = r112.getColumnIndex("name");     // Catch: Throwable -> L16
        int r101 = r112.getColumnIndex("type");     // Catch: Throwable -> L16
        int r102 = r112.getColumnIndex("notnull");     // Catch: Throwable -> L16
        int r103 = r112.getColumnIndex(PbRequest.SwitchType.PK);     // Catch: Throwable -> L16
        int r104 = r112.getColumnIndex("dflt_value");     // Catch: Throwable -> L16
    L7:
        if (r112.moveToNext() == false) goto L14;
        String r105 = r112.getString(r100);     // Catch: Throwable -> L16
        String r106 = r112.getString(r101);     // Catch: Throwable -> L16
        if (r112.getInt(r102) == 0) goto L11;
        boolean r107 = true;
    L12:
        r113.put(r105, new Column(r105, r106, r107, r112.getInt(r103), r112.getString(r104), 2));     // Catch: Throwable -> L16
        goto L7
    L11:
        r107 = false;
    L14:
        r112.close();
        return r113;
    }

    private static Set<ForeignKey> readForeignKeys(SupportSQLiteDatabase r110, String r111) {
        HashSet r100 = new HashSet();
        Cursor r101 = r110.query("PRAGMA foreign_key_list(`" + r111 + "`)");
        int r102 = r101.getColumnIndex("id");     // Catch: Throwable -> L18
        int r103 = r101.getColumnIndex(OnekeyLoginConstants.CU_KEY_SEQ);     // Catch: Throwable -> L18
        int r104 = r101.getColumnIndex(CopyContentTypeString.TABLE);     // Catch: Throwable -> L18
        int r105 = r101.getColumnIndex("on_delete");     // Catch: Throwable -> L18
        int r106 = r101.getColumnIndex("on_update");     // Catch: Throwable -> L18
        List<ForeignKeyWithSequence> r107 = readForeignKeyFieldMappings(r101);     // Catch: Throwable -> L18
        int r108 = r101.getCount();     // Catch: Throwable -> L18
        int r109 = 0;
    L4:
        if (r109 >= r108) goto L16;
        r101.moveToPosition(r109);     // Catch: Throwable -> L18
        if (r101.getInt(r103) != 0) goto L15;
        int r112 = r101.getInt(r102);     // Catch: Throwable -> L18
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L18
        ArrayList r114 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<ForeignKeyWithSequence> r115 = r107.iterator();     // Catch: Throwable -> L18
    L10:
        if (r115.hasNext() == false) goto L14;
        ForeignKeyWithSequence r116 = r115.next();     // Catch: Throwable -> L18
        if (r116.mId != r112) goto L10;
        r113.add(r116.mFrom);     // Catch: Throwable -> L18
        r114.add(r116.mTo);     // Catch: Throwable -> L18
        goto L10
    L14:
        r100.add(new ForeignKey(r101.getString(r104), r101.getString(r105), r101.getString(r106), r113, r114));     // Catch: Throwable -> L18
    L15:
        r109 = r109 + 1;
        goto L4
    L16:
        r101.close();
        return r100;
    L18:
        th = move-exception;
        r101.close();
        throw th;
    }

    private static Set<Index> readIndices(SupportSQLiteDatabase r100, String r101) {
        Cursor r102 = r100.query("PRAGMA index_list(`" + r101 + "`)");
        int r103 = r102.getColumnIndex("name");     // Catch: Throwable -> L28
        int r104 = r102.getColumnIndex(PlayerResolution.SDKKEY.ORIGIN);     // Catch: Throwable -> L28
        int r105 = r102.getColumnIndex("unique");     // Catch: Throwable -> L28
        if (r103 == (-1)) goto L26;
        if (r104 == (-1)) goto L26;
        if (r105 == (-1)) goto L26;
        HashSet r106 = new HashSet();     // Catch: Throwable -> L28
    L10:
        if (r102.moveToNext() == false) goto L24;
        if ("c".equals(r102.getString(r104)) == false) goto L10;
        String r107 = r102.getString(r103);     // Catch: Throwable -> L28
        boolean r108 = true;
        if (r102.getInt(r105) == 1) goto L18;
        r108 = false;
    L18:
        Index r109 = readIndex(r100, r107, r108);     // Catch: Throwable -> L28
        if (r109 == null) goto L20;
        r106.add(r109);     // Catch: Throwable -> L28
        goto L10
    L20:
        r102.close();
        return null;
    L24:
        r102.close();
        return r106;
    L26:
        r102.close();
        return null;
    L28:
        th = move-exception;
        r102.close();
        throw th;
    }

    public TableInfo(String r100, Map<String, Column> r101, Set<ForeignKey> r102) {
        this(r100, r101, r102, Collections.emptySet());
    }

    private static Index readIndex(SupportSQLiteDatabase r110, String r111, boolean r112) {
        Cursor r113 = r110.query("PRAGMA index_xinfo(`" + r111 + "`)");
        int r100 = r113.getColumnIndex("seqno");     // Catch: Throwable -> L25
        int r101 = r113.getColumnIndex("cid");     // Catch: Throwable -> L25
        int r102 = r113.getColumnIndex("name");     // Catch: Throwable -> L25
        int r103 = r113.getColumnIndex(SocialConstants.PARAM_APP_DESC);     // Catch: Throwable -> L25
        if (r100 == (-1)) goto L23;
        if (r101 == (-1)) goto L23;
        if (r102 == (-1)) goto L23;
        if (r103 == (-1)) goto L23;
        TreeMap r104 = new TreeMap();     // Catch: Throwable -> L25
        TreeMap r105 = new TreeMap();     // Catch: Throwable -> L25
    L11:
        if (r113.moveToNext() == false) goto L20;
        if (r113.getInt(r101) < 0) goto L11;
        int r106 = r113.getInt(r100);     // Catch: Throwable -> L25
        String r107 = r113.getString(r102);     // Catch: Throwable -> L25
        if (r113.getInt(r103) <= 0) goto L18;
        String r108 = "DESC";
    L19:
        r104.put(Integer.valueOf(r106), r107);     // Catch: Throwable -> L25
        r105.put(Integer.valueOf(r106), r108);     // Catch: Throwable -> L25
        goto L11
    L18:
        r108 = "ASC";
        goto L19
    L20:
        ArrayList r109 = new ArrayList(r104.size());     // Catch: Throwable -> L25
        r109.addAll(r104.values());     // Catch: Throwable -> L25
        ArrayList r114 = new ArrayList(r105.size());     // Catch: Throwable -> L25
        r114.addAll(r105.values());     // Catch: Throwable -> L25
        Index r115 = new Index(r111, r112, r109, r114);     // Catch: Throwable -> L25
        r113.close();
        return r115;
    L23:
        r113.close();
        return null;
    L25:
        th = move-exception;
        r113.close();
        throw th;
    }

    public TableInfo(String r100, Map<String, Column> r101, Set<ForeignKey> r102, Set<Index> r103) {
        this.name = r100;
        this.columns = Collections.unmodifiableMap(r101);
        this.foreignKeys = Collections.unmodifiableSet(r102);
        if (r103 != null) goto L5;
        Set<Index> r104 = null;
    L6:
        this.indices = r104;
        return;
    L5:
        r104 = Collections.unmodifiableSet(r103);
        goto L6
    }
}
