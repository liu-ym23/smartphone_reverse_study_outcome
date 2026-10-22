package A4;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.deepbinder.client.channel.remote.DefaultRemoteChannel;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.taskrobot.llmapi.stepfun.DebugInfoDialogListener;
import com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper;
import com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup;
import com.stepos.taskrobot.service.TaskRobotManagerImpl;
import com.zyql.common.utils.update.UpdateManager;
import com.zyql.common.utils.update.UpdateProgressDialog;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import qa.C1860l;
import qa.InterfaceC1855g;
import qa.L;
import stepai.aios.guiexecutor.input.UserInputRequest;
import xa.InterfaceC2124a;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f100a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(int i, String str, Object obj, Object obj2) {
        this.f100a = i;
        this.c = obj;
        this.b = str;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        switch (this.f100a) {
            case 0:
                j jVar = (j) this.c;
                ToolCallEvent toolCallEvent = (ToolCallEvent) this.d;
                String str = (String) this.b;
                try {
                    jVar.f105a.onToolCallEvent(toolCallEvent);
                    break;
                } catch (Exception e) {
                    String strH = androidx.constraintlayout.core.dsl.a.h("publishToolCallEvent failed for ", str, NotificationCompat.CATEGORY_MESSAGE);
                    String strConcat = "Ability_".concat("TaskListenerManager");
                    P3.b bVar = P3.c.f1086a;
                    bVar.invoke(5, strConcat, strH, e);
                    if ((e instanceof DeadObjectException) || (e.getCause() instanceof DeadObjectException)) {
                        String strA = k.a(str);
                        k.f106a.remove(str);
                        Set set = (Set) k.b.get(strA);
                        if (set != null) {
                            set.remove(str);
                        }
                        String msg = "listener removed (dead object): ".concat(str);
                        kotlin.jvm.internal.k.f(msg, "msg");
                        bVar.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
                        return;
                    }
                    return;
                }
            case 1:
                String str2 = (String) this.b;
                Task task = (Task) this.d;
                j jVar2 = (j) this.c;
                P3.b bVar2 = P3.c.f1086a;
                try {
                    String msg2 = "publishTaskEvent: key=" + str2 + ", taskId=" + task.getTaskId();
                    kotlin.jvm.internal.k.f(msg2, "msg");
                    bVar2.invoke(3, "Ability_".concat("TaskListenerManager"), msg2, null);
                    jVar2.f105a.onTaskEvent(task);
                    break;
                } catch (Exception e6) {
                    bVar2.invoke(5, "Ability_".concat("TaskListenerManager"), androidx.constraintlayout.core.dsl.a.h("publishTaskEvent failed for ", str2, NotificationCompat.CATEGORY_MESSAGE), e6);
                    if ((e6 instanceof DeadObjectException) || (e6.getCause() instanceof DeadObjectException)) {
                        String strA2 = k.a(str2);
                        k.f106a.remove(str2);
                        Set set2 = (Set) k.b.get(strA2);
                        if (set2 != null) {
                            set2.remove(str2);
                        }
                        String msg3 = "listener removed (dead object): ".concat(str2);
                        kotlin.jvm.internal.k.f(msg3, "msg");
                        bVar2.invoke(3, "Ability_".concat("TaskListenerManager"), msg3, null);
                        return;
                    }
                    return;
                }
            case 2:
                F.i.w((NestedScrollView) this.c, (View) this.d, (View) this.b);
                break;
            case 3:
                F.i.w((ListView) this.c, (View) this.d, (View) this.b);
                break;
            case 4:
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.d dVar = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.d) this.c;
                TrackerPayload trackerPayload = (TrackerPayload) this.d;
                String str3 = (String) this.b;
                V5.a aVar = dVar.f;
                Log.d("V3OfflineEmitter", "add thread:" + Thread.currentThread().getName());
                dVar.g = dVar.g + 1;
                W5.c.a("V3OfflineEmitter", "add rowId:" + dVar.g);
                u1.d dVar2 = com.stepos.statsapp.v3.lib.plugin.emitter.remote.e.f3972a;
                Context context = dVar.f3966a;
                String str4 = dVar.h;
                EmitterConfig emitterConfig = dVar.b;
                if (u1.d.h) {
                    dVar2.getClass();
                } else if (dVar2.H(context)) {
                    try {
                        u1.d.h = true;
                        ((IVccOfflineStatsInterface) dVar2.c).emitterUpdateConfig(str4, emitterConfig);
                    } catch (Throwable th) {
                        W5.c.b("V3RemoteServiceReq", "emitterUpdateConfig error, " + th.getMessage());
                        return;
                    }
                }
                String str5 = dVar.h;
                String appId = emitterConfig.getAppId();
                String channel = emitterConfig.getChannel();
                long j5 = dVar.g;
                if (dVar2.H(context)) {
                    try {
                        ((IVccOfflineStatsInterface) dVar2.c).emitterAddEvent(str5, appId, channel, j5, trackerPayload);
                    } catch (Throwable th2) {
                        W5.c.b("V3RemoteServiceReq", "emitterAddEvent error, " + th2.getMessage());
                    }
                }
                if (aVar.f1385a.getAll().size() < 500) {
                    aVar.a(String.valueOf(dVar.g), str3);
                    break;
                }
                break;
            case 5:
                DebugInfoDialogListener.onUserInputRequested$lambda$0((String) this.b, (AtomicReference) this.c, (UserInputRequest) this.d);
                break;
            case 6:
                FullScreenHelper.migrateEntry$lambda$0((FullScreenHelper) this.c, (String) this.b, (String) this.d);
                break;
            case 7:
                UpdateManager.checkAndDownloadUpdate$lambda$24$lambda$22$lambda$20$lambda$19((UpdateProgressDialog) this.c, (Context) this.d, (File) this.b);
                break;
            case 8:
                DefaultRemoteChannel.call$lambda$1((DefaultRemoteChannel) this.c, (String) this.b, (Bundle) this.d);
                break;
            case 9:
                PassiveTakeoverPromptPopup.show$lambda$0((PassiveTakeoverPromptPopup) this.c, (String) this.b, (View) this.d);
                break;
            case 10:
                TaskRobotManagerImpl.submitUserInput$lambda$0((String) this.b, (String) this.c, (String) this.d);
                break;
            case 11:
                ((PAGView) this.c).a((String) this.b, (PAGFile.LoadListener) this.d);
                break;
            case 12:
                F.g gVar = (F.g) this.c;
                InterfaceC1855g interfaceC1855g = (InterfaceC1855g) this.d;
                L l = (L) this.b;
                C1860l c1860l = (C1860l) gVar.c;
                if (!c1860l.b.l()) {
                    interfaceC1855g.j(c1860l, l);
                    break;
                } else {
                    interfaceC1855g.r(c1860l, new IOException("Canceled"));
                    break;
                }
            case 13:
                ((InterfaceC1855g) this.d).r((C1860l) ((F.g) this.c).c, (Throwable) this.b);
                break;
            case 14:
                wa.e eVar = (wa.e) this.c;
                za.i iVar = (za.i) this.d;
                String str6 = (String) this.b;
                eVar.getClass();
                try {
                    Iterator it = eVar.f6861a.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC2124a) it.next()).onTaskTakenOver(iVar, str6);
                    }
                    break;
                } catch (Exception e9) {
                    com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskTakenOver", ": ", e9.getMessage(), "TaskEventDispatcher");
                    return;
                }
            default:
                wa.e eVar2 = (wa.e) this.c;
                za.i iVar2 = (za.i) this.d;
                za.c cVar = (za.c) this.b;
                eVar2.getClass();
                try {
                    Iterator it2 = eVar2.f6861a.iterator();
                    while (it2.hasNext()) {
                        ((InterfaceC2124a) it2.next()).onTaskRunning(iVar2, cVar);
                    }
                    break;
                } catch (Exception e10) {
                    com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRunning", ": ", e10.getMessage(), "TaskEventDispatcher");
                }
        }
    }

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i) {
        this.f100a = i;
        this.c = obj;
        this.d = obj2;
        this.b = obj3;
    }

    public /* synthetic */ e(String str, Task task, j jVar) {
        this.f100a = 1;
        this.b = str;
        this.d = task;
        this.c = jVar;
    }

    public /* synthetic */ e(String str, Serializable serializable, Object obj, int i) {
        this.f100a = i;
        this.b = str;
        this.c = serializable;
        this.d = obj;
    }
}
