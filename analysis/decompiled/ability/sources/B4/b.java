package B4;

import com.stepos.ability.api.task.registry.ITaskRegistry;
import com.stepos.ability.bean.InternalTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b implements ITaskRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f191a = new ConcurrentHashMap();

    @Override // com.stepos.ability.api.task.registry.ITaskRegistry
    public final InternalTask get(String taskId) {
        k.f(taskId, "taskId");
        a aVar = (a) this.f191a.get(taskId);
        if (aVar != null) {
            return aVar.f190a;
        }
        return null;
    }

    @Override // com.stepos.ability.api.task.registry.ITaskRegistry
    public final Integer getCallingUid(String taskId) {
        k.f(taskId, "taskId");
        a aVar = (a) this.f191a.get(taskId);
        if (aVar != null) {
            return Integer.valueOf(aVar.b);
        }
        return null;
    }

    @Override // com.stepos.ability.api.task.registry.ITaskRegistry
    public final Integer getStatus(String taskId) {
        AtomicInteger atomicInteger;
        k.f(taskId, "taskId");
        a aVar = (a) this.f191a.get(taskId);
        if (aVar == null || (atomicInteger = aVar.c) == null) {
            return null;
        }
        return Integer.valueOf(atomicInteger.get());
    }

    @Override // com.stepos.ability.api.task.registry.ITaskRegistry
    public final void register(InternalTask internalTask, int i) {
        k.f(internalTask, "internalTask");
        String taskId = internalTask.getTask().getTaskId();
        a aVar = new a(internalTask, i, new AtomicInteger(internalTask.getTask().getStatus()));
        ConcurrentHashMap concurrentHashMap = this.f191a;
        concurrentHashMap.put(taskId, aVar);
        int size = concurrentHashMap.size();
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "register: taskId=", taskId, ", uid=", ", total=");
        sbT.append(size);
        String msg = sbT.toString();
        k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskRegistry"), msg, null);
    }

    @Override // com.stepos.ability.api.task.registry.ITaskRegistry
    public final void unregister(String taskId) {
        k.f(taskId, "taskId");
        ConcurrentHashMap concurrentHashMap = this.f191a;
        if (((a) concurrentHashMap.remove(taskId)) != null) {
            String msg = "unregister: taskId=" + taskId + ", remaining=" + concurrentHashMap.size();
            k.f(msg, "msg");
            P3.c.f1086a.invoke(3, "Ability_".concat("TaskRegistry"), msg, null);
        }
    }

    @Override // com.stepos.ability.api.task.registry.ITaskRegistry
    public final void updateStatus(String taskId, int i) {
        AtomicInteger atomicInteger;
        k.f(taskId, "taskId");
        a aVar = (a) this.f191a.get(taskId);
        if (aVar == null || (atomicInteger = aVar.c) == null) {
            return;
        }
        atomicInteger.set(i);
    }
}
