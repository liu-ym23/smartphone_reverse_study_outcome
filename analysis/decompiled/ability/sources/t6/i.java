package t6;

import androidx.sqlite.SQLiteConnection;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import j9.t;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6666a;
    public final /* synthetic */ String b;

    public /* synthetic */ i(String str, int i) {
        this.f6666a = i;
        this.b = str;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6666a) {
            case 0:
                return TaskStepDao_Impl.getFirstStepByTaskId$lambda$0("SELECT * FROM task_step WHERE taskId = ? ORDER BY startTime ASC LIMIT 1", this.b, (SQLiteConnection) obj);
            case 1:
                return TaskStepDao_Impl.deleteByTaskId$lambda$0("DELETE FROM task_step WHERE taskId = ?", this.b, (SQLiteConnection) obj);
            default:
                String it = (String) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return Boolean.valueOf(t.e0(it, this.b + "_", false));
        }
    }
}
