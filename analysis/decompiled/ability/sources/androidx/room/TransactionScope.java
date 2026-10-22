package androidx.room;

import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J@\u0010\b\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00032(\u0010\u0007\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H¦@¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000H¦@¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/room/TransactionScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/PooledConnection;", "R", "Lkotlin/Function2;", "LH7/c;", "", "block", "withNestedTransaction", "(LS7/n;LH7/c;)Ljava/lang/Object;", "result", "", "rollback", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TransactionScope<T> extends PooledConnection {
    Object rollback(T t9, H7.c<?> cVar);

    <R> Object withNestedTransaction(n nVar, H7.c<? super R> cVar);
}
