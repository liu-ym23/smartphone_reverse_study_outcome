package com.bytedance.ai.bridge.method.system;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.setting.AbsGetSystemSettingMethodIDL;
import com.bytedance.ai.utils.g;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.a0;
import e3.e;
import f3.h;
import f4.o;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetSystemSettingMethod;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetSystemSettingMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetSystemSettingMethodIDL$GetSystemSettingResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/setting/AbsGetSystemSettingMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSystemSettingMethod extends AbsGetSystemSettingMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f35939b;

    public static final class a {
    }

    static {
    }

    public GetSystemSettingMethod() {
        this.f35939b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.f35939b;
    }

    public static com.bytedance.ai.bridge.core.a b(e3.d r100, AbsGetSystemSettingMethodIDL.a r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        g r102 = g.f37637a;
        StringBuilder r103 = new StringBuilder("call start, appletId=");
        a0 r104 = r100.getContainerContext();
        WifiManager r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.getAppletId();
    L6:
        r103.append(r106);
        r102.i("AISDK_JSB_GetSystemSettingMethod", r103.toString());
        Context r107 = e.b(r100);
        if (r107 != null) goto L10;
        StringBuilder r108 = new StringBuilder("call failed, errNo=");
        f3.a r109 = f3.a.f475265f;
        r108.append(r109.f475285a);
        r108.append(", msg=context is null");
        r102.e("AISDK_JSB_GetSystemSettingMethod", r108.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "context is null", null, r109, 21);
    L10:
        r102.i("AISDK_JSB_GetSystemSettingMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsGetSystemSettingMethodIDL.b.class, "<this>");
        BaseModel r110 = k3.c.a(AbsGetSystemSettingMethodIDL.b.class);
        AbsGetSystemSettingMethodIDL.b r111 = (AbsGetSystemSettingMethodIDL.b) r110;
        o.f475473a.getClass();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r112 = false;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L23
        if (Build.VERSION.SDK_INT < 23) goto L17;
        BluetoothManager r114 = (BluetoothManager) r107.getSystemService(BluetoothManager.class);     // Catch: Throwable -> L23
        if (r114 == null) goto L16;
        BluetoothAdapter r115 = r114.getAdapter();     // Catch: Throwable -> L23
    L18:
        if (r115 == null) goto L20;
        boolean r116 = r115.isEnabled();     // Catch: Throwable -> L23
    L21:
        Object r117 = Result.m9449constructorimpl(Boolean.valueOf(r116));     // Catch: Throwable -> L23
    L25:
        Boolean r118 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r117) == false) goto L28;
        r117 = r118;
    L28:
        r111.setBluetoothEnabled(Boolean.valueOf(((Boolean) r117).booleanValue()));
        o.f475473a.getClass();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r119 = r107.getSystemService("location");     // Catch: Throwable -> L47
        if ((r119 instanceof LocationManager) == false) goto L32;
        LocationManager r120 = (LocationManager) r119;     // Catch: Throwable -> L47
    L33:
        if (r120 != null) goto L36;
    L43:
        boolean r121 = false;
    L45:
        Object r122 = Result.m9449constructorimpl(Boolean.valueOf(r121));     // Catch: Throwable -> L47
    L49:
        Boolean r123 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r122) == false) goto L52;
        r122 = r123;
    L52:
        r111.setLocationEnabled(Boolean.valueOf(((Boolean) r122).booleanValue()));
        o.f475473a.getClass();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r124 = r107.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L61
        if ((r124 instanceof WifiManager) == false) goto L56;
        r105 = (WifiManager) r124;     // Catch: Throwable -> L61
    L56:
        if (r105 == null) goto L59;
        r112 = r105.isWifiEnabled();     // Catch: Throwable -> L61
    L59:
        Object r125 = Result.m9449constructorimpl(Boolean.valueOf(r112));     // Catch: Throwable -> L61
    L63:
        Boolean r126 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r125) == false) goto L66;
        r125 = r126;
    L66:
        r111.setWifiEnabled(Boolean.valueOf(((Boolean) r125).booleanValue()));
        o.f475473a.getClass();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r127 = r107.getResources().getConfiguration().orientation;
        if (r127 != 1) goto L69;
    L73:
        String r128 = "portrait";
    L74:
        r111.setDeviceOrientation(r128);
        return new com.bytedance.ai.bridge.core.a.c(r110);
    L69:
        if (r127 == 2) goto L72;
        Resources r129 = r107.getResources();
        DisplayMetrics r130 = WindowDisplayMetricsOverride.apply(r129, r129.getDisplayMetrics());
        if (r130.widthPixels <= r130.heightPixels) goto L73;
    L72:
        r128 = "landscape";
    L61:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    L36:
        if (Build.VERSION.SDK_INT < 28) goto L39;
        r121 = r120.isLocationEnabled();     // Catch: Throwable -> L47
        goto L45
    L39:
        if (r120.isProviderEnabled(GeocodeSearch.GPS) == false) goto L41;
    L44:
        r121 = true;
        goto L45
    L41:
        if (r120.isProviderEnabled("network") == false) goto L43;
    L32:
        r120 = null;
    L47:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L20:
        r116 = false;
        goto L21
    L16:
        r115 = null;
        goto L18
    L17:
        r115 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(e3.d r100, ParamModel r101) {
        return b(r100, (AbsGetSystemSettingMethodIDL.a) r101);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsGetSystemSettingMethodIDL.a r103 = (AbsGetSystemSettingMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r100, r103), r102);
    }
}
