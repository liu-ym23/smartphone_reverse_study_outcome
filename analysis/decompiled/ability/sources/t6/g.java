package t6;

import androidx.sqlite.SQLiteConnection;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6664a;
    public final /* synthetic */ TaskStepDao_Impl b;
    public final /* synthetic */ TaskStepEntity c;

    public /* synthetic */ g(TaskStepDao_Impl taskStepDao_Impl, TaskStepEntity taskStepEntity, int i) {
        this.f6664a = i;
        this.b = taskStepDao_Impl;
        this.c = taskStepEntity;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6664a) {
            case 0:
                return Integer.valueOf(TaskStepDao_Impl.update$lambda$0(this.b, this.c, (SQLiteConnection) obj));
            case 1:
                return TaskStepDao_Impl.delete$lambda$0(this.b, this.c, (SQLiteConnection) obj);
            default:
                return Long.valueOf(TaskStepDao_Impl.insert$lambda$0(this.b, this.c, (SQLiteConnection) obj));
        }
    }
}
