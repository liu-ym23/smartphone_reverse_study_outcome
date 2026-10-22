package com.stepos.ailauncher.oobe.api;

import Ac.a;
import Ac.o;
import com.stepos.ailauncher.network.ApiResponse;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\bH§@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/BotMsgApi;", "", "Lcom/stepos/ailauncher/oobe/api/SaveAgentPersonParams;", "body", "Lcom/stepos/ailauncher/network/ApiResponse;", "Lcom/stepos/ailauncher/oobe/api/AgentPerson;", "saveAgentPerson", "(Lcom/stepos/ailauncher/oobe/api/SaveAgentPersonParams;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/oobe/api/RestoreWorkspaceMdParams;", "Lcom/stepos/ailauncher/oobe/api/RestoreWorkspaceMdResponse;", "restoreWorkspaceMd", "(Lcom/stepos/ailauncher/oobe/api/RestoreWorkspaceMdParams;Le9/c;)Ljava/lang/Object;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BotMsgApi {
    @o("step.agi.botmsg.BotMsg/RestoreWorkspaceMd")
    Object restoreWorkspaceMd(@a RestoreWorkspaceMdParams restoreWorkspaceMdParams, InterfaceC4014c<? super RestoreWorkspaceMdResponse> interfaceC4014c);

    @o("step.agi.botmsg.BotMsg/SaveAgentPersona")
    Object saveAgentPerson(@a SaveAgentPersonParams saveAgentPersonParams, InterfaceC4014c<? super ApiResponse<AgentPerson>> interfaceC4014c);
}
