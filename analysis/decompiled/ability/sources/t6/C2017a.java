package t6;

import androidx.sqlite.SQLiteConnection;
import com.stepos.taskrobot.taskmemory.dao.TaskDao_Impl;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;

/* renamed from: t6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2017a implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6660a;
    public final /* synthetic */ TaskDao_Impl b;
    public final /* synthetic */ TaskEntity c;

    public /* synthetic */ C2017a(TaskDao_Impl taskDao_Impl, TaskEntity taskEntity, int i) {
        this.f6660a = i;
        this.b = taskDao_Impl;
        this.c = taskEntity;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6660a) {
            case 0:
                return Long.valueOf(TaskDao_Impl.insert$lambda$0(this.b, this.c, (SQLiteConnection) obj));
            case 1:
                return TaskDao_Impl.update$lambda$0(this.b, this.c, (SQLiteConnection) obj);
            default:
                return TaskDao_Impl.delete$lambda$0(this.b, this.c, (SQLiteConnection) obj);
        }
    }
}
