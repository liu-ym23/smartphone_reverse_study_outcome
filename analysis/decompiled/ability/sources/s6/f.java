package s6;

import D7.o;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import l3.InterfaceC1661e;
import n5.C1741a;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f5991a = new f();
    public static final C7.f b = kotlin.a.a(new C1741a(5));
    public static final InterfaceC1661e c;
    public static final ConcurrentHashMap d;
    public static final ConcurrentHashMap e;
    public static final ConcurrentHashMap f;

    static {
        com.google.common.cache.a aVarE = com.google.common.cache.a.e();
        aVarE.d(200L);
        aVarE.c(30L, TimeUnit.MINUTES);
        c = aVarE.a(new e());
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
    }

    public static void a(String str, TaskStepEntity taskStepEntity) {
        if (str == null || taskStepEntity == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = d;
        synchronized (concurrentHashMap) {
            TaskStepEntity[] taskStepEntityArr = (TaskStepEntity[]) concurrentHashMap.get(str);
            ArrayList arrayList = taskStepEntityArr != null ? new ArrayList(new o(taskStepEntityArr, false)) : new ArrayList();
            arrayList.add(taskStepEntity);
            concurrentHashMap.put(str, arrayList.toArray(new TaskStepEntity[0]));
        }
    }

    public static final f b() {
        return (f) b.getF4884a();
    }

    public static TaskStepEntity c(String str) {
        TaskStepEntity[] taskStepEntityArr = (TaskStepEntity[]) d.get(str);
        if (taskStepEntityArr == null || taskStepEntityArr.length == 0) {
            return null;
        }
        return taskStepEntityArr[taskStepEntityArr.length - 1];
    }
}
