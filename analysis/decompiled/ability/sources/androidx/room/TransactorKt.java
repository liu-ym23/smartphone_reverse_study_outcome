package androidx.room;

import C7.r;
import S7.n;
import androidx.compose.ui.text.d;
import androidx.room.Transactor;
import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001aD\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00072(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001aD\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00072(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0086@¢\u0006\u0004\b\u000f\u0010\u000e\u001aD\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00072(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0086@¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/room/PooledConnection;", "", "sql", "LC7/r;", "execSQL", "(Landroidx/room/PooledConnection;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "R", "Landroidx/room/Transactor;", "Lkotlin/Function2;", "Landroidx/room/TransactionScope;", "LH7/c;", "", "block", "deferredTransaction", "(Landroidx/room/Transactor;LS7/n;LH7/c;)Ljava/lang/Object;", "immediateTransaction", "exclusiveTransaction", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransactorKt {
    public static final <R> Object deferredTransaction(Transactor transactor, n nVar, H7.c<? super R> cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.DEFERRED, nVar, cVar);
    }

    public static final <R> Object exclusiveTransaction(Transactor transactor, n nVar, H7.c<? super R> cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.EXCLUSIVE, nVar, cVar);
    }

    public static final Object execSQL(PooledConnection pooledConnection, String str, H7.c<? super r> cVar) {
        Object objUsePrepared = pooledConnection.usePrepared(str, new d(9), cVar);
        return objUsePrepared == CoroutineSingletons.f4909a ? objUsePrepared : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean execSQL$lambda$0(SQLiteStatement it) {
        k.f(it, "it");
        return it.step();
    }

    public static final <R> Object immediateTransaction(Transactor transactor, n nVar, H7.c<? super R> cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.IMMEDIATE, nVar, cVar);
    }
}
