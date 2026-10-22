package bl7;

import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.ActionTaskManager$executeCallback$1;
import com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.NormalTimerTaskExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tk7.a f19498a;

    public a() {
    }

    public void a(tk7.a r100) {
    }

    public abstract String d();

    public abstract boolean e();

    public abstract void f();

    public abstract void h();

    public boolean i() {
        return this instanceof NormalTimerTaskExecutor;
    }

    public void j() {
    }

    public final tk7.a c() {
        tk7.a r100 = this.f19498a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selfActionModel");
    L5:
        return r100;
    }

    public void g(tk7.a r100) {
        this.f19498a = r100;
    }

    public void b(tk7.a r100, ActionTaskManager$executeCallback$1 r101) {
        this.f19498a = r100;
    }
}
