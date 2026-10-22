package com.stepos.ailauncher.agent.aispace;

import La.H;
import O6.ExternalDeviceInfo;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.sla.G;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/w;", "LO6/i;", "<init>", "()V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "newList", "LY8/t;", "c", "(Ljava/util/List;)V", Parameters.DEVICE, Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)V", "", "deviceId", "agent", "", G.NETWORK_ONLINE, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Z)V", "LO6/e;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "e", "TAG", "Ljava/lang/String;", "devices", "Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w implements O6.i {
    private static final String TAG = "ExternalAgentContextHolder";
    public static final w INSTANCE = new w();
    private static volatile List<IExternalAgentBindService.ConnectedDevice> devices = C1173v.m();

    @Override // O6.i
    public List<ExternalDeviceInfo> a() {
        List<IExternalAgentBindService.ConnectedDevice> list = devices;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (IExternalAgentBindService.ConnectedDevice connectedDevice : list) {
            arrayList.add(new ExternalDeviceInfo(connectedDevice.getDeviceId(), connectedDevice.getDeviceName(), connectedDevice.getAgentType(), connectedDevice.getOnline()));
        }
        return arrayList;
    }

    public final void b(String deviceId, String agent, boolean online) {
        boolean z10;
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        List<IExternalAgentBindService.ConnectedDevice> list = devices;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (IExternalAgentBindService.ConnectedDevice connectedDeviceCopy$default : list) {
            if (La.D.L(H.D1(connectedDeviceCopy$default.getDeviceId()).toString(), H.D1(deviceId).toString(), true) && La.D.L(H.D1(connectedDeviceCopy$default.getAgentType()).toString(), H.D1(agent).toString(), true)) {
                z10 = online;
                connectedDeviceCopy$default = IExternalAgentBindService.ConnectedDevice.copy$default(connectedDeviceCopy$default, null, null, null, z10, 7, null);
            } else {
                z10 = online;
            }
            arrayList.add(connectedDeviceCopy$default);
            online = z10;
        }
        devices = arrayList;
    }

    public final void c(List<IExternalAgentBindService.ConnectedDevice> newList) {
        kotlin.jvm.internal.p.i(newList, "newList");
        devices = newList;
    }

    public final void d(IExternalAgentBindService.ConnectedDevice device) {
        kotlin.jvm.internal.p.i(device, "device");
        List<IExternalAgentBindService.ConnectedDevice> list = devices;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            IExternalAgentBindService.ConnectedDevice connectedDevice = (IExternalAgentBindService.ConnectedDevice) obj;
            if (!kotlin.jvm.internal.p.d(connectedDevice.getDeviceId(), device.getDeviceId()) || !kotlin.jvm.internal.p.d(connectedDevice.getAgentType(), device.getAgentType())) {
                arrayList.add(obj);
            }
        }
        devices = Z8.F.T0(arrayList, device);
    }

    public final void e(String deviceId, String agent, boolean online) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        List<IExternalAgentBindService.ConnectedDevice> list = devices;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (IExternalAgentBindService.ConnectedDevice connectedDevice : list) {
                if (La.D.L(H.D1(connectedDevice.getDeviceId()).toString(), H.D1(deviceId).toString(), true) && La.D.L(H.D1(connectedDevice.getAgentType()).toString(), H.D1(agent).toString(), true)) {
                    b(deviceId, agent, online);
                    return;
                }
            }
        }
        devices = Z8.F.T0(devices, new IExternalAgentBindService.ConnectedDevice(deviceId, "", agent, online));
    }
}
