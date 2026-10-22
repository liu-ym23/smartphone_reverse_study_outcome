package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeBatteryInfoWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeBatteryInfoWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f118837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LandscapeBatteryView f118838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f118839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f118840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f118841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LandscapeBatteryInfoWidget$batteryReceiver$1 f118842f;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_landscape_battery_info;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ALogger.i("LandscapeBattery", "onUnload");
        Context r100 = this.context;     // Catch: Exception -> L15
        LandscapeBatteryInfoWidget$batteryReceiver$1 r101 = this.f118842f;     // Catch: Exception -> L15
        ReceiverRegisterLancet.loge(r101, false);     // Catch: Exception -> L15
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L18;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L15
        return;
    L18:
    L9:
        e = move-exception;
        if (r101 == null) goto L12;
        Npth.addTag("unregisterReceiver", r101.toString());     // Catch: Exception -> L15
    L12:
        e.printStackTrace();     // Catch: Exception -> L15
        return;
    L6:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L21;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L9
    L23:
        return;
    L21:
        return;
    L15:
        e = move-exception;
        ALogger.e("LandscapeBattery", e.toString());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeBatteryInfoWidget$batteryReceiver$1] */
    public LandscapeBatteryInfoWidget() {
        this.f118839c = -1;
        this.f118840d = -1;
        this.f118841e = -1;
        this.f118842f = new LandscapeBatteryInfoWidget$batteryReceiver$1(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        ALogger.i("LandscapeBattery", "onInit");
        this.f118837a = (TextView) this.contentView.findViewById(R.id.tv_battery_info);
        this.f118838b = (LandscapeBatteryView) this.contentView.findViewById(R.id.battery_view);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        ALogger.i("LandscapeBattery", WidgetCostModule.TYPE_ON_LOAD);
        IntentFilter r111 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Context r100 = this.context;
        LandscapeBatteryInfoWidget$batteryReceiver$1 r101 = this.f118842f;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L36:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        Intent r112 = ReceiverRegisterCrashOptimizer.registerReceiver(r101, r111);
    L33:
        wq(r112);
        UtilityKotlinExtentionsKt.s(0, false, false, new LandscapeBatteryInfoWidget$refreshUI$1(this), 7);
        return;
    L35:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L20;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r111, 0, null, null, 2, r100);     // Catch: Exception -> L29
        int r103 = r102.result;     // Catch: Exception -> L29
        if (r103 != 1) goto L12;
        r112 = r100.registerReceiver(r101, r111);     // Catch: Exception -> L29
        goto L33
    L12:
        if (r103 != 2) goto L14;
        r112 = new Intent();     // Catch: Exception -> L29
        goto L33
    L14:
        if (r103 == 3) goto L16;
        r112 = r100.registerReceiver(r101, r111);     // Catch: Exception -> L29
        goto L33
    L16:
        r112 = r102.intent;     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r112 = r100.registerReceiver(r101, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L33
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r112 = r100.registerReceiver(r101, r111);     // Catch: Exception -> L29
        goto L33
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        r112 = ContextCompat.registerReceiver(r100, r101, r111, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
        goto L33
    }

    public final void wq(Intent r100) {
        if (r100 == null) goto L6;
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L6;
        int r102 = r101.getInt("scale");
    L7:
        this.f118839c = r102;
        if (r100 == null) goto L12;
        Bundle r103 = r100.getExtras();
        if (r103 == null) goto L12;
        int r104 = r103.getInt("level");
    L13:
        this.f118840d = r104;
        if (r100 == null) goto L18;
        Bundle r105 = r100.getExtras();
        if (r105 == null) goto L18;
        int r106 = r105.getInt("status");
    L19:
        this.f118841e = r106;
        ALogger.i("LandscapeBattery", "receive data = " + this.f118839c + "  current = " + this.f118840d + "   status = " + this.f118841e);
        return;
    L18:
        r106 = 1;
    L12:
        r104 = this.f118839c;
    L6:
        r102 = 100;
        goto L7
    }
}
