package com.stepos.ailauncher.agent.aispace.connect;

import Z8.C1173v;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository;
import com.stepos.ailauncher.agent.aispace.connect.data.DeviceAgentItem;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity$fetchAndPrintDeviceList$1", f = "ScanQrActivity.kt", l = {751}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ScanQrActivity$fetchAndPrintDeviceList$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ ScanQrActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanQrActivity$fetchAndPrintDeviceList$1(ScanQrActivity scanQrActivity, InterfaceC4014c<? super ScanQrActivity$fetchAndPrintDeviceList$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = scanQrActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ScanQrActivity$fetchAndPrintDeviceList$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ScanQrActivity$fetchAndPrintDeviceList$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
            this.label = 1;
            objD = agentDeviceRepository.D(this);
            if (objD == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objD = ((Result) obj).getValue();
        }
        AgentDeviceRepository agentDeviceRepository2 = AgentDeviceRepository.INSTANCE;
        String strB = agentDeviceRepository2.B();
        if (La.H.x0(strB)) {
            strB = null;
        }
        if (strB != null) {
            this.this$0.Z("listDevices OUTGOING HEADERS:\n" + La.H.F1(strB).toString());
        }
        ScanQrActivity scanQrActivity = this.this$0;
        Throwable thE = Result.e(objD);
        if (thE == null) {
            List list = (List) objD;
            String strA = agentDeviceRepository2.A();
            if (strA != null) {
                scanQrActivity.Z("⚠ listDevices server FAILED (fallback to local sticky)\n" + strA);
            }
            if (list.isEmpty()) {
                scanQrActivity.Z("listDevices 返回 0 条设备（server + sticky 都空）");
            } else {
                StringBuilder sb2 = new StringBuilder(strA == null ? "✓ listDevices OK：共 " + list.size() + " 条设备\n" : "★ 本地 sticky 快照：共 " + list.size() + " 条设备（server 挂了用兜底）\n");
                int i11 = 0;
                for (Object obj2 : list) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        C1173v.w();
                    }
                    DeviceAgentItem deviceAgentItem = (DeviceAgentItem) obj2;
                    sb2.append("[" + i11 + "] device_id=" + deviceAgentItem.getDeviceId() + " agent=" + deviceAgentItem.getAgent() + " display_name=" + deviceAgentItem.getDisplayName() + "\n");
                    i11 = i12;
                }
                String string = sb2.toString();
                kotlin.jvm.internal.p.h(string, "toString(...)");
                scanQrActivity.Z(La.H.F1(string).toString());
            }
        } else {
            String simpleName = thE.getClass().getSimpleName();
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            scanQrActivity.Z("✗ listDevices unexpected failure: " + simpleName + " " + message);
        }
        return Y8.t.f7040a;
    }
}
