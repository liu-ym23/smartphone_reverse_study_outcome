package androidx.room.util;

import C7.r;
import E7.a;
import H4.o;
import J7.c;
import S7.n;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.stepos.ability.task.executor.e;
import j9.t;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aP\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022$\b\u0004\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0080H¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "", "isReadOnly", "inTransaction", "Lkotlin/Function2;", "Landroidx/room/PooledConnection;", "LH7/c;", "", "block", "internalPerform", "(Landroidx/room/RoomDatabase;ZZLS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/sqlite/SQLiteConnection;", "connection", "LC7/r;", "dropFtsSyncTriggers", "(Landroidx/sqlite/SQLiteConnection;)V", "db", "", "tableName", "foreignKeyCheck", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/String;)V", "Landroidx/sqlite/SQLiteStatement;", "stmt", "processForeignKeyCheckFailure$DBUtil__DBUtilKt", "(Landroidx/sqlite/SQLiteStatement;)Ljava/lang/String;", "processForeignKeyCheckFailure", "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/util/DBUtil")
/* loaded from: classes2.dex */
final /* synthetic */ class DBUtil__DBUtilKt {

    @c(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2", f = "DBUtil.kt", l = {56, 57, 59, 60, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "R", "transactor", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: androidx.room.util.DBUtil__DBUtilKt$internalPerform$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ boolean $isReadOnly;
        final /* synthetic */ RoomDatabase $this_internalPerform;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z10, boolean z11, RoomDatabase roomDatabase, n nVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$inTransaction = z10;
            this.$isReadOnly = z11;
            this.$this_internalPerform = roomDatabase;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(Transactor transactor, H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(transactor, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
        
            if (r9.sync$room_runtime(r8) == r0) goto L51;
         */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00a6 A[PHI: r1 r9
          0x00a6: PHI (r1v11 androidx.room.Transactor) = (r1v8 androidx.room.Transactor), (r1v18 androidx.room.Transactor) binds: [B:36:0x00a3, B:14:0x0028] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r9v12 java.lang.Object) = (r9v11 java.lang.Object), (r9v0 java.lang.Object) binds: [B:36:0x00a3, B:14:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c9 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 214
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtilKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invokeSuspend$$forInline(Object obj) throws Throwable {
            Transactor transactor = (Transactor) this.L$0;
            if (!this.$inTransaction) {
                return this.$block.invoke(transactor, this);
            }
            boolean z10 = this.$isReadOnly;
            Transactor.SQLiteTransactionType sQLiteTransactionType = z10 ? Transactor.SQLiteTransactionType.DEFERRED : Transactor.SQLiteTransactionType.IMMEDIATE;
            if (!z10 && !((Boolean) transactor.inTransaction(this)).booleanValue()) {
                this.$this_internalPerform.getInvalidationTracker().sync$room_runtime(this);
            }
            Object objWithTransaction = transactor.withTransaction(sQLiteTransactionType, new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null), this);
            if (!this.$isReadOnly && !((Boolean) transactor.inTransaction(this)).booleanValue()) {
                this.$this_internalPerform.getInvalidationTracker().refreshAsync();
            }
            return objWithTransaction;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SQLiteConnection connection) {
        k.f(connection, "connection");
        ListBuilder listBuilderY = o.y();
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (sQLiteStatementPrepare.step()) {
            try {
                listBuilderY.add(sQLiteStatementPrepare.getText(0));
            } finally {
            }
        }
        e.s(sQLiteStatementPrepare, null);
        ListIterator listIterator = o.q(listBuilderY).listIterator(0);
        while (true) {
            a aVar = (a) listIterator;
            if (!aVar.hasNext()) {
                return;
            }
            String str = (String) aVar.next();
            if (t.e0(str, "room_fts_content_sync_", false)) {
                SQLite.execSQL(connection, "DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(SQLiteConnection db, String tableName) {
        k.f(db, "db");
        k.f(tableName, "tableName");
        SQLiteStatement sQLiteStatementPrepare = db.prepare("PRAGMA foreign_key_check(`" + tableName + "`)");
        try {
            if (sQLiteStatementPrepare.step()) {
                throw new SQLException(processForeignKeyCheckFailure$DBUtil__DBUtilKt(sQLiteStatementPrepare));
            }
            e.s(sQLiteStatementPrepare, null);
        } finally {
        }
    }

    public static final <R> Object internalPerform(RoomDatabase roomDatabase, boolean z10, boolean z11, n nVar, H7.c<? super R> cVar) {
        return roomDatabase.useConnection(z10, new AnonymousClass2(z11, z10, roomDatabase, nVar, null), cVar);
    }

    private static final String processForeignKeyCheckFailure$DBUtil__DBUtilKt(SQLiteStatement sQLiteStatement) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        do {
            if (i == 0) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(sQLiteStatement.getText(0));
                sb.append("'.\n");
            }
            String text = sQLiteStatement.getText(3);
            if (!linkedHashMap.containsKey(text)) {
                linkedHashMap.put(text, sQLiteStatement.getText(2));
            }
            i++;
        } while (sQLiteStatement.step());
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\nNumber of rows in violation: ");
        sb.append(i);
        sb.append("\nViolation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            androidx.constraintlayout.core.dsl.a.A(sb, "\tParent Table = ", (String) entry.getValue(), ", Foreign Key Constraint Index = ", (String) entry.getKey());
            sb.append("\n");
        }
        return sb.toString();
    }
}
