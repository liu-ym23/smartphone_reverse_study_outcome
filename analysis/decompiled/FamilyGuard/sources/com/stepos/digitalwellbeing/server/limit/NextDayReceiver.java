package com.stepos.digitalwellbeing.server.limit;

import A3.c;
import R1.a;
import T1.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import f2.C0697b;
import java.util.concurrent.TimeUnit;
import p2.g;
import x3.f;
import z3.C1347a;

/* loaded from: classes.dex */
public class NextDayReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private c f14566a;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Context context, Long l5) {
        c(context);
    }

    private void c(Context context) {
        DigitalWellbeingService.Z(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (b.f(context) || g.x(context)) {
            String action = intent.getAction();
            if (TextUtils.equals("android.intent.action.DATE_CHANGED", action) || TextUtils.equals("android.intent.action.TIME_SET", action)) {
                a.a("NextDayReceiver", action);
                if (C0697b.u(action)) {
                    a.l("NextDayReceiver", "clock jump: reschedule and reHandleLimit instead of onNextDay");
                    DigitalWellbeingService.V(context);
                    return;
                } else {
                    if (TextUtils.equals("android.intent.action.DATE_CHANGED", action)) {
                        this.f14566a = f.b0(2L, TimeUnit.MINUTES).G(C1347a.a()).S(new D3.c() { // from class: Y1.m
                            @Override // D3.c
                            public final void accept(Object obj) {
                                this.f6454a.b(context, (Long) obj);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.equals("com.stepos.digitalwellbeing.action.next_day", action)) {
                a.a("NextDayReceiver", "NEXT_DAY_ACTION");
                if (!C0697b.q()) {
                    c(context);
                } else {
                    a.l("NextDayReceiver", "skip NEXT_DAY_ACTION after recent clock jump");
                    DigitalWellbeingService.V(context);
                }
            }
        }
    }
}
