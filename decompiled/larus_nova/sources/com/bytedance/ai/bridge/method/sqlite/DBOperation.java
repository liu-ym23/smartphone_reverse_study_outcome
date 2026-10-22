package com.bytedance.ai.bridge.method.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Base64;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
public final class DBOperation {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f35882f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f35883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f35884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f35885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f35887e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/sqlite/DBOperation$QueryType;", "", "operationType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOperationType", "()Ljava/lang/String;", "UPDATE", "INSERT", "DELETE", "SELECT", FlowDoraWifiScene.OTHER, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum QueryType extends Enum<QueryType> {
        public static final QueryType DELETE = null;
        public static final QueryType INSERT = null;
        public static final QueryType OTHER = null;
        public static final QueryType SELECT = null;
        public static final QueryType UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ QueryType[] f35888a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f35889b = null;
        private final String operationType;

        public static EnumEntries<QueryType> getEntries() {
            return f35889b;
        }

        static {
            QueryType r100 = new QueryType("UPDATE", 0, "update");
            UPDATE = r100;
            QueryType r101 = new QueryType("INSERT", 1, "insert");
            INSERT = r101;
            QueryType r102 = new QueryType("DELETE", 2, "delete");
            DELETE = r102;
            QueryType r103 = new QueryType("SELECT", 3, "select");
            SELECT = r103;
            QueryType r104 = new QueryType(FlowDoraWifiScene.OTHER, 4, "other");
            OTHER = r104;
            QueryType[] r105 = {r100, r101, r102, r103, r104};
            f35888a = r105;
            f35889b = EnumEntriesKt.enumEntries(r105);
        }

        public static QueryType[] values() {
            return (QueryType[]) f35888a.clone();
        }

        public final String getOperationType() {
            return this.operationType;
        }

        public static QueryType valueOf(String r100) {
            return (QueryType) r27.a.a(QueryType.class, r100);
        }

        public QueryType(String r100, int r101, String r102) {
            super(r100, r101);
            this.operationType = r102;
        }
    }

    public static final class a {
    }

    static {
        f35882f = PatternProtector.compile("^\\s*(\\S+)", 2);
    }

    public static QueryType c(String r100) {
        Matcher r101 = f35882f.matcher(r100);
        if (r101.find() == true) goto L16;
        com.bytedance.ai.utils.g.f37637a.w("ExecuteSqliteActionMethod", "unsupported query type");
        return QueryType.OTHER;
    L16:
        String r102 = r101.group().toLowerCase();     // Catch: IllegalArgumentException -> L12
        QueryType[] r103 = QueryType.values();     // Catch: IllegalArgumentException -> L12
        int r104 = r103.length;     // Catch: IllegalArgumentException -> L12
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L11;
        QueryType r106 = r103[r105];     // Catch: IllegalArgumentException -> L12
        if (Intrinsics.areEqual(r106.getOperationType(), r102) == true) goto L8;
        r105 = r105 + 1;     // Catch: IllegalArgumentException -> L12
        goto L5
    L8:
        return r106;
    L11:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: IllegalArgumentException -> L12
    L12:
        com.bytedance.ai.utils.g.f37637a.w("ExecuteSqliteActionMethod", "unsupported query type");
        return QueryType.OTHER;
    }

    public DBOperation(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dbName");
        this.f35883a = r100;
        this.f35884b = r101;
        this.f35887e = LazyKt.lazy(new d());
    }

    public static void a(SQLiteStatement r100, ArrayList r101) {
        Iterator r102 = r101.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L24;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if ((r104 instanceof Integer) == false) goto L12;
        r100.bindLong(r105, ((Number) r104).intValue());
    L23:
        r103 = r105;
        goto L4
    L12:
        if ((r104 instanceof Long) == false) goto L15;
        r100.bindLong(r105, ((Number) r104).longValue());
        goto L23
    L15:
        if ((r104 instanceof Double) == false) goto L18;
        r100.bindDouble(r105, ((Number) r104).doubleValue());
        goto L23
    L18:
        if ((r104 instanceof String) == false) goto L23;
        if (Intrinsics.areEqual(((String) r104).toUpperCase(), "NULL") == false) goto L22;
        r100.bindNull(r105);
        goto L23
    L22:
        r100.bindString(r105, d(r104, ""));
        goto L23
    }

    public static String d(Object r100, String r101) {
        if ((r100 instanceof String) == false) goto L6;
        return (String) r100;
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        return String.valueOf(((Number) r100).intValue());
    L9:
        if ((r100 instanceof Long) == false) goto L12;
        return String.valueOf(((Number) r100).longValue());
    L12:
        if ((r100 instanceof Boolean) == true) goto L14;
        return r101;
    L14:
        return String.valueOf(((Boolean) r100).booleanValue());
    }

    public final void e(f3.h<AbsExecuteSqliteActionMethodIDL.b> r100, Function1<? super SQLiteDatabase, Unit> r101) {
        BuildersKt.launch$default((CoroutineScope) this.f35887e.getValue(), null, null, new DBOperation$safeRun$1(this, r101, r100, null), 3, null);
    }

    public static void b(Map r100, String r101, Cursor r102, int r103) {
        int r104 = r102.getType(r103);
        Long r105 = null;
        byte[] r106 = null;
        String r107 = null;
        Double r108 = null;
        if (r104 != 0) goto L5;
        r100.put(r101, null);
        return;
    L5:
        if (r104 == 1) goto L34;
        if (r104 == 2) goto L29;
        if (r104 == 3) goto L24;
        if (r104 == 4) goto L14;
        return;
    L14:
        if (r102.isNull(r103) == true) goto L17;
        r106 = r102.getBlob(r103);
    L17:
        if (r106 == null) goto L21;
        byte[] r109 = Base64.encode(r106, 0);
        Object r110 = r109;
        if (r109 == null) goto L21;
    L22:
        r100.put(r101, r110);
        return;
    L21:
        r110 = "";
        goto L22
    L24:
        if (r102.isNull(r103) == true) goto L27;
        r107 = r102.getString(r103);
    L27:
        r100.put(r101, r107);
        return;
    L29:
        if (r102.isNull(r103) == true) goto L32;
        r108 = Double.valueOf(r102.getDouble(r103));
    L32:
        r100.put(r101, r108);
        return;
    L34:
        if (r102.isNull(r103) == true) goto L37;
        r105 = Long.valueOf(r102.getLong(r103));
    L37:
        r100.put(r101, r105);
    }
}
