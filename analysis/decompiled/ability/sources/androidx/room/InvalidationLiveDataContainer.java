package androidx.room;

import android.view.LiveData;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011¢\u0006\u0004\b\u000f\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0019\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR$\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/room/InvalidationLiveDataContainer;", "", "Landroidx/room/RoomDatabase;", "database", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "", "tableNames", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callableFunction", "Landroidx/lifecycle/LiveData;", "create", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteConnection;", "lambdaFunction", "([Ljava/lang/String;ZLS7/k;)Landroidx/lifecycle/LiveData;", "liveData", "LC7/r;", "onActive", "(Landroidx/lifecycle/LiveData;)V", "onInactive", "Landroidx/room/RoomDatabase;", "", "liveDataSet", "Ljava/util/Set;", "getLiveDataSet$room_runtime", "()Ljava/util/Set;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InvalidationLiveDataContainer {
    private final RoomDatabase database;
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase database) {
        k.f(database, "database");
        this.database = database;
        Set<LiveData<?>> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        k.e(setNewSetFromMap, "newSetFromMap(...)");
        this.liveDataSet = setNewSetFromMap;
    }

    public final <T> LiveData<T> create(String[] tableNames, boolean inTransaction, Callable<T> callableFunction) {
        k.f(tableNames, "tableNames");
        k.f(callableFunction, "callableFunction");
        return new RoomCallableTrackingLiveData(this.database, this, inTransaction, tableNames, callableFunction);
    }

    public final Set<LiveData<?>> getLiveDataSet$room_runtime() {
        return this.liveDataSet;
    }

    public final void onActive(LiveData<?> liveData) {
        k.f(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(LiveData<?> liveData) {
        k.f(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }

    public final <T> LiveData<T> create(String[] tableNames, boolean inTransaction, S7.k lambdaFunction) {
        k.f(tableNames, "tableNames");
        k.f(lambdaFunction, "lambdaFunction");
        return new RoomLambdaTrackingLiveData(this.database, this, inTransaction, tableNames, lambdaFunction);
    }
}
