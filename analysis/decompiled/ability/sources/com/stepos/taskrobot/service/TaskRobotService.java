package com.stepos.taskrobot.service;

import C7.f;
import C7.r;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge;
import f6.AbstractC1436a;
import i9.l;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.a;
import kotlin.b;
import o6.j;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J)\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/service/TaskRobotService;", "Landroid/app/Service;", AppAgent.CONSTRUCT, "()V", "LC7/r;", AppAgent.ON_CREATE, "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "", "onUnbind", "(Landroid/content/Intent;)Z", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Lcom/stepos/taskrobot/service/TaskRobotManagerImpl;", "taskRobotManagerImpl$delegate", "LC7/f;", "getTaskRobotManagerImpl", "()Lcom/stepos/taskrobot/service/TaskRobotManagerImpl;", "taskRobotManagerImpl", "Companion", "o6/j", "service_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskRobotService extends Service {
    public static final j Companion = new j();
    public static final String TAG = "TaskRobotService";
    private static TaskRobotService instance;

    /* renamed from: taskRobotManagerImpl$delegate, reason: from kotlin metadata */
    private final f taskRobotManagerImpl = a.a(new l(this, 3));

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskRobotManagerImpl taskRobotManagerImpl_delegate$lambda$0(TaskRobotService taskRobotService) {
        return new TaskRobotManagerImpl(taskRobotService);
    }

    public final TaskRobotManagerImpl getTaskRobotManagerImpl() {
        return (TaskRobotManagerImpl) this.taskRobotManagerImpl.getF4884a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        AbstractC1436a.a(TAG, "onBind", true);
        return getTaskRobotManagerImpl();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AbstractC1436a.a(TAG, AppAgent.ON_CREATE, true);
        instance = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Object objA;
        AbstractC1436a.a(TAG, "onDestroy", true);
        try {
            SystemSdkBridge.INSTANCE.clearAllPendingSurfaces();
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, "clearAllPendingSurfaces failed: " + thA.getMessage(), true);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        AbstractC1436a.a(TAG, "onStartCommand", true);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        AbstractC1436a.a(TAG, "onUnbind", true);
        return super.onUnbind(intent);
    }
}
