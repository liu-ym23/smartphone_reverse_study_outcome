package o6;

import com.stepos.taskrobot.service.TaskRobotManagerImpl;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5432a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(int i, String str, String str2) {
        this.f5432a = i;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5432a) {
            case 0:
                TaskRobotManagerImpl.cancelUserInput$lambda$0(this.b, this.c);
                break;
            default:
                TaskRobotManagerImpl.setChatSessionId$lambda$0(this.b, this.c);
                break;
        }
    }
}
