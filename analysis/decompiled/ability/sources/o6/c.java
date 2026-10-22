package o6;

import com.stepos.taskrobot.service.TaskRobotManagerImpl;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5435a;
    public final /* synthetic */ TaskRobotManagerImpl b;
    public final /* synthetic */ String c;

    public /* synthetic */ c(TaskRobotManagerImpl taskRobotManagerImpl, String str, int i) {
        this.f5435a = i;
        this.b = taskRobotManagerImpl;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5435a) {
            case 0:
                TaskRobotManagerImpl.pauseTask$lambda$0(this.b, this.c);
                break;
            case 1:
                TaskRobotManagerImpl.switchToMainDisplay$lambda$0(this.b, this.c);
                break;
            case 2:
                TaskRobotManagerImpl.switchToVirtualDisplay$lambda$0(this.b, this.c);
                break;
            case 3:
                TaskRobotManagerImpl.takeoverTask$lambda$0(this.b, this.c);
                break;
            case 4:
                TaskRobotManagerImpl.recoverFromTakeover$lambda$0(this.b, this.c);
                break;
            default:
                TaskRobotManagerImpl.resumeTask$lambda$0(this.b, this.c);
                break;
        }
    }
}
