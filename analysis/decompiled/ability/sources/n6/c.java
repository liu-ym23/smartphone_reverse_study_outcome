package n6;

import S7.k;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.stepos.ability.task.executor.e;
import com.stepos.taskrobot.common.ITaskRobotManger;

/* loaded from: classes3.dex */
public final class c implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f5352a;

    public c(k kVar) {
        this.f5352a = kVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(service, "service");
        Log.d("TaskRobotManager", "onServiceConnected");
        e.f3313j = ITaskRobotManger.Stub.asInterface(service);
        e.k = this;
        k kVar = this.f5352a;
        if (kVar != null) {
            kVar.invoke(Boolean.TRUE);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        kotlin.jvm.internal.k.f(name, "name");
        Log.d("TaskRobotManager", "onServiceDisconnected");
        e.f3313j = null;
        e.k = null;
    }
}
