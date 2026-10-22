package o6;

import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.service.TaskRobotManagerImpl;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5436a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ITaskProgressCallback d;

    public /* synthetic */ d(String str, int i, ITaskProgressCallback iTaskProgressCallback, int i6) {
        this.f5436a = i6;
        this.b = str;
        this.c = i;
        this.d = iTaskProgressCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5436a) {
            case 0:
                TaskRobotManagerImpl.unregisterProgressCallback$lambda$0(this.b, this.c, this.d);
                break;
            default:
                TaskRobotManagerImpl.registerProgressCallback$lambda$0(this.b, this.c, this.d);
                break;
        }
    }
}
