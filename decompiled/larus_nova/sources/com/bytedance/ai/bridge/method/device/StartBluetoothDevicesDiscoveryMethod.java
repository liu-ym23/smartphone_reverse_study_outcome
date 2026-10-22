package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.bluetooth.AbsStartBluetoothDevicesDiscoveryMethodIDL;
import com.lynx.canvas.KryptonCamera;
import e3.d;
import f3.h;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import l4.c;
import t3.e0;
import t3.f0;
import t3.g2;
import t3.h2;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/StartBluetoothDevicesDiscoveryMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL$StartBluetoothDevicesDiscoveryParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartBluetoothDevicesDiscoveryMethod extends AbsStartBluetoothDevicesDiscoveryMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f35437b = null;

    public static final class a {
    }

    static {
        f35437b = SetsKt.setOf(new String[]{"low", KryptonCamera.Config.RESOLUTION_MEDIUM, "high"});
    }

    public StartBluetoothDevicesDiscoveryMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final d r100, ParamModel r101, final h r102) {
        final AbsStartBluetoothDevicesDiscoveryMethodIDL.b r103 = (AbsStartBluetoothDevicesDiscoveryMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getPowerLevel();
        if (r104 == null) goto L5;
        final String r105 = r104.toLowerCase(Locale.ROOT);
    L6:
        if (r105 != null) goto L8;
    L10:
        String r106 = this.f35274a;
        e0.f544279a.getClass();
        c.b(r100, r106, e0.j(), new g2(r102), new h2(r100, r103, r105, r102));
        return;
    L8:
        if (f35437b.contains(r105) == true) goto L10;
        f0.a(r102, "startBluetoothDevicesDiscovery failed: invalid powerLevel: " + r103.getPowerLevel());
        return;
    L5:
        r105 = null;
        goto L6
    }
}
