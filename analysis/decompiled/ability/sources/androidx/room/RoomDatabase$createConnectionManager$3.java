package androidx.room;

import S7.k;
import S7.n;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class RoomDatabase$createConnectionManager$3 extends FunctionReferenceImpl implements n {
    public RoomDatabase$createConnectionManager$3(Object obj) {
        super(2, obj, RoomDatabaseKt__RoomDatabase_androidKt.class, "compatTransactionCoroutineExecute", "compatTransactionCoroutineExecute(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
    }

    @Override // S7.n
    public final Object invoke(k kVar, H7.c<Object> cVar) {
        return RoomDatabaseKt.compatTransactionCoroutineExecute((RoomDatabase) this.receiver, kVar, cVar);
    }
}
