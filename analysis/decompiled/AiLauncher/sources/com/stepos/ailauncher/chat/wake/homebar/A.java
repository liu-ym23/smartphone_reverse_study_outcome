package com.stepos.ailauncher.chat.wake.homebar;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService;
import com.stepos.ailauncher.sheet.v0;
import k5.C4814a;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u00008\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001am\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017\u001a7\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010#\"\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"", "startTime", "extraLeadMs", "leadMs", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(JJJ)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "delayMs", "durationMs", "applyLeadOnEnd", "firstBeatIsAnimEnd", "Lkotlin/Function0;", "isActive", "durationAtStart", "startClose", "Ljava/lang/Runnable;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(JJJZZLp9/a;Lp9/a;Lp9/a;)Ljava/lang/Runnable;", "runnable", "c", "(Ljava/lang/Runnable;)V", "", "stiffness", "dampingRatio", "startValue", "endValue", "startVelocity", "e", "(FFFFF)J", Const.INTENT_KEY_UMID, "()V", "SYSUI_CHAT_CLOSE_DELAY_MS", "J", "SYSUI_CHAT_CLOSE_TIME_LEAD_MS", "Landroid/os/Handler;", "sysUiCloseHandler", "Landroid/os/Handler;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    public static final long SYSUI_CHAT_CLOSE_DELAY_MS = 100;
    public static final long SYSUI_CHAT_CLOSE_TIME_LEAD_MS = 20;
    private static final Handler sysUiCloseHandler = new Handler(Looper.getMainLooper());

    public static final void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        sysUiCloseHandler.removeCallbacks(runnable);
    }

    public static final void d() {
        Application applicationA = C3197a.INSTANCE.a();
        Intent intent = new Intent(applicationA, (Class<?>) WakeService.class);
        intent.putExtra(C4814a.PARAM_SOURCE, C4814a.BOTTOM_BAR_KEY_LONG_CLICK);
        WakeService.INSTANCE.J1(applicationA, intent);
    }

    public static final long e(float f10, float f11, float f12, float f13, float f14) {
        return v0.a(f10, f11, f12, f13, f14);
    }

    public static /* synthetic */ long f(float f10, float f11, float f12, float f13, float f14, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            f14 = 0.0f;
        }
        return e(f10, f11, f12, f13, f14);
    }

    public static final boolean g() {
        IHomeBarSysUiService iHomeBarSysUiService = (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class);
        return iHomeBarSysUiService != null && iHomeBarSysUiService.isWhiteHomeBar();
    }

    public static final void h(long j10, long j11, long j12) {
        IHomeBarSysUiService iHomeBarSysUiService = (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class);
        if (iHomeBarSysUiService != null) {
            iHomeBarSysUiService.notifyChatViewClosed((j10 - j12) - j11);
        }
    }

    public static /* synthetic */ void i(long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = SystemClock.elapsedRealtime();
        }
        if ((i10 & 2) != 0) {
            j11 = 0;
        }
        if ((i10 & 4) != 0) {
            j12 = 20;
        }
        long j13 = j12;
        h(j10, j11, j13);
    }

    public static final Runnable j(long j10, long j11, final long j12, final boolean z10, boolean z11, final InterfaceC5063a<Boolean> isActive, final InterfaceC5063a<Long> interfaceC5063a, final InterfaceC5063a<Y8.t> startClose) {
        kotlin.jvm.internal.p.i(isActive, "isActive");
        kotlin.jvm.internal.p.i(startClose, "startClose");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long jG = C5685n.g(j11, 0L);
        if (z11) {
            h(jElapsedRealtime + j10 + jG, j12, 0L);
        } else {
            i(jElapsedRealtime + j10, j12, 0L, 4, null);
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.homebar.z
            @Override // java.lang.Runnable
            public final void run() {
                A.m(isActive, interfaceC5063a, jG, startClose, j12, z10);
            }
        };
        sysUiCloseHandler.postDelayed(runnable, j10);
        return runnable;
    }

    public static /* synthetic */ Runnable k(long j10, long j11, long j12, boolean z10, boolean z11, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5063a interfaceC5063a3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 100;
        }
        if ((i10 & 4) != 0) {
            j12 = 0;
        }
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        if ((i10 & 16) != 0) {
            z11 = false;
        }
        if ((i10 & 32) != 0) {
            interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.homebar.y
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(A.l());
                }
            };
        }
        if ((i10 & 64) != 0) {
            interfaceC5063a2 = null;
        }
        InterfaceC5063a interfaceC5063a4 = interfaceC5063a;
        boolean z12 = z10;
        return j(j10, j11, j12, z12, z11, interfaceC5063a4, interfaceC5063a2, interfaceC5063a3);
    }

    public static final boolean l() {
        return true;
    }

    public static final void m(InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, long j10, InterfaceC5063a interfaceC5063a3, long j11, boolean z10) {
        if (((Boolean) interfaceC5063a.invoke()).booleanValue()) {
            if (interfaceC5063a2 != null) {
                j10 = ((Number) interfaceC5063a2.invoke()).longValue();
            }
            long jG = C5685n.g(j10, 0L);
            interfaceC5063a3.invoke();
            h(SystemClock.elapsedRealtime() + jG, j11, z10 ? 20L : 0L);
        }
    }
}
