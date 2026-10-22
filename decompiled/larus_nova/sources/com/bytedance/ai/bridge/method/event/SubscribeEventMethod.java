package com.bytedance.ai.bridge.method.event;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.event.AbsSubscribeEventMethodIDL;
import com.bytedance.ai.bridge.method.device.BatteryInfoChangeEventPublisher$ensureMonitoring$1$changeReceiver$1;
import com.bytedance.ai.utils.g;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import f4.t;
import f4.w;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l3.e;
import t3.e0;
import v3.b;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/event/SubscribeEventMethod;", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL$SubscribeEventParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL$EmptyMessageModel;", "shouldSkipThemeChangeSubscription", "", "eventName", "", "launchRelatedEventService", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubscribeEventMethod extends AbsSubscribeEventMethodIDL {

    public static final class a {
    }

    static {
    }

    public SubscribeEventMethod() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [android.content.BroadcastReceiver, com.bytedance.ai.bridge.method.device.BatteryInfoChangeEventPublisher$ensureMonitoring$1$changeReceiver$1, java.lang.Object] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r110, ParamModel r111, h r112) {
        AbsSubscribeEventMethodIDL.b r113 = (AbsSubscribeEventMethodIDL.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (Intrinsics.areEqual(r113.getEventName(), "onThemeChange") == true) goto L5;
        boolean r100 = false;
    L24:
        if (r100 == false) goto L26;
        g.f37637a.i("SubscribeEventMethod", "skip onThemeChange subscription because theme is forced");
        Intrinsics.checkNotNullParameter(AbsSubscribeEventMethodIDL.a.class, "<this>");
        r112.b((ResultModel) c.a(AbsSubscribeEventMethodIDL.a.class), "");
        return;
    L26:
        Lazy r101 = l3.d.f507201a;
        e3.g r102 = r110.getJsEventDelegate();
        a0 r103 = r110.getContainerContext();
        if (r103 == null) goto L29;
        String r104 = r103.getContainerId();
    L30:
        a0 r105 = r110.getContainerContext();
        if (r105 == null) goto L33;
        String r106 = r105.getAppletId();
    L34:
        long r107 = r113.getTimestamp();
        a0 r108 = r110.getContainerContext();
        if (r108 == null) goto L37;
        String r109 = r108.getTag();
    L38:
        l3.d.e(new e(r102, r104, r106, r107, r109), r113.getEventName());
        String r114 = r113.getEventName();
        switch(r114.hashCode()) {
            case -2116854609: goto L108;
            case -1771389009: goto L101;
            case -1697607502: goto L98;
            case -1411253139: goto L92;
            case -1272114076: goto L56;
            case 403290560: goto L52;
            case 1015003481: goto L49;
            case 1559973925: goto L46;
            case 1982168521: goto L42;
            default: goto L117;
        };
    L117:
        Intrinsics.checkNotNullParameter(AbsSubscribeEventMethodIDL.a.class, "<this>");
        r112.b((ResultModel) c.a(AbsSubscribeEventMethodIDL.a.class), "");
        return;
    L42:
        if (r114.equals("doubao.onNetworkStatusChange") == false) goto L117;
        Object r115 = com.bytedance.ai.bridge.method.net.d.f35637a;
        com.bytedance.ai.bridge.method.net.d.b();
        goto L117
    L46:
        if (r114.equals("doubao.onBluetoothDeviceFound") == false) goto L117;
    L110:
        Context r116 = e3.e.b(r110);
        if (r116 == null) goto L117;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L114
        e0.f544279a.getClass();     // Catch: Throwable -> L114
        e0.d(r110, r116);     // Catch: Throwable -> L114
        Object r118 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L114
    L116:
        Result.m9448boximpl(r118);
    L114:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L116
    L49:
        if (r114.equals("doubao.onBluetoothAdapterStateChange") == true) goto L110;
    L52:
        if (r114.equals("doubao.onUserCaptureScreen") == false) goto L117;
        w3.d.f558094a.getClass();
        w3.d.c();
        goto L117
    L56:
        if (r114.equals("doubao.onBatteryInfoChange") == false) goto L117;
        Object r120 = t3.d.f544263a;
        Context r121 = k.a().getApplicationContext();
        Object r122 = t3.d.f544263a;
        monitor-enter(r122);
    L88:
        th = move-exception;
        throw th;
    L61:
        if (t3.d.f544265c == null) goto L64;
        monitor-exit(r122);
        goto L117
    L64:
        ?? r123 = new BatteryInfoChangeEventPublisher$ensureMonitoring$1$changeReceiver$1();     // Catch: Throwable -> L88
        IntentFilter r124 = new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED");     // Catch: RuntimeException -> L71 Throwable -> L88
        r124.addAction("miui.intent.action.POWER_SAVE_MODE_CHANGED");     // Catch: RuntimeException -> L71 Throwable -> L88
        if (Build.VERSION.SDK_INT < 34) goto L68;
        t3.d.a(r121, r123, r124);     // Catch: RuntimeException -> L71 Throwable -> L88
    L69:
        t3.d.f544264b = r121;     // Catch: RuntimeException -> L71 Throwable -> L88
        t3.d.f544265c = r123;     // Catch: RuntimeException -> L71 Throwable -> L88
        t3.e.f544277b.getClass();     // Catch: RuntimeException -> L71 Throwable -> L88
        t3.d.f544266d = t3.e.a.a(r121);     // Catch: RuntimeException -> L71 Throwable -> L88
    L85:
        Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L88
        monitor-exit(r122);
        goto L117
    L68:
        t3.d.b(r121, r123, r124);     // Catch: RuntimeException -> L71 Throwable -> L88
    L71:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L82
        ReceiverRegisterLancet.loge(r123, false);     // Catch: Throwable -> L82
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L125;
        r121.unregisterReceiver(r123);     // Catch: Throwable -> L82
    L80:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L82
    L84:
        t3.d.f544264b = null;     // Catch: Throwable -> L88
        t3.d.f544265c = null;     // Catch: Throwable -> L88
        t3.d.f544266d = null;     // Catch: Throwable -> L88
        goto L85
    L125:
    L77:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r123.toString());     // Catch: Throwable -> L82
        e.printStackTrace();     // Catch: Throwable -> L82
        goto L80
    L74:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r123, r121) == false) goto L80;
        r121.unregisterReceiver(r123);     // Catch: Exception -> L77 Throwable -> L82
    L82:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L88
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L88
        goto L84
    L92:
        if (r114.equals("doubao.onWifiConnected") == false) goto L117;
        Context r128 = e3.e.b(r110);
        if (r128 == null) goto L117;
        b.f(r128);
        goto L117
    L98:
        if (r114.equals("doubao.onBLECharacteristicValueChange") == true) goto L110;
    L101:
        if (r114.equals("doubao.onUserScreenRecord") == false) goto L117;
        w r129 = w.f475483a;
        final Activity r130 = e3.e.a(r110);
        r129.getClass();
        if (Build.VERSION.SDK_INT < 35) goto L117;
        p2.c.d(new t(r130));
        goto L117
    L108:
        if (r114.equals("doubao.onBLEConnectionStateChange") == true) goto L110;
    L37:
        r109 = null;
        goto L38
    L33:
        r106 = null;
        goto L34
    L29:
        r104 = null;
        goto L30
    L5:
        View r131 = r110.getEngineView();
        if (r131 == null) goto L8;
        Context r132 = r131.getContext();
    L9:
        r100 = t2.a.b(r132);
        g r133 = g.f37637a;
        StringBuilder r134 = new StringBuilder("check onThemeChange subscription, appletId=");
        a0 r135 = r110.getContainerContext();
        if (r135 == null) goto L12;
        String r136 = r135.getAppletId();
    L13:
        r134.append(r136);
        r134.append(", hasEngineView=");
        if (r131 == null) goto L16;
        boolean r137 = true;
    L17:
        r134.append(r137);
        r134.append(", contextType=");
        if (r131 == null) goto L22;
        Context r138 = r131.getContext();
        if (r138 == null) goto L22;
        String r139 = r138.getClass().getName();
    L23:
        r134.append(r139);
        r134.append(", isForcedTheme=");
        r134.append(r100);
        r133.i("SubscribeEventMethod", r134.toString());
    L22:
        r139 = null;
        goto L23
    L16:
        r137 = false;
        goto L17
    L12:
        r136 = null;
        goto L13
    L8:
        r132 = null;
        goto L9
    }
}
