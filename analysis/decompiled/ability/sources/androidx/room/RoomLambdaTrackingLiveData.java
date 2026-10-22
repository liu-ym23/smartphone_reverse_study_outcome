package androidx.room;

import S7.k;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.util.DBUtil;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BE\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/RoomLambdaTrackingLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomTrackingLiveData;", "Landroidx/room/RoomDatabase;", "database", "Landroidx/room/InvalidationLiveDataContainer;", "container", "", "inTransaction", "", "", "tableNames", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteConnection;", "lambdaFunction", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;Z[Ljava/lang/String;LS7/k;)V", "compute", "(LH7/c;)Ljava/lang/Object;", "LS7/k;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoomLambdaTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final k lambdaFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLambdaTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean z10, String[] tableNames, k lambdaFunction) {
        super(database, container, z10, tableNames, null);
        kotlin.jvm.internal.k.f(database, "database");
        kotlin.jvm.internal.k.f(container, "container");
        kotlin.jvm.internal.k.f(tableNames, "tableNames");
        kotlin.jvm.internal.k.f(lambdaFunction, "lambdaFunction");
        this.lambdaFunction = lambdaFunction;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object compute(H7.c<? super T> cVar) {
        return DBUtil.performSuspending(getDatabase(), true, getInTransaction(), this.lambdaFunction, cVar);
    }
}
