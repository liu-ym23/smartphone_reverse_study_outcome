package com.stepos.ailauncher.homegesture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import h8.C4148a;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B)\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/homegesture/d;", "Landroid/content/BroadcastReceiver;", "Lkotlin/Function1;", "", "LY8/t;", "onConsume", "Lkotlin/Function0;", "onDismissDesktop", "<init>", "(Lp9/l;Lp9/a;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lp9/l;", "Lp9/a;", "Companion", Const.INTENT_KEY_APIKEY, "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3337d extends BroadcastReceiver {
    private static final String TAG = "HomeConsumeReceiver";
    private final InterfaceC5074l<Long, Y8.t> onConsume;
    private final InterfaceC5063a<Y8.t> onDismissDesktop;

    /* JADX WARN: Multi-variable type inference failed */
    public C3337d(InterfaceC5074l<? super Long, Y8.t> onConsume, InterfaceC5063a<Y8.t> onDismissDesktop) {
        kotlin.jvm.internal.p.i(onConsume, "onConsume");
        kotlin.jvm.internal.p.i(onDismissDesktop, "onDismissDesktop");
        this.onConsume = onConsume;
        this.onDismissDesktop = onDismissDesktop;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (!kotlin.jvm.internal.p.d(action, "com.stepos.ailauncher.action.CONSUME_HOME_GESTURE")) {
            if (kotlin.jvm.internal.p.d(action, "com.stepos.ailauncher.action.DISMISS_DESKTOP_CHAT")) {
                C4148a.k(TAG, "DISMISS_DESKTOP_CHAT", false, 4, null);
                this.onDismissDesktop.invoke();
                return;
            }
            return;
        }
        long longExtra = intent.getLongExtra(HomeGestureEligibilityContract.EXTRA_GENERATION, -1L);
        C4148a.k(TAG, "CONSUME_HOME_GESTURE gen=" + longExtra, false, 4, null);
        this.onConsume.invoke(Long.valueOf(longExtra));
    }
}
