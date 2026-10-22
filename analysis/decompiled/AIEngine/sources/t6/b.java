package t6;

import com.stepos.base.task.data.TaskPriority;
import kotlin.Result;
import kotlinx.coroutines.flow.Flow;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface b {
    void shutdown();

    Flow<Result<Object>> submitFlow(String str, TaskPriority taskPriority, r6.a aVar, l<? super qb.b<? super Flow<? extends Result<? extends Object>>>, ? extends Object> lVar);
}
