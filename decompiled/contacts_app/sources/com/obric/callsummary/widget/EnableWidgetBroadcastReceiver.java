package com.obric.callsummary.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnableWidgetBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/callsummary/widget/EnableWidgetBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EnableWidgetBroadcastReceiver extends BroadcastReceiver {
    public static final Companion Companion = null;
    public static final String TAG = "EnableWidgetBroadcastReceiver";

    /* JADX INFO: compiled from: EnableWidgetBroadcastReceiver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/callsummary/widget/EnableWidgetBroadcastReceiver$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EnableWidgetBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryWidget.TAG, "EnableWidgetBroadcastReceiver onReceive " + r3);
        if (Intrinsics.areEqual(r3.getAction(), CallSummaryWidget.ACTION_WIDGET_SWITCH_ON) == false) goto L6;
        CallSummaryWidget.setCallSummaryAndRecordSwitchOn$default(r2, false, false, 6, null);
        return;
    }
}
