package com.stepos.ailauncher.chat.lockscreen;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.stepos.ailauncher.chat.lockscreen.LockScreenUnlockActivity;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.wake.DialogC3116e0;
import com.stepos.ailauncher.chat.wake.WakeDialogImpl;
import com.stepos.ailauncher.sla.SlaGate;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/O;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/sla/SlaGate;", "gate", "LY8/t;", "c", "(Landroid/content/Context;Lcom/stepos/ailauncher/sla/SlaGate;)V", "", "TAG", "Ljava/lang/String;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicLong;", "requestCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class O {
    private static final String TAG = "LockScreenUnlockCoordinator";
    public static final O INSTANCE = new O();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final AtomicLong requestCounter = new AtomicLong(0);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LockScreenUnlockActivity.UnlockResult.values().length];
            try {
                iArr[LockScreenUnlockActivity.UnlockResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LockScreenUnlockActivity.UnlockResult.ALREADY_UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LockScreenUnlockActivity.UnlockResult.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LockScreenUnlockActivity.UnlockResult.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LockScreenUnlockActivity.UnlockResult.TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Y8.t d(SlaGate slaGate, LockScreenUnlockActivity.UnlockResult result) {
        kotlin.jvm.internal.p.i(result, "result");
        int i10 = a.$EnumSwitchMapping$0[result.ordinal()];
        if (i10 == 1 || i10 == 2) {
            C4148a.k(TAG, "requestUnlockForSlaReplay: result=" + result + " -> replayCachedDecision", false, 4, null);
            slaGate.Q();
        } else {
            if (i10 != 3 && i10 != 4 && i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            C4148a.u(TAG, "requestUnlockForSlaReplay: result=" + result + " -> dropCachedDecision", false, 4, null);
            slaGate.I();
        }
        return Y8.t.f7040a;
    }

    public static final void e() {
        Object objB;
        DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
        if (dialogC3116e0Y0 instanceof WakeDialogImpl) {
            C4148a.k(TAG, "requestUnlockForSlaReplay: dismiss WakeDialog to release focus", false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                WakeDialogImpl.I3((WakeDialogImpl) dialogC3116e0Y0, null, 1, null);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "dismiss WakeDialog failed", thE, false, 8, null);
            }
        }
    }

    public final void c(Context context, final SlaGate gate) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(gate, "gate");
        Context applicationContext = context.getApplicationContext();
        String str = "sla_replay_" + requestCounter.incrementAndGet();
        C4148a.k(TAG, "requestUnlockForSlaReplay: requestId=" + str, false, 4, null);
        LockScreenUnlockActivity.Companion companion = LockScreenUnlockActivity.INSTANCE;
        kotlin.jvm.internal.p.f(applicationContext);
        companion.c(applicationContext, str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.lockscreen.M
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return O.d(gate, (LockScreenUnlockActivity.UnlockResult) obj);
            }
        });
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.N
            @Override // java.lang.Runnable
            public final void run() {
                O.e();
            }
        });
    }
}
