package t6;

import androidx.sqlite.SQLiteConnection;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6667a;
    public final /* synthetic */ TaskStepDao_Impl b;
    public final /* synthetic */ List c;

    public /* synthetic */ j(TaskStepDao_Impl taskStepDao_Impl, List list, int i) {
        this.f6667a = i;
        this.b = taskStepDao_Impl;
        this.c = list;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6667a) {
            case 0:
                return TaskStepDao_Impl.insertList$lambda$0(this.b, this.c, (SQLiteConnection) obj);
            default:
                return TaskStepDao_Impl.updateMultipleDurationData$lambda$0(this.b, this.c, (SQLiteConnection) obj);
        }
    }
}
