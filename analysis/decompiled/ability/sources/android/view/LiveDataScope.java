package android.view;

import C7.r;
import H7.c;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import m9.InterfaceC1693K;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H¦@¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00018\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/LiveDataScope;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "LC7/r;", "emit", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", AgentBusWakeContract.EXTRA_SOURCE, "Lm9/K;", "emitSource", "(Landroidx/lifecycle/LiveData;LH7/c;)Ljava/lang/Object;", "getLatestValue", "()Ljava/lang/Object;", "latestValue", "lifecycle-livedata_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LiveDataScope<T> {
    Object emit(T t9, c<? super r> cVar);

    Object emitSource(LiveData<T> liveData, c<? super InterfaceC1693K> cVar);

    T getLatestValue();
}
