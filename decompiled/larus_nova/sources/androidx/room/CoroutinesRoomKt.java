package androidx.room;

import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"transactionDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Landroidx/room/RoomDatabase;", "getTransactionDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "getQueryDispatcher", "reflectGetBackingFieldMap", "", "", "", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CoroutinesRoomKt {
    public static final CoroutineDispatcher getQueryDispatcher(RoomDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, Object> r101 = reflectGetBackingFieldMap(r100);
        Object r102 = r101.get("QueryDispatcher");
        if (r102 != null) goto L5;
        r102 = ExecutorsKt.from(r100.getQueryExecutor());
        r101.put("QueryDispatcher", r102);
    L5:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) r102;
    }

    public static final CoroutineDispatcher getTransactionDispatcher(RoomDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, Object> r101 = reflectGetBackingFieldMap(r100);
        Object r102 = r101.get("TransactionDispatcher");
        if (r102 != null) goto L5;
        r102 = ExecutorsKt.from(r100.getTransactionExecutor());
        r101.put("TransactionDispatcher", r102);
    L5:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) r102;
    }

    public static final Map<String, Object> reflectGetBackingFieldMap(RoomDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Method r101 = RoomDatabase.class.getDeclaredMethod("getBackingFieldMap", new Class[0]);
        r101.setAccessible(true);
        Object r102 = r101.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        return TypeIntrinsics.asMutableMap(r102);
    }
}
