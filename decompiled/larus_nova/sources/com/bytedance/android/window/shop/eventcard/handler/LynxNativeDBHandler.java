package com.bytedance.android.window.shop.eventcard.handler;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import com.bytedance.android.ec.window.base.db.WindowDatabase;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ho.m;
import ho.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class LynxNativeDBHandler implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f187792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f187793b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxNativeDBHandler f187794c = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/handler/LynxNativeDBHandler$LynxDBOperation;", "", "", WikiFolderPushPlugin.OPT, "Ljava/lang/String;", "getOperation", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "INSERT", "REMOVE", "UPDATE", ConfirmNextAction.ACTION_TYPE_QUERY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LynxDBOperation extends Enum<LynxDBOperation> {
        public static final a Companion = null;
        public static final LynxDBOperation INSERT = null;
        public static final LynxDBOperation QUERY = null;
        public static final LynxDBOperation REMOVE = null;
        public static final LynxDBOperation UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxDBOperation[] f187795a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, LynxDBOperation> f187796b = null;
        private final String operation;

        public static final class a {
            public a() {
            }
        }

        static {
            int r100 = 0;
            LynxDBOperation r101 = new LynxDBOperation("INSERT", 0, "insert");
            INSERT = r101;
            LynxDBOperation r102 = new LynxDBOperation("REMOVE", 1, "remove");
            REMOVE = r102;
            LynxDBOperation r103 = new LynxDBOperation("UPDATE", 2, "update");
            UPDATE = r103;
            LynxDBOperation r104 = new LynxDBOperation(ConfirmNextAction.ACTION_TYPE_QUERY, 3, "query");
            QUERY = r104;
            f187795a = new LynxDBOperation[]{r101, r102, r103, r104};
            Companion = new a();
            LynxDBOperation[] r105 = values();
            LinkedHashMap r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r105.length), 16));
            int r107 = r105.length;
        L3:
            if (r100 >= r107) goto L5;
            LynxDBOperation r108 = r105[r100];
            r106.put(r108.operation, r108);
            r100 = r100 + 1;
            goto L3
        L5:
            f187796b = r106;
        }

        public static LynxDBOperation valueOf(String r100) {
            return (LynxDBOperation) r27.a.a(LynxDBOperation.class, r100);
        }

        public static LynxDBOperation[] values() {
            return (LynxDBOperation[]) f187795a.clone();
        }

        public static final /* synthetic */ Map access$getMapping$cp() {
            return f187796b;
        }

        public final String getOperation() {
            return this.operation;
        }

        public LynxDBOperation(String r100, int r101, String r102) {
            super(r100, r101);
            this.operation = r102;
        }
    }

    public LynxNativeDBHandler() {
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    static {
        f187794c = new LynxNativeDBHandler();
        f187792a = MapsKt.mapOf(TuplesKt.to("success", Boolean.FALSE));
        f187793b = MapsKt.mapOf(TuplesKt.to("success", Boolean.TRUE));
    }

    public static Map b(Map r100) {
        Object r101 = r100.get("entity");
        if ((r101 instanceof Map) == true) goto L5;
        r101 = null;
    L5:
        Map r102 = (Map) r101;
        if (r102 != null) goto L10;
        return MapsKt.emptyMap();
    L10:
        if (r102.isEmpty() == true) goto L18;
        Iterator r103 = r102.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        boolean r104 = true;
        if ((!(((Map.Entry) r103.next()).getKey() instanceof String)) == false) goto L14;
    L19:
        if (r104 == true) goto L21;
        return r102;
    L21:
        return MapsKt.emptyMap();
    L18:
        r104 = false;
        goto L19
    }

    private final Map<String, Object> insert(Map<String, ? extends Object> r100) {
        Map r101 = b(r100);
        io.e.f490663m.getClass();
        Intrinsics.checkNotNullParameter(r101, "map");
        if (io.e.a.a(r101, io.e.f490659i) == false) goto L5;
        io.e r102 = io.e.a.b(r101);
        WindowDatabase r103 = go.a.f481867b.a();
        if (r103 == null) goto L17;
        m r104 = r103.g();
        if (r104 == null) goto L17;
        n r105 = (n) r104;
        r105.f486196a.assertNotSuspendingTransaction();
        r105.f486196a.beginTransaction();
        r105.f486197b.insertAndReturnId(r102);     // Catch: Throwable -> L13
        r105.f486196a.setTransactionSuccessful();     // Catch: Throwable -> L13
        r105.f486196a.endTransaction();
    L13:
        th = move-exception;
        r105.f486196a.endTransaction();
        throw th;
    L17:
        return MapsKt.emptyMap();
    L5:
        return f187792a;
    }

    private final Map<String, Object> query(Map<String, ? extends Object> r310) {
        Map r100 = b(r310);
        io.e.f490663m.getClass();
        Intrinsics.checkNotNullParameter(r100, "map");
        if (io.e.a.a(r100, io.e.f490662l) == false) goto L5;
        io.e r101 = io.e.a.b(r100);
        WindowDatabase r102 = go.a.f481867b.a();
        if (r102 == null) goto L36;
        m r103 = r102.g();
        if (r103 == null) goto L36;
        String r110 = r101.f490664a;
        String r111 = r101.f490665b;
        String r104 = r101.f490666c;
        n r105 = (n) r103;
        RoomSQLiteQuery r112 = RoomSQLiteQuery.acquire("SELECT * FROM window_lynx_common WHERE user_id = ? and scene_id = ? and business = ? limit 1", 3);
        if (r110 != null) goto L13;
        r112.bindNull(1);
    L15:
        if (r111 != null) goto L17;
        r112.bindNull(2);
    L18:
        if (r104 != null) goto L20;
        r112.bindNull(3);
    L21:
        r105.f486196a.assertNotSuspendingTransaction();
        Cursor r106 = DBUtil.query(r105.f486196a, r112, false);
        int r113 = CursorUtil.getColumnIndexOrThrow(r106, "user_id");     // Catch: Throwable -> L32
        int r114 = CursorUtil.getColumnIndexOrThrow(r106, "scene_id");     // Catch: Throwable -> L32
        int r115 = CursorUtil.getColumnIndexOrThrow(r106, "business");     // Catch: Throwable -> L32
        int r116 = CursorUtil.getColumnIndexOrThrow(r106, "count");     // Catch: Throwable -> L32
        int r117 = CursorUtil.getColumnIndexOrThrow(r106, "timestamp");     // Catch: Throwable -> L32
        int r107 = CursorUtil.getColumnIndexOrThrow(r106, "data");     // Catch: Throwable -> L32
        int r108 = CursorUtil.getColumnIndexOrThrow(r106, "reserved_string");     // Catch: Throwable -> L32
        int r109 = CursorUtil.getColumnIndexOrThrow(r106, "reserved_long");     // Catch: Throwable -> L32
        if (r106.moveToFirst() == false) goto L26;
        io.e r118 = new io.e(r106.getString(r113), r106.getString(r114), r106.getString(r115), r106.getInt(r116), r106.getLong(r117), r106.getString(r107), r106.getString(r108), r106.getLong(r109));     // Catch: Throwable -> L32
    L27:
        r106.close();
        r112.release();
        if (r118 == null) goto L36;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("user_id", r118.f490664a), TuplesKt.to("scene_id", r118.f490665b), TuplesKt.to("business", r118.f490666c), TuplesKt.to("count", Integer.valueOf(r118.f490667d)), TuplesKt.to("timestamp", Long.valueOf(r118.f490668e)), TuplesKt.to("data", r118.f490669f), TuplesKt.to("reserved_string", r118.f490670g), TuplesKt.to("reserved_long", Long.valueOf(r118.f490671h))});
    L26:
        r118 = null;
    L32:
        th = move-exception;
        r106.close();
        r112.release();
        throw th;
    L20:
        r112.bindString(3, r104);
        goto L21
    L17:
        r112.bindString(2, r111);
        goto L18
    L13:
        r112.bindString(1, r110);
    L36:
        return f187792a;
    L5:
        return f187792a;
    }

    private final Map<String, Object> update(Map<String, ? extends Object> r100) {
        Map r101 = b(r100);
        io.e.f490663m.getClass();
        Intrinsics.checkNotNullParameter(r101, "map");
        if (io.e.a.a(r101, io.e.f490661k) == false) goto L5;
        io.e r102 = io.e.a.b(r101);
        WindowDatabase r103 = go.a.f481867b.a();
        if (r103 == null) goto L17;
        m r104 = r103.g();
        if (r104 == null) goto L17;
        n r105 = (n) r104;
        r105.f486196a.assertNotSuspendingTransaction();
        r105.f486196a.beginTransaction();
        r105.f486199d.handle(r102);     // Catch: Throwable -> L13
        r105.f486196a.setTransactionSuccessful();     // Catch: Throwable -> L13
        r105.f486196a.endTransaction();
    L13:
        th = move-exception;
        r105.f486196a.endTransaction();
        throw th;
    L17:
        return f187793b;
    L5:
        return f187792a;
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        LynxDBOperation.a r102 = LynxDBOperation.Companion;
        Object r103 = r101.get(WikiFolderPushPlugin.OPT);
        LynxDBOperation r104 = null;
        if ((r103 instanceof String) == true) goto L5;
        r103 = null;
    L5:
        String r105 = (String) r103;
        r102.getClass();
        if (r105 == null) goto L9;
        r104 = (LynxDBOperation) LynxDBOperation.access$getMapping$cp().get(r105);
    L9:
        if (r104 == null) goto L11;
        int r106 = d.f187805a[r104.ordinal()];
        if (r106 == 1) goto L39;
        if (r106 != 2) goto L17;
        Map r107 = b(r101);
        io.e.f490663m.getClass();
        Intrinsics.checkNotNullParameter(r107, "map");
        if (io.e.a.a(r107, io.e.f490660j) == false) goto L44;
        io.e r108 = io.e.a.b(r107);
        WindowDatabase r109 = go.a.f481867b.a();
        if (r109 == null) goto L45;
        m r110 = r109.g();
        if (r110 == null) goto L45;
        n r111 = (n) r110;
        r111.f486196a.assertNotSuspendingTransaction();
        r111.f486196a.beginTransaction();
        r111.f486198c.handle(r108);     // Catch: Throwable -> L34
        r111.f486196a.setTransactionSuccessful();     // Catch: Throwable -> L34
        r111.f486196a.endTransaction();
    L34:
        th = move-exception;
        r111.f486196a.endTransaction();
        throw th;
    L45:
        return f187793b;
    L44:
        return f187792a;
    L17:
        if (r106 == 3) goto L43;
        if (r106 != 4) goto L22;
        return query(r101);
    L22:
        throw new NoWhenBranchMatchedException();
    L43:
        return update(r101);
    L39:
        return insert(r101);
    L11:
        return MapsKt.emptyMap();
    }
}
