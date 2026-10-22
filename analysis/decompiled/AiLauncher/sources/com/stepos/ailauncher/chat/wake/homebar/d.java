package com.stepos.ailauncher.chat.wake.homebar;

import Z8.F;
import android.app.ActivityManager;
import android.content.Context;
import android.view.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0013\u0010\u0003R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/d;", "Landroidx/lifecycle/Q;", "<init>", "()V", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;", HomeGestureEligibilityContract.EXTRA_SCENE, "Landroid/content/Context;", "context", "", "taskId", "LY8/t;", "f", "(Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;Landroid/content/Context;I)V", "Lkotlin/Function0;", "", "isActive", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$b;", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$b;", "finished", "Z", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends Q {
    public static final String EXTRA_FROM_MORE_MENU = "com.stepos.ailauncher.extra.FROM_INPUT_MORE_MENU";
    private boolean finished;
    private HomeBarDisableManager.b token;

    public static final boolean h(d dVar, ActivityManager activityManager, int i10) {
        Object objB;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean z10 = false;
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) F.s0(runningTasks)) != null && runningTaskInfo.id == i10) {
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // android.view.Q
    public void d() {
        i();
    }

    public final void f(HomeBarDisableManager.Scene scene, Context context, final int taskId) {
        kotlin.jvm.internal.p.i(scene, "scene");
        kotlin.jvm.internal.p.i(context, "context");
        if (this.token != null || this.finished) {
            return;
        }
        final ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(ActivityManager.class);
        g(scene, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.homebar.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(d.h(this.f26781a, activityManager, taskId));
            }
        });
    }

    public final void g(HomeBarDisableManager.Scene scene, InterfaceC5063a<Boolean> isActive) {
        kotlin.jvm.internal.p.i(scene, "scene");
        kotlin.jvm.internal.p.i(isActive, "isActive");
        if (this.token != null || this.finished) {
            return;
        }
        this.token = HomeBarDisableManager.INSTANCE.b(scene, isActive);
        C4148a.d("HomeBarDisable", "begin " + scene, false, 4, null);
    }

    public final void i() {
        this.finished = true;
        HomeBarDisableManager.b bVar = this.token;
        if (bVar == null) {
            return;
        }
        this.token = null;
        bVar.close();
        C4148a.d("HomeBarDisable", "finish, remaining=" + HomeBarDisableManager.INSTANCE.c(), false, 4, null);
    }
}
