package com.bytedance.ai.bridge.method.device.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.wifi.AbsConnectWifiMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.b;
import f3.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import v3.f;
import v3.i;
import v3.j;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/ConnectWifiMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsConnectWifiMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/wifi/AbsConnectWifiMethodIDL$ConnectWifiParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/wifi/AbsConnectWifiMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectWifiMethod extends AbsConnectWifiMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35470b = 0;

    public static final class a {
    }

    static {
    }

    public ConnectWifiMethod() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Runnable, v3.g] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Object, v3.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, v3.i] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r110, ParamModel r210, final h r211) {
        AbsConnectWifiMethodIDL.a r100 = (AbsConnectWifiMethodIDL.a) r210;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        g r101 = g.f37637a;
        StringBuilder r102 = new StringBuilder("call start, hasSsid=");
        boolean r103 = false;
        if (r100.getSsid().length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        r102.append(", hasBssid=");
        String r105 = r100.getBssid();
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        r102.append(!r106);
        r102.append(", manual=");
        Boolean r107 = r100.getManual();
        Boolean r108 = Boolean.TRUE;
        r102.append(Intrinsics.areEqual(r107, r108));
        r102.append(", appletId=");
        a0 r109 = r110.getContainerContext();
        Object r111 = null;
        if (r109 == null) goto L16;
        String r112 = r109.getAppletId();
    L17:
        r102.append(r112);
        r101.i("AISDK_JSB_ConnectWifiMethod", r102.toString());
        final v3.h r113 = j.a(r110);
        String r114 = r100.getSsid();
        String r115 = r100.getPassword();
        String r116 = r100.getBssid();
        boolean r117 = Intrinsics.areEqual(r100.getManual(), r108);
        final ?? r118 = new v3.a(r211);
        Intrinsics.checkNotNullParameter(r114, "ssid");
        Intrinsics.checkNotNullParameter(r115, "password");
        Intrinsics.checkNotNullParameter(r118, "completion");
        if (r117 == false) goto L32;
        Context r119 = r113.j();
        if (r119 != null) goto L175;
        Object r120 = new WifiError(f3.a.f475265f, "context is null");
    L31:
        r118.invoke(r120);
        return;
    L175:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L24
        Intent r122 = new Intent("android.settings.WIFI_SETTINGS");     // Catch: Throwable -> L24
        r122.addFlags(268435456);     // Catch: Throwable -> L24
        r119.startActivity(r122);     // Catch: Throwable -> L24
        Object r123 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 != null) goto L29;
        Unit r125 = (Unit) r123;
    L30:
        r120 = r111;
        goto L31
    L29:
        r111 = new WifiError(f3.a.f475265f, "open wifi settings failed: " + r124.getMessage());
    L24:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L32:
        WifiError r127 = r113.h();
        if (r127 == null) goto L35;
        r118.invoke(r127);
        return;
    L35:
        final Context r128 = r113.j();
        if (r128 != null) goto L39;
        r118.invoke(new WifiError(f3.a.f475265f, "context is null"));
        return;
    L39:
        if (StringsKt.isBlank(r114) == false) goto L42;
        r118.invoke(new WifiError(f3.a.f475267h, "ssid is empty"));
        return;
    L42:
        if (Build.VERSION.SDK_INT < 29) goto L103;
        Object r129 = r128.getSystemService("connectivity");
        if ((r129 instanceof ConnectivityManager) == false) goto L46;
        ConnectivityManager r130 = (ConnectivityManager) r129;
    L47:
        if (r130 != null) goto L173;
        r118.invoke(new WifiError(f3.a.f475266g, "connectivity manager is not available"));
        return;
    L173:
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L63
        WifiNetworkSpecifier.Builder r132 = new WifiNetworkSpecifier.Builder().setSsid(r114);     // Catch: Throwable -> L63
        if (r115.length() <= 0) goto L52;
        r103 = true;
    L52:
        if (r103 == false) goto L54;
        r132.setWpa2Passphrase(r115);     // Catch: Throwable -> L63
    L54:
        if (r116 != null) goto L56;
    L61:
        Object r133 = Result.m9449constructorimpl(new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier(r132.build()).build());     // Catch: Throwable -> L63
    L65:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 != null) goto L102;
        NetworkRequest r135 = (NetworkRequest) r133;
        final Ref.BooleanRef r136 = new Ref.BooleanRef();
        final Ref.ObjectRef r137 = new Ref.ObjectRef();
        ?? r138 = new v3.g(r113, r118, r137, r136);
        r137.element = new i(r113, r138, r128, r118, r136, r130);
        Object r139 = r113.f552798b;
        monitor-enter(r139);
        r113.b();     // Catch: Throwable -> L99
        r113.f552802f = r130;     // Catch: Throwable -> L99
        T r140 = r137.element;     // Catch: Throwable -> L99
        if (r140 != 0) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("callback");     // Catch: Throwable -> L99
        ConnectivityManager.NetworkCallback r141 = null;
    L73:
        r113.f552803g = r141;     // Catch: Throwable -> L99
        Unit r142 = Unit.INSTANCE;     // Catch: Throwable -> L99
        monitor-exit(r139);
        T r143 = r137.element;     // Catch: Throwable -> L81
        if (r143 != 0) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("callback");     // Catch: Throwable -> L81
        ConnectivityManager.NetworkCallback r144 = null;
    L79:
        r130.requestNetwork(r135, r144);     // Catch: Throwable -> L81
        Object r145 = Result.m9449constructorimpl(Boolean.valueOf(r113.f552799c.postDelayed(r138, 30000)));     // Catch: Throwable -> L81
    L83:
        Throwable r146 = Result.m9452exceptionOrNullimpl(r145);
        if (r146 == null) goto L193;
        Object r147 = r113.f552798b;
        monitor-enter(r147);
        ConnectivityManager.NetworkCallback r148 = r113.f552803g;     // Catch: Throwable -> L96
        Object r149 = r137.element;     // Catch: Throwable -> L96
        if (r149 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("callback");     // Catch: Throwable -> L96
    L91:
        if (r148 != r111) goto L93;
        r113.b();     // Catch: Throwable -> L96
    L93:
        Unit r150 = Unit.INSTANCE;     // Catch: Throwable -> L96
        monitor-exit(r147);
        f3.a.C5852a r151 = f3.a.f475262c;
        f3.a r152 = b.f475287a;
        Intrinsics.checkNotNullParameter(r151, "<this>");
        r118.invoke(new WifiError(b.f475293g, "connect wifi failed: " + r146.getMessage()));
        return;
    L90:
        r111 = (ConnectivityManager.NetworkCallback) r149;     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        throw th;
    L193:
        return;
    L78:
        r144 = (ConnectivityManager.NetworkCallback) r143;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L83
    L72:
        r141 = (ConnectivityManager.NetworkCallback) r140;     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        throw th;
    L102:
        f3.a.C5852a r154 = f3.a.f475262c;
        f3.a r155 = b.f475287a;
        Intrinsics.checkNotNullParameter(r154, "<this>");
        r118.invoke(new WifiError(b.f475293g, "build wifi request failed: " + r134.getMessage()));
        return;
    L56:
        if ((!StringsKt.isBlank(r116)) == true) goto L59;
        r116 = null;
    L59:
        if (r116 == null) goto L61;
        r132.setBssid(MacAddress.fromString(r116));     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L65
    L46:
        r130 = null;
        goto L47
    L103:
        v3.d.f552786a.getClass();
        WifiManager r157 = v3.d.g(r128);
        if (r157 != null) goto L172;
        WifiError r158 = new WifiError(f3.a.f475266g, "wifi is not available");
    L170:
        r118.invoke(r158);
        return;
    L172:
        Result.Companion r159 = Result.Companion;     // Catch: Throwable -> L163
        if (r157.isWifiEnabled() == true) goto L109;
        r157.setWifiEnabled(true);     // Catch: Throwable -> L163
    L109:
        String r160 = "\"" + r114 + Typography.quote;     // Catch: Throwable -> L163
        List r161 = v3.h.g(r157);     // Catch: Throwable -> L163
        if (r161 == null) goto L131;
        Iterator r162 = r161.iterator();     // Catch: Throwable -> L163
    L113:
        if (r162.hasNext() == false) goto L129;
        Object r163 = r162.next();     // Catch: Throwable -> L163
        WifiConfiguration r164 = (WifiConfiguration) r163;     // Catch: Throwable -> L163
        if (Intrinsics.areEqual(v3.h.e(r164), r160) == false) goto L126;
        if (r116 != null) goto L118;
    L121:
        boolean r165 = true;
    L122:
        if (r165 == false) goto L124;
    L125:
        boolean r166 = true;
    L127:
        if (r166 == false) goto L113;
    L130:
        WifiConfiguration r167 = (WifiConfiguration) r163;     // Catch: Throwable -> L163
    L132:
        if (r167 == null) goto L134;
        int r168 = r167.networkId;     // Catch: Throwable -> L163
    L153:
        if (r168 != (-1)) goto L155;
        f3.a.C5852a r169 = f3.a.f475262c;     // Catch: Throwable -> L163
        f3.a r170 = b.f475287a;     // Catch: Throwable -> L163
        Intrinsics.checkNotNullParameter(r169, "<this>");     // Catch: Throwable -> L163
        r158 = new WifiError(b.f475293g, "add wifi network failed");     // Catch: Throwable -> L163
        goto L170
    L155:
        boolean r171 = r157.enableNetwork(r168, true);     // Catch: Throwable -> L163
        boolean r172 = r157.reconnect();     // Catch: Throwable -> L163
        if (r171 == false) goto L160;
        if (r172 == false) goto L160;
        r113.f552799c.postDelayed(new f(r128), 1500);     // Catch: Throwable -> L163
    L161:
        Object r173 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L163
    L165:
        Throwable r174 = Result.m9452exceptionOrNullimpl(r173);
        if (r174 == null) goto L169;
        f3.a.C5852a r175 = f3.a.f475262c;
        f3.a r176 = b.f475287a;
        Intrinsics.checkNotNullParameter(r175, "<this>");
        r173 = new WifiError(b.f475293g, "connect wifi failed: " + r174.getMessage());
    L169:
        r158 = (WifiError) r173;
    L160:
        f3.a.C5852a r177 = f3.a.f475262c;     // Catch: Throwable -> L163
        f3.a r178 = b.f475287a;     // Catch: Throwable -> L163
        Intrinsics.checkNotNullParameter(r177, "<this>");     // Catch: Throwable -> L163
        r111 = new WifiError(b.f475293g, "connect wifi failed");     // Catch: Throwable -> L163
        goto L161
    L134:
        WifiConfiguration r179 = new WifiConfiguration();     // Catch: Throwable -> L163
        v3.h.f(r179, r160);     // Catch: Throwable -> L163
        if (r116 != null) goto L137;
    L143:
        r116 = null;
    L144:
        v3.h.d(r179, r116);     // Catch: Throwable -> L163
        if (r115.length() != 0) goto L147;
        boolean r180 = true;
    L148:
        if (r180 == false) goto L150;
        r179.allowedKeyManagement.set(0);     // Catch: Throwable -> L163
    L151:
        r168 = r157.addNetwork(r179);     // Catch: Throwable -> L163
        goto L153
    L150:
        r179.preSharedKey = Typography.quote + r115 + Typography.quote;     // Catch: Throwable -> L163
        r179.allowedKeyManagement.set(1);     // Catch: Throwable -> L163
        goto L151
    L147:
        r180 = false;
        goto L148
    L137:
        if (StringsKt.isBlank(r116) == true) goto L139;
        boolean r181 = true;
    L141:
        if (Boolean.valueOf(r181).booleanValue() == false) goto L143;
    L139:
        r181 = false;
        goto L141
    L124:
        if (Intrinsics.areEqual(v3.h.c(r164), r116) == false) goto L126;
    L118:
        if (StringsKt.isBlank(r116) == true) goto L121;
        r165 = false;
    L126:
        r166 = false;
        goto L127
    L129:
        r163 = null;
        goto L130
    L131:
        r167 = null;
    L163:
        th = move-exception;
        Result.Companion r182 = Result.Companion;
        r173 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L165
    L16:
        r112 = null;
        goto L17
    L9:
        if (r105.length() == 0) goto L12;
        r106 = false;
        goto L13
    L5:
        r104 = false;
        goto L6
    }
}
