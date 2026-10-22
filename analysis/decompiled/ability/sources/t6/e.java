package t6;

import androidx.sqlite.SQLiteConnection;
import com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao_Impl;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6663a;
    public final /* synthetic */ TaskDeviceInfoDao_Impl b;
    public final /* synthetic */ TaskDeviceInfoEntity c;

    public /* synthetic */ e(TaskDeviceInfoDao_Impl taskDeviceInfoDao_Impl, TaskDeviceInfoEntity taskDeviceInfoEntity, int i) {
        this.f6663a = i;
        this.b = taskDeviceInfoDao_Impl;
        this.c = taskDeviceInfoEntity;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6663a) {
            case 0:
                return TaskDeviceInfoDao_Impl.update$lambda$0(this.b, this.c, (SQLiteConnection) obj);
            case 1:
                return TaskDeviceInfoDao_Impl.delete$lambda$0(this.b, this.c, (SQLiteConnection) obj);
            default:
                return Long.valueOf(TaskDeviceInfoDao_Impl.insert$lambda$0(this.b, this.c, (SQLiteConnection) obj));
        }
    }
}
