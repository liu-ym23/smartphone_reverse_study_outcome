package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\t\u0010\nJ0\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000bH§@¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0015H§@¢\u0006\u0004\b\u0017\u0010\u0018J*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0019H§@¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u001cH§@¢\u0006\u0004\b\u001e\u0010\u001fJ0\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020 H§@¢\u0006\u0004\b\"\u0010#J*\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010$\u001a\u00020\u0002H§@¢\u0006\u0004\b&\u0010'Jb\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b.\u0010/¨\u00060À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/a;", "", "", "authorization", "Lcom/stepos/ailauncher/agent/aispace/connect/data/o;", "body", "Lyc/v;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/l;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/connect/data/o;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/m;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/connect/data/m;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/r;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/s;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/connect/data/r;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/C;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/z;", "LY8/t;", "e", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/connect/data/z;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/n;", "f", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/connect/data/n;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/x;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/y;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/connect/data/x;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/t;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/u;", "c", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/connect/data/t;Le9/c;)Ljava/lang/Object;", "deviceId", "Lcom/stepos/ailauncher/agent/aispace/connect/data/j;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "agent", "", "limit", "cursor", "keyword", "Lcom/stepos/ailauncher/agent/aispace/connect/data/B;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC2198a {
    @Ac.o("QueryDeviceAgentOnline")
    Object a(@Ac.i("Authorization") String str, @Ac.a QueryDeviceAgentOnlineRequest queryDeviceAgentOnlineRequest, InterfaceC4014c<? super ApiEnvelope<QueryDeviceAgentOnlineResponseData>> interfaceC4014c);

    @Ac.o("GetDeviceAgentList")
    Object b(@Ac.i("Authorization") String str, @Ac.a r rVar, InterfaceC4014c<? super yc.v<ApiEnvelope<GetDeviceAgentListResponseData>>> interfaceC4014c);

    @Ac.o("GetFileSync")
    Object c(@Ac.i("Authorization") String str, @Ac.a GetFileSyncRequest getFileSyncRequest, InterfaceC4014c<? super yc.v<ApiEnvelope<GetFileSyncResponseData>>> interfaceC4014c);

    @Ac.f("GetAgentEntranceConfig")
    Object d(@Ac.i("Authorization") String str, @Ac.t(Parameters.DEVICE_ID) String str2, InterfaceC4014c<? super ApiEnvelope<AgentEntranceResponseData>> interfaceC4014c);

    @Ac.o("RenameDeviceAgent")
    Object e(@Ac.i("Authorization") String str, @Ac.a RenameAgentRequest renameAgentRequest, InterfaceC4014c<? super ApiEnvelope<Y8.t>> interfaceC4014c);

    @Ac.o("ChangeDeviceAgentStatus")
    Object f(@Ac.i("Authorization") String str, @Ac.a ChangeAgentStatusRequest changeAgentStatusRequest, InterfaceC4014c<? super ApiEnvelope<Y8.t>> interfaceC4014c);

    @Ac.o("BindStepaiDevice")
    Object g(@Ac.i("Authorization") String str, @Ac.a BindStepaiDeviceRequest bindStepaiDeviceRequest, InterfaceC4014c<? super yc.v<ApiEnvelope<DeviceInfoDto>>> interfaceC4014c);

    @Ac.f("GetSidebarAgentList")
    Object h(@Ac.i("Authorization") String str, InterfaceC4014c<? super yc.v<ApiEnvelope<SidebarAgentListData>>> interfaceC4014c);

    @Ac.o("DevicePhoneConfirm")
    Object i(@Ac.i("Authorization") String str, @Ac.a ConfirmDeviceRequest confirmDeviceRequest, InterfaceC4014c<? super yc.v<ApiEnvelope<DeviceInfoDto>>> interfaceC4014c);

    @Ac.f("SessionList")
    Object j(@Ac.i("Authorization") String str, @Ac.t(Parameters.DEVICE_ID) String str2, @Ac.t("agent") String str3, @Ac.t("limit") Integer num, @Ac.t("cursor") String str4, @Ac.t("keyword") String str5, InterfaceC4014c<? super yc.v<ApiEnvelope<SessionListResponseData>>> interfaceC4014c);
}
