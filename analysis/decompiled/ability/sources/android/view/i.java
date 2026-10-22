package android.view;

import R5.d;
import android.content.IntentSender;
import android.view.result.contract.ActivityResultContract;
import androidx.profileinstaller.DeviceProfileWriter;
import com.mdisdk.capability.input.EventCallback;
import com.mdisdk.capability.input.impl.gesture.BaseGestureExecutor;
import com.stepos.deepbinder.core.provider.ClientServiceProvider;
import com.stepos.taskrobot.service.TaskRobotManagerImpl;
import com.uxsense.parse.b;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1673a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ i(int i, int i6, Object obj, Object obj2) {
        this.f1673a = i6;
        this.b = obj;
        this.c = i;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1673a) {
            case 0:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0((ComponentActivity$activityResultRegistry$1) this.b, this.c, (ActivityResultContract.SynchronousResult) this.d);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1((ComponentActivity$activityResultRegistry$1) this.b, this.c, (IntentSender.SendIntentException) this.d);
                break;
            case 2:
                ((DeviceProfileWriter) this.b).lambda$result$0(this.c, this.d);
                break;
            case 3:
                ((BaseGestureExecutor) this.b).lambda$execute$2(this.c, (EventCallback) this.d);
                break;
            case 4:
                d.c(this.c + 1, (d) this.b, (b) this.d);
                break;
            case 5:
                TaskRobotManagerImpl.confirmPackageConflict$lambda$0((TaskRobotManagerImpl) this.b, (String) this.d, this.c);
                break;
            default:
                ((ClientServiceProvider) this.b).recycle(this.c, (long[]) this.d);
                break;
        }
    }

    public /* synthetic */ i(int i, d dVar, b bVar) {
        this.f1673a = 4;
        this.c = i;
        this.b = dVar;
        this.d = bVar;
    }

    public /* synthetic */ i(TaskRobotManagerImpl taskRobotManagerImpl, String str, int i) {
        this.f1673a = 5;
        this.b = taskRobotManagerImpl;
        this.d = str;
        this.c = i;
    }
}
