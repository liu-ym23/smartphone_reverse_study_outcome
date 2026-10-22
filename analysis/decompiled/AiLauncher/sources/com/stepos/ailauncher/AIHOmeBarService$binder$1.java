package com.stepos.ailauncher;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.ailauncher.ISysUI2AILauncher;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarChatViewCoordinator;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager;
import com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import v9.C5685n;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/ailauncher/AIHOmeBarService$binder$1", "Lcom/stepos/ailauncher/ISysUI2AILauncher$Stub;", "LY8/t;", "onHomeBarCapsuleClick", "()V", "onHomeBarPressed", "onHomeBarCancel", "", "startTime", "", "whitBar", "tryToShowChatView", "(JZ)V", "Landroid/content/Intent;", "intent", "tryToShowChatViewWithIntent", "(Landroid/content/Intent;JZ)V", "", "chatPanelShowType", "()I", "Landroid/os/IBinder;", UxipConstants.f30680s, "onInitialize", "(Landroid/os/IBinder;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AIHOmeBarService$binder$1 extends ISysUI2AILauncher.Stub {
    final /* synthetic */ AIHOmeBarService this$0;

    public AIHOmeBarService$binder$1(AIHOmeBarService aIHOmeBarService) {
        this.this$0 = aIHOmeBarService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHomeBarCancel$lambda$2(AIHOmeBarService aIHOmeBarService) throws Resources.NotFoundException {
        aIHOmeBarService.mainHandler.removeCallbacks(aIHOmeBarService.showChatViewRunnable);
        HomeBarChatViewCoordinator.INSTANCE.i();
        Iterator it = AIHOmeBarService.callbacks.iterator();
        while (it.hasNext()) {
            ((H) it.next()).onHomeBarCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHomeBarCapsuleClick$lambda$0() {
        Iterator it = AIHOmeBarService.callbacks.iterator();
        while (it.hasNext()) {
            ((H) it.next()).onHomeBarCapsuleClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHomeBarPressed$lambda$1() throws Resources.NotFoundException {
        HomeBarChatViewCoordinator.INSTANCE.j();
        Iterator it = AIHOmeBarService.callbacks.iterator();
        while (it.hasNext()) {
            ((H) it.next()).onHomeBarPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryToShowChatView$lambda$3(AIHOmeBarService aIHOmeBarService, long j10, boolean z10) throws Resources.NotFoundException {
        aIHOmeBarService.scheduleShowChatView(j10, z10);
        Iterator it = AIHOmeBarService.callbacks.iterator();
        while (it.hasNext()) {
            ((H) it.next()).tryToShowChatView(j10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryToShowChatViewWithIntent$lambda$5(AIHOmeBarService aIHOmeBarService) {
        Runnable runnable = aIHOmeBarService.pendingIntentLaunch;
        if (runnable != null) {
            aIHOmeBarService.mainHandler.removeCallbacks(runnable);
        }
        aIHOmeBarService.pendingIntentLaunch = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryToShowChatViewWithIntent$lambda$6(final String str, final long j10, final AIHOmeBarService aIHOmeBarService, final String str2, final AIHOmeBarService$binder$1 aIHOmeBarService$binder$1) {
        String str3 = str + ServerSentEventKt.COLON + j10;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (kotlin.jvm.internal.p.d(str3, aIHOmeBarService.lastIntentLaunchKey) && jElapsedRealtime - aIHOmeBarService.lastIntentLaunchAt < 1000) {
            Log.i("AIHomeBar", "tryToShowChatViewWithIntent deduped key=" + str3);
            return;
        }
        aIHOmeBarService.lastIntentLaunchKey = str3;
        aIHOmeBarService.lastIntentLaunchAt = jElapsedRealtime;
        Runnable runnable = aIHOmeBarService.pendingIntentLaunch;
        if (runnable != null) {
            aIHOmeBarService.mainHandler.removeCallbacks(runnable);
        }
        final long jO = C5685n.o(j10 - SystemClock.elapsedRealtime(), 0L, 500L);
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.p
            @Override // java.lang.Runnable
            public final void run() {
                AIHOmeBarService$binder$1.tryToShowChatViewWithIntent$lambda$6$0(aIHOmeBarService, str2, aIHOmeBarService$binder$1, str, j10, jO);
            }
        };
        aIHOmeBarService.pendingIntentLaunch = runnable2;
        if (jO == 0) {
            runnable2.run();
        } else {
            aIHOmeBarService.mainHandler.postDelayed(runnable2, jO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryToShowChatViewWithIntent$lambda$6$0(AIHOmeBarService aIHOmeBarService, String str, AIHOmeBarService$binder$1 aIHOmeBarService$binder$1, String str2, long j10, long j11) {
        Object objB;
        aIHOmeBarService.pendingIntentLaunch = null;
        ILiveNotificationService iLiveNotificationService = (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class);
        if (iLiveNotificationService != null) {
            ILiveNotificationService.dismissFailedAfterView$default(iLiveNotificationService, str, null, 2, null);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context applicationContext = aIHOmeBarService.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            objB = Result.b(C2739j.v(applicationContext, str2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e("AIHomeBar", "tryToShowChatViewWithIntent failed sessionId=" + str2, thE);
        }
        Log.i("AIHomeBar", "tryToShowChatViewWithIntent sessionId=" + str2 + " startTime=" + j10 + " delay=" + j11 + " route=" + ((String) (Result.g(objB) ? null : objB)));
    }

    @Override // com.stepos.ailauncher.ISysUI2AILauncher
    public int chatPanelShowType() {
        Pair pairA;
        if (HomeBarDisableManager.INSTANCE.e()) {
            pairA = Y8.j.a(-1, "input_more_attachment");
        } else {
            KeyguardManager keyguardManager = (KeyguardManager) this.this$0.getSystemService(KeyguardManager.class);
            if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
                AuthManager authManager = AuthManager.INSTANCE;
                pairA = !authManager.U() ? Y8.j.a(2, "login_required") : !authManager.K() ? Y8.j.a(2, "agent_auth_required") : com.stepos.ailauncher.common.utils.v.INSTANCE.k() ? Y8.j.a(-1, "conversation_foreground") : (!this.this$0.chatPanelShowing.get() || DesktopChatResidentController.S1()) ? Y8.j.a(1, "expand") : Y8.j.a(1, "restore");
            } else {
                pairA = Y8.j.a(-1, "keyguard");
            }
        }
        int iIntValue = ((Number) pairA.a()).intValue();
        Log.i("AIHomeBar", "chatPanelShowType type=" + iIntValue + " reason=" + ((String) pairA.b()));
        return iIntValue;
    }

    @Override // com.stepos.ailauncher.ISysUI2AILauncher
    public void onHomeBarCancel() {
        Handler handler = this.this$0.mainHandler;
        final AIHOmeBarService aIHOmeBarService = this.this$0;
        handler.post(new Runnable() { // from class: com.stepos.ailauncher.m
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                AIHOmeBarService$binder$1.onHomeBarCancel$lambda$2(aIHOmeBarService);
            }
        });
    }

    @Override // com.stepos.ailauncher.ISysUI2AILauncher
    public void onHomeBarCapsuleClick() {
        this.this$0.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.j
            @Override // java.lang.Runnable
            public final void run() {
                AIHOmeBarService$binder$1.onHomeBarCapsuleClick$lambda$0();
            }
        });
    }

    @Override // com.stepos.ailauncher.ISysUI2AILauncher
    public void onHomeBarPressed() {
        this.this$0.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.o
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                AIHOmeBarService$binder$1.onHomeBarPressed$lambda$1();
            }
        });
    }

    @Override // com.stepos.ailauncher.ISysUI2AILauncher
    public void onInitialize(IBinder value) {
        this.this$0.attachSysUi(value);
    }

    @Override // com.stepos.ailauncher.ISysUI2AILauncher
    public void tryToShowChatView(final long startTime, final boolean whitBar) {
        AIHOmeBarService.INSTANCE.o(whitBar);
        Handler handler = this.this$0.mainHandler;
        final AIHOmeBarService aIHOmeBarService = this.this$0;
        handler.post(new Runnable() { // from class: com.stepos.ailauncher.n
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                AIHOmeBarService$binder$1.tryToShowChatView$lambda$3(aIHOmeBarService, startTime, whitBar);
            }
        });
    }

    @Override // com.stepos.ailauncher.ISysUI2AILauncher
    public void tryToShowChatViewWithIntent(Intent intent, final long startTime, boolean whitBar) {
        String stringExtra;
        AIHOmeBarService.INSTANCE.o(whitBar);
        final String str = (intent == null || (stringExtra = intent.getStringExtra("sessionId")) == null || La.H.x0(stringExtra)) ? null : stringExtra;
        if (str == null) {
            Handler handler = this.this$0.mainHandler;
            final AIHOmeBarService aIHOmeBarService = this.this$0;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.k
                @Override // java.lang.Runnable
                public final void run() {
                    AIHOmeBarService$binder$1.tryToShowChatViewWithIntent$lambda$5(aIHOmeBarService);
                }
            });
            Log.w("AIHomeBar", "tryToShowChatViewWithIntent ignored: missing sessionId");
            return;
        }
        final String strM = ConversationSessionIds.INSTANCE.m(str);
        Handler handler2 = this.this$0.mainHandler;
        final AIHOmeBarService aIHOmeBarService2 = this.this$0;
        handler2.post(new Runnable() { // from class: com.stepos.ailauncher.l
            @Override // java.lang.Runnable
            public final void run() {
                AIHOmeBarService$binder$1.tryToShowChatViewWithIntent$lambda$6(strM, startTime, aIHOmeBarService2, str, this);
            }
        });
    }
}
